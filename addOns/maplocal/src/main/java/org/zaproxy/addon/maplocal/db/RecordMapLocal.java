package org.zaproxy.addon.maplocal.db;

public class RecordMapLocal {

    private int mapLocalId;

    private String urlString;
    private String match;
    private boolean ignoreCase;
    private String localPath;

    public RecordMapLocal(int mapLocalId, String urlString, String match, boolean ignoreCase, String localPath) {
        this.mapLocalId = mapLocalId;
        this.urlString = urlString;
        this.match = match;
        this.ignoreCase = ignoreCase;
        this.localPath = localPath;
    }

    public int getMapLocalId() {
        return mapLocalId;
    }

    public void setMapLocalId(int mapLocalId) {
        this.mapLocalId = mapLocalId;
    }

    public String getUrlString() {
        return urlString;
    }

    public void setUrlString(String urlString) {
        this.urlString = urlString;
    }

    public String getMatch() {
        return match;
    }

    public void setMatch(String match) {
        this.match = match;
    }

    public boolean isIgnoreCase() {
        return ignoreCase;
    }

    public void setIgnoreCase(boolean ignoreCase) {
        this.ignoreCase = ignoreCase;
    }

    public String getLocalPath() {
        return localPath;
    }

    public void setLocalPath(String localPath) {
        this.localPath = localPath;
    }
}
