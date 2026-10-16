package androidx.glance;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.glance.unit.ColorProvider;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class ButtonDefaults {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ButtonDefaults f37530a = new ButtonDefaults();

    private ButtonDefaults() {
    }

    public final ButtonColors a(ColorProvider colorProvider, ColorProvider colorProvider2, Composer composer, int i3, int i4) {
        composer.F(207135993);
        if ((i4 & 1) != 0) {
            colorProvider = GlanceTheme.f37608a.a(composer, 6).g();
        }
        if ((i4 & 2) != 0) {
            colorProvider2 = GlanceTheme.f37608a.a(composer, 6).c();
        }
        if (ComposerKt.M()) {
            ComposerKt.U(207135993, i3, -1, "androidx.glance.ButtonDefaults.buttonColors (Button.kt:198)");
        }
        ButtonColors buttonColors = new ButtonColors(colorProvider, colorProvider2);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.Y();
        return buttonColors;
    }
}
