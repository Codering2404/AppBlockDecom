package com.google.android.gms.internal.ads;

import com.applovin.exoplayer2.common.base.Ascii;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzapj implements zzapt {
    private final zzes zza;
    private final zzet zzb;
    private final String zzc;
    private final int zzd;
    private final String zze;
    private String zzf;
    private zzahk zzg;
    private int zzh;
    private int zzi;
    private boolean zzj;
    private long zzk;
    private zzv zzl;
    private int zzm;
    private long zzn;

    public zzapj(String str, int i3, String str2) {
        zzes zzesVar = new zzes(new byte[ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD], ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
        this.zza = zzesVar;
        this.zzb = new zzet(zzesVar.zza);
        this.zzh = 0;
        this.zzn = -9223372036854775807L;
        this.zzc = str;
        this.zzd = i3;
        this.zze = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zza() {
        this.zzh = 0;
        this.zzi = 0;
        this.zzj = false;
        this.zzn = -9223372036854775807L;
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzb(zzagb zzagbVar, zzarh zzarhVar) {
        zzarhVar.zza();
        this.zzf = zzarhVar.zzc();
        this.zzg = zzagbVar.zzu(zzarhVar.zzb(), 1);
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzc(long j3, int i3) {
        this.zzn = j3;
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzd(zzet zzetVar) {
        this.zzg.getClass();
        while (zzetVar.zzd() > 0) {
            int i3 = this.zzh;
            if (i3 == 0) {
                while (true) {
                    if (zzetVar.zzd() <= 0) {
                        break;
                    }
                    if (this.zzj) {
                        int iZzs = zzetVar.zzs();
                        if (iZzs == 119) {
                            this.zzj = false;
                            this.zzh = 1;
                            zzet zzetVar2 = this.zzb;
                            zzetVar2.zzi()[0] = Ascii.VT;
                            zzetVar2.zzi()[1] = 119;
                            this.zzi = 2;
                            break;
                        }
                        this.zzj = iZzs == 11;
                    } else {
                        this.zzj = zzetVar.zzs() == 11;
                    }
                }
            } else if (i3 != 1) {
                int iMin = Math.min(zzetVar.zzd(), this.zzm - this.zzi);
                this.zzg.zzc(zzetVar, iMin);
                int i4 = this.zzi + iMin;
                this.zzi = i4;
                if (i4 == this.zzm) {
                    zzgtj.zzi(this.zzn != -9223372036854775807L);
                    this.zzg.zze(this.zzn, 1, this.zzm, 0, null);
                    this.zzn += this.zzk;
                    this.zzh = 0;
                }
            } else {
                zzet zzetVar3 = this.zzb;
                byte[] bArrZzi = zzetVar3.zzi();
                int iMin2 = Math.min(zzetVar.zzd(), 128 - this.zzi);
                zzetVar.zzm(bArrZzi, this.zzi, iMin2);
                int i5 = this.zzi + iMin2;
                this.zzi = i5;
                if (i5 == 128) {
                    zzes zzesVar = this.zza;
                    zzesVar.zzf(0);
                    zzaex zzaexVarZzc = zzaey.zzc(zzesVar);
                    zzv zzvVar = this.zzl;
                    if (zzvVar == null || zzaexVarZzc.zzc != zzvVar.zzH || zzaexVarZzc.zzb != zzvVar.zzI || !Objects.equals(zzaexVarZzc.zza, zzvVar.zzp)) {
                        zzt zztVar = new zzt();
                        zztVar.zza(this.zzf);
                        zztVar.zzn(this.zze);
                        String str = zzaexVarZzc.zza;
                        zztVar.zzo(str);
                        zztVar.zzG(zzaexVarZzc.zzc);
                        zztVar.zzH(zzaexVarZzc.zzb);
                        zztVar.zze(this.zzc);
                        zztVar.zzg(this.zzd);
                        int i6 = zzaexVarZzc.zzf;
                        zztVar.zzj(i6);
                        if ("audio/ac3".equals(str)) {
                            zztVar.zzi(i6);
                        }
                        zzv zzvVarZzO = zztVar.zzO();
                        this.zzl = zzvVarZzO;
                        this.zzg.zzA(zzvVarZzO);
                    }
                    this.zzm = zzaexVarZzc.zzd;
                    this.zzk = (((long) zzaexVarZzc.zze) * 1000000) / ((long) this.zzl.zzI);
                    zzetVar3.zzh(0);
                    this.zzg.zzc(zzetVar3, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                    this.zzh = 2;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zze(boolean z2) {
    }
}
