package com.google.crypto.tink.internal;

import com.facebook.stetho.common.Utf8Charset;
import com.google.crypto.tink.util.Bytes;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class Util {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f86290a = Charset.forName(Utf8Charset.NAME);

    private static final byte a(char c3) {
        if (c3 >= '!' && c3 <= '~') {
            return (byte) c3;
        }
        throw new TinkBugException("Not a printable ASCII character: " + c3);
    }

    public static final Bytes b(String str) {
        byte[] bArr = new byte[str.length()];
        for (int i3 = 0; i3 < str.length(); i3++) {
            bArr[i3] = a(str.charAt(i3));
        }
        return Bytes.a(bArr);
    }
}
