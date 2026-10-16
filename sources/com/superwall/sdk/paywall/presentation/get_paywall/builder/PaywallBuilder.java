package com.superwall.sdk.paywall.presentation.get_paywall.builder;

import android.app.Activity;
import android.view.View;
import com.superwall.sdk.Superwall;
import com.superwall.sdk.misc.IOScope;
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
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

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
public final class PaywallBuilder {
    private Activity activity;
    private PaywallViewCallback delegate;
    private Map<String, ? extends Object> params;
    private PaywallOverrides paywallOverrides;
    private final String placement;
    private PaywallPurchaseLoadingView purchaseLoadingView;
    private PaywallShimmerView shimmmerView;

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.get_paywall.builder.PaywallBuilder$buildSync$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.get_paywall.builder.PaywallBuilder$buildSync$1", f = "PaywallBuilder.kt", l = {140}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PaywallView>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PaywallBuilder.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object paywall;
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                Superwall companion = Superwall.Companion.getInstance();
                String placement = PaywallBuilder.this.getPlacement();
                Map map = PaywallBuilder.this.params;
                PaywallOverrides paywallOverrides = PaywallBuilder.this.paywallOverrides;
                PaywallViewCallback paywallViewCallback = PaywallBuilder.this.delegate;
                Intrinsics.checkNotNull(paywallViewCallback);
                this.label = 1;
                paywall = PublicGetPaywallKt.getPaywall(companion, placement, map, paywallOverrides, paywallViewCallback, this);
                if (paywall == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                paywall = ((Result) obj).j();
            }
            PaywallBuilder paywallBuilder = PaywallBuilder.this;
            if (!Result.h(paywall)) {
                ResultKt.b(paywall);
                return paywall;
            }
            PaywallView paywallView = (PaywallView) paywall;
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
            return paywallView;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super PaywallView> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    public PaywallBuilder(String placement) {
        Intrinsics.checkNotNullParameter(placement, "placement");
        this.placement = placement;
    }

    public final PaywallBuilder activity(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /* JADX INFO: renamed from: build-IoAF18A, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m1325buildIoAF18A(kotlin.coroutines.Continuation<? super kotlin.Result<com.superwall.sdk.paywall.view.PaywallView>> r13) {
        /*
            r12 = this;
            boolean r0 = r13 instanceof com.superwall.sdk.paywall.presentation.get_paywall.builder.PaywallBuilder$build$1
            if (r0 == 0) goto L14
            r0 = r13
            com.superwall.sdk.paywall.presentation.get_paywall.builder.PaywallBuilder$build$1 r0 = (com.superwall.sdk.paywall.presentation.get_paywall.builder.PaywallBuilder$build$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            com.superwall.sdk.paywall.presentation.get_paywall.builder.PaywallBuilder$build$1 r0 = new com.superwall.sdk.paywall.presentation.get_paywall.builder.PaywallBuilder$build$1
            r0.<init>(r12, r13)
            goto L12
        L1a:
            java.lang.Object r13 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L3d
            if (r1 != r2) goto L35
            java.lang.Object r0 = r6.L$0
            com.superwall.sdk.paywall.presentation.get_paywall.builder.PaywallBuilder r0 = (com.superwall.sdk.paywall.presentation.get_paywall.builder.PaywallBuilder) r0
            kotlin.ResultKt.b(r13)
            kotlin.Result r13 = (kotlin.Result) r13
            java.lang.Object r13 = r13.j()
            goto L5e
        L35:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L3d:
            kotlin.ResultKt.b(r13)
            com.superwall.sdk.Superwall$Companion r13 = com.superwall.sdk.Superwall.Companion
            com.superwall.sdk.Superwall r1 = r13.getInstance()
            r13 = r2
            java.lang.String r2 = r12.placement
            java.util.Map<java.lang.String, ? extends java.lang.Object> r3 = r12.params
            com.superwall.sdk.paywall.presentation.internal.request.PaywallOverrides r4 = r12.paywallOverrides
            com.superwall.sdk.paywall.view.delegate.PaywallViewCallback r5 = r12.delegate
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            r6.L$0 = r12
            r6.label = r13
            java.lang.Object r13 = com.superwall.sdk.paywall.presentation.get_paywall.PublicGetPaywallKt.getPaywall(r1, r2, r3, r4, r5, r6)
            if (r13 != r0) goto L5d
            return r0
        L5d:
            r0 = r12
        L5e:
            boolean r1 = kotlin.Result.h(r13)
            if (r1 == 0) goto Lb4
            r1 = r13
            com.superwall.sdk.paywall.view.PaywallView r1 = (com.superwall.sdk.paywall.view.PaywallView) r1
            java.lang.ref.WeakReference r2 = new java.lang.ref.WeakReference
            android.app.Activity r3 = r0.activity
            r2.<init>(r3)
            r1.setEncapsulatingActivity(r2)
            com.superwall.sdk.paywall.view.PaywallShimmerView r2 = r0.shimmmerView
            if (r2 != 0) goto L81
            com.superwall.sdk.paywall.view.ShimmerView r2 = new com.superwall.sdk.paywall.view.ShimmerView
            android.app.Activity r3 = r0.activity
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            r4 = 2
            r5 = 0
            r2.<init>(r3, r5, r4, r5)
        L81:
            com.superwall.sdk.paywall.view.PaywallPurchaseLoadingView r3 = r0.purchaseLoadingView
            if (r3 != 0) goto La8
            com.superwall.sdk.paywall.view.LoadingView r4 = new com.superwall.sdk.paywall.view.LoadingView
            android.app.Activity r5 = r0.activity
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            com.superwall.sdk.Superwall$Companion r0 = com.superwall.sdk.Superwall.Companion
            com.superwall.sdk.Superwall r0 = r0.getInstance()
            com.superwall.sdk.config.options.SuperwallOptions r0 = r0.getOptions()
            com.superwall.sdk.config.options.PaywallOptions r0 = r0.getPaywalls()
            java.lang.Integer r9 = r0.getLoadingColor()
            r10 = 14
            r11 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r4.<init>(r5, r6, r7, r8, r9, r10, r11)
            r3 = r4
        La8:
            r1.setupWith(r2, r3)
            r1.setupShimmer$superwall_release(r2)
            r1.setupLoading$superwall_release(r3)
            r1.beforeViewCreated()
        Lb4:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.presentation.get_paywall.builder.PaywallBuilder.m1325buildIoAF18A(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final PaywallView buildSync() {
        return (PaywallView) BuildersKt__BuildersKt.b(null, new AnonymousClass1(null), 1, null);
    }

    public final void buildWithCallback(Function1<? super PaywallView, Unit> onSuccess, Function1<? super Throwable, Unit> onError) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        BuildersKt__Builders_commonKt.d(new IOScope(null, 1, null), null, null, new PaywallBuilder$build$3(this, onSuccess, onError, null), 3, null);
    }

    public final PaywallBuilder delegate(PaywallViewCallback delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
        return this;
    }

    public final String getPlacement() {
        return this.placement;
    }

    public final PaywallBuilder overrides(PaywallOverrides paywallOverrides) {
        this.paywallOverrides = paywallOverrides;
        return this;
    }

    public final PaywallBuilder params(Map<String, ? extends Object> map) {
        this.params = map;
        return this;
    }

    public final <T extends View & PaywallPurchaseLoadingView> PaywallBuilder purchaseLoadingView(T purchaseLoadingView) {
        Intrinsics.checkNotNullParameter(purchaseLoadingView, "purchaseLoadingView");
        this.purchaseLoadingView = purchaseLoadingView;
        return this;
    }

    public final <T extends View & PaywallShimmerView> PaywallBuilder shimmerView(T shimmerView) {
        Intrinsics.checkNotNullParameter(shimmerView, "shimmerView");
        this.shimmmerView = shimmerView;
        return this;
    }
}
