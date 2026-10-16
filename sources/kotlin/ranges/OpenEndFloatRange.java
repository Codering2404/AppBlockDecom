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
final class OpenEndFloatRange implements OpenEndRange<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f140232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f140233b;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.ranges.OpenEndRange
    public /* bridge */ /* synthetic */ boolean b(Comparable comparable) {
        return c(((Number) comparable).floatValue());
    }

    public boolean c(float f3) {
        return f3 >= this.f140232a && f3 < this.f140233b;
    }

    @Override // kotlin.ranges.OpenEndRange
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Float f() {
        return Float.valueOf(this.f140233b);
    }

    @Override // kotlin.ranges.OpenEndRange
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public Float a() {
        return Float.valueOf(this.f140232a);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof OpenEndFloatRange)) {
            return false;
        }
        if (g() && ((OpenEndFloatRange) obj).g()) {
            return true;
        }
        OpenEndFloatRange openEndFloatRange = (OpenEndFloatRange) obj;
        return this.f140232a == openEndFloatRange.f140232a && this.f140233b == openEndFloatRange.f140233b;
    }

    public boolean g() {
        return this.f140232a >= this.f140233b;
    }

    public int hashCode() {
        if (g()) {
            return -1;
        }
        return (Float.hashCode(this.f140232a) * 31) + Float.hashCode(this.f140233b);
    }

    public String toString() {
        return this.f140232a + "..<" + this.f140233b;
    }
}
