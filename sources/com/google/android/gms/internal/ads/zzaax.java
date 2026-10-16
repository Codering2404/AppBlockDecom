package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzaax extends zzaaq {
    private final boolean zze;
    private final zzaam zzf;
    private final boolean zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final int zzm;
    private final int zzn;
    private final int zzo;
    private final int zzp;
    private final boolean zzq;
    private final int zzr;
    private final int zzs;
    private final boolean zzt;
    private final boolean zzu;
    private final int zzv;

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public zzaax(int r5, com.google.android.gms.internal.ads.zzbg r6, int r7, com.google.android.gms.internal.ads.zzaam r8, int r9, java.lang.String r10, int r11, boolean r12) {
        /*
            Method dump skipped, instruction units count: 426
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaax.<init>(int, com.google.android.gms.internal.ads.zzbg, int, com.google.android.gms.internal.ads.zzaam, int, java.lang.String, int, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzi(zzaax zzaaxVar, zzaax zzaaxVar2) {
        zzgvz zzgvzVarZza = zzgvz.zzg().zzd(zzaaxVar.zzh, zzaaxVar2.zzh).zza(Integer.valueOf(zzaaxVar.zzm), Integer.valueOf(zzaaxVar2.zzm), zzgyg.zzb().zza()).zzb(zzaaxVar.zzn, zzaaxVar2.zzn).zzb(zzaaxVar.zzo, zzaaxVar2.zzo).zza(Integer.valueOf(zzaaxVar.zzp), Integer.valueOf(zzaaxVar2.zzp), zzgyg.zzb().zza()).zzd(zzaaxVar.zzq, zzaaxVar2.zzq).zzb(zzaaxVar.zzr, zzaaxVar2.zzr).zzd(zzaaxVar.zzi, zzaaxVar2.zzi).zzd(zzaaxVar.zze, zzaaxVar2.zze).zzd(zzaaxVar.zzg, zzaaxVar2.zzg).zza(Integer.valueOf(zzaaxVar.zzl), Integer.valueOf(zzaaxVar2.zzl), zzgyg.zzb().zza());
        boolean z2 = zzaaxVar.zzt;
        zzgvz zzgvzVarZzd = zzgvzVarZza.zzd(z2, zzaaxVar2.zzt);
        boolean z3 = zzaaxVar.zzu;
        zzgvz zzgvzVarZzd2 = zzgvzVarZzd.zzd(z3, zzaaxVar2.zzu);
        if (z2 && z3) {
            zzgvzVarZzd2 = zzgvzVarZzd2.zzb(zzaaxVar.zzv, zzaaxVar2.zzv);
        }
        return zzgvzVarZzd2.zze();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzj(zzaax zzaaxVar, zzaax zzaaxVar2) {
        zzgyg zzgygVarZza = (zzaaxVar.zze && zzaaxVar.zzh) ? zzaay.zzc : zzaay.zzc.zza();
        zzgvz zzgvzVarZzg = zzgvz.zzg();
        boolean z2 = zzaaxVar.zzf.zzF;
        return zzgvzVarZzg.zza(Integer.valueOf(zzaaxVar.zzk), Integer.valueOf(zzaaxVar2.zzk), zzgygVarZza).zza(Integer.valueOf(zzaaxVar.zzj), Integer.valueOf(zzaaxVar2.zzj), zzgygVarZza).zze();
    }

    @Override // com.google.android.gms.internal.ads.zzaaq
    public final int zza() {
        return this.zzs;
    }

    @Override // com.google.android.gms.internal.ads.zzaaq
    public final /* bridge */ /* synthetic */ boolean zzc(zzaaq zzaaqVar) {
        zzaax zzaaxVar = (zzaax) zzaaqVar;
        if (!Objects.equals(this.zzd.zzp, zzaaxVar.zzd.zzp)) {
            return false;
        }
        boolean z2 = this.zzf.zzN;
        return this.zzt == zzaaxVar.zzt && this.zzu == zzaaxVar.zzu;
    }
}
