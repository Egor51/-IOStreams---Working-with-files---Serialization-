import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {
    static StringBuilder log = new StringBuilder();

    static boolean createDir(String way, String name) {
        java.io.File dir = new java.io.File(way, name);
        if (dir.mkdir()) {
            log.append("Директория  " + name + " создана" + " ").append(new Date()).append(":");
            System.out.println("Директория " + name + " создана");
        }
        return false;
    }

    static boolean createFile(String way, String name) {
        java.io.File file = new java.io.File(way, name);
        try {
            if (file.createNewFile()) {
                log.append("Фаил  " + name + "  создан" + " ")
                        .append(new Date()).append(":");
                System.out.println("Фаил " + name + " создан");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            ;
        }
        return false;
    }

    public static void fileWrite() {
        try (FileWriter writer = new FileWriter("/home/egor/Apps/Games/temp/temp.txt", true)) {
            writer.write(String.valueOf(log));
            writer.write("\n");
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static boolean saveGame(String name, GameProgress gameProgress) {
        java.io.File file = new java.io.File("/home/egor/Apps/Games/savegames", name);
        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(gameProgress);
            System.out.println("Фаил  " + name + " сохранен успешно");
            log.append("Фаил  " + name + " сохранен" + " ").append(new Date()).append(":");


        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    public static void zipFiles(String path, ArrayList<String> listSave) {
        for (String pathSave : listSave) {
            try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(path));
                 FileInputStream fis = new FileInputStream(pathSave)) {

                ZipEntry zipEntry = new ZipEntry(pathSave);
                zos.putNextEntry(zipEntry);
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);
                zos.write(buffer);
                zos.closeEntry();
                System.out.println("Файл" + pathSave + " заaрхивирован");
                log.append("Фаил" + pathSave + " заархивированны" + " ").append(new Date()).append(":");

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void deleteSave(String way, String name) {
        java.io.File file = new java.io.File(way, name);
        if (file.delete()) {
            System.out.println("Фаил  " + name + " удален");
            log.append("Фаил  " + name + " удален" + " ").append(new Date()).append(":");

        }
    }

    public static void main(String[] args) throws IOException {

        createDir("/home/egor/Apps", "Games");
        createDir("/home/egor/Apps/Games", "src");
        createDir("/home/egor/Apps/Games", "res");
        createDir("/home/egor/Apps/Games", "temp");
        createDir("/home/egor/Apps/Games", "savegames");
        createDir("/home/egor/Apps/Games/src", "main");
        createDir("/home/egor/Apps/Games/src", "test");
        createDir("/home/egor/Apps/Games/res", "drawables");
        createDir("/home/egor/Apps/Games/res", "vectors");
        createDir("/home/egor/Apps/Games/res", "icons");


        createFile("/home/egor/Apps/Games/src/main", "Main.java");
        createFile("/home/egor/Apps/Games/src/main", "Utils.java");
        createFile("/home/egor/Apps/Games/temp", "temp.txt");


        saveGame("save1.dat", new GameProgress(100, 2, 2, 13));
        saveGame("save2.dat", new GameProgress(98, 4, 5, 129));
        saveGame("save3.dat", new GameProgress(54, 2, 10, 300));

        ArrayList<String> array = new ArrayList<>();
        array.add("/home/egor/Apps/Games/savegames//save1.dat");
        array.add("/home/egor/Apps/Games/savegames//save2.dat");
        array.add("/home/egor/Apps/Games/savegames//save3.dat");
        zipFiles("/home/egor/Apps/Games/savegames/zip.zip", array);

        deleteSave("/home/egor/Apps/Games/savegames/", "save1.dat");
        deleteSave("/home/egor/Apps/Games/savegames/", "save2.dat");
        deleteSave("/home/egor/Apps/Games/savegames/", "save3.dat");
        fileWrite();

    }
}





