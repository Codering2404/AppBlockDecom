package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
public final class FocusTraversalKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f25564a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f25565b;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            try {
                iArr[LayoutDirection.f30001a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LayoutDirection.f30002b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f25564a = iArr;
            int[] iArr2 = new int[FocusStateImpl.values().length];
            try {
                iArr2[FocusStateImpl.f25537a.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[FocusStateImpl.f25538b.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[FocusStateImpl.f25539c.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[FocusStateImpl.f25540d.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            f25565b = iArr2;
        }
    }

    public static final FocusRequester a(FocusTargetNode focusTargetNode, int i3, LayoutDirection layoutDirection) {
        FocusRequester focusRequesterR;
        FocusRequester focusRequester;
        FocusRequester focusRequesterA;
        FocusProperties focusPropertiesT2 = focusTargetNode.t2();
        FocusDirection.Companion companion = FocusDirection.f25444b;
        if (FocusDirection.l(i3, companion.e())) {
            return focusPropertiesT2.b();
        }
        if (FocusDirection.l(i3, companion.f())) {
            return focusPropertiesT2.w();
        }
        if (FocusDirection.l(i3, companion.h())) {
            return focusPropertiesT2.q();
        }
        if (FocusDirection.l(i3, companion.a())) {
            return focusPropertiesT2.s();
        }
        if (FocusDirection.l(i3, companion.d())) {
            int i4 = WhenMappings.f25564a[layoutDirection.ordinal()];
            if (i4 == 1) {
                focusRequesterA = focusPropertiesT2.a();
            } else {
                if (i4 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                focusRequesterA = focusPropertiesT2.r();
            }
            focusRequester = focusRequesterA != FocusRequester.f25519b.b() ? focusRequesterA : null;
            return focusRequester == null ? focusPropertiesT2.m() : focusRequester;
        }
        if (FocusDirection.l(i3, companion.g())) {
            int i5 = WhenMappings.f25564a[layoutDirection.ordinal()];
            if (i5 == 1) {
                focusRequesterR = focusPropertiesT2.r();
            } else {
                if (i5 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                focusRequesterR = focusPropertiesT2.a();
            }
            focusRequester = focusRequesterR != FocusRequester.f25519b.b() ? focusRequesterR : null;
            return focusRequester == null ? focusPropertiesT2.p() : focusRequester;
        }
        if (!(FocusDirection.l(i3, companion.b()) ? true : FocusDirection.l(i3, companion.c()))) {
            throw new IllegalStateException("invalid FocusDirection");
        }
        CancelIndicatingFocusBoundaryScope cancelIndicatingFocusBoundaryScope = new CancelIndicatingFocusBoundaryScope(i3, null);
        FocusTransactionManager focusTransactionManagerA = FocusTargetNodeKt.a(focusTargetNode);
        int iH = focusTransactionManagerA != null ? focusTransactionManagerA.h() : 0;
        FocusOwner focusOwner = DelegatableNodeKt.p(focusTargetNode).getFocusOwner();
        FocusTargetNode focusTargetNodeH = focusOwner.h();
        if (FocusDirection.l(i3, companion.b())) {
            focusPropertiesT2.x().invoke(cancelIndicatingFocusBoundaryScope);
        } else {
            focusPropertiesT2.y().invoke(cancelIndicatingFocusBoundaryScope);
        }
        return cancelIndicatingFocusBoundaryScope.c() ? FocusRequester.f25519b.a() : (iH != (focusTransactionManagerA != null ? focusTransactionManagerA.h() : 0) || (ComposeUiFlags.f25107g && focusTargetNodeH != focusOwner.h())) ? FocusRequester.f25519b.c() : FocusRequester.f25519b.b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x006e, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final androidx.compose.ui.focus.FocusTargetNode b(androidx.compose.ui.focus.FocusTargetNode r10) {
        /*
            Method dump skipped, instruction units count: 235
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusTraversalKt.b(androidx.compose.ui.focus.FocusTargetNode):androidx.compose.ui.focus.FocusTargetNode");
    }

    private static final FocusTargetNode c(FocusTargetNode focusTargetNode) {
        NodeChain nodeChainU0;
        int iA = NodeKind.a(1024);
        if (!focusTargetNode.getNode().isAttached()) {
            InlineClassHelperKt.c("visitAncestors called on an unattached node");
        }
        Modifier.Node parent$ui_release = focusTargetNode.getNode().getParent$ui_release();
        LayoutNode layoutNodeO = DelegatableNodeKt.o(focusTargetNode);
        while (layoutNodeO != null) {
            if ((layoutNodeO.u0().k().getAggregateChildKindSet$ui_release() & iA) != 0) {
                while (parent$ui_release != null) {
                    if ((parent$ui_release.getKindSet$ui_release() & iA) != 0) {
                        Modifier.Node nodeH = parent$ui_release;
                        MutableVector mutableVector = null;
                        while (nodeH != null) {
                            if (nodeH instanceof FocusTargetNode) {
                                FocusTargetNode focusTargetNode2 = (FocusTargetNode) nodeH;
                                if (focusTargetNode2.t2().v()) {
                                    return focusTargetNode2;
                                }
                            } else if ((nodeH.getKindSet$ui_release() & iA) != 0 && (nodeH instanceof DelegatingNode)) {
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
        return null;
    }

    public static final Rect d(FocusTargetNode focusTargetNode) {
        Rect rectJ0;
        NodeCoordinator coordinator$ui_release = focusTargetNode.getCoordinator$ui_release();
        return (coordinator$ui_release == null || (rectJ0 = LayoutCoordinatesKt.d(coordinator$ui_release).j0(coordinator$ui_release, false)) == null) ? Rect.f25601e.a() : rectJ0;
    }

    public static final Boolean e(FocusTargetNode focusTargetNode, int i3, LayoutDirection layoutDirection, Rect rect, Function1 function1) {
        int iG;
        FocusDirection.Companion companion = FocusDirection.f25444b;
        if (FocusDirection.l(i3, companion.e()) ? true : FocusDirection.l(i3, companion.f())) {
            return Boolean.valueOf(OneDimensionalFocusSearchKt.f(focusTargetNode, i3, function1));
        }
        if (FocusDirection.l(i3, companion.d()) ? true : FocusDirection.l(i3, companion.g()) ? true : FocusDirection.l(i3, companion.h()) ? true : FocusDirection.l(i3, companion.a())) {
            return TwoDimensionalFocusSearchKt.t(focusTargetNode, i3, rect, function1);
        }
        if (!FocusDirection.l(i3, companion.b())) {
            if (FocusDirection.l(i3, companion.c())) {
                FocusTargetNode focusTargetNodeB = b(focusTargetNode);
                FocusTargetNode focusTargetNodeC = focusTargetNodeB != null ? c(focusTargetNodeB) : null;
                return Boolean.valueOf((focusTargetNodeC == null || Intrinsics.areEqual(focusTargetNodeC, focusTargetNode)) ? false : ((Boolean) function1.invoke(focusTargetNodeC)).booleanValue());
            }
            throw new IllegalStateException(("Focus search invoked with invalid FocusDirection " + ((Object) FocusDirection.n(i3))).toString());
        }
        int i4 = WhenMappings.f25564a[layoutDirection.ordinal()];
        if (i4 == 1) {
            iG = companion.g();
        } else {
            if (i4 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            iG = companion.d();
        }
        FocusTargetNode focusTargetNodeB2 = b(focusTargetNode);
        if (focusTargetNodeB2 != null) {
            return TwoDimensionalFocusSearchKt.t(focusTargetNodeB2, iG, rect, function1);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x0040, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final androidx.compose.ui.focus.FocusTargetNode f(androidx.compose.ui.focus.FocusTargetNode r10) {
        /*
            Method dump skipped, instruction units count: 214
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusTraversalKt.f(androidx.compose.ui.focus.FocusTargetNode):androidx.compose.ui.focus.FocusTargetNode");
    }

    public static final boolean g(FocusTargetNode focusTargetNode) {
        LayoutNode layoutNodeX1;
        NodeCoordinator coordinator$ui_release;
        LayoutNode layoutNodeX12;
        NodeCoordinator coordinator$ui_release2 = focusTargetNode.getCoordinator$ui_release();
        return (coordinator$ui_release2 == null || (layoutNodeX1 = coordinator$ui_release2.X1()) == null || !layoutNodeX1.u() || (coordinator$ui_release = focusTargetNode.getCoordinator$ui_release()) == null || (layoutNodeX12 = coordinator$ui_release.X1()) == null || !layoutNodeX12.m()) ? false : true;
    }
}
