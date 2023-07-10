package org.zaproxy.addon.maplocal;

import org.parosproxy.paros.core.proxy.ProxyListener;
import org.parosproxy.paros.extension.history.ProxyListenerLog;
import org.parosproxy.paros.model.Model;
import org.parosproxy.paros.network.HttpMessage;

public class ProxyListenerMapLocal implements ProxyListener {

    // Should be before the breaks listener
    public static final int PROXY_LISTENER_ORDER = ProxyListenerLog.PROXY_LISTENER_ORDER - 2;

    private Model model;
    private ExtensionMapLocal extension;

    public ProxyListenerMapLocal(Model model, ExtensionMapLocal extension) {
        this.model = model;
        this.extension = extension;
    }

    @Override
    public boolean onHttpRequestSend(HttpMessage msg) {
        return true;
    }

    @Override
    public boolean onHttpResponseReceive(HttpMessage msg) {
        return extension.messageReceivedFromServer(msg);
    }

    @Override
    public int getArrangeableListenerOrder() {
        return PROXY_LISTENER_ORDER;
    }
}
