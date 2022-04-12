package edu.ecnu.tobacco_display.utils;


import java.io.*;

//序列化工具
public class SerializeUtil {
    public static byte[] serialize(Object object) {//序列化
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            byte[] bytes = baos.toByteArray();
            return bytes;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static Object unserialize(byte[] bytes) {//反序列化
        ByteArrayInputStream bais = null;
        try {
            bais = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
