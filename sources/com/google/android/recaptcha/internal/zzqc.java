package com.google.android.recaptcha.internal;

import android.util.Base64;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzqc {
    protected static final Charset zza = StandardCharsets.UTF_16;
    protected int[] zzb;
    protected int[] zzc;
    private final int[] zzd = {511133343, 1277647508, 107287496, 338123662};
    private byte[] zze;
    private byte[] zzf;
    private int zzg;

    protected zzqc() {
    }

    protected static int zza(int i3, int i4) {
        if (i3 % 2 != 0) {
            return (i3 | i4) - (i3 & i4);
        }
        return ((~i3) & i4) | ((~i4) & i3);
    }

    public static String zze(String str, byte[] bArr, zzqd zzqdVar) {
        byte[] bArrDecode = Base64.decode(str, 0);
        byte[] bArr2 = new byte[12];
        int length = bArrDecode.length - 12;
        byte[] bArr3 = new byte[length];
        System.arraycopy(bArrDecode, 0, bArr2, 0, 12);
        System.arraycopy(bArrDecode, 12, bArr3, 0, length);
        return new String(new zzqc(bArr, bArr2).zzd(bArr3), zza);
    }

    public static String zzf(String str, byte[] bArr, zzqd zzqdVar) {
        byte[] bArr2 = new byte[12];
        new SecureRandom().nextBytes(bArr2);
        byte[] bArrZzd = new zzqc(bArr, bArr2).zzd(str.getBytes(zza));
        int length = bArrZzd.length;
        byte[] bArr3 = new byte[length + 12];
        System.arraycopy(bArr2, 0, bArr3, 0, 12);
        System.arraycopy(bArrZzd, 0, bArr3, 12, length);
        return Base64.encodeToString(bArr3, 2);
    }

    private static final int zzg(byte[] bArr, int i3) {
        int i4 = bArr[i3] & 255;
        int i5 = bArr[i3 + 1] & 255;
        int i6 = bArr[i3 + 2] & 255;
        return ((bArr[i3 + 3] & 255) << 24) | (i5 << 8) | i4 | (i6 << 16);
    }

    protected final void zzb(int i3, int i4, int i5, int i6) {
        zzc(i3, i4, i6, 16);
        zzc(i5, i6, i4, 12);
        zzc(i3, i4, i6, 8);
        zzc(i5, i6, i4, 7);
    }

    protected final void zzc(int i3, int i4, int i5, int i6) {
        int[] iArr = this.zzb;
        int i7 = iArr[i3] + iArr[i4];
        iArr[i3] = i7;
        int iZza = zza(iArr[i5], i7);
        iArr[i5] = iZza;
        iArr[i5] = (iZza << i6) | (iZza >>> (32 - i6));
    }

    protected final byte[] zzd(byte[] bArr) {
        if (this.zzg != 1) {
            throw new IllegalStateException();
        }
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        int i3 = 0;
        while (length > 0) {
            int[] iArr = this.zzc;
            int[] iArr2 = this.zzb;
            int length2 = iArr.length;
            System.arraycopy(iArr, 0, iArr2, 0, 16);
            this.zzb[12] = this.zzg;
            for (int i4 = 0; i4 < 10; i4++) {
                zzb(0, 4, 8, 12);
                zzb(1, 5, 9, 13);
                zzb(2, 6, 10, 14);
                zzb(3, 7, 11, 15);
                zzb(0, 5, 10, 15);
                zzb(1, 6, 11, 12);
                zzb(2, 7, 8, 13);
                zzb(3, 4, 9, 14);
            }
            byte[] bArr3 = new byte[64];
            for (int i5 = 0; i5 < 16; i5++) {
                int i6 = this.zzb[i5];
                int i7 = i5 * 4;
                bArr3[i7] = (byte) (i6 & 255);
                bArr3[i7 + 1] = (byte) ((i6 >> 8) & 255);
                bArr3[i7 + 2] = (byte) ((i6 >> 16) & 255);
                bArr3[i7 + 3] = (byte) ((i6 >> 24) & 255);
            }
            for (int i8 = 0; i8 < Math.min(64, length); i8++) {
                int i9 = i3 + i8;
                bArr2[i9] = (byte) zza(bArr3[i8], bArr[i9]);
            }
            this.zzg++;
            length -= 64;
            i3 += 64;
        }
        return bArr2;
    }

    protected zzqc(byte[] bArr, byte[] bArr2) {
        if (bArr.length != 32) {
            throw new IllegalArgumentException();
        }
        this.zze = bArr;
        this.zzg = 1;
        this.zzf = bArr2;
        this.zzb = new int[16];
        for (int i3 = 0; i3 < 4; i3++) {
            this.zzb[i3] = zza(this.zzd[i3], 2131181306);
        }
        for (int i4 = 4; i4 < 12; i4++) {
            this.zzb[i4] = zzg(this.zze, (i4 - 4) * 4);
        }
        this.zzb[12] = this.zzg;
        for (int i5 = 13; i5 < 16; i5++) {
            this.zzb[i5] = zzg(this.zzf, (i5 - 13) * 4);
        }
        int[] iArr = new int[16];
        this.zzc = iArr;
        int[] iArr2 = this.zzb;
        int length = iArr2.length;
        System.arraycopy(iArr2, 0, iArr, 0, 16);
    }
}
