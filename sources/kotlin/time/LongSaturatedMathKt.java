package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
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
public final class LongSaturatedMathKt {
    private static final long a(long j3) {
        return j3 < 0 ? Duration.f140631b.b() : Duration.f140631b.a();
    }

    private static final long b(long j3, long j4, DurationUnit durationUnit) {
        long j5 = j3 - j4;
        if (((j5 ^ j3) & (~(j5 ^ j4))) >= 0) {
            return DurationKt.t(j5, durationUnit);
        }
        DurationUnit durationUnit2 = DurationUnit.f140640d;
        if (durationUnit.compareTo(durationUnit2) >= 0) {
            return Duration.R(a(j5));
        }
        long jB = DurationUnitKt__DurationUnitJvmKt.b(1L, durationUnit2, durationUnit);
        long j6 = (j3 / jB) - (j4 / jB);
        long j7 = (j3 % jB) - (j4 % jB);
        Duration.Companion companion = Duration.f140631b;
        return Duration.G(DurationKt.t(j6, durationUnit2), DurationKt.t(j7, durationUnit));
    }

    public static final long c(long j3, long j4, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return ((j4 - 1) | 1) == Long.MAX_VALUE ? j3 == j4 ? Duration.f140631b.c() : Duration.R(a(j4)) : (1 | (j3 - 1)) == Long.MAX_VALUE ? a(j3) : b(j3, j4, unit);
    }
}
