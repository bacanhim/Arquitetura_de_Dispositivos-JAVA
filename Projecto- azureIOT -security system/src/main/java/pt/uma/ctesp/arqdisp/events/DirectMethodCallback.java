/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uma.ctesp.arqdisp.events;

import pt.uma.ctesp.arqdisp.SmartSecurityIot.Device;
import com.microsoft.azure.sdk.iot.device.*;
import com.microsoft.azure.sdk.iot.device.DeviceTwin.*;
import com.google.gson.Gson;
import com.microsoft.azure.sdk.iot.service.devicetwin.MethodResult;
import com.microsoft.azure.sdk.iot.service.exceptions.IotHubException;
import java.io.*;
import java.net.URISyntaxException;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Turma A
 */
public class DirectMethodCallback implements DeviceMethodCallback{
    // Define method response codes
    private static final int METHOD_SUCCESS = 200;
    private static final int METHOD_NOT_DEFINED = 404;
    private static final int INVALID_PARAMETER = 400;

    private static int telemetryInterval = 50;
    private static boolean isOn = true;
    public static boolean getAlarmState() {
        return isOn;
    }

    public static void setAlarmState(boolean A) {
        System.out.println("Alarme definido como: "+A);
        isOn = A;
    }
    
    private void setDistanceInterval(int interval)
    {
      System.out.println("Distancia alterada para : " + interval);
      telemetryInterval = interval ;
    }

    public static int getDistanceInterval() {
        return telemetryInterval;
    }
    private static void blink(){
        for (int i = 0; i < 3; i++) {
            Device.pin.high();
            try {
                 Thread.sleep(200);
            } catch (InterruptedException ex) {
                 Logger.getLogger(DirectMethodCallback.class.getName()).log(Level.SEVERE, null, ex);
            }
            Device.pin.low();
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(DirectMethodCallback.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    

  @Override
    public DeviceMethodData call(String methodName, Object methodData, Object context)
    {
      DeviceMethodData deviceMethodData;
      String payload = new String((byte[])methodData);
      switch (methodName)
      {
        case "SetDistanceInterval" :
        {
          int interval;
          try {
            int status = METHOD_SUCCESS;
            interval = Integer.parseInt(payload);
            System.out.println(payload);
            setDistanceInterval(interval);
            deviceMethodData = new DeviceMethodData(status, "Executed direct method " + methodName);
            } catch (NumberFormatException e) {
            int status = INVALID_PARAMETER;
            deviceMethodData = new DeviceMethodData(status, "Invalid parameter " + payload);
          }
          break;
        }
        case "SetAlarmOn" :
        {
          boolean ison;
          try {
            int status = METHOD_SUCCESS;
            ison = Boolean.parseBoolean(payload);
            System.out.println(ison);
            setAlarmState(ison);
            deviceMethodData = new DeviceMethodData(status, "Executed direct method " + methodName);
            blink();
          } catch (NumberFormatException e) {
            int status = INVALID_PARAMETER;
            deviceMethodData = new DeviceMethodData(status, "Invalid parameter " + payload);
          }
          break;
        }
        default:
        {
          int status = METHOD_NOT_DEFINED;
          deviceMethodData = new DeviceMethodData(status, "Not defined direct method " + methodName);
        }
      }
      return deviceMethodData;
      }
}
