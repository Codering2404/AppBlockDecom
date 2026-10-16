package kotlinx.coroutines;

import androidx.compose.material.icons.twotone.Phg.QaXmqxvjHhxVy;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
final class AwaitAll<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f140872b = AtomicIntegerFieldUpdater.newUpdater(AwaitAll.class, "notCompletedCount$volatile");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Deferred[] f140873a;
    private volatile /* synthetic */ int notCompletedCount$volatile;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private final class AwaitAllNode extends JobNode {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final /* synthetic */ AtomicReferenceFieldUpdater f140874i = AtomicReferenceFieldUpdater.newUpdater(AwaitAllNode.class, Object.class, QaXmqxvjHhxVy.leppfoJYHgi);
        private volatile /* synthetic */ Object _disposer$volatile;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final CancellableContinuation f140875f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public DisposableHandle f140876g;

        public AwaitAllNode(CancellableContinuation cancellableContinuation) {
            this.f140875f = cancellableContinuation;
        }

        public final void A(DisposeHandlersOnCancel disposeHandlersOnCancel) {
            f140874i.set(this, disposeHandlersOnCancel);
        }

        public final void B(DisposableHandle disposableHandle) {
            this.f140876g = disposableHandle;
        }

        @Override // kotlinx.coroutines.JobNode
        public boolean u() {
            return false;
        }

        @Override // kotlinx.coroutines.JobNode
        public void v(Throwable th) {
            if (th != null) {
                Object objP = this.f140875f.p(th);
                if (objP != null) {
                    this.f140875f.R(objP);
                    DisposeHandlersOnCancel disposeHandlersOnCancelX = x();
                    if (disposeHandlersOnCancelX != null) {
                        disposeHandlersOnCancelX.a();
                        return;
                    }
                    return;
                }
                return;
            }
            if (AwaitAll.d().decrementAndGet(AwaitAll.this) == 0) {
                CancellableContinuation cancellableContinuation = this.f140875f;
                Deferred[] deferredArr = AwaitAll.this.f140873a;
                ArrayList arrayList = new ArrayList(deferredArr.length);
                for (Deferred deferred : deferredArr) {
                    arrayList.add(deferred.getCompleted());
                }
                cancellableContinuation.resumeWith(Result.b(arrayList));
            }
        }

        public final DisposeHandlersOnCancel x() {
            return (DisposeHandlersOnCancel) f140874i.get(this);
        }

        public final DisposableHandle y() {
            DisposableHandle disposableHandle = this.f140876g;
            if (disposableHandle != null) {
                return disposableHandle;
            }
            Intrinsics.throwUninitializedPropertyAccessException("handle");
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private final class DisposeHandlersOnCancel implements CancelHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AwaitAllNode[] f140878a;

        public DisposeHandlersOnCancel(AwaitAllNode[] awaitAllNodeArr) {
            this.f140878a = awaitAllNodeArr;
        }

        public final void a() {
            for (AwaitAllNode awaitAllNode : this.f140878a) {
                awaitAllNode.y().dispose();
            }
        }

        @Override // kotlinx.coroutines.CancelHandler
        public void c(Throwable th) {
            a();
        }

        public String toString() {
            return "DisposeHandlersOnCancel[" + this.f140878a + ']';
        }
    }

    public AwaitAll(Deferred[] deferredArr) {
        this.f140873a = deferredArr;
        this.notCompletedCount$volatile = deferredArr.length;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ AtomicIntegerFieldUpdater d() {
        return f140872b;
    }

    public final Object c(Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        int length = this.f140873a.length;
        AwaitAllNode[] awaitAllNodeArr = new AwaitAllNode[length];
        for (int i3 = 0; i3 < length; i3++) {
            Deferred deferred = this.f140873a[i3];
            deferred.start();
            AwaitAllNode awaitAllNode = new AwaitAllNode(cancellableContinuationImpl);
            awaitAllNode.B(JobKt__JobKt.o(deferred, false, awaitAllNode, 1, null));
            Unit unit = Unit.f139807a;
            awaitAllNodeArr[i3] = awaitAllNode;
        }
        DisposeHandlersOnCancel disposeHandlersOnCancel = new DisposeHandlersOnCancel(awaitAllNodeArr);
        for (int i4 = 0; i4 < length; i4++) {
            awaitAllNodeArr[i4].A(disposeHandlersOnCancel);
        }
        if (cancellableContinuationImpl.isCompleted()) {
            disposeHandlersOnCancel.a();
        } else {
            CancellableContinuationKt.c(cancellableContinuationImpl, disposeHandlersOnCancel);
        }
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV;
    }
}
