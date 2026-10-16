package androidx.compose.ui.text;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.font.FontFamily;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class TextMeasurerHelperKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f28919a = 8;

    public static final TextMeasurer a(int i3, Composer composer, int i4, int i5) {
        boolean z2 = true;
        if ((i5 & 1) != 0) {
            i3 = f28919a;
        }
        if (ComposerKt.M()) {
            ComposerKt.U(1538166871, i4, -1, "androidx.compose.ui.text.rememberTextMeasurer (TextMeasurerHelper.kt:41)");
        }
        FontFamily.Resolver resolver = (FontFamily.Resolver) composer.q(CompositionLocalsKt.h());
        Density density = (Density) composer.q(CompositionLocalsKt.f());
        LayoutDirection layoutDirection = (LayoutDirection) composer.q(CompositionLocalsKt.m());
        boolean Z = composer.Z(resolver) | composer.Z(density) | composer.Z(layoutDirection);
        if ((((i4 & 14) ^ 6) <= 4 || !composer.e(i3)) && (i4 & 6) != 4) {
            z2 = false;
        }
        boolean z3 = Z | z2;
        Object objG = composer.G();
        if (z3 || objG == Composer.f23746a.a()) {
            objG = new TextMeasurer(resolver, density, layoutDirection, i3);
            composer.w(objG);
        }
        TextMeasurer textMeasurer = (TextMeasurer) objG;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return textMeasurer;
    }
}
