package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.BeyondBoundsLayout;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
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
public final class TwoDimensionalFocusSearchKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f25581a;

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
            f25581a = iArr;
        }
    }

    private static final FocusTargetNode b(FocusTargetNode focusTargetNode) {
        if (focusTargetNode.a0() != FocusStateImpl.f25538b) {
            throw new IllegalStateException("Searching for active node in inactive hierarchy");
        }
        FocusTargetNode focusTargetNodeB = FocusTraversalKt.b(focusTargetNode);
        if (focusTargetNodeB != null) {
            return focusTargetNodeB;
        }
        throw new IllegalStateException("ActiveParent must have a focusedChild");
    }

    private static final boolean c(Rect rect, Rect rect2, Rect rect3, int i3) {
        if (d(rect3, i3, rect) || !d(rect2, i3, rect)) {
            return false;
        }
        if (!e(rect3, i3, rect)) {
            return true;
        }
        FocusDirection.Companion companion = FocusDirection.f25444b;
        return FocusDirection.l(i3, companion.d()) || FocusDirection.l(i3, companion.g()) || f(rect2, i3, rect) < g(rect3, i3, rect);
    }

    private static final boolean d(Rect rect, int i3, Rect rect2) {
        FocusDirection.Companion companion = FocusDirection.f25444b;
        if (FocusDirection.l(i3, companion.d()) ? true : FocusDirection.l(i3, companion.g())) {
            return rect.i() > rect2.r() && rect.r() < rect2.i();
        }
        if (FocusDirection.l(i3, companion.h()) ? true : FocusDirection.l(i3, companion.a())) {
            return rect.p() > rect2.o() && rect.o() < rect2.p();
        }
        throw new IllegalStateException("This function should only be used for 2-D focus search");
    }

    private static final boolean e(Rect rect, int i3, Rect rect2) {
        FocusDirection.Companion companion = FocusDirection.f25444b;
        if (FocusDirection.l(i3, companion.d())) {
            return rect2.o() >= rect.p();
        }
        if (FocusDirection.l(i3, companion.g())) {
            return rect2.p() <= rect.o();
        }
        if (FocusDirection.l(i3, companion.h())) {
            return rect2.r() >= rect.i();
        }
        if (FocusDirection.l(i3, companion.a())) {
            return rect2.i() <= rect.r();
        }
        throw new IllegalStateException("This function should only be used for 2-D focus search");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0056 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0057 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final float f(androidx.compose.ui.geometry.Rect r2, int r3, androidx.compose.ui.geometry.Rect r4) {
        /*
            androidx.compose.ui.focus.FocusDirection$Companion r0 = androidx.compose.ui.focus.FocusDirection.f25444b
            int r1 = r0.d()
            boolean r1 = androidx.compose.ui.focus.FocusDirection.l(r3, r1)
            if (r1 == 0) goto L16
            float r3 = r4.o()
            float r2 = r2.p()
        L14:
            float r3 = r3 - r2
            goto L51
        L16:
            int r1 = r0.g()
            boolean r1 = androidx.compose.ui.focus.FocusDirection.l(r3, r1)
            if (r1 == 0) goto L2b
            float r2 = r2.o()
            float r3 = r4.p()
        L28:
            float r3 = r2 - r3
            goto L51
        L2b:
            int r1 = r0.h()
            boolean r1 = androidx.compose.ui.focus.FocusDirection.l(r3, r1)
            if (r1 == 0) goto L3e
            float r3 = r4.r()
            float r2 = r2.i()
            goto L14
        L3e:
            int r0 = r0.a()
            boolean r3 = androidx.compose.ui.focus.FocusDirection.l(r3, r0)
            if (r3 == 0) goto L58
            float r2 = r2.r()
            float r3 = r4.i()
            goto L28
        L51:
            r2 = 0
            int r4 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r4 >= 0) goto L57
            return r2
        L57:
            return r3
        L58:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r3 = "This function should only be used for 2-D focus search"
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.TwoDimensionalFocusSearchKt.f(androidx.compose.ui.geometry.Rect, int, androidx.compose.ui.geometry.Rect):float");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0057 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0058 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final float g(androidx.compose.ui.geometry.Rect r2, int r3, androidx.compose.ui.geometry.Rect r4) {
        /*
            androidx.compose.ui.focus.FocusDirection$Companion r0 = androidx.compose.ui.focus.FocusDirection.f25444b
            int r1 = r0.d()
            boolean r1 = androidx.compose.ui.focus.FocusDirection.l(r3, r1)
            if (r1 == 0) goto L16
            float r3 = r4.o()
            float r2 = r2.o()
        L14:
            float r3 = r3 - r2
            goto L51
        L16:
            int r1 = r0.g()
            boolean r1 = androidx.compose.ui.focus.FocusDirection.l(r3, r1)
            if (r1 == 0) goto L2b
            float r2 = r2.p()
            float r3 = r4.p()
        L28:
            float r3 = r2 - r3
            goto L51
        L2b:
            int r1 = r0.h()
            boolean r1 = androidx.compose.ui.focus.FocusDirection.l(r3, r1)
            if (r1 == 0) goto L3e
            float r3 = r4.r()
            float r2 = r2.r()
            goto L14
        L3e:
            int r0 = r0.a()
            boolean r3 = androidx.compose.ui.focus.FocusDirection.l(r3, r0)
            if (r3 == 0) goto L59
            float r2 = r2.i()
            float r3 = r4.i()
            goto L28
        L51:
            r2 = 1065353216(0x3f800000, float:1.0)
            int r4 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r4 >= 0) goto L58
            return r2
        L58:
            return r3
        L59:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r3 = "This function should only be used for 2-D focus search"
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.TwoDimensionalFocusSearchKt.g(androidx.compose.ui.geometry.Rect, int, androidx.compose.ui.geometry.Rect):float");
    }

    private static final Rect h(Rect rect) {
        return new Rect(rect.p(), rect.i(), rect.p(), rect.i());
    }

    private static final void i(DelegatableNode delegatableNode, MutableVector mutableVector) {
        int iA = NodeKind.a(1024);
        if (!delegatableNode.getNode().isAttached()) {
            InlineClassHelperKt.c("visitChildren called on an unattached node");
        }
        MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui_release = delegatableNode.getNode().getChild$ui_release();
        if (child$ui_release == null) {
            DelegatableNodeKt.c(mutableVector2, delegatableNode.getNode(), false);
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
                                FocusTargetNode focusTargetNode = (FocusTargetNode) nodeH;
                                if (focusTargetNode.isAttached() && !DelegatableNodeKt.o(focusTargetNode).y()) {
                                    if (focusTargetNode.t2().v()) {
                                        mutableVector.b(focusTargetNode);
                                    } else {
                                        i(focusTargetNode, mutableVector);
                                    }
                                }
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
    }

    private static final FocusTargetNode j(MutableVector mutableVector, Rect rect, int i3) {
        Rect rectA;
        FocusDirection.Companion companion = FocusDirection.f25444b;
        if (FocusDirection.l(i3, companion.d())) {
            rectA = rect.A((rect.p() - rect.o()) + 1, 0.0f);
        } else if (FocusDirection.l(i3, companion.g())) {
            rectA = rect.A(-((rect.p() - rect.o()) + 1), 0.0f);
        } else if (FocusDirection.l(i3, companion.h())) {
            rectA = rect.A(0.0f, (rect.i() - rect.r()) + 1);
        } else {
            if (!FocusDirection.l(i3, companion.a())) {
                throw new IllegalStateException("This function should only be used for 2-D focus search");
            }
            rectA = rect.A(0.0f, -((rect.i() - rect.r()) + 1));
        }
        Object[] objArr = mutableVector.f24389a;
        int iO = mutableVector.o();
        FocusTargetNode focusTargetNode = null;
        for (int i4 = 0; i4 < iO; i4++) {
            FocusTargetNode focusTargetNode2 = (FocusTargetNode) objArr[i4];
            if (FocusTraversalKt.g(focusTargetNode2)) {
                Rect rectD = FocusTraversalKt.d(focusTargetNode2);
                if (m(rectD, rectA, rect, i3)) {
                    focusTargetNode = focusTargetNode2;
                    rectA = rectD;
                }
            }
        }
        return focusTargetNode;
    }

    public static final boolean k(FocusTargetNode focusTargetNode, int i3, Function1 function1) {
        Rect rectH;
        MutableVector mutableVector = new MutableVector(new FocusTargetNode[16], 0);
        i(focusTargetNode, mutableVector);
        if (mutableVector.o() <= 1) {
            FocusTargetNode focusTargetNode2 = (FocusTargetNode) (mutableVector.o() == 0 ? null : mutableVector.f24389a[0]);
            if (focusTargetNode2 != null) {
                return ((Boolean) function1.invoke(focusTargetNode2)).booleanValue();
            }
            return false;
        }
        FocusDirection.Companion companion = FocusDirection.f25444b;
        if (FocusDirection.l(i3, companion.b())) {
            i3 = companion.g();
        }
        if (FocusDirection.l(i3, companion.g()) ? true : FocusDirection.l(i3, companion.a())) {
            rectH = s(FocusTraversalKt.d(focusTargetNode));
        } else {
            if (!(FocusDirection.l(i3, companion.d()) ? true : FocusDirection.l(i3, companion.h()))) {
                throw new IllegalStateException("This function should only be used for 2-D focus search");
            }
            rectH = h(FocusTraversalKt.d(focusTargetNode));
        }
        FocusTargetNode focusTargetNodeJ = j(mutableVector, rectH, i3);
        if (focusTargetNodeJ != null) {
            return ((Boolean) function1.invoke(focusTargetNodeJ)).booleanValue();
        }
        return false;
    }

    private static final boolean l(final FocusTargetNode focusTargetNode, final Rect rect, final int i3, final Function1 function1) {
        if (r(focusTargetNode, rect, i3, function1)) {
            return true;
        }
        final FocusTransactionManager focusTransactionManagerC = FocusTargetNodeKt.c(focusTargetNode);
        final int iH = focusTransactionManagerC.h();
        final FocusTargetNode focusTargetNodeH = DelegatableNodeKt.p(focusTargetNode).getFocusOwner().h();
        Boolean bool = (Boolean) BeyondBoundsLayoutKt.a(focusTargetNode, i3, new Function1<BeyondBoundsLayout.BeyondBoundsScope, Boolean>() { // from class: androidx.compose.ui.focus.TwoDimensionalFocusSearchKt$generateAndSearchChildren$1
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
                boolean zR = TwoDimensionalFocusSearchKt.r(focusTargetNode, rect, i3, function1);
                Boolean boolValueOf = Boolean.valueOf(zR);
                if (zR || !beyondBoundsScope.a()) {
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

    public static final boolean m(Rect rect, Rect rect2, Rect rect3, int i3) {
        if (!n(rect, i3, rect3)) {
            return false;
        }
        if (n(rect2, i3, rect3) && !c(rect3, rect, rect2, i3)) {
            return !c(rect3, rect2, rect, i3) && q(i3, rect3, rect) < q(i3, rect3, rect2);
        }
        return true;
    }

    private static final boolean n(Rect rect, int i3, Rect rect2) {
        FocusDirection.Companion companion = FocusDirection.f25444b;
        if (FocusDirection.l(i3, companion.d())) {
            return (rect2.p() > rect.p() || rect2.o() >= rect.p()) && rect2.o() > rect.o();
        }
        if (FocusDirection.l(i3, companion.g())) {
            return (rect2.o() < rect.o() || rect2.p() <= rect.o()) && rect2.p() < rect.p();
        }
        if (FocusDirection.l(i3, companion.h())) {
            return (rect2.i() > rect.i() || rect2.r() >= rect.i()) && rect2.r() > rect.r();
        }
        if (FocusDirection.l(i3, companion.a())) {
            return (rect2.r() < rect.r() || rect2.i() <= rect.r()) && rect2.i() < rect.i();
        }
        throw new IllegalStateException("This function should only be used for 2-D focus search");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0056 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0057 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final float o(androidx.compose.ui.geometry.Rect r2, int r3, androidx.compose.ui.geometry.Rect r4) {
        /*
            androidx.compose.ui.focus.FocusDirection$Companion r0 = androidx.compose.ui.focus.FocusDirection.f25444b
            int r1 = r0.d()
            boolean r1 = androidx.compose.ui.focus.FocusDirection.l(r3, r1)
            if (r1 == 0) goto L16
            float r3 = r4.o()
            float r2 = r2.p()
        L14:
            float r3 = r3 - r2
            goto L51
        L16:
            int r1 = r0.g()
            boolean r1 = androidx.compose.ui.focus.FocusDirection.l(r3, r1)
            if (r1 == 0) goto L2b
            float r2 = r2.o()
            float r3 = r4.p()
        L28:
            float r3 = r2 - r3
            goto L51
        L2b:
            int r1 = r0.h()
            boolean r1 = androidx.compose.ui.focus.FocusDirection.l(r3, r1)
            if (r1 == 0) goto L3e
            float r3 = r4.r()
            float r2 = r2.i()
            goto L14
        L3e:
            int r0 = r0.a()
            boolean r3 = androidx.compose.ui.focus.FocusDirection.l(r3, r0)
            if (r3 == 0) goto L58
            float r2 = r2.r()
            float r3 = r4.i()
            goto L28
        L51:
            r2 = 0
            int r4 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r4 >= 0) goto L57
            return r2
        L57:
            return r3
        L58:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r3 = "This function should only be used for 2-D focus search"
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.TwoDimensionalFocusSearchKt.o(androidx.compose.ui.geometry.Rect, int, androidx.compose.ui.geometry.Rect):float");
    }

    private static final float p(Rect rect, int i3, Rect rect2) {
        float f3;
        float f4;
        float fO;
        float fP;
        float fO2;
        FocusDirection.Companion companion = FocusDirection.f25444b;
        if (FocusDirection.l(i3, companion.d()) ? true : FocusDirection.l(i3, companion.g())) {
            float fR = rect2.r();
            float fI = rect2.i() - rect2.r();
            f3 = 2;
            f4 = fR + (fI / f3);
            fO = rect.r();
            fP = rect.i();
            fO2 = rect.r();
        } else {
            if (!(FocusDirection.l(i3, companion.h()) ? true : FocusDirection.l(i3, companion.a()))) {
                throw new IllegalStateException("This function should only be used for 2-D focus search");
            }
            float fO3 = rect2.o();
            float fP2 = rect2.p() - rect2.o();
            f3 = 2;
            f4 = fO3 + (fP2 / f3);
            fO = rect.o();
            fP = rect.p();
            fO2 = rect.o();
        }
        return f4 - (fO + ((fP - fO2) / f3));
    }

    private static final long q(int i3, Rect rect, Rect rect2) {
        long jO = (long) o(rect2, i3, rect);
        long jP = (long) p(rect2, i3, rect);
        return (((long) 13) * jO * jO) + (jP * jP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean r(FocusTargetNode focusTargetNode, Rect rect, int i3, Function1 function1) {
        FocusTargetNode focusTargetNodeJ;
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
                                FocusTargetNode focusTargetNode2 = (FocusTargetNode) nodeH;
                                if (focusTargetNode2.isAttached()) {
                                    mutableVector.b(focusTargetNode2);
                                }
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
        while (mutableVector.o() != 0 && (focusTargetNodeJ = j(mutableVector, rect, i3)) != null) {
            if (focusTargetNodeJ.t2().v()) {
                return ((Boolean) function1.invoke(focusTargetNodeJ)).booleanValue();
            }
            if (l(focusTargetNodeJ, rect, i3, function1)) {
                return true;
            }
            mutableVector.s(focusTargetNodeJ);
        }
        return false;
    }

    private static final Rect s(Rect rect) {
        return new Rect(rect.o(), rect.r(), rect.o(), rect.r());
    }

    public static final Boolean t(FocusTargetNode focusTargetNode, int i3, Rect rect, Function1 function1) {
        FocusStateImpl focusStateImplA0 = focusTargetNode.a0();
        int[] iArr = WhenMappings.f25581a;
        int i4 = iArr[focusStateImplA0.ordinal()];
        if (i4 != 1) {
            if (i4 == 2 || i4 == 3) {
                return Boolean.valueOf(k(focusTargetNode, i3, function1));
            }
            if (i4 == 4) {
                return focusTargetNode.t2().v() ? (Boolean) function1.invoke(focusTargetNode) : rect == null ? Boolean.valueOf(k(focusTargetNode, i3, function1)) : Boolean.valueOf(r(focusTargetNode, rect, i3, function1));
            }
            throw new NoWhenBranchMatchedException();
        }
        FocusTargetNode focusTargetNodeF = FocusTraversalKt.f(focusTargetNode);
        if (focusTargetNodeF == null) {
            throw new IllegalStateException("ActiveParent must have a focusedChild");
        }
        int i5 = iArr[focusTargetNodeF.a0().ordinal()];
        if (i5 == 1) {
            Boolean boolT = t(focusTargetNodeF, i3, rect, function1);
            if (!Intrinsics.areEqual(boolT, Boolean.FALSE)) {
                return boolT;
            }
            if (rect == null) {
                rect = FocusTraversalKt.d(b(focusTargetNodeF));
            }
            return Boolean.valueOf(l(focusTargetNode, rect, i3, function1));
        }
        if (i5 == 2 || i5 == 3) {
            if (rect == null) {
                rect = FocusTraversalKt.d(focusTargetNodeF);
            }
            return Boolean.valueOf(l(focusTargetNode, rect, i3, function1));
        }
        if (i5 != 4) {
            throw new NoWhenBranchMatchedException();
        }
        throw new IllegalStateException("ActiveParent must have a focusedChild");
    }
}
