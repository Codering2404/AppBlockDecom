package com.google.android.gms.internal.ads;

import android.os.Build;
import com.facebook.stetho.common.Utf8Charset;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhnz {
    public static final /* synthetic */ int zza = 0;

    static {
        Charset.forName(Utf8Charset.NAME);
    }

    public static final zziaz zza(String str) {
        byte[] bArr = new byte[str.length()];
        for (int i3 = 0; i3 < str.length(); i3++) {
            char cCharAt = str.charAt(i3);
            if (cCharAt < '!' || cCharAt > '~') {
                StringBuilder sb = new StringBuilder(String.valueOf(cCharAt).length() + 33);
                sb.append("Not a printable ASCII character: ");
                sb.append(cCharAt);
                throw new zzhny(sb.toString());
            }
            bArr[i3] = (byte) cCharAt;
        }
        return zziaz.zza(bArr);
    }

    public static final zziaz zzb(String str) throws GeneralSecurityException {
        byte[] bArr = new byte[str.length()];
        for (int i3 = 0; i3 < str.length(); i3++) {
            char cCharAt = str.charAt(i3);
            if (cCharAt < '!' || cCharAt > '~') {
                StringBuilder sb = new StringBuilder(String.valueOf(cCharAt).length() + 33);
                sb.append("Not a printable ASCII character: ");
                sb.append(cCharAt);
                throw new GeneralSecurityException(sb.toString());
            }
            bArr[i3] = (byte) cCharAt;
        }
        return zziaz.zza(bArr);
    }

    public static boolean zzc() {
        return Objects.equals(System.getProperty("java.vendor"), "The Android Project");
    }

    @Nullable
    public static Integer zzd() {
        if (zzc()) {
            return Integer.valueOf(Build.VERSION.SDK_INT);
        }
        return null;
    }

    public static boolean zze(byte[] bArr, byte[] bArr2) {
        if (bArr2.length < bArr.length) {
            return false;
        }
        for (int i3 = 0; i3 < bArr.length; i3++) {
            if (bArr2[i3] != bArr[i3]) {
                return false;
            }
        }
        return true;
    }
}
