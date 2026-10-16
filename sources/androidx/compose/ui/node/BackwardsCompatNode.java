package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.BuildDrawCacheParams;
import androidx.compose.ui.draw.DrawCacheModifier;
import androidx.compose.ui.draw.DrawModifier;
import androidx.compose.ui.focus.FocusEventModifier;
import androidx.compose.ui.focus.FocusEventModifierNode;
import androidx.compose.ui.focus.FocusOrder;
import androidx.compose.ui.focus.FocusOrderModifier;
import androidx.compose.ui.focus.FocusProperties;
import androidx.compose.ui.focus.FocusPropertiesModifierNode;
import androidx.compose.ui.focus.FocusRequesterModifier;
import androidx.compose.ui.focus.FocusRequesterModifierNode;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputModifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnGloballyPositionedModifier;
import androidx.compose.ui.layout.OnPlacedModifier;
import androidx.compose.ui.layout.OnRemeasuredModifier;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.layout.RemeasurementModifier;
import androidx.compose.ui.modifier.BackwardsCompatLocalMap;
import androidx.compose.ui.modifier.ModifierLocal;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalMap;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.modifier.ModifierLocalModifierNodeKt;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsModifier;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.media3.extractor.jpeg.xWt.jTYhJgqLBN;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.HashSet;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class BackwardsCompatNode extends Modifier.Node implements LayoutModifierNode, DrawModifierNode, SemanticsModifierNode, PointerInputModifierNode, ModifierLocalModifierNode, ModifierLocalReadScope, ParentDataModifierNode, LayoutAwareModifierNode, GlobalPositionAwareModifierNode, FocusEventModifierNode, FocusPropertiesModifierNode, FocusRequesterModifierNode, OwnerScope, BuildDrawCacheParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Modifier.Element f27273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f27274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private BackwardsCompatLocalMap f27275c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private HashSet f27276d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private LayoutCoordinates f27277f;

    public BackwardsCompatNode(Modifier.Element element) {
        setKindSet$ui_release(NodeKindKt.f(element));
        this.f27273a = element;
        this.f27274b = true;
        this.f27276d = new HashSet();
    }

    private final void p2(boolean z2) {
        if (!isAttached()) {
            InlineClassHelperKt.c("initializeModifier called on unattached node");
        }
        Modifier.Element element = this.f27273a;
        if ((NodeKind.a(32) & getKindSet$ui_release()) != 0) {
            if (element instanceof ModifierLocalConsumer) {
                sideEffect(new Function0<Unit>() { // from class: androidx.compose.ui.node.BackwardsCompatNode$initializeModifier$2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m226invoke();
                        return Unit.f139807a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m226invoke() {
                        this.f27278a.u2();
                    }
                });
            }
            if (element instanceof ModifierLocalProvider) {
                v2((ModifierLocalProvider) element);
            }
        }
        if ((NodeKind.a(4) & getKindSet$ui_release()) != 0) {
            if (element instanceof DrawCacheModifier) {
                this.f27274b = true;
            }
            if (!z2) {
                LayoutModifierNodeKt.a(this);
            }
        }
        if ((NodeKind.a(2) & getKindSet$ui_release()) != 0) {
            if (BackwardsCompatNodeKt.e(this)) {
                NodeCoordinator coordinator$ui_release = getCoordinator$ui_release();
                Intrinsics.checkNotNull(coordinator$ui_release);
                ((LayoutModifierNodeCoordinator) coordinator$ui_release).b4(this);
                coordinator$ui_release.p3();
            }
            if (!z2) {
                LayoutModifierNodeKt.a(this);
                DelegatableNodeKt.o(this).P0();
            }
        }
        if (element instanceof RemeasurementModifier) {
            ((RemeasurementModifier) element).K0(DelegatableNodeKt.o(this));
        }
        if ((NodeKind.a(ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) & getKindSet$ui_release()) != 0) {
            if ((element instanceof OnRemeasuredModifier) && BackwardsCompatNodeKt.e(this)) {
                DelegatableNodeKt.o(this).P0();
            }
            if (element instanceof OnPlacedModifier) {
                this.f27277f = null;
                if (BackwardsCompatNodeKt.e(this)) {
                    DelegatableNodeKt.p(this).s(new Owner.OnLayoutCompletedListener() { // from class: androidx.compose.ui.node.BackwardsCompatNode$initializeModifier$3
                        @Override // androidx.compose.ui.node.Owner.OnLayoutCompletedListener
                        public void j() {
                            if (this.f27279a.f27277f == null) {
                                BackwardsCompatNode backwardsCompatNode = this.f27279a;
                                backwardsCompatNode.p(DelegatableNodeKt.j(backwardsCompatNode, NodeKind.a(ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD)));
                            }
                        }
                    });
                }
            }
        }
        if ((NodeKind.a(Function.MAX_NARGS) & getKindSet$ui_release()) != 0 && (element instanceof OnGloballyPositionedModifier) && BackwardsCompatNodeKt.e(this)) {
            DelegatableNodeKt.o(this).P0();
        }
        if (element instanceof FocusRequesterModifier) {
            ((FocusRequesterModifier) element).k0().e().b(this);
        }
        if ((NodeKind.a(16) & getKindSet$ui_release()) != 0 && (element instanceof PointerInputModifier)) {
            ((PointerInputModifier) element).C1().f(getCoordinator$ui_release());
        }
        if ((NodeKind.a(8) & getKindSet$ui_release()) != 0) {
            DelegatableNodeKt.p(this).F();
        }
    }

    private final void s2() {
        if (!isAttached()) {
            InlineClassHelperKt.c("unInitializeModifier called on unattached node");
        }
        Modifier.Element element = this.f27273a;
        if ((NodeKind.a(32) & getKindSet$ui_release()) != 0) {
            if (element instanceof ModifierLocalProvider) {
                DelegatableNodeKt.p(this).getModifierLocalManager().d(this, ((ModifierLocalProvider) element).getKey());
            }
            if (element instanceof ModifierLocalConsumer) {
                ((ModifierLocalConsumer) element).l1(BackwardsCompatNodeKt.f27283a);
            }
        }
        if ((NodeKind.a(8) & getKindSet$ui_release()) != 0) {
            DelegatableNodeKt.p(this).F();
        }
        if (element instanceof FocusRequesterModifier) {
            ((FocusRequesterModifier) element).k0().e().s(this);
        }
    }

    private final void t2() {
        final Modifier.Element element = this.f27273a;
        if (element instanceof DrawCacheModifier) {
            DelegatableNodeKt.p(this).getSnapshotObserver().i(this, BackwardsCompatNodeKt.f27284b, new Function0<Unit>() { // from class: androidx.compose.ui.node.BackwardsCompatNode$updateDrawCache$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m227invoke();
                    return Unit.f139807a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m227invoke() {
                    ((DrawCacheModifier) element).s1(this);
                }
            });
        }
        this.f27274b = false;
    }

    private final void v2(ModifierLocalProvider modifierLocalProvider) {
        BackwardsCompatLocalMap backwardsCompatLocalMap = this.f27275c;
        if (backwardsCompatLocalMap != null && backwardsCompatLocalMap.a(modifierLocalProvider.getKey())) {
            backwardsCompatLocalMap.d(modifierLocalProvider);
            DelegatableNodeKt.p(this).getModifierLocalManager().f(this, modifierLocalProvider.getKey());
        } else {
            this.f27275c = new BackwardsCompatLocalMap(modifierLocalProvider);
            if (BackwardsCompatNodeKt.e(this)) {
                DelegatableNodeKt.p(this).getModifierLocalManager().a(this, modifierLocalProvider.getKey());
            }
        }
    }

    @Override // androidx.compose.ui.node.ParentDataModifierNode
    public Object H(Density density, Object obj) {
        Modifier.Element element = this.f27273a;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.layout.ParentDataModifier");
        return ((ParentDataModifier) element).H(density, obj);
    }

    @Override // androidx.compose.ui.node.GlobalPositionAwareModifierNode
    public void I(LayoutCoordinates layoutCoordinates) {
        Modifier.Element element = this.f27273a;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.layout.OnGloballyPositionedModifier");
        ((OnGloballyPositionedModifier) element).I(layoutCoordinates);
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public void N(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Modifier.Element element = this.f27273a;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.semantics.SemanticsModifier");
        SemanticsConfiguration semanticsConfigurationQ = ((SemanticsModifier) element).Q();
        Intrinsics.checkNotNull(semanticsPropertyReceiver, "null cannot be cast to non-null type androidx.compose.ui.semantics.SemanticsConfiguration");
        ((SemanticsConfiguration) semanticsPropertyReceiver).b(semanticsConfigurationQ);
    }

    @Override // androidx.compose.ui.focus.FocusEventModifierNode
    public void O(FocusState focusState) {
        Modifier.Element element = this.f27273a;
        if (!(element instanceof FocusEventModifier)) {
            InlineClassHelperKt.c("onFocusEvent called on wrong node");
        }
        ((FocusEventModifier) element).O(focusState);
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public boolean W1() {
        Modifier.Element element = this.f27273a;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        return ((PointerInputModifier) element).C1().c();
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public boolean a1() {
        return isAttached();
    }

    @Override // androidx.compose.ui.draw.BuildDrawCacheParams
    public long b() {
        return IntSizeKt.e(DelegatableNodeKt.j(this, NodeKind.a(ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD)).a());
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        Modifier.Element element = this.f27273a;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.draw.DrawModifier");
        DrawModifier drawModifier = (DrawModifier) element;
        if (this.f27274b && (element instanceof DrawCacheModifier)) {
            t2();
        }
        drawModifier.draw(contentDrawScope);
    }

    @Override // androidx.compose.ui.draw.BuildDrawCacheParams
    public Density getDensity() {
        return DelegatableNodeKt.o(this).U();
    }

    @Override // androidx.compose.ui.draw.BuildDrawCacheParams
    public LayoutDirection getLayoutDirection() {
        return DelegatableNodeKt.o(this).getLayoutDirection();
    }

    @Override // androidx.compose.ui.focus.FocusPropertiesModifierNode
    public void i1(FocusProperties focusProperties) {
        Modifier.Element element = this.f27273a;
        if (!(element instanceof FocusOrderModifier)) {
            InlineClassHelperKt.c("applyFocusProperties called on wrong node");
        }
        ((FocusOrderModifier) element).A1(new FocusOrder(focusProperties));
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public boolean l0() {
        Modifier.Element element = this.f27273a;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        return ((PointerInputModifier) element).C1().a();
    }

    @Override // androidx.compose.ui.node.LayoutAwareModifierNode
    public void m(long j3) {
        Modifier.Element element = this.f27273a;
        if (element instanceof OnRemeasuredModifier) {
            ((OnRemeasuredModifier) element).m(j3);
        }
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        Modifier.Element element = this.f27273a;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return ((LayoutModifier) element).maxIntrinsicHeight(intrinsicMeasureScope, intrinsicMeasurable, i3);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        Modifier.Element element = this.f27273a;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return ((LayoutModifier) element).maxIntrinsicWidth(intrinsicMeasureScope, intrinsicMeasurable, i3);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo11measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j3) {
        Modifier.Element element = this.f27273a;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return ((LayoutModifier) element).mo45measure3p2s80s(measureScope, measurable, j3);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        Modifier.Element element = this.f27273a;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return ((LayoutModifier) element).minIntrinsicHeight(intrinsicMeasureScope, intrinsicMeasurable, i3);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        Modifier.Element element = this.f27273a;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return ((LayoutModifier) element).minIntrinsicWidth(intrinsicMeasureScope, intrinsicMeasurable, i3);
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalModifierNode
    public ModifierLocalMap n0() {
        BackwardsCompatLocalMap backwardsCompatLocalMap = this.f27275c;
        return backwardsCompatLocalMap != null ? backwardsCompatLocalMap : ModifierLocalModifierNodeKt.a();
    }

    public final Modifier.Element n2() {
        return this.f27273a;
    }

    public final HashSet o2() {
        return this.f27276d;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        p2(true);
    }

    @Override // androidx.compose.ui.node.DelegatableNode, androidx.compose.ui.node.PointerInputModifierNode
    public void onDensityChange() {
        if (this.f27273a instanceof PointerInputModifier) {
            u1();
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        s2();
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void onMeasureResultChanged() {
        this.f27274b = true;
        DrawModifierNodeKt.a(this);
    }

    @Override // androidx.compose.ui.node.LayoutAwareModifierNode
    public void p(LayoutCoordinates layoutCoordinates) {
        this.f27277f = layoutCoordinates;
        Modifier.Element element = this.f27273a;
        if (element instanceof OnPlacedModifier) {
            ((OnPlacedModifier) element).p(layoutCoordinates);
        }
    }

    public final void q2() {
        this.f27274b = true;
        DrawModifierNodeKt.a(this);
    }

    public final void r2(Modifier.Element element) {
        if (isAttached()) {
            s2();
        }
        this.f27273a = element;
        setKindSet$ui_release(NodeKindKt.f(element));
        if (isAttached()) {
            p2(false);
        }
    }

    public String toString() {
        return this.f27273a.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r3v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v6 */
    @Override // androidx.compose.ui.modifier.ModifierLocalModifierNode, androidx.compose.ui.modifier.ModifierLocalReadScope
    public Object u(ModifierLocal modifierLocal) {
        NodeChain nodeChainU0;
        this.f27276d.add(modifierLocal);
        int iA = NodeKind.a(32);
        if (!getNode().isAttached()) {
            InlineClassHelperKt.c("visitAncestors called on an unattached node");
        }
        Modifier.Node parent$ui_release = getNode().getParent$ui_release();
        LayoutNode layoutNodeO = DelegatableNodeKt.o(this);
        while (layoutNodeO != null) {
            if ((layoutNodeO.u0().k().getAggregateChildKindSet$ui_release() & iA) != 0) {
                while (parent$ui_release != null) {
                    if ((parent$ui_release.getKindSet$ui_release() & iA) != 0) {
                        ?? H = parent$ui_release;
                        ?? mutableVector = 0;
                        while (H != 0) {
                            if (H instanceof ModifierLocalModifierNode) {
                                ModifierLocalModifierNode modifierLocalModifierNode = (ModifierLocalModifierNode) H;
                                if (modifierLocalModifierNode.n0().a(modifierLocal)) {
                                    return modifierLocalModifierNode.n0().b(modifierLocal);
                                }
                            } else if ((H.getKindSet$ui_release() & iA) != 0 && (H instanceof DelegatingNode)) {
                                Modifier.Node nodeN2 = ((DelegatingNode) H).n2();
                                int i3 = 0;
                                H = H;
                                mutableVector = mutableVector;
                                while (nodeN2 != null) {
                                    if ((nodeN2.getKindSet$ui_release() & iA) != 0) {
                                        i3++;
                                        mutableVector = mutableVector;
                                        if (i3 == 1) {
                                            H = nodeN2;
                                        } else {
                                            if (mutableVector == 0) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (H != 0) {
                                                mutableVector.b(H);
                                                H = 0;
                                            }
                                            mutableVector.b(nodeN2);
                                        }
                                    }
                                    nodeN2 = nodeN2.getChild$ui_release();
                                    H = H;
                                    mutableVector = mutableVector;
                                }
                                if (i3 == 1) {
                                }
                            }
                            H = DelegatableNodeKt.h(mutableVector);
                        }
                    }
                    parent$ui_release = parent$ui_release.getParent$ui_release();
                }
            }
            layoutNodeO = layoutNodeO.B0();
            parent$ui_release = (layoutNodeO == null || (nodeChainU0 = layoutNodeO.u0()) == null) ? null : nodeChainU0.p();
        }
        return modifierLocal.a().invoke();
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public void u1() {
        Modifier.Element element = this.f27273a;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        ((PointerInputModifier) element).C1().d();
    }

    public final void u2() {
        if (isAttached()) {
            this.f27276d.clear();
            DelegatableNodeKt.p(this).getSnapshotObserver().i(this, BackwardsCompatNodeKt.f27285c, new Function0<Unit>() { // from class: androidx.compose.ui.node.BackwardsCompatNode$updateModifierLocalConsumer$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m228invoke();
                    return Unit.f139807a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m228invoke() {
                    Modifier.Element elementN2 = this.f27282a.n2();
                    Intrinsics.checkNotNull(elementN2, "null cannot be cast to non-null type androidx.compose.ui.modifier.ModifierLocalConsumer");
                    ((ModifierLocalConsumer) elementN2).l1(this.f27282a);
                }
            });
        }
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public void g0(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j3) {
        Modifier.Element element = this.f27273a;
        Intrinsics.checkNotNull(element, jTYhJgqLBN.ppCTjB);
        ((PointerInputModifier) element).C1().e(pointerEvent, pointerEventPass, j3);
    }
}
