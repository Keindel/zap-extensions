package org.zaproxy.addon.maplocal.view.popup;

import org.parosproxy.paros.Constant;
import org.parosproxy.paros.db.DatabaseException;
import org.parosproxy.paros.model.SiteNode;
import org.zaproxy.addon.maplocal.view.MapLocalUiManagerImpl;
import org.zaproxy.zap.model.StructuralSiteNode;
import org.zaproxy.zap.view.messagecontainer.http.HttpMessageContainer;
import org.zaproxy.zap.view.popup.PopupMenuItemHttpMessageContainer;
import org.zaproxy.zap.view.popup.PopupMenuItemSiteNodeContainer;

@SuppressWarnings("serial")
public class PopupMenuAddMapLocalSites extends PopupMenuItemSiteNodeContainer {
    private static final long serialVersionUID = -1L;

    private MapLocalUiManagerImpl uiManager;

    public PopupMenuAddMapLocalSites(MapLocalUiManagerImpl uiManager) {
        super(Constant.messages.getString("mapLocal.add.popup"));

        this.uiManager = uiManager;
    }

    @Override
    public boolean isEnableForInvoker(PopupMenuItemHttpMessageContainer.Invoker invoker, HttpMessageContainer httpMessageContainer) {
        return (invoker == PopupMenuItemHttpMessageContainer.Invoker.SITES_PANEL);
    }

    @Override
    public void performAction(SiteNode sn) {
        try {
            uiManager.handleAddMapLocal(new StructuralSiteNode(sn).getRegexPattern(false));
        } catch (DatabaseException e) {
            // Ignore
        }
    }
}
