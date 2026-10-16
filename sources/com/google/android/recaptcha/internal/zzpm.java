package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzpm {
    private static final zzpm zza = new zzpm(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzpm(int i3, int[] iArr, Object[] objArr, boolean z2) {
        this.zze = -1;
        this.zzb = i3;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z2;
    }

    public static zzpm zzc() {
        return zza;
    }

    static zzpm zze(zzpm zzpmVar, zzpm zzpmVar2) {
        int i3 = zzpmVar.zzb + zzpmVar2.zzb;
        int[] iArrCopyOf = Arrays.copyOf(zzpmVar.zzc, i3);
        System.arraycopy(zzpmVar2.zzc, 0, iArrCopyOf, zzpmVar.zzb, zzpmVar2.zzb);
        Object[] objArrCopyOf = Arrays.copyOf(zzpmVar.zzd, i3);
        System.arraycopy(zzpmVar2.zzd, 0, objArrCopyOf, zzpmVar.zzb, zzpmVar2.zzb);
        return new zzpm(i3, iArrCopyOf, objArrCopyOf, true);
    }

    static zzpm zzf() {
        return new zzpm(0, new int[8], new Object[8], true);
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
        if (obj == null || !(obj instanceof zzpm)) {
            return false;
        }
        zzpm zzpmVar = (zzpm) obj;
        int i3 = this.zzb;
        if (i3 == zzpmVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzpmVar.zzc;
            int i4 = 0;
            while (true) {
                if (i4 >= i3) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzpmVar.zzd;
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
        int iZzA;
        int iZzB;
        int iZzA2;
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
                    iZzA2 = zzln.zzA(i7 << 3) + 8;
                } else if (i8 == 2) {
                    int i9 = i7 << 3;
                    zzle zzleVar = (zzle) this.zzd[i5];
                    int iZzA3 = zzln.zzA(i9);
                    int iZzd = zzleVar.zzd();
                    iZzA2 = iZzA3 + zzln.zzA(iZzd) + iZzd;
                } else if (i8 == 3) {
                    int iZzA4 = zzln.zzA(i7 << 3);
                    iZzA = iZzA4 + iZzA4;
                    iZzB = ((zzpm) this.zzd[i5]).zza();
                } else {
                    if (i8 != 5) {
                        throw new IllegalStateException(new zznm("Protocol message tag had invalid wire type."));
                    }
                    ((Integer) this.zzd[i5]).getClass();
                    iZzA2 = zzln.zzA(i7 << 3) + 4;
                }
                i4 += iZzA2;
            } else {
                int i10 = i7 << 3;
                long jLongValue = ((Long) this.zzd[i5]).longValue();
                iZzA = zzln.zzA(i10);
                iZzB = zzln.zzB(jLongValue);
            }
            iZzA2 = iZzA + iZzB;
            i4 += iZzA2;
        }
        this.zze = i4;
        return i4;
    }

    public final int zzb() {
        int i3 = this.zze;
        if (i3 != -1) {
            return i3;
        }
        int iZzA = 0;
        for (int i4 = 0; i4 < this.zzb; i4++) {
            int i5 = this.zzc[i4] >>> 3;
            zzle zzleVar = (zzle) this.zzd[i4];
            int iZzA2 = zzln.zzA(8);
            int iZzA3 = zzln.zzA(16) + zzln.zzA(i5);
            int iZzA4 = zzln.zzA(24);
            int iZzd = zzleVar.zzd();
            iZzA += iZzA2 + iZzA2 + iZzA3 + iZzA4 + zzln.zzA(iZzd) + iZzd;
        }
        this.zze = iZzA;
        return iZzA;
    }

    final zzpm zzd(zzpm zzpmVar) {
        if (zzpmVar.equals(zza)) {
            return this;
        }
        zzg();
        int i3 = this.zzb + zzpmVar.zzb;
        zzm(i3);
        System.arraycopy(zzpmVar.zzc, 0, this.zzc, this.zzb, zzpmVar.zzb);
        System.arraycopy(zzpmVar.zzd, 0, this.zzd, this.zzb, zzpmVar.zzb);
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
            zzok.zzb(sb, i3, String.valueOf(this.zzc[i4] >>> 3), this.zzd[i4]);
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

    final void zzk(zzpy zzpyVar) throws IOException {
        for (int i3 = 0; i3 < this.zzb; i3++) {
            zzpyVar.zzw(this.zzc[i3] >>> 3, this.zzd[i3]);
        }
    }

    public final void zzl(zzpy zzpyVar) throws IOException {
        if (this.zzb != 0) {
            for (int i3 = 0; i3 < this.zzb; i3++) {
                int i4 = this.zzc[i3];
                Object obj = this.zzd[i3];
                int i5 = i4 & 7;
                int i6 = i4 >>> 3;
                if (i5 == 0) {
                    zzpyVar.zzt(i6, ((Long) obj).longValue());
                } else if (i5 == 1) {
                    zzpyVar.zzm(i6, ((Long) obj).longValue());
                } else if (i5 == 2) {
                    zzpyVar.zzd(i6, (zzle) obj);
                } else if (i5 == 3) {
                    zzpyVar.zzF(i6);
                    ((zzpm) obj).zzl(zzpyVar);
                    zzpyVar.zzh(i6);
                } else {
                    if (i5 != 5) {
                        throw new RuntimeException(new zznm("Protocol message tag had invalid wire type."));
                    }
                    zzpyVar.zzk(i6, ((Integer) obj).intValue());
                }
            }
        }
    }

    private zzpm() {
        this(0, new int[8], new Object[8], true);
    }
}
