package androidx.compose.ui.unit;

import androidx.compose.ui.unit.fontscaling.FontScaleConverter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
final class DensityWithConverter implements Density {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f29967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f29968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final FontScaleConverter f29969c;

    public DensityWithConverter(float f3, float f4, FontScaleConverter fontScaleConverter) {
        this.f29967a = f3;
        this.f29968b = f4;
        this.f29969c = fontScaleConverter;
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public float K1() {
        return this.f29968b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DensityWithConverter)) {
            return false;
        }
        DensityWithConverter densityWithConverter = (DensityWithConverter) obj;
        return Float.compare(this.f29967a, densityWithConverter.f29967a) == 0 && Float.compare(this.f29968b, densityWithConverter.f29968b) == 0 && Intrinsics.areEqual(this.f29969c, densityWithConverter.f29969c);
    }

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return this.f29967a;
    }

    public int hashCode() {
        return (((Float.hashCode(this.f29967a) * 31) + Float.hashCode(this.f29968b)) * 31) + this.f29969c.hashCode();
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public long n(float f3) {
        return TextUnitKt.h(this.f29969c.a(f3));
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public float q(long j3) {
        if (TextUnitType.g(TextUnit.g(j3), TextUnitType.f30010b.b())) {
            return Dp.g(this.f29969c.b(TextUnit.h(j3)));
        }
        throw new IllegalStateException("Only Sp can convert to Px");
    }

    public String toString() {
        return "DensityWithConverter(density=" + this.f29967a + ", fontScale=" + this.f29968b + ", converter=" + this.f29969c + ')';
    }
}
