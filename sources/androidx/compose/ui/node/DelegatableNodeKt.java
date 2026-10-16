package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.semantics.SemanticsInfo;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.KotlinNothingValueException;
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
public final class DelegatableNodeKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(MutableVector mutableVector, Modifier.Node node, boolean z2) {
        MutableVector mutableVectorE = e(o(node), z2);
        int iO = mutableVectorE.o() - 1;
        Object[] objArr = mutableVectorE.f24389a;
        if (iO < objArr.length) {
            while (iO >= 0) {
                mutableVector.b(((LayoutNode) objArr[iO]).u0().k());
                iO--;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final LayoutModifierNode d(Modifier.Node node) {
        if ((NodeKind.a(2) & node.getKindSet$ui_release()) != 0) {
            if (node instanceof LayoutModifierNode) {
                return (LayoutModifierNode) node;
            }
            if (node instanceof DelegatingNode) {
                Modifier.Node nodeN2 = ((DelegatingNode) node).n2();
                while (nodeN2 != 0) {
                    if (nodeN2 instanceof LayoutModifierNode) {
                        return (LayoutModifierNode) nodeN2;
                    }
                    nodeN2 = (!(nodeN2 instanceof DelegatingNode) || (NodeKind.a(2) & nodeN2.getKindSet$ui_release()) == 0) ? nodeN2.getChild$ui_release() : ((DelegatingNode) nodeN2).n2();
                }
            }
        }
        return null;
    }

    private static final MutableVector e(LayoutNode layoutNode, boolean z2) {
        return z2 ? layoutNode.G0() : layoutNode.H0();
    }

    public static final boolean f(DelegatableNode delegatableNode, int i3) {
        return (delegatableNode.getNode().getAggregateChildKindSet$ui_release() & i3) != 0;
    }

    public static final boolean g(DelegatableNode delegatableNode) {
        return delegatableNode.getNode() == delegatableNode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier.Node h(MutableVector mutableVector) {
        if (mutableVector == null || mutableVector.o() == 0) {
            return null;
        }
        return (Modifier.Node) mutableVector.u(mutableVector.o() - 1);
    }

    public static final void i(DelegatableNode delegatableNode) {
        o(delegatableNode).y1();
    }

    public static final NodeCoordinator j(DelegatableNode delegatableNode, int i3) {
        NodeCoordinator coordinator$ui_release = delegatableNode.getNode().getCoordinator$ui_release();
        Intrinsics.checkNotNull(coordinator$ui_release);
        if (coordinator$ui_release.W2() != delegatableNode || !NodeKindKt.i(i3)) {
            return coordinator$ui_release;
        }
        NodeCoordinator nodeCoordinatorX2 = coordinator$ui_release.X2();
        Intrinsics.checkNotNull(nodeCoordinatorX2);
        return nodeCoordinatorX2;
    }

    public static final Density k(DelegatableNode delegatableNode) {
        return o(delegatableNode).U();
    }

    public static final GraphicsContext l(DelegatableNode delegatableNode) {
        return p(delegatableNode).getGraphicsContext();
    }

    public static final LayoutCoordinates m(DelegatableNode delegatableNode) {
        if (!delegatableNode.getNode().isAttached()) {
            InlineClassHelperKt.c("Cannot get LayoutCoordinates, Modifier.Node is not attached.");
        }
        LayoutCoordinates layoutCoordinatesU1 = j(delegatableNode, NodeKind.a(2)).u1();
        if (!layoutCoordinatesU1.m()) {
            InlineClassHelperKt.c("LayoutCoordinates is not attached.");
        }
        return layoutCoordinatesU1;
    }

    public static final LayoutDirection n(DelegatableNode delegatableNode) {
        return o(delegatableNode).getLayoutDirection();
    }

    public static final LayoutNode o(DelegatableNode delegatableNode) {
        NodeCoordinator coordinator$ui_release = delegatableNode.getNode().getCoordinator$ui_release();
        if (coordinator$ui_release != null) {
            return coordinator$ui_release.X1();
        }
        InlineClassHelperKt.d("Cannot obtain node coordinator. Is the Modifier.Node attached?");
        throw new KotlinNothingValueException();
    }

    public static final Owner p(DelegatableNode delegatableNode) {
        Owner ownerA0 = o(delegatableNode).A0();
        if (ownerA0 != null) {
            return ownerA0;
        }
        InlineClassHelperKt.d("This node does not have an owner.");
        throw new KotlinNothingValueException();
    }

    public static final SemanticsInfo q(DelegatableNode delegatableNode) {
        return o(delegatableNode);
    }
}
