package kotlin.random;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongRange;

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
public final class RandomKt {
    public static final Random a(long j3) {
        return new XorWowRandom((int) j3, (int) (j3 >> 32));
    }

    public static final String b(Object from, Object until) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(until, "until");
        return "Random range is empty: [" + from + ", " + until + ").";
    }

    public static final void c(double d3, double d4) {
        if (d4 <= d3) {
            throw new IllegalArgumentException(b(Double.valueOf(d3), Double.valueOf(d4)).toString());
        }
    }

    public static final void d(int i3, int i4) {
        if (i4 <= i3) {
            throw new IllegalArgumentException(b(Integer.valueOf(i3), Integer.valueOf(i4)).toString());
        }
    }

    public static final void e(long j3, long j4) {
        if (j4 <= j3) {
            throw new IllegalArgumentException(b(Long.valueOf(j3), Long.valueOf(j4)).toString());
        }
    }

    public static final int f(int i3) {
        return 31 - Integer.numberOfLeadingZeros(i3);
    }

    public static final int g(Random random, IntRange range) {
        Intrinsics.checkNotNullParameter(random, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        if (!range.isEmpty()) {
            return range.h() < Integer.MAX_VALUE ? random.k(range.g(), range.h() + 1) : range.g() > Integer.MIN_VALUE ? random.k(range.g() - 1, range.h()) + 1 : random.i();
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + range);
    }

    public static final long h(Random random, LongRange range) {
        Intrinsics.checkNotNullParameter(random, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        if (!range.isEmpty()) {
            return range.h() < Long.MAX_VALUE ? random.m(range.g(), range.h() + 1) : range.g() > Long.MIN_VALUE ? random.m(range.g() - 1, range.h()) + 1 : random.l();
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + range);
    }

    public static final int i(int i3, int i4) {
        return (i3 >>> (32 - i4)) & ((-i4) >> 31);
    }
}
