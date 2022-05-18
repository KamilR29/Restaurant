package order;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Delete {

    public int delAll() throws FileNotFoundException {

        PrintWriter printWriter = new PrintWriter("order.txt");
        printWriter.print("");
        printWriter.close();
        PrintWriter printWriter1 = new PrintWriter("done.txt");
        printWriter1.print("");
        printWriter1.close();

        return 0;
    }


}
