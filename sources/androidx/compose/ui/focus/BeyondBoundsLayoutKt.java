package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
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
public final class BeyondBoundsLayoutKt {
    public static final Object a(FocusTargetNode focusTargetNode, int i3, Function1 function1) {
        Modifier.Node nodeH;
        BeyondBoundsLayout beyondBoundsLayoutU2;
        int iC;
        NodeChain nodeChainU0;
        int iA = NodeKind.a(1024);
        if (!focusTargetNode.getNode().isAttached()) {
            InlineClassHelperKt.c("visitAncestors called on an unattached node");
        }
        Modifier.Node parent$ui_release = focusTargetNode.getNode().getParent$ui_release();
        LayoutNode layoutNodeO = DelegatableNodeKt.o(focusTargetNode);
        loop0: while (true) {
            if (layoutNodeO == null) {
                nodeH = null;
                break;
            }
            if ((layoutNodeO.u0().k().getAggregateChildKindSet$ui_release() & iA) != 0) {
                while (parent$ui_release != null) {
                    if ((parent$ui_release.getKindSet$ui_release() & iA) != 0) {
                        nodeH = parent$ui_release;
                        MutableVector mutableVector = null;
                        while (nodeH != null) {
                            if (nodeH instanceof FocusTargetNode) {
                                break loop0;
                            }
                            if ((nodeH.getKindSet$ui_release() & iA) != 0 && (nodeH instanceof DelegatingNode)) {
                                int i4 = 0;
                                for (Modifier.Node nodeN2 = ((DelegatingNode) nodeH).n2(); nodeN2 != null; nodeN2 = nodeN2.getChild$ui_release()) {
                                    if ((nodeN2.getKindSet$ui_release() & iA) != 0) {
                                        i4++;
                                        if (i4 == 1) {
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
                                if (i4 == 1) {
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
        FocusTargetNode focusTargetNode2 = (FocusTargetNode) nodeH;
        if ((focusTargetNode2 != null && Intrinsics.areEqual(focusTargetNode2.u2(), focusTargetNode.u2())) || (beyondBoundsLayoutU2 = focusTargetNode.u2()) == null) {
            return null;
        }
        FocusDirection.Companion companion = FocusDirection.f25444b;
        if (FocusDirection.l(i3, companion.h())) {
            iC = BeyondBoundsLayout.LayoutDirection.f27041b.a();
        } else if (FocusDirection.l(i3, companion.a())) {
            iC = BeyondBoundsLayout.LayoutDirection.f27041b.d();
        } else if (FocusDirection.l(i3, companion.d())) {
            iC = BeyondBoundsLayout.LayoutDirection.f27041b.e();
        } else if (FocusDirection.l(i3, companion.g())) {
            iC = BeyondBoundsLayout.LayoutDirection.f27041b.f();
        } else if (FocusDirection.l(i3, companion.e())) {
            iC = BeyondBoundsLayout.LayoutDirection.f27041b.b();
        } else {
            if (!FocusDirection.l(i3, companion.f())) {
                throw new IllegalStateException("Unsupported direction for beyond bounds layout");
            }
            iC = BeyondBoundsLayout.LayoutDirection.f27041b.c();
        }
        return beyondBoundsLayoutU2.i0(iC, function1);
    }
}
