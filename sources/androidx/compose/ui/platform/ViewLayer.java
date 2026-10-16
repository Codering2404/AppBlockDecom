package androidx.compose.ui.platform;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.CompositingStrategy;
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
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class ViewLayer extends View implements OwnedLayer, GraphicLayerInfo {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Companion f28240q = new Companion(null);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f28241r = 8;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final Function2 f28242s = new Function2<View, Matrix, Unit>() { // from class: androidx.compose.ui.platform.ViewLayer$Companion$getMatrix$1
        public final void c(View view, Matrix matrix) {
            matrix.set(view.getMatrix());
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            c((View) obj, (Matrix) obj2);
            return Unit.f139807a;
        }
    };

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final ViewOutlineProvider f28243t = new ViewOutlineProvider() { // from class: androidx.compose.ui.platform.ViewLayer$Companion$OutlineProvider$1
        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type androidx.compose.ui.platform.ViewLayer");
            Outline outlineB = ((ViewLayer) view).f28252f.b();
            Intrinsics.checkNotNull(outlineB);
            outline.set(outlineB);
        }
    };

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static Method f28244u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static Field f28245v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static boolean f28246w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static boolean f28247x;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AndroidComposeView f28248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DrawChildContainer f28249b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Function2 f28250c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Function0 f28251d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final OutlineResolver f28252f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f28253g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Rect f28254h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f28255i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f28256j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final CanvasHolder f28257k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final LayerMatrixCache f28258l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f28259m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f28260n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final long f28261o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f28262p;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return ViewLayer.f28246w;
        }

        public final boolean b() {
            return ViewLayer.f28247x;
        }

        public final void c(boolean z2) {
            ViewLayer.f28247x = z2;
        }

        public final void d(View view) {
            try {
                if (!a()) {
                    ViewLayer.f28246w = true;
                    ViewLayer.f28244u = (Method) Class.class.getDeclaredMethod("getDeclaredMethod", String.class, new Class[0].getClass()).invoke(View.class, "updateDisplayListIfDirty", new Class[0]);
                    ViewLayer.f28245v = (Field) Class.class.getDeclaredMethod("getDeclaredField", String.class).invoke(View.class, "mRecreateDisplayList");
                    Method method = ViewLayer.f28244u;
                    if (method != null) {
                        method.setAccessible(true);
                    }
                    Field field = ViewLayer.f28245v;
                    if (field != null) {
                        field.setAccessible(true);
                    }
                }
                Field field2 = ViewLayer.f28245v;
                if (field2 != null) {
                    field2.setBoolean(view, true);
                }
                Method method2 = ViewLayer.f28244u;
                if (method2 != null) {
                    method2.invoke(view, null);
                }
            } catch (Throwable unused) {
                c(true);
            }
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class UniqueDrawingIdApi29 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final UniqueDrawingIdApi29 f28264a = new UniqueDrawingIdApi29();

        private UniqueDrawingIdApi29() {
        }

        public static final long a(View view) {
            return view.getUniqueDrawingId();
        }
    }

    public ViewLayer(AndroidComposeView androidComposeView, DrawChildContainer drawChildContainer, Function2 function2, Function0 function0) {
        super(androidComposeView.getContext());
        this.f28248a = androidComposeView;
        this.f28249b = drawChildContainer;
        this.f28250c = function2;
        this.f28251d = function0;
        this.f28252f = new OutlineResolver();
        this.f28257k = new CanvasHolder();
        this.f28258l = new LayerMatrixCache(f28242s);
        this.f28259m = TransformOrigin.f25955b.a();
        this.f28260n = true;
        setWillNotDraw(false);
        drawChildContainer.addView(this);
        this.f28261o = View.generateViewId();
    }

    private final Path getManualClipPath() {
        if (!getClipToOutline() || this.f28252f.e()) {
            return null;
        }
        return this.f28252f.d();
    }

    private final void setInvalidated(boolean z2) {
        if (z2 != this.f28255i) {
            this.f28255i = z2;
            this.f28248a.I0(this, z2);
        }
    }

    private final void v() {
        Rect rect;
        if (this.f28253g) {
            Rect rect2 = this.f28254h;
            if (rect2 == null) {
                this.f28254h = new Rect(0, 0, getWidth(), getHeight());
            } else {
                Intrinsics.checkNotNull(rect2);
                rect2.set(0, 0, getWidth(), getHeight());
            }
            rect = this.f28254h;
        } else {
            rect = null;
        }
        setClipBounds(rect);
    }

    private final void w() {
        setOutlineProvider(this.f28252f.b() != null ? f28243t : null);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void a(float[] fArr) {
        androidx.compose.ui.graphics.Matrix.l(fArr, this.f28258l.b(this));
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public long b(long j3, boolean z2) {
        return z2 ? this.f28258l.g(this, j3) : this.f28258l.e(this, j3);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void c(Function2 function2, Function0 function0) {
        this.f28249b.addView(this);
        this.f28258l.h();
        this.f28253g = false;
        this.f28256j = false;
        this.f28259m = TransformOrigin.f25955b.a();
        this.f28250c = function2;
        this.f28251d = function0;
        setInvalidated(false);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void d(long j3) {
        int i3 = (int) (j3 >> 32);
        int i4 = (int) (j3 & 4294967295L);
        if (i3 == getWidth() && i4 == getHeight()) {
            return;
        }
        setPivotX(TransformOrigin.f(this.f28259m) * i3);
        setPivotY(TransformOrigin.g(this.f28259m) * i4);
        w();
        layout(getLeft(), getTop(), getLeft() + i3, getTop() + i4);
        v();
        this.f28258l.c();
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void destroy() {
        setInvalidated(false);
        this.f28248a.T0();
        this.f28250c = null;
        this.f28251d = null;
        this.f28248a.R0(this);
        this.f28249b.removeViewInLayout(this);
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        boolean z2;
        CanvasHolder canvasHolder = this.f28257k;
        Canvas canvasB = canvasHolder.a().B();
        canvasHolder.a().C(canvas);
        AndroidCanvas androidCanvasA = canvasHolder.a();
        if (getManualClipPath() == null && canvas.isHardwareAccelerated()) {
            z2 = false;
        } else {
            androidCanvasA.t();
            this.f28252f.a(androidCanvasA);
            z2 = true;
        }
        Function2 function2 = this.f28250c;
        if (function2 != null) {
            function2.invoke(androidCanvasA, null);
        }
        if (z2) {
            androidCanvasA.k();
        }
        canvasHolder.a().C(canvasB);
        setInvalidated(false);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void e(androidx.compose.ui.graphics.Canvas canvas, GraphicsLayer graphicsLayer) {
        boolean z2 = getElevation() > 0.0f;
        this.f28256j = z2;
        if (z2) {
            canvas.n();
        }
        this.f28249b.a(canvas, this, getDrawingTime());
        if (this.f28256j) {
            canvas.u();
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void f(MutableRect mutableRect, boolean z2) {
        if (z2) {
            this.f28258l.f(this, mutableRect);
        } else {
            this.f28258l.d(this, mutableRect);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public boolean g(long j3) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j3 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (4294967295L & j3));
        if (this.f28253g) {
            return 0.0f <= fIntBitsToFloat && fIntBitsToFloat < ((float) getWidth()) && 0.0f <= fIntBitsToFloat2 && fIntBitsToFloat2 < ((float) getHeight());
        }
        if (getClipToOutline()) {
            return this.f28252f.f(j3);
        }
        return true;
    }

    public final float getCameraDistancePx() {
        return getCameraDistance() / getResources().getDisplayMetrics().densityDpi;
    }

    public final DrawChildContainer getContainer() {
        return this.f28249b;
    }

    public long getLayerId() {
        return this.f28261o;
    }

    public final AndroidComposeView getOwnerView() {
        return this.f28248a;
    }

    public long getOwnerViewId() {
        if (Build.VERSION.SDK_INT >= 29) {
            return UniqueDrawingIdApi29.a(this.f28248a);
        }
        return -1L;
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* JADX INFO: renamed from: getUnderlyingMatrix-sQKQjiQ */
    public float[] mo244getUnderlyingMatrixsQKQjiQ() {
        return this.f28258l.b(this);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void h(ReusableGraphicsLayerScope reusableGraphicsLayerScope) {
        Function0 function0;
        int I = reusableGraphicsLayerScope.I() | this.f28262p;
        if ((I & 4096) != 0) {
            long jY0 = reusableGraphicsLayerScope.y0();
            this.f28259m = jY0;
            setPivotX(TransformOrigin.f(jY0) * getWidth());
            setPivotY(TransformOrigin.g(this.f28259m) * getHeight());
        }
        if ((I & 1) != 0) {
            setScaleX(reusableGraphicsLayerScope.D());
        }
        if ((I & 2) != 0) {
            setScaleY(reusableGraphicsLayerScope.P());
        }
        if ((I & 4) != 0) {
            setAlpha(reusableGraphicsLayerScope.m());
        }
        if ((I & 8) != 0) {
            setTranslationX(reusableGraphicsLayerScope.K());
        }
        if ((I & 16) != 0) {
            setTranslationY(reusableGraphicsLayerScope.J());
        }
        if ((I & 32) != 0) {
            setElevation(reusableGraphicsLayerScope.Q());
        }
        if ((I & 1024) != 0) {
            setRotation(reusableGraphicsLayerScope.w());
        }
        if ((I & Function.MAX_NARGS) != 0) {
            setRotationX(reusableGraphicsLayerScope.L());
        }
        if ((I & 512) != 0) {
            setRotationY(reusableGraphicsLayerScope.t());
        }
        if ((I & 2048) != 0) {
            setCameraDistancePx(reusableGraphicsLayerScope.A());
        }
        boolean z2 = false;
        boolean z3 = getManualClipPath() != null;
        boolean z4 = reusableGraphicsLayerScope.u() && reusableGraphicsLayerScope.R() != RectangleShapeKt.a();
        if ((I & 24576) != 0) {
            this.f28253g = reusableGraphicsLayerScope.u() && reusableGraphicsLayerScope.R() == RectangleShapeKt.a();
            v();
            setClipToOutline(z4);
        }
        boolean zH = this.f28252f.h(reusableGraphicsLayerScope.N(), reusableGraphicsLayerScope.m(), z4, reusableGraphicsLayerScope.Q(), reusableGraphicsLayerScope.b());
        if (this.f28252f.c()) {
            w();
        }
        boolean z5 = getManualClipPath() != null;
        if (z3 != z5 || (z5 && zH)) {
            invalidate();
        }
        if (!this.f28256j && getElevation() > 0.0f && (function0 = this.f28251d) != null) {
            function0.invoke();
        }
        if ((I & 7963) != 0) {
            this.f28258l.c();
        }
        int i3 = Build.VERSION.SDK_INT;
        if ((I & 64) != 0) {
            ViewLayerVerificationHelper28.f28265a.a(this, ColorKt.k(reusableGraphicsLayerScope.p()));
        }
        if ((I & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            ViewLayerVerificationHelper28.f28265a.b(this, ColorKt.k(reusableGraphicsLayerScope.S()));
        }
        if (i3 >= 31 && (131072 & I) != 0) {
            ViewLayerVerificationHelper31.f28266a.a(this, reusableGraphicsLayerScope.O());
        }
        if ((I & 32768) != 0) {
            int iX = reusableGraphicsLayerScope.x();
            CompositingStrategy.Companion companion = CompositingStrategy.f25737b;
            if (CompositingStrategy.g(iX, companion.c())) {
                setLayerType(2, null);
            } else if (CompositingStrategy.g(iX, companion.b())) {
                setLayerType(0, null);
                this.f28260n = z2;
            } else {
                setLayerType(0, null);
            }
            z2 = true;
            this.f28260n = z2;
        }
        this.f28262p = reusableGraphicsLayerScope.I();
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return this.f28260n;
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void i(float[] fArr) {
        float[] fArrA = this.f28258l.a(this);
        if (fArrA != null) {
            androidx.compose.ui.graphics.Matrix.l(fArr, fArrA);
        }
    }

    @Override // android.view.View, androidx.compose.ui.node.OwnedLayer
    public void invalidate() {
        if (this.f28255i) {
            return;
        }
        setInvalidated(true);
        super.invalidate();
        this.f28248a.invalidate();
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void j(long j3) {
        int iK = IntOffset.k(j3);
        if (iK != getLeft()) {
            offsetLeftAndRight(iK - getLeft());
            this.f28258l.c();
        }
        int iL = IntOffset.l(j3);
        if (iL != getTop()) {
            offsetTopAndBottom(iL - getTop());
            this.f28258l.c();
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void k() {
        if (!this.f28255i || f28247x) {
            return;
        }
        f28240q.d(this);
        setInvalidated(false);
    }

    public final void setCameraDistancePx(float f3) {
        setCameraDistance(f3 * getResources().getDisplayMetrics().densityDpi);
    }

    public final boolean u() {
        return this.f28255i;
    }

    @Override // android.view.View
    public void forceLayout() {
    }

    @Override // android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
    }
}
