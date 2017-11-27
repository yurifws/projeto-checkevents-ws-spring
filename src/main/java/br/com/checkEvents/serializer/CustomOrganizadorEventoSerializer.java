/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.checkEvents.serializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import br.com.checkEvents.model.Usuario;

/**
 *
 * @author rodrigo alves
 */
public class CustomOrganizadorEventoSerializer extends StdSerializer<Usuario> {

    public CustomOrganizadorEventoSerializer() {
        this(null);
    }
 
    public CustomOrganizadorEventoSerializer(Class<Usuario> t) {
        super(t);
    }
    
    @Override
    public void serialize(
    		Usuario items, 
      JsonGenerator generator, 
      SerializerProvider provider) 
      throws IOException, JsonProcessingException {
         
//        List<Integer> ids = new ArrayList<Integer>();
//        for (Evento item : items) {
//            item.setOrganizador(null);
//        }
    	items.setEventos(null);

        generator.writeObject(items);
    }
    
    protected Date formatarData(Date data, String format) throws ParseException{
    	SimpleDateFormat sdf = new SimpleDateFormat(format);
    	String dataFormatada = sdf.format(data);
    	return sdf.parse(dataFormatada);
    }
    
}
