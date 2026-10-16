package com.google.android.gms.internal.ads;

import com.applovin.impl.privacy.consentFlow.as.KLAQHFCRAUejH;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfxl extends zzfxi {
    private final String zza;
    private final boolean zzb;
    private final boolean zzc;
    private final long zzd;
    private final long zze;

    /* synthetic */ zzfxl(String str, boolean z2, boolean z3, boolean z4, long j3, boolean z5, long j4, byte[] bArr) {
        this.zza = str;
        this.zzb = z2;
        this.zzc = z3;
        this.zzd = j3;
        this.zze = j4;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfxi) {
            zzfxi zzfxiVar = (zzfxi) obj;
            if (this.zza.equals(zzfxiVar.zza()) && this.zzb == zzfxiVar.zzb() && this.zzc == zzfxiVar.zzc()) {
                zzfxiVar.zzd();
                if (this.zzd == zzfxiVar.zze()) {
                    zzfxiVar.zzf();
                    if (this.zze == zzfxiVar.zzg()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((((((this.zza.hashCode() ^ 1000003) * 1000003) ^ (true != this.zzb ? 1237 : 1231)) * 1000003) ^ (true != this.zzc ? 1237 : 1231)) * 1000003) ^ 1237) * 1000003) ^ ((int) this.zzd)) * 1000003) ^ 1237) * 1000003) ^ ((int) this.zze);
    }

    @Override // com.google.android.gms.internal.ads.zzfxi
    public final String zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzfxi
    public final boolean zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfxi
    public final boolean zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzfxi
    public final boolean zzd() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzfxi
    public final long zze() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzfxi
    public final boolean zzf() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzfxi
    public final long zzg() {
        return this.zze;
    }

    public final String toString() {
        boolean z2 = this.zzb;
        int length = String.valueOf(z2).length();
        boolean z3 = this.zzc;
        int length2 = String.valueOf(z3).length();
        long j3 = this.zzd;
        int length3 = String.valueOf(j3).length();
        long j4 = this.zze;
        int length4 = String.valueOf(j4).length();
        String str = this.zza;
        StringBuilder sb = new StringBuilder(str.length() + 56 + length + 32 + length2 + 57 + length3 + 61 + length4 + 1);
        sb.append("AdShield2Options{clientVersion=");
        sb.append(str);
        sb.append(", shouldGetAdvertisingId=");
        sb.append(z2);
        sb.append(", isGooglePlayServicesAvailable=");
        sb.append(z3);
        sb.append(KLAQHFCRAUejH.fyiB);
        sb.append(j3);
        sb.append(", enableQuerySignalsCache=false, querySignalsCacheTtlSeconds=");
        sb.append(j4);
        sb.append("}");
        return sb.toString();
    }
}
