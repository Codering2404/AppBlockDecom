package androidx.compose.material;

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
    public static final CompatRippleTheme f12488b = new CompatRippleTheme();

    private CompatRippleTheme() {
    }

    @Override // androidx.compose.material.ripple.RippleTheme
    public long a(Composer composer, int i3) {
        composer.a0(-1599906584);
        if (ComposerKt.M()) {
            ComposerKt.U(-1599906584, i3, -1, "androidx.compose.material.CompatRippleTheme.defaultColor (Ripple.kt:279)");
        }
        long jB = RippleDefaults.f13616a.b(((Color) composer.q(ContentColorKt.a())).B(), MaterialTheme.f13091a.a(composer, 6).o());
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return jB;
    }

    @Override // androidx.compose.material.ripple.RippleTheme
    public RippleAlpha b(Composer composer, int i3) {
        composer.a0(112776173);
        if (ComposerKt.M()) {
            ComposerKt.U(112776173, i3, -1, "androidx.compose.material.CompatRippleTheme.rippleAlpha (Ripple.kt:286)");
        }
        RippleAlpha rippleAlphaA = RippleDefaults.f13616a.a(((Color) composer.q(ContentColorKt.a())).B(), MaterialTheme.f13091a.a(composer, 6).o());
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return rippleAlphaA;
    }
}
