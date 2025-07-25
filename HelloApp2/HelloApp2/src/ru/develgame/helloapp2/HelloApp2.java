package ru.develgame.helloapp2;

import javacard.framework.*;

public class HelloApp2 extends Applet
{
	private static final byte HELLO_CLA = (byte)0xB0;
    
    private static final byte SAY_HELLO = (byte) 0x50;
    
    private static final byte SUM_CMD = (byte) 0x60;

	public static void install(byte[] bArray, short bOffset, byte bLength) 
	{
		new HelloApp2().register(bArray, (short) (bOffset + 1), bArray[bOffset]);
	}

	public void process(APDU apdu)
	{
		if (selectingApplet())
		{
			return;
		}

		byte[] buffer = apdu.getBuffer();
		if (buffer[ISO7816.OFFSET_CLA] != HELLO_CLA) {
            ISOException.throwIt(ISO7816.SW_CLA_NOT_SUPPORTED);
        }
        
        if (buffer[ISO7816.OFFSET_INS] == SAY_HELLO) {
            sayHello(apdu);
            return;
        }
        
        if (buffer[ISO7816.OFFSET_INS] == SUM_CMD) {
            sum(apdu);
            return;
        }
        
        ISOException.throwIt(ISO7816.SW_INS_NOT_SUPPORTED);
	}

	private void sayHello(APDU apdu) {
        byte[] buffer = apdu.getBuffer();
        short le = apdu.setOutgoing();
        
        apdu.setOutgoingLength((byte)5);
        buffer[0] = 104;
        buffer[1] = 101;
        buffer[2] = 108;
        buffer[3] = 108;
        buffer[4] = 111;
        
        apdu.sendBytes((short)0, (short)5);
    }
    
    private void sum(APDU apdu) {
	    byte[] buffer = apdu.getBuffer();
	    
	    byte p1 = buffer[ISO7816.OFFSET_P1];
	    byte p2 = buffer[ISO7816.OFFSET_P2];
	    
	    short le = apdu.setOutgoing();

        short p1s = (short) (p1 & 0xff);
        short p2s = (short) (p2 & 0xff);

        short res = (short) (p1s + p2s);
	    
	    apdu.setOutgoingLength((byte)2);
	    buffer[0] = (byte)((res >> 8) & 0xff);
	    buffer[1] = (byte)(res & 0xff);
	    
	    apdu.sendBytes((short)0, (short)2);
    }
}
