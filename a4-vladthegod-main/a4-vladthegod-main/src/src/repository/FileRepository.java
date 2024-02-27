package repository;
import domain.Identifiable;
import exceptions.AlreadyExistentItem;
import exceptions.InexistentItem;

public abstract class FileRepository<T extends  Identifiable<U>,U> extends  MemoryRepository<T,U> {
    protected String fileName;

    public FileRepository(String filename)
    {
        this.fileName =filename;
        //this.readFromFile();//to be comented if bin is empty
    }

    protected abstract void readFromFile();

    protected abstract void writeFile();

    @Override
    public void addItem(T elem) throws AlreadyExistentItem
    {
        try {
            super.addItem(elem);
            writeFile();
        }catch (AlreadyExistentItem e)
        {
            System.out.println("Item already exists.");
        }
    }

    @Override
    public boolean removeItem(U id) throws InexistentItem {
       boolean  removed= super.removeItem(id);
        if(removed)
        {
            writeFile();
        }
        return removed;
    }


    @Override
    public void updateItemById(U id, T newItem) throws InexistentItem {
        super.updateItemById(id, newItem);
        writeFile();
    }

}
