package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
final class CacheDrawModifierNodeImpl extends Modifier.Node implements CacheDrawModifierNode, ObserverModifierNode, BuildDrawCacheParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CacheDrawScope f25384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f25385b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ScopedGraphicsContext f25386c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Function1 f25387d;

    public CacheDrawModifierNodeImpl(CacheDrawScope cacheDrawScope, Function1 function1) {
        this.f25384a = cacheDrawScope;
        this.f25387d = function1;
        cacheDrawScope.I(this);
        cacheDrawScope.Q(new Function0<GraphicsContext>() { // from class: androidx.compose.ui.draw.CacheDrawModifierNodeImpl.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final GraphicsContext invoke() {
                return CacheDrawModifierNodeImpl.this.n2();
            }
        });
    }

    private final DrawResult o2(ContentDrawScope contentDrawScope) {
        if (!this.f25385b) {
            final CacheDrawScope cacheDrawScope = this.f25384a;
            cacheDrawScope.O(null);
            cacheDrawScope.N(contentDrawScope);
            ObserverModifierNodeKt.a(this, new Function0<Unit>() { // from class: androidx.compose.ui.draw.CacheDrawModifierNodeImpl$getOrBuildCachedDrawBlock$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m210invoke();
                    return Unit.f139807a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m210invoke() {
                    this.f25389a.m2().invoke(cacheDrawScope);
                }
            });
            if (cacheDrawScope.m() == null) {
                InlineClassHelperKt.d("DrawResult not defined, did you forget to call onDraw?");
                throw new KotlinNothingValueException();
            }
            this.f25385b = true;
        }
        DrawResult drawResultM = this.f25384a.m();
        Intrinsics.checkNotNull(drawResultM);
        return drawResultM;
    }

    @Override // androidx.compose.ui.draw.CacheDrawModifierNode
    public void X0() {
        ScopedGraphicsContext scopedGraphicsContext = this.f25386c;
        if (scopedGraphicsContext != null) {
            scopedGraphicsContext.d();
        }
        this.f25385b = false;
        this.f25384a.O(null);
        DrawModifierNodeKt.a(this);
    }

    @Override // androidx.compose.ui.draw.BuildDrawCacheParams
    public long b() {
        return IntSizeKt.e(DelegatableNodeKt.j(this, NodeKind.a(ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD)).a());
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        o2(contentDrawScope).a().invoke(contentDrawScope);
    }

    @Override // androidx.compose.ui.draw.BuildDrawCacheParams
    public Density getDensity() {
        return DelegatableNodeKt.k(this);
    }

    @Override // androidx.compose.ui.draw.BuildDrawCacheParams
    public LayoutDirection getLayoutDirection() {
        return DelegatableNodeKt.n(this);
    }

    public final Function1 m2() {
        return this.f25387d;
    }

    public final GraphicsContext n2() {
        ScopedGraphicsContext scopedGraphicsContext = this.f25386c;
        if (scopedGraphicsContext == null) {
            scopedGraphicsContext = new ScopedGraphicsContext();
            this.f25386c = scopedGraphicsContext;
        }
        if (scopedGraphicsContext.c() == null) {
            scopedGraphicsContext.e(DelegatableNodeKt.l(this));
        }
        return scopedGraphicsContext;
    }

    @Override // androidx.compose.ui.node.DelegatableNode, androidx.compose.ui.node.PointerInputModifierNode
    public void onDensityChange() {
        X0();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        super.onDetach();
        ScopedGraphicsContext scopedGraphicsContext = this.f25386c;
        if (scopedGraphicsContext != null) {
            scopedGraphicsContext.d();
        }
    }

    @Override // androidx.compose.ui.node.DelegatableNode
    public void onLayoutDirectionChange() {
        X0();
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void onMeasureResultChanged() {
        X0();
    }

    public final void p2(Function1 function1) {
        this.f25387d = function1;
        X0();
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public void w0() {
        X0();
    }
}
