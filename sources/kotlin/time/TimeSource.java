package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.ComparableTimeMark;

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
public interface TimeSource {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f140666a = new Companion();

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface WithComparableMarks extends TimeSource {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Monotonic implements WithComparableMarks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Monotonic f140667a = new Monotonic();

        private Monotonic() {
        }

        public long a() {
            return MonotonicTimeSource.f140663a.b();
        }

        public String toString() {
            return MonotonicTimeSource.f140663a.toString();
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @JvmInline
        public static final class ValueTimeMark implements ComparableTimeMark {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final long f140668a;

            public static boolean c(long j3, Object obj) {
                return (obj instanceof ValueTimeMark) && j3 == ((ValueTimeMark) obj).h();
            }

            public static int d(long j3) {
                return Long.hashCode(j3);
            }

            public static final long e(long j3, long j4) {
                return MonotonicTimeSource.f140663a.a(j3, j4);
            }

            public static long f(long j3, ComparableTimeMark other) {
                Intrinsics.checkNotNullParameter(other, "other");
                if (other instanceof ValueTimeMark) {
                    return e(j3, ((ValueTimeMark) other).h());
                }
                throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + ((Object) g(j3)) + " and " + other);
            }

            public static String g(long j3) {
                return "ValueTimeMark(reading=" + j3 + ')';
            }

            @Override // java.lang.Comparable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public /* bridge */ int compareTo(ComparableTimeMark comparableTimeMark) {
                return ComparableTimeMark.DefaultImpls.a(this, comparableTimeMark);
            }

            public boolean equals(Object obj) {
                return c(this.f140668a, obj);
            }

            public final /* synthetic */ long h() {
                return this.f140668a;
            }

            public int hashCode() {
                return d(this.f140668a);
            }

            @Override // kotlin.time.ComparableTimeMark
            public long j0(ComparableTimeMark other) {
                Intrinsics.checkNotNullParameter(other, "other");
                return f(this.f140668a, other);
            }

            public String toString() {
                return g(this.f140668a);
            }

            public static long b(long j3) {
                return j3;
            }
        }
    }
}
