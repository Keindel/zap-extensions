package org.zaproxy.addon.maplocal.view.popup;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.parosproxy.paros.Constant;
import org.parosproxy.paros.db.DatabaseException;
import org.parosproxy.paros.model.HistoryReference;
import org.parosproxy.paros.network.HttpMalformedHeaderException;
import org.zaproxy.addon.maplocal.ExtensionMapLocal;
import org.zaproxy.zap.view.messagecontainer.http.HttpMessageContainer;
import org.zaproxy.zap.view.popup.PopupMenuItemHistoryReferenceContainer;
import org.zaproxy.zap.view.popup.PopupMenuItemHttpMessageContainer;

@SuppressWarnings("serial")
public class PopupMenuAddMapLocalHistory extends PopupMenuItemHistoryReferenceContainer {
    private static final long serialVersionUID = 1L;

    private static final Logger LOGGER = LogManager.getLogger(PopupMenuAddMapLocalHistory.class);

    private final ExtensionMapLocal extensionMapLocal;

    public PopupMenuAddMapLocalHistory(ExtensionMapLocal extension) {
        super(Constant.messages.getString("mapLocal.add.popup"));

        this.extensionMapLocal = extension;
    }

    @Override
    public boolean isEnableForInvoker(PopupMenuItemHttpMessageContainer.Invoker invoker, HttpMessageContainer httpMessageContainer) {
        return (invoker == PopupMenuItemHttpMessageContainer.Invoker.HISTORY_PANEL);
    }

    @Override
    public void performAction(HistoryReference href) {
        try {
            extensionMapLocal.addUiMapLocal(href.getHttpMessage());
        } catch (HttpMalformedHeaderException | DatabaseException e) {
            LOGGER.error(e.getMessage(), e);
            extensionMapLocal
                    .getView()
                    .showWarningDialog(Constant.messages.getString("mapLocal.add.error.history"));
        }
    }
}
