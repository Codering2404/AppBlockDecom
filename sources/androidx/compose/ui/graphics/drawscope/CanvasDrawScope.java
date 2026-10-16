package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.FilterQuality;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
@Metadata
public final class CanvasDrawScope implements DrawScope {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DrawParams f26079a = new DrawParams(null, null, null, 0, 15, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DrawContext f26080b = new DrawContext() { // from class: androidx.compose.ui.graphics.drawscope.CanvasDrawScope$drawContext$1

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final DrawTransform f26087a = CanvasDrawScopeKt.b(this);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private GraphicsLayer f26088b;

        @Override // androidx.compose.ui.graphics.drawscope.DrawContext
        public long b() {
            return this.f26089c.O().h();
        }

        @Override // androidx.compose.ui.graphics.drawscope.DrawContext
        public void c(LayoutDirection layoutDirection) {
            this.f26089c.O().k(layoutDirection);
        }

        @Override // androidx.compose.ui.graphics.drawscope.DrawContext
        public void d(Density density) {
            this.f26089c.O().j(density);
        }

        @Override // androidx.compose.ui.graphics.drawscope.DrawContext
        public DrawTransform e() {
            return this.f26087a;
        }

        @Override // androidx.compose.ui.graphics.drawscope.DrawContext
        public void f(GraphicsLayer graphicsLayer) {
            this.f26088b = graphicsLayer;
        }

        @Override // androidx.compose.ui.graphics.drawscope.DrawContext
        public Canvas g() {
            return this.f26089c.O().e();
        }

        @Override // androidx.compose.ui.graphics.drawscope.DrawContext
        public Density getDensity() {
            return this.f26089c.O().f();
        }

        @Override // androidx.compose.ui.graphics.drawscope.DrawContext
        public LayoutDirection getLayoutDirection() {
            return this.f26089c.O().g();
        }

        @Override // androidx.compose.ui.graphics.drawscope.DrawContext
        public void h(long j3) {
            this.f26089c.O().l(j3);
        }

        @Override // androidx.compose.ui.graphics.drawscope.DrawContext
        public GraphicsLayer i() {
            return this.f26088b;
        }

        @Override // androidx.compose.ui.graphics.drawscope.DrawContext
        public void j(Canvas canvas) {
            this.f26089c.O().i(canvas);
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Paint f26081c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Paint f26082d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DrawParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Density f26083a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private LayoutDirection f26084b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Canvas f26085c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f26086d;

        public /* synthetic */ DrawParams(Density density, LayoutDirection layoutDirection, Canvas canvas, long j3, DefaultConstructorMarker defaultConstructorMarker) {
            this(density, layoutDirection, canvas, j3);
        }

        public final Density a() {
            return this.f26083a;
        }

        public final LayoutDirection b() {
            return this.f26084b;
        }

        public final Canvas c() {
            return this.f26085c;
        }

        public final long d() {
            return this.f26086d;
        }

        public final Canvas e() {
            return this.f26085c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DrawParams)) {
                return false;
            }
            DrawParams drawParams = (DrawParams) obj;
            return Intrinsics.areEqual(this.f26083a, drawParams.f26083a) && this.f26084b == drawParams.f26084b && Intrinsics.areEqual(this.f26085c, drawParams.f26085c) && Size.f(this.f26086d, drawParams.f26086d);
        }

        public final Density f() {
            return this.f26083a;
        }

        public final LayoutDirection g() {
            return this.f26084b;
        }

        public final long h() {
            return this.f26086d;
        }

        public int hashCode() {
            return (((((this.f26083a.hashCode() * 31) + this.f26084b.hashCode()) * 31) + this.f26085c.hashCode()) * 31) + Size.j(this.f26086d);
        }

        public final void i(Canvas canvas) {
            this.f26085c = canvas;
        }

        public final void j(Density density) {
            this.f26083a = density;
        }

        public final void k(LayoutDirection layoutDirection) {
            this.f26084b = layoutDirection;
        }

        public final void l(long j3) {
            this.f26086d = j3;
        }

        public String toString() {
            return "DrawParams(density=" + this.f26083a + ", layoutDirection=" + this.f26084b + ", canvas=" + this.f26085c + ", size=" + ((Object) Size.l(this.f26086d)) + ')';
        }

        private DrawParams(Density density, LayoutDirection layoutDirection, Canvas canvas, long j3) {
            this.f26083a = density;
            this.f26084b = layoutDirection;
            this.f26085c = canvas;
            this.f26086d = j3;
        }

        public /* synthetic */ DrawParams(Density density, LayoutDirection layoutDirection, Canvas canvas, long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? DrawContextKt.a() : density, (i3 & 2) != 0 ? LayoutDirection.f30001a : layoutDirection, (i3 & 4) != 0 ? EmptyCanvas.f26097a : canvas, (i3 & 8) != 0 ? Size.f25617b.b() : j3, null);
        }
    }

    static /* synthetic */ Paint H(CanvasDrawScope canvasDrawScope, long j3, float f3, float f4, int i3, int i4, PathEffect pathEffect, float f5, ColorFilter colorFilter, int i5, int i6, int i7, Object obj) {
        return canvasDrawScope.z(j3, f3, f4, i3, i4, pathEffect, f5, colorFilter, i5, (i7 & 512) != 0 ? DrawScope.e8.b() : i6);
    }

    private final Paint I(Brush brush, float f3, float f4, int i3, int i4, PathEffect pathEffect, float f5, ColorFilter colorFilter, int i5, int i6) {
        Paint paintS = S();
        if (brush != null) {
            brush.mo218applyToPq9zytI(b(), paintS, f5);
        } else if (paintS.a() != f5) {
            paintS.c(f5);
        }
        if (!Intrinsics.areEqual(paintS.b(), colorFilter)) {
            paintS.B(colorFilter);
        }
        if (!BlendMode.F(paintS.m(), i5)) {
            paintS.p(i5);
        }
        if (paintS.G() != f3) {
            paintS.F(f3);
        }
        if (paintS.x() != f4) {
            paintS.C(f4);
        }
        if (!StrokeCap.g(paintS.r(), i3)) {
            paintS.o(i3);
        }
        if (!StrokeJoin.g(paintS.w(), i4)) {
            paintS.t(i4);
        }
        if (!Intrinsics.areEqual(paintS.v(), pathEffect)) {
            paintS.s(pathEffect);
        }
        if (!FilterQuality.e(paintS.D(), i6)) {
            paintS.q(i6);
        }
        return paintS;
    }

    static /* synthetic */ Paint N(CanvasDrawScope canvasDrawScope, Brush brush, float f3, float f4, int i3, int i4, PathEffect pathEffect, float f5, ColorFilter colorFilter, int i5, int i6, int i7, Object obj) {
        return canvasDrawScope.I(brush, f3, f4, i3, i4, pathEffect, f5, colorFilter, i5, (i7 & 512) != 0 ? DrawScope.e8.b() : i6);
    }

    private final long Q(long j3, float f3) {
        return f3 == 1.0f ? j3 : Color.r(j3, Color.u(j3) * f3, 0.0f, 0.0f, 0.0f, 14, null);
    }

    private final Paint R() {
        Paint paint = this.f26081c;
        if (paint != null) {
            return paint;
        }
        Paint paintA = AndroidPaint_androidKt.a();
        paintA.E(PaintingStyle.f25822b.a());
        this.f26081c = paintA;
        return paintA;
    }

    private final Paint S() {
        Paint paint = this.f26082d;
        if (paint != null) {
            return paint;
        }
        Paint paintA = AndroidPaint_androidKt.a();
        paintA.E(PaintingStyle.f25822b.b());
        this.f26082d = paintA;
        return paintA;
    }

    private final Paint T(DrawStyle drawStyle) {
        if (Intrinsics.areEqual(drawStyle, Fill.f26098a)) {
            return R();
        }
        if (!(drawStyle instanceof Stroke)) {
            throw new NoWhenBranchMatchedException();
        }
        Paint paintS = S();
        Stroke stroke = (Stroke) drawStyle;
        if (paintS.G() != stroke.f()) {
            paintS.F(stroke.f());
        }
        if (!StrokeCap.g(paintS.r(), stroke.b())) {
            paintS.o(stroke.b());
        }
        if (paintS.x() != stroke.d()) {
            paintS.C(stroke.d());
        }
        if (!StrokeJoin.g(paintS.w(), stroke.c())) {
            paintS.t(stroke.c());
        }
        if (!Intrinsics.areEqual(paintS.v(), stroke.e())) {
            paintS.s(stroke.e());
        }
        return paintS;
    }

    private final Paint m(long j3, DrawStyle drawStyle, float f3, ColorFilter colorFilter, int i3, int i4) {
        Paint paintT = T(drawStyle);
        long jQ = Q(j3, f3);
        if (!Color.t(paintT.d(), jQ)) {
            paintT.u(jQ);
        }
        if (paintT.A() != null) {
            paintT.z(null);
        }
        if (!Intrinsics.areEqual(paintT.b(), colorFilter)) {
            paintT.B(colorFilter);
        }
        if (!BlendMode.F(paintT.m(), i3)) {
            paintT.p(i3);
        }
        if (!FilterQuality.e(paintT.D(), i4)) {
            paintT.q(i4);
        }
        return paintT;
    }

    static /* synthetic */ Paint p(CanvasDrawScope canvasDrawScope, long j3, DrawStyle drawStyle, float f3, ColorFilter colorFilter, int i3, int i4, int i5, Object obj) {
        return canvasDrawScope.m(j3, drawStyle, f3, colorFilter, i3, (i5 & 32) != 0 ? DrawScope.e8.b() : i4);
    }

    private final Paint u(Brush brush, DrawStyle drawStyle, float f3, ColorFilter colorFilter, int i3, int i4) {
        Paint paintT = T(drawStyle);
        if (brush != null) {
            brush.mo218applyToPq9zytI(b(), paintT, f3);
        } else {
            if (paintT.A() != null) {
                paintT.z(null);
            }
            long jD = paintT.d();
            Color.Companion companion = Color.f25715b;
            if (!Color.t(jD, companion.a())) {
                paintT.u(companion.a());
            }
            if (paintT.a() != f3) {
                paintT.c(f3);
            }
        }
        if (!Intrinsics.areEqual(paintT.b(), colorFilter)) {
            paintT.B(colorFilter);
        }
        if (!BlendMode.F(paintT.m(), i3)) {
            paintT.p(i3);
        }
        if (!FilterQuality.e(paintT.D(), i4)) {
            paintT.q(i4);
        }
        return paintT;
    }

    static /* synthetic */ Paint x(CanvasDrawScope canvasDrawScope, Brush brush, DrawStyle drawStyle, float f3, ColorFilter colorFilter, int i3, int i4, int i5, Object obj) {
        if ((i5 & 32) != 0) {
            i4 = DrawScope.e8.b();
        }
        return canvasDrawScope.u(brush, drawStyle, f3, colorFilter, i3, i4);
    }

    private final Paint z(long j3, float f3, float f4, int i3, int i4, PathEffect pathEffect, float f5, ColorFilter colorFilter, int i5, int i6) {
        Paint paintS = S();
        long jQ = Q(j3, f5);
        if (!Color.t(paintS.d(), jQ)) {
            paintS.u(jQ);
        }
        if (paintS.A() != null) {
            paintS.z(null);
        }
        if (!Intrinsics.areEqual(paintS.b(), colorFilter)) {
            paintS.B(colorFilter);
        }
        if (!BlendMode.F(paintS.m(), i5)) {
            paintS.p(i5);
        }
        if (paintS.G() != f3) {
            paintS.F(f3);
        }
        if (paintS.x() != f4) {
            paintS.C(f4);
        }
        if (!StrokeCap.g(paintS.r(), i3)) {
            paintS.o(i3);
        }
        if (!StrokeJoin.g(paintS.w(), i4)) {
            paintS.t(i4);
        }
        if (!Intrinsics.areEqual(paintS.v(), pathEffect)) {
            paintS.s(pathEffect);
        }
        if (!FilterQuality.e(paintS.D(), i6)) {
            paintS.q(i6);
        }
        return paintS;
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void G0(long j3, long j4, long j5, long j6, DrawStyle drawStyle, float f3, ColorFilter colorFilter, int i3) {
        int i4 = (int) (j4 >> 32);
        int i5 = (int) (j4 & 4294967295L);
        this.f26079a.e().A(Float.intBitsToFloat(i4), Float.intBitsToFloat(i5), Float.intBitsToFloat(i4) + Float.intBitsToFloat((int) (j5 >> 32)), Float.intBitsToFloat(i5) + Float.intBitsToFloat((int) (j5 & 4294967295L)), Float.intBitsToFloat((int) (j6 >> 32)), Float.intBitsToFloat((int) (j6 & 4294967295L)), p(this, j3, drawStyle, f3, colorFilter, i3, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void H1(Brush brush, long j3, long j4, long j5, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i3) {
        int i4 = (int) (j3 >> 32);
        int i5 = (int) (j3 & 4294967295L);
        this.f26079a.e().A(Float.intBitsToFloat(i4), Float.intBitsToFloat(i5), Float.intBitsToFloat(i4) + Float.intBitsToFloat((int) (j4 >> 32)), Float.intBitsToFloat(i5) + Float.intBitsToFloat((int) (j4 & 4294967295L)), Float.intBitsToFloat((int) (j5 >> 32)), Float.intBitsToFloat((int) (j5 & 4294967295L)), x(this, brush, drawStyle, f3, colorFilter, i3, 0, 32, null));
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public float K1() {
        return this.f26079a.f().K1();
    }

    public final DrawParams O() {
        return this.f26079a;
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void O1(List list, int i3, long j3, float f3, int i4, PathEffect pathEffect, float f4, ColorFilter colorFilter, int i5) {
        this.f26079a.e().h(i3, list, H(this, j3, f3, 4.0f, i4, StrokeJoin.f25940b.b(), pathEffect, f4, colorFilter, i5, 0, 512, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public DrawContext Q1() {
        return this.f26080b;
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void S1(Brush brush, long j3, long j4, float f3, int i3, PathEffect pathEffect, float f4, ColorFilter colorFilter, int i4) {
        this.f26079a.e().q(j3, j4, N(this, brush, f3, 4.0f, i3, StrokeJoin.f25940b.b(), pathEffect, f4, colorFilter, i4, 0, 512, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void W0(ImageBitmap imageBitmap, long j3, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i3) {
        this.f26079a.e().j(imageBitmap, j3, x(this, null, drawStyle, f3, colorFilter, i3, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void Y1(Brush brush, float f3, long j3, float f4, DrawStyle drawStyle, ColorFilter colorFilter, int i3) {
        this.f26079a.e().z(j3, f3, x(this, brush, drawStyle, f4, colorFilter, i3, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void Z1(ImageBitmap imageBitmap, long j3, long j4, long j5, long j6, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i3, int i4) {
        this.f26079a.e().i(imageBitmap, j3, j4, j5, j6, u(null, drawStyle, f3, colorFilter, i3, i4));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void b1(Brush brush, long j3, long j4, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i3) {
        int i4 = (int) (j3 >> 32);
        int i5 = (int) (j3 & 4294967295L);
        this.f26079a.e().g(Float.intBitsToFloat(i4), Float.intBitsToFloat(i5), Float.intBitsToFloat(i4) + Float.intBitsToFloat((int) (j4 >> 32)), Float.intBitsToFloat(i5) + Float.intBitsToFloat((int) (j4 & 4294967295L)), x(this, brush, drawStyle, f3, colorFilter, i3, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void d1(long j3, long j4, long j5, float f3, int i3, PathEffect pathEffect, float f4, ColorFilter colorFilter, int i4) {
        this.f26079a.e().q(j4, j5, H(this, j3, f3, 4.0f, i3, StrokeJoin.f25940b.b(), pathEffect, f4, colorFilter, i4, 0, 512, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void e1(Brush brush, float f3, float f4, boolean z2, long j3, long j4, float f5, DrawStyle drawStyle, ColorFilter colorFilter, int i3) {
        int i4 = (int) (j3 >> 32);
        int i5 = (int) (j3 & 4294967295L);
        this.f26079a.e().m(Float.intBitsToFloat(i4), Float.intBitsToFloat(i5), Float.intBitsToFloat(i4) + Float.intBitsToFloat((int) (j4 >> 32)), Float.intBitsToFloat(i5) + Float.intBitsToFloat((int) (j4 & 4294967295L)), f3, f4, z2, x(this, brush, drawStyle, f5, colorFilter, i3, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void f1(Path path, long j3, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i3) {
        this.f26079a.e().x(path, p(this, j3, drawStyle, f3, colorFilter, i3, 0, 32, null));
    }

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return this.f26079a.f().getDensity();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public LayoutDirection getLayoutDirection() {
        return this.f26079a.g();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void h1(long j3, long j4, long j5, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i3) {
        int i4 = (int) (j4 >> 32);
        int i5 = (int) (j4 & 4294967295L);
        this.f26079a.e().g(Float.intBitsToFloat(i4), Float.intBitsToFloat(i5), Float.intBitsToFloat(i4) + Float.intBitsToFloat((int) (j5 >> 32)), Float.intBitsToFloat(i5) + Float.intBitsToFloat((int) (j5 & 4294967295L)), p(this, j3, drawStyle, f3, colorFilter, i3, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void p1(long j3, float f3, long j4, float f4, DrawStyle drawStyle, ColorFilter colorFilter, int i3) {
        this.f26079a.e().z(j4, f3, p(this, j3, drawStyle, f4, colorFilter, i3, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void s0(Path path, Brush brush, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i3) {
        this.f26079a.e().x(path, x(this, brush, drawStyle, f3, colorFilter, i3, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void v1(long j3, float f3, float f4, boolean z2, long j4, long j5, float f5, DrawStyle drawStyle, ColorFilter colorFilter, int i3) {
        int i4 = (int) (j4 >> 32);
        int i5 = (int) (j4 & 4294967295L);
        this.f26079a.e().m(Float.intBitsToFloat(i4), Float.intBitsToFloat(i5), Float.intBitsToFloat(i4) + Float.intBitsToFloat((int) (j5 >> 32)), Float.intBitsToFloat(i5) + Float.intBitsToFloat((int) (j5 & 4294967295L)), f3, f4, z2, p(this, j3, drawStyle, f5, colorFilter, i3, 0, 32, null));
    }
}
