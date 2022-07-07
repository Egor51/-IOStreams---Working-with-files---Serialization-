import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws IOException {

        File.createDir("/home/egor/Apps", "Games");
        File.createDir("/home/egor/Apps/Games", "src");
        File.createDir("/home/egor/Apps/Games", "res");
        File.createDir("/home/egor/Apps/Games", "temp");
        File.createDir("/home/egor/Apps/Games", "savegames");
        File.createDir("/home/egor/Apps/Games/src", "main");
        File.createDir("/home/egor/Apps/Games/src", "test");
        File.createDir("/home/egor/Apps/Games/res", "drawables");
        File.createDir("/home/egor/Apps/Games/res", "vectors");
        File.createDir("/home/egor/Apps/Games/res", "icons");

        File.createFile("/home/egor/Apps/Games/src/main", "Main.java");
        File.createFile("/home/egor/Apps/Games/src/main", "Utils.java");
        File.createFile("/home/egor/Apps/Games/temp", "temp.txt");
        File.fileWrit();
    }



}

