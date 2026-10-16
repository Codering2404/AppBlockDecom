package androidx.compose.ui.text.font;

import android.content.Context;
import androidx.compose.ui.text.font.FontVariation;
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
public final class PlatformTypefaces_androidKt {
    public static final PlatformTypefaces a() {
        return new PlatformTypefacesApi28();
    }

    public static final String b(String str, FontWeight fontWeight) {
        int iN = fontWeight.n() / 100;
        if (iN >= 0 && iN < 2) {
            return str + "-thin";
        }
        if (2 <= iN && iN < 4) {
            return str + "-light";
        }
        if (iN == 4) {
            return str;
        }
        if (iN == 5) {
            return str + "-medium";
        }
        if ((6 <= iN && iN < 8) || 8 > iN || iN >= 11) {
            return str;
        }
        return str + "-black";
    }

    public static final android.graphics.Typeface c(android.graphics.Typeface typeface, FontVariation.Settings settings, Context context) {
        return TypefaceCompatApi26.f29270a.a(typeface, settings, context);
    }
}
