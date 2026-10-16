package cz.mobilesoft.coreblock.view.compose.material3;

import androidx.compose.material3.SwitchColors;
import androidx.compose.material3.SwitchDefaults;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class SwitchKt {
    public static final SwitchColors a(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(117145314, i3, -1, "cz.mobilesoft.coreblock.view.compose.material3.AppBlockSwitchColors (Switch.kt:8)");
        }
        SwitchColors switchColorsA = SwitchDefaults.f20446a.a(composer, SwitchDefaults.f20448c);
        long jQ0 = ComposeColorsKt.j(composer, 0).q0();
        long jB = ComposeColorsKt.j(composer, 0).b();
        long jB2 = ComposeColorsKt.j(composer, 0).b();
        long jB3 = ComposeColorsKt.j(composer, 0).b();
        long jQ = ComposeColorsKt.j(composer, 0).q();
        long jW = ComposeColorsKt.j(composer, 0).W();
        long jQ2 = ComposeColorsKt.j(composer, 0).q();
        long jW2 = ComposeColorsKt.j(composer, 0).W();
        long jW3 = ComposeColorsKt.j(composer, 0).W();
        Color.Companion companion = Color.f25715b;
        SwitchColors switchColorsB = switchColorsA.b(jQ0, jB, jB2, jB3, jQ, jW, jQ2, jW2, jW3, Color.r(ComposeColorsKt.j(composer, 0).p(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), companion.j(), ComposeColorsKt.j(composer, 0).l0(), Color.r(ComposeColorsKt.j(composer, 0).p(), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), companion.j(), Color.r(ComposeColorsKt.j(composer, 0).p(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), Color.r(ComposeColorsKt.j(composer, 0).p(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return switchColorsB;
    }
}
