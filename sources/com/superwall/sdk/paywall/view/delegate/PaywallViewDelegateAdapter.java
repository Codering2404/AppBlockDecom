package com.superwall.sdk.paywall.view.delegate;

import com.superwall.sdk.paywall.presentation.internal.state.PaywallResult;
import com.superwall.sdk.paywall.view.PaywallView;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

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
public final class PaywallViewDelegateAdapter {
    private final WeakReference<PaywallViewCallback> kotlinDelegate;

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.delegate.PaywallViewDelegateAdapter$onFinished$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.view.delegate.PaywallViewDelegateAdapter$onFinished$2", f = "PaywallViewDelegateAdapter.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PaywallView $paywall;
        final /* synthetic */ PaywallResult $result;
        final /* synthetic */ boolean $shouldDismiss;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(PaywallView paywallView, PaywallResult paywallResult, boolean z2, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$paywall = paywallView;
            this.$result = paywallResult;
            this.$shouldDismiss = z2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PaywallViewDelegateAdapter.this.new AnonymousClass2(this.$paywall, this.$result, this.$shouldDismiss, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            PaywallViewCallback paywallViewCallback;
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            WeakReference<PaywallViewCallback> kotlinDelegate = PaywallViewDelegateAdapter.this.getKotlinDelegate();
            if (kotlinDelegate == null || (paywallViewCallback = kotlinDelegate.get()) == null) {
                return null;
            }
            paywallViewCallback.onFinished(this.$paywall, this.$result, this.$shouldDismiss);
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    public PaywallViewDelegateAdapter(PaywallViewCallback paywallViewCallback) {
        this.kotlinDelegate = new WeakReference<>(paywallViewCallback);
    }

    public final boolean getHasJavaDelegate() {
        return false;
    }

    public final WeakReference<PaywallViewCallback> getKotlinDelegate() {
        return this.kotlinDelegate;
    }

    public final Object onFinished(PaywallView paywallView, PaywallResult paywallResult, boolean z2, Continuation<? super Unit> continuation) {
        return BuildersKt.g(Dispatchers.c(), new AnonymousClass2(paywallView, paywallResult, z2, null), continuation);
    }
}
