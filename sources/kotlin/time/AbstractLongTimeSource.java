package kotlin.time;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
@Metadata
public abstract class AbstractLongTimeSource implements TimeSource.WithComparableMarks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DurationUnit f140624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f140625b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class LongTimeMark implements ComparableTimeMark {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f140626a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AbstractLongTimeSource f140627b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f140628c;

        public /* synthetic */ LongTimeMark(long j3, AbstractLongTimeSource abstractLongTimeSource, long j4, DefaultConstructorMarker defaultConstructorMarker) {
            this(j3, abstractLongTimeSource, j4);
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public /* bridge */ int compareTo(ComparableTimeMark comparableTimeMark) {
            return ComparableTimeMark.DefaultImpls.a(this, comparableTimeMark);
        }

        public boolean equals(Object obj) {
            return (obj instanceof LongTimeMark) && Intrinsics.areEqual(this.f140627b, ((LongTimeMark) obj).f140627b) && Duration.k(j0((ComparableTimeMark) obj), Duration.f140631b.c());
        }

        public int hashCode() {
            return (Duration.y(this.f140628c) * 37) + Long.hashCode(this.f140626a);
        }

        @Override // kotlin.time.ComparableTimeMark
        public long j0(ComparableTimeMark other) {
            Intrinsics.checkNotNullParameter(other, "other");
            if (other instanceof LongTimeMark) {
                LongTimeMark longTimeMark = (LongTimeMark) other;
                if (Intrinsics.areEqual(this.f140627b, longTimeMark.f140627b)) {
                    return Duration.G(LongSaturatedMathKt.c(this.f140626a, longTimeMark.f140626a, this.f140627b.c()), Duration.F(this.f140628c, longTimeMark.f140628c));
                }
            }
            throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + this + " and " + other);
        }

        public String toString() {
            return "LongTimeMark(" + this.f140626a + DurationUnitKt__DurationUnitKt.f(this.f140627b.c()) + " + " + ((Object) Duration.Q(this.f140628c)) + ", " + this.f140627b + ')';
        }

        private LongTimeMark(long j3, AbstractLongTimeSource timeSource, long j4) {
            Intrinsics.checkNotNullParameter(timeSource, "timeSource");
            this.f140626a = j3;
            this.f140627b = timeSource;
            this.f140628c = j4;
        }
    }

    public AbstractLongTimeSource(DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        this.f140624a = unit;
        this.f140625b = LazyKt.b(new Function0() { // from class: kotlin.time.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(AbstractLongTimeSource.g(this.f140679a));
            }
        });
    }

    private final long b() {
        return f() - d();
    }

    private final long d() {
        return ((Number) this.f140625b.getValue()).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long g(AbstractLongTimeSource abstractLongTimeSource) {
        return abstractLongTimeSource.f();
    }

    protected final DurationUnit c() {
        return this.f140624a;
    }

    public ComparableTimeMark e() {
        return new LongTimeMark(b(), this, Duration.f140631b.c(), null);
    }

    protected abstract long f();
}
