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
final class UnionInsets implements WindowInsets {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WindowInsets f7160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final WindowInsets f7161c;

    public UnionInsets(WindowInsets windowInsets, WindowInsets windowInsets2) {
        this.f7160b = windowInsets;
        this.f7161c = windowInsets2;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int a(Density density) {
        return Math.max(this.f7160b.a(density), this.f7161c.a(density));
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int b(Density density, LayoutDirection layoutDirection) {
        return Math.max(this.f7160b.b(density, layoutDirection), this.f7161c.b(density, layoutDirection));
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int c(Density density) {
        return Math.max(this.f7160b.c(density), this.f7161c.c(density));
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int d(Density density, LayoutDirection layoutDirection) {
        return Math.max(this.f7160b.d(density, layoutDirection), this.f7161c.d(density, layoutDirection));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UnionInsets)) {
            return false;
        }
        UnionInsets unionInsets = (UnionInsets) obj;
        return Intrinsics.areEqual(unionInsets.f7160b, this.f7160b) && Intrinsics.areEqual(unionInsets.f7161c, this.f7161c);
    }

    public int hashCode() {
        return this.f7160b.hashCode() + (this.f7161c.hashCode() * 31);
    }

    public String toString() {
        return '(' + this.f7160b + " ∪ " + this.f7161c + ')';
    }
}
