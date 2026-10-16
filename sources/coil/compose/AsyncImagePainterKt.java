package coil.compose;

import android.graphics.drawable.Drawable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.platform.InspectionModeKt;
import coil.ImageLoader;
import coil.request.ImageRequest;
import coil.size.Dimension;
import coil.size.Dimensions;
import coil.transition.TransitionTarget;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
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
public final class AsyncImagePainterKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AsyncImagePainterKt$FakeTransitionTarget$1 f55547a = new TransitionTarget() { // from class: coil.compose.AsyncImagePainterKt$FakeTransitionTarget$1
        @Override // coil.transition.TransitionTarget
        public Drawable f() {
            return null;
        }
    };

    private static final boolean c(long j3) {
        return ((double) Size.i(j3)) >= 0.5d && ((double) Size.g(j3)) >= 0.5d;
    }

    public static final AsyncImagePainter d(Object obj, ImageLoader imageLoader, Painter painter, Painter painter2, Painter painter3, Function1 function1, Function1 function12, Function1 function13, ContentScale contentScale, int i3, Composer composer, int i4, int i5) {
        composer.F(2140758544);
        if ((i5 & 4) != 0) {
            painter = null;
        }
        Painter painter4 = (i5 & 8) != 0 ? null : painter2;
        Painter painter5 = (i5 & 16) != 0 ? painter4 : painter3;
        Function1 function14 = (i5 & 32) != 0 ? null : function1;
        Function1 function15 = (i5 & 64) != 0 ? null : function12;
        Function1 function16 = (i5 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) == 0 ? function13 : null;
        ContentScale contentScaleE = (i5 & Function.MAX_NARGS) != 0 ? ContentScale.f27054a.e() : contentScale;
        int iB = (i5 & 512) != 0 ? DrawScope.e8.b() : i3;
        if (ComposerKt.M()) {
            ComposerKt.U(2140758544, i4, -1, "coil.compose.rememberAsyncImagePainter (AsyncImagePainter.kt:83)");
        }
        int i6 = i4 >> 12;
        AsyncImagePainter asyncImagePainterE = e(obj, imageLoader, UtilsKt.h(painter, painter4, painter5), UtilsKt.d(function14, function15, function16), contentScaleE, iB, composer, (57344 & i6) | 72 | (i6 & 458752), 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.Y();
        return asyncImagePainterE;
    }

    public static final AsyncImagePainter e(Object obj, ImageLoader imageLoader, Function1 function1, Function1 function12, ContentScale contentScale, int i3, Composer composer, int i4, int i5) {
        composer.F(-2020614074);
        if ((i5 & 4) != 0) {
            function1 = AsyncImagePainter.f55509w.a();
        }
        if ((i5 & 8) != 0) {
            function12 = null;
        }
        if ((i5 & 16) != 0) {
            contentScale = ContentScale.f27054a.e();
        }
        if ((i5 & 32) != 0) {
            i3 = DrawScope.e8.b();
        }
        if (ComposerKt.M()) {
            ComposerKt.U(-2020614074, i4, -1, "coil.compose.rememberAsyncImagePainter (AsyncImagePainter.kt:128)");
        }
        ImageRequest imageRequestE = UtilsKt.e(obj, composer, 8);
        i(imageRequestE);
        composer.F(-492369756);
        Object objG = composer.G();
        if (objG == Composer.f23746a.a()) {
            objG = new AsyncImagePainter(imageRequestE, imageLoader);
            composer.w(objG);
        }
        composer.Y();
        AsyncImagePainter asyncImagePainter = (AsyncImagePainter) objG;
        asyncImagePainter.M(function1);
        asyncImagePainter.H(function12);
        asyncImagePainter.E(contentScale);
        asyncImagePainter.F(i3);
        asyncImagePainter.J(((Boolean) composer.q(InspectionModeKt.a())).booleanValue());
        asyncImagePainter.G(imageLoader);
        asyncImagePainter.K(imageRequestE);
        asyncImagePainter.c();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.Y();
        return asyncImagePainter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final coil.size.Size f(long j3) {
        if (j3 == Size.f25617b.a()) {
            return coil.size.Size.f56177d;
        }
        if (!c(j3)) {
            return null;
        }
        float fI = Size.i(j3);
        Dimension dimensionA = (Float.isInfinite(fI) || Float.isNaN(fI)) ? Dimension.Undefined.f56164a : Dimensions.a(MathKt.d(Size.i(j3)));
        float fG = Size.g(j3);
        return new coil.size.Size(dimensionA, (Float.isInfinite(fG) || Float.isNaN(fG)) ? Dimension.Undefined.f56164a : Dimensions.a(MathKt.d(Size.g(j3))));
    }

    private static final Void g(String str, String str2) {
        throw new IllegalArgumentException("Unsupported type: " + str + ". " + str2);
    }

    static /* synthetic */ Void h(String str, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = "If you wish to display this " + str + ", use androidx.compose.foundation.Image.";
        }
        return g(str, str2);
    }

    private static final void i(ImageRequest imageRequest) {
        Object objM = imageRequest.m();
        if (objM instanceof ImageRequest.Builder) {
            g("ImageRequest.Builder", "Did you forget to call ImageRequest.Builder.build()?");
            throw new KotlinNothingValueException();
        }
        if (objM instanceof ImageBitmap) {
            h("ImageBitmap", null, 2, null);
            throw new KotlinNothingValueException();
        }
        if (objM instanceof ImageVector) {
            h("ImageVector", null, 2, null);
            throw new KotlinNothingValueException();
        }
        if (objM instanceof Painter) {
            h("Painter", null, 2, null);
            throw new KotlinNothingValueException();
        }
        if (imageRequest.M() != null) {
            throw new IllegalArgumentException("request.target must be null.");
        }
    }
}
