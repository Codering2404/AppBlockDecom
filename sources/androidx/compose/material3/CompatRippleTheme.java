package androidx.compose.material3;

import androidx.compose.material.ripple.RippleAlpha;
import androidx.compose.material.ripple.RippleTheme;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
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
public final class CompatRippleTheme implements RippleTheme {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CompatRippleTheme f16672b = new CompatRippleTheme();

    private CompatRippleTheme() {
    }

    @Override // androidx.compose.material.ripple.RippleTheme
    public long a(Composer composer, int i3) {
        composer.a0(-1844533201);
        if (ComposerKt.M()) {
            ComposerKt.U(-1844533201, i3, -1, "androidx.compose.material3.CompatRippleTheme.defaultColor (Ripple.kt:244)");
        }
        long jB = ((Color) composer.q(ContentColorKt.a())).B();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return jB;
    }

    @Override // androidx.compose.material.ripple.RippleTheme
    public RippleAlpha b(Composer composer, int i3) {
        composer.a0(-290975286);
        if (ComposerKt.M()) {
            ComposerKt.U(-290975286, i3, -1, "androidx.compose.material3.CompatRippleTheme.rippleAlpha (Ripple.kt:248)");
        }
        RippleAlpha rippleAlphaA = RippleDefaults.f19379a.a();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return rippleAlphaA;
    }
}
