package com.google.android.gms.internal.p002firebaseauthapi;

import com.facebook.stetho.common.Utf8Charset;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzalh {
    static final Charset zza;
    public static final byte[] zzb;

    static {
        Charset.forName("US-ASCII");
        zza = Charset.forName(Utf8Charset.NAME);
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        zzb = bArr;
        ByteBuffer.wrap(bArr);
        zzakh.zza(bArr, 0, bArr.length, false);
    }

    public static int zza(long j3) {
        return (int) (j3 ^ (j3 >>> 32));
    }

    public static int zza(boolean z2) {
        return z2 ? 1231 : 1237;
    }

    static boolean zza(zzamm zzammVar) {
        return false;
    }

    public static int zza(byte[] bArr) {
        int length = bArr.length;
        int iZza = zza(length, bArr, 0, length);
        if (iZza == 0) {
            return 1;
        }
        return iZza;
    }

    static int zza(int i3, byte[] bArr, int i4, int i5) {
        for (int i6 = i4; i6 < i4 + i5; i6++) {
            i3 = (i3 * 31) + bArr[i6];
        }
        return i3;
    }

    static <T> T zza(T t2) {
        t2.getClass();
        return t2;
    }

    static <T> T zza(T t2, String str) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(str);
    }
}
