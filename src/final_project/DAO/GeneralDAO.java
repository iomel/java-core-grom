package final_project.DAO;

import final_project.utils.BaseEntity;
import final_project.utils.FilesIO;

import java.io.IOException;
import java.util.TreeSet;

public abstract class GeneralDAO<T extends BaseEntity> {

    protected void add(String path, T t) throws IOException {
        try {
            FilesIO.writeFile(path, t.toString(), true);
        } catch (Exception e) {
            throw new IOException("Can't add " + t.getClass().getSimpleName() + " " + t.getId() + " " + e);
        }
    }

    abstract TreeSet<T> getAll() throws Exception;

    protected void delete(String path, long id) throws Exception{
        hasEntity(id);

        String content = FilesIO.readFile(path).concat("\n").replaceAll("\n\n", "\n");
        String itemToDelete = "";
        for(T t : getAll())
            if(t.getId() == id) {
                itemToDelete = t.toString();
                break;
            }
        content = content.replace(itemToDelete, "");
        FilesIO.writeFile(path,content, false);
    }

    protected void hasEntity(long id) throws Exception{
        try {
            hasDuplicate(id);
        } catch (Exception e) {
            return;
        }
        throw new IOException("hasEntity method error - no such entity! BaseEntity ID:" + id);
    }

    protected void hasDuplicate(long id) throws Exception{
        for (T t : getAll())
            if(t.getId() == id)
                throw new IOException("hasDuplicate error - duplicated entity! " + t.getClass().getSimpleName() + "_ID: " + id);
    }

}
