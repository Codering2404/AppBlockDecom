package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.proto.EcPointFormat;
import com.google.crypto.tink.proto.EllipticCurveType;
import com.google.crypto.tink.proto.HashType;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class HybridUtil {

    /* JADX INFO: renamed from: com.google.crypto.tink.hybrid.HybridUtil$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f86183a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f86184b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final /* synthetic */ int[] f86185c;

        static {
            int[] iArr = new int[EcPointFormat.values().length];
            f86185c = iArr;
            try {
                iArr[EcPointFormat.UNCOMPRESSED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f86185c[EcPointFormat.DO_NOT_USE_CRUNCHY_UNCOMPRESSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f86185c[EcPointFormat.COMPRESSED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[EllipticCurveType.values().length];
            f86184b = iArr2;
            try {
                iArr2[EllipticCurveType.NIST_P256.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f86184b[EllipticCurveType.NIST_P384.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f86184b[EllipticCurveType.NIST_P521.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr3 = new int[HashType.values().length];
            f86183a = iArr3;
            try {
                iArr3[HashType.SHA1.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f86183a[HashType.SHA224.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f86183a[HashType.SHA256.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f86183a[HashType.SHA384.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f86183a[HashType.SHA512.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }
}
