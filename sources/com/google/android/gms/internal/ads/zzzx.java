package com.google.android.gms.internal.ads;

import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.common.api.Api;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzzx extends zzaaq implements Comparable {
    private final int zze;
    private final boolean zzf;
    private final String zzg;
    private final zzaam zzh;
    private final boolean zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final int zzm;
    private final boolean zzn;
    private final int zzo;
    private final int zzp;
    private final boolean zzq;
    private final int zzr;
    private final int zzs;
    private final int zzt;
    private final int zzu;
    private final boolean zzv;
    private final boolean zzw;
    private final boolean zzx;

    public zzzx(int i3, zzbg zzbgVar, int i4, zzaam zzaamVar, int i5, boolean z2, zzgtk zzgtkVar, int i6) {
        int i7;
        int iZzj;
        int iHashCode;
        int iZzj2;
        boolean z3;
        super(i3, zzbgVar, i4);
        this.zzh = zzaamVar;
        int i8 = 1;
        int i9 = true != zzaamVar.zzT ? 16 : 24;
        this.zzg = zzaay.zzi(this.zzd.zzd);
        this.zzi = zznc.zzac(i5, false);
        int i10 = 0;
        while (true) {
            int size = zzaamVar.zzq.size();
            i7 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            if (i10 >= size) {
                iZzj = 0;
                i10 = Integer.MAX_VALUE;
                break;
            } else {
                iZzj = zzaay.zzj(this.zzd, (String) zzaamVar.zzq.get(i10), false);
                if (iZzj > 0) {
                    break;
                } else {
                    i10++;
                }
            }
        }
        this.zzk = i10;
        this.zzj = iZzj;
        this.zzl = zzaay.zzm(this.zzd.zzf, 0);
        this.zzm = zzaay.zzn(this.zzd, zzaamVar.zzr);
        zzv zzvVar = this.zzd;
        int i11 = zzvVar.zzf;
        this.zzn = i11 == 0 || (i11 & 1) != 0;
        this.zzq = 1 == (zzvVar.zze & 1);
        String str = zzvVar.zzp;
        this.zzx = str != null && ((iHashCode = str.hashCode()) == -2123537834 ? str.equals("audio/eac3-joc") : !(iHashCode == 187078297 ? !str.equals("audio/ac4") : !(iHashCode == 1504698186 && str.equals("audio/iamf"))));
        int i12 = zzvVar.zzH;
        this.zzr = i12;
        this.zzs = zzvVar.zzI;
        int i13 = zzvVar.zzj;
        this.zzt = i13;
        this.zzf = (i13 == -1 || i13 <= zzaamVar.zzu) && (i12 == -1 || i12 <= zzaamVar.zzt) && zzgtkVar.zza(zzvVar);
        String str2 = zzfl.zza;
        String[] strArrSplit = Resources.getSystem().getConfiguration().getLocales().toLanguageTags().split(",", -1);
        for (int i14 = 0; i14 < strArrSplit.length; i14++) {
            strArrSplit[i14] = zzfl.zzi(strArrSplit[i14]);
        }
        int i15 = 0;
        while (true) {
            if (i15 >= strArrSplit.length) {
                iZzj2 = 0;
                i15 = Integer.MAX_VALUE;
                break;
            } else {
                iZzj2 = zzaay.zzj(this.zzd, strArrSplit[i15], false);
                if (iZzj2 > 0) {
                    break;
                } else {
                    i15++;
                }
            }
        }
        this.zzo = i15;
        this.zzp = iZzj2;
        int i16 = 0;
        while (true) {
            if (i16 >= zzaamVar.zzv.size()) {
                break;
            }
            String str3 = this.zzd.zzp;
            if (str3 != null && str3.equals(zzaamVar.zzv.get(i16))) {
                i7 = i16;
                break;
            }
            i16++;
        }
        this.zzu = i7;
        this.zzv = (i5 & 384) == 128;
        this.zzw = (i5 & 64) == 64;
        zzaam zzaamVar2 = this.zzh;
        if (zznc.zzac(i5, zzaamVar2.zzV) && ((z3 = this.zzf) || zzaamVar2.zzO)) {
            int i17 = zzaamVar2.zzw.zzb;
            if (zznc.zzac(i5, false) && z3 && this.zzd.zzj != -1 && ((zzaamVar2.zzX || !z2) && (i9 & i5) != 0)) {
                i8 = 2;
            }
        } else {
            i8 = 0;
        }
        this.zze = i8;
    }

    @Override // com.google.android.gms.internal.ads.zzaaq
    public final int zza() {
        return this.zze;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final int compareTo(zzzx zzzxVar) {
        boolean z2 = this.zzf;
        zzgyg zzgygVarZza = (z2 && this.zzi) ? zzaay.zzc : zzaay.zzc.zza();
        zzgvz zzgvzVarZza = zzgvz.zzg().zzd(this.zzi, zzzxVar.zzi).zza(Integer.valueOf(this.zzk), Integer.valueOf(zzzxVar.zzk), zzgyg.zzb().zza()).zzb(this.zzj, zzzxVar.zzj).zzb(this.zzl, zzzxVar.zzl).zza(Integer.valueOf(this.zzm), Integer.valueOf(zzzxVar.zzm), zzgyg.zzb().zza()).zzd(this.zzq, zzzxVar.zzq).zzd(this.zzn, zzzxVar.zzn).zza(Integer.valueOf(this.zzo), Integer.valueOf(zzzxVar.zzo), zzgyg.zzb().zza()).zzb(this.zzp, zzzxVar.zzp).zzd(z2, zzzxVar.zzf).zza(Integer.valueOf(this.zzu), Integer.valueOf(zzzxVar.zzu), zzgyg.zzb().zza());
        boolean z3 = this.zzh.zzF;
        zzgvz zzgvzVarZza2 = zzgvzVarZza.zzd(this.zzv, zzzxVar.zzv).zzd(this.zzw, zzzxVar.zzw).zzd(this.zzx, zzzxVar.zzx).zza(Integer.valueOf(this.zzr), Integer.valueOf(zzzxVar.zzr), zzgygVarZza).zza(Integer.valueOf(this.zzs), Integer.valueOf(zzzxVar.zzs), zzgygVarZza);
        if (Objects.equals(this.zzg, zzzxVar.zzg)) {
            zzgvzVarZza2 = zzgvzVarZza2.zza(Integer.valueOf(this.zzt), Integer.valueOf(zzzxVar.zzt), zzgygVarZza);
        }
        return zzgvzVarZza2.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzaaq
    public final /* bridge */ /* synthetic */ boolean zzc(zzaaq zzaaqVar) {
        String str;
        int i3;
        zzzx zzzxVar = (zzzx) zzaaqVar;
        boolean z2 = this.zzh.zzR;
        zzv zzvVar = this.zzd;
        int i4 = zzvVar.zzH;
        if (i4 == -1) {
            return false;
        }
        zzv zzvVar2 = zzzxVar.zzd;
        return i4 == zzvVar2.zzH && (str = zzvVar.zzp) != null && TextUtils.equals(str, zzvVar2.zzp) && (i3 = zzvVar.zzI) != -1 && i3 == zzvVar2.zzI && this.zzv == zzzxVar.zzv && this.zzw == zzzxVar.zzw;
    }
}
