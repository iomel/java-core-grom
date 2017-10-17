package lesson19.home;

public class File {
    private long id;
    private String name;
    private String format;
    private long size;

    public File(long id, String name, String format, long size) {
        if (name != null)
            if (name.length() > 10) {
                System.out.println("Wrong file name length! File will not be created");
                return;
            }
        this.id = id;
        this.name = name;
        this.format = format;
        this.size = size;
    }

    public boolean isEmpty ()
    {
        if (id==0 && name == null && format == null && size == 0)
            return true;
        return false;
    }


    @Override
    public String toString() {
        return "   File{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", format='" + format + '\'' +
                ", size=" + size +
                '}';
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFormat() {
        return format;
    }

    public long getSize() {
        return size;
    }
}
