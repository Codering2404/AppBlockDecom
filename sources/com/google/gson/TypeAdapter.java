package com.google.gson;

import com.google.gson.internal.bind.JsonTreeWriter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class TypeAdapter<T> {
    public final TypeAdapter a() {
        return new TypeAdapter<T>() { // from class: com.google.gson.TypeAdapter.1
            @Override // com.google.gson.TypeAdapter
            public Object b(JsonReader jsonReader) throws IOException {
                if (jsonReader.j0() != JsonToken.NULL) {
                    return TypeAdapter.this.b(jsonReader);
                }
                jsonReader.T();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public void d(JsonWriter jsonWriter, Object obj) throws IOException {
                if (obj == null) {
                    jsonWriter.F();
                } else {
                    TypeAdapter.this.d(jsonWriter, obj);
                }
            }
        };
    }

    public abstract Object b(JsonReader jsonReader);

    public final JsonElement c(Object obj) {
        try {
            JsonTreeWriter jsonTreeWriter = new JsonTreeWriter();
            d(jsonTreeWriter, obj);
            return jsonTreeWriter.R0();
        } catch (IOException e3) {
            throw new JsonIOException(e3);
        }
    }

    public abstract void d(JsonWriter jsonWriter, Object obj);
}
