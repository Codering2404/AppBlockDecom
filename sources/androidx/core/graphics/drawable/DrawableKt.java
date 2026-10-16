package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
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
public final class DrawableKt {
    public static final Bitmap a(Drawable drawable, int i3, int i4, Bitmap.Config config) {
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() == null) {
                throw new IllegalArgumentException("bitmap is null");
            }
            if (config == null || bitmapDrawable.getBitmap().getConfig() == config) {
                return (i3 == bitmapDrawable.getBitmap().getWidth() && i4 == bitmapDrawable.getBitmap().getHeight()) ? bitmapDrawable.getBitmap() : Bitmap.createScaledBitmap(bitmapDrawable.getBitmap(), i3, i4, true);
            }
        }
        Rect bounds = drawable.getBounds();
        int i5 = bounds.left;
        int i6 = bounds.top;
        int i7 = bounds.right;
        int i8 = bounds.bottom;
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i3, i4, config);
        drawable.setBounds(0, 0, i3, i4);
        drawable.draw(new Canvas(bitmapCreateBitmap));
        drawable.setBounds(i5, i6, i7, i8);
        return bitmapCreateBitmap;
    }

    public static /* synthetic */ Bitmap b(Drawable drawable, int i3, int i4, Bitmap.Config config, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i3 = drawable.getIntrinsicWidth();
        }
        if ((i5 & 2) != 0) {
            i4 = drawable.getIntrinsicHeight();
        }
        if ((i5 & 4) != 0) {
            config = null;
        }
        return a(drawable, i3, i4, config);
    }
}
