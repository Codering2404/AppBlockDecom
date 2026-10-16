package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaal {
    private static final zzaal zza = new zzaal(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzaal(int i3, int[] iArr, Object[] objArr, boolean z2) {
        this.zze = -1;
        this.zzb = i3;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z2;
    }

    public static zzaal zzc() {
        return zza;
    }

    static zzaal zze(zzaal zzaalVar, zzaal zzaalVar2) {
        int i3 = zzaalVar.zzb + zzaalVar2.zzb;
        int[] iArrCopyOf = Arrays.copyOf(zzaalVar.zzc, i3);
        System.arraycopy(zzaalVar2.zzc, 0, iArrCopyOf, zzaalVar.zzb, zzaalVar2.zzb);
        Object[] objArrCopyOf = Arrays.copyOf(zzaalVar.zzd, i3);
        System.arraycopy(zzaalVar2.zzd, 0, objArrCopyOf, zzaalVar.zzb, zzaalVar2.zzb);
        return new zzaal(i3, iArrCopyOf, objArrCopyOf, true);
    }

    static zzaal zzf() {
        return new zzaal(0, new int[8], new Object[8], true);
    }

    private final void zzm(int i3) {
        int[] iArr = this.zzc;
        if (i3 > iArr.length) {
            int i4 = this.zzb;
            int i5 = i4 + (i4 / 2);
            if (i5 >= i3) {
                i3 = i5;
            }
            if (i3 < 8) {
                i3 = 8;
            }
            this.zzc = Arrays.copyOf(iArr, i3);
            this.zzd = Arrays.copyOf(this.zzd, i3);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzaal)) {
            return false;
        }
        zzaal zzaalVar = (zzaal) obj;
        int i3 = this.zzb;
        if (i3 == zzaalVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzaalVar.zzc;
            int i4 = 0;
            while (true) {
                if (i4 >= i3) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzaalVar.zzd;
                    int i5 = this.zzb;
                    for (int i6 = 0; i6 < i5; i6++) {
                        if (objArr[i6].equals(objArr2[i6])) {
                        }
                    }
                    return true;
                }
                if (iArr[i4] != iArr2[i4]) {
                    break;
                }
                i4++;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i3 = this.zzb;
        int i4 = i3 + 527;
        int[] iArr = this.zzc;
        int iHashCode = 17;
        int i5 = 17;
        for (int i6 = 0; i6 < i3; i6++) {
            i5 = (i5 * 31) + iArr[i6];
        }
        int i7 = ((i4 * 31) + i5) * 31;
        Object[] objArr = this.zzd;
        int i8 = this.zzb;
        for (int i9 = 0; i9 < i8; i9++) {
            iHashCode = (iHashCode * 31) + objArr[i9].hashCode();
        }
        return i7 + iHashCode;
    }

    public final int zza() {
        int iZzE;
        int iZzD;
        int iZzD2;
        int i3 = this.zze;
        if (i3 != -1) {
            return i3;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < this.zzb; i5++) {
            int i6 = this.zzc[i5];
            int i7 = i6 >>> 3;
            int i8 = i6 & 7;
            if (i8 != 0) {
                if (i8 == 1) {
                    ((Long) this.zzd[i5]).getClass();
                    iZzD2 = zzuq.zzD(i7 << 3) + 8;
                } else if (i8 == 2) {
                    int i9 = i7 << 3;
                    zzud zzudVar = (zzud) this.zzd[i5];
                    int i10 = zzuq.zzf;
                    int iZzd = zzudVar.zzd();
                    iZzD2 = zzuq.zzD(i9) + zzuq.zzD(iZzd) + iZzd;
                } else if (i8 == 3) {
                    int i11 = i7 << 3;
                    int i12 = zzuq.zzf;
                    iZzE = ((zzaal) this.zzd[i5]).zza();
                    int iZzD3 = zzuq.zzD(i11);
                    iZzD = iZzD3 + iZzD3;
                } else {
                    if (i8 != 5) {
                        throw new IllegalStateException(zzyg.zza());
                    }
                    ((Integer) this.zzd[i5]).getClass();
                    iZzD2 = zzuq.zzD(i7 << 3) + 4;
                }
                i4 += iZzD2;
            } else {
                int i13 = i7 << 3;
                iZzE = zzuq.zzE(((Long) this.zzd[i5]).longValue());
                iZzD = zzuq.zzD(i13);
            }
            iZzD2 = iZzD + iZzE;
            i4 += iZzD2;
        }
        this.zze = i4;
        return i4;
    }

    public final int zzb() {
        int i3 = this.zze;
        if (i3 != -1) {
            return i3;
        }
        int iZzD = 0;
        for (int i4 = 0; i4 < this.zzb; i4++) {
            int i5 = this.zzc[i4] >>> 3;
            zzud zzudVar = (zzud) this.zzd[i4];
            int i6 = zzuq.zzf;
            int iZzd = zzudVar.zzd();
            int iZzD2 = zzuq.zzD(iZzd) + iZzd;
            int iZzD3 = zzuq.zzD(16);
            int iZzD4 = zzuq.zzD(i5);
            int iZzD5 = zzuq.zzD(8);
            iZzD += iZzD5 + iZzD5 + iZzD3 + iZzD4 + zzuq.zzD(24) + iZzD2;
        }
        this.zze = iZzD;
        return iZzD;
    }

    final zzaal zzd(zzaal zzaalVar) {
        if (zzaalVar.equals(zza)) {
            return this;
        }
        zzg();
        int i3 = this.zzb + zzaalVar.zzb;
        zzm(i3);
        System.arraycopy(zzaalVar.zzc, 0, this.zzc, this.zzb, zzaalVar.zzb);
        System.arraycopy(zzaalVar.zzd, 0, this.zzd, this.zzb, zzaalVar.zzb);
        this.zzb = i3;
        return this;
    }

    final void zzg() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    public final void zzh() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    final void zzi(StringBuilder sb, int i3) {
        for (int i4 = 0; i4 < this.zzb; i4++) {
            zzzi.zzb(sb, i3, String.valueOf(this.zzc[i4] >>> 3), this.zzd[i4]);
        }
    }

    final void zzj(int i3, Object obj) {
        zzg();
        zzm(this.zzb + 1);
        int[] iArr = this.zzc;
        int i4 = this.zzb;
        iArr[i4] = i3;
        this.zzd[i4] = obj;
        this.zzb = i4 + 1;
    }

    final void zzk(zzur zzurVar) throws IOException {
        for (int i3 = 0; i3 < this.zzb; i3++) {
            zzurVar.zzw(this.zzc[i3] >>> 3, this.zzd[i3]);
        }
    }

    public final void zzl(zzur zzurVar) throws IOException {
        if (this.zzb != 0) {
            for (int i3 = 0; i3 < this.zzb; i3++) {
                int i4 = this.zzc[i3];
                Object obj = this.zzd[i3];
                int i5 = i4 & 7;
                int i6 = i4 >>> 3;
                if (i5 == 0) {
                    zzurVar.zzt(i6, ((Long) obj).longValue());
                } else if (i5 == 1) {
                    zzurVar.zzm(i6, ((Long) obj).longValue());
                } else if (i5 == 2) {
                    zzurVar.zzd(i6, (zzud) obj);
                } else if (i5 == 3) {
                    zzurVar.zzF(i6);
                    ((zzaal) obj).zzl(zzurVar);
                    zzurVar.zzh(i6);
                } else {
                    if (i5 != 5) {
                        throw new RuntimeException(zzyg.zza());
                    }
                    zzurVar.zzk(i6, ((Integer) obj).intValue());
                }
            }
        }
    }

    private zzaal() {
        this(0, new int[8], new Object[8], true);
    }
}
