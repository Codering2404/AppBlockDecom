package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.ImageBitmapConfig;
import androidx.compose.ui.graphics.ImageBitmapKt;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

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
public final class DrawCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ImageBitmap f26295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Canvas f26296b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Density f26297c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private LayoutDirection f26298d = LayoutDirection.f30001a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f26299e = IntSize.f29998b.a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f26300f = ImageBitmapConfig.f25784b.b();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final CanvasDrawScope f26301g = new CanvasDrawScope();

    private final void a(DrawScope drawScope) {
        DrawScope.L1(drawScope, Color.f25715b.a(), 0L, 0L, 0.0f, null, null, BlendMode.f25667b.a(), 62, null);
    }

    public final void b(int i3, long j3, Density density, LayoutDirection layoutDirection, Function1 function1) {
        this.f26297c = density;
        this.f26298d = layoutDirection;
        ImageBitmap imageBitmapB = this.f26295a;
        Canvas canvasA = this.f26296b;
        if (imageBitmapB == null || canvasA == null || ((int) (j3 >> 32)) > imageBitmapB.getWidth() || ((int) (j3 & 4294967295L)) > imageBitmapB.getHeight() || !ImageBitmapConfig.i(this.f26300f, i3)) {
            imageBitmapB = ImageBitmapKt.b((int) (j3 >> 32), (int) (4294967295L & j3), i3, false, null, 24, null);
            canvasA = CanvasKt.a(imageBitmapB);
            this.f26295a = imageBitmapB;
            this.f26296b = canvasA;
            this.f26300f = i3;
        }
        this.f26299e = j3;
        CanvasDrawScope canvasDrawScope = this.f26301g;
        long jE = IntSizeKt.e(j3);
        CanvasDrawScope.DrawParams drawParamsO = canvasDrawScope.O();
        Density densityA = drawParamsO.a();
        LayoutDirection layoutDirectionB = drawParamsO.b();
        Canvas canvasC = drawParamsO.c();
        long jD = drawParamsO.d();
        CanvasDrawScope.DrawParams drawParamsO2 = canvasDrawScope.O();
        drawParamsO2.j(density);
        drawParamsO2.k(layoutDirection);
        drawParamsO2.i(canvasA);
        drawParamsO2.l(jE);
        canvasA.t();
        a(canvasDrawScope);
        function1.invoke(canvasDrawScope);
        canvasA.k();
        CanvasDrawScope.DrawParams drawParamsO3 = canvasDrawScope.O();
        drawParamsO3.j(densityA);
        drawParamsO3.k(layoutDirectionB);
        drawParamsO3.i(canvasC);
        drawParamsO3.l(jD);
        imageBitmapB.a();
    }

    public final void c(DrawScope drawScope, float f3, ColorFilter colorFilter) {
        ImageBitmap imageBitmap = this.f26295a;
        if (!(imageBitmap != null)) {
            InlineClassHelperKt.c("drawCachedImage must be invoked first before attempting to draw the result into another destination");
        }
        DrawScope.W(drawScope, imageBitmap, 0L, this.f26299e, 0L, 0L, f3, null, colorFilter, 0, 0, 858, null);
    }

    public final ImageBitmap d() {
        return this.f26295a;
    }
}
