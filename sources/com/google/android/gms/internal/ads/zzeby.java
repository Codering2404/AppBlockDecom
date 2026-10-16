package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzeby implements zzdjz {
    private final Bundle zza = new Bundle();

    @Override // com.google.android.gms.internal.ads.zzdjz
    public final synchronized void zza(String str) {
        this.zza.putInt(str, 1);
    }

    @Override // com.google.android.gms.internal.ads.zzdjz
    public final synchronized void zzb(String str) {
        this.zza.putInt(str, 2);
    }

    @Override // com.google.android.gms.internal.ads.zzdjz
    public final synchronized void zzc(String str, String str2) {
        this.zza.putInt(str, 3);
    }

    public final synchronized Bundle zzg() {
        return new Bundle(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzdjz
    public final void zze() {
    }

    @Override // com.google.android.gms.internal.ads.zzdjz
    public final void zzf() {
    }

    @Override // com.google.android.gms.internal.ads.zzdjz
    public final void zzd(String str) {
    }
}
