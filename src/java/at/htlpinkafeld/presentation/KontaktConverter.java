/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.presentation;

import at.htlpinkafeld.pojo.Kontakt;
import java.util.List;
import javax.el.ELResolver;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

/**
 *
 * @author rene-_000
 */
public class KontaktConverter implements Converter{
    
        private Kontakt selectWithID(List<Kontakt> pList, int id) {

        for (Kontakt p : pList) {
            if (p.getKid()== id) {
                return p;
            }
        }

        return null;
    }
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Kontakt retVal = null;
        FacesMessage fm = null;

        if (string != null) {
            System.out.println(string);
            try {
                int id = Integer.parseInt(string.substring(0,1));
                Application app = fc.getApplication();
                ELResolver elRes = app.getELResolver();
               PostausgangsBean plB = (PostausgangsBean) elRes.getValue(fc.getELContext(),
                        null,
                        "buchBean");
                List<Kontakt> pList = plB.getKontaktliste();

                retVal = selectWithID(pList, id);
                if (retVal == null) {
                    fm = new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Invalid Fach-Id.", "");
                }

            } catch (NumberFormatException e) {
                fm = new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Abteilung-Id is not a number.", "");
            } catch (Exception e) {
                fm = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Abteilung conversion error.", "");
            }
            finally {
                if( fm != null )
                    throw new ConverterException(fm);
            }
        }

        return retVal;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        String retVal = null;

        if (o != null) {
            int id;
            Kontakt p = (Kontakt) o;
            id = p.getKid();
            if (id > 0) {
                retVal = p.toString();
            } else {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Kontakt not Initialized!!!",
                        "");
                throw new ConverterException(fm);
            }

        }

        return retVal;
    }
}
