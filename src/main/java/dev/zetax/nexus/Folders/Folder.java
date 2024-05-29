package dev.zetax.nexus.Folders;

import java.net.URL;

public class Folder {

    public String name;
    public String description;
    public URL downloadURL;

    public Folder(String name, String description, URL downloadURL) {
        this.name = name;
        this.description = description;
        this.downloadURL = downloadURL;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public URL getDownloadURL() {
        return this.downloadURL;
    }

}
