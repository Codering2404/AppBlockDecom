package com.google.firebase.crashlytics.internal.metadata;

import com.facebook.share.HKJ.pnxuebdT;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class KeysMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f88516a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f88517b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f88518c;

    public KeysMap(int i3, int i4) {
        this.f88517b = i3;
        this.f88518c = i4;
    }

    private String b(String str) {
        if (str != null) {
            return c(str, this.f88518c);
        }
        throw new IllegalArgumentException("Custom attribute key must not be null.");
    }

    public static String c(String str, int i3) {
        if (str == null) {
            return str;
        }
        String strTrim = str.trim();
        return strTrim.length() > i3 ? strTrim.substring(0, i3) : strTrim;
    }

    public synchronized Map a() {
        return Collections.unmodifiableMap(new HashMap(this.f88516a));
    }

    public synchronized boolean d(String str, String str2) {
        String strB = b(str);
        if (this.f88516a.size() >= this.f88517b && !this.f88516a.containsKey(strB)) {
            Logger.f().k(pnxuebdT.hjzoozNgBBkjyE + str + "\" when adding custom keys. Maximum allowable: " + this.f88517b);
            return false;
        }
        String strC = c(str2, this.f88518c);
        if (CommonUtils.z((String) this.f88516a.get(strB), strC)) {
            return false;
        }
        Map map = this.f88516a;
        if (str2 == null) {
            strC = "";
        }
        map.put(strB, strC);
        return true;
    }

    public synchronized void e(Map map) {
        try {
            int i3 = 0;
            for (Map.Entry entry : map.entrySet()) {
                String strB = b((String) entry.getKey());
                if (this.f88516a.size() < this.f88517b || this.f88516a.containsKey(strB)) {
                    String str = (String) entry.getValue();
                    this.f88516a.put(strB, str == null ? "" : c(str, this.f88518c));
                } else {
                    i3++;
                }
            }
            if (i3 > 0) {
                Logger.f().k("Ignored " + i3 + " entries when adding custom keys. Maximum allowable: " + this.f88517b);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
