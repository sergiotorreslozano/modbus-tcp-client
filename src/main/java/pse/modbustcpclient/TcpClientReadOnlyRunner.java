package pse.modbustcpclient;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;

public class TcpClientReadOnlyRunner {

    public static void main(String[] args) throws ExecutionException, InterruptedException , Exception {
        System.out.println("Starting TcpClientReadOnlyRunner... ");
        ModbusTcpClient client = new ModbusTcpClient("192.168.68.202",50200);
        client.connect();
//        int[] holdingRegisters = client.readHoldingRegisters(1,10);
//        Arrays.stream(holdingRegisters).forEach(registry -> {
//            System.out.println("Registry: " + registry);
//        });

//        client.writeHoldingRegister(10, 33);
        int[] holdingRegisters1 = client.readHoldingRegisters(40,4);
        Arrays.stream(holdingRegisters1).forEach( registry -> {
            System.out.println("Registry read: " + registry);
        });

        int[] holdingRegisters2 = client.readHoldingRegisters(50,4);
        Arrays.stream(holdingRegisters2).forEach( registry -> {
            System.out.println("Registry read: " + registry);
        });



        int[] holdingRegisters3 = client.readHoldingRegisters(60,4);
        Arrays.stream(holdingRegisters3).forEach( registry -> {
            System.out.println("Registry read: " + registry);
        });

        int[] holdingRegisters4 = client.readHoldingRegisters(70,4);
        Arrays.stream(holdingRegisters4).forEach( registry -> {
            System.out.println("Registry read: " + registry);
        });

        int[] holdingRegisters5 = client.readHoldingRegisters(80,4);
        Arrays.stream(holdingRegisters5).forEach( registry -> {
            System.out.println("Registry read: " + registry);
        });

        client.disconnect();
        System.out.println("Stopping TcpClientReadOnlyRunner... ");
    }
}
