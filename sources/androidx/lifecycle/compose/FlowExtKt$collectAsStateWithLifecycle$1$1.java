package androidx.lifecycle.compose;

import androidx.compose.runtime.ProduceStateScope;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.RepeatOnLifecycleKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

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
@DebugMetadata(c = "androidx.lifecycle.compose.FlowExtKt$collectAsStateWithLifecycle$1$1", f = "FlowExt.kt", l = {177}, m = "invokeSuspend")
final class FlowExtKt$collectAsStateWithLifecycle$1$1 extends SuspendLambda implements Function2<ProduceStateScope<Object>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f40150a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f40151b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Lifecycle f40152c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Lifecycle.State f40153d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ CoroutineContext f40154f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Flow f40155g;

    /* JADX INFO: renamed from: androidx.lifecycle.compose.FlowExtKt$collectAsStateWithLifecycle$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.lifecycle.compose.FlowExtKt$collectAsStateWithLifecycle$1$1$1", f = "FlowExt.kt", l = {179, 181}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f40156a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ CoroutineContext f40157b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Flow f40158c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ ProduceStateScope f40159d;

        /* JADX INFO: renamed from: androidx.lifecycle.compose.FlowExtKt$collectAsStateWithLifecycle$1$1$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "androidx.lifecycle.compose.FlowExtKt$collectAsStateWithLifecycle$1$1$1$2", f = "FlowExt.kt", l = {182}, m = "invokeSuspend")
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f40161a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Flow f40162b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ ProduceStateScope f40163c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(Flow flow, ProduceStateScope produceStateScope, Continuation continuation) {
                super(2, continuation);
                this.f40162b = flow;
                this.f40163c = produceStateScope;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new AnonymousClass2(this.f40162b, this.f40163c, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objF = IntrinsicsKt.f();
                int i3 = this.f40161a;
                if (i3 == 0) {
                    ResultKt.b(obj);
                    Flow flow = this.f40162b;
                    final ProduceStateScope produceStateScope = this.f40163c;
                    FlowCollector flowCollector = new FlowCollector() { // from class: androidx.lifecycle.compose.FlowExtKt.collectAsStateWithLifecycle.1.1.1.2.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public final Object emit(Object obj2, Continuation continuation) {
                            produceStateScope.setValue(obj2);
                            return Unit.f139807a;
                        }
                    };
                    this.f40161a = 1;
                    if (flow.collect(flowCollector, this) == objF) {
                        return objF;
                    }
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                return Unit.f139807a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(CoroutineContext coroutineContext, Flow flow, ProduceStateScope produceStateScope, Continuation continuation) {
            super(2, continuation);
            this.f40157b = coroutineContext;
            this.f40158c = flow;
            this.f40159d = produceStateScope;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f40157b, this.f40158c, this.f40159d, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0037, code lost:
        
            if (r7.collect(r1, r6) == r0) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x004c, code lost:
        
            if (kotlinx.coroutines.BuildersKt.g(r7, r1, r6) == r0) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x004e, code lost:
        
            return r0;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r6.f40156a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1b
                if (r1 == r3) goto L17
                if (r1 != r2) goto Lf
                goto L17
            Lf:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L17:
                kotlin.ResultKt.b(r7)
                goto L4f
            L1b:
                kotlin.ResultKt.b(r7)
                kotlin.coroutines.CoroutineContext r7 = r6.f40157b
                kotlin.coroutines.EmptyCoroutineContext r1 = kotlin.coroutines.EmptyCoroutineContext.f139889a
                boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r1)
                if (r7 == 0) goto L3a
                kotlinx.coroutines.flow.Flow r7 = r6.f40158c
                androidx.lifecycle.compose.FlowExtKt$collectAsStateWithLifecycle$1$1$1$1 r1 = new androidx.lifecycle.compose.FlowExtKt$collectAsStateWithLifecycle$1$1$1$1
                androidx.compose.runtime.ProduceStateScope r2 = r6.f40159d
                r1.<init>()
                r6.f40156a = r3
                java.lang.Object r7 = r7.collect(r1, r6)
                if (r7 != r0) goto L4f
                goto L4e
            L3a:
                kotlin.coroutines.CoroutineContext r7 = r6.f40157b
                androidx.lifecycle.compose.FlowExtKt$collectAsStateWithLifecycle$1$1$1$2 r1 = new androidx.lifecycle.compose.FlowExtKt$collectAsStateWithLifecycle$1$1$1$2
                kotlinx.coroutines.flow.Flow r3 = r6.f40158c
                androidx.compose.runtime.ProduceStateScope r4 = r6.f40159d
                r5 = 0
                r1.<init>(r3, r4, r5)
                r6.f40156a = r2
                java.lang.Object r7 = kotlinx.coroutines.BuildersKt.g(r7, r1, r6)
                if (r7 != r0) goto L4f
            L4e:
                return r0
            L4f:
                kotlin.Unit r7 = kotlin.Unit.f139807a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.compose.FlowExtKt$collectAsStateWithLifecycle$1$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FlowExtKt$collectAsStateWithLifecycle$1$1(Lifecycle lifecycle, Lifecycle.State state, CoroutineContext coroutineContext, Flow flow, Continuation continuation) {
        super(2, continuation);
        this.f40152c = lifecycle;
        this.f40153d = state;
        this.f40154f = coroutineContext;
        this.f40155g = flow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        FlowExtKt$collectAsStateWithLifecycle$1$1 flowExtKt$collectAsStateWithLifecycle$1$1 = new FlowExtKt$collectAsStateWithLifecycle$1$1(this.f40152c, this.f40153d, this.f40154f, this.f40155g, continuation);
        flowExtKt$collectAsStateWithLifecycle$1$1.f40151b = obj;
        return flowExtKt$collectAsStateWithLifecycle$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(ProduceStateScope produceStateScope, Continuation continuation) {
        return ((FlowExtKt$collectAsStateWithLifecycle$1$1) create(produceStateScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f40150a;
        if (i3 == 0) {
            ResultKt.b(obj);
            ProduceStateScope produceStateScope = (ProduceStateScope) this.f40151b;
            Lifecycle lifecycle = this.f40152c;
            Lifecycle.State state = this.f40153d;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f40154f, this.f40155g, produceStateScope, null);
            this.f40150a = 1;
            if (RepeatOnLifecycleKt.a(lifecycle, state, anonymousClass1, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f139807a;
    }
}
