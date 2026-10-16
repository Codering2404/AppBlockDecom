package kotlin.time;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.ComparableTimeMark;
import kotlin.time.TimeSource;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Deprecated
@Metadata
public abstract class AbstractDoubleTimeSource implements TimeSource.WithComparableMarks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DurationUnit f140620a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class DoubleTimeMark implements ComparableTimeMark {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final double f140621a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AbstractDoubleTimeSource f140622b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f140623c;

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public /* bridge */ int compareTo(ComparableTimeMark comparableTimeMark) {
            return ComparableTimeMark.DefaultImpls.a(this, comparableTimeMark);
        }

        public boolean equals(Object obj) {
            return (obj instanceof DoubleTimeMark) && Intrinsics.areEqual(this.f140622b, ((DoubleTimeMark) obj).f140622b) && Duration.k(j0((ComparableTimeMark) obj), Duration.f140631b.c());
        }

        public int hashCode() {
            return Duration.y(Duration.G(DurationKt.r(this.f140621a, this.f140622b.a()), this.f140623c));
        }

        @Override // kotlin.time.ComparableTimeMark
        public long j0(ComparableTimeMark other) {
            Intrinsics.checkNotNullParameter(other, "other");
            if (other instanceof DoubleTimeMark) {
                DoubleTimeMark doubleTimeMark = (DoubleTimeMark) other;
                if (Intrinsics.areEqual(this.f140622b, doubleTimeMark.f140622b)) {
                    if (Duration.k(this.f140623c, doubleTimeMark.f140623c) && Duration.C(this.f140623c)) {
                        return Duration.f140631b.c();
                    }
                    long jF = Duration.F(this.f140623c, doubleTimeMark.f140623c);
                    long jR = DurationKt.r(this.f140621a - doubleTimeMark.f140621a, this.f140622b.a());
                    return Duration.k(jR, Duration.R(jF)) ? Duration.f140631b.c() : Duration.G(jR, jF);
                }
            }
            throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + this + " and " + other);
        }

        public String toString() {
            return "DoubleTimeMark(" + this.f140621a + DurationUnitKt__DurationUnitKt.f(this.f140622b.a()) + " + " + ((Object) Duration.Q(this.f140623c)) + ", " + this.f140622b + ')';
        }
    }

    protected final DurationUnit a() {
        return this.f140620a;
    }
}
