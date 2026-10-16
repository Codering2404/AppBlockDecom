package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class CollectionTypeAdapterFactory implements TypeAdapterFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConstructorConstructor f90399a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Adapter<E> extends TypeAdapter<Collection<E>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TypeAdapter f90400a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ObjectConstructor f90401b;

        public Adapter(Gson gson, Type type, TypeAdapter typeAdapter, ObjectConstructor objectConstructor) {
            this.f90400a = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
            this.f90401b = objectConstructor;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Collection b(JsonReader jsonReader) throws IOException {
            if (jsonReader.j0() == JsonToken.NULL) {
                jsonReader.T();
                return null;
            }
            Collection collection = (Collection) this.f90401b.a();
            jsonReader.a();
            while (jsonReader.r()) {
                collection.add(this.f90400a.b(jsonReader));
            }
            jsonReader.j();
            return collection;
        }

        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(JsonWriter jsonWriter, Collection collection) throws IOException {
            if (collection == null) {
                jsonWriter.F();
                return;
            }
            jsonWriter.c();
            Iterator<E> it = collection.iterator();
            while (it.hasNext()) {
                this.f90400a.d(jsonWriter, it.next());
            }
            jsonWriter.j();
        }
    }

    public CollectionTypeAdapterFactory(ConstructorConstructor constructorConstructor) {
        this.f90399a = constructorConstructor;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public TypeAdapter a(Gson gson, TypeToken typeToken) {
        Type typeD = typeToken.d();
        Class clsC = typeToken.c();
        if (!Collection.class.isAssignableFrom(clsC)) {
            return null;
        }
        Type typeH = C$Gson$Types.h(typeD, clsC);
        return new Adapter(gson, typeH, gson.l(TypeToken.b(typeH)), this.f90399a.b(typeToken));
    }
}
