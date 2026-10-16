package com.google.android.gms.internal.auth;

import com.applovin.exoplayer2.common.base.Ascii;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzhn {
    public static final /* synthetic */ int zza = 0;
    private static final zzhl zzb;

    static {
        if (zzhj.zzu() && zzhj.zzv()) {
            int i3 = zzds.zza;
        }
        zzb = new zzhm();
    }

    static /* bridge */ /* synthetic */ int zza(byte[] bArr, int i3, int i4) {
        int i5 = i4 - i3;
        byte b3 = bArr[i3 - 1];
        if (i5 == 0) {
            if (b3 > -12) {
                return -1;
            }
            return b3;
        }
        if (i5 == 1) {
            byte b4 = bArr[i3];
            if (b3 > -12 || b4 > -65) {
                return -1;
            }
            return (b4 << 8) ^ b3;
        }
        if (i5 != 2) {
            throw new AssertionError();
        }
        byte b5 = bArr[i3];
        byte b6 = bArr[i3 + 1];
        if (b3 > -12 || b5 > -65 || b6 > -65) {
            return -1;
        }
        return (b6 << Ascii.DLE) ^ ((b5 << 8) ^ b3);
    }

    static boolean zzb(byte[] bArr) {
        return zzb.zzb(bArr, 0, bArr.length);
    }

    static boolean zzc(byte[] bArr, int i3, int i4) {
        return zzb.zzb(bArr, i3, i4);
    }
}
