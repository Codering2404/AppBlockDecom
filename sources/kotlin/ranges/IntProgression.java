package kotlin.ranges;

import com.facebook.FacebookContentProvider;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
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
public class IntProgression implements Iterable<Integer>, KMappedMarker {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f140210d = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f140211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f140212b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f140213c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final IntProgression a(int i3, int i4, int i5) {
            return new IntProgression(i3, i4, i5);
        }

        private Companion() {
        }
    }

    public IntProgression(int i3, int i4, int i5) {
        if (i5 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i5 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f140211a = i3;
        this.f140212b = ProgressionUtilKt.c(i3, i4, i5);
        this.f140213c = i5;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof IntProgression)) {
            return false;
        }
        if (isEmpty() && ((IntProgression) obj).isEmpty()) {
            return true;
        }
        IntProgression intProgression = (IntProgression) obj;
        return this.f140211a == intProgression.f140211a && this.f140212b == intProgression.f140212b && this.f140213c == intProgression.f140213c;
    }

    public final int g() {
        return this.f140211a;
    }

    public final int h() {
        return this.f140212b;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f140211a * 31) + this.f140212b) * 31) + this.f140213c;
    }

    public boolean isEmpty() {
        return this.f140213c > 0 ? this.f140211a > this.f140212b : this.f140211a < this.f140212b;
    }

    public final int l() {
        return this.f140213c;
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public IntIterator iterator() {
        return new IntProgressionIterator(this.f140211a, this.f140212b, this.f140213c);
    }

    public String toString() {
        StringBuilder sb;
        int i3;
        if (this.f140213c > 0) {
            sb = new StringBuilder();
            sb.append(this.f140211a);
            sb.append(FacebookContentProvider.INVALID_FILE_NAME);
            sb.append(this.f140212b);
            sb.append(" step ");
            i3 = this.f140213c;
        } else {
            sb = new StringBuilder();
            sb.append(this.f140211a);
            sb.append(" downTo ");
            sb.append(this.f140212b);
            sb.append(" step ");
            i3 = -this.f140213c;
        }
        sb.append(i3);
        return sb.toString();
    }
}
