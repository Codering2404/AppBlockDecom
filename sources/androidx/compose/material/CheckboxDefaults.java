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
public final class CheckboxDefaults {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CheckboxDefaults f12358a = new CheckboxDefaults();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f12359b = 0;

    private CheckboxDefaults() {
    }

    public final CheckboxColors a(long j3, long j4, long j5, long j6, long j7, Composer composer, int i3, int i4) {
        long j8;
        long jR;
        long jL = (i4 & 1) != 0 ? MaterialTheme.f13091a.a(composer, 6).l() : j3;
        long jR2 = (i4 & 2) != 0 ? Color.r(MaterialTheme.f13091a.a(composer, 6).i(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null) : j4;
        long jN = (i4 & 4) != 0 ? MaterialTheme.f13091a.a(composer, 6).n() : j5;
        long jR3 = (i4 & 8) != 0 ? Color.r(MaterialTheme.f13091a.a(composer, 6).i(), ContentAlpha.f12529a.b(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j6;
        if ((i4 & 16) != 0) {
            long j9 = jL;
            jR = Color.r(j9, ContentAlpha.f12529a.b(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
            j8 = j9;
        } else {
            j8 = jL;
            jR = j7;
        }
        if (ComposerKt.M()) {
            ComposerKt.U(469524104, i3, -1, "androidx.compose.material.CheckboxDefaults.colors (Checkbox.kt:231)");
        }
        boolean z2 = ((((i3 & 14) ^ 6) > 4 && composer.f(j8)) || (i3 & 6) == 4) | ((((i3 & 112) ^ 48) > 32 && composer.f(jR2)) || (i3 & 48) == 32) | ((((i3 & 896) ^ 384) > 256 && composer.f(jN)) || (i3 & 384) == 256) | ((((i3 & 7168) ^ 3072) > 2048 && composer.f(jR3)) || (i3 & 3072) == 2048) | ((((57344 & i3) ^ 24576) > 16384 && composer.f(jR)) || (i3 & 24576) == 16384);
        Object objG = composer.G();
        if (z2 || objG == Composer.f23746a.a()) {
            long j10 = j8;
            long j11 = jR3;
            DefaultCheckboxColors defaultCheckboxColors = new DefaultCheckboxColors(jN, Color.r(jN, 0.0f, 0.0f, 0.0f, 0.0f, 14, null), j10, Color.r(j10, 0.0f, 0.0f, 0.0f, 0.0f, 14, null), j11, Color.r(jR3, 0.0f, 0.0f, 0.0f, 0.0f, 14, null), jR, j10, jR2, jR3, jR, null);
            composer.w(defaultCheckboxColors);
            objG = defaultCheckboxColors;
        }
        DefaultCheckboxColors defaultCheckboxColors2 = (DefaultCheckboxColors) objG;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return defaultCheckboxColors2;
    }
}
