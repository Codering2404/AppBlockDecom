package coil.transform;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.Shader;
import coil.decode.DecodeUtils;
import coil.size.Dimension;
import coil.size.Scale;
import coil.size.Size;
import coil.size.Sizes;
import coil.util.Bitmaps;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

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
public final class RoundedCornersTransformation implements Transformation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f56190a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f56191b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f56192c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f56193d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f56194e;

    private final Pair c(Bitmap bitmap, Size size) {
        if (Sizes.a(size)) {
            return TuplesKt.a(Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()));
        }
        Dimension dimensionA = size.a();
        Dimension dimensionB = size.b();
        if ((dimensionA instanceof Dimension.Pixels) && (dimensionB instanceof Dimension.Pixels)) {
            return TuplesKt.a(Integer.valueOf(((Dimension.Pixels) dimensionA).f56163a), Integer.valueOf(((Dimension.Pixels) dimensionB).f56163a));
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Dimension dimensionD = size.d();
        int i3 = dimensionD instanceof Dimension.Pixels ? ((Dimension.Pixels) dimensionD).f56163a : Integer.MIN_VALUE;
        Dimension dimensionC = size.c();
        double dC = DecodeUtils.c(width, height, i3, dimensionC instanceof Dimension.Pixels ? ((Dimension.Pixels) dimensionC).f56163a : Integer.MIN_VALUE, Scale.FILL);
        return TuplesKt.a(Integer.valueOf(MathKt.c(((double) bitmap.getWidth()) * dC)), Integer.valueOf(MathKt.c(dC * ((double) bitmap.getHeight()))));
    }

    @Override // coil.transform.Transformation
    public String a() {
        return this.f56194e;
    }

    @Override // coil.transform.Transformation
    public Object b(Bitmap bitmap, Size size, Continuation continuation) {
        Paint paint = new Paint(3);
        Pair pairC = c(bitmap, size);
        int iIntValue = ((Number) pairC.a()).intValue();
        int iIntValue2 = ((Number) pairC.b()).intValue();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iIntValue, iIntValue2, Bitmaps.c(bitmap));
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(width, height, config)");
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        Matrix matrix = new Matrix();
        float fC = (float) DecodeUtils.c(bitmap.getWidth(), bitmap.getHeight(), iIntValue, iIntValue2, Scale.FILL);
        float f3 = 2;
        matrix.setTranslate((iIntValue - (bitmap.getWidth() * fC)) / f3, (iIntValue2 - (bitmap.getHeight() * fC)) / f3);
        matrix.preScale(fC, fC);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        float f4 = this.f56190a;
        float f5 = this.f56191b;
        float f6 = this.f56193d;
        float f7 = this.f56192c;
        float[] fArr = {f4, f4, f5, f5, f6, f6, f7, f7};
        RectF rectF = new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        Path path = new Path();
        path.addRoundRect(rectF, fArr, Path.Direction.CW);
        canvas.drawPath(path, paint);
        return bitmapCreateBitmap;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RoundedCornersTransformation)) {
            return false;
        }
        RoundedCornersTransformation roundedCornersTransformation = (RoundedCornersTransformation) obj;
        return this.f56190a == roundedCornersTransformation.f56190a && this.f56191b == roundedCornersTransformation.f56191b && this.f56192c == roundedCornersTransformation.f56192c && this.f56193d == roundedCornersTransformation.f56193d;
    }

    public int hashCode() {
        return (((((Float.hashCode(this.f56190a) * 31) + Float.hashCode(this.f56191b)) * 31) + Float.hashCode(this.f56192c)) * 31) + Float.hashCode(this.f56193d);
    }
}
