/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smarttermoazureiot;

import com.microsoft.azure.sdk.iot.device.*;
/**
 *
 * @author Turma A
 */
public class DirectMethodStatusCallback {
    public void execute(IotHubStatusCode status, Object context)
    {
      System.out.println("Direct method # IoT Hub responded to device method acknowledgement with status: " + status.name());
    }
}
