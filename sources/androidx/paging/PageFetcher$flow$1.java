package androidx.paging;

import androidx.paging.PageFetcher;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

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
@DebugMetadata(c = "androidx.paging.PageFetcher$flow$1", f = "PageFetcher.kt", l = {136}, m = "invokeSuspend")
final class PageFetcher$flow$1<Value> extends SuspendLambda implements Function2<SimpleProducerScope<PagingData<Value>>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f50042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f50043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ RemoteMediator f50044c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ PageFetcher f50045d;

    /* JADX INFO: renamed from: androidx.paging.PageFetcher$flow$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.paging.PageFetcher$flow$1$1", f = "PageFetcher.kt", l = {63, 63}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Boolean>, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f50046a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f50047b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ RemoteMediatorAccessor f50048c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(RemoteMediatorAccessor remoteMediatorAccessor, Continuation continuation) {
            super(2, continuation);
            this.f50048c = remoteMediatorAccessor;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f50048c, continuation);
            anonymousClass1.f50047b = obj;
            return anonymousClass1;
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0037, code lost:
        
            if (r7 == r0) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0050, code lost:
        
            if (r1.emit(r7, r6) != r0) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0052, code lost:
        
            return r0;
         */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0043  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r6.f50046a
                r2 = 0
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L23
                if (r1 == r4) goto L1b
                if (r1 != r3) goto L13
                kotlin.ResultKt.b(r7)
                goto L53
            L13:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1b:
                java.lang.Object r1 = r6.f50047b
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                kotlin.ResultKt.b(r7)
                goto L3a
            L23:
                kotlin.ResultKt.b(r7)
                java.lang.Object r7 = r6.f50047b
                r1 = r7
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                androidx.paging.RemoteMediatorAccessor r7 = r6.f50048c
                if (r7 == 0) goto L3d
                r6.f50047b = r1
                r6.f50046a = r4
                java.lang.Object r7 = r7.a(r6)
                if (r7 != r0) goto L3a
                goto L52
            L3a:
                androidx.paging.RemoteMediator$InitializeAction r7 = (androidx.paging.RemoteMediator.InitializeAction) r7
                goto L3e
            L3d:
                r7 = r2
            L3e:
                androidx.paging.RemoteMediator$InitializeAction r5 = androidx.paging.RemoteMediator.InitializeAction.LAUNCH_INITIAL_REFRESH
                if (r7 != r5) goto L43
                goto L44
            L43:
                r4 = 0
            L44:
                java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.a(r4)
                r6.f50047b = r2
                r6.f50046a = r3
                java.lang.Object r7 = r1.emit(r7, r6)
                if (r7 != r0) goto L53
            L52:
                return r0
            L53:
                kotlin.Unit r7 = kotlin.Unit.f139807a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageFetcher$flow$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector flowCollector, Continuation continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [Key] */
    /* JADX INFO: renamed from: androidx.paging.PageFetcher$flow$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.paging.PageFetcher$flow$1$2", f = "PageFetcher.kt", l = {73, 77}, m = "invokeSuspend")
    static final class AnonymousClass2<Key> extends SuspendLambda implements Function3<PageFetcher.GenerationInfo<Key, Value>, Boolean, Continuation<? super PageFetcher.GenerationInfo<Key, Value>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f50049a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f50050b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f50051c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ boolean f50052d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ RemoteMediatorAccessor f50053f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ PageFetcher f50054g;

        /* JADX INFO: renamed from: androidx.paging.PageFetcher$flow$1$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Unit> {
            AnonymousClass1(Object obj) {
                super(0, obj, PageFetcher.class, "refresh", "refresh()V", 0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m352invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m352invoke() {
                ((PageFetcher) this.receiver).l();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(RemoteMediatorAccessor remoteMediatorAccessor, PageFetcher pageFetcher, Continuation continuation) {
            super(3, continuation);
            this.f50053f = remoteMediatorAccessor;
            this.f50054g = pageFetcher;
        }

        public final Object h(PageFetcher.GenerationInfo generationInfo, boolean z2, Continuation continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.f50053f, this.f50054g, continuation);
            anonymousClass2.f50051c = generationInfo;
            anonymousClass2.f50052d = z2;
            return anonymousClass2.invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return h((PageFetcher.GenerationInfo) obj, ((Boolean) obj2).booleanValue(), (Continuation) obj3);
        }

        /* JADX WARN: Removed duplicated region for block: B:36:0x007c  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0081  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0086  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x008c A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:51:0x00a9  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x00ae  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x00b1  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x00c8  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x00d0  */
        /* JADX WARN: Removed duplicated region for block: B:69:0x00fc  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x0107  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 312
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageFetcher$flow$1.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PageFetcher$flow$1$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    /* synthetic */ class AnonymousClass4 implements FlowCollector, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SimpleProducerScope f50057a;

        AnonymousClass4(SimpleProducerScope simpleProducerScope) {
            this.f50057a = simpleProducerScope;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(PagingData pagingData, Continuation continuation) {
            Object objY = this.f50057a.y(pagingData, continuation);
            return objY == IntrinsicsKt.f() ? objY : Unit.f139807a;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function b() {
            return new FunctionReferenceImpl(2, this.f50057a, SimpleProducerScope.class, "send", "send(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof FlowCollector) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(b(), ((FunctionAdapter) obj).b());
            }
            return false;
        }

        public final int hashCode() {
            return b().hashCode();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PageFetcher$flow$1(RemoteMediator remoteMediator, PageFetcher pageFetcher, Continuation continuation) {
        super(2, continuation);
        this.f50044c = remoteMediator;
        this.f50045d = pageFetcher;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        PageFetcher$flow$1 pageFetcher$flow$1 = new PageFetcher$flow$1(this.f50044c, this.f50045d, continuation);
        pageFetcher$flow$1.f50043b = obj;
        return pageFetcher$flow$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(SimpleProducerScope simpleProducerScope, Continuation continuation) {
        return ((PageFetcher$flow$1) create(simpleProducerScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f50042a;
        if (i3 == 0) {
            ResultKt.b(obj);
            SimpleProducerScope simpleProducerScope = (SimpleProducerScope) this.f50043b;
            RemoteMediator remoteMediator = this.f50044c;
            RemoteMediatorAccessor remoteMediatorAccessorA = remoteMediator != null ? RemoteMediatorAccessorKt.a(simpleProducerScope, remoteMediator) : null;
            Flow flowD = FlowExtKt.d(FlowKt.C(FlowExtKt.c(FlowKt.W(this.f50045d.f50032d.a(), new AnonymousClass1(remoteMediatorAccessorA, null)), null, new AnonymousClass2(remoteMediatorAccessorA, this.f50045d, null))), new PageFetcher$flow$1$invokeSuspend$$inlined$simpleMapLatest$1(null, this.f50045d, remoteMediatorAccessorA));
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(simpleProducerScope);
            this.f50042a = 1;
            if (flowD.collect(anonymousClass4, this) == objF) {
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
