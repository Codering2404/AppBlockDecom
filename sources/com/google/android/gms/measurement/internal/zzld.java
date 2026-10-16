package com.google.android.gms.measurement.internal;

import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final /* synthetic */ class zzld implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ zzld f74127a = new zzld();

    private /* synthetic */ zzld() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return Long.compare(((Long) obj).longValue(), ((Long) obj2).longValue());
    }
}
