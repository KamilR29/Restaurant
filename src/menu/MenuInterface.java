package menu;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface MenuInterface {


    default void createDish() throws IOException{}
    default void  readMenu() throws FileNotFoundException {}
    default void deleteFromMenu() throws IOException {}
    default void changeAvailable() throws IOException{}


}
