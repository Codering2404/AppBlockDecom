package kotlin.ranges;

import com.facebook.FacebookContentProvider;
import kotlin.Metadata;
import kotlin.collections.LongIterator;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

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
public class LongProgression implements Iterable<Long>, KMappedMarker {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f140220d = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f140221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f140222b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f140223c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LongProgression a(long j3, long j4, long j5) {
            return new LongProgression(j3, j4, j5);
        }

        private Companion() {
        }
    }

    public LongProgression(long j3, long j4, long j5) {
        if (j5 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j5 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.f140221a = j3;
        this.f140222b = ProgressionUtilKt.d(j3, j4, j5);
        this.f140223c = j5;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LongProgression)) {
            return false;
        }
        if (isEmpty() && ((LongProgression) obj).isEmpty()) {
            return true;
        }
        LongProgression longProgression = (LongProgression) obj;
        return this.f140221a == longProgression.f140221a && this.f140222b == longProgression.f140222b && this.f140223c == longProgression.f140223c;
    }

    public final long g() {
        return this.f140221a;
    }

    public final long h() {
        return this.f140222b;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        long j3 = 31;
        long j4 = this.f140221a;
        long j5 = this.f140222b;
        long j6 = j3 * (((j4 ^ (j4 >>> 32)) * j3) + (j5 ^ (j5 >>> 32)));
        long j7 = this.f140223c;
        return (int) (j6 + (j7 ^ (j7 >>> 32)));
    }

    public boolean isEmpty() {
        long j3 = this.f140223c;
        long j4 = this.f140221a;
        long j5 = this.f140222b;
        return j3 > 0 ? j4 > j5 : j4 < j5;
    }

    public final long l() {
        return this.f140223c;
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public LongIterator iterator() {
        return new LongProgressionIterator(this.f140221a, this.f140222b, this.f140223c);
    }

    public String toString() {
        StringBuilder sb;
        long j3;
        if (this.f140223c > 0) {
            sb = new StringBuilder();
            sb.append(this.f140221a);
            sb.append(FacebookContentProvider.INVALID_FILE_NAME);
            sb.append(this.f140222b);
            sb.append(" step ");
            j3 = this.f140223c;
        } else {
            sb = new StringBuilder();
            sb.append(this.f140221a);
            sb.append(" downTo ");
            sb.append(this.f140222b);
            sb.append(" step ");
            j3 = -this.f140223c;
        }
        sb.append(j3);
        return sb.toString();
    }
}
