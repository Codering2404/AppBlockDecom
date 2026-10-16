package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.ToNumberPolicy;
import com.google.gson.ToNumberStrategy;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class ObjectTypeAdapter extends TypeAdapter<Object> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final TypeAdapterFactory f90431c = f(ToNumberPolicy.DOUBLE);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Gson f90432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ToNumberStrategy f90433b;

    /* JADX INFO: renamed from: com.google.gson.internal.bind.ObjectTypeAdapter$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f90435a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            f90435a = iArr;
            try {
                iArr[JsonToken.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f90435a[JsonToken.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f90435a[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f90435a[JsonToken.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f90435a[JsonToken.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f90435a[JsonToken.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static TypeAdapterFactory e(ToNumberStrategy toNumberStrategy) {
        return toNumberStrategy == ToNumberPolicy.DOUBLE ? f90431c : f(toNumberStrategy);
    }

    private static TypeAdapterFactory f(final ToNumberStrategy toNumberStrategy) {
        return new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.ObjectTypeAdapter.1
            @Override // com.google.gson.TypeAdapterFactory
            public TypeAdapter a(Gson gson, TypeToken typeToken) {
                if (typeToken.c() == Object.class) {
                    return new ObjectTypeAdapter(gson, toNumberStrategy);
                }
                return null;
            }
        };
    }

    private Object g(JsonReader jsonReader, JsonToken jsonToken) throws IOException {
        int i3 = AnonymousClass2.f90435a[jsonToken.ordinal()];
        if (i3 == 3) {
            return jsonReader.e0();
        }
        if (i3 == 4) {
            return this.f90433b.a(jsonReader);
        }
        if (i3 == 5) {
            return Boolean.valueOf(jsonReader.J());
        }
        if (i3 == 6) {
            jsonReader.T();
            return null;
        }
        throw new IllegalStateException("Unexpected token: " + jsonToken);
    }

    private Object h(JsonReader jsonReader, JsonToken jsonToken) throws IOException {
        int i3 = AnonymousClass2.f90435a[jsonToken.ordinal()];
        if (i3 == 1) {
            jsonReader.a();
            return new ArrayList();
        }
        if (i3 != 2) {
            return null;
        }
        jsonReader.b();
        return new LinkedTreeMap();
    }

    @Override // com.google.gson.TypeAdapter
    public Object b(JsonReader jsonReader) throws IOException {
        JsonToken jsonTokenJ0 = jsonReader.j0();
        Object objH = h(jsonReader, jsonTokenJ0);
        if (objH == null) {
            return g(jsonReader, jsonTokenJ0);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (jsonReader.r()) {
                String strN = objH instanceof Map ? jsonReader.N() : null;
                JsonToken jsonTokenJ02 = jsonReader.j0();
                Object objH2 = h(jsonReader, jsonTokenJ02);
                boolean z2 = objH2 != null;
                if (objH2 == null) {
                    objH2 = g(jsonReader, jsonTokenJ02);
                }
                if (objH instanceof List) {
                    ((List) objH).add(objH2);
                } else {
                    ((Map) objH).put(strN, objH2);
                }
                if (z2) {
                    arrayDeque.addLast(objH);
                    objH = objH2;
                }
            } else {
                if (objH instanceof List) {
                    jsonReader.j();
                } else {
                    jsonReader.k();
                }
                if (arrayDeque.isEmpty()) {
                    return objH;
                }
                objH = arrayDeque.removeLast();
            }
        }
    }

    @Override // com.google.gson.TypeAdapter
    public void d(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.F();
            return;
        }
        TypeAdapter typeAdapterM = this.f90432a.m(obj.getClass());
        if (!(typeAdapterM instanceof ObjectTypeAdapter)) {
            typeAdapterM.d(jsonWriter, obj);
        } else {
            jsonWriter.f();
            jsonWriter.k();
        }
    }

    private ObjectTypeAdapter(Gson gson, ToNumberStrategy toNumberStrategy) {
        this.f90432a = gson;
        this.f90433b = toNumberStrategy;
    }
}
