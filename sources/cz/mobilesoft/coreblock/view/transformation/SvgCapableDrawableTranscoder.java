package cz.mobilesoft.coreblock.view.transformation;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.PictureDrawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.SimpleResource;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.caverock.androidsvg.SVG;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class SvgCapableDrawableTranscoder implements ResourceTranscoder<SvgOrBitmapResource, PictureDrawable> {
    private final Picture b(Bitmap bitmap) {
        Picture picture = new Picture();
        Canvas canvasBeginRecording = picture.beginRecording(bitmap.getWidth(), bitmap.getHeight());
        Intrinsics.checkNotNullExpressionValue(canvasBeginRecording, "beginRecording(...)");
        canvasBeginRecording.drawBitmap(bitmap, (Rect) null, new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight()), (Paint) null);
        picture.endRecording();
        return picture;
    }

    @Override // com.bumptech.glide.load.resource.transcode.ResourceTranscoder
    public Resource a(Resource toTranscode, Options options) {
        PictureDrawable pictureDrawable;
        Intrinsics.checkNotNullParameter(toTranscode, "toTranscode");
        Intrinsics.checkNotNullParameter(options, "options");
        SVG svgB = ((SvgOrBitmapResource) toTranscode.get()).b();
        if (svgB != null) {
            pictureDrawable = new PictureDrawable(svgB.s());
        } else {
            Bitmap bitmapA = ((SvgOrBitmapResource) toTranscode.get()).a();
            if (bitmapA == null) {
                return null;
            }
            pictureDrawable = new PictureDrawable(b(bitmapA));
        }
        return new SimpleResource(pictureDrawable);
    }
}
