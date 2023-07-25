/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.develgame.helloapp;

import javacard.framework.*;

/**
 *
 * @author pasca
 */
public class HelloApp extends Applet {
    final static byte HELLO_CLA = (byte)0xB0;
    
    final static byte SAY_HELLO = (byte) 0x50;

    /**
     * Installs this applet.
     * 
     * @param bArray
     *            the array containing installation parameters
     * @param bOffset
     *            the starting offset in bArray
     * @param bLength
     *            the length in bytes of the parameter data in bArray
     */
    public static void install(byte[] bArray, short bOffset, byte bLength) {
        new HelloApp();
    }

    /**
     * Only this class's install method should create the applet object.
     */
    protected HelloApp() {
        register();
    }

    /**
     * Processes an incoming APDU.
     * 
     * @see APDU
     * @param apdu
     *            the incoming APDU
     */
    public void process(APDU apdu) {
        byte[] buffer = apdu.getBuffer();
        
        if (selectingApplet()) {
            return;
        }
        
        if (buffer[ISO7816.OFFSET_CLA] != HELLO_CLA) {
            ISOException.throwIt(ISO7816.SW_CLA_NOT_SUPPORTED);
        }
        
        if (buffer[ISO7816.OFFSET_INS] == SAY_HELLO) {
            sayHello(apdu);
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
}
