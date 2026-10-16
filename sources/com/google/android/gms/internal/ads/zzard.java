package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzard implements zzafy {
    private final int zza;
    private final List zzb;
    private final zzet zzc;
    private final SparseIntArray zzd;
    private final zzarg zze;
    private final zzanj zzf;
    private final SparseArray zzg;
    private final SparseBooleanArray zzh;
    private final SparseBooleanArray zzi;
    private final zzaqz zzj;
    private zzaqy zzk;
    private zzagb zzl;
    private int zzm;
    private boolean zzn;
    private boolean zzo;
    private boolean zzp;
    private int zzq;
    private int zzr;

    static {
        int i3 = zzarc.zza;
    }

    @Deprecated
    public zzard() {
        this(1, 1, zzanj.zza, new zzfi(0L), new zzapq(0), 112800);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0020, code lost:
    
        r1 = r1 + 1;
     */
    @Override // com.google.android.gms.internal.ads.zzafy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zza(com.google.android.gms.internal.ads.zzafz r7) throws java.io.IOException {
        /*
            r6 = this;
            com.google.android.gms.internal.ads.zzet r0 = r6.zzc
            byte[] r0 = r0.zzi()
            com.google.android.gms.internal.ads.zzafp r7 = (com.google.android.gms.internal.ads.zzafp) r7
            r1 = 940(0x3ac, float:1.317E-42)
            r2 = 0
            r7.zzh(r0, r2, r1, r2)
            r1 = r2
        Lf:
            r3 = 188(0xbc, float:2.63E-43)
            if (r1 >= r3) goto L2b
            r3 = r2
        L14:
            r4 = 5
            if (r3 >= r4) goto L26
            int r4 = r3 * 188
            int r4 = r4 + r1
            r4 = r0[r4]
            r5 = 71
            if (r4 == r5) goto L23
            int r1 = r1 + 1
            goto Lf
        L23:
            int r3 = r3 + 1
            goto L14
        L26:
            r7.zze(r1, r2)
            r7 = 1
            return r7
        L2b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzard.zza(com.google.android.gms.internal.ads.zzafz):boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzc(zzagb zzagbVar) {
        if (this.zza == 0) {
            zzagbVar = new zzanm(zzagbVar, this.zzf);
        }
        this.zzl = zzagbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final int zzd(zzafz zzafzVar, zzagy zzagyVar) throws IOException {
        long j3;
        long j4;
        long jZzo = zzafzVar.zzo();
        if (this.zzn) {
            if (jZzo != -1) {
                zzaqz zzaqzVar = this.zzj;
                if (!zzaqzVar.zza()) {
                    return zzaqzVar.zzb(zzafzVar, zzagyVar, this.zzr);
                }
            }
            if (this.zzo) {
                j3 = -1;
                j4 = 0;
            } else {
                this.zzo = true;
                zzaqz zzaqzVar2 = this.zzj;
                if (zzaqzVar2.zzc() != -9223372036854775807L) {
                    j3 = -1;
                    j4 = 0;
                    zzaqy zzaqyVar = new zzaqy(zzaqzVar2.zzd(), zzaqzVar2.zzc(), jZzo, this.zzr, 112800);
                    this.zzk = zzaqyVar;
                    this.zzl.zzw(zzaqyVar.zza());
                } else {
                    j3 = -1;
                    j4 = 0;
                    this.zzl.zzw(new zzaha(zzaqzVar2.zzc(), 0L));
                }
            }
            if (this.zzp) {
                this.zzp = false;
                zze(j4, j4);
                if (zzafzVar.zzn() != j4) {
                    zzagyVar.zza = j4;
                    return 1;
                }
            }
            zzaqy zzaqyVar2 = this.zzk;
            if (zzaqyVar2 != null && zzaqyVar2.zzc()) {
                return zzaqyVar2.zzd(zzafzVar, zzagyVar);
            }
        } else {
            j3 = -1;
        }
        zzet zzetVar = this.zzc;
        byte[] bArrZzi = zzetVar.zzi();
        if (9400 - zzetVar.zzg() < 188) {
            int iZzd = zzetVar.zzd();
            if (iZzd > 0) {
                System.arraycopy(bArrZzi, zzetVar.zzg(), bArrZzi, 0, iZzd);
            }
            zzetVar.zzb(bArrZzi, iZzd);
        }
        while (zzetVar.zzd() < 188) {
            int iZze = zzetVar.zze();
            int iZza = zzafzVar.zza(bArrZzi, iZze, 9400 - iZze);
            if (iZza == -1) {
                int i3 = 0;
                while (true) {
                    SparseArray sparseArray = this.zzg;
                    if (i3 >= sparseArray.size()) {
                        return -1;
                    }
                    zzari zzariVar = (zzari) sparseArray.valueAt(i3);
                    if (zzariVar instanceof zzaqm) {
                        zzaqm zzaqmVar = (zzaqm) zzariVar;
                        if (zzaqmVar.zzd(false)) {
                            zzaqmVar.zzc(new zzet(), 1);
                        }
                    }
                    i3++;
                }
            } else {
                zzetVar.zzf(iZze + iZza);
            }
        }
        int iZzg = zzetVar.zzg();
        int iZze2 = zzetVar.zze();
        int iZza2 = zzarj.zza(zzetVar.zzi(), iZzg, iZze2);
        zzetVar.zzh(iZza2);
        int i4 = iZza2 + 188;
        if (i4 > iZze2) {
            this.zzq += iZza2 - iZzg;
        } else {
            this.zzq = 0;
        }
        int iZze3 = zzetVar.zze();
        if (i4 > iZze3) {
            return 0;
        }
        int iZzB = zzetVar.zzB();
        if ((8388608 & iZzB) != 0) {
            zzetVar.zzh(i4);
            return 0;
        }
        int i5 = (4194304 & iZzB) != 0 ? 1 : 0;
        int i6 = iZzB & 32;
        int i7 = (iZzB >> 8) & 8191;
        zzari zzariVar2 = (iZzB & 16) != 0 ? (zzari) this.zzg.get(i7) : null;
        if (zzariVar2 == null) {
            zzetVar.zzh(i4);
            return 0;
        }
        int i8 = iZzB & 15;
        SparseIntArray sparseIntArray = this.zzd;
        int i9 = sparseIntArray.get(i7, i8 - 1);
        sparseIntArray.put(i7, i8);
        if (i9 == i8) {
            zzetVar.zzh(i4);
            return 0;
        }
        if (i8 != ((i9 + 1) & 15)) {
            zzariVar2.zzb();
        }
        if (i6 != 0) {
            int iZzs = zzetVar.zzs();
            i5 |= (zzetVar.zzs() & 64) != 0 ? 2 : 0;
            zzetVar.zzk(iZzs - 1);
        }
        boolean z2 = this.zzn;
        if (z2 || !this.zzi.get(i7, false)) {
            zzetVar.zzf(i4);
            zzariVar2.zzc(zzetVar, i5);
            zzetVar.zzf(iZze3);
        }
        if (!z2 && this.zzn && jZzo != j3) {
            this.zzp = true;
        }
        zzetVar.zzh(i4);
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002f  */
    @Override // com.google.android.gms.internal.ads.zzafy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zze(long r10, long r12) {
        /*
            r9 = this;
            java.util.List r10 = r9.zzb
            int r11 = r10.size()
            r0 = 0
            r1 = r0
        L8:
            r2 = 0
            if (r1 >= r11) goto L35
            java.lang.Object r4 = r10.get(r1)
            com.google.android.gms.internal.ads.zzfi r4 = (com.google.android.gms.internal.ads.zzfi) r4
            long r5 = r4.zzc()
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 == 0) goto L2f
            long r5 = r4.zza()
            int r7 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r7 == 0) goto L32
            int r2 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r2 == 0) goto L32
            int r2 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1))
            if (r2 == 0) goto L32
        L2f:
            r4.zzd(r12)
        L32:
            int r1 = r1 + 1
            goto L8
        L35:
            int r10 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r10 == 0) goto L40
            com.google.android.gms.internal.ads.zzaqy r10 = r9.zzk
            if (r10 == 0) goto L40
            r10.zzb(r12)
        L40:
            com.google.android.gms.internal.ads.zzet r10 = r9.zzc
            r10.zza(r0)
            android.util.SparseIntArray r10 = r9.zzd
            r10.clear()
            r10 = r0
        L4b:
            android.util.SparseArray r11 = r9.zzg
            int r12 = r11.size()
            if (r10 >= r12) goto L5f
            java.lang.Object r11 = r11.valueAt(r10)
            com.google.android.gms.internal.ads.zzari r11 = (com.google.android.gms.internal.ads.zzari) r11
            r11.zzb()
            int r10 = r10 + 1
            goto L4b
        L5f:
            r9.zzq = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzard.zze(long, long):void");
    }

    final /* synthetic */ List zzh() {
        return this.zzb;
    }

    final /* synthetic */ zzarg zzi() {
        return this.zze;
    }

    final /* synthetic */ SparseArray zzj() {
        return this.zzg;
    }

    final /* synthetic */ SparseBooleanArray zzk() {
        return this.zzh;
    }

    final /* synthetic */ SparseBooleanArray zzl() {
        return this.zzi;
    }

    final /* synthetic */ zzagb zzm() {
        return this.zzl;
    }

    final /* synthetic */ int zzn() {
        return this.zzm;
    }

    final /* synthetic */ void zzo(int i3) {
        this.zzm = i3;
    }

    final /* synthetic */ void zzp(boolean z2) {
        this.zzn = true;
    }

    final /* synthetic */ void zzq(int i3) {
        this.zzr = i3;
    }

    public zzard(int i3, int i4, zzanj zzanjVar, zzfi zzfiVar, zzarg zzargVar, int i5) {
        this.zze = zzargVar;
        this.zza = i4;
        this.zzf = zzanjVar;
        this.zzb = Collections.singletonList(zzfiVar);
        this.zzc = new zzet(new byte[9400], 0);
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        this.zzh = sparseBooleanArray;
        this.zzi = new SparseBooleanArray();
        SparseArray sparseArray = new SparseArray();
        this.zzg = sparseArray;
        this.zzd = new SparseIntArray();
        this.zzj = new zzaqz(112800);
        this.zzl = zzagb.zza;
        this.zzr = -1;
        sparseBooleanArray.clear();
        sparseArray.clear();
        SparseArray sparseArrayZza = zzargVar.zza();
        int size = sparseArrayZza.size();
        for (int i6 = 0; i6 < size; i6++) {
            this.zzg.put(sparseArrayZza.keyAt(i6), (zzari) sparseArrayZza.valueAt(i6));
        }
        this.zzg.put(0, new zzaqu(new zzara(this)));
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzf() {
    }
}
