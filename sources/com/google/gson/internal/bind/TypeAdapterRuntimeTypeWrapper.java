package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class TypeAdapterRuntimeTypeWrapper<T> extends TypeAdapter<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Gson f90475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TypeAdapter f90476b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Type f90477c;

    TypeAdapterRuntimeTypeWrapper(Gson gson, TypeAdapter typeAdapter, Type type) {
        this.f90475a = gson;
        this.f90476b = typeAdapter;
        this.f90477c = type;
    }

    private static Type e(Type type, Object obj) {
        return obj != null ? ((type instanceof Class) || (type instanceof TypeVariable)) ? obj.getClass() : type : type;
    }

    private static boolean f(TypeAdapter typeAdapter) {
        TypeAdapter typeAdapterE;
        while ((typeAdapter instanceof SerializationDelegatingTypeAdapter) && (typeAdapterE = ((SerializationDelegatingTypeAdapter) typeAdapter).e()) != typeAdapter) {
            typeAdapter = typeAdapterE;
        }
        return typeAdapter instanceof ReflectiveTypeAdapterFactory.Adapter;
    }

    @Override // com.google.gson.TypeAdapter
    public Object b(JsonReader jsonReader) {
        return this.f90476b.b(jsonReader);
    }

    @Override // com.google.gson.TypeAdapter
    public void d(JsonWriter jsonWriter, Object obj) {
        TypeAdapter typeAdapterL = this.f90476b;
        Type typeE = e(this.f90477c, obj);
        if (typeE != this.f90477c) {
            typeAdapterL = this.f90475a.l(TypeToken.b(typeE));
            if ((typeAdapterL instanceof ReflectiveTypeAdapterFactory.Adapter) && !f(this.f90476b)) {
                typeAdapterL = this.f90476b;
            }
        }
        typeAdapterL.d(jsonWriter, obj);
    }
}
