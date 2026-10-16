package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzoj {
    private static final zzoj zza = new zzoj(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzoj(int i3, int[] iArr, Object[] objArr, boolean z2) {
        this.zze = -1;
        this.zzb = i3;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z2;
    }

    public static zzoj zza() {
        return zza;
    }

    static zzoj zzb() {
        return new zzoj(0, new int[8], new Object[8], true);
    }

    static zzoj zzc(zzoj zzojVar, zzoj zzojVar2) {
        int i3 = zzojVar.zzb + zzojVar2.zzb;
        int[] iArrCopyOf = Arrays.copyOf(zzojVar.zzc, i3);
        System.arraycopy(zzojVar2.zzc, 0, iArrCopyOf, zzojVar.zzb, zzojVar2.zzb);
        Object[] objArrCopyOf = Arrays.copyOf(zzojVar.zzd, i3);
        System.arraycopy(zzojVar2.zzd, 0, objArrCopyOf, zzojVar.zzb, zzojVar2.zzb);
        return new zzoj(i3, iArrCopyOf, objArrCopyOf, true);
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
        if (obj == null || !(obj instanceof zzoj)) {
            return false;
        }
        zzoj zzojVar = (zzoj) obj;
        int i3 = this.zzb;
        if (i3 == zzojVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzojVar.zzc;
            int i4 = 0;
            while (true) {
                if (i4 >= i3) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzojVar.zzd;
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

    public final void zzd() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    final void zze() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    final void zzf(zzov zzovVar) throws IOException {
        for (int i3 = 0; i3 < this.zzb; i3++) {
            zzovVar.zzv(this.zzc[i3] >>> 3, this.zzd[i3]);
        }
    }

    public final void zzg(zzov zzovVar) throws IOException {
        if (this.zzb != 0) {
            for (int i3 = 0; i3 < this.zzb; i3++) {
                int i4 = this.zzc[i3];
                Object obj = this.zzd[i3];
                int i5 = i4 & 7;
                int i6 = i4 >>> 3;
                if (i5 == 0) {
                    zzovVar.zzc(i6, ((Long) obj).longValue());
                } else if (i5 == 1) {
                    zzovVar.zzj(i6, ((Long) obj).longValue());
                } else if (i5 == 2) {
                    zzovVar.zzn(i6, (zzlh) obj);
                } else if (i5 == 3) {
                    zzovVar.zzt(i6);
                    ((zzoj) obj).zzg(zzovVar);
                    zzovVar.zzu(i6);
                } else {
                    if (i5 != 5) {
                        throw new RuntimeException(new zzmq("Protocol message tag had invalid wire type."));
                    }
                    zzovVar.zzk(i6, ((Integer) obj).intValue());
                }
            }
        }
    }

    public final int zzh() {
        int i3 = this.zze;
        if (i3 != -1) {
            return i3;
        }
        int iZzz = 0;
        for (int i4 = 0; i4 < this.zzb; i4++) {
            int i5 = this.zzc[i4] >>> 3;
            zzlh zzlhVar = (zzlh) this.zzd[i4];
            int iZzz2 = zzlm.zzz(8);
            int iZzz3 = zzlm.zzz(16) + zzlm.zzz(i5);
            int iZzz4 = zzlm.zzz(24);
            int iZzc = zzlhVar.zzc();
            iZzz += iZzz2 + iZzz2 + iZzz3 + iZzz4 + zzlm.zzz(iZzc) + iZzc;
        }
        this.zze = iZzz;
        return iZzz;
    }

    public final int zzi() {
        int iZzz;
        int iZzA;
        int iZzz2;
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
                    iZzz2 = zzlm.zzz(i7 << 3) + 8;
                } else if (i8 == 2) {
                    int i9 = i7 << 3;
                    zzlh zzlhVar = (zzlh) this.zzd[i5];
                    int iZzz3 = zzlm.zzz(i9);
                    int iZzc = zzlhVar.zzc();
                    iZzz2 = iZzz3 + zzlm.zzz(iZzc) + iZzc;
                } else if (i8 == 3) {
                    int iZzz4 = zzlm.zzz(i7 << 3);
                    iZzz = iZzz4 + iZzz4;
                    iZzA = ((zzoj) this.zzd[i5]).zzi();
                } else {
                    if (i8 != 5) {
                        throw new IllegalStateException(new zzmq("Protocol message tag had invalid wire type."));
                    }
                    ((Integer) this.zzd[i5]).getClass();
                    iZzz2 = zzlm.zzz(i7 << 3) + 4;
                }
                i4 += iZzz2;
            } else {
                int i10 = i7 << 3;
                long jLongValue = ((Long) this.zzd[i5]).longValue();
                iZzz = zzlm.zzz(i10);
                iZzA = zzlm.zzA(jLongValue);
            }
            iZzz2 = iZzz + iZzA;
            i4 += iZzz2;
        }
        this.zze = i4;
        return i4;
    }

    final void zzj(StringBuilder sb, int i3) {
        for (int i4 = 0; i4 < this.zzb; i4++) {
            zzno.zzb(sb, i3, String.valueOf(this.zzc[i4] >>> 3), this.zzd[i4]);
        }
    }

    final void zzk(int i3, Object obj) {
        zze();
        zzm(this.zzb + 1);
        int[] iArr = this.zzc;
        int i4 = this.zzb;
        iArr[i4] = i3;
        this.zzd[i4] = obj;
        this.zzb = i4 + 1;
    }

    final zzoj zzl(zzoj zzojVar) {
        if (zzojVar.equals(zza)) {
            return this;
        }
        zze();
        int i3 = this.zzb + zzojVar.zzb;
        zzm(i3);
        System.arraycopy(zzojVar.zzc, 0, this.zzc, this.zzb, zzojVar.zzb);
        System.arraycopy(zzojVar.zzd, 0, this.zzd, this.zzb, zzojVar.zzb);
        this.zzb = i3;
        return this;
    }

    private zzoj() {
        this(0, new int[8], new Object[8], true);
    }
}
