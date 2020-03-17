package eg.edu.alexu.csd.oop.game.sample.GameObjects.Composite;

import java.util.ArrayList;
import java.util.List;

public class ShelfDirector {
    private static ShelfDirector ourInstance = new ShelfDirector();

    public static ShelfDirector getInstance() {
        return ourInstance;
    }

    private ShelfDirector() {
    }
    private List<Shelf> shelfList = new ArrayList<Shelf>();
    public Shelf showShelfeDetails(int i) {
        return shelfList.get(i);
    }

    public void addShelf(Shelf shelf) {
        shelfList.add(shelf);
    }
}
