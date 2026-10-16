package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.scheduling.Task;

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
public abstract class DispatchedTask<T> extends Task {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f140933c;

    public DispatchedTask(int i3) {
        this.f140933c = i3;
    }

    public abstract Continuation c();

    public Throwable d(Object obj) {
        CompletedExceptionally completedExceptionally = obj instanceof CompletedExceptionally ? (CompletedExceptionally) obj : null;
        if (completedExceptionally != null) {
            return completedExceptionally.f140908a;
        }
        return null;
    }

    public final void f(Throwable th) {
        CoroutineExceptionHandlerKt.a(c().getContext(), new CoroutinesInternalError("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    public abstract Object g();

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Continuation continuationC = c();
            Intrinsics.checkNotNull(continuationC, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>");
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuationC;
            Continuation continuation = dispatchedContinuation.f142435f;
            Object obj = dispatchedContinuation.f142437h;
            CoroutineContext context = continuation.getContext();
            Object objI = ThreadContextKt.i(context, obj);
            Job job = null;
            UndispatchedCoroutine undispatchedCoroutineM = objI != ThreadContextKt.f142489a ? CoroutineContextKt.m(continuation, context, objI) : null;
            try {
                CoroutineContext context2 = continuation.getContext();
                Object objG = g();
                Throwable thD = d(objG);
                if (thD == null && DispatchedTaskKt.b(this.f140933c)) {
                    job = (Job) context2.get(Job.v8);
                }
                if (job != null && !job.isActive()) {
                    CancellationException cancellationException = job.getCancellationException();
                    a(objG, cancellationException);
                    Result.Companion companion = Result.f139772b;
                    continuation.resumeWith(Result.b(ResultKt.a(cancellationException)));
                } else if (thD != null) {
                    Result.Companion companion2 = Result.f139772b;
                    continuation.resumeWith(Result.b(ResultKt.a(thD)));
                } else {
                    Result.Companion companion3 = Result.f139772b;
                    continuation.resumeWith(Result.b(e(objG)));
                }
                Unit unit = Unit.f139807a;
                if (undispatchedCoroutineM != null && !undispatchedCoroutineM.f1()) {
                    return;
                }
                ThreadContextKt.f(context, objI);
            } catch (Throwable th) {
                if (undispatchedCoroutineM == null || undispatchedCoroutineM.f1()) {
                    ThreadContextKt.f(context, objI);
                }
                throw th;
            }
        } catch (Throwable th2) {
            f(th2);
        }
    }

    public Object e(Object obj) {
        return obj;
    }

    public void a(Object obj, Throwable th) {
    }
}
