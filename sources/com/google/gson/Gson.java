package com.google.gson;

import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.internal.Primitives;
import com.google.gson.internal.Streams;
import com.google.gson.internal.bind.ArrayTypeAdapter;
import com.google.gson.internal.bind.CollectionTypeAdapterFactory;
import com.google.gson.internal.bind.DateTypeAdapter;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.internal.bind.NumberTypeAdapter;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.bind.SerializationDelegatingTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.internal.sql.SqlTypesSupport;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class Gson {
    static final FieldNamingStrategy A = FieldNamingPolicy.IDENTITY;
    static final ToNumberStrategy B = ToNumberPolicy.DOUBLE;
    static final ToNumberStrategy C = ToNumberPolicy.LAZILY_PARSED_NUMBER;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    static final String f90241z = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ThreadLocal f90242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConcurrentMap f90243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ConstructorConstructor f90244c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final JsonAdapterAnnotationTypeAdapterFactory f90245d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final List f90246e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Excluder f90247f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final FieldNamingStrategy f90248g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final Map f90249h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final boolean f90250i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final boolean f90251j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final boolean f90252k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final boolean f90253l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final boolean f90254m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final boolean f90255n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    final boolean f90256o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    final boolean f90257p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    final String f90258q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    final int f90259r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    final int f90260s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    final LongSerializationPolicy f90261t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    final List f90262u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    final List f90263v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    final ToNumberStrategy f90264w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    final ToNumberStrategy f90265x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    final List f90266y;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class FutureTypeAdapter<T> extends SerializationDelegatingTypeAdapter<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private TypeAdapter f90271a = null;

        FutureTypeAdapter() {
        }

        private TypeAdapter f() {
            TypeAdapter typeAdapter = this.f90271a;
            if (typeAdapter != null) {
                return typeAdapter;
            }
            throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        }

        @Override // com.google.gson.TypeAdapter
        public Object b(JsonReader jsonReader) {
            return f().b(jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void d(JsonWriter jsonWriter, Object obj) {
            f().d(jsonWriter, obj);
        }

        @Override // com.google.gson.internal.bind.SerializationDelegatingTypeAdapter
        public TypeAdapter e() {
            return f();
        }

        public void g(TypeAdapter typeAdapter) {
            if (this.f90271a != null) {
                throw new AssertionError("Delegate is already set");
            }
            this.f90271a = typeAdapter;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Gson() {
        Excluder excluder = Excluder.f90341h;
        FieldNamingStrategy fieldNamingStrategy = A;
        Map map = Collections.EMPTY_MAP;
        LongSerializationPolicy longSerializationPolicy = LongSerializationPolicy.DEFAULT;
        String str = f90241z;
        List list = Collections.EMPTY_LIST;
        this(excluder, fieldNamingStrategy, map, false, false, false, true, false, false, false, true, longSerializationPolicy, str, 2, 2, list, list, list, B, C, list);
    }

    private static void a(Object obj, JsonReader jsonReader) {
        if (obj != null) {
            try {
                if (jsonReader.j0() == JsonToken.END_DOCUMENT) {
                } else {
                    throw new JsonSyntaxException("JSON document was not fully consumed.");
                }
            } catch (MalformedJsonException e3) {
                throw new JsonSyntaxException(e3);
            } catch (IOException e4) {
                throw new JsonIOException(e4);
            }
        }
    }

    private static TypeAdapter b(final TypeAdapter typeAdapter) {
        return new TypeAdapter<AtomicLong>() { // from class: com.google.gson.Gson.4
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public AtomicLong b(JsonReader jsonReader) {
                return new AtomicLong(((Number) typeAdapter.b(jsonReader)).longValue());
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(JsonWriter jsonWriter, AtomicLong atomicLong) {
                typeAdapter.d(jsonWriter, Long.valueOf(atomicLong.get()));
            }
        }.a();
    }

    private static TypeAdapter c(final TypeAdapter typeAdapter) {
        return new TypeAdapter<AtomicLongArray>() { // from class: com.google.gson.Gson.5
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public AtomicLongArray b(JsonReader jsonReader) throws IOException {
                ArrayList arrayList = new ArrayList();
                jsonReader.a();
                while (jsonReader.r()) {
                    arrayList.add(Long.valueOf(((Number) typeAdapter.b(jsonReader)).longValue()));
                }
                jsonReader.j();
                int size = arrayList.size();
                AtomicLongArray atomicLongArray = new AtomicLongArray(size);
                for (int i3 = 0; i3 < size; i3++) {
                    atomicLongArray.set(i3, ((Long) arrayList.get(i3)).longValue());
                }
                return atomicLongArray;
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(JsonWriter jsonWriter, AtomicLongArray atomicLongArray) throws IOException {
                jsonWriter.c();
                int length = atomicLongArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    typeAdapter.d(jsonWriter, Long.valueOf(atomicLongArray.get(i3)));
                }
                jsonWriter.j();
            }
        }.a();
    }

    static void d(double d3) {
        if (Double.isNaN(d3) || Double.isInfinite(d3)) {
            throw new IllegalArgumentException(d3 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private TypeAdapter e(boolean z2) {
        return z2 ? TypeAdapters.f90499v : new TypeAdapter<Number>() { // from class: com.google.gson.Gson.1
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public Double b(JsonReader jsonReader) throws IOException {
                if (jsonReader.j0() != JsonToken.NULL) {
                    return Double.valueOf(jsonReader.K());
                }
                jsonReader.T();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(JsonWriter jsonWriter, Number number) throws IOException {
                if (number == null) {
                    jsonWriter.F();
                    return;
                }
                double dDoubleValue = number.doubleValue();
                Gson.d(dDoubleValue);
                jsonWriter.g0(dDoubleValue);
            }
        };
    }

    private TypeAdapter f(boolean z2) {
        return z2 ? TypeAdapters.f90498u : new TypeAdapter<Number>() { // from class: com.google.gson.Gson.2
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public Float b(JsonReader jsonReader) throws IOException {
                if (jsonReader.j0() != JsonToken.NULL) {
                    return Float.valueOf((float) jsonReader.K());
                }
                jsonReader.T();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(JsonWriter jsonWriter, Number number) throws IOException {
                if (number == null) {
                    jsonWriter.F();
                    return;
                }
                float fFloatValue = number.floatValue();
                Gson.d(fFloatValue);
                if (!(number instanceof Float)) {
                    number = Float.valueOf(fFloatValue);
                }
                jsonWriter.w0(number);
            }
        };
    }

    private static TypeAdapter o(LongSerializationPolicy longSerializationPolicy) {
        return longSerializationPolicy == LongSerializationPolicy.DEFAULT ? TypeAdapters.f90497t : new TypeAdapter<Number>() { // from class: com.google.gson.Gson.3
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public Number b(JsonReader jsonReader) throws IOException {
                if (jsonReader.j0() != JsonToken.NULL) {
                    return Long.valueOf(jsonReader.M());
                }
                jsonReader.T();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(JsonWriter jsonWriter, Number number) throws IOException {
                if (number == null) {
                    jsonWriter.F();
                } else {
                    jsonWriter.z0(number.toString());
                }
            }
        };
    }

    public Object g(JsonReader jsonReader, TypeToken typeToken) {
        boolean z2 = jsonReader.z();
        boolean z3 = true;
        jsonReader.O0(true);
        try {
            try {
                try {
                    jsonReader.j0();
                    z3 = false;
                    return l(typeToken).b(jsonReader);
                } catch (AssertionError e3) {
                    throw new AssertionError("AssertionError (GSON 2.10.1): " + e3.getMessage(), e3);
                } catch (IllegalStateException e4) {
                    throw new JsonSyntaxException(e4);
                }
            } catch (EOFException e5) {
                if (!z3) {
                    throw new JsonSyntaxException(e5);
                }
                jsonReader.O0(z2);
                return null;
            } catch (IOException e6) {
                throw new JsonSyntaxException(e6);
            }
        } finally {
            jsonReader.O0(z2);
        }
    }

    public Object h(Reader reader, TypeToken typeToken) {
        JsonReader jsonReaderP = p(reader);
        Object objG = g(jsonReaderP, typeToken);
        a(objG, jsonReaderP);
        return objG;
    }

    public Object i(String str, TypeToken typeToken) {
        if (str == null) {
            return null;
        }
        return h(new StringReader(str), typeToken);
    }

    public Object j(String str, Class cls) {
        return Primitives.b(cls).cast(i(str, TypeToken.a(cls)));
    }

    public Object k(String str, Type type) {
        return i(str, TypeToken.b(type));
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0051, code lost:
    
        r2.g(r4);
        r0.put(r7, r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.google.gson.TypeAdapter l(com.google.gson.reflect.TypeToken r7) {
        /*
            r6 = this;
            java.lang.String r0 = "type must not be null"
            java.util.Objects.requireNonNull(r7, r0)
            java.util.concurrent.ConcurrentMap r0 = r6.f90243b
            java.lang.Object r0 = r0.get(r7)
            com.google.gson.TypeAdapter r0 = (com.google.gson.TypeAdapter) r0
            if (r0 == 0) goto L10
            return r0
        L10:
            java.lang.ThreadLocal r0 = r6.f90242a
            java.lang.Object r0 = r0.get()
            java.util.Map r0 = (java.util.Map) r0
            if (r0 != 0) goto L26
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.ThreadLocal r1 = r6.f90242a
            r1.set(r0)
            r1 = 1
            goto L30
        L26:
            java.lang.Object r1 = r0.get(r7)
            com.google.gson.TypeAdapter r1 = (com.google.gson.TypeAdapter) r1
            if (r1 == 0) goto L2f
            return r1
        L2f:
            r1 = 0
        L30:
            com.google.gson.Gson$FutureTypeAdapter r2 = new com.google.gson.Gson$FutureTypeAdapter     // Catch: java.lang.Throwable -> L58
            r2.<init>()     // Catch: java.lang.Throwable -> L58
            r0.put(r7, r2)     // Catch: java.lang.Throwable -> L58
            java.util.List r3 = r6.f90246e     // Catch: java.lang.Throwable -> L58
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L58
            r4 = 0
        L3f:
            boolean r5 = r3.hasNext()     // Catch: java.lang.Throwable -> L58
            if (r5 == 0) goto L5a
            java.lang.Object r4 = r3.next()     // Catch: java.lang.Throwable -> L58
            com.google.gson.TypeAdapterFactory r4 = (com.google.gson.TypeAdapterFactory) r4     // Catch: java.lang.Throwable -> L58
            com.google.gson.TypeAdapter r4 = r4.a(r6, r7)     // Catch: java.lang.Throwable -> L58
            if (r4 == 0) goto L3f
            r2.g(r4)     // Catch: java.lang.Throwable -> L58
            r0.put(r7, r4)     // Catch: java.lang.Throwable -> L58
            goto L5a
        L58:
            r7 = move-exception
            goto L82
        L5a:
            if (r1 == 0) goto L61
            java.lang.ThreadLocal r2 = r6.f90242a
            r2.remove()
        L61:
            if (r4 == 0) goto L6b
            if (r1 == 0) goto L6a
            java.util.concurrent.ConcurrentMap r7 = r6.f90243b
            r7.putAll(r0)
        L6a:
            return r4
        L6b:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "GSON (2.10.1) cannot handle "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            r0.<init>(r7)
            throw r0
        L82:
            if (r1 == 0) goto L89
            java.lang.ThreadLocal r0 = r6.f90242a
            r0.remove()
        L89:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.Gson.l(com.google.gson.reflect.TypeToken):com.google.gson.TypeAdapter");
    }

    public TypeAdapter m(Class cls) {
        return l(TypeToken.a(cls));
    }

    public TypeAdapter n(TypeAdapterFactory typeAdapterFactory, TypeToken typeToken) {
        if (!this.f90246e.contains(typeAdapterFactory)) {
            typeAdapterFactory = this.f90245d;
        }
        boolean z2 = false;
        for (TypeAdapterFactory typeAdapterFactory2 : this.f90246e) {
            if (z2) {
                TypeAdapter typeAdapterA = typeAdapterFactory2.a(this, typeToken);
                if (typeAdapterA != null) {
                    return typeAdapterA;
                }
            } else if (typeAdapterFactory2 == typeAdapterFactory) {
                z2 = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + typeToken);
    }

    public JsonReader p(Reader reader) {
        JsonReader jsonReader = new JsonReader(reader);
        jsonReader.O0(this.f90255n);
        return jsonReader;
    }

    public JsonWriter q(Writer writer) throws IOException {
        if (this.f90252k) {
            writer.write(")]}'\n");
        }
        JsonWriter jsonWriter = new JsonWriter(writer);
        if (this.f90254m) {
            jsonWriter.O("  ");
        }
        jsonWriter.N(this.f90253l);
        jsonWriter.T(this.f90255n);
        jsonWriter.V(this.f90250i);
        return jsonWriter;
    }

    public String r(JsonElement jsonElement) {
        StringWriter stringWriter = new StringWriter();
        v(jsonElement, stringWriter);
        return stringWriter.toString();
    }

    public String s(Object obj) {
        return obj == null ? r(JsonNull.f90293a) : t(obj, obj.getClass());
    }

    public String t(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        x(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public String toString() {
        return "{serializeNulls:" + this.f90250i + ",factories:" + this.f90246e + ",instanceCreators:" + this.f90244c + "}";
    }

    public void u(JsonElement jsonElement, JsonWriter jsonWriter) {
        boolean zN = jsonWriter.n();
        jsonWriter.T(true);
        boolean zM = jsonWriter.m();
        jsonWriter.N(this.f90253l);
        boolean zL = jsonWriter.l();
        jsonWriter.V(this.f90250i);
        try {
            try {
                Streams.b(jsonElement, jsonWriter);
            } catch (IOException e3) {
                throw new JsonIOException(e3);
            } catch (AssertionError e4) {
                throw new AssertionError("AssertionError (GSON 2.10.1): " + e4.getMessage(), e4);
            }
        } finally {
            jsonWriter.T(zN);
            jsonWriter.N(zM);
            jsonWriter.V(zL);
        }
    }

    public void v(JsonElement jsonElement, Appendable appendable) {
        try {
            u(jsonElement, q(Streams.c(appendable)));
        } catch (IOException e3) {
            throw new JsonIOException(e3);
        }
    }

    public void w(Object obj, Type type, JsonWriter jsonWriter) {
        TypeAdapter typeAdapterL = l(TypeToken.b(type));
        boolean zN = jsonWriter.n();
        jsonWriter.T(true);
        boolean zM = jsonWriter.m();
        jsonWriter.N(this.f90253l);
        boolean zL = jsonWriter.l();
        jsonWriter.V(this.f90250i);
        try {
            try {
                typeAdapterL.d(jsonWriter, obj);
            } catch (IOException e3) {
                throw new JsonIOException(e3);
            } catch (AssertionError e4) {
                throw new AssertionError("AssertionError (GSON 2.10.1): " + e4.getMessage(), e4);
            }
        } finally {
            jsonWriter.T(zN);
            jsonWriter.N(zM);
            jsonWriter.V(zL);
        }
    }

    public void x(Object obj, Type type, Appendable appendable) {
        try {
            w(obj, type, q(Streams.c(appendable)));
        } catch (IOException e3) {
            throw new JsonIOException(e3);
        }
    }

    Gson(Excluder excluder, FieldNamingStrategy fieldNamingStrategy, Map map, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, LongSerializationPolicy longSerializationPolicy, String str, int i3, int i4, List list, List list2, List list3, ToNumberStrategy toNumberStrategy, ToNumberStrategy toNumberStrategy2, List list4) {
        this.f90242a = new ThreadLocal();
        this.f90243b = new ConcurrentHashMap();
        this.f90247f = excluder;
        this.f90248g = fieldNamingStrategy;
        this.f90249h = map;
        ConstructorConstructor constructorConstructor = new ConstructorConstructor(map, z9, list4);
        this.f90244c = constructorConstructor;
        this.f90250i = z2;
        this.f90251j = z3;
        this.f90252k = z4;
        this.f90253l = z5;
        this.f90254m = z6;
        this.f90255n = z7;
        this.f90256o = z8;
        this.f90257p = z9;
        this.f90261t = longSerializationPolicy;
        this.f90258q = str;
        this.f90259r = i3;
        this.f90260s = i4;
        this.f90262u = list;
        this.f90263v = list2;
        this.f90264w = toNumberStrategy;
        this.f90265x = toNumberStrategy2;
        this.f90266y = list4;
        ArrayList arrayList = new ArrayList();
        arrayList.add(TypeAdapters.W);
        arrayList.add(ObjectTypeAdapter.e(toNumberStrategy));
        arrayList.add(excluder);
        arrayList.addAll(list3);
        arrayList.add(TypeAdapters.C);
        arrayList.add(TypeAdapters.f90490m);
        arrayList.add(TypeAdapters.f90484g);
        arrayList.add(TypeAdapters.f90486i);
        arrayList.add(TypeAdapters.f90488k);
        TypeAdapter typeAdapterO = o(longSerializationPolicy);
        arrayList.add(TypeAdapters.c(Long.TYPE, Long.class, typeAdapterO));
        arrayList.add(TypeAdapters.c(Double.TYPE, Double.class, e(z8)));
        arrayList.add(TypeAdapters.c(Float.TYPE, Float.class, f(z8)));
        arrayList.add(NumberTypeAdapter.e(toNumberStrategy2));
        arrayList.add(TypeAdapters.f90492o);
        arrayList.add(TypeAdapters.f90494q);
        arrayList.add(TypeAdapters.b(AtomicLong.class, b(typeAdapterO)));
        arrayList.add(TypeAdapters.b(AtomicLongArray.class, c(typeAdapterO)));
        arrayList.add(TypeAdapters.f90496s);
        arrayList.add(TypeAdapters.f90501x);
        arrayList.add(TypeAdapters.E);
        arrayList.add(TypeAdapters.G);
        arrayList.add(TypeAdapters.b(BigDecimal.class, TypeAdapters.f90503z));
        arrayList.add(TypeAdapters.b(BigInteger.class, TypeAdapters.A));
        arrayList.add(TypeAdapters.b(LazilyParsedNumber.class, TypeAdapters.B));
        arrayList.add(TypeAdapters.I);
        arrayList.add(TypeAdapters.K);
        arrayList.add(TypeAdapters.O);
        arrayList.add(TypeAdapters.Q);
        arrayList.add(TypeAdapters.U);
        arrayList.add(TypeAdapters.M);
        arrayList.add(TypeAdapters.f90481d);
        arrayList.add(DateTypeAdapter.f90402b);
        arrayList.add(TypeAdapters.S);
        if (SqlTypesSupport.f90536a) {
            arrayList.add(SqlTypesSupport.f90540e);
            arrayList.add(SqlTypesSupport.f90539d);
            arrayList.add(SqlTypesSupport.f90541f);
        }
        arrayList.add(ArrayTypeAdapter.f90396c);
        arrayList.add(TypeAdapters.f90479b);
        arrayList.add(new CollectionTypeAdapterFactory(constructorConstructor));
        arrayList.add(new MapTypeAdapterFactory(constructorConstructor, z3));
        JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory = new JsonAdapterAnnotationTypeAdapterFactory(constructorConstructor);
        this.f90245d = jsonAdapterAnnotationTypeAdapterFactory;
        arrayList.add(jsonAdapterAnnotationTypeAdapterFactory);
        arrayList.add(TypeAdapters.X);
        arrayList.add(new ReflectiveTypeAdapterFactory(constructorConstructor, fieldNamingStrategy, excluder, jsonAdapterAnnotationTypeAdapterFactory, list4));
        this.f90246e = Collections.unmodifiableList(arrayList);
    }
}
