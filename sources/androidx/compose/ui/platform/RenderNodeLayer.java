package androidx.compose.ui.platform;

import android.graphics.Matrix;
import android.os.Build;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.layout.GraphicLayerInfo;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.unit.IntOffset;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class RenderNodeLayer implements OwnedLayer, GraphicLayerInfo {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Companion f28175o = new Companion(null);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f28176p = 8;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final Function2 f28177q = new Function2<DeviceRenderNode, Matrix, Unit>() { // from class: androidx.compose.ui.platform.RenderNodeLayer$Companion$getMatrix$1
        public final void c(DeviceRenderNode deviceRenderNode, Matrix matrix) {
            deviceRenderNode.z(matrix);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            c((DeviceRenderNode) obj, (Matrix) obj2);
            return Unit.f139807a;
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AndroidComposeView f28178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Function2 f28179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Function0 f28180c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f28181d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f28183g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f28184h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Paint f28185i;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final DeviceRenderNode f28189m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f28190n;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final OutlineResolver f28182f = new OutlineResolver();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final LayerMatrixCache f28186j = new LayerMatrixCache(f28177q);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final CanvasHolder f28187k = new CanvasHolder();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f28188l = TransformOrigin.f25955b.a();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class UniqueDrawingIdApi29 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final UniqueDrawingIdApi29 f28192a = new UniqueDrawingIdApi29();

        private UniqueDrawingIdApi29() {
        }
    }

    public RenderNodeLayer(AndroidComposeView androidComposeView, Function2 function2, Function0 function0) {
        this.f28178a = androidComposeView;
        this.f28179b = function2;
        this.f28180c = function0;
        DeviceRenderNode renderNodeApi29 = Build.VERSION.SDK_INT >= 29 ? new RenderNodeApi29(androidComposeView) : new RenderNodeApi23(androidComposeView);
        renderNodeApi29.y(true);
        renderNodeApi29.q(false);
        this.f28189m = renderNodeApi29;
    }

    private final void l(Canvas canvas) {
        if (this.f28189m.x() || this.f28189m.v()) {
            this.f28182f.a(canvas);
        }
    }

    private final void m(boolean z2) {
        if (z2 != this.f28181d) {
            this.f28181d = z2;
            this.f28178a.I0(this, z2);
        }
    }

    private final void n() {
        WrapperRenderNodeLayerHelperMethods.f28336a.a(this.f28178a);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void a(float[] fArr) {
        androidx.compose.ui.graphics.Matrix.l(fArr, this.f28186j.b(this.f28189m));
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public long b(long j3, boolean z2) {
        return z2 ? this.f28186j.g(this.f28189m, j3) : this.f28186j.e(this.f28189m, j3);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void c(Function2 function2, Function0 function0) {
        this.f28186j.h();
        m(false);
        this.f28183g = false;
        this.f28184h = false;
        this.f28188l = TransformOrigin.f25955b.a();
        this.f28179b = function2;
        this.f28180c = function0;
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void d(long j3) {
        int i3 = (int) (j3 >> 32);
        int i4 = (int) (j3 & 4294967295L);
        this.f28189m.C(TransformOrigin.f(this.f28188l) * i3);
        this.f28189m.D(TransformOrigin.g(this.f28188l) * i4);
        DeviceRenderNode deviceRenderNode = this.f28189m;
        if (deviceRenderNode.r(deviceRenderNode.m(), this.f28189m.w(), this.f28189m.m() + i3, this.f28189m.w() + i4)) {
            this.f28189m.E(this.f28182f.b());
            invalidate();
            this.f28186j.c();
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void destroy() {
        if (this.f28189m.o()) {
            this.f28189m.n();
        }
        this.f28179b = null;
        this.f28180c = null;
        this.f28183g = true;
        m(false);
        this.f28178a.T0();
        this.f28178a.R0(this);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void e(Canvas canvas, GraphicsLayer graphicsLayer) {
        android.graphics.Canvas canvasD = AndroidCanvas_androidKt.d(canvas);
        if (canvasD.isHardwareAccelerated()) {
            k();
            boolean z2 = this.f28189m.J() > 0.0f;
            this.f28184h = z2;
            if (z2) {
                canvas.n();
            }
            this.f28189m.b(canvasD);
            if (this.f28184h) {
                canvas.u();
                return;
            }
            return;
        }
        float fM = this.f28189m.m();
        float fW = this.f28189m.w();
        float fP = this.f28189m.p();
        float fB = this.f28189m.B();
        if (this.f28189m.a() < 1.0f) {
            Paint paintA = this.f28185i;
            if (paintA == null) {
                paintA = AndroidPaint_androidKt.a();
                this.f28185i = paintA;
            }
            paintA.c(this.f28189m.a());
            canvasD.saveLayer(fM, fW, fP, fB, paintA.y());
        } else {
            canvas.t();
        }
        canvas.e(fM, fW);
        canvas.v(this.f28186j.b(this.f28189m));
        l(canvas);
        Function2 function2 = this.f28179b;
        if (function2 != null) {
            function2.invoke(canvas, null);
        }
        canvas.k();
        m(false);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void f(MutableRect mutableRect, boolean z2) {
        if (z2) {
            this.f28186j.f(this.f28189m, mutableRect);
        } else {
            this.f28186j.d(this.f28189m, mutableRect);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public boolean g(long j3) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j3 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (4294967295L & j3));
        if (this.f28189m.v()) {
            return 0.0f <= fIntBitsToFloat && fIntBitsToFloat < ((float) this.f28189m.getWidth()) && 0.0f <= fIntBitsToFloat2 && fIntBitsToFloat2 < ((float) this.f28189m.getHeight());
        }
        if (this.f28189m.x()) {
            return this.f28182f.f(j3);
        }
        return true;
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* JADX INFO: renamed from: getUnderlyingMatrix-sQKQjiQ */
    public float[] mo244getUnderlyingMatrixsQKQjiQ() {
        return this.f28186j.b(this.f28189m);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void h(ReusableGraphicsLayerScope reusableGraphicsLayerScope) {
        Function0 function0;
        int I = reusableGraphicsLayerScope.I() | this.f28190n;
        int i3 = I & 4096;
        if (i3 != 0) {
            this.f28188l = reusableGraphicsLayerScope.y0();
        }
        boolean z2 = false;
        boolean z3 = this.f28189m.x() && !this.f28182f.e();
        if ((I & 1) != 0) {
            this.f28189m.e(reusableGraphicsLayerScope.D());
        }
        if ((I & 2) != 0) {
            this.f28189m.k(reusableGraphicsLayerScope.P());
        }
        if ((I & 4) != 0) {
            this.f28189m.c(reusableGraphicsLayerScope.m());
        }
        if ((I & 8) != 0) {
            this.f28189m.l(reusableGraphicsLayerScope.K());
        }
        if ((I & 16) != 0) {
            this.f28189m.d(reusableGraphicsLayerScope.J());
        }
        if ((I & 32) != 0) {
            this.f28189m.t(reusableGraphicsLayerScope.Q());
        }
        if ((I & 64) != 0) {
            this.f28189m.F(ColorKt.k(reusableGraphicsLayerScope.p()));
        }
        if ((I & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            this.f28189m.I(ColorKt.k(reusableGraphicsLayerScope.S()));
        }
        if ((I & 1024) != 0) {
            this.f28189m.j(reusableGraphicsLayerScope.w());
        }
        if ((I & Function.MAX_NARGS) != 0) {
            this.f28189m.h(reusableGraphicsLayerScope.L());
        }
        if ((I & 512) != 0) {
            this.f28189m.i(reusableGraphicsLayerScope.t());
        }
        if ((I & 2048) != 0) {
            this.f28189m.g(reusableGraphicsLayerScope.A());
        }
        if (i3 != 0) {
            this.f28189m.C(TransformOrigin.f(this.f28188l) * this.f28189m.getWidth());
            this.f28189m.D(TransformOrigin.g(this.f28188l) * this.f28189m.getHeight());
        }
        boolean z4 = reusableGraphicsLayerScope.u() && reusableGraphicsLayerScope.R() != RectangleShapeKt.a();
        if ((I & 24576) != 0) {
            this.f28189m.G(z4);
            this.f28189m.q(reusableGraphicsLayerScope.u() && reusableGraphicsLayerScope.R() == RectangleShapeKt.a());
        }
        if ((131072 & I) != 0) {
            this.f28189m.f(reusableGraphicsLayerScope.O());
        }
        if ((32768 & I) != 0) {
            this.f28189m.s(reusableGraphicsLayerScope.x());
        }
        boolean zH = this.f28182f.h(reusableGraphicsLayerScope.N(), reusableGraphicsLayerScope.m(), z4, reusableGraphicsLayerScope.Q(), reusableGraphicsLayerScope.b());
        if (this.f28182f.c()) {
            this.f28189m.E(this.f28182f.b());
        }
        if (z4 && !this.f28182f.e()) {
            z2 = true;
        }
        if (z3 != z2 || (z2 && zH)) {
            invalidate();
        } else {
            n();
        }
        if (!this.f28184h && this.f28189m.J() > 0.0f && (function0 = this.f28180c) != null) {
            function0.invoke();
        }
        if ((I & 7963) != 0) {
            this.f28186j.c();
        }
        this.f28190n = reusableGraphicsLayerScope.I();
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void i(float[] fArr) {
        float[] fArrA = this.f28186j.a(this.f28189m);
        if (fArrA != null) {
            androidx.compose.ui.graphics.Matrix.l(fArr, fArrA);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void invalidate() {
        if (this.f28181d || this.f28183g) {
            return;
        }
        this.f28178a.invalidate();
        m(true);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void j(long j3) {
        int iM = this.f28189m.m();
        int iW = this.f28189m.w();
        int iK = IntOffset.k(j3);
        int iL = IntOffset.l(j3);
        if (iM == iK && iW == iL) {
            return;
        }
        if (iM != iK) {
            this.f28189m.A(iK - iM);
        }
        if (iW != iL) {
            this.f28189m.u(iL - iW);
        }
        n();
        this.f28186j.c();
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void k() {
        if (this.f28181d || !this.f28189m.o()) {
            Path pathD = (!this.f28189m.x() || this.f28182f.e()) ? null : this.f28182f.d();
            final Function2 function2 = this.f28179b;
            if (function2 != null) {
                this.f28189m.H(this.f28187k, pathD, new Function1<Canvas, Unit>() { // from class: androidx.compose.ui.platform.RenderNodeLayer$updateDisplayList$1$1
                    {
                        super(1);
                    }

                    public final void c(Canvas canvas) {
                        function2.invoke(canvas, null);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        c((Canvas) obj);
                        return Unit.f139807a;
                    }
                });
            }
            m(false);
        }
    }
}
