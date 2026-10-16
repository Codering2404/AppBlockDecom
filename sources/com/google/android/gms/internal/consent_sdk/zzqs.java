package com.google.android.gms.internal.consent_sdk;

import com.facebook.stetho.common.Utf8Charset;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzqs {
    static final Charset zza = Charset.forName(Utf8Charset.NAME);
    public static final byte[] zzb;

    static {
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        zzb = bArr;
        ByteBuffer.wrap(bArr);
        int i3 = zzpp.zza;
        try {
            new zzpn(bArr, 0, 0, false, null).zza(0);
        } catch (zzqu e3) {
            throw new IllegalArgumentException(e3);
        }
    }

    public static int zza(boolean z2) {
        return z2 ? 1231 : 1237;
    }

    static int zzb(int i3, byte[] bArr, int i4, int i5) {
        for (int i6 = 0; i6 < i5; i6++) {
            i3 = (i3 * 31) + bArr[i6];
        }
        return i3;
    }
}
