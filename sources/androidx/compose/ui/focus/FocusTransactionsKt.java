package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class FocusTransactionsKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f25562a;

        static {
            int[] iArr = new int[FocusStateImpl.values().length];
            try {
                iArr[FocusStateImpl.f25537a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FocusStateImpl.f25539c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FocusStateImpl.f25538b.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FocusStateImpl.f25540d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f25562a = iArr;
        }
    }

    private static final boolean a(FocusTargetNode focusTargetNode, boolean z2, boolean z3) {
        FocusTargetNode focusTargetNodeF = FocusTraversalKt.f(focusTargetNode);
        if (focusTargetNodeF != null) {
            return c(focusTargetNodeF, z2, z3);
        }
        return true;
    }

    static /* synthetic */ boolean b(FocusTargetNode focusTargetNode, boolean z2, boolean z3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = false;
        }
        if ((i3 & 2) != 0) {
            z3 = true;
        }
        return a(focusTargetNode, z2, z3);
    }

    public static final boolean c(FocusTargetNode focusTargetNode, boolean z2, boolean z3) {
        int i3 = WhenMappings.f25562a[focusTargetNode.a0().ordinal()];
        if (i3 == 1) {
            if (ComposeUiFlags.f25107g) {
                DelegatableNodeKt.p(focusTargetNode).getFocusOwner().s(null);
                if (z3) {
                    focusTargetNode.s2(FocusStateImpl.f25537a, FocusStateImpl.f25540d);
                }
            } else {
                focusTargetNode.E2(FocusStateImpl.f25540d);
                if (z3) {
                    focusTargetNode.r2();
                }
            }
            return true;
        }
        if (i3 == 2) {
            if (z2) {
                if (ComposeUiFlags.f25107g) {
                    DelegatableNodeKt.p(focusTargetNode).getFocusOwner().s(null);
                    if (z3) {
                        focusTargetNode.s2(FocusStateImpl.f25539c, FocusStateImpl.f25540d);
                        return z2;
                    }
                } else {
                    focusTargetNode.E2(FocusStateImpl.f25540d);
                    if (z3) {
                        focusTargetNode.r2();
                    }
                }
            }
            return z2;
        }
        if (i3 != 3) {
            if (i3 == 4) {
                return true;
            }
            throw new NoWhenBranchMatchedException();
        }
        if (!a(focusTargetNode, z2, z3)) {
            return false;
        }
        if (!ComposeUiFlags.f25107g) {
            focusTargetNode.E2(FocusStateImpl.f25540d);
            if (z3) {
                focusTargetNode.r2();
            }
        } else if (z3) {
            focusTargetNode.s2(FocusStateImpl.f25538b, FocusStateImpl.f25540d);
        }
        return true;
    }

    public static /* synthetic */ boolean d(FocusTargetNode focusTargetNode, boolean z2, boolean z3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = false;
        }
        return c(focusTargetNode, z2, z3);
    }

    private static final boolean e(final FocusTargetNode focusTargetNode) {
        ObserverModifierNodeKt.a(focusTargetNode, new Function0<Unit>() { // from class: androidx.compose.ui.focus.FocusTransactionsKt$grantFocus$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m217invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m217invoke() {
                focusTargetNode.t2();
            }
        });
        int i3 = WhenMappings.f25562a[focusTargetNode.a0().ordinal()];
        if (i3 != 3 && i3 != 4) {
            return true;
        }
        if (ComposeUiFlags.f25107g) {
            DelegatableNodeKt.p(focusTargetNode).getFocusOwner().s(focusTargetNode);
            return true;
        }
        focusTargetNode.E2(FocusStateImpl.f25537a);
        return true;
    }

    public static final CustomDestinationResult f(FocusTargetNode focusTargetNode, int i3) {
        int i4 = WhenMappings.f25562a[focusTargetNode.a0().ordinal()];
        if (i4 != 1) {
            if (i4 == 2) {
                return CustomDestinationResult.f25436b;
            }
            if (i4 == 3) {
                CustomDestinationResult customDestinationResultF = f(o(focusTargetNode), i3);
                if (customDestinationResultF == CustomDestinationResult.f25435a) {
                    customDestinationResultF = null;
                }
                return customDestinationResultF == null ? h(focusTargetNode, i3) : customDestinationResultF;
            }
            if (i4 != 4) {
                throw new NoWhenBranchMatchedException();
            }
        }
        return CustomDestinationResult.f25435a;
    }

    private static final CustomDestinationResult g(FocusTargetNode focusTargetNode, int i3) {
        if (!focusTargetNode.f25547d) {
            focusTargetNode.f25547d = true;
            try {
                FocusProperties focusPropertiesT2 = focusTargetNode.t2();
                CancelIndicatingFocusBoundaryScope cancelIndicatingFocusBoundaryScope = new CancelIndicatingFocusBoundaryScope(i3, null);
                FocusTransactionManager focusTransactionManagerA = FocusTargetNodeKt.a(focusTargetNode);
                int iH = focusTransactionManagerA != null ? focusTransactionManagerA.h() : 0;
                FocusOwner focusOwner = DelegatableNodeKt.p(focusTargetNode).getFocusOwner();
                FocusTargetNode focusTargetNodeH = focusOwner.h();
                focusPropertiesT2.x().invoke(cancelIndicatingFocusBoundaryScope);
                int iH2 = focusTransactionManagerA != null ? focusTransactionManagerA.h() : 0;
                FocusTargetNode focusTargetNodeH2 = focusOwner.h();
                if (cancelIndicatingFocusBoundaryScope.c()) {
                    FocusRequester.Companion companion = FocusRequester.f25519b;
                    FocusRequester focusRequesterA = companion.a();
                    if (focusRequesterA == companion.a()) {
                        CustomDestinationResult customDestinationResult = CustomDestinationResult.f25436b;
                        focusTargetNode.f25547d = false;
                        return customDestinationResult;
                    }
                    if (focusRequesterA == companion.c()) {
                        CustomDestinationResult customDestinationResult2 = CustomDestinationResult.f25437c;
                        focusTargetNode.f25547d = false;
                        return customDestinationResult2;
                    }
                    CustomDestinationResult customDestinationResult3 = FocusRequester.h(focusRequesterA, 0, 1, null) ? CustomDestinationResult.f25437c : CustomDestinationResult.f25438d;
                    focusTargetNode.f25547d = false;
                    return customDestinationResult3;
                }
                if (iH != iH2 || (ComposeUiFlags.f25107g && focusTargetNodeH != focusTargetNodeH2 && focusTargetNodeH2 != null)) {
                    FocusRequester.Companion companion2 = FocusRequester.f25519b;
                    FocusRequester focusRequesterC = companion2.c();
                    if (focusRequesterC == companion2.a()) {
                        CustomDestinationResult customDestinationResult4 = CustomDestinationResult.f25436b;
                        focusTargetNode.f25547d = false;
                        return customDestinationResult4;
                    }
                    if (focusRequesterC == companion2.c()) {
                        CustomDestinationResult customDestinationResult5 = CustomDestinationResult.f25437c;
                        focusTargetNode.f25547d = false;
                        return customDestinationResult5;
                    }
                    CustomDestinationResult customDestinationResult6 = FocusRequester.h(focusRequesterC, 0, 1, null) ? CustomDestinationResult.f25437c : CustomDestinationResult.f25438d;
                    focusTargetNode.f25547d = false;
                    return customDestinationResult6;
                }
                focusTargetNode.f25547d = false;
            } catch (Throwable th) {
                focusTargetNode.f25547d = false;
                throw th;
            }
        }
        return CustomDestinationResult.f25435a;
    }

    private static final CustomDestinationResult h(FocusTargetNode focusTargetNode, int i3) {
        if (!focusTargetNode.f25546c) {
            focusTargetNode.f25546c = true;
            try {
                FocusProperties focusPropertiesT2 = focusTargetNode.t2();
                CancelIndicatingFocusBoundaryScope cancelIndicatingFocusBoundaryScope = new CancelIndicatingFocusBoundaryScope(i3, null);
                FocusTransactionManager focusTransactionManagerA = FocusTargetNodeKt.a(focusTargetNode);
                int iH = focusTransactionManagerA != null ? focusTransactionManagerA.h() : 0;
                FocusOwner focusOwner = DelegatableNodeKt.p(focusTargetNode).getFocusOwner();
                FocusTargetNode focusTargetNodeH = focusOwner.h();
                focusPropertiesT2.y().invoke(cancelIndicatingFocusBoundaryScope);
                int iH2 = focusTransactionManagerA != null ? focusTransactionManagerA.h() : 0;
                FocusTargetNode focusTargetNodeH2 = focusOwner.h();
                if (cancelIndicatingFocusBoundaryScope.c()) {
                    FocusRequester.Companion companion = FocusRequester.f25519b;
                    FocusRequester focusRequesterA = companion.a();
                    if (focusRequesterA == companion.a()) {
                        CustomDestinationResult customDestinationResult = CustomDestinationResult.f25436b;
                        focusTargetNode.f25546c = false;
                        return customDestinationResult;
                    }
                    if (focusRequesterA == companion.c()) {
                        CustomDestinationResult customDestinationResult2 = CustomDestinationResult.f25437c;
                        focusTargetNode.f25546c = false;
                        return customDestinationResult2;
                    }
                    CustomDestinationResult customDestinationResult3 = FocusRequester.h(focusRequesterA, 0, 1, null) ? CustomDestinationResult.f25437c : CustomDestinationResult.f25438d;
                    focusTargetNode.f25546c = false;
                    return customDestinationResult3;
                }
                if (iH != iH2 || (ComposeUiFlags.f25107g && focusTargetNodeH != focusTargetNodeH2 && focusTargetNodeH2 != null)) {
                    FocusRequester.Companion companion2 = FocusRequester.f25519b;
                    FocusRequester focusRequesterC = companion2.c();
                    if (focusRequesterC == companion2.a()) {
                        CustomDestinationResult customDestinationResult4 = CustomDestinationResult.f25436b;
                        focusTargetNode.f25546c = false;
                        return customDestinationResult4;
                    }
                    if (focusRequesterC == companion2.c()) {
                        CustomDestinationResult customDestinationResult5 = CustomDestinationResult.f25437c;
                        focusTargetNode.f25546c = false;
                        return customDestinationResult5;
                    }
                    CustomDestinationResult customDestinationResult6 = FocusRequester.h(focusRequesterC, 0, 1, null) ? CustomDestinationResult.f25437c : CustomDestinationResult.f25438d;
                    focusTargetNode.f25546c = false;
                    return customDestinationResult6;
                }
                focusTargetNode.f25546c = false;
            } catch (Throwable th) {
                focusTargetNode.f25546c = false;
                throw th;
            }
        }
        return CustomDestinationResult.f25435a;
    }

    public static final CustomDestinationResult i(FocusTargetNode focusTargetNode, int i3) {
        Modifier.Node nodeH;
        NodeChain nodeChainU0;
        int i4 = WhenMappings.f25562a[focusTargetNode.a0().ordinal()];
        if (i4 == 1 || i4 == 2) {
            return CustomDestinationResult.f25435a;
        }
        if (i4 == 3) {
            return f(o(focusTargetNode), i3);
        }
        if (i4 != 4) {
            throw new NoWhenBranchMatchedException();
        }
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
                                int i5 = 0;
                                for (Modifier.Node nodeN2 = ((DelegatingNode) nodeH).n2(); nodeN2 != null; nodeN2 = nodeN2.getChild$ui_release()) {
                                    if ((nodeN2.getKindSet$ui_release() & iA) != 0) {
                                        i5++;
                                        if (i5 == 1) {
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
                                if (i5 == 1) {
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
        if (focusTargetNode2 == null) {
            return CustomDestinationResult.f25435a;
        }
        int i6 = WhenMappings.f25562a[focusTargetNode2.a0().ordinal()];
        if (i6 == 1) {
            return g(focusTargetNode2, i3);
        }
        if (i6 == 2) {
            return CustomDestinationResult.f25436b;
        }
        if (i6 == 3) {
            return i(focusTargetNode2, i3);
        }
        if (i6 != 4) {
            throw new NoWhenBranchMatchedException();
        }
        CustomDestinationResult customDestinationResultI = i(focusTargetNode2, i3);
        CustomDestinationResult customDestinationResult = customDestinationResultI != CustomDestinationResult.f25435a ? customDestinationResultI : null;
        return customDestinationResult == null ? g(focusTargetNode2, i3) : customDestinationResult;
    }

    public static final boolean j(FocusTargetNode focusTargetNode) {
        return ComposeUiFlags.f25107g ? l(focusTargetNode) : k(focusTargetNode);
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x00e0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final boolean k(androidx.compose.ui.focus.FocusTargetNode r11) {
        /*
            Method dump skipped, instruction units count: 285
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusTransactionsKt.k(androidx.compose.ui.focus.FocusTargetNode):boolean");
    }

    private static final boolean l(FocusTargetNode focusTargetNode) {
        MutableVector mutableVector;
        int i3;
        NodeChain nodeChainU0;
        NodeChain nodeChainU02;
        FocusOwner focusOwner = DelegatableNodeKt.p(focusTargetNode).getFocusOwner();
        FocusTargetNode focusTargetNodeH = focusOwner.h();
        FocusStateImpl focusStateImplA0 = focusTargetNode.a0();
        int i4 = 1;
        if (focusTargetNodeH == focusTargetNode) {
            focusTargetNode.s2(focusStateImplA0, focusStateImplA0);
            return true;
        }
        int i5 = 0;
        if (focusTargetNodeH == null && !n(focusTargetNode)) {
            return false;
        }
        int i6 = 1024;
        int i7 = 16;
        if (focusTargetNodeH != null) {
            mutableVector = new MutableVector(new FocusTargetNode[16], 0);
            int iA = NodeKind.a(1024);
            if (!focusTargetNodeH.getNode().isAttached()) {
                InlineClassHelperKt.c("visitAncestors called on an unattached node");
            }
            Modifier.Node parent$ui_release = focusTargetNodeH.getNode().getParent$ui_release();
            LayoutNode layoutNodeO = DelegatableNodeKt.o(focusTargetNodeH);
            while (layoutNodeO != null) {
                if ((layoutNodeO.u0().k().getAggregateChildKindSet$ui_release() & iA) != 0) {
                    while (parent$ui_release != null) {
                        if ((parent$ui_release.getKindSet$ui_release() & iA) != 0) {
                            Modifier.Node nodeH = parent$ui_release;
                            MutableVector mutableVector2 = null;
                            while (nodeH != null) {
                                int i8 = i6;
                                if (nodeH instanceof FocusTargetNode) {
                                    mutableVector.b((FocusTargetNode) nodeH);
                                } else if ((nodeH.getKindSet$ui_release() & iA) != 0 && (nodeH instanceof DelegatingNode)) {
                                    Modifier.Node nodeN2 = ((DelegatingNode) nodeH).n2();
                                    int i9 = 0;
                                    while (nodeN2 != null) {
                                        if ((nodeN2.getKindSet$ui_release() & iA) != 0) {
                                            i9++;
                                            if (i9 == i4) {
                                                nodeH = nodeN2;
                                            } else {
                                                if (mutableVector2 == null) {
                                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (nodeH != null) {
                                                    mutableVector2.b(nodeH);
                                                    nodeH = null;
                                                }
                                                mutableVector2.b(nodeN2);
                                            }
                                        }
                                        nodeN2 = nodeN2.getChild$ui_release();
                                        i4 = 1;
                                    }
                                    if (i9 == i4) {
                                        i6 = i8;
                                    }
                                }
                                nodeH = DelegatableNodeKt.h(mutableVector2);
                                i6 = i8;
                                i4 = 1;
                            }
                        }
                        parent$ui_release = parent$ui_release.getParent$ui_release();
                        i6 = i6;
                        i4 = 1;
                    }
                }
                int i10 = i6;
                layoutNodeO = layoutNodeO.B0();
                parent$ui_release = (layoutNodeO == null || (nodeChainU02 = layoutNodeO.u0()) == null) ? null : nodeChainU02.p();
                i6 = i10;
                i4 = 1;
            }
        } else {
            mutableVector = null;
        }
        int i11 = i6;
        MutableVector mutableVector3 = new MutableVector(new FocusTargetNode[16], 0);
        int iA2 = NodeKind.a(i11);
        if (!focusTargetNode.getNode().isAttached()) {
            InlineClassHelperKt.c("visitAncestors called on an unattached node");
        }
        Modifier.Node parent$ui_release2 = focusTargetNode.getNode().getParent$ui_release();
        LayoutNode layoutNodeO2 = DelegatableNodeKt.o(focusTargetNode);
        int i12 = 1;
        while (layoutNodeO2 != null) {
            if ((layoutNodeO2.u0().k().getAggregateChildKindSet$ui_release() & iA2) != 0) {
                while (parent$ui_release2 != null) {
                    if ((parent$ui_release2.getKindSet$ui_release() & iA2) != 0) {
                        Modifier.Node nodeH2 = parent$ui_release2;
                        MutableVector mutableVector4 = null;
                        while (nodeH2 != null) {
                            if (nodeH2 instanceof FocusTargetNode) {
                                FocusTargetNode focusTargetNode2 = (FocusTargetNode) nodeH2;
                                Boolean boolValueOf = mutableVector != null ? Boolean.valueOf(mutableVector.s(focusTargetNode2)) : null;
                                if (boolValueOf == null || !boolValueOf.booleanValue()) {
                                    mutableVector3.b(focusTargetNode2);
                                }
                                if (focusTargetNode2 == focusTargetNodeH) {
                                    i12 = i5;
                                }
                            } else {
                                if ((nodeH2.getKindSet$ui_release() & iA2) != 0 && (nodeH2 instanceof DelegatingNode)) {
                                    Modifier.Node nodeN22 = ((DelegatingNode) nodeH2).n2();
                                    int i13 = i5;
                                    while (nodeN22 != null) {
                                        if ((nodeN22.getKindSet$ui_release() & iA2) != 0) {
                                            i13++;
                                            if (i13 == 1) {
                                                nodeH2 = nodeN22;
                                            } else {
                                                if (mutableVector4 == null) {
                                                    mutableVector4 = new MutableVector(new Modifier.Node[i7], 0);
                                                }
                                                if (nodeH2 != null) {
                                                    mutableVector4.b(nodeH2);
                                                    nodeH2 = null;
                                                }
                                                mutableVector4.b(nodeN22);
                                            }
                                        }
                                        nodeN22 = nodeN22.getChild$ui_release();
                                        i7 = 16;
                                    }
                                    if (i13 == 1) {
                                    }
                                }
                                i5 = 0;
                                i7 = 16;
                            }
                            nodeH2 = DelegatableNodeKt.h(mutableVector4);
                            i5 = 0;
                            i7 = 16;
                        }
                    }
                    parent$ui_release2 = parent$ui_release2.getParent$ui_release();
                    i5 = 0;
                    i7 = 16;
                }
            }
            layoutNodeO2 = layoutNodeO2.B0();
            parent$ui_release2 = (layoutNodeO2 == null || (nodeChainU0 = layoutNodeO2.u0()) == null) ? null : nodeChainU0.p();
            i5 = 0;
            i7 = 16;
        }
        if (i12 == 0 || focusTargetNodeH == null) {
            i3 = 1;
        } else {
            i3 = 1;
            if (!d(focusTargetNodeH, false, true, 1, null)) {
                return false;
            }
        }
        e(focusTargetNode);
        if (mutableVector != null) {
            int iO = mutableVector.o() - i3;
            Object[] objArr = mutableVector.f24389a;
            if (iO < objArr.length) {
                while (iO >= 0) {
                    FocusTargetNode focusTargetNode3 = (FocusTargetNode) objArr[iO];
                    if (focusOwner.h() != focusTargetNode) {
                        return false;
                    }
                    focusTargetNode3.s2(FocusStateImpl.f25538b, FocusStateImpl.f25540d);
                    iO--;
                }
            }
        }
        int iO2 = mutableVector3.o() - 1;
        Object[] objArr2 = mutableVector3.f24389a;
        if (iO2 < objArr2.length) {
            while (iO2 >= 0) {
                FocusTargetNode focusTargetNode4 = (FocusTargetNode) objArr2[iO2];
                if (focusOwner.h() != focusTargetNode) {
                    return false;
                }
                focusTargetNode4.s2(focusTargetNode4 == focusTargetNodeH ? FocusStateImpl.f25537a : FocusStateImpl.f25540d, FocusStateImpl.f25538b);
                iO2--;
            }
        }
        if (focusOwner.h() != focusTargetNode) {
            return false;
        }
        focusTargetNode.s2(focusStateImplA0, FocusStateImpl.f25537a);
        if (focusOwner.h() != focusTargetNode) {
            return false;
        }
        if (!ComposeUiFlags.f25105e || DelegatableNodeKt.o(focusTargetNode).b0() != null) {
            return true;
        }
        DelegatableNodeKt.p(focusTargetNode).getFocusOwner().u(FocusDirection.i(FocusDirection.f25444b.e()), null);
        return true;
    }

    private static final boolean m(FocusTargetNode focusTargetNode, FocusTargetNode focusTargetNode2) {
        Modifier.Node node;
        Modifier.Node nodeH;
        NodeChain nodeChainU0;
        NodeChain nodeChainU02;
        int iA = NodeKind.a(1024);
        if (!focusTargetNode2.getNode().isAttached()) {
            InlineClassHelperKt.c("visitAncestors called on an unattached node");
        }
        Modifier.Node parent$ui_release = focusTargetNode2.getNode().getParent$ui_release();
        LayoutNode layoutNodeO = DelegatableNodeKt.o(focusTargetNode2);
        loop0: while (true) {
            node = null;
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
            parent$ui_release = (layoutNodeO == null || (nodeChainU02 = layoutNodeO.u0()) == null) ? null : nodeChainU02.p();
        }
        if (!Intrinsics.areEqual(nodeH, focusTargetNode)) {
            throw new IllegalStateException("Non child node cannot request focus.");
        }
        int i4 = WhenMappings.f25562a[focusTargetNode.a0().ordinal()];
        if (i4 == 1) {
            boolean zE = e(focusTargetNode2);
            if (zE) {
                focusTargetNode.E2(FocusStateImpl.f25538b);
            }
            return zE;
        }
        if (i4 != 2) {
            if (i4 != 3) {
                if (i4 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                int iA2 = NodeKind.a(1024);
                if (!focusTargetNode.getNode().isAttached()) {
                    InlineClassHelperKt.c("visitAncestors called on an unattached node");
                }
                Modifier.Node parent$ui_release2 = focusTargetNode.getNode().getParent$ui_release();
                LayoutNode layoutNodeO2 = DelegatableNodeKt.o(focusTargetNode);
                loop4: while (true) {
                    if (layoutNodeO2 == null) {
                        break;
                    }
                    if ((layoutNodeO2.u0().k().getAggregateChildKindSet$ui_release() & iA2) != 0) {
                        while (parent$ui_release2 != null) {
                            if ((parent$ui_release2.getKindSet$ui_release() & iA2) != 0) {
                                Modifier.Node nodeH2 = parent$ui_release2;
                                MutableVector mutableVector2 = null;
                                while (nodeH2 != null) {
                                    if (nodeH2 instanceof FocusTargetNode) {
                                        node = nodeH2;
                                        break loop4;
                                    }
                                    if ((nodeH2.getKindSet$ui_release() & iA2) != 0 && (nodeH2 instanceof DelegatingNode)) {
                                        int i5 = 0;
                                        for (Modifier.Node nodeN22 = ((DelegatingNode) nodeH2).n2(); nodeN22 != null; nodeN22 = nodeN22.getChild$ui_release()) {
                                            if ((nodeN22.getKindSet$ui_release() & iA2) != 0) {
                                                i5++;
                                                if (i5 == 1) {
                                                    nodeH2 = nodeN22;
                                                } else {
                                                    if (mutableVector2 == null) {
                                                        mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                    }
                                                    if (nodeH2 != null) {
                                                        mutableVector2.b(nodeH2);
                                                        nodeH2 = null;
                                                    }
                                                    mutableVector2.b(nodeN22);
                                                }
                                            }
                                        }
                                        if (i5 == 1) {
                                        }
                                    }
                                    nodeH2 = DelegatableNodeKt.h(mutableVector2);
                                }
                            }
                            parent$ui_release2 = parent$ui_release2.getParent$ui_release();
                        }
                    }
                    layoutNodeO2 = layoutNodeO2.B0();
                    parent$ui_release2 = (layoutNodeO2 == null || (nodeChainU0 = layoutNodeO2.u0()) == null) ? null : nodeChainU0.p();
                }
                FocusTargetNode focusTargetNode3 = (FocusTargetNode) node;
                if (focusTargetNode3 == null && n(focusTargetNode)) {
                    boolean zE2 = e(focusTargetNode2);
                    if (zE2) {
                        focusTargetNode.E2(FocusStateImpl.f25538b);
                    }
                    return zE2;
                }
                if (focusTargetNode3 == null || !m(focusTargetNode3, focusTargetNode)) {
                    return false;
                }
                boolean zM = m(focusTargetNode, focusTargetNode2);
                if (focusTargetNode.a0() != FocusStateImpl.f25538b) {
                    throw new IllegalStateException("Deactivated node is focused");
                }
                if (zM) {
                    focusTargetNode3.r2();
                }
                return zM;
            }
            o(focusTargetNode);
            if (b(focusTargetNode, false, false, 3, null) && e(focusTargetNode2)) {
                return true;
            }
        }
        return false;
    }

    private static final boolean n(FocusTargetNode focusTargetNode) {
        return DelegatableNodeKt.p(focusTargetNode).getFocusOwner().u(null, null);
    }

    private static final FocusTargetNode o(FocusTargetNode focusTargetNode) {
        FocusTargetNode focusTargetNodeF = FocusTraversalKt.f(focusTargetNode);
        if (focusTargetNodeF != null) {
            return focusTargetNodeF;
        }
        throw new IllegalArgumentException("ActiveParent with no focused child");
    }
}
