package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.KotlinNothingValueException;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class LayoutNodeDrawScope implements DrawScope, ContentDrawScope {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CanvasDrawScope f27401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private DrawModifierNode f27402b;

    public LayoutNodeDrawScope(CanvasDrawScope canvasDrawScope) {
        this.f27401a = canvasDrawScope;
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void D1(GraphicsLayer graphicsLayer, long j3, final Function1 function1) {
        final DrawModifierNode drawModifierNode = this.f27402b;
        graphicsLayer.G(this, getLayoutDirection(), j3, new Function1<DrawScope, Unit>() { // from class: androidx.compose.ui.node.LayoutNodeDrawScope$record$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) throws Throwable {
                invoke((DrawScope) obj);
                return Unit.f139807a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r2v0, types: [androidx.compose.ui.node.DrawModifierNode] */
            /* JADX WARN: Type inference failed for: r2v1 */
            /* JADX WARN: Type inference failed for: r2v2, types: [androidx.compose.ui.node.DrawModifierNode] */
            /* JADX WARN: Type inference failed for: r2v3 */
            /* JADX WARN: Type inference failed for: r2v4, types: [androidx.compose.ui.graphics.drawscope.DrawContext] */
            /* JADX WARN: Type inference failed for: r2v5 */
            public final void invoke(DrawScope drawScope) throws Throwable {
                LayoutNodeDrawScope layoutNodeDrawScope;
                Density density;
                LayoutDirection layoutDirection;
                Canvas canvasG;
                long jB;
                GraphicsLayer graphicsLayerI;
                Function1 function12;
                Density density2;
                LayoutDirection layoutDirection2;
                Canvas canvasG2;
                long jB2;
                GraphicsLayer graphicsLayerI2;
                ?? Q1 = this.f27403a.f27402b;
                this.f27403a.f27402b = drawModifierNode;
                try {
                    layoutNodeDrawScope = this.f27403a;
                    density = drawScope.Q1().getDensity();
                    layoutDirection = drawScope.Q1().getLayoutDirection();
                    canvasG = drawScope.Q1().g();
                    jB = drawScope.Q1().b();
                    graphicsLayerI = drawScope.Q1().i();
                    function12 = function1;
                    density2 = layoutNodeDrawScope.Q1().getDensity();
                    layoutDirection2 = layoutNodeDrawScope.Q1().getLayoutDirection();
                    canvasG2 = layoutNodeDrawScope.Q1().g();
                    jB2 = layoutNodeDrawScope.Q1().b();
                    graphicsLayerI2 = layoutNodeDrawScope.Q1().i();
                } catch (Throwable th) {
                    th = th;
                    this.f27403a.f27402b = Q1;
                    throw th;
                }
                try {
                    Q1 = layoutNodeDrawScope.Q1();
                    Q1.d(density);
                    Q1.c(layoutDirection);
                    Q1.j(canvasG);
                    Q1.h(jB);
                    Q1.f(graphicsLayerI);
                    canvasG.t();
                    try {
                        function12.invoke(layoutNodeDrawScope);
                        canvasG.k();
                        DrawContext drawContextQ1 = layoutNodeDrawScope.Q1();
                        drawContextQ1.d(density2);
                        drawContextQ1.c(layoutDirection2);
                        drawContextQ1.j(canvasG2);
                        drawContextQ1.h(jB2);
                        drawContextQ1.f(graphicsLayerI2);
                        this.f27403a.f27402b = Q1;
                    } finally {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    Q1 = Q1;
                    this.f27403a.f27402b = Q1;
                    throw th;
                }
            }
        });
    }

    @Override // androidx.compose.ui.unit.Density
    public float F(int i3) {
        return this.f27401a.F(i3);
    }

    @Override // androidx.compose.ui.unit.Density
    public float G(float f3) {
        return this.f27401a.G(f3);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void G0(long j3, long j4, long j5, long j6, DrawStyle drawStyle, float f3, ColorFilter colorFilter, int i3) {
        this.f27401a.G0(j3, j4, j5, j6, drawStyle, f3, colorFilter, i3);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void H1(Brush brush, long j3, long j4, long j5, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i3) {
        this.f27401a.H1(brush, j3, j4, j5, f3, drawStyle, colorFilter, i3);
    }

    @Override // androidx.compose.ui.unit.Density
    public float J0(long j3) {
        return this.f27401a.J0(j3);
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public float K1() {
        return this.f27401a.K1();
    }

    @Override // androidx.compose.ui.unit.Density
    public long M(long j3) {
        return this.f27401a.M(j3);
    }

    @Override // androidx.compose.ui.unit.Density
    public float M1(float f3) {
        return this.f27401a.M1(f3);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void O1(List list, int i3, long j3, float f3, int i4, PathEffect pathEffect, float f4, ColorFilter colorFilter, int i5) {
        this.f27401a.O1(list, i3, j3, f3, i4, pathEffect, f4, colorFilter, i5);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public DrawContext Q1() {
        return this.f27401a.Q1();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void S1(Brush brush, long j3, long j4, float f3, int i3, PathEffect pathEffect, float f4, ColorFilter colorFilter, int i4) {
        this.f27401a.S1(brush, j3, j4, f3, i3, pathEffect, f4, colorFilter, i4);
    }

    @Override // androidx.compose.ui.unit.Density
    public int T1(long j3) {
        return this.f27401a.T1(j3);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public long V1() {
        return this.f27401a.V1();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void W0(ImageBitmap imageBitmap, long j3, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i3) {
        this.f27401a.W0(imageBitmap, j3, f3, drawStyle, colorFilter, i3);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void Y1(Brush brush, float f3, long j3, float f4, DrawStyle drawStyle, ColorFilter colorFilter, int i3) {
        this.f27401a.Y1(brush, f3, j3, f4, drawStyle, colorFilter, i3);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void Z1(ImageBitmap imageBitmap, long j3, long j4, long j5, long j6, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i3, int i4) {
        this.f27401a.Z1(imageBitmap, j3, j4, j5, j6, f3, drawStyle, colorFilter, i3, i4);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public long b() {
        return this.f27401a.b();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void b1(Brush brush, long j3, long j4, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i3) {
        this.f27401a.b1(brush, j3, j4, f3, drawStyle, colorFilter, i3);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void d1(long j3, long j4, long j5, float f3, int i3, PathEffect pathEffect, float f4, ColorFilter colorFilter, int i4) {
        this.f27401a.d1(j3, j4, j5, f3, i3, pathEffect, f4, colorFilter, i4);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void e1(Brush brush, float f3, float f4, boolean z2, long j3, long j4, float f5, DrawStyle drawStyle, ColorFilter colorFilter, int i3) {
        this.f27401a.e1(brush, f3, f4, z2, j3, j4, f5, drawStyle, colorFilter, i3);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void f1(Path path, long j3, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i3) {
        this.f27401a.f1(path, j3, f3, drawStyle, colorFilter, i3);
    }

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return this.f27401a.getDensity();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public LayoutDirection getLayoutDirection() {
        return this.f27401a.getLayoutDirection();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void h1(long j3, long j4, long j5, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i3) {
        this.f27401a.h1(j3, j4, j5, f3, drawStyle, colorFilter, i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v6 */
    @Override // androidx.compose.ui.graphics.drawscope.ContentDrawScope
    public void i2() {
        Canvas canvasG = Q1().g();
        DrawModifierNode drawModifierNode = this.f27402b;
        if (drawModifierNode == null) {
            InlineClassHelperKt.d("Attempting to drawContent for a `null` node. This usually means that a call to ContentDrawScope#drawContent() has been captured inside a lambda, and is being invoked outside of the draw pass. Capturing the scope this way is unsupported - if you are trying to record drawContent with graphicsLayer.record(), make sure you are using the GraphicsLayer#record function within DrawScope, instead of the member function on GraphicsLayer.");
            throw new KotlinNothingValueException();
        }
        ?? B = LayoutNodeDrawScopeKt.b(drawModifierNode);
        if (B == 0) {
            NodeCoordinator nodeCoordinatorJ = DelegatableNodeKt.j(drawModifierNode, NodeKind.a(4));
            if (nodeCoordinatorJ.W2() == drawModifierNode.getNode()) {
                nodeCoordinatorJ = nodeCoordinatorJ.X2();
                Intrinsics.checkNotNull(nodeCoordinatorJ);
            }
            nodeCoordinatorJ.x3(canvasG, Q1().i());
            return;
        }
        int iA = NodeKind.a(4);
        ?? mutableVector = 0;
        while (B != 0) {
            if (B instanceof DrawModifierNode) {
                z((DrawModifierNode) B, canvasG, Q1().i());
            } else if ((B.getKindSet$ui_release() & iA) != 0 && (B instanceof DelegatingNode)) {
                Modifier.Node nodeN2 = ((DelegatingNode) B).n2();
                int i3 = 0;
                B = B;
                mutableVector = mutableVector;
                while (nodeN2 != null) {
                    if ((nodeN2.getKindSet$ui_release() & iA) != 0) {
                        i3++;
                        mutableVector = mutableVector;
                        if (i3 == 1) {
                            B = nodeN2;
                        } else {
                            if (mutableVector == 0) {
                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (B != 0) {
                                mutableVector.b(B);
                                B = 0;
                            }
                            mutableVector.b(nodeN2);
                        }
                    }
                    nodeN2 = nodeN2.getChild$ui_release();
                    B = B;
                    mutableVector = mutableVector;
                }
                if (i3 == 1) {
                }
            }
            B = DelegatableNodeKt.h(mutableVector);
        }
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public long n(float f3) {
        return this.f27401a.n(f3);
    }

    @Override // androidx.compose.ui.unit.Density
    public long o(long j3) {
        return this.f27401a.o(j3);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void p1(long j3, float f3, long j4, float f4, DrawStyle drawStyle, ColorFilter colorFilter, int i3) {
        this.f27401a.p1(j3, f3, j4, f4, drawStyle, colorFilter, i3);
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public float q(long j3) {
        return this.f27401a.q(j3);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void s0(Path path, Brush brush, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i3) {
        this.f27401a.s0(path, brush, f3, drawStyle, colorFilter, i3);
    }

    public final void u(Canvas canvas, long j3, NodeCoordinator nodeCoordinator, Modifier.Node node, GraphicsLayer graphicsLayer) {
        int iA = NodeKind.a(4);
        Modifier.Node nodeH = node;
        MutableVector mutableVector = null;
        while (nodeH != null) {
            if (nodeH instanceof DrawModifierNode) {
                x(canvas, j3, nodeCoordinator, (DrawModifierNode) nodeH, graphicsLayer);
            } else if ((nodeH.getKindSet$ui_release() & iA) != 0 && (nodeH instanceof DelegatingNode)) {
                int i3 = 0;
                for (Modifier.Node nodeN2 = ((DelegatingNode) nodeH).n2(); nodeN2 != null; nodeN2 = nodeN2.getChild$ui_release()) {
                    if ((nodeN2.getKindSet$ui_release() & iA) != 0) {
                        i3++;
                        if (i3 == 1) {
                            nodeH = nodeN2;
                        } else {
                            if (mutableVector == null) {
                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (nodeH != null) {
                                mutableVector.b(nodeH);
                                nodeH = null;
                            }
                            mutableVector.b(nodeN2);
                        }
                    }
                }
                if (i3 == 1) {
                }
            }
            nodeH = DelegatableNodeKt.h(mutableVector);
        }
    }

    @Override // androidx.compose.ui.unit.Density
    public long v(float f3) {
        return this.f27401a.v(f3);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void v1(long j3, float f3, float f4, boolean z2, long j4, long j5, float f5, DrawStyle drawStyle, ColorFilter colorFilter, int i3) {
        this.f27401a.v1(j3, f3, f4, z2, j4, j5, f5, drawStyle, colorFilter, i3);
    }

    public final void x(Canvas canvas, long j3, NodeCoordinator nodeCoordinator, DrawModifierNode drawModifierNode, GraphicsLayer graphicsLayer) {
        DrawModifierNode drawModifierNode2 = this.f27402b;
        this.f27402b = drawModifierNode;
        CanvasDrawScope canvasDrawScope = this.f27401a;
        LayoutDirection layoutDirection = nodeCoordinator.getLayoutDirection();
        Density density = canvasDrawScope.Q1().getDensity();
        LayoutDirection layoutDirection2 = canvasDrawScope.Q1().getLayoutDirection();
        Canvas canvasG = canvasDrawScope.Q1().g();
        long jB = canvasDrawScope.Q1().b();
        GraphicsLayer graphicsLayerI = canvasDrawScope.Q1().i();
        DrawContext drawContextQ1 = canvasDrawScope.Q1();
        drawContextQ1.d(nodeCoordinator);
        drawContextQ1.c(layoutDirection);
        drawContextQ1.j(canvas);
        drawContextQ1.h(j3);
        drawContextQ1.f(graphicsLayer);
        canvas.t();
        try {
            drawModifierNode.draw(this);
            canvas.k();
            DrawContext drawContextQ12 = canvasDrawScope.Q1();
            drawContextQ12.d(density);
            drawContextQ12.c(layoutDirection2);
            drawContextQ12.j(canvasG);
            drawContextQ12.h(jB);
            drawContextQ12.f(graphicsLayerI);
            this.f27402b = drawModifierNode2;
        } catch (Throwable th) {
            canvas.k();
            DrawContext drawContextQ13 = canvasDrawScope.Q1();
            drawContextQ13.d(density);
            drawContextQ13.c(layoutDirection2);
            drawContextQ13.j(canvasG);
            drawContextQ13.h(jB);
            drawContextQ13.f(graphicsLayerI);
            throw th;
        }
    }

    public final void z(DrawModifierNode drawModifierNode, Canvas canvas, GraphicsLayer graphicsLayer) {
        NodeCoordinator nodeCoordinatorJ = DelegatableNodeKt.j(drawModifierNode, NodeKind.a(4));
        nodeCoordinatorJ.X1().m0().x(canvas, IntSizeKt.e(nodeCoordinatorJ.a()), nodeCoordinatorJ, drawModifierNode, graphicsLayer);
    }

    @Override // androidx.compose.ui.unit.Density
    public int z0(float f3) {
        return this.f27401a.z0(f3);
    }

    public /* synthetic */ LayoutNodeDrawScope(CanvasDrawScope canvasDrawScope, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new CanvasDrawScope() : canvasDrawScope);
    }
}
