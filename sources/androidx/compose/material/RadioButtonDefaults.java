package androidx.compose.material;

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
public final class RadioButtonDefaults {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final RadioButtonDefaults f13585a = new RadioButtonDefaults();

    private RadioButtonDefaults() {
    }

    public final RadioButtonColors a(long j3, long j4, long j5, Composer composer, int i3, int i4) {
        long jL = (i4 & 1) != 0 ? MaterialTheme.f13091a.a(composer, 6).l() : j3;
        long jR = (i4 & 2) != 0 ? Color.r(MaterialTheme.f13091a.a(composer, 6).i(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null) : j4;
        long jR2 = (i4 & 4) != 0 ? Color.r(MaterialTheme.f13091a.a(composer, 6).i(), ContentAlpha.f12529a.b(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j5;
        if (ComposerKt.M()) {
            ComposerKt.U(1370708026, i3, -1, "androidx.compose.material.RadioButtonDefaults.colors (RadioButton.kt:165)");
        }
        boolean z2 = (((6 ^ (i3 & 14)) > 4 && composer.f(jL)) || (i3 & 6) == 4) | ((((i3 & 112) ^ 48) > 32 && composer.f(jR)) || (i3 & 48) == 32) | ((((i3 & 896) ^ 384) > 256 && composer.f(jR2)) || (i3 & 384) == 256);
        Object objG = composer.G();
        if (z2 || objG == Composer.f23746a.a()) {
            DefaultRadioButtonColors defaultRadioButtonColors = new DefaultRadioButtonColors(jL, jR, jR2, null);
            composer.w(defaultRadioButtonColors);
            objG = defaultRadioButtonColors;
        }
        DefaultRadioButtonColors defaultRadioButtonColors2 = (DefaultRadioButtonColors) objG;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return defaultRadioButtonColors2;
    }
}
