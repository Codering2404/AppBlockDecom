package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzavv {
    public int zza;
    public zzavq zzb;
    public zzave zzc;
    public zzavh zzd;

    zzavv() {
        this(new zzavh(1));
    }

    private final long zzg() throws zzavu, zzavs {
        int i3 = ((((~1246322141) & 272302173) | 1841378864) + ((1246322141 & 825937997) | 658822930)) - (-1823634633);
        int i4 = 1600766768 % 649830540;
        int i5 = ((((~680326130) & 1378702392) | 3315809) + ((680326130 & 1913472410) | 739293607)) - 2048099035;
        int i6 = 1743768897 % 152059765;
        int i7 = ((((~973294814) & 1252035530) | 51191353) + ((973294814 & 1755616710) | 889459732)) - 1494176168;
        int i8 = 1861701682 % 1196748250;
        int i9 = ((((~29116548) & 174422021) | 84710160) + ((29116548 & (-1973327347)) | (-1266641286))) - (-1891729929);
        int i10 = 2091729405 % 1207774949;
        int i11 = ((((~80201211) & 1629524354) | 38778411) + ((80201211 & 1977746312) | 382371455)) - 1921480783;
        int i12 = 1050760512 % 184320788;
        int i13 = 0;
        long j3 = 0;
        while (i13 < (i3 ^ i4)) {
            try {
                zzave zzaveVar = this.zzc;
                zzavq zzavqVar = this.zzb;
                int i14 = i3;
                int i15 = this.zza;
                int i16 = i4;
                this.zza = i15 + 1;
                byte bZza = zzaveVar.zza(zzavqVar, i15);
                int i17 = i7 ^ i8;
                j3 |= ((long) ((i5 ^ i6) & bZza)) << i13;
                if (i13 == i17) {
                    if (bZza > 1) {
                        throw new zzavs();
                    }
                    i13 = i17;
                }
                if ((bZza & (i9 ^ i10)) == 0) {
                    return (j3 >>> 1) ^ (-(1 & j3));
                }
                i13 += i11 ^ i12;
                i3 = i14;
                i4 = i16;
            } catch (IndexOutOfBoundsException e3) {
                throw new zzavu(e3);
            }
        }
        throw new zzavs();
    }

    private static final void zzh(long j3) throws zzavt {
        long[] jArr = {141540322, 456640674, 1141397064, 993500330, 1614820873, 3337980909L, 410218731, 1716462158, 477127367};
        long j4 = jArr[0];
        long j5 = jArr[1];
        long j6 = jArr[2];
        long j7 = jArr[3];
        long j8 = jArr[4];
        long j9 = jArr[5];
        if (j3 % ((jArr[6] + (((((~j4) & j5) | j6) + ((j4 & j7) | j8)) - j9)) ^ (jArr[7] % 477127367)) != 0) {
            throw new zzavt();
        }
    }

    public final void zza(long j3) throws zzavu, zzavt {
        long[] jArr = {2139842053, 728564241, 750932242, 1403848321, 1892818418, 4558981222L, 1919655804, 1856374729, 899334107};
        long j4 = jArr[0];
        long j5 = jArr[1];
        long j6 = jArr[2];
        long j7 = jArr[3];
        long j8 = jArr[4];
        long j9 = jArr[5];
        long j10 = jArr[6];
        long j11 = jArr[7];
        zzh(j3);
        long j12 = j3 / ((j10 + (((((~j4) & j5) | j6) + ((j4 & j7) | j8)) - j9)) ^ (j11 % 899334107));
        if (j12 < 0 || j12 > this.zzb.zza.length) {
            throw new zzavu();
        }
        this.zza = (int) j12;
    }

    public final long zzb() {
        long[] jArr = {491705403, 818579170, 1201981453, 810223590, 1243973916, 3701563257L, 554701476, 1889947178, 1780695788};
        long j3 = jArr[0];
        long j4 = jArr[1];
        long j5 = jArr[2];
        long j6 = jArr[3];
        long j7 = jArr[4];
        long j8 = jArr[5];
        return ((long) this.zza) * ((jArr[6] + (((((~j3) & j4) | j5) + ((j3 & j6) | j7)) - j8)) ^ (jArr[7] % 1780695788));
    }

    public final long zzc() throws zzavu {
        try {
            zzave zzaveVar = this.zzc;
            zzavq zzavqVar = this.zzb;
            this.zza = this.zza + 1;
            return zzaveVar.zza(zzavqVar, r2);
        } catch (IndexOutOfBoundsException e3) {
            throw new zzavu(e3);
        }
    }

    public final int zzd() throws zzavu {
        int i3 = ((((~413360099) & 1621678468) | 84323740) + ((413360099 & 1621644360) | 385888249)) - 1513564466;
        int i4 = 1609416931 % 1031126087;
        int i5 = ((((~978587665) & 1228171537) | 1025392332) + ((978587665 & 1075859857) | 983056096)) - (-1589113644);
        int i6 = 1723578341 % 672563970;
        int i7 = ((((~1163384280) & 546336857) | 505597090) + ((1163384280 & 546323033) | 358992768)) - 1346988633;
        int i8 = 1124734562 % 530406424;
        int i9 = ((((~217161528) & 116398273) | 202500381) + ((217161528 & 316821712) | 269928733)) - 410012058;
        int i10 = 529302443 % 418646579;
        try {
            zzave zzaveVar = this.zzc;
            zzavq zzavqVar = this.zzb;
            int i11 = this.zza;
            this.zza = i11 + 1;
            int i12 = i3 ^ i4;
            int iZza = zzaveVar.zza(zzavqVar, i11) & i12;
            zzave zzaveVar2 = this.zzc;
            zzavq zzavqVar2 = this.zzb;
            int i13 = this.zza;
            this.zza = i13 + 1;
            int iZza2 = iZza | ((zzaveVar2.zza(zzavqVar2, i13) & i12) << (i5 ^ i6));
            zzave zzaveVar3 = this.zzc;
            zzavq zzavqVar3 = this.zzb;
            int i14 = this.zza;
            this.zza = i14 + 1;
            int iZza3 = iZza2 | ((i12 & zzaveVar3.zza(zzavqVar3, i14)) << (i7 ^ i8));
            zzave zzaveVar4 = this.zzc;
            zzavq zzavqVar4 = this.zzb;
            int i15 = this.zza;
            this.zza = i15 + 1;
            return iZza3 | (zzaveVar4.zza(zzavqVar4, i15) << (i9 ^ i10));
        } catch (IndexOutOfBoundsException e3) {
            throw new zzavu(e3);
        }
    }

    public final long zze() throws zzavu, zzavs {
        return zzg();
    }

    public final zzavq zzf(long j3) throws zzavu, zzavt {
        int[] iArr = {1667674495, 1502201381, 1197125461, 478240810, 622476187, -1652496091, 840440151, 1203013321, 774318984};
        int i3 = iArr[0];
        int i4 = iArr[1];
        int i5 = iArr[2];
        int i6 = iArr[3];
        int i7 = iArr[4];
        int i8 = iArr[5];
        int i9 = iArr[6];
        int i10 = iArr[7];
        int i11 = i9 + ((((i4 & (~i3)) | i5) + ((i3 & i6) | i7)) - i8);
        zzh(zzb() + j3);
        int i12 = this.zza;
        long j4 = i12;
        zzavq zzavqVar = this.zzb;
        long j5 = (j3 >> ((i10 % 774318984) ^ i11)) + j4;
        if (j5 > zzavqVar.zza.length || j5 < j4) {
            throw new zzavu();
        }
        try {
            int i13 = (int) j5;
            zzavq zzavqVarZzb = this.zzc.zzb(zzavqVar, i12, i13);
            this.zza = i13;
            return zzavqVarZzb;
        } catch (IndexOutOfBoundsException e3) {
            throw new AssertionError(zzavo.zza("CEiv6BFfPnitUE+D"), e3);
        }
    }

    public zzavv(zzavh zzavhVar) {
        this(zzavq.zzb, 0, new zzavf());
        this.zzd = zzavhVar;
    }

    private zzavv(zzavq zzavqVar, int i3, zzave zzaveVar) {
        this.zzb = zzavqVar;
        this.zza = i3;
        this.zzc = zzaveVar;
    }

    public zzavv(zzavq zzavqVar, int i3, zzave zzaveVar, zzavh zzavhVar) {
        this(zzavqVar, i3, zzaveVar);
        this.zzd = zzavhVar;
    }
}
