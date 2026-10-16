package com.google.common.hash;

import com.google.common.hash.LittleEndianByteArray;
import com.google.common.primitives.Longs;
import java.lang.reflect.Field;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class LittleEndianByteArray {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final LittleEndianBytes f85112a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private enum JavaLittleEndianBytes implements LittleEndianBytes {
        INSTANCE { // from class: com.google.common.hash.LittleEndianByteArray.JavaLittleEndianBytes.1
            @Override // com.google.common.hash.LittleEndianByteArray.LittleEndianBytes
            public long a(byte[] bArr, int i3) {
                return Longs.d(bArr[i3 + 7], bArr[i3 + 6], bArr[i3 + 5], bArr[i3 + 4], bArr[i3 + 3], bArr[i3 + 2], bArr[i3 + 1], bArr[i3]);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private interface LittleEndianBytes {
        long a(byte[] bArr, int i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    enum UnsafeByteArray implements LittleEndianBytes {
        UNSAFE_LITTLE_ENDIAN { // from class: com.google.common.hash.LittleEndianByteArray.UnsafeByteArray.1
            @Override // com.google.common.hash.LittleEndianByteArray.LittleEndianBytes
            public long a(byte[] bArr, int i3) {
                return UnsafeByteArray.f85117c.getLong(bArr, ((long) i3) + ((long) UnsafeByteArray.f85118d));
            }
        },
        UNSAFE_BIG_ENDIAN { // from class: com.google.common.hash.LittleEndianByteArray.UnsafeByteArray.2
            @Override // com.google.common.hash.LittleEndianByteArray.LittleEndianBytes
            public long a(byte[] bArr, int i3) {
                return Long.reverseBytes(UnsafeByteArray.f85117c.getLong(bArr, ((long) i3) + ((long) UnsafeByteArray.f85118d)));
            }
        };


        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final Unsafe f85117c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final int f85118d;

        static {
            Unsafe unsafeF = f();
            f85117c = unsafeF;
            f85118d = unsafeF.arrayBaseOffset(byte[].class);
            if (unsafeF.arrayIndexScale(byte[].class) != 1) {
                throw new AssertionError();
            }
        }

        private static Unsafe f() {
            try {
                try {
                    return Unsafe.getUnsafe();
                } catch (PrivilegedActionException e3) {
                    throw new RuntimeException("Could not initialize intrinsics", e3.getCause());
                }
            } catch (SecurityException unused) {
                return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction() { // from class: com.google.common.hash.a
                    @Override // java.security.PrivilegedExceptionAction
                    public final Object run() {
                        return LittleEndianByteArray.UnsafeByteArray.g();
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Unsafe g() throws IllegalAccessException {
            for (Field field : Unsafe.class.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj = field.get(null);
                if (Unsafe.class.isInstance(obj)) {
                    return (Unsafe) Unsafe.class.cast(obj);
                }
            }
            throw new NoSuchFieldError("the Unsafe");
        }
    }

    static {
        LittleEndianBytes littleEndianBytes = JavaLittleEndianBytes.INSTANCE;
        try {
            if ("amd64".equals(System.getProperty("os.arch"))) {
                littleEndianBytes = ByteOrder.nativeOrder().equals(ByteOrder.LITTLE_ENDIAN) ? UnsafeByteArray.UNSAFE_LITTLE_ENDIAN : UnsafeByteArray.UNSAFE_BIG_ENDIAN;
            }
        } catch (Throwable unused) {
        }
        f85112a = littleEndianBytes;
    }

    static int a(byte[] bArr, int i3) {
        return ((bArr[i3 + 3] & 255) << 24) | (bArr[i3] & 255) | ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3 + 2] & 255) << 16);
    }

    static long b(byte[] bArr, int i3) {
        return f85112a.a(bArr, i3);
    }

    static long c(byte[] bArr, int i3, int i4) {
        int iMin = Math.min(i4, 8);
        long j3 = 0;
        for (int i5 = 0; i5 < iMin; i5++) {
            j3 |= (((long) bArr[i3 + i5]) & 255) << (i5 * 8);
        }
        return j3;
    }
}
