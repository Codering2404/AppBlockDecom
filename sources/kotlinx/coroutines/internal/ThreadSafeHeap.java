package kotlinx.coroutines.internal;

import java.lang.Comparable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public class ThreadSafeHeap<T extends ThreadSafeHeapNode & Comparable<? super T>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f142497b = AtomicIntegerFieldUpdater.newUpdater(ThreadSafeHeap.class, "_size$volatile");
    private volatile /* synthetic */ int _size$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ThreadSafeHeapNode[] f142498a;

    private final ThreadSafeHeapNode[] g() {
        ThreadSafeHeapNode[] threadSafeHeapNodeArr = this.f142498a;
        if (threadSafeHeapNodeArr == null) {
            ThreadSafeHeapNode[] threadSafeHeapNodeArr2 = new ThreadSafeHeapNode[4];
            this.f142498a = threadSafeHeapNodeArr2;
            return threadSafeHeapNodeArr2;
        }
        if (c() < threadSafeHeapNodeArr.length) {
            return threadSafeHeapNodeArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(threadSafeHeapNodeArr, c() * 2);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
        ThreadSafeHeapNode[] threadSafeHeapNodeArr3 = (ThreadSafeHeapNode[]) objArrCopyOf;
        this.f142498a = threadSafeHeapNodeArr3;
        return threadSafeHeapNodeArr3;
    }

    private final void k(int i3) {
        f142497b.set(this, i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void l(int r6) {
        /*
            r5 = this;
        L0:
            int r0 = r6 * 2
            int r1 = r0 + 1
            int r2 = r5.c()
            if (r1 < r2) goto Lb
            goto L3e
        Lb:
            kotlinx.coroutines.internal.ThreadSafeHeapNode[] r2 = r5.f142498a
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            int r0 = r0 + 2
            int r3 = r5.c()
            if (r0 >= r3) goto L2b
            r3 = r2[r0]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            java.lang.Comparable r3 = (java.lang.Comparable) r3
            r4 = r2[r1]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            int r3 = r3.compareTo(r4)
            if (r3 >= 0) goto L2b
            goto L2c
        L2b:
            r0 = r1
        L2c:
            r1 = r2[r6]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            java.lang.Comparable r1 = (java.lang.Comparable) r1
            r2 = r2[r0]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            int r1 = r1.compareTo(r2)
            if (r1 > 0) goto L3f
        L3e:
            return
        L3f:
            r5.n(r6, r0)
            r6 = r0
            goto L0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.ThreadSafeHeap.l(int):void");
    }

    private final void m(int i3) {
        while (i3 > 0) {
            ThreadSafeHeapNode[] threadSafeHeapNodeArr = this.f142498a;
            Intrinsics.checkNotNull(threadSafeHeapNodeArr);
            int i4 = (i3 - 1) / 2;
            ThreadSafeHeapNode threadSafeHeapNode = threadSafeHeapNodeArr[i4];
            Intrinsics.checkNotNull(threadSafeHeapNode);
            ThreadSafeHeapNode threadSafeHeapNode2 = threadSafeHeapNodeArr[i3];
            Intrinsics.checkNotNull(threadSafeHeapNode2);
            if (((Comparable) threadSafeHeapNode).compareTo(threadSafeHeapNode2) <= 0) {
                return;
            }
            n(i3, i4);
            i3 = i4;
        }
    }

    private final void n(int i3, int i4) {
        ThreadSafeHeapNode[] threadSafeHeapNodeArr = this.f142498a;
        Intrinsics.checkNotNull(threadSafeHeapNodeArr);
        ThreadSafeHeapNode threadSafeHeapNode = threadSafeHeapNodeArr[i4];
        Intrinsics.checkNotNull(threadSafeHeapNode);
        ThreadSafeHeapNode threadSafeHeapNode2 = threadSafeHeapNodeArr[i3];
        Intrinsics.checkNotNull(threadSafeHeapNode2);
        threadSafeHeapNodeArr[i3] = threadSafeHeapNode;
        threadSafeHeapNodeArr[i4] = threadSafeHeapNode2;
        threadSafeHeapNode.setIndex(i3);
        threadSafeHeapNode2.setIndex(i4);
    }

    public final void a(ThreadSafeHeapNode threadSafeHeapNode) {
        threadSafeHeapNode.a(this);
        ThreadSafeHeapNode[] threadSafeHeapNodeArrG = g();
        int iC = c();
        k(iC + 1);
        threadSafeHeapNodeArrG[iC] = threadSafeHeapNode;
        threadSafeHeapNode.setIndex(iC);
        m(iC);
    }

    public final ThreadSafeHeapNode b() {
        ThreadSafeHeapNode[] threadSafeHeapNodeArr = this.f142498a;
        if (threadSafeHeapNodeArr != null) {
            return threadSafeHeapNodeArr[0];
        }
        return null;
    }

    public final int c() {
        return f142497b.get(this);
    }

    public final boolean e() {
        return c() == 0;
    }

    public final ThreadSafeHeapNode f() {
        ThreadSafeHeapNode threadSafeHeapNodeB;
        synchronized (this) {
            threadSafeHeapNodeB = b();
        }
        return threadSafeHeapNodeB;
    }

    public final boolean h(ThreadSafeHeapNode threadSafeHeapNode) {
        boolean z2;
        synchronized (this) {
            if (threadSafeHeapNode.c() == null) {
                z2 = false;
            } else {
                i(threadSafeHeapNode.getIndex());
                z2 = true;
            }
        }
        return z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final kotlinx.coroutines.internal.ThreadSafeHeapNode i(int r6) {
        /*
            r5 = this;
            kotlinx.coroutines.internal.ThreadSafeHeapNode[] r0 = r5.f142498a
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            int r1 = r5.c()
            r2 = -1
            int r1 = r1 + r2
            r5.k(r1)
            int r1 = r5.c()
            if (r6 >= r1) goto L3d
            int r1 = r5.c()
            r5.n(r6, r1)
            int r1 = r6 + (-1)
            int r1 = r1 / 2
            if (r6 <= 0) goto L3a
            r3 = r0[r6]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            java.lang.Comparable r3 = (java.lang.Comparable) r3
            r4 = r0[r1]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            int r3 = r3.compareTo(r4)
            if (r3 >= 0) goto L3a
            r5.n(r6, r1)
            r5.m(r1)
            goto L3d
        L3a:
            r5.l(r6)
        L3d:
            int r6 = r5.c()
            r6 = r0[r6]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            r1 = 0
            r6.a(r1)
            r6.setIndex(r2)
            int r2 = r5.c()
            r0[r2] = r1
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.ThreadSafeHeap.i(int):kotlinx.coroutines.internal.ThreadSafeHeapNode");
    }

    public final ThreadSafeHeapNode j() {
        ThreadSafeHeapNode threadSafeHeapNodeI;
        synchronized (this) {
            threadSafeHeapNodeI = c() > 0 ? i(0) : null;
        }
        return threadSafeHeapNodeI;
    }
}
