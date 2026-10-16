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
final class AddedInsets implements WindowInsets {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WindowInsets f6535b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final WindowInsets f6536c;

    public AddedInsets(WindowInsets windowInsets, WindowInsets windowInsets2) {
        this.f6535b = windowInsets;
        this.f6536c = windowInsets2;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int a(Density density) {
        return this.f6535b.a(density) + this.f6536c.a(density);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int b(Density density, LayoutDirection layoutDirection) {
        return this.f6535b.b(density, layoutDirection) + this.f6536c.b(density, layoutDirection);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int c(Density density) {
        return this.f6535b.c(density) + this.f6536c.c(density);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int d(Density density, LayoutDirection layoutDirection) {
        return this.f6535b.d(density, layoutDirection) + this.f6536c.d(density, layoutDirection);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AddedInsets)) {
            return false;
        }
        AddedInsets addedInsets = (AddedInsets) obj;
        return Intrinsics.areEqual(addedInsets.f6535b, this.f6535b) && Intrinsics.areEqual(addedInsets.f6536c, this.f6536c);
    }

    public int hashCode() {
        return this.f6535b.hashCode() + (this.f6536c.hashCode() * 31);
    }

    public String toString() {
        return '(' + this.f6535b + " + " + this.f6536c + ')';
    }
}
