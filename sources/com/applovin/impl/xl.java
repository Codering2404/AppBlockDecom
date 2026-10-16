package com.applovin.impl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
abstract class xl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final qo f65002a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class a extends ch {
        public a(String str) {
            super(str, null, false, 1);
        }
    }

    protected xl(qo qoVar) {
        this.f65002a = qoVar;
    }

    protected abstract boolean a(ah ahVar);

    public final boolean a(ah ahVar, long j3) {
        return a(ahVar) && b(ahVar, j3);
    }

    protected abstract boolean b(ah ahVar, long j3);
}
