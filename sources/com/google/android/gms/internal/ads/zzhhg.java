package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhhg extends zzheu {
    private final zzhhf zza;
    private final String zzb;
    private final zzhhe zzc;
    private final zzheu zzd;

    /* synthetic */ zzhhg(zzhhf zzhhfVar, String str, zzhhe zzhheVar, zzheu zzheuVar, byte[] bArr) {
        this.zza = zzhhfVar;
        this.zzb = str;
        this.zzc = zzhheVar;
        this.zzd = zzheuVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzhhg)) {
            return false;
        }
        zzhhg zzhhgVar = (zzhhg) obj;
        return zzhhgVar.zzc.equals(this.zzc) && zzhhgVar.zzd.equals(this.zzd) && zzhhgVar.zzb.equals(this.zzb) && zzhhgVar.zza.equals(this.zza);
    }

    public final int hashCode() {
        return Objects.hash(zzhhg.class, this.zzb, this.zzc, this.zzd, this.zza);
    }

    public final String toString() {
        zzhhf zzhhfVar = this.zza;
        zzheu zzheuVar = this.zzd;
        String strValueOf = String.valueOf(this.zzc);
        String strValueOf2 = String.valueOf(zzheuVar);
        String strValueOf3 = String.valueOf(zzhhfVar);
        String str = this.zzb;
        int length = String.valueOf(str).length();
        int length2 = strValueOf.length();
        StringBuilder sb = new StringBuilder(length + 64 + length2 + 27 + strValueOf2.length() + 11 + strValueOf3.length() + 1);
        sb.append("LegacyKmsEnvelopeAead Parameters (kekUri: ");
        sb.append(str);
        sb.append(", dekParsingStrategy: ");
        sb.append(strValueOf);
        sb.append(", dekParametersForNewKeys: ");
        sb.append(strValueOf2);
        sb.append(", variant: ");
        sb.append(strValueOf3);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzheh
    public final boolean zza() {
        return this.zza != zzhhf.zzb;
    }

    public final String zzb() {
        return this.zzb;
    }

    public final zzhhf zzc() {
        return this.zza;
    }

    public final zzheu zzd() {
        return this.zzd;
    }
}
