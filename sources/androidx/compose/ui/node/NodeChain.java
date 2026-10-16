package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.ModifierInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
public final class NodeChain {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LayoutNode f27536a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InnerNodeCoordinator f27537b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private NodeCoordinator f27538c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Modifier.Node f27539d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Modifier.Node f27540e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private MutableVector f27541f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private MutableVector f27542g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Differ f27543h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Logger f27544i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private final class Differ implements DiffCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Modifier.Node f27545a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f27546b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private MutableVector f27547c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private MutableVector f27548d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f27549e;

        public Differ(Modifier.Node node, int i3, MutableVector mutableVector, MutableVector mutableVector2, boolean z2) {
            this.f27545a = node;
            this.f27546b = i3;
            this.f27547c = mutableVector;
            this.f27548d = mutableVector2;
            this.f27549e = z2;
        }

        @Override // androidx.compose.ui.node.DiffCallback
        public void a(int i3, int i4) {
            Modifier.Node child$ui_release = this.f27545a.getChild$ui_release();
            Intrinsics.checkNotNull(child$ui_release);
            Logger logger = NodeChain.this.f27544i;
            if (logger != null) {
                MutableVector mutableVector = this.f27547c;
                logger.d(i4, (Modifier.Element) mutableVector.f24389a[this.f27546b + i4], child$ui_release);
            }
            if ((NodeKind.a(2) & child$ui_release.getKindSet$ui_release()) != 0) {
                NodeCoordinator coordinator$ui_release = child$ui_release.getCoordinator$ui_release();
                Intrinsics.checkNotNull(coordinator$ui_release);
                NodeCoordinator nodeCoordinatorY2 = coordinator$ui_release.Y2();
                NodeCoordinator nodeCoordinatorX2 = coordinator$ui_release.X2();
                Intrinsics.checkNotNull(nodeCoordinatorX2);
                if (nodeCoordinatorY2 != null) {
                    nodeCoordinatorY2.H3(nodeCoordinatorX2);
                }
                nodeCoordinatorX2.I3(nodeCoordinatorY2);
                NodeChain.this.w(this.f27545a, nodeCoordinatorX2);
            }
            this.f27545a = NodeChain.this.h(child$ui_release);
        }

        @Override // androidx.compose.ui.node.DiffCallback
        public boolean b(int i3, int i4) {
            MutableVector mutableVector = this.f27547c;
            int i5 = this.f27546b;
            return NodeChainKt.d((Modifier.Element) mutableVector.f24389a[i3 + i5], (Modifier.Element) this.f27548d.f24389a[i5 + i4]) != 0;
        }

        @Override // androidx.compose.ui.node.DiffCallback
        public void c(int i3) {
            int i4 = this.f27546b + i3;
            Modifier.Node node = this.f27545a;
            this.f27545a = NodeChain.this.g((Modifier.Element) this.f27548d.f24389a[i4], node);
            Logger logger = NodeChain.this.f27544i;
            if (logger != null) {
                logger.a(i4, i4, (Modifier.Element) this.f27548d.f24389a[i4], node, this.f27545a);
            }
            if (!this.f27549e) {
                this.f27545a.setInsertedNodeAwaitingAttachForInvalidation$ui_release(true);
                return;
            }
            Modifier.Node child$ui_release = this.f27545a.getChild$ui_release();
            Intrinsics.checkNotNull(child$ui_release);
            NodeCoordinator coordinator$ui_release = child$ui_release.getCoordinator$ui_release();
            Intrinsics.checkNotNull(coordinator$ui_release);
            LayoutModifierNode layoutModifierNodeD = DelegatableNodeKt.d(this.f27545a);
            if (layoutModifierNodeD != null) {
                LayoutModifierNodeCoordinator layoutModifierNodeCoordinator = new LayoutModifierNodeCoordinator(NodeChain.this.m(), layoutModifierNodeD);
                this.f27545a.updateCoordinator$ui_release(layoutModifierNodeCoordinator);
                NodeChain.this.w(this.f27545a, layoutModifierNodeCoordinator);
                layoutModifierNodeCoordinator.I3(coordinator$ui_release.Y2());
                layoutModifierNodeCoordinator.H3(coordinator$ui_release);
                coordinator$ui_release.I3(layoutModifierNodeCoordinator);
            } else {
                this.f27545a.updateCoordinator$ui_release(coordinator$ui_release);
            }
            this.f27545a.markAsAttached$ui_release();
            this.f27545a.runAttachLifecycle$ui_release();
            NodeKindKt.a(this.f27545a);
        }

        @Override // androidx.compose.ui.node.DiffCallback
        public void d(int i3, int i4) {
            Modifier.Node child$ui_release = this.f27545a.getChild$ui_release();
            Intrinsics.checkNotNull(child$ui_release);
            this.f27545a = child$ui_release;
            MutableVector mutableVector = this.f27547c;
            int i5 = this.f27546b;
            Modifier.Element element = (Modifier.Element) mutableVector.f24389a[i5 + i3];
            Modifier.Element element2 = (Modifier.Element) this.f27548d.f24389a[i5 + i4];
            if (Intrinsics.areEqual(element, element2)) {
                Logger logger = NodeChain.this.f27544i;
                if (logger != null) {
                    int i6 = this.f27546b;
                    logger.e(i6 + i3, i6 + i4, element, element2, this.f27545a);
                    return;
                }
                return;
            }
            NodeChain.this.G(element, element2, this.f27545a);
            Logger logger2 = NodeChain.this.f27544i;
            if (logger2 != null) {
                int i7 = this.f27546b;
                logger2.b(i7 + i3, i7 + i4, element, element2, this.f27545a);
            }
        }

        public final void e(MutableVector mutableVector) {
            this.f27548d = mutableVector;
        }

        public final void f(MutableVector mutableVector) {
            this.f27547c = mutableVector;
        }

        public final void g(Modifier.Node node) {
            this.f27545a = node;
        }

        public final void h(int i3) {
            this.f27546b = i3;
        }

        public final void i(boolean z2) {
            this.f27549e = z2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface Logger {
        void a(int i3, int i4, Modifier.Element element, Modifier.Node node, Modifier.Node node2);

        void b(int i3, int i4, Modifier.Element element, Modifier.Element element2, Modifier.Node node);

        void c(int i3, Modifier.Element element, Modifier.Element element2, Modifier.Node node);

        void d(int i3, Modifier.Element element, Modifier.Node node);

        void e(int i3, int i4, Modifier.Element element, Modifier.Element element2, Modifier.Node node);
    }

    public NodeChain(LayoutNode layoutNode) {
        this.f27536a = layoutNode;
        InnerNodeCoordinator innerNodeCoordinator = new InnerNodeCoordinator(layoutNode);
        this.f27537b = innerNodeCoordinator;
        this.f27538c = innerNodeCoordinator;
        TailModifierNode tailModifierNodeW3 = innerNodeCoordinator.W2();
        this.f27539d = tailModifierNodeW3;
        this.f27540e = tailModifierNodeW3;
    }

    private final void B(int i3, MutableVector mutableVector, MutableVector mutableVector2, Modifier.Node node, boolean z2) {
        MyersDiffKt.e(mutableVector.o() - i3, mutableVector2.o() - i3, j(node, i3, mutableVector, mutableVector2, z2));
        C();
    }

    private final void C() {
        int kindSet$ui_release = 0;
        for (Modifier.Node parent$ui_release = this.f27539d.getParent$ui_release(); parent$ui_release != null && parent$ui_release != NodeChainKt.f27551a; parent$ui_release = parent$ui_release.getParent$ui_release()) {
            kindSet$ui_release |= parent$ui_release.getKindSet$ui_release();
            parent$ui_release.setAggregateChildKindSet$ui_release(kindSet$ui_release);
        }
    }

    private final Modifier.Node E(Modifier.Node node) {
        if (!(node == NodeChainKt.f27551a)) {
            InlineClassHelperKt.c("trimChain called on already trimmed chain");
        }
        Modifier.Node child$ui_release = NodeChainKt.f27551a.getChild$ui_release();
        if (child$ui_release == null) {
            child$ui_release = this.f27539d;
        }
        child$ui_release.setParent$ui_release(null);
        NodeChainKt.f27551a.setChild$ui_release(null);
        NodeChainKt.f27551a.setAggregateChildKindSet$ui_release(-1);
        NodeChainKt.f27551a.updateCoordinator$ui_release(null);
        if (!(child$ui_release != NodeChainKt.f27551a)) {
            InlineClassHelperKt.c("trimChain did not update the head");
        }
        return child$ui_release;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(Modifier.Element element, Modifier.Element element2, Modifier.Node node) {
        if ((element instanceof ModifierNodeElement) && (element2 instanceof ModifierNodeElement)) {
            NodeChainKt.f((ModifierNodeElement) element2, node);
            if (node.isAttached()) {
                NodeKindKt.e(node);
                return;
            } else {
                node.setUpdatedNodeAwaitingAttachForInvalidation$ui_release(true);
                return;
            }
        }
        if (!(node instanceof BackwardsCompatNode)) {
            InlineClassHelperKt.c("Unknown Modifier.Node type");
            return;
        }
        ((BackwardsCompatNode) node).r2(element2);
        if (node.isAttached()) {
            NodeKindKt.e(node);
        } else {
            node.setUpdatedNodeAwaitingAttachForInvalidation$ui_release(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Modifier.Node g(Modifier.Element element, Modifier.Node node) {
        Modifier.Node backwardsCompatNode;
        if (element instanceof ModifierNodeElement) {
            backwardsCompatNode = ((ModifierNodeElement) element).create();
            backwardsCompatNode.setKindSet$ui_release(NodeKindKt.h(backwardsCompatNode));
        } else {
            backwardsCompatNode = new BackwardsCompatNode(element);
        }
        if (backwardsCompatNode.isAttached()) {
            InlineClassHelperKt.c("A ModifierNodeElement cannot return an already attached node from create() ");
        }
        backwardsCompatNode.setInsertedNodeAwaitingAttachForInvalidation$ui_release(true);
        return r(backwardsCompatNode, node);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Modifier.Node h(Modifier.Node node) {
        if (node.isAttached()) {
            NodeKindKt.d(node);
            node.runDetachLifecycle$ui_release();
            node.markAsDetached$ui_release();
        }
        return x(node);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int i() {
        return this.f27540e.getAggregateChildKindSet$ui_release();
    }

    private final Differ j(Modifier.Node node, int i3, MutableVector mutableVector, MutableVector mutableVector2, boolean z2) {
        Differ differ = this.f27543h;
        if (differ == null) {
            Differ differ2 = new Differ(node, i3, mutableVector, mutableVector2, z2);
            this.f27543h = differ2;
            return differ2;
        }
        differ.g(node);
        differ.h(i3);
        differ.f(mutableVector);
        differ.e(mutableVector2);
        differ.i(z2);
        return differ;
    }

    private final Modifier.Node r(Modifier.Node node, Modifier.Node node2) {
        Modifier.Node child$ui_release = node2.getChild$ui_release();
        if (child$ui_release != null) {
            child$ui_release.setParent$ui_release(node);
            node.setChild$ui_release(child$ui_release);
        }
        node2.setChild$ui_release(node);
        node.setParent$ui_release(node2);
        return node;
    }

    private final Modifier.Node v() {
        if (!(this.f27540e != NodeChainKt.f27551a)) {
            InlineClassHelperKt.c("padChain called on already padded chain");
        }
        Modifier.Node node = this.f27540e;
        node.setParent$ui_release(NodeChainKt.f27551a);
        NodeChainKt.f27551a.setChild$ui_release(node);
        return NodeChainKt.f27551a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(Modifier.Node node, NodeCoordinator nodeCoordinator) {
        for (Modifier.Node parent$ui_release = node.getParent$ui_release(); parent$ui_release != null; parent$ui_release = parent$ui_release.getParent$ui_release()) {
            if (parent$ui_release == NodeChainKt.f27551a) {
                LayoutNode layoutNodeB0 = this.f27536a.B0();
                nodeCoordinator.I3(layoutNodeB0 != null ? layoutNodeB0.Z() : null);
                this.f27538c = nodeCoordinator;
                return;
            } else {
                if ((NodeKind.a(2) & parent$ui_release.getKindSet$ui_release()) != 0) {
                    return;
                }
                parent$ui_release.updateCoordinator$ui_release(nodeCoordinator);
            }
        }
    }

    private final Modifier.Node x(Modifier.Node node) {
        Modifier.Node child$ui_release = node.getChild$ui_release();
        Modifier.Node parent$ui_release = node.getParent$ui_release();
        if (child$ui_release != null) {
            child$ui_release.setParent$ui_release(parent$ui_release);
            node.setChild$ui_release(null);
        }
        if (parent$ui_release != null) {
            parent$ui_release.setChild$ui_release(child$ui_release);
            node.setParent$ui_release(null);
        }
        Intrinsics.checkNotNull(parent$ui_release);
        return parent$ui_release;
    }

    public final void A() {
        for (Modifier.Node nodeP = p(); nodeP != null; nodeP = nodeP.getParent$ui_release()) {
            if (nodeP.isAttached()) {
                nodeP.runDetachLifecycle$ui_release();
            }
        }
        NodeCoordinator nodeCoordinatorY2 = this.f27537b;
        NodeCoordinator nodeCoordinator = this.f27538c;
        while (nodeCoordinatorY2 != nodeCoordinator) {
            nodeCoordinatorY2.o3();
            nodeCoordinatorY2 = nodeCoordinatorY2.Y2();
            Intrinsics.checkNotNull(nodeCoordinatorY2);
        }
        nodeCoordinator.o3();
    }

    public final void D() {
        NodeCoordinator layoutModifierNodeCoordinator;
        NodeCoordinator nodeCoordinator = this.f27537b;
        for (Modifier.Node parent$ui_release = this.f27539d.getParent$ui_release(); parent$ui_release != null; parent$ui_release = parent$ui_release.getParent$ui_release()) {
            LayoutModifierNode layoutModifierNodeD = DelegatableNodeKt.d(parent$ui_release);
            if (layoutModifierNodeD != null) {
                if (parent$ui_release.getCoordinator$ui_release() != null) {
                    NodeCoordinator coordinator$ui_release = parent$ui_release.getCoordinator$ui_release();
                    Intrinsics.checkNotNull(coordinator$ui_release, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
                    layoutModifierNodeCoordinator = (LayoutModifierNodeCoordinator) coordinator$ui_release;
                    LayoutModifierNode layoutModifierNodeX3 = layoutModifierNodeCoordinator.X3();
                    layoutModifierNodeCoordinator.b4(layoutModifierNodeD);
                    if (layoutModifierNodeX3 != parent$ui_release) {
                        layoutModifierNodeCoordinator.p3();
                    }
                } else {
                    layoutModifierNodeCoordinator = new LayoutModifierNodeCoordinator(this.f27536a, layoutModifierNodeD);
                    parent$ui_release.updateCoordinator$ui_release(layoutModifierNodeCoordinator);
                }
                nodeCoordinator.I3(layoutModifierNodeCoordinator);
                layoutModifierNodeCoordinator.H3(nodeCoordinator);
                nodeCoordinator = layoutModifierNodeCoordinator;
            } else {
                parent$ui_release.updateCoordinator$ui_release(nodeCoordinator);
            }
        }
        LayoutNode layoutNodeB0 = this.f27536a.B0();
        nodeCoordinator.I3(layoutNodeB0 != null ? layoutNodeB0.Z() : null);
        this.f27538c = nodeCoordinator;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void F(androidx.compose.ui.Modifier r18) {
        /*
            Method dump skipped, instruction units count: 364
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.NodeChain.F(androidx.compose.ui.Modifier):void");
    }

    public final Modifier.Node k() {
        return this.f27540e;
    }

    public final InnerNodeCoordinator l() {
        return this.f27537b;
    }

    public final LayoutNode m() {
        return this.f27536a;
    }

    public final List n() {
        MutableVector mutableVector = this.f27541f;
        if (mutableVector == null) {
            return CollectionsKt.emptyList();
        }
        int i3 = 0;
        MutableVector mutableVector2 = new MutableVector(new ModifierInfo[mutableVector.o()], 0);
        Modifier.Node nodeK = k();
        while (nodeK != null && nodeK != p()) {
            NodeCoordinator coordinator$ui_release = nodeK.getCoordinator$ui_release();
            if (coordinator$ui_release == null) {
                throw new IllegalArgumentException("getModifierInfo called on node with no coordinator");
            }
            OwnedLayer ownedLayerR2 = coordinator$ui_release.R2();
            OwnedLayer ownedLayerR22 = this.f27537b.R2();
            Modifier.Node child$ui_release = nodeK.getChild$ui_release();
            if (child$ui_release != this.f27539d || nodeK.getCoordinator$ui_release() == child$ui_release.getCoordinator$ui_release()) {
                ownedLayerR22 = null;
            }
            if (ownedLayerR2 == null) {
                ownedLayerR2 = ownedLayerR22;
            }
            mutableVector2.b(new ModifierInfo((Modifier) mutableVector.f24389a[i3], coordinator$ui_release, ownedLayerR2));
            nodeK = nodeK.getChild$ui_release();
            i3++;
        }
        return mutableVector2.h();
    }

    public final NodeCoordinator o() {
        return this.f27538c;
    }

    public final Modifier.Node p() {
        return this.f27539d;
    }

    public final boolean q(int i3) {
        return (i3 & i()) != 0;
    }

    public final boolean s() {
        return NodeChainKt.f27551a.getChild$ui_release() != null;
    }

    public final void t() {
        for (Modifier.Node nodeK = k(); nodeK != null; nodeK = nodeK.getChild$ui_release()) {
            nodeK.markAsAttached$ui_release();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (this.f27540e == this.f27539d) {
            sb.append("]");
        } else {
            Modifier.Node nodeK = k();
            while (true) {
                if (nodeK == null || nodeK == p()) {
                    break;
                }
                sb.append(String.valueOf(nodeK));
                if (nodeK.getChild$ui_release() == this.f27539d) {
                    sb.append("]");
                    break;
                }
                sb.append(",");
                nodeK = nodeK.getChild$ui_release();
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public final void u() {
        for (Modifier.Node nodeP = p(); nodeP != null; nodeP = nodeP.getParent$ui_release()) {
            if (nodeP.isAttached()) {
                nodeP.markAsDetached$ui_release();
            }
        }
    }

    public final void y() {
        for (Modifier.Node nodeP = p(); nodeP != null; nodeP = nodeP.getParent$ui_release()) {
            if (nodeP.isAttached()) {
                nodeP.reset$ui_release();
            }
        }
        A();
        u();
    }

    public final void z() {
        NodeCoordinator nodeCoordinatorX2 = this.f27538c;
        InnerNodeCoordinator innerNodeCoordinator = this.f27537b;
        while (nodeCoordinatorX2 != innerNodeCoordinator) {
            nodeCoordinatorX2.m3();
            nodeCoordinatorX2 = nodeCoordinatorX2.X2();
            Intrinsics.checkNotNull(nodeCoordinatorX2);
        }
        innerNodeCoordinator.m3();
        for (Modifier.Node nodeK = k(); nodeK != null; nodeK = nodeK.getChild$ui_release()) {
            nodeK.runAttachLifecycle$ui_release();
            if (nodeK.getInsertedNodeAwaitingAttachForInvalidation$ui_release()) {
                NodeKindKt.a(nodeK);
            }
            if (nodeK.getUpdatedNodeAwaitingAttachForInvalidation$ui_release()) {
                NodeKindKt.e(nodeK);
            }
            nodeK.setInsertedNodeAwaitingAttachForInvalidation$ui_release(false);
            nodeK.setUpdatedNodeAwaitingAttachForInvalidation$ui_release(false);
        }
    }
}
