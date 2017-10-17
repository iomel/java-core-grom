package lesson19.home;

public class Storage {
    private long id;
    private File[] files;
    private String[] formatsSupported;
    private String storageCountry;
    private long storageSize;

    public Storage(long id, File[] files, String[] formatsSupported, String storageCountry, long storageSize) {
        this.id = id;
        this.files = files;
        this.formatsSupported = formatsSupported;
        this.storageCountry = storageCountry;
        this.storageSize = storageSize;
    }

    public long getId() {
        return id;
    }

    public File[] getFiles() {
        return files;
    }

    public void setFiles(File[] files) {
        this.files = files;
    }


    public void printStorage()
    {
        System.out.println("Storage (id:" + id + ") contains: ");
        if(files == null) {
            System.out.println(" Nothing - is empty!");
            return;
        }
        for (File f : files)
            System.out.println(f.toString());
    }


    public String[] getFormatsSupported() {
        return formatsSupported;
    }

    public long getStorageSize() {
        return storageSize;
    }
}
