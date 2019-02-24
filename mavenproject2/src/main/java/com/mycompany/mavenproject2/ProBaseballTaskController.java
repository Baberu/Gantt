package com.mycompany.mavenproject2;

import com.mycompany.mavenproject2.util.JsfUtil;
import com.mycompany.mavenproject2.util.JsfUtil.PersistAction;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;

@Named("proBaseballTaskController")
@SessionScoped
public class ProBaseballTaskController implements Serializable {

    @EJB
    private com.mycompany.mavenproject2.ProBaseballTaskFacade ejbFacade;
    private List<ProBaseballTask> items = null;
    private ProBaseballTask selected;
    private String ganttData = "";
    public ProBaseballTaskController() {
    }

    public ProBaseballTask getSelected() {
        return selected;
    }

    public void setSelected(ProBaseballTask selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ProBaseballTaskFacade getFacade() {
        return ejbFacade;
    }

    public ProBaseballTask prepareCreate() {
        selected = new ProBaseballTask();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ProBaseballTaskCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ProBaseballTaskUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ProBaseballTaskDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<ProBaseballTask> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }
    
    public String createGanttData() {
        List<ProBaseballTask> taskList = getFacade().sportFindTask();
        JSONObject dataJson = new JSONObject();
        JSONArray array = new JSONArray();
        //dhtmlx gantt の仕様のDateFormat
        SimpleDateFormat ganntDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        try {
            //dhtmlx gantt の仕様に合わせたデータを作成する
            for(ProBaseballTask proBaseballTask : taskList){
                    JSONObject taskJson = new JSONObject();
                    taskJson.put("id", proBaseballTask.getId());
                    String text = proBaseballTask.getProBaseballHomeTeamId().getName() + " - " + proBaseballTask.getProBaseballAwayTeamId().getName();
                    taskJson.put("text", text);
                    taskJson.put("place", proBaseballTask.getProBaseballPlaceId().getPlaceName());
                    String start_date = ganntDateFormat.format(proBaseballTask.getStartDatetime());
                    taskJson.put("start_date", start_date);
                    taskJson.put("duration", 1);
                    array.put(taskJson);
            }
            // jsonを入れ子にする
            dataJson.put("data",array);
            ganttData = dataJson.toString();
        } catch (JSONException ex) {
            Logger.getLogger(ProBaseballTaskController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ganttData;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public ProBaseballTask getProBaseballTask(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<ProBaseballTask> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<ProBaseballTask> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = ProBaseballTask.class)
    public static class ProBaseballTaskControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ProBaseballTaskController controller = (ProBaseballTaskController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "proBaseballTaskController");
            return controller.getProBaseballTask(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof ProBaseballTask) {
                ProBaseballTask o = (ProBaseballTask) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ProBaseballTask.class.getName()});
                return null;
            }
        }

    }

}
