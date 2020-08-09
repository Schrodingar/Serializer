import java.io.*;
import java.util.Arrays;

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

    public static String toStringByteArray(byte[] data) {
        String str = "i";
        for (int i = 0; i < data.length; i++) {
            str += data[i];
            if (i < data.length - 1) {
                str += ", ";
            }
        }
        str = str.substring(1);
        return str;
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
}

