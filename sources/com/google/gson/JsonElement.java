package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.StringWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class JsonElement {
    public int a() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public JsonArray b() {
        if (g()) {
            return (JsonArray) this;
        }
        throw new IllegalStateException("Not a JSON Array: " + this);
    }

    public JsonObject d() {
        if (l()) {
            return (JsonObject) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public JsonPrimitive e() {
        if (n()) {
            return (JsonPrimitive) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }

    public String f() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean g() {
        return this instanceof JsonArray;
    }

    public boolean h() {
        return this instanceof JsonNull;
    }

    public boolean l() {
        return this instanceof JsonObject;
    }

    public boolean n() {
        return this instanceof JsonPrimitive;
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            JsonWriter jsonWriter = new JsonWriter(stringWriter);
            jsonWriter.T(true);
            Streams.b(this, jsonWriter);
            return stringWriter.toString();
        } catch (IOException e3) {
            throw new AssertionError(e3);
        }
    }
}
