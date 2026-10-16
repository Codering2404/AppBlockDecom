package androidx.compose.ui.graphics;

import android.graphics.Bitmap;
import androidx.compose.ui.graphics.ImageBitmapConfig;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
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
public final class AndroidImageBitmap_androidKt {
    public static final ImageBitmap a(int i3, int i4, int i5, boolean z2, ColorSpace colorSpace) {
        d(i5);
        return new AndroidImageBitmap(Api26Bitmap.a(i3, i4, i5, z2, colorSpace));
    }

    public static final Bitmap b(ImageBitmap imageBitmap) {
        if (imageBitmap instanceof AndroidImageBitmap) {
            return ((AndroidImageBitmap) imageBitmap).c();
        }
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Bitmap");
    }

    public static final ImageBitmap c(Bitmap bitmap) {
        return new AndroidImageBitmap(bitmap);
    }

    public static final Bitmap.Config d(int i3) {
        ImageBitmapConfig.Companion companion = ImageBitmapConfig.f25784b;
        return ImageBitmapConfig.i(i3, companion.b()) ? Bitmap.Config.ARGB_8888 : ImageBitmapConfig.i(i3, companion.a()) ? Bitmap.Config.ALPHA_8 : ImageBitmapConfig.i(i3, companion.e()) ? Bitmap.Config.RGB_565 : ImageBitmapConfig.i(i3, companion.c()) ? Bitmap.Config.RGBA_F16 : ImageBitmapConfig.i(i3, companion.d()) ? Bitmap.Config.HARDWARE : Bitmap.Config.ARGB_8888;
    }

    public static final int e(Bitmap.Config config) {
        return config == Bitmap.Config.ALPHA_8 ? ImageBitmapConfig.f25784b.a() : config == Bitmap.Config.RGB_565 ? ImageBitmapConfig.f25784b.e() : config == Bitmap.Config.ARGB_4444 ? ImageBitmapConfig.f25784b.b() : config == Bitmap.Config.RGBA_F16 ? ImageBitmapConfig.f25784b.c() : config == Bitmap.Config.HARDWARE ? ImageBitmapConfig.f25784b.d() : ImageBitmapConfig.f25784b.b();
    }
}
