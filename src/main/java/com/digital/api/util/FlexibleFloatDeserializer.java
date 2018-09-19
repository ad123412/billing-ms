package com.digital.api.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;

public class FlexibleFloatDeserializer extends JsonDeserializer<Float> {

    @Override
    public Float deserialize(JsonParser parser, DeserializationContext context)
            throws IOException {
        String floatString = parser.getText();
        if (floatString.contains(",")) {
            floatString = floatString.replace(",", ".");
        }
        System.out.println("floatString >>>>>>>>>>>>>>>>>> " + floatString);
        return Float.valueOf(floatString);
    }
}
