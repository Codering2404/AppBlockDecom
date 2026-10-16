package com.google.android.gms.internal.p002firebaseauthapi;

import com.facebook.stetho.common.Utf8Charset;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import java.io.UnsupportedEncodingException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzahx {
    public static long zza(String str) {
        zzahw zzahwVarZzb = zzb(str);
        return zzahwVarZzb.zza().longValue() - zzahwVarZzb.zzb().longValue();
    }

    private static zzahw zzb(String str) {
        Preconditions.g(str);
        List<String> listZza = zzt.zza('.').zza((CharSequence) str);
        if (listZza.size() >= 2) {
            try {
                return zzahw.zza(new String(Base64Utils.b(listZza.get(1)), Utf8Charset.NAME));
            } catch (UnsupportedEncodingException e3) {
                throw new RuntimeException("Unable to decode token", e3);
            }
        }
        throw new RuntimeException("Invalid idToken " + str);
    }
}
