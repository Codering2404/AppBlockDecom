package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfzi extends zzfzo {
    private String zza;
    private byte zzb;
    private int zzc;
    private int zzd;

    zzfzi() {
    }

    public final zzfzo zza(String str) {
        this.zza = "";
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfzo
    public final zzfzo zzb(boolean z2) {
        this.zzb = (byte) 1;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfzo
    public final zzfzp zzc() {
        if (this.zzb == 1 && this.zza != null && this.zzc != 0 && this.zzd != 0) {
            return new zzfzj(this.zza, false, this.zzc, null, this.zzd, null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.zza == null) {
            sb.append(" fileOwner");
        }
        if (this.zzb == 0) {
            sb.append(" hasDifferentDmaOwner");
        }
        if (this.zzc == 0) {
            sb.append(" fileChecks");
        }
        if (this.zzd == 0) {
            sb.append(" filePurpose");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    @Override // com.google.android.gms.internal.ads.zzfzo
    final zzfzo zzd(int i3) {
        this.zzc = i3;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfzo
    public final zzfzo zze(int i3) {
        this.zzd = 1;
        return this;
    }
}
