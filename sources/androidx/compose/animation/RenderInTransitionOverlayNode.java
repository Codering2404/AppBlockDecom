package androidx.compose.animation;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DrawModifierNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

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
public final class RenderInTransitionOverlayNode extends Modifier.Node implements DrawModifierNode, ModifierLocalModifierNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SharedTransitionScopeImpl f3580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Function0 f3581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Function2 f3582c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MutableFloatState f3583d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private LayerWithRenderer f3584f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private final class LayerWithRenderer implements LayerRenderer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final GraphicsLayer f3585a;

        public LayerWithRenderer(GraphicsLayer graphicsLayer) {
            this.f3585a = graphicsLayer;
        }

        @Override // androidx.compose.animation.LayerRenderer
        public float a() {
            return RenderInTransitionOverlayNode.this.q2();
        }

        @Override // androidx.compose.animation.LayerRenderer
        public void b(DrawScope drawScope) {
            if (((Boolean) RenderInTransitionOverlayNode.this.o2().invoke()).booleanValue()) {
                RenderInTransitionOverlayNode renderInTransitionOverlayNode = RenderInTransitionOverlayNode.this;
                long jS = renderInTransitionOverlayNode.p2().i().S(DelegatableNodeKt.m(renderInTransitionOverlayNode), Offset.f25596b.c());
                float fIntBitsToFloat = Float.intBitsToFloat((int) (jS >> 32));
                float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jS & 4294967295L));
                Path path = (Path) renderInTransitionOverlayNode.m2().invoke(drawScope.getLayoutDirection(), DelegatableNodeKt.k(renderInTransitionOverlayNode));
                if (path == null) {
                    drawScope.Q1().e().e(fIntBitsToFloat, fIntBitsToFloat2);
                    try {
                        GraphicsLayerKt.a(drawScope, this.f3585a);
                        return;
                    } finally {
                    }
                }
                int iB = ClipOp.f25711b.b();
                DrawContext drawContextQ1 = drawScope.Q1();
                long jB = drawContextQ1.b();
                drawContextQ1.g().t();
                try {
                    drawContextQ1.e().d(path, iB);
                    drawScope.Q1().e().e(fIntBitsToFloat, fIntBitsToFloat2);
                    try {
                        GraphicsLayerKt.a(drawScope, this.f3585a);
                    } finally {
                    }
                } finally {
                    drawContextQ1.g().k();
                    drawContextQ1.h(jB);
                }
            }
        }

        public final GraphicsLayer c() {
            return this.f3585a;
        }
    }

    public RenderInTransitionOverlayNode(SharedTransitionScopeImpl sharedTransitionScopeImpl, Function0 function0, float f3, Function2 function2) {
        this.f3580a = sharedTransitionScopeImpl;
        this.f3581b = function0;
        this.f3582c = function2;
        this.f3583d = PrimitiveSnapshotStateKt.a(f3);
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(final ContentDrawScope contentDrawScope) {
        GraphicsLayer graphicsLayerN2 = n2();
        if (graphicsLayerN2 == null) {
            throw new IllegalArgumentException("Error: layer never initialized");
        }
        DrawScope.a2(contentDrawScope, graphicsLayerN2, 0L, new Function1<DrawScope, Unit>() { // from class: androidx.compose.animation.RenderInTransitionOverlayNode.draw.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((DrawScope) obj);
                return Unit.f139807a;
            }

            public final void invoke(DrawScope drawScope) {
                contentDrawScope.i2();
            }
        }, 1, null);
        if (((Boolean) this.f3581b.invoke()).booleanValue()) {
            return;
        }
        GraphicsLayerKt.a(contentDrawScope, graphicsLayerN2);
    }

    public final Function2 m2() {
        return this.f3582c;
    }

    public final GraphicsLayer n2() {
        LayerWithRenderer layerWithRenderer = this.f3584f;
        if (layerWithRenderer != null) {
            return layerWithRenderer.c();
        }
        return null;
    }

    public final Function0 o2() {
        return this.f3581b;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        LayerWithRenderer layerWithRenderer = new LayerWithRenderer(DelegatableNodeKt.l(this).a());
        this.f3580a.n(layerWithRenderer);
        this.f3584f = layerWithRenderer;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        LayerWithRenderer layerWithRenderer = this.f3584f;
        if (layerWithRenderer != null) {
            this.f3580a.o(layerWithRenderer);
            DelegatableNodeKt.l(this).b(layerWithRenderer.c());
        }
    }

    public final SharedTransitionScopeImpl p2() {
        return this.f3580a;
    }

    public final float q2() {
        return this.f3583d.c();
    }

    public final void r2(Function2 function2) {
        this.f3582c = function2;
    }

    public final void s2(Function0 function0) {
        this.f3581b = function0;
    }

    public final void t2(SharedTransitionScopeImpl sharedTransitionScopeImpl) {
        this.f3580a = sharedTransitionScopeImpl;
    }

    public final void u2(float f3) {
        this.f3583d.s(f3);
    }
}
