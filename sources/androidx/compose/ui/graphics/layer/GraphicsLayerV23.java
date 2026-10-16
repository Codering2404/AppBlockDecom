package androidx.compose.ui.graphics.layer;

import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.view.DisplayListCanvas;
import android.view.RenderNode;
import android.view.View;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.layer.CompositingStrategy;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
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
public final class GraphicsLayerV23 implements GraphicsLayerImpl {
    private static boolean H;
    private float A;
    private boolean B;
    private boolean C;
    private boolean D;
    private RenderEffect E;
    private boolean F;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f26153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CanvasHolder f26154c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CanvasDrawScope f26155d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final RenderNode f26156e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f26157f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Paint f26158g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Matrix f26159h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f26160i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f26161j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f26162k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f26163l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ColorFilter f26164m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f26165n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f26166o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private long f26167p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f26168q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f26169r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private float f26170s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private float f26171t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private float f26172u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private long f26173v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private long f26174w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private float f26175x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private float f26176y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private float f26177z;
    public static final Companion G = new Companion(null);
    private static final AtomicBoolean I = new AtomicBoolean(true);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public GraphicsLayerV23(View view, long j3, CanvasHolder canvasHolder, CanvasDrawScope canvasDrawScope) {
        this.f26153b = j3;
        this.f26154c = canvasHolder;
        this.f26155d = canvasDrawScope;
        RenderNode renderNodeCreate = RenderNode.create("Compose", view);
        this.f26156e = renderNodeCreate;
        IntSize.Companion companion = IntSize.f29998b;
        this.f26157f = companion.a();
        this.f26161j = companion.a();
        if (I.getAndSet(false)) {
            renderNodeCreate.setScaleX(renderNodeCreate.getScaleX());
            renderNodeCreate.setScaleY(renderNodeCreate.getScaleY());
            renderNodeCreate.setTranslationX(renderNodeCreate.getTranslationX());
            renderNodeCreate.setTranslationY(renderNodeCreate.getTranslationY());
            renderNodeCreate.setElevation(renderNodeCreate.getElevation());
            renderNodeCreate.setRotation(renderNodeCreate.getRotation());
            renderNodeCreate.setRotationX(renderNodeCreate.getRotationX());
            renderNodeCreate.setRotationY(renderNodeCreate.getRotationY());
            renderNodeCreate.setCameraDistance(renderNodeCreate.getCameraDistance());
            renderNodeCreate.setPivotX(renderNodeCreate.getPivotX());
            renderNodeCreate.setPivotY(renderNodeCreate.getPivotY());
            renderNodeCreate.setClipToOutline(renderNodeCreate.getClipToOutline());
            renderNodeCreate.setClipToBounds(false);
            renderNodeCreate.setAlpha(renderNodeCreate.getAlpha());
            renderNodeCreate.isValid();
            renderNodeCreate.setLeftTopRightBottom(0, 0, 0, 0);
            renderNodeCreate.offsetLeftAndRight(0);
            renderNodeCreate.offsetTopAndBottom(0);
            V(renderNodeCreate);
            R();
            renderNodeCreate.setLayerType(0);
            renderNodeCreate.setHasOverlappingRendering(renderNodeCreate.hasOverlappingRendering());
        }
        if (H) {
            throw new NoClassDefFoundError();
        }
        renderNodeCreate.setClipToBounds(false);
        CompositingStrategy.Companion companion2 = CompositingStrategy.f26113b;
        Q(companion2.a());
        this.f26162k = companion2.a();
        this.f26163l = BlendMode.f25667b.B();
        this.f26165n = 1.0f;
        this.f26167p = Offset.f25596b.b();
        this.f26168q = 1.0f;
        this.f26169r = 1.0f;
        Color.Companion companion3 = Color.f25715b;
        this.f26173v = companion3.a();
        this.f26174w = companion3.a();
        this.A = 8.0f;
        this.F = true;
    }

    private final void O() {
        boolean z2 = false;
        boolean z3 = S() && !this.f26160i;
        if (S() && this.f26160i) {
            z2 = true;
        }
        if (z3 != this.C) {
            this.C = z3;
            this.f26156e.setClipToBounds(z3);
        }
        if (z2 != this.D) {
            this.D = z2;
            this.f26156e.setClipToOutline(z2);
        }
    }

    private final void Q(int i3) {
        RenderNode renderNode = this.f26156e;
        CompositingStrategy.Companion companion = CompositingStrategy.f26113b;
        if (CompositingStrategy.f(i3, companion.c())) {
            renderNode.setLayerType(2);
            renderNode.setLayerPaint(this.f26158g);
            renderNode.setHasOverlappingRendering(true);
        } else if (CompositingStrategy.f(i3, companion.b())) {
            renderNode.setLayerType(0);
            renderNode.setLayerPaint(this.f26158g);
            renderNode.setHasOverlappingRendering(false);
        } else {
            renderNode.setLayerType(0);
            renderNode.setLayerPaint(this.f26158g);
            renderNode.setHasOverlappingRendering(true);
        }
    }

    private final boolean T() {
        return (!CompositingStrategy.f(r(), CompositingStrategy.f26113b.c()) && BlendMode.F(m(), BlendMode.f25667b.B()) && b() == null) ? false : true;
    }

    private final void U() {
        if (T()) {
            Q(CompositingStrategy.f26113b.c());
        } else {
            Q(r());
        }
    }

    private final void V(RenderNode renderNode) {
        RenderNodeVerificationHelper28 renderNodeVerificationHelper28 = RenderNodeVerificationHelper28.f26255a;
        renderNodeVerificationHelper28.c(renderNode, renderNodeVerificationHelper28.a(renderNode));
        renderNodeVerificationHelper28.d(renderNode, renderNodeVerificationHelper28.b(renderNode));
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float A() {
        return this.A;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void B(boolean z2) {
        this.B = z2;
        O();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void C(long j3) {
        this.f26174w = j3;
        RenderNodeVerificationHelper28.f26255a.d(this.f26156e, ColorKt.k(j3));
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float D() {
        return this.f26168q;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void E(float f3) {
        this.f26172u = f3;
        this.f26156e.setElevation(f3);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void F(boolean z2) {
        this.F = z2;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void G(Outline outline, long j3) {
        this.f26161j = j3;
        this.f26156e.setOutline(outline);
        this.f26160i = outline != null;
        O();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void H(long j3) {
        this.f26167p = j3;
        if ((9223372034707292159L & j3) == 9205357640488583168L) {
            this.f26166o = true;
            this.f26156e.setPivotX(((int) (this.f26157f >> 32)) / 2.0f);
            this.f26156e.setPivotY(((int) (4294967295L & this.f26157f)) / 2.0f);
        } else {
            this.f26166o = false;
            this.f26156e.setPivotX(Float.intBitsToFloat((int) (j3 >> 32)));
            this.f26156e.setPivotY(Float.intBitsToFloat((int) (j3 & 4294967295L)));
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void I(int i3) {
        this.f26162k = i3;
        U();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float J() {
        return this.f26171t;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float K() {
        return this.f26170s;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float L() {
        return this.f26175x;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float M() {
        return this.f26172u;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void N(Canvas canvas) {
        DisplayListCanvas displayListCanvasD = AndroidCanvas_androidKt.d(canvas);
        Intrinsics.checkNotNull(displayListCanvasD, "null cannot be cast to non-null type android.view.DisplayListCanvas");
        displayListCanvasD.drawRenderNode(this.f26156e);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float P() {
        return this.f26169r;
    }

    public final void R() {
        RenderNodeVerificationHelper24.f26254a.a(this.f26156e);
    }

    public boolean S() {
        return this.B;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float a() {
        return this.f26165n;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public ColorFilter b() {
        return this.f26164m;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void c(float f3) {
        this.f26165n = f3;
        this.f26156e.setAlpha(f3);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void d(float f3) {
        this.f26171t = f3;
        this.f26156e.setTranslationY(f3);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void e(float f3) {
        this.f26168q = f3;
        this.f26156e.setScaleX(f3);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void f(RenderEffect renderEffect) {
        this.E = renderEffect;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void g(float f3) {
        this.A = f3;
        this.f26156e.setCameraDistance(-f3);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void h(float f3) {
        this.f26175x = f3;
        this.f26156e.setRotationX(f3);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void i(float f3) {
        this.f26176y = f3;
        this.f26156e.setRotationY(f3);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void j(float f3) {
        this.f26177z = f3;
        this.f26156e.setRotation(f3);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void k(float f3) {
        this.f26169r = f3;
        this.f26156e.setScaleY(f3);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void l(float f3) {
        this.f26170s = f3;
        this.f26156e.setTranslationX(f3);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public int m() {
        return this.f26163l;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void n() {
        R();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public boolean o() {
        return this.f26156e.isValid();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public RenderEffect p() {
        return this.E;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void q(Density density, LayoutDirection layoutDirection, GraphicsLayer graphicsLayer, Function1 function1) {
        android.graphics.Canvas canvasStart = this.f26156e.start(Math.max((int) (this.f26157f >> 32), (int) (this.f26161j >> 32)), Math.max((int) (this.f26157f & 4294967295L), (int) (this.f26161j & 4294967295L)));
        try {
            CanvasHolder canvasHolder = this.f26154c;
            android.graphics.Canvas canvasB = canvasHolder.a().B();
            canvasHolder.a().C(canvasStart);
            AndroidCanvas androidCanvasA = canvasHolder.a();
            CanvasDrawScope canvasDrawScope = this.f26155d;
            long jE = IntSizeKt.e(this.f26157f);
            Density density2 = canvasDrawScope.Q1().getDensity();
            LayoutDirection layoutDirection2 = canvasDrawScope.Q1().getLayoutDirection();
            Canvas canvasG = canvasDrawScope.Q1().g();
            long jB = canvasDrawScope.Q1().b();
            GraphicsLayer graphicsLayerI = canvasDrawScope.Q1().i();
            DrawContext drawContextQ1 = canvasDrawScope.Q1();
            drawContextQ1.d(density);
            drawContextQ1.c(layoutDirection);
            drawContextQ1.j(androidCanvasA);
            drawContextQ1.h(jE);
            drawContextQ1.f(graphicsLayer);
            androidCanvasA.t();
            try {
                function1.invoke(canvasDrawScope);
                androidCanvasA.k();
                DrawContext drawContextQ12 = canvasDrawScope.Q1();
                drawContextQ12.d(density2);
                drawContextQ12.c(layoutDirection2);
                drawContextQ12.j(canvasG);
                drawContextQ12.h(jB);
                drawContextQ12.f(graphicsLayerI);
                canvasHolder.a().C(canvasB);
                this.f26156e.end(canvasStart);
                F(false);
            } catch (Throwable th) {
                androidCanvasA.k();
                DrawContext drawContextQ13 = canvasDrawScope.Q1();
                drawContextQ13.d(density2);
                drawContextQ13.c(layoutDirection2);
                drawContextQ13.j(canvasG);
                drawContextQ13.h(jB);
                drawContextQ13.f(graphicsLayerI);
                throw th;
            }
        } catch (Throwable th2) {
            this.f26156e.end(canvasStart);
            throw th2;
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public int r() {
        return this.f26162k;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void s(int i3, int i4, long j3) {
        int i5 = (int) (j3 >> 32);
        int i6 = (int) (4294967295L & j3);
        this.f26156e.setLeftTopRightBottom(i3, i4, i3 + i5, i4 + i6);
        if (IntSize.e(this.f26157f, j3)) {
            return;
        }
        if (this.f26166o) {
            this.f26156e.setPivotX(i5 / 2.0f);
            this.f26156e.setPivotY(i6 / 2.0f);
        }
        this.f26157f = j3;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float t() {
        return this.f26176y;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public long u() {
        return this.f26173v;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public long v() {
        return this.f26174w;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float w() {
        return this.f26177z;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public Matrix x() {
        Matrix matrix = this.f26159h;
        if (matrix == null) {
            matrix = new Matrix();
            this.f26159h = matrix;
        }
        this.f26156e.getMatrix(matrix);
        return matrix;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void y(long j3) {
        this.f26173v = j3;
        RenderNodeVerificationHelper28.f26255a.c(this.f26156e, ColorKt.k(j3));
    }

    public /* synthetic */ GraphicsLayerV23(View view, long j3, CanvasHolder canvasHolder, CanvasDrawScope canvasDrawScope, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, j3, (i3 & 4) != 0 ? new CanvasHolder() : canvasHolder, (i3 & 8) != 0 ? new CanvasDrawScope() : canvasDrawScope);
    }
}
