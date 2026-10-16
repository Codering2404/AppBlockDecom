package androidx.compose.ui.input.pointer;

import androidx.collection.LongSparseArray;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
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
public class NodeParent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MutableVector f26822a = new MutableVector(new Node[16], 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableObjectList f26823b = new MutableObjectList(10);

    public boolean a(LongSparseArray longSparseArray, LayoutCoordinates layoutCoordinates, InternalPointerEvent internalPointerEvent, boolean z2) {
        MutableVector mutableVector = this.f26822a;
        Object[] objArr = mutableVector.f24389a;
        int iO = mutableVector.o();
        boolean z3 = false;
        for (int i3 = 0; i3 < iO; i3++) {
            z3 = ((Node) objArr[i3]).a(longSparseArray, layoutCoordinates, internalPointerEvent, z2) || z3;
        }
        return z3;
    }

    public void b(InternalPointerEvent internalPointerEvent) {
        int iO = this.f26822a.o();
        while (true) {
            iO--;
            if (-1 >= iO) {
                return;
            }
            if (((Node) this.f26822a.f24389a[iO]).l().f()) {
                this.f26822a.u(iO);
            }
        }
    }

    public final void c() {
        this.f26822a.i();
    }

    public void d() {
        MutableVector mutableVector = this.f26822a;
        Object[] objArr = mutableVector.f24389a;
        int iO = mutableVector.o();
        for (int i3 = 0; i3 < iO; i3++) {
            ((Node) objArr[i3]).d();
        }
    }

    public boolean e(InternalPointerEvent internalPointerEvent) {
        MutableVector mutableVector = this.f26822a;
        Object[] objArr = mutableVector.f24389a;
        int iO = mutableVector.o();
        boolean z2 = false;
        for (int i3 = 0; i3 < iO; i3++) {
            z2 = ((Node) objArr[i3]).e(internalPointerEvent) || z2;
        }
        b(internalPointerEvent);
        return z2;
    }

    public boolean f(LongSparseArray longSparseArray, LayoutCoordinates layoutCoordinates, InternalPointerEvent internalPointerEvent, boolean z2) {
        MutableVector mutableVector = this.f26822a;
        Object[] objArr = mutableVector.f24389a;
        int iO = mutableVector.o();
        boolean z3 = false;
        for (int i3 = 0; i3 < iO; i3++) {
            z3 = ((Node) objArr[i3]).f(longSparseArray, layoutCoordinates, internalPointerEvent, z2) || z3;
        }
        return z3;
    }

    public final MutableVector g() {
        return this.f26822a;
    }

    public void h(long j3, MutableObjectList mutableObjectList) {
        MutableVector mutableVector = this.f26822a;
        Object[] objArr = mutableVector.f24389a;
        int iO = mutableVector.o();
        for (int i3 = 0; i3 < iO; i3++) {
            ((Node) objArr[i3]).h(j3, mutableObjectList);
        }
    }

    public void i(Modifier.Node node) {
        this.f26823b.t();
        this.f26823b.n(this);
        while (this.f26823b.h()) {
            NodeParent nodeParent = (NodeParent) this.f26823b.A(r0.e() - 1);
            int i3 = 0;
            while (i3 < nodeParent.f26822a.o()) {
                Node node2 = (Node) nodeParent.f26822a.f24389a[i3];
                if (Intrinsics.areEqual(node2.k(), node)) {
                    nodeParent.f26822a.s(node2);
                    node2.d();
                } else {
                    this.f26823b.n(node2);
                    i3++;
                }
            }
        }
    }
}
