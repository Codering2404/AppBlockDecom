package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.MimeTypeMap;
import com.applovin.exoplayer2.common.base.Ascii;
import java.io.Closeable;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Lj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0864Lj {
    public static byte[] A00;
    public static final String A01;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 17);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A00 = new byte[]{91, 78, 76, 6, 52, 3, 3, Ascii.RS, 3, 81, Ascii.DC2, Ascii.GS, Ascii.RS, 2, Ascii.CAN, Ascii.US, Ascii.SYN, 81, 3, Ascii.DC4, 2, Ascii.RS, 4, 3, Ascii.DC2, Ascii.DC4, 107, 98, 19};
    }

    static {
        A04();
        A01 = C0864Lj.class.getSimpleName();
    }

    public static String A01(String str) {
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        String extension = MimeTypeMap.getFileExtensionFromUrl(str);
        if (TextUtils.isEmpty(extension)) {
            return null;
        }
        return singleton.getMimeTypeFromExtension(extension);
    }

    public static String A02(String str) {
        try {
            return A03(MessageDigest.getInstance(A00(26, 3, 55)).digest(str.getBytes()));
        } catch (NoSuchAlgorithmException e3) {
            throw new IllegalStateException(e3);
        }
    }

    public static String A03(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b3 : bArr) {
            stringBuffer.append(String.format(Locale.US, A00(0, 4, 111), Byte.valueOf(b3)));
        }
        return stringBuffer.toString();
    }

    public static void A05(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e3) {
                Log.e(A01, A00(4, 22, 96), e3);
            }
        }
    }
}
