package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.RandomKt;
import kotlin.ranges.IntProgression;
import kotlin.ranges.LongProgression;

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
public class RangesKt___RangesKt extends RangesKt__RangesKt {
    public static LongProgression A(LongProgression longProgression, long j3) {
        Intrinsics.checkNotNullParameter(longProgression, "<this>");
        RangesKt__RangesKt.a(j3 > 0, Long.valueOf(j3));
        LongProgression.Companion companion = LongProgression.f140220d;
        long jG = longProgression.g();
        long jH = longProgression.h();
        if (longProgression.l() <= 0) {
            j3 = -j3;
        }
        return companion.a(jG, jH, j3);
    }

    public static IntRange B(int i3, int i4) {
        return i4 <= Integer.MIN_VALUE ? IntRange.f140218f.a() : new IntRange(i3, i4 - 1);
    }

    public static double d(double d3, double d4) {
        return d3 < d4 ? d4 : d3;
    }

    public static float e(float f3, float f4) {
        return f3 < f4 ? f4 : f3;
    }

    public static int f(int i3, int i4) {
        return i3 < i4 ? i4 : i3;
    }

    public static long g(long j3, long j4) {
        return j3 < j4 ? j4 : j3;
    }

    public static Comparable h(Comparable comparable, Comparable minimumValue) {
        Intrinsics.checkNotNullParameter(comparable, "<this>");
        Intrinsics.checkNotNullParameter(minimumValue, "minimumValue");
        return comparable.compareTo(minimumValue) < 0 ? minimumValue : comparable;
    }

    public static double i(double d3, double d4) {
        return d3 > d4 ? d4 : d3;
    }

    public static float j(float f3, float f4) {
        return f3 > f4 ? f4 : f3;
    }

    public static int k(int i3, int i4) {
        return i3 > i4 ? i4 : i3;
    }

    public static long l(long j3, long j4) {
        return j3 > j4 ? j4 : j3;
    }

    public static Comparable m(Comparable comparable, Comparable maximumValue) {
        Intrinsics.checkNotNullParameter(comparable, "<this>");
        Intrinsics.checkNotNullParameter(maximumValue, "maximumValue");
        return comparable.compareTo(maximumValue) > 0 ? maximumValue : comparable;
    }

    public static double n(double d3, double d4, double d5) {
        if (d4 <= d5) {
            return d3 < d4 ? d4 : d3 > d5 ? d5 : d3;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + d5 + " is less than minimum " + d4 + '.');
    }

    public static float o(float f3, float f4, float f5) {
        if (f4 <= f5) {
            return f3 < f4 ? f4 : f3 > f5 ? f5 : f3;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + f5 + " is less than minimum " + f4 + '.');
    }

    public static int p(int i3, int i4, int i5) {
        if (i4 <= i5) {
            return i3 < i4 ? i4 : i3 > i5 ? i5 : i3;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i5 + " is less than minimum " + i4 + '.');
    }

    public static int q(int i3, ClosedRange range) {
        Intrinsics.checkNotNullParameter(range, "range");
        if (range instanceof ClosedFloatingPointRange) {
            return ((Number) u(Integer.valueOf(i3), (ClosedFloatingPointRange) range)).intValue();
        }
        if (!range.isEmpty()) {
            return i3 < ((Number) range.a()).intValue() ? ((Number) range.a()).intValue() : i3 > ((Number) range.e()).intValue() ? ((Number) range.e()).intValue() : i3;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    public static long r(long j3, long j4, long j5) {
        if (j4 <= j5) {
            return j3 < j4 ? j4 : j3 > j5 ? j5 : j3;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + j5 + " is less than minimum " + j4 + '.');
    }

    public static long s(long j3, ClosedRange range) {
        Intrinsics.checkNotNullParameter(range, "range");
        if (range instanceof ClosedFloatingPointRange) {
            return ((Number) u(Long.valueOf(j3), (ClosedFloatingPointRange) range)).longValue();
        }
        if (!range.isEmpty()) {
            return j3 < ((Number) range.a()).longValue() ? ((Number) range.a()).longValue() : j3 > ((Number) range.e()).longValue() ? ((Number) range.e()).longValue() : j3;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    public static Comparable t(Comparable comparable, Comparable comparable2, Comparable comparable3) {
        Intrinsics.checkNotNullParameter(comparable, "<this>");
        if (comparable2 == null || comparable3 == null) {
            if (comparable2 != null && comparable.compareTo(comparable2) < 0) {
                return comparable2;
            }
            if (comparable3 != null && comparable.compareTo(comparable3) > 0) {
                return comparable3;
            }
        } else {
            if (comparable2.compareTo(comparable3) > 0) {
                throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + comparable3 + " is less than minimum " + comparable2 + '.');
            }
            if (comparable.compareTo(comparable2) < 0) {
                return comparable2;
            }
            if (comparable.compareTo(comparable3) > 0) {
                return comparable3;
            }
        }
        return comparable;
    }

    public static Comparable u(Comparable comparable, ClosedFloatingPointRange range) {
        Intrinsics.checkNotNullParameter(comparable, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        if (!range.isEmpty()) {
            return (!range.d(comparable, range.a()) || range.d(range.a(), comparable)) ? (!range.d(range.e(), comparable) || range.d(comparable, range.e())) ? comparable : range.e() : range.a();
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    public static IntProgression v(int i3, int i4) {
        return IntProgression.f140210d.a(i3, i4, -1);
    }

    public static int w(IntRange intRange, Random random) {
        Intrinsics.checkNotNullParameter(intRange, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        try {
            return RandomKt.g(random, intRange);
        } catch (IllegalArgumentException e3) {
            throw new NoSuchElementException(e3.getMessage());
        }
    }

    public static long x(LongRange longRange, Random random) {
        Intrinsics.checkNotNullParameter(longRange, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        try {
            return RandomKt.h(random, longRange);
        } catch (IllegalArgumentException e3) {
            throw new NoSuchElementException(e3.getMessage());
        }
    }

    public static IntProgression y(IntProgression intProgression) {
        Intrinsics.checkNotNullParameter(intProgression, "<this>");
        return IntProgression.f140210d.a(intProgression.h(), intProgression.g(), -intProgression.l());
    }

    public static IntProgression z(IntProgression intProgression, int i3) {
        Intrinsics.checkNotNullParameter(intProgression, "<this>");
        RangesKt__RangesKt.a(i3 > 0, Integer.valueOf(i3));
        IntProgression.Companion companion = IntProgression.f140210d;
        int iG = intProgression.g();
        int iH = intProgression.h();
        if (intProgression.l() <= 0) {
            i3 = -i3;
        }
        return companion.a(iG, iH, i3);
    }
}
