package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

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
public final class OutlineKt {
    public static final void a(Path path, Outline outline) {
        if (outline instanceof Outline.Rectangle) {
            Path.d(path, ((Outline.Rectangle) outline).b(), null, 2, null);
        } else if (outline instanceof Outline.Rounded) {
            Path.s(path, ((Outline.Rounded) outline).b(), null, 2, null);
        } else {
            if (!(outline instanceof Outline.Generic)) {
                throw new NoWhenBranchMatchedException();
            }
            Path.u(path, ((Outline.Generic) outline).b(), 0L, 2, null);
        }
    }

    public static final void b(DrawScope drawScope, Outline outline, Brush brush, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i3) {
        if (outline instanceof Outline.Rectangle) {
            Rect rectB = ((Outline.Rectangle) outline).b();
            drawScope.b1(brush, h(rectB), f(rectB), f3, drawStyle, colorFilter, i3);
            return;
        }
        if (!(outline instanceof Outline.Rounded)) {
            if (!(outline instanceof Outline.Generic)) {
                throw new NoWhenBranchMatchedException();
            }
            drawScope.s0(((Outline.Generic) outline).b(), brush, f3, drawStyle, colorFilter, i3);
            return;
        }
        Outline.Rounded rounded = (Outline.Rounded) outline;
        Path pathC = rounded.c();
        if (pathC != null) {
            drawScope.s0(pathC, brush, f3, drawStyle, colorFilter, i3);
            return;
        }
        RoundRect roundRectB = rounded.b();
        float fIntBitsToFloat = Float.intBitsToFloat((int) (roundRectB.b() >> 32));
        drawScope.H1(brush, i(roundRectB), g(roundRectB), CornerRadius.b((((long) Float.floatToRawIntBits(fIntBitsToFloat)) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32)), f3, drawStyle, colorFilter, i3);
    }

    public static /* synthetic */ void c(DrawScope drawScope, Outline outline, Brush brush, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            f3 = 1.0f;
        }
        float f4 = f3;
        if ((i4 & 8) != 0) {
            drawStyle = Fill.f26098a;
        }
        DrawStyle drawStyle2 = drawStyle;
        if ((i4 & 16) != 0) {
            colorFilter = null;
        }
        ColorFilter colorFilter2 = colorFilter;
        if ((i4 & 32) != 0) {
            i3 = DrawScope.e8.a();
        }
        b(drawScope, outline, brush, f4, drawStyle2, colorFilter2, i3);
    }

    public static final void d(DrawScope drawScope, Outline outline, long j3, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i3) {
        if (outline instanceof Outline.Rectangle) {
            Rect rectB = ((Outline.Rectangle) outline).b();
            drawScope.h1(j3, h(rectB), f(rectB), f3, drawStyle, colorFilter, i3);
            return;
        }
        if (!(outline instanceof Outline.Rounded)) {
            if (!(outline instanceof Outline.Generic)) {
                throw new NoWhenBranchMatchedException();
            }
            drawScope.f1(((Outline.Generic) outline).b(), j3, f3, drawStyle, colorFilter, i3);
            return;
        }
        Outline.Rounded rounded = (Outline.Rounded) outline;
        Path pathC = rounded.c();
        if (pathC != null) {
            drawScope.f1(pathC, j3, f3, drawStyle, colorFilter, i3);
            return;
        }
        RoundRect roundRectB = rounded.b();
        float fIntBitsToFloat = Float.intBitsToFloat((int) (roundRectB.b() >> 32));
        drawScope.G0(j3, i(roundRectB), g(roundRectB), CornerRadius.b((((long) Float.floatToRawIntBits(fIntBitsToFloat)) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32)), drawStyle, f3, colorFilter, i3);
    }

    public static /* synthetic */ void e(DrawScope drawScope, Outline outline, long j3, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            f3 = 1.0f;
        }
        float f4 = f3;
        if ((i4 & 8) != 0) {
            drawStyle = Fill.f26098a;
        }
        DrawStyle drawStyle2 = drawStyle;
        if ((i4 & 16) != 0) {
            colorFilter = null;
        }
        d(drawScope, outline, j3, f4, drawStyle2, colorFilter, (i4 & 32) != 0 ? DrawScope.e8.a() : i3);
    }

    private static final long f(Rect rect) {
        float fP = rect.p() - rect.o();
        return Size.d((((long) Float.floatToRawIntBits(rect.i() - rect.r())) & 4294967295L) | (Float.floatToRawIntBits(fP) << 32));
    }

    private static final long g(RoundRect roundRect) {
        float fJ = roundRect.j();
        float fD = roundRect.d();
        return Size.d((((long) Float.floatToRawIntBits(fJ)) << 32) | (((long) Float.floatToRawIntBits(fD)) & 4294967295L));
    }

    private static final long h(Rect rect) {
        float fO = rect.o();
        float fR = rect.r();
        return Offset.e((((long) Float.floatToRawIntBits(fO)) << 32) | (((long) Float.floatToRawIntBits(fR)) & 4294967295L));
    }

    private static final long i(RoundRect roundRect) {
        float fE = roundRect.e();
        float fG = roundRect.g();
        return Offset.e((((long) Float.floatToRawIntBits(fE)) << 32) | (((long) Float.floatToRawIntBits(fG)) & 4294967295L));
    }
}
