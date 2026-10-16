package com.google.android.gms.internal.fido;

import com.facebook.stetho.common.Utf8Charset;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhc {
    static final Charset zza = Charset.forName("US-ASCII");
    static final Charset zzb = Charset.forName(Utf8Charset.NAME);
    static final Charset zzc = Charset.forName("ISO-8859-1");
    public static final byte[] zzd;
    public static final ByteBuffer zze;
    public static final zzhb zzf;

    static {
        byte[] bArr = new byte[0];
        zzd = bArr;
        zze = ByteBuffer.wrap(bArr);
        int i3 = zzhb.zza;
        zzgz zzgzVar = new zzgz(bArr, 0, 0, false, null);
        try {
            zzgzVar.zza(0);
            zzf = zzgzVar;
        } catch (zzhd e3) {
            throw new IllegalArgumentException(e3);
        }
    }
}
