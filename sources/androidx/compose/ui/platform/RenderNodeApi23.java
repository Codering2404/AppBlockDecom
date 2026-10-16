package androidx.compose.ui.platform;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.view.DisplayListCanvas;
import android.view.RenderNode;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.CompositingStrategy;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RenderEffect;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class RenderNodeApi23 implements DeviceRenderNode {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static boolean f28159l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AndroidComposeView f28161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RenderNode f28162b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f28163c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f28164d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f28165e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f28166f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f28167g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private RenderEffect f28168h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f28169i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Companion f28157j = new Companion(null);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f28158k = 8;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static boolean f28160m = true;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public RenderNodeApi23(AndroidComposeView androidComposeView) {
        this.f28161a = androidComposeView;
        RenderNode renderNodeCreate = RenderNode.create("Compose", androidComposeView);
        this.f28162b = renderNodeCreate;
        this.f28163c = CompositingStrategy.f25737b.a();
        if (f28160m) {
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
            P(renderNodeCreate);
            K();
            renderNodeCreate.setLayerType(0);
            renderNodeCreate.setHasOverlappingRendering(renderNodeCreate.hasOverlappingRendering());
            f28160m = false;
        }
        if (f28159l) {
            throw new NoClassDefFoundError();
        }
    }

    private final void K() {
        RenderNodeVerificationHelper24.f28195a.a(this.f28162b);
    }

    private final void P(RenderNode renderNode) {
        RenderNodeVerificationHelper28 renderNodeVerificationHelper28 = RenderNodeVerificationHelper28.f28196a;
        renderNodeVerificationHelper28.c(renderNode, renderNodeVerificationHelper28.a(renderNode));
        renderNodeVerificationHelper28.d(renderNode, renderNodeVerificationHelper28.b(renderNode));
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void A(int i3) {
        M(m() + i3);
        N(p() + i3);
        this.f28162b.offsetLeftAndRight(i3);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int B() {
        return this.f28167g;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void C(float f3) {
        this.f28162b.setPivotX(f3);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void D(float f3) {
        this.f28162b.setPivotY(f3);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void E(Outline outline) {
        this.f28162b.setOutline(outline);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void F(int i3) {
        RenderNodeVerificationHelper28.f28196a.c(this.f28162b, i3);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void G(boolean z2) {
        this.f28162b.setClipToOutline(z2);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void H(CanvasHolder canvasHolder, Path path, Function1 function1) {
        DisplayListCanvas displayListCanvasStart = this.f28162b.start(getWidth(), getHeight());
        Canvas canvasB = canvasHolder.a().B();
        canvasHolder.a().C((Canvas) displayListCanvasStart);
        AndroidCanvas androidCanvasA = canvasHolder.a();
        if (path != null) {
            androidCanvasA.t();
            androidx.compose.ui.graphics.Canvas.l(androidCanvasA, path, 0, 2, null);
        }
        function1.invoke(androidCanvasA);
        if (path != null) {
            androidCanvasA.k();
        }
        canvasHolder.a().C(canvasB);
        this.f28162b.end(displayListCanvasStart);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void I(int i3) {
        RenderNodeVerificationHelper28.f28196a.d(this.f28162b, i3);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public float J() {
        return this.f28162b.getElevation();
    }

    public void L(int i3) {
        this.f28167g = i3;
    }

    public void M(int i3) {
        this.f28164d = i3;
    }

    public void N(int i3) {
        this.f28166f = i3;
    }

    public void O(int i3) {
        this.f28165e = i3;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public float a() {
        return this.f28162b.getAlpha();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void b(Canvas canvas) {
        Intrinsics.checkNotNull(canvas, "null cannot be cast to non-null type android.view.DisplayListCanvas");
        ((DisplayListCanvas) canvas).drawRenderNode(this.f28162b);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void c(float f3) {
        this.f28162b.setAlpha(f3);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void d(float f3) {
        this.f28162b.setTranslationY(f3);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void e(float f3) {
        this.f28162b.setScaleX(f3);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void f(RenderEffect renderEffect) {
        this.f28168h = renderEffect;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void g(float f3) {
        this.f28162b.setCameraDistance(-f3);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getHeight() {
        return B() - w();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getWidth() {
        return p() - m();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void h(float f3) {
        this.f28162b.setRotationX(f3);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void i(float f3) {
        this.f28162b.setRotationY(f3);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void j(float f3) {
        this.f28162b.setRotation(f3);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void k(float f3) {
        this.f28162b.setScaleY(f3);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void l(float f3) {
        this.f28162b.setTranslationX(f3);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int m() {
        return this.f28164d;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void n() {
        K();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public boolean o() {
        return this.f28162b.isValid();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int p() {
        return this.f28166f;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void q(boolean z2) {
        this.f28169i = z2;
        this.f28162b.setClipToBounds(z2);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public boolean r(int i3, int i4, int i5, int i6) {
        M(i3);
        O(i4);
        N(i5);
        L(i6);
        return this.f28162b.setLeftTopRightBottom(i3, i4, i5, i6);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void s(int i3) {
        CompositingStrategy.Companion companion = CompositingStrategy.f25737b;
        if (CompositingStrategy.g(i3, companion.c())) {
            this.f28162b.setLayerType(2);
            this.f28162b.setHasOverlappingRendering(true);
        } else if (CompositingStrategy.g(i3, companion.b())) {
            this.f28162b.setLayerType(0);
            this.f28162b.setHasOverlappingRendering(false);
        } else {
            this.f28162b.setLayerType(0);
            this.f28162b.setHasOverlappingRendering(true);
        }
        this.f28163c = i3;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void t(float f3) {
        this.f28162b.setElevation(f3);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void u(int i3) {
        O(w() + i3);
        L(B() + i3);
        this.f28162b.offsetTopAndBottom(i3);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public boolean v() {
        return this.f28169i;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int w() {
        return this.f28165e;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public boolean x() {
        return this.f28162b.getClipToOutline();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public boolean y(boolean z2) {
        return this.f28162b.setHasOverlappingRendering(z2);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void z(Matrix matrix) {
        this.f28162b.getMatrix(matrix);
    }
}
