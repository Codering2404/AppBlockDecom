package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import kotlin.Metadata;
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
public abstract class DelegatingNode extends Modifier.Node {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f27309a = NodeKindKt.g(this);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Modifier.Node f27310b;

    private final void q2(int i3, boolean z2) {
        Modifier.Node child$ui_release;
        int kindSet$ui_release = getKindSet$ui_release();
        setKindSet$ui_release(i3);
        if (kindSet$ui_release != i3) {
            if (DelegatableNodeKt.g(this)) {
                setAggregateChildKindSet$ui_release(i3);
            }
            if (isAttached()) {
                Modifier.Node node = getNode();
                Modifier.Node parent$ui_release = this;
                while (parent$ui_release != null) {
                    i3 |= parent$ui_release.getKindSet$ui_release();
                    parent$ui_release.setKindSet$ui_release(i3);
                    if (parent$ui_release == node) {
                        break;
                    } else {
                        parent$ui_release = parent$ui_release.getParent$ui_release();
                    }
                }
                if (z2 && parent$ui_release == node) {
                    i3 = NodeKindKt.h(node);
                    node.setKindSet$ui_release(i3);
                }
                int aggregateChildKindSet$ui_release = i3 | ((parent$ui_release == null || (child$ui_release = parent$ui_release.getChild$ui_release()) == null) ? 0 : child$ui_release.getAggregateChildKindSet$ui_release());
                while (parent$ui_release != null) {
                    aggregateChildKindSet$ui_release |= parent$ui_release.getKindSet$ui_release();
                    parent$ui_release.setAggregateChildKindSet$ui_release(aggregateChildKindSet$ui_release);
                    parent$ui_release = parent$ui_release.getParent$ui_release();
                }
            }
        }
    }

    private final void r2(int i3, Modifier.Node node) {
        int kindSet$ui_release = getKindSet$ui_release();
        if ((i3 & NodeKind.a(2)) == 0 || (NodeKind.a(2) & kindSet$ui_release) == 0 || (this instanceof LayoutModifierNode)) {
            return;
        }
        InlineClassHelperKt.c("Delegating to multiple LayoutModifierNodes without the delegating node implementing LayoutModifierNode itself is not allowed.\nDelegating Node: " + this + "\nDelegate Node: " + node);
    }

    protected final DelegatableNode m2(DelegatableNode delegatableNode) {
        Modifier.Node node = delegatableNode.getNode();
        if (node != delegatableNode) {
            Modifier.Node node2 = delegatableNode instanceof Modifier.Node ? (Modifier.Node) delegatableNode : null;
            Modifier.Node parent$ui_release = node2 != null ? node2.getParent$ui_release() : null;
            if (node == getNode() && Intrinsics.areEqual(parent$ui_release, this)) {
                return delegatableNode;
            }
            throw new IllegalStateException("Cannot delegate to an already delegated node");
        }
        if (node.isAttached()) {
            InlineClassHelperKt.c("Cannot delegate to an already attached node");
        }
        node.setAsDelegateTo$ui_release(getNode());
        int kindSet$ui_release = getKindSet$ui_release();
        int iH = NodeKindKt.h(node);
        node.setKindSet$ui_release(iH);
        r2(iH, node);
        node.setChild$ui_release(this.f27310b);
        this.f27310b = node;
        node.setParent$ui_release(this);
        q2(getKindSet$ui_release() | iH, false);
        if (isAttached()) {
            if ((iH & NodeKind.a(2)) == 0 || (kindSet$ui_release & NodeKind.a(2)) != 0) {
                updateCoordinator$ui_release(getCoordinator$ui_release());
            } else {
                NodeChain nodeChainU0 = DelegatableNodeKt.o(this).u0();
                getNode().updateCoordinator$ui_release(null);
                nodeChainU0.D();
            }
            node.markAsAttached$ui_release();
            node.runAttachLifecycle$ui_release();
            NodeKindKt.a(node);
        }
        return delegatableNode;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void markAsAttached$ui_release() {
        super.markAsAttached$ui_release();
        for (Modifier.Node nodeN2 = n2(); nodeN2 != null; nodeN2 = nodeN2.getChild$ui_release()) {
            nodeN2.updateCoordinator$ui_release(getCoordinator$ui_release());
            if (!nodeN2.isAttached()) {
                nodeN2.markAsAttached$ui_release();
            }
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void markAsDetached$ui_release() {
        for (Modifier.Node nodeN2 = n2(); nodeN2 != null; nodeN2 = nodeN2.getChild$ui_release()) {
            nodeN2.markAsDetached$ui_release();
        }
        super.markAsDetached$ui_release();
    }

    public final Modifier.Node n2() {
        return this.f27310b;
    }

    public final int o2() {
        return this.f27309a;
    }

    protected final void p2(DelegatableNode delegatableNode) {
        Modifier.Node node = null;
        for (Modifier.Node child$ui_release = this.f27310b; child$ui_release != null; child$ui_release = child$ui_release.getChild$ui_release()) {
            if (child$ui_release == delegatableNode) {
                if (child$ui_release.isAttached()) {
                    NodeKindKt.d(child$ui_release);
                    child$ui_release.runDetachLifecycle$ui_release();
                    child$ui_release.markAsDetached$ui_release();
                }
                child$ui_release.setAsDelegateTo$ui_release(child$ui_release);
                child$ui_release.setAggregateChildKindSet$ui_release(0);
                if (node == null) {
                    this.f27310b = child$ui_release.getChild$ui_release();
                } else {
                    node.setChild$ui_release(child$ui_release.getChild$ui_release());
                }
                child$ui_release.setChild$ui_release(null);
                child$ui_release.setParent$ui_release(null);
                int kindSet$ui_release = getKindSet$ui_release();
                int iH = NodeKindKt.h(this);
                q2(iH, true);
                if (isAttached() && (kindSet$ui_release & NodeKind.a(2)) != 0 && (NodeKind.a(2) & iH) == 0) {
                    NodeChain nodeChainU0 = DelegatableNodeKt.o(this).u0();
                    getNode().updateCoordinator$ui_release(null);
                    nodeChainU0.D();
                    return;
                }
                return;
            }
            node = child$ui_release;
        }
        throw new IllegalStateException(("Could not find delegate: " + delegatableNode).toString());
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void reset$ui_release() {
        super.reset$ui_release();
        for (Modifier.Node nodeN2 = n2(); nodeN2 != null; nodeN2 = nodeN2.getChild$ui_release()) {
            nodeN2.reset$ui_release();
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void runAttachLifecycle$ui_release() {
        for (Modifier.Node nodeN2 = n2(); nodeN2 != null; nodeN2 = nodeN2.getChild$ui_release()) {
            nodeN2.runAttachLifecycle$ui_release();
        }
        super.runAttachLifecycle$ui_release();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void runDetachLifecycle$ui_release() {
        super.runDetachLifecycle$ui_release();
        for (Modifier.Node nodeN2 = n2(); nodeN2 != null; nodeN2 = nodeN2.getChild$ui_release()) {
            nodeN2.runDetachLifecycle$ui_release();
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void setAsDelegateTo$ui_release(Modifier.Node node) {
        super.setAsDelegateTo$ui_release(node);
        for (Modifier.Node nodeN2 = n2(); nodeN2 != null; nodeN2 = nodeN2.getChild$ui_release()) {
            nodeN2.setAsDelegateTo$ui_release(node);
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void updateCoordinator$ui_release(NodeCoordinator nodeCoordinator) {
        super.updateCoordinator$ui_release(nodeCoordinator);
        for (Modifier.Node nodeN2 = n2(); nodeN2 != null; nodeN2 = nodeN2.getChild$ui_release()) {
            nodeN2.updateCoordinator$ui_release(nodeCoordinator);
        }
    }
}
