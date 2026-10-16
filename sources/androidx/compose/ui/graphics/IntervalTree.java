package androidx.compose.ui.graphics;

import java.util.ArrayList;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class IntervalTree<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Node f25794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Node f25795b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f25796c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public final class Node extends Interval<T> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f25797d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private float f25798e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private float f25799f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Node f25800g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Node f25801h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private Node f25802i;

        public Node(float f3, float f4, Object obj, int i3) {
            super(f3, f4, obj);
            this.f25797d = i3;
            this.f25798e = f3;
            this.f25799f = f4;
            Node node = IntervalTree.this.f25794a;
            this.f25800g = node;
            this.f25801h = node;
            this.f25802i = node;
        }

        public final int e() {
            return this.f25797d;
        }

        public final Node f() {
            return this.f25800g;
        }

        public final float g() {
            return this.f25799f;
        }

        public final float h() {
            return this.f25798e;
        }

        public final Node i() {
            return this.f25802i;
        }

        public final Node j() {
            return this.f25801h;
        }

        public final Node k() {
            Node node = this;
            while (true) {
                Node node2 = node.f25800g;
                if (node2 == IntervalTree.this.f25794a) {
                    return node;
                }
                node = node2;
            }
        }

        public final Node l() {
            Node node = this.f25801h;
            if (node != IntervalTree.this.f25794a) {
                return node.k();
            }
            Node node2 = this.f25802i;
            Node node3 = this;
            while (node2 != IntervalTree.this.f25794a && node3 == node2.f25801h) {
                node3 = node2;
                node2 = node2.f25802i;
            }
            return node2;
        }

        public final void m(int i3) {
            this.f25797d = i3;
        }

        public final void n(Node node) {
            this.f25800g = node;
        }

        public final void o(float f3) {
            this.f25799f = f3;
        }

        public final void p(float f3) {
            this.f25798e = f3;
        }

        public final void q(Node node) {
            this.f25802i = node;
        }

        public final void r(Node node) {
            this.f25801h = node;
        }
    }

    public IntervalTree() {
        Node node = new Node(Float.MAX_VALUE, Float.MIN_VALUE, null, 1);
        this.f25794a = node;
        this.f25795b = node;
        this.f25796c = new ArrayList();
    }

    public static /* synthetic */ Interval d(IntervalTree intervalTree, float f3, float f4, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            f4 = f3;
        }
        return intervalTree.c(f3, f4);
    }

    private final void e(Node node) {
        while (node != this.f25795b && node.i().e() == 0) {
            Node nodeI = node.i().i();
            if (node.i() == nodeI.f()) {
                Node nodeJ = nodeI.j();
                if (nodeJ.e() == 0) {
                    nodeJ.m(1);
                    node.i().m(1);
                    nodeI.m(0);
                    node = nodeI;
                } else {
                    if (node == node.i().j()) {
                        node = node.i();
                        f(node);
                    }
                    node.i().m(1);
                    nodeI.m(0);
                    g(nodeI);
                }
            } else {
                Node nodeF = nodeI.f();
                if (nodeF.e() == 0) {
                    nodeF.m(1);
                    node.i().m(1);
                    nodeI.m(0);
                    node = nodeI;
                } else {
                    if (node == node.i().f()) {
                        node = node.i();
                        g(node);
                    }
                    node.i().m(1);
                    nodeI.m(0);
                    f(nodeI);
                }
            }
        }
        this.f25795b.m(1);
    }

    private final void f(Node node) {
        Node nodeJ = node.j();
        node.r(nodeJ.f());
        if (nodeJ.f() != this.f25794a) {
            nodeJ.f().q(node);
        }
        nodeJ.q(node.i());
        if (node.i() == this.f25794a) {
            this.f25795b = nodeJ;
        } else if (node.i().f() == node) {
            node.i().n(nodeJ);
        } else {
            node.i().r(nodeJ);
        }
        nodeJ.n(node);
        node.q(nodeJ);
        h(node);
    }

    private final void g(Node node) {
        Node nodeF = node.f();
        node.n(nodeF.j());
        if (nodeF.j() != this.f25794a) {
            nodeF.j().q(node);
        }
        nodeF.q(node.i());
        if (node.i() == this.f25794a) {
            this.f25795b = nodeF;
        } else if (node.i().j() == node) {
            node.i().r(nodeF);
        } else {
            node.i().n(nodeF);
        }
        nodeF.r(node);
        node.q(nodeF);
        h(node);
    }

    private final void h(Node node) {
        while (node != this.f25794a) {
            node.p(Math.min(node.c(), Math.min(node.f().h(), node.j().h())));
            node.o(Math.max(node.b(), Math.max(node.f().g(), node.j().g())));
            node = node.i();
        }
    }

    public final void a(float f3, float f4, Object obj) {
        Node node = new Node(f3, f4, obj, 0);
        Node node2 = this.f25794a;
        for (Node nodeF = this.f25795b; nodeF != this.f25794a; nodeF = node.c() <= nodeF.c() ? nodeF.f() : nodeF.j()) {
            node2 = nodeF;
        }
        node.q(node2);
        if (node2 == this.f25794a) {
            this.f25795b = node;
        } else if (node.c() <= node2.c()) {
            node2.n(node);
        } else {
            node2.r(node);
        }
        h(node);
        e(node);
    }

    public final boolean b(float f3) {
        return c(f3, f3) != IntervalTreeKt.a();
    }

    public final Interval c(float f3, float f4) {
        Node node = this.f25795b;
        Node node2 = this.f25794a;
        if (node != node2 && node != node2) {
            ArrayList arrayList = this.f25796c;
            arrayList.add(node);
            while (arrayList.size() > 0) {
                Node node3 = (Node) arrayList.remove(arrayList.size() - 1);
                if (node3.d(f3, f4)) {
                    return node3;
                }
                if (node3.f() != this.f25794a && node3.f().g() >= f3) {
                    arrayList.add(node3.f());
                }
                if (node3.j() != this.f25794a && node3.j().h() <= f4) {
                    arrayList.add(node3.j());
                }
            }
            arrayList.clear();
        }
        Interval intervalA = IntervalTreeKt.a();
        Intrinsics.checkNotNull(intervalA, "null cannot be cast to non-null type androidx.compose.ui.graphics.Interval<T of androidx.compose.ui.graphics.IntervalTree>");
        return intervalA;
    }
}
