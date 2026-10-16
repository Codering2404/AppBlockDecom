package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzcs implements zzcr {
    final /* synthetic */ zzct zza;
    private final short[] zzb;
    private short[] zzc;
    private short[] zzd;
    private short[] zze;
    private int zzf;
    private int zzg;
    private int zzh;

    zzcs(zzct zzctVar) {
        Objects.requireNonNull(zzctVar);
        this.zza = zzctVar;
        this.zzb = new short[zzctVar.zzh()];
        this.zzc = new short[zzctVar.zzh() * zzctVar.zzg()];
        this.zzd = new short[zzctVar.zzh() * zzctVar.zzg()];
        this.zze = new short[zzctVar.zzh() * zzctVar.zzg()];
    }

    private final int zzs(short[] sArr, int i3, int i4, int i5) {
        int i6 = 1;
        int i7 = 255;
        int i8 = 0;
        int i9 = 0;
        while (i4 <= i5) {
            int iAbs = 0;
            for (int i10 = 0; i10 < i4; i10++) {
                int iZzg = this.zza.zzg() * i3;
                iAbs += Math.abs(sArr[iZzg + i10] - sArr[(iZzg + i4) + i10]);
            }
            int i11 = iAbs * i8;
            int i12 = i6 * i4;
            if (i11 < i12) {
                i6 = iAbs;
            }
            if (i11 < i12) {
                i8 = i4;
            }
            int i13 = iAbs * i7;
            int i14 = i9 * i4;
            if (i13 > i14) {
                i9 = iAbs;
            }
            if (i13 > i14) {
                i7 = i4;
            }
            i4++;
        }
        this.zzf = i6 / i8;
        this.zzg = i9 / i7;
        return i8;
    }

    private final short[] zzt(short[] sArr, int i3, int i4) {
        zzct zzctVar = this.zza;
        int length = sArr.length / zzctVar.zzg();
        return i3 + i4 <= length ? sArr : Arrays.copyOf(sArr, (((length * 3) / 2) + i4) * zzctVar.zzg());
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final int zza() {
        return 2;
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final void zzb(int i3, long j3, long j4) {
        int i4 = 0;
        while (true) {
            zzct zzctVar = this.zza;
            if (i4 >= zzctVar.zzg()) {
                return;
            }
            short[] sArr = this.zzd;
            int iZzg = zzctVar.zzg();
            int iZzj = zzctVar.zzj();
            short[] sArr2 = this.zze;
            int iZzg2 = (zzctVar.zzg() * i3) + i4;
            short s2 = sArr2[iZzg2];
            short s3 = sArr2[iZzg2 + zzctVar.zzg()];
            long jZzm = ((long) zzctVar.zzm()) * j3;
            long jZzl = ((long) zzctVar.zzl()) * j4;
            long jZzl2 = ((long) (zzctVar.zzl() + 1)) * j4;
            int i5 = i4;
            long j5 = jZzl2 - jZzl;
            long j6 = jZzl2 - jZzm;
            sArr[(iZzj * iZzg) + i5] = (short) (((j6 * ((long) s2)) + ((j5 - j6) * ((long) s3))) / j5);
            i4 = i5 + 1;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final boolean zzc() {
        int i3 = this.zzf;
        return i3 != 0 && this.zza.zzn() != 0 && this.zzg <= i3 * 3 && i3 + i3 > this.zzh * 3;
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final void zzd(int i3, int i4) {
        int iZzg;
        short[] sArr = this.zzc;
        int i5 = 0;
        while (true) {
            zzct zzctVar = this.zza;
            if (i5 >= zzctVar.zzh() / i4) {
                return;
            }
            int i6 = 0;
            int i7 = 0;
            while (true) {
                iZzg = zzctVar.zzg() * i4;
                if (i6 < iZzg) {
                    i7 += sArr[(zzctVar.zzg() * i3) + (iZzg * i5) + i6];
                    i6++;
                }
            }
            this.zzb[i5] = (short) (i7 / iZzg);
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final int zze(int i3, int i4, int i5) {
        return zzs(this.zzb, 0, i4, i5);
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final int zzf(int i3, int i4, int i5) {
        return zzs(this.zzc, i3, i4, i5);
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final void zzg() {
        this.zzh = 0;
        this.zzf = 0;
        this.zzg = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final void zzh(int i3, int i4, int i5, int i6, int i7) {
        short[] sArr = this.zzd;
        short[] sArr2 = this.zzc;
        for (int i8 = 0; i8 < i4; i8++) {
            int i9 = (i6 * i4) + i8;
            int i10 = (i7 * i4) + i8;
            int i11 = (i5 * i4) + i8;
            for (int i12 = 0; i12 < i3; i12++) {
                sArr[i11] = (short) (((sArr2[i9] * (i3 - i12)) + (sArr2[i10] * i12)) / i3);
                i11 += i4;
                i9 += i4;
                i10 += i4;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final void zzi() {
        this.zzh = this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final void zzj(int i3) {
        this.zzc = zzt(this.zzc, this.zza.zzi(), i3);
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final void zzk(int i3) {
        this.zzd = zzt(this.zzd, this.zza.zzj(), i3);
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final void zzl(int i3) {
        this.zze = zzt(this.zze, this.zza.zzk(), i3);
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final void zzm(int i3, int i4) {
        for (int i5 = 0; i5 < this.zza.zzg() * i4; i5++) {
            this.zzc[i3 + i5] = 0;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final void zzn(ByteBuffer byteBuffer, int i3) {
        zzct zzctVar = this.zza;
        byteBuffer.asShortBuffer().get(this.zzc, zzctVar.zzi() * zzctVar.zzg(), i3 / 2);
        byteBuffer.position(byteBuffer.position() + i3);
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final void zzo(ByteBuffer byteBuffer, int i3) {
        zzct zzctVar = this.zza;
        byteBuffer.asShortBuffer().put(this.zzd, 0, zzctVar.zzg() * i3);
        byteBuffer.position(byteBuffer.position() + ((i3 + i3) * zzctVar.zzg()));
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final /* synthetic */ Object zzp() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final /* synthetic */ Object zzq() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final /* synthetic */ Object zzr() {
        return this.zzc;
    }
}
