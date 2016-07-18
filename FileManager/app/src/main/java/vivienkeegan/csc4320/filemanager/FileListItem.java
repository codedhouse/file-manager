package vivienkeegan.csc4320.filemanager;

public class FileListItem {
    protected String name;
    protected boolean isFolder;

    public FileListItem(String name, boolean isFolder) {
        this.name = name;
        this.isFolder = isFolder;
    }
}
