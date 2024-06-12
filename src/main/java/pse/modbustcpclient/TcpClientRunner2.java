package pse.modbustcpclient;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;

public class TcpClientRunner2 {



    public static void main(String[] args) throws ExecutionException, InterruptedException , Exception     {
        System.out.println("Starting TcpClientRunner... ");
        ExtendedModbusTcpClient client = new ExtendedModbusTcpClient("192.168.68.210",50200);
        client.connect();

        client.writeHoldingRegister(40, 8000);


        int[] values = new int[]{20, 22};
        client.writeHoldingRegisters(41, values);

        int [] readHoldingRegisters = client.readHoldingRegisters(40, 4);
        Arrays.stream(readHoldingRegisters).forEach( registry -> {
            System.out.println("Registry: " + registry);
        });


        System.out.println("-----------");
        Integer original = 305419896;
        int[] originals = toRegistry(original);
        toInteger(originals);

        client.writeHoldingRegister(40,original);
        Integer back = client.readHoldingRegister(40, 0);
        System.out.println("back: " + back);



        System.out.println("MINUS 1 -----------");
        Integer minus1 = -1;
        int[] negative = toRegistry(minus1);
        toInteger(negative);

        client.writeHoldingRegister(50, minus1);
        System.out.println("back -1: " + client.readHoldingRegister(50,0));

        System.out.println("······················");
        Integer forTest = -32769;
        toInteger(toRegistry(forTest));

        client.writeHoldingRegister(80, 888);


        client.disconnect();
        System.out.println("Stopping TcpClientRunner... ");
    }

    static int[] toRegistry(Integer value){
        System.out.println("toRegistry: " + value);
        if (value == null) {
            return null;
        }
        toConsole(value);
        int intValue = value.intValue();
        int[] result = new int[2];

        // Extract the first 2 bytes (16 bits) and last 2 bytes (16 bits)
        result[0] = (intValue >> 16) & 0xFFFF;
        result[1] = intValue & 0xFFFF;
        System.out.println("result[0]");
        toConsole(result[0]);
        System.out.println("result[1]");
        toConsole(result[1]);
        toConsole(result);
        System.out.println("completed toRegistry");
        return result;
    }

    static void toConsole(Integer value){
        System.out.println("As HEX: " + String.format("%04X", value));
        System.out.println("asInteger value: " + value);
    }

    static Integer toInteger(int[] values) {
        if (values == null || values.length != 2) {
            return null;
        }
        toConsole(values);

        // Extract the last 2 bytes from each element and compose the Integer
        int value = ((values[0] & 0xFFFF) << 16) | (values[1] & 0xFFFF);
        toConsole(value);
        return Integer.valueOf(value);
    }

    static void toConsole(int[] result){
        System.out.println("result[0]: " + result[0]);
        System.out.println("result[1]: " + result[1]);
    }
}
