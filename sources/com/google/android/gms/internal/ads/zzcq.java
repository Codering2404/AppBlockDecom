package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzcq implements zzcr {
    final /* synthetic */ zzct zza;
    private final float[] zzb;
    private float[] zzc;
    private float[] zzd;
    private float[] zze;
    private double zzf;
    private double zzg;
    private double zzh;

    zzcq(zzct zzctVar) {
        Objects.requireNonNull(zzctVar);
        this.zza = zzctVar;
        this.zzb = new float[zzctVar.zzh()];
        this.zzc = new float[zzctVar.zzh() * zzctVar.zzg()];
        this.zzd = new float[zzctVar.zzh() * zzctVar.zzg()];
        this.zze = new float[zzctVar.zzh() * zzctVar.zzg()];
    }

    private final int zzs(float[] fArr, int i3, int i4, int i5) {
        int i6 = 255;
        int i7 = 0;
        double d3 = 0.0d;
        double d4 = 1.0d;
        int i8 = i4;
        while (true) {
            double d5 = i6;
            double d6 = i7;
            if (i8 > i5) {
                this.zzf = d4 / d6;
                this.zzg = d3 / d5;
                return i7;
            }
            int i9 = 0;
            double dAbs = 0.0d;
            while (i9 < i8) {
                int iZzg = this.zza.zzg() * i3;
                dAbs += (double) Math.abs(fArr[iZzg + i9] - fArr[(iZzg + i8) + i9]);
                i9++;
                i6 = i6;
            }
            int i10 = i6;
            double d7 = d6 * dAbs;
            double d8 = i8;
            double d9 = d4 * d8;
            if (d7 < d9) {
                d4 = dAbs;
            }
            if (d7 < d9) {
                i7 = i8;
            }
            double d10 = d5 * dAbs;
            double d11 = d8 * d3;
            if (d10 > d11) {
                d3 = dAbs;
            }
            i6 = d10 > d11 ? i8 : i10;
            i8++;
        }
    }

    private final float[] zzt(float[] fArr, int i3, int i4) {
        zzct zzctVar = this.zza;
        int length = fArr.length / zzctVar.zzg();
        return i3 + i4 <= length ? fArr : Arrays.copyOf(fArr, (((length * 3) / 2) + i4) * zzctVar.zzg());
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final int zza() {
        return 4;
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final void zzb(int i3, long j3, long j4) {
        int i4 = 0;
        while (true) {
            zzct zzctVar = this.zza;
            if (i4 >= zzctVar.zzg()) {
                return;
            }
            float[] fArr = this.zzd;
            int iZzg = zzctVar.zzg();
            int iZzj = zzctVar.zzj();
            float[] fArr2 = this.zze;
            int iZzg2 = (zzctVar.zzg() * i3) + i4;
            float f3 = fArr2[iZzg2];
            float f4 = fArr2[iZzg2 + zzctVar.zzg()];
            long jZzm = ((long) zzctVar.zzm()) * j3;
            long jZzl = ((long) zzctVar.zzl()) * j4;
            long jZzl2 = ((long) (zzctVar.zzl() + 1)) * j4;
            long j5 = jZzl2 - jZzm;
            fArr[(iZzj * iZzg) + i4] = ((j5 * f3) + ((r12 - j5) * f4)) / (jZzl2 - jZzl);
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final boolean zzc() {
        double d3 = this.zzf;
        return d3 != 0.0d && this.zza.zzn() != 0 && this.zzg <= d3 * 3.0d && d3 + d3 > this.zzh * 3.0d;
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final void zzd(int i3, int i4) {
        int iZzg;
        int i5 = 0;
        while (true) {
            zzct zzctVar = this.zza;
            if (i5 >= zzctVar.zzh() / i4) {
                return;
            }
            double d3 = 0.0d;
            int i6 = 0;
            while (true) {
                iZzg = zzctVar.zzg() * i4;
                if (i6 < iZzg) {
                    d3 += (double) this.zzc[(zzctVar.zzg() * i3) + (iZzg * i5) + i6];
                    i6++;
                }
            }
            this.zzb[i5] = (float) (d3 / ((double) iZzg));
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
        this.zzh = 0.0d;
        this.zzf = 0.0d;
        this.zzg = 0.0d;
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final void zzh(int i3, int i4, int i5, int i6, int i7) {
        float[] fArr = this.zzd;
        float[] fArr2 = this.zzc;
        for (int i8 = 0; i8 < i4; i8++) {
            int i9 = (i6 * i4) + i8;
            int i10 = (i7 * i4) + i8;
            int i11 = (i5 * i4) + i8;
            for (int i12 = 0; i12 < i3; i12++) {
                fArr[i11] = ((fArr2[i9] * (i3 - i12)) + (fArr2[i10] * i12)) / i3;
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
            this.zzc[i3 + i5] = 0.0f;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final void zzn(ByteBuffer byteBuffer, int i3) {
        zzct zzctVar = this.zza;
        byteBuffer.asFloatBuffer().get(this.zzc, zzctVar.zzi() * zzctVar.zzg(), i3 / 4);
        byteBuffer.position(byteBuffer.position() + i3);
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final void zzo(ByteBuffer byteBuffer, int i3) {
        zzct zzctVar = this.zza;
        byteBuffer.asFloatBuffer().put(this.zzd, 0, zzctVar.zzg() * i3);
        byteBuffer.position(byteBuffer.position() + (i3 * 4 * zzctVar.zzg()));
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
