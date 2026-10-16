package com.google.android.libraries.places.internal;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbjk {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final zzbjk f76279b = new zzbjk(new zzbjg(), zzbjh.f76278a);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f76280c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentMap f76281a = new ConcurrentHashMap();

    zzbjk(zzbjj... zzbjjVarArr) {
        for (int i3 = 0; i3 < 2; i3++) {
            zzbjj zzbjjVar = zzbjjVarArr[i3];
            this.f76281a.put(zzbjjVar.zza(), zzbjjVar);
        }
    }

    public static zzbjk a() {
        return f76279b;
    }
}
