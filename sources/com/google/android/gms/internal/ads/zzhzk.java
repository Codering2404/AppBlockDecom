package com.google.android.gms.internal.ads;

import com.facebook.stetho.common.Utf8Charset;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhzk {
    private static final Charset zza = Charset.forName(Utf8Charset.NAME);

    public static byte[] zza(String str, int i3) {
        byte[] bytes = str.getBytes(zza);
        int length = bytes.length;
        zzhzj zzhzjVar = new zzhzj(2, new byte[(length * 3) / 4]);
        if (!zzhzjVar.zza(bytes, 0, length, true)) {
            throw new IllegalArgumentException("bad base-64");
        }
        int i4 = zzhzjVar.zzb;
        byte[] bArr = zzhzjVar.zza;
        if (i4 == bArr.length) {
            return bArr;
        }
        byte[] bArr2 = new byte[i4];
        System.arraycopy(bArr, 0, bArr2, 0, i4);
        return bArr2;
    }
}
