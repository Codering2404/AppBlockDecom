package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
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
final class PaddingValuesInsets implements WindowInsets {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PaddingValues f7075b;

    public PaddingValuesInsets(PaddingValues paddingValues) {
        this.f7075b = paddingValues;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int a(Density density) {
        return density.z0(this.f7075b.d());
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int b(Density density, LayoutDirection layoutDirection) {
        return density.z0(this.f7075b.c(layoutDirection));
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int c(Density density) {
        return density.z0(this.f7075b.a());
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int d(Density density, LayoutDirection layoutDirection) {
        return density.z0(this.f7075b.b(layoutDirection));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PaddingValuesInsets) {
            return Intrinsics.areEqual(((PaddingValuesInsets) obj).f7075b, this.f7075b);
        }
        return false;
    }

    public int hashCode() {
        return this.f7075b.hashCode();
    }

    public String toString() {
        LayoutDirection layoutDirection = LayoutDirection.f30001a;
        return "PaddingValues(" + ((Object) Dp.k(this.f7075b.b(layoutDirection))) + ", " + ((Object) Dp.k(this.f7075b.d())) + ", " + ((Object) Dp.k(this.f7075b.c(layoutDirection))) + ", " + ((Object) Dp.k(this.f7075b.a())) + ')';
    }
}
