package final_project.DAO;

import final_project.utils.Entity;
import final_project.utils.FilesIO;

import java.io.IOException;
import java.util.TreeSet;

public abstract class GeneralDAO<T extends Entity> {

    protected void add(String path, T t) throws IOException {
        try {
            FilesIO.writeFile(path, t.toDBEntity(), true);
        } catch (Exception e) {
            throw new IOException("Can't add " + t.getClass().getSimpleName() + " " + t.getId() + " " + e);
        }
    }

    abstract TreeSet<T> getAll() throws Exception;

    protected void hasEntity(long id) throws Exception{
        try {
            hasDuplicate(id);
        } catch (Exception e) {
            return;
        }
        throw new IOException("hasEntity method error - no such entity! Entity ID:" + id);
    }

    protected void hasDuplicate(long id) throws Exception{
        for (T t : getAll())
            if(t.getId() == id)
                throw new IOException("hasDuplicate error - duplicated entity! " + t.getClass().getSimpleName() + "_ID: " + id);
    }

}
