package com.iab.omid.library.applovin.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.WindowManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.iab.omid.library.applovin.adsession.OutputDeviceStatus;
import com.iab.omid.library.applovin.walking.a;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static WindowManager f92186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String[] f92187b = {"x", "y", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static float f92188c = Resources.getSystem().getDisplayMetrics().density;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f92189a;

        static {
            int[] iArr = new int[OutputDeviceStatus.values().length];
            f92189a = iArr;
            try {
                iArr[OutputDeviceStatus.NOT_DETECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final float f92190a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final float f92191b;

        b(float f3, float f4) {
            this.f92190a = f3;
            this.f92191b = f4;
        }
    }

    static float a(int i3) {
        return i3 / f92188c;
    }

    public static void b(JSONObject jSONObject) {
        b bVarA = a(jSONObject);
        try {
            jSONObject.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, bVarA.f92190a);
            jSONObject.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, bVarA.f92191b);
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    private static boolean c(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("isFriendlyObstructionFor");
        JSONArray jSONArrayOptJSONArray2 = jSONObject2.optJSONArray("isFriendlyObstructionFor");
        if (jSONArrayOptJSONArray == null && jSONArrayOptJSONArray2 == null) {
            return true;
        }
        if (!a(jSONArrayOptJSONArray, jSONArrayOptJSONArray2)) {
            return false;
        }
        for (int i3 = 0; i3 < jSONArrayOptJSONArray.length(); i3++) {
            if (!jSONArrayOptJSONArray.optString(i3, "").equals(jSONArrayOptJSONArray2.optString(i3, ""))) {
                return false;
            }
        }
        return true;
    }

    private static boolean d(JSONObject jSONObject, JSONObject jSONObject2) {
        return Boolean.valueOf(jSONObject.optBoolean("hasWindowFocus")).equals(Boolean.valueOf(jSONObject2.optBoolean("hasWindowFocus")));
    }

    private static boolean e(JSONObject jSONObject, JSONObject jSONObject2) {
        return Boolean.valueOf(jSONObject.optBoolean("noOutputDevice")).equals(Boolean.valueOf(jSONObject2.optBoolean("noOutputDevice")));
    }

    private static boolean f(JSONObject jSONObject, JSONObject jSONObject2) {
        for (String str : f92187b) {
            if (jSONObject.optDouble(str) != jSONObject2.optDouble(str)) {
                return false;
            }
        }
        return true;
    }

    private static boolean g(JSONObject jSONObject, JSONObject jSONObject2) {
        return jSONObject.optString("adSessionId", "").equals(jSONObject2.optString("adSessionId", ""));
    }

    public static boolean h(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null && jSONObject2 == null) {
            return true;
        }
        return jSONObject != null && jSONObject2 != null && f(jSONObject, jSONObject2) && g(jSONObject, jSONObject2) && e(jSONObject, jSONObject2) && d(jSONObject, jSONObject2) && c(jSONObject, jSONObject2) && b(jSONObject, jSONObject2);
    }

    private static b a(JSONObject jSONObject) {
        float fA;
        float fA2;
        if (f92186a != null) {
            Point point = new Point(0, 0);
            f92186a.getDefaultDisplay().getRealSize(point);
            fA = a(point.x);
            fA2 = a(point.y);
        } else {
            fA = 0.0f;
            fA2 = 0.0f;
        }
        return new b(fA, fA2);
    }

    public static void b(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("notVisibleReason", str);
        } catch (JSONException e3) {
            d.a("Error with setting not visible reason", e3);
        }
    }

    public static JSONObject a(int i3, int i4, int i5, int i6) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", a(i3));
            jSONObject.put("y", a(i4));
            jSONObject.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, a(i5));
            jSONObject.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, a(i6));
            return jSONObject;
        } catch (JSONException e3) {
            d.a("Error with creating viewStateObject", e3);
            return jSONObject;
        }
    }

    private static boolean b(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("childViews");
        JSONArray jSONArrayOptJSONArray2 = jSONObject2.optJSONArray("childViews");
        if (jSONArrayOptJSONArray == null && jSONArrayOptJSONArray2 == null) {
            return true;
        }
        if (!a(jSONArrayOptJSONArray, jSONArrayOptJSONArray2)) {
            return false;
        }
        for (int i3 = 0; i3 < jSONArrayOptJSONArray.length(); i3++) {
            if (!h(jSONArrayOptJSONArray.optJSONObject(i3), jSONArrayOptJSONArray2.optJSONObject(i3))) {
                return false;
            }
        }
        return true;
    }

    public static void a(Context context) {
        if (context != null) {
            f92188c = context.getResources().getDisplayMetrics().density;
            f92186a = (WindowManager) context.getSystemService("window");
        }
    }

    public static void a(JSONObject jSONObject, OutputDeviceStatus outputDeviceStatus) {
        try {
            jSONObject.put("noOutputDevice", a(outputDeviceStatus));
        } catch (JSONException e3) {
            d.a("Error with setting output device status", e3);
        }
    }

    public static void a(JSONObject jSONObject, a.C0171a c0171a) {
        com.iab.omid.library.applovin.internal.e eVarA = c0171a.a();
        JSONArray jSONArray = new JSONArray();
        ArrayList<String> arrayListB = c0171a.b();
        int size = arrayListB.size();
        int i3 = 0;
        while (i3 < size) {
            String str = arrayListB.get(i3);
            i3++;
            jSONArray.put(str);
        }
        try {
            jSONObject.put("isFriendlyObstructionFor", jSONArray);
            jSONObject.put("friendlyObstructionClass", eVarA.d());
            jSONObject.put("friendlyObstructionPurpose", eVarA.b());
            jSONObject.put("friendlyObstructionReason", eVarA.a());
        } catch (JSONException e3) {
            d.a("Error with setting friendly obstruction", e3);
        }
    }

    public static void a(JSONObject jSONObject, Boolean bool) {
        try {
            jSONObject.put("hasWindowFocus", bool);
        } catch (JSONException e3) {
            d.a("Error with setting has window focus", e3);
        }
    }

    public static void a(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("adSessionId", str);
        } catch (JSONException e3) {
            d.a("Error with setting ad session id", e3);
        }
    }

    public static void a(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (NullPointerException | JSONException e3) {
            d.a("JSONException during JSONObject.put for name [" + str + "]", e3);
        }
    }

    public static void a(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("childViews");
            if (jSONArrayOptJSONArray == null) {
                jSONArrayOptJSONArray = new JSONArray();
                jSONObject.put("childViews", jSONArrayOptJSONArray);
            }
            jSONArrayOptJSONArray.put(jSONObject2);
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    private static boolean a(OutputDeviceStatus outputDeviceStatus) {
        return a.f92189a[outputDeviceStatus.ordinal()] == 1;
    }

    private static boolean a(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        return (jSONArray == null || jSONArray2 == null || jSONArray.length() != jSONArray2.length()) ? false : true;
    }
}
