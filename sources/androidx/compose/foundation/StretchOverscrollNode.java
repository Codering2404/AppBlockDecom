package androidx.compose.foundation;

import android.graphics.Canvas;
import android.graphics.RecordingCanvas;
import android.graphics.RenderNode;
import android.widget.EdgeEffect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.math.MathKt;

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
final class StretchOverscrollNode extends DelegatingNode implements DrawModifierNode {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AndroidEdgeEffectOverscrollEffect f5178c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final EdgeEffectWrapper f5179d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private RenderNode f5180f;

    public StretchOverscrollNode(DelegatableNode delegatableNode, AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, EdgeEffectWrapper edgeEffectWrapper) {
        this.f5178c = androidEdgeEffectOverscrollEffect;
        this.f5179d = edgeEffectWrapper;
        m2(delegatableNode);
    }

    private final boolean s2(EdgeEffect edgeEffect, Canvas canvas) {
        return w2(180.0f, edgeEffect, canvas);
    }

    private final boolean t2(EdgeEffect edgeEffect, Canvas canvas) {
        return w2(270.0f, edgeEffect, canvas);
    }

    private final boolean u2(EdgeEffect edgeEffect, Canvas canvas) {
        return w2(90.0f, edgeEffect, canvas);
    }

    private final boolean v2(EdgeEffect edgeEffect, Canvas canvas) {
        return w2(0.0f, edgeEffect, canvas);
    }

    private final boolean w2(float f3, EdgeEffect edgeEffect, Canvas canvas) {
        if (f3 == 0.0f) {
            return edgeEffect.draw(canvas);
        }
        int iSave = canvas.save();
        canvas.rotate(f3);
        boolean zDraw = edgeEffect.draw(canvas);
        canvas.restoreToCount(iSave);
        return zDraw;
    }

    private final RenderNode x2() {
        RenderNode renderNode = this.f5180f;
        if (renderNode != null) {
            return renderNode;
        }
        RenderNode renderNodeA = j.a("AndroidEdgeEffectOverscrollEffect");
        this.f5180f = renderNodeA;
        return renderNodeA;
    }

    private final boolean y2() {
        EdgeEffectWrapper edgeEffectWrapper = this.f5179d;
        return edgeEffectWrapper.s() || edgeEffectWrapper.t() || edgeEffectWrapper.v() || edgeEffectWrapper.w();
    }

    private final boolean z2() {
        EdgeEffectWrapper edgeEffectWrapper = this.f5179d;
        return edgeEffectWrapper.z() || edgeEffectWrapper.A() || edgeEffectWrapper.p() || edgeEffectWrapper.q();
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        long j3;
        boolean zT2;
        float f3;
        float f4;
        this.f5178c.p(contentDrawScope.b());
        Canvas canvasD = AndroidCanvas_androidKt.d(contentDrawScope.Q1().g());
        this.f5178c.i().getValue();
        if (Size.k(contentDrawScope.b())) {
            contentDrawScope.i2();
            return;
        }
        if (!canvasD.isHardwareAccelerated()) {
            this.f5179d.f();
            contentDrawScope.i2();
            return;
        }
        float fM1 = contentDrawScope.M1(ClipScrollableContainerKt.b());
        EdgeEffectWrapper edgeEffectWrapper = this.f5179d;
        boolean zZ2 = z2();
        boolean zY2 = y2();
        if (zZ2 && zY2) {
            x2().setPosition(0, 0, canvasD.getWidth(), canvasD.getHeight());
        } else if (zZ2) {
            x2().setPosition(0, 0, canvasD.getWidth() + (MathKt.d(fM1) * 2), canvasD.getHeight());
        } else {
            if (!zY2) {
                contentDrawScope.i2();
                return;
            }
            x2().setPosition(0, 0, canvasD.getWidth(), canvasD.getHeight() + (MathKt.d(fM1) * 2));
        }
        RecordingCanvas recordingCanvasBeginRecording = x2().beginRecording();
        if (edgeEffectWrapper.t()) {
            EdgeEffect edgeEffectJ = edgeEffectWrapper.j();
            u2(edgeEffectJ, recordingCanvasBeginRecording);
            edgeEffectJ.finish();
        }
        if (edgeEffectWrapper.s()) {
            EdgeEffect edgeEffectI = edgeEffectWrapper.i();
            zT2 = t2(edgeEffectI, recordingCanvasBeginRecording);
            if (edgeEffectWrapper.u()) {
                float fIntBitsToFloat = Float.intBitsToFloat((int) (this.f5178c.h() & 4294967295L));
                EdgeEffectCompat edgeEffectCompat = EdgeEffectCompat.f4901a;
                j3 = 4294967295L;
                edgeEffectCompat.e(edgeEffectWrapper.j(), edgeEffectCompat.c(edgeEffectI), 1 - fIntBitsToFloat);
            } else {
                j3 = 4294967295L;
            }
        } else {
            j3 = 4294967295L;
            zT2 = false;
        }
        if (edgeEffectWrapper.A()) {
            EdgeEffect edgeEffectN = edgeEffectWrapper.n();
            s2(edgeEffectN, recordingCanvasBeginRecording);
            edgeEffectN.finish();
        }
        if (edgeEffectWrapper.z()) {
            EdgeEffect edgeEffectM = edgeEffectWrapper.m();
            zT2 = v2(edgeEffectM, recordingCanvasBeginRecording) || zT2;
            if (edgeEffectWrapper.B()) {
                float fIntBitsToFloat2 = Float.intBitsToFloat((int) (this.f5178c.h() >> 32));
                EdgeEffectCompat edgeEffectCompat2 = EdgeEffectCompat.f4901a;
                edgeEffectCompat2.e(edgeEffectWrapper.n(), edgeEffectCompat2.c(edgeEffectM), fIntBitsToFloat2);
            }
        }
        if (edgeEffectWrapper.w()) {
            EdgeEffect edgeEffectL = edgeEffectWrapper.l();
            t2(edgeEffectL, recordingCanvasBeginRecording);
            edgeEffectL.finish();
        }
        if (edgeEffectWrapper.v()) {
            EdgeEffect edgeEffectK = edgeEffectWrapper.k();
            zT2 = u2(edgeEffectK, recordingCanvasBeginRecording) || zT2;
            if (edgeEffectWrapper.x()) {
                float fIntBitsToFloat3 = Float.intBitsToFloat((int) (this.f5178c.h() & j3));
                EdgeEffectCompat edgeEffectCompat3 = EdgeEffectCompat.f4901a;
                edgeEffectCompat3.e(edgeEffectWrapper.l(), edgeEffectCompat3.c(edgeEffectK), fIntBitsToFloat3);
            }
        }
        if (edgeEffectWrapper.q()) {
            EdgeEffect edgeEffectH = edgeEffectWrapper.h();
            v2(edgeEffectH, recordingCanvasBeginRecording);
            edgeEffectH.finish();
        }
        if (edgeEffectWrapper.p()) {
            EdgeEffect edgeEffectG = edgeEffectWrapper.g();
            boolean z2 = s2(edgeEffectG, recordingCanvasBeginRecording) || zT2;
            if (edgeEffectWrapper.r()) {
                float fIntBitsToFloat4 = Float.intBitsToFloat((int) (this.f5178c.h() >> 32));
                EdgeEffectCompat edgeEffectCompat4 = EdgeEffectCompat.f4901a;
                edgeEffectCompat4.e(edgeEffectWrapper.h(), edgeEffectCompat4.c(edgeEffectG), 1 - fIntBitsToFloat4);
            }
            zT2 = z2;
        }
        if (zT2) {
            this.f5178c.j();
        }
        float f5 = zY2 ? 0.0f : fM1;
        if (zZ2) {
            fM1 = 0.0f;
        }
        LayoutDirection layoutDirection = contentDrawScope.getLayoutDirection();
        androidx.compose.ui.graphics.Canvas canvasB = AndroidCanvas_androidKt.b(recordingCanvasBeginRecording);
        long jB = contentDrawScope.b();
        Density density = contentDrawScope.Q1().getDensity();
        LayoutDirection layoutDirection2 = contentDrawScope.Q1().getLayoutDirection();
        androidx.compose.ui.graphics.Canvas canvasG = contentDrawScope.Q1().g();
        long jB2 = contentDrawScope.Q1().b();
        GraphicsLayer graphicsLayerI = contentDrawScope.Q1().i();
        DrawContext drawContextQ1 = contentDrawScope.Q1();
        drawContextQ1.d(contentDrawScope);
        drawContextQ1.c(layoutDirection);
        drawContextQ1.j(canvasB);
        drawContextQ1.h(jB);
        drawContextQ1.f(null);
        canvasB.t();
        try {
            contentDrawScope.Q1().e().e(f5, fM1);
            try {
                contentDrawScope.i2();
                canvasB.k();
                DrawContext drawContextQ12 = contentDrawScope.Q1();
                drawContextQ12.d(density);
                drawContextQ12.c(layoutDirection2);
                drawContextQ12.j(canvasG);
                drawContextQ12.h(jB2);
                drawContextQ12.f(graphicsLayerI);
                x2().endRecording();
                int iSave = canvasD.save();
                canvasD.translate(f3, f4);
                canvasD.drawRenderNode(x2());
                canvasD.restoreToCount(iSave);
            } finally {
                contentDrawScope.Q1().e().e(-f5, -fM1);
            }
        } catch (Throwable th) {
            canvasB.k();
            DrawContext drawContextQ13 = contentDrawScope.Q1();
            drawContextQ13.d(density);
            drawContextQ13.c(layoutDirection2);
            drawContextQ13.j(canvasG);
            drawContextQ13.h(jB2);
            drawContextQ13.f(graphicsLayerI);
            throw th;
        }
    }
}
