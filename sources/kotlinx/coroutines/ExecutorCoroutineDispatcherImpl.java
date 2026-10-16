package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

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
public final class ExecutorCoroutineDispatcherImpl extends ExecutorCoroutineDispatcher implements Delay {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Executor f140957c;

    public ExecutorCoroutineDispatcherImpl(Executor executor) {
        this.f140957c = executor;
        if (w0() instanceof ScheduledThreadPoolExecutor) {
            ((ScheduledThreadPoolExecutor) w0()).setRemoveOnCancelPolicy(true);
        }
    }

    private final ScheduledFuture O0(ScheduledExecutorService scheduledExecutorService, Runnable runnable, CoroutineContext coroutineContext, long j3) {
        try {
            return scheduledExecutorService.schedule(runnable, j3, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e3) {
            z0(coroutineContext, e3);
            return null;
        }
    }

    private final void z0(CoroutineContext coroutineContext, RejectedExecutionException rejectedExecutionException) {
        JobKt.c(coroutineContext, ExceptionsKt.a("The task was rejected", rejectedExecutionException));
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void M(CoroutineContext coroutineContext, Runnable runnable) {
        Runnable runnableH;
        try {
            Executor executorW0 = w0();
            AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.f140870a;
            if (abstractTimeSource == null || (runnableH = abstractTimeSource.h(runnable)) == null) {
                runnableH = runnable;
            }
            executorW0.execute(runnableH);
        } catch (RejectedExecutionException e3) {
            AbstractTimeSource abstractTimeSource2 = AbstractTimeSourceKt.f140870a;
            if (abstractTimeSource2 != null) {
                abstractTimeSource2.e();
            }
            z0(coroutineContext, e3);
            Dispatchers.b().M(coroutineContext, runnable);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Executor executorW0 = w0();
        ExecutorService executorService = executorW0 instanceof ExecutorService ? (ExecutorService) executorW0 : null;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof ExecutorCoroutineDispatcherImpl) && ((ExecutorCoroutineDispatcherImpl) obj).w0() == w0();
    }

    public int hashCode() {
        return System.identityHashCode(w0());
    }

    @Override // kotlinx.coroutines.Delay
    public void i(long j3, CancellableContinuation cancellableContinuation) {
        long j4;
        Executor executorW0 = w0();
        ScheduledFuture scheduledFutureO0 = null;
        ScheduledExecutorService scheduledExecutorService = executorW0 instanceof ScheduledExecutorService ? (ScheduledExecutorService) executorW0 : null;
        if (scheduledExecutorService != null) {
            j4 = j3;
            scheduledFutureO0 = O0(scheduledExecutorService, new ResumeUndispatchedRunnable(this, cancellableContinuation), cancellableContinuation.getContext(), j4);
        } else {
            j4 = j3;
        }
        if (scheduledFutureO0 != null) {
            CancellableContinuationKt.c(cancellableContinuation, new CancelFutureOnCancel(scheduledFutureO0));
        } else {
            DefaultExecutor.f140926i.i(j4, cancellableContinuation);
        }
    }

    @Override // kotlinx.coroutines.Delay
    public DisposableHandle m(long j3, Runnable runnable, CoroutineContext coroutineContext) {
        long j4;
        Runnable runnable2;
        CoroutineContext coroutineContext2;
        Executor executorW0 = w0();
        ScheduledFuture scheduledFutureO0 = null;
        ScheduledExecutorService scheduledExecutorService = executorW0 instanceof ScheduledExecutorService ? (ScheduledExecutorService) executorW0 : null;
        if (scheduledExecutorService != null) {
            j4 = j3;
            runnable2 = runnable;
            coroutineContext2 = coroutineContext;
            scheduledFutureO0 = O0(scheduledExecutorService, runnable2, coroutineContext2, j4);
        } else {
            j4 = j3;
            runnable2 = runnable;
            coroutineContext2 = coroutineContext;
        }
        return scheduledFutureO0 != null ? new DisposableFutureHandle(scheduledFutureO0) : DefaultExecutor.f140926i.m(j4, runnable2, coroutineContext2);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        return w0().toString();
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    public Executor w0() {
        return this.f140957c;
    }
}
