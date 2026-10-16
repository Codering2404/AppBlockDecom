package androidx.compose.ui.platform;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.RecordingCanvas;
import android.graphics.RenderNode;
import android.os.Build;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.CompositingStrategy;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RenderEffect;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

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
public final class RenderNodeApi29 implements DeviceRenderNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AndroidComposeView f28170a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private RenderEffect f28172c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RenderNode f28171b = androidx.compose.foundation.j.a("Compose");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f28173d = CompositingStrategy.f25737b.a();

    public RenderNodeApi29(AndroidComposeView androidComposeView) {
        this.f28170a = androidComposeView;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void A(int i3) {
        this.f28171b.offsetLeftAndRight(i3);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int B() {
        return this.f28171b.getBottom();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void C(float f3) {
        this.f28171b.setPivotX(f3);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void D(float f3) {
        this.f28171b.setPivotY(f3);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void E(Outline outline) {
        this.f28171b.setOutline(outline);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void F(int i3) {
        this.f28171b.setAmbientShadowColor(i3);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void G(boolean z2) {
        this.f28171b.setClipToOutline(z2);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void H(CanvasHolder canvasHolder, Path path, Function1 function1) {
        RecordingCanvas recordingCanvasBeginRecording = this.f28171b.beginRecording();
        Canvas canvasB = canvasHolder.a().B();
        canvasHolder.a().C(recordingCanvasBeginRecording);
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
        this.f28171b.endRecording();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void I(int i3) {
        this.f28171b.setSpotShadowColor(i3);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public float J() {
        return this.f28171b.getElevation();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public float a() {
        return this.f28171b.getAlpha();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void b(Canvas canvas) {
        canvas.drawRenderNode(this.f28171b);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void c(float f3) {
        this.f28171b.setAlpha(f3);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void d(float f3) {
        this.f28171b.setTranslationY(f3);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void e(float f3) {
        this.f28171b.setScaleX(f3);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void f(RenderEffect renderEffect) {
        this.f28172c = renderEffect;
        if (Build.VERSION.SDK_INT >= 31) {
            RenderNodeApi29VerificationHelper.f28174a.a(this.f28171b, renderEffect);
        }
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void g(float f3) {
        this.f28171b.setCameraDistance(f3);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getHeight() {
        return this.f28171b.getHeight();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getWidth() {
        return this.f28171b.getWidth();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void h(float f3) {
        this.f28171b.setRotationX(f3);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void i(float f3) {
        this.f28171b.setRotationY(f3);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void j(float f3) {
        this.f28171b.setRotationZ(f3);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void k(float f3) {
        this.f28171b.setScaleY(f3);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void l(float f3) {
        this.f28171b.setTranslationX(f3);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int m() {
        return this.f28171b.getLeft();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void n() {
        this.f28171b.discardDisplayList();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public boolean o() {
        return this.f28171b.hasDisplayList();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int p() {
        return this.f28171b.getRight();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void q(boolean z2) {
        this.f28171b.setClipToBounds(z2);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public boolean r(int i3, int i4, int i5, int i6) {
        return this.f28171b.setPosition(i3, i4, i5, i6);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void s(int i3) {
        RenderNode renderNode = this.f28171b;
        CompositingStrategy.Companion companion = CompositingStrategy.f25737b;
        if (CompositingStrategy.g(i3, companion.c())) {
            renderNode.setUseCompositingLayer(true, null);
            renderNode.setHasOverlappingRendering(true);
        } else if (CompositingStrategy.g(i3, companion.b())) {
            renderNode.setUseCompositingLayer(false, null);
            renderNode.setHasOverlappingRendering(false);
        } else {
            renderNode.setUseCompositingLayer(false, null);
            renderNode.setHasOverlappingRendering(true);
        }
        this.f28173d = i3;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void t(float f3) {
        this.f28171b.setElevation(f3);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void u(int i3) {
        this.f28171b.offsetTopAndBottom(i3);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public boolean v() {
        return this.f28171b.getClipToBounds();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int w() {
        return this.f28171b.getTop();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public boolean x() {
        return this.f28171b.getClipToOutline();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public boolean y(boolean z2) {
        return this.f28171b.setHasOverlappingRendering(z2);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void z(Matrix matrix) {
        this.f28171b.getMatrix(matrix);
    }
}
