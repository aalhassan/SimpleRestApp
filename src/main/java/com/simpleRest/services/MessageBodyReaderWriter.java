package com.simpleRest.services;

import org.glassfish.jersey.media.sse.EventOutput;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/**
 * This is the main class for the implementation
 * of MessageBodyReader and MessageBodyWriter
 *
 * @author Mej Al
 */
@Provider
@Produces({MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
public class MessageBodyReaderWriter implements MessageBodyReader<EventOutput>, MessageBodyWriter<EventOutput> {
    public boolean isReadable(Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType) {
        return true;
    }

    public EventOutput readFrom(Class<EventOutput> msgClass, Type type, Annotation[] annotations,
                                MediaType mediaType,
                                MultivaluedMap<String, String> stringEventOutputMultivaluedMap,
                                InputStream inputStream) throws IOException, WebApplicationException {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(EventOutput.class.getPackage().getName());
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            EventOutput msg = (EventOutput) unmarshaller.unmarshal(inputStream);
            return msg;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean isWriteable(Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType) {
        return true;
    }

    public long getSize(EventOutput msg, Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType) {
        return -1;
    }

    public void writeTo(EventOutput msg, Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> stringObjectMultivaluedMap, OutputStream outputStream) throws IOException, WebApplicationException {
        try {
            if (mediaType.equals(MediaType.APPLICATION_XML_TYPE)) {
                JAXBContext jaxbContext = JAXBContext.newInstance(EventOutput.class.getPackage().getName());

                Marshaller marshaller = jaxbContext.createMarshaller();
                marshaller.marshal(msg, outputStream);
            } else {
                outputStream.write(msg.toString().getBytes());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getStringFromInputStream(InputStream is) {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
        try {

            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();

    }
}

