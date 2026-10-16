package com.google.android.libraries.places.internal;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbxt implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzbxv f77176a;

    /* synthetic */ zzbxt(zzbxv zzbxvVar, byte[] bArr) {
        Objects.requireNonNull(zzbxvVar);
        this.f77176a = zzbxvVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbxv zzbxvVar = this.f77176a;
        byte[] bArr = null;
        if (!zzbxvVar.h()) {
            zzbxvVar.j(null);
            return;
        }
        long jG = zzbxvVar.g();
        long jC = zzbxvVar.c();
        if (jG - jC > 0) {
            zzbxvVar.j(zzbxvVar.d().schedule(new zzbxu(zzbxvVar, bArr), zzbxvVar.g() - jC, TimeUnit.NANOSECONDS));
        } else {
            zzbxvVar.i(false);
            zzbxvVar.j(null);
            zzbxvVar.f().run();
        }
    }
}
