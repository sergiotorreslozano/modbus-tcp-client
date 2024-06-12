package pse.modbustcpclient;

import pse.modbustcpclient.exception.FunctionCodeNotSupportedException;
import pse.modbustcpclient.exception.InvalidQuantityException;
import pse.modbustcpclient.exception.InvalidStartingAddressException;
import pse.modbustcpclient.exception.ModbusException;

import java.io.IOException;

import static pse.modbustcpclient.helper.Utils.toIntArray;
import static pse.modbustcpclient.helper.Utils.toInteger;


public class ExtendedModbusTcpClient extends ModbusTcpClient{

    public ExtendedModbusTcpClient(String localhost, int port) {
        super(localhost,port);
    }

    /**
     * Reads an Integer
     * @param startingAddress
     * @param value only needed for overloading
     * @return
     * @throws ModbusException
     * @throws InvalidStartingAddressException
     * @throws InvalidQuantityException
     * @throws FunctionCodeNotSupportedException
     */
    public Integer readHoldingRegister (int startingAddress, Integer value)throws IOException, ModbusException, InvalidStartingAddressException, InvalidQuantityException, FunctionCodeNotSupportedException {
        return toInteger(super.readHoldingRegisters(startingAddress,2));
    }


    public void writeHoldingRegister(int startingAddress, Integer value) throws IOException, ModbusException, InvalidStartingAddressException, InvalidQuantityException, FunctionCodeNotSupportedException {
        super.writeHoldingRegisters(startingAddress, toIntArray(value));
    }
//
//    int[] toIntArray(Integer value) {
//        if (value == null) {
//            return null;
//        }
//
//        int intValue = value.intValue();
//        int[] result = new int[2];
//
//        // Extract the first 2 bytes (16 bits) and last 2 bytes (16 bits)
//        result[0] = (intValue >> 16) & 0xFFFF;
//        result[1] = intValue & 0xFFFF;
//
//        return result;
//    }
//
//    Integer toInteger(int[] values) {
//        if (values == null || values.length != 2) {
//            return null;
//        }
//
//        // Extract the last 2 bytes from each element and compose the Integer
//        int value = ((values[0] & 0xFFFF) << 16) | (values[1] & 0xFFFF);
//
//        return Integer.valueOf(value);
//    }

}
