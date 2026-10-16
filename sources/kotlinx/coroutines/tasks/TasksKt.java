package kotlinx.coroutines.tasks;

import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

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
public final class TasksKt {
    public static final Object a(Task task, CancellationTokenSource cancellationTokenSource, Continuation continuation) {
        return c(task, cancellationTokenSource, continuation);
    }

    public static final Object b(Task task, Continuation continuation) {
        return c(task, null, continuation);
    }

    private static final Object c(Task task, final CancellationTokenSource cancellationTokenSource, Continuation continuation) throws Exception {
        if (!task.isComplete()) {
            final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
            cancellableContinuationImpl.C();
            task.addOnCompleteListener(DirectExecutor.f142678a, new OnCompleteListener() { // from class: kotlinx.coroutines.tasks.TasksKt$awaitImpl$2$1
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task2) {
                    Exception exception = task2.getException();
                    if (exception != null) {
                        CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
                        Result.Companion companion = Result.f139772b;
                        cancellableContinuation.resumeWith(Result.b(ResultKt.a(exception)));
                    } else {
                        if (task2.isCanceled()) {
                            CancellableContinuation.DefaultImpls.a(cancellableContinuationImpl, null, 1, null);
                            return;
                        }
                        CancellableContinuation cancellableContinuation2 = cancellableContinuationImpl;
                        Result.Companion companion2 = Result.f139772b;
                        cancellableContinuation2.resumeWith(Result.b(task2.getResult()));
                    }
                }
            });
            if (cancellationTokenSource != null) {
                cancellableContinuationImpl.m(new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.tasks.TasksKt$awaitImpl$2$2
                    public final void c(Throwable th) {
                        cancellationTokenSource.cancel();
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        c((Throwable) obj);
                        return Unit.f139807a;
                    }
                });
            }
            Object objV = cancellableContinuationImpl.v();
            if (objV == IntrinsicsKt.f()) {
                DebugProbesKt.c(continuation);
            }
            return objV;
        }
        Exception exception = task.getException();
        if (exception != null) {
            throw exception;
        }
        if (!task.isCanceled()) {
            return task.getResult();
        }
        throw new CancellationException("Task " + task + " was cancelled normally.");
    }
}
