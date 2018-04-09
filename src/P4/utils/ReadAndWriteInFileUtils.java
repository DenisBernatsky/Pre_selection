package P4.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class ReadAndWriteInFileUtils {

    public void writeInFile(String fileName, String text) {
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            byte[] buffer = text.getBytes();
            fos.write(buffer, 0, buffer.length);
            fos.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public String getTextFromFile(String fileName) throws IOException {
        String content = null;
        File file = new File(fileName);
        FileReader reader = null;
        try {
            reader = new FileReader(file);
            char[] chars = new char[(int) file.length()];
            reader.read(chars);
            content = new String(chars);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(reader !=null){reader.close();}
        }
        return content;
    }


}
