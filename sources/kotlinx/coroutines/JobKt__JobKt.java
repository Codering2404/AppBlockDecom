package kotlinx.coroutines;

import java.util.Iterator;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.Job;

/* JADX INFO: Access modifiers changed from: package-private */
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
public final /* synthetic */ class JobKt__JobKt {
    public static final CompletableJob a(Job job) {
        return new JobImpl(job);
    }

    public static /* synthetic */ CompletableJob b(Job job, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            job = null;
        }
        return JobKt.a(job);
    }

    public static final void c(CoroutineContext coroutineContext, CancellationException cancellationException) {
        Job job = (Job) coroutineContext.get(Job.v8);
        if (job != null) {
            job.cancel(cancellationException);
        }
    }

    public static final void d(Job job, String str, Throwable th) {
        job.cancel(ExceptionsKt.a(str, th));
    }

    public static /* synthetic */ void e(CoroutineContext coroutineContext, CancellationException cancellationException, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            cancellationException = null;
        }
        JobKt.c(coroutineContext, cancellationException);
    }

    public static /* synthetic */ void f(Job job, String str, Throwable th, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            th = null;
        }
        JobKt.d(job, str, th);
    }

    public static final Object g(Job job, Continuation continuation) {
        Job.DefaultImpls.b(job, null, 1, null);
        Object objJoin = job.join(continuation);
        return objJoin == IntrinsicsKt.f() ? objJoin : Unit.f139807a;
    }

    public static final void h(CoroutineContext coroutineContext, CancellationException cancellationException) {
        Sequence children;
        Job job = (Job) coroutineContext.get(Job.v8);
        if (job == null || (children = job.getChildren()) == null) {
            return;
        }
        Iterator it = children.iterator();
        while (it.hasNext()) {
            ((Job) it.next()).cancel(cancellationException);
        }
    }

    public static /* synthetic */ void i(CoroutineContext coroutineContext, CancellationException cancellationException, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            cancellationException = null;
        }
        JobKt.h(coroutineContext, cancellationException);
    }

    public static final DisposableHandle j(Job job, DisposableHandle disposableHandle) {
        return o(job, false, new DisposeOnCompletion(disposableHandle), 1, null);
    }

    public static final void k(CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.v8);
        if (job != null) {
            JobKt.l(job);
        }
    }

    public static final void l(Job job) {
        if (!job.isActive()) {
            throw job.getCancellationException();
        }
    }

    public static final Job m(CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.v8);
        if (job != null) {
            return job;
        }
        throw new IllegalStateException(("Current context doesn't contain Job in it: " + coroutineContext).toString());
    }

    public static final DisposableHandle n(Job job, boolean z2, JobNode jobNode) {
        return job instanceof JobSupport ? ((JobSupport) job).w0(z2, jobNode) : job.invokeOnCompletion(jobNode.u(), z2, new JobKt__JobKt$invokeOnCompletion$1(jobNode));
    }

    public static /* synthetic */ DisposableHandle o(Job job, boolean z2, JobNode jobNode, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = true;
        }
        return JobKt.n(job, z2, jobNode);
    }

    public static final boolean p(CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.v8);
        if (job != null) {
            return job.isActive();
        }
        return true;
    }
}
