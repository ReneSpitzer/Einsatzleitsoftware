/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.presentation;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
 
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Circle;

/**
 *
 * @author Alex
 */

@ManagedBean
@SessionScoped
public class karteBean implements Serializable{


   private MapModel simpleModel;
      
    @PostConstruct
    public void init() {
         
        this.simpleModel = new DefaultMapModel();
    }
   
    public void onCircleSelect(OverlaySelectEvent event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Circle Selected", null));
    }
    
    public MapModel getSimpleModel() {
        return simpleModel;
    }
    
    public void drawNuessler(double x, double y, int metersI, int metersA){
        LatLng kord =new LatLng(x,y);
        Circle cirI = new Circle(kord, metersI);
        Circle cirA = new Circle(kord, metersA);
       
        
        //Konfiguration Evakuierungsberreich Innen
        cirI.setStrokeColor("#d93c3c");
        cirI.setFillColor("#d93c3c");
        cirI.setStrokeOpacity(2.0);
        cirI.setFillOpacity(0.0);
        
        //Konfiguration Evakuierungsberreich Aussen
        cirA.setStrokeColor("#00ff00");
        cirA.setFillColor("#00ff00");
        cirA.setStrokeOpacity(2.0);
        cirA.setFillOpacity(0.0);
        
        simpleModel.addOverlay(cirI);
        simpleModel.addOverlay(cirA);
        
    }
    
    public void addMarker(double x, double y, String aufgabe){
        LatLng kord =new LatLng(x,y);
        
        simpleModel.addOverlay(new Marker(kord, aufgabe));
    }
    
    public void addMarker(double x, double y){
        LatLng kord =new LatLng(x,y);
        
        simpleModel.addOverlay(new Marker(kord));
    }
    
    
}


/* Testdaten --> ins init() einfügen zum testen
        //Shared coordinates
        LatLng coord1 = new LatLng(47.370875, 16.124291);
        LatLng coord2 = new LatLng(47.378978, 16.124792);
        LatLng coord3 = new LatLng(47.379672, 16.124984);
        LatLng coord4 = new LatLng(47.374771, 16.124573);
 
        //Basic marker
        simpleModel.addOverlay(new Marker(coord1, "Einsatz 1"));
        simpleModel.addOverlay(new Marker(coord2, "Einsatz 2"));
        simpleModel.addOverlay(new Marker(coord3, "Einsatz 3"));
        simpleModel.addOverlay(new Marker(coord4, "Einsatz 4"));

        //Circle
        Circle circle1 = new Circle(coord1, 500);
        circle1.setStrokeColor("#d93c3c");
        circle1.setFillColor("#d93c3c");
        circle1.setStrokeOpacity(2.0);
        circle1.setFillOpacity(0.0);
 
        Circle circle2 = new Circle(coord4, 300);
        circle2.setStrokeColor("#00ff00");
        circle2.setFillColor("#00ff00");
        circle2.setStrokeOpacity(2.0);
        circle2.setFillOpacity(0.0);
 
        simpleModel.addOverlay(circle1);
        simpleModel.addOverlay(circle2);      
*/
