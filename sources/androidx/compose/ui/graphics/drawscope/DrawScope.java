package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.FilterQuality;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@DrawScopeMarker
@Metadata
public interface DrawScope extends Density {
    public static final Companion e8 = Companion.f26092a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f26092a = new Companion();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final int f26093b = BlendMode.f25667b.B();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final int f26094c = FilterQuality.f25743b.a();

        private Companion() {
        }

        public final int a() {
            return f26093b;
        }

        public final int b() {
            return f26094c;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
    }

    static /* synthetic */ void E1(DrawScope drawScope, List list, int i3, long j3, float f3, int i4, PathEffect pathEffect, float f4, ColorFilter colorFilter, int i5, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawPoints-F8ZwMP8");
        }
        drawScope.O1(list, i3, j3, (i6 & 8) != 0 ? 0.0f : f3, (i6 & 16) != 0 ? StrokeCap.f25935b.a() : i4, (i6 & 32) != 0 ? null : pathEffect, (i6 & 64) != 0 ? 1.0f : f4, (i6 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : colorFilter, (i6 & Function.MAX_NARGS) != 0 ? e8.a() : i5);
    }

    static /* synthetic */ void F0(DrawScope drawScope, long j3, float f3, float f4, boolean z2, long j4, long j5, float f5, DrawStyle drawStyle, ColorFilter colorFilter, int i3, int i4, Object obj) {
        DrawScope drawScope2;
        long jG1;
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawArc-yD3GUKo");
        }
        long jC = (i4 & 16) != 0 ? Offset.f25596b.c() : j4;
        if ((i4 & 32) != 0) {
            drawScope2 = drawScope;
            jG1 = drawScope2.G1(drawScope.b(), jC);
        } else {
            drawScope2 = drawScope;
            jG1 = j5;
        }
        drawScope2.v1(j3, f3, f4, z2, jC, jG1, (i4 & 64) != 0 ? 1.0f : f5, (i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? Fill.f26098a : drawStyle, (i4 & Function.MAX_NARGS) != 0 ? null : colorFilter, (i4 & 512) != 0 ? e8.a() : i3);
    }

    static /* synthetic */ void F1(DrawScope drawScope, Path path, Brush brush, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawPath-GBMwjPU");
        }
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
            i3 = e8.a();
        }
        drawScope.s0(path, brush, f4, drawStyle2, colorFilter2, i3);
    }

    private default long G1(long j3, long j4) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j3 >> 32)) - Float.intBitsToFloat((int) (j4 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j3 & 4294967295L)) - Float.intBitsToFloat((int) (j4 & 4294967295L));
        return Size.d((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L));
    }

    static /* synthetic */ void L0(DrawScope drawScope, long j3, long j4, long j5, float f3, int i3, PathEffect pathEffect, float f4, ColorFilter colorFilter, int i4, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawLine-NGM6Ib0");
        }
        drawScope.d1(j3, j4, j5, (i5 & 8) != 0 ? 0.0f : f3, (i5 & 16) != 0 ? Stroke.f26099f.a() : i3, (i5 & 32) != 0 ? null : pathEffect, (i5 & 64) != 0 ? 1.0f : f4, (i5 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : colorFilter, (i5 & Function.MAX_NARGS) != 0 ? e8.a() : i4);
    }

    static /* synthetic */ void L1(DrawScope drawScope, long j3, long j4, long j5, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRect-n-J9OG0");
        }
        long jC = (i4 & 2) != 0 ? Offset.f25596b.c() : j4;
        drawScope.h1(j3, jC, (i4 & 4) != 0 ? drawScope.G1(drawScope.b(), jC) : j5, (i4 & 8) != 0 ? 1.0f : f3, (i4 & 16) != 0 ? Fill.f26098a : drawStyle, (i4 & 32) != 0 ? null : colorFilter, (i4 & 64) != 0 ? e8.a() : i3);
    }

    static /* synthetic */ void W(DrawScope drawScope, ImageBitmap imageBitmap, long j3, long j4, long j5, long j6, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i3, int i4, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawImage-AZ2fEMs");
        }
        long jB = (i5 & 2) != 0 ? IntOffset.f29988b.b() : j3;
        long jC = (i5 & 4) != 0 ? IntSize.c((((long) imageBitmap.getHeight()) & 4294967295L) | (((long) imageBitmap.getWidth()) << 32)) : j4;
        drawScope.Z1(imageBitmap, jB, jC, (i5 & 8) != 0 ? IntOffset.f29988b.b() : j5, (i5 & 16) != 0 ? jC : j6, (i5 & 32) != 0 ? 1.0f : f3, (i5 & 64) != 0 ? Fill.f26098a : drawStyle, (i5 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : colorFilter, (i5 & Function.MAX_NARGS) != 0 ? e8.a() : i3, (i5 & 512) != 0 ? e8.b() : i4);
    }

    static /* synthetic */ void Y0(DrawScope drawScope, ImageBitmap imageBitmap, long j3, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawImage-gbVJVH8");
        }
        drawScope.W0(imageBitmap, (i4 & 2) != 0 ? Offset.f25596b.c() : j3, (i4 & 4) != 0 ? 1.0f : f3, (i4 & 8) != 0 ? Fill.f26098a : drawStyle, (i4 & 16) != 0 ? null : colorFilter, (i4 & 32) != 0 ? e8.a() : i3);
    }

    static /* synthetic */ void a2(DrawScope drawScope, GraphicsLayer graphicsLayer, long j3, Function1 function1, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: record-JVtK1S4");
        }
        if ((i3 & 1) != 0) {
            j3 = IntSizeKt.d(drawScope.b());
        }
        drawScope.D1(graphicsLayer, j3, function1);
    }

    static /* synthetic */ void e2(DrawScope drawScope, long j3, float f3, long j4, float f4, DrawStyle drawStyle, ColorFilter colorFilter, int i3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawCircle-VaOC9Bg");
        }
        if ((i4 & 2) != 0) {
            f3 = Size.h(drawScope.b()) / 2.0f;
        }
        drawScope.p1(j3, f3, (i4 & 4) != 0 ? drawScope.V1() : j4, (i4 & 8) != 0 ? 1.0f : f4, (i4 & 16) != 0 ? Fill.f26098a : drawStyle, (i4 & 32) != 0 ? null : colorFilter, (i4 & 64) != 0 ? e8.a() : i3);
    }

    static /* synthetic */ void f2(DrawScope drawScope, long j3, long j4, long j5, long j6, DrawStyle drawStyle, float f3, ColorFilter colorFilter, int i3, int i4, Object obj) {
        DrawScope drawScope2;
        long jG1;
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRoundRect-u-Aw5IA");
        }
        long jC = (i4 & 2) != 0 ? Offset.f25596b.c() : j4;
        if ((i4 & 4) != 0) {
            drawScope2 = drawScope;
            jG1 = drawScope2.G1(drawScope.b(), jC);
        } else {
            drawScope2 = drawScope;
            jG1 = j5;
        }
        drawScope2.G0(j3, jC, jG1, (i4 & 8) != 0 ? CornerRadius.f25589b.a() : j6, (i4 & 16) != 0 ? Fill.f26098a : drawStyle, (i4 & 32) != 0 ? 1.0f : f3, (i4 & 64) != 0 ? null : colorFilter, (i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? e8.a() : i3);
    }

    static /* synthetic */ void g2(DrawScope drawScope, Brush brush, long j3, long j4, long j5, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRoundRect-ZuiqVtQ");
        }
        long jC = (i4 & 2) != 0 ? Offset.f25596b.c() : j3;
        drawScope.H1(brush, jC, (i4 & 4) != 0 ? drawScope.G1(drawScope.b(), jC) : j4, (i4 & 8) != 0 ? CornerRadius.f25589b.a() : j5, (i4 & 16) != 0 ? 1.0f : f3, (i4 & 32) != 0 ? Fill.f26098a : drawStyle, (i4 & 64) != 0 ? null : colorFilter, (i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? e8.a() : i3);
    }

    static /* synthetic */ void h2(DrawScope drawScope, Brush brush, long j3, long j4, float f3, int i3, PathEffect pathEffect, float f4, ColorFilter colorFilter, int i4, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawLine-1RTmtNc");
        }
        drawScope.S1(brush, j3, j4, (i5 & 8) != 0 ? 0.0f : f3, (i5 & 16) != 0 ? Stroke.f26099f.a() : i3, (i5 & 32) != 0 ? null : pathEffect, (i5 & 64) != 0 ? 1.0f : f4, (i5 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : colorFilter, (i5 & Function.MAX_NARGS) != 0 ? e8.a() : i4);
    }

    static /* synthetic */ void k1(DrawScope drawScope, Brush brush, long j3, long j4, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRect-AsUm42w");
        }
        long jC = (i4 & 2) != 0 ? Offset.f25596b.c() : j3;
        drawScope.b1(brush, jC, (i4 & 4) != 0 ? drawScope.G1(drawScope.b(), jC) : j4, (i4 & 8) != 0 ? 1.0f : f3, (i4 & 16) != 0 ? Fill.f26098a : drawStyle, (i4 & 32) != 0 ? null : colorFilter, (i4 & 64) != 0 ? e8.a() : i3);
    }

    static /* synthetic */ void u0(DrawScope drawScope, Path path, long j3, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawPath-LG529CI");
        }
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
        drawScope.f1(path, j3, f4, drawStyle2, colorFilter, (i4 & 32) != 0 ? e8.a() : i3);
    }

    static /* synthetic */ void y1(DrawScope drawScope, Brush brush, float f3, float f4, boolean z2, long j3, long j4, float f5, DrawStyle drawStyle, ColorFilter colorFilter, int i3, int i4, Object obj) {
        DrawScope drawScope2;
        long jG1;
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawArc-illE91I");
        }
        long jC = (i4 & 16) != 0 ? Offset.f25596b.c() : j3;
        if ((i4 & 32) != 0) {
            drawScope2 = drawScope;
            jG1 = drawScope2.G1(drawScope.b(), jC);
        } else {
            drawScope2 = drawScope;
            jG1 = j4;
        }
        drawScope2.e1(brush, f3, f4, z2, jC, jG1, (i4 & 64) != 0 ? 1.0f : f5, (i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? Fill.f26098a : drawStyle, (i4 & Function.MAX_NARGS) != 0 ? null : colorFilter, (i4 & 512) != 0 ? e8.a() : i3);
    }

    static /* synthetic */ void z1(DrawScope drawScope, Brush brush, float f3, long j3, float f4, DrawStyle drawStyle, ColorFilter colorFilter, int i3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawCircle-V9BoPsw");
        }
        drawScope.Y1(brush, (i4 & 2) != 0 ? Size.h(drawScope.b()) / 2.0f : f3, (i4 & 4) != 0 ? drawScope.V1() : j3, (i4 & 8) != 0 ? 1.0f : f4, (i4 & 16) != 0 ? Fill.f26098a : drawStyle, (i4 & 32) != 0 ? null : colorFilter, (i4 & 64) != 0 ? e8.a() : i3);
    }

    default void D1(GraphicsLayer graphicsLayer, long j3, final Function1 function1) {
        graphicsLayer.G(this, getLayoutDirection(), j3, new Function1<DrawScope, Unit>() { // from class: androidx.compose.ui.graphics.drawscope.DrawScope$record$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((DrawScope) obj);
                return Unit.f139807a;
            }

            public final void invoke(DrawScope drawScope) {
                DrawScope drawScope2 = this.f26095a;
                Density density = drawScope.Q1().getDensity();
                LayoutDirection layoutDirection = drawScope.Q1().getLayoutDirection();
                Canvas canvasG = drawScope.Q1().g();
                long jB = drawScope.Q1().b();
                GraphicsLayer graphicsLayerI = drawScope.Q1().i();
                Function1 function12 = function1;
                Density density2 = drawScope2.Q1().getDensity();
                LayoutDirection layoutDirection2 = drawScope2.Q1().getLayoutDirection();
                Canvas canvasG2 = drawScope2.Q1().g();
                long jB2 = drawScope2.Q1().b();
                GraphicsLayer graphicsLayerI2 = drawScope2.Q1().i();
                DrawContext drawContextQ1 = drawScope2.Q1();
                drawContextQ1.d(density);
                drawContextQ1.c(layoutDirection);
                drawContextQ1.j(canvasG);
                drawContextQ1.h(jB);
                drawContextQ1.f(graphicsLayerI);
                canvasG.t();
                try {
                    function12.invoke(drawScope2);
                } finally {
                    canvasG.k();
                    DrawContext drawContextQ12 = drawScope2.Q1();
                    drawContextQ12.d(density2);
                    drawContextQ12.c(layoutDirection2);
                    drawContextQ12.j(canvasG2);
                    drawContextQ12.h(jB2);
                    drawContextQ12.f(graphicsLayerI2);
                }
            }
        });
    }

    void G0(long j3, long j4, long j5, long j6, DrawStyle drawStyle, float f3, ColorFilter colorFilter, int i3);

    void H1(Brush brush, long j3, long j4, long j5, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i3);

    void O1(List list, int i3, long j3, float f3, int i4, PathEffect pathEffect, float f4, ColorFilter colorFilter, int i5);

    DrawContext Q1();

    void S1(Brush brush, long j3, long j4, float f3, int i3, PathEffect pathEffect, float f4, ColorFilter colorFilter, int i4);

    default long V1() {
        return SizeKt.b(Q1().b());
    }

    void W0(ImageBitmap imageBitmap, long j3, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i3);

    void Y1(Brush brush, float f3, long j3, float f4, DrawStyle drawStyle, ColorFilter colorFilter, int i3);

    default void Z1(ImageBitmap imageBitmap, long j3, long j4, long j5, long j6, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i3, int i4) {
        W(this, imageBitmap, j3, j4, j5, j6, f3, drawStyle, colorFilter, i3, 0, 512, null);
    }

    default long b() {
        return Q1().b();
    }

    void b1(Brush brush, long j3, long j4, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i3);

    void d1(long j3, long j4, long j5, float f3, int i3, PathEffect pathEffect, float f4, ColorFilter colorFilter, int i4);

    void e1(Brush brush, float f3, float f4, boolean z2, long j3, long j4, float f5, DrawStyle drawStyle, ColorFilter colorFilter, int i3);

    void f1(Path path, long j3, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i3);

    LayoutDirection getLayoutDirection();

    void h1(long j3, long j4, long j5, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i3);

    void p1(long j3, float f3, long j4, float f4, DrawStyle drawStyle, ColorFilter colorFilter, int i3);

    void s0(Path path, Brush brush, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i3);

    void v1(long j3, float f3, float f4, boolean z2, long j4, long j5, float f5, DrawStyle drawStyle, ColorFilter colorFilter, int i3);
}
