package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Actual_jvmKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.TraversableNode;
import kotlin.Metadata;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class TraversableNodeKt {
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
    public static final TraversableNode a(DelegatableNode delegatableNode, Object obj) {
        NodeChain nodeChainU0;
        int iA = NodeKind.a(262144);
        if (!delegatableNode.getNode().isAttached()) {
            InlineClassHelperKt.c("visitAncestors called on an unattached node");
        }
        Modifier.Node parent$ui_release = delegatableNode.getNode().getParent$ui_release();
        LayoutNode layoutNodeO = DelegatableNodeKt.o(delegatableNode);
        while (layoutNodeO != null) {
            if ((layoutNodeO.u0().k().getAggregateChildKindSet$ui_release() & iA) != 0) {
                while (parent$ui_release != null) {
                    if ((parent$ui_release.getKindSet$ui_release() & iA) != 0) {
                        ?? H = parent$ui_release;
                        ?? mutableVector = 0;
                        while (H != 0) {
                            if (H instanceof TraversableNode) {
                                TraversableNode traversableNode = (TraversableNode) H;
                                if (Intrinsics.areEqual(obj, traversableNode.U())) {
                                    return traversableNode;
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
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v9 */
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
    /* JADX WARN: Type inference failed for: r6v7 */
    public static final TraversableNode b(TraversableNode traversableNode) {
        NodeChain nodeChainU0;
        int iA = NodeKind.a(262144);
        if (!traversableNode.getNode().isAttached()) {
            InlineClassHelperKt.c("visitAncestors called on an unattached node");
        }
        Modifier.Node parent$ui_release = traversableNode.getNode().getParent$ui_release();
        LayoutNode layoutNodeO = DelegatableNodeKt.o(traversableNode);
        while (layoutNodeO != null) {
            if ((layoutNodeO.u0().k().getAggregateChildKindSet$ui_release() & iA) != 0) {
                while (parent$ui_release != null) {
                    if ((parent$ui_release.getKindSet$ui_release() & iA) != 0) {
                        ?? H = parent$ui_release;
                        ?? mutableVector = 0;
                        while (H != 0) {
                            if (H instanceof TraversableNode) {
                                TraversableNode traversableNode2 = (TraversableNode) H;
                                if (Intrinsics.areEqual(traversableNode.U(), traversableNode2.U()) && Actual_jvmKt.a(traversableNode, traversableNode2)) {
                                    return traversableNode2;
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
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [androidx.compose.ui.Modifier$Node] */
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
    /* JADX WARN: Type inference failed for: r5v8 */
    public static final void c(DelegatableNode delegatableNode, Object obj, Function1 function1) {
        NodeChain nodeChainU0;
        int iA = NodeKind.a(262144);
        if (!delegatableNode.getNode().isAttached()) {
            InlineClassHelperKt.c("visitAncestors called on an unattached node");
        }
        Modifier.Node parent$ui_release = delegatableNode.getNode().getParent$ui_release();
        LayoutNode layoutNodeO = DelegatableNodeKt.o(delegatableNode);
        while (layoutNodeO != null) {
            if ((layoutNodeO.u0().k().getAggregateChildKindSet$ui_release() & iA) != 0) {
                while (parent$ui_release != null) {
                    if ((parent$ui_release.getKindSet$ui_release() & iA) != 0) {
                        ?? H = parent$ui_release;
                        ?? mutableVector = 0;
                        while (H != 0) {
                            if (H instanceof TraversableNode) {
                                TraversableNode traversableNode = (TraversableNode) H;
                                if (!(Intrinsics.areEqual(obj, traversableNode.U()) ? ((Boolean) function1.invoke(traversableNode)).booleanValue() : true)) {
                                    return;
                                }
                            } else {
                                if (((H.getKindSet$ui_release() & iA) != 0) && (H instanceof DelegatingNode)) {
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
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r3v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [androidx.compose.ui.Modifier$Node] */
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
    /* JADX WARN: Type inference failed for: r6v9 */
    public static final void d(TraversableNode traversableNode, Function1 function1) {
        NodeChain nodeChainU0;
        int iA = NodeKind.a(262144);
        if (!traversableNode.getNode().isAttached()) {
            InlineClassHelperKt.c("visitAncestors called on an unattached node");
        }
        Modifier.Node parent$ui_release = traversableNode.getNode().getParent$ui_release();
        LayoutNode layoutNodeO = DelegatableNodeKt.o(traversableNode);
        while (layoutNodeO != null) {
            if ((layoutNodeO.u0().k().getAggregateChildKindSet$ui_release() & iA) != 0) {
                while (parent$ui_release != null) {
                    if ((parent$ui_release.getKindSet$ui_release() & iA) != 0) {
                        ?? H = parent$ui_release;
                        ?? mutableVector = 0;
                        while (H != 0) {
                            boolean zBooleanValue = true;
                            if (H instanceof TraversableNode) {
                                TraversableNode traversableNode2 = (TraversableNode) H;
                                if (Intrinsics.areEqual(traversableNode.U(), traversableNode2.U()) && Actual_jvmKt.a(traversableNode, traversableNode2)) {
                                    zBooleanValue = ((Boolean) function1.invoke(traversableNode2)).booleanValue();
                                }
                                if (!zBooleanValue) {
                                    return;
                                }
                            } else {
                                if (((H.getKindSet$ui_release() & iA) != 0) && (H instanceof DelegatingNode)) {
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
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Type inference failed for: r9v8 */
    public static final void e(DelegatableNode delegatableNode, Object obj, Function1 function1) {
        int iA = NodeKind.a(262144);
        if (!delegatableNode.getNode().isAttached()) {
            InlineClassHelperKt.c("visitSubtreeIf called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui_release = delegatableNode.getNode().getChild$ui_release();
        if (child$ui_release == null) {
            DelegatableNodeKt.c(mutableVector, delegatableNode.getNode(), false);
        } else {
            mutableVector.b(child$ui_release);
        }
        while (mutableVector.o() != 0) {
            Modifier.Node node = (Modifier.Node) mutableVector.u(mutableVector.o() - 1);
            if ((node.getAggregateChildKindSet$ui_release() & iA) != 0) {
                for (Modifier.Node child$ui_release2 = node; child$ui_release2 != null; child$ui_release2 = child$ui_release2.getChild$ui_release()) {
                    if ((child$ui_release2.getKindSet$ui_release() & iA) != 0) {
                        ?? H = child$ui_release2;
                        ?? mutableVector2 = 0;
                        while (H != 0) {
                            if (H instanceof TraversableNode) {
                                TraversableNode traversableNode = (TraversableNode) H;
                                TraversableNode.Companion.TraverseDescendantsAction traverseDescendantsAction = Intrinsics.areEqual(obj, traversableNode.U()) ? (TraversableNode.Companion.TraverseDescendantsAction) function1.invoke(traversableNode) : TraversableNode.Companion.TraverseDescendantsAction.f27641a;
                                if (traverseDescendantsAction == TraversableNode.Companion.TraverseDescendantsAction.f27643c) {
                                    return;
                                }
                                if (traverseDescendantsAction == TraversableNode.Companion.TraverseDescendantsAction.f27642b) {
                                    break;
                                }
                            } else if ((H.getKindSet$ui_release() & iA) != 0 && (H instanceof DelegatingNode)) {
                                Modifier.Node nodeN2 = ((DelegatingNode) H).n2();
                                int i3 = 0;
                                H = H;
                                mutableVector2 = mutableVector2;
                                while (nodeN2 != null) {
                                    if ((nodeN2.getKindSet$ui_release() & iA) != 0) {
                                        i3++;
                                        mutableVector2 = mutableVector2;
                                        if (i3 == 1) {
                                            H = nodeN2;
                                        } else {
                                            if (mutableVector2 == 0) {
                                                mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (H != 0) {
                                                mutableVector2.b(H);
                                                H = 0;
                                            }
                                            mutableVector2.b(nodeN2);
                                        }
                                    }
                                    nodeN2 = nodeN2.getChild$ui_release();
                                    H = H;
                                    mutableVector2 = mutableVector2;
                                }
                                if (i3 == 1) {
                                }
                            }
                            H = DelegatableNodeKt.h(mutableVector2);
                        }
                    }
                }
            }
            DelegatableNodeKt.c(mutableVector, node, false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r14v0, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r8v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    public static final void f(TraversableNode traversableNode, Function1 function1) {
        int iA = NodeKind.a(262144);
        if (!traversableNode.getNode().isAttached()) {
            InlineClassHelperKt.c("visitSubtreeIf called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui_release = traversableNode.getNode().getChild$ui_release();
        if (child$ui_release == null) {
            DelegatableNodeKt.c(mutableVector, traversableNode.getNode(), false);
        } else {
            mutableVector.b(child$ui_release);
        }
        while (mutableVector.o() != 0) {
            Modifier.Node node = (Modifier.Node) mutableVector.u(mutableVector.o() - 1);
            if ((node.getAggregateChildKindSet$ui_release() & iA) != 0) {
                for (Modifier.Node child$ui_release2 = node; child$ui_release2 != null; child$ui_release2 = child$ui_release2.getChild$ui_release()) {
                    if ((child$ui_release2.getKindSet$ui_release() & iA) != 0) {
                        ?? H = child$ui_release2;
                        ?? mutableVector2 = 0;
                        while (H != 0) {
                            if (H instanceof TraversableNode) {
                                TraversableNode traversableNode2 = (TraversableNode) H;
                                TraversableNode.Companion.TraverseDescendantsAction traverseDescendantsAction = (Intrinsics.areEqual(traversableNode.U(), traversableNode2.U()) && Actual_jvmKt.a(traversableNode, traversableNode2)) ? (TraversableNode.Companion.TraverseDescendantsAction) function1.invoke(traversableNode2) : TraversableNode.Companion.TraverseDescendantsAction.f27641a;
                                if (traverseDescendantsAction == TraversableNode.Companion.TraverseDescendantsAction.f27643c) {
                                    return;
                                }
                                if (traverseDescendantsAction == TraversableNode.Companion.TraverseDescendantsAction.f27642b) {
                                    break;
                                }
                            } else if ((H.getKindSet$ui_release() & iA) != 0 && (H instanceof DelegatingNode)) {
                                Modifier.Node nodeN2 = ((DelegatingNode) H).n2();
                                int i3 = 0;
                                H = H;
                                mutableVector2 = mutableVector2;
                                while (nodeN2 != null) {
                                    if ((nodeN2.getKindSet$ui_release() & iA) != 0) {
                                        i3++;
                                        mutableVector2 = mutableVector2;
                                        if (i3 == 1) {
                                            H = nodeN2;
                                        } else {
                                            if (mutableVector2 == 0) {
                                                mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (H != 0) {
                                                mutableVector2.b(H);
                                                H = 0;
                                            }
                                            mutableVector2.b(nodeN2);
                                        }
                                    }
                                    nodeN2 = nodeN2.getChild$ui_release();
                                    H = H;
                                    mutableVector2 = mutableVector2;
                                }
                                if (i3 == 1) {
                                }
                            }
                            H = DelegatableNodeKt.h(mutableVector2);
                        }
                    }
                }
            }
            DelegatableNodeKt.c(mutableVector, node, false);
        }
    }
}
