package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Pair;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzlu implements Handler.Callback, zzxh, zzabg, zzmq, zzjh, zzmu, zzcc, zzadr {
    private static final long zza = zzfl.zzr(10000);
    private final boolean zzA;
    private zzni zzB;
    private boolean zzD;
    private boolean zzE;
    private zzlt zzF;
    private int zzG;
    private zzms zzH;
    private zzlr zzI;
    private boolean zzJ;
    private boolean zzL;
    private boolean zzM;
    private boolean zzO;
    private boolean zzR;
    private int zzS;
    private zzlt zzT;
    private long zzU;
    private long zzV;
    private int zzW;
    private boolean zzX;
    private zzjk zzY;
    private zzju zzaa;
    private boolean zzac;
    private final zzjd zzae;
    private final zzne[] zzb;
    private final zznc[] zzc;
    private final boolean[] zzd;
    private final zzabh zze;
    private final zzabi zzf;
    private final zzly zzg;
    private final zzabq zzh;
    private final zzdz zzi;
    private final zzmt zzj;
    private final Looper zzk;
    private final zzbe zzl;
    private final zzbd zzm;
    private final long zzn;
    private final zzji zzo;
    private final ArrayList zzp;
    private final zzdo zzq;
    private final zzls zzr;
    private final zzmf zzs;
    private final zzmr zzt;
    private final long zzu;
    private final zzqf zzv;
    private final zznm zzw;
    private final zzdz zzx;
    private final boolean zzy;
    private final zzcd zzz;
    private long zzab = -9223372036854775807L;
    private int zzP = 0;
    private boolean zzQ = false;
    private boolean zzK = false;
    private float zzad = 1.0f;
    private zznh zzC = zznh.zza;
    private long zzZ = -9223372036854775807L;
    private long zzN = -9223372036854775807L;

    public zzlu(Context context, zzna[] zznaVarArr, zzna[] zznaVarArr2, zzabh zzabhVar, zzabi zzabiVar, zzly zzlyVar, zzabq zzabqVar, int i3, boolean z2, zznm zznmVar, zzni zzniVar, zzjd zzjdVar, long j3, boolean z3, boolean z4, Looper looper, zzdo zzdoVar, zzls zzlsVar, zzqf zzqfVar, zzmt zzmtVar, zzju zzjuVar, final zzadr zzadrVar, boolean z5) {
        this.zzr = zzlsVar;
        this.zze = zzabhVar;
        this.zzf = zzabiVar;
        this.zzg = zzlyVar;
        this.zzh = zzabqVar;
        this.zzB = zzniVar;
        this.zzae = zzjdVar;
        this.zzu = j3;
        this.zzq = zzdoVar;
        this.zzv = zzqfVar;
        this.zzaa = zzjuVar;
        this.zzw = zznmVar;
        this.zzA = z5;
        this.zzn = zzlyVar.zzf(zzqfVar);
        zzlyVar.zzg(zzqfVar);
        zzbf zzbfVar = zzbf.zza;
        zzms zzmsVarZza = zzms.zza(zzabiVar);
        this.zzH = zzmsVarZza;
        this.zzI = new zzlr(zzmsVarZza);
        int length = zznaVarArr.length;
        this.zzc = new zznc[2];
        this.zzd = new boolean[2];
        zznb zznbVarZzg = zzabhVar.zzg();
        this.zzb = new zzne[2];
        boolean z6 = false;
        for (int i4 = 0; i4 < 2; i4++) {
            zznaVarArr[i4].zzc(i4, zzqfVar, zzdoVar);
            this.zzc[i4] = zznaVarArr[i4].zzb();
            this.zzc[i4].zzv(zznbVarZzg);
            zzna zznaVar = zznaVarArr2[i4];
            if (zznaVar != null) {
                zznaVar.zzc(i4, zzqfVar, zzdoVar);
                z6 = true;
            }
            this.zzb[i4] = new zzne(zznaVarArr[i4], zznaVarArr2[i4], i4);
        }
        this.zzy = z6;
        this.zzo = new zzji(this, zzdoVar);
        this.zzp = new ArrayList();
        this.zzl = new zzbe();
        this.zzm = new zzbd();
        zzabhVar.zzs(this, zzabqVar);
        this.zzX = true;
        zzdz zzdzVarZzd = zzdoVar.zzd(looper, null);
        this.zzx = zzdzVarZzd;
        this.zzs = new zzmf(zznmVar, zzdzVarZzd, new zzln(this), zzjuVar);
        this.zzt = new zzmr(this, zznmVar, zzdzVarZzd, zzqfVar);
        zzmt zzmtVar2 = new zzmt(null);
        this.zzj = zzmtVar2;
        Looper looperZza = zzmtVar2.zza();
        this.zzk = looperZza;
        zzdz zzdzVarZzd2 = zzdoVar.zzd(looperZza, this);
        this.zzi = zzdzVarZzd2;
        this.zzz = new zzcd(context, looperZza, this);
        zzdzVarZzd2.zzd(35, new zzadr() { // from class: com.google.android.gms.internal.ads.zzlj
            @Override // com.google.android.gms.internal.ads.zzadr
            public final /* synthetic */ void zzcS(long j4, long j5, zzv zzvVar, MediaFormat mediaFormat) {
                this.zza.zzcS(j4, j5, zzvVar, mediaFormat);
            }
        }).zza();
    }

    private final void zzA(IOException iOException, int i3) {
        zzmf zzmfVar = this.zzs;
        zzjk zzjkVarZza = zzjk.zza(iOException, i3);
        zzmc zzmcVarZzm = zzmfVar.zzm();
        if (zzmcVarZzm != null) {
            zzjkVarZza = zzjkVarZza.zzd(zzmcVarZzm.zzg.zza);
        }
        zzeg.zzf("ExoPlayerImplInternal", "Playback error", zzjkVarZza);
        zzW(false, false);
        this.zzH = this.zzH.zzf(zzjkVarZza);
    }

    private final void zzB(int i3) {
        zzms zzmsVar = this.zzH;
        if (zzmsVar.zze != i3) {
            if (i3 != 2) {
                this.zzZ = -9223372036854775807L;
            }
            this.zzH = zzmsVar.zze(i3);
        }
    }

    private final void zzC() {
        this.zzI.zzb(this.zzH);
        if (this.zzI.zzd()) {
            this.zzr.zza(this.zzI);
            this.zzI = new zzlr(this.zzH);
        }
    }

    private final void zzD(float f3) throws zzjk {
        this.zzad = f3;
        float fZza = f3 * this.zzz.zza();
        int i3 = 0;
        while (true) {
            zzne[] zzneVarArr = this.zzb;
            if (i3 >= 2) {
                return;
            }
            zzneVarArr[i3].zzL(fZza);
            i3++;
        }
    }

    private final void zzE(boolean z2, int i3, boolean z3, int i4) throws zzjk {
        this.zzI.zza(z3 ? 1 : 0);
        zzG(z2, i3, i4);
    }

    private final void zzF() throws zzjk {
        zzms zzmsVar = this.zzH;
        zzG(zzmsVar.zzl, zzmsVar.zzn, zzmsVar.zzm);
    }

    private final void zzG(boolean z2, int i3, int i4) throws zzjk {
        zzH(z2, this.zzz.zzc(z2, this.zzH.zze), i3, i4);
    }

    private final void zzH(boolean z2, int i3, int i4, int i5) throws zzjk {
        boolean z3;
        if (!z2) {
            z3 = false;
        } else if (i3 != -1) {
            z3 = true;
        } else {
            i3 = -1;
            z3 = false;
        }
        if (i3 == -1) {
            i5 = 2;
        } else if (i5 == 2) {
            i5 = 1;
        }
        boolean z4 = this.zzD;
        if (i3 == 0) {
            i4 = 1;
        } else if (i4 == 1) {
            i4 = z4 ? 4 : 0;
        }
        zzms zzmsVar = this.zzH;
        if (zzmsVar.zzl == z3 && zzmsVar.zzn == i4 && zzmsVar.zzm == i5) {
            return;
        }
        this.zzH = zzmsVar.zzi(z3, i5, i4);
        zzaD(false, false);
        zzmf zzmfVar = this.zzs;
        for (zzmc zzmcVarZzm = zzmfVar.zzm(); zzmcVarZzm != null; zzmcVarZzm = zzmcVarZzm.zzp()) {
            for (zzaba zzabaVar : zzmcVarZzm.zzr().zzc) {
            }
        }
        if (!zzay()) {
            zzK();
            zzL();
            boolean z5 = this.zzH.zzp;
            zzmfVar.zzf(this.zzU);
            return;
        }
        int i6 = this.zzH.zze;
        if (i6 == 3) {
            this.zzo.zza();
            zzJ();
            this.zzi.zzh(2);
        } else if (i6 == 2) {
            this.zzi.zzh(2);
        }
    }

    private final void zzI(boolean z2) throws zzjk {
        zzxk zzxkVar = this.zzs.zzm().zzg.zza;
        long jZzT = zzT(zzxkVar, this.zzH.zzs, true, false);
        if (jZzT != this.zzH.zzs) {
            zzms zzmsVar = this.zzH;
            this.zzH = zzap(zzxkVar, jZzT, zzmsVar.zzc, zzmsVar.zzd, z2, 5);
        }
    }

    private final void zzJ() throws zzjk {
        zzmc zzmcVarZzm = this.zzs.zzm();
        if (zzmcVarZzm == null) {
            return;
        }
        zzabi zzabiVarZzr = zzmcVarZzm.zzr();
        int i3 = 0;
        while (true) {
            zzne[] zzneVarArr = this.zzb;
            if (i3 >= 2) {
                return;
            }
            if (zzabiVarZzr.zza(i3)) {
                zzneVarArr[i3].zzv();
            }
            i3++;
        }
    }

    private final void zzK() throws zzjk {
        this.zzo.zzb();
        int i3 = 0;
        while (true) {
            zzne[] zzneVarArr = this.zzb;
            if (i3 >= 2) {
                return;
            }
            zzneVarArr[i3].zzw();
            i3++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a9, code lost:
    
        r13 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzL() throws com.google.android.gms.internal.ads.zzjk {
        /*
            Method dump skipped, instruction units count: 370
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlu.zzL():void");
    }

    private final void zzM(zzav zzavVar) {
        this.zzi.zzk(16);
        this.zzo.zzi(zzavVar);
    }

    private final void zzN(final int i3, final boolean z2) {
        boolean[] zArr = this.zzd;
        if (zArr[i3] != z2) {
            zArr[i3] = z2;
            this.zzx.zzm(new Runnable() { // from class: com.google.android.gms.internal.ads.zzlk
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzu(i3, z2);
                }
            });
        }
    }

    private final long zzO(zzbf zzbfVar, Object obj, long j3) {
        int i3 = zzbfVar.zzo(obj, this.zzm).zzc;
        zzbe zzbeVar = this.zzl;
        zzbfVar.zzb(i3, zzbeVar, 0L);
        if (zzbeVar.zzf == -9223372036854775807L || !zzbeVar.zzb() || !zzbeVar.zzi) {
            return -9223372036854775807L;
        }
        long j4 = zzbeVar.zzg;
        String str = zzfl.zza;
        return zzfl.zzs((j4 == -9223372036854775807L ? System.currentTimeMillis() : j4 + SystemClock.elapsedRealtime()) - zzbeVar.zzf) - j3;
    }

    private final boolean zzP(zzbf zzbfVar, zzxk zzxkVar) {
        if (!zzxkVar.zzb() && !zzbfVar.zzg()) {
            int i3 = zzbfVar.zzo(zzxkVar.zza, this.zzm).zzc;
            zzbe zzbeVar = this.zzl;
            zzbfVar.zzb(i3, zzbeVar, 0L);
            if (zzbeVar.zzb() && zzbeVar.zzi && zzbeVar.zzf != -9223372036854775807L) {
                return true;
            }
        }
        return false;
    }

    private final void zzQ(long j3) {
        if (zzw()) {
            jMin = this.zzH.zze != 3 ? zza : 1000L;
            zzne[] zzneVarArr = this.zzb;
            for (int i3 = 0; i3 < 2; i3++) {
                jMin = Math.min(jMin, zzfl.zzr(zzneVarArr[i3].zzk(this.zzU, this.zzV)));
            }
            if (this.zzH.zzj()) {
                zzmf zzmfVar = this.zzs;
                if ((zzmfVar.zzm() != null ? zzmfVar.zzm().zzp() : null) != null) {
                    if (this.zzU + (zzfl.zzs(jMin) * this.zzH.zzo.zzb) >= r0.zzc()) {
                        jMin = Math.min(jMin, zza);
                    }
                }
            }
        } else if (this.zzH.zze != 3 || zzay()) {
            jMin = zza;
        }
        this.zzi.zzj(2, j3 + jMin);
    }

    private final void zzR(zzlt zzltVar) throws Throwable {
        long jLongValue;
        long j3;
        zzxk zzxkVarZzy;
        boolean z2;
        boolean z3;
        long j4;
        long j5;
        long j6;
        long j7;
        long jZzk;
        zzms zzmsVar;
        int i3;
        if (this.zzE) {
            if (this.zzF != null) {
                this.zzG++;
                this.zzI.zza(1);
            }
            this.zzF = zzltVar;
            return;
        }
        this.zzI.zza(1);
        zzbf zzbfVar = this.zzH.zza;
        int i4 = this.zzP;
        boolean z4 = this.zzQ;
        zzbe zzbeVar = this.zzl;
        zzbd zzbdVar = this.zzm;
        Pair pairZzaE = zzaE(zzbfVar, zzltVar, true, i4, z4, zzbeVar, zzbdVar);
        long jMax = -9223372036854775807L;
        if (pairZzaE == null) {
            Pair pairZzY = zzY(this.zzH.zza);
            zzxk zzxkVar = (zzxk) pairZzY.first;
            jLongValue = ((Long) pairZzY.second).longValue();
            z2 = !this.zzH.zza.zzg();
            zzxkVarZzy = zzxkVar;
            j3 = -9223372036854775807L;
        } else {
            Object obj = pairZzaE.first;
            jLongValue = ((Long) pairZzaE.second).longValue();
            long j8 = zzltVar.zzc;
            if (j8 == -9223372036854775807L) {
                j3 = -9223372036854775807L;
            } else {
                j3 = -9223372036854775807L;
                jMax = jLongValue;
            }
            zzxkVarZzy = this.zzs.zzy(this.zzH.zza, obj, jLongValue);
            if (zzxkVarZzy.zzb()) {
                this.zzH.zza.zzo(zzxkVarZzy.zza, zzbdVar);
                int i5 = zzxkVarZzy.zzb;
                if (zzbdVar.zzd(i5) == zzxkVarZzy.zzc) {
                    zzbdVar.zzj();
                }
                long j9 = zzbdVar.zzg.zza(i5).zza;
                jMax = Math.max(jMax, 0L);
                jLongValue = 0;
            } else if (j8 != -9223372036854775807L) {
                z2 = false;
            }
            z2 = true;
        }
        try {
            if (this.zzH.zza.zzg()) {
                this.zzT = zzltVar;
            } else if (pairZzaE == null) {
                if (this.zzH.zze != 1) {
                    zzB(4);
                }
                zzX(false, true, false, true);
            } else {
                if (zzxkVarZzy.equals(this.zzH.zzb)) {
                    zzmc zzmcVarZzm = this.zzs.zzm();
                    if (zzmcVarZzm == null || !zzmcVarZzm.zze || jLongValue == 0) {
                        jZzk = jLongValue;
                    } else {
                        zzxi zzxiVar = zzmcVarZzm.zza;
                        long j10 = zzbeVar.zzm;
                        if (this.zzD && j10 != j3) {
                            Double d3 = this.zzC.zzc;
                        }
                        jZzk = zzxiVar.zzk(jLongValue, this.zzB);
                    }
                    long j11 = jZzk;
                    if (zzfl.zzr(jZzk) == zzfl.zzr(this.zzH.zzs) && ((i3 = (zzmsVar = this.zzH).zze) == 2 || i3 == 3)) {
                        jLongValue = zzmsVar.zzs;
                    } else {
                        j5 = j11;
                    }
                } else {
                    j5 = jLongValue;
                }
                if (this.zzD) {
                    zzne[] zzneVarArr = this.zzb;
                    int i6 = 0;
                    while (true) {
                        if (i6 >= 2) {
                            break;
                        }
                        zzne zzneVar = zzneVarArr[i6];
                        if (zzneVar.zzM() && zzneVar.zze() == 2) {
                            this.zzE = true;
                            break;
                        }
                        i6++;
                    }
                }
                long jZzS = zzS(zzxkVarZzy, j5, this.zzH.zze == 4);
                z3 = (jLongValue != jZzS) | z2;
                try {
                    zzms zzmsVar2 = this.zzH;
                    zzxk zzxkVar2 = zzxkVarZzy;
                    try {
                        zzbf zzbfVar2 = zzmsVar2.zza;
                        long j12 = jMax;
                        try {
                            zzag(zzbfVar2, zzxkVar2, zzbfVar2, zzmsVar2.zzb, j12, true);
                            zzxkVarZzy = zzxkVar2;
                            j6 = j12;
                            j7 = jZzS;
                            this.zzH = zzap(zzxkVarZzy, j7, j6, j7, z3, 2);
                        } catch (Throwable th) {
                            th = th;
                            zzxkVarZzy = zzxkVar2;
                            jMax = j12;
                            j4 = jZzS;
                            this.zzH = zzap(zzxkVarZzy, j4, jMax, j4, z3, 2);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        zzxkVarZzy = zzxkVar2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
            z3 = z2;
            j6 = jMax;
            j7 = jLongValue;
            this.zzH = zzap(zzxkVarZzy, j7, j6, j7, z3, 2);
        } catch (Throwable th4) {
            th = th4;
            z3 = z2;
            j4 = jLongValue;
        }
    }

    private final long zzS(zzxk zzxkVar, long j3, boolean z2) throws zzjk {
        zzmf zzmfVar = this.zzs;
        return zzT(zzxkVar, j3, zzmfVar.zzm() != zzmfVar.zzn(), z2);
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final long zzT(com.google.android.gms.internal.ads.zzxk r10, long r11, boolean r13, boolean r14) throws com.google.android.gms.internal.ads.zzjk {
        /*
            Method dump skipped, instruction units count: 243
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlu.zzT(com.google.android.gms.internal.ads.zzxk, long, boolean, boolean):long");
    }

    private final void zzU(long j3, boolean z2) throws zzjk {
        zzmc zzmcVarZzm = this.zzs.zzm();
        long jZza = j3 + (zzmcVarZzm == null ? 1000000000000L : zzmcVarZzm.zza());
        this.zzU = jZza;
        this.zzo.zzc(jZza);
        zzne[] zzneVarArr = this.zzb;
        for (int i3 = 0; i3 < 2; i3++) {
            zzneVarArr[i3].zzE(zzmcVarZzm, this.zzU, z2);
        }
        for (zzmc zzmcVarZzm2 = r0.zzm(); zzmcVarZzm2 != null; zzmcVarZzm2 = zzmcVarZzm2.zzp()) {
            for (zzaba zzabaVar : zzmcVarZzm2.zzr().zzc) {
            }
        }
    }

    private final void zzV() throws zzjk {
        int i3 = 0;
        while (true) {
            zzne[] zzneVarArr = this.zzb;
            if (i3 >= 2) {
                return;
            }
            zzneVarArr[i3].zzz(this.zzD ? this.zzC : null);
            i3++;
        }
    }

    private final void zzW(boolean z2, boolean z3) {
        zzX(z2 || !this.zzR, false, true, false);
        this.zzI.zza(z3 ? 1 : 0);
        this.zzg.zzc(this.zzv);
        this.zzz.zzc(this.zzH.zzl, 1);
        zzB(1);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x009d A[PHI: r2 r7 r9
      0x009d: PHI (r2v2 com.google.android.gms.internal.ads.zzxk) = (r2v1 com.google.android.gms.internal.ads.zzxk), (r2v11 com.google.android.gms.internal.ads.zzxk) binds: [B:28:0x0073, B:30:0x0098] A[DONT_GENERATE, DONT_INLINE]
      0x009d: PHI (r7v3 long) = (r7v2 long), (r7v11 long) binds: [B:28:0x0073, B:30:0x0098] A[DONT_GENERATE, DONT_INLINE]
      0x009d: PHI (r9v2 long) = (r9v1 long), (r9v7 long) binds: [B:28:0x0073, B:30:0x0098] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e1 A[PHI: r3
      0x00e1: PHI (r3v3 com.google.android.gms.internal.ads.zzbf) = 
      (r3v2 com.google.android.gms.internal.ads.zzbf)
      (r3v2 com.google.android.gms.internal.ads.zzbf)
      (r3v12 com.google.android.gms.internal.ads.zzbf)
      (r3v12 com.google.android.gms.internal.ads.zzbf)
     binds: [B:34:0x00aa, B:36:0x00ae, B:38:0x00bf, B:40:0x00d5] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzX(boolean r35, boolean r36, boolean r37, boolean r38) {
        /*
            Method dump skipped, instruction units count: 320
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlu.zzX(boolean, boolean, boolean, boolean):void");
    }

    private final Pair zzY(zzbf zzbfVar) {
        long j3 = 0;
        if (zzbfVar.zzg()) {
            return Pair.create(zzms.zzb(), 0L);
        }
        int iZzk = zzbfVar.zzk(this.zzQ);
        zzbe zzbeVar = this.zzl;
        zzbd zzbdVar = this.zzm;
        Pair pairZzm = zzbfVar.zzm(zzbeVar, zzbdVar, iZzk, -9223372036854775807L);
        zzxk zzxkVarZzy = this.zzs.zzy(zzbfVar, pairZzm.first, 0L);
        long jLongValue = ((Long) pairZzm.second).longValue();
        if (zzxkVarZzy.zzb()) {
            zzbfVar.zzo(zzxkVarZzy.zza, zzbdVar);
            if (zzxkVarZzy.zzc == zzbdVar.zzd(zzxkVarZzy.zzb)) {
                zzbdVar.zzj();
            }
        } else {
            j3 = jLongValue;
        }
        return Pair.create(zzxkVarZzy, Long.valueOf(j3));
    }

    private final void zzZ(zzbf zzbfVar, zzbf zzbfVar2) {
        if (zzbfVar.zzg() && zzbfVar2.zzg()) {
            return;
        }
        ArrayList arrayList = this.zzp;
        int size = arrayList.size() - 1;
        if (size < 0) {
            Collections.sort(arrayList);
        } else {
            Object obj = ((zzlq) arrayList.get(size)).zzb;
            String str = zzfl.zza;
            throw null;
        }
    }

    private final boolean zzaA() {
        if (!this.zzy) {
            return false;
        }
        zzne[] zzneVarArr = this.zzb;
        for (int i3 = 0; i3 < 2; i3++) {
            if (zzneVarArr[i3].zzc()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzaB, reason: merged with bridge method [inline-methods] */
    public final boolean zzw() {
        if (!this.zzD) {
            return false;
        }
        boolean z2 = this.zzC.zzg;
        return true;
    }

    private static boolean zzaC(zzms zzmsVar, zzbd zzbdVar) {
        zzxk zzxkVar = zzmsVar.zzb;
        zzbf zzbfVar = zzmsVar.zza;
        return zzbfVar.zzg() || zzbfVar.zzo(zzxkVar.zza, zzbdVar).zzf;
    }

    private final void zzaD(boolean z2, boolean z3) {
        this.zzM = z2;
        long jElapsedRealtime = -9223372036854775807L;
        if (z2 && !z3) {
            jElapsedRealtime = SystemClock.elapsedRealtime();
        }
        this.zzN = jElapsedRealtime;
    }

    private static Pair zzaE(zzbf zzbfVar, zzlt zzltVar, boolean z2, int i3, boolean z3, zzbe zzbeVar, zzbd zzbdVar) {
        Pair pairZzm;
        zzbf zzbfVar2;
        zzbf zzbfVar3 = zzltVar.zza;
        if (zzbfVar.zzg()) {
            return null;
        }
        boolean zZzg = zzbfVar3.zzg();
        zzbf zzbfVar4 = zzbfVar3;
        if (true == zZzg) {
            zzbfVar4 = zzbfVar;
        }
        try {
            pairZzm = zzbfVar4.zzm(zzbeVar, zzbdVar, zzltVar.zzb, zzltVar.zzc);
            zzbfVar2 = zzbfVar4;
        } catch (IndexOutOfBoundsException unused) {
        }
        if (zzbfVar.equals(zzbfVar2)) {
            return pairZzm;
        }
        if (zzbfVar.zze(pairZzm.first) != -1) {
            return (zzbfVar2.zzo(pairZzm.first, zzbdVar).zzf && zzbfVar2.zzb(zzbdVar.zzc, zzbeVar, 0L).zzn == zzbfVar2.zze(pairZzm.first)) ? zzbfVar.zzm(zzbeVar, zzbdVar, zzbfVar.zzo(pairZzm.first, zzbdVar).zzc, zzltVar.zzc) : pairZzm;
        }
        int iZzr = zzr(zzbeVar, zzbdVar, i3, z3, pairZzm.first, zzbfVar2, zzbfVar);
        if (iZzr != -1) {
            return zzbfVar.zzm(zzbeVar, zzbdVar, iZzr, -9223372036854775807L);
        }
        return null;
    }

    private static final void zzaF(zzmw zzmwVar) throws zzjk {
        zzmwVar.zzh();
        try {
            zzmwVar.zza().zzx(zzmwVar.zzc(), zzmwVar.zze());
        } finally {
            zzmwVar.zzi(true);
        }
    }

    private static final boolean zzaG(zzmc zzmcVar) {
        if (zzmcVar != null) {
            try {
                if (zzmcVar.zze) {
                    zzzc[] zzzcVarArr = zzmcVar.zzc;
                    for (int i3 = 0; i3 < 2; i3++) {
                        zzzc zzzcVar = zzzcVarArr[i3];
                        if (zzzcVar != null) {
                            zzzcVar.zzc();
                        }
                    }
                } else {
                    zzmcVar.zza.zzc();
                }
                if (zzmcVar.zzg() != Long.MIN_VALUE) {
                    return true;
                }
            } catch (IOException unused) {
            }
        }
        return false;
    }

    private final void zzaa() throws zzjk {
        int i3 = 0;
        while (true) {
            zzne[] zzneVarArr = this.zzb;
            if (i3 >= 2) {
                this.zzab = -9223372036854775807L;
                return;
            }
            int iZzd = zzneVarArr[i3].zzd();
            zzneVarArr[i3].zzA(this.zzo);
            zzN(i3, false);
            this.zzS -= iZzd;
            i3++;
        }
    }

    private final void zzab() {
        if (this.zzy && zzaA()) {
            zzne[] zzneVarArr = this.zzb;
            for (int i3 = 0; i3 < 2; i3++) {
                zzne zzneVar = zzneVarArr[i3];
                int iZzd = zzneVar.zzd();
                zzneVar.zzC(this.zzo);
                this.zzS -= iZzd - zzneVar.zzd();
            }
            this.zzab = -9223372036854775807L;
        }
    }

    private final void zzac() throws zzjk {
        zzad();
        zzI(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v4, types: [com.google.android.gms.internal.ads.zzlu] */
    /* JADX WARN: Type inference failed for: r6v7, types: [com.google.android.gms.internal.ads.zzlu] */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [int] */
    private final void zzad() throws zzjk {
        int i3;
        ?? r6;
        boolean z2;
        zzji zzjiVar = this.zzo;
        float f3 = zzjiVar.zzj().zzb;
        zzmf zzmfVar = this.zzs;
        zzmc zzmcVarZzm = zzmfVar.zzm();
        zzmc zzmcVarZzn = zzmfVar.zzn();
        zzabi zzabiVar = null;
        boolean z3 = true;
        while (zzmcVarZzm != null && zzmcVarZzm.zze) {
            zzms zzmsVar = this.zzH;
            zzabi zzabiVarZzk = zzmcVarZzm.zzk(f3, zzmsVar.zza, zzmsVar.zzl);
            zzabi zzabiVar2 = zzmcVarZzm == zzmfVar.zzm() ? zzabiVarZzk : zzabiVar;
            zzabi zzabiVarZzr = zzmcVarZzm.zzr();
            boolean z4 = false;
            if (zzabiVarZzr != null) {
                zzaba[] zzabaVarArr = zzabiVarZzk.zzc;
                if (zzabiVarZzr.zzc.length == zzabaVarArr.length) {
                    for (int i4 = 0; i4 < zzabaVarArr.length; i4++) {
                        if (zzabiVarZzk.zzb(zzabiVarZzr, i4)) {
                        }
                    }
                    if (zzmcVarZzm != zzmcVarZzn) {
                        z4 = true;
                    }
                    z3 &= z4;
                    zzmcVarZzm = zzmcVarZzm.zzp();
                    zzabiVar = zzabiVar2;
                }
            }
            if (z3) {
                zzmc zzmcVarZzm2 = zzmfVar.zzm();
                int iZzs = zzmfVar.zzs(zzmcVarZzm2) & 1;
                zzne[] zzneVarArr = this.zzb;
                boolean[] zArr = new boolean[2];
                zzabiVar2.getClass();
                long jZzm = zzmcVarZzm2.zzm(zzabiVar2, this.zzH.zzs, 1 == iZzs, zArr);
                zzms zzmsVar2 = this.zzH;
                if (zzmsVar2.zze == 4 || jZzm == zzmsVar2.zzs) {
                    z2 = false;
                } else {
                    z2 = false;
                    z4 = true;
                }
                zzms zzmsVar3 = this.zzH;
                boolean z5 = z2;
                i3 = 2;
                ?? r62 = this;
                r62.zzH = zzap(zzmsVar3.zzb, jZzm, zzmsVar3.zzc, zzmsVar3.zzd, z4, 5);
                if (z4) {
                    r62.zzU(jZzm, true);
                }
                r62.zzab();
                boolean[] zArr2 = new boolean[2];
                for (?? r8 = z5; r8 < 2; r8++) {
                    int iZzd = zzneVarArr[r8].zzd();
                    zArr2[r8] = zzneVarArr[r8].zzM();
                    zzneVarArr[r8].zzD(zzmcVarZzm2.zzc[r8], zzjiVar, r62.zzU, zArr[r8]);
                    if (iZzd - zzneVarArr[r8].zzd() > 0) {
                        r62.zzN(r8, z5);
                    }
                    r62.zzS -= iZzd - zzneVarArr[r8].zzd();
                }
                r62.zzar(zArr2, r62.zzU);
                zzmcVarZzm2.zzh = true;
                r6 = r62;
            } else {
                zzlu zzluVar = this;
                i3 = 2;
                zzmfVar.zzs(zzmcVarZzm);
                r6 = zzluVar;
                if (zzmcVarZzm.zze) {
                    long jMax = Math.max(zzmcVarZzm.zzg.zzb, zzluVar.zzU - zzmcVarZzm.zza());
                    if (zzluVar.zzy && zzluVar.zzaA() && zzmfVar.zzo() == zzmcVarZzm) {
                        zzluVar.zzab();
                    }
                    zzmcVarZzm.zzl(zzabiVarZzk, jMax, false);
                    r6 = zzluVar;
                }
            }
            r6.zzat(true);
            if (r6.zzH.zze != 4) {
                r6.zzan();
                r6.zzL();
                r6.zzi.zzh(i3);
                return;
            }
            return;
        }
    }

    private final boolean zzae() {
        zzmc zzmcVarZzm = this.zzs.zzm();
        long j3 = zzmcVarZzm.zzg.zzf;
        if (zzmcVarZzm.zze) {
            return j3 == -9223372036854775807L || this.zzH.zzs < j3 || !zzay();
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0427  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x042a  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0434  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x043c  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x043e  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0444  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0469  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x020f  */
    /* JADX WARN: Type inference failed for: r12v10, types: [com.google.android.gms.internal.ads.zzlt] */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v17 */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5, types: [com.google.android.gms.internal.ads.zzlt] */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v10 */
    /* JADX WARN: Type inference failed for: r16v11 */
    /* JADX WARN: Type inference failed for: r16v12 */
    /* JADX WARN: Type inference failed for: r16v13 */
    /* JADX WARN: Type inference failed for: r16v14 */
    /* JADX WARN: Type inference failed for: r16v15 */
    /* JADX WARN: Type inference failed for: r16v16 */
    /* JADX WARN: Type inference failed for: r16v17 */
    /* JADX WARN: Type inference failed for: r16v18 */
    /* JADX WARN: Type inference failed for: r16v19 */
    /* JADX WARN: Type inference failed for: r16v20 */
    /* JADX WARN: Type inference failed for: r16v21 */
    /* JADX WARN: Type inference failed for: r16v22 */
    /* JADX WARN: Type inference failed for: r16v23 */
    /* JADX WARN: Type inference failed for: r16v24 */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r16v5 */
    /* JADX WARN: Type inference failed for: r16v6 */
    /* JADX WARN: Type inference failed for: r16v7 */
    /* JADX WARN: Type inference failed for: r16v8 */
    /* JADX WARN: Type inference failed for: r16v9 */
    /* JADX WARN: Type inference failed for: r34v0, types: [com.google.android.gms.internal.ads.zzlu] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzaf(com.google.android.gms.internal.ads.zzbf r35, boolean r36) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1142
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlu.zzaf(com.google.android.gms.internal.ads.zzbf, boolean):void");
    }

    private final void zzag(zzbf zzbfVar, zzxk zzxkVar, zzbf zzbfVar2, zzxk zzxkVar2, long j3, boolean z2) throws zzjk {
        if (!zzP(zzbfVar, zzxkVar)) {
            zzav zzavVar = zzxkVar.zzb() ? zzav.zza : this.zzH.zzo;
            if (this.zzo.zzj().equals(zzavVar)) {
                return;
            }
            zzM(zzavVar);
            zzam(this.zzH.zzo, zzavVar.zzb, false, false);
            return;
        }
        Object obj = zzxkVar.zza;
        zzbd zzbdVar = this.zzm;
        int i3 = zzbfVar.zzo(obj, zzbdVar).zzc;
        zzbe zzbeVar = this.zzl;
        zzbfVar.zzb(i3, zzbeVar, 0L);
        zzjd zzjdVar = this.zzae;
        zzaf zzafVar = zzbeVar.zzj;
        String str = zzfl.zza;
        zzjdVar.zza(zzafVar);
        if (j3 != -9223372036854775807L) {
            zzjdVar.zzb(zzO(zzbfVar, obj, j3));
            return;
        }
        if (!Objects.equals(!zzbfVar2.zzg() ? zzbfVar2.zzb(zzbfVar2.zzo(zzxkVar2.zza, zzbdVar).zzc, zzbeVar, 0L).zzb : null, zzbeVar.zzb) || z2) {
            zzjdVar.zzb(-9223372036854775807L);
        }
    }

    private final long zzah(zzmc zzmcVar) {
        if (zzmcVar == null) {
            return 0L;
        }
        long jZza = zzmcVar.zza();
        if (zzmcVar.zze) {
            int i3 = 0;
            while (true) {
                zzne[] zzneVarArr = this.zzb;
                if (i3 >= 2) {
                    break;
                }
                if (zzneVarArr[i3].zzp(zzmcVar)) {
                    long jZzf = zzneVarArr[i3].zzf(zzmcVar);
                    if (jZzf == Long.MIN_VALUE) {
                        return Long.MIN_VALUE;
                    }
                    jZza = Math.max(jZzf, jZza);
                }
                i3++;
            }
        }
        return jZza;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0218 A[LOOP:9: B:118:0x0216->B:119:0x0218, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0108 A[EDGE_INSN: B:227:0x0108->B:63:0x0108 BREAK  A[LOOP:6: B:72:0x0128->B:76:0x0134]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzai() throws com.google.android.gms.internal.ads.zzjk {
        /*
            Method dump skipped, instruction units count: 905
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlu.zzai():void");
    }

    private final void zzaj() {
        zzmf zzmfVar = this.zzs;
        zzmfVar.zzt();
        zzmc zzmcVarZzl = zzmfVar.zzl();
        if (zzmcVarZzl != null) {
            if (!zzmcVarZzl.zzd || zzmcVarZzl.zze) {
                zzxi zzxiVar = zzmcVarZzl.zza;
                if (zzxiVar.zzn()) {
                    return;
                }
                if (this.zzg.zzj(this.zzv, this.zzH.zza, zzmcVarZzl.zzg.zza, zzmcVarZzl.zze ? zzxiVar.zzi() : 0L)) {
                    if (!zzmcVarZzl.zzd) {
                        zzmcVarZzl.zzt(this, zzmcVarZzl.zzg.zzb);
                        return;
                    }
                    zzlz zzlzVar = new zzlz();
                    zzlzVar.zza(this.zzU - zzmcVarZzl.zza());
                    zzlzVar.zzb(this.zzo.zzj().zzb);
                    zzlzVar.zzc(this.zzN);
                    zzmcVarZzl.zzj(new zzma(zzlzVar, null));
                }
            }
        }
    }

    private final void zzak() {
        zzmc zzmcVarZzm = this.zzs.zzm();
        boolean z2 = false;
        if (zzmcVarZzm != null && zzmcVarZzm.zzg.zzj && this.zzK) {
            z2 = true;
        }
        this.zzL = z2;
    }

    private final void zzal(zzav zzavVar, boolean z2) throws zzjk {
        zzam(zzavVar, zzavVar.zzb, true, z2);
    }

    private final void zzam(zzav zzavVar, float f3, boolean z2, boolean z3) throws zzjk {
        int i3;
        if (z2) {
            if (z3) {
                this.zzI.zza(1);
            }
            zzms zzmsVar = this.zzH;
            this.zzH = new zzms(zzmsVar.zza, zzmsVar.zzb, zzmsVar.zzc, zzmsVar.zzd, zzmsVar.zze, zzmsVar.zzf, zzmsVar.zzg, zzmsVar.zzh, zzmsVar.zzi, zzmsVar.zzj, zzmsVar.zzk, zzmsVar.zzl, zzmsVar.zzm, zzmsVar.zzn, zzavVar, zzmsVar.zzq, zzmsVar.zzr, zzmsVar.zzs, zzmsVar.zzt, false);
        }
        float f4 = zzavVar.zzb;
        zzmc zzmcVarZzm = this.zzs.zzm();
        while (true) {
            i3 = 0;
            if (zzmcVarZzm == null) {
                break;
            }
            zzaba[] zzabaVarArr = zzmcVarZzm.zzr().zzc;
            int length = zzabaVarArr.length;
            while (i3 < length) {
                zzaba zzabaVar = zzabaVarArr[i3];
                i3++;
            }
            zzmcVarZzm = zzmcVarZzm.zzp();
        }
        zzne[] zzneVarArr = this.zzb;
        while (i3 < 2) {
            zzneVarArr[i3].zzm(f3, f4);
            i3++;
        }
    }

    private final void zzan() {
        long jZza;
        long jZza2;
        zzmf zzmfVar = this.zzs;
        boolean zZzh = false;
        if (zzaG(zzmfVar.zzk())) {
            zzmc zzmcVarZzk = zzmfVar.zzk();
            long jZzav = zzav(zzmcVarZzk.zzg());
            if (zzmcVarZzk == zzmfVar.zzm()) {
                jZza = this.zzU;
                jZza2 = zzmcVarZzk.zza();
            } else {
                jZza = this.zzU - zzmcVarZzk.zza();
                jZza2 = zzmcVarZzk.zzg.zzb;
            }
            zzlx zzlxVar = new zzlx(this.zzv, this.zzH.zza, zzmcVarZzk.zzg.zza, jZza - jZza2, jZzav, this.zzo.zzj().zzb, this.zzH.zzl, this.zzM, zzP(this.zzH.zza, zzmcVarZzk.zzg.zza) ? this.zzae.zze() : -9223372036854775807L, this.zzN);
            zzly zzlyVar = this.zzg;
            boolean zZzh2 = zzlyVar.zzh(zzlxVar);
            zzmc zzmcVarZzm = zzmfVar.zzm();
            if (zZzh2 || !zzmcVarZzm.zze || jZzav >= 500000 || this.zzn <= 0) {
                zZzh = zZzh2;
            } else {
                zzmcVarZzm.zza.zzf(this.zzH.zzs, false);
                zZzh = zzlyVar.zzh(zzlxVar);
            }
        }
        this.zzO = zZzh;
        if (zZzh) {
            zzmc zzmcVarZzk2 = zzmfVar.zzk();
            zzmcVarZzk2.getClass();
            zzlz zzlzVar = new zzlz();
            zzlzVar.zza(this.zzU - zzmcVarZzk2.zza());
            zzlzVar.zzb(this.zzo.zzj().zzb);
            zzlzVar.zzc(this.zzN);
            zzmcVarZzk2.zzj(new zzma(zzlzVar, null));
        }
        zzao();
    }

    private final void zzao() {
        zzmc zzmcVarZzk = this.zzs.zzk();
        boolean z2 = true;
        if (!this.zzO && (zzmcVarZzk == null || !zzmcVarZzk.zza.zzn())) {
            z2 = false;
        }
        zzms zzmsVar = this.zzH;
        if (z2 != zzmsVar.zzg) {
            this.zzH = zzmsVar.zzg(z2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.google.android.gms.internal.ads.zzms zzap(com.google.android.gms.internal.ads.zzxk r17, long r18, long r20, long r22, boolean r24, int r25) {
        /*
            Method dump skipped, instruction units count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlu.zzap(com.google.android.gms.internal.ads.zzxk, long, long, long, boolean, int):com.google.android.gms.internal.ads.zzms");
    }

    private final void zzaq() throws zzjk {
        zzar(new boolean[2], this.zzs.zzn().zzc());
    }

    private final void zzar(boolean[] zArr, long j3) throws zzjk {
        zzne[] zzneVarArr;
        long j4;
        zzmc zzmcVarZzn = this.zzs.zzn();
        zzabi zzabiVarZzr = zzmcVarZzn.zzr();
        int i3 = 0;
        while (true) {
            zzneVarArr = this.zzb;
            if (i3 >= 2) {
                break;
            }
            if (!zzabiVarZzr.zza(i3)) {
                zzneVarArr[i3].zzG();
            }
            i3++;
        }
        int i4 = 0;
        while (i4 < 2) {
            if (!zzabiVarZzr.zza(i4) || zzneVarArr[i4].zzp(zzmcVarZzn)) {
                j4 = j3;
            } else {
                j4 = j3;
                zzas(zzmcVarZzn, i4, zArr[i4], j4);
            }
            i4++;
            j3 = j4;
        }
    }

    private final void zzas(zzmc zzmcVar, int i3, boolean z2, long j3) throws zzjk {
        zzne zzneVar = this.zzb[i3];
        if (zzneVar.zzM()) {
            return;
        }
        boolean z3 = zzmcVar == this.zzs.zzm();
        zzabi zzabiVarZzr = zzmcVar.zzr();
        zznd zzndVar = zzabiVarZzr.zzb[i3];
        zzaba zzabaVar = zzabiVarZzr.zzc[i3];
        boolean z4 = zzay() && this.zzH.zze == 3;
        boolean z5 = !z2 && z4;
        this.zzS++;
        zzneVar.zzx(zzndVar, zzabaVar, zzmcVar.zzc[i3], this.zzU, z5, z3, j3, zzmcVar.zza(), zzmcVar.zzg.zza, this.zzo);
        zzneVar.zzy(11, new zzli(this), zzmcVar);
        if (z4 && z3) {
            zzneVar.zzv();
        }
    }

    private final void zzat(boolean z2) {
        zzmc zzmcVarZzk = this.zzs.zzk();
        zzxk zzxkVar = zzmcVarZzk == null ? this.zzH.zzb : zzmcVarZzk.zzg.zza;
        boolean zEquals = this.zzH.zzk.equals(zzxkVar);
        if (!zEquals) {
            this.zzH = this.zzH.zzh(zzxkVar);
        }
        zzms zzmsVar = this.zzH;
        zzmsVar.zzq = zzmcVarZzk == null ? zzmsVar.zzs : zzmcVarZzk.zzf();
        this.zzH.zzr = zzau();
        if ((!zEquals || z2) && zzmcVarZzk != null && zzmcVarZzk.zze) {
            zzax(zzmcVarZzk.zzg.zza, zzmcVarZzk.zzq(), zzmcVarZzk.zzr());
        }
    }

    private final long zzau() {
        return zzav(this.zzH.zzq);
    }

    private final long zzav(long j3) {
        zzmc zzmcVarZzk = this.zzs.zzk();
        if (zzmcVarZzk == null) {
            return 0L;
        }
        return Math.max(0L, j3 - (this.zzU - zzmcVarZzk.zza()));
    }

    private final long zzaw(zzmc zzmcVar) {
        zzgtj.zzi(zzmcVar.zze);
        return (long) ((zzmcVar.zzc() - this.zzU) / this.zzo.zzj().zzb);
    }

    private final void zzax(zzxk zzxkVar, zzzn zzznVar, zzabi zzabiVar) {
        long jZza;
        long jZza2;
        zzmf zzmfVar = this.zzs;
        zzmc zzmcVarZzk = zzmfVar.zzk();
        zzmcVarZzk.getClass();
        if (zzmcVarZzk == zzmfVar.zzm()) {
            jZza = this.zzU;
            jZza2 = zzmcVarZzk.zza();
        } else {
            jZza = this.zzU - zzmcVarZzk.zza();
            jZza2 = zzmcVarZzk.zzg.zzb;
        }
        this.zzg.zzb(new zzlx(this.zzv, this.zzH.zza, zzxkVar, jZza - jZza2, zzav(zzmcVarZzk.zzf()), this.zzo.zzj().zzb, this.zzH.zzl, this.zzM, zzP(this.zzH.zza, zzmcVarZzk.zzg.zza) ? this.zzae.zze() : -9223372036854775807L, this.zzN), zzznVar, zzabiVar.zzc);
    }

    private final boolean zzay() {
        zzms zzmsVar = this.zzH;
        return zzmsVar.zzl && zzmsVar.zzn == 0;
    }

    private final void zzaz(int i3) throws Throwable {
        zzne zzneVar = this.zzb[i3];
        try {
            zzmc zzmcVarZzm = this.zzs.zzm();
            if (zzmcVarZzm == null) {
                throw null;
            }
            zzneVar.zzu(zzmcVarZzm);
        } catch (IOException e3) {
            e = e3;
            zzneVar.zze();
            throw e;
        } catch (RuntimeException e4) {
            e = e4;
            zzneVar.zze();
            throw e;
        }
    }

    static int zzr(zzbe zzbeVar, zzbd zzbdVar, int i3, boolean z2, Object obj, zzbf zzbfVar, zzbf zzbfVar2) {
        zzbe zzbeVar2 = zzbeVar;
        zzbf zzbfVar3 = zzbfVar;
        Object obj2 = zzbfVar3.zzb(zzbfVar3.zzo(obj, zzbdVar).zzc, zzbeVar, 0L).zzb;
        for (int i4 = 0; i4 < zzbfVar2.zza(); i4++) {
            if (zzbfVar2.zzb(i4, zzbeVar, 0L).zzb.equals(obj2)) {
                return i4;
            }
        }
        int iZze = zzbfVar3.zze(obj);
        int iZzc = zzbfVar3.zzc();
        int iZze2 = -1;
        int i5 = 0;
        while (true) {
            if (i5 >= iZzc || iZze2 != -1) {
                break;
            }
            zzbf zzbfVar4 = zzbfVar3;
            int iZzl = zzbfVar4.zzl(iZze, zzbdVar, zzbeVar2, i3, z2);
            if (iZzl == -1) {
                iZze2 = -1;
                break;
            }
            iZze2 = zzbfVar2.zze(zzbfVar4.zzf(iZzl));
            i5++;
            zzbfVar3 = zzbfVar4;
            iZze = iZzl;
            zzbeVar2 = zzbeVar;
        }
        if (iZze2 == -1) {
            return -1;
        }
        return zzbfVar2.zzd(iZze2, zzbdVar, false).zzc;
    }

    static final /* synthetic */ void zzz(zzmw zzmwVar) {
        try {
            zzaF(zzmwVar);
        } catch (zzjk e3) {
            zzeg.zzf("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e3);
            throw new RuntimeException(e3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:261:0x0563 A[Catch: RuntimeException -> 0x0022, IOException -> 0x0025, zzwk -> 0x0028, zzhq -> 0x002b, zzat -> 0x002e, zzuf -> 0x0031, zzjk -> 0x0034, TryCatch #7 {zzat -> 0x002e, zzhq -> 0x002b, zzjk -> 0x0034, zzuf -> 0x0031, zzwk -> 0x0028, IOException -> 0x0025, RuntimeException -> 0x0022, blocks: (B:3:0x000b, B:4:0x0012, B:6:0x0016, B:22:0x0037, B:24:0x003d, B:25:0x0043, B:27:0x004d, B:29:0x0053, B:31:0x0057, B:33:0x005f, B:34:0x0064, B:36:0x0068, B:37:0x0072, B:39:0x007f, B:40:0x0086, B:41:0x008c, B:43:0x0095, B:44:0x009d, B:45:0x00a4, B:46:0x00b3, B:47:0x00c0, B:51:0x00d1, B:52:0x00d9, B:54:0x00e8, B:55:0x00f0, B:60:0x00ff, B:58:0x00f8, B:61:0x0104, B:65:0x0120, B:66:0x0138, B:67:0x0149, B:68:0x0161, B:69:0x0166, B:70:0x016b, B:74:0x0172, B:76:0x017b, B:78:0x0187, B:79:0x018f, B:80:0x019a, B:81:0x01ae, B:82:0x01c6, B:83:0x01dc, B:85:0x01eb, B:86:0x01ef, B:87:0x0200, B:89:0x020f, B:90:0x022b, B:91:0x023e, B:92:0x0247, B:94:0x0259, B:95:0x0265, B:96:0x0275, B:98:0x0281, B:101:0x028c, B:102:0x0293, B:103:0x029e, B:107:0x02a5, B:109:0x02ad, B:111:0x02b1, B:113:0x02b6, B:115:0x02c0, B:116:0x02c5, B:120:0x02cc, B:122:0x02dc, B:126:0x02e6, B:123:0x02e0, B:125:0x02e3, B:127:0x02eb, B:129:0x02fd, B:133:0x0307, B:130:0x0301, B:132:0x0304, B:134:0x030c, B:135:0x0311, B:137:0x031d, B:138:0x0327, B:140:0x032d, B:148:0x0348, B:155:0x0397, B:185:0x03dc, B:188:0x03e4, B:189:0x03e5, B:191:0x03ed, B:193:0x040a, B:194:0x040e, B:202:0x0442, B:204:0x0450, B:205:0x045d, B:206:0x045e, B:207:0x0465, B:208:0x046f, B:209:0x0483, B:210:0x048e, B:212:0x049d, B:213:0x04a0, B:219:0x04ad, B:220:0x04b0, B:222:0x04b8, B:223:0x04bd, B:225:0x04c9, B:226:0x04e5, B:228:0x04e9, B:230:0x04f1, B:245:0x051b, B:231:0x04f5, B:233:0x04fe, B:237:0x0507, B:243:0x0517, B:247:0x0528, B:249:0x0533, B:253:0x053b, B:255:0x0543, B:257:0x0547, B:258:0x0552, B:260:0x0558, B:313:0x0676, B:316:0x067d, B:318:0x0681, B:320:0x0689, B:321:0x068c, B:322:0x068f, B:324:0x0695, B:326:0x069e, B:328:0x06a8, B:330:0x06ae, B:332:0x06b4, B:339:0x06d6, B:341:0x06dc, B:345:0x06e6, B:355:0x06fe, B:352:0x06f7, B:354:0x06fb, B:333:0x06bb, B:336:0x06c9, B:337:0x06d1, B:338:0x06d2, B:261:0x0563, B:263:0x0569, B:265:0x056d, B:292:0x0618, B:294:0x0624, B:295:0x0631, B:297:0x0638, B:299:0x063c, B:303:0x0645, B:305:0x0654, B:307:0x065a, B:309:0x0664, B:310:0x0669, B:311:0x066e, B:312:0x0673, B:268:0x057f, B:270:0x0583, B:272:0x0595, B:274:0x05a0, B:276:0x05aa, B:280:0x05b3, B:282:0x05bd, B:288:0x05c8, B:246:0x0521, B:357:0x0704, B:361:0x070b), top: B:438:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:294:0x0624 A[Catch: RuntimeException -> 0x0022, IOException -> 0x0025, zzwk -> 0x0028, zzhq -> 0x002b, zzat -> 0x002e, zzuf -> 0x0031, zzjk -> 0x0034, TryCatch #7 {zzat -> 0x002e, zzhq -> 0x002b, zzjk -> 0x0034, zzuf -> 0x0031, zzwk -> 0x0028, IOException -> 0x0025, RuntimeException -> 0x0022, blocks: (B:3:0x000b, B:4:0x0012, B:6:0x0016, B:22:0x0037, B:24:0x003d, B:25:0x0043, B:27:0x004d, B:29:0x0053, B:31:0x0057, B:33:0x005f, B:34:0x0064, B:36:0x0068, B:37:0x0072, B:39:0x007f, B:40:0x0086, B:41:0x008c, B:43:0x0095, B:44:0x009d, B:45:0x00a4, B:46:0x00b3, B:47:0x00c0, B:51:0x00d1, B:52:0x00d9, B:54:0x00e8, B:55:0x00f0, B:60:0x00ff, B:58:0x00f8, B:61:0x0104, B:65:0x0120, B:66:0x0138, B:67:0x0149, B:68:0x0161, B:69:0x0166, B:70:0x016b, B:74:0x0172, B:76:0x017b, B:78:0x0187, B:79:0x018f, B:80:0x019a, B:81:0x01ae, B:82:0x01c6, B:83:0x01dc, B:85:0x01eb, B:86:0x01ef, B:87:0x0200, B:89:0x020f, B:90:0x022b, B:91:0x023e, B:92:0x0247, B:94:0x0259, B:95:0x0265, B:96:0x0275, B:98:0x0281, B:101:0x028c, B:102:0x0293, B:103:0x029e, B:107:0x02a5, B:109:0x02ad, B:111:0x02b1, B:113:0x02b6, B:115:0x02c0, B:116:0x02c5, B:120:0x02cc, B:122:0x02dc, B:126:0x02e6, B:123:0x02e0, B:125:0x02e3, B:127:0x02eb, B:129:0x02fd, B:133:0x0307, B:130:0x0301, B:132:0x0304, B:134:0x030c, B:135:0x0311, B:137:0x031d, B:138:0x0327, B:140:0x032d, B:148:0x0348, B:155:0x0397, B:185:0x03dc, B:188:0x03e4, B:189:0x03e5, B:191:0x03ed, B:193:0x040a, B:194:0x040e, B:202:0x0442, B:204:0x0450, B:205:0x045d, B:206:0x045e, B:207:0x0465, B:208:0x046f, B:209:0x0483, B:210:0x048e, B:212:0x049d, B:213:0x04a0, B:219:0x04ad, B:220:0x04b0, B:222:0x04b8, B:223:0x04bd, B:225:0x04c9, B:226:0x04e5, B:228:0x04e9, B:230:0x04f1, B:245:0x051b, B:231:0x04f5, B:233:0x04fe, B:237:0x0507, B:243:0x0517, B:247:0x0528, B:249:0x0533, B:253:0x053b, B:255:0x0543, B:257:0x0547, B:258:0x0552, B:260:0x0558, B:313:0x0676, B:316:0x067d, B:318:0x0681, B:320:0x0689, B:321:0x068c, B:322:0x068f, B:324:0x0695, B:326:0x069e, B:328:0x06a8, B:330:0x06ae, B:332:0x06b4, B:339:0x06d6, B:341:0x06dc, B:345:0x06e6, B:355:0x06fe, B:352:0x06f7, B:354:0x06fb, B:333:0x06bb, B:336:0x06c9, B:337:0x06d1, B:338:0x06d2, B:261:0x0563, B:263:0x0569, B:265:0x056d, B:292:0x0618, B:294:0x0624, B:295:0x0631, B:297:0x0638, B:299:0x063c, B:303:0x0645, B:305:0x0654, B:307:0x065a, B:309:0x0664, B:310:0x0669, B:311:0x066e, B:312:0x0673, B:268:0x057f, B:270:0x0583, B:272:0x0595, B:274:0x05a0, B:276:0x05aa, B:280:0x05b3, B:282:0x05bd, B:288:0x05c8, B:246:0x0521, B:357:0x0704, B:361:0x070b), top: B:438:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:297:0x0638 A[Catch: RuntimeException -> 0x0022, IOException -> 0x0025, zzwk -> 0x0028, zzhq -> 0x002b, zzat -> 0x002e, zzuf -> 0x0031, zzjk -> 0x0034, TryCatch #7 {zzat -> 0x002e, zzhq -> 0x002b, zzjk -> 0x0034, zzuf -> 0x0031, zzwk -> 0x0028, IOException -> 0x0025, RuntimeException -> 0x0022, blocks: (B:3:0x000b, B:4:0x0012, B:6:0x0016, B:22:0x0037, B:24:0x003d, B:25:0x0043, B:27:0x004d, B:29:0x0053, B:31:0x0057, B:33:0x005f, B:34:0x0064, B:36:0x0068, B:37:0x0072, B:39:0x007f, B:40:0x0086, B:41:0x008c, B:43:0x0095, B:44:0x009d, B:45:0x00a4, B:46:0x00b3, B:47:0x00c0, B:51:0x00d1, B:52:0x00d9, B:54:0x00e8, B:55:0x00f0, B:60:0x00ff, B:58:0x00f8, B:61:0x0104, B:65:0x0120, B:66:0x0138, B:67:0x0149, B:68:0x0161, B:69:0x0166, B:70:0x016b, B:74:0x0172, B:76:0x017b, B:78:0x0187, B:79:0x018f, B:80:0x019a, B:81:0x01ae, B:82:0x01c6, B:83:0x01dc, B:85:0x01eb, B:86:0x01ef, B:87:0x0200, B:89:0x020f, B:90:0x022b, B:91:0x023e, B:92:0x0247, B:94:0x0259, B:95:0x0265, B:96:0x0275, B:98:0x0281, B:101:0x028c, B:102:0x0293, B:103:0x029e, B:107:0x02a5, B:109:0x02ad, B:111:0x02b1, B:113:0x02b6, B:115:0x02c0, B:116:0x02c5, B:120:0x02cc, B:122:0x02dc, B:126:0x02e6, B:123:0x02e0, B:125:0x02e3, B:127:0x02eb, B:129:0x02fd, B:133:0x0307, B:130:0x0301, B:132:0x0304, B:134:0x030c, B:135:0x0311, B:137:0x031d, B:138:0x0327, B:140:0x032d, B:148:0x0348, B:155:0x0397, B:185:0x03dc, B:188:0x03e4, B:189:0x03e5, B:191:0x03ed, B:193:0x040a, B:194:0x040e, B:202:0x0442, B:204:0x0450, B:205:0x045d, B:206:0x045e, B:207:0x0465, B:208:0x046f, B:209:0x0483, B:210:0x048e, B:212:0x049d, B:213:0x04a0, B:219:0x04ad, B:220:0x04b0, B:222:0x04b8, B:223:0x04bd, B:225:0x04c9, B:226:0x04e5, B:228:0x04e9, B:230:0x04f1, B:245:0x051b, B:231:0x04f5, B:233:0x04fe, B:237:0x0507, B:243:0x0517, B:247:0x0528, B:249:0x0533, B:253:0x053b, B:255:0x0543, B:257:0x0547, B:258:0x0552, B:260:0x0558, B:313:0x0676, B:316:0x067d, B:318:0x0681, B:320:0x0689, B:321:0x068c, B:322:0x068f, B:324:0x0695, B:326:0x069e, B:328:0x06a8, B:330:0x06ae, B:332:0x06b4, B:339:0x06d6, B:341:0x06dc, B:345:0x06e6, B:355:0x06fe, B:352:0x06f7, B:354:0x06fb, B:333:0x06bb, B:336:0x06c9, B:337:0x06d1, B:338:0x06d2, B:261:0x0563, B:263:0x0569, B:265:0x056d, B:292:0x0618, B:294:0x0624, B:295:0x0631, B:297:0x0638, B:299:0x063c, B:303:0x0645, B:305:0x0654, B:307:0x065a, B:309:0x0664, B:310:0x0669, B:311:0x066e, B:312:0x0673, B:268:0x057f, B:270:0x0583, B:272:0x0595, B:274:0x05a0, B:276:0x05aa, B:280:0x05b3, B:282:0x05bd, B:288:0x05c8, B:246:0x0521, B:357:0x0704, B:361:0x070b), top: B:438:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:305:0x0654 A[Catch: RuntimeException -> 0x0022, IOException -> 0x0025, zzwk -> 0x0028, zzhq -> 0x002b, zzat -> 0x002e, zzuf -> 0x0031, zzjk -> 0x0034, TryCatch #7 {zzat -> 0x002e, zzhq -> 0x002b, zzjk -> 0x0034, zzuf -> 0x0031, zzwk -> 0x0028, IOException -> 0x0025, RuntimeException -> 0x0022, blocks: (B:3:0x000b, B:4:0x0012, B:6:0x0016, B:22:0x0037, B:24:0x003d, B:25:0x0043, B:27:0x004d, B:29:0x0053, B:31:0x0057, B:33:0x005f, B:34:0x0064, B:36:0x0068, B:37:0x0072, B:39:0x007f, B:40:0x0086, B:41:0x008c, B:43:0x0095, B:44:0x009d, B:45:0x00a4, B:46:0x00b3, B:47:0x00c0, B:51:0x00d1, B:52:0x00d9, B:54:0x00e8, B:55:0x00f0, B:60:0x00ff, B:58:0x00f8, B:61:0x0104, B:65:0x0120, B:66:0x0138, B:67:0x0149, B:68:0x0161, B:69:0x0166, B:70:0x016b, B:74:0x0172, B:76:0x017b, B:78:0x0187, B:79:0x018f, B:80:0x019a, B:81:0x01ae, B:82:0x01c6, B:83:0x01dc, B:85:0x01eb, B:86:0x01ef, B:87:0x0200, B:89:0x020f, B:90:0x022b, B:91:0x023e, B:92:0x0247, B:94:0x0259, B:95:0x0265, B:96:0x0275, B:98:0x0281, B:101:0x028c, B:102:0x0293, B:103:0x029e, B:107:0x02a5, B:109:0x02ad, B:111:0x02b1, B:113:0x02b6, B:115:0x02c0, B:116:0x02c5, B:120:0x02cc, B:122:0x02dc, B:126:0x02e6, B:123:0x02e0, B:125:0x02e3, B:127:0x02eb, B:129:0x02fd, B:133:0x0307, B:130:0x0301, B:132:0x0304, B:134:0x030c, B:135:0x0311, B:137:0x031d, B:138:0x0327, B:140:0x032d, B:148:0x0348, B:155:0x0397, B:185:0x03dc, B:188:0x03e4, B:189:0x03e5, B:191:0x03ed, B:193:0x040a, B:194:0x040e, B:202:0x0442, B:204:0x0450, B:205:0x045d, B:206:0x045e, B:207:0x0465, B:208:0x046f, B:209:0x0483, B:210:0x048e, B:212:0x049d, B:213:0x04a0, B:219:0x04ad, B:220:0x04b0, B:222:0x04b8, B:223:0x04bd, B:225:0x04c9, B:226:0x04e5, B:228:0x04e9, B:230:0x04f1, B:245:0x051b, B:231:0x04f5, B:233:0x04fe, B:237:0x0507, B:243:0x0517, B:247:0x0528, B:249:0x0533, B:253:0x053b, B:255:0x0543, B:257:0x0547, B:258:0x0552, B:260:0x0558, B:313:0x0676, B:316:0x067d, B:318:0x0681, B:320:0x0689, B:321:0x068c, B:322:0x068f, B:324:0x0695, B:326:0x069e, B:328:0x06a8, B:330:0x06ae, B:332:0x06b4, B:339:0x06d6, B:341:0x06dc, B:345:0x06e6, B:355:0x06fe, B:352:0x06f7, B:354:0x06fb, B:333:0x06bb, B:336:0x06c9, B:337:0x06d1, B:338:0x06d2, B:261:0x0563, B:263:0x0569, B:265:0x056d, B:292:0x0618, B:294:0x0624, B:295:0x0631, B:297:0x0638, B:299:0x063c, B:303:0x0645, B:305:0x0654, B:307:0x065a, B:309:0x0664, B:310:0x0669, B:311:0x066e, B:312:0x0673, B:268:0x057f, B:270:0x0583, B:272:0x0595, B:274:0x05a0, B:276:0x05aa, B:280:0x05b3, B:282:0x05bd, B:288:0x05c8, B:246:0x0521, B:357:0x0704, B:361:0x070b), top: B:438:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:315:0x067c  */
    /* JADX WARN: Removed duplicated region for block: B:338:0x06d2 A[Catch: RuntimeException -> 0x0022, IOException -> 0x0025, zzwk -> 0x0028, zzhq -> 0x002b, zzat -> 0x002e, zzuf -> 0x0031, zzjk -> 0x0034, TryCatch #7 {zzat -> 0x002e, zzhq -> 0x002b, zzjk -> 0x0034, zzuf -> 0x0031, zzwk -> 0x0028, IOException -> 0x0025, RuntimeException -> 0x0022, blocks: (B:3:0x000b, B:4:0x0012, B:6:0x0016, B:22:0x0037, B:24:0x003d, B:25:0x0043, B:27:0x004d, B:29:0x0053, B:31:0x0057, B:33:0x005f, B:34:0x0064, B:36:0x0068, B:37:0x0072, B:39:0x007f, B:40:0x0086, B:41:0x008c, B:43:0x0095, B:44:0x009d, B:45:0x00a4, B:46:0x00b3, B:47:0x00c0, B:51:0x00d1, B:52:0x00d9, B:54:0x00e8, B:55:0x00f0, B:60:0x00ff, B:58:0x00f8, B:61:0x0104, B:65:0x0120, B:66:0x0138, B:67:0x0149, B:68:0x0161, B:69:0x0166, B:70:0x016b, B:74:0x0172, B:76:0x017b, B:78:0x0187, B:79:0x018f, B:80:0x019a, B:81:0x01ae, B:82:0x01c6, B:83:0x01dc, B:85:0x01eb, B:86:0x01ef, B:87:0x0200, B:89:0x020f, B:90:0x022b, B:91:0x023e, B:92:0x0247, B:94:0x0259, B:95:0x0265, B:96:0x0275, B:98:0x0281, B:101:0x028c, B:102:0x0293, B:103:0x029e, B:107:0x02a5, B:109:0x02ad, B:111:0x02b1, B:113:0x02b6, B:115:0x02c0, B:116:0x02c5, B:120:0x02cc, B:122:0x02dc, B:126:0x02e6, B:123:0x02e0, B:125:0x02e3, B:127:0x02eb, B:129:0x02fd, B:133:0x0307, B:130:0x0301, B:132:0x0304, B:134:0x030c, B:135:0x0311, B:137:0x031d, B:138:0x0327, B:140:0x032d, B:148:0x0348, B:155:0x0397, B:185:0x03dc, B:188:0x03e4, B:189:0x03e5, B:191:0x03ed, B:193:0x040a, B:194:0x040e, B:202:0x0442, B:204:0x0450, B:205:0x045d, B:206:0x045e, B:207:0x0465, B:208:0x046f, B:209:0x0483, B:210:0x048e, B:212:0x049d, B:213:0x04a0, B:219:0x04ad, B:220:0x04b0, B:222:0x04b8, B:223:0x04bd, B:225:0x04c9, B:226:0x04e5, B:228:0x04e9, B:230:0x04f1, B:245:0x051b, B:231:0x04f5, B:233:0x04fe, B:237:0x0507, B:243:0x0517, B:247:0x0528, B:249:0x0533, B:253:0x053b, B:255:0x0543, B:257:0x0547, B:258:0x0552, B:260:0x0558, B:313:0x0676, B:316:0x067d, B:318:0x0681, B:320:0x0689, B:321:0x068c, B:322:0x068f, B:324:0x0695, B:326:0x069e, B:328:0x06a8, B:330:0x06ae, B:332:0x06b4, B:339:0x06d6, B:341:0x06dc, B:345:0x06e6, B:355:0x06fe, B:352:0x06f7, B:354:0x06fb, B:333:0x06bb, B:336:0x06c9, B:337:0x06d1, B:338:0x06d2, B:261:0x0563, B:263:0x0569, B:265:0x056d, B:292:0x0618, B:294:0x0624, B:295:0x0631, B:297:0x0638, B:299:0x063c, B:303:0x0645, B:305:0x0654, B:307:0x065a, B:309:0x0664, B:310:0x0669, B:311:0x066e, B:312:0x0673, B:268:0x057f, B:270:0x0583, B:272:0x0595, B:274:0x05a0, B:276:0x05aa, B:280:0x05b3, B:282:0x05bd, B:288:0x05c8, B:246:0x0521, B:357:0x0704, B:361:0x070b), top: B:438:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:375:0x074f  */
    /* JADX WARN: Removed duplicated region for block: B:379:0x0759  */
    /* JADX WARN: Removed duplicated region for block: B:410:0x07e4  */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean handleMessage(android.os.Message r41) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 2232
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlu.handleMessage(android.os.Message):boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzcc
    public final void zza(float f3) {
        this.zzi.zzh(34);
    }

    @Override // com.google.android.gms.internal.ads.zzcc
    public final void zzb(int i3) {
        this.zzi.zze(33, i3, 0).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzjh
    public final void zzc(zzav zzavVar) {
        this.zzi.zzd(16, zzavVar).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzadr
    public final void zzcS(long j3, long j4, zzv zzvVar, MediaFormat mediaFormat) {
        if (this.zzE) {
            this.zzi.zzc(37).zza();
        }
    }

    public final void zzd() {
        this.zzi.zzc(29).zza();
    }

    public final void zze(boolean z2, int i3, int i4) {
        this.zzi.zze(1, z2 ? 1 : 0, (i4 << 4) | 1).zza();
    }

    public final void zzf(zzbf zzbfVar, int i3, long j3) {
        this.zzi.zzd(3, new zzlt(zzbfVar, i3, j3)).zza();
    }

    public final void zzg(zznh zznhVar) {
        this.zzi.zzd(38, zznhVar).zza();
    }

    public final void zzh() {
        this.zzi.zzc(6).zza();
    }

    public final void zzi(zzd zzdVar, boolean z2) {
        this.zzi.zzf(31, 0, 0, zzdVar).zza();
    }

    public final void zzj(float f3) {
        this.zzi.zzd(32, Float.valueOf(f3)).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzmu
    public final void zzk(zzmw zzmwVar) {
        if (!this.zzJ && this.zzk.getThread().isAlive()) {
            this.zzi.zzd(14, zzmwVar).zza();
        } else {
            zzeg.zzc("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            zzmwVar.zzi(false);
        }
    }

    public final boolean zzl(Object obj, long j3) {
        if (this.zzJ || !this.zzk.getThread().isAlive()) {
            return true;
        }
        zzds zzdsVar = new zzds(this.zzq);
        this.zzi.zzd(30, new Pair(obj, zzdsVar)).zza();
        if (j3 != -9223372036854775807L) {
            return zzdsVar.zze(j3);
        }
        return true;
    }

    public final boolean zzm() {
        if (this.zzJ || !this.zzk.getThread().isAlive()) {
            return true;
        }
        this.zzJ = true;
        zzds zzdsVar = new zzds(this.zzq);
        this.zzi.zzd(7, zzdsVar).zza();
        return zzdsVar.zze(this.zzu);
    }

    public final Looper zzn() {
        return this.zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzmq
    public final void zzo() {
        zzdz zzdzVar = this.zzi;
        zzdzVar.zzk(2);
        zzdzVar.zzh(22);
    }

    @Override // com.google.android.gms.internal.ads.zzxh
    public final void zzp(zzxi zzxiVar) {
        this.zzi.zzd(8, zzxiVar).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzabg
    public final void zzq() {
        this.zzi.zzh(10);
    }

    @Override // com.google.android.gms.internal.ads.zzzd
    public final /* bridge */ /* synthetic */ void zzs(zzze zzzeVar) {
        this.zzi.zzd(9, (zzxi) zzzeVar).zza();
    }

    final /* synthetic */ zzmc zzt(zzmd zzmdVar, long j3) {
        zzabl zzablVarZze = this.zzg.zze(this.zzv);
        long j4 = this.zzaa.zzb;
        zzabi zzabiVar = this.zzf;
        zzmr zzmrVar = this.zzt;
        return new zzmc(this.zzc, j3, this.zze, zzablVarZze, zzmrVar, zzmdVar, zzabiVar, -9223372036854775807L);
    }

    final /* synthetic */ void zzu(int i3, boolean z2) {
        this.zzw.zzB(i3, this.zzb[i3].zze(), z2);
    }

    final /* synthetic */ void zzv(int i3) {
        this.zzw.zzW(i3);
    }

    final /* synthetic */ zzdz zzx() {
        return this.zzi;
    }

    public final void zzy(List list, int i3, long j3, zzzf zzzfVar) {
        this.zzi.zzd(17, new zzlo(list, zzzfVar, i3, j3, null)).zza();
    }
}
