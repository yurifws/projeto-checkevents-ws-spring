/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.checkEvents.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import br.com.checkEvents.model.Contato;

/**
 *
 * @author rodrigo alves
 */
public class CustomContatoSerializer extends StdSerializer<Contato> {

    public CustomContatoSerializer() {
        this(null);
    }

    public CustomContatoSerializer(Class<Contato> t) {
        super(t);
    }

    @Override
    public void serialize(
            Contato contato,
            JsonGenerator generator,
            SerializerProvider provider)
            throws IOException, JsonProcessingException {

        contato.setUsuario(null);
        
        contato.setEvento(null);
        
        generator.writeObject(contato);
    }
}
