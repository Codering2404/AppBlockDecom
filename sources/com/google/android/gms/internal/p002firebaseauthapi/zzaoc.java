package com.google.android.gms.internal.p002firebaseauthapi;

import com.applovin.exoplayer2.common.base.Ascii;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzaoc {
    private static boolean zza(byte b3) {
        return b3 > -65;
    }

    static /* synthetic */ void zza(byte b3, byte b4, byte b5, byte b6, char[] cArr, int i3) throws zzall {
        if (zza(b4) || (((b3 << Ascii.FS) + (b4 + 112)) >> 30) != 0 || zza(b5) || zza(b6)) {
            throw zzall.zzd();
        }
        int i4 = ((b3 & 7) << 18) | ((b4 & 63) << 12) | ((b5 & 63) << 6) | (b6 & 63);
        cArr[i3] = (char) ((i4 >>> 10) + 55232);
        cArr[i3 + 1] = (char) ((i4 & 1023) + 56320);
    }

    static /* synthetic */ void zza(byte b3, char[] cArr, int i3) {
        cArr[i3] = (char) b3;
    }

    static /* synthetic */ void zza(byte b3, byte b4, byte b5, char[] cArr, int i3) throws zzall {
        if (!zza(b4) && ((b3 != -32 || b4 >= -96) && ((b3 != -19 || b4 < -96) && !zza(b5)))) {
            cArr[i3] = (char) (((b3 & Ascii.SI) << 12) | ((b4 & 63) << 6) | (b5 & 63));
            return;
        }
        throw zzall.zzd();
    }

    static /* synthetic */ void zza(byte b3, byte b4, char[] cArr, int i3) throws zzall {
        if (b3 >= -62 && !zza(b4)) {
            cArr[i3] = (char) (((b3 & Ascii.US) << 6) | (b4 & 63));
            return;
        }
        throw zzall.zzd();
    }
}
