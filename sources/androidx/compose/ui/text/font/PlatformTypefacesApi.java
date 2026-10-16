package androidx.compose.ui.text.font;

import android.content.Context;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontVariation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
final class PlatformTypefacesApi implements PlatformTypefaces {
    private final android.graphics.Typeface d(String str, FontWeight fontWeight, int i3) {
        if (FontStyle.f(i3, FontStyle.f29211b.b()) && Intrinsics.areEqual(fontWeight, FontWeight.f29233b.g()) && (str == null || str.length() == 0)) {
            return android.graphics.Typeface.DEFAULT;
        }
        int iC = AndroidFontUtils_androidKt.c(fontWeight, i3);
        return (str == null || str.length() == 0) ? android.graphics.Typeface.defaultFromStyle(iC) : android.graphics.Typeface.create(str, iC);
    }

    private final android.graphics.Typeface e(String str, FontWeight fontWeight, int i3) {
        if (str.length() == 0) {
            return null;
        }
        android.graphics.Typeface typefaceD = d(str, fontWeight, i3);
        if (Intrinsics.areEqual(typefaceD, android.graphics.Typeface.create(android.graphics.Typeface.DEFAULT, AndroidFontUtils_androidKt.c(fontWeight, i3))) || Intrinsics.areEqual(typefaceD, d(null, fontWeight, i3))) {
            return null;
        }
        return typefaceD;
    }

    @Override // androidx.compose.ui.text.font.PlatformTypefaces
    public android.graphics.Typeface a(GenericFontFamily genericFontFamily, FontWeight fontWeight, int i3) {
        android.graphics.Typeface typefaceE = e(PlatformTypefaces_androidKt.b(genericFontFamily.g(), fontWeight), fontWeight, i3);
        return typefaceE == null ? d(genericFontFamily.g(), fontWeight, i3) : typefaceE;
    }

    @Override // androidx.compose.ui.text.font.PlatformTypefaces
    public android.graphics.Typeface b(FontWeight fontWeight, int i3) {
        return d(null, fontWeight, i3);
    }

    @Override // androidx.compose.ui.text.font.PlatformTypefaces
    public android.graphics.Typeface c(String str, FontWeight fontWeight, int i3, FontVariation.Settings settings, Context context) {
        FontFamily.Companion companion = FontFamily.f29155b;
        return PlatformTypefaces_androidKt.c(Intrinsics.areEqual(str, companion.d().g()) ? a(companion.d(), fontWeight, i3) : Intrinsics.areEqual(str, companion.e().g()) ? a(companion.e(), fontWeight, i3) : Intrinsics.areEqual(str, companion.c().g()) ? a(companion.c(), fontWeight, i3) : Intrinsics.areEqual(str, companion.a().g()) ? a(companion.a(), fontWeight, i3) : e(str, fontWeight, i3), settings, context);
    }
}
