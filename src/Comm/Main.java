package Comm;

public class Main {
	public static void main(String[] args) {
		DSerialPort serialPort = new DSerialPort();
		serialPort.listPort();
		serialPort.selectPort("COM3");
		serialPort.Initialize();
		//0Ϊһֱ����
		serialPort.startRead(0);
	}
}
