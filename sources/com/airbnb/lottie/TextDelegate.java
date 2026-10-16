package com.airbnb.lottie;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class TextDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f56427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f56428b;

    public String b(String str, String str2) {
        return a(str2);
    }

    public final String c(String str, String str2) {
        if (this.f56428b && this.f56427a.containsKey(str2)) {
            return (String) this.f56427a.get(str2);
        }
        String strB = b(str, str2);
        if (this.f56428b) {
            this.f56427a.put(str2, strB);
        }
        return strB;
    }

    public String a(String str) {
        return str;
    }
}
