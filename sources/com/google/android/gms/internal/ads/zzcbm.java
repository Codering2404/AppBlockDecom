package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcbm extends zzcbo {
    private final String zza;
    private final int zzb;

    public zzcbm(String str, int i3) {
        this.zza = str;
        this.zzb = i3;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzcbm)) {
            return false;
        }
        zzcbm zzcbmVar = (zzcbm) obj;
        if (Objects.b(this.zza, zzcbmVar.zza)) {
            if (Objects.b(Integer.valueOf(this.zzb), Integer.valueOf(zzcbmVar.zzb))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzcbp
    public final String zzb() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzcbp
    public final int zzc() {
        return this.zzb;
    }
}
