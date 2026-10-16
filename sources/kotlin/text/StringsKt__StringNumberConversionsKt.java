package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
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
public class StringsKt__StringNumberConversionsKt extends StringsKt__StringNumberConversionsJVMKt {
    public static final Void t(String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        throw new NumberFormatException("Invalid number format: '" + input + '\'');
    }

    public static Integer u(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return v(str, 10);
    }

    public static final Integer v(String str, int i3) {
        boolean z2;
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(str, "<this>");
        CharsKt__CharJVMKt.checkRadix(i3);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i6 = 0;
        char cCharAt = str.charAt(0);
        int i7 = -2147483647;
        if (Intrinsics.compare((int) cCharAt, 48) < 0) {
            i4 = 1;
            if (length == 1) {
                return null;
            }
            if (cCharAt == '+') {
                z2 = false;
            } else {
                if (cCharAt != '-') {
                    return null;
                }
                i7 = Integer.MIN_VALUE;
                z2 = true;
            }
        } else {
            z2 = false;
            i4 = 0;
        }
        int i8 = -59652323;
        while (i4 < length) {
            int iA = CharsKt__CharJVMKt.a(str.charAt(i4), i3);
            if (iA < 0) {
                return null;
            }
            if ((i6 < i8 && (i8 != -59652323 || i6 < (i8 = i7 / i3))) || (i5 = i6 * i3) < i7 + iA) {
                return null;
            }
            i6 = i5 - iA;
            i4++;
        }
        return z2 ? Integer.valueOf(i6) : Integer.valueOf(-i6);
    }

    public static Long w(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return x(str, 10);
    }

    public static final Long x(String str, int i3) {
        boolean z2;
        Intrinsics.checkNotNullParameter(str, "<this>");
        CharsKt__CharJVMKt.checkRadix(i3);
        int length = str.length();
        Long l3 = null;
        if (length == 0) {
            return null;
        }
        int i4 = 0;
        char cCharAt = str.charAt(0);
        long j3 = -9223372036854775807L;
        if (Intrinsics.compare((int) cCharAt, 48) < 0) {
            z2 = true;
            if (length == 1) {
                return null;
            }
            if (cCharAt == '+') {
                z2 = false;
                i4 = 1;
            } else {
                if (cCharAt != '-') {
                    return null;
                }
                j3 = Long.MIN_VALUE;
                i4 = 1;
            }
        } else {
            z2 = false;
        }
        long j4 = 0;
        long j5 = -256204778801521550L;
        while (i4 < length) {
            int iA = CharsKt__CharJVMKt.a(str.charAt(i4), i3);
            if (iA < 0) {
                return l3;
            }
            if (j4 < j5) {
                if (j5 != -256204778801521550L) {
                    return l3;
                }
                j5 = j3 / ((long) i3);
                if (j4 < j5) {
                    return l3;
                }
            }
            Long l4 = l3;
            int i5 = i4;
            long j6 = j4 * ((long) i3);
            long j7 = iA;
            if (j6 < j3 + j7) {
                return l4;
            }
            j4 = j6 - j7;
            i4 = i5 + 1;
            l3 = l4;
        }
        return z2 ? Long.valueOf(j4) : Long.valueOf(-j4);
    }
}
