package androidx.compose.ui.graphics.layer;

import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.RectF;
import android.os.Build;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawContextKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
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
public final class GraphicsLayer {
    private static final LayerSnapshotImpl A;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final Companion f26118z = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final GraphicsLayerImpl f26119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LayerManager f26120b;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Outline f26125g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f26127i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f26128j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f26129k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private androidx.compose.ui.graphics.Outline f26130l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Path f26131m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Path f26132n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f26133o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private CanvasDrawScope f26134p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Paint f26135q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f26136r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final ChildLayerDependenciesTracker f26137s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f26138t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private long f26139u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private long f26140v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private long f26141w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f26142x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private RectF f26143y;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Density f26121c = DrawContextKt.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private LayoutDirection f26122d = LayoutDirection.f30001a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Function1 f26123e = new Function1<DrawScope, Unit>() { // from class: androidx.compose.ui.graphics.layer.GraphicsLayer$drawBlock$1
        public final void invoke(DrawScope drawScope) {
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((DrawScope) obj);
            return Unit.f139807a;
        }
    };

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Function1 f26124f = new Function1<DrawScope, Unit>() { // from class: androidx.compose.ui.graphics.layer.GraphicsLayer$clipDrawBlock$1
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((DrawScope) obj);
            return Unit.f139807a;
        }

        public final void invoke(DrawScope drawScope) {
            Path path = this.f26144a.f26131m;
            if (!this.f26144a.f26133o || !this.f26144a.m() || path == null) {
                this.f26144a.j(drawScope);
                return;
            }
            GraphicsLayer graphicsLayer = this.f26144a;
            int iB = ClipOp.f25711b.b();
            DrawContext drawContextQ1 = drawScope.Q1();
            long jB = drawContextQ1.b();
            drawContextQ1.g().t();
            try {
                drawContextQ1.e().d(path, iB);
                graphicsLayer.j(drawScope);
            } finally {
                drawContextQ1.g().k();
                drawContextQ1.h(jB);
            }
        }
    };

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f26126h = true;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        A = LayerManager.f26228g.a() ? LayerSnapshotV21.f26236a : LayerSnapshotV28.f26247a;
    }

    public GraphicsLayer(GraphicsLayerImpl graphicsLayerImpl, LayerManager layerManager) {
        this.f26119a = graphicsLayerImpl;
        this.f26120b = layerManager;
        Offset.Companion companion = Offset.f25596b;
        this.f26127i = companion.c();
        this.f26128j = Size.f25617b.a();
        this.f26137s = new ChildLayerDependenciesTracker();
        graphicsLayerImpl.B(false);
        this.f26139u = IntOffset.f29988b.b();
        this.f26140v = IntSize.f29998b.a();
        this.f26141w = companion.b();
    }

    private final Outline C() {
        Outline outline = this.f26125g;
        if (outline != null) {
            return outline;
        }
        Outline outline2 = new Outline();
        this.f26125g = outline2;
        return outline2;
    }

    private final RectF D() {
        RectF rectF = this.f26143y;
        if (rectF != null) {
            return rectF;
        }
        RectF rectF2 = new RectF();
        this.f26143y = rectF2;
        return rectF2;
    }

    private final void E() {
        this.f26136r++;
    }

    private final void F() {
        this.f26136r--;
        f();
    }

    private final void H() {
        this.f26119a.q(this.f26121c, this.f26122d, this, this.f26124f);
    }

    private final void I() {
        if (this.f26119a.o()) {
            return;
        }
        try {
            H();
        } catch (Throwable unused) {
        }
    }

    private final void K() {
        this.f26130l = null;
        this.f26131m = null;
        this.f26128j = Size.f25617b.a();
        this.f26127i = Offset.f25596b.c();
        this.f26129k = 0.0f;
        this.f26126h = true;
        this.f26133o = false;
    }

    private final void S(long j3, long j4) {
        this.f26119a.s(IntOffset.k(j3), IntOffset.l(j3), j4);
    }

    private final void c0(long j3) {
        if (IntSize.e(this.f26140v, j3)) {
            return;
        }
        this.f26140v = j3;
        S(this.f26139u, j3);
        if (this.f26128j == 9205357640488583168L) {
            this.f26126h = true;
            e();
        }
    }

    private final void d(GraphicsLayer graphicsLayer) {
        if (this.f26137s.i(graphicsLayer)) {
            graphicsLayer.E();
        }
    }

    private final void e() {
        if (this.f26126h) {
            Outline outline = null;
            if (this.f26142x || w() > 0.0f) {
                Path path = this.f26131m;
                if (path != null) {
                    RectF rectFD = D();
                    if (!(path instanceof AndroidPath)) {
                        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
                    }
                    ((AndroidPath) path).A().computeBounds(rectFD, false);
                    Outline outlineJ0 = j0(path);
                    if (outlineJ0 != null) {
                        outlineJ0.setAlpha(k());
                        outline = outlineJ0;
                    }
                    this.f26119a.G(outline, IntSize.c((4294967295L & ((long) Math.round(rectFD.height()))) | (((long) Math.round(rectFD.width())) << 32)));
                    if (this.f26133o && this.f26142x) {
                        this.f26119a.B(false);
                        this.f26119a.n();
                    } else {
                        this.f26119a.B(this.f26142x);
                    }
                } else {
                    this.f26119a.B(this.f26142x);
                    Size.f25617b.b();
                    Outline outlineC = C();
                    long jE = IntSizeKt.e(this.f26140v);
                    long j3 = this.f26127i;
                    long j4 = this.f26128j;
                    long j5 = j4 == 9205357640488583168L ? jE : j4;
                    int i3 = (int) (j3 >> 32);
                    int i4 = (int) (j3 & 4294967295L);
                    outlineC.setRoundRect(Math.round(Float.intBitsToFloat(i3)), Math.round(Float.intBitsToFloat(i4)), Math.round(Float.intBitsToFloat(i3) + Float.intBitsToFloat((int) (j5 >> 32))), Math.round(Float.intBitsToFloat(i4) + Float.intBitsToFloat((int) (j5 & 4294967295L))), this.f26129k);
                    outlineC.setAlpha(k());
                    this.f26119a.G(outlineC, IntSizeKt.c(j5));
                }
            } else {
                this.f26119a.B(false);
                this.f26119a.G(null, IntSize.f29998b.a());
            }
        }
        this.f26126h = false;
    }

    private final void f() {
        if (this.f26138t && this.f26136r == 0) {
            LayerManager layerManager = this.f26120b;
            if (layerManager != null) {
                layerManager.f(this);
            } else {
                g();
            }
        }
    }

    private final void i0(Canvas canvas) {
        Canvas canvas2;
        float fK = IntOffset.k(this.f26139u);
        float fL = IntOffset.l(this.f26139u);
        float fK2 = IntOffset.k(this.f26139u) + ((int) (this.f26140v >> 32));
        float fL2 = IntOffset.l(this.f26139u) + ((int) (this.f26140v & 4294967295L));
        float fK3 = k();
        ColorFilter colorFilterN = n();
        int iL = l();
        if (fK3 < 1.0f || !BlendMode.F(iL, BlendMode.f25667b.B()) || colorFilterN != null || CompositingStrategy.f(o(), CompositingStrategy.f26113b.c())) {
            Paint paintA = this.f26135q;
            if (paintA == null) {
                paintA = AndroidPaint_androidKt.a();
                this.f26135q = paintA;
            }
            paintA.c(fK3);
            paintA.p(iL);
            paintA.B(colorFilterN);
            canvas2 = canvas;
            canvas2.saveLayer(fK, fL, fK2, fL2, paintA.y());
        } else {
            canvas.save();
            canvas2 = canvas;
        }
        canvas2.translate(fK, fL);
        canvas2.concat(this.f26119a.x());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void j(androidx.compose.ui.graphics.drawscope.DrawScope r15) {
        /*
            r14 = this;
            androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker r0 = r14.f26137s
            androidx.compose.ui.graphics.layer.GraphicsLayer r1 = androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.b(r0)
            androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.g(r0, r1)
            androidx.collection.MutableScatterSet r1 = androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.a(r0)
            if (r1 == 0) goto L28
            boolean r2 = r1.f()
            if (r2 == 0) goto L28
            androidx.collection.MutableScatterSet r2 = androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.c(r0)
            if (r2 != 0) goto L22
            androidx.collection.MutableScatterSet r2 = androidx.collection.ScatterSetKt.a()
            androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.f(r0, r2)
        L22:
            r2.j(r1)
            r1.n()
        L28:
            r1 = 1
            androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.h(r0, r1)
            kotlin.jvm.functions.Function1 r1 = r14.f26123e
            r1.invoke(r15)
            r15 = 0
            androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.h(r0, r15)
            androidx.compose.ui.graphics.layer.GraphicsLayer r1 = androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.d(r0)
            if (r1 == 0) goto L3e
            r1.F()
        L3e:
            androidx.collection.MutableScatterSet r0 = androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.c(r0)
            if (r0 == 0) goto L91
            boolean r1 = r0.f()
            if (r1 == 0) goto L91
            java.lang.Object[] r1 = r0.f3116b
            long[] r2 = r0.f3115a
            int r3 = r2.length
            int r3 = r3 + (-2)
            if (r3 < 0) goto L8e
            r4 = r15
        L54:
            r5 = r2[r4]
            long r7 = ~r5
            r9 = 7
            long r7 = r7 << r9
            long r7 = r7 & r5
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L89
            int r7 = r4 - r3
            int r7 = ~r7
            int r7 = r7 >>> 31
            r8 = 8
            int r7 = 8 - r7
            r9 = r15
        L6e:
            if (r9 >= r7) goto L87
            r10 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r5
            r12 = 128(0x80, double:6.3E-322)
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L83
            int r10 = r4 << 3
            int r10 = r10 + r9
            r10 = r1[r10]
            androidx.compose.ui.graphics.layer.GraphicsLayer r10 = (androidx.compose.ui.graphics.layer.GraphicsLayer) r10
            r10.F()
        L83:
            long r5 = r5 >> r8
            int r9 = r9 + 1
            goto L6e
        L87:
            if (r7 != r8) goto L8e
        L89:
            if (r4 == r3) goto L8e
            int r4 = r4 + 1
            goto L54
        L8e:
            r0.n()
        L91:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.layer.GraphicsLayer.j(androidx.compose.ui.graphics.drawscope.DrawScope):void");
    }

    private final Outline j0(Path path) {
        Outline outline;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 > 28 || path.e()) {
            Outline outlineC = C();
            if (i3 >= 30) {
                OutlineVerificationHelper.f26251a.a(outlineC, path);
            } else {
                if (!(path instanceof AndroidPath)) {
                    throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
                }
                outlineC.setConvexPath(((AndroidPath) path).A());
            }
            this.f26133o = !outlineC.canClip();
            outline = outlineC;
        } else {
            Outline outline2 = this.f26125g;
            if (outline2 != null) {
                outline2.setEmpty();
            }
            this.f26133o = true;
            this.f26119a.F(true);
            outline = null;
        }
        this.f26131m = path;
        return outline;
    }

    public final float A() {
        return this.f26119a.J();
    }

    public final boolean B() {
        return this.f26138t;
    }

    public final void G(Density density, LayoutDirection layoutDirection, long j3, Function1 function1) {
        c0(j3);
        this.f26121c = density;
        this.f26122d = layoutDirection;
        this.f26123e = function1;
        this.f26119a.F(true);
        H();
    }

    public final void J() {
        if (this.f26138t) {
            return;
        }
        this.f26138t = true;
        f();
    }

    public final void L(float f3) {
        if (this.f26119a.a() == f3) {
            return;
        }
        this.f26119a.c(f3);
    }

    public final void M(long j3) {
        if (Color.t(j3, this.f26119a.u())) {
            return;
        }
        this.f26119a.y(j3);
    }

    public final void N(float f3) {
        if (this.f26119a.A() == f3) {
            return;
        }
        this.f26119a.g(f3);
    }

    public final void O(boolean z2) {
        if (this.f26142x != z2) {
            this.f26142x = z2;
            this.f26126h = true;
            e();
        }
    }

    public final void P(int i3) {
        if (CompositingStrategy.f(this.f26119a.r(), i3)) {
            return;
        }
        this.f26119a.I(i3);
    }

    public final void Q(Path path) {
        K();
        this.f26131m = path;
        e();
    }

    public final void R(long j3) {
        if (Offset.j(this.f26141w, j3)) {
            return;
        }
        this.f26141w = j3;
        this.f26119a.H(j3);
    }

    public final void T(long j3, long j4) {
        Y(j3, j4, 0.0f);
    }

    public final void U(RenderEffect renderEffect) {
        if (Intrinsics.areEqual(this.f26119a.p(), renderEffect)) {
            return;
        }
        this.f26119a.f(renderEffect);
    }

    public final void V(float f3) {
        if (this.f26119a.L() == f3) {
            return;
        }
        this.f26119a.h(f3);
    }

    public final void W(float f3) {
        if (this.f26119a.t() == f3) {
            return;
        }
        this.f26119a.i(f3);
    }

    public final void X(float f3) {
        if (this.f26119a.w() == f3) {
            return;
        }
        this.f26119a.j(f3);
    }

    public final void Y(long j3, long j4, float f3) {
        if (Offset.j(this.f26127i, j3) && Size.f(this.f26128j, j4) && this.f26129k == f3 && this.f26131m == null) {
            return;
        }
        K();
        this.f26127i = j3;
        this.f26128j = j4;
        this.f26129k = f3;
        e();
    }

    public final void Z(float f3) {
        if (this.f26119a.D() == f3) {
            return;
        }
        this.f26119a.e(f3);
    }

    public final void a0(float f3) {
        if (this.f26119a.P() == f3) {
            return;
        }
        this.f26119a.k(f3);
    }

    public final void b0(float f3) {
        if (this.f26119a.M() == f3) {
            return;
        }
        this.f26119a.E(f3);
        this.f26126h = true;
        e();
    }

    public final void d0(long j3) {
        if (Color.t(j3, this.f26119a.v())) {
            return;
        }
        this.f26119a.C(j3);
    }

    public final void e0(long j3) {
        if (IntOffset.j(this.f26139u, j3)) {
            return;
        }
        this.f26139u = j3;
        S(j3, this.f26140v);
    }

    public final void f0(float f3) {
        if (this.f26119a.K() == f3) {
            return;
        }
        this.f26119a.l(f3);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void g() {
        /*
            r15 = this;
            androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker r0 = r15.f26137s
            androidx.compose.ui.graphics.layer.GraphicsLayer r1 = androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.b(r0)
            if (r1 == 0) goto Lf
            r1.F()
            r1 = 0
            androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.e(r0, r1)
        Lf:
            androidx.collection.MutableScatterSet r0 = androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.a(r0)
            if (r0 == 0) goto L5d
            java.lang.Object[] r1 = r0.f3116b
            long[] r2 = r0.f3115a
            int r3 = r2.length
            int r3 = r3 + (-2)
            if (r3 < 0) goto L5a
            r4 = 0
            r5 = r4
        L20:
            r6 = r2[r5]
            long r8 = ~r6
            r10 = 7
            long r8 = r8 << r10
            long r8 = r8 & r6
            r10 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r8 = r8 & r10
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 == 0) goto L55
            int r8 = r5 - r3
            int r8 = ~r8
            int r8 = r8 >>> 31
            r9 = 8
            int r8 = 8 - r8
            r10 = r4
        L3a:
            if (r10 >= r8) goto L53
            r11 = 255(0xff, double:1.26E-321)
            long r11 = r11 & r6
            r13 = 128(0x80, double:6.3E-322)
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r11 >= 0) goto L4f
            int r11 = r5 << 3
            int r11 = r11 + r10
            r11 = r1[r11]
            androidx.compose.ui.graphics.layer.GraphicsLayer r11 = (androidx.compose.ui.graphics.layer.GraphicsLayer) r11
            r11.F()
        L4f:
            long r6 = r6 >> r9
            int r10 = r10 + 1
            goto L3a
        L53:
            if (r8 != r9) goto L5a
        L55:
            if (r5 == r3) goto L5a
            int r5 = r5 + 1
            goto L20
        L5a:
            r0.n()
        L5d:
            androidx.compose.ui.graphics.layer.GraphicsLayerImpl r0 = r15.f26119a
            r0.n()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.layer.GraphicsLayer.g():void");
    }

    public final void g0(float f3) {
        if (this.f26119a.J() == f3) {
            return;
        }
        this.f26119a.d(f3);
    }

    public final void h(androidx.compose.ui.graphics.Canvas canvas, GraphicsLayer graphicsLayer) {
        boolean z2;
        boolean z3;
        if (this.f26138t) {
            return;
        }
        e();
        I();
        boolean z4 = w() > 0.0f;
        if (z4) {
            canvas.n();
        }
        Canvas canvasD = AndroidCanvas_androidKt.d(canvas);
        boolean zIsHardwareAccelerated = canvasD.isHardwareAccelerated();
        if (!zIsHardwareAccelerated) {
            i0(canvasD);
        }
        boolean z5 = !zIsHardwareAccelerated && this.f26142x;
        if (z5) {
            canvas.t();
            androidx.compose.ui.graphics.Outline outlineP = p();
            if (outlineP instanceof Outline.Rectangle) {
                androidx.compose.ui.graphics.Canvas.s(canvas, outlineP.a(), 0, 2, null);
            } else if (outlineP instanceof Outline.Rounded) {
                Path pathA = this.f26132n;
                if (pathA != null) {
                    pathA.r();
                } else {
                    pathA = AndroidPath_androidKt.a();
                    this.f26132n = pathA;
                }
                Path.s(pathA, ((Outline.Rounded) outlineP).b(), null, 2, null);
                androidx.compose.ui.graphics.Canvas.l(canvas, pathA, 0, 2, null);
            } else if (outlineP instanceof Outline.Generic) {
                androidx.compose.ui.graphics.Canvas.l(canvas, ((Outline.Generic) outlineP).b(), 0, 2, null);
            }
        }
        if (graphicsLayer != null) {
            graphicsLayer.d(this);
        }
        if (AndroidCanvas_androidKt.d(canvas).isHardwareAccelerated() || this.f26119a.z()) {
            z2 = z4;
            z3 = z5;
            this.f26119a.N(canvas);
        } else {
            CanvasDrawScope canvasDrawScope = this.f26134p;
            if (canvasDrawScope == null) {
                canvasDrawScope = new CanvasDrawScope();
                this.f26134p = canvasDrawScope;
            }
            DrawScope drawScope = canvasDrawScope;
            Density density = this.f26121c;
            LayoutDirection layoutDirection = this.f26122d;
            long jE = IntSizeKt.e(this.f26140v);
            Density density2 = drawScope.Q1().getDensity();
            LayoutDirection layoutDirection2 = drawScope.Q1().getLayoutDirection();
            androidx.compose.ui.graphics.Canvas canvasG = drawScope.Q1().g();
            long jB = drawScope.Q1().b();
            z2 = z4;
            GraphicsLayer graphicsLayerI = drawScope.Q1().i();
            z3 = z5;
            DrawContext drawContextQ1 = drawScope.Q1();
            drawContextQ1.d(density);
            drawContextQ1.c(layoutDirection);
            drawContextQ1.j(canvas);
            drawContextQ1.h(jE);
            drawContextQ1.f(this);
            canvas.t();
            try {
                j(drawScope);
            } finally {
                canvas.k();
                DrawContext drawContextQ12 = drawScope.Q1();
                drawContextQ12.d(density2);
                drawContextQ12.c(layoutDirection2);
                drawContextQ12.j(canvasG);
                drawContextQ12.h(jB);
                drawContextQ12.f(graphicsLayerI);
            }
        }
        if (z3) {
            canvas.k();
        }
        if (z2) {
            canvas.u();
        }
        if (zIsHardwareAccelerated) {
            return;
        }
        canvasD.restore();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object h0(kotlin.coroutines.Continuation r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.compose.ui.graphics.layer.GraphicsLayer$toImageBitmap$1
            if (r0 == 0) goto L13
            r0 = r5
            androidx.compose.ui.graphics.layer.GraphicsLayer$toImageBitmap$1 r0 = (androidx.compose.ui.graphics.layer.GraphicsLayer$toImageBitmap$1) r0
            int r1 = r0.f26148c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f26148c = r1
            goto L18
        L13:
            androidx.compose.ui.graphics.layer.GraphicsLayer$toImageBitmap$1 r0 = new androidx.compose.ui.graphics.layer.GraphicsLayer$toImageBitmap$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f26146a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f26148c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r5)
            goto L3f
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            kotlin.ResultKt.b(r5)
            androidx.compose.ui.graphics.layer.LayerSnapshotImpl r5 = androidx.compose.ui.graphics.layer.GraphicsLayer.A
            r0.f26148c = r3
            java.lang.Object r5 = r5.a(r4, r0)
            if (r5 != r1) goto L3f
            return r1
        L3f:
            android.graphics.Bitmap r5 = (android.graphics.Bitmap) r5
            androidx.compose.ui.graphics.ImageBitmap r5 = androidx.compose.ui.graphics.AndroidImageBitmap_androidKt.c(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.layer.GraphicsLayer.h0(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void i(androidx.compose.ui.graphics.Canvas canvas) {
        if (AndroidCanvas_androidKt.d(canvas).isHardwareAccelerated() || this.f26119a.z()) {
            I();
            this.f26119a.N(canvas);
        }
    }

    public final float k() {
        return this.f26119a.a();
    }

    public final int l() {
        return this.f26119a.m();
    }

    public final boolean m() {
        return this.f26142x;
    }

    public final ColorFilter n() {
        return this.f26119a.b();
    }

    public final int o() {
        return this.f26119a.r();
    }

    public final androidx.compose.ui.graphics.Outline p() {
        androidx.compose.ui.graphics.Outline rectangle;
        androidx.compose.ui.graphics.Outline outline = this.f26130l;
        Path path = this.f26131m;
        if (outline != null) {
            return outline;
        }
        if (path != null) {
            Outline.Generic generic = new Outline.Generic(path);
            this.f26130l = generic;
            return generic;
        }
        long jE = IntSizeKt.e(this.f26140v);
        long j3 = this.f26127i;
        long j4 = this.f26128j;
        if (j4 != 9205357640488583168L) {
            jE = j4;
        }
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j3 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j3 & 4294967295L));
        float fIntBitsToFloat3 = Float.intBitsToFloat((int) (jE >> 32)) + fIntBitsToFloat;
        float fIntBitsToFloat4 = fIntBitsToFloat2 + Float.intBitsToFloat((int) (jE & 4294967295L));
        float f3 = this.f26129k;
        if (f3 > 0.0f) {
            rectangle = new Outline.Rounded(RoundRectKt.d(fIntBitsToFloat, fIntBitsToFloat2, fIntBitsToFloat3, fIntBitsToFloat4, CornerRadius.b((((long) Float.floatToRawIntBits(f3)) << 32) | (4294967295L & ((long) Float.floatToRawIntBits(f3))))));
        } else {
            rectangle = new Outline.Rectangle(new Rect(fIntBitsToFloat, fIntBitsToFloat2, fIntBitsToFloat3, fIntBitsToFloat4));
        }
        this.f26130l = rectangle;
        return rectangle;
    }

    public final long q() {
        return this.f26141w;
    }

    public final float r() {
        return this.f26119a.L();
    }

    public final float s() {
        return this.f26119a.t();
    }

    public final float t() {
        return this.f26119a.w();
    }

    public final float u() {
        return this.f26119a.D();
    }

    public final float v() {
        return this.f26119a.P();
    }

    public final float w() {
        return this.f26119a.M();
    }

    public final long x() {
        return this.f26140v;
    }

    public final long y() {
        return this.f26139u;
    }

    public final float z() {
        return this.f26119a.K();
    }
}
