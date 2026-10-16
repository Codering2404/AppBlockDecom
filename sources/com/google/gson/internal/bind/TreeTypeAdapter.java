package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class TreeTypeAdapter<T> extends SerializationDelegatingTypeAdapter<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JsonSerializer f90461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final JsonDeserializer f90462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Gson f90463c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final TypeToken f90464d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final TypeAdapterFactory f90465e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final GsonContextImpl f90466f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f90467g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile TypeAdapter f90468h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class GsonContextImpl implements JsonSerializationContext, JsonDeserializationContext {
        private GsonContextImpl() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class SingleTypeFactory implements TypeAdapterFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TypeToken f90470a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f90471b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Class f90472c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final JsonSerializer f90473d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final JsonDeserializer f90474f;

        SingleTypeFactory(Object obj, TypeToken typeToken, boolean z2, Class cls) {
            JsonSerializer jsonSerializer = obj instanceof JsonSerializer ? (JsonSerializer) obj : null;
            this.f90473d = jsonSerializer;
            JsonDeserializer jsonDeserializer = obj instanceof JsonDeserializer ? (JsonDeserializer) obj : null;
            this.f90474f = jsonDeserializer;
            C$Gson$Preconditions.a((jsonSerializer == null && jsonDeserializer == null) ? false : true);
            this.f90470a = typeToken;
            this.f90471b = z2;
            this.f90472c = cls;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public TypeAdapter a(Gson gson, TypeToken typeToken) {
            TypeToken typeToken2 = this.f90470a;
            if (typeToken2 != null ? typeToken2.equals(typeToken) || (this.f90471b && this.f90470a.d() == typeToken.c()) : this.f90472c.isAssignableFrom(typeToken.c())) {
                return new TreeTypeAdapter(this.f90473d, this.f90474f, gson, typeToken, this);
            }
            return null;
        }
    }

    public TreeTypeAdapter(JsonSerializer jsonSerializer, JsonDeserializer jsonDeserializer, Gson gson, TypeToken typeToken, TypeAdapterFactory typeAdapterFactory, boolean z2) {
        this.f90466f = new GsonContextImpl();
        this.f90461a = jsonSerializer;
        this.f90462b = jsonDeserializer;
        this.f90463c = gson;
        this.f90464d = typeToken;
        this.f90465e = typeAdapterFactory;
        this.f90467g = z2;
    }

    private TypeAdapter f() {
        TypeAdapter typeAdapter = this.f90468h;
        if (typeAdapter != null) {
            return typeAdapter;
        }
        TypeAdapter typeAdapterN = this.f90463c.n(this.f90465e, this.f90464d);
        this.f90468h = typeAdapterN;
        return typeAdapterN;
    }

    public static TypeAdapterFactory g(TypeToken typeToken, Object obj) {
        return new SingleTypeFactory(obj, typeToken, typeToken.d() == typeToken.c(), null);
    }

    @Override // com.google.gson.TypeAdapter
    public Object b(JsonReader jsonReader) {
        if (this.f90462b == null) {
            return f().b(jsonReader);
        }
        JsonElement jsonElementA = Streams.a(jsonReader);
        if (this.f90467g && jsonElementA.h()) {
            return null;
        }
        return this.f90462b.a(jsonElementA, this.f90464d.d(), this.f90466f);
    }

    @Override // com.google.gson.TypeAdapter
    public void d(JsonWriter jsonWriter, Object obj) throws IOException {
        JsonSerializer jsonSerializer = this.f90461a;
        if (jsonSerializer == null) {
            f().d(jsonWriter, obj);
        } else if (this.f90467g && obj == null) {
            jsonWriter.F();
        } else {
            Streams.b(jsonSerializer.b(obj, this.f90464d.d(), this.f90466f), jsonWriter);
        }
    }

    @Override // com.google.gson.internal.bind.SerializationDelegatingTypeAdapter
    public TypeAdapter e() {
        return this.f90461a != null ? this : f();
    }

    public TreeTypeAdapter(JsonSerializer jsonSerializer, JsonDeserializer jsonDeserializer, Gson gson, TypeToken typeToken, TypeAdapterFactory typeAdapterFactory) {
        this(jsonSerializer, jsonDeserializer, gson, typeToken, typeAdapterFactory, true);
    }
}
