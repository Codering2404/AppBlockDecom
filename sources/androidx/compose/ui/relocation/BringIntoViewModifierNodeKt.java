package androidx.compose.ui.relocation;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class BringIntoViewModifierNodeKt {
    public static final Object a(DelegatableNode delegatableNode, final Function0 function0, Continuation continuation) {
        Object obj;
        NodeChain nodeChainU0;
        if (!delegatableNode.getNode().isAttached()) {
            return Unit.f139807a;
        }
        int iA = NodeKind.a(524288);
        if (!delegatableNode.getNode().isAttached()) {
            InlineClassHelperKt.c("visitAncestors called on an unattached node");
        }
        Modifier.Node parent$ui_release = delegatableNode.getNode().getParent$ui_release();
        LayoutNode layoutNodeO = DelegatableNodeKt.o(delegatableNode);
        loop0: while (true) {
            obj = null;
            if (layoutNodeO == null) {
                break;
            }
            if ((layoutNodeO.u0().k().getAggregateChildKindSet$ui_release() & iA) != 0) {
                while (parent$ui_release != null) {
                    if ((parent$ui_release.getKindSet$ui_release() & iA) != 0) {
                        Modifier.Node nodeH = parent$ui_release;
                        MutableVector mutableVector = null;
                        while (nodeH != null) {
                            if (nodeH instanceof BringIntoViewModifierNode) {
                                obj = nodeH;
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
                                                Boxing.a(mutableVector.b(nodeH));
                                                nodeH = null;
                                            }
                                            Boxing.a(mutableVector.b(nodeN2));
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
        BringIntoViewModifierNode bringIntoViewModifierNode = (BringIntoViewModifierNode) obj;
        if (bringIntoViewModifierNode == null) {
            return Unit.f139807a;
        }
        final LayoutCoordinates layoutCoordinatesM = DelegatableNodeKt.m(delegatableNode);
        Object objE0 = bringIntoViewModifierNode.E0(layoutCoordinatesM, new Function0<Rect>() { // from class: androidx.compose.ui.relocation.BringIntoViewModifierNodeKt$bringIntoView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Rect invoke() {
                Rect rect;
                Function0 function02 = function0;
                if (function02 != null && (rect = (Rect) function02.invoke()) != null) {
                    return rect;
                }
                LayoutCoordinates layoutCoordinates = layoutCoordinatesM;
                if (!layoutCoordinates.m()) {
                    layoutCoordinates = null;
                }
                if (layoutCoordinates != null) {
                    return SizeKt.c(IntSizeKt.e(layoutCoordinates.a()));
                }
                return null;
            }
        }, continuation);
        return objE0 == IntrinsicsKt.f() ? objE0 : Unit.f139807a;
    }

    public static /* synthetic */ Object b(DelegatableNode delegatableNode, Function0 function0, Continuation continuation, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            function0 = null;
        }
        return a(delegatableNode, function0, continuation);
    }
}
