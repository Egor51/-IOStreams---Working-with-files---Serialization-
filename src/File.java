import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class File {

    static String way;
    static String name;

    static StringBuilder log = new StringBuilder();

    public File(String way,String name)  {
        this.way = way;
        this.way = name;
    }

    static boolean createDir(String way,String name) throws IOException {
        java.io.File dir = new java.io.File(way,name);
        try { if (dir.mkdir()) {
                log.append("Директория  "+ name + " создана" + " ")
                        .append(new Date()).append(":");
                System.out.println("папка создана");
            }
            return false;
        } catch (Exception e) { throw new IOException(e);
        }
    }

    static boolean createFile(String way,String name) throws IOException {
        java.io.File dir = new java.io.File(way,name);
        try {
            //TODO если фаил создан то не пересоздавать
            if (dir.createNewFile())
                log.append("Фаил  " + name + "  создан" + " ")
                        .append(new Date()).append(":");
            System.out.println("Фаил создан");
          } catch (Exception e) { throw new IOException(e);
        }
        return false;
    }

    public static void fileWrit() throws IOException {
        try (FileWriter writer = new FileWriter("/home/egor/Apps/Games/temp/temp.txt", true)) {
            writer.write(String.valueOf(log));
            writer.write("\n");
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }


    }
}






