package com.google.gson.internal.bind;

import androidx.media3.extractor.jpeg.xWt.jTYhJgqLBN;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.ReflectionAccessFilter;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Primitives;
import com.google.gson.internal.ReflectionAccessFilterHelper;
import com.google.gson.internal.reflect.ReflectionHelper;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class ReflectiveTypeAdapterFactory implements TypeAdapterFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConstructorConstructor f90436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FieldNamingStrategy f90437b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Excluder f90438c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final JsonAdapterAnnotationTypeAdapterFactory f90439d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List f90440f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Adapter<T, A> extends TypeAdapter<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Map f90450a;

        Adapter(Map map) {
            this.f90450a = map;
        }

        @Override // com.google.gson.TypeAdapter
        public Object b(JsonReader jsonReader) throws IOException {
            if (jsonReader.j0() == JsonToken.NULL) {
                jsonReader.T();
                return null;
            }
            Object objE = e();
            try {
                jsonReader.b();
                while (jsonReader.r()) {
                    BoundField boundField = (BoundField) this.f90450a.get(jsonReader.N());
                    if (boundField == null || !boundField.f90455e) {
                        jsonReader.h1();
                    } else {
                        g(objE, jsonReader, boundField);
                    }
                }
                jsonReader.k();
                return f(objE);
            } catch (IllegalAccessException e3) {
                throw ReflectionHelper.e(e3);
            } catch (IllegalStateException e4) {
                throw new JsonSyntaxException(e4);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void d(JsonWriter jsonWriter, Object obj) throws IOException {
            if (obj == null) {
                jsonWriter.F();
                return;
            }
            jsonWriter.f();
            try {
                Iterator it = this.f90450a.values().iterator();
                while (it.hasNext()) {
                    ((BoundField) it.next()).c(jsonWriter, obj);
                }
                jsonWriter.k();
            } catch (IllegalAccessException e3) {
                throw ReflectionHelper.e(e3);
            }
        }

        abstract Object e();

        abstract Object f(Object obj);

        abstract void g(Object obj, JsonReader jsonReader, BoundField boundField);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class BoundField {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f90451a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Field f90452b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final String f90453c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final boolean f90454d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final boolean f90455e;

        protected BoundField(String str, Field field, boolean z2, boolean z3) {
            this.f90451a = str;
            this.f90452b = field;
            this.f90453c = field.getName();
            this.f90454d = z2;
            this.f90455e = z3;
        }

        abstract void a(JsonReader jsonReader, int i3, Object[] objArr);

        abstract void b(JsonReader jsonReader, Object obj);

        abstract void c(JsonWriter jsonWriter, Object obj);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class RecordAdapter<T> extends Adapter<T, Object[]> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        static final Map f90457e = j();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Constructor f90458b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Object[] f90459c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Map f90460d;

        RecordAdapter(Class cls, Map map, boolean z2) {
            super(map);
            this.f90460d = new HashMap();
            Constructor constructorI = ReflectionHelper.i(cls);
            this.f90458b = constructorI;
            if (z2) {
                ReflectiveTypeAdapterFactory.c(null, constructorI);
            } else {
                ReflectionHelper.l(constructorI);
            }
            String[] strArrJ = ReflectionHelper.j(cls);
            for (int i3 = 0; i3 < strArrJ.length; i3++) {
                this.f90460d.put(strArrJ[i3], Integer.valueOf(i3));
            }
            Class<?>[] parameterTypes = this.f90458b.getParameterTypes();
            this.f90459c = new Object[parameterTypes.length];
            for (int i4 = 0; i4 < parameterTypes.length; i4++) {
                this.f90459c[i4] = f90457e.get(parameterTypes[i4]);
            }
        }

        private static Map j() {
            HashMap map = new HashMap();
            map.put(Byte.TYPE, (byte) 0);
            map.put(Short.TYPE, (short) 0);
            map.put(Integer.TYPE, 0);
            map.put(Long.TYPE, 0L);
            map.put(Float.TYPE, Float.valueOf(0.0f));
            map.put(Double.TYPE, Double.valueOf(0.0d));
            map.put(Character.TYPE, (char) 0);
            map.put(Boolean.TYPE, Boolean.FALSE);
            return map;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Object[] e() {
            return (Object[]) this.f90459c.clone();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Object f(Object[] objArr) {
            try {
                return this.f90458b.newInstance(objArr);
            } catch (IllegalAccessException e3) {
                throw ReflectionHelper.e(e3);
            } catch (IllegalArgumentException e4) {
                e = e4;
                throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.c(this.f90458b) + "' with args " + Arrays.toString(objArr), e);
            } catch (InstantiationException e5) {
                e = e5;
                throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.c(this.f90458b) + "' with args " + Arrays.toString(objArr), e);
            } catch (InvocationTargetException e6) {
                throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.c(this.f90458b) + "' with args " + Arrays.toString(objArr), e6.getCause());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public void g(Object[] objArr, JsonReader jsonReader, BoundField boundField) {
            Integer num = (Integer) this.f90460d.get(boundField.f90453c);
            if (num != null) {
                boundField.a(jsonReader, num.intValue(), objArr);
                return;
            }
            throw new IllegalStateException("Could not find the index in the constructor '" + ReflectionHelper.c(this.f90458b) + "' for field with name '" + boundField.f90453c + "', unable to determine which argument in the constructor the field corresponds to. This is unexpected behavior, as we expect the RecordComponents to have the same names as the fields in the Java class, and that the order of the RecordComponents is the same as the order of the canonical constructor parameters.");
        }
    }

    public ReflectiveTypeAdapterFactory(ConstructorConstructor constructorConstructor, FieldNamingStrategy fieldNamingStrategy, Excluder excluder, JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory, List list) {
        this.f90436a = constructorConstructor;
        this.f90437b = fieldNamingStrategy;
        this.f90438c = excluder;
        this.f90439d = jsonAdapterAnnotationTypeAdapterFactory;
        this.f90440f = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static void c(Object obj, AccessibleObject accessibleObject) {
        if (Modifier.isStatic(((Member) accessibleObject).getModifiers())) {
            obj = null;
        }
        if (ReflectionAccessFilterHelper.a(accessibleObject, obj)) {
            return;
        }
        throw new JsonIOException(ReflectionHelper.g(accessibleObject, true) + " is not accessible and ReflectionAccessFilter does not permit making it accessible. Register a TypeAdapter for the declaring type, adjust the access filter or increase the visibility of the element and its declaring type.");
    }

    private BoundField d(final Gson gson, Field field, final Method method, String str, final TypeToken typeToken, boolean z2, boolean z3, final boolean z4) {
        final boolean zA = Primitives.a(typeToken.c());
        int modifiers = field.getModifiers();
        final boolean z5 = Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers);
        JsonAdapter jsonAdapter = (JsonAdapter) field.getAnnotation(JsonAdapter.class);
        TypeAdapter typeAdapterB = jsonAdapter != null ? this.f90439d.b(this.f90436a, gson, typeToken, jsonAdapter) : null;
        final boolean z6 = typeAdapterB != null;
        if (typeAdapterB == null) {
            typeAdapterB = gson.l(typeToken);
        }
        final TypeAdapter typeAdapter = typeAdapterB;
        return new BoundField(str, field, z2, z3) { // from class: com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.1
            @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
            void a(JsonReader jsonReader, int i3, Object[] objArr) {
                Object objB = typeAdapter.b(jsonReader);
                if (objB != null || !zA) {
                    objArr[i3] = objB;
                    return;
                }
                throw new JsonParseException("null is not allowed as value for record component '" + this.f90453c + "' of primitive type; at path " + jsonReader.g());
            }

            @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
            void b(JsonReader jsonReader, Object obj) throws IllegalAccessException {
                Object objB = typeAdapter.b(jsonReader);
                if (objB == null && zA) {
                    return;
                }
                if (z4) {
                    ReflectiveTypeAdapterFactory.c(obj, this.f90452b);
                } else if (z5) {
                    throw new JsonIOException("Cannot set value of 'static final' " + ReflectionHelper.g(this.f90452b, false));
                }
                this.f90452b.set(obj, objB);
            }

            @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
            void c(JsonWriter jsonWriter, Object obj) throws IllegalAccessException {
                Object objInvoke;
                if (this.f90454d) {
                    if (z4) {
                        Method method2 = method;
                        if (method2 == null) {
                            ReflectiveTypeAdapterFactory.c(obj, this.f90452b);
                        } else {
                            ReflectiveTypeAdapterFactory.c(obj, method2);
                        }
                    }
                    Method method3 = method;
                    if (method3 != null) {
                        try {
                            objInvoke = method3.invoke(obj, null);
                        } catch (InvocationTargetException e3) {
                            throw new JsonIOException("Accessor " + ReflectionHelper.g(method, false) + " threw exception", e3.getCause());
                        }
                    } else {
                        objInvoke = this.f90452b.get(obj);
                    }
                    if (objInvoke == obj) {
                        return;
                    }
                    jsonWriter.z(this.f90451a);
                    (z6 ? typeAdapter : new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, typeToken.d())).d(jsonWriter, objInvoke);
                }
            }
        };
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x012f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0121 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.Map e(com.google.gson.Gson r22, com.google.gson.reflect.TypeToken r23, java.lang.Class r24, boolean r25, boolean r26) {
        /*
            Method dump skipped, instruction units count: 396
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.e(com.google.gson.Gson, com.google.gson.reflect.TypeToken, java.lang.Class, boolean, boolean):java.util.Map");
    }

    private List f(Field field) {
        SerializedName serializedName = (SerializedName) field.getAnnotation(SerializedName.class);
        if (serializedName == null) {
            return Collections.singletonList(this.f90437b.a(field));
        }
        String strValue = serializedName.value();
        String[] strArrAlternate = serializedName.alternate();
        if (strArrAlternate.length == 0) {
            return Collections.singletonList(strValue);
        }
        ArrayList arrayList = new ArrayList(strArrAlternate.length + 1);
        arrayList.add(strValue);
        Collections.addAll(arrayList, strArrAlternate);
        return arrayList;
    }

    private boolean g(Field field, boolean z2) {
        return (this.f90438c.c(field.getType(), z2) || this.f90438c.h(field, z2)) ? false : true;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public TypeAdapter a(Gson gson, TypeToken typeToken) {
        boolean z2;
        Class clsC = typeToken.c();
        if (!Object.class.isAssignableFrom(clsC)) {
            return null;
        }
        ReflectionAccessFilter.FilterResult filterResultB = ReflectionAccessFilterHelper.b(this.f90440f, clsC);
        if (filterResultB != ReflectionAccessFilter.FilterResult.BLOCK_ALL) {
            if (filterResultB == ReflectionAccessFilter.FilterResult.BLOCK_INACCESSIBLE) {
                z2 = true;
            } else {
                z2 = false;
            }
            boolean z3 = z2;
            if (ReflectionHelper.k(clsC)) {
                return new RecordAdapter(clsC, e(gson, typeToken, clsC, z3, true), z3);
            }
            return new FieldReflectionAdapter(this.f90436a.b(typeToken), e(gson, typeToken, clsC, z3, false));
        }
        throw new JsonIOException(jTYhJgqLBN.uCnjSvNPzGlEOQ + clsC + ". Register a TypeAdapter for this type or adjust the access filter.");
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class FieldReflectionAdapter<T> extends Adapter<T, T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ObjectConstructor f90456b;

        FieldReflectionAdapter(ObjectConstructor objectConstructor, Map map) {
            super(map);
            this.f90456b = objectConstructor;
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        Object e() {
            return this.f90456b.a();
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        void g(Object obj, JsonReader jsonReader, BoundField boundField) {
            boundField.b(jsonReader, obj);
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        Object f(Object obj) {
            return obj;
        }
    }
}
