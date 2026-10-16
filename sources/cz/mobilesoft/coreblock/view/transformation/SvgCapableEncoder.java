package cz.mobilesoft.coreblock.view.transformation;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Picture;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.SimpleResource;
import com.caverock.androidsvg.SVG;
import cz.mobilesoft.coreblock.LockieApplication;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
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
public final class SvgCapableEncoder implements ResourceEncoder<SvgOrBitmapResource> {
    @Override // com.bumptech.glide.load.ResourceEncoder
    public EncodeStrategy b(Options options) {
        Intrinsics.checkNotNullParameter(options, "options");
        return EncodeStrategy.SOURCE;
    }

    @Override // com.bumptech.glide.load.Encoder
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(Resource data, File file, Options options) {
        Object objA;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(options, "options");
        try {
            SVG svgB = ((SvgOrBitmapResource) data.get()).b();
            if (svgB != null) {
                Picture pictureS = svgB.s();
                Intrinsics.checkNotNullExpressionValue(pictureS, "renderToPicture(...)");
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(pictureS.getWidth(), pictureS.getHeight(), Bitmap.Config.ARGB_8888);
                Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
                pictureS.draw(new Canvas(bitmapCreateBitmap));
                objA = Unit.f139807a;
            } else {
                objA = ((SvgOrBitmapResource) data.get()).a();
            }
            if (objA == null) {
                return false;
            }
            SimpleResource simpleResource = new SimpleResource(objA);
            ResourceEncoder resourceEncoderK = Glide.c(LockieApplication.g()).j().k(simpleResource);
            Intrinsics.checkNotNullExpressionValue(resourceEncoderK, "getResultEncoder(...)");
            resourceEncoderK.a(simpleResource, file, options);
            return true;
        } catch (Exception e3) {
            e3.printStackTrace();
            return false;
        }
    }
}
