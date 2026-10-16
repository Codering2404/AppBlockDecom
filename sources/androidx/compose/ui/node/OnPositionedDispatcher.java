package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class OnPositionedDispatcher {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f27607c = new Companion(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f27608d = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MutableVector f27609a = new MutableVector(new LayoutNode[16], 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LayoutNode[] f27610b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        private static final class DepthComparator implements Comparator<LayoutNode> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final DepthComparator f27611a = new DepthComparator();

            private DepthComparator() {
            }

            @Override // java.util.Comparator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(LayoutNode layoutNode, LayoutNode layoutNode2) {
                int iCompare = Intrinsics.compare(layoutNode2.V(), layoutNode.V());
                return iCompare != 0 ? iCompare : Intrinsics.compare(layoutNode.hashCode(), layoutNode2.hashCode());
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final void b(LayoutNode layoutNode) {
        layoutNode.G();
        layoutNode.R1(false);
        MutableVector mutableVectorH0 = layoutNode.H0();
        Object[] objArr = mutableVectorH0.f24389a;
        int iO = mutableVectorH0.o();
        for (int i3 = 0; i3 < iO; i3++) {
            b((LayoutNode) objArr[i3]);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a() {
        /*
            r4 = this;
            androidx.compose.runtime.collection.MutableVector r0 = r4.f27609a
            androidx.compose.ui.node.OnPositionedDispatcher$Companion$DepthComparator r1 = androidx.compose.ui.node.OnPositionedDispatcher.Companion.DepthComparator.f27611a
            r0.A(r1)
            androidx.compose.runtime.collection.MutableVector r0 = r4.f27609a
            int r0 = r0.o()
            androidx.compose.ui.node.LayoutNode[] r1 = r4.f27610b
            if (r1 == 0) goto L14
            int r2 = r1.length
            if (r2 >= r0) goto L22
        L14:
            androidx.compose.runtime.collection.MutableVector r1 = r4.f27609a
            int r1 = r1.o()
            r2 = 16
            int r1 = java.lang.Math.max(r2, r1)
            androidx.compose.ui.node.LayoutNode[] r1 = new androidx.compose.ui.node.LayoutNode[r1]
        L22:
            r2 = 0
            r4.f27610b = r2
            r2 = 0
        L26:
            if (r2 >= r0) goto L33
            androidx.compose.runtime.collection.MutableVector r3 = r4.f27609a
            java.lang.Object[] r3 = r3.f24389a
            r3 = r3[r2]
            r1[r2] = r3
            int r2 = r2 + 1
            goto L26
        L33:
            androidx.compose.runtime.collection.MutableVector r2 = r4.f27609a
            r2.i()
            int r0 = r0 + (-1)
        L3a:
            r2 = -1
            if (r2 >= r0) goto L4e
            r2 = r1[r0]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            boolean r3 = r2.t0()
            if (r3 == 0) goto L4b
            r4.b(r2)
        L4b:
            int r0 = r0 + (-1)
            goto L3a
        L4e:
            r4.f27610b = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.OnPositionedDispatcher.a():void");
    }

    public final boolean c() {
        return this.f27609a.o() != 0;
    }

    public final void d(LayoutNode layoutNode) {
        this.f27609a.b(layoutNode);
        layoutNode.R1(true);
    }

    public final void e(LayoutNode layoutNode) {
        this.f27609a.i();
        this.f27609a.b(layoutNode);
        layoutNode.R1(true);
    }

    public final void f(LayoutNode layoutNode) {
        this.f27609a.s(layoutNode);
    }
}
