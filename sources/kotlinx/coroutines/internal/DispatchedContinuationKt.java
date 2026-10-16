package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.ThreadLocalEventLoop;

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
public final class DispatchedContinuationKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Symbol f142438a = new Symbol("UNDEFINED");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Symbol f142439b = new Symbol("REUSABLE_CLAIMED");

    /* JADX WARN: Removed duplicated region for block: B:27:0x008e A[Catch: all -> 0x0067, DONT_GENERATE, TryCatch #0 {all -> 0x0067, blocks: (B:11:0x003e, B:13:0x004c, B:15:0x0052, B:28:0x0091, B:18:0x0069, B:20:0x0079, B:25:0x0088, B:27:0x008e, B:33:0x009e, B:36:0x00a7, B:35:0x00a4, B:23:0x007f), top: B:45:0x003e, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void b(kotlin.coroutines.Continuation r6, java.lang.Object r7) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.internal.DispatchedContinuation
            if (r0 == 0) goto Lb2
            kotlinx.coroutines.internal.DispatchedContinuation r6 = (kotlinx.coroutines.internal.DispatchedContinuation) r6
            java.lang.Object r0 = kotlinx.coroutines.CompletionStateKt.b(r7)
            kotlinx.coroutines.CoroutineDispatcher r1 = r6.f142434d
            kotlin.coroutines.CoroutineContext r2 = r6.getContext()
            boolean r1 = r1.e0(r2)
            r2 = 1
            if (r1 == 0) goto L26
            r6.f142436g = r0
            r6.f140933c = r2
            kotlinx.coroutines.CoroutineDispatcher r7 = r6.f142434d
            kotlin.coroutines.CoroutineContext r0 = r6.getContext()
            r7.M(r0, r6)
            goto Lac
        L26:
            kotlinx.coroutines.ThreadLocalEventLoop r1 = kotlinx.coroutines.ThreadLocalEventLoop.f141011a
            kotlinx.coroutines.EventLoop r1 = r1.b()
            boolean r3 = r1.i1()
            if (r3 == 0) goto L3b
            r6.f142436g = r0
            r6.f140933c = r2
            r1.R0(r6)
            goto Lac
        L3b:
            r1.a1(r2)
            kotlin.coroutines.CoroutineContext r3 = r6.getContext()     // Catch: java.lang.Throwable -> L67
            kotlinx.coroutines.Job$Key r4 = kotlinx.coroutines.Job.v8     // Catch: java.lang.Throwable -> L67
            kotlin.coroutines.CoroutineContext$Element r3 = r3.get(r4)     // Catch: java.lang.Throwable -> L67
            kotlinx.coroutines.Job r3 = (kotlinx.coroutines.Job) r3     // Catch: java.lang.Throwable -> L67
            if (r3 == 0) goto L69
            boolean r4 = r3.isActive()     // Catch: java.lang.Throwable -> L67
            if (r4 != 0) goto L69
            java.util.concurrent.CancellationException r7 = r3.getCancellationException()     // Catch: java.lang.Throwable -> L67
            r6.a(r0, r7)     // Catch: java.lang.Throwable -> L67
            kotlin.Result$Companion r0 = kotlin.Result.f139772b     // Catch: java.lang.Throwable -> L67
            java.lang.Object r7 = kotlin.ResultKt.a(r7)     // Catch: java.lang.Throwable -> L67
            java.lang.Object r7 = kotlin.Result.b(r7)     // Catch: java.lang.Throwable -> L67
            r6.resumeWith(r7)     // Catch: java.lang.Throwable -> L67
            goto L91
        L67:
            r7 = move-exception
            goto La8
        L69:
            kotlin.coroutines.Continuation r0 = r6.f142435f     // Catch: java.lang.Throwable -> L67
            java.lang.Object r3 = r6.f142437h     // Catch: java.lang.Throwable -> L67
            kotlin.coroutines.CoroutineContext r4 = r0.getContext()     // Catch: java.lang.Throwable -> L67
            java.lang.Object r3 = kotlinx.coroutines.internal.ThreadContextKt.i(r4, r3)     // Catch: java.lang.Throwable -> L67
            kotlinx.coroutines.internal.Symbol r5 = kotlinx.coroutines.internal.ThreadContextKt.f142489a     // Catch: java.lang.Throwable -> L67
            if (r3 == r5) goto L7e
            kotlinx.coroutines.UndispatchedCoroutine r0 = kotlinx.coroutines.CoroutineContextKt.m(r0, r4, r3)     // Catch: java.lang.Throwable -> L67
            goto L7f
        L7e:
            r0 = 0
        L7f:
            kotlin.coroutines.Continuation r5 = r6.f142435f     // Catch: java.lang.Throwable -> L9b
            r5.resumeWith(r7)     // Catch: java.lang.Throwable -> L9b
            kotlin.Unit r7 = kotlin.Unit.f139807a     // Catch: java.lang.Throwable -> L9b
            if (r0 == 0) goto L8e
            boolean r7 = r0.f1()     // Catch: java.lang.Throwable -> L67
            if (r7 == 0) goto L91
        L8e:
            kotlinx.coroutines.internal.ThreadContextKt.f(r4, r3)     // Catch: java.lang.Throwable -> L67
        L91:
            boolean r7 = r1.u1()     // Catch: java.lang.Throwable -> L67
            if (r7 != 0) goto L91
        L97:
            r1.w0(r2)
            goto Lac
        L9b:
            r7 = move-exception
            if (r0 == 0) goto La4
            boolean r0 = r0.f1()     // Catch: java.lang.Throwable -> L67
            if (r0 == 0) goto La7
        La4:
            kotlinx.coroutines.internal.ThreadContextKt.f(r4, r3)     // Catch: java.lang.Throwable -> L67
        La7:
            throw r7     // Catch: java.lang.Throwable -> L67
        La8:
            r6.f(r7)     // Catch: java.lang.Throwable -> Lad
            goto L97
        Lac:
            return
        Lad:
            r6 = move-exception
            r1.w0(r2)
            throw r6
        Lb2:
            r6.resumeWith(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.DispatchedContinuationKt.b(kotlin.coroutines.Continuation, java.lang.Object):void");
    }

    public static final boolean c(DispatchedContinuation dispatchedContinuation) {
        Unit unit = Unit.f139807a;
        EventLoop eventLoopB = ThreadLocalEventLoop.f141011a.b();
        if (eventLoopB.o1()) {
            return false;
        }
        if (eventLoopB.i1()) {
            dispatchedContinuation.f142436g = unit;
            dispatchedContinuation.f140933c = 1;
            eventLoopB.R0(dispatchedContinuation);
            return true;
        }
        eventLoopB.a1(true);
        try {
            dispatchedContinuation.run();
            do {
            } while (eventLoopB.u1());
        } finally {
            try {
            } finally {
            }
        }
        return false;
    }
}
