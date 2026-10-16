package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class JsonTreeWriter extends JsonWriter {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final Writer f90416q = new Writer() { // from class: com.google.gson.internal.bind.JsonTreeWriter.1
        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            throw new AssertionError();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i3, int i4) {
            throw new AssertionError();
        }
    };

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final JsonPrimitive f90417r = new JsonPrimitive("closed");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final List f90418n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f90419o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private JsonElement f90420p;

    public JsonTreeWriter() {
        super(f90416q);
        this.f90418n = new ArrayList();
        this.f90420p = JsonNull.f90293a;
    }

    private JsonElement U0() {
        return (JsonElement) this.f90418n.get(r0.size() - 1);
    }

    private void X0(JsonElement jsonElement) {
        if (this.f90419o != null) {
            if (!jsonElement.h() || l()) {
                ((JsonObject) U0()).o(this.f90419o, jsonElement);
            }
            this.f90419o = null;
            return;
        }
        if (this.f90418n.isEmpty()) {
            this.f90420p = jsonElement;
            return;
        }
        JsonElement jsonElementU0 = U0();
        if (!(jsonElementU0 instanceof JsonArray)) {
            throw new IllegalStateException();
        }
        ((JsonArray) jsonElementU0).o(jsonElement);
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter A0(boolean z2) {
        X0(new JsonPrimitive(Boolean.valueOf(z2)));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter F() {
        X0(JsonNull.f90293a);
        return this;
    }

    public JsonElement R0() {
        if (this.f90418n.isEmpty()) {
            return this.f90420p;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.f90418n);
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter c() {
        JsonArray jsonArray = new JsonArray();
        X0(jsonArray);
        this.f90418n.add(jsonArray);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.f90418n.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.f90418n.add(f90417r);
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter f() {
        JsonObject jsonObject = new JsonObject();
        X0(jsonObject);
        this.f90418n.add(jsonObject);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter g0(double d3) {
        if (n() || !(Double.isNaN(d3) || Double.isInfinite(d3))) {
            X0(new JsonPrimitive(Double.valueOf(d3)));
            return this;
        }
        throw new IllegalArgumentException("JSON forbids NaN and infinities: " + d3);
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter j() {
        if (this.f90418n.isEmpty() || this.f90419o != null) {
            throw new IllegalStateException();
        }
        if (!(U0() instanceof JsonArray)) {
            throw new IllegalStateException();
        }
        this.f90418n.remove(r0.size() - 1);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter j0(long j3) {
        X0(new JsonPrimitive(Long.valueOf(j3)));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter k() {
        if (this.f90418n.isEmpty() || this.f90419o != null) {
            throw new IllegalStateException();
        }
        if (!(U0() instanceof JsonObject)) {
            throw new IllegalStateException();
        }
        this.f90418n.remove(r0.size() - 1);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter q0(Boolean bool) {
        if (bool == null) {
            return F();
        }
        X0(new JsonPrimitive(bool));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter w0(Number number) {
        if (number == null) {
            return F();
        }
        if (!n()) {
            double dDoubleValue = number.doubleValue();
            if (Double.isNaN(dDoubleValue) || Double.isInfinite(dDoubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        X0(new JsonPrimitive(number));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter z(String str) {
        Objects.requireNonNull(str, "name == null");
        if (this.f90418n.isEmpty() || this.f90419o != null) {
            throw new IllegalStateException();
        }
        if (!(U0() instanceof JsonObject)) {
            throw new IllegalStateException();
        }
        this.f90419o = str;
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter z0(String str) {
        if (str == null) {
            return F();
        }
        X0(new JsonPrimitive(str));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter, java.io.Flushable
    public void flush() {
    }
}
