package org.zaproxy.addon.maplocal.view.popup;

import org.parosproxy.paros.Constant;
import org.parosproxy.paros.extension.ExtensionPopupMenuItem;
import org.zaproxy.addon.maplocal.ExtensionMapLocal;
import org.zaproxy.addon.maplocal.view.MapLocalStatusPanel;

import java.awt.Component;

@SuppressWarnings("serial")
public class PopupMenuRemoveMapLocal extends ExtensionPopupMenuItem {

    private static final long serialVersionUID = 1L;
    private ExtensionMapLocal extension = null;

    public PopupMenuRemoveMapLocal() {
        super(Constant.messages.getString("mapLocal.remove.popup"));

        this.addActionListener(
                new java.awt.event.ActionListener() {

                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        extension.removeUiSelectedMapLocal();
                    }
                });
    }

    @Override
    public boolean isEnableForComponent(Component invoker) {
        if (invoker.getName() != null && invoker.getName().equals(MapLocalStatusPanel.PANEL_NAME)) {
            this.setEnabled(true);
            return true;
        }
        return false;
    }

    public void setExtension(ExtensionMapLocal extension) {
        this.extension = extension;
    }
}
