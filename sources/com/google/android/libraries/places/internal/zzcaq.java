package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzcaq implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzcat f77345a;

    zzcaq(zzcat zzcatVar) {
        Objects.requireNonNull(zzcatVar);
        this.f77345a = zzcatVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            zzcat zzcatVar = this.f77345a;
            if (zzcatVar.k() != null && zzcatVar.zze().zzb() > 0) {
                zzcatVar.k().i2(zzcatVar.zze(), zzcatVar.zze().zzb());
            }
        } catch (IOException e3) {
            this.f77345a.f().d(e3);
        }
        try {
            zzcat zzcatVar2 = this.f77345a;
            if (zzcatVar2.k() != null) {
                zzcatVar2.k().close();
            }
        } catch (IOException e4) {
            this.f77345a.f().d(e4);
        }
        try {
            zzcat zzcatVar3 = this.f77345a;
            if (zzcatVar3.l() != null) {
                zzcatVar3.l().close();
            }
        } catch (IOException e5) {
            this.f77345a.f().d(e5);
        }
    }
}
