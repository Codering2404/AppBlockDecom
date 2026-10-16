package androidx.paging;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
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
@DebugMetadata(c = "androidx.paging.PageFetcherSnapshot$pageEventFlow$1", f = "PageFetcherSnapshot.kt", l = {646, 168, 657}, m = "invokeSuspend")
final class PageFetcherSnapshot$pageEventFlow$1<Value> extends SuspendLambda implements Function2<SimpleProducerScope<PageEvent<Value>>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f50161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f50162b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f50163c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f50164d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private /* synthetic */ Object f50165f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ PageFetcherSnapshot f50166g;

    /* JADX INFO: renamed from: androidx.paging.PageFetcherSnapshot$pageEventFlow$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.paging.PageFetcherSnapshot$pageEventFlow$1$2", f = "PageFetcherSnapshot.kt", l = {91}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f50167a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ PageFetcherSnapshot f50168b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ SimpleProducerScope f50169c;

        /* JADX INFO: renamed from: androidx.paging.PageFetcherSnapshot$pageEventFlow$1$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ SimpleProducerScope f50170a;

            AnonymousClass1(SimpleProducerScope simpleProducerScope) {
                this.f50170a = simpleProducerScope;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object emit(androidx.paging.PageEvent r5, kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof androidx.paging.PageFetcherSnapshot$pageEventFlow$1$2$1$emit$1
                    if (r0 == 0) goto L13
                    r0 = r6
                    androidx.paging.PageFetcherSnapshot$pageEventFlow$1$2$1$emit$1 r0 = (androidx.paging.PageFetcherSnapshot$pageEventFlow$1$2$1$emit$1) r0
                    int r1 = r0.f50173c
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f50173c = r1
                    goto L18
                L13:
                    androidx.paging.PageFetcherSnapshot$pageEventFlow$1$2$1$emit$1 r0 = new androidx.paging.PageFetcherSnapshot$pageEventFlow$1$2$1$emit$1
                    r0.<init>(r4, r6)
                L18:
                    java.lang.Object r6 = r0.f50171a
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                    int r2 = r0.f50173c
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    kotlin.ResultKt.b(r6)     // Catch: kotlinx.coroutines.channels.ClosedSendChannelException -> L3f
                    goto L3f
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    kotlin.ResultKt.b(r6)
                    androidx.paging.SimpleProducerScope r6 = r4.f50170a     // Catch: kotlinx.coroutines.channels.ClosedSendChannelException -> L3f
                    r0.f50173c = r3     // Catch: kotlinx.coroutines.channels.ClosedSendChannelException -> L3f
                    java.lang.Object r5 = r6.y(r5, r0)     // Catch: kotlinx.coroutines.channels.ClosedSendChannelException -> L3f
                    if (r5 != r1) goto L3f
                    return r1
                L3f:
                    kotlin.Unit r5 = kotlin.Unit.f139807a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageFetcherSnapshot$pageEventFlow$1.AnonymousClass2.AnonymousClass1.emit(androidx.paging.PageEvent, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(PageFetcherSnapshot pageFetcherSnapshot, SimpleProducerScope simpleProducerScope, Continuation continuation) {
            super(2, continuation);
            this.f50168b = pageFetcherSnapshot;
            this.f50169c = simpleProducerScope;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass2(this.f50168b, this.f50169c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f50167a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowR = FlowKt.r(this.f50168b.f50106j);
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f50169c);
                this.f50167a = 1;
                if (flowR.collect(anonymousClass1, this) == objF) {
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

    /* JADX INFO: renamed from: androidx.paging.PageFetcherSnapshot$pageEventFlow$1$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.paging.PageFetcherSnapshot$pageEventFlow$1$3", f = "PageFetcherSnapshot.kt", l = {105}, m = "invokeSuspend")
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f50174a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ PageFetcherSnapshot f50175b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Channel f50176c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(PageFetcherSnapshot pageFetcherSnapshot, Channel channel, Continuation continuation) {
            super(2, continuation);
            this.f50175b = pageFetcherSnapshot;
            this.f50176c = channel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass3(this.f50175b, this.f50176c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f50174a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flow = this.f50175b.f50100d;
                final Channel channel = this.f50176c;
                FlowCollector flowCollector = new FlowCollector() { // from class: androidx.paging.PageFetcherSnapshot.pageEventFlow.1.3.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public final Object emit(Unit unit, Continuation continuation) {
                        channel.h(unit);
                        return Unit.f139807a;
                    }
                };
                this.f50174a = 1;
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
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4", f = "PageFetcherSnapshot.kt", l = {110}, m = "invokeSuspend")
    static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f50178a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f50179b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Channel f50180c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ PageFetcherSnapshot f50181d;

        /* JADX INFO: renamed from: androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ PageFetcherSnapshot f50182a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ CoroutineScope f50183b;

            /* JADX INFO: renamed from: androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4$1$WhenMappings */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public /* synthetic */ class WhenMappings {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f50184a;

                static {
                    int[] iArr = new int[LoadType.values().length];
                    try {
                        iArr[LoadType.REFRESH.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    f50184a = iArr;
                }
            }

            AnonymousClass1(PageFetcherSnapshot pageFetcherSnapshot, CoroutineScope coroutineScope) {
                this.f50182a = pageFetcherSnapshot;
                this.f50183b = coroutineScope;
            }

            /* JADX WARN: Code restructure failed: missing block: B:121:0x040a, code lost:
            
                if (r1.f(null, r13) == r0) goto L168;
             */
            /* JADX WARN: Code restructure failed: missing block: B:75:0x02f6, code lost:
            
                if (r1.f(null, r13) == r0) goto L168;
             */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:107:0x038d  */
            /* JADX WARN: Removed duplicated region for block: B:108:0x0391  */
            /* JADX WARN: Removed duplicated region for block: B:117:0x03e8  */
            /* JADX WARN: Removed duplicated region for block: B:120:0x03f0  */
            /* JADX WARN: Removed duplicated region for block: B:134:0x0434 A[PHI: r1 r4 r14
              0x0434: PHI (r1v53 androidx.paging.LoadStates) = (r1v28 androidx.paging.LoadStates), (r1v60 androidx.paging.LoadStates) binds: [B:89:0x0328, B:127:0x0426] A[DONT_GENERATE, DONT_INLINE]
              0x0434: PHI (r4v52 kotlinx.coroutines.CoroutineScope) = (r4v26 kotlinx.coroutines.CoroutineScope), (r4v55 kotlinx.coroutines.CoroutineScope) binds: [B:89:0x0328, B:127:0x0426] A[DONT_GENERATE, DONT_INLINE]
              0x0434: PHI (r14v51 androidx.paging.PageFetcherSnapshot) = (r14v28 androidx.paging.PageFetcherSnapshot), (r14v52 androidx.paging.PageFetcherSnapshot) binds: [B:89:0x0328, B:127:0x0426] A[DONT_GENERATE, DONT_INLINE]] */
            /* JADX WARN: Removed duplicated region for block: B:136:0x043e  */
            /* JADX WARN: Removed duplicated region for block: B:144:0x047c  */
            /* JADX WARN: Removed duplicated region for block: B:145:0x047e  */
            /* JADX WARN: Removed duplicated region for block: B:153:0x049a  */
            /* JADX WARN: Removed duplicated region for block: B:154:0x049e  */
            /* JADX WARN: Removed duplicated region for block: B:163:0x04f1  */
            /* JADX WARN: Removed duplicated region for block: B:166:0x04f6  */
            /* JADX WARN: Removed duplicated region for block: B:173:0x0529  */
            /* JADX WARN: Removed duplicated region for block: B:55:0x025b  */
            /* JADX WARN: Removed duplicated region for block: B:58:0x026e  */
            /* JADX WARN: Removed duplicated region for block: B:61:0x027c  */
            /* JADX WARN: Removed duplicated region for block: B:62:0x0280  */
            /* JADX WARN: Removed duplicated region for block: B:71:0x02d5  */
            /* JADX WARN: Removed duplicated region for block: B:74:0x02dd  */
            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            /* JADX WARN: Removed duplicated region for block: B:90:0x032a  */
            /* JADX WARN: Removed duplicated region for block: B:98:0x036d  */
            /* JADX WARN: Removed duplicated region for block: B:99:0x036f  */
            /* JADX WARN: Type inference failed for: r1v0, types: [int] */
            /* JADX WARN: Type inference failed for: r1v1, types: [kotlinx.coroutines.sync.Mutex] */
            /* JADX WARN: Type inference failed for: r1v14, types: [kotlinx.coroutines.sync.Mutex] */
            /* JADX WARN: Type inference failed for: r1v2, types: [kotlinx.coroutines.sync.Mutex] */
            /* JADX WARN: Type inference failed for: r1v3, types: [kotlinx.coroutines.sync.Mutex] */
            /* JADX WARN: Type inference failed for: r1v39, types: [kotlinx.coroutines.sync.Mutex] */
            /* JADX WARN: Type inference failed for: r1v68, types: [kotlinx.coroutines.sync.Mutex] */
            /* JADX WARN: Type inference failed for: r1v86 */
            /* JADX WARN: Type inference failed for: r1v87 */
            /* JADX WARN: Type inference failed for: r1v89 */
            /* JADX WARN: Type inference failed for: r1v90 */
            /* JADX WARN: Type inference failed for: r1v92 */
            /* JADX WARN: Type inference failed for: r1v93 */
            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object emit(kotlin.Unit r13, kotlin.coroutines.Continuation r14) throws java.lang.Throwable {
                /*
                    Method dump skipped, instruction units count: 1382
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageFetcherSnapshot$pageEventFlow$1.AnonymousClass4.AnonymousClass1.emit(kotlin.Unit, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(Channel channel, PageFetcherSnapshot pageFetcherSnapshot, Continuation continuation) {
            super(2, continuation);
            this.f50180c = channel;
            this.f50181d = pageFetcherSnapshot;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(this.f50180c, this.f50181d, continuation);
            anonymousClass4.f50179b = obj;
            return anonymousClass4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f50178a;
            if (i3 == 0) {
                ResultKt.b(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.f50179b;
                Flow flowR = FlowKt.r(this.f50180c);
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f50181d, coroutineScope);
                this.f50178a = 1;
                if (flowR.collect(anonymousClass1, this) == objF) {
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
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PageFetcherSnapshot$pageEventFlow$1(PageFetcherSnapshot pageFetcherSnapshot, Continuation continuation) {
        super(2, continuation);
        this.f50166g = pageFetcherSnapshot;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        PageFetcherSnapshot$pageEventFlow$1 pageFetcherSnapshot$pageEventFlow$1 = new PageFetcherSnapshot$pageEventFlow$1(this.f50166g, continuation);
        pageFetcherSnapshot$pageEventFlow$1.f50165f = obj;
        return pageFetcherSnapshot$pageEventFlow$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(SimpleProducerScope simpleProducerScope, Continuation continuation) {
        return ((PageFetcherSnapshot$pageEventFlow$1) create(simpleProducerScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x010f  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 293
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageFetcherSnapshot$pageEventFlow$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
