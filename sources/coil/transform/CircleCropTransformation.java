package coil.transform;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import coil.size.Size;
import coil.util.Bitmaps;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class CircleCropTransformation implements Transformation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f56189a;

    @Override // coil.transform.Transformation
    public String a() {
        return this.f56189a;
    }

    @Override // coil.transform.Transformation
    public Object b(Bitmap bitmap, Size size, Continuation continuation) {
        Paint paint = new Paint(3);
        int iMin = Math.min(bitmap.getWidth(), bitmap.getHeight());
        float f3 = iMin / 2.0f;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMin, iMin, Bitmaps.c(bitmap));
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(width, height, config)");
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawCircle(f3, f3, f3, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, f3 - (bitmap.getWidth() / 2.0f), f3 - (bitmap.getHeight() / 2.0f), paint);
        return bitmapCreateBitmap;
    }

    public boolean equals(Object obj) {
        return obj instanceof CircleCropTransformation;
    }

    public int hashCode() {
        return CircleCropTransformation.class.hashCode();
    }
}
