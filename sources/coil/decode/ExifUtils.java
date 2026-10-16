package coil.decode;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.exifinterface.media.ExifInterface;
import coil.util.Bitmaps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSource;

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
public final class ExifUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExifUtils f55718a = new ExifUtils();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Paint f55719b = new Paint(3);

    private ExifUtils() {
    }

    public final ExifData a(String str, BufferedSource bufferedSource, ExifOrientationPolicy exifOrientationPolicy) {
        if (!ExifUtilsKt.c(exifOrientationPolicy, str)) {
            return ExifData.f55709d;
        }
        ExifInterface exifInterface = new ExifInterface(new ExifInterfaceInputStream(bufferedSource.peek().H2()));
        return new ExifData(exifInterface.s(), exifInterface.l());
    }

    public final Bitmap b(Bitmap bitmap, ExifData exifData) {
        Bitmap bitmapCreateBitmap;
        if (!exifData.b() && !ExifUtilsKt.a(exifData)) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        float width = bitmap.getWidth() / 2.0f;
        float height = bitmap.getHeight() / 2.0f;
        if (exifData.b()) {
            matrix.postScale(-1.0f, 1.0f, width, height);
        }
        if (ExifUtilsKt.a(exifData)) {
            matrix.postRotate(exifData.a(), width, height);
        }
        RectF rectF = new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
        matrix.mapRect(rectF);
        float f3 = rectF.left;
        if (f3 != 0.0f || rectF.top != 0.0f) {
            matrix.postTranslate(-f3, -rectF.top);
        }
        if (ExifUtilsKt.b(exifData)) {
            bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getHeight(), bitmap.getWidth(), Bitmaps.c(bitmap));
            Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(width, height, config)");
        } else {
            bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmaps.c(bitmap));
            Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(width, height, config)");
        }
        new Canvas(bitmapCreateBitmap).drawBitmap(bitmap, matrix, f55719b);
        bitmap.recycle();
        return bitmapCreateBitmap;
    }
}
