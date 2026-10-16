package androidx.compose.ui.focus;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class FocusInvalidationManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function1 f25459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function0 f25460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function0 f25461c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Function0 f25462d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final MutableScatterSet f25463e = ScatterSetKt.a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final MutableScatterSet f25464f = ScatterSetKt.a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List f25465g = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List f25466h = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List f25467i = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final List f25468j = new ArrayList();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f25469k;

    public FocusInvalidationManager(Function1 function1, Function0 function0, Function0 function02, Function0 function03) {
        this.f25459a = function1;
        this.f25460b = function0;
        this.f25461c = function02;
        this.f25462d = function03;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c() {
        if (ComposeUiFlags.f25107g) {
            e();
        } else {
            d();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v12 */
    /* JADX WARN: Type inference failed for: r15v13 */
    /* JADX WARN: Type inference failed for: r15v17 */
    /* JADX WARN: Type inference failed for: r15v18 */
    /* JADX WARN: Type inference failed for: r15v19 */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v20 */
    /* JADX WARN: Type inference failed for: r15v21 */
    /* JADX WARN: Type inference failed for: r15v22 */
    /* JADX WARN: Type inference failed for: r15v23 */
    /* JADX WARN: Type inference failed for: r15v24 */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r15v9 */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v10 */
    /* JADX WARN: Type inference failed for: r16v11 */
    /* JADX WARN: Type inference failed for: r16v12 */
    /* JADX WARN: Type inference failed for: r16v13 */
    /* JADX WARN: Type inference failed for: r16v14 */
    /* JADX WARN: Type inference failed for: r16v15 */
    /* JADX WARN: Type inference failed for: r16v16 */
    /* JADX WARN: Type inference failed for: r16v17 */
    /* JADX WARN: Type inference failed for: r16v18 */
    /* JADX WARN: Type inference failed for: r16v19 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v20 */
    /* JADX WARN: Type inference failed for: r16v21 */
    /* JADX WARN: Type inference failed for: r16v3 */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r16v5 */
    /* JADX WARN: Type inference failed for: r16v6 */
    /* JADX WARN: Type inference failed for: r16v7 */
    /* JADX WARN: Type inference failed for: r16v8 */
    /* JADX WARN: Type inference failed for: r16v9 */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Type inference failed for: r7v28 */
    /* JADX WARN: Type inference failed for: r7v29 */
    /* JADX WARN: Type inference failed for: r7v3, types: [int] */
    /* JADX WARN: Type inference failed for: r7v31 */
    /* JADX WARN: Type inference failed for: r7v34 */
    /* JADX WARN: Type inference failed for: r7v35 */
    /* JADX WARN: Type inference failed for: r7v36 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v21, types: [int] */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v23, types: [int] */
    /* JADX WARN: Type inference failed for: r8v24 */
    private final void d() {
        int i3;
        int i4;
        boolean z2;
        ?? r7;
        boolean z3;
        FocusState focusStateA0;
        boolean z4;
        ?? r72;
        ?? r73;
        ?? r16;
        ?? r15;
        ?? r2 = 0;
        if (!((FocusState) this.f25461c.invoke()).b()) {
            List list = this.f25466h;
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                ((FocusEventModifierNode) list.get(i5)).O(FocusStateImpl.f25540d);
            }
            List list2 = this.f25465g;
            int size2 = list2.size();
            for (int i6 = 0; i6 < size2; i6++) {
                FocusTargetNode focusTargetNode = (FocusTargetNode) list2.get(i6);
                if (focusTargetNode.isAttached() && !focusTargetNode.D2()) {
                    focusTargetNode.A2(FocusStateImpl.f25540d);
                }
            }
            this.f25465g.clear();
            this.f25466h.clear();
            this.f25467i.clear();
            this.f25468j.clear();
            this.f25460b.invoke();
            return;
        }
        List list3 = this.f25467i;
        int size3 = list3.size();
        int i7 = 0;
        while (true) {
            i3 = 1024;
            i4 = 16;
            z2 = true;
            if (i7 >= size3) {
                break;
            }
            FocusPropertiesModifierNode focusPropertiesModifierNode = (FocusPropertiesModifierNode) list3.get(i7);
            if (focusPropertiesModifierNode.getNode().isAttached()) {
                int iA = NodeKind.a(1024);
                Modifier.Node node = focusPropertiesModifierNode.getNode();
                MutableVector mutableVector = null;
                while (node != null) {
                    if (node instanceof FocusTargetNode) {
                        this.f25465g.add((FocusTargetNode) node);
                    } else if ((node.getKindSet$ui_release() & iA) != 0 && (node instanceof DelegatingNode)) {
                        int i8 = 0;
                        for (Modifier.Node nodeN2 = ((DelegatingNode) node).n2(); nodeN2 != null; nodeN2 = nodeN2.getChild$ui_release()) {
                            if ((nodeN2.getKindSet$ui_release() & iA) != 0) {
                                i8++;
                                if (i8 == 1) {
                                    node = nodeN2;
                                } else {
                                    if (mutableVector == null) {
                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                    }
                                    if (node != null) {
                                        mutableVector.b(node);
                                        node = null;
                                    }
                                    mutableVector.b(nodeN2);
                                }
                            }
                        }
                        if (i8 == 1) {
                        }
                    }
                    node = DelegatableNodeKt.h(mutableVector);
                }
                if (!focusPropertiesModifierNode.getNode().isAttached()) {
                    InlineClassHelperKt.c("visitChildren called on an unattached node");
                }
                MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                Modifier.Node child$ui_release = focusPropertiesModifierNode.getNode().getChild$ui_release();
                if (child$ui_release == null) {
                    DelegatableNodeKt.c(mutableVector2, focusPropertiesModifierNode.getNode(), false);
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
                                        this.f25465g.add((FocusTargetNode) nodeH);
                                    } else if ((nodeH.getKindSet$ui_release() & iA) != 0 && (nodeH instanceof DelegatingNode)) {
                                        int i9 = 0;
                                        for (Modifier.Node nodeN22 = ((DelegatingNode) nodeH).n2(); nodeN22 != null; nodeN22 = nodeN22.getChild$ui_release()) {
                                            if ((nodeN22.getKindSet$ui_release() & iA) != 0) {
                                                i9++;
                                                if (i9 == 1) {
                                                    nodeH = nodeN22;
                                                } else {
                                                    if (mutableVector3 == null) {
                                                        mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                                    }
                                                    if (nodeH != null) {
                                                        mutableVector3.b(nodeH);
                                                        nodeH = null;
                                                    }
                                                    mutableVector3.b(nodeN22);
                                                }
                                            }
                                        }
                                        if (i9 == 1) {
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
            i7++;
        }
        this.f25467i.clear();
        List list4 = this.f25466h;
        int size4 = list4.size();
        int i10 = 0;
        while (i10 < size4) {
            FocusEventModifierNode focusEventModifierNode = (FocusEventModifierNode) list4.get(i10);
            if (focusEventModifierNode.getNode().isAttached()) {
                int iA2 = NodeKind.a(i3);
                Modifier.Node node2 = focusEventModifierNode.getNode();
                ?? r162 = r2;
                ?? r152 = z2;
                FocusTargetNode focusTargetNode2 = null;
                MutableVector mutableVector4 = null;
                while (node2 != null) {
                    if (node2 instanceof FocusTargetNode) {
                        FocusTargetNode focusTargetNode3 = (FocusTargetNode) node2;
                        r162 = r162;
                        if (focusTargetNode2 != null) {
                            r162 = z2;
                        }
                        r152 = r152;
                        if (this.f25465g.contains(focusTargetNode3)) {
                            this.f25468j.add(focusTargetNode3);
                            r152 = r2;
                        }
                        focusTargetNode2 = focusTargetNode3;
                    } else if ((node2.getKindSet$ui_release() & iA2) != 0 && (node2 instanceof DelegatingNode)) {
                        Modifier.Node nodeN23 = ((DelegatingNode) node2).n2();
                        ?? r8 = r2;
                        while (nodeN23 != null) {
                            if ((nodeN23.getKindSet$ui_release() & iA2) != 0) {
                                r8++;
                                if (r8 == z2) {
                                    node2 = nodeN23;
                                } else {
                                    if (mutableVector4 == null) {
                                        mutableVector4 = new MutableVector(new Modifier.Node[i4], r2);
                                    }
                                    if (node2 != null) {
                                        mutableVector4.b(node2);
                                        node2 = null;
                                    }
                                    mutableVector4.b(nodeN23);
                                }
                            }
                            nodeN23 = nodeN23.getChild$ui_release();
                            z2 = true;
                            r8 = r8;
                        }
                        boolean z5 = z2;
                        if (r8 == z5) {
                            z2 = z5;
                        }
                    }
                    node2 = DelegatableNodeKt.h(mutableVector4);
                    z2 = true;
                }
                if (!focusEventModifierNode.getNode().isAttached()) {
                    InlineClassHelperKt.c("visitChildren called on an unattached node");
                }
                MutableVector mutableVector5 = new MutableVector(new Modifier.Node[i4], r2);
                Modifier.Node child$ui_release2 = focusEventModifierNode.getNode().getChild$ui_release();
                if (child$ui_release2 == null) {
                    DelegatableNodeKt.c(mutableVector5, focusEventModifierNode.getNode(), r2);
                } else {
                    mutableVector5.b(child$ui_release2);
                }
                while (mutableVector5.o() != 0) {
                    Modifier.Node nodeH2 = (Modifier.Node) mutableVector5.u(mutableVector5.o() - 1);
                    r2 = r2;
                    if ((nodeH2.getAggregateChildKindSet$ui_release() & iA2) == 0) {
                        DelegatableNodeKt.c(mutableVector5, nodeH2, r2);
                    } else {
                        while (nodeH2 != null) {
                            if ((nodeH2.getKindSet$ui_release() & iA2) != 0) {
                                MutableVector mutableVector6 = null;
                                r2 = r2;
                                r152 = r152;
                                r162 = r162;
                                while (nodeH2 != null) {
                                    if (nodeH2 instanceof FocusTargetNode) {
                                        FocusTargetNode focusTargetNode4 = (FocusTargetNode) nodeH2;
                                        ?? r163 = r162;
                                        if (focusTargetNode2 != null) {
                                            r163 = 1;
                                        }
                                        ?? r153 = r152;
                                        if (this.f25465g.contains(focusTargetNode4)) {
                                            this.f25468j.add(focusTargetNode4);
                                            r153 = r2 == true ? 1 : 0;
                                        }
                                        z4 = r2 == true ? 1 : 0;
                                        focusTargetNode2 = focusTargetNode4;
                                        r15 = r153;
                                        r16 = r163;
                                    } else if ((nodeH2.getKindSet$ui_release() & iA2) == 0 || !(nodeH2 instanceof DelegatingNode)) {
                                        z4 = r2 == true ? 1 : 0;
                                        r15 = r152;
                                        r16 = r162;
                                    } else {
                                        Modifier.Node nodeN24 = ((DelegatingNode) nodeH2).n2();
                                        int i11 = r2 == true ? 1 : 0;
                                        ?? r22 = r2;
                                        while (nodeN24 != null) {
                                            if ((nodeN24.getKindSet$ui_release() & iA2) != 0) {
                                                i11++;
                                                if (i11 == 1) {
                                                    nodeH2 = nodeN24;
                                                    r73 = 0;
                                                } else {
                                                    if (mutableVector6 == null) {
                                                        Modifier.Node[] nodeArr = new Modifier.Node[i4];
                                                        r73 = 0;
                                                        mutableVector6 = new MutableVector(nodeArr, 0);
                                                    } else {
                                                        r73 = 0;
                                                    }
                                                    if (nodeH2 != null) {
                                                        mutableVector6.b(nodeH2);
                                                        nodeH2 = null;
                                                    }
                                                    mutableVector6.b(nodeN24);
                                                }
                                            } else {
                                                r73 = r22;
                                            }
                                            nodeN24 = nodeN24.getChild$ui_release();
                                            r22 = r73;
                                            i4 = 16;
                                        }
                                        r72 = r22;
                                        r72 = r72;
                                        r152 = r152;
                                        r162 = r162;
                                        if (i11 != 1) {
                                            nodeH2 = DelegatableNodeKt.h(mutableVector6);
                                        }
                                        r2 = r72;
                                        i4 = 16;
                                        r152 = r152;
                                        r162 = r162;
                                    }
                                    r72 = z4;
                                    r152 = r15;
                                    r162 = r16;
                                    nodeH2 = DelegatableNodeKt.h(mutableVector6);
                                    r2 = r72;
                                    i4 = 16;
                                    r152 = r152;
                                    r162 = r162;
                                }
                                boolean z6 = r2 == true ? 1 : 0;
                                i4 = 16;
                            } else {
                                boolean z7 = r2 == true ? 1 : 0;
                                nodeH2 = nodeH2.getChild$ui_release();
                                r2 = z7 ? 1 : 0;
                                i4 = 16;
                            }
                        }
                    }
                    r2 = r2 == true ? 1 : 0;
                    i4 = 16;
                }
                r7 = r2 == true ? 1 : 0;
                z3 = true;
                if (r152 != 0) {
                    if (r162 != 0) {
                        focusStateA0 = FocusEventModifierNodeKt.a(focusEventModifierNode);
                    } else if (focusTargetNode2 == null || (focusStateA0 = focusTargetNode2.a0()) == null) {
                        focusStateA0 = FocusStateImpl.f25540d;
                    }
                    focusEventModifierNode.O(focusStateA0);
                }
            } else {
                focusEventModifierNode.O(FocusStateImpl.f25540d);
                r7 = r2;
                z3 = z2;
            }
            i10++;
            z2 = z3;
            r2 = r7;
            i3 = 1024;
            i4 = 16;
        }
        this.f25466h.clear();
        ?? r12 = this.f25465g;
        int size5 = ((Collection) r12).size();
        for (?? r74 = r2; r74 < size5; r74++) {
            FocusTargetNode focusTargetNode5 = (FocusTargetNode) r12.get(r74);
            if (focusTargetNode5.isAttached()) {
                FocusStateImpl focusStateImplA0 = focusTargetNode5.a0();
                focusTargetNode5.C2();
                if (focusStateImplA0 != focusTargetNode5.a0() || this.f25468j.contains(focusTargetNode5)) {
                    focusTargetNode5.r2();
                }
            }
        }
        this.f25465g.clear();
        this.f25468j.clear();
        this.f25460b.invoke();
        if (!this.f25467i.isEmpty()) {
            InlineClassHelperKt.c("Unprocessed FocusProperties nodes");
        }
        if (!this.f25466h.isEmpty()) {
            InlineClassHelperKt.c("Unprocessed FocusEvent nodes");
        }
        if (this.f25465g.isEmpty()) {
            return;
        }
        InlineClassHelperKt.c("Unprocessed FocusTarget nodes");
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x0140  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void e() {
        /*
            Method dump skipped, instruction units count: 343
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusInvalidationManager.e():void");
    }

    private final void f(MutableScatterSet mutableScatterSet, Object obj) {
        if (mutableScatterSet.i(obj)) {
            l();
        }
    }

    private final void k(List list, Object obj) {
        if (list.add(obj) && this.f25465g.size() + this.f25466h.size() + this.f25467i.size() == 1) {
            this.f25459a.invoke(new FocusInvalidationManager$scheduleInvalidationLegacy$1(this));
        }
    }

    private final void l() {
        if (this.f25469k) {
            return;
        }
        this.f25459a.invoke(new FocusInvalidationManager$setUpOnRequestApplyChangesListener$1(this));
        this.f25469k = true;
    }

    public final boolean b() {
        return ComposeUiFlags.f25107g ? this.f25469k : (this.f25465g.isEmpty() && this.f25467i.isEmpty() && this.f25466h.isEmpty()) ? false : true;
    }

    public final void g(FocusEventModifierNode focusEventModifierNode) {
        if (ComposeUiFlags.f25107g) {
            f(this.f25464f, focusEventModifierNode);
        } else {
            k(this.f25466h, focusEventModifierNode);
        }
    }

    public final void h(FocusPropertiesModifierNode focusPropertiesModifierNode) {
        k(this.f25467i, focusPropertiesModifierNode);
    }

    public final void i(FocusTargetNode focusTargetNode) {
        if (ComposeUiFlags.f25107g) {
            f(this.f25463e, focusTargetNode);
        } else {
            k(this.f25465g, focusTargetNode);
        }
    }

    public final void j() {
        l();
    }
}
