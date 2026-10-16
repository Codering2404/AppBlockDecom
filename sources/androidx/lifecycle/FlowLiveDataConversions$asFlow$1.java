package androidx.lifecycle;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.NonCancellable;
import kotlinx.coroutines.channels.ProducerScope;

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
@DebugMetadata(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1", f = "FlowLiveData.kt", l = {105, 106, 108}, m = "invokeSuspend")
final class FlowLiveDataConversions$asFlow$1 extends SuspendLambda implements Function2<ProducerScope<Object>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f39929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f39930b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ LiveData f39931c;

    /* JADX INFO: renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1", f = "FlowLiveData.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f39932a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ LiveData f39933b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Observer f39934c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(LiveData liveData, Observer observer, Continuation continuation) {
            super(2, continuation);
            this.f39933b = liveData;
            this.f39934c = observer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f39933b, this.f39934c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f39932a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            this.f39933b.k(this.f39934c);
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2", f = "FlowLiveData.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f39935a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ LiveData f39936b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Observer f39937c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(LiveData liveData, Observer observer, Continuation continuation) {
            super(2, continuation);
            this.f39936b = liveData;
            this.f39937c = observer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass2(this.f39936b, this.f39937c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f39935a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            this.f39936b.o(this.f39937c);
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FlowLiveDataConversions$asFlow$1(LiveData liveData, Continuation continuation) {
        super(2, continuation);
        this.f39931c = liveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(ProducerScope producerScope, Object obj) {
        producerScope.h(obj);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        FlowLiveDataConversions$asFlow$1 flowLiveDataConversions$asFlow$1 = new FlowLiveDataConversions$asFlow$1(this.f39931c, continuation);
        flowLiveDataConversions$asFlow$1.f39930b = obj;
        return flowLiveDataConversions$asFlow$1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [androidx.lifecycle.Observer] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v5 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Observer observer;
        Object objF = IntrinsicsKt.f();
        ?? r12 = this.f39929a;
        try {
        } catch (Throwable th) {
            CoroutineContext coroutineContextPlus = Dispatchers.c().w0().plus(NonCancellable.f141003a);
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.f39931c, r12, null);
            this.f39930b = th;
            this.f39929a = 3;
            if (BuildersKt.g(coroutineContextPlus, anonymousClass2, this) != objF) {
                throw th;
            }
        }
        if (r12 == 0) {
            ResultKt.b(obj);
            final ProducerScope producerScope = (ProducerScope) this.f39930b;
            Observer observer2 = new Observer() { // from class: androidx.lifecycle.d
                @Override // androidx.lifecycle.Observer
                public final void a(Object obj2) {
                    FlowLiveDataConversions$asFlow$1.y(producerScope, obj2);
                }
            };
            MainCoroutineDispatcher mainCoroutineDispatcherW0 = Dispatchers.c().w0();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f39931c, observer2, null);
            this.f39930b = observer2;
            this.f39929a = 1;
            observer = observer2;
            if (BuildersKt.g(mainCoroutineDispatcherW0, anonymousClass1, this) == objF) {
            }
            return objF;
        }
        if (r12 != 1) {
            if (r12 == 2) {
                Observer observer3 = (Observer) this.f39930b;
                ResultKt.b(obj);
                r12 = observer3;
                throw new KotlinNothingValueException();
            }
            if (r12 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Throwable th2 = (Throwable) this.f39930b;
            ResultKt.b(obj);
            throw th2;
        }
        Observer observer4 = (Observer) this.f39930b;
        ResultKt.b(obj);
        observer = observer4;
        this.f39930b = observer;
        this.f39929a = 2;
        r12 = observer;
        if (DelayKt.a(this) == objF) {
            return objF;
        }
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public final Object invoke(ProducerScope producerScope, Continuation continuation) {
        return ((FlowLiveDataConversions$asFlow$1) create(producerScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
