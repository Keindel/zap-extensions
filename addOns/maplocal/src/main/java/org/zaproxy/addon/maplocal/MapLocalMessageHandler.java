package org.zaproxy.addon.maplocal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.parosproxy.paros.network.HttpMessage;
import org.zaproxy.addon.maplocal.view.MapLocalTableEntry;
import org.zaproxy.zap.extension.httppanel.Message;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.List;

public class MapLocalMessageHandler {

    private static final Logger LOGGER = LogManager.getLogger(MapLocalMessageHandler.class);
    protected static final Object SEMAPHORE = new Object();

    protected List<MapLocalTableEntry> enabledMapLocals;

    public void setEnabledMapLocals(List<MapLocalTableEntry> enabledMapLocals) {
        this.enabledMapLocals = enabledMapLocals;
    }

    protected MapLocalTableEntry findEnabledMapLocal(
            Message aMessage, boolean isRequest, boolean onlyIfInScope) {
        if (enabledMapLocals.isEmpty()) return null;

        synchronized (enabledMapLocals) {
            Iterator<MapLocalTableEntry> it = enabledMapLocals.iterator();

            while (it.hasNext()) {
                MapLocalTableEntry mapLocal = it.next();

                if (mapLocal.match(aMessage, isRequest, onlyIfInScope)) {
                    return mapLocal;
                }
            }
        }
        return null;
    }

    public boolean handleMessageReceivedFromServer(HttpMessage msg, boolean onlyIfInScope) {
        MapLocalTableEntry mapLocal = findEnabledMapLocal(msg, false, onlyIfInScope);
        if (mapLocal != null) {
            try {
                synchronized (SEMAPHORE) {
                    msg.setResponseBody(Files.readAllBytes(mapLocal.getLocalPath()));
                    msg.getResponseHeader().setContentLength(msg.getResponseBody().length());
                }
            } catch (IOException e) {
                LOGGER.error(e.getMessage(), e);
            }
        }
        return true;
    }
}
