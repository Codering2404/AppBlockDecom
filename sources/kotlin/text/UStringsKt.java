package kotlin.text;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class UStringsKt {
    public static final String a(int i3, int i4) {
        return UnsignedKt.f(((long) i3) & 4294967295L, CharsKt__CharJVMKt.checkRadix(i4));
    }

    public static final byte b(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        UByte uByteC = c(str);
        if (uByteC != null) {
            return uByteC.f();
        }
        StringsKt__StringNumberConversionsKt.t(str);
        throw new KotlinNothingValueException();
    }

    public static final UByte c(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return d(str, 10);
    }

    public static final UByte d(String str, int i3) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        UInt uIntG = g(str, i3);
        if (uIntG == null) {
            return null;
        }
        int iF = uIntG.f();
        if (Integer.compareUnsigned(iF, UInt.b(255)) > 0) {
            return null;
        }
        return UByte.a(UByte.b((byte) iF));
    }

    public static final int e(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        UInt uIntF = f(str);
        if (uIntF != null) {
            return uIntF.f();
        }
        StringsKt__StringNumberConversionsKt.t(str);
        throw new KotlinNothingValueException();
    }

    public static final UInt f(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return g(str, 10);
    }

    public static final UInt g(String str, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(str, "<this>");
        CharsKt__CharJVMKt.checkRadix(i3);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i5 = 0;
        char cCharAt = str.charAt(0);
        if (Intrinsics.compare((int) cCharAt, 48) < 0) {
            i4 = 1;
            if (length == 1 || cCharAt != '+') {
                return null;
            }
        } else {
            i4 = 0;
        }
        int iB = UInt.b(i3);
        int iDivideUnsigned = 119304647;
        while (i4 < length) {
            int iA = CharsKt__CharJVMKt.a(str.charAt(i4), i3);
            if (iA < 0) {
                return null;
            }
            if (Integer.compareUnsigned(i5, iDivideUnsigned) > 0) {
                if (iDivideUnsigned == 119304647) {
                    iDivideUnsigned = Integer.divideUnsigned(-1, iB);
                    if (Integer.compareUnsigned(i5, iDivideUnsigned) > 0) {
                    }
                }
                return null;
            }
            int iB2 = UInt.b(i5 * iB);
            int iB3 = UInt.b(UInt.b(iA) + iB2);
            if (Integer.compareUnsigned(iB3, iB2) < 0) {
                return null;
            }
            i4++;
            i5 = iB3;
        }
        return UInt.a(i5);
    }

    public static final long h(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        ULong uLongI = i(str);
        if (uLongI != null) {
            return uLongI.g();
        }
        StringsKt__StringNumberConversionsKt.t(str);
        throw new KotlinNothingValueException();
    }

    public static final ULong i(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return j(str, 10);
    }

    public static final ULong j(String str, int i3) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        CharsKt__CharJVMKt.checkRadix(i3);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i4 = 0;
        char cCharAt = str.charAt(0);
        if (Intrinsics.compare((int) cCharAt, 48) < 0) {
            i4 = 1;
            if (length == 1 || cCharAt != '+') {
                return null;
            }
        }
        long jB = ULong.b(i3);
        long j3 = 0;
        long jDivideUnsigned = 512409557603043100L;
        while (i4 < length) {
            int iA = CharsKt__CharJVMKt.a(str.charAt(i4), i3);
            if (iA < 0) {
                return null;
            }
            if (Long.compareUnsigned(j3, jDivideUnsigned) > 0) {
                if (jDivideUnsigned == 512409557603043100L) {
                    jDivideUnsigned = Long.divideUnsigned(-1L, jB);
                    if (Long.compareUnsigned(j3, jDivideUnsigned) > 0) {
                    }
                }
                return null;
            }
            long jB2 = ULong.b(j3 * jB);
            long jB3 = ULong.b(ULong.b(((long) UInt.b(iA)) & 4294967295L) + jB2);
            if (Long.compareUnsigned(jB3, jB2) < 0) {
                return null;
            }
            i4++;
            j3 = jB3;
        }
        return ULong.a(j3);
    }

    public static final short k(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        UShort uShortL = l(str);
        if (uShortL != null) {
            return uShortL.f();
        }
        StringsKt__StringNumberConversionsKt.t(str);
        throw new KotlinNothingValueException();
    }

    public static final UShort l(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return m(str, 10);
    }

    public static final UShort m(String str, int i3) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        UInt uIntG = g(str, i3);
        if (uIntG == null) {
            return null;
        }
        int iF = uIntG.f();
        if (Integer.compareUnsigned(iF, UInt.b(65535)) > 0) {
            return null;
        }
        return UShort.a(UShort.b((short) iF));
    }
}
