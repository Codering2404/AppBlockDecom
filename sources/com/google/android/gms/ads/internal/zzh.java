package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzfye;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzh implements zzfye {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzk f70401a;

    zzh(zzk zzkVar) {
        Objects.requireNonNull(zzkVar);
        this.f70401a = zzkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfye
    public final void zza(int i3, long j3) {
        this.f70401a.f().zzb(i3, System.currentTimeMillis() - j3);
    }

    @Override // com.google.android.gms.internal.ads.zzfye
    public final void zzb(int i3, long j3, String str) {
        this.f70401a.f().zzf(i3, System.currentTimeMillis() - j3, str);
    }
}
