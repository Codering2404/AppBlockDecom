package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class JsonTreeReader extends JsonReader {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final Reader f90409u = new Reader() { // from class: com.google.gson.internal.bind.JsonTreeReader.1
        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i3, int i4) {
            throw new AssertionError();
        }
    };

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final Object f90410v = new Object();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Object[] f90411q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f90412r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String[] f90413s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int[] f90414t;

    /* JADX INFO: renamed from: com.google.gson.internal.bind.JsonTreeReader$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f90415a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            f90415a = iArr;
            try {
                iArr[JsonToken.NAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f90415a[JsonToken.END_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f90415a[JsonToken.END_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f90415a[JsonToken.END_DOCUMENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private Object A1() {
        Object[] objArr = this.f90411q;
        int i3 = this.f90412r - 1;
        this.f90412r = i3;
        Object obj = objArr[i3];
        objArr[i3] = null;
        return obj;
    }

    private String F() {
        return " at path " + g();
    }

    private void I1(Object obj) {
        int i3 = this.f90412r;
        Object[] objArr = this.f90411q;
        if (i3 == objArr.length) {
            int i4 = i3 * 2;
            this.f90411q = Arrays.copyOf(objArr, i4);
            this.f90414t = Arrays.copyOf(this.f90414t, i4);
            this.f90413s = (String[]) Arrays.copyOf(this.f90413s, i4);
        }
        Object[] objArr2 = this.f90411q;
        int i5 = this.f90412r;
        this.f90412r = i5 + 1;
        objArr2[i5] = obj;
    }

    private String m(boolean z2) {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i3 = 0;
        while (true) {
            int i4 = this.f90412r;
            if (i3 >= i4) {
                return sb.toString();
            }
            Object[] objArr = this.f90411q;
            Object obj = objArr[i3];
            if (obj instanceof JsonArray) {
                i3++;
                if (i3 < i4 && (objArr[i3] instanceof Iterator)) {
                    int i5 = this.f90414t[i3];
                    if (z2 && i5 > 0 && (i3 == i4 - 1 || i3 == i4 - 2)) {
                        i5--;
                    }
                    sb.append('[');
                    sb.append(i5);
                    sb.append(']');
                }
            } else if ((obj instanceof JsonObject) && (i3 = i3 + 1) < i4 && (objArr[i3] instanceof Iterator)) {
                sb.append('.');
                String str = this.f90413s[i3];
                if (str != null) {
                    sb.append(str);
                }
            }
            i3++;
        }
    }

    private void o1(JsonToken jsonToken) {
        if (j0() == jsonToken) {
            return;
        }
        throw new IllegalStateException("Expected " + jsonToken + " but was " + j0() + F());
    }

    private String u1(boolean z2) {
        o1(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) w1()).next();
        String str = (String) entry.getKey();
        this.f90413s[this.f90412r - 1] = z2 ? "<skipped>" : str;
        I1(entry.getValue());
        return str;
    }

    private Object w1() {
        return this.f90411q[this.f90412r - 1];
    }

    public void B1() {
        o1(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) w1()).next();
        I1(entry.getValue());
        I1(new JsonPrimitive((String) entry.getKey()));
    }

    @Override // com.google.gson.stream.JsonReader
    public boolean J() {
        o1(JsonToken.BOOLEAN);
        boolean zO = ((JsonPrimitive) A1()).o();
        int i3 = this.f90412r;
        if (i3 > 0) {
            int[] iArr = this.f90414t;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
        }
        return zO;
    }

    @Override // com.google.gson.stream.JsonReader
    public double K() throws MalformedJsonException {
        JsonToken jsonTokenJ0 = j0();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (jsonTokenJ0 != jsonToken && jsonTokenJ0 != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + jsonTokenJ0 + F());
        }
        double dP = ((JsonPrimitive) w1()).p();
        if (!z() && (Double.isNaN(dP) || Double.isInfinite(dP))) {
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + dP);
        }
        A1();
        int i3 = this.f90412r;
        if (i3 > 0) {
            int[] iArr = this.f90414t;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
        }
        return dP;
    }

    @Override // com.google.gson.stream.JsonReader
    public int L() throws MalformedJsonException {
        JsonToken jsonTokenJ0 = j0();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (jsonTokenJ0 != jsonToken && jsonTokenJ0 != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + jsonTokenJ0 + F());
        }
        int iA = ((JsonPrimitive) w1()).a();
        A1();
        int i3 = this.f90412r;
        if (i3 > 0) {
            int[] iArr = this.f90414t;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
        }
        return iA;
    }

    @Override // com.google.gson.stream.JsonReader
    public long M() throws MalformedJsonException {
        JsonToken jsonTokenJ0 = j0();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (jsonTokenJ0 != jsonToken && jsonTokenJ0 != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + jsonTokenJ0 + F());
        }
        long jQ = ((JsonPrimitive) w1()).q();
        A1();
        int i3 = this.f90412r;
        if (i3 > 0) {
            int[] iArr = this.f90414t;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
        }
        return jQ;
    }

    @Override // com.google.gson.stream.JsonReader
    public String N() {
        return u1(false);
    }

    @Override // com.google.gson.stream.JsonReader
    public void T() {
        o1(JsonToken.NULL);
        A1();
        int i3 = this.f90412r;
        if (i3 > 0) {
            int[] iArr = this.f90414t;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public void a() {
        o1(JsonToken.BEGIN_ARRAY);
        I1(((JsonArray) w1()).iterator());
        this.f90414t[this.f90412r - 1] = 0;
    }

    @Override // com.google.gson.stream.JsonReader
    public void b() {
        o1(JsonToken.BEGIN_OBJECT);
        I1(((JsonObject) w1()).entrySet().iterator());
    }

    @Override // com.google.gson.stream.JsonReader, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f90411q = new Object[]{f90410v};
        this.f90412r = 1;
    }

    @Override // com.google.gson.stream.JsonReader
    public String e0() throws MalformedJsonException {
        JsonToken jsonTokenJ0 = j0();
        JsonToken jsonToken = JsonToken.STRING;
        if (jsonTokenJ0 == jsonToken || jsonTokenJ0 == JsonToken.NUMBER) {
            String strF = ((JsonPrimitive) A1()).f();
            int i3 = this.f90412r;
            if (i3 > 0) {
                int[] iArr = this.f90414t;
                int i4 = i3 - 1;
                iArr[i4] = iArr[i4] + 1;
            }
            return strF;
        }
        throw new IllegalStateException("Expected " + jsonToken + " but was " + jsonTokenJ0 + F());
    }

    @Override // com.google.gson.stream.JsonReader
    public String g() {
        return m(false);
    }

    @Override // com.google.gson.stream.JsonReader
    public void h1() throws MalformedJsonException {
        int i3 = AnonymousClass2.f90415a[j0().ordinal()];
        if (i3 == 1) {
            u1(true);
            return;
        }
        if (i3 == 2) {
            j();
            return;
        }
        if (i3 == 3) {
            k();
            return;
        }
        if (i3 != 4) {
            A1();
            int i4 = this.f90412r;
            if (i4 > 0) {
                int[] iArr = this.f90414t;
                int i5 = i4 - 1;
                iArr[i5] = iArr[i5] + 1;
            }
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public void j() {
        o1(JsonToken.END_ARRAY);
        A1();
        A1();
        int i3 = this.f90412r;
        if (i3 > 0) {
            int[] iArr = this.f90414t;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public JsonToken j0() throws MalformedJsonException {
        if (this.f90412r == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object objW1 = w1();
        if (objW1 instanceof Iterator) {
            boolean z2 = this.f90411q[this.f90412r - 2] instanceof JsonObject;
            Iterator it = (Iterator) objW1;
            if (!it.hasNext()) {
                return z2 ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            }
            if (z2) {
                return JsonToken.NAME;
            }
            I1(it.next());
            return j0();
        }
        if (objW1 instanceof JsonObject) {
            return JsonToken.BEGIN_OBJECT;
        }
        if (objW1 instanceof JsonArray) {
            return JsonToken.BEGIN_ARRAY;
        }
        if (objW1 instanceof JsonPrimitive) {
            JsonPrimitive jsonPrimitive = (JsonPrimitive) objW1;
            if (jsonPrimitive.w()) {
                return JsonToken.STRING;
            }
            if (jsonPrimitive.t()) {
                return JsonToken.BOOLEAN;
            }
            if (jsonPrimitive.v()) {
                return JsonToken.NUMBER;
            }
            throw new AssertionError();
        }
        if (objW1 instanceof JsonNull) {
            return JsonToken.NULL;
        }
        if (objW1 == f90410v) {
            throw new IllegalStateException("JsonReader is closed");
        }
        throw new MalformedJsonException("Custom JsonElement subclass " + objW1.getClass().getName() + " is not supported");
    }

    @Override // com.google.gson.stream.JsonReader
    public void k() {
        o1(JsonToken.END_OBJECT);
        this.f90413s[this.f90412r - 1] = null;
        A1();
        A1();
        int i3 = this.f90412r;
        if (i3 > 0) {
            int[] iArr = this.f90414t;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public String n() {
        return m(true);
    }

    @Override // com.google.gson.stream.JsonReader
    public boolean r() throws MalformedJsonException {
        JsonToken jsonTokenJ0 = j0();
        return (jsonTokenJ0 == JsonToken.END_OBJECT || jsonTokenJ0 == JsonToken.END_ARRAY || jsonTokenJ0 == JsonToken.END_DOCUMENT) ? false : true;
    }

    JsonElement t1() throws MalformedJsonException {
        JsonToken jsonTokenJ0 = j0();
        if (jsonTokenJ0 != JsonToken.NAME && jsonTokenJ0 != JsonToken.END_ARRAY && jsonTokenJ0 != JsonToken.END_OBJECT && jsonTokenJ0 != JsonToken.END_DOCUMENT) {
            JsonElement jsonElement = (JsonElement) w1();
            h1();
            return jsonElement;
        }
        throw new IllegalStateException("Unexpected " + jsonTokenJ0 + " when reading a JsonElement.");
    }

    @Override // com.google.gson.stream.JsonReader
    public String toString() {
        return JsonTreeReader.class.getSimpleName() + F();
    }
}
