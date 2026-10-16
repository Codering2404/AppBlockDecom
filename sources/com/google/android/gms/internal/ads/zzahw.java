package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzahw {
    private final zzahv zza;
    private final zzahk zzb;
    private final int zzc;
    private final int zzd;
    private final long zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private long zzl;
    private long[] zzm;
    private int[] zzn;

    public zzahw(int i3, zzahv zzahvVar, zzahk zzahkVar) {
        this.zza = zzahvVar;
        int iZzc = zzahvVar.zzc();
        boolean z2 = true;
        if (iZzc != 1) {
            if (iZzc == 2) {
                iZzc = 2;
            } else {
                z2 = false;
            }
        }
        zzgtj.zza(z2);
        this.zzc = zzj(i3, iZzc == 2 ? 1667497984 : 1651965952);
        this.zze = zzahvVar.zzd();
        this.zzb = zzahkVar;
        this.zzd = iZzc == 2 ? zzj(i3, 1650720768) : -1;
        this.zzl = -1L;
        this.zzm = new long[512];
        this.zzn = new int[512];
        this.zzf = zzahvVar.zzd;
    }

    private final long zzh(int i3) {
        return (this.zze * ((long) i3)) / ((long) this.zzf);
    }

    private final zzahc zzi(int i3) {
        return new zzahc(((long) this.zzn[i3]) * zzh(1), this.zzm[i3]);
    }

    private static int zzj(int i3, int i4) {
        return (((i3 % 10) + 48) << 8) | ((i3 / 10) + 48) | i4;
    }

    public final void zza(long j3, boolean z2) {
        if (this.zzl == -1) {
            this.zzl = j3;
        }
        if (z2) {
            if (this.zzk == this.zzn.length) {
                long[] jArr = this.zzm;
                this.zzm = Arrays.copyOf(jArr, (jArr.length * 3) / 2);
                int[] iArr = this.zzn;
                this.zzn = Arrays.copyOf(iArr, (iArr.length * 3) / 2);
            }
            long[] jArr2 = this.zzm;
            int i3 = this.zzk;
            jArr2[i3] = j3;
            this.zzn[i3] = this.zzj;
            this.zzk = i3 + 1;
        }
        this.zzj++;
    }

    public final void zzb() {
        int i3;
        this.zzm = Arrays.copyOf(this.zzm, this.zzk);
        this.zzn = Arrays.copyOf(this.zzn, this.zzk);
        if ((this.zzc & 1651965952) != 1651965952 || this.zza.zzf == 0 || (i3 = this.zzk) <= 0) {
            return;
        }
        this.zzf = i3;
    }

    public final boolean zzc(int i3) {
        return this.zzc == i3 || this.zzd == i3;
    }

    public final void zzd(int i3) {
        this.zzg = i3;
        this.zzh = i3;
    }

    public final boolean zze(zzafz zzafzVar) throws IOException {
        int i3 = this.zzh;
        zzahk zzahkVar = this.zzb;
        int iZza = i3 - zzahkVar.zza(zzafzVar, i3, false);
        this.zzh = iZza;
        boolean z2 = iZza == 0;
        if (z2) {
            if (this.zzg > 0) {
                zzahkVar.zze(zzh(this.zzi), Arrays.binarySearch(this.zzn, this.zzi) >= 0 ? 1 : 0, this.zzg, 0, null);
            }
            this.zzi++;
        }
        return z2;
    }

    public final void zzf(long j3) {
        if (this.zzk == 0) {
            this.zzi = 0;
        } else {
            this.zzi = this.zzn[zzfl.zzo(this.zzm, j3, true, true)];
        }
    }

    public final zzagz zzg(long j3) {
        if (this.zzk == 0) {
            zzahc zzahcVar = new zzahc(0L, this.zzl);
            return new zzagz(zzahcVar, zzahcVar);
        }
        int iZzh = (int) (j3 / zzh(1));
        int iZzn = zzfl.zzn(this.zzn, iZzh, true, true);
        if (this.zzn[iZzn] == iZzh) {
            zzahc zzahcVarZzi = zzi(iZzn);
            return new zzagz(zzahcVarZzi, zzahcVarZzi);
        }
        zzahc zzahcVarZzi2 = zzi(iZzn);
        int i3 = iZzn + 1;
        return i3 < this.zzm.length ? new zzagz(zzahcVarZzi2, zzi(i3)) : new zzagz(zzahcVarZzi2, zzahcVarZzi2);
    }
}
