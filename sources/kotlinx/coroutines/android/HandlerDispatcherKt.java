package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.android.HandlerDispatcherKt;

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
public final class HandlerDispatcherKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HandlerDispatcher f141035a;
    private static volatile Choreographer choreographer;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Object objB;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        try {
            Result.Companion companion = Result.f139772b;
            objB = Result.b(new HandlerContext(c(Looper.getMainLooper(), true), objArr2 == true ? 1 : 0, 2, objArr == true ? 1 : 0));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.f139772b;
            objB = Result.b(ResultKt.a(th));
        }
        f141035a = (HandlerDispatcher) (Result.g(objB) ? null : objB);
    }

    public static final Handler c(Looper looper, boolean z2) throws IllegalAccessException, InvocationTargetException {
        if (!z2) {
            return new Handler(looper);
        }
        Object objInvoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
        Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type android.os.Handler");
        return (Handler) objInvoke;
    }

    public static final HandlerDispatcher d(Handler handler, String str) {
        return new HandlerContext(handler, str);
    }

    private static final void e(Choreographer choreographer2, final CancellableContinuation cancellableContinuation) {
        choreographer2.postFrameCallback(new Choreographer.FrameCallback() { // from class: p2.c
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j3) {
                HandlerDispatcherKt.f(cancellableContinuation, j3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(CancellableContinuation cancellableContinuation, long j3) {
        cancellableContinuation.I(Dispatchers.c(), Long.valueOf(j3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(CancellableContinuation cancellableContinuation) {
        Choreographer choreographer2 = choreographer;
        if (choreographer2 == null) {
            choreographer2 = Choreographer.getInstance();
            Intrinsics.checkNotNull(choreographer2);
            choreographer = choreographer2;
        }
        e(choreographer2, cancellableContinuation);
    }
}
