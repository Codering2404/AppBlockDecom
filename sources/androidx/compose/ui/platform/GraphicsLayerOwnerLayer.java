package androidx.compose.ui.platform;

import android.os.Build;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CompositingStrategy;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.MatrixKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.GraphicLayerInfo;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import com.google.android.gms.common.api.Api;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class GraphicsLayerOwnerLayer implements OwnedLayer, GraphicLayerInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private GraphicsLayer f28073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final GraphicsContext f28074b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AndroidComposeView f28075c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Function2 f28076d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Function0 f28077f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f28078g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f28079h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final float[] f28080i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float[] f28081j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f28082k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Density f28083l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private LayoutDirection f28084m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final CanvasDrawScope f28085n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f28086o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private long f28087p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Outline f28088q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f28089r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f28090s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f28091t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f28092u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final Function1 f28093v;

    public GraphicsLayerOwnerLayer(GraphicsLayer graphicsLayer, GraphicsContext graphicsContext, AndroidComposeView androidComposeView, Function2 function2, Function0 function0) {
        this.f28073a = graphicsLayer;
        this.f28074b = graphicsContext;
        this.f28075c = androidComposeView;
        this.f28076d = function2;
        this.f28077f = function0;
        long j3 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.f28078g = IntSize.c((j3 & 4294967295L) | (j3 << 32));
        this.f28080i = Matrix.c(null, 1, null);
        this.f28083l = DensityKt.b(1.0f, 0.0f, 2, null);
        this.f28084m = LayoutDirection.f30001a;
        this.f28085n = new CanvasDrawScope();
        this.f28087p = TransformOrigin.f25955b.a();
        this.f28091t = true;
        this.f28093v = new Function1<DrawScope, Unit>() { // from class: androidx.compose.ui.platform.GraphicsLayerOwnerLayer$recordLambda$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((DrawScope) obj);
                return Unit.f139807a;
            }

            public final void invoke(DrawScope drawScope) {
                GraphicsLayerOwnerLayer graphicsLayerOwnerLayer = this.f28094a;
                Canvas canvasG = drawScope.Q1().g();
                Function2 function22 = graphicsLayerOwnerLayer.f28076d;
                if (function22 != null) {
                    function22.invoke(canvasG, drawScope.Q1().i());
                }
            }
        };
    }

    private final float[] m() {
        float[] fArrC = this.f28081j;
        if (fArrC == null) {
            fArrC = Matrix.c(null, 1, null);
            this.f28081j = fArrC;
        }
        if (!this.f28090s) {
            if (Float.isNaN(fArrC[0])) {
                return null;
            }
            return fArrC;
        }
        this.f28090s = false;
        float[] fArrN = n();
        if (this.f28091t) {
            return fArrN;
        }
        if (InvertMatrixKt.a(fArrN, fArrC)) {
            return fArrC;
        }
        fArrC[0] = Float.NaN;
        return null;
    }

    private final float[] n() {
        q();
        return this.f28080i;
    }

    private final void o(boolean z2) {
        if (z2 != this.f28082k) {
            this.f28082k = z2;
            this.f28075c.I0(this, z2);
        }
    }

    private final void p() {
        WrapperRenderNodeLayerHelperMethods.f28336a.a(this.f28075c);
    }

    private final void q() {
        if (this.f28089r) {
            GraphicsLayer graphicsLayer = this.f28073a;
            long jB = (graphicsLayer.q() & 9223372034707292159L) == 9205357640488583168L ? SizeKt.b(IntSizeKt.e(this.f28078g)) : graphicsLayer.q();
            Matrix.i(this.f28080i, Float.intBitsToFloat((int) (jB >> 32)), Float.intBitsToFloat((int) (jB & 4294967295L)), graphicsLayer.z(), graphicsLayer.A(), 1.0f, graphicsLayer.r(), graphicsLayer.s(), graphicsLayer.t(), graphicsLayer.u(), graphicsLayer.v(), 1.0f);
            this.f28089r = false;
            this.f28091t = MatrixKt.a(this.f28080i);
        }
    }

    private final void r() {
        Function0 function0;
        Outline outline = this.f28088q;
        if (outline == null) {
            return;
        }
        GraphicsLayerKt.b(this.f28073a, outline);
        if (!(outline instanceof Outline.Generic) || Build.VERSION.SDK_INT >= 33 || (function0 = this.f28077f) == null) {
            return;
        }
        function0.invoke();
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void a(float[] fArr) {
        Matrix.l(fArr, n());
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public long b(long j3, boolean z2) {
        float[] fArrN;
        if (z2) {
            fArrN = m();
            if (fArrN == null) {
                return Offset.f25596b.a();
            }
        } else {
            fArrN = n();
        }
        return this.f28091t ? j3 : Matrix.f(fArrN, j3);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void c(Function2 function2, Function0 function0) {
        GraphicsContext graphicsContext = this.f28074b;
        if (graphicsContext == null) {
            InlineClassHelperKt.d("currently reuse is only supported when we manage the layer lifecycle");
            throw new KotlinNothingValueException();
        }
        if (!this.f28073a.B()) {
            InlineClassHelperKt.a("layer should have been released before reuse");
        }
        this.f28073a = graphicsContext.a();
        this.f28079h = false;
        this.f28076d = function2;
        this.f28077f = function0;
        this.f28089r = false;
        this.f28090s = false;
        this.f28091t = true;
        Matrix.h(this.f28080i);
        float[] fArr = this.f28081j;
        if (fArr != null) {
            Matrix.h(fArr);
        }
        this.f28087p = TransformOrigin.f25955b.a();
        this.f28092u = false;
        long j3 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.f28078g = IntSize.c((j3 & 4294967295L) | (j3 << 32));
        this.f28088q = null;
        this.f28086o = 0;
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void d(long j3) {
        if (IntSize.e(j3, this.f28078g)) {
            return;
        }
        this.f28078g = j3;
        invalidate();
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void destroy() {
        this.f28076d = null;
        this.f28077f = null;
        this.f28079h = true;
        o(false);
        GraphicsContext graphicsContext = this.f28074b;
        if (graphicsContext != null) {
            graphicsContext.b(this.f28073a);
            this.f28075c.R0(this);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void e(Canvas canvas, GraphicsLayer graphicsLayer) {
        k();
        this.f28092u = this.f28073a.w() > 0.0f;
        DrawContext drawContextQ1 = this.f28085n.Q1();
        drawContextQ1.j(canvas);
        drawContextQ1.f(graphicsLayer);
        GraphicsLayerKt.a(this.f28085n, this.f28073a);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void f(MutableRect mutableRect, boolean z2) {
        float[] fArrM = z2 ? m() : n();
        if (this.f28091t) {
            return;
        }
        if (fArrM == null) {
            mutableRect.g(0.0f, 0.0f, 0.0f, 0.0f);
        } else {
            Matrix.g(fArrM, mutableRect);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public boolean g(long j3) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j3 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j3 & 4294967295L));
        if (this.f28073a.m()) {
            return ShapeContainingUtilKt.c(this.f28073a.p(), fIntBitsToFloat, fIntBitsToFloat2, null, null, 24, null);
        }
        return true;
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* JADX INFO: renamed from: getUnderlyingMatrix-sQKQjiQ */
    public float[] mo244getUnderlyingMatrixsQKQjiQ() {
        return n();
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void h(ReusableGraphicsLayerScope reusableGraphicsLayerScope) {
        int iB;
        Function0 function0;
        int I = reusableGraphicsLayerScope.I() | this.f28086o;
        this.f28084m = reusableGraphicsLayerScope.H();
        this.f28083l = reusableGraphicsLayerScope.z();
        int i3 = I & 4096;
        if (i3 != 0) {
            this.f28087p = reusableGraphicsLayerScope.y0();
        }
        if ((I & 1) != 0) {
            this.f28073a.Z(reusableGraphicsLayerScope.D());
        }
        if ((I & 2) != 0) {
            this.f28073a.a0(reusableGraphicsLayerScope.P());
        }
        if ((I & 4) != 0) {
            this.f28073a.L(reusableGraphicsLayerScope.m());
        }
        if ((I & 8) != 0) {
            this.f28073a.f0(reusableGraphicsLayerScope.K());
        }
        if ((I & 16) != 0) {
            this.f28073a.g0(reusableGraphicsLayerScope.J());
        }
        if ((I & 32) != 0) {
            this.f28073a.b0(reusableGraphicsLayerScope.Q());
            if (reusableGraphicsLayerScope.Q() > 0.0f && !this.f28092u && (function0 = this.f28077f) != null) {
                function0.invoke();
            }
        }
        if ((I & 64) != 0) {
            this.f28073a.M(reusableGraphicsLayerScope.p());
        }
        if ((I & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            this.f28073a.d0(reusableGraphicsLayerScope.S());
        }
        if ((I & 1024) != 0) {
            this.f28073a.X(reusableGraphicsLayerScope.w());
        }
        if ((I & Function.MAX_NARGS) != 0) {
            this.f28073a.V(reusableGraphicsLayerScope.L());
        }
        if ((I & 512) != 0) {
            this.f28073a.W(reusableGraphicsLayerScope.t());
        }
        if ((I & 2048) != 0) {
            this.f28073a.N(reusableGraphicsLayerScope.A());
        }
        if (i3 != 0) {
            if (TransformOrigin.e(this.f28087p, TransformOrigin.f25955b.a())) {
                this.f28073a.R(Offset.f25596b.b());
            } else {
                this.f28073a.R(Offset.e((((long) Float.floatToRawIntBits(TransformOrigin.g(this.f28087p) * ((int) (this.f28078g & 4294967295L)))) & 4294967295L) | (((long) Float.floatToRawIntBits(TransformOrigin.f(this.f28087p) * ((int) (this.f28078g >> 32)))) << 32)));
            }
        }
        if ((I & 16384) != 0) {
            this.f28073a.O(reusableGraphicsLayerScope.u());
        }
        if ((131072 & I) != 0) {
            this.f28073a.U(reusableGraphicsLayerScope.O());
        }
        if ((32768 & I) != 0) {
            GraphicsLayer graphicsLayer = this.f28073a;
            int iX = reusableGraphicsLayerScope.x();
            CompositingStrategy.Companion companion = CompositingStrategy.f25737b;
            if (CompositingStrategy.g(iX, companion.a())) {
                iB = androidx.compose.ui.graphics.layer.CompositingStrategy.f26113b.a();
            } else if (CompositingStrategy.g(iX, companion.c())) {
                iB = androidx.compose.ui.graphics.layer.CompositingStrategy.f26113b.c();
            } else {
                if (!CompositingStrategy.g(iX, companion.b())) {
                    throw new IllegalStateException("Not supported composition strategy");
                }
                iB = androidx.compose.ui.graphics.layer.CompositingStrategy.f26113b.b();
            }
            graphicsLayer.P(iB);
        }
        boolean z2 = true;
        if ((I & 7963) != 0) {
            this.f28089r = true;
            this.f28090s = true;
        }
        if (Intrinsics.areEqual(this.f28088q, reusableGraphicsLayerScope.N())) {
            z2 = false;
        } else {
            this.f28088q = reusableGraphicsLayerScope.N();
            r();
        }
        this.f28086o = reusableGraphicsLayerScope.I();
        if (I != 0 || z2) {
            p();
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void i(float[] fArr) {
        float[] fArrM = m();
        if (fArrM != null) {
            Matrix.l(fArr, fArrM);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void invalidate() {
        if (this.f28082k || this.f28079h) {
            return;
        }
        this.f28075c.invalidate();
        o(true);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void j(long j3) {
        this.f28073a.e0(j3);
        p();
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void k() {
        if (this.f28082k) {
            if (!TransformOrigin.e(this.f28087p, TransformOrigin.f25955b.a()) && !IntSize.e(this.f28073a.x(), this.f28078g)) {
                GraphicsLayer graphicsLayer = this.f28073a;
                float f3 = TransformOrigin.f(this.f28087p) * ((int) (this.f28078g >> 32));
                graphicsLayer.R(Offset.e((((long) Float.floatToRawIntBits(TransformOrigin.g(this.f28087p) * ((int) (this.f28078g & 4294967295L)))) & 4294967295L) | (Float.floatToRawIntBits(f3) << 32)));
            }
            this.f28073a.G(this.f28083l, this.f28084m, this.f28078g, this.f28093v);
            o(false);
        }
    }
}
