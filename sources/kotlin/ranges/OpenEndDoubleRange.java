package kotlin.ranges;

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
final class OpenEndDoubleRange implements OpenEndRange<Double> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final double f140230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final double f140231b;

    public OpenEndDoubleRange(double d3, double d4) {
        this.f140230a = d3;
        this.f140231b = d4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.ranges.OpenEndRange
    public /* bridge */ /* synthetic */ boolean b(Comparable comparable) {
        return c(((Number) comparable).doubleValue());
    }

    public boolean c(double d3) {
        return d3 >= this.f140230a && d3 < this.f140231b;
    }

    @Override // kotlin.ranges.OpenEndRange
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Double f() {
        return Double.valueOf(this.f140231b);
    }

    @Override // kotlin.ranges.OpenEndRange
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public Double a() {
        return Double.valueOf(this.f140230a);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof OpenEndDoubleRange)) {
            return false;
        }
        if (g() && ((OpenEndDoubleRange) obj).g()) {
            return true;
        }
        OpenEndDoubleRange openEndDoubleRange = (OpenEndDoubleRange) obj;
        return this.f140230a == openEndDoubleRange.f140230a && this.f140231b == openEndDoubleRange.f140231b;
    }

    public boolean g() {
        return this.f140230a >= this.f140231b;
    }

    public int hashCode() {
        if (g()) {
            return -1;
        }
        return (Double.hashCode(this.f140230a) * 31) + Double.hashCode(this.f140231b);
    }

    public String toString() {
        return this.f140230a + "..<" + this.f140231b;
    }
}
