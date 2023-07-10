package org.zaproxy.addon.maplocal.view.popup;

import org.parosproxy.paros.Constant;
import org.parosproxy.paros.extension.ExtensionPopupMenuItem;
import org.zaproxy.addon.maplocal.ExtensionMapLocal;
import org.zaproxy.addon.maplocal.view.MapLocalStatusPanel;

import java.awt.Component;

@SuppressWarnings("serial")
public class PopupMenuEditMapLocal extends ExtensionPopupMenuItem {
    private static final long serialVersionUID = 1L;

    private ExtensionMapLocal extension;

    public PopupMenuEditMapLocal() {
        super(Constant.messages.getString("mapLocal.edit.popup"));
        this.addActionListener(
                new java.awt.event.ActionListener() {

                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        extension.editUiSelectedMapLocal();
                    }
                });
    }

    public void setExtension(ExtensionMapLocal extension) {
        this.extension = extension;
    }

    @Override
    public boolean isEnableForComponent(Component invoker) {
        return invoker.getName() != null && invoker.getName().equals(MapLocalStatusPanel.PANEL_NAME);
    }
}
