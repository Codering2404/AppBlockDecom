package com.google.android.libraries.places.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzboi implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f76545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzboj f76546b;

    zzboi(zzboj zzbojVar, zzcev zzcevVar, int i3) {
        this.f76545a = i3;
        Objects.requireNonNull(zzbojVar);
        this.f76546b = zzbojVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            int i3 = zzcew.f77735a;
            this.f76546b.r().zzc(this.f76545a);
        } catch (Throwable th) {
            this.f76546b.d(th);
        }
    }
}
