/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.checkEvents.serializer;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import br.com.checkEvents.model.Evento;

/**
 *
 * @author rodrigo alves
 */
public class CustomEventoParticipanteSerializer extends StdSerializer<List<Evento>> {

    public CustomEventoParticipanteSerializer() {
        this(null);
    }
 
    public CustomEventoParticipanteSerializer(Class<List<Evento>> t) {
        super(t);
    }
    
    @Override
    public void serialize(
      List<Evento> items, 
      JsonGenerator generator, 
      SerializerProvider provider) 
      throws IOException, JsonProcessingException {
         
//        List<Integer> ids = new ArrayList<Integer>();
//        for (Evento item : items) {
//            item.setOrganizador(null);
//        }
    items.stream().forEach(evento -> {
        evento.setParticipantes(null);
    });

        generator.writeObject(items);
    }
    
}
