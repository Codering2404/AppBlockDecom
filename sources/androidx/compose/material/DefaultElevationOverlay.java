package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
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
final class DefaultElevationOverlay implements ElevationOverlay {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DefaultElevationOverlay f12571a = new DefaultElevationOverlay();

    private DefaultElevationOverlay() {
    }

    @Override // androidx.compose.material.ElevationOverlay
    public long a(long j3, float f3, Composer composer, int i3) {
        composer.a0(-1687113661);
        if (ComposerKt.M()) {
            ComposerKt.U(-1687113661, i3, -1, "androidx.compose.material.DefaultElevationOverlay.apply (ElevationOverlay.kt:68)");
        }
        Colors colorsA = MaterialTheme.f13091a.a(composer, 6);
        if (Dp.f(f3, Dp.g(0)) <= 0 || colorsA.o()) {
            composer.a0(1169152471);
            composer.U();
        } else {
            composer.a0(1169013963);
            j3 = ColorKt.h(ElevationOverlayKt.b(j3, f3, composer, i3 & 126), j3);
            composer.U();
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return j3;
    }
}
