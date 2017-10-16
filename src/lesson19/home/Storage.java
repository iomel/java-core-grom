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

    public boolean checkFormat (File file)
    {
        if(file == null)
            return false;
        if(file.getFormat() == null)
            return false;

        for (String format : formatsSupported)
        {
            if (format.equals(file.getFormat()))
                return true;
        }
        return false;
    }

    public long getStorageFreeSpace ()
    {
        if (files == null)
            return storageSize;

        long totalSize = 0;
        for (File f : files)
        {
            if(f == null)
                continue;
            totalSize += f.getSize();
        }

        return storageSize - totalSize;
    }

    public boolean hasFile (File file){
        // null check ?
        if (files == null)
            return false;

        for (File f : files)
        {
            if (f.equals(file) || f.getId() == file.getId())
                return true;
        }
        return false;
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

    public void setFiles(File[] files) {
        this.files = files;
    }

    public long getId() {
        return id;
    }

    public File[] getFiles() {
        return files;
    }

    public String[] getFormatsSupported() {
        return formatsSupported;
    }

    public String getStorageCountry() {
        return storageCountry;
    }

    public long getStorageSize() {
        return storageSize;
    }
}
