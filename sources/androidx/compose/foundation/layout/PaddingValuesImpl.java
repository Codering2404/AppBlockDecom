package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class PaddingValuesImpl implements PaddingValues {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f7071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f7072b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f7073c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f7074d;

    public /* synthetic */ PaddingValuesImpl(float f3, float f4, float f5, float f6, DefaultConstructorMarker defaultConstructorMarker) {
        this(f3, f4, f5, f6);
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    public float a() {
        return this.f7074d;
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    public float b(LayoutDirection layoutDirection) {
        return layoutDirection == LayoutDirection.f30001a ? this.f7071a : this.f7073c;
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    public float c(LayoutDirection layoutDirection) {
        return layoutDirection == LayoutDirection.f30001a ? this.f7073c : this.f7071a;
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    public float d() {
        return this.f7072b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PaddingValuesImpl)) {
            return false;
        }
        PaddingValuesImpl paddingValuesImpl = (PaddingValuesImpl) obj;
        return Dp.i(this.f7071a, paddingValuesImpl.f7071a) && Dp.i(this.f7072b, paddingValuesImpl.f7072b) && Dp.i(this.f7073c, paddingValuesImpl.f7073c) && Dp.i(this.f7074d, paddingValuesImpl.f7074d);
    }

    public int hashCode() {
        return (((((Dp.j(this.f7071a) * 31) + Dp.j(this.f7072b)) * 31) + Dp.j(this.f7073c)) * 31) + Dp.j(this.f7074d);
    }

    public String toString() {
        return "PaddingValues(start=" + ((Object) Dp.k(this.f7071a)) + ", top=" + ((Object) Dp.k(this.f7072b)) + ", end=" + ((Object) Dp.k(this.f7073c)) + ", bottom=" + ((Object) Dp.k(this.f7074d)) + ')';
    }

    private PaddingValuesImpl(float f3, float f4, float f5, float f6) {
        this.f7071a = f3;
        this.f7072b = f4;
        this.f7073c = f5;
        this.f7074d = f6;
        if (!((f3 >= 0.0f) & (f4 >= 0.0f) & (f5 >= 0.0f)) || !(f6 >= 0.0f)) {
            InlineClassHelperKt.a("Padding must be non-negative");
        }
    }
}
