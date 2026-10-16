package coil.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import coil.decode.DecodeUtils;
import coil.size.Scale;
import coil.size.Size;
import coil.size.Sizes;
import kotlin.Metadata;
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
public final class DrawableUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DrawableUtils f56225a = new DrawableUtils();

    private DrawableUtils() {
    }

    private final boolean b(Bitmap bitmap, Bitmap.Config config) {
        return bitmap.getConfig() == Bitmaps.e(config);
    }

    private final boolean c(boolean z2, Bitmap bitmap, Size size, Scale scale) {
        if (z2) {
            return true;
        }
        return DecodeUtils.c(bitmap.getWidth(), bitmap.getHeight(), Sizes.a(size) ? bitmap.getWidth() : Utils.B(size.d(), scale), Sizes.a(size) ? bitmap.getHeight() : Utils.B(size.c(), scale), scale) == 1.0d;
    }

    public final Bitmap a(Drawable drawable, Bitmap.Config config, Size size, Scale scale, boolean z2) {
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            if (b(bitmap, config) && c(z2, bitmap, size, scale)) {
                return bitmap;
            }
        }
        Drawable drawableMutate = drawable.mutate();
        int iQ = Utils.q(drawableMutate);
        if (iQ <= 0) {
            iQ = 512;
        }
        int iJ = Utils.j(drawableMutate);
        int i3 = iJ > 0 ? iJ : 512;
        double dC = DecodeUtils.c(iQ, i3, Sizes.a(size) ? iQ : Utils.B(size.d(), scale), Sizes.a(size) ? i3 : Utils.B(size.c(), scale), scale);
        int iC = MathKt.c(((double) iQ) * dC);
        int iC2 = MathKt.c(dC * ((double) i3));
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iC, iC2, Bitmaps.e(config));
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(width, height, config)");
        Rect bounds = drawableMutate.getBounds();
        int i4 = bounds.left;
        int i5 = bounds.top;
        int i6 = bounds.right;
        int i7 = bounds.bottom;
        drawableMutate.setBounds(0, 0, iC, iC2);
        drawableMutate.draw(new Canvas(bitmapCreateBitmap));
        drawableMutate.setBounds(i4, i5, i6, i7);
        return bitmapCreateBitmap;
    }
}
