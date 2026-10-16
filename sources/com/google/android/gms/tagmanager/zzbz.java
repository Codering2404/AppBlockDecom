package com.google.android.gms.tagmanager;

import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbz {
    private final long zza;
    private final long zzb;
    private String zzc;

    zzbz(long j3, long j4, long j5) {
        this.zza = j3;
        this.zzb = j5;
    }

    final long zza() {
        return this.zzb;
    }

    final long zzb() {
        return this.zza;
    }

    final String zzc() {
        return this.zzc;
    }

    final void zzd(String str) {
        if (str == null || TextUtils.isEmpty(str.trim())) {
            return;
        }
        this.zzc = str;
    }
}
