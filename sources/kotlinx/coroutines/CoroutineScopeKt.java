package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.intrinsics.UndispatchedKt;

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
public final class CoroutineScopeKt {
    public static final CoroutineScope a(CoroutineContext coroutineContext) {
        if (coroutineContext.get(Job.v8) == null) {
            coroutineContext = coroutineContext.plus(JobKt__JobKt.b(null, 1, null));
        }
        return new ContextScope(coroutineContext);
    }

    public static final CoroutineScope b() {
        return new ContextScope(SupervisorKt.b(null, 1, null).plus(Dispatchers.c()));
    }

    public static final void c(CoroutineScope coroutineScope, String str, Throwable th) {
        d(coroutineScope, ExceptionsKt.a(str, th));
    }

    public static final void d(CoroutineScope coroutineScope, CancellationException cancellationException) {
        Job job = (Job) coroutineScope.getCoroutineContext().get(Job.v8);
        if (job != null) {
            job.cancel(cancellationException);
            return;
        }
        throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + coroutineScope).toString());
    }

    public static /* synthetic */ void e(CoroutineScope coroutineScope, CancellationException cancellationException, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            cancellationException = null;
        }
        d(coroutineScope, cancellationException);
    }

    public static final Object f(Function2 function2, Continuation continuation) {
        ScopeCoroutine scopeCoroutine = new ScopeCoroutine(continuation.getContext(), continuation);
        Object objB = UndispatchedKt.b(scopeCoroutine, scopeCoroutine, function2);
        if (objB == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objB;
    }

    public static final void g(CoroutineScope coroutineScope) {
        JobKt.k(coroutineScope.getCoroutineContext());
    }

    public static final boolean h(CoroutineScope coroutineScope) {
        Job job = (Job) coroutineScope.getCoroutineContext().get(Job.v8);
        if (job != null) {
            return job.isActive();
        }
        return true;
    }

    public static final CoroutineScope i(CoroutineScope coroutineScope, CoroutineContext coroutineContext) {
        return new ContextScope(coroutineScope.getCoroutineContext().plus(coroutineContext));
    }
}
