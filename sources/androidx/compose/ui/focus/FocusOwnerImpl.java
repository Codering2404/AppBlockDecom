package androidx.compose.ui.focus;

import android.view.KeyEvent;
import androidx.collection.MutableLongSet;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.SoftKeyboardInterceptionModifierNode;
import androidx.compose.ui.input.rotary.RotaryInputModifierNode;
import androidx.compose.ui.input.rotary.RotaryScrollEvent;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.LayoutDirection;
import com.facebook.internal.Utility;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.PropertyReference0Impl;
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
public final class FocusOwnerImpl implements FocusOwner {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function2 f25476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function1 f25477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function0 f25478c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Function0 f25479d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Function0 f25480e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final FocusInvalidationManager f25482g;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private MutableLongSet f25485j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private FocusTargetNode f25487l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f25488m;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private FocusTargetNode f25481f = new FocusTargetNode(Focusability.f25566b.b(), null, null, 6, null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final FocusTransactionManager f25483h = new FocusTransactionManager();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Modifier f25484i = new ModifierNodeElement<FocusTargetNode>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$modifier$1
        @Override // androidx.compose.ui.node.ModifierNodeElement
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public FocusTargetNode create() {
            return this.f25494a.A();
        }

        public boolean equals(Object obj) {
            return obj == this;
        }

        public int hashCode() {
            return this.f25494a.A().hashCode();
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public void inspectableProperties(InspectorInfo inspectorInfo) {
            inspectorInfo.d("RootFocusTarget");
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void update(FocusTargetNode focusTargetNode) {
        }
    };

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final MutableObjectList f25486k = new MutableObjectList(1);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f25489a;

        static {
            int[] iArr = new int[CustomDestinationResult.values().length];
            try {
                iArr[CustomDestinationResult.f25437c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CustomDestinationResult.f25436b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CustomDestinationResult.f25438d.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CustomDestinationResult.f25435a.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f25489a = iArr;
        }
    }

    public FocusOwnerImpl(Function1 function1, Function2 function2, Function1 function12, Function0 function0, Function0 function02, Function0 function03) {
        this.f25476a = function2;
        this.f25477b = function12;
        this.f25478c = function0;
        this.f25479d = function02;
        this.f25480e = function03;
        this.f25482g = new FocusInvalidationManager(function1, new FocusOwnerImpl$focusInvalidationManager$1(this), new PropertyReference0Impl(this) { // from class: androidx.compose.ui.focus.FocusOwnerImpl$focusInvalidationManager$2
            @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((FocusOwnerImpl) this.receiver).p();
            }
        }, new MutablePropertyReference0Impl(this) { // from class: androidx.compose.ui.focus.FocusOwnerImpl$focusInvalidationManager$3
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((FocusOwnerImpl) this.receiver).h();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B() {
        if ((ComposeUiFlags.f25107g && h() == null) || this.f25481f.a0() == FocusStateImpl.f25540d) {
            this.f25478c.invoke();
        }
    }

    private final Modifier.Node C(DelegatableNode delegatableNode) {
        int iA = NodeKind.a(1024) | NodeKind.a(Utility.DEFAULT_STREAM_BUFFER_SIZE);
        if (!delegatableNode.getNode().isAttached()) {
            InlineClassHelperKt.c("visitLocalDescendants called on an unattached node");
        }
        Modifier.Node node = delegatableNode.getNode();
        Modifier.Node node2 = null;
        if ((node.getAggregateChildKindSet$ui_release() & iA) != 0) {
            for (Modifier.Node child$ui_release = node.getChild$ui_release(); child$ui_release != null; child$ui_release = child$ui_release.getChild$ui_release()) {
                if ((child$ui_release.getKindSet$ui_release() & iA) != 0) {
                    if ((NodeKind.a(1024) & child$ui_release.getKindSet$ui_release()) != 0) {
                        return node2;
                    }
                    node2 = child$ui_release;
                }
            }
        }
        return node2;
    }

    private final boolean F(KeyEvent keyEvent) {
        long jA = KeyEvent_androidKt.a(keyEvent);
        int iB = KeyEvent_androidKt.b(keyEvent);
        KeyEventType.Companion companion = KeyEventType.f26731b;
        if (KeyEventType.f(iB, companion.a())) {
            MutableLongSet mutableLongSet = this.f25485j;
            if (mutableLongSet == null) {
                mutableLongSet = new MutableLongSet(3);
                this.f25485j = mutableLongSet;
            }
            mutableLongSet.l(jA);
        } else if (KeyEventType.f(iB, companion.b())) {
            MutableLongSet mutableLongSet2 = this.f25485j;
            if (mutableLongSet2 == null || !mutableLongSet2.a(jA)) {
                return false;
            }
            MutableLongSet mutableLongSet3 = this.f25485j;
            if (mutableLongSet3 != null) {
                mutableLongSet3.m(jA);
            }
        }
        return true;
    }

    private final boolean y(boolean z2, boolean z3) {
        NodeChain nodeChainU0;
        if (h() == null) {
            return true;
        }
        if (n() && !z2) {
            return false;
        }
        FocusTargetNode focusTargetNodeH = h();
        s(null);
        if (z3 && focusTargetNodeH != null) {
            focusTargetNodeH.s2(n() ? FocusStateImpl.f25539c : FocusStateImpl.f25537a, FocusStateImpl.f25540d);
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
                            MutableVector mutableVector = null;
                            Modifier.Node nodeH = parent$ui_release;
                            while (nodeH != null) {
                                if (nodeH instanceof FocusTargetNode) {
                                    ((FocusTargetNode) nodeH).s2(FocusStateImpl.f25538b, FocusStateImpl.f25540d);
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
        return true;
    }

    private final FocusTargetNode z() {
        return FocusTraversalKt.b(this.f25481f);
    }

    public final FocusTargetNode A() {
        return this.f25481f;
    }

    public void D(boolean z2) {
        if (!((z2 && h() == null) ? false : true)) {
            InlineClassHelperKt.a("Cannot capture focus when the active focus target node is unset");
        }
        this.f25488m = z2;
    }

    public boolean E(final int i3, Rect rect) {
        Boolean boolW = w(i3, rect, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$takeFocus$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(FocusTargetNode focusTargetNode) {
                return Boolean.valueOf(focusTargetNode.R(i3));
            }
        });
        if (boolW != null) {
            return boolW.booleanValue();
        }
        return false;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public Modifier a() {
        return this.f25484i;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public MutableObjectList b() {
        return this.f25486k;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void c(FocusEventModifierNode focusEventModifierNode) {
        this.f25482g.g(focusEventModifierNode);
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public FocusTransactionManager d() {
        return this.f25483h;
    }

    @Override // androidx.compose.ui.focus.FocusManager
    public boolean e(final int i3) {
        if (ComposeUiFlags.f25105e && ((Boolean) this.f25477b.invoke(FocusDirection.i(i3))).booleanValue()) {
            return true;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.f140144a = Boolean.FALSE;
        int iH = d().h();
        FocusTargetNode focusTargetNodeH = h();
        Boolean boolW = w(i3, (Rect) this.f25479d.invoke(), new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$moveFocus$focusSearchSuccess$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(FocusTargetNode focusTargetNode) {
                objectRef.f140144a = Boolean.valueOf(focusTargetNode.R(i3));
                Boolean bool = (Boolean) objectRef.f140144a;
                return Boolean.valueOf(bool != null ? bool.booleanValue() : false);
            }
        });
        int iH2 = d().h();
        Boolean bool = Boolean.TRUE;
        if (Intrinsics.areEqual(boolW, bool) && (iH != iH2 || (ComposeUiFlags.f25107g && focusTargetNodeH != h()))) {
            return true;
        }
        if (boolW != null && objectRef.f140144a != null) {
            if (Intrinsics.areEqual(boolW, bool) && Intrinsics.areEqual(objectRef.f140144a, bool)) {
                return true;
            }
            if (FocusOwnerImplKt.a(i3)) {
                return o(false, true, false, i3) && E(i3, null);
            }
            if (!ComposeUiFlags.f25105e && ((Boolean) this.f25477b.invoke(FocusDirection.i(i3))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v18, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v21, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r10v24 */
    /* JADX WARN: Type inference failed for: r10v25 */
    /* JADX WARN: Type inference failed for: r10v26 */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v15, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v24, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v42 */
    /* JADX WARN: Type inference failed for: r2v43 */
    /* JADX WARN: Type inference failed for: r2v44 */
    /* JADX WARN: Type inference failed for: r2v45 */
    /* JADX WARN: Type inference failed for: r2v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v6, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v7, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v22, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r3v29 */
    /* JADX WARN: Type inference failed for: r3v30 */
    /* JADX WARN: Type inference failed for: r3v31 */
    /* JADX WARN: Type inference failed for: r3v32 */
    /* JADX WARN: Type inference failed for: r3v33 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v18, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r9v19, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v22 */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v25 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    @Override // androidx.compose.ui.focus.FocusOwner
    public boolean g(KeyEvent keyEvent) {
        SoftKeyboardInterceptionModifierNode softKeyboardInterceptionModifierNode;
        int size;
        NodeChain nodeChainU0;
        ?? H;
        NodeChain nodeChainU02;
        if (this.f25482g.b()) {
            System.out.println((Object) "FocusRelatedWarning: Dispatching intercepted soft keyboard event while the focus system is invalidated.");
            return false;
        }
        FocusTargetNode focusTargetNodeB = FocusTraversalKt.b(this.f25481f);
        if (focusTargetNodeB != null) {
            int iA = NodeKind.a(131072);
            if (!focusTargetNodeB.getNode().isAttached()) {
                InlineClassHelperKt.c("visitAncestors called on an unattached node");
            }
            Modifier.Node node = focusTargetNodeB.getNode();
            LayoutNode layoutNodeO = DelegatableNodeKt.o(focusTargetNodeB);
            loop0: while (true) {
                if (layoutNodeO == null) {
                    H = 0;
                    break;
                }
                if ((layoutNodeO.u0().k().getAggregateChildKindSet$ui_release() & iA) != 0) {
                    while (node != null) {
                        if ((node.getKindSet$ui_release() & iA) != 0) {
                            ?? mutableVector = 0;
                            H = node;
                            while (H != 0) {
                                if (H instanceof SoftKeyboardInterceptionModifierNode) {
                                    break loop0;
                                }
                                if ((H.getKindSet$ui_release() & iA) != 0 && (H instanceof DelegatingNode)) {
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
                        node = node.getParent$ui_release();
                    }
                }
                layoutNodeO = layoutNodeO.B0();
                node = (layoutNodeO == null || (nodeChainU02 = layoutNodeO.u0()) == null) ? null : nodeChainU02.p();
            }
            softKeyboardInterceptionModifierNode = (SoftKeyboardInterceptionModifierNode) H;
        } else {
            softKeyboardInterceptionModifierNode = null;
        }
        if (softKeyboardInterceptionModifierNode != null) {
            int iA2 = NodeKind.a(131072);
            if (!softKeyboardInterceptionModifierNode.getNode().isAttached()) {
                InlineClassHelperKt.c("visitAncestors called on an unattached node");
            }
            Modifier.Node parent$ui_release = softKeyboardInterceptionModifierNode.getNode().getParent$ui_release();
            LayoutNode layoutNodeO2 = DelegatableNodeKt.o(softKeyboardInterceptionModifierNode);
            ArrayList arrayList = null;
            while (layoutNodeO2 != null) {
                if ((layoutNodeO2.u0().k().getAggregateChildKindSet$ui_release() & iA2) != 0) {
                    while (parent$ui_release != null) {
                        if ((parent$ui_release.getKindSet$ui_release() & iA2) != 0) {
                            Modifier.Node nodeH = parent$ui_release;
                            MutableVector mutableVector2 = null;
                            while (nodeH != null) {
                                if (nodeH instanceof SoftKeyboardInterceptionModifierNode) {
                                    if (arrayList == null) {
                                        arrayList = new ArrayList();
                                    }
                                    arrayList.add(nodeH);
                                } else if ((nodeH.getKindSet$ui_release() & iA2) != 0 && (nodeH instanceof DelegatingNode)) {
                                    int i4 = 0;
                                    for (Modifier.Node nodeN22 = ((DelegatingNode) nodeH).n2(); nodeN22 != null; nodeN22 = nodeN22.getChild$ui_release()) {
                                        if ((nodeN22.getKindSet$ui_release() & iA2) != 0) {
                                            i4++;
                                            if (i4 == 1) {
                                                nodeH = nodeN22;
                                            } else {
                                                if (mutableVector2 == null) {
                                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (nodeH != null) {
                                                    mutableVector2.b(nodeH);
                                                    nodeH = null;
                                                }
                                                mutableVector2.b(nodeN22);
                                            }
                                        }
                                    }
                                    if (i4 == 1) {
                                    }
                                }
                                nodeH = DelegatableNodeKt.h(mutableVector2);
                            }
                        }
                        parent$ui_release = parent$ui_release.getParent$ui_release();
                    }
                }
                layoutNodeO2 = layoutNodeO2.B0();
                parent$ui_release = (layoutNodeO2 == null || (nodeChainU0 = layoutNodeO2.u0()) == null) ? null : nodeChainU0.p();
            }
            if (arrayList != null && arrayList.size() - 1 >= 0) {
                while (true) {
                    int i5 = size - 1;
                    if (((SoftKeyboardInterceptionModifierNode) arrayList.get(size)).X(keyEvent)) {
                        return true;
                    }
                    if (i5 < 0) {
                        break;
                    }
                    size = i5;
                }
            }
            ?? node2 = softKeyboardInterceptionModifierNode.getNode();
            ?? mutableVector3 = 0;
            while (node2 != 0) {
                if (node2 instanceof SoftKeyboardInterceptionModifierNode) {
                    if (((SoftKeyboardInterceptionModifierNode) node2).X(keyEvent)) {
                        return true;
                    }
                } else if ((node2.getKindSet$ui_release() & iA2) != 0 && (node2 instanceof DelegatingNode)) {
                    Modifier.Node nodeN23 = ((DelegatingNode) node2).n2();
                    int i6 = 0;
                    node2 = node2;
                    mutableVector3 = mutableVector3;
                    while (nodeN23 != null) {
                        if ((nodeN23.getKindSet$ui_release() & iA2) != 0) {
                            i6++;
                            mutableVector3 = mutableVector3;
                            if (i6 == 1) {
                                node2 = nodeN23;
                            } else {
                                if (mutableVector3 == 0) {
                                    mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (node2 != 0) {
                                    mutableVector3.b(node2);
                                    node2 = 0;
                                }
                                mutableVector3.b(nodeN23);
                            }
                        }
                        nodeN23 = nodeN23.getChild$ui_release();
                        node2 = node2;
                        mutableVector3 = mutableVector3;
                    }
                    if (i6 == 1) {
                    }
                }
                node2 = DelegatableNodeKt.h(mutableVector3);
            }
            ?? node3 = softKeyboardInterceptionModifierNode.getNode();
            ?? mutableVector4 = 0;
            while (node3 != 0) {
                if (node3 instanceof SoftKeyboardInterceptionModifierNode) {
                    if (((SoftKeyboardInterceptionModifierNode) node3).r0(keyEvent)) {
                        return true;
                    }
                } else if ((node3.getKindSet$ui_release() & iA2) != 0 && (node3 instanceof DelegatingNode)) {
                    Modifier.Node nodeN24 = ((DelegatingNode) node3).n2();
                    int i7 = 0;
                    node3 = node3;
                    mutableVector4 = mutableVector4;
                    while (nodeN24 != null) {
                        if ((nodeN24.getKindSet$ui_release() & iA2) != 0) {
                            i7++;
                            mutableVector4 = mutableVector4;
                            if (i7 == 1) {
                                node3 = nodeN24;
                            } else {
                                if (mutableVector4 == 0) {
                                    mutableVector4 = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (node3 != 0) {
                                    mutableVector4.b(node3);
                                    node3 = 0;
                                }
                                mutableVector4.b(nodeN24);
                            }
                        }
                        nodeN24 = nodeN24.getChild$ui_release();
                        node3 = node3;
                        mutableVector4 = mutableVector4;
                    }
                    if (i7 == 1) {
                    }
                }
                node3 = DelegatableNodeKt.h(mutableVector4);
            }
            if (arrayList != null) {
                int size2 = arrayList.size();
                for (int i8 = 0; i8 < size2; i8++) {
                    if (((SoftKeyboardInterceptionModifierNode) arrayList.get(i8)).r0(keyEvent)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public FocusTargetNode h() {
        return this.f25487l;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void i(FocusTargetNode focusTargetNode) {
        this.f25482g.i(focusTargetNode);
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void j() {
        this.f25482g.j();
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x00e0 A[Catch: all -> 0x001d, TryCatch #0 {all -> 0x001d, blocks: (B:3:0x0009, B:5:0x0012, B:10:0x0020, B:14:0x002a, B:17:0x0038, B:114:0x0188, B:116:0x0196, B:117:0x0199, B:119:0x01a8, B:122:0x01b9, B:126:0x01c4, B:129:0x01ca, B:130:0x01cf, B:150:0x020f, B:131:0x01d3, B:133:0x01da, B:135:0x01de, B:137:0x01e8, B:139:0x01ef, B:143:0x01f7, B:145:0x0200, B:146:0x0204, B:147:0x0207, B:151:0x0214, B:152:0x0219, B:154:0x021f, B:156:0x0225, B:159:0x0230, B:161:0x0238, B:168:0x024f, B:169:0x0251, B:170:0x0261, B:172:0x0265, B:174:0x0269, B:201:0x02c6, B:178:0x0275, B:180:0x027e, B:182:0x0284, B:184:0x028d, B:186:0x0294, B:188:0x0298, B:189:0x029b, B:191:0x02a1, B:192:0x02a8, B:194:0x02b0, B:195:0x02b5, B:197:0x02bb, B:198:0x02be, B:202:0x02d1, B:206:0x02e1, B:207:0x02f1, B:209:0x02f5, B:211:0x02f9, B:238:0x0356, B:215:0x0305, B:217:0x030e, B:219:0x0314, B:221:0x031d, B:223:0x0324, B:225:0x0328, B:226:0x032b, B:228:0x0331, B:229:0x0338, B:231:0x0340, B:232:0x0345, B:234:0x034b, B:235:0x034e, B:240:0x0363, B:242:0x036a, B:247:0x037d, B:248:0x037f, B:20:0x0040, B:22:0x004e, B:23:0x0051, B:25:0x005b, B:28:0x006c, B:32:0x0077, B:63:0x00d6, B:65:0x00da, B:35:0x007c, B:37:0x0083, B:39:0x0087, B:41:0x0091, B:43:0x0098, B:47:0x00a0, B:49:0x00a9, B:50:0x00ad, B:51:0x00b0, B:54:0x00b8, B:55:0x00bd, B:56:0x00c2, B:58:0x00c8, B:60:0x00ce, B:66:0x00e0, B:68:0x00f0, B:69:0x00f3, B:71:0x0101, B:74:0x0112, B:78:0x011d, B:109:0x017c, B:111:0x0180, B:81:0x0122, B:83:0x0129, B:85:0x012d, B:87:0x0137, B:89:0x013e, B:93:0x0146, B:95:0x014f, B:96:0x0153, B:97:0x0156, B:100:0x015e, B:101:0x0163, B:102:0x0168, B:104:0x016e, B:106:0x0174), top: B:253:0x0009 }] */
    @Override // androidx.compose.ui.focus.FocusOwner
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean k(android.view.KeyEvent r17, kotlin.jvm.functions.Function0 r18) {
        /*
            Method dump skipped, instruction units count: 905
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusOwnerImpl.k(android.view.KeyEvent, kotlin.jvm.functions.Function0):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v16, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v18, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r11v19, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX WARN: Type inference failed for: r11v22 */
    /* JADX WARN: Type inference failed for: r11v23 */
    /* JADX WARN: Type inference failed for: r11v24 */
    /* JADX WARN: Type inference failed for: r11v25 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v17 */
    /* JADX WARN: Type inference failed for: r12v18, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r12v19 */
    /* JADX WARN: Type inference failed for: r12v20 */
    /* JADX WARN: Type inference failed for: r12v21, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r12v23 */
    /* JADX WARN: Type inference failed for: r12v24 */
    /* JADX WARN: Type inference failed for: r12v25 */
    /* JADX WARN: Type inference failed for: r12v26 */
    /* JADX WARN: Type inference failed for: r13v16 */
    /* JADX WARN: Type inference failed for: r4v10, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v18, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v26, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v27, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v28 */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r4v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v45 */
    /* JADX WARN: Type inference failed for: r4v46 */
    /* JADX WARN: Type inference failed for: r4v47 */
    /* JADX WARN: Type inference failed for: r4v48 */
    /* JADX WARN: Type inference failed for: r4v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v9, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v19, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v22, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v30 */
    /* JADX WARN: Type inference failed for: r5v31 */
    /* JADX WARN: Type inference failed for: r5v32 */
    /* JADX WARN: Type inference failed for: r5v33 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    @Override // androidx.compose.ui.focus.FocusOwner
    public boolean l(RotaryScrollEvent rotaryScrollEvent, Function0 function0) {
        RotaryInputModifierNode rotaryInputModifierNode;
        int size;
        NodeChain nodeChainU0;
        ?? H;
        NodeChain nodeChainU02;
        if (this.f25482g.b()) {
            System.out.println((Object) "FocusRelatedWarning: Dispatching rotary event while the focus system is invalidated.");
            return false;
        }
        FocusTargetNode focusTargetNodeZ = z();
        if (focusTargetNodeZ != null) {
            int iA = NodeKind.a(16384);
            if (!focusTargetNodeZ.getNode().isAttached()) {
                InlineClassHelperKt.c("visitAncestors called on an unattached node");
            }
            Modifier.Node node = focusTargetNodeZ.getNode();
            LayoutNode layoutNodeO = DelegatableNodeKt.o(focusTargetNodeZ);
            loop0: while (true) {
                if (layoutNodeO == null) {
                    H = 0;
                    break;
                }
                if ((layoutNodeO.u0().k().getAggregateChildKindSet$ui_release() & iA) != 0) {
                    while (node != null) {
                        if ((node.getKindSet$ui_release() & iA) != 0) {
                            ?? mutableVector = 0;
                            H = node;
                            while (H != 0) {
                                if (H instanceof RotaryInputModifierNode) {
                                    break loop0;
                                }
                                if ((H.getKindSet$ui_release() & iA) != 0 && (H instanceof DelegatingNode)) {
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
                        node = node.getParent$ui_release();
                    }
                }
                layoutNodeO = layoutNodeO.B0();
                node = (layoutNodeO == null || (nodeChainU02 = layoutNodeO.u0()) == null) ? null : nodeChainU02.p();
            }
            rotaryInputModifierNode = (RotaryInputModifierNode) H;
        } else {
            rotaryInputModifierNode = null;
        }
        if (rotaryInputModifierNode != null) {
            int iA2 = NodeKind.a(16384);
            if (!rotaryInputModifierNode.getNode().isAttached()) {
                InlineClassHelperKt.c("visitAncestors called on an unattached node");
            }
            Modifier.Node parent$ui_release = rotaryInputModifierNode.getNode().getParent$ui_release();
            LayoutNode layoutNodeO2 = DelegatableNodeKt.o(rotaryInputModifierNode);
            ArrayList arrayList = null;
            while (layoutNodeO2 != null) {
                if ((layoutNodeO2.u0().k().getAggregateChildKindSet$ui_release() & iA2) != 0) {
                    while (parent$ui_release != null) {
                        if ((parent$ui_release.getKindSet$ui_release() & iA2) != 0) {
                            Modifier.Node nodeH = parent$ui_release;
                            MutableVector mutableVector2 = null;
                            while (nodeH != null) {
                                if (nodeH instanceof RotaryInputModifierNode) {
                                    if (arrayList == null) {
                                        arrayList = new ArrayList();
                                    }
                                    arrayList.add(nodeH);
                                } else if ((nodeH.getKindSet$ui_release() & iA2) != 0 && (nodeH instanceof DelegatingNode)) {
                                    int i4 = 0;
                                    for (Modifier.Node nodeN22 = ((DelegatingNode) nodeH).n2(); nodeN22 != null; nodeN22 = nodeN22.getChild$ui_release()) {
                                        if ((nodeN22.getKindSet$ui_release() & iA2) != 0) {
                                            i4++;
                                            if (i4 == 1) {
                                                nodeH = nodeN22;
                                            } else {
                                                if (mutableVector2 == null) {
                                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (nodeH != null) {
                                                    mutableVector2.b(nodeH);
                                                    nodeH = null;
                                                }
                                                mutableVector2.b(nodeN22);
                                            }
                                        }
                                    }
                                    if (i4 == 1) {
                                    }
                                }
                                nodeH = DelegatableNodeKt.h(mutableVector2);
                            }
                        }
                        parent$ui_release = parent$ui_release.getParent$ui_release();
                    }
                }
                layoutNodeO2 = layoutNodeO2.B0();
                parent$ui_release = (layoutNodeO2 == null || (nodeChainU0 = layoutNodeO2.u0()) == null) ? null : nodeChainU0.p();
            }
            if (arrayList != null && arrayList.size() - 1 >= 0) {
                while (true) {
                    int i5 = size - 1;
                    if (((RotaryInputModifierNode) arrayList.get(size)).f0(rotaryScrollEvent)) {
                        return true;
                    }
                    if (i5 < 0) {
                        break;
                    }
                    size = i5;
                }
            }
            ?? node2 = rotaryInputModifierNode.getNode();
            ?? mutableVector3 = 0;
            while (node2 != 0) {
                if (node2 instanceof RotaryInputModifierNode) {
                    if (((RotaryInputModifierNode) node2).f0(rotaryScrollEvent)) {
                        return true;
                    }
                } else if ((node2.getKindSet$ui_release() & iA2) != 0 && (node2 instanceof DelegatingNode)) {
                    Modifier.Node nodeN23 = ((DelegatingNode) node2).n2();
                    int i6 = 0;
                    node2 = node2;
                    mutableVector3 = mutableVector3;
                    while (nodeN23 != null) {
                        if ((nodeN23.getKindSet$ui_release() & iA2) != 0) {
                            i6++;
                            mutableVector3 = mutableVector3;
                            if (i6 == 1) {
                                node2 = nodeN23;
                            } else {
                                if (mutableVector3 == 0) {
                                    mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (node2 != 0) {
                                    mutableVector3.b(node2);
                                    node2 = 0;
                                }
                                mutableVector3.b(nodeN23);
                            }
                        }
                        nodeN23 = nodeN23.getChild$ui_release();
                        node2 = node2;
                        mutableVector3 = mutableVector3;
                    }
                    if (i6 == 1) {
                    }
                }
                node2 = DelegatableNodeKt.h(mutableVector3);
            }
            if (((Boolean) function0.invoke()).booleanValue()) {
                return true;
            }
            ?? node3 = rotaryInputModifierNode.getNode();
            ?? mutableVector4 = 0;
            while (node3 != 0) {
                if (node3 instanceof RotaryInputModifierNode) {
                    if (((RotaryInputModifierNode) node3).q1(rotaryScrollEvent)) {
                        return true;
                    }
                } else if ((node3.getKindSet$ui_release() & iA2) != 0 && (node3 instanceof DelegatingNode)) {
                    Modifier.Node nodeN24 = ((DelegatingNode) node3).n2();
                    int i7 = 0;
                    node3 = node3;
                    mutableVector4 = mutableVector4;
                    while (nodeN24 != null) {
                        if ((nodeN24.getKindSet$ui_release() & iA2) != 0) {
                            i7++;
                            mutableVector4 = mutableVector4;
                            if (i7 == 1) {
                                node3 = nodeN24;
                            } else {
                                if (mutableVector4 == 0) {
                                    mutableVector4 = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (node3 != 0) {
                                    mutableVector4.b(node3);
                                    node3 = 0;
                                }
                                mutableVector4.b(nodeN24);
                            }
                        }
                        nodeN24 = nodeN24.getChild$ui_release();
                        node3 = node3;
                        mutableVector4 = mutableVector4;
                    }
                    if (i7 == 1) {
                    }
                }
                node3 = DelegatableNodeKt.h(mutableVector4);
            }
            if (arrayList != null) {
                int size2 = arrayList.size();
                for (int i8 = 0; i8 < size2; i8++) {
                    if (((RotaryInputModifierNode) arrayList.get(i8)).q1(rotaryScrollEvent)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public boolean n() {
        return this.f25488m;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0065 A[Catch: all -> 0x0041, TRY_LEAVE, TryCatch #0 {all -> 0x0041, blocks: (B:16:0x0037, B:18:0x003d, B:21:0x0043, B:23:0x0048, B:25:0x0051, B:29:0x0065), top: B:37:0x0037 }] */
    @Override // androidx.compose.ui.focus.FocusOwner
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean o(boolean r8, boolean r9, boolean r10, int r11) {
        /*
            r7 = this;
            boolean r0 = androidx.compose.ui.ComposeUiFlags.f25107g
            r1 = 0
            r2 = 3
            r3 = 2
            r4 = 1
            if (r0 == 0) goto L31
            if (r8 != 0) goto L2c
            androidx.compose.ui.focus.FocusTargetNode r0 = r7.f25481f
            androidx.compose.ui.focus.CustomDestinationResult r11 = androidx.compose.ui.focus.FocusTransactionsKt.f(r0, r11)
            int[] r0 = androidx.compose.ui.focus.FocusOwnerImpl.WhenMappings.f25489a
            int r11 = r11.ordinal()
            r11 = r0[r11]
            if (r11 == r4) goto L6e
            if (r11 == r3) goto L6e
            if (r11 == r2) goto L6e
            r0 = 4
            if (r11 != r0) goto L26
            boolean r1 = r7.y(r8, r9)
            goto L6e
        L26:
            kotlin.NoWhenBranchMatchedException r8 = new kotlin.NoWhenBranchMatchedException
            r8.<init>()
            throw r8
        L2c:
            boolean r1 = r7.y(r8, r9)
            goto L6e
        L31:
            androidx.compose.ui.focus.FocusTransactionManager r0 = r7.d()
            androidx.compose.ui.focus.FocusOwnerImpl$clearFocus$clearedFocusSuccessfully$1 r5 = new kotlin.jvm.functions.Function0<kotlin.Unit>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$clearFocus$clearedFocusSuccessfully$1
                static {
                    /*
                        androidx.compose.ui.focus.FocusOwnerImpl$clearFocus$clearedFocusSuccessfully$1 r0 = new androidx.compose.ui.focus.FocusOwnerImpl$clearFocus$clearedFocusSuccessfully$1
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:androidx.compose.ui.focus.FocusOwnerImpl$clearFocus$clearedFocusSuccessfully$1) androidx.compose.ui.focus.FocusOwnerImpl$clearFocus$clearedFocusSuccessfully$1.a androidx.compose.ui.focus.FocusOwnerImpl$clearFocus$clearedFocusSuccessfully$1
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusOwnerImpl$clearFocus$clearedFocusSuccessfully$1.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusOwnerImpl$clearFocus$clearedFocusSuccessfully$1.<init>():void");
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m213invoke() {
                    /*
                        r0 = this;
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusOwnerImpl$clearFocus$clearedFocusSuccessfully$1.m213invoke():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ java.lang.Object invoke() {
                    /*
                        r1 = this;
                        r1.m213invoke()
                        kotlin.Unit r0 = kotlin.Unit.f139807a
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusOwnerImpl$clearFocus$clearedFocusSuccessfully$1.invoke():java.lang.Object");
                }
            }
            boolean r6 = r0.i()     // Catch: java.lang.Throwable -> L41
            if (r6 == 0) goto L43
            androidx.compose.ui.focus.FocusTransactionManager.b(r0)     // Catch: java.lang.Throwable -> L41
            goto L43
        L41:
            r8 = move-exception
            goto L78
        L43:
            androidx.compose.ui.focus.FocusTransactionManager.a(r0)     // Catch: java.lang.Throwable -> L41
            if (r5 == 0) goto L4f
            androidx.compose.runtime.collection.MutableVector r6 = androidx.compose.ui.focus.FocusTransactionManager.d(r0)     // Catch: java.lang.Throwable -> L41
            r6.b(r5)     // Catch: java.lang.Throwable -> L41
        L4f:
            if (r8 != 0) goto L65
            androidx.compose.ui.focus.FocusTargetNode r5 = r7.f25481f     // Catch: java.lang.Throwable -> L41
            androidx.compose.ui.focus.CustomDestinationResult r11 = androidx.compose.ui.focus.FocusTransactionsKt.f(r5, r11)     // Catch: java.lang.Throwable -> L41
            int[] r5 = androidx.compose.ui.focus.FocusOwnerImpl.WhenMappings.f25489a     // Catch: java.lang.Throwable -> L41
            int r11 = r11.ordinal()     // Catch: java.lang.Throwable -> L41
            r11 = r5[r11]     // Catch: java.lang.Throwable -> L41
            if (r11 == r4) goto L6b
            if (r11 == r3) goto L6b
            if (r11 == r2) goto L6b
        L65:
            androidx.compose.ui.focus.FocusTargetNode r11 = r7.f25481f     // Catch: java.lang.Throwable -> L41
            boolean r1 = androidx.compose.ui.focus.FocusTransactionsKt.c(r11, r8, r9)     // Catch: java.lang.Throwable -> L41
        L6b:
            androidx.compose.ui.focus.FocusTransactionManager.c(r0)
        L6e:
            if (r1 == 0) goto L77
            if (r10 == 0) goto L77
            kotlin.jvm.functions.Function0 r8 = r7.f25478c
            r8.invoke()
        L77:
            return r1
        L78:
            androidx.compose.ui.focus.FocusTransactionManager.c(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusOwnerImpl.o(boolean, boolean, boolean, int):boolean");
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public FocusState p() {
        return this.f25481f.a0();
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void q(FocusPropertiesModifierNode focusPropertiesModifierNode) {
        this.f25482g.h(focusPropertiesModifierNode);
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public Rect r() {
        FocusTargetNode focusTargetNodeZ = z();
        if (focusTargetNodeZ != null) {
            return FocusTraversalKt.d(focusTargetNodeZ);
        }
        return null;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void s(FocusTargetNode focusTargetNode) {
        FocusTargetNode focusTargetNode2 = this.f25487l;
        this.f25487l = focusTargetNode;
        if (focusTargetNode == null || focusTargetNode2 != focusTargetNode) {
            D(false);
        }
        if (ComposeUiFlags.f25104d) {
            MutableObjectList mutableObjectListB = b();
            Object[] objArr = mutableObjectListB.f3081a;
            int i3 = mutableObjectListB.f3082b;
            for (int i4 = 0; i4 < i3; i4++) {
                ((FocusListener) objArr[i4]).a(focusTargetNode2, focusTargetNode);
            }
        }
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void t() {
        if (ComposeUiFlags.f25107g) {
            FocusTransactionsKt.c(this.f25481f, true, true);
            return;
        }
        FocusTransactionManager focusTransactionManagerD = d();
        if (focusTransactionManagerD.i()) {
            FocusTransactionsKt.c(this.f25481f, true, true);
            return;
        }
        try {
            focusTransactionManagerD.e();
            FocusTransactionsKt.c(this.f25481f, true, true);
        } finally {
            focusTransactionManagerD.g();
        }
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public boolean u(FocusDirection focusDirection, Rect rect) {
        return ((Boolean) this.f25476a.invoke(focusDirection, rect)).booleanValue();
    }

    @Override // androidx.compose.ui.focus.FocusManager
    public void v(boolean z2) {
        o(z2, true, true, FocusDirection.f25444b.c());
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public Boolean w(int i3, Rect rect, final Function1 function1) {
        final FocusTargetNode focusTargetNodeZ = z();
        if (focusTargetNodeZ != null) {
            FocusRequester focusRequesterA = FocusTraversalKt.a(focusTargetNodeZ, i3, (LayoutDirection) this.f25480e.invoke());
            FocusRequester.Companion companion = FocusRequester.f25519b;
            if (Intrinsics.areEqual(focusRequesterA, companion.a())) {
                return null;
            }
            if (Intrinsics.areEqual(focusRequesterA, companion.c())) {
                FocusTargetNode focusTargetNodeZ2 = z();
                if (focusTargetNodeZ2 != null) {
                    return (Boolean) function1.invoke(focusTargetNodeZ2);
                }
                return null;
            }
            if (!Intrinsics.areEqual(focusRequesterA, companion.b())) {
                return Boolean.valueOf(focusRequesterA.d(function1));
            }
        } else {
            focusTargetNodeZ = null;
        }
        return FocusTraversalKt.e(this.f25481f, i3, (LayoutDirection) this.f25480e.invoke(), rect, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$focusSearch$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(FocusTargetNode focusTargetNode) {
                boolean zBooleanValue;
                if (Intrinsics.areEqual(focusTargetNode, focusTargetNodeZ)) {
                    zBooleanValue = false;
                } else {
                    if (Intrinsics.areEqual(focusTargetNode, this.A())) {
                        throw new IllegalStateException("Focus search landed at the root.");
                    }
                    zBooleanValue = ((Boolean) function1.invoke(focusTargetNode)).booleanValue();
                }
                return Boolean.valueOf(zBooleanValue);
            }
        });
    }
}
