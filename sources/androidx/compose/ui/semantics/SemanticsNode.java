package androidx.compose.ui.semantics;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LayoutInfo;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.unit.IntSize;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

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
public final class SemanticsNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Modifier.Node f28503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f28504b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LayoutNode f28505c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SemanticsConfiguration f28506d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f28507e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private SemanticsNode f28508f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f28509g;

    public SemanticsNode(Modifier.Node node, boolean z2, LayoutNode layoutNode, SemanticsConfiguration semanticsConfiguration) {
        this.f28503a = node;
        this.f28504b = z2;
        this.f28505c = layoutNode;
        this.f28506d = semanticsConfiguration;
        this.f28509g = layoutNode.v();
    }

    private final void B(List list, SemanticsConfiguration semanticsConfiguration) {
        if (this.f28506d.o()) {
            return;
        }
        D(this, list, false, false, 6, null);
        int size = list.size();
        for (int size2 = list.size(); size2 < size; size2++) {
            SemanticsNode semanticsNode = (SemanticsNode) list.get(size2);
            if (!semanticsNode.y()) {
                semanticsConfiguration.q(semanticsNode.f28506d);
                semanticsNode.B(list, semanticsConfiguration);
            }
        }
    }

    public static /* synthetic */ List D(SemanticsNode semanticsNode, List list, boolean z2, boolean z3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = new ArrayList();
        }
        if ((i3 & 2) != 0) {
            z2 = false;
        }
        if ((i3 & 4) != 0) {
            z3 = false;
        }
        return semanticsNode.C(list, z2, z3);
    }

    private final void b(List list) {
        final Role roleG = SemanticsNodeKt.g(this);
        if (roleG != null && this.f28506d.p() && !list.isEmpty()) {
            list.add(c(roleG, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.ui.semantics.SemanticsNode$emitFakeNodes$fakeNode$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((SemanticsPropertyReceiver) obj);
                    return Unit.f139807a;
                }

                public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    SemanticsPropertiesKt.r0(semanticsPropertyReceiver, roleG.p());
                }
            }));
        }
        SemanticsConfiguration semanticsConfiguration = this.f28506d;
        SemanticsProperties semanticsProperties = SemanticsProperties.f28517a;
        if (semanticsConfiguration.d(semanticsProperties.d()) && !list.isEmpty() && this.f28506d.p()) {
            List list2 = (List) SemanticsConfigurationKt.a(this.f28506d, semanticsProperties.d());
            final String str = list2 != null ? (String) CollectionsKt.firstOrNull(list2) : null;
            if (str != null) {
                list.add(0, c(null, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.ui.semantics.SemanticsNode$emitFakeNodes$fakeNode$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((SemanticsPropertyReceiver) obj);
                        return Unit.f139807a;
                    }

                    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertiesKt.d0(semanticsPropertyReceiver, str);
                    }
                }));
            }
        }
    }

    private final SemanticsNode c(Role role, Function1 function1) {
        SemanticsConfiguration semanticsConfiguration = new SemanticsConfiguration();
        semanticsConfiguration.t(false);
        semanticsConfiguration.s(false);
        function1.invoke(semanticsConfiguration);
        SemanticsNode semanticsNode = new SemanticsNode(new SemanticsNode$fakeSemanticsNode$fakeNode$1(function1), false, new LayoutNode(true, role != null ? SemanticsNodeKt.h(this) : SemanticsNodeKt.e(this)), semanticsConfiguration);
        semanticsNode.f28507e = true;
        semanticsNode.f28508f = this;
        return semanticsNode;
    }

    private final void d(LayoutNode layoutNode, List list, boolean z2) {
        MutableVector mutableVectorG0 = layoutNode.G0();
        Object[] objArr = mutableVectorG0.f24389a;
        int iO = mutableVectorG0.o();
        for (int i3 = 0; i3 < iO; i3++) {
            LayoutNode layoutNode2 = (LayoutNode) objArr[i3];
            if (layoutNode2.m() && (z2 || !layoutNode2.y())) {
                if (layoutNode2.u0().q(NodeKind.a(8))) {
                    list.add(SemanticsNodeKt.a(layoutNode2, this.f28504b));
                } else {
                    d(layoutNode2, list, z2);
                }
            }
        }
    }

    private final List f(List list, List list2) {
        D(this, list, false, false, 6, null);
        int size = list.size();
        for (int size2 = list.size(); size2 < size; size2++) {
            SemanticsNode semanticsNode = (SemanticsNode) list.get(size2);
            if (semanticsNode.y()) {
                list2.add(semanticsNode);
            } else if (!semanticsNode.f28506d.o()) {
                semanticsNode.f(list, list2);
            }
        }
        return list2;
    }

    static /* synthetic */ List g(SemanticsNode semanticsNode, List list, List list2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            list2 = new ArrayList();
        }
        return semanticsNode.f(list, list2);
    }

    public static /* synthetic */ List m(SemanticsNode semanticsNode, boolean z2, boolean z3, boolean z4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = !semanticsNode.f28504b;
        }
        if ((i3 & 2) != 0) {
            z3 = false;
        }
        if ((i3 & 4) != 0) {
            z4 = false;
        }
        return semanticsNode.l(z2, z3, z4);
    }

    private final boolean y() {
        return this.f28504b && this.f28506d.p();
    }

    public final boolean A() {
        if (this.f28507e || !t().isEmpty()) {
            return false;
        }
        LayoutNode layoutNodeB0 = this.f28505c.B0();
        while (true) {
            if (layoutNodeB0 == null) {
                layoutNodeB0 = null;
                break;
            }
            SemanticsConfiguration semanticsConfigurationQ = layoutNodeB0.Q();
            if (semanticsConfigurationQ != null && semanticsConfigurationQ.p()) {
                break;
            }
            layoutNodeB0 = layoutNodeB0.B0();
        }
        return layoutNodeB0 == null;
    }

    public final List C(List list, boolean z2, boolean z3) {
        if (this.f28507e) {
            return CollectionsKt.emptyList();
        }
        d(this.f28505c, list, z3);
        if (z2) {
            b(list);
        }
        return list;
    }

    public final SemanticsNode a() {
        return new SemanticsNode(this.f28503a, true, this.f28505c, this.f28506d);
    }

    public final NodeCoordinator e() {
        if (this.f28507e) {
            SemanticsNode semanticsNodeR = r();
            if (semanticsNodeR != null) {
                return semanticsNodeR.e();
            }
            return null;
        }
        DelegatableNode delegatableNodeF = SemanticsNodeKt.f(this.f28505c);
        if (delegatableNodeF == null) {
            delegatableNodeF = this.f28503a;
        }
        return DelegatableNodeKt.j(delegatableNodeF, NodeKind.a(8));
    }

    public final Rect h() {
        LayoutCoordinates layoutCoordinatesU1;
        SemanticsNode semanticsNodeR = r();
        if (semanticsNodeR == null) {
            return Rect.f25601e.a();
        }
        NodeCoordinator nodeCoordinatorE = e();
        if (nodeCoordinatorE != null) {
            if (!nodeCoordinatorE.m()) {
                nodeCoordinatorE = null;
            }
            if (nodeCoordinatorE != null && (layoutCoordinatesU1 = nodeCoordinatorE.u1()) != null) {
                return LayoutCoordinates.R(DelegatableNodeKt.j(semanticsNodeR.f28503a, NodeKind.a(8)), layoutCoordinatesU1, false, 2, null);
            }
        }
        return Rect.f25601e.a();
    }

    public final Rect i() {
        Rect rectB;
        NodeCoordinator nodeCoordinatorE = e();
        if (nodeCoordinatorE != null) {
            if (!nodeCoordinatorE.m()) {
                nodeCoordinatorE = null;
            }
            if (nodeCoordinatorE != null && (rectB = LayoutCoordinatesKt.b(nodeCoordinatorE)) != null) {
                return rectB;
            }
        }
        return Rect.f25601e.a();
    }

    public final Rect j() {
        Rect rectC;
        NodeCoordinator nodeCoordinatorE = e();
        if (nodeCoordinatorE != null) {
            if (!nodeCoordinatorE.m()) {
                nodeCoordinatorE = null;
            }
            if (nodeCoordinatorE != null && (rectC = LayoutCoordinatesKt.c(nodeCoordinatorE)) != null) {
                return rectC;
            }
        }
        return Rect.f25601e.a();
    }

    public final List k() {
        return m(this, false, false, false, 7, null);
    }

    public final List l(boolean z2, boolean z3, boolean z4) {
        if (!z2 && this.f28506d.o()) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        return y() ? g(this, arrayList, null, 2, null) : C(arrayList, z3, z4);
    }

    public final SemanticsConfiguration n() {
        if (!y()) {
            return this.f28506d;
        }
        SemanticsConfiguration semanticsConfigurationF = this.f28506d.f();
        B(new ArrayList(), semanticsConfigurationF);
        return semanticsConfigurationF;
    }

    public final int o() {
        return this.f28509g;
    }

    public final LayoutInfo p() {
        return this.f28505c;
    }

    public final LayoutNode q() {
        return this.f28505c;
    }

    public final SemanticsNode r() {
        LayoutNode layoutNodeB0;
        SemanticsNode semanticsNode = this.f28508f;
        if (semanticsNode != null) {
            return semanticsNode;
        }
        if (this.f28504b) {
            layoutNodeB0 = this.f28505c.B0();
            while (layoutNodeB0 != null) {
                SemanticsConfiguration semanticsConfigurationQ = layoutNodeB0.Q();
                if (semanticsConfigurationQ != null && semanticsConfigurationQ.p()) {
                    break;
                }
                layoutNodeB0 = layoutNodeB0.B0();
            }
            layoutNodeB0 = null;
        } else {
            layoutNodeB0 = null;
        }
        if (layoutNodeB0 == null) {
            layoutNodeB0 = this.f28505c.B0();
            while (true) {
                if (layoutNodeB0 == null) {
                    layoutNodeB0 = null;
                    break;
                }
                if (layoutNodeB0.u0().q(NodeKind.a(8))) {
                    break;
                }
                layoutNodeB0 = layoutNodeB0.B0();
            }
        }
        if (layoutNodeB0 == null) {
            return null;
        }
        return SemanticsNodeKt.a(layoutNodeB0, this.f28504b);
    }

    public final long s() {
        NodeCoordinator nodeCoordinatorE = e();
        if (nodeCoordinatorE != null) {
            if (!nodeCoordinatorE.m()) {
                nodeCoordinatorE = null;
            }
            if (nodeCoordinatorE != null) {
                return LayoutCoordinatesKt.f(nodeCoordinatorE);
            }
        }
        return Offset.f25596b.c();
    }

    public final List t() {
        return m(this, false, true, false, 4, null);
    }

    public final long u() {
        NodeCoordinator nodeCoordinatorE = e();
        return nodeCoordinatorE != null ? nodeCoordinatorE.a() : IntSize.f29998b.a();
    }

    public final Rect v() {
        DelegatableNode delegatableNodeF;
        if (!this.f28506d.p() || (delegatableNodeF = SemanticsNodeKt.f(this.f28505c)) == null) {
            delegatableNodeF = this.f28503a;
        }
        return SemanticsModifierNodeKt.c(delegatableNodeF.getNode(), SemanticsModifierNodeKt.a(this.f28506d));
    }

    public final SemanticsConfiguration w() {
        return this.f28506d;
    }

    public final boolean x() {
        return this.f28507e;
    }

    public final boolean z() {
        NodeCoordinator nodeCoordinatorE = e();
        if (nodeCoordinatorE != null) {
            return nodeCoordinatorE.k3();
        }
        return false;
    }
}
