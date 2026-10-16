package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class ArrayTypeAdapter<E> extends TypeAdapter<Object> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final TypeAdapterFactory f90396c = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.ArrayTypeAdapter.1
        @Override // com.google.gson.TypeAdapterFactory
        public TypeAdapter a(Gson gson, TypeToken typeToken) {
            Type typeD = typeToken.d();
            if (!(typeD instanceof GenericArrayType) && (!(typeD instanceof Class) || !((Class) typeD).isArray())) {
                return null;
            }
            Type typeG = C$Gson$Types.g(typeD);
            return new ArrayTypeAdapter(gson, gson.l(TypeToken.b(typeG)), C$Gson$Types.k(typeG));
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class f90397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TypeAdapter f90398b;

    public ArrayTypeAdapter(Gson gson, TypeAdapter typeAdapter, Class cls) {
        this.f90398b = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, cls);
        this.f90397a = cls;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.gson.TypeAdapter
    public Object b(JsonReader jsonReader) throws IOException {
        if (jsonReader.j0() == JsonToken.NULL) {
            jsonReader.T();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        jsonReader.a();
        while (jsonReader.r()) {
            arrayList.add(this.f90398b.b(jsonReader));
        }
        jsonReader.j();
        int size = arrayList.size();
        if (!this.f90397a.isPrimitive()) {
            return arrayList.toArray((Object[]) Array.newInstance((Class<?>) this.f90397a, size));
        }
        Object objNewInstance = Array.newInstance((Class<?>) this.f90397a, size);
        for (int i3 = 0; i3 < size; i3++) {
            Array.set(objNewInstance, i3, arrayList.get(i3));
        }
        return objNewInstance;
    }

    @Override // com.google.gson.TypeAdapter
    public void d(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.F();
            return;
        }
        jsonWriter.c();
        int length = Array.getLength(obj);
        for (int i3 = 0; i3 < length; i3++) {
            this.f90398b.d(jsonWriter, Array.get(obj, i3));
        }
        jsonWriter.j();
    }
}
