import java.io.*;

public class Serializer {

    public static byte[] serialize(Object obj) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream os;
        try {
            os = new ObjectOutputStream(out);
            os.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toByteArray();
    }

    public static Object deserialize(byte[] data) {
        ByteArrayInputStream in = new ByteArrayInputStream(data);
        ObjectInputStream is;
        try {
            is = new ObjectInputStream(in);
            return is.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeInFile(byte[] array, String filePath) {
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(array, 0, array.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static byte[] rearFromFile(String filePath) {
        try (FileInputStream fin = new FileInputStream(filePath)) {
            byte[] buffer = new byte[fin.available()];
            fin.read(buffer, 0, fin.available());
            return buffer;
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return null;
    }

}

