package kotlinx.coroutines.flow.internal;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.ThreadContextKt;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1", f = "Combine.kt", l = {123}, m = "invokeSuspend")
final class CombineKt$zipImpl$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f142337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f142338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private /* synthetic */ Object f142339c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Flow f142340d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Flow f142341f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ FlowCollector f142342g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ Function3 f142343h;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2", f = "Combine.kt", l = {124}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f142345a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Flow f142346b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ CoroutineContext f142347c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Object f142348d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ ReceiveChannel f142349f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ FlowCollector f142350g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ Function3 f142351h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ CompletableJob f142352i;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ CoroutineContext f142353a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Object f142354b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ ReceiveChannel f142355c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ FlowCollector f142356d;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ Function3 f142357f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ CompletableJob f142358g;

            /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$1", f = "Combine.kt", l = {126, 129, 129}, m = "invokeSuspend")
            static final class C03141 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                Object f142359a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                int f142360b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ ReceiveChannel f142361c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ FlowCollector f142362d;

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                final /* synthetic */ Function3 f142363f;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                final /* synthetic */ Object f142364g;

                /* JADX INFO: renamed from: h, reason: collision with root package name */
                final /* synthetic */ CompletableJob f142365h;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C03141(ReceiveChannel receiveChannel, FlowCollector flowCollector, Function3 function3, Object obj, CompletableJob completableJob, Continuation continuation) {
                    super(2, continuation);
                    this.f142361c = receiveChannel;
                    this.f142362d = flowCollector;
                    this.f142363f = function3;
                    this.f142364g = obj;
                    this.f142365h = completableJob;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation create(Object obj, Continuation continuation) {
                    return new C03141(this.f142361c, this.f142362d, this.f142363f, this.f142364g, this.f142365h, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
                public final Object invoke(Unit unit, Continuation continuation) {
                    return ((C03141) create(unit, continuation)).invokeSuspend(Unit.f139807a);
                }

                /* JADX WARN: Code restructure failed: missing block: B:28:0x006e, code lost:
                
                    if (r1.emit(r9, r8) != r0) goto L30;
                 */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
                    /*
                        r8 = this;
                        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                        int r1 = r8.f142360b
                        r2 = 0
                        r3 = 3
                        r4 = 2
                        r5 = 1
                        if (r1 == 0) goto L30
                        if (r1 == r5) goto L26
                        if (r1 == r4) goto L1e
                        if (r1 != r3) goto L16
                        kotlin.ResultKt.b(r9)
                        goto L71
                    L16:
                        java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r9.<init>(r0)
                        throw r9
                    L1e:
                        java.lang.Object r1 = r8.f142359a
                        kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                        kotlin.ResultKt.b(r9)
                        goto L66
                    L26:
                        kotlin.ResultKt.b(r9)
                        kotlinx.coroutines.channels.ChannelResult r9 = (kotlinx.coroutines.channels.ChannelResult) r9
                        java.lang.Object r9 = r9.m()
                        goto L3e
                    L30:
                        kotlin.ResultKt.b(r9)
                        kotlinx.coroutines.channels.ReceiveChannel r9 = r8.f142361c
                        r8.f142360b = r5
                        java.lang.Object r9 = r9.t(r8)
                        if (r9 != r0) goto L3e
                        goto L70
                    L3e:
                        kotlinx.coroutines.CompletableJob r1 = r8.f142365h
                        boolean r5 = r9 instanceof kotlinx.coroutines.channels.ChannelResult.Failed
                        if (r5 == 0) goto L50
                        java.lang.Throwable r9 = kotlinx.coroutines.channels.ChannelResult.e(r9)
                        if (r9 != 0) goto L4f
                        kotlinx.coroutines.flow.internal.AbortFlowException r9 = new kotlinx.coroutines.flow.internal.AbortFlowException
                        r9.<init>(r1)
                    L4f:
                        throw r9
                    L50:
                        kotlinx.coroutines.flow.FlowCollector r1 = r8.f142362d
                        kotlin.jvm.functions.Function3 r5 = r8.f142363f
                        java.lang.Object r6 = r8.f142364g
                        kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.flow.internal.NullSurrogateKt.f142386a
                        if (r9 != r7) goto L5b
                        r9 = r2
                    L5b:
                        r8.f142359a = r1
                        r8.f142360b = r4
                        java.lang.Object r9 = r5.invoke(r6, r9, r8)
                        if (r9 != r0) goto L66
                        goto L70
                    L66:
                        r8.f142359a = r2
                        r8.f142360b = r3
                        java.lang.Object r9 = r1.emit(r9, r8)
                        if (r9 != r0) goto L71
                    L70:
                        return r0
                    L71:
                        kotlin.Unit r9 = kotlin.Unit.f139807a
                        return r9
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1.AnonymousClass2.AnonymousClass1.C03141.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            AnonymousClass1(CoroutineContext coroutineContext, Object obj, ReceiveChannel receiveChannel, FlowCollector flowCollector, Function3 function3, CompletableJob completableJob) {
                this.f142353a = coroutineContext;
                this.f142354b = obj;
                this.f142355c = receiveChannel;
                this.f142356d = flowCollector;
                this.f142357f = function3;
                this.f142358g = completableJob;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object emit(java.lang.Object r13, kotlin.coroutines.Continuation r14) throws java.lang.Throwable {
                /*
                    r12 = this;
                    boolean r0 = r14 instanceof kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$emit$1
                    if (r0 == 0) goto L13
                    r0 = r14
                    kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$emit$1 r0 = (kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$emit$1) r0
                    int r1 = r0.f142368c
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f142368c = r1
                    goto L18
                L13:
                    kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$emit$1 r0 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$emit$1
                    r0.<init>(r12, r14)
                L18:
                    java.lang.Object r14 = r0.f142366a
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                    int r2 = r0.f142368c
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    kotlin.ResultKt.b(r14)
                    goto L52
                L29:
                    java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                    java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
                    r13.<init>(r14)
                    throw r13
                L31:
                    kotlin.ResultKt.b(r14)
                    kotlin.coroutines.CoroutineContext r14 = r12.f142353a
                    kotlin.Unit r2 = kotlin.Unit.f139807a
                    java.lang.Object r4 = r12.f142354b
                    kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$1 r5 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$1
                    kotlinx.coroutines.channels.ReceiveChannel r6 = r12.f142355c
                    kotlinx.coroutines.flow.FlowCollector r7 = r12.f142356d
                    kotlin.jvm.functions.Function3 r8 = r12.f142357f
                    kotlinx.coroutines.CompletableJob r10 = r12.f142358g
                    r11 = 0
                    r9 = r13
                    r5.<init>(r6, r7, r8, r9, r10, r11)
                    r0.f142368c = r3
                    java.lang.Object r13 = kotlinx.coroutines.flow.internal.ChannelFlowKt.c(r14, r2, r4, r5, r0)
                    if (r13 != r1) goto L52
                    return r1
                L52:
                    kotlin.Unit r13 = kotlin.Unit.f139807a
                    return r13
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1.AnonymousClass2.AnonymousClass1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Flow flow, CoroutineContext coroutineContext, Object obj, ReceiveChannel receiveChannel, FlowCollector flowCollector, Function3 function3, CompletableJob completableJob, Continuation continuation) {
            super(2, continuation);
            this.f142346b = flow;
            this.f142347c = coroutineContext;
            this.f142348d = obj;
            this.f142349f = receiveChannel;
            this.f142350g = flowCollector;
            this.f142351h = function3;
            this.f142352i = completableJob;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass2(this.f142346b, this.f142347c, this.f142348d, this.f142349f, this.f142350g, this.f142351h, this.f142352i, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Unit unit, Continuation continuation) {
            return ((AnonymousClass2) create(unit, continuation)).invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f142345a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flow = this.f142346b;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f142347c, this.f142348d, this.f142349f, this.f142350g, this.f142351h, this.f142352i);
                this.f142345a = 1;
                if (flow.collect(anonymousClass1, this) == objF) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CombineKt$zipImpl$1$1(Flow flow, Flow flow2, FlowCollector flowCollector, Function3 function3, Continuation continuation) {
        super(2, continuation);
        this.f142340d = flow;
        this.f142341f = flow2;
        this.f142342g = flowCollector;
        this.f142343h = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        CombineKt$zipImpl$1$1 combineKt$zipImpl$1$1 = new CombineKt$zipImpl$1$1(this.f142340d, this.f142341f, this.f142342g, this.f142343h, continuation);
        combineKt$zipImpl$1$1.f142339c = obj;
        return combineKt$zipImpl$1$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        ReceiveChannel receiveChannel;
        CompletableJob completableJob;
        ReceiveChannel receiveChannel2;
        CompletableJob completableJob2;
        Unit unit;
        AnonymousClass2 anonymousClass2;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f142338b;
        if (i3 == 0) {
            ResultKt.b(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.f142339c;
            ReceiveChannel receiveChannelD = ProduceKt.d(coroutineScope, null, 0, new CombineKt$zipImpl$1$1$second$1(this.f142340d, null), 3, null);
            final CompletableJob completableJobB = JobKt__JobKt.b(null, 1, null);
            Intrinsics.checkNotNull(receiveChannelD, "null cannot be cast to non-null type kotlinx.coroutines.channels.SendChannel<*>");
            ((SendChannel) receiveChannelD).g(new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1.1
                public final void c(Throwable th) {
                    if (completableJobB.isActive()) {
                        completableJobB.cancel((CancellationException) new AbortFlowException(completableJobB));
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    c((Throwable) obj2);
                    return Unit.f139807a;
                }
            });
            try {
                CoroutineContext coroutineContext = coroutineScope.getCoroutineContext();
                Object objG = ThreadContextKt.g(coroutineContext);
                CoroutineContext coroutineContextPlus = coroutineScope.getCoroutineContext().plus(completableJobB);
                try {
                    try {
                        unit = Unit.f139807a;
                        try {
                            anonymousClass2 = new AnonymousClass2(this.f142341f, coroutineContext, objG, receiveChannelD, this.f142342g, this.f142343h, completableJobB, null);
                            receiveChannel = receiveChannelD;
                            completableJob = completableJobB;
                        } catch (AbortFlowException e3) {
                            e = e3;
                            receiveChannel = receiveChannelD;
                            completableJob = completableJobB;
                        }
                    } catch (Throwable th) {
                        th = th;
                        receiveChannel = receiveChannelD;
                    }
                } catch (AbortFlowException e4) {
                    e = e4;
                    completableJob = completableJobB;
                    receiveChannel = receiveChannelD;
                }
                try {
                    this.f142339c = receiveChannel;
                    this.f142337a = completableJob;
                    this.f142338b = 1;
                    if (ChannelFlowKt.d(coroutineContextPlus, unit, null, anonymousClass2, this, 4, null) == objF) {
                        return objF;
                    }
                    receiveChannel2 = receiveChannel;
                } catch (AbortFlowException e5) {
                    e = e5;
                    completableJob2 = completableJob;
                    receiveChannel2 = receiveChannel;
                    FlowExceptions_commonKt.a(e, completableJob2);
                } catch (Throwable th2) {
                    th = th2;
                    receiveChannel2 = receiveChannel;
                    ReceiveChannel.DefaultImpls.a(receiveChannel2, null, 1, null);
                    throw th;
                }
            } catch (AbortFlowException e6) {
                e = e6;
                receiveChannel = receiveChannelD;
                completableJob = completableJobB;
            } catch (Throwable th3) {
                th = th3;
                receiveChannel = receiveChannelD;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            completableJob2 = (CompletableJob) this.f142337a;
            receiveChannel2 = (ReceiveChannel) this.f142339c;
            try {
                try {
                    ResultKt.b(obj);
                } catch (AbortFlowException e7) {
                    e = e7;
                    FlowExceptions_commonKt.a(e, completableJob2);
                }
            } catch (Throwable th4) {
                th = th4;
                ReceiveChannel.DefaultImpls.a(receiveChannel2, null, 1, null);
                throw th;
            }
        }
        ReceiveChannel.DefaultImpls.a(receiveChannel2, null, 1, null);
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((CombineKt$zipImpl$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
