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
final class ClosedFloatRange implements ClosedFloatingPointRange<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f140204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f140205b;

    public ClosedFloatRange(float f3, float f4) {
        this.f140204a = f3;
        this.f140205b = f4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.ranges.ClosedFloatingPointRange
    public /* bridge */ /* synthetic */ boolean b(Comparable comparable) {
        return c(((Number) comparable).floatValue());
    }

    public boolean c(float f3) {
        return f3 >= this.f140204a && f3 <= this.f140205b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.ranges.ClosedFloatingPointRange
    public /* bridge */ /* synthetic */ boolean d(Comparable comparable, Comparable comparable2) {
        return h(((Number) comparable).floatValue(), ((Number) comparable2).floatValue());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ClosedFloatRange)) {
            return false;
        }
        if (isEmpty() && ((ClosedFloatRange) obj).isEmpty()) {
            return true;
        }
        ClosedFloatRange closedFloatRange = (ClosedFloatRange) obj;
        return this.f140204a == closedFloatRange.f140204a && this.f140205b == closedFloatRange.f140205b;
    }

    @Override // kotlin.ranges.ClosedRange
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Float e() {
        return Float.valueOf(this.f140205b);
    }

    @Override // kotlin.ranges.ClosedRange
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public Float a() {
        return Float.valueOf(this.f140204a);
    }

    public boolean h(float f3, float f4) {
        return f3 <= f4;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Float.hashCode(this.f140204a) * 31) + Float.hashCode(this.f140205b);
    }

    @Override // kotlin.ranges.ClosedFloatingPointRange, kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        return this.f140204a > this.f140205b;
    }

    public String toString() {
        return this.f140204a + FacebookContentProvider.INVALID_FILE_NAME + this.f140205b;
    }
}
