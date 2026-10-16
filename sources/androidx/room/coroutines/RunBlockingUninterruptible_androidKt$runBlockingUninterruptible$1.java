package androidx.room.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@DebugMetadata(c = "androidx.room.coroutines.RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1", f = "RunBlockingUninterruptible.android.kt", l = {}, m = "invokeSuspend")
final class RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<Object>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f52633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f52634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function2 f52635c;

    /* JADX INFO: renamed from: androidx.room.coroutines.RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.room.coroutines.RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1$1", f = "RunBlockingUninterruptible.android.kt", l = {52}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f52636a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f52637b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ CompletableDeferred f52638c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function2 f52639d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(CompletableDeferred completableDeferred, Function2 function2, Continuation continuation) {
            super(2, continuation);
            this.f52638c = completableDeferred;
            this.f52639d = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f52638c, this.f52639d, continuation);
            anonymousClass1.f52637b = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            CompletableDeferred completableDeferred;
            Object objB;
            Object objF = IntrinsicsKt.f();
            int i3 = this.f52636a;
            if (i3 == 0) {
                ResultKt.b(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.f52637b;
                CompletableDeferred completableDeferred2 = this.f52638c;
                Function2 function2 = this.f52639d;
                try {
                    Result.Companion companion = Result.f139772b;
                    this.f52637b = completableDeferred2;
                    this.f52636a = 1;
                    obj = function2.invoke(coroutineScope, this);
                    if (obj == objF) {
                        return objF;
                    }
                    completableDeferred = completableDeferred2;
                } catch (Throwable th) {
                    th = th;
                    completableDeferred = completableDeferred2;
                    Result.Companion companion2 = Result.f139772b;
                    objB = Result.b(ResultKt.a(th));
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                completableDeferred = (CompletableDeferred) this.f52637b;
                try {
                    ResultKt.b(obj);
                } catch (Throwable th2) {
                    th = th2;
                    Result.Companion companion22 = Result.f139772b;
                    objB = Result.b(ResultKt.a(th));
                }
            }
            objB = Result.b(obj);
            CompletableDeferredKt.c(completableDeferred, objB);
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: androidx.room.coroutines.RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.room.coroutines.RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1$2", f = "RunBlockingUninterruptible.android.kt", l = {58}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<Object>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f52640a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ CompletableDeferred f52641b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(CompletableDeferred completableDeferred, Continuation continuation) {
            super(2, continuation);
            this.f52641b = completableDeferred;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass2(this.f52641b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f52640a;
            if (i3 != 0) {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return obj;
            }
            ResultKt.b(obj);
            CompletableDeferred completableDeferred = this.f52641b;
            this.f52640a = 1;
            Object objAwait = completableDeferred.await(this);
            return objAwait == objF ? objF : objAwait;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1(Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.f52635c = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1 runBlockingUninterruptible_androidKt$runBlockingUninterruptible$1 = new RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1(this.f52635c, continuation);
        runBlockingUninterruptible_androidKt$runBlockingUninterruptible$1.f52634b = obj;
        return runBlockingUninterruptible_androidKt$runBlockingUninterruptible$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f52633a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        CoroutineContext.Element element = ((CoroutineScope) this.f52634b).getCoroutineContext().get(ContinuationInterceptor.t8);
        Intrinsics.checkNotNull(element);
        ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) element;
        CompletableDeferred completableDeferredB = CompletableDeferredKt.b(null, 1, null);
        BuildersKt.c(GlobalScope.f140958a, continuationInterceptor, CoroutineStart.f140919d, new AnonymousClass1(completableDeferredB, this.f52635c, null));
        while (!completableDeferredB.isCompleted()) {
            try {
                return BuildersKt.e(continuationInterceptor, new AnonymousClass2(completableDeferredB, null));
            } catch (InterruptedException unused) {
            }
        }
        return completableDeferredB.getCompleted();
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
