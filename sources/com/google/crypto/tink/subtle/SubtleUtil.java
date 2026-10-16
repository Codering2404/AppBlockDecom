package com.google.crypto.tink.subtle;

import com.google.crypto.tink.subtle.Enums;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class SubtleUtil {

    /* JADX INFO: renamed from: com.google.crypto.tink.subtle.SubtleUtil$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f87541a;

        static {
            int[] iArr = new int[Enums.HashType.values().length];
            f87541a = iArr;
            try {
                iArr[Enums.HashType.SHA1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f87541a[Enums.HashType.SHA224.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f87541a[Enums.HashType.SHA256.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f87541a[Enums.HashType.SHA384.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f87541a[Enums.HashType.SHA512.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static boolean a() {
        return "The Android Project".equals(System.getProperty("java.vendor"));
    }

    public static void b(ByteBuffer byteBuffer, long j3) throws GeneralSecurityException {
        if (0 > j3 || j3 >= 4294967296L) {
            throw new GeneralSecurityException("Index out of range");
        }
        byteBuffer.putInt((int) j3);
    }
}
