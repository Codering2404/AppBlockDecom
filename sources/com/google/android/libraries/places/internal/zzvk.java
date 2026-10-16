package com.google.android.libraries.places.internal;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class zzvk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final zzvk f78689a = new zzve();

    /* synthetic */ zzvk(byte[] bArr) {
    }

    public static zzvk d(zzut zzutVar, zzut zzutVar2) {
        int iA = zzutVar2.a();
        if (iA == 0) {
            return f78689a;
        }
        byte[] bArr = null;
        return iA <= 28 ? new zzvi(zzutVar, zzutVar2, bArr) : new zzvj(zzutVar, zzutVar2, bArr);
    }

    public abstract void a(zzva zzvaVar, Object obj);

    public abstract int b();

    public abstract Set c();
}
