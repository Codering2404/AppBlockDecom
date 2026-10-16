package kotlin.text;

import com.sun.jna.Function;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.HexFormat;

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
public final class HexExtensionsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f140528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f140529b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f140530c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long[] f140531d;

    static {
        int[] iArr = new int[Function.MAX_NARGS];
        int i3 = 0;
        for (int i4 = 0; i4 < 256; i4++) {
            iArr[i4] = "0123456789abcdef".charAt(i4 & 15) | ("0123456789abcdef".charAt(i4 >> 4) << '\b');
        }
        f140528a = iArr;
        int[] iArr2 = new int[Function.MAX_NARGS];
        for (int i5 = 0; i5 < 256; i5++) {
            iArr2[i5] = "0123456789ABCDEF".charAt(i5 & 15) | ("0123456789ABCDEF".charAt(i5 >> 4) << '\b');
        }
        f140529b = iArr2;
        int[] iArr3 = new int[Function.MAX_NARGS];
        for (int i6 = 0; i6 < 256; i6++) {
            iArr3[i6] = -1;
        }
        int i7 = 0;
        int i8 = 0;
        while (i7 < "0123456789abcdef".length()) {
            iArr3["0123456789abcdef".charAt(i7)] = i8;
            i7++;
            i8++;
        }
        int i9 = 0;
        int i10 = 0;
        while (i9 < "0123456789ABCDEF".length()) {
            iArr3["0123456789ABCDEF".charAt(i9)] = i10;
            i9++;
            i10++;
        }
        f140530c = iArr3;
        long[] jArr = new long[Function.MAX_NARGS];
        for (int i11 = 0; i11 < 256; i11++) {
            jArr[i11] = -1;
        }
        int i12 = 0;
        int i13 = 0;
        while (i12 < "0123456789abcdef".length()) {
            jArr["0123456789abcdef".charAt(i12)] = i13;
            i12++;
            i13++;
        }
        int i14 = 0;
        while (i3 < "0123456789ABCDEF".length()) {
            jArr["0123456789ABCDEF".charAt(i3)] = i14;
            i3++;
            i14++;
        }
        f140531d = jArr;
    }

    private static final void a(String str, int i3, int i4, int i5) {
        int i6 = i4 - i3;
        if (i6 < 1) {
            j(str, i3, i4, "at least", 1);
        } else if (i6 > i5) {
            c(str, i3, (i6 + i3) - i5);
        }
    }

    private static final void b(String str, int i3, int i4, String str2, String str3, boolean z2, int i5) {
        if ((i4 - i3) - str2.length() <= str3.length()) {
            k(str, i3, i4, str2, str3);
        }
        if (str2.length() != 0) {
            int length = str2.length();
            for (int i6 = 0; i6 < length; i6++) {
                if (!CharsKt__CharKt.g(str2.charAt(i6), str.charAt(i3 + i6), z2)) {
                    l(str, i3, i4, str2, "prefix");
                }
            }
            i3 += str2.length();
        }
        int length2 = i4 - str3.length();
        if (str3.length() != 0) {
            int length3 = str3.length();
            for (int i7 = 0; i7 < length3; i7++) {
                if (!CharsKt__CharKt.g(str3.charAt(i7), str.charAt(length2 + i7), z2)) {
                    l(str, length2, i4, str3, "suffix");
                }
            }
        }
        a(str, i3, length2, i5);
    }

    private static final void c(String str, int i3, int i4) {
        while (i3 < i4) {
            if (str.charAt(i3) != '0') {
                throw new NumberFormatException("Expected the hexadecimal digit '0' at index " + i3 + ", but was '" + str.charAt(i3) + "'.\nThe result won't fit the type being parsed.");
            }
            i3++;
        }
    }

    public static final int[] d() {
        return f140528a;
    }

    public static final long e(String str, int i3, int i4, HexFormat format) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return g(str, i3, i4, format, 16);
    }

    public static /* synthetic */ long f(String str, int i3, int i4, HexFormat hexFormat, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i3 = 0;
        }
        if ((i5 & 2) != 0) {
            i4 = str.length();
        }
        if ((i5 & 4) != 0) {
            hexFormat = HexFormat.f140532d.a();
        }
        return e(str, i3, i4, hexFormat);
    }

    private static final long g(String str, int i3, int i4, HexFormat hexFormat, int i5) {
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(i3, i4, str.length());
        HexFormat.NumberHexFormat numberHexFormatB = hexFormat.b();
        if (numberHexFormatB.f()) {
            a(str, i3, i4, i5);
            return h(str, i3, i4);
        }
        String strD = numberHexFormatB.d();
        String strE = numberHexFormatB.e();
        b(str, i3, i4, strD, strE, numberHexFormatB.c(), i5);
        return h(str, i3 + strD.length(), i4 - strE.length());
    }

    private static final long h(String str, int i3, int i4) {
        long j3 = 0;
        while (i3 < i4) {
            long j4 = j3 << 4;
            char cCharAt = str.charAt(i3);
            if ((cCharAt >>> '\b') == 0) {
                long j5 = f140531d[cCharAt];
                if (j5 >= 0) {
                    j3 = j4 | j5;
                    i3++;
                }
            }
            i(str, i3);
            throw new KotlinNothingValueException();
        }
        return j3;
    }

    private static final Void i(String str, int i3) {
        throw new NumberFormatException("Expected a hexadecimal digit at index " + i3 + ", but was " + str.charAt(i3));
    }

    private static final void j(String str, int i3, int i4, String str2, int i5) {
        Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = str.substring(i3, i4);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        throw new NumberFormatException("Expected " + str2 + ' ' + i5 + " hexadecimal digits at index " + i3 + ", but was \"" + strSubstring + "\" of length " + (i4 - i3));
    }

    private static final void k(String str, int i3, int i4, String str2, String str3) {
        Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = str.substring(i3, i4);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        throw new NumberFormatException("Expected a hexadecimal number with prefix \"" + str2 + "\" and suffix \"" + str3 + "\", but was " + strSubstring);
    }

    private static final void l(String str, int i3, int i4, String str2, String str3) {
        int iK = RangesKt.k(str2.length() + i3, i4);
        Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = str.substring(i3, iK);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        throw new NumberFormatException("Expected " + str3 + " \"" + str2 + "\" at index " + i3 + ", but was " + strSubstring);
    }
}
