package androidx.compose.ui.input.pointer;

import androidx.collection.LongSparseArray;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.util.PointerIdArray;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.PointerInputModifierNode;
import java.util.List;
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
public final class Node extends NodeParent {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Modifier.Node f26814c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private LayoutCoordinates f26817f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private PointerEvent f26818g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f26819h;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PointerIdArray f26815d = new PointerIdArray();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final LongSparseArray f26816e = new LongSparseArray(2);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f26820i = true;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f26821j = true;

    public Node(Modifier.Node node) {
        this.f26814c = node;
    }

    private final void j() {
        this.f26816e.b();
        this.f26817f = null;
    }

    private final boolean m(PointerEvent pointerEvent, PointerEvent pointerEvent2) {
        if (pointerEvent == null || pointerEvent.c().size() != pointerEvent2.c().size()) {
            return true;
        }
        int size = pointerEvent2.c().size();
        for (int i3 = 0; i3 < size; i3++) {
            if (!Offset.j(((PointerInputChange) pointerEvent.c().get(i3)).h(), ((PointerInputChange) pointerEvent2.c().get(i3)).h())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0260  */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r5v2, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v27, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v28, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v3, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v30 */
    /* JADX WARN: Type inference failed for: r5v31 */
    /* JADX WARN: Type inference failed for: r5v32 */
    /* JADX WARN: Type inference failed for: r5v33 */
    /* JADX WARN: Type inference failed for: r5v34 */
    @Override // androidx.compose.ui.input.pointer.NodeParent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(androidx.collection.LongSparseArray r46, androidx.compose.ui.layout.LayoutCoordinates r47, androidx.compose.ui.input.pointer.InternalPointerEvent r48, boolean r49) {
        /*
            Method dump skipped, instruction units count: 707
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.Node.a(androidx.collection.LongSparseArray, androidx.compose.ui.layout.LayoutCoordinates, androidx.compose.ui.input.pointer.InternalPointerEvent, boolean):boolean");
    }

    @Override // androidx.compose.ui.input.pointer.NodeParent
    public void b(InternalPointerEvent internalPointerEvent) {
        super.b(internalPointerEvent);
        PointerEvent pointerEvent = this.f26818g;
        if (pointerEvent == null) {
            return;
        }
        this.f26819h = this.f26820i;
        List listC = pointerEvent.c();
        int size = listC.size();
        for (int i3 = 0; i3 < size; i3++) {
            PointerInputChange pointerInputChange = (PointerInputChange) listC.get(i3);
            boolean zI = pointerInputChange.i();
            boolean zA = internalPointerEvent.a(pointerInputChange.f());
            boolean z2 = this.f26820i;
            if ((!zI && !zA) || (!zI && !z2)) {
                this.f26815d.g(pointerInputChange.f());
            }
        }
        this.f26820i = false;
        this.f26821j = PointerEventType.j(pointerEvent.h(), PointerEventType.f26835b.b());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v3, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v4 */
    @Override // androidx.compose.ui.input.pointer.NodeParent
    public void d() {
        MutableVector mutableVectorG = g();
        Object[] objArr = mutableVectorG.f24389a;
        int iO = mutableVectorG.o();
        for (int i3 = 0; i3 < iO; i3++) {
            ((Node) objArr[i3]).d();
        }
        ?? H = this.f26814c;
        int iA = NodeKind.a(16);
        ?? mutableVector = 0;
        while (H != 0) {
            if (H instanceof PointerInputModifierNode) {
                ((PointerInputModifierNode) H).u1();
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r4v0, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
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
    @Override // androidx.compose.ui.input.pointer.NodeParent
    public boolean e(InternalPointerEvent internalPointerEvent) {
        boolean z2 = false;
        z2 = false;
        if (!this.f26816e.j() && this.f26814c.isAttached()) {
            PointerEvent pointerEvent = this.f26818g;
            Intrinsics.checkNotNull(pointerEvent);
            LayoutCoordinates layoutCoordinates = this.f26817f;
            Intrinsics.checkNotNull(layoutCoordinates);
            long jA = layoutCoordinates.a();
            ?? H = this.f26814c;
            int iA = NodeKind.a(16);
            ?? mutableVector = 0;
            while (H != 0) {
                if (H instanceof PointerInputModifierNode) {
                    ((PointerInputModifierNode) H).g0(pointerEvent, PointerEventPass.f26832c, jA);
                } else if ((H.getKindSet$ui_release() & iA) != 0 && (H instanceof DelegatingNode)) {
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
            if (this.f26814c.isAttached()) {
                MutableVector mutableVectorG = g();
                Object[] objArr = mutableVectorG.f24389a;
                int iO = mutableVectorG.o();
                for (int i4 = 0; i4 < iO; i4++) {
                    ((Node) objArr[i4]).e(internalPointerEvent);
                }
            }
            z2 = true;
        }
        b(internalPointerEvent);
        j();
        return z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v13 */
    /* JADX WARN: Type inference failed for: r14v14 */
    /* JADX WARN: Type inference failed for: r14v3, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r14v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r14v7, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r14v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v9 */
    /* JADX WARN: Type inference failed for: r2v0, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v10, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v17, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r8v9 */
    @Override // androidx.compose.ui.input.pointer.NodeParent
    public boolean f(LongSparseArray longSparseArray, LayoutCoordinates layoutCoordinates, InternalPointerEvent internalPointerEvent, boolean z2) {
        if (this.f26816e.j() || !this.f26814c.isAttached()) {
            return false;
        }
        PointerEvent pointerEvent = this.f26818g;
        Intrinsics.checkNotNull(pointerEvent);
        LayoutCoordinates layoutCoordinates2 = this.f26817f;
        Intrinsics.checkNotNull(layoutCoordinates2);
        long jA = layoutCoordinates2.a();
        ?? H = this.f26814c;
        int iA = NodeKind.a(16);
        ?? mutableVector = 0;
        while (H != 0) {
            if (H instanceof PointerInputModifierNode) {
                ((PointerInputModifierNode) H).g0(pointerEvent, PointerEventPass.f26830a, jA);
            } else if ((H.getKindSet$ui_release() & iA) != 0 && (H instanceof DelegatingNode)) {
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
        if (this.f26814c.isAttached()) {
            MutableVector mutableVectorG = g();
            Object[] objArr = mutableVectorG.f24389a;
            int iO = mutableVectorG.o();
            for (int i4 = 0; i4 < iO; i4++) {
                Node node = (Node) objArr[i4];
                LongSparseArray longSparseArray2 = this.f26816e;
                LayoutCoordinates layoutCoordinates3 = this.f26817f;
                Intrinsics.checkNotNull(layoutCoordinates3);
                node.f(longSparseArray2, layoutCoordinates3, internalPointerEvent, z2);
            }
        }
        if (this.f26814c.isAttached()) {
            ?? H2 = this.f26814c;
            int iA2 = NodeKind.a(16);
            ?? mutableVector2 = 0;
            while (H2 != 0) {
                if (H2 instanceof PointerInputModifierNode) {
                    ((PointerInputModifierNode) H2).g0(pointerEvent, PointerEventPass.f26831b, jA);
                } else if ((H2.getKindSet$ui_release() & iA2) != 0 && (H2 instanceof DelegatingNode)) {
                    Modifier.Node nodeN22 = ((DelegatingNode) H2).n2();
                    int i5 = 0;
                    mutableVector2 = mutableVector2;
                    H2 = H2;
                    while (nodeN22 != null) {
                        if ((nodeN22.getKindSet$ui_release() & iA2) != 0) {
                            i5++;
                            mutableVector2 = mutableVector2;
                            if (i5 == 1) {
                                H2 = nodeN22;
                            } else {
                                if (mutableVector2 == 0) {
                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (H2 != 0) {
                                    mutableVector2.b(H2);
                                    H2 = 0;
                                }
                                mutableVector2.b(nodeN22);
                            }
                        }
                        nodeN22 = nodeN22.getChild$ui_release();
                        mutableVector2 = mutableVector2;
                        H2 = H2;
                    }
                    if (i5 == 1) {
                    }
                }
                H2 = DelegatableNodeKt.h(mutableVector2);
            }
        }
        return true;
    }

    @Override // androidx.compose.ui.input.pointer.NodeParent
    public void h(long j3, MutableObjectList mutableObjectList) {
        if (this.f26815d.c(j3) && !mutableObjectList.a(this)) {
            this.f26815d.g(j3);
            this.f26816e.p(j3);
        }
        MutableVector mutableVectorG = g();
        Object[] objArr = mutableVectorG.f24389a;
        int iO = mutableVectorG.o();
        for (int i3 = 0; i3 < iO; i3++) {
            ((Node) objArr[i3]).h(j3, mutableObjectList);
        }
    }

    public final Modifier.Node k() {
        return this.f26814c;
    }

    public final PointerIdArray l() {
        return this.f26815d;
    }

    public final void n() {
        this.f26820i = true;
    }

    public String toString() {
        return "Node(modifierNode=" + this.f26814c + ", children=" + g() + ", pointerIds=" + this.f26815d + ')';
    }
}
