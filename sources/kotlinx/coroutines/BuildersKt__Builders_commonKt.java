package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;

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
public final /* synthetic */ class BuildersKt__Builders_commonKt {
    public static final Deferred a(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2) {
        CoroutineContext coroutineContextK = CoroutineContextKt.k(coroutineScope, coroutineContext);
        DeferredCoroutine lazyDeferredCoroutine = coroutineStart.c() ? new LazyDeferredCoroutine(coroutineContextK, function2) : new DeferredCoroutine(coroutineContextK, true);
        lazyDeferredCoroutine.e1(coroutineStart, lazyDeferredCoroutine, function2);
        return lazyDeferredCoroutine;
    }

    public static /* synthetic */ Deferred b(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.f139889a;
        }
        if ((i3 & 2) != 0) {
            coroutineStart = CoroutineStart.f140916a;
        }
        return BuildersKt.a(coroutineScope, coroutineContext, coroutineStart, function2);
    }

    public static final Job c(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2) {
        CoroutineContext coroutineContextK = CoroutineContextKt.k(coroutineScope, coroutineContext);
        StandaloneCoroutine lazyStandaloneCoroutine = coroutineStart.c() ? new LazyStandaloneCoroutine(coroutineContextK, function2) : new StandaloneCoroutine(coroutineContextK, true);
        lazyStandaloneCoroutine.e1(coroutineStart, lazyStandaloneCoroutine, function2);
        return lazyStandaloneCoroutine;
    }

    public static /* synthetic */ Job d(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.f139889a;
        }
        if ((i3 & 2) != 0) {
            coroutineStart = CoroutineStart.f140916a;
        }
        return BuildersKt.c(coroutineScope, coroutineContext, coroutineStart, function2);
    }

    public static final Object e(CoroutineContext coroutineContext, Function2 function2, Continuation continuation) {
        Object objF1;
        CoroutineContext context = continuation.getContext();
        CoroutineContext coroutineContextJ = CoroutineContextKt.j(context, coroutineContext);
        JobKt.k(coroutineContextJ);
        if (coroutineContextJ == context) {
            ScopeCoroutine scopeCoroutine = new ScopeCoroutine(coroutineContextJ, continuation);
            objF1 = UndispatchedKt.b(scopeCoroutine, scopeCoroutine, function2);
        } else {
            ContinuationInterceptor.Key key = ContinuationInterceptor.t8;
            if (Intrinsics.areEqual(coroutineContextJ.get(key), context.get(key))) {
                UndispatchedCoroutine undispatchedCoroutine = new UndispatchedCoroutine(coroutineContextJ, continuation);
                CoroutineContext context2 = undispatchedCoroutine.getContext();
                Object objI = ThreadContextKt.i(context2, null);
                try {
                    Object objB = UndispatchedKt.b(undispatchedCoroutine, undispatchedCoroutine, function2);
                    ThreadContextKt.f(context2, objI);
                    objF1 = objB;
                } catch (Throwable th) {
                    ThreadContextKt.f(context2, objI);
                    throw th;
                }
            } else {
                DispatchedCoroutine dispatchedCoroutine = new DispatchedCoroutine(coroutineContextJ, continuation);
                CancellableKt.c(function2, dispatchedCoroutine, dispatchedCoroutine);
                objF1 = dispatchedCoroutine.f1();
            }
        }
        if (objF1 == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objF1;
    }
}
