package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzhla {
    final long[] zza;
    final long[] zzb;
    final long[] zzc;

    zzhla(long[] jArr, long[] jArr2, long[] jArr3) {
        this.zza = jArr;
        this.zzb = jArr2;
        this.zzc = jArr3;
    }

    static zzhla zza(zzhla zzhlaVar, zzhkz zzhkzVar) {
        zzhla zzhlaVar2 = zzhkzVar.zza;
        long[] jArr = zzhlaVar.zza;
        long[] jArr2 = zzhlaVar2.zza;
        long[] jArr3 = zzhkzVar.zzb;
        zzhlj.zze(jArr, jArr2, jArr3);
        long[] jArr4 = zzhlaVar.zzb;
        long[] jArr5 = zzhlaVar2.zzb;
        long[] jArr6 = zzhlaVar2.zzc;
        zzhlj.zze(jArr4, jArr5, jArr6);
        zzhlj.zze(zzhlaVar.zzc, jArr6, jArr3);
        return zzhlaVar;
    }

    final byte[] zzb() {
        long[] jArr = new long[10];
        long[] jArr2 = new long[10];
        long[] jArr3 = new long[10];
        int i3 = zzhlj.zza;
        long[] jArr4 = new long[10];
        long[] jArr5 = new long[10];
        long[] jArr6 = new long[10];
        long[] jArr7 = new long[10];
        long[] jArr8 = new long[10];
        long[] jArr9 = new long[10];
        long[] jArr10 = new long[10];
        long[] jArr11 = new long[10];
        long[] jArr12 = new long[10];
        long[] jArr13 = new long[10];
        long[] jArr14 = this.zzc;
        zzhlj.zzf(jArr4, jArr14);
        zzhlj.zzf(jArr13, jArr4);
        zzhlj.zzf(jArr12, jArr13);
        zzhlj.zze(jArr5, jArr12, jArr14);
        zzhlj.zze(jArr6, jArr5, jArr4);
        zzhlj.zzf(jArr12, jArr6);
        zzhlj.zze(jArr7, jArr12, jArr5);
        zzhlj.zzf(jArr12, jArr7);
        zzhlj.zzf(jArr13, jArr12);
        zzhlj.zzf(jArr12, jArr13);
        zzhlj.zzf(jArr13, jArr12);
        zzhlj.zzf(jArr12, jArr13);
        zzhlj.zze(jArr8, jArr12, jArr7);
        zzhlj.zzf(jArr12, jArr8);
        zzhlj.zzf(jArr13, jArr12);
        for (int i4 = 2; i4 < 10; i4 += 2) {
            zzhlj.zzf(jArr12, jArr13);
            zzhlj.zzf(jArr13, jArr12);
        }
        zzhlj.zze(jArr9, jArr13, jArr8);
        zzhlj.zzf(jArr12, jArr9);
        zzhlj.zzf(jArr13, jArr12);
        for (int i5 = 2; i5 < 20; i5 += 2) {
            zzhlj.zzf(jArr12, jArr13);
            zzhlj.zzf(jArr13, jArr12);
        }
        zzhlj.zze(jArr12, jArr13, jArr9);
        zzhlj.zzf(jArr13, jArr12);
        zzhlj.zzf(jArr12, jArr13);
        for (int i6 = 2; i6 < 10; i6 += 2) {
            zzhlj.zzf(jArr13, jArr12);
            zzhlj.zzf(jArr12, jArr13);
        }
        zzhlj.zze(jArr10, jArr12, jArr8);
        zzhlj.zzf(jArr12, jArr10);
        zzhlj.zzf(jArr13, jArr12);
        for (int i7 = 2; i7 < 50; i7 += 2) {
            zzhlj.zzf(jArr12, jArr13);
            zzhlj.zzf(jArr13, jArr12);
        }
        zzhlj.zze(jArr11, jArr13, jArr10);
        zzhlj.zzf(jArr13, jArr11);
        zzhlj.zzf(jArr12, jArr13);
        for (int i8 = 2; i8 < 100; i8 += 2) {
            zzhlj.zzf(jArr13, jArr12);
            zzhlj.zzf(jArr12, jArr13);
        }
        zzhlj.zze(jArr13, jArr12, jArr11);
        zzhlj.zzf(jArr12, jArr13);
        zzhlj.zzf(jArr13, jArr12);
        for (int i9 = 2; i9 < 50; i9 += 2) {
            zzhlj.zzf(jArr12, jArr13);
            zzhlj.zzf(jArr13, jArr12);
        }
        zzhlj.zze(jArr12, jArr13, jArr10);
        zzhlj.zzf(jArr13, jArr12);
        zzhlj.zzf(jArr12, jArr13);
        zzhlj.zzf(jArr13, jArr12);
        zzhlj.zzf(jArr12, jArr13);
        zzhlj.zzf(jArr13, jArr12);
        zzhlj.zze(jArr, jArr13, jArr6);
        zzhlj.zze(jArr2, this.zza, jArr);
        zzhlj.zze(jArr3, this.zzb, jArr);
        byte[] bArrZzh = zzhlj.zzh(jArr3);
        bArrZzh[31] = (byte) ((zzhlc.zzf(jArr2) << 7) ^ bArrZzh[31]);
        return bArrZzh;
    }

    zzhla() {
        this(new long[10], new long[10], new long[10]);
    }

    zzhla(zzhkz zzhkzVar) {
        this();
        zza(this, zzhkzVar);
    }

    zzhla(zzhla zzhlaVar) {
        this.zza = Arrays.copyOf(zzhlaVar.zza, 10);
        this.zzb = Arrays.copyOf(zzhlaVar.zzb, 10);
        this.zzc = Arrays.copyOf(zzhlaVar.zzc, 10);
    }
}
