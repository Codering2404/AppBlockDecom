package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzanx {
    private static final zzanx zza = new zzanx(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzanx() {
        this(0, new int[8], new Object[8], true);
    }

    public static zzanx zzc() {
        return zza;
    }

    static zzanx zzd() {
        return new zzanx();
    }

    private final void zzf() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzanx)) {
            return false;
        }
        zzanx zzanxVar = (zzanx) obj;
        int i3 = this.zzb;
        if (i3 == zzanxVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzanxVar.zzc;
            int i4 = 0;
            while (true) {
                if (i4 >= i3) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzanxVar.zzd;
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
        int i4 = (i3 + 527) * 31;
        int[] iArr = this.zzc;
        int iHashCode = 17;
        int i5 = 17;
        for (int i6 = 0; i6 < i3; i6++) {
            i5 = (i5 * 31) + iArr[i6];
        }
        int i7 = (i4 + i5) * 31;
        Object[] objArr = this.zzd;
        int i8 = this.zzb;
        for (int i9 = 0; i9 < i8; i9++) {
            iHashCode = (iHashCode * 31) + objArr[i9].hashCode();
        }
        return i7 + iHashCode;
    }

    public final int zza() {
        int iZze;
        int i3 = this.zze;
        if (i3 != -1) {
            return i3;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < this.zzb; i5++) {
            int i6 = this.zzc[i5];
            int i7 = i6 >>> 3;
            int i8 = i6 & 7;
            if (i8 == 0) {
                iZze = zzakn.zze(i7, ((Long) this.zzd[i5]).longValue());
            } else if (i8 == 1) {
                iZze = zzakn.zza(i7, ((Long) this.zzd[i5]).longValue());
            } else if (i8 == 2) {
                iZze = zzakn.zza(i7, (zzajv) this.zzd[i5]);
            } else if (i8 == 3) {
                iZze = (zzakn.zzh(i7) << 1) + ((zzanx) this.zzd[i5]).zza();
            } else {
                if (i8 != 5) {
                    throw new IllegalStateException(zzall.zza());
                }
                iZze = zzakn.zzb(i7, ((Integer) this.zzd[i5]).intValue());
            }
            i4 += iZze;
        }
        this.zze = i4;
        return i4;
    }

    public final int zzb() {
        int i3 = this.zze;
        if (i3 != -1) {
            return i3;
        }
        int iZzb = 0;
        for (int i4 = 0; i4 < this.zzb; i4++) {
            iZzb += zzakn.zzb(this.zzc[i4] >>> 3, (zzajv) this.zzd[i4]);
        }
        this.zze = iZzb;
        return iZzb;
    }

    public final void zze() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    private zzanx(int i3, int[] iArr, Object[] objArr, boolean z2) {
        this.zze = -1;
        this.zzb = i3;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z2;
    }

    public final void zzb(zzaol zzaolVar) throws IOException {
        if (this.zzb == 0) {
            return;
        }
        if (zzaolVar.zza() == 1) {
            for (int i3 = 0; i3 < this.zzb; i3++) {
                zza(this.zzc[i3], this.zzd[i3], zzaolVar);
            }
            return;
        }
        for (int i4 = this.zzb - 1; i4 >= 0; i4--) {
            zza(this.zzc[i4], this.zzd[i4], zzaolVar);
        }
    }

    final zzanx zza(zzanx zzanxVar) {
        if (zzanxVar.equals(zza)) {
            return this;
        }
        zzf();
        int i3 = this.zzb + zzanxVar.zzb;
        zza(i3);
        System.arraycopy(zzanxVar.zzc, 0, this.zzc, this.zzb, zzanxVar.zzb);
        System.arraycopy(zzanxVar.zzd, 0, this.zzd, this.zzb, zzanxVar.zzb);
        this.zzb = i3;
        return this;
    }

    static zzanx zza(zzanx zzanxVar, zzanx zzanxVar2) {
        int i3 = zzanxVar.zzb + zzanxVar2.zzb;
        int[] iArrCopyOf = Arrays.copyOf(zzanxVar.zzc, i3);
        System.arraycopy(zzanxVar2.zzc, 0, iArrCopyOf, zzanxVar.zzb, zzanxVar2.zzb);
        Object[] objArrCopyOf = Arrays.copyOf(zzanxVar.zzd, i3);
        System.arraycopy(zzanxVar2.zzd, 0, objArrCopyOf, zzanxVar.zzb, zzanxVar2.zzb);
        return new zzanx(i3, iArrCopyOf, objArrCopyOf, true);
    }

    private final void zza(int i3) {
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

    final void zza(StringBuilder sb, int i3) {
        for (int i4 = 0; i4 < this.zzb; i4++) {
            zzamn.zza(sb, i3, String.valueOf(this.zzc[i4] >>> 3), this.zzd[i4]);
        }
    }

    final void zza(int i3, Object obj) {
        zzf();
        zza(this.zzb + 1);
        int[] iArr = this.zzc;
        int i4 = this.zzb;
        iArr[i4] = i3;
        this.zzd[i4] = obj;
        this.zzb = i4 + 1;
    }

    final void zza(zzaol zzaolVar) throws IOException {
        if (zzaolVar.zza() == 2) {
            for (int i3 = this.zzb - 1; i3 >= 0; i3--) {
                zzaolVar.zza(this.zzc[i3] >>> 3, this.zzd[i3]);
            }
            return;
        }
        for (int i4 = 0; i4 < this.zzb; i4++) {
            zzaolVar.zza(this.zzc[i4] >>> 3, this.zzd[i4]);
        }
    }

    private static void zza(int i3, Object obj, zzaol zzaolVar) throws IOException {
        int i4 = i3 >>> 3;
        int i5 = i3 & 7;
        if (i5 == 0) {
            zzaolVar.zzb(i4, ((Long) obj).longValue());
            return;
        }
        if (i5 == 1) {
            zzaolVar.zza(i4, ((Long) obj).longValue());
            return;
        }
        if (i5 == 2) {
            zzaolVar.zza(i4, (zzajv) obj);
            return;
        }
        if (i5 != 3) {
            if (i5 == 5) {
                zzaolVar.zzb(i4, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzall.zza());
        }
        if (zzaolVar.zza() == 1) {
            zzaolVar.zzb(i4);
            ((zzanx) obj).zzb(zzaolVar);
            zzaolVar.zza(i4);
        } else {
            zzaolVar.zza(i4);
            ((zzanx) obj).zzb(zzaolVar);
            zzaolVar.zzb(i4);
        }
    }
}
