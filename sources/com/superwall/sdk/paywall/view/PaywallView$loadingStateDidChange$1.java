package com.superwall.sdk.paywall.view;

import com.superwall.sdk.paywall.view.PaywallViewState;
import com.superwall.sdk.paywall.view.delegate.PaywallLoadingState;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

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
@DebugMetadata(c = "com.superwall.sdk.paywall.view.PaywallView$loadingStateDidChange$1", f = "PaywallView.kt", l = {}, m = "invokeSuspend")
final class PaywallView$loadingStateDidChange$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PaywallLoadingState $currentLoadingState;
    final /* synthetic */ PaywallLoadingState $previousLoadingState;
    int label;
    final /* synthetic */ PaywallView this$0;

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.PaywallView$loadingStateDidChange$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.view.PaywallView$loadingStateDidChange$1$1", f = "PaywallView.kt", l = {934}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ PaywallView this$0;

        /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.PaywallView$loadingStateDidChange$1$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "com.superwall.sdk.paywall.view.PaywallView$loadingStateDidChange$1$1$1", f = "PaywallView.kt", l = {}, m = "invokeSuspend")
        static final class C02461 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ PaywallView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02461(PaywallView paywallView, Continuation<? super C02461> continuation) {
                super(2, continuation);
                this.this$0 = paywallView;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C02461(this.this$0, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.f();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                this.this$0.showRefreshButtonAfterTimeout(false);
                this.this$0.hideLoadingView();
                this.this$0.hideShimmerView();
                return Unit.f139807a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C02461) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PaywallView paywallView, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = paywallView;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                long delay = this.this$0.getState().getPaywall().getPresentation().getDelay();
                this.label = 1;
                if (DelayKt.b(delay, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            BuildersKt__Builders_commonKt.d(PaywallView.mainScope, null, null, new C02461(this.this$0, null), 3, null);
            this.this$0.getController().updateState(PaywallViewState.Updates.ResetCrashRetry.INSTANCE);
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PaywallView$loadingStateDidChange$1(PaywallLoadingState paywallLoadingState, PaywallView paywallView, PaywallLoadingState paywallLoadingState2, Continuation<? super PaywallView$loadingStateDidChange$1> continuation) {
        super(2, continuation);
        this.$currentLoadingState = paywallLoadingState;
        this.this$0 = paywallView;
        this.$previousLoadingState = paywallLoadingState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PaywallView$loadingStateDidChange$1(this.$currentLoadingState, this.this$0, this.$previousLoadingState, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        PaywallLoadingState paywallLoadingState = this.$currentLoadingState;
        if (!(paywallLoadingState instanceof PaywallLoadingState.Unknown)) {
            if ((paywallLoadingState instanceof PaywallLoadingState.LoadingPurchase) || (paywallLoadingState instanceof PaywallLoadingState.ManualLoading)) {
                this.this$0.showLoadingView();
            } else if (paywallLoadingState instanceof PaywallLoadingState.LoadingURL) {
                this.this$0.showShimmerView();
                this.this$0.showRefreshButtonAfterTimeout(true);
            } else {
                if (!(paywallLoadingState instanceof PaywallLoadingState.Ready)) {
                    throw new NoWhenBranchMatchedException();
                }
                PaywallLoadingState paywallLoadingState2 = this.$previousLoadingState;
                if ((paywallLoadingState2 instanceof PaywallLoadingState.LoadingURL) || (paywallLoadingState2 instanceof PaywallLoadingState.Unknown)) {
                    this.this$0.delayedHideJob = BuildersKt__Builders_commonKt.d(PaywallView.ioScope, null, null, new AnonymousClass1(this.this$0, null), 3, null);
                } else {
                    this.this$0.showRefreshButtonAfterTimeout(false);
                    this.this$0.hideLoadingView();
                    this.this$0.hideShimmerView();
                    this.this$0.getController().updateState(PaywallViewState.Updates.ResetCrashRetry.INSTANCE);
                }
            }
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PaywallView$loadingStateDidChange$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
