package kotlin.coroutines.intrinsics;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.RestrictedContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

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
public class IntrinsicsKt__IntrinsicsJvmKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static Continuation a(final Function2 function2, final Object obj, Continuation completion) {
        Intrinsics.checkNotNullParameter(function2, "<this>");
        Intrinsics.checkNotNullParameter(completion, "completion");
        final Continuation<?> continuationA = DebugProbesKt.a(completion);
        if (function2 instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) function2).create(obj, continuationA);
        }
        final CoroutineContext context = continuationA.getContext();
        return context == EmptyCoroutineContext.f139889a ? new RestrictedContinuationImpl(continuationA, function2, obj) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$3

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private int f139908a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Function2 f139909b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ Object f139910c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(continuationA);
                this.f139909b = function2;
                this.f139910c = obj;
                Intrinsics.checkNotNull(continuationA, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            protected Object invokeSuspend(Object obj2) throws Throwable {
                int i3 = this.f139908a;
                if (i3 == 0) {
                    this.f139908a = 1;
                    ResultKt.b(obj2);
                    Intrinsics.checkNotNull(this.f139909b, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted>, kotlin.Any?>");
                    return ((Function2) TypeIntrinsics.f(this.f139909b, 2)).invoke(this.f139910c, this);
                }
                if (i3 != 1) {
                    throw new IllegalStateException("This coroutine had already completed");
                }
                this.f139908a = 2;
                ResultKt.b(obj2);
                return obj2;
            }
        } : new ContinuationImpl(continuationA, context, function2, obj) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private int f139911a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Function2 f139912b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ Object f139913c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(continuationA, context);
                this.f139912b = function2;
                this.f139913c = obj;
                Intrinsics.checkNotNull(continuationA, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            protected Object invokeSuspend(Object obj2) throws Throwable {
                int i3 = this.f139911a;
                if (i3 == 0) {
                    this.f139911a = 1;
                    ResultKt.b(obj2);
                    Intrinsics.checkNotNull(this.f139912b, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted>, kotlin.Any?>");
                    return ((Function2) TypeIntrinsics.f(this.f139912b, 2)).invoke(this.f139913c, this);
                }
                if (i3 != 1) {
                    throw new IllegalStateException("This coroutine had already completed");
                }
                this.f139911a = 2;
                ResultKt.b(obj2);
                return obj2;
            }
        };
    }

    private static final Continuation b(final Continuation continuation) {
        final CoroutineContext context = continuation.getContext();
        return context == EmptyCoroutineContext.f139889a ? new RestrictedContinuationImpl(continuation) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(continuation);
                Intrinsics.checkNotNull(continuation, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            protected Object invokeSuspend(Object obj) throws Throwable {
                ResultKt.b(obj);
                return obj;
            }
        } : new ContinuationImpl(continuation, context) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(continuation, context);
                Intrinsics.checkNotNull(continuation, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            protected Object invokeSuspend(Object obj) throws Throwable {
                ResultKt.b(obj);
                return obj;
            }
        };
    }

    public static Continuation c(Continuation continuation) {
        Continuation<Object> continuationIntercepted;
        Intrinsics.checkNotNullParameter(continuation, "<this>");
        ContinuationImpl continuationImpl = continuation instanceof ContinuationImpl ? (ContinuationImpl) continuation : null;
        return (continuationImpl == null || (continuationIntercepted = continuationImpl.intercepted()) == null) ? continuation : continuationIntercepted;
    }

    public static Object d(Function2 function2, Object obj, Continuation completion) {
        Intrinsics.checkNotNullParameter(function2, "<this>");
        Intrinsics.checkNotNullParameter(completion, "completion");
        return ((Function2) TypeIntrinsics.f(function2, 2)).invoke(obj, b(DebugProbesKt.a(completion)));
    }

    public static Object e(Function3 function3, Object obj, Object obj2, Continuation completion) {
        Intrinsics.checkNotNullParameter(function3, "<this>");
        Intrinsics.checkNotNullParameter(completion, "completion");
        return ((Function3) TypeIntrinsics.f(function3, 3)).invoke(obj, obj2, b(DebugProbesKt.a(completion)));
    }
}
