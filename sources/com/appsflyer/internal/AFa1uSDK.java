package com.appsflyer.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.Base64;
import com.appsflyer.AFLogger;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFa1uSDK {
    String AFInAppEventParameterName;
    private byte[] AFInAppEventType;
    public String AFKeystoreWrapper;
    public AFd1tSDK valueOf;
    public String values;

    public AFa1uSDK() {
    }

    private static List<Object> AFKeystoreWrapper(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            Object objValueOf = jSONArray.get(i3);
            if (objValueOf instanceof JSONArray) {
                objValueOf = AFKeystoreWrapper((JSONArray) objValueOf);
            } else if (objValueOf instanceof JSONObject) {
                objValueOf = valueOf((JSONObject) objValueOf);
            }
            arrayList.add(objValueOf);
        }
        return arrayList;
    }

    public static JSONObject valueOf(Map<String, ?> map) {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            try {
                jSONObject.put(entry.getKey(), valueOf(entry.getValue()));
            } catch (JSONException unused) {
            }
        }
        return jSONObject;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && AFa1uSDK.class == obj.getClass()) {
            AFa1uSDK aFa1uSDK = (AFa1uSDK) obj;
            String str = this.AFInAppEventParameterName;
            if (str == null ? aFa1uSDK.AFInAppEventParameterName != null : !str.equals(aFa1uSDK.AFInAppEventParameterName)) {
                return false;
            }
            if (!Arrays.equals(this.AFInAppEventType, aFa1uSDK.AFInAppEventType)) {
                return false;
            }
            String str2 = this.values;
            if (str2 == null ? aFa1uSDK.values != null : !str2.equals(aFa1uSDK.values)) {
                return false;
            }
            String str3 = this.AFKeystoreWrapper;
            if (str3 == null ? aFa1uSDK.AFKeystoreWrapper != null : !str3.equals(aFa1uSDK.AFKeystoreWrapper)) {
                return false;
            }
            if (this.valueOf == aFa1uSDK.valueOf) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.AFInAppEventParameterName;
        int iHashCode = (((str != null ? str.hashCode() : 0) * 31) + Arrays.hashCode(this.AFInAppEventType)) * 31;
        String str2 = this.values;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.AFKeystoreWrapper;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        AFd1tSDK aFd1tSDK = this.valueOf;
        return iHashCode3 + (aFd1tSDK != null ? aFd1tSDK.hashCode() : 0);
    }

    public AFa1uSDK(String str, byte[] bArr, String str2, AFd1tSDK aFd1tSDK) {
        this.values = str;
        this.AFInAppEventType = bArr;
        this.AFInAppEventParameterName = str2;
        this.valueOf = aFd1tSDK;
    }

    public static JSONObject valueOf(String str) {
        if (str == null) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (JSONException unused) {
            return null;
        }
    }

    private static Object valueOf(Object obj) {
        if (obj == null) {
            return JSONObject.NULL;
        }
        if ((obj instanceof JSONArray) || (obj instanceof JSONObject) || obj.equals(JSONObject.NULL)) {
            return obj;
        }
        try {
            if (obj instanceof Collection) {
                JSONArray jSONArray = new JSONArray();
                Iterator it = ((Collection) obj).iterator();
                while (it.hasNext()) {
                    jSONArray.put(valueOf(it.next()));
                }
                return jSONArray;
            }
            if (obj.getClass().isArray()) {
                int length = Array.getLength(obj);
                JSONArray jSONArray2 = new JSONArray();
                for (int i3 = 0; i3 < length; i3++) {
                    jSONArray2.put(valueOf(Array.get(obj, i3)));
                }
                return jSONArray2;
            }
            if (obj instanceof Map) {
                return valueOf((Map<String, ?>) obj);
            }
            return ((obj instanceof Boolean) || (obj instanceof Byte) || (obj instanceof Character) || (obj instanceof Double) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Short) || (obj instanceof String)) ? obj : obj.toString();
        } catch (Exception unused) {
            return JSONObject.NULL;
        }
    }

    public AFa1uSDK(char[] cArr) {
        Scanner scanner = new Scanner(new String(cArr));
        int i3 = 0;
        int i4 = 0;
        while (scanner.hasNextLine()) {
            String strNextLine = scanner.nextLine();
            if (strNextLine.startsWith("url=")) {
                this.values = strNextLine.substring(4).trim();
            } else if (strNextLine.startsWith("version=")) {
                this.AFInAppEventParameterName = strNextLine.substring(8).trim();
                Matcher matcher = Pattern.compile("^(0|[1-9]\\d*)\\.(0|[1-9]\\d*)\\.(0|[1-9]\\d*)(?:-((?:0|[1-9]\\d*|\\d*[a-zA-Z-][0-9a-zA-Z-]*)(?:\\.(?:0|[1-9]\\d*|\\d*[a-zA-Z-][0-9a-zA-Z-]*))*))?(?:\\+([0-9a-zA-Z-]+(?:\\.[0-9a-zA-Z-]+)*))?$").matcher(this.AFInAppEventParameterName);
                if (matcher.matches()) {
                    i3 = Integer.parseInt(matcher.group(1));
                    i4 = Integer.parseInt(matcher.group(2));
                }
            } else if (strNextLine.startsWith("data=")) {
                String strTrim = strNextLine.substring(5).trim();
                this.AFInAppEventType = (i3 > 4 || i4 >= 11) ? Base64.decode(strTrim, 2) : strTrim.getBytes(Charset.defaultCharset());
            } else if (strNextLine.startsWith("type=")) {
                String strTrim2 = strNextLine.substring(5).trim();
                try {
                    this.valueOf = AFd1tSDK.valueOf(strTrim2);
                } catch (Exception e3) {
                    AFLogger.afErrorLog("CACHE: Unknown task type: ".concat(String.valueOf(strTrim2)), e3);
                }
            }
        }
        scanner.close();
    }

    static AFe1kSDK AFKeystoreWrapper(Context context) {
        if (context instanceof Activity) {
            return AFe1kSDK.activity;
        }
        if (context instanceof Application) {
            return AFe1kSDK.application;
        }
        return AFe1kSDK.other;
    }

    public final byte[] AFKeystoreWrapper() {
        return this.AFInAppEventType;
    }

    public static Map<String, Object> valueOf(JSONObject jSONObject) throws JSONException {
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objValueOf = jSONObject.get(next);
            if (objValueOf instanceof JSONArray) {
                objValueOf = AFKeystoreWrapper((JSONArray) objValueOf);
            } else if (objValueOf instanceof JSONObject) {
                objValueOf = valueOf((JSONObject) objValueOf);
            }
            map.put(next, objValueOf);
        }
        return map;
    }
}
