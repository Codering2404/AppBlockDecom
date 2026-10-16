package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlinx.coroutines.DebugStringsKt;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public class LockFreeLinkedListNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f142456a = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_next$volatile");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f142457b = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_prev$volatile");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f142458c = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_removedRef$volatile");
    private volatile /* synthetic */ Object _next$volatile = this;
    private volatile /* synthetic */ Object _prev$volatile = this;
    private volatile /* synthetic */ Object _removedRef$volatile;

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0025, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003f, code lost:
    
        if (androidx.concurrent.futures.a.a(kotlinx.coroutines.internal.LockFreeLinkedListNode.f142456a, r3, r2, ((kotlinx.coroutines.internal.Removed) r4).f142479a) != false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final kotlinx.coroutines.internal.LockFreeLinkedListNode g() {
        /*
            r7 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = n()
            java.lang.Object r0 = r0.get(r7)
            kotlinx.coroutines.internal.LockFreeLinkedListNode r0 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r0
            r1 = 0
            r2 = r0
        Lc:
            r3 = r1
        Ld:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = m()
            java.lang.Object r4 = r4.get(r2)
            if (r4 != r7) goto L26
            if (r0 != r2) goto L1a
            goto L25
        L1a:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = n()
            boolean r0 = androidx.concurrent.futures.a.a(r1, r7, r0, r2)
            if (r0 != 0) goto L25
            goto L0
        L25:
            return r2
        L26:
            boolean r5 = r7.p()
            if (r5 == 0) goto L2d
            return r1
        L2d:
            boolean r5 = r4 instanceof kotlinx.coroutines.internal.Removed
            if (r5 == 0) goto L4f
            if (r3 == 0) goto L44
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = m()
            kotlinx.coroutines.internal.Removed r4 = (kotlinx.coroutines.internal.Removed) r4
            kotlinx.coroutines.internal.LockFreeLinkedListNode r4 = r4.f142479a
            boolean r2 = androidx.concurrent.futures.a.a(r5, r3, r2, r4)
            if (r2 != 0) goto L42
            goto L0
        L42:
            r2 = r3
            goto Lc
        L44:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = n()
            java.lang.Object r2 = r4.get(r2)
            kotlinx.coroutines.internal.LockFreeLinkedListNode r2 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r2
            goto Ld
        L4f:
            java.lang.String r3 = "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4, r3)
            r3 = r4
            kotlinx.coroutines.internal.LockFreeLinkedListNode r3 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r3
            r6 = r3
            r3 = r2
            r2 = r6
            goto Ld
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.LockFreeLinkedListNode.g():kotlinx.coroutines.internal.LockFreeLinkedListNode");
    }

    private final LockFreeLinkedListNode h(LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (lockFreeLinkedListNode.p()) {
            lockFreeLinkedListNode = (LockFreeLinkedListNode) f142457b.get(lockFreeLinkedListNode);
        }
        return lockFreeLinkedListNode;
    }

    private final void i(LockFreeLinkedListNode lockFreeLinkedListNode) {
        LockFreeLinkedListNode lockFreeLinkedListNode2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f142457b;
        do {
            lockFreeLinkedListNode2 = (LockFreeLinkedListNode) atomicReferenceFieldUpdater.get(lockFreeLinkedListNode);
            if (j() != lockFreeLinkedListNode) {
                return;
            }
        } while (!androidx.concurrent.futures.a.a(f142457b, lockFreeLinkedListNode, lockFreeLinkedListNode2, this));
        if (p()) {
            lockFreeLinkedListNode.g();
        }
    }

    private final Removed s() {
        Removed removed = (Removed) f142458c.get(this);
        if (removed != null) {
            return removed;
        }
        Removed removed2 = new Removed(this);
        f142458c.set(this, removed2);
        return removed2;
    }

    public final boolean c(LockFreeLinkedListNode lockFreeLinkedListNode, int i3) {
        LockFreeLinkedListNode lockFreeLinkedListNodeL;
        do {
            lockFreeLinkedListNodeL = l();
            if (lockFreeLinkedListNodeL instanceof ListClosed) {
                return (((ListClosed) lockFreeLinkedListNodeL).f142455d & i3) == 0 && lockFreeLinkedListNodeL.c(lockFreeLinkedListNode, i3);
            }
        } while (!lockFreeLinkedListNodeL.d(lockFreeLinkedListNode, this));
        return true;
    }

    public final boolean d(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2) {
        f142457b.set(lockFreeLinkedListNode, this);
        f142456a.set(lockFreeLinkedListNode, lockFreeLinkedListNode2);
        if (!androidx.concurrent.futures.a.a(f142456a, this, lockFreeLinkedListNode2, lockFreeLinkedListNode)) {
            return false;
        }
        lockFreeLinkedListNode.i(lockFreeLinkedListNode2);
        return true;
    }

    public final boolean e(LockFreeLinkedListNode lockFreeLinkedListNode) {
        f142457b.set(lockFreeLinkedListNode, this);
        f142456a.set(lockFreeLinkedListNode, this);
        while (j() == this) {
            if (androidx.concurrent.futures.a.a(f142456a, this, this, lockFreeLinkedListNode)) {
                lockFreeLinkedListNode.i(this);
                return true;
            }
        }
        return false;
    }

    public final void f(int i3) {
        c(new ListClosed(i3), i3);
    }

    public final Object j() {
        return f142456a.get(this);
    }

    public final LockFreeLinkedListNode k() {
        LockFreeLinkedListNode lockFreeLinkedListNode;
        Object objJ = j();
        Removed removed = objJ instanceof Removed ? (Removed) objJ : null;
        if (removed != null && (lockFreeLinkedListNode = removed.f142479a) != null) {
            return lockFreeLinkedListNode;
        }
        Intrinsics.checkNotNull(objJ, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        return (LockFreeLinkedListNode) objJ;
    }

    public final LockFreeLinkedListNode l() {
        LockFreeLinkedListNode lockFreeLinkedListNodeG = g();
        return lockFreeLinkedListNodeG == null ? h((LockFreeLinkedListNode) f142457b.get(this)) : lockFreeLinkedListNodeG;
    }

    public boolean p() {
        return j() instanceof Removed;
    }

    public boolean q() {
        return r() == null;
    }

    public final LockFreeLinkedListNode r() {
        Object objJ;
        LockFreeLinkedListNode lockFreeLinkedListNode;
        do {
            objJ = j();
            if (objJ instanceof Removed) {
                return ((Removed) objJ).f142479a;
            }
            if (objJ == this) {
                return (LockFreeLinkedListNode) objJ;
            }
            Intrinsics.checkNotNull(objJ, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
            lockFreeLinkedListNode = (LockFreeLinkedListNode) objJ;
        } while (!androidx.concurrent.futures.a.a(f142456a, this, objJ, lockFreeLinkedListNode.s()));
        lockFreeLinkedListNode.g();
        return null;
    }

    public String toString() {
        return new PropertyReference0Impl(this) { // from class: kotlinx.coroutines.internal.LockFreeLinkedListNode.toString.1
            @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return DebugStringsKt.a(this.receiver);
            }
        } + '@' + DebugStringsKt.b(this);
    }
}
