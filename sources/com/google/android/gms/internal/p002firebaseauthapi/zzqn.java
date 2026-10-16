package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Build;
import androidx.appcompat.app.jE.vxrlPPpdv;
import com.facebook.stetho.common.Utf8Charset;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzqn {
    public static final Charset zza = Charset.forName(Utf8Charset.NAME);

    public static int zza() {
        int i3 = 0;
        while (i3 == 0) {
            byte[] bArrZza = zzqd.zza(4);
            i3 = (bArrZza[3] & 255) | ((bArrZza[0] & 255) << 24) | ((bArrZza[1] & 255) << 16) | ((bArrZza[2] & 255) << 8);
        }
        return i3;
    }

    public static final zzaaj zzb(String str) {
        byte[] bArr = new byte[str.length()];
        for (int i3 = 0; i3 < str.length(); i3++) {
            char cCharAt = str.charAt(i3);
            if (cCharAt < '!' || cCharAt > '~') {
                throw new zzql(vxrlPPpdv.CGbTOQlb + cCharAt);
            }
            bArr[i3] = (byte) cCharAt;
        }
        return zzaaj.zza(bArr);
    }

    public static final zzaaj zza(String str) throws GeneralSecurityException {
        byte[] bArr = new byte[str.length()];
        for (int i3 = 0; i3 < str.length(); i3++) {
            char cCharAt = str.charAt(i3);
            if (cCharAt >= '!' && cCharAt <= '~') {
                bArr[i3] = (byte) cCharAt;
            } else {
                throw new GeneralSecurityException("Not a printable ASCII character: " + cCharAt);
            }
        }
        return zzaaj.zza(bArr);
    }

    @Nullable
    public static Integer zzb() {
        if (Objects.equals(System.getProperty("java.vendor"), "The Android Project")) {
            return Integer.valueOf(Build.VERSION.SDK_INT);
        }
        return null;
    }

    public static boolean zza(byte[] bArr, byte[] bArr2) {
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
