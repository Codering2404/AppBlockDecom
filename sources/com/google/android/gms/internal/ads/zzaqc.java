package com.google.android.gms.internal.ads;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.Collections;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaqc implements zzapt {
    private final zzaqw zza;
    private String zzb;
    private zzahk zzc;
    private zzaqb zzd;
    private boolean zze;
    private long zzl;
    private final boolean[] zzf = new boolean[3];
    private final zzaqk zzg = new zzaqk(32, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
    private final zzaqk zzh = new zzaqk(33, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
    private final zzaqk zzi = new zzaqk(34, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
    private final zzaqk zzj = new zzaqk(39, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
    private final zzaqk zzk = new zzaqk(40, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
    private long zzm = -9223372036854775807L;
    private final zzet zzn = new zzet();

    public zzaqc(zzaqw zzaqwVar, String str) {
        this.zza = zzaqwVar;
    }

    @RequiresNonNull
    private final void zzf(long j3, int i3, int i4, long j4) {
        this.zzd.zzb(j3, i3, i4, j4, this.zze);
        if (!this.zze) {
            this.zzg.zzc(i4);
            this.zzh.zzc(i4);
            this.zzi.zzc(i4);
        }
        this.zzj.zzc(i4);
        this.zzk.zzc(i4);
    }

    @RequiresNonNull
    private final void zzg(byte[] bArr, int i3, int i4) {
        this.zzd.zzc(bArr, i3, i4);
        if (!this.zze) {
            this.zzg.zzd(bArr, i3, i4);
            this.zzh.zzd(bArr, i3, i4);
            this.zzi.zzd(bArr, i3, i4);
        }
        this.zzj.zzd(bArr, i3, i4);
        this.zzk.zzd(bArr, i3, i4);
    }

    @RequiresNonNull
    private final void zzh(long j3, int i3, int i4, long j4) {
        this.zzd.zzd(j3, i3, this.zze);
        if (!this.zze) {
            zzaqk zzaqkVar = this.zzg;
            zzaqkVar.zze(i4);
            zzaqk zzaqkVar2 = this.zzh;
            zzaqkVar2.zze(i4);
            zzaqk zzaqkVar3 = this.zzi;
            zzaqkVar3.zze(i4);
            if (zzaqkVar.zzb() && zzaqkVar2.zzb() && zzaqkVar3.zzb()) {
                String str = this.zzb;
                int i5 = zzaqkVar.zzb;
                byte[] bArr = new byte[zzaqkVar2.zzb + i5 + zzaqkVar3.zzb];
                System.arraycopy(zzaqkVar.zza, 0, bArr, 0, i5);
                System.arraycopy(zzaqkVar2.zza, 0, bArr, zzaqkVar.zzb, zzaqkVar2.zzb);
                System.arraycopy(zzaqkVar3.zza, 0, bArr, zzaqkVar.zzb + zzaqkVar2.zzb, zzaqkVar3.zzb);
                String strZzc = null;
                zzgj zzgjVarZzg = zzgp.zzg(zzaqkVar2.zza, 3, zzaqkVar2.zzb, null);
                zzge zzgeVar = zzgjVarZzg.zzb;
                if (zzgeVar != null) {
                    int i6 = zzgeVar.zzf;
                    int[] iArr = zzgeVar.zze;
                    int i7 = zzgeVar.zzd;
                    strZzc = zzdq.zzc(zzgeVar.zza, zzgeVar.zzb, zzgeVar.zzc, i7, iArr, i6);
                }
                zzt zztVar = new zzt();
                zztVar.zza(str);
                zztVar.zzn("video/mp2t");
                zztVar.zzo("video/hevc");
                zztVar.zzk(strZzc);
                zztVar.zzv(zzgjVarZzg.zze);
                zztVar.zzw(zzgjVarZzg.zzf);
                zztVar.zzx(zzgjVarZzg.zzg);
                zztVar.zzy(zzgjVarZzg.zzh);
                zzh zzhVar = new zzh();
                zzhVar.zza(zzgjVarZzg.zzk);
                zzhVar.zzb(zzgjVarZzg.zzl);
                zzhVar.zzc(zzgjVarZzg.zzm);
                zzhVar.zze(zzgjVarZzg.zzc + 8);
                zzhVar.zzf(zzgjVarZzg.zzd + 8);
                zztVar.zzE(zzhVar.zzg());
                zztVar.zzB(zzgjVarZzg.zzi);
                zztVar.zzq(zzgjVarZzg.zzj);
                zztVar.zzF(zzgjVarZzg.zza + 1);
                zztVar.zzr(Collections.singletonList(bArr));
                zzv zzvVarZzO = zztVar.zzO();
                this.zzc.zzA(zzvVarZzO);
                int i8 = zzvVarZzO.zzr;
                zzgtj.zzi(i8 != -1);
                this.zza.zzb(i8);
                this.zze = true;
            }
        }
        zzaqk zzaqkVar4 = this.zzj;
        if (zzaqkVar4.zze(i4)) {
            int iZza = zzgp.zza(zzaqkVar4.zza, zzaqkVar4.zzb);
            zzet zzetVar = this.zzn;
            zzetVar.zzb(zzaqkVar4.zza, iZza);
            zzetVar.zzk(5);
            this.zza.zzc(j4, zzetVar);
        }
        zzaqk zzaqkVar5 = this.zzk;
        if (zzaqkVar5.zze(i4)) {
            int iZza2 = zzgp.zza(zzaqkVar5.zza, zzaqkVar5.zzb);
            zzet zzetVar2 = this.zzn;
            zzetVar2.zzb(zzaqkVar5.zza, iZza2);
            zzetVar2.zzk(5);
            this.zza.zzc(j4, zzetVar2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zza() {
        this.zzl = 0L;
        this.zzm = -9223372036854775807L;
        zzgp.zzj(this.zzf);
        this.zzg.zza();
        this.zzh.zza();
        this.zzi.zza();
        this.zzj.zza();
        this.zzk.zza();
        this.zza.zze();
        zzaqb zzaqbVar = this.zzd;
        if (zzaqbVar != null) {
            zzaqbVar.zza();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzb(zzagb zzagbVar, zzarh zzarhVar) {
        zzarhVar.zza();
        this.zzb = zzarhVar.zzc();
        zzahk zzahkVarZzu = zzagbVar.zzu(zzarhVar.zzb(), 2);
        this.zzc = zzahkVarZzu;
        this.zzd = new zzaqb(zzahkVarZzu);
        this.zza.zza(zzagbVar, zzarhVar);
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzc(long j3, int i3) {
        this.zzm = j3;
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzd(zzet zzetVar) {
        this.zzc.getClass();
        String str = zzfl.zza;
        while (zzetVar.zzd() > 0) {
            int iZzg = zzetVar.zzg();
            int iZze = zzetVar.zze();
            byte[] bArrZzi = zzetVar.zzi();
            this.zzl += (long) zzetVar.zzd();
            this.zzc.zzc(zzetVar, zzetVar.zzd());
            while (iZzg < iZze) {
                int iZzi = zzgp.zzi(bArrZzi, iZzg, iZze, this.zzf);
                if (iZzi == iZze) {
                    zzg(bArrZzi, iZzg, iZze);
                    return;
                }
                int i3 = bArrZzi[iZzi + 3] & 126;
                int i4 = 3;
                if (iZzi > 0) {
                    int i5 = iZzi - 1;
                    if (bArrZzi[i5] == 0) {
                        i4 = 4;
                        iZzi = i5;
                    }
                }
                int i6 = iZzi - iZzg;
                if (i6 > 0) {
                    zzg(bArrZzi, iZzg, iZzi);
                }
                int i7 = iZze - iZzi;
                long j3 = this.zzl - ((long) i7);
                zzh(j3, i7, i6 < 0 ? -i6 : 0, this.zzm);
                zzf(j3, i7, i3 >> 1, this.zzm);
                iZzg = iZzi + i4;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zze(boolean z2) {
        this.zzc.getClass();
        String str = zzfl.zza;
        if (z2) {
            this.zza.zzd();
            zzh(this.zzl, 0, 0, this.zzm);
            zzf(this.zzl, 0, 48, this.zzm);
        }
    }
}
