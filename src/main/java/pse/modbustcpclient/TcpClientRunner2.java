package pse.modbustcpclient;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;

public class TcpClientRunner2 {



    public static void main(String[] args) throws ExecutionException, InterruptedException , Exception     {
        System.out.println("Starting TcpClientRunner... ");
        ModbusTcpClient client = new ModbusTcpClient("localhost",50200);
        client.connect();
        int[] holdingRegisters = client.readHoldingRegisters(1,10);
        Arrays.stream(holdingRegisters).forEach( registry -> {
            System.out.println("Registry: " + registry);
        });

        client.writeHoldingRegister(10, 8000);
        int[] holdingRegisters2 = client.readHoldingRegisters(1,10);
        Arrays.stream(holdingRegisters2).forEach( registry -> {
            System.out.println("Registry: " + registry);
        });

        int[] values = new int[]{15,20,50,60};
        client.writeHoldingRegisters(15, values);

        client.disconnect();
        System.out.println("Stopping TcpClientRunner... ");
    }
}
