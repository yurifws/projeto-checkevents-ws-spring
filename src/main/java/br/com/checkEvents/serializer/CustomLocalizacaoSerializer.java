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

import br.com.checkEvents.model.Localizacao;

/**
 *
 * @author rodrigo alves
 */
public class CustomLocalizacaoSerializer extends StdSerializer<Localizacao> {

    public CustomLocalizacaoSerializer() {
        this(null);
    }

    public CustomLocalizacaoSerializer(Class<Localizacao> t) {
        super(t);
    }

    @Override
    public void serialize(
            Localizacao localizacao,
            JsonGenerator generator,
            SerializerProvider provider)
            throws IOException, JsonProcessingException {

        localizacao.setEvento(null);
        
        generator.writeObject(localizacao);
    }
    
}
