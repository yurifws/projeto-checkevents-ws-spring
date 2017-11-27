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

import br.com.checkEvents.model.Endereco;

/**
 *
 * @author rodrigo alves
 */
public class CustomEnderecoSerializer extends StdSerializer<Endereco> {

    public CustomEnderecoSerializer() {
        this(null);
    }

    public CustomEnderecoSerializer(Class<Endereco> t) {
        super(t);
    }

    @Override
    public void serialize(
            Endereco endereco,
            JsonGenerator generator,
            SerializerProvider provider)
            throws IOException, JsonProcessingException {

        endereco.setEvento(null);
        
        generator.writeObject(endereco);
    }
    
}
