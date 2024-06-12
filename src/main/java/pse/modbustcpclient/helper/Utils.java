package pse.modbustcpclient.helper;

import java.nio.ByteBuffer;


public abstract class Utils {
    public static byte[] toByteArray(short value) {
        return ByteBuffer.allocate(2).putShort(value).array();
    }

    public static byte[] toByteArray(int value) {
        return ByteBuffer.allocate(4).putInt(value).array();
    }

    public static byte[] toByteArray(float value) {
        return ByteBuffer.allocate(4).putFloat(value).array();
    }

    public static byte[] toByteArray(double value) {
        return ByteBuffer.allocate(8).putDouble(value).array();
    }

    public static byte[] toByteArray(long value) {
        return ByteBuffer.allocate(8).putLong(value).array();
    }

    public static int[] toIntArray(Integer value) {
        if (value == null) {
            return null;
        }

        int intValue = value.intValue();
        int[] result = new int[2];

        // Extract the first 2 bytes (16 bits) and last 2 bytes (16 bits)
        result[0] = (intValue >> 16) & 0xFFFF;
        result[1] = intValue & 0xFFFF;

        return result;
    }

    public static Integer toInteger(int[] values) {
        if (values == null || values.length != 2) {
            return null;
        }

        // Extract the last 2 bytes from each element and compose the Integer
        int value = ((values[0] & 0xFFFF) << 16) | (values[1] & 0xFFFF);

        return Integer.valueOf(value);
    }

}
