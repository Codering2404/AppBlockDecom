package com.superwall.sdk.paywall.presentation.get_paywall.builder;

import android.app.Activity;
import com.superwall.sdk.Superwall;
import com.superwall.sdk.paywall.presentation.get_paywall.PublicGetPaywallKt;
import com.superwall.sdk.paywall.presentation.internal.request.PaywallOverrides;
import com.superwall.sdk.paywall.view.LoadingView;
import com.superwall.sdk.paywall.view.PaywallPurchaseLoadingView;
import com.superwall.sdk.paywall.view.PaywallShimmerView;
import com.superwall.sdk.paywall.view.PaywallView;
import com.superwall.sdk.paywall.view.ShimmerView;
import com.superwall.sdk.paywall.view.delegate.PaywallViewCallback;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

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
@DebugMetadata(c = "com.superwall.sdk.paywall.presentation.get_paywall.builder.PaywallBuilder$build$3", f = "PaywallBuilder.kt", l = {113}, m = "invokeSuspend")
final class PaywallBuilder$build$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Throwable, Unit> $onError;
    final /* synthetic */ Function1<PaywallView, Unit> $onSuccess;
    int label;
    final /* synthetic */ PaywallBuilder this$0;

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.get_paywall.builder.PaywallBuilder$build$3$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.get_paywall.builder.PaywallBuilder$build$3$1", f = "PaywallBuilder.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Throwable, Unit> $onError;
        final /* synthetic */ Function1<PaywallView, Unit> $onSuccess;
        final /* synthetic */ Object $res;
        int label;
        final /* synthetic */ PaywallBuilder this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Object obj, PaywallBuilder paywallBuilder, Function1<? super PaywallView, Unit> function1, Function1<? super Throwable, Unit> function12, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$res = obj;
            this.this$0 = paywallBuilder;
            this.$onSuccess = function1;
            this.$onError = function12;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$res, this.this$0, this.$onSuccess, this.$onError, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            Object obj2 = this.$res;
            PaywallBuilder paywallBuilder = this.this$0;
            Function1<PaywallView, Unit> function1 = this.$onSuccess;
            if (Result.h(obj2)) {
                PaywallView paywallView = (PaywallView) obj2;
                paywallView.setEncapsulatingActivity(new WeakReference<>(paywallBuilder.activity));
                PaywallShimmerView shimmerView = paywallBuilder.shimmmerView;
                if (shimmerView == null) {
                    Activity activity = paywallBuilder.activity;
                    Intrinsics.checkNotNull(activity);
                    shimmerView = new ShimmerView(activity, null, 2, null);
                }
                PaywallPurchaseLoadingView loadingView = paywallBuilder.purchaseLoadingView;
                if (loadingView == null) {
                    Activity activity2 = paywallBuilder.activity;
                    Intrinsics.checkNotNull(activity2);
                    loadingView = new LoadingView(activity2, null, 0, 0, Superwall.Companion.getInstance().getOptions().getPaywalls().getLoadingColor(), 14, null);
                }
                paywallView.setupWith(shimmerView, loadingView);
                paywallView.setupShimmer$superwall_release(shimmerView);
                paywallView.setupLoading$superwall_release(loadingView);
                paywallView.beforeViewCreated();
                function1.invoke(paywallView);
            }
            Function1<Throwable, Unit> function12 = this.$onError;
            Throwable thE = Result.e(obj2);
            if (thE != null) {
                function12.invoke(thE);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    PaywallBuilder$build$3(PaywallBuilder paywallBuilder, Function1<? super PaywallView, Unit> function1, Function1<? super Throwable, Unit> function12, Continuation<? super PaywallBuilder$build$3> continuation) {
        super(2, continuation);
        this.this$0 = paywallBuilder;
        this.$onSuccess = function1;
        this.$onError = function12;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PaywallBuilder$build$3(this.this$0, this.$onSuccess, this.$onError, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objJ;
        Object objF = IntrinsicsKt.f();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.b(obj);
            Superwall companion = Superwall.Companion.getInstance();
            String placement = this.this$0.getPlacement();
            Map map = this.this$0.params;
            PaywallOverrides paywallOverrides = this.this$0.paywallOverrides;
            PaywallViewCallback paywallViewCallback = this.this$0.delegate;
            Intrinsics.checkNotNull(paywallViewCallback);
            this.label = 1;
            Object paywall = PublicGetPaywallKt.getPaywall(companion, placement, map, paywallOverrides, paywallViewCallback, this);
            if (paywall == objF) {
                return objF;
            }
            objJ = paywall;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            objJ = ((Result) obj).j();
        }
        BuildersKt__Builders_commonKt.d(CoroutineScopeKt.b(), null, null, new AnonymousClass1(objJ, this.this$0, this.$onSuccess, this.$onError, null), 3, null);
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PaywallBuilder$build$3) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
