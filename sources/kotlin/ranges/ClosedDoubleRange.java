package kotlin.ranges;

import com.facebook.FacebookContentProvider;
import kotlin.Metadata;

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
final class ClosedDoubleRange implements ClosedFloatingPointRange<Double> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final double f140202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final double f140203b;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.ranges.ClosedFloatingPointRange
    public /* bridge */ /* synthetic */ boolean b(Comparable comparable) {
        return c(((Number) comparable).doubleValue());
    }

    public boolean c(double d3) {
        return d3 >= this.f140202a && d3 <= this.f140203b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.ranges.ClosedFloatingPointRange
    public /* bridge */ /* synthetic */ boolean d(Comparable comparable, Comparable comparable2) {
        return h(((Number) comparable).doubleValue(), ((Number) comparable2).doubleValue());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ClosedDoubleRange)) {
            return false;
        }
        if (isEmpty() && ((ClosedDoubleRange) obj).isEmpty()) {
            return true;
        }
        ClosedDoubleRange closedDoubleRange = (ClosedDoubleRange) obj;
        return this.f140202a == closedDoubleRange.f140202a && this.f140203b == closedDoubleRange.f140203b;
    }

    @Override // kotlin.ranges.ClosedRange
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Double e() {
        return Double.valueOf(this.f140203b);
    }

    @Override // kotlin.ranges.ClosedRange
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public Double a() {
        return Double.valueOf(this.f140202a);
    }

    public boolean h(double d3, double d4) {
        return d3 <= d4;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Double.hashCode(this.f140202a) * 31) + Double.hashCode(this.f140203b);
    }

    @Override // kotlin.ranges.ClosedFloatingPointRange, kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        return this.f140202a > this.f140203b;
    }

    public String toString() {
        return this.f140202a + FacebookContentProvider.INVALID_FILE_NAME + this.f140203b;
    }
}
