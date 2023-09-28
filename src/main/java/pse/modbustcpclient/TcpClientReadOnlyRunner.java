package pse.modbustcpclient;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;

public class TcpClientReadOnlyRunner {

    public static void main(String[] args) throws ExecutionException, InterruptedException , Exception {
        System.out.println("Starting TcpClientReadOnlyRunner... ");
        ModbusTcpClient client = new ModbusTcpClient("192.168.68.201",50200);
        client.connect();
//        int[] holdingRegisters = client.readHoldingRegisters(1,10);
//        Arrays.stream(holdingRegisters).forEach(registry -> {
//            System.out.println("Registry: " + registry);
//        });

//        client.writeHoldingRegister(10, 33);
        int[] holdingRegisters2 = client.readHoldingRegisters(40,4);
        Arrays.stream(holdingRegisters2).forEach( registry -> {
            System.out.println("Registry2: " + registry);
        });
        client.disconnect();
        System.out.println("Stopping TcpClientReadOnlyRunner... ");
    }
}
