package kotlin;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

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
final class DeepRecursiveScopeImpl<T, R> extends DeepRecursiveScope<T, R> implements Continuation<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Function3 f139739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object f139740b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Continuation f139741c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object f139742d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeepRecursiveScopeImpl(Function3 block, Object obj) {
        super(null);
        Intrinsics.checkNotNullParameter(block, "block");
        this.f139739a = block;
        this.f139740b = obj;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        this.f139741c = this;
        this.f139742d = DeepRecursiveKt.f139738a;
    }

    @Override // kotlin.DeepRecursiveScope
    public Object a(Object obj, Continuation continuation) {
        Intrinsics.checkNotNull(continuation, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        this.f139741c = continuation;
        this.f139740b = obj;
        Object objF = IntrinsicsKt.f();
        if (objF == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objF;
    }

    public final Object e() throws Throwable {
        while (true) {
            Object obj = this.f139742d;
            Continuation continuation = this.f139741c;
            if (continuation == null) {
                ResultKt.b(obj);
                return obj;
            }
            if (Result.d(DeepRecursiveKt.f139738a, obj)) {
                try {
                    Function3 function3 = this.f139739a;
                    Object obj2 = this.f139740b;
                    Object objE = !(function3 instanceof BaseContinuationImpl) ? IntrinsicsKt.e(function3, this, obj2, continuation) : ((Function3) TypeIntrinsics.f(function3, 3)).invoke(this, obj2, continuation);
                    if (objE != IntrinsicsKt.f()) {
                        continuation.resumeWith(Result.b(objE));
                    }
                } catch (Throwable th) {
                    Result.Companion companion = Result.f139772b;
                    continuation.resumeWith(Result.b(ResultKt.a(th)));
                }
            } else {
                this.f139742d = DeepRecursiveKt.f139738a;
                continuation.resumeWith(obj);
            }
        }
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return EmptyCoroutineContext.f139889a;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        this.f139741c = null;
        this.f139742d = obj;
    }
}
