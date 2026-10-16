package kotlinx.coroutines.intrinsics;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.JobSupportKt;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.ThreadContextKt;

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
public final class UndispatchedKt {
    public static final void a(Function2 function2, Object obj, Continuation continuation) {
        Continuation continuationA = DebugProbesKt.a(continuation);
        try {
            CoroutineContext context = continuationA.getContext();
            Object objI = ThreadContextKt.i(context, null);
            try {
                DebugProbesKt.b(continuationA);
                Object objD = !(function2 instanceof BaseContinuationImpl) ? IntrinsicsKt.d(function2, obj, continuationA) : ((Function2) TypeIntrinsics.f(function2, 2)).invoke(obj, continuationA);
                ThreadContextKt.f(context, objI);
                if (objD != IntrinsicsKt.f()) {
                    continuationA.resumeWith(Result.b(objD));
                }
            } catch (Throwable th) {
                ThreadContextKt.f(context, objI);
                throw th;
            }
        } catch (Throwable th2) {
            Result.Companion companion = Result.f139772b;
            continuationA.resumeWith(Result.b(ResultKt.a(th2)));
        }
    }

    public static final Object b(ScopeCoroutine scopeCoroutine, Object obj, Function2 function2) {
        Object completedExceptionally;
        try {
            completedExceptionally = !(function2 instanceof BaseContinuationImpl) ? IntrinsicsKt.d(function2, obj, scopeCoroutine) : ((Function2) TypeIntrinsics.f(function2, 2)).invoke(obj, scopeCoroutine);
        } catch (Throwable th) {
            completedExceptionally = new CompletedExceptionally(th, false, 2, null);
        }
        if (completedExceptionally == IntrinsicsKt.f()) {
            return IntrinsicsKt.f();
        }
        Object objC0 = scopeCoroutine.C0(completedExceptionally);
        if (objC0 == JobSupportKt.f140995b) {
            return IntrinsicsKt.f();
        }
        if (objC0 instanceof CompletedExceptionally) {
            throw ((CompletedExceptionally) objC0).f140908a;
        }
        return JobSupportKt.h(objC0);
    }

    public static final Object c(ScopeCoroutine scopeCoroutine, Object obj, Function2 function2) throws Throwable {
        Object completedExceptionally;
        try {
            completedExceptionally = !(function2 instanceof BaseContinuationImpl) ? IntrinsicsKt.d(function2, obj, scopeCoroutine) : ((Function2) TypeIntrinsics.f(function2, 2)).invoke(obj, scopeCoroutine);
        } catch (Throwable th) {
            completedExceptionally = new CompletedExceptionally(th, false, 2, null);
        }
        if (completedExceptionally == IntrinsicsKt.f()) {
            return IntrinsicsKt.f();
        }
        Object objC0 = scopeCoroutine.C0(completedExceptionally);
        if (objC0 == JobSupportKt.f140995b) {
            return IntrinsicsKt.f();
        }
        if (objC0 instanceof CompletedExceptionally) {
            Throwable th2 = ((CompletedExceptionally) objC0).f140908a;
            if (!(th2 instanceof TimeoutCancellationException) || ((TimeoutCancellationException) th2).f141016a != scopeCoroutine) {
                throw th2;
            }
            if (completedExceptionally instanceof CompletedExceptionally) {
                throw ((CompletedExceptionally) completedExceptionally).f140908a;
            }
        } else {
            completedExceptionally = JobSupportKt.h(objC0);
        }
        return completedExceptionally;
    }
}
