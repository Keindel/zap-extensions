package org.zaproxy.addon.maplocal.view;

import org.zaproxy.zap.extension.httppanel.Message;

public interface MapLocalUiManagerInterface {

    Class<? extends Message> getMessageClass();

    Class<? extends MapLocalTableEntry> getMapLocalClass();

    String getType();

    void handleAddMapLocal(Message aMessage);

    void handleEditMapLocal(MapLocalTableEntry mapLocal);

    void handleRemoveMapLocal(MapLocalTableEntry mapLocal);

    void reset();
}
