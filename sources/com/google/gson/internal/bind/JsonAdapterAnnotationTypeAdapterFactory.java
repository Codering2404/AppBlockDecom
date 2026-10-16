package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.reflect.TypeToken;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class JsonAdapterAnnotationTypeAdapterFactory implements TypeAdapterFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConstructorConstructor f90408a;

    public JsonAdapterAnnotationTypeAdapterFactory(ConstructorConstructor constructorConstructor) {
        this.f90408a = constructorConstructor;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public TypeAdapter a(Gson gson, TypeToken typeToken) {
        JsonAdapter jsonAdapter = (JsonAdapter) typeToken.c().getAnnotation(JsonAdapter.class);
        if (jsonAdapter == null) {
            return null;
        }
        return b(this.f90408a, gson, typeToken, jsonAdapter);
    }

    TypeAdapter b(ConstructorConstructor constructorConstructor, Gson gson, TypeToken typeToken, JsonAdapter jsonAdapter) {
        TypeAdapter typeAdapterA;
        Object objA = constructorConstructor.b(TypeToken.a(jsonAdapter.value())).a();
        boolean zNullSafe = jsonAdapter.nullSafe();
        if (objA instanceof TypeAdapter) {
            typeAdapterA = (TypeAdapter) objA;
        } else if (objA instanceof TypeAdapterFactory) {
            typeAdapterA = ((TypeAdapterFactory) objA).a(gson, typeToken);
        } else {
            boolean z2 = objA instanceof JsonSerializer;
            if (!z2 && !(objA instanceof JsonDeserializer)) {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + objA.getClass().getName() + " as a @JsonAdapter for " + typeToken.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
            TreeTypeAdapter treeTypeAdapter = new TreeTypeAdapter(z2 ? (JsonSerializer) objA : null, objA instanceof JsonDeserializer ? (JsonDeserializer) objA : null, gson, typeToken, null, zNullSafe);
            zNullSafe = false;
            typeAdapterA = treeTypeAdapter;
        }
        return (typeAdapterA == null || !zNullSafe) ? typeAdapterA : typeAdapterA.a();
    }
}
