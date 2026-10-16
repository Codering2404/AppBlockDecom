package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.ConcurrentLinkedListNode;

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
public abstract class ConcurrentLinkedListNode<N extends ConcurrentLinkedListNode<N>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f142428a = AtomicReferenceFieldUpdater.newUpdater(ConcurrentLinkedListNode.class, Object.class, "_next$volatile");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f142429b = AtomicReferenceFieldUpdater.newUpdater(ConcurrentLinkedListNode.class, Object.class, "_prev$volatile");
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ Object _prev$volatile;

    public ConcurrentLinkedListNode(ConcurrentLinkedListNode concurrentLinkedListNode) {
        this._prev$volatile = concurrentLinkedListNode;
    }

    private final ConcurrentLinkedListNode d() {
        ConcurrentLinkedListNode concurrentLinkedListNodeH = h();
        while (concurrentLinkedListNodeH != null && concurrentLinkedListNodeH.k()) {
            concurrentLinkedListNodeH = (ConcurrentLinkedListNode) f142429b.get(concurrentLinkedListNodeH);
        }
        return concurrentLinkedListNodeH;
    }

    private final ConcurrentLinkedListNode e() {
        ConcurrentLinkedListNode concurrentLinkedListNodeF;
        ConcurrentLinkedListNode concurrentLinkedListNodeF2 = f();
        Intrinsics.checkNotNull(concurrentLinkedListNodeF2);
        while (concurrentLinkedListNodeF2.k() && (concurrentLinkedListNodeF = concurrentLinkedListNodeF2.f()) != null) {
            concurrentLinkedListNodeF2 = concurrentLinkedListNodeF;
        }
        return concurrentLinkedListNodeF2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object g() {
        return f142428a.get(this);
    }

    public final void b() {
        f142429b.set(this, null);
    }

    public final ConcurrentLinkedListNode f() {
        Object objG = g();
        if (objG == ConcurrentLinkedListKt.f142427a) {
            return null;
        }
        return (ConcurrentLinkedListNode) objG;
    }

    public final ConcurrentLinkedListNode h() {
        return (ConcurrentLinkedListNode) f142429b.get(this);
    }

    public abstract boolean k();

    public final boolean l() {
        return f() == null;
    }

    public final boolean m() {
        return androidx.concurrent.futures.a.a(f142428a, this, null, ConcurrentLinkedListKt.f142427a);
    }

    public final void n() {
        Object obj;
        if (l()) {
            return;
        }
        while (true) {
            ConcurrentLinkedListNode concurrentLinkedListNodeD = d();
            ConcurrentLinkedListNode concurrentLinkedListNodeE = e();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f142429b;
            do {
                obj = atomicReferenceFieldUpdater.get(concurrentLinkedListNodeE);
            } while (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, concurrentLinkedListNodeE, obj, ((ConcurrentLinkedListNode) obj) == null ? null : concurrentLinkedListNodeD));
            if (concurrentLinkedListNodeD != null) {
                f142428a.set(concurrentLinkedListNodeD, concurrentLinkedListNodeE);
            }
            if (!concurrentLinkedListNodeE.k() || concurrentLinkedListNodeE.l()) {
                if (concurrentLinkedListNodeD == null || !concurrentLinkedListNodeD.k()) {
                    return;
                }
            }
        }
    }

    public final boolean o(ConcurrentLinkedListNode concurrentLinkedListNode) {
        return androidx.concurrent.futures.a.a(f142428a, this, null, concurrentLinkedListNode);
    }
}
