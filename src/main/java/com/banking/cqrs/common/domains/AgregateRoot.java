package com.banking.cqrs.common.domains;

import com.banking.cqrs.common.events.BaseEvent;
import lombok.val;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AgregateRoot {
    private int version= -1;
    protected  String id;
    /**
     *Mantener la lista de events.
     * coleccion del conjunto de cambios de entidades de eventos.
     * esta lista va a contener todos los cambios   que fueron hechos el
     * el agregar en forma de eventos.
     */
    private final List<BaseEvent> changes = new ArrayList<>();
    private final Logger logger = Logger.getLogger(AgregateRoot.class.getName());

    public String getId(){
        return  this.id;
    }

    public int getVersion(){
        return this.version;
    }

    public void setVersion(int version){
        this.version= version;
    }

    /**
     * tambien vamos agregar una lista que almacene los cambios que no han sido
     * registrados , los eventos que no han sido registrados en este agregateroot
     */
    public List<BaseEvent> getUncommitedChange(){
        return  this.changes;
    }

    /**
     * changes en blanco los cambios estan confirmados
     * limpiar la lista
     */

    public void markChangesAsCommited(){
        this.changes.clear();
    }

    /**
     * Controlar estas actividades aplicar cambios
     * @param event
     *
     * una vez que se ejecute este mètodo, podrè agregar el evento a mi lista
     * de changes que esta en la parte de arriba
     *
     * posee dos acciones principales ejecutar new event, reprocesar un event
     *  la primera la ejecuciòn del m+ètodo Aply
     *  La segunda si el evento es nuevo se agregara a la lista de Changes
     */
    protected void applyChange(BaseEvent event, Boolean isNewEvent ) {
        //first catch evaluar si encontro el mètodo primero
        try {
            //buscar un mètodo
            //recuerda que tengo que utilizar reflexiòn porque estoy con clases genèricas
            val method = getClass().getDeclaredMethod("aply", event.getClass());
            //accesible el mètodo
            method.setAccessible(true);
            method.invoke(this, event);
        } catch (NoSuchMethodException e) {
            logger.log(Level.WARNING, MessageFormat.format("El mètodo aply no fue encontrado para {0}", event.getClass().getName()));
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Errores aplicando el evento al agregate", e);
        } finally {
            if (isNewEvent) {
                changes.add(event);
            }
        }
    }

    /**
     * agreagr
     * ejecutar y agregar dentro del agregar un nuevo evento
     */
    public void raiseEvent(BaseEvent event){
        applyChange(event, true);
    }
    /**
     * reprocesar un event
     */
    public void replaceEvents( Iterable<BaseEvent> events){
        events.forEach(event->applyChange(event, false));
    }
}
