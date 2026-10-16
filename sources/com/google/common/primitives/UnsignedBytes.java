package com.google.common.primitives;

import com.google.common.base.Preconditions;
import java.lang.reflect.Field;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Comparator;
import java.util.Objects;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class UnsignedBytes {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class LexicographicalComparatorHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final String f85506a = LexicographicalComparatorHolder.class.getName() + "$UnsafeComparator";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final Comparator f85507b = a();

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        enum PureJavaComparator implements Comparator<byte[]> {
            INSTANCE;

            @Override // java.util.Comparator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public int compare(byte[] bArr, byte[] bArr2) {
                int iMin = Math.min(bArr.length, bArr2.length);
                for (int i3 = 0; i3 < iMin; i3++) {
                    int iB = UnsignedBytes.b(bArr[i3], bArr2[i3]);
                    if (iB != 0) {
                        return iB;
                    }
                }
                return bArr.length - bArr2.length;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "UnsignedBytes.lexicographicalComparator() (pure Java version)";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        enum UnsafeComparator implements Comparator<byte[]> {
            INSTANCE;


            /* JADX INFO: renamed from: b, reason: collision with root package name */
            static final boolean f85511b = ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN);

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            static final Unsafe f85512c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            static final int f85513d;

            static {
                Unsafe unsafeC = c();
                f85512c = unsafeC;
                int iArrayBaseOffset = unsafeC.arrayBaseOffset(byte[].class);
                f85513d = iArrayBaseOffset;
                if (!"64".equals(System.getProperty("sun.arch.data.model")) || iArrayBaseOffset % 8 != 0 || unsafeC.arrayIndexScale(byte[].class) != 1) {
                    throw new Error();
                }
            }

            private static Unsafe c() {
                try {
                    try {
                        return Unsafe.getUnsafe();
                    } catch (PrivilegedActionException e3) {
                        throw new RuntimeException("Could not initialize intrinsics", e3.getCause());
                    }
                } catch (SecurityException unused) {
                    return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: com.google.common.primitives.UnsignedBytes.LexicographicalComparatorHolder.UnsafeComparator.1
                        @Override // java.security.PrivilegedExceptionAction
                        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                        public Unsafe run() throws IllegalAccessException {
                            for (Field field : Unsafe.class.getDeclaredFields()) {
                                field.setAccessible(true);
                                Object obj = field.get(null);
                                if (Unsafe.class.isInstance(obj)) {
                                    return (Unsafe) Unsafe.class.cast(obj);
                                }
                            }
                            throw new NoSuchFieldError("the Unsafe");
                        }
                    });
                }
            }

            @Override // java.util.Comparator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public int compare(byte[] bArr, byte[] bArr2) {
                int iMin = Math.min(bArr.length, bArr2.length);
                int i3 = iMin & (-8);
                int i4 = 0;
                while (i4 < i3) {
                    Unsafe unsafe = f85512c;
                    int i5 = f85513d;
                    long j3 = i4;
                    long j4 = unsafe.getLong(bArr, ((long) i5) + j3);
                    long j5 = unsafe.getLong(bArr2, ((long) i5) + j3);
                    if (j4 != j5) {
                        if (f85511b) {
                            return Long.compareUnsigned(j4, j5);
                        }
                        int iNumberOfTrailingZeros = Long.numberOfTrailingZeros(j4 ^ j5) & (-8);
                        return ((int) ((j4 >>> iNumberOfTrailingZeros) & 255)) - ((int) ((j5 >>> iNumberOfTrailingZeros) & 255));
                    }
                    i4 += 8;
                }
                while (i4 < iMin) {
                    int iB = UnsignedBytes.b(bArr[i4], bArr2[i4]);
                    if (iB != 0) {
                        return iB;
                    }
                    i4++;
                }
                return bArr.length - bArr2.length;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "UnsignedBytes.lexicographicalComparator() (sun.misc.Unsafe version)";
            }
        }

        static Comparator a() {
            try {
                Object[] enumConstants = Class.forName(f85506a).getEnumConstants();
                Objects.requireNonNull(enumConstants);
                return (Comparator) enumConstants[0];
            } catch (Throwable unused) {
                return UnsignedBytes.c();
            }
        }
    }

    public static byte a(long j3) {
        Preconditions.k((j3 >> 8) == 0, "out of range: %s", j3);
        return (byte) j3;
    }

    public static int b(byte b3, byte b4) {
        return d(b3) - d(b4);
    }

    static Comparator c() {
        return LexicographicalComparatorHolder.PureJavaComparator.INSTANCE;
    }

    public static int d(byte b3) {
        return b3 & 255;
    }
}
