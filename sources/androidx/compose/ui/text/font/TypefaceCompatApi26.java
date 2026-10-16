package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.Paint;
import androidx.compose.ui.text.font.FontVariation;
import androidx.compose.ui.unit.AndroidDensity_androidKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.util.ListUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

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
final class TypefaceCompatApi26 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TypefaceCompatApi26 f29270a = new TypefaceCompatApi26();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ThreadLocal f29271b = new ThreadLocal();

    private TypefaceCompatApi26() {
    }

    private final String b(FontVariation.Settings settings, Context context) {
        final Density densityA = AndroidDensity_androidKt.a(context);
        return ListUtilsKt.e(settings.b(), null, null, null, 0, null, new Function1<FontVariation.Setting, CharSequence>() { // from class: androidx.compose.ui.text.font.TypefaceCompatApi26$toAndroidString$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final CharSequence invoke(FontVariation.Setting setting) {
                return '\'' + setting.c() + "' " + setting.b(densityA);
            }
        }, 31, null);
    }

    public final android.graphics.Typeface a(android.graphics.Typeface typeface, FontVariation.Settings settings, Context context) {
        if (typeface == null) {
            return null;
        }
        if (settings.b().isEmpty()) {
            return typeface;
        }
        Paint paint = (Paint) f29271b.get();
        if (paint == null) {
            paint = new Paint();
            f29271b.set(paint);
        }
        paint.setFontVariationSettings(null);
        paint.setTypeface(typeface);
        paint.setFontVariationSettings(b(settings, context));
        return paint.getTypeface();
    }
}
