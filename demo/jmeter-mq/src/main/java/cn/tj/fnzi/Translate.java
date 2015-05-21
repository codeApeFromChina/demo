package cn.tj.fnzi;

public class Translate {

	public static void main(String[] args) throws Exception {
		String text = "dddd";
		byte[] bs = text.getBytes("GBK");
		
		for(byte b : bs) {
			System.out.print(b);
		}
		
	}

}



//<?xml version="1.0" encoding="UTF-8"?>
//<R>
//	<HD>
//		<MT>RELI</MT>
//		<MS>0412345</MS>
//		<SSN>101</SSN>
//		<SDR>GWC001,RcvQ01</SDR>
//	</HD>
//	<BD>
//		<ENB>${a}</ENB>
//		<PWD>${b}</PWD>
//	</BD>
//</R>
