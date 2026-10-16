package androidx.compose.foundation;

import android.graphics.Canvas;
import android.widget.EdgeEffect;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.DrawModifierNode;
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
final class GlowOverscrollNode extends DelegatingNode implements DrawModifierNode {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AndroidEdgeEffectOverscrollEffect f4948c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final EdgeEffectWrapper f4949d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final PaddingValues f4950f;

    public GlowOverscrollNode(DelegatableNode delegatableNode, AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, EdgeEffectWrapper edgeEffectWrapper, PaddingValues paddingValues) {
        this.f4948c = androidEdgeEffectOverscrollEffect;
        this.f4949d = edgeEffectWrapper;
        this.f4950f = paddingValues;
        m2(delegatableNode);
    }

    private final boolean s2(DrawScope drawScope, EdgeEffect edgeEffect, Canvas canvas) {
        float fM1 = drawScope.M1(this.f4950f.a());
        float f3 = -Float.intBitsToFloat((int) (drawScope.b() >> 32));
        float f4 = (-Float.intBitsToFloat((int) (drawScope.b() & 4294967295L))) + fM1;
        return w2(180.0f, Offset.e((((long) Float.floatToRawIntBits(f3)) << 32) | (((long) Float.floatToRawIntBits(f4)) & 4294967295L)), edgeEffect, canvas);
    }

    private final boolean t2(DrawScope drawScope, EdgeEffect edgeEffect, Canvas canvas) {
        float f3 = -Float.intBitsToFloat((int) (drawScope.b() & 4294967295L));
        float fM1 = drawScope.M1(this.f4950f.b(drawScope.getLayoutDirection()));
        return w2(270.0f, Offset.e((((long) Float.floatToRawIntBits(f3)) << 32) | (4294967295L & ((long) Float.floatToRawIntBits(fM1)))), edgeEffect, canvas);
    }

    private final boolean u2(DrawScope drawScope, EdgeEffect edgeEffect, Canvas canvas) {
        return w2(90.0f, Offset.e((((long) Float.floatToRawIntBits((-MathKt.d(Float.intBitsToFloat((int) (drawScope.b() >> 32)))) + drawScope.M1(this.f4950f.c(drawScope.getLayoutDirection())))) & 4294967295L) | (Float.floatToRawIntBits(0.0f) << 32)), edgeEffect, canvas);
    }

    private final boolean v2(DrawScope drawScope, EdgeEffect edgeEffect, Canvas canvas) {
        float fM1 = drawScope.M1(this.f4950f.d());
        return w2(0.0f, Offset.e((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(fM1)) & 4294967295L)), edgeEffect, canvas);
    }

    private final boolean w2(float f3, long j3, EdgeEffect edgeEffect, Canvas canvas) {
        int iSave = canvas.save();
        canvas.rotate(f3);
        canvas.translate(Float.intBitsToFloat((int) (j3 >> 32)), Float.intBitsToFloat((int) (j3 & 4294967295L)));
        boolean zDraw = edgeEffect.draw(canvas);
        canvas.restoreToCount(iSave);
        return zDraw;
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        this.f4948c.p(contentDrawScope.b());
        if (Size.k(contentDrawScope.b())) {
            contentDrawScope.i2();
            return;
        }
        contentDrawScope.i2();
        this.f4948c.i().getValue();
        Canvas canvasD = AndroidCanvas_androidKt.d(contentDrawScope.Q1().g());
        EdgeEffectWrapper edgeEffectWrapper = this.f4949d;
        boolean zT2 = edgeEffectWrapper.s() ? t2(contentDrawScope, edgeEffectWrapper.i(), canvasD) : false;
        if (edgeEffectWrapper.z()) {
            zT2 = v2(contentDrawScope, edgeEffectWrapper.m(), canvasD) || zT2;
        }
        if (edgeEffectWrapper.v()) {
            zT2 = u2(contentDrawScope, edgeEffectWrapper.k(), canvasD) || zT2;
        }
        if (edgeEffectWrapper.p()) {
            zT2 = s2(contentDrawScope, edgeEffectWrapper.g(), canvasD) || zT2;
        }
        if (zT2) {
            this.f4948c.j();
        }
    }
}
