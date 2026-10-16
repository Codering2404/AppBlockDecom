package androidx.compose.ui.focus;

import android.os.Trace;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.BeyondBoundsLayout;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

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
public final class FocusTargetNode extends Modifier.Node implements CompositionLocalConsumerModifierNode, FocusTargetModifierNode, ObserverModifierNode, ModifierLocalModifierNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function2 f25544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function1 f25545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f25546c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f25547d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private FocusStateImpl f25548f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f25549g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f25550h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f25551i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f25553a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f25554b;

        static {
            int[] iArr = new int[CustomDestinationResult.values().length];
            try {
                iArr[CustomDestinationResult.f25435a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CustomDestinationResult.f25437c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CustomDestinationResult.f25436b.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CustomDestinationResult.f25438d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f25553a = iArr;
            int[] iArr2 = new int[FocusStateImpl.values().length];
            try {
                iArr2[FocusStateImpl.f25537a.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[FocusStateImpl.f25539c.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[FocusStateImpl.f25538b.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[FocusStateImpl.f25540d.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            f25554b = iArr2;
        }
    }

    public /* synthetic */ FocusTargetNode(int i3, Function2 function2, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, function2, function1);
    }

    public static /* synthetic */ void B2(FocusTargetNode focusTargetNode, FocusStateImpl focusStateImpl, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            focusStateImpl = null;
        }
        focusTargetNode.A2(focusStateImpl);
    }

    private static final boolean y2(FocusTargetNode focusTargetNode) {
        int iA = NodeKind.a(1024);
        if (!focusTargetNode.getNode().isAttached()) {
            InlineClassHelperKt.c("visitSubtreeIf called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui_release = focusTargetNode.getNode().getChild$ui_release();
        if (child$ui_release == null) {
            DelegatableNodeKt.c(mutableVector, focusTargetNode.getNode(), false);
        } else {
            mutableVector.b(child$ui_release);
        }
        while (mutableVector.o() != 0) {
            Modifier.Node node = (Modifier.Node) mutableVector.u(mutableVector.o() - 1);
            if ((node.getAggregateChildKindSet$ui_release() & iA) != 0) {
                for (Modifier.Node child$ui_release2 = node; child$ui_release2 != null; child$ui_release2 = child$ui_release2.getChild$ui_release()) {
                    if ((child$ui_release2.getKindSet$ui_release() & iA) != 0) {
                        Modifier.Node nodeH = child$ui_release2;
                        MutableVector mutableVector2 = null;
                        while (nodeH != null) {
                            if (nodeH instanceof FocusTargetNode) {
                                FocusTargetNode focusTargetNode2 = (FocusTargetNode) nodeH;
                                if (focusTargetNode2.D2()) {
                                    int i3 = WhenMappings.f25554b[focusTargetNode2.a0().ordinal()];
                                    if (i3 == 1 || i3 == 2 || i3 == 3) {
                                        return true;
                                    }
                                    if (i3 != 4) {
                                        throw new NoWhenBranchMatchedException();
                                    }
                                }
                            } else if ((nodeH.getKindSet$ui_release() & iA) != 0 && (nodeH instanceof DelegatingNode)) {
                                int i4 = 0;
                                for (Modifier.Node nodeN2 = ((DelegatingNode) nodeH).n2(); nodeN2 != null; nodeN2 = nodeN2.getChild$ui_release()) {
                                    if ((nodeN2.getKindSet$ui_release() & iA) != 0) {
                                        i4++;
                                        if (i4 == 1) {
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
                                }
                                if (i4 == 1) {
                                }
                            }
                            nodeH = DelegatableNodeKt.h(mutableVector2);
                        }
                    }
                }
            }
            DelegatableNodeKt.c(mutableVector, node, false);
        }
        return false;
    }

    private static final boolean z2(FocusTargetNode focusTargetNode) {
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
                                if (focusTargetNode2.D2()) {
                                    int i3 = WhenMappings.f25554b[focusTargetNode2.a0().ordinal()];
                                    if (i3 != 1 && i3 != 2) {
                                        if (i3 == 3) {
                                            return true;
                                        }
                                        if (i3 != 4) {
                                            throw new NoWhenBranchMatchedException();
                                        }
                                    }
                                    return false;
                                }
                            } else if ((nodeH.getKindSet$ui_release() & iA) != 0 && (nodeH instanceof DelegatingNode)) {
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
        return false;
    }

    public final void A2(FocusStateImpl focusStateImpl) {
        if (D2()) {
            throw new IllegalStateException("Re-initializing focus target node.");
        }
        if (ComposeUiFlags.f25107g) {
            return;
        }
        FocusTransactionManager focusTransactionManagerC = FocusTargetNodeKt.c(this);
        try {
            if (focusTransactionManagerC.i()) {
                focusTransactionManagerC.f();
            }
            focusTransactionManagerC.e();
            if (focusStateImpl == null) {
                focusStateImpl = (z2(this) && y2(this)) ? FocusStateImpl.f25538b : FocusStateImpl.f25540d;
            }
            E2(focusStateImpl);
            Unit unit = Unit.f139807a;
            focusTransactionManagerC.g();
        } catch (Throwable th) {
            focusTransactionManagerC.g();
            throw th;
        }
    }

    public final void C2() {
        FocusProperties focusProperties = null;
        if (!D2()) {
            B2(this, null, 1, null);
        }
        int i3 = WhenMappings.f25554b[a0().ordinal()];
        if (i3 == 1 || i3 == 2) {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            ObserverModifierNodeKt.a(this, new Function0<Unit>() { // from class: androidx.compose.ui.focus.FocusTargetNode$invalidateFocus$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m215invoke();
                    return Unit.f139807a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m215invoke() {
                    objectRef.f140144a = this.t2();
                }
            });
            Object obj = objectRef.f140144a;
            if (obj == null) {
                Intrinsics.throwUninitializedPropertyAccessException("focusProperties");
            } else {
                focusProperties = (FocusProperties) obj;
            }
            if (focusProperties.v()) {
                return;
            }
            DelegatableNodeKt.p(this).getFocusOwner().v(true);
        }
    }

    public final boolean D2() {
        return ComposeUiFlags.f25107g || this.f25548f != null;
    }

    public void E2(FocusStateImpl focusStateImpl) {
        if (ComposeUiFlags.f25107g) {
            return;
        }
        FocusTargetNodeKt.c(this).k(this, focusStateImpl);
    }

    public final void F2(int i3) {
        this.f25551i = i3;
    }

    @Override // androidx.compose.ui.focus.FocusTargetModifierNode
    public boolean R(int i3) {
        Trace.beginSection("FocusTransactions:requestFocus");
        try {
            boolean zJ = false;
            if (!t2().v()) {
                Trace.endSection();
                return false;
            }
            if (ComposeUiFlags.f25107g) {
                int i4 = WhenMappings.f25553a[FocusTransactionsKt.i(this, i3).ordinal()];
                if (i4 == 1) {
                    zJ = FocusTransactionsKt.j(this);
                } else if (i4 == 2) {
                    zJ = true;
                } else if (i4 != 3 && i4 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                FocusTransactionManager focusTransactionManagerC = FocusTargetNodeKt.c(this);
                Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.ui.focus.FocusTargetNode$requestFocus$1$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m216invoke();
                        return Unit.f139807a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m216invoke() {
                        if (this.f25557a.getNode().isAttached()) {
                            this.f25557a.r2();
                        }
                    }
                };
                try {
                    if (focusTransactionManagerC.i()) {
                        focusTransactionManagerC.f();
                    }
                    focusTransactionManagerC.e();
                    focusTransactionManagerC.f25559b.b(function0);
                    int i5 = WhenMappings.f25553a[FocusTransactionsKt.i(this, i3).ordinal()];
                    if (i5 == 1) {
                        zJ = FocusTransactionsKt.j(this);
                    } else if (i5 == 2) {
                        zJ = true;
                    } else if (i5 != 3 && i5 != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                } finally {
                    focusTransactionManagerC.g();
                }
            }
            return zJ;
        } finally {
            Trace.endSection();
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return this.f25549g;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        if (ComposeUiFlags.f25107g) {
            return;
        }
        FocusTargetNodeKt.b(this);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        int i3 = WhenMappings.f25554b[a0().ordinal()];
        if (i3 == 1 || i3 == 2) {
            FocusOwner focusOwner = DelegatableNodeKt.p(this).getFocusOwner();
            focusOwner.o(true, true, false, FocusDirection.f25444b.c());
            if (ComposeUiFlags.f25107g) {
                focusOwner.j();
            } else {
                FocusTargetNodeKt.b(this);
            }
        } else if (i3 == 3 && !ComposeUiFlags.f25107g) {
            FocusTransactionManager focusTransactionManagerC = FocusTargetNodeKt.c(this);
            try {
                if (focusTransactionManagerC.i()) {
                    focusTransactionManagerC.f();
                }
                focusTransactionManagerC.e();
                E2(FocusStateImpl.f25540d);
                Unit unit = Unit.f139807a;
                focusTransactionManagerC.g();
            } catch (Throwable th) {
                focusTransactionManagerC.g();
                throw th;
            }
        }
        this.f25548f = null;
    }

    public final void q2() {
        FocusStateImpl focusStateImplJ = FocusTargetNodeKt.c(this).j(this);
        if (focusStateImplJ != null) {
            this.f25548f = focusStateImplJ;
        } else {
            InlineClassHelperKt.d("committing a node that was not updated in the current transaction");
            throw new KotlinNothingValueException();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r6v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9, types: [androidx.compose.ui.Modifier$Node] */
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
    /* JADX WARN: Type inference failed for: r9v5 */
    public final void r2() {
        NodeChain nodeChainU0;
        Function2 function2;
        FocusStateImpl focusStateImpl = this.f25548f;
        if (focusStateImpl == null) {
            focusStateImpl = FocusStateImpl.f25540d;
        }
        FocusStateImpl focusStateImplA0 = a0();
        if (focusStateImpl != focusStateImplA0 && (function2 = this.f25544a) != null) {
            function2.invoke(focusStateImpl, focusStateImplA0);
        }
        int iA = NodeKind.a(4096);
        int iA2 = NodeKind.a(1024);
        Modifier.Node node = getNode();
        int i3 = iA | iA2;
        if (!getNode().isAttached()) {
            InlineClassHelperKt.c("visitAncestors called on an unattached node");
        }
        Modifier.Node node2 = getNode();
        LayoutNode layoutNodeO = DelegatableNodeKt.o(this);
        loop0: while (layoutNodeO != null) {
            if ((layoutNodeO.u0().k().getAggregateChildKindSet$ui_release() & i3) != 0) {
                while (node2 != null) {
                    if ((node2.getKindSet$ui_release() & i3) != 0) {
                        if (node2 != node && (node2.getKindSet$ui_release() & iA2) != 0) {
                            break loop0;
                        }
                        if ((node2.getKindSet$ui_release() & iA) != 0) {
                            ?? H = node2;
                            ?? mutableVector = 0;
                            while (H != 0) {
                                if (H instanceof FocusEventModifierNode) {
                                    FocusEventModifierNode focusEventModifierNode = (FocusEventModifierNode) H;
                                    focusEventModifierNode.O(FocusEventModifierNodeKt.a(focusEventModifierNode));
                                } else if ((H.getKindSet$ui_release() & iA) != 0 && (H instanceof DelegatingNode)) {
                                    Modifier.Node nodeN2 = ((DelegatingNode) H).n2();
                                    int i4 = 0;
                                    H = H;
                                    mutableVector = mutableVector;
                                    while (nodeN2 != null) {
                                        if ((nodeN2.getKindSet$ui_release() & iA) != 0) {
                                            i4++;
                                            mutableVector = mutableVector;
                                            if (i4 == 1) {
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
                                    if (i4 == 1) {
                                    }
                                }
                                H = DelegatableNodeKt.h(mutableVector);
                            }
                        }
                    }
                    node2 = node2.getParent$ui_release();
                }
            }
            layoutNodeO = layoutNodeO.B0();
            node2 = (layoutNodeO == null || (nodeChainU0 = layoutNodeO.u0()) == null) ? null : nodeChainU0.p();
        }
        Function1 function1 = this.f25545b;
        if (function1 != null) {
            function1.invoke(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r10v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r13v5 */
    public final void s2(FocusState focusState, FocusState focusState2) {
        NodeChain nodeChainU0;
        Function2 function2;
        FocusOwner focusOwner = DelegatableNodeKt.p(this).getFocusOwner();
        FocusTargetNode focusTargetNodeH = focusOwner.h();
        if (!Intrinsics.areEqual(focusState, focusState2) && (function2 = this.f25544a) != null) {
            function2.invoke(focusState, focusState2);
        }
        int iA = NodeKind.a(4096);
        int iA2 = NodeKind.a(1024);
        Modifier.Node node = getNode();
        int i3 = iA | iA2;
        if (!getNode().isAttached()) {
            InlineClassHelperKt.c("visitAncestors called on an unattached node");
        }
        Modifier.Node node2 = getNode();
        LayoutNode layoutNodeO = DelegatableNodeKt.o(this);
        loop0: while (layoutNodeO != null) {
            if ((layoutNodeO.u0().k().getAggregateChildKindSet$ui_release() & i3) != 0) {
                while (node2 != null) {
                    if ((node2.getKindSet$ui_release() & i3) != 0) {
                        if (node2 != node && (node2.getKindSet$ui_release() & iA2) != 0) {
                            break loop0;
                        }
                        if ((node2.getKindSet$ui_release() & iA) != 0) {
                            ?? H = node2;
                            ?? mutableVector = 0;
                            while (H != 0) {
                                if (H instanceof FocusEventModifierNode) {
                                    FocusEventModifierNode focusEventModifierNode = (FocusEventModifierNode) H;
                                    if (focusTargetNodeH == focusOwner.h()) {
                                        focusEventModifierNode.O(focusState2);
                                    }
                                } else if ((H.getKindSet$ui_release() & iA) != 0 && (H instanceof DelegatingNode)) {
                                    Modifier.Node nodeN2 = ((DelegatingNode) H).n2();
                                    int i4 = 0;
                                    H = H;
                                    mutableVector = mutableVector;
                                    while (nodeN2 != null) {
                                        if ((nodeN2.getKindSet$ui_release() & iA) != 0) {
                                            i4++;
                                            mutableVector = mutableVector;
                                            if (i4 == 1) {
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
                                    if (i4 == 1) {
                                    }
                                }
                                H = DelegatableNodeKt.h(mutableVector);
                            }
                        }
                    }
                    node2 = node2.getParent$ui_release();
                }
            }
            layoutNodeO = layoutNodeO.B0();
            node2 = (layoutNodeO == null || (nodeChainU0 = layoutNodeO.u0()) == null) ? null : nodeChainU0.p();
        }
        Function1 function1 = this.f25545b;
        if (function1 != null) {
            function1.invoke(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r7v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9, types: [androidx.compose.ui.Modifier$Node] */
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
    public final FocusProperties t2() {
        NodeChain nodeChainU0;
        FocusPropertiesImpl focusPropertiesImpl = new FocusPropertiesImpl();
        focusPropertiesImpl.t(Focusability.d(w2(), this));
        int iA = NodeKind.a(2048);
        int iA2 = NodeKind.a(1024);
        Modifier.Node node = getNode();
        int i3 = iA | iA2;
        if (!getNode().isAttached()) {
            InlineClassHelperKt.c("visitAncestors called on an unattached node");
        }
        Modifier.Node node2 = getNode();
        LayoutNode layoutNodeO = DelegatableNodeKt.o(this);
        while (layoutNodeO != null) {
            if ((layoutNodeO.u0().k().getAggregateChildKindSet$ui_release() & i3) != 0) {
                while (node2 != null) {
                    if ((node2.getKindSet$ui_release() & i3) != 0) {
                        if (node2 != node && (node2.getKindSet$ui_release() & iA2) != 0) {
                            return focusPropertiesImpl;
                        }
                        if ((node2.getKindSet$ui_release() & iA) != 0) {
                            ?? H = node2;
                            ?? mutableVector = 0;
                            while (H != 0) {
                                if (H instanceof FocusPropertiesModifierNode) {
                                    ((FocusPropertiesModifierNode) H).i1(focusPropertiesImpl);
                                } else if ((H.getKindSet$ui_release() & iA) != 0 && (H instanceof DelegatingNode)) {
                                    Modifier.Node nodeN2 = ((DelegatingNode) H).n2();
                                    int i4 = 0;
                                    H = H;
                                    mutableVector = mutableVector;
                                    while (nodeN2 != null) {
                                        if ((nodeN2.getKindSet$ui_release() & iA) != 0) {
                                            i4++;
                                            mutableVector = mutableVector;
                                            if (i4 == 1) {
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
                                    if (i4 == 1) {
                                    }
                                }
                                H = DelegatableNodeKt.h(mutableVector);
                            }
                        }
                    }
                    node2 = node2.getParent$ui_release();
                }
            }
            layoutNodeO = layoutNodeO.B0();
            node2 = (layoutNodeO == null || (nodeChainU0 = layoutNodeO.u0()) == null) ? null : nodeChainU0.p();
        }
        return focusPropertiesImpl;
    }

    public final BeyondBoundsLayout u2() {
        return (BeyondBoundsLayout) u(androidx.compose.ui.layout.BeyondBoundsLayoutKt.a());
    }

    @Override // androidx.compose.ui.focus.FocusTargetModifierNode
    /* JADX INFO: renamed from: v2, reason: merged with bridge method [inline-methods] */
    public FocusStateImpl a0() {
        FocusStateImpl focusStateImplJ;
        NodeChain nodeChainU0;
        if (!ComposeUiFlags.f25107g) {
            FocusTransactionManager focusTransactionManagerA = FocusTargetNodeKt.a(this);
            if (focusTransactionManagerA != null && (focusStateImplJ = focusTransactionManagerA.j(this)) != null) {
                return focusStateImplJ;
            }
            FocusStateImpl focusStateImpl = this.f25548f;
            return focusStateImpl == null ? FocusStateImpl.f25540d : focusStateImpl;
        }
        if (!isAttached()) {
            return FocusStateImpl.f25540d;
        }
        FocusOwner focusOwner = DelegatableNodeKt.p(this).getFocusOwner();
        FocusTargetNode focusTargetNodeH = focusOwner.h();
        if (focusTargetNodeH == null) {
            return FocusStateImpl.f25540d;
        }
        if (this == focusTargetNodeH) {
            return focusOwner.n() ? FocusStateImpl.f25539c : FocusStateImpl.f25537a;
        }
        if (focusTargetNodeH.isAttached()) {
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
                            MutableVector mutableVector = null;
                            while (nodeH != null) {
                                if (nodeH instanceof FocusTargetNode) {
                                    if (this == ((FocusTargetNode) nodeH)) {
                                        return FocusStateImpl.f25538b;
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
        }
        return FocusStateImpl.f25540d;
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public void w0() {
        if (ComposeUiFlags.f25107g) {
            C2();
            return;
        }
        FocusStateImpl focusStateImplA0 = a0();
        C2();
        if (focusStateImplA0 != a0()) {
            r2();
        }
    }

    public int w2() {
        return this.f25550h;
    }

    public final int x2() {
        return this.f25551i;
    }

    public /* synthetic */ FocusTargetNode(int i3, Function2 function2, Function1 function1, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? Focusability.f25566b.a() : i3, (i4 & 2) != 0 ? null : function2, (i4 & 4) != 0 ? null : function1, null);
    }

    private FocusTargetNode(int i3, Function2 function2, Function1 function1) {
        this.f25544a = function2;
        this.f25545b = function1;
        this.f25550h = i3;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class FocusTargetElement extends ModifierNodeElement<FocusTargetNode> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final FocusTargetElement f25552a = new FocusTargetElement();

        private FocusTargetElement() {
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public FocusTargetNode create() {
            return new FocusTargetNode(0, null, null, 7, null);
        }

        public boolean equals(Object obj) {
            return obj == this;
        }

        public int hashCode() {
            return 1739042953;
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public void inspectableProperties(InspectorInfo inspectorInfo) {
            inspectorInfo.d("focusTarget");
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void update(FocusTargetNode focusTargetNode) {
        }
    }
}
