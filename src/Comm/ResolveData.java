package Comm;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ResolveData {
	byte[] portData;
	public ResolveData(byte[] readBuffer){
		portData = readBuffer;
	}
	public Data getData(){
		String strData = new String(portData);
		byte[] resultPortData = strData.trim().getBytes();
		int soilTemperature = (resultPortData[1] * 10) + resultPortData[2];
		int soilHumidity = (resultPortData[3] * 100) + (resultPortData[4] * 10) + resultPortData[5];
		int airTemperature = resultPortData[6] * 10 + resultPortData[7];
		int airHumidity = resultPortData[8] * 10 + resultPortData[9];
		String currentTime = new SimpleDateFormat("HH:mm:ss").format(new Date()).toString();
		System.out.println("当前时间为：" + currentTime);
		System.out.println("当前土壤温度为：" + soilTemperature + ",当前土壤湿度为：" + soilHumidity);
		System.out.println("当前空气温度为：" + airTemperature + ",当前空气温度为：" + airHumidity );
		Data data = new Data(soilTemperature, soilHumidity, airTemperature, airHumidity, currentTime);
		return data;
	}
}
