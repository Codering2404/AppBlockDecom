package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzigu {
    private static final zzigu zza = new zzigu(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzigu(int i3, int[] iArr, Object[] objArr, boolean z2) {
        this.zze = -1;
        this.zzb = i3;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z2;
    }

    public static zzigu zza() {
        return zza;
    }

    static zzigu zzb() {
        return new zzigu();
    }

    static zzigu zzc(zzigu zziguVar, zzigu zziguVar2) {
        int i3 = zziguVar.zzb + zziguVar2.zzb;
        int[] iArrCopyOf = Arrays.copyOf(zziguVar.zzc, i3);
        System.arraycopy(zziguVar2.zzc, 0, iArrCopyOf, zziguVar.zzb, zziguVar2.zzb);
        Object[] objArrCopyOf = Arrays.copyOf(zziguVar.zzd, i3);
        System.arraycopy(zziguVar2.zzd, 0, objArrCopyOf, zziguVar.zzb, zziguVar2.zzb);
        return new zzigu(i3, iArrCopyOf, objArrCopyOf, true);
    }

    private final void zzn(int i3) {
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
        if (obj == null || !(obj instanceof zzigu)) {
            return false;
        }
        zzigu zziguVar = (zzigu) obj;
        int i3 = this.zzb;
        if (i3 == zziguVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zziguVar.zzc;
            int i4 = 0;
            while (true) {
                if (i4 >= i3) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zziguVar.zzd;
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

    final void zzf(zzihi zzihiVar) throws IOException {
        for (int i3 = 0; i3 < this.zzb; i3++) {
            zzihiVar.zzv(this.zzc[i3] >>> 3, this.zzd[i3]);
        }
    }

    public final void zzg(zzihi zzihiVar) throws IOException {
        if (this.zzb != 0) {
            for (int i3 = 0; i3 < this.zzb; i3++) {
                int i4 = this.zzc[i3];
                Object obj = this.zzd[i3];
                int i5 = i4 & 7;
                int i6 = i4 >>> 3;
                if (i5 == 0) {
                    zzihiVar.zzc(i6, ((Long) obj).longValue());
                } else if (i5 == 1) {
                    zzihiVar.zzj(i6, ((Long) obj).longValue());
                } else if (i5 == 2) {
                    zzihiVar.zzn(i6, (zzida) obj);
                } else if (i5 == 3) {
                    zzihiVar.zzt(i6);
                    ((zzigu) obj).zzg(zzihiVar);
                    zzihiVar.zzu(i6);
                } else {
                    if (i5 != 5) {
                        throw new RuntimeException(new zzies("Protocol message tag had invalid wire type."));
                    }
                    zzihiVar.zzk(i6, ((Integer) obj).intValue());
                }
            }
        }
    }

    public final int zzh() {
        int i3 = this.zze;
        if (i3 != -1) {
            return i3;
        }
        int iZzF = 0;
        for (int i4 = 0; i4 < this.zzb; i4++) {
            int i5 = this.zzc[i4] >>> 3;
            zzida zzidaVar = (zzida) this.zzd[i4];
            int iZzF2 = zzidj.zzF(8);
            int iZzF3 = zzidj.zzF(16) + zzidj.zzF(i5);
            int iZzF4 = zzidj.zzF(24);
            int iZzb = zzidaVar.zzb();
            iZzF += iZzF2 + iZzF2 + iZzF3 + iZzF4 + zzidj.zzF(iZzb) + iZzb;
        }
        this.zze = iZzF;
        return iZzF;
    }

    public final int zzi() {
        int iZzF;
        int iZzG;
        int iZzF2;
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
                    iZzF2 = zzidj.zzF(i7 << 3) + 8;
                } else if (i8 == 2) {
                    int i9 = i7 << 3;
                    zzida zzidaVar = (zzida) this.zzd[i5];
                    int iZzF3 = zzidj.zzF(i9);
                    int iZzb = zzidaVar.zzb();
                    iZzF2 = iZzF3 + zzidj.zzF(iZzb) + iZzb;
                } else if (i8 == 3) {
                    int iZzF4 = zzidj.zzF(i7 << 3);
                    iZzF = iZzF4 + iZzF4;
                    iZzG = ((zzigu) this.zzd[i5]).zzi();
                } else {
                    if (i8 != 5) {
                        throw new IllegalStateException(new zzies("Protocol message tag had invalid wire type."));
                    }
                    ((Integer) this.zzd[i5]).getClass();
                    iZzF2 = zzidj.zzF(i7 << 3) + 4;
                }
                i4 += iZzF2;
            } else {
                int i10 = i7 << 3;
                long jLongValue = ((Long) this.zzd[i5]).longValue();
                iZzF = zzidj.zzF(i10);
                iZzG = zzidj.zzG(jLongValue);
            }
            iZzF2 = iZzF + iZzG;
            i4 += iZzF2;
        }
        this.zze = i4;
        return i4;
    }

    final void zzj(StringBuilder sb, int i3) {
        for (int i4 = 0; i4 < this.zzb; i4++) {
            zzifr.zzb(sb, i3, String.valueOf(this.zzc[i4] >>> 3), this.zzd[i4]);
        }
    }

    final void zzk(int i3, Object obj) {
        zze();
        zzn(this.zzb + 1);
        int[] iArr = this.zzc;
        int i4 = this.zzb;
        iArr[i4] = i3;
        this.zzd[i4] = obj;
        this.zzb = i4 + 1;
    }

    final boolean zzl(int i3, zzide zzideVar) throws IOException {
        int iZza;
        zze();
        int i4 = i3 & 7;
        if (i4 == 0) {
            zzk(i3, Long.valueOf(zzideVar.zzg()));
            return true;
        }
        if (i4 == 1) {
            zzk(i3, Long.valueOf(zzideVar.zzi()));
            return true;
        }
        if (i4 == 2) {
            zzk(i3, zzideVar.zzn());
            return true;
        }
        if (i4 != 3) {
            if (i4 == 4) {
                zzideVar.zzK();
                return false;
            }
            if (i4 != 5) {
                throw new zzies("Protocol message tag had invalid wire type.");
            }
            zzk(i3, Integer.valueOf(zzideVar.zzj()));
            return true;
        }
        zzigu zziguVar = new zzigu();
        do {
            iZza = zzideVar.zza();
            if (iZza == 0) {
                break;
            }
        } while (zziguVar.zzl(iZza, zzideVar));
        zzideVar.zzb(4 | ((i3 >>> 3) << 3));
        zzk(i3, zziguVar);
        return true;
    }

    final zzigu zzm(zzigu zziguVar) {
        if (zziguVar.equals(zza)) {
            return this;
        }
        zze();
        int i3 = this.zzb + zziguVar.zzb;
        zzn(i3);
        System.arraycopy(zziguVar.zzc, 0, this.zzc, this.zzb, zziguVar.zzb);
        System.arraycopy(zziguVar.zzd, 0, this.zzd, this.zzb, zziguVar.zzb);
        this.zzb = i3;
        return this;
    }

    private zzigu() {
        this(0, new int[8], new Object[8], true);
    }
}
