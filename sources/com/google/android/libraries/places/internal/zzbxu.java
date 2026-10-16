package com.google.android.libraries.places.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbxu implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzbxv f77177a;

    /* synthetic */ zzbxu(zzbxv zzbxvVar, byte[] bArr) {
        Objects.requireNonNull(zzbxvVar);
        this.f77177a = zzbxvVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbxv zzbxvVar = this.f77177a;
        zzbxt zzbxtVar = new zzbxt(zzbxvVar, null);
        zzbnx zzbnxVar = (zzbnx) zzbxvVar.e();
        zzbnxVar.a(zzbxtVar);
        zzbnxVar.zza();
    }
}
