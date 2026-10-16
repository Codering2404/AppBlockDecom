package androidx.compose.foundation.layout;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class MutableWindowInsets implements WindowInsets {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableState f7010b;

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int a(Density density) {
        return e().a(density);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int b(Density density, LayoutDirection layoutDirection) {
        return e().b(density, layoutDirection);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int c(Density density) {
        return e().c(density);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int d(Density density, LayoutDirection layoutDirection) {
        return e().d(density, layoutDirection);
    }

    public final WindowInsets e() {
        return (WindowInsets) this.f7010b.getValue();
    }
}
