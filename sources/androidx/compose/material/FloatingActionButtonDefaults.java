package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
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
public final class FloatingActionButtonDefaults {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FloatingActionButtonDefaults f12951a = new FloatingActionButtonDefaults();

    private FloatingActionButtonDefaults() {
    }

    public final FloatingActionButtonElevation a(float f3, float f4, float f5, float f6, Composer composer, int i3, int i4) {
        if ((i4 & 1) != 0) {
            f3 = Dp.g(6);
        }
        float f7 = f3;
        if ((i4 & 2) != 0) {
            f4 = Dp.g(12);
        }
        float f8 = f4;
        if ((i4 & 4) != 0) {
            f5 = Dp.g(8);
        }
        float f9 = f5;
        if ((i4 & 8) != 0) {
            f6 = Dp.g(8);
        }
        float f10 = f6;
        if (ComposerKt.M()) {
            ComposerKt.U(380403812, i3, -1, "androidx.compose.material.FloatingActionButtonDefaults.elevation (FloatingActionButton.kt:248)");
        }
        boolean z2 = ((((i3 & 14) ^ 6) > 4 && composer.c(f7)) || (i3 & 6) == 4) | ((((i3 & 112) ^ 48) > 32 && composer.c(f8)) || (i3 & 48) == 32) | ((((i3 & 896) ^ 384) > 256 && composer.c(f9)) || (i3 & 384) == 256) | ((((i3 & 7168) ^ 3072) > 2048 && composer.c(f10)) || (i3 & 3072) == 2048);
        Object objG = composer.G();
        if (z2 || objG == Composer.f23746a.a()) {
            DefaultFloatingActionButtonElevation defaultFloatingActionButtonElevation = new DefaultFloatingActionButtonElevation(f7, f8, f9, f10, null);
            composer.w(defaultFloatingActionButtonElevation);
            objG = defaultFloatingActionButtonElevation;
        }
        DefaultFloatingActionButtonElevation defaultFloatingActionButtonElevation2 = (DefaultFloatingActionButtonElevation) objG;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return defaultFloatingActionButtonElevation2;
    }
}
