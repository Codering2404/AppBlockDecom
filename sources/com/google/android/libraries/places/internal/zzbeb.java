package com.google.android.libraries.places.internal;

import com.facebook.stetho.common.Utf8Charset;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbeb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Charset f76091a = Charset.forName(Utf8Charset.NAME);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f76092b;

    static {
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        f76092b = bArr;
        ByteBuffer.wrap(bArr);
        zzbco.f(bArr, 0, 0, false);
    }

    public static int a(boolean z2) {
        return z2 ? 1231 : 1237;
    }

    static int b(int i3, byte[] bArr, int i4, int i5) {
        for (int i6 = i4; i6 < i4 + i5; i6++) {
            i3 = (i3 * 31) + bArr[i6];
        }
        return i3;
    }
}
