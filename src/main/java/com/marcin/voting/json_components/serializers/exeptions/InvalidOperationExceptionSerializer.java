package com.marcin.voting.json_components.serializers.exeptions;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.marcin.voting.exeptions.InvalidOperationException;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class InvalidOperationExceptionSerializer extends StdSerializer<InvalidOperationException> {

    public InvalidOperationExceptionSerializer() {
        this(null);
    }

    public InvalidOperationExceptionSerializer(Class<InvalidOperationException> e) {
        super(e);
    }

    @Override
    public void serialize(InvalidOperationException e, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

        jsonGenerator.writeStartObject();

        jsonGenerator.writeNumberField("status", 406);
        jsonGenerator.writeStringField("message", e.getMessage());
        jsonGenerator.writeStringField("timestamp", e.getExceptionTime().format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss")));

        jsonGenerator.writeEndObject();
    }
}
