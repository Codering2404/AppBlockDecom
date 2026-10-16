package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzzb implements zzahk {
    private zzv zzA;
    private boolean zzC;
    private final zzyw zza;
    private final zzun zzd;
    private final zzui zze;
    private zzza zzf;
    private zzv zzg;
    private zzug zzh;
    private int zzp;
    private int zzq;
    private int zzr;
    private int zzs;
    private boolean zzx;
    private final zzyx zzb = new zzyx();
    private int zzi = 1000;
    private long[] zzj = new long[1000];
    private long[] zzk = new long[1000];
    private long[] zzn = new long[1000];
    private int[] zzm = new int[1000];
    private int[] zzl = new int[1000];
    private zzahj[] zzo = new zzahj[1000];
    private final zzzi zzc = new zzzi(zzyy.zza);
    private long zzt = Long.MIN_VALUE;
    private long zzu = Long.MIN_VALUE;
    private long zzv = Long.MIN_VALUE;
    private boolean zzz = true;
    private boolean zzy = true;
    private boolean zzB = true;
    private int zzw = -1;

    protected zzzb(zzabl zzablVar, zzun zzunVar, zzui zzuiVar) {
        this.zzd = zzunVar;
        this.zze = zzuiVar;
        this.zza = new zzyw(zzablVar);
    }

    private final synchronized void zzB() {
        this.zzs = 0;
        this.zza.zzb();
    }

    private final synchronized int zzC(zzlw zzlwVar, zziv zzivVar, boolean z2, boolean z3, zzyx zzyxVar) {
        boolean z4 = false;
        zzivVar.zzd = false;
        int i3 = this.zzq + this.zzs;
        if (this.zzw != -1 && i3 >= 0) {
            z4 = true;
        }
        if (zzI() && !z4) {
            zzv zzvVar = ((zzyz) this.zzc.zza(i3)).zza;
            if (!z2 && zzvVar == this.zzg) {
                int iZzN = zzN(this.zzs);
                if (!zzK(iZzN)) {
                    zzivVar.zzd = true;
                    return -3;
                }
                zzivVar.zzg(this.zzm[iZzN]);
                if (this.zzs == this.zzp - 1 && (z3 || this.zzx)) {
                    zzivVar.zzh(536870912);
                }
                zzivVar.zze = this.zzn[iZzN];
                zzyxVar.zza = this.zzl[iZzN];
                zzyxVar.zzb = this.zzk[iZzN];
                zzyxVar.zzc = this.zzo[iZzN];
                return -4;
            }
            zzJ(zzvVar, zzlwVar);
            return -5;
        }
        if (!z3 && !this.zzx && !z4) {
            zzv zzvVar2 = this.zzA;
            if (zzvVar2 == null || (!z2 && zzvVar2 == this.zzg)) {
                return -3;
            }
            zzJ(zzvVar2, zzlwVar);
            return -5;
        }
        zzivVar.zzg(4);
        zzivVar.zze = Long.MIN_VALUE;
        return -4;
    }

    private final synchronized boolean zzD(zzv zzvVar) {
        try {
            this.zzz = false;
            if (Objects.equals(zzvVar, this.zzA)) {
                return false;
            }
            zzzi zzziVar = this.zzc;
            if (zzziVar.zzf() || !((zzyz) zzziVar.zzc()).zza.equals(zzvVar)) {
                this.zzA = zzvVar;
            } else {
                this.zzA = ((zzyz) zzziVar.zzc()).zza;
            }
            boolean z2 = this.zzB;
            zzv zzvVar2 = this.zzA;
            String str = zzvVar2.zzp;
            this.zzB = z2 & (zzas.zzf(str) == 1 && zzas.zzd(str, zzvVar2.zzk));
            this.zzC = false;
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x000f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final synchronized long zzE(long r8, boolean r10, boolean r11) throws java.lang.Throwable {
        /*
            r7 = this;
            monitor-enter(r7)
            int r10 = r7.zzp     // Catch: java.lang.Throwable -> L32
            if (r10 == 0) goto Lf
            long[] r0 = r7.zzn     // Catch: java.lang.Throwable -> L32
            int r2 = r7.zzr     // Catch: java.lang.Throwable -> L32
            r0 = r0[r2]     // Catch: java.lang.Throwable -> L32
            int r0 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r0 >= 0) goto L11
        Lf:
            r1 = r7
            goto L35
        L11:
            if (r11 == 0) goto L19
            int r11 = r7.zzs     // Catch: java.lang.Throwable -> L1b
            if (r11 == r10) goto L19
            int r10 = r11 + 1
        L19:
            r3 = r10
            goto L1f
        L1b:
            r0 = move-exception
            r8 = r0
            r1 = r7
            goto L39
        L1f:
            r6 = 0
            r1 = r7
            r4 = r8
            int r8 = r1.zzL(r2, r3, r4, r6)     // Catch: java.lang.Throwable -> L2f
            r9 = -1
            if (r8 == r9) goto L35
            long r8 = r7.zzM(r8)     // Catch: java.lang.Throwable -> L2f
            monitor-exit(r7)
            return r8
        L2f:
            r0 = move-exception
        L30:
            r8 = r0
            goto L39
        L32:
            r0 = move-exception
            r1 = r7
            goto L30
        L35:
            monitor-exit(r7)
            r8 = -1
            return r8
        L39:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L2f
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzzb.zzE(long, boolean, boolean):long");
    }

    private final synchronized long zzF() {
        int i3 = this.zzp;
        if (i3 == 0) {
            return -1L;
        }
        return zzM(i3);
    }

    private final void zzG() {
        if (this.zzh != null) {
            this.zzh = null;
            this.zzg = null;
        }
    }

    private final synchronized void zzH(long j3, int i3, long j4, int i4, zzahj zzahjVar) {
        try {
            int i5 = this.zzp;
            if (i5 > 0) {
                int iZzN = zzN(i5 - 1);
                zzgtj.zza(this.zzk[iZzN] + ((long) this.zzl[iZzN]) <= j4);
            }
            this.zzx = (536870912 & i3) != 0;
            this.zzv = Math.max(this.zzv, j3);
            int iZzN2 = zzN(this.zzp);
            this.zzn[iZzN2] = j3;
            this.zzk[iZzN2] = j4;
            this.zzl[iZzN2] = i4;
            this.zzm[iZzN2] = i3;
            this.zzo[iZzN2] = zzahjVar;
            this.zzj[iZzN2] = 0;
            zzzi zzziVar = this.zzc;
            if (zzziVar.zzf() || !((zzyz) zzziVar.zzc()).zza.equals(this.zzA)) {
                zzv zzvVar = this.zzA;
                if (zzvVar == null) {
                    throw null;
                }
                zzziVar.zzb(this.zzq + this.zzp, new zzyz(zzvVar, zzum.zzb, null));
            }
            int i6 = this.zzp + 1;
            this.zzp = i6;
            int i7 = this.zzi;
            if (i6 == i7) {
                int i8 = i7 + 1000;
                long[] jArr = new long[i8];
                long[] jArr2 = new long[i8];
                long[] jArr3 = new long[i8];
                int[] iArr = new int[i8];
                int[] iArr2 = new int[i8];
                zzahj[] zzahjVarArr = new zzahj[i8];
                int i9 = this.zzr;
                int i10 = i7 - i9;
                System.arraycopy(this.zzk, i9, jArr2, 0, i10);
                System.arraycopy(this.zzn, this.zzr, jArr3, 0, i10);
                System.arraycopy(this.zzm, this.zzr, iArr, 0, i10);
                System.arraycopy(this.zzl, this.zzr, iArr2, 0, i10);
                System.arraycopy(this.zzo, this.zzr, zzahjVarArr, 0, i10);
                System.arraycopy(this.zzj, this.zzr, jArr, 0, i10);
                int i11 = this.zzr;
                System.arraycopy(this.zzk, 0, jArr2, i10, i11);
                System.arraycopy(this.zzn, 0, jArr3, i10, i11);
                System.arraycopy(this.zzm, 0, iArr, i10, i11);
                System.arraycopy(this.zzl, 0, iArr2, i10, i11);
                System.arraycopy(this.zzo, 0, zzahjVarArr, i10, i11);
                System.arraycopy(this.zzj, 0, jArr, i10, i11);
                this.zzk = jArr2;
                this.zzn = jArr3;
                this.zzm = iArr;
                this.zzl = iArr2;
                this.zzo = zzahjVarArr;
                this.zzj = jArr;
                this.zzr = 0;
                this.zzi = i8;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private final boolean zzI() {
        return this.zzs != this.zzp;
    }

    private final void zzJ(zzv zzvVar, zzlw zzlwVar) {
        zzv zzvVar2 = this.zzg;
        zzq zzqVar = zzvVar2 == null ? null : zzvVar2.zzt;
        this.zzg = zzvVar;
        zzq zzqVar2 = zzvVar.zzt;
        zzun zzunVar = this.zzd;
        zzlwVar.zzb = zzvVar.zzb(zzunVar.zzb(zzvVar));
        zzlwVar.zza = this.zzh;
        if (zzvVar2 == null || !Objects.equals(zzqVar, zzqVar2)) {
            zzug zzugVarZza = zzunVar.zza(this.zze, zzvVar);
            this.zzh = zzugVarZza;
            zzlwVar.zza = zzugVarZza;
        }
    }

    private final boolean zzK(int i3) {
        if (this.zzh == null) {
            return true;
        }
        int i4 = this.zzm[i3];
        return false;
    }

    private final int zzL(int i3, int i4, long j3, boolean z2) {
        int i5 = -1;
        for (int i6 = 0; i6 < i4; i6++) {
            long j4 = this.zzn[i3];
            if (j4 > j3) {
                break;
            }
            if (!z2 || (this.zzm[i3] & 1) != 0) {
                if (j4 == j3) {
                    return i6;
                }
                i5 = i6;
            }
            i3++;
            if (i3 == this.zzi) {
                i3 = 0;
            }
        }
        return i5;
    }

    private final long zzM(int i3) {
        long j3 = this.zzu;
        long jMax = Long.MIN_VALUE;
        if (i3 != 0) {
            int iZzN = zzN(i3 - 1);
            for (int i4 = 0; i4 < i3; i4++) {
                jMax = Math.max(jMax, this.zzn[iZzN]);
                if ((this.zzm[iZzN] & 1) != 0) {
                    break;
                }
                iZzN--;
                if (iZzN == -1) {
                    iZzN = this.zzi - 1;
                }
            }
        }
        this.zzu = Math.max(j3, jMax);
        this.zzp -= i3;
        int i5 = this.zzq + i3;
        this.zzq = i5;
        int i6 = this.zzr + i3;
        this.zzr = i6;
        int i7 = this.zzi;
        if (i6 >= i7) {
            this.zzr = i6 - i7;
        }
        int i8 = this.zzs - i3;
        this.zzs = i8;
        if (i8 < 0) {
            this.zzs = 0;
        }
        this.zzc.zzd(i5);
        if (this.zzp != 0) {
            return this.zzk[this.zzr];
        }
        int i9 = this.zzr;
        if (i9 == 0) {
            i9 = this.zzi;
        }
        int i10 = i9 - 1;
        return this.zzk[i10] + ((long) this.zzl[i10]);
    }

    private final int zzN(int i3) {
        int i4 = this.zzr + i3;
        int i5 = this.zzi;
        return i4 < i5 ? i4 : i4 - i5;
    }

    @Override // com.google.android.gms.internal.ads.zzahk
    public final void zzA(zzv zzvVar) {
        boolean zZzD = zzD(zzvVar);
        zzza zzzaVar = this.zzf;
        if (zzzaVar == null || !zZzD) {
            return;
        }
        zzzaVar.zzy(zzvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzahk
    public final int zzb(zzj zzjVar, int i3, boolean z2, int i4) throws IOException {
        return this.zza.zzg(zzjVar, i3, z2);
    }

    @Override // com.google.android.gms.internal.ads.zzahk
    public final void zzd(zzet zzetVar, int i3, int i4) {
        this.zza.zzh(zzetVar, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzahk
    public final void zze(long j3, int i3, int i4, int i5, zzahj zzahjVar) {
        if (this.zzy) {
            if ((i3 & 1) == 0) {
                return;
            } else {
                this.zzy = false;
            }
        }
        if (this.zzB) {
            if (j3 < this.zzt) {
                return;
            }
            if ((i3 & 1) == 0) {
                if (!this.zzC) {
                    zzeg.zzc("SampleQueue", "Overriding unexpected non-sync sample for format: ".concat(String.valueOf(this.zzA)));
                    this.zzC = true;
                }
                i3 |= 1;
            }
        }
        int i6 = i3;
        zzH(j3, i6, (this.zza.zzf() - ((long) i4)) - ((long) i5), i4, zzahjVar);
    }

    public final void zzf() {
        zzg(true);
        zzG();
    }

    public final void zzg(boolean z2) {
        this.zza.zza();
        this.zzp = 0;
        this.zzq = 0;
        this.zzr = 0;
        this.zzs = 0;
        this.zzw = -1;
        this.zzy = true;
        this.zzt = Long.MIN_VALUE;
        this.zzu = Long.MIN_VALUE;
        this.zzv = Long.MIN_VALUE;
        this.zzx = false;
        this.zzc.zze();
        if (z2) {
            this.zzA = null;
            this.zzz = true;
            this.zzB = true;
        }
    }

    public final void zzh(long j3) {
        this.zzt = j3;
    }

    public final synchronized void zzi(long j3) {
    }

    public final int zzj() {
        return this.zzq + this.zzp;
    }

    public final void zzk() {
        zzy();
        zzG();
    }

    public final void zzl() throws IOException {
        zzug zzugVar = this.zzh;
        if (zzugVar != null) {
            throw zzugVar.zza();
        }
    }

    public final int zzm() {
        return this.zzq;
    }

    public final int zzn() {
        return this.zzq + this.zzs;
    }

    public final synchronized zzv zzo() {
        if (this.zzz) {
            return null;
        }
        return this.zzA;
    }

    public final synchronized long zzp() {
        return this.zzv;
    }

    public final synchronized boolean zzq() {
        return this.zzx;
    }

    public final synchronized boolean zzr(boolean z2) {
        int i3 = this.zzq + this.zzs;
        boolean z3 = true;
        if (this.zzw != -1 && i3 >= 0) {
            return true;
        }
        if (zzI()) {
            if (((zzyz) this.zzc.zza(i3)).zza != this.zzg) {
                return true;
            }
            return zzK(zzN(this.zzs));
        }
        if (!z2 && !this.zzx) {
            zzv zzvVar = this.zzA;
            if (zzvVar == null) {
                z3 = false;
            } else if (zzvVar == this.zzg) {
                return false;
            }
        }
        return z3;
    }

    public final int zzs(zzlw zzlwVar, zziv zzivVar, int i3, boolean z2) {
        boolean z3 = (i3 & 2) != 0;
        zzyx zzyxVar = this.zzb;
        int iZzC = zzC(zzlwVar, zzivVar, z3, z2, zzyxVar);
        if (iZzC != -4) {
            return iZzC;
        }
        if (!zzivVar.zzb()) {
            int i4 = i3 & 1;
            if ((i3 & 4) == 0) {
                if (i4 != 0) {
                    this.zza.zzd(zzivVar, zzyxVar);
                    return -4;
                }
                this.zza.zzc(zzivVar, zzyxVar);
            } else if (i4 != 0) {
                return -4;
            }
            this.zzs++;
        }
        return -4;
    }

    public final synchronized boolean zzt(int i3) {
        zzB();
        int i4 = this.zzq;
        if (i3 >= i4 && i3 <= this.zzp + i4 && (this.zzw == -1 || i3 < 0)) {
            this.zzt = Long.MIN_VALUE;
            this.zzs = i3 - i4;
            return true;
        }
        return false;
    }

    public final synchronized boolean zzu(long j3, boolean z2) throws Throwable {
        Throwable th;
        zzzb zzzbVar;
        long j4;
        int iZzL;
        try {
            try {
                zzB();
                int i3 = this.zzs;
                int iZzN = zzN(i3);
                long j5 = this.zzv;
                if (zzI() && j3 >= this.zzn[iZzN]) {
                    if (j3 > j5) {
                        if (z2) {
                            z2 = true;
                        }
                    }
                    if (this.zzB) {
                        try {
                            int i4 = this.zzp - i3;
                            int i5 = 0;
                            while (true) {
                                if (i5 < i4) {
                                    if (this.zzn[iZzN] >= j3) {
                                        zzzbVar = this;
                                        j4 = j3;
                                        iZzL = i5;
                                        break;
                                    }
                                    iZzN++;
                                    if (iZzN == this.zzi) {
                                        iZzN = 0;
                                    }
                                    i5++;
                                } else if (z2) {
                                    j4 = j3;
                                    iZzL = i4;
                                    zzzbVar = this;
                                } else {
                                    zzzbVar = this;
                                    j4 = j3;
                                    iZzL = -1;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            throw th;
                        }
                    } else {
                        zzzbVar = this;
                        j4 = j3;
                        iZzL = zzzbVar.zzL(iZzN, this.zzp - i3, j4, true);
                    }
                    if (iZzL != -1) {
                        zzzbVar.zzt = j4;
                        zzzbVar.zzs += iZzL;
                        return true;
                    }
                }
                return false;
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public final synchronized int zzv(long j3, boolean z2) {
        Throwable th;
        try {
            try {
                int i3 = this.zzs;
                int iZzN = zzN(i3);
                if (!zzI() || j3 < this.zzn[iZzN]) {
                    return 0;
                }
                if (j3 <= this.zzv || !z2) {
                    int iZzL = zzL(iZzN, this.zzp - i3, j3, true);
                    if (iZzL == -1) {
                        return 0;
                    }
                    return iZzL;
                }
                try {
                    return this.zzp - i3;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
        }
        th = th;
        throw th;
    }

    public final synchronized void zzw(int i3) {
        boolean z2 = false;
        if (i3 >= 0) {
            try {
                if (this.zzs + i3 <= this.zzp) {
                    z2 = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        zzgtj.zza(z2);
        this.zzs += i3;
    }

    public final void zzx(long j3, boolean z2, boolean z3) {
        this.zza.zze(zzE(j3, false, z3));
    }

    public final void zzy() {
        this.zza.zze(zzF());
    }

    public final void zzz(zzza zzzaVar) {
        this.zzf = zzzaVar;
    }
}
