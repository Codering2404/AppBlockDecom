package androidx.paging;

import androidx.paging.LoadState;
import androidx.paging.PageEvent;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Add missing generic type declarations: [Value] */
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
@DebugMetadata(c = "androidx.paging.PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1", f = "PageFetcher.kt", l = {161}, m = "invokeSuspend")
public final class PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1<Value> extends SuspendLambda implements Function2<SimpleProducerScope<PageEvent<Value>>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f50074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f50075b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Flow f50076c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Flow f50077d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ MutableLoadStateCollection f50078f;

    /* JADX INFO: renamed from: androidx.paging.PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.paging.PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1$1", f = "PageFetcher.kt", l = {141}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function4<LoadStates, PageEvent<Value>, CombineSource, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f50079a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f50080b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f50081c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f50082d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ SimpleProducerScope f50083f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ MutableLoadStateCollection f50084g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SimpleProducerScope simpleProducerScope, Continuation continuation, MutableLoadStateCollection mutableLoadStateCollection) {
            super(4, continuation);
            this.f50084g = mutableLoadStateCollection;
            this.f50083f = simpleProducerScope;
        }

        @Override // kotlin.jvm.functions.Function4
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Object obj, Object obj2, CombineSource combineSource, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f50083f, continuation, this.f50084g);
            anonymousClass1.f50080b = obj;
            anonymousClass1.f50081c = obj2;
            anonymousClass1.f50082d = combineSource;
            return anonymousClass1.invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f50079a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Object obj2 = this.f50080b;
                Object obj3 = this.f50081c;
                CombineSource combineSource = (CombineSource) this.f50082d;
                SimpleProducerScope simpleProducerScope = this.f50083f;
                Object loadStateUpdate = (PageEvent) obj3;
                LoadStates loadStates = (LoadStates) obj2;
                if (combineSource == CombineSource.RECEIVER) {
                    loadStateUpdate = new PageEvent.LoadStateUpdate(this.f50084g.d(), loadStates);
                } else if (loadStateUpdate instanceof PageEvent.Insert) {
                    PageEvent.Insert insert = (PageEvent.Insert) loadStateUpdate;
                    this.f50084g.b(insert.o());
                    loadStateUpdate = PageEvent.Insert.i(insert, null, null, 0, 0, insert.o(), loadStates, 15, null);
                } else if (loadStateUpdate instanceof PageEvent.Drop) {
                    this.f50084g.c(((PageEvent.Drop) loadStateUpdate).g(), LoadState.NotLoading.f49893b.b());
                } else {
                    if (!(loadStateUpdate instanceof PageEvent.LoadStateUpdate)) {
                        if (loadStateUpdate instanceof PageEvent.StaticList) {
                            throw new IllegalStateException("Paging generated an event to display a static list that\n originated from a paginated source. If you see this\n exception, it is most likely a bug in the library.\n Please file a bug so we can fix it at:\n https://issuetracker.google.com/issues/new?component=413106");
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    PageEvent.LoadStateUpdate loadStateUpdate2 = (PageEvent.LoadStateUpdate) loadStateUpdate;
                    this.f50084g.b(loadStateUpdate2.h());
                    loadStateUpdate = new PageEvent.LoadStateUpdate(loadStateUpdate2.h(), loadStates);
                }
                this.f50079a = 1;
                if (simpleProducerScope.y(loadStateUpdate, this) == objF) {
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

    /* JADX INFO: renamed from: androidx.paging.PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.paging.FlowExtKt$combineWithoutBatching$2$1$1", f = "FlowExt.kt", l = {147}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f50085a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SimpleProducerScope f50086b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Flow f50087c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ AtomicInteger f50088d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ UnbatchedFlowCombiner f50089f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f50090g;

        /* JADX INFO: renamed from: androidx.paging.PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ UnbatchedFlowCombiner f50091a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f50092b;

            /* JADX INFO: renamed from: androidx.paging.PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1$2$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            static final class C00791 extends ContinuationImpl {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                /* synthetic */ Object f50093a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                int f50094b;

                C00791(Continuation continuation) {
                    super(continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    this.f50093a = obj;
                    this.f50094b |= Integer.MIN_VALUE;
                    return AnonymousClass1.this.emit(null, this);
                }
            }

            public AnonymousClass1(UnbatchedFlowCombiner unbatchedFlowCombiner, int i3) {
                this.f50091a = unbatchedFlowCombiner;
                this.f50092b = i3;
            }

            /* JADX WARN: Code restructure failed: missing block: B:20:0x004e, code lost:
            
                if (kotlinx.coroutines.YieldKt.a(r0) == r1) goto L21;
             */
            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object emit(java.lang.Object r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
                /*
                    r5 = this;
                    boolean r0 = r7 instanceof androidx.paging.PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1.AnonymousClass2.AnonymousClass1.C00791
                    if (r0 == 0) goto L13
                    r0 = r7
                    androidx.paging.PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1$2$1$1 r0 = (androidx.paging.PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1.AnonymousClass2.AnonymousClass1.C00791) r0
                    int r1 = r0.f50094b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f50094b = r1
                    goto L18
                L13:
                    androidx.paging.PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1$2$1$1 r0 = new androidx.paging.PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1$2$1$1
                    r0.<init>(r7)
                L18:
                    java.lang.Object r7 = r0.f50093a
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                    int r2 = r0.f50094b
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L38
                    if (r2 == r4) goto L34
                    if (r2 != r3) goto L2c
                    kotlin.ResultKt.b(r7)
                    goto L51
                L2c:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r7)
                    throw r6
                L34:
                    kotlin.ResultKt.b(r7)
                    goto L48
                L38:
                    kotlin.ResultKt.b(r7)
                    androidx.paging.UnbatchedFlowCombiner r7 = r5.f50091a
                    int r2 = r5.f50092b
                    r0.f50094b = r4
                    java.lang.Object r6 = r7.a(r2, r6, r0)
                    if (r6 != r1) goto L48
                    goto L50
                L48:
                    r0.f50094b = r3
                    java.lang.Object r6 = kotlinx.coroutines.YieldKt.a(r0)
                    if (r6 != r1) goto L51
                L50:
                    return r1
                L51:
                    kotlin.Unit r6 = kotlin.Unit.f139807a
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1.AnonymousClass2.AnonymousClass1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Flow flow, AtomicInteger atomicInteger, SimpleProducerScope simpleProducerScope, UnbatchedFlowCombiner unbatchedFlowCombiner, int i3, Continuation continuation) {
            super(2, continuation);
            this.f50087c = flow;
            this.f50088d = atomicInteger;
            this.f50089f = unbatchedFlowCombiner;
            this.f50090g = i3;
            this.f50086b = simpleProducerScope;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass2(this.f50087c, this.f50088d, this.f50086b, this.f50089f, this.f50090g, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            AtomicInteger atomicInteger;
            Object objF = IntrinsicsKt.f();
            int i3 = this.f50085a;
            try {
                if (i3 == 0) {
                    ResultKt.b(obj);
                    Flow flow = this.f50087c;
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f50089f, this.f50090g);
                    this.f50085a = 1;
                    if (flow.collect(anonymousClass1, this) == objF) {
                        return objF;
                    }
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                if (atomicInteger.decrementAndGet() == 0) {
                    SendChannel.DefaultImpls.a(this.f50086b, null, 1, null);
                }
                return Unit.f139807a;
            } finally {
                if (this.f50088d.decrementAndGet() == 0) {
                    SendChannel.DefaultImpls.a(this.f50086b, null, 1, null);
                }
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1(Flow flow, Flow flow2, Continuation continuation, MutableLoadStateCollection mutableLoadStateCollection) {
        super(2, continuation);
        this.f50076c = flow;
        this.f50077d = flow2;
        this.f50078f = mutableLoadStateCollection;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1 pageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1 = new PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1(this.f50076c, this.f50077d, continuation, this.f50078f);
        pageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1.f50075b = obj;
        return pageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(SimpleProducerScope simpleProducerScope, Continuation continuation) {
        return ((PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1) create(simpleProducerScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f50074a;
        if (i3 == 0) {
            ResultKt.b(obj);
            SimpleProducerScope simpleProducerScope = (SimpleProducerScope) this.f50075b;
            AtomicInteger atomicInteger = new AtomicInteger(2);
            UnbatchedFlowCombiner unbatchedFlowCombiner = new UnbatchedFlowCombiner(new AnonymousClass1(simpleProducerScope, null, this.f50078f));
            final CompletableJob completableJobB = JobKt__JobKt.b(null, 1, null);
            int i4 = 0;
            Flow[] flowArr = {this.f50076c, this.f50077d};
            int i5 = 0;
            while (i5 < 2) {
                SimpleProducerScope simpleProducerScope2 = simpleProducerScope;
                simpleProducerScope = simpleProducerScope2;
                BuildersKt__Builders_commonKt.d(simpleProducerScope, completableJobB, null, new AnonymousClass2(flowArr[i5], atomicInteger, simpleProducerScope2, unbatchedFlowCombiner, i4, null), 2, null);
                i5++;
                atomicInteger = atomicInteger;
                i4++;
                unbatchedFlowCombiner = unbatchedFlowCombiner;
            }
            Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.paging.PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1.3
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m355invoke();
                    return Unit.f139807a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m355invoke() {
                    Job.DefaultImpls.b(completableJobB, null, 1, null);
                }
            };
            this.f50074a = 1;
            if (simpleProducerScope.M(function0, this) == objF) {
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
