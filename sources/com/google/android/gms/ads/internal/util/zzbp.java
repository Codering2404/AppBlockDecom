package com.google.android.gms.ads.internal.util;

import android.os.Bundle;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.JsonWriter;
import com.google.android.gms.internal.ads.zzfkk;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbp {
    public static List a(JSONArray jSONArray, List list) {
        if (list == null) {
            list = new ArrayList();
        }
        if (jSONArray != null) {
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                list.add(jSONArray.getString(i3));
            }
        }
        return list;
    }

    public static List b(JsonReader jsonReader) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(jsonReader.nextString());
        }
        jsonReader.endArray();
        return arrayList;
    }

    public static Map c(JsonReader jsonReader) throws IOException {
        HashMap map = new HashMap();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            HashMap map2 = new HashMap();
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                map2.put(jsonReader.nextName(), jsonReader.nextString());
            }
            jsonReader.endObject();
            map.put(strNextName, map2);
        }
        jsonReader.endObject();
        return map;
    }

    public static JSONObject d(JsonReader jsonReader) {
        JSONObject jSONObject = new JSONObject();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            JsonToken jsonTokenPeek = jsonReader.peek();
            if (JsonToken.BEGIN_ARRAY.equals(jsonTokenPeek)) {
                jSONObject.put(strNextName, e(jsonReader));
            } else if (JsonToken.BEGIN_OBJECT.equals(jsonTokenPeek)) {
                jSONObject.put(strNextName, d(jsonReader));
            } else if (JsonToken.BOOLEAN.equals(jsonTokenPeek)) {
                jSONObject.put(strNextName, jsonReader.nextBoolean());
            } else if (JsonToken.NUMBER.equals(jsonTokenPeek)) {
                jSONObject.put(strNextName, jsonReader.nextDouble());
            } else {
                if (!JsonToken.STRING.equals(jsonTokenPeek)) {
                    throw new IllegalStateException("unexpected json token: ".concat(String.valueOf(jsonTokenPeek)));
                }
                jSONObject.put(strNextName, jsonReader.nextString());
            }
        }
        jsonReader.endObject();
        return jSONObject;
    }

    public static JSONArray e(JsonReader jsonReader) throws JSONException, IOException {
        JSONArray jSONArray = new JSONArray();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            JsonToken jsonTokenPeek = jsonReader.peek();
            if (JsonToken.BEGIN_ARRAY.equals(jsonTokenPeek)) {
                jSONArray.put(e(jsonReader));
            } else if (JsonToken.BEGIN_OBJECT.equals(jsonTokenPeek)) {
                jSONArray.put(d(jsonReader));
            } else if (JsonToken.BOOLEAN.equals(jsonTokenPeek)) {
                jSONArray.put(jsonReader.nextBoolean());
            } else if (JsonToken.NUMBER.equals(jsonTokenPeek)) {
                jSONArray.put(jsonReader.nextDouble());
            } else {
                if (!JsonToken.STRING.equals(jsonTokenPeek)) {
                    throw new IllegalStateException("unexpected json token: ".concat(String.valueOf(jsonTokenPeek)));
                }
                jSONArray.put(jsonReader.nextString());
            }
        }
        jsonReader.endArray();
        return jSONArray;
    }

    public static void f(JsonWriter jsonWriter, JSONObject jSONObject) throws IOException {
        try {
            jsonWriter.beginObject();
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object obj = jSONObject.get(next);
                if (obj instanceof String) {
                    jsonWriter.name(next).value((String) obj);
                } else if (obj instanceof Number) {
                    jsonWriter.name(next).value((Number) obj);
                } else if (obj instanceof Boolean) {
                    jsonWriter.name(next).value(((Boolean) obj).booleanValue());
                } else if (obj instanceof JSONObject) {
                    f(jsonWriter.name(next), (JSONObject) obj);
                } else {
                    if (!(obj instanceof JSONArray)) {
                        String strValueOf = String.valueOf(obj);
                        StringBuilder sb = new StringBuilder(strValueOf.length() + 23);
                        sb.append("unable to write field: ");
                        sb.append(strValueOf);
                        throw new JSONException(sb.toString());
                    }
                    g(jsonWriter.name(next), (JSONArray) obj);
                }
            }
            jsonWriter.endObject();
        } catch (JSONException e3) {
            throw new IOException(e3);
        }
    }

    public static void g(JsonWriter jsonWriter, JSONArray jSONArray) throws IOException {
        try {
            jsonWriter.beginArray();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                Object obj = jSONArray.get(i3);
                if (obj instanceof String) {
                    jsonWriter.value((String) obj);
                } else if (obj instanceof Number) {
                    jsonWriter.value((Number) obj);
                } else if (obj instanceof Boolean) {
                    jsonWriter.value(((Boolean) obj).booleanValue());
                } else if (obj instanceof JSONObject) {
                    f(jsonWriter, (JSONObject) obj);
                } else {
                    if (!(obj instanceof JSONArray)) {
                        String strValueOf = String.valueOf(obj);
                        StringBuilder sb = new StringBuilder(strValueOf.length() + 23);
                        sb.append("unable to write field: ");
                        sb.append(strValueOf);
                        throw new JSONException(sb.toString());
                    }
                    g(jsonWriter, (JSONArray) obj);
                }
            }
            jsonWriter.endArray();
        } catch (JSONException e3) {
            throw new IOException(e3);
        }
    }

    public static JSONObject h(JSONObject jSONObject, String str) throws JSONException {
        try {
            return jSONObject.getJSONObject(str);
        } catch (JSONException unused) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put(str, jSONObject2);
            return jSONObject2;
        }
    }

    public static JSONObject i(JSONObject jSONObject, String... strArr) {
        JSONObject jSONObjectO = o(jSONObject, strArr);
        if (jSONObjectO == null) {
            return null;
        }
        return jSONObjectO.optJSONObject(strArr[1]);
    }

    public static boolean j(boolean z2, JSONObject jSONObject, String... strArr) {
        JSONObject jSONObjectO = o(jSONObject, strArr);
        if (jSONObjectO == null) {
            return false;
        }
        return jSONObjectO.optBoolean(strArr[strArr.length - 1], false);
    }

    public static String k(String str, JSONObject jSONObject, String... strArr) {
        JSONObject jSONObjectO = o(jSONObject, strArr);
        return jSONObjectO == null ? "" : jSONObjectO.optString(strArr[0], "");
    }

    public static Bundle l(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Iterator<String> itKeys = jSONObject.keys();
        Bundle bundle = new Bundle();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objOpt = jSONObject.opt(next);
            if (objOpt != null) {
                if (objOpt instanceof Boolean) {
                    bundle.putBoolean(next, ((Boolean) objOpt).booleanValue());
                } else if (objOpt instanceof Double) {
                    bundle.putDouble(next, ((Double) objOpt).doubleValue());
                } else if (objOpt instanceof Integer) {
                    bundle.putInt(next, ((Integer) objOpt).intValue());
                } else if (objOpt instanceof Long) {
                    bundle.putLong(next, ((Long) objOpt).longValue());
                } else if (objOpt instanceof String) {
                    bundle.putString(next, (String) objOpt);
                } else if (objOpt instanceof JSONArray) {
                    JSONArray jSONArray = (JSONArray) objOpt;
                    if (jSONArray.length() != 0) {
                        int length = jSONArray.length();
                        int i3 = 0;
                        Object objOpt2 = null;
                        for (int i4 = 0; objOpt2 == null && i4 < length; i4++) {
                            objOpt2 = !jSONArray.isNull(i4) ? jSONArray.opt(i4) : null;
                        }
                        if (objOpt2 == null) {
                            String strValueOf = String.valueOf(next);
                            int i5 = zze.f70328b;
                            com.google.android.gms.ads.internal.util.client.zzo.f("Expected JSONArray with at least 1 non-null element for key:".concat(strValueOf));
                        } else if (objOpt2 instanceof JSONObject) {
                            Bundle[] bundleArr = new Bundle[length];
                            while (i3 < length) {
                                bundleArr[i3] = !jSONArray.isNull(i3) ? l(jSONArray.optJSONObject(i3)) : null;
                                i3++;
                            }
                            bundle.putParcelableArray(next, bundleArr);
                        } else if (objOpt2 instanceof Number) {
                            double[] dArr = new double[jSONArray.length()];
                            while (i3 < length) {
                                dArr[i3] = jSONArray.optDouble(i3);
                                i3++;
                            }
                            bundle.putDoubleArray(next, dArr);
                        } else if (objOpt2 instanceof CharSequence) {
                            String[] strArr = new String[length];
                            while (i3 < length) {
                                strArr[i3] = !jSONArray.isNull(i3) ? jSONArray.optString(i3) : null;
                                i3++;
                            }
                            bundle.putStringArray(next, strArr);
                        } else if (objOpt2 instanceof Boolean) {
                            boolean[] zArr = new boolean[length];
                            while (i3 < length) {
                                zArr[i3] = jSONArray.optBoolean(i3);
                                i3++;
                            }
                            bundle.putBooleanArray(next, zArr);
                        } else {
                            String str = String.format("JSONArray with unsupported type %s for key:%s", objOpt2.getClass().getCanonicalName(), next);
                            int i6 = zze.f70328b;
                            com.google.android.gms.ads.internal.util.client.zzo.f(str);
                        }
                    }
                } else if (objOpt instanceof JSONObject) {
                    bundle.putBundle(next, l((JSONObject) objOpt));
                } else {
                    String strValueOf2 = String.valueOf(next);
                    int i7 = zze.f70328b;
                    com.google.android.gms.ads.internal.util.client.zzo.f("Unsupported type for key:".concat(strValueOf2));
                }
            }
        }
        return bundle;
    }

    public static String m(zzfkk zzfkkVar) {
        if (zzfkkVar == null) {
            return null;
        }
        StringWriter stringWriter = new StringWriter();
        try {
            JsonWriter jsonWriter = new JsonWriter(stringWriter);
            n(jsonWriter, zzfkkVar);
            jsonWriter.close();
            return stringWriter.toString();
        } catch (IOException e3) {
            int i3 = zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Error when writing JSON.", e3);
            return null;
        }
    }

    private static void n(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        if (obj instanceof Number) {
            jsonWriter.value((Number) obj);
            return;
        }
        if (obj instanceof Boolean) {
            jsonWriter.value(((Boolean) obj).booleanValue());
            return;
        }
        if (obj instanceof String) {
            jsonWriter.value((String) obj);
            return;
        }
        if (obj instanceof zzfkk) {
            f(jsonWriter, ((zzfkk) obj).zzd);
            return;
        }
        if (!(obj instanceof Map)) {
            if (!(obj instanceof List)) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginArray();
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                n(jsonWriter, it.next());
            }
            jsonWriter.endArray();
            return;
        }
        jsonWriter.beginObject();
        for (Map.Entry entry : ((Map) obj).entrySet()) {
            Object key = entry.getKey();
            if (key instanceof String) {
                n(jsonWriter.name((String) key), entry.getValue());
            }
        }
        jsonWriter.endObject();
    }

    private static JSONObject o(JSONObject jSONObject, String[] strArr) {
        for (int i3 = 0; i3 < strArr.length - 1; i3 = 1) {
            if (jSONObject == null) {
                return null;
            }
            jSONObject = jSONObject.optJSONObject(strArr[0]);
        }
        return jSONObject;
    }
}
