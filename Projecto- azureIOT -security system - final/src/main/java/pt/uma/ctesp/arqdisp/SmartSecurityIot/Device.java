/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uma.ctesp.arqdisp.SmartSecurityIot;

import com.microsoft.azure.sdk.iot.device.*;
import com.google.gson.Gson;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import java.io.*;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;
import pt.uma.ctesp.arqdisp.events.DirectMethodCallback;
import pt.uma.ctesp.arqdisp.events.DirectMethodStatusCallback;
import pt.uma.ctesp.arqdisp.events.EventCallback;

/**
 *
 * @author Turma A
 */
public class Device extends javax.swing.JFrame {

    private static String connString = "HostName=SmartTermoIOT.azure-devices.net;DeviceId=MyJavaDevice;SharedAccessKey=vNKQFKCHpEjw/Cjrz3x6HuP/UwvMjNlENP2F99hz+GU=";
    private static GpioPinDigitalOutput sensorTriggerPin;
    private static GpioPinDigitalInput sensorEchoPin;
    // Using the MQTT protocol to connect to IoT Hub
    private static IotHubClientProtocol protocol = IotHubClientProtocol.MQTT;
    private static DeviceClient client;
    public static final GpioController gpio = GpioFactory.getInstance();
    public static final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_15, "MyLED", PinState.HIGH);

    int distance;
    /**
     * Creates new form Device
     */
    Timer timer = new Timer();
    TimerTask sendMessage = new TimerTask() {
        @Override
        public void run() {
            TelemetryDataPoint telemetryDataPoint = new TelemetryDataPoint();
            System.out.println(distance);
            telemetryDataPoint.distance = distance;
            telemetryDataPoint.data = new Date();
            telemetryDataPoint.alarme = distance < DirectMethodCallback.getDistanceInterval();
            String msgStr = telemetryDataPoint.serialize();
            Message msg = new Message(msgStr);
            System.out.println("Sending message: " + msgStr);
            Object lockobj = new Object();

            // Send the message.
            EventCallback callback = new EventCallback();
            client.sendEventAsync(msg, callback, lockobj);

            synchronized (lockobj) {
                try {
                    lockobj.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Device.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Device.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    };
    TimerTask sensor = new TimerTask() {
        GpioPinDigitalOutput sensorTriggerPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_07);
        // Echo pin as INPUT
        GpioPinDigitalInput sensorEchoPin = gpio.provisionDigitalInputPin(RaspiPin.GPIO_00, PinPullResistance.PULL_DOWN);

        // create gpio controller
        @Override
        public void run() {
            // Trigger pin as OUTPUT

            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Device.class.getName()).log(Level.SEVERE, null, ex);
            }
            sensorTriggerPin.high(); // Make trigger pin HIGH
            try {
                Thread.sleep((long) 0.01);// Delay for 10 microseconds
            } catch (InterruptedException ex) {
                Logger.getLogger(Device.class.getName()).log(Level.SEVERE, null, ex);
            }
            sensorTriggerPin.low(); //Make trigger pin LOW

            while (sensorEchoPin.isLow()) { //Wait until the ECHO pin gets HIGH

            }
            long startTime = System.nanoTime(); // Store the surrent time to calculate ECHO pin HIGH time.
            while (sensorEchoPin.isHigh()) { //Wait until the ECHO pin gets LOW

            }
            long endTime = System.nanoTime(); // Store the echo pin HIGH end time to calculate ECHO pin HIGH time.

            distance = (int) ((((endTime - startTime) / 1e3) / 2) / 29.1);
            if (DirectMethodCallback.getAlarmState()) {
                if (distance < DirectMethodCallback.getDistanceInterval()) {
                    pin.high();
                } else {
                    pin.low();
                }

            }
        }

    };

    public Device() throws URISyntaxException, IOException, InterruptedException {
        initComponents();

        // Connect to the IoT hub.
        client = new DeviceClient(connString, protocol);
        client.open();

        client.subscribeToDeviceMethod(new DirectMethodCallback(), null, new DirectMethodStatusCallback(), null);
        timer.scheduleAtFixedRate(sensor, 500, 1000);
        timer.scheduleAtFixedRate(sendMessage, 5000, 1000);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Device.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Device.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Device.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Device.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Device().setVisible(true);
                } catch (URISyntaxException ex) {
                    Logger.getLogger(Device.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Device.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Device.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify                     
    // End of variables declaration                   
}
