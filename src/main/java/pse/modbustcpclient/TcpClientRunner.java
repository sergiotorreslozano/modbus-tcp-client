package pse.modbustcpclient;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Optional;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class TcpClientRunner {

    private static String ipAddress;
    private static int port;
    private static int connectTimeout;

    public static void main(String[] args) throws ExecutionException, InterruptedException , Exception     {
        System.out.println("Starting TcpClientRunner... ");
        if (args.length <2){
            System.out.println("usage: java -Dconfig=config.properties -jar <startingWriteAddres> [values]");
            System.exit(1); // not right number of parameters
        }
        readProperties();

        ModbusTcpClient client = new ModbusTcpClient(ipAddress, port, connectTimeout);
        client.connect();
        int startingAddress = Integer.parseInt(args[0]);
        int[] values = findValues(args);
        client.writeHoldingRegisters(startingAddress, values);

        int[] holdingRegisters = client.readHoldingRegisters(startingAddress,values.length);
        Arrays.stream(holdingRegisters).forEach( registry -> {
            System.out.println("Registry: " + registry);
        });

        client.disconnect();
        System.out.println("Stopping TcpClientRunner... ");
    }

    private static int[] findValues(String[] args) {
        int[] values = new int[args.length-1];
        for (int i = 0; i < values.length; i++) {
            // args has one element more due to args[0] being the starting address
            values[i] = Integer.parseInt(args[i+1]);
        }
        return values;
    }

    private static void readProperties() {

        try {
            InputStream input = TcpClientRunner.class.getClassLoader().getResourceAsStream("config.properties");
            Properties prop = new Properties();

            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                System.exit(2); // Stopping due to properties not being loaded
            }

            //load a properties file from class path, inside static method
            prop.load(input);
            ipAddress = (String) prop.get("ipAddress");
            // get the property value and print it out
            System.out.println(prop.getProperty("ipAddress"));
            port = Integer.parseInt(prop.getProperty("port"));
            System.out.println(prop.getProperty("port"));
            connectTimeout = Integer.parseInt(prop.getProperty("connectTimeout"));
            System.out.println(prop.getProperty("connectTimeout"));

        } catch (IOException ex) {
            System.out.println("Could not load properties " + ex);
            System.exit(2); // Stopping due to properties not being loaded
        }

    }
}
