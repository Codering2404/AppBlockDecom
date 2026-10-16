package androidx.compose.ui.graphics.layer;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.layer.CompositingStrategy;
import androidx.compose.ui.graphics.layer.view.DrawChildContainer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class GraphicsViewLayer implements GraphicsLayerImpl {
    public static final Companion L = new Companion(null);
    private static final boolean M = !SurfaceUtils.f26256a.a();
    private static final Canvas N = new Canvas() { // from class: androidx.compose.ui.graphics.layer.GraphicsViewLayer$Companion$PlaceholderCanvas$1
        @Override // android.graphics.Canvas
        public boolean isHardwareAccelerated() {
            return true;
        }
    };
    private float A;
    private float B;
    private float C;
    private float D;
    private long E;
    private long F;
    private float G;
    private float H;
    private float I;
    private RenderEffect J;
    private final boolean K;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DrawChildContainer f26203b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f26204c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CanvasHolder f26205d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ViewLayer f26206e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Resources f26207f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Rect f26208g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Paint f26209h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Picture f26210i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final CanvasDrawScope f26211j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final CanvasHolder f26212k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f26213l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f26214m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f26215n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f26216o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f26217p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f26218q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f26219r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final long f26220s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f26221t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private ColorFilter f26222u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f26223v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private float f26224w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f26225x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private long f26226y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private float f26227z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public GraphicsViewLayer(DrawChildContainer drawChildContainer, long j3, CanvasHolder canvasHolder, CanvasDrawScope canvasDrawScope) {
        this.f26203b = drawChildContainer;
        this.f26204c = j3;
        this.f26205d = canvasHolder;
        ViewLayer viewLayer = new ViewLayer(drawChildContainer, canvasHolder, canvasDrawScope);
        this.f26206e = viewLayer;
        this.f26207f = drawChildContainer.getResources();
        this.f26208g = new Rect();
        boolean z2 = M;
        this.f26210i = z2 ? new Picture() : null;
        this.f26211j = z2 ? new CanvasDrawScope() : null;
        this.f26212k = z2 ? new CanvasHolder() : null;
        drawChildContainer.addView(viewLayer);
        viewLayer.setClipBounds(null);
        this.f26215n = IntSize.f29998b.a();
        this.f26217p = true;
        this.f26220s = View.generateViewId();
        this.f26221t = BlendMode.f25667b.B();
        this.f26223v = CompositingStrategy.f26113b.a();
        this.f26224w = 1.0f;
        this.f26226y = Offset.f25596b.c();
        this.f26227z = 1.0f;
        this.A = 1.0f;
        Color.Companion companion = Color.f25715b;
        this.E = companion.a();
        this.F = companion.a();
        this.K = z2;
    }

    private final void O(int i3) {
        ViewLayer viewLayer = this.f26206e;
        CompositingStrategy.Companion companion = CompositingStrategy.f26113b;
        boolean z2 = true;
        if (CompositingStrategy.f(i3, companion.c())) {
            this.f26206e.setLayerType(2, this.f26209h);
        } else if (CompositingStrategy.f(i3, companion.b())) {
            this.f26206e.setLayerType(0, this.f26209h);
            z2 = false;
        } else {
            this.f26206e.setLayerType(0, this.f26209h);
        }
        viewLayer.setCanUseCompositingLayer$ui_graphics_release(z2);
    }

    private final void R() {
        try {
            CanvasHolder canvasHolder = this.f26205d;
            Canvas canvas = N;
            Canvas canvasB = canvasHolder.a().B();
            canvasHolder.a().C(canvas);
            AndroidCanvas androidCanvasA = canvasHolder.a();
            DrawChildContainer drawChildContainer = this.f26203b;
            ViewLayer viewLayer = this.f26206e;
            drawChildContainer.a(androidCanvasA, viewLayer, viewLayer.getDrawingTime());
            canvasHolder.a().C(canvasB);
        } catch (Throwable unused) {
        }
    }

    private final boolean S() {
        return CompositingStrategy.f(r(), CompositingStrategy.f26113b.c()) || T();
    }

    private final boolean T() {
        return (BlendMode.F(m(), BlendMode.f25667b.B()) && b() == null) ? false : true;
    }

    private final void U() {
        Rect rect;
        if (this.f26216o) {
            ViewLayer viewLayer = this.f26206e;
            if (!Q() || this.f26218q) {
                rect = null;
            } else {
                rect = this.f26208g;
                rect.left = 0;
                rect.top = 0;
                rect.right = this.f26206e.getWidth();
                rect.bottom = this.f26206e.getHeight();
            }
            viewLayer.setClipBounds(rect);
        }
    }

    private final void V() {
        if (S()) {
            O(CompositingStrategy.f26113b.c());
        } else {
            O(r());
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float A() {
        return this.f26206e.getCameraDistance() / this.f26207f.getDisplayMetrics().densityDpi;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void B(boolean z2) {
        boolean z3 = false;
        this.f26219r = z2 && !this.f26218q;
        this.f26216o = true;
        ViewLayer viewLayer = this.f26206e;
        if (z2 && this.f26218q) {
            z3 = true;
        }
        viewLayer.setClipToOutline(z3);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void C(long j3) {
        this.F = j3;
        ViewLayerVerificationHelper28.f26270a.c(this.f26206e, ColorKt.k(j3));
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float D() {
        return this.f26227z;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void E(float f3) {
        this.D = f3;
        this.f26206e.setElevation(f3);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void F(boolean z2) {
        this.f26217p = z2;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void G(Outline outline, long j3) {
        boolean zD = this.f26206e.d(outline);
        if (Q() && outline != null) {
            this.f26206e.setClipToOutline(true);
            if (this.f26219r) {
                this.f26219r = false;
                this.f26216o = true;
            }
        }
        this.f26218q = outline != null;
        if (zD) {
            return;
        }
        this.f26206e.invalidate();
        R();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void H(long j3) {
        this.f26226y = j3;
        if ((9223372034707292159L & j3) == 9205357640488583168L) {
            ViewLayerVerificationHelper28.f26270a.a(this.f26206e);
            return;
        }
        this.f26225x = false;
        this.f26206e.setPivotX(Float.intBitsToFloat((int) (j3 >> 32)));
        this.f26206e.setPivotY(Float.intBitsToFloat((int) (j3 & 4294967295L)));
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void I(int i3) {
        this.f26223v = i3;
        V();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float J() {
        return this.C;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float K() {
        return this.B;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float L() {
        return this.G;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float M() {
        return this.D;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void N(androidx.compose.ui.graphics.Canvas canvas) {
        U();
        Canvas canvasD = AndroidCanvas_androidKt.d(canvas);
        if (canvasD.isHardwareAccelerated()) {
            DrawChildContainer drawChildContainer = this.f26203b;
            ViewLayer viewLayer = this.f26206e;
            drawChildContainer.a(canvas, viewLayer, viewLayer.getDrawingTime());
        } else {
            Picture picture = this.f26210i;
            if (picture != null) {
                canvasD.drawPicture(picture);
            }
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float P() {
        return this.A;
    }

    public boolean Q() {
        return this.f26219r || this.f26206e.getClipToOutline();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float a() {
        return this.f26224w;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public ColorFilter b() {
        return this.f26222u;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void c(float f3) {
        this.f26224w = f3;
        this.f26206e.setAlpha(f3);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void d(float f3) {
        this.C = f3;
        this.f26206e.setTranslationY(f3);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void e(float f3) {
        this.f26227z = f3;
        this.f26206e.setScaleX(f3);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void f(RenderEffect renderEffect) {
        this.J = renderEffect;
        if (Build.VERSION.SDK_INT >= 31) {
            ViewLayerVerificationHelper31.f26271a.a(this.f26206e, renderEffect);
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void g(float f3) {
        this.f26206e.setCameraDistance(f3 * this.f26207f.getDisplayMetrics().densityDpi);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void h(float f3) {
        this.G = f3;
        this.f26206e.setRotationX(f3);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void i(float f3) {
        this.H = f3;
        this.f26206e.setRotationY(f3);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void j(float f3) {
        this.I = f3;
        this.f26206e.setRotation(f3);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void k(float f3) {
        this.A = f3;
        this.f26206e.setScaleY(f3);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void l(float f3) {
        this.B = f3;
        this.f26206e.setTranslationX(f3);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public int m() {
        return this.f26221t;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void n() {
        this.f26203b.removeViewInLayout(this.f26206e);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public RenderEffect p() {
        return this.J;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void q(Density density, LayoutDirection layoutDirection, GraphicsLayer graphicsLayer, Function1 function1) {
        CanvasHolder canvasHolder;
        Canvas canvas;
        if (this.f26206e.getParent() == null) {
            this.f26203b.addView(this.f26206e);
        }
        this.f26206e.c(density, layoutDirection, graphicsLayer, function1);
        if (this.f26206e.isAttachedToWindow()) {
            this.f26206e.setVisibility(4);
            this.f26206e.setVisibility(0);
            R();
            Picture picture = this.f26210i;
            if (picture != null) {
                long j3 = this.f26215n;
                Canvas canvasBeginRecording = picture.beginRecording((int) (j3 >> 32), (int) (j3 & 4294967295L));
                try {
                    CanvasHolder canvasHolder2 = this.f26212k;
                    if (canvasHolder2 != null) {
                        Canvas canvasB = canvasHolder2.a().B();
                        canvasHolder2.a().C(canvasBeginRecording);
                        AndroidCanvas androidCanvasA = canvasHolder2.a();
                        CanvasDrawScope canvasDrawScope = this.f26211j;
                        if (canvasDrawScope != null) {
                            long jE = IntSizeKt.e(this.f26215n);
                            Density density2 = canvasDrawScope.Q1().getDensity();
                            LayoutDirection layoutDirection2 = canvasDrawScope.Q1().getLayoutDirection();
                            androidx.compose.ui.graphics.Canvas canvasG = canvasDrawScope.Q1().g();
                            canvasHolder = canvasHolder2;
                            canvas = canvasB;
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
                        } else {
                            canvasHolder = canvasHolder2;
                            canvas = canvasB;
                        }
                        canvasHolder.a().C(canvas);
                        Unit unit = Unit.f139807a;
                    }
                    picture.endRecording();
                } catch (Throwable th2) {
                    picture.endRecording();
                    throw th2;
                }
            }
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public int r() {
        return this.f26223v;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void s(int i3, int i4, long j3) {
        if (IntSize.e(this.f26215n, j3)) {
            int i5 = this.f26213l;
            if (i5 != i3) {
                this.f26206e.offsetLeftAndRight(i3 - i5);
            }
            int i6 = this.f26214m;
            if (i6 != i4) {
                this.f26206e.offsetTopAndBottom(i4 - i6);
            }
        } else {
            if (Q()) {
                this.f26216o = true;
            }
            int i7 = (int) (j3 >> 32);
            int i8 = (int) (4294967295L & j3);
            this.f26206e.layout(i3, i4, i3 + i7, i4 + i8);
            this.f26215n = j3;
            if (this.f26225x) {
                this.f26206e.setPivotX(i7 / 2.0f);
                this.f26206e.setPivotY(i8 / 2.0f);
            }
        }
        this.f26213l = i3;
        this.f26214m = i4;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float t() {
        return this.H;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public long u() {
        return this.E;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public long v() {
        return this.F;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float w() {
        return this.I;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public Matrix x() {
        return this.f26206e.getMatrix();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void y(long j3) {
        this.E = j3;
        ViewLayerVerificationHelper28.f26270a.b(this.f26206e, ColorKt.k(j3));
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public boolean z() {
        return this.K;
    }

    public /* synthetic */ GraphicsViewLayer(DrawChildContainer drawChildContainer, long j3, CanvasHolder canvasHolder, CanvasDrawScope canvasDrawScope, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(drawChildContainer, j3, (i3 & 4) != 0 ? new CanvasHolder() : canvasHolder, (i3 & 8) != 0 ? new CanvasDrawScope() : canvasDrawScope);
    }
}
