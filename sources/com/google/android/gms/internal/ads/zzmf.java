package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzmf {
    private final zznm zzc;
    private final zzdz zzd;
    private long zze;
    private int zzf;
    private boolean zzg;
    private zzju zzh;
    private zzmc zzi;
    private zzmc zzj;
    private zzmc zzk;
    private zzmc zzl;
    private zzmc zzm;
    private int zzn;
    private Object zzo;
    private long zzp;
    private final zzln zzr;
    private final zzbd zza = new zzbd();
    private final zzbe zzb = new zzbe();
    private List zzq = new ArrayList();

    public zzmf(zznm zznmVar, zzdz zzdzVar, zzln zzlnVar, zzju zzjuVar) {
        this.zzc = zznmVar;
        this.zzd = zzdzVar;
        this.zzr = zzlnVar;
        this.zzh = zzjuVar;
    }

    private static zzxk zzA(zzbf zzbfVar, Object obj, long j3, long j4, zzbe zzbeVar, zzbd zzbdVar) {
        zzbfVar.zzo(obj, zzbdVar);
        zzbfVar.zzb(zzbdVar.zzc, zzbeVar, 0L);
        zzbfVar.zze(obj);
        zzbdVar.zzb();
        zzbfVar.zzo(obj, zzbdVar);
        int iZze = zzbdVar.zze(j3);
        return iZze == -1 ? new zzxk(obj, j4, zzbdVar.zzf(j3)) : new zzxk(obj, iZze, zzbdVar.zzd(iZze), j4);
    }

    private final void zzB() {
        int i3 = zzgwm.zzd;
        final zzgwj zzgwjVar = new zzgwj();
        for (zzmc zzmcVarZzp = this.zzi; zzmcVarZzp != null; zzmcVarZzp = zzmcVarZzp.zzp()) {
            zzgwjVar.zzf(zzmcVarZzp.zzg.zza);
        }
        zzmc zzmcVar = this.zzj;
        final zzxk zzxkVar = zzmcVar == null ? null : zzmcVar.zzg.zza;
        this.zzd.zzm(new Runnable() { // from class: com.google.android.gms.internal.ads.zzme
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzz(zzgwjVar, zzxkVar);
            }
        });
    }

    private final long zzC(Object obj) {
        for (int i3 = 0; i3 < this.zzq.size(); i3++) {
            zzmc zzmcVar = (zzmc) this.zzq.get(i3);
            if (zzmcVar.zzb.equals(obj)) {
                return zzmcVar.zzg.zza.zzd;
            }
        }
        return -1L;
    }

    private final int zzD(zzbf zzbfVar) {
        zzbf zzbfVar2;
        zzmc zzmcVarZzp = this.zzi;
        if (zzmcVarZzp == null) {
            return 0;
        }
        int iZze = zzbfVar.zze(zzmcVarZzp.zzb);
        while (true) {
            zzbfVar2 = zzbfVar;
            iZze = zzbfVar2.zzl(iZze, this.zza, this.zzb, this.zzf, this.zzg);
            while (true) {
                zzmcVarZzp.getClass();
                if (zzmcVarZzp.zzp() == null || zzmcVarZzp.zzg.zzi) {
                    break;
                }
                zzmcVarZzp = zzmcVarZzp.zzp();
            }
            zzmc zzmcVarZzp2 = zzmcVarZzp.zzp();
            if (iZze == -1 || zzmcVarZzp2 == null || zzbfVar2.zze(zzmcVarZzp2.zzb) != iZze) {
                break;
            }
            zzmcVarZzp = zzmcVarZzp2;
            zzbfVar = zzbfVar2;
        }
        int iZzs = zzs(zzmcVarZzp);
        zzmcVarZzp.zzg = zzx(zzbfVar2, zzmcVarZzp.zzg);
        return iZzs;
    }

    private final zzmd zzE(zzbf zzbfVar, zzmc zzmcVar, long j3) {
        zzbf zzbfVar2;
        long j4;
        long j5;
        zzbf zzbfVar3;
        zzbd zzbdVar;
        zzbe zzbeVar;
        long j6;
        long j7;
        Object obj;
        long j8;
        long j9;
        zzmd zzmdVar = zzmcVar.zzg;
        long jZza = zzmcVar.zza();
        long j10 = zzmdVar.zzf;
        long j11 = (jZza + j10) - j3;
        long j12 = 0;
        if (!zzmdVar.zzi) {
            zzxk zzxkVar = zzmdVar.zza;
            Object obj2 = zzxkVar.zza;
            zzbd zzbdVar2 = this.zza;
            zzbfVar.zzo(obj2, zzbdVar2);
            if (!zzxkVar.zzb()) {
                int i3 = zzxkVar.zze;
                if (i3 != -1) {
                    zzbdVar2.zzi(i3);
                }
                int iZzd = zzbdVar2.zzd(i3);
                zzbdVar2.zzk(i3);
                if (iZzd != zzbdVar2.zzg(i3)) {
                    return zzG(zzbfVar, obj2, i3, iZzd, j10, zzxkVar.zzd, false);
                }
                zzK(zzbfVar, obj2, i3);
                return zzH(zzbfVar, obj2, 0L, -9223372036854775807L, j10, zzxkVar.zzd, false);
            }
            int i4 = zzxkVar.zzb;
            if (zzbdVar2.zzg(i4) == -1) {
                return null;
            }
            int iZza = zzbdVar2.zzg.zza(i4).zza(zzxkVar.zzc);
            if (iZza < 0) {
                return zzG(zzbfVar, obj2, i4, iZza, zzmdVar.zzd, zzxkVar.zzd, false);
            }
            long jLongValue = zzmdVar.zzd;
            if (jLongValue == -9223372036854775807L) {
                zzbe zzbeVar2 = this.zzb;
                long jMax = zzL(zzbfVar, zzbdVar2.zzc, zzbdVar2.zzd, zzbeVar2) ? Math.max(0L, j11) : -9223372036854775807L;
                zzbfVar2 = zzbfVar;
                Pair pairZzn = zzbfVar2.zzn(zzbeVar2, zzbdVar2, zzbdVar2.zzc, -9223372036854775807L, jMax);
                if (pairZzn == null) {
                    return null;
                }
                jLongValue = ((Long) pairZzn.second).longValue();
                j5 = jMax;
                j4 = -9223372036854775807L;
            } else {
                zzbfVar2 = zzbfVar;
                j4 = jLongValue;
                j5 = -9223372036854775807L;
            }
            zzK(zzbfVar2, obj2, i4);
            return zzH(zzbfVar2, obj2, Math.max(0L, jLongValue), j5, j4, zzxkVar.zzd, false);
        }
        zzxk zzxkVar2 = zzmdVar.zza;
        Object obj3 = zzxkVar2.zza;
        int iZze = zzbfVar.zze(obj3);
        int i5 = this.zzf;
        boolean z2 = this.zzg;
        zzbe zzbeVar3 = this.zzb;
        zzbd zzbdVar3 = this.zza;
        int iZzl = zzbfVar.zzl(iZze, zzbdVar3, zzbeVar3, i5, z2);
        if (iZzl == -1) {
            return null;
        }
        int i6 = zzbfVar.zzd(iZzl, zzbdVar3, true).zzc;
        Object obj4 = zzbdVar3.zzb;
        obj4.getClass();
        long j13 = zzxkVar2.zzd;
        if (zzbfVar.zzb(i6, zzbeVar3, 0L).zzn == iZzl) {
            long jMax2 = zzL(zzbfVar, zzbdVar3.zzc, zzbdVar3.zzd, zzbeVar3) ? Math.max(0L, j11) : -9223372036854775807L;
            Pair pairZzn2 = zzbfVar.zzn(zzbeVar3, zzbdVar3, i6, -9223372036854775807L, jMax2);
            if (pairZzn2 == null) {
                return null;
            }
            Object obj5 = pairZzn2.first;
            long jLongValue2 = ((Long) pairZzn2.second).longValue();
            zzmc zzmcVarZzp = zzmcVar.zzp();
            if (zzmcVarZzp == null || !zzmcVarZzp.zzb.equals(obj5)) {
                long jZzC = zzC(obj5);
                if (jZzC == -1) {
                    jZzC = this.zze;
                    this.zze = 1 + jZzC;
                }
                j9 = jZzC;
            } else {
                j9 = zzmcVarZzp.zzg.zza.zzd;
            }
            long j14 = jMax2;
            zzbeVar = zzbeVar3;
            obj = obj5;
            j6 = j9;
            j8 = j14;
            zzbfVar3 = zzbfVar;
            zzbdVar = zzbdVar3;
            j7 = jLongValue2;
            j12 = -9223372036854775807L;
        } else {
            zzbfVar3 = zzbfVar;
            zzbdVar = zzbdVar3;
            zzbeVar = zzbeVar3;
            j6 = j13;
            j7 = 0;
            obj = obj4;
            j8 = -9223372036854775807L;
        }
        zzxk zzxkVarZzA = zzA(zzbfVar3, obj, j7, j6, zzbeVar, zzbdVar);
        long j15 = j7;
        zzbd zzbdVar4 = zzbdVar;
        if (j12 != -9223372036854775807L && zzmdVar.zzd != -9223372036854775807L) {
            zzbfVar3.zzo(obj3, zzbdVar4).zzb();
            int i7 = zzbdVar4.zzg.zzd;
        }
        return zzF(zzbfVar3, zzxkVarZzA, j12, j15, j8);
    }

    private final zzmd zzF(zzbf zzbfVar, zzxk zzxkVar, long j3, long j4, long j5) {
        Object obj = zzxkVar.zza;
        zzbfVar.zzo(obj, this.zza);
        return zzxkVar.zzb() ? zzG(zzbfVar, obj, zzxkVar.zzb, zzxkVar.zzc, j3, zzxkVar.zzd, false) : zzH(zzbfVar, obj, j4, j5, j3, zzxkVar.zzd, false);
    }

    private final zzmd zzG(zzbf zzbfVar, Object obj, int i3, int i4, long j3, long j4, boolean z2) {
        zzxk zzxkVar = new zzxk(obj, i3, i4, j4);
        Object obj2 = zzxkVar.zza;
        int i5 = zzxkVar.zzb;
        int i6 = zzxkVar.zzc;
        zzbd zzbdVar = this.zza;
        long jZzh = zzbfVar.zzo(obj2, zzbdVar).zzh(i5, i6);
        if (i4 == zzbdVar.zzd(i3)) {
            zzbdVar.zzj();
        }
        zzbdVar.zzk(i5);
        long jMax = 0;
        if (jZzh != -9223372036854775807L && jZzh <= 0) {
            jMax = Math.max(0L, (-1) + jZzh);
        }
        return new zzmd(zzxkVar, jMax, -9223372036854775807L, j3, -9223372036854775807L, jZzh, false, false, false, false, false);
    }

    private final zzmd zzH(zzbf zzbfVar, Object obj, long j3, long j4, long j5, long j6, boolean z2) {
        long j7;
        long j8;
        long j9;
        long jMax = j3;
        zzbd zzbdVar = this.zza;
        zzbfVar.zzo(obj, zzbdVar);
        int iZzf = zzbdVar.zzf(jMax);
        if (iZzf == -1) {
            zzbdVar.zzb();
        } else {
            zzbdVar.zzk(iZzf);
        }
        zzxk zzxkVar = new zzxk(obj, j6, iZzf);
        boolean zZzM = zzM(zzxkVar);
        boolean zZzI = zzI(zzbfVar, zzxkVar);
        boolean zZzJ = zzJ(zzbfVar, zzxkVar, zZzM);
        if (iZzf != -1) {
            zzbdVar.zzk(iZzf);
        }
        if (iZzf != -1) {
            zzbdVar.zzi(iZzf);
        }
        if (iZzf != -1) {
            zzbdVar.zzc(iZzf);
            j7 = 0;
        } else {
            j7 = -9223372036854775807L;
        }
        if (j7 != -9223372036854775807L) {
            j9 = j7;
            j8 = j9;
        } else {
            j8 = zzbdVar.zzd;
            j9 = -9223372036854775807L;
        }
        if (j8 != -9223372036854775807L && jMax >= j8) {
            jMax = Math.max(0L, j8 - 1);
        }
        return new zzmd(zzxkVar, jMax, j4, j5, j9, j8, false, false, zZzM, zZzI, zZzJ);
    }

    private final boolean zzI(zzbf zzbfVar, zzxk zzxkVar) {
        if (!zzM(zzxkVar)) {
            return false;
        }
        Object obj = zzxkVar.zza;
        return zzbfVar.zzb(zzbfVar.zzo(obj, this.zza).zzc, this.zzb, 0L).zzo == zzbfVar.zze(obj);
    }

    private final boolean zzJ(zzbf zzbfVar, zzxk zzxkVar, boolean z2) {
        int iZze = zzbfVar.zze(zzxkVar.zza);
        zzbd zzbdVar = this.zza;
        int i3 = zzbfVar.zzd(iZze, zzbdVar, false).zzc;
        zzbe zzbeVar = this.zzb;
        return !zzbfVar.zzb(i3, zzbeVar, 0L).zzi && zzbfVar.zzl(iZze, zzbdVar, zzbeVar, this.zzf, this.zzg) == -1 && z2;
    }

    private final long zzK(zzbf zzbfVar, Object obj, int i3) {
        zzbd zzbdVar = this.zza;
        zzbfVar.zzo(obj, zzbdVar);
        zzbdVar.zzc(i3);
        long j3 = zzbdVar.zzg.zza(i3).zzi;
        return 0L;
    }

    private static boolean zzL(zzbf zzbfVar, int i3, long j3, zzbe zzbeVar) {
        if (j3 == -9223372036854775807L) {
            zzbfVar.zzb(i3, zzbeVar, 0L);
            if (zzbeVar.zzi && !zzbeVar.zzk) {
                return true;
            }
        }
        return false;
    }

    private static final boolean zzM(zzxk zzxkVar) {
        return !zzxkVar.zzb() && zzxkVar.zze == -1;
    }

    public final int zza(zzbf zzbfVar, int i3) {
        this.zzf = i3;
        return zzD(zzbfVar);
    }

    public final int zzb(zzbf zzbfVar, boolean z2) {
        this.zzg = z2;
        return zzD(zzbfVar);
    }

    public final void zzc(zzbf zzbfVar, zzju zzjuVar) {
        this.zzh = zzjuVar;
        long j3 = zzjuVar.zzb;
        zzj();
    }

    public final boolean zzd(zzxi zzxiVar) {
        zzmc zzmcVar = this.zzl;
        return zzmcVar != null && zzmcVar.zza == zzxiVar;
    }

    public final boolean zze(zzxi zzxiVar) {
        zzmc zzmcVar = this.zzm;
        return zzmcVar != null && zzmcVar.zza == zzxiVar;
    }

    public final void zzf(long j3) {
        zzmc zzmcVar = this.zzl;
        if (zzmcVar != null) {
            zzmcVar.zzi(j3);
        }
    }

    public final boolean zzg() {
        zzmc zzmcVar = this.zzl;
        if (zzmcVar != null) {
            return !zzmcVar.zzg.zzk && zzmcVar.zzd() && this.zzl.zzg.zzf != -9223372036854775807L && this.zzn < 100;
        }
        return true;
    }

    public final zzmd zzh(long j3, zzms zzmsVar) {
        zzmc zzmcVar = this.zzl;
        return zzmcVar == null ? zzF(zzmsVar.zza, zzmsVar.zzb, zzmsVar.zzc, zzmsVar.zzs, -9223372036854775807L) : zzE(zzmsVar.zza, zzmcVar, j3);
    }

    public final zzmc zzi(zzmd zzmdVar) {
        zzmc zzmcVarZza;
        zzmc zzmcVar = this.zzl;
        long jZza = zzmcVar == null ? 1000000000000L : (zzmcVar.zza() + zzmcVar.zzg.zzf) - zzmdVar.zzb;
        int i3 = 0;
        while (true) {
            if (i3 >= this.zzq.size()) {
                zzmcVarZza = null;
                break;
            }
            zzmd zzmdVar2 = ((zzmc) this.zzq.get(i3)).zzg;
            long j3 = zzmdVar2.zzf;
            long j4 = zzmdVar.zzf;
            if ((j3 == -9223372036854775807L || j3 == j4) && zzmdVar2.zzb == zzmdVar.zzb && zzmdVar2.zza.equals(zzmdVar.zza)) {
                zzmcVarZza = (zzmc) this.zzq.remove(i3);
                break;
            }
            i3++;
        }
        if (zzmcVarZza == null) {
            zzmcVarZza = this.zzr.zza(zzmdVar, jZza);
        } else {
            zzmcVarZza.zzg = zzmdVar;
            zzmcVarZza.zzb(jZza);
        }
        zzmc zzmcVar2 = this.zzl;
        if (zzmcVar2 != null) {
            zzmcVar2.zzo(zzmcVarZza);
        } else {
            this.zzi = zzmcVarZza;
            this.zzj = zzmcVarZza;
            this.zzk = zzmcVarZza;
        }
        this.zzo = null;
        this.zzl = zzmcVarZza;
        this.zzn++;
        zzB();
        return zzmcVarZza;
    }

    public final void zzj() {
        if (this.zzq.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < this.zzq.size(); i3++) {
            ((zzmc) this.zzq.get(i3)).zzn();
        }
        this.zzq = arrayList;
        this.zzm = null;
        zzt();
    }

    public final zzmc zzk() {
        return this.zzl;
    }

    public final zzmc zzl() {
        return this.zzm;
    }

    public final zzmc zzm() {
        return this.zzi;
    }

    public final zzmc zzn() {
        return this.zzj;
    }

    public final zzmc zzo() {
        return this.zzk;
    }

    public final zzmc zzp() {
        zzmc zzmcVar = this.zzk;
        zzmc zzmcVar2 = this.zzj;
        if (zzmcVar == zzmcVar2) {
            zzmcVar2.getClass();
            this.zzk = zzmcVar2.zzp();
        }
        zzmcVar2.getClass();
        this.zzj = zzmcVar2.zzp();
        zzB();
        zzmc zzmcVar3 = this.zzj;
        zzmcVar3.getClass();
        return zzmcVar3;
    }

    public final zzmc zzq() {
        zzmc zzmcVar = this.zzk;
        zzmcVar.getClass();
        this.zzk = zzmcVar.zzp();
        zzB();
        zzmc zzmcVar2 = this.zzk;
        zzmcVar2.getClass();
        return zzmcVar2;
    }

    public final zzmc zzr() {
        zzmc zzmcVar = this.zzi;
        if (zzmcVar == null) {
            return null;
        }
        if (zzmcVar == this.zzj) {
            this.zzj = zzmcVar.zzp();
        }
        if (zzmcVar == this.zzk) {
            this.zzk = zzmcVar.zzp();
        }
        zzmcVar.zzn();
        int i3 = this.zzn - 1;
        this.zzn = i3;
        if (i3 == 0) {
            this.zzl = null;
            zzmc zzmcVar2 = this.zzi;
            this.zzo = zzmcVar2.zzb;
            this.zzp = zzmcVar2.zzg.zza.zzd;
        }
        this.zzi = this.zzi.zzp();
        zzB();
        return this.zzi;
    }

    public final int zzs(zzmc zzmcVar) {
        zzmcVar.getClass();
        int i3 = 0;
        if (zzmcVar.equals(this.zzl)) {
            return 0;
        }
        this.zzl = zzmcVar;
        while (zzmcVar.zzp() != null) {
            zzmcVar = zzmcVar.zzp();
            zzmcVar.getClass();
            if (zzmcVar == this.zzj) {
                zzmc zzmcVar2 = this.zzi;
                this.zzj = zzmcVar2;
                this.zzk = zzmcVar2;
                i3 = 3;
            }
            if (zzmcVar == this.zzk) {
                this.zzk = this.zzj;
                i3 |= 2;
            }
            zzmcVar.zzn();
            this.zzn--;
        }
        zzmc zzmcVar3 = this.zzl;
        zzmcVar3.getClass();
        zzmcVar3.zzo(null);
        zzB();
        return i3;
    }

    public final void zzt() {
        zzmc zzmcVar = this.zzm;
        if (zzmcVar == null || zzmcVar.zze()) {
            this.zzm = null;
            for (int i3 = 0; i3 < this.zzq.size(); i3++) {
                zzmc zzmcVar2 = (zzmc) this.zzq.get(i3);
                if (!zzmcVar2.zze()) {
                    this.zzm = zzmcVar2;
                    return;
                }
            }
        }
    }

    public final zzmc zzu(zzxi zzxiVar) {
        for (int i3 = 0; i3 < this.zzq.size(); i3++) {
            zzmc zzmcVar = (zzmc) this.zzq.get(i3);
            if (zzmcVar.zza == zzxiVar) {
                return zzmcVar;
            }
        }
        return null;
    }

    public final void zzv() {
        if (this.zzn == 0) {
            return;
        }
        zzmc zzmcVarZzp = this.zzi;
        zzmcVarZzp.getClass();
        this.zzo = zzmcVarZzp.zzb;
        this.zzp = zzmcVarZzp.zzg.zza.zzd;
        while (zzmcVarZzp != null) {
            zzmcVarZzp.zzn();
            zzmcVarZzp = zzmcVarZzp.zzp();
        }
        this.zzi = null;
        this.zzl = null;
        this.zzj = null;
        this.zzk = null;
        this.zzn = 0;
        zzB();
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zzw(com.google.android.gms.internal.ads.zzbf r23, long r24, long r26, long r28) {
        /*
            Method dump skipped, instruction units count: 238
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzmf.zzw(com.google.android.gms.internal.ads.zzbf, long, long, long):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.internal.ads.zzmd zzx(com.google.android.gms.internal.ads.zzbf r19, com.google.android.gms.internal.ads.zzmd r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            com.google.android.gms.internal.ads.zzxk r3 = r2.zza
            boolean r15 = zzM(r3)
            boolean r16 = r0.zzI(r1, r3)
            boolean r17 = r0.zzJ(r1, r3, r15)
            java.lang.Object r4 = r3.zza
            com.google.android.gms.internal.ads.zzbd r5 = r0.zza
            r1.zzo(r4, r5)
            boolean r1 = r3.zzb()
            r4 = -1
            r6 = 0
            r8 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r1 != 0) goto L2d
            int r1 = r3.zze
            if (r1 != r4) goto L2f
        L2d:
            r10 = r8
            goto L33
        L2f:
            r5.zzc(r1)
            r10 = r6
        L33:
            boolean r1 = r3.zzb()
            if (r1 == 0) goto L44
            int r1 = r3.zzb
            int r6 = r3.zzc
            long r6 = r5.zzh(r1, r6)
        L41:
            r9 = r10
            r11 = r6
            goto L4e
        L44:
            int r1 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r1 == 0) goto L4b
            r9 = r6
            r11 = r9
            goto L4e
        L4b:
            long r6 = r5.zzd
            goto L41
        L4e:
            boolean r1 = r3.zzb()
            if (r1 == 0) goto L5a
            int r1 = r3.zzb
            r5.zzk(r1)
            goto L61
        L5a:
            int r1 = r3.zze
            if (r1 == r4) goto L61
            r5.zzk(r1)
        L61:
            com.google.android.gms.internal.ads.zzmd r1 = new com.google.android.gms.internal.ads.zzmd
            r5 = r3
            long r3 = r2.zzb
            r7 = r5
            long r5 = r2.zzc
            long r13 = r2.zzd
            r2 = r7
            r7 = r13
            r13 = 0
            r14 = 0
            r1.<init>(r2, r3, r5, r7, r9, r11, r13, r14, r15, r16, r17)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzmf.zzx(com.google.android.gms.internal.ads.zzbf, com.google.android.gms.internal.ads.zzmd):com.google.android.gms.internal.ads.zzmd");
    }

    public final zzxk zzy(zzbf zzbfVar, Object obj, long j3) {
        long jZzC;
        int iZze;
        zzbd zzbdVar = this.zza;
        int i3 = zzbfVar.zzo(obj, zzbdVar).zzc;
        Object obj2 = this.zzo;
        if (obj2 == null || (iZze = zzbfVar.zze(obj2)) == -1 || zzbfVar.zzd(iZze, zzbdVar, false).zzc != i3) {
            zzmc zzmcVarZzp = this.zzi;
            while (true) {
                if (zzmcVarZzp == null) {
                    zzmc zzmcVarZzp2 = this.zzi;
                    while (true) {
                        if (zzmcVarZzp2 != null) {
                            int iZze2 = zzbfVar.zze(zzmcVarZzp2.zzb);
                            if (iZze2 != -1 && zzbfVar.zzd(iZze2, zzbdVar, false).zzc == i3) {
                                jZzC = zzmcVarZzp2.zzg.zza.zzd;
                                break;
                            }
                            zzmcVarZzp2 = zzmcVarZzp2.zzp();
                        } else {
                            jZzC = zzC(obj);
                            if (jZzC == -1) {
                                jZzC = this.zze;
                                this.zze = 1 + jZzC;
                                if (this.zzi == null) {
                                    this.zzo = obj;
                                    this.zzp = jZzC;
                                }
                            }
                        }
                    }
                } else {
                    if (zzmcVarZzp.zzb.equals(obj)) {
                        jZzC = zzmcVarZzp.zzg.zza.zzd;
                        break;
                    }
                    zzmcVarZzp = zzmcVarZzp.zzp();
                }
            }
        } else {
            jZzC = this.zzp;
        }
        long j4 = jZzC;
        zzbfVar.zzo(obj, zzbdVar);
        int i4 = zzbdVar.zzc;
        zzbe zzbeVar = this.zzb;
        zzbfVar.zzb(i4, zzbeVar, 0L);
        Object obj3 = obj;
        for (int iZze3 = zzbfVar.zze(obj); iZze3 >= zzbeVar.zzn; iZze3--) {
            zzbfVar.zzd(iZze3, zzbdVar, true);
            zzbdVar.zzb();
            if (zzbdVar.zze(zzbdVar.zzd) != -1) {
                Object obj4 = zzbdVar.zzb;
                obj4.getClass();
                obj3 = obj4;
            }
        }
        return zzA(zzbfVar, obj3, j3, j4, zzbeVar, zzbdVar);
    }

    final /* synthetic */ void zzz(zzgwj zzgwjVar, zzxk zzxkVar) {
        this.zzc.zzz(zzgwjVar.zzi(), zzxkVar);
    }
}
