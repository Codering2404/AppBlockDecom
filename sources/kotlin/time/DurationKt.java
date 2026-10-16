package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlin.time.Duration;

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
public final class DurationKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final long i(long j3, int i3) {
        return Duration.i((j3 << 1) + ((long) i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long j(long j3) {
        return Duration.i((j3 << 1) + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long k(long j3) {
        return (-4611686018426L > j3 || j3 >= 4611686018427L) ? j(RangesKt.r(j3, -4611686018427387903L, 4611686018427387903L)) : l(n(j3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long l(long j3) {
        return Duration.i(j3 << 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long m(long j3) {
        return (-4611686018426999999L > j3 || j3 >= 4611686018427000000L) ? j(o(j3)) : l(j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long n(long j3) {
        return j3 * ((long) 1000000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long o(long j3) {
        return j3 / ((long) 1000000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long p(String str, boolean z2) {
        int i3;
        char cCharAt;
        char cCharAt2;
        int i4;
        boolean z3;
        int length = str.length();
        if (length == 0) {
            throw new IllegalArgumentException("The string is empty");
        }
        Duration.Companion companion = Duration.f140631b;
        long jC = companion.c();
        char cCharAt3 = str.charAt(0);
        int length2 = (cCharAt3 == '+' || cCharAt3 == '-') ? 1 : 0;
        boolean z4 = length2 > 0;
        boolean z5 = z4 && StringsKt.Y0(str, '-', false, 2, null);
        if (length <= length2) {
            throw new IllegalArgumentException("No components");
        }
        char c3 = ':';
        char c4 = '0';
        if (str.charAt(length2) == 'P') {
            int i5 = length2 + 1;
            if (i5 == length) {
                throw new IllegalArgumentException();
            }
            boolean z6 = false;
            DurationUnit durationUnit = null;
            while (i5 < length) {
                if (str.charAt(i5) != 'T') {
                    int i6 = i5;
                    while (true) {
                        if (i6 >= str.length()) {
                            i4 = length;
                            break;
                        }
                        char cCharAt4 = str.charAt(i6);
                        if (c4 > cCharAt4 || cCharAt4 >= c3) {
                            i4 = length;
                            if (!StringsKt.Z("+-.", cCharAt4, false, 2, null)) {
                                break;
                            }
                        } else {
                            i4 = length;
                        }
                        i6++;
                        length = i4;
                        c4 = '0';
                        c3 = ':';
                    }
                    Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
                    String strSubstring = str.substring(i5, i6);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    if (strSubstring.length() == 0) {
                        throw new IllegalArgumentException();
                    }
                    int length3 = i5 + strSubstring.length();
                    if (length3 < 0 || length3 >= str.length()) {
                        throw new IllegalArgumentException("Missing unit for value " + strSubstring);
                    }
                    char cCharAt5 = str.charAt(length3);
                    i5 = length3 + 1;
                    DurationUnit durationUnitD = DurationUnitKt__DurationUnitKt.d(cCharAt5, z6);
                    if (durationUnit != null && durationUnit.compareTo(durationUnitD) <= 0) {
                        throw new IllegalArgumentException("Unexpected order of duration components");
                    }
                    int iM0 = StringsKt.m0(strSubstring, '.', 0, false, 6, null);
                    if (durationUnitD != DurationUnit.f140641f || iM0 <= 0) {
                        z3 = z6;
                        jC = Duration.G(jC, t(q(strSubstring), durationUnitD));
                    } else {
                        Intrinsics.checkNotNull(strSubstring, "null cannot be cast to non-null type java.lang.String");
                        String strSubstring2 = strSubstring.substring(0, iM0);
                        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                        z3 = z6;
                        long jG = Duration.G(jC, t(q(strSubstring2), durationUnitD));
                        Intrinsics.checkNotNull(strSubstring, "null cannot be cast to non-null type java.lang.String");
                        String strSubstring3 = strSubstring.substring(iM0);
                        Intrinsics.checkNotNullExpressionValue(strSubstring3, "substring(...)");
                        jC = Duration.G(jG, r(Double.parseDouble(strSubstring3), durationUnitD));
                    }
                    z6 = z3;
                    durationUnit = durationUnitD;
                    length = i4;
                    c4 = '0';
                    c3 = ':';
                } else {
                    if (z6 || (i5 = i5 + 1) == length) {
                        throw new IllegalArgumentException();
                    }
                    z6 = true;
                }
            }
        } else {
            if (z2) {
                throw new IllegalArgumentException();
            }
            char c5 = '0';
            if (StringsKt.I(str, length2, "Infinity", 0, Math.max(length - length2, 8), true)) {
                jC = companion.a();
            } else {
                boolean z7 = !z4;
                if (z4 && str.charAt(length2) == '(' && StringsKt.z1(str) == ')') {
                    length2++;
                    int i7 = length - 1;
                    if (length2 == i7) {
                        throw new IllegalArgumentException("No components");
                    }
                    i3 = i7;
                    z7 = true;
                } else {
                    i3 = length;
                }
                boolean z8 = false;
                DurationUnit durationUnit2 = null;
                while (length2 < i3) {
                    if (z8 && z7) {
                        while (length2 < str.length() && str.charAt(length2) == ' ') {
                            length2++;
                        }
                    }
                    int i8 = length2;
                    while (i8 < str.length() && ((c5 <= (cCharAt2 = str.charAt(i8)) && cCharAt2 < ':') || cCharAt2 == '.')) {
                        i8++;
                    }
                    Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
                    String strSubstring4 = str.substring(length2, i8);
                    Intrinsics.checkNotNullExpressionValue(strSubstring4, "substring(...)");
                    if (strSubstring4.length() == 0) {
                        throw new IllegalArgumentException();
                    }
                    int length4 = length2 + strSubstring4.length();
                    int i9 = length4;
                    while (i9 < str.length() && 'a' <= (cCharAt = str.charAt(i9)) && cCharAt < '{') {
                        i9++;
                    }
                    Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
                    String strSubstring5 = str.substring(length4, i9);
                    Intrinsics.checkNotNullExpressionValue(strSubstring5, "substring(...)");
                    length2 = length4 + strSubstring5.length();
                    DurationUnit durationUnitE = DurationUnitKt__DurationUnitKt.e(strSubstring5);
                    if (durationUnit2 != null && durationUnit2.compareTo(durationUnitE) <= 0) {
                        throw new IllegalArgumentException("Unexpected order of duration components");
                    }
                    int iM02 = StringsKt.m0(strSubstring4, '.', 0, false, 6, null);
                    if (iM02 > 0) {
                        Intrinsics.checkNotNull(strSubstring4, "null cannot be cast to non-null type java.lang.String");
                        String strSubstring6 = strSubstring4.substring(0, iM02);
                        Intrinsics.checkNotNullExpressionValue(strSubstring6, "substring(...)");
                        long jG2 = Duration.G(jC, t(Long.parseLong(strSubstring6), durationUnitE));
                        Intrinsics.checkNotNull(strSubstring4, "null cannot be cast to non-null type java.lang.String");
                        String strSubstring7 = strSubstring4.substring(iM02);
                        Intrinsics.checkNotNullExpressionValue(strSubstring7, "substring(...)");
                        jC = Duration.G(jG2, r(Double.parseDouble(strSubstring7), durationUnitE));
                        if (length2 < i3) {
                            throw new IllegalArgumentException("Fractional component must be last");
                        }
                    } else {
                        jC = Duration.G(jC, t(Long.parseLong(strSubstring4), durationUnitE));
                    }
                    durationUnit2 = durationUnitE;
                    z8 = true;
                    c5 = '0';
                }
            }
        }
        return z5 ? Duration.R(jC) : jC;
    }

    private static final long q(String str) {
        char cCharAt;
        int length = str.length();
        int i3 = (length <= 0 || !StringsKt.Z("+-", str.charAt(0), false, 2, null)) ? 0 : 1;
        if (length - i3 > 16) {
            int i4 = i3;
            while (true) {
                if (i3 < length) {
                    char cCharAt2 = str.charAt(i3);
                    if (cCharAt2 == '0') {
                        if (i4 == i3) {
                            i4++;
                        }
                    } else if ('1' > cCharAt2 || cCharAt2 >= ':') {
                        break;
                    }
                    i3++;
                } else if (length - i4 > 16) {
                    return str.charAt(0) == '-' ? Long.MIN_VALUE : Long.MAX_VALUE;
                }
            }
        }
        return (!StringsKt.U(str, "+", false, 2, null) || length <= 1 || '0' > (cCharAt = str.charAt(1)) || cCharAt >= ':') ? Long.parseLong(str) : Long.parseLong(StringsKt.w1(str, 1));
    }

    public static final long r(double d3, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        double dA = DurationUnitKt__DurationUnitJvmKt.a(d3, unit, DurationUnit.f140638b);
        if (Double.isNaN(dA)) {
            throw new IllegalArgumentException("Duration value cannot be NaN.");
        }
        long jE = MathKt.e(dA);
        return (-4611686018426999999L > jE || jE >= 4611686018427000000L) ? k(MathKt.e(DurationUnitKt__DurationUnitJvmKt.a(d3, unit, DurationUnit.f140640d))) : l(jE);
    }

    public static final long s(int i3, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return unit.compareTo(DurationUnit.f140641f) <= 0 ? l(DurationUnitKt__DurationUnitJvmKt.c(i3, unit, DurationUnit.f140638b)) : t(i3, unit);
    }

    public static final long t(long j3, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        DurationUnit durationUnit = DurationUnit.f140638b;
        long jC = DurationUnitKt__DurationUnitJvmKt.c(4611686018426999999L, durationUnit, unit);
        return ((-jC) > j3 || j3 > jC) ? j(RangesKt.r(DurationUnitKt__DurationUnitJvmKt.b(j3, unit, DurationUnit.f140640d), -4611686018427387903L, 4611686018427387903L)) : l(DurationUnitKt__DurationUnitJvmKt.c(j3, unit, durationUnit));
    }
}
