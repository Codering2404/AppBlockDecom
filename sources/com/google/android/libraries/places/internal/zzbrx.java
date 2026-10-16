package com.google.android.libraries.places.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbrx implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f76750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzbsb f76751b;

    zzbrx(zzbsb zzbsbVar, boolean z2) {
        this.f76750a = z2;
        Objects.requireNonNull(zzbsbVar);
        this.f76751b = zzbsbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f76750a) {
            zzbse zzbseVar = this.f76751b.f76759b;
            zzbseVar.f76780n = true;
            if (zzbseVar.i() > 0) {
                zzbseVar.k().h().i();
            }
        }
        this.f76751b.f76759b.l(false);
    }
}
