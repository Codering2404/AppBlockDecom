package com.google.crypto.tink.internal;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.math.BigDecimal;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class JsonParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final JsonElementTypeAdapter f86225a = new JsonElementTypeAdapter(null);

    /* JADX INFO: renamed from: com.google.crypto.tink.internal.JsonParser$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f86226a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            f86226a = iArr;
            try {
                iArr[JsonToken.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f86226a[JsonToken.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f86226a[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f86226a[JsonToken.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f86226a[JsonToken.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f86226a[JsonToken.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class JsonElementTypeAdapter extends TypeAdapter<JsonElement> {
        private JsonElementTypeAdapter() {
        }

        private JsonElement f(JsonReader jsonReader, JsonToken jsonToken) throws IOException {
            int i3 = AnonymousClass1.f86226a[jsonToken.ordinal()];
            if (i3 == 3) {
                String strE0 = jsonReader.e0();
                if (JsonParser.a(strE0)) {
                    return new JsonPrimitive(strE0);
                }
                throw new IOException("illegal characters in string");
            }
            if (i3 == 4) {
                return new JsonPrimitive(new LazilyParsedNumber(jsonReader.e0()));
            }
            if (i3 == 5) {
                return new JsonPrimitive(Boolean.valueOf(jsonReader.J()));
            }
            if (i3 == 6) {
                jsonReader.T();
                return JsonNull.f90293a;
            }
            throw new IllegalStateException("Unexpected token: " + jsonToken);
        }

        private JsonElement g(JsonReader jsonReader, JsonToken jsonToken) throws IOException {
            int i3 = AnonymousClass1.f86226a[jsonToken.ordinal()];
            if (i3 == 1) {
                jsonReader.a();
                return new JsonArray();
            }
            if (i3 != 2) {
                return null;
            }
            jsonReader.b();
            return new JsonObject();
        }

        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public JsonElement b(JsonReader jsonReader) throws IOException {
            String strN;
            JsonToken jsonTokenJ0 = jsonReader.j0();
            JsonElement jsonElementG = g(jsonReader, jsonTokenJ0);
            if (jsonElementG == null) {
                return f(jsonReader, jsonTokenJ0);
            }
            ArrayDeque arrayDeque = new ArrayDeque();
            while (true) {
                if (jsonReader.r()) {
                    if (jsonElementG instanceof JsonObject) {
                        strN = jsonReader.N();
                        if (!JsonParser.a(strN)) {
                            throw new IOException("illegal characters in string");
                        }
                    } else {
                        strN = null;
                    }
                    JsonToken jsonTokenJ02 = jsonReader.j0();
                    JsonElement jsonElementG2 = g(jsonReader, jsonTokenJ02);
                    boolean z2 = jsonElementG2 != null;
                    if (jsonElementG2 == null) {
                        jsonElementG2 = f(jsonReader, jsonTokenJ02);
                    }
                    if (jsonElementG instanceof JsonArray) {
                        ((JsonArray) jsonElementG).o(jsonElementG2);
                    } else {
                        JsonObject jsonObject = (JsonObject) jsonElementG;
                        if (jsonObject.q(strN)) {
                            throw new IOException("duplicate key: " + strN);
                        }
                        jsonObject.o(strN, jsonElementG2);
                    }
                    if (z2) {
                        arrayDeque.addLast(jsonElementG);
                        if (arrayDeque.size() > 100) {
                            throw new IOException("too many recursions");
                        }
                        jsonElementG = jsonElementG2;
                    } else {
                        continue;
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
        public void d(JsonWriter jsonWriter, JsonElement jsonElement) {
            throw new UnsupportedOperationException("write is not supported");
        }

        /* synthetic */ JsonElementTypeAdapter(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class LazilyParsedNumber extends Number {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f86227a;

        public LazilyParsedNumber(String str) {
            this.f86227a = str;
        }

        private void readObject(ObjectInputStream objectInputStream) throws NotSerializableException {
            throw new NotSerializableException("serialization is not supported");
        }

        private Object writeReplace() throws NotSerializableException {
            throw new NotSerializableException("serialization is not supported");
        }

        @Override // java.lang.Number
        public double doubleValue() {
            return Double.parseDouble(this.f86227a);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LazilyParsedNumber) {
                return this.f86227a.equals(((LazilyParsedNumber) obj).f86227a);
            }
            return false;
        }

        @Override // java.lang.Number
        public float floatValue() {
            return Float.parseFloat(this.f86227a);
        }

        public int hashCode() {
            return this.f86227a.hashCode();
        }

        @Override // java.lang.Number
        public int intValue() {
            try {
                try {
                    return Integer.parseInt(this.f86227a);
                } catch (NumberFormatException unused) {
                    return (int) Long.parseLong(this.f86227a);
                }
            } catch (NumberFormatException unused2) {
                return new BigDecimal(this.f86227a).intValue();
            }
        }

        @Override // java.lang.Number
        public long longValue() {
            try {
                return Long.parseLong(this.f86227a);
            } catch (NumberFormatException unused) {
                return new BigDecimal(this.f86227a).longValue();
            }
        }

        public String toString() {
            return this.f86227a;
        }
    }

    public static boolean a(String str) {
        int length = str.length();
        int i3 = 0;
        while (i3 != length) {
            char cCharAt = str.charAt(i3);
            int i4 = i3 + 1;
            if (!Character.isSurrogate(cCharAt)) {
                i3 = i4;
            } else {
                if (Character.isLowSurrogate(cCharAt) || i4 == length || !Character.isLowSurrogate(str.charAt(i4))) {
                    return false;
                }
                i3 += 2;
            }
        }
        return true;
    }
}
