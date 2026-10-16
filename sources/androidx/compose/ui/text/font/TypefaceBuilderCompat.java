package androidx.compose.ui.text.font;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.os.ParcelFileDescriptor;
import androidx.compose.ui.text.font.FontVariation;
import androidx.compose.ui.unit.AndroidDensity_androidKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
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
final class TypefaceBuilderCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TypefaceBuilderCompat f29269a = new TypefaceBuilderCompat();

    private TypefaceBuilderCompat() {
    }

    private final FontVariationAxis[] d(FontVariation.Settings settings, Context context) {
        Density densityA;
        if (context != null) {
            densityA = AndroidDensity_androidKt.a(context);
        } else {
            if (settings.a()) {
                throw new IllegalStateException("Required density, but not provided");
            }
            densityA = DensityKt.a(1.0f, 1.0f);
        }
        List listB = settings.b();
        ArrayList arrayList = new ArrayList(listB.size());
        int size = listB.size();
        for (int i3 = 0; i3 < size; i3++) {
            FontVariation.Setting setting = (FontVariation.Setting) listB.get(i3);
            arrayList.add(new FontVariationAxis(setting.c(), setting.b(densityA)));
        }
        return (FontVariationAxis[]) arrayList.toArray(new FontVariationAxis[0]);
    }

    public final android.graphics.Typeface a(AssetManager assetManager, String str, Context context, FontVariation.Settings settings) {
        if (context == null) {
            return null;
        }
        return new Typeface.Builder(assetManager, str).setFontVariationSettings(d(settings, context)).build();
    }

    public final android.graphics.Typeface b(File file, Context context, FontVariation.Settings settings) {
        if (context == null) {
            return null;
        }
        return new Typeface.Builder(file).setFontVariationSettings(d(settings, context)).build();
    }

    public final android.graphics.Typeface c(ParcelFileDescriptor parcelFileDescriptor, Context context, FontVariation.Settings settings) {
        if (context == null) {
            return null;
        }
        return new Typeface.Builder(parcelFileDescriptor.getFileDescriptor()).setFontVariationSettings(d(settings, context)).build();
    }
}
