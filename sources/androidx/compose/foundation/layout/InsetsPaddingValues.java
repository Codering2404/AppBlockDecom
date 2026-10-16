package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
final class InsetsPaddingValues implements PaddingValues {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WindowInsets f6970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Density f6971b;

    public InsetsPaddingValues(WindowInsets windowInsets, Density density) {
        this.f6970a = windowInsets;
        this.f6971b = density;
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    public float a() {
        Density density = this.f6971b;
        return density.F(this.f6970a.c(density));
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    public float b(LayoutDirection layoutDirection) {
        Density density = this.f6971b;
        return density.F(this.f6970a.d(density, layoutDirection));
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    public float c(LayoutDirection layoutDirection) {
        Density density = this.f6971b;
        return density.F(this.f6970a.b(density, layoutDirection));
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    public float d() {
        Density density = this.f6971b;
        return density.F(this.f6970a.a(density));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InsetsPaddingValues)) {
            return false;
        }
        InsetsPaddingValues insetsPaddingValues = (InsetsPaddingValues) obj;
        return Intrinsics.areEqual(this.f6970a, insetsPaddingValues.f6970a) && Intrinsics.areEqual(this.f6971b, insetsPaddingValues.f6971b);
    }

    public int hashCode() {
        return (this.f6970a.hashCode() * 31) + this.f6971b.hashCode();
    }

    public String toString() {
        return "InsetsPaddingValues(insets=" + this.f6970a + ", density=" + this.f6971b + ')';
    }
}
