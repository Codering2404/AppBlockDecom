package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzalg implements zzald {
    private final int zza;
    private final int zzb;
    private final zzet zzc;

    public zzalg(zzfy zzfyVar, zzv zzvVar) {
        zzet zzetVar = zzfyVar.zza;
        this.zzc = zzetVar;
        zzetVar.zzh(12);
        int iZzH = zzetVar.zzH();
        if ("audio/raw".equals(zzvVar.zzp)) {
            int iZzG = zzfl.zzG(zzvVar.zzJ) * zzvVar.zzH;
            if (iZzH % iZzG != 0) {
                StringBuilder sb = new StringBuilder(String.valueOf(iZzG).length() + 66 + String.valueOf(iZzH).length());
                sb.append("Audio sample size mismatch. stsd sample size: ");
                sb.append(iZzG);
                sb.append(", stsz sample size: ");
                sb.append(iZzH);
                zzeg.zzc("BoxParsers", sb.toString());
                iZzH = iZzG;
            }
        }
        this.zza = iZzH == 0 ? -1 : iZzH;
        this.zzb = zzetVar.zzH();
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final int zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final int zzb() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final int zzc() {
        int i3 = this.zza;
        return i3 == -1 ? this.zzc.zzH() : i3;
    }
}
