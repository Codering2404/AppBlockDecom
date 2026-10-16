package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.BeyondBoundsLayout;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

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
public final class OneDimensionalFocusSearchKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f25573a;

        static {
            int[] iArr = new int[FocusStateImpl.values().length];
            try {
                iArr[FocusStateImpl.f25538b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FocusStateImpl.f25537a.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FocusStateImpl.f25539c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FocusStateImpl.f25540d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f25573a = iArr;
        }
    }

    private static final boolean b(FocusTargetNode focusTargetNode, Function1 function1) {
        FocusStateImpl focusStateImplA0 = focusTargetNode.a0();
        int[] iArr = WhenMappings.f25573a;
        int i3 = iArr[focusStateImplA0.ordinal()];
        if (i3 != 1) {
            if (i3 == 2 || i3 == 3) {
                return g(focusTargetNode, function1);
            }
            if (i3 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            if (!g(focusTargetNode, function1)) {
                if (!(focusTargetNode.t2().v() ? ((Boolean) function1.invoke(focusTargetNode)).booleanValue() : false)) {
                    return false;
                }
            }
            return true;
        }
        FocusTargetNode focusTargetNodeF = FocusTraversalKt.f(focusTargetNode);
        if (focusTargetNodeF == null) {
            throw new IllegalStateException("ActiveParent must have a focusedChild");
        }
        int i4 = iArr[focusTargetNodeF.a0().ordinal()];
        if (i4 == 1) {
            return b(focusTargetNodeF, function1) || d(focusTargetNode, focusTargetNodeF, FocusDirection.f25444b.f(), function1) || (focusTargetNodeF.t2().v() && ((Boolean) function1.invoke(focusTargetNodeF)).booleanValue());
        }
        if (i4 == 2 || i4 == 3) {
            return d(focusTargetNode, focusTargetNodeF, FocusDirection.f25444b.f(), function1);
        }
        if (i4 != 4) {
            throw new NoWhenBranchMatchedException();
        }
        throw new IllegalStateException("ActiveParent must have a focusedChild");
    }

    private static final boolean c(FocusTargetNode focusTargetNode, Function1 function1) {
        int i3 = WhenMappings.f25573a[focusTargetNode.a0().ordinal()];
        if (i3 == 1) {
            FocusTargetNode focusTargetNodeF = FocusTraversalKt.f(focusTargetNode);
            if (focusTargetNodeF != null) {
                return c(focusTargetNodeF, function1) || d(focusTargetNode, focusTargetNodeF, FocusDirection.f25444b.e(), function1);
            }
            throw new IllegalStateException("ActiveParent must have a focusedChild");
        }
        if (i3 == 2 || i3 == 3) {
            return h(focusTargetNode, function1);
        }
        if (i3 == 4) {
            return focusTargetNode.t2().v() ? ((Boolean) function1.invoke(focusTargetNode)).booleanValue() : h(focusTargetNode, function1);
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final boolean d(final FocusTargetNode focusTargetNode, final FocusTargetNode focusTargetNode2, final int i3, final Function1 function1) {
        if (i(focusTargetNode, focusTargetNode2, i3, function1)) {
            return true;
        }
        final FocusTransactionManager focusTransactionManagerC = FocusTargetNodeKt.c(focusTargetNode);
        final int iH = focusTransactionManagerC.h();
        final FocusTargetNode focusTargetNodeH = DelegatableNodeKt.p(focusTargetNode).getFocusOwner().h();
        Boolean bool = (Boolean) BeyondBoundsLayoutKt.a(focusTargetNode, i3, new Function1<BeyondBoundsLayout.BeyondBoundsScope, Boolean>() { // from class: androidx.compose.ui.focus.OneDimensionalFocusSearchKt$generateAndSearchChildren$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(BeyondBoundsLayout.BeyondBoundsScope beyondBoundsScope) {
                if (iH != focusTransactionManagerC.h() || (ComposeUiFlags.f25107g && focusTargetNodeH != DelegatableNodeKt.p(focusTargetNode).getFocusOwner().h())) {
                    return Boolean.TRUE;
                }
                boolean zI = OneDimensionalFocusSearchKt.i(focusTargetNode, focusTargetNode2, i3, function1);
                Boolean boolValueOf = Boolean.valueOf(zI);
                if (zI || !beyondBoundsScope.a()) {
                    return boolValueOf;
                }
                return null;
            }
        });
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private static final boolean e(FocusTargetNode focusTargetNode) {
        Modifier.Node node;
        NodeChain nodeChainU0;
        int iA = NodeKind.a(1024);
        if (!focusTargetNode.getNode().isAttached()) {
            InlineClassHelperKt.c("visitAncestors called on an unattached node");
        }
        Modifier.Node parent$ui_release = focusTargetNode.getNode().getParent$ui_release();
        LayoutNode layoutNodeO = DelegatableNodeKt.o(focusTargetNode);
        loop0: while (true) {
            node = null;
            if (layoutNodeO == null) {
                break;
            }
            if ((layoutNodeO.u0().k().getAggregateChildKindSet$ui_release() & iA) != 0) {
                while (parent$ui_release != null) {
                    if ((parent$ui_release.getKindSet$ui_release() & iA) != 0) {
                        Modifier.Node nodeH = parent$ui_release;
                        MutableVector mutableVector = null;
                        while (nodeH != null) {
                            if (nodeH instanceof FocusTargetNode) {
                                node = nodeH;
                                break loop0;
                            }
                            if ((nodeH.getKindSet$ui_release() & iA) != 0 && (nodeH instanceof DelegatingNode)) {
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
                    parent$ui_release = parent$ui_release.getParent$ui_release();
                }
            }
            layoutNodeO = layoutNodeO.B0();
            parent$ui_release = (layoutNodeO == null || (nodeChainU0 = layoutNodeO.u0()) == null) ? null : nodeChainU0.p();
        }
        return node == null;
    }

    public static final boolean f(FocusTargetNode focusTargetNode, int i3, Function1 function1) {
        FocusDirection.Companion companion = FocusDirection.f25444b;
        if (FocusDirection.l(i3, companion.e())) {
            return c(focusTargetNode, function1);
        }
        if (FocusDirection.l(i3, companion.f())) {
            return b(focusTargetNode, function1);
        }
        throw new IllegalStateException("This function should only be used for 1-D focus search");
    }

    private static final boolean g(FocusTargetNode focusTargetNode, Function1 function1) {
        MutableVector mutableVector = new MutableVector(new FocusTargetNode[16], 0);
        int iA = NodeKind.a(1024);
        if (!focusTargetNode.getNode().isAttached()) {
            InlineClassHelperKt.c("visitChildren called on an unattached node");
        }
        MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui_release = focusTargetNode.getNode().getChild$ui_release();
        if (child$ui_release == null) {
            DelegatableNodeKt.c(mutableVector2, focusTargetNode.getNode(), false);
        } else {
            mutableVector2.b(child$ui_release);
        }
        while (mutableVector2.o() != 0) {
            Modifier.Node nodeH = (Modifier.Node) mutableVector2.u(mutableVector2.o() - 1);
            if ((nodeH.getAggregateChildKindSet$ui_release() & iA) == 0) {
                DelegatableNodeKt.c(mutableVector2, nodeH, false);
            } else {
                while (true) {
                    if (nodeH == null) {
                        break;
                    }
                    if ((nodeH.getKindSet$ui_release() & iA) != 0) {
                        MutableVector mutableVector3 = null;
                        while (nodeH != null) {
                            if (nodeH instanceof FocusTargetNode) {
                                mutableVector.b((FocusTargetNode) nodeH);
                            } else if ((nodeH.getKindSet$ui_release() & iA) != 0 && (nodeH instanceof DelegatingNode)) {
                                int i3 = 0;
                                for (Modifier.Node nodeN2 = ((DelegatingNode) nodeH).n2(); nodeN2 != null; nodeN2 = nodeN2.getChild$ui_release()) {
                                    if ((nodeN2.getKindSet$ui_release() & iA) != 0) {
                                        i3++;
                                        if (i3 == 1) {
                                            nodeH = nodeN2;
                                        } else {
                                            if (mutableVector3 == null) {
                                                mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (nodeH != null) {
                                                mutableVector3.b(nodeH);
                                                nodeH = null;
                                            }
                                            mutableVector3.b(nodeN2);
                                        }
                                    }
                                }
                                if (i3 == 1) {
                                }
                            }
                            nodeH = DelegatableNodeKt.h(mutableVector3);
                        }
                    } else {
                        nodeH = nodeH.getChild$ui_release();
                    }
                }
            }
        }
        mutableVector.A(FocusableChildrenComparator.f25571a);
        int iO = mutableVector.o() - 1;
        Object[] objArr = mutableVector.f24389a;
        if (iO < objArr.length) {
            while (iO >= 0) {
                FocusTargetNode focusTargetNode2 = (FocusTargetNode) objArr[iO];
                if (FocusTraversalKt.g(focusTargetNode2) && b(focusTargetNode2, function1)) {
                    return true;
                }
                iO--;
            }
        }
        return false;
    }

    private static final boolean h(FocusTargetNode focusTargetNode, Function1 function1) {
        MutableVector mutableVector = new MutableVector(new FocusTargetNode[16], 0);
        int iA = NodeKind.a(1024);
        if (!focusTargetNode.getNode().isAttached()) {
            InlineClassHelperKt.c("visitChildren called on an unattached node");
        }
        MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui_release = focusTargetNode.getNode().getChild$ui_release();
        if (child$ui_release == null) {
            DelegatableNodeKt.c(mutableVector2, focusTargetNode.getNode(), false);
        } else {
            mutableVector2.b(child$ui_release);
        }
        while (mutableVector2.o() != 0) {
            Modifier.Node nodeH = (Modifier.Node) mutableVector2.u(mutableVector2.o() - 1);
            if ((nodeH.getAggregateChildKindSet$ui_release() & iA) == 0) {
                DelegatableNodeKt.c(mutableVector2, nodeH, false);
            } else {
                while (true) {
                    if (nodeH == null) {
                        break;
                    }
                    if ((nodeH.getKindSet$ui_release() & iA) != 0) {
                        MutableVector mutableVector3 = null;
                        while (nodeH != null) {
                            if (nodeH instanceof FocusTargetNode) {
                                mutableVector.b((FocusTargetNode) nodeH);
                            } else if ((nodeH.getKindSet$ui_release() & iA) != 0 && (nodeH instanceof DelegatingNode)) {
                                int i3 = 0;
                                for (Modifier.Node nodeN2 = ((DelegatingNode) nodeH).n2(); nodeN2 != null; nodeN2 = nodeN2.getChild$ui_release()) {
                                    if ((nodeN2.getKindSet$ui_release() & iA) != 0) {
                                        i3++;
                                        if (i3 == 1) {
                                            nodeH = nodeN2;
                                        } else {
                                            if (mutableVector3 == null) {
                                                mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (nodeH != null) {
                                                mutableVector3.b(nodeH);
                                                nodeH = null;
                                            }
                                            mutableVector3.b(nodeN2);
                                        }
                                    }
                                }
                                if (i3 == 1) {
                                }
                            }
                            nodeH = DelegatableNodeKt.h(mutableVector3);
                        }
                    } else {
                        nodeH = nodeH.getChild$ui_release();
                    }
                }
            }
        }
        mutableVector.A(FocusableChildrenComparator.f25571a);
        Object[] objArr = mutableVector.f24389a;
        int iO = mutableVector.o();
        for (int i4 = 0; i4 < iO; i4++) {
            FocusTargetNode focusTargetNode2 = (FocusTargetNode) objArr[i4];
            if (FocusTraversalKt.g(focusTargetNode2) && c(focusTargetNode2, function1)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean i(FocusTargetNode focusTargetNode, FocusTargetNode focusTargetNode2, int i3, Function1 function1) {
        if (focusTargetNode.a0() != FocusStateImpl.f25538b) {
            throw new IllegalStateException("This function should only be used within a parent that has focus.");
        }
        MutableVector mutableVector = new MutableVector(new FocusTargetNode[16], 0);
        int iA = NodeKind.a(1024);
        if (!focusTargetNode.getNode().isAttached()) {
            InlineClassHelperKt.c("visitChildren called on an unattached node");
        }
        MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui_release = focusTargetNode.getNode().getChild$ui_release();
        if (child$ui_release == null) {
            DelegatableNodeKt.c(mutableVector2, focusTargetNode.getNode(), false);
        } else {
            mutableVector2.b(child$ui_release);
        }
        while (mutableVector2.o() != 0) {
            Modifier.Node nodeH = (Modifier.Node) mutableVector2.u(mutableVector2.o() - 1);
            if ((nodeH.getAggregateChildKindSet$ui_release() & iA) == 0) {
                DelegatableNodeKt.c(mutableVector2, nodeH, false);
            } else {
                while (true) {
                    if (nodeH == null) {
                        break;
                    }
                    if ((nodeH.getKindSet$ui_release() & iA) != 0) {
                        MutableVector mutableVector3 = null;
                        while (nodeH != null) {
                            if (nodeH instanceof FocusTargetNode) {
                                mutableVector.b((FocusTargetNode) nodeH);
                            } else if ((nodeH.getKindSet$ui_release() & iA) != 0 && (nodeH instanceof DelegatingNode)) {
                                int i4 = 0;
                                for (Modifier.Node nodeN2 = ((DelegatingNode) nodeH).n2(); nodeN2 != null; nodeN2 = nodeN2.getChild$ui_release()) {
                                    if ((nodeN2.getKindSet$ui_release() & iA) != 0) {
                                        i4++;
                                        if (i4 == 1) {
                                            nodeH = nodeN2;
                                        } else {
                                            if (mutableVector3 == null) {
                                                mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (nodeH != null) {
                                                mutableVector3.b(nodeH);
                                                nodeH = null;
                                            }
                                            mutableVector3.b(nodeN2);
                                        }
                                    }
                                }
                                if (i4 == 1) {
                                }
                            }
                            nodeH = DelegatableNodeKt.h(mutableVector3);
                        }
                    } else {
                        nodeH = nodeH.getChild$ui_release();
                    }
                }
            }
        }
        mutableVector.A(FocusableChildrenComparator.f25571a);
        FocusDirection.Companion companion = FocusDirection.f25444b;
        if (FocusDirection.l(i3, companion.e())) {
            IntRange intRangeB = RangesKt.B(0, mutableVector.o());
            int iG = intRangeB.g();
            int iH = intRangeB.h();
            if (iG <= iH) {
                boolean z2 = false;
                while (true) {
                    if (z2) {
                        FocusTargetNode focusTargetNode3 = (FocusTargetNode) mutableVector.f24389a[iG];
                        if (FocusTraversalKt.g(focusTargetNode3) && c(focusTargetNode3, function1)) {
                            return true;
                        }
                    }
                    if (Intrinsics.areEqual(mutableVector.f24389a[iG], focusTargetNode2)) {
                        z2 = true;
                    }
                    if (iG == iH) {
                        break;
                    }
                    iG++;
                }
            }
        } else {
            if (!FocusDirection.l(i3, companion.f())) {
                throw new IllegalStateException("This function should only be used for 1-D focus search");
            }
            IntRange intRangeB2 = RangesKt.B(0, mutableVector.o());
            int iG2 = intRangeB2.g();
            int iH2 = intRangeB2.h();
            if (iG2 <= iH2) {
                boolean z3 = false;
                while (true) {
                    if (z3) {
                        FocusTargetNode focusTargetNode4 = (FocusTargetNode) mutableVector.f24389a[iH2];
                        if (FocusTraversalKt.g(focusTargetNode4) && b(focusTargetNode4, function1)) {
                            return true;
                        }
                    }
                    if (Intrinsics.areEqual(mutableVector.f24389a[iH2], focusTargetNode2)) {
                        z3 = true;
                    }
                    if (iH2 == iG2) {
                        break;
                    }
                    iH2--;
                }
            }
        }
        if (FocusDirection.l(i3, FocusDirection.f25444b.e()) || !focusTargetNode.t2().v() || e(focusTargetNode)) {
            return false;
        }
        return ((Boolean) function1.invoke(focusTargetNode)).booleanValue();
    }
}
