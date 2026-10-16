package androidx.compose.foundation;

import androidx.compose.foundation.gestures.BringIntoViewSpec;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.gestures.ScrollableNode;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
final class ScrollingContainerNode extends DelegatingNode implements CompositionLocalConsumerModifierNode, ObserverModifierNode {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ScrollableState f5159c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Orientation f5160d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f5161f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f5162g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private FlingBehavior f5163h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private MutableInteractionSource f5164i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private BringIntoViewSpec f5165j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f5166k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private OverscrollEffect f5167l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final boolean f5168m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ScrollableNode f5169n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private DelegatableNode f5170o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private OverscrollFactory f5171p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private OverscrollEffect f5172q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f5173r;

    public ScrollingContainerNode(ScrollableState scrollableState, Orientation orientation, boolean z2, boolean z3, FlingBehavior flingBehavior, MutableInteractionSource mutableInteractionSource, BringIntoViewSpec bringIntoViewSpec, boolean z4, OverscrollEffect overscrollEffect) {
        this.f5159c = scrollableState;
        this.f5160d = orientation;
        this.f5161f = z2;
        this.f5162g = z3;
        this.f5163h = flingBehavior;
        this.f5164i = mutableInteractionSource;
        this.f5165j = bringIntoViewSpec;
        this.f5166k = z4;
        this.f5167l = overscrollEffect;
    }

    private final void v2() {
        DelegatableNode delegatableNode = this.f5170o;
        if (delegatableNode != null) {
            if (delegatableNode == null || delegatableNode.getNode().isAttached()) {
                return;
            }
            m2(delegatableNode);
            return;
        }
        if (this.f5166k) {
            ObserverModifierNodeKt.a(this, new Function0<Unit>() { // from class: androidx.compose.foundation.ScrollingContainerNode$attachOverscrollNodeIfNeeded$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m31invoke();
                    return Unit.f139807a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m31invoke() {
                    ScrollingContainerNode scrollingContainerNode = this.f5174a;
                    scrollingContainerNode.f5171p = (OverscrollFactory) CompositionLocalConsumerModifierNodeKt.a(scrollingContainerNode, OverscrollKt.a());
                    ScrollingContainerNode scrollingContainerNode2 = this.f5174a;
                    OverscrollFactory overscrollFactory = scrollingContainerNode2.f5171p;
                    scrollingContainerNode2.f5172q = overscrollFactory != null ? overscrollFactory.a() : null;
                }
            });
        }
        OverscrollEffect overscrollEffectW2 = w2();
        if (overscrollEffectW2 != null) {
            DelegatableNode node = overscrollEffectW2.getNode();
            if (node.getNode().isAttached()) {
                return;
            }
            this.f5170o = m2(node);
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return this.f5168m;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        this.f5173r = x2();
        v2();
        if (this.f5169n == null) {
            this.f5169n = (ScrollableNode) m2(new ScrollableNode(this.f5159c, w2(), this.f5163h, this.f5160d, this.f5161f, this.f5173r, this.f5164i, this.f5165j));
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        DelegatableNode delegatableNode = this.f5170o;
        if (delegatableNode != null) {
            p2(delegatableNode);
        }
    }

    @Override // androidx.compose.ui.node.DelegatableNode
    public void onLayoutDirectionChange() {
        boolean zX2 = x2();
        if (this.f5173r != zX2) {
            this.f5173r = zX2;
            y2(this.f5159c, this.f5160d, this.f5166k, w2(), this.f5161f, this.f5162g, this.f5163h, this.f5164i, this.f5165j);
        }
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public void w0() {
        OverscrollFactory overscrollFactory = (OverscrollFactory) CompositionLocalConsumerModifierNodeKt.a(this, OverscrollKt.a());
        if (Intrinsics.areEqual(overscrollFactory, this.f5171p)) {
            return;
        }
        this.f5171p = overscrollFactory;
        this.f5172q = null;
        DelegatableNode delegatableNode = this.f5170o;
        if (delegatableNode != null) {
            p2(delegatableNode);
        }
        this.f5170o = null;
        v2();
        ScrollableNode scrollableNode = this.f5169n;
        if (scrollableNode != null) {
            scrollableNode.W2(this.f5159c, this.f5160d, w2(), this.f5161f, this.f5173r, this.f5163h, this.f5164i, this.f5165j);
        }
    }

    public final OverscrollEffect w2() {
        return this.f5166k ? this.f5172q : this.f5167l;
    }

    public final boolean x2() {
        LayoutDirection layoutDirectionN = LayoutDirection.f30001a;
        if (isAttached()) {
            layoutDirectionN = DelegatableNodeKt.n(this);
        }
        return ScrollableDefaults.f6072a.b(layoutDirectionN, this.f5160d, this.f5162g);
    }

    public final void y2(ScrollableState scrollableState, Orientation orientation, boolean z2, OverscrollEffect overscrollEffect, boolean z3, boolean z4, FlingBehavior flingBehavior, MutableInteractionSource mutableInteractionSource, BringIntoViewSpec bringIntoViewSpec) {
        boolean z5;
        this.f5159c = scrollableState;
        this.f5160d = orientation;
        boolean z6 = true;
        if (this.f5166k != z2) {
            this.f5166k = z2;
            z5 = true;
        } else {
            z5 = false;
        }
        if (Intrinsics.areEqual(this.f5167l, overscrollEffect)) {
            z6 = false;
        } else {
            this.f5167l = overscrollEffect;
        }
        if (z5 || (z6 && !z2)) {
            DelegatableNode delegatableNode = this.f5170o;
            if (delegatableNode != null) {
                p2(delegatableNode);
            }
            this.f5170o = null;
            v2();
        }
        this.f5161f = z3;
        this.f5162g = z4;
        this.f5163h = flingBehavior;
        this.f5164i = mutableInteractionSource;
        this.f5165j = bringIntoViewSpec;
        this.f5173r = x2();
        ScrollableNode scrollableNode = this.f5169n;
        if (scrollableNode != null) {
            scrollableNode.W2(scrollableState, orientation, w2(), z3, this.f5173r, flingBehavior, mutableInteractionSource, bringIntoViewSpec);
        }
    }
}
