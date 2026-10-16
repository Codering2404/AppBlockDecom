package com.google.crypto.tink.hybrid.internal;

import com.google.crypto.tink.internal.Util;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class HpkeUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f86193a = a(1, 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f86194b = a(2, 32);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte[] f86195c = a(2, 16);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final byte[] f86196d = a(2, 17);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final byte[] f86197e = a(2, 18);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final byte[] f86198f = a(2, 1);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final byte[] f86199g = a(2, 2);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final byte[] f86200h = a(2, 3);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final byte[] f86201i = a(2, 1);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final byte[] f86202j = a(2, 2);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final byte[] f86203k = a(2, 3);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final byte[] f86204l = new byte[0];

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final byte[] f86205m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final byte[] f86206n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final byte[] f86207o;

    /* JADX INFO: renamed from: com.google.crypto.tink.hybrid.internal.HpkeUtil$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f86208a;

        static {
            int[] iArr = new int[com.google.crypto.tink.proto.HpkeKem.values().length];
            f86208a = iArr;
            try {
                iArr[com.google.crypto.tink.proto.HpkeKem.DHKEM_P256_HKDF_SHA256.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f86208a[com.google.crypto.tink.proto.HpkeKem.DHKEM_P384_HKDF_SHA384.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f86208a[com.google.crypto.tink.proto.HpkeKem.DHKEM_P521_HKDF_SHA512.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        Charset charset = Util.f86290a;
        f86205m = "KEM".getBytes(charset);
        f86206n = "HPKE".getBytes(charset);
        f86207o = "HPKE-v1".getBytes(charset);
    }

    public static byte[] a(int i3, int i4) {
        byte[] bArr = new byte[i3];
        for (int i5 = 0; i5 < i3; i5++) {
            bArr[i5] = (byte) ((i4 >> (((i3 - i5) - 1) * 8)) & 255);
        }
        return bArr;
    }
}
