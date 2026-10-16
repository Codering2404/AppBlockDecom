package com.singular.sdk.internal.utils;

import com.singular.sdk.internal.SingularLog;
import com.singular.sdk.internal.Utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class SLJsonUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SingularLog f92756a = SingularLog.f(SLJsonUtils.class.getSimpleName());

    public static Map a(JSONObject jSONObject) {
        return jSONObject != JSONObject.NULL ? c(jSONObject) : new HashMap();
    }

    public static List b(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            try {
                Object objC = jSONArray.get(i3);
                if (objC instanceof JSONArray) {
                    objC = b((JSONArray) objC);
                } else if (objC instanceof JSONObject) {
                    objC = c((JSONObject) objC);
                }
                arrayList.add(objC);
            } catch (Throwable th) {
                f92756a.a(Utils.l(th));
                return arrayList;
            }
        }
        return arrayList;
    }

    public static Map c(JSONObject jSONObject) {
        HashMap map = new HashMap();
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object objC = jSONObject.get(next);
                if (objC instanceof JSONArray) {
                    objC = b((JSONArray) objC);
                } else if (objC instanceof JSONObject) {
                    objC = c((JSONObject) objC);
                }
                map.put(next, objC);
            }
            return map;
        } catch (Throwable th) {
            f92756a.a(Utils.l(th));
            return map;
        }
    }
}
