package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class MapTypeAdapterFactory implements TypeAdapterFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConstructorConstructor f90421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final boolean f90422b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class Adapter<K, V> extends TypeAdapter<Map<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TypeAdapter f90423a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final TypeAdapter f90424b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ObjectConstructor f90425c;

        public Adapter(Gson gson, Type type, TypeAdapter typeAdapter, Type type2, TypeAdapter typeAdapter2, ObjectConstructor objectConstructor) {
            this.f90423a = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
            this.f90424b = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter2, type2);
            this.f90425c = objectConstructor;
        }

        private String e(JsonElement jsonElement) {
            if (!jsonElement.n()) {
                if (jsonElement.h()) {
                    return "null";
                }
                throw new AssertionError();
            }
            JsonPrimitive jsonPrimitiveE = jsonElement.e();
            if (jsonPrimitiveE.v()) {
                return String.valueOf(jsonPrimitiveE.s());
            }
            if (jsonPrimitiveE.t()) {
                return Boolean.toString(jsonPrimitiveE.o());
            }
            if (jsonPrimitiveE.w()) {
                return jsonPrimitiveE.f();
            }
            throw new AssertionError();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Map b(JsonReader jsonReader) throws IOException {
            JsonToken jsonTokenJ0 = jsonReader.j0();
            if (jsonTokenJ0 == JsonToken.NULL) {
                jsonReader.T();
                return null;
            }
            Map map = (Map) this.f90425c.a();
            if (jsonTokenJ0 != JsonToken.BEGIN_ARRAY) {
                jsonReader.b();
                while (jsonReader.r()) {
                    JsonReaderInternalAccess.f90355a.a(jsonReader);
                    Object objB = this.f90423a.b(jsonReader);
                    if (map.put(objB, this.f90424b.b(jsonReader)) != null) {
                        throw new JsonSyntaxException("duplicate key: " + objB);
                    }
                }
                jsonReader.k();
                return map;
            }
            jsonReader.a();
            while (jsonReader.r()) {
                jsonReader.a();
                Object objB2 = this.f90423a.b(jsonReader);
                if (map.put(objB2, this.f90424b.b(jsonReader)) != null) {
                    throw new JsonSyntaxException("duplicate key: " + objB2);
                }
                jsonReader.j();
            }
            jsonReader.j();
            return map;
        }

        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void d(JsonWriter jsonWriter, Map map) throws IOException {
            if (map == null) {
                jsonWriter.F();
                return;
            }
            if (!MapTypeAdapterFactory.this.f90422b) {
                jsonWriter.f();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    jsonWriter.z(String.valueOf(entry.getKey()));
                    this.f90424b.d(jsonWriter, entry.getValue());
                }
                jsonWriter.k();
                return;
            }
            ArrayList arrayList = new ArrayList(map.size());
            ArrayList arrayList2 = new ArrayList(map.size());
            int i3 = 0;
            boolean z2 = false;
            for (Map.Entry<K, V> entry2 : map.entrySet()) {
                JsonElement jsonElementC = this.f90423a.c(entry2.getKey());
                arrayList.add(jsonElementC);
                arrayList2.add(entry2.getValue());
                z2 |= jsonElementC.g() || jsonElementC.l();
            }
            if (!z2) {
                jsonWriter.f();
                int size = arrayList.size();
                while (i3 < size) {
                    jsonWriter.z(e((JsonElement) arrayList.get(i3)));
                    this.f90424b.d(jsonWriter, arrayList2.get(i3));
                    i3++;
                }
                jsonWriter.k();
                return;
            }
            jsonWriter.c();
            int size2 = arrayList.size();
            while (i3 < size2) {
                jsonWriter.c();
                Streams.b((JsonElement) arrayList.get(i3), jsonWriter);
                this.f90424b.d(jsonWriter, arrayList2.get(i3));
                jsonWriter.j();
                i3++;
            }
            jsonWriter.j();
        }
    }

    public MapTypeAdapterFactory(ConstructorConstructor constructorConstructor, boolean z2) {
        this.f90421a = constructorConstructor;
        this.f90422b = z2;
    }

    private TypeAdapter b(Gson gson, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? TypeAdapters.f90483f : gson.l(TypeToken.b(type));
    }

    @Override // com.google.gson.TypeAdapterFactory
    public TypeAdapter a(Gson gson, TypeToken typeToken) {
        Type typeD = typeToken.d();
        Class clsC = typeToken.c();
        if (!Map.class.isAssignableFrom(clsC)) {
            return null;
        }
        Type[] typeArrJ = C$Gson$Types.j(typeD, clsC);
        return new Adapter(gson, typeArrJ[0], b(gson, typeArrJ[0]), typeArrJ[1], gson.l(TypeToken.b(typeArrJ[1])), this.f90421a.b(typeToken));
    }
}
