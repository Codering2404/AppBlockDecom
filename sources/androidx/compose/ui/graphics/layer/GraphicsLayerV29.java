package androidx.compose.ui.graphics.layer;

import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.RecordingCanvas;
import android.graphics.RenderNode;
import android.os.Build;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
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
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class GraphicsLayerV29 implements GraphicsLayerImpl {
    private boolean A;
    private RenderEffect B;
    private int C;
    private boolean D;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f26178b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CanvasHolder f26179c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CanvasDrawScope f26180d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final RenderNode f26181e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f26182f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Paint f26183g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Matrix f26184h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f26185i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f26186j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f26187k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ColorFilter f26188l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f26189m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f26190n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f26191o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float f26192p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f26193q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f26194r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f26195s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private long f26196t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private float f26197u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private float f26198v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private float f26199w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private float f26200x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f26201y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f26202z;

    public GraphicsLayerV29(long j3, CanvasHolder canvasHolder, CanvasDrawScope canvasDrawScope) {
        this.f26178b = j3;
        this.f26179c = canvasHolder;
        this.f26180d = canvasDrawScope;
        RenderNode renderNodeA = androidx.compose.foundation.j.a("graphicsLayer");
        this.f26181e = renderNodeA;
        this.f26182f = Size.f25617b.b();
        renderNodeA.setClipToBounds(false);
        CompositingStrategy.Companion companion = CompositingStrategy.f26113b;
        Q(renderNodeA, companion.a());
        this.f26186j = 1.0f;
        this.f26187k = BlendMode.f25667b.B();
        this.f26189m = Offset.f25596b.b();
        this.f26190n = 1.0f;
        this.f26191o = 1.0f;
        Color.Companion companion2 = Color.f25715b;
        this.f26195s = companion2.a();
        this.f26196t = companion2.a();
        this.f26200x = 8.0f;
        this.C = companion.a();
        this.D = true;
    }

    private final void O() {
        boolean z2 = false;
        boolean z3 = R() && !this.f26185i;
        if (R() && this.f26185i) {
            z2 = true;
        }
        if (z3 != this.f26202z) {
            this.f26202z = z3;
            this.f26181e.setClipToBounds(z3);
        }
        if (z2 != this.A) {
            this.A = z2;
            this.f26181e.setClipToOutline(z2);
        }
    }

    private final void Q(RenderNode renderNode, int i3) {
        CompositingStrategy.Companion companion = CompositingStrategy.f26113b;
        if (CompositingStrategy.f(i3, companion.c())) {
            renderNode.setUseCompositingLayer(true, this.f26183g);
            renderNode.setHasOverlappingRendering(true);
        } else if (CompositingStrategy.f(i3, companion.b())) {
            renderNode.setUseCompositingLayer(false, this.f26183g);
            renderNode.setHasOverlappingRendering(false);
        } else {
            renderNode.setUseCompositingLayer(false, this.f26183g);
            renderNode.setHasOverlappingRendering(true);
        }
    }

    private final boolean S() {
        return CompositingStrategy.f(r(), CompositingStrategy.f26113b.c()) || T() || p() != null;
    }

    private final boolean T() {
        return (BlendMode.F(m(), BlendMode.f25667b.B()) && b() == null) ? false : true;
    }

    private final void U() {
        if (S()) {
            Q(this.f26181e, CompositingStrategy.f26113b.c());
        } else {
            Q(this.f26181e, r());
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float A() {
        return this.f26200x;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void B(boolean z2) {
        this.f26201y = z2;
        O();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void C(long j3) {
        this.f26196t = j3;
        this.f26181e.setSpotShadowColor(ColorKt.k(j3));
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float D() {
        return this.f26190n;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void E(float f3) {
        this.f26194r = f3;
        this.f26181e.setElevation(f3);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void F(boolean z2) {
        this.D = z2;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void G(Outline outline, long j3) {
        this.f26181e.setOutline(outline);
        this.f26185i = outline != null;
        O();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void H(long j3) {
        this.f26189m = j3;
        if ((9223372034707292159L & j3) == 9205357640488583168L) {
            this.f26181e.resetPivot();
        } else {
            this.f26181e.setPivotX(Float.intBitsToFloat((int) (j3 >> 32)));
            this.f26181e.setPivotY(Float.intBitsToFloat((int) (j3 & 4294967295L)));
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void I(int i3) {
        this.C = i3;
        U();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float J() {
        return this.f26193q;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float K() {
        return this.f26192p;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float L() {
        return this.f26197u;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float M() {
        return this.f26194r;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void N(Canvas canvas) {
        AndroidCanvas_androidKt.d(canvas).drawRenderNode(this.f26181e);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float P() {
        return this.f26191o;
    }

    public boolean R() {
        return this.f26201y;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float a() {
        return this.f26186j;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public ColorFilter b() {
        return this.f26188l;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void c(float f3) {
        this.f26186j = f3;
        this.f26181e.setAlpha(f3);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void d(float f3) {
        this.f26193q = f3;
        this.f26181e.setTranslationY(f3);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void e(float f3) {
        this.f26190n = f3;
        this.f26181e.setScaleX(f3);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void f(RenderEffect renderEffect) {
        this.B = renderEffect;
        if (Build.VERSION.SDK_INT >= 31) {
            RenderNodeVerificationHelper.f26252a.a(this.f26181e, renderEffect);
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void g(float f3) {
        this.f26200x = f3;
        this.f26181e.setCameraDistance(f3);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void h(float f3) {
        this.f26197u = f3;
        this.f26181e.setRotationX(f3);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void i(float f3) {
        this.f26198v = f3;
        this.f26181e.setRotationY(f3);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void j(float f3) {
        this.f26199w = f3;
        this.f26181e.setRotationZ(f3);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void k(float f3) {
        this.f26191o = f3;
        this.f26181e.setScaleY(f3);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void l(float f3) {
        this.f26192p = f3;
        this.f26181e.setTranslationX(f3);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public int m() {
        return this.f26187k;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void n() {
        this.f26181e.discardDisplayList();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public boolean o() {
        return this.f26181e.hasDisplayList();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public RenderEffect p() {
        return this.B;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void q(Density density, LayoutDirection layoutDirection, GraphicsLayer graphicsLayer, Function1 function1) {
        RecordingCanvas recordingCanvasBeginRecording = this.f26181e.beginRecording();
        try {
            CanvasHolder canvasHolder = this.f26179c;
            android.graphics.Canvas canvasB = canvasHolder.a().B();
            canvasHolder.a().C(recordingCanvasBeginRecording);
            AndroidCanvas androidCanvasA = canvasHolder.a();
            DrawContext drawContextQ1 = this.f26180d.Q1();
            drawContextQ1.d(density);
            drawContextQ1.c(layoutDirection);
            drawContextQ1.f(graphicsLayer);
            drawContextQ1.h(this.f26182f);
            drawContextQ1.j(androidCanvasA);
            function1.invoke(this.f26180d);
            canvasHolder.a().C(canvasB);
            this.f26181e.endRecording();
            F(false);
        } catch (Throwable th) {
            this.f26181e.endRecording();
            throw th;
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public int r() {
        return this.C;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void s(int i3, int i4, long j3) {
        this.f26181e.setPosition(i3, i4, ((int) (j3 >> 32)) + i3, ((int) (4294967295L & j3)) + i4);
        this.f26182f = IntSizeKt.e(j3);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float t() {
        return this.f26198v;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public long u() {
        return this.f26195s;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public long v() {
        return this.f26196t;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float w() {
        return this.f26199w;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public Matrix x() {
        Matrix matrix = this.f26184h;
        if (matrix == null) {
            matrix = new Matrix();
            this.f26184h = matrix;
        }
        this.f26181e.getMatrix(matrix);
        return matrix;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void y(long j3) {
        this.f26195s = j3;
        this.f26181e.setAmbientShadowColor(ColorKt.k(j3));
    }

    public /* synthetic */ GraphicsLayerV29(long j3, CanvasHolder canvasHolder, CanvasDrawScope canvasDrawScope, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, (i3 & 2) != 0 ? new CanvasHolder() : canvasHolder, (i3 & 4) != 0 ? new CanvasDrawScope() : canvasDrawScope);
    }
}
