package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgqt extends zzgru {
    private int zza;
    private String zzb;
    private int zzc;
    private byte zzd;

    zzgqt() {
    }

    @Override // com.google.android.gms.internal.ads.zzgru
    public final zzgru zza(int i3) {
        this.zza = i3;
        this.zzd = (byte) (this.zzd | 1);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzgru
    public final zzgru zzb(String str) {
        this.zzb = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzgru
    public final zzgru zzc(int i3) {
        this.zzc = i3;
        this.zzd = (byte) (this.zzd | 2);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzgru
    public final zzgrv zzd() {
        if (this.zzd == 3) {
            return new zzgqu(this.zza, this.zzb, this.zzc, null);
        }
        StringBuilder sb = new StringBuilder();
        if ((this.zzd & 1) == 0) {
            sb.append(" statusCode");
        }
        if ((this.zzd & 2) == 0) {
            sb.append(" uiMode");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}
