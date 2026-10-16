package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzyn implements zzzc {
    final /* synthetic */ zzyq zza;
    private final int zzb;

    public zzyn(zzyq zzyqVar, int i3) {
        Objects.requireNonNull(zzyqVar);
        this.zza = zzyqVar;
        this.zzb = i3;
    }

    final /* synthetic */ int zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final boolean zzb() {
        return this.zza.zzp(this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final void zzc() throws IOException {
        this.zza.zzq(this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final int zzd(zzlw zzlwVar, zziv zzivVar, int i3) {
        return this.zza.zzs(this.zzb, zzlwVar, zzivVar, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final int zze(long j3) {
        return this.zza.zzt(this.zzb, j3);
    }
}
