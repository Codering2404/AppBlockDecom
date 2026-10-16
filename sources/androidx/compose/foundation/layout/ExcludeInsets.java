package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

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
final class ExcludeInsets implements WindowInsets {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WindowInsets f6762b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final WindowInsets f6763c;

    public ExcludeInsets(WindowInsets windowInsets, WindowInsets windowInsets2) {
        this.f6762b = windowInsets;
        this.f6763c = windowInsets2;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int a(Density density) {
        return RangesKt.f(this.f6762b.a(density) - this.f6763c.a(density), 0);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int b(Density density, LayoutDirection layoutDirection) {
        return RangesKt.f(this.f6762b.b(density, layoutDirection) - this.f6763c.b(density, layoutDirection), 0);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int c(Density density) {
        return RangesKt.f(this.f6762b.c(density) - this.f6763c.c(density), 0);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int d(Density density, LayoutDirection layoutDirection) {
        return RangesKt.f(this.f6762b.d(density, layoutDirection) - this.f6763c.d(density, layoutDirection), 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExcludeInsets)) {
            return false;
        }
        ExcludeInsets excludeInsets = (ExcludeInsets) obj;
        return Intrinsics.areEqual(excludeInsets.f6762b, this.f6762b) && Intrinsics.areEqual(excludeInsets.f6763c, this.f6763c);
    }

    public int hashCode() {
        return (this.f6762b.hashCode() * 31) + this.f6763c.hashCode();
    }

    public String toString() {
        return '(' + this.f6762b + " - " + this.f6763c + ')';
    }
}
