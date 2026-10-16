package com.applovin.impl;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class g4 {
    public static List a(com.applovin.impl.sdk.j jVar) {
        if (!jVar.u().j()) {
            return null;
        }
        boolean zR0 = jVar.r0();
        Boolean bool = (Boolean) jVar.a(uj.f64239o, Boolean.FALSE);
        if (!zR0) {
            return b(jVar);
        }
        if (bool.booleanValue()) {
            return b(jVar);
        }
        return null;
    }

    private static List b(com.applovin.impl.sdk.j jVar) {
        return jVar.u().h() != null ? n4.b(jVar) : n4.a(jVar);
    }

    public static List c(com.applovin.impl.sdk.j jVar) {
        if (jVar.u().j()) {
            return n4.c(jVar);
        }
        return null;
    }
}
