package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class TypeAdapters {
    public static final TypeAdapter A;
    public static final TypeAdapter B;
    public static final TypeAdapterFactory C;
    public static final TypeAdapter D;
    public static final TypeAdapterFactory E;
    public static final TypeAdapter F;
    public static final TypeAdapterFactory G;
    public static final TypeAdapter H;
    public static final TypeAdapterFactory I;
    public static final TypeAdapter J;
    public static final TypeAdapterFactory K;
    public static final TypeAdapter L;
    public static final TypeAdapterFactory M;
    public static final TypeAdapter N;
    public static final TypeAdapterFactory O;
    public static final TypeAdapter P;
    public static final TypeAdapterFactory Q;
    public static final TypeAdapter R;
    public static final TypeAdapterFactory S;
    public static final TypeAdapter T;
    public static final TypeAdapterFactory U;
    public static final TypeAdapter V;
    public static final TypeAdapterFactory W;
    public static final TypeAdapterFactory X;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TypeAdapter f90478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final TypeAdapterFactory f90479b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final TypeAdapter f90480c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final TypeAdapterFactory f90481d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final TypeAdapter f90482e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final TypeAdapter f90483f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final TypeAdapterFactory f90484g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final TypeAdapter f90485h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final TypeAdapterFactory f90486i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final TypeAdapter f90487j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final TypeAdapterFactory f90488k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final TypeAdapter f90489l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final TypeAdapterFactory f90490m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final TypeAdapter f90491n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final TypeAdapterFactory f90492o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final TypeAdapter f90493p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final TypeAdapterFactory f90494q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final TypeAdapter f90495r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final TypeAdapterFactory f90496s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final TypeAdapter f90497t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final TypeAdapter f90498u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final TypeAdapter f90499v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final TypeAdapter f90500w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final TypeAdapterFactory f90501x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final TypeAdapter f90502y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final TypeAdapter f90503z;

    /* JADX INFO: renamed from: com.google.gson.internal.bind.TypeAdapters$35, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass35 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f90518a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            f90518a = iArr;
            try {
                iArr[JsonToken.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f90518a[JsonToken.STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f90518a[JsonToken.BOOLEAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f90518a[JsonToken.BEGIN_ARRAY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f90518a[JsonToken.BEGIN_OBJECT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f90518a[JsonToken.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class EnumTypeAdapter<T extends Enum<T>> extends TypeAdapter<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map f90519a = new HashMap();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map f90520b = new HashMap();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Map f90521c = new HashMap();

        public EnumTypeAdapter(final Class cls) {
            try {
                for (Field field : (Field[]) AccessController.doPrivileged(new PrivilegedAction<Field[]>() { // from class: com.google.gson.internal.bind.TypeAdapters.EnumTypeAdapter.1
                    @Override // java.security.PrivilegedAction
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public Field[] run() {
                        Field[] declaredFields = cls.getDeclaredFields();
                        ArrayList arrayList = new ArrayList(declaredFields.length);
                        for (Field field2 : declaredFields) {
                            if (field2.isEnumConstant()) {
                                arrayList.add(field2);
                            }
                        }
                        Field[] fieldArr = (Field[]) arrayList.toArray(new Field[0]);
                        AccessibleObject.setAccessible(fieldArr, true);
                        return fieldArr;
                    }
                })) {
                    Enum r4 = (Enum) field.get(null);
                    String strName = r4.name();
                    String string = r4.toString();
                    SerializedName serializedName = (SerializedName) field.getAnnotation(SerializedName.class);
                    if (serializedName != null) {
                        strName = serializedName.value();
                        for (String str : serializedName.alternate()) {
                            this.f90519a.put(str, r4);
                        }
                    }
                    this.f90519a.put(strName, r4);
                    this.f90520b.put(string, r4);
                    this.f90521c.put(r4, strName);
                }
            } catch (IllegalAccessException e3) {
                throw new AssertionError(e3);
            }
        }

        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Enum b(JsonReader jsonReader) throws IOException {
            if (jsonReader.j0() == JsonToken.NULL) {
                jsonReader.T();
                return null;
            }
            String strE0 = jsonReader.e0();
            Enum r02 = (Enum) this.f90519a.get(strE0);
            return r02 == null ? (Enum) this.f90520b.get(strE0) : r02;
        }

        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(JsonWriter jsonWriter, Enum r3) throws IOException {
            jsonWriter.z0(r3 == null ? null : (String) this.f90521c.get(r3));
        }
    }

    static {
        TypeAdapter typeAdapterA = new TypeAdapter<Class>() { // from class: com.google.gson.internal.bind.TypeAdapters.1
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public Class b(JsonReader jsonReader) {
                throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(JsonWriter jsonWriter, Class cls) {
                throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
            }
        }.a();
        f90478a = typeAdapterA;
        f90479b = b(Class.class, typeAdapterA);
        TypeAdapter typeAdapterA2 = new TypeAdapter<BitSet>() { // from class: com.google.gson.internal.bind.TypeAdapters.2
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public BitSet b(JsonReader jsonReader) throws IOException {
                BitSet bitSet = new BitSet();
                jsonReader.a();
                JsonToken jsonTokenJ0 = jsonReader.j0();
                int i3 = 0;
                while (jsonTokenJ0 != JsonToken.END_ARRAY) {
                    int i4 = AnonymousClass35.f90518a[jsonTokenJ0.ordinal()];
                    boolean zJ = true;
                    if (i4 == 1 || i4 == 2) {
                        int iL = jsonReader.L();
                        if (iL == 0) {
                            zJ = false;
                        } else if (iL != 1) {
                            throw new JsonSyntaxException("Invalid bitset value " + iL + ", expected 0 or 1; at path " + jsonReader.n());
                        }
                    } else {
                        if (i4 != 3) {
                            throw new JsonSyntaxException("Invalid bitset value type: " + jsonTokenJ0 + "; at path " + jsonReader.g());
                        }
                        zJ = jsonReader.J();
                    }
                    if (zJ) {
                        bitSet.set(i3);
                    }
                    i3++;
                    jsonTokenJ0 = jsonReader.j0();
                }
                jsonReader.j();
                return bitSet;
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(JsonWriter jsonWriter, BitSet bitSet) throws IOException {
                jsonWriter.c();
                int length = bitSet.length();
                for (int i3 = 0; i3 < length; i3++) {
                    jsonWriter.j0(bitSet.get(i3) ? 1L : 0L);
                }
                jsonWriter.j();
            }
        }.a();
        f90480c = typeAdapterA2;
        f90481d = b(BitSet.class, typeAdapterA2);
        TypeAdapter<Boolean> typeAdapter = new TypeAdapter<Boolean>() { // from class: com.google.gson.internal.bind.TypeAdapters.3
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public Boolean b(JsonReader jsonReader) throws IOException {
                JsonToken jsonTokenJ0 = jsonReader.j0();
                if (jsonTokenJ0 != JsonToken.NULL) {
                    return jsonTokenJ0 == JsonToken.STRING ? Boolean.valueOf(Boolean.parseBoolean(jsonReader.e0())) : Boolean.valueOf(jsonReader.J());
                }
                jsonReader.T();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(JsonWriter jsonWriter, Boolean bool) throws IOException {
                jsonWriter.q0(bool);
            }
        };
        f90482e = typeAdapter;
        f90483f = new TypeAdapter<Boolean>() { // from class: com.google.gson.internal.bind.TypeAdapters.4
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public Boolean b(JsonReader jsonReader) throws IOException {
                if (jsonReader.j0() != JsonToken.NULL) {
                    return Boolean.valueOf(jsonReader.e0());
                }
                jsonReader.T();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(JsonWriter jsonWriter, Boolean bool) throws IOException {
                jsonWriter.z0(bool == null ? "null" : bool.toString());
            }
        };
        f90484g = c(Boolean.TYPE, Boolean.class, typeAdapter);
        TypeAdapter<Number> typeAdapter2 = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.5
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public Number b(JsonReader jsonReader) throws IOException {
                if (jsonReader.j0() == JsonToken.NULL) {
                    jsonReader.T();
                    return null;
                }
                try {
                    int iL = jsonReader.L();
                    if (iL <= 255 && iL >= -128) {
                        return Byte.valueOf((byte) iL);
                    }
                    throw new JsonSyntaxException("Lossy conversion from " + iL + " to byte; at path " + jsonReader.n());
                } catch (NumberFormatException e3) {
                    throw new JsonSyntaxException(e3);
                }
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(JsonWriter jsonWriter, Number number) throws IOException {
                if (number == null) {
                    jsonWriter.F();
                } else {
                    jsonWriter.j0(number.byteValue());
                }
            }
        };
        f90485h = typeAdapter2;
        f90486i = c(Byte.TYPE, Byte.class, typeAdapter2);
        TypeAdapter<Number> typeAdapter3 = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.6
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public Number b(JsonReader jsonReader) throws IOException {
                if (jsonReader.j0() == JsonToken.NULL) {
                    jsonReader.T();
                    return null;
                }
                try {
                    int iL = jsonReader.L();
                    if (iL <= 65535 && iL >= -32768) {
                        return Short.valueOf((short) iL);
                    }
                    throw new JsonSyntaxException("Lossy conversion from " + iL + " to short; at path " + jsonReader.n());
                } catch (NumberFormatException e3) {
                    throw new JsonSyntaxException(e3);
                }
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(JsonWriter jsonWriter, Number number) throws IOException {
                if (number == null) {
                    jsonWriter.F();
                } else {
                    jsonWriter.j0(number.shortValue());
                }
            }
        };
        f90487j = typeAdapter3;
        f90488k = c(Short.TYPE, Short.class, typeAdapter3);
        TypeAdapter<Number> typeAdapter4 = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.7
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public Number b(JsonReader jsonReader) throws IOException {
                if (jsonReader.j0() == JsonToken.NULL) {
                    jsonReader.T();
                    return null;
                }
                try {
                    return Integer.valueOf(jsonReader.L());
                } catch (NumberFormatException e3) {
                    throw new JsonSyntaxException(e3);
                }
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(JsonWriter jsonWriter, Number number) throws IOException {
                if (number == null) {
                    jsonWriter.F();
                } else {
                    jsonWriter.j0(number.intValue());
                }
            }
        };
        f90489l = typeAdapter4;
        f90490m = c(Integer.TYPE, Integer.class, typeAdapter4);
        TypeAdapter typeAdapterA3 = new TypeAdapter<AtomicInteger>() { // from class: com.google.gson.internal.bind.TypeAdapters.8
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public AtomicInteger b(JsonReader jsonReader) {
                try {
                    return new AtomicInteger(jsonReader.L());
                } catch (NumberFormatException e3) {
                    throw new JsonSyntaxException(e3);
                }
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(JsonWriter jsonWriter, AtomicInteger atomicInteger) throws IOException {
                jsonWriter.j0(atomicInteger.get());
            }
        }.a();
        f90491n = typeAdapterA3;
        f90492o = b(AtomicInteger.class, typeAdapterA3);
        TypeAdapter typeAdapterA4 = new TypeAdapter<AtomicBoolean>() { // from class: com.google.gson.internal.bind.TypeAdapters.9
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public AtomicBoolean b(JsonReader jsonReader) {
                return new AtomicBoolean(jsonReader.J());
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(JsonWriter jsonWriter, AtomicBoolean atomicBoolean) throws IOException {
                jsonWriter.A0(atomicBoolean.get());
            }
        }.a();
        f90493p = typeAdapterA4;
        f90494q = b(AtomicBoolean.class, typeAdapterA4);
        TypeAdapter typeAdapterA5 = new TypeAdapter<AtomicIntegerArray>() { // from class: com.google.gson.internal.bind.TypeAdapters.10
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public AtomicIntegerArray b(JsonReader jsonReader) throws IOException {
                ArrayList arrayList = new ArrayList();
                jsonReader.a();
                while (jsonReader.r()) {
                    try {
                        arrayList.add(Integer.valueOf(jsonReader.L()));
                    } catch (NumberFormatException e3) {
                        throw new JsonSyntaxException(e3);
                    }
                }
                jsonReader.j();
                int size = arrayList.size();
                AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
                for (int i3 = 0; i3 < size; i3++) {
                    atomicIntegerArray.set(i3, ((Integer) arrayList.get(i3)).intValue());
                }
                return atomicIntegerArray;
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(JsonWriter jsonWriter, AtomicIntegerArray atomicIntegerArray) throws IOException {
                jsonWriter.c();
                int length = atomicIntegerArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    jsonWriter.j0(atomicIntegerArray.get(i3));
                }
                jsonWriter.j();
            }
        }.a();
        f90495r = typeAdapterA5;
        f90496s = b(AtomicIntegerArray.class, typeAdapterA5);
        f90497t = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.11
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public Number b(JsonReader jsonReader) throws IOException {
                if (jsonReader.j0() == JsonToken.NULL) {
                    jsonReader.T();
                    return null;
                }
                try {
                    return Long.valueOf(jsonReader.M());
                } catch (NumberFormatException e3) {
                    throw new JsonSyntaxException(e3);
                }
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(JsonWriter jsonWriter, Number number) throws IOException {
                if (number == null) {
                    jsonWriter.F();
                } else {
                    jsonWriter.j0(number.longValue());
                }
            }
        };
        f90498u = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.12
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public Number b(JsonReader jsonReader) throws IOException {
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
                if (!(number instanceof Float)) {
                    number = Float.valueOf(number.floatValue());
                }
                jsonWriter.w0(number);
            }
        };
        f90499v = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.13
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public Number b(JsonReader jsonReader) throws IOException {
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
                } else {
                    jsonWriter.g0(number.doubleValue());
                }
            }
        };
        TypeAdapter<Character> typeAdapter5 = new TypeAdapter<Character>() { // from class: com.google.gson.internal.bind.TypeAdapters.14
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public Character b(JsonReader jsonReader) throws IOException {
                if (jsonReader.j0() == JsonToken.NULL) {
                    jsonReader.T();
                    return null;
                }
                String strE0 = jsonReader.e0();
                if (strE0.length() == 1) {
                    return Character.valueOf(strE0.charAt(0));
                }
                throw new JsonSyntaxException("Expecting character, got: " + strE0 + "; at " + jsonReader.n());
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(JsonWriter jsonWriter, Character ch) throws IOException {
                jsonWriter.z0(ch == null ? null : String.valueOf(ch));
            }
        };
        f90500w = typeAdapter5;
        f90501x = c(Character.TYPE, Character.class, typeAdapter5);
        TypeAdapter<String> typeAdapter6 = new TypeAdapter<String>() { // from class: com.google.gson.internal.bind.TypeAdapters.15
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public String b(JsonReader jsonReader) throws IOException {
                JsonToken jsonTokenJ0 = jsonReader.j0();
                if (jsonTokenJ0 != JsonToken.NULL) {
                    return jsonTokenJ0 == JsonToken.BOOLEAN ? Boolean.toString(jsonReader.J()) : jsonReader.e0();
                }
                jsonReader.T();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(JsonWriter jsonWriter, String str) throws IOException {
                jsonWriter.z0(str);
            }
        };
        f90502y = typeAdapter6;
        f90503z = new TypeAdapter<BigDecimal>() { // from class: com.google.gson.internal.bind.TypeAdapters.16
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public BigDecimal b(JsonReader jsonReader) throws IOException {
                if (jsonReader.j0() == JsonToken.NULL) {
                    jsonReader.T();
                    return null;
                }
                String strE0 = jsonReader.e0();
                try {
                    return new BigDecimal(strE0);
                } catch (NumberFormatException e3) {
                    throw new JsonSyntaxException("Failed parsing '" + strE0 + "' as BigDecimal; at path " + jsonReader.n(), e3);
                }
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(JsonWriter jsonWriter, BigDecimal bigDecimal) throws IOException {
                jsonWriter.w0(bigDecimal);
            }
        };
        A = new TypeAdapter<BigInteger>() { // from class: com.google.gson.internal.bind.TypeAdapters.17
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public BigInteger b(JsonReader jsonReader) throws IOException {
                if (jsonReader.j0() == JsonToken.NULL) {
                    jsonReader.T();
                    return null;
                }
                String strE0 = jsonReader.e0();
                try {
                    return new BigInteger(strE0);
                } catch (NumberFormatException e3) {
                    throw new JsonSyntaxException("Failed parsing '" + strE0 + "' as BigInteger; at path " + jsonReader.n(), e3);
                }
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(JsonWriter jsonWriter, BigInteger bigInteger) throws IOException {
                jsonWriter.w0(bigInteger);
            }
        };
        B = new TypeAdapter<LazilyParsedNumber>() { // from class: com.google.gson.internal.bind.TypeAdapters.18
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public LazilyParsedNumber b(JsonReader jsonReader) throws IOException {
                if (jsonReader.j0() != JsonToken.NULL) {
                    return new LazilyParsedNumber(jsonReader.e0());
                }
                jsonReader.T();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(JsonWriter jsonWriter, LazilyParsedNumber lazilyParsedNumber) throws IOException {
                jsonWriter.w0(lazilyParsedNumber);
            }
        };
        C = b(String.class, typeAdapter6);
        TypeAdapter<StringBuilder> typeAdapter7 = new TypeAdapter<StringBuilder>() { // from class: com.google.gson.internal.bind.TypeAdapters.19
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public StringBuilder b(JsonReader jsonReader) throws IOException {
                if (jsonReader.j0() != JsonToken.NULL) {
                    return new StringBuilder(jsonReader.e0());
                }
                jsonReader.T();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(JsonWriter jsonWriter, StringBuilder sb) throws IOException {
                jsonWriter.z0(sb == null ? null : sb.toString());
            }
        };
        D = typeAdapter7;
        E = b(StringBuilder.class, typeAdapter7);
        TypeAdapter<StringBuffer> typeAdapter8 = new TypeAdapter<StringBuffer>() { // from class: com.google.gson.internal.bind.TypeAdapters.20
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public StringBuffer b(JsonReader jsonReader) throws IOException {
                if (jsonReader.j0() != JsonToken.NULL) {
                    return new StringBuffer(jsonReader.e0());
                }
                jsonReader.T();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(JsonWriter jsonWriter, StringBuffer stringBuffer) throws IOException {
                jsonWriter.z0(stringBuffer == null ? null : stringBuffer.toString());
            }
        };
        F = typeAdapter8;
        G = b(StringBuffer.class, typeAdapter8);
        TypeAdapter<URL> typeAdapter9 = new TypeAdapter<URL>() { // from class: com.google.gson.internal.bind.TypeAdapters.21
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public URL b(JsonReader jsonReader) throws IOException {
                if (jsonReader.j0() == JsonToken.NULL) {
                    jsonReader.T();
                    return null;
                }
                String strE0 = jsonReader.e0();
                if ("null".equals(strE0)) {
                    return null;
                }
                return new URL(strE0);
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(JsonWriter jsonWriter, URL url) throws IOException {
                jsonWriter.z0(url == null ? null : url.toExternalForm());
            }
        };
        H = typeAdapter9;
        I = b(URL.class, typeAdapter9);
        TypeAdapter<URI> typeAdapter10 = new TypeAdapter<URI>() { // from class: com.google.gson.internal.bind.TypeAdapters.22
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public URI b(JsonReader jsonReader) throws IOException {
                if (jsonReader.j0() == JsonToken.NULL) {
                    jsonReader.T();
                    return null;
                }
                try {
                    String strE0 = jsonReader.e0();
                    if ("null".equals(strE0)) {
                        return null;
                    }
                    return new URI(strE0);
                } catch (URISyntaxException e3) {
                    throw new JsonIOException(e3);
                }
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(JsonWriter jsonWriter, URI uri) throws IOException {
                jsonWriter.z0(uri == null ? null : uri.toASCIIString());
            }
        };
        J = typeAdapter10;
        K = b(URI.class, typeAdapter10);
        TypeAdapter<InetAddress> typeAdapter11 = new TypeAdapter<InetAddress>() { // from class: com.google.gson.internal.bind.TypeAdapters.23
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public InetAddress b(JsonReader jsonReader) throws IOException {
                if (jsonReader.j0() != JsonToken.NULL) {
                    return InetAddress.getByName(jsonReader.e0());
                }
                jsonReader.T();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(JsonWriter jsonWriter, InetAddress inetAddress) throws IOException {
                jsonWriter.z0(inetAddress == null ? null : inetAddress.getHostAddress());
            }
        };
        L = typeAdapter11;
        M = e(InetAddress.class, typeAdapter11);
        TypeAdapter<UUID> typeAdapter12 = new TypeAdapter<UUID>() { // from class: com.google.gson.internal.bind.TypeAdapters.24
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public UUID b(JsonReader jsonReader) throws IOException {
                if (jsonReader.j0() == JsonToken.NULL) {
                    jsonReader.T();
                    return null;
                }
                String strE0 = jsonReader.e0();
                try {
                    return UUID.fromString(strE0);
                } catch (IllegalArgumentException e3) {
                    throw new JsonSyntaxException("Failed parsing '" + strE0 + "' as UUID; at path " + jsonReader.n(), e3);
                }
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(JsonWriter jsonWriter, UUID uuid) throws IOException {
                jsonWriter.z0(uuid == null ? null : uuid.toString());
            }
        };
        N = typeAdapter12;
        O = b(UUID.class, typeAdapter12);
        TypeAdapter typeAdapterA6 = new TypeAdapter<Currency>() { // from class: com.google.gson.internal.bind.TypeAdapters.25
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public Currency b(JsonReader jsonReader) throws IOException {
                String strE0 = jsonReader.e0();
                try {
                    return Currency.getInstance(strE0);
                } catch (IllegalArgumentException e3) {
                    throw new JsonSyntaxException("Failed parsing '" + strE0 + "' as Currency; at path " + jsonReader.n(), e3);
                }
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(JsonWriter jsonWriter, Currency currency) throws IOException {
                jsonWriter.z0(currency.getCurrencyCode());
            }
        }.a();
        P = typeAdapterA6;
        Q = b(Currency.class, typeAdapterA6);
        TypeAdapter<Calendar> typeAdapter13 = new TypeAdapter<Calendar>() { // from class: com.google.gson.internal.bind.TypeAdapters.26
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public Calendar b(JsonReader jsonReader) throws IOException {
                if (jsonReader.j0() == JsonToken.NULL) {
                    jsonReader.T();
                    return null;
                }
                jsonReader.b();
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                int i8 = 0;
                while (jsonReader.j0() != JsonToken.END_OBJECT) {
                    String strN = jsonReader.N();
                    int iL = jsonReader.L();
                    if ("year".equals(strN)) {
                        i3 = iL;
                    } else if ("month".equals(strN)) {
                        i4 = iL;
                    } else if ("dayOfMonth".equals(strN)) {
                        i5 = iL;
                    } else if ("hourOfDay".equals(strN)) {
                        i6 = iL;
                    } else if ("minute".equals(strN)) {
                        i7 = iL;
                    } else if ("second".equals(strN)) {
                        i8 = iL;
                    }
                }
                jsonReader.k();
                return new GregorianCalendar(i3, i4, i5, i6, i7, i8);
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(JsonWriter jsonWriter, Calendar calendar) throws IOException {
                if (calendar == null) {
                    jsonWriter.F();
                    return;
                }
                jsonWriter.f();
                jsonWriter.z("year");
                jsonWriter.j0(calendar.get(1));
                jsonWriter.z("month");
                jsonWriter.j0(calendar.get(2));
                jsonWriter.z("dayOfMonth");
                jsonWriter.j0(calendar.get(5));
                jsonWriter.z("hourOfDay");
                jsonWriter.j0(calendar.get(11));
                jsonWriter.z("minute");
                jsonWriter.j0(calendar.get(12));
                jsonWriter.z("second");
                jsonWriter.j0(calendar.get(13));
                jsonWriter.k();
            }
        };
        R = typeAdapter13;
        S = d(Calendar.class, GregorianCalendar.class, typeAdapter13);
        TypeAdapter<Locale> typeAdapter14 = new TypeAdapter<Locale>() { // from class: com.google.gson.internal.bind.TypeAdapters.27
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public Locale b(JsonReader jsonReader) throws IOException {
                if (jsonReader.j0() == JsonToken.NULL) {
                    jsonReader.T();
                    return null;
                }
                StringTokenizer stringTokenizer = new StringTokenizer(jsonReader.e0(), "_");
                String strNextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                String strNextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                String strNextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                return (strNextToken2 == null && strNextToken3 == null) ? new Locale(strNextToken) : strNextToken3 == null ? new Locale(strNextToken, strNextToken2) : new Locale(strNextToken, strNextToken2, strNextToken3);
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(JsonWriter jsonWriter, Locale locale) throws IOException {
                jsonWriter.z0(locale == null ? null : locale.toString());
            }
        };
        T = typeAdapter14;
        U = b(Locale.class, typeAdapter14);
        TypeAdapter<JsonElement> typeAdapter15 = new TypeAdapter<JsonElement>() { // from class: com.google.gson.internal.bind.TypeAdapters.28
            private JsonElement f(JsonReader jsonReader, JsonToken jsonToken) throws IOException {
                int i3 = AnonymousClass35.f90518a[jsonToken.ordinal()];
                if (i3 == 1) {
                    return new JsonPrimitive(new LazilyParsedNumber(jsonReader.e0()));
                }
                if (i3 == 2) {
                    return new JsonPrimitive(jsonReader.e0());
                }
                if (i3 == 3) {
                    return new JsonPrimitive(Boolean.valueOf(jsonReader.J()));
                }
                if (i3 == 6) {
                    jsonReader.T();
                    return JsonNull.f90293a;
                }
                throw new IllegalStateException("Unexpected token: " + jsonToken);
            }

            private JsonElement g(JsonReader jsonReader, JsonToken jsonToken) throws IOException {
                int i3 = AnonymousClass35.f90518a[jsonToken.ordinal()];
                if (i3 == 4) {
                    jsonReader.a();
                    return new JsonArray();
                }
                if (i3 != 5) {
                    return null;
                }
                jsonReader.b();
                return new JsonObject();
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public JsonElement b(JsonReader jsonReader) throws IOException {
                if (jsonReader instanceof JsonTreeReader) {
                    return ((JsonTreeReader) jsonReader).t1();
                }
                JsonToken jsonTokenJ0 = jsonReader.j0();
                JsonElement jsonElementG = g(jsonReader, jsonTokenJ0);
                if (jsonElementG == null) {
                    return f(jsonReader, jsonTokenJ0);
                }
                ArrayDeque arrayDeque = new ArrayDeque();
                while (true) {
                    if (jsonReader.r()) {
                        String strN = jsonElementG instanceof JsonObject ? jsonReader.N() : null;
                        JsonToken jsonTokenJ02 = jsonReader.j0();
                        JsonElement jsonElementG2 = g(jsonReader, jsonTokenJ02);
                        boolean z2 = jsonElementG2 != null;
                        if (jsonElementG2 == null) {
                            jsonElementG2 = f(jsonReader, jsonTokenJ02);
                        }
                        if (jsonElementG instanceof JsonArray) {
                            ((JsonArray) jsonElementG).o(jsonElementG2);
                        } else {
                            ((JsonObject) jsonElementG).o(strN, jsonElementG2);
                        }
                        if (z2) {
                            arrayDeque.addLast(jsonElementG);
                            jsonElementG = jsonElementG2;
                        }
                    } else {
                        if (jsonElementG instanceof JsonArray) {
                            jsonReader.j();
                        } else {
                            jsonReader.k();
                        }
                        if (arrayDeque.isEmpty()) {
                            return jsonElementG;
                        }
                        jsonElementG = (JsonElement) arrayDeque.removeLast();
                    }
                }
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public void d(JsonWriter jsonWriter, JsonElement jsonElement) throws IOException {
                if (jsonElement == null || jsonElement.h()) {
                    jsonWriter.F();
                    return;
                }
                if (jsonElement.n()) {
                    JsonPrimitive jsonPrimitiveE = jsonElement.e();
                    if (jsonPrimitiveE.v()) {
                        jsonWriter.w0(jsonPrimitiveE.s());
                        return;
                    } else if (jsonPrimitiveE.t()) {
                        jsonWriter.A0(jsonPrimitiveE.o());
                        return;
                    } else {
                        jsonWriter.z0(jsonPrimitiveE.f());
                        return;
                    }
                }
                if (jsonElement.g()) {
                    jsonWriter.c();
                    Iterator<JsonElement> it = jsonElement.b().iterator();
                    while (it.hasNext()) {
                        d(jsonWriter, it.next());
                    }
                    jsonWriter.j();
                    return;
                }
                if (!jsonElement.l()) {
                    throw new IllegalArgumentException("Couldn't write " + jsonElement.getClass());
                }
                jsonWriter.f();
                for (Map.Entry entry : jsonElement.d().entrySet()) {
                    jsonWriter.z((String) entry.getKey());
                    d(jsonWriter, (JsonElement) entry.getValue());
                }
                jsonWriter.k();
            }
        };
        V = typeAdapter15;
        W = e(JsonElement.class, typeAdapter15);
        X = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.29
            @Override // com.google.gson.TypeAdapterFactory
            public TypeAdapter a(Gson gson, TypeToken typeToken) {
                Class clsC = typeToken.c();
                if (!Enum.class.isAssignableFrom(clsC) || clsC == Enum.class) {
                    return null;
                }
                if (!clsC.isEnum()) {
                    clsC = clsC.getSuperclass();
                }
                return new EnumTypeAdapter(clsC);
            }
        };
    }

    public static TypeAdapterFactory a(final TypeToken typeToken, final TypeAdapter typeAdapter) {
        return new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.30
            @Override // com.google.gson.TypeAdapterFactory
            public TypeAdapter a(Gson gson, TypeToken typeToken2) {
                if (typeToken2.equals(typeToken)) {
                    return typeAdapter;
                }
                return null;
            }
        };
    }

    public static TypeAdapterFactory b(final Class cls, final TypeAdapter typeAdapter) {
        return new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.31
            @Override // com.google.gson.TypeAdapterFactory
            public TypeAdapter a(Gson gson, TypeToken typeToken) {
                if (typeToken.c() == cls) {
                    return typeAdapter;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }

    public static TypeAdapterFactory c(final Class cls, final Class cls2, final TypeAdapter typeAdapter) {
        return new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.32
            @Override // com.google.gson.TypeAdapterFactory
            public TypeAdapter a(Gson gson, TypeToken typeToken) {
                Class clsC = typeToken.c();
                if (clsC == cls || clsC == cls2) {
                    return typeAdapter;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls2.getName() + "+" + cls.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }

    public static TypeAdapterFactory d(final Class cls, final Class cls2, final TypeAdapter typeAdapter) {
        return new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.33
            @Override // com.google.gson.TypeAdapterFactory
            public TypeAdapter a(Gson gson, TypeToken typeToken) {
                Class clsC = typeToken.c();
                if (clsC == cls || clsC == cls2) {
                    return typeAdapter;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + "+" + cls2.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }

    public static TypeAdapterFactory e(final Class cls, final TypeAdapter typeAdapter) {
        return new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.34
            @Override // com.google.gson.TypeAdapterFactory
            public TypeAdapter a(Gson gson, TypeToken typeToken) {
                final Class<?> clsC = typeToken.c();
                if (cls.isAssignableFrom(clsC)) {
                    return new TypeAdapter<Object>() { // from class: com.google.gson.internal.bind.TypeAdapters.34.1
                        @Override // com.google.gson.TypeAdapter
                        public Object b(JsonReader jsonReader) {
                            Object objB = typeAdapter.b(jsonReader);
                            if (objB == null || clsC.isInstance(objB)) {
                                return objB;
                            }
                            throw new JsonSyntaxException("Expected a " + clsC.getName() + " but was " + objB.getClass().getName() + "; at path " + jsonReader.n());
                        }

                        @Override // com.google.gson.TypeAdapter
                        public void d(JsonWriter jsonWriter, Object obj) {
                            typeAdapter.d(jsonWriter, obj);
                        }
                    };
                }
                return null;
            }

            public String toString() {
                return "Factory[typeHierarchy=" + cls.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }
}
