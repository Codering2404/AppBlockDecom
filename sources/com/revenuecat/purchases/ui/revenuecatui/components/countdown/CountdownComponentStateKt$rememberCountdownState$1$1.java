package com.revenuecat.purchases.ui.revenuecatui.components.countdown;

import androidx.compose.runtime.MutableState;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import java.util.Date;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.countdown.CountdownComponentStateKt$rememberCountdownState$1$1", f = "CountdownComponentState.kt", l = {92}, m = "invokeSuspend")
final class CountdownComponentStateKt$rememberCountdownState$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<CountdownTime> $countdownTime$delegate;
    final /* synthetic */ MutableState<Boolean> $isCountingEnabled$delegate;
    final /* synthetic */ LifecycleOwner $lifecycleOwner;
    final /* synthetic */ Date $targetDate;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.countdown.CountdownComponentStateKt$rememberCountdownState$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.countdown.CountdownComponentStateKt$rememberCountdownState$1$1$1", f = "CountdownComponentState.kt", l = {74}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MutableState<Boolean> $isCountingEnabled$delegate;
        final /* synthetic */ LifecycleOwner $lifecycleOwner;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(LifecycleOwner lifecycleOwner, MutableState<Boolean> mutableState, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$lifecycleOwner = lifecycleOwner;
            this.$isCountingEnabled$delegate = mutableState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$lifecycleOwner, this.$isCountingEnabled$delegate, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                final StateFlow<Lifecycle.State> currentStateFlow = this.$lifecycleOwner.getLifecycle().getCurrentStateFlow();
                Flow flowU = FlowKt.u(new Flow<Boolean>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.countdown.CountdownComponentStateKt$rememberCountdownState$1$1$1$invokeSuspend$$inlined$map$1

                    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.countdown.CountdownComponentStateKt$rememberCountdownState$1$1$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                    @Metadata
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.countdown.CountdownComponentStateKt$rememberCountdownState$1$1$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                        @Metadata
                        @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.countdown.CountdownComponentStateKt$rememberCountdownState$1$1$1$invokeSuspend$$inlined$map$1$2", f = "CountdownComponentState.kt", l = {223}, m = "emit")
                        public static final class AnonymousClass1 extends ContinuationImpl {
                            Object L$0;
                            int label;
                            /* synthetic */ Object result;

                            public AnonymousClass1(Continuation continuation) {
                                super(continuation);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                this.result = obj;
                                this.label |= Integer.MIN_VALUE;
                                return AnonymousClass2.this.emit(null, this);
                            }
                        }

                        public AnonymousClass2(FlowCollector flowCollector) {
                            this.$this_unsafeFlow = flowCollector;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
                            /*
                                r4 = this;
                                boolean r0 = r6 instanceof com.revenuecat.purchases.ui.revenuecatui.components.countdown.CountdownComponentStateKt$rememberCountdownState$1$1$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1
                                if (r0 == 0) goto L13
                                r0 = r6
                                com.revenuecat.purchases.ui.revenuecatui.components.countdown.CountdownComponentStateKt$rememberCountdownState$1$1$1$invokeSuspend$$inlined$map$1$2$1 r0 = (com.revenuecat.purchases.ui.revenuecatui.components.countdown.CountdownComponentStateKt$rememberCountdownState$1$1$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.label = r1
                                goto L18
                            L13:
                                com.revenuecat.purchases.ui.revenuecatui.components.countdown.CountdownComponentStateKt$rememberCountdownState$1$1$1$invokeSuspend$$inlined$map$1$2$1 r0 = new com.revenuecat.purchases.ui.revenuecatui.components.countdown.CountdownComponentStateKt$rememberCountdownState$1$1$1$invokeSuspend$$inlined$map$1$2$1
                                r0.<init>(r6)
                            L18:
                                java.lang.Object r6 = r0.result
                                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                                int r2 = r0.label
                                r3 = 1
                                if (r2 == 0) goto L31
                                if (r2 != r3) goto L29
                                kotlin.ResultKt.b(r6)
                                goto L4b
                            L29:
                                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                                r5.<init>(r6)
                                throw r5
                            L31:
                                kotlin.ResultKt.b(r6)
                                kotlinx.coroutines.flow.FlowCollector r6 = r4.$this_unsafeFlow
                                androidx.lifecycle.Lifecycle$State r5 = (androidx.lifecycle.Lifecycle.State) r5
                                androidx.lifecycle.Lifecycle$State r2 = androidx.lifecycle.Lifecycle.State.f39950d
                                boolean r5 = r5.b(r2)
                                java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.a(r5)
                                r0.label = r3
                                java.lang.Object r5 = r6.emit(r5, r0)
                                if (r5 != r1) goto L4b
                                return r1
                            L4b:
                                kotlin.Unit r5 = kotlin.Unit.f139807a
                                return r5
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.components.countdown.CountdownComponentStateKt$rememberCountdownState$1$1$1$invokeSuspend$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                        }
                    }

                    @Override // kotlinx.coroutines.flow.Flow
                    public Object collect(FlowCollector flowCollector, Continuation continuation) {
                        Object objCollect = currentStateFlow.collect(new AnonymousClass2(flowCollector), continuation);
                        return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
                    }
                });
                final MutableState<Boolean> mutableState = this.$isCountingEnabled$delegate;
                FlowCollector flowCollector = new FlowCollector() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.countdown.CountdownComponentStateKt.rememberCountdownState.1.1.1.2
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit(((Boolean) obj2).booleanValue(), (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(boolean z2, Continuation<? super Unit> continuation) {
                        CountdownComponentStateKt.rememberCountdownState$lambda$6(mutableState, z2);
                        return Unit.f139807a;
                    }
                };
                this.label = 1;
                if (flowU.collect(flowCollector, this) == objF) {
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
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CountdownComponentStateKt$rememberCountdownState$1$1(Date date, LifecycleOwner lifecycleOwner, MutableState<Boolean> mutableState, MutableState<CountdownTime> mutableState2, Continuation<? super CountdownComponentStateKt$rememberCountdownState$1$1> continuation) {
        super(2, continuation);
        this.$targetDate = date;
        this.$lifecycleOwner = lifecycleOwner;
        this.$isCountingEnabled$delegate = mutableState;
        this.$countdownTime$delegate = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CountdownComponentStateKt$rememberCountdownState$1$1 countdownComponentStateKt$rememberCountdownState$1$1 = new CountdownComponentStateKt$rememberCountdownState$1$1(this.$targetDate, this.$lifecycleOwner, this.$isCountingEnabled$delegate, this.$countdownTime$delegate, continuation);
        countdownComponentStateKt$rememberCountdownState$1$1.L$0 = obj;
        return countdownComponentStateKt$rememberCountdownState$1$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        CoroutineScope coroutineScope;
        long jS;
        Object objF = IntrinsicsKt.f();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.b(obj);
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            BuildersKt__Builders_commonKt.d(coroutineScope2, null, null, new AnonymousClass1(this.$lifecycleOwner, this.$isCountingEnabled$delegate, null), 3, null);
            coroutineScope = coroutineScope2;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.b(obj);
        }
        do {
            if (JobKt.p(coroutineScope.getCoroutineContext())) {
                if (CountdownComponentStateKt.rememberCountdownState$lambda$5(this.$isCountingEnabled$delegate)) {
                    long time = this.$targetDate.getTime() - new Date().getTime();
                    if (time <= 0) {
                        this.$countdownTime$delegate.setValue(CountdownTime.Companion.getZERO());
                    } else {
                        this.$countdownTime$delegate.setValue(CountdownTime.Companion.fromInterval(time));
                    }
                }
                Duration.Companion companion = Duration.f140631b;
                jS = DurationKt.s(1, DurationUnit.f140641f);
                this.L$0 = coroutineScope;
                this.label = 1;
            }
            return Unit.f139807a;
        } while (DelayKt.c(jS, this) != objF);
        return objF;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CountdownComponentStateKt$rememberCountdownState$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
