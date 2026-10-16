package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class JsonParser {
    public static JsonElement a(JsonReader jsonReader) {
        boolean z2 = jsonReader.z();
        jsonReader.O0(true);
        try {
            try {
                return Streams.a(jsonReader);
            } catch (OutOfMemoryError e3) {
                throw new JsonParseException("Failed parsing JSON source: " + jsonReader + " to Json", e3);
            } catch (StackOverflowError e4) {
                throw new JsonParseException("Failed parsing JSON source: " + jsonReader + " to Json", e4);
            }
        } finally {
            jsonReader.O0(z2);
        }
    }

    public static JsonElement b(Reader reader) {
        try {
            JsonReader jsonReader = new JsonReader(reader);
            JsonElement jsonElementA = a(jsonReader);
            if (!jsonElementA.h() && jsonReader.j0() != JsonToken.END_DOCUMENT) {
                throw new JsonSyntaxException("Did not consume the entire document.");
            }
            return jsonElementA;
        } catch (MalformedJsonException e3) {
            throw new JsonSyntaxException(e3);
        } catch (IOException e4) {
            throw new JsonIOException(e4);
        } catch (NumberFormatException e5) {
            throw new JsonSyntaxException(e5);
        }
    }

    public static JsonElement c(String str) {
        return b(new StringReader(str));
    }
}
