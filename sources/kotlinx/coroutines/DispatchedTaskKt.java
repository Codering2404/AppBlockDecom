package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.DispatchedContinuation;
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
public final class DispatchedTaskKt {
    public static final void a(DispatchedTask dispatchedTask, int i3) {
        Continuation continuationC = dispatchedTask.c();
        boolean z2 = i3 == 4;
        if (z2 || !(continuationC instanceof DispatchedContinuation) || b(i3) != b(dispatchedTask.f140933c)) {
            d(dispatchedTask, continuationC, z2);
            return;
        }
        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuationC;
        CoroutineDispatcher coroutineDispatcher = dispatchedContinuation.f142434d;
        CoroutineContext context = dispatchedContinuation.getContext();
        if (coroutineDispatcher.e0(context)) {
            coroutineDispatcher.M(context, dispatchedTask);
        } else {
            e(dispatchedTask);
        }
    }

    public static final boolean b(int i3) {
        return i3 == 1 || i3 == 2;
    }

    public static final boolean c(int i3) {
        return i3 == 2;
    }

    public static final void d(DispatchedTask dispatchedTask, Continuation continuation, boolean z2) {
        Object objE;
        Object objG = dispatchedTask.g();
        Throwable thD = dispatchedTask.d(objG);
        if (thD != null) {
            Result.Companion companion = Result.f139772b;
            objE = ResultKt.a(thD);
        } else {
            Result.Companion companion2 = Result.f139772b;
            objE = dispatchedTask.e(objG);
        }
        Object objB = Result.b(objE);
        if (!z2) {
            continuation.resumeWith(objB);
            return;
        }
        Intrinsics.checkNotNull(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
        Continuation continuation2 = dispatchedContinuation.f142435f;
        Object obj = dispatchedContinuation.f142437h;
        CoroutineContext context = continuation2.getContext();
        Object objI = ThreadContextKt.i(context, obj);
        UndispatchedCoroutine undispatchedCoroutineM = objI != ThreadContextKt.f142489a ? CoroutineContextKt.m(continuation2, context, objI) : null;
        try {
            dispatchedContinuation.f142435f.resumeWith(objB);
            Unit unit = Unit.f139807a;
            if (undispatchedCoroutineM == null || undispatchedCoroutineM.f1()) {
                ThreadContextKt.f(context, objI);
            }
        } catch (Throwable th) {
            if (undispatchedCoroutineM == null || undispatchedCoroutineM.f1()) {
                ThreadContextKt.f(context, objI);
            }
            throw th;
        }
    }

    private static final void e(DispatchedTask dispatchedTask) {
        EventLoop eventLoopB = ThreadLocalEventLoop.f141011a.b();
        if (eventLoopB.i1()) {
            eventLoopB.R0(dispatchedTask);
            return;
        }
        eventLoopB.a1(true);
        try {
            d(dispatchedTask, dispatchedTask.c(), true);
            do {
            } while (eventLoopB.u1());
        } finally {
            try {
            } finally {
            }
        }
    }
}
