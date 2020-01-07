/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uma.ctesp.arqdisp.SmartSecurityIot;

import com.google.gson.Gson;
import java.util.Date;

/**
 *
 * @author Turma A
 */
public class TelemetryDataPoint {

    public double distance;
    public Date data;
    public boolean alarme;

    // Serialize object to JSON format.
    public String serialize() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
