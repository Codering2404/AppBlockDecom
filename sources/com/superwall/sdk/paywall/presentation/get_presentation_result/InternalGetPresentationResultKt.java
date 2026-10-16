package com.superwall.sdk.paywall.presentation.get_presentation_result;

import com.superwall.sdk.logger.LogLevel;
import com.superwall.sdk.logger.LogScope;
import com.superwall.sdk.logger.Logger;
import com.superwall.sdk.paywall.presentation.internal.PaywallPresentationRequestStatusReason;
import com.superwall.sdk.paywall.presentation.internal.PresentationRequestType;
import com.superwall.sdk.paywall.presentation.result.PresentationResult;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

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
public final class InternalGetPresentationResultKt {

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.get_presentation_result.InternalGetPresentationResultKt$getPresentationResult$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.get_presentation_result.InternalGetPresentationResultKt", f = "InternalGetPresentationResult.kt", l = {15}, m = "getPresentationResult")
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InternalGetPresentationResultKt.getPresentationResult(null, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object getPresentationResult(com.superwall.sdk.Superwall r7, com.superwall.sdk.paywall.presentation.internal.PresentationRequest r8, kotlin.coroutines.Continuation<? super com.superwall.sdk.paywall.presentation.result.PresentationResult> r9) throws java.lang.Throwable {
        /*
            boolean r0 = r9 instanceof com.superwall.sdk.paywall.presentation.get_presentation_result.InternalGetPresentationResultKt.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r9
            com.superwall.sdk.paywall.presentation.get_presentation_result.InternalGetPresentationResultKt$getPresentationResult$1 r0 = (com.superwall.sdk.paywall.presentation.get_presentation_result.InternalGetPresentationResultKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r4 = r0
            goto L1a
        L14:
            com.superwall.sdk.paywall.presentation.get_presentation_result.InternalGetPresentationResultKt$getPresentationResult$1 r0 = new com.superwall.sdk.paywall.presentation.get_presentation_result.InternalGetPresentationResultKt$getPresentationResult$1
            r0.<init>(r9)
            goto L12
        L1a:
            java.lang.Object r9 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L3e
            if (r1 != r2) goto L36
            java.lang.Object r7 = r4.L$0
            r8 = r7
            com.superwall.sdk.paywall.presentation.internal.PresentationRequest r8 = (com.superwall.sdk.paywall.presentation.internal.PresentationRequest) r8
            kotlin.ResultKt.b(r9)
            kotlin.Result r9 = (kotlin.Result) r9
            java.lang.Object r7 = r9.j()
            goto L52
        L36:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3e:
            kotlin.ResultKt.b(r9)
            r4.L$0 = r8
            r4.label = r2
            r3 = 0
            r5 = 2
            r6 = 0
            r1 = r7
            r2 = r8
            java.lang.Object r7 = com.superwall.sdk.paywall.presentation.internal.GetPaywallComponentsKt.getPaywallComponents$default(r1, r2, r3, r4, r5, r6)
            if (r7 != r0) goto L51
            return r0
        L51:
            r8 = r2
        L52:
            boolean r9 = kotlin.Result.h(r7)
            if (r9 == 0) goto L68
            com.superwall.sdk.paywall.presentation.get_paywall.PaywallComponents r7 = (com.superwall.sdk.paywall.presentation.get_paywall.PaywallComponents) r7
            com.superwall.sdk.paywall.presentation.get_presentation_result.GetPresentationResultLogic r9 = com.superwall.sdk.paywall.presentation.get_presentation_result.GetPresentationResultLogic.INSTANCE
            com.superwall.sdk.paywall.presentation.rule_logic.RuleEvaluationOutcome r7 = r7.getRulesOutcome()
            com.superwall.sdk.models.triggers.InternalTriggerResult r7 = r7.getTriggerResult()
            com.superwall.sdk.paywall.presentation.result.PresentationResult r7 = r9.convertTriggerResult(r7)
        L68:
            java.lang.Object r7 = kotlin.Result.b(r7)
            java.lang.Throwable r9 = kotlin.Result.e(r7)
            if (r9 != 0) goto L75
            com.superwall.sdk.paywall.presentation.result.PresentationResult r7 = (com.superwall.sdk.paywall.presentation.result.PresentationResult) r7
            return r7
        L75:
            boolean r7 = r9 instanceof com.superwall.sdk.paywall.presentation.internal.PaywallPresentationRequestStatusReason
            if (r7 == 0) goto L88
            com.superwall.sdk.paywall.presentation.internal.PaywallPresentationRequestStatusReason r9 = (com.superwall.sdk.paywall.presentation.internal.PaywallPresentationRequestStatusReason) r9
            com.superwall.sdk.paywall.presentation.internal.PresentationRequest$Flags r7 = r8.getFlags()
            com.superwall.sdk.paywall.presentation.internal.PresentationRequestType r7 = r7.getType()
            com.superwall.sdk.paywall.presentation.result.PresentationResult r7 = handle(r9, r7)
            return r7
        L88:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.presentation.get_presentation_result.InternalGetPresentationResultKt.getPresentationResult(com.superwall.sdk.Superwall, com.superwall.sdk.paywall.presentation.internal.PresentationRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final PresentationResult handle(PaywallPresentationRequestStatusReason paywallPresentationRequestStatusReason, PresentationRequestType presentationRequestType) {
        if (!Intrinsics.areEqual(presentationRequestType, PresentationRequestType.GetImplicitPresentationResult.INSTANCE)) {
            Logger.debug$default(Logger.INSTANCE, LogLevel.info, LogScope.paywallPresentation, "Paywall presentation error: " + paywallPresentationRequestStatusReason, (Map) null, (Throwable) null, 24, (Object) null);
        }
        if (paywallPresentationRequestStatusReason instanceof PaywallPresentationRequestStatusReason.NoPaywallView) {
            return new PresentationResult.PaywallNotAvailable();
        }
        if (paywallPresentationRequestStatusReason instanceof PaywallPresentationRequestStatusReason.NoAudienceMatch) {
            return new PresentationResult.NoAudienceMatch();
        }
        if (paywallPresentationRequestStatusReason instanceof PaywallPresentationRequestStatusReason.Holdout) {
            return new PresentationResult.Holdout(((PaywallPresentationRequestStatusReason.Holdout) paywallPresentationRequestStatusReason).getExperiment());
        }
        if (paywallPresentationRequestStatusReason instanceof PaywallPresentationRequestStatusReason.PlacementNotFound) {
            return new PresentationResult.PlacementNotFound();
        }
        if ((paywallPresentationRequestStatusReason instanceof PaywallPresentationRequestStatusReason.DebuggerPresented) || (paywallPresentationRequestStatusReason instanceof PaywallPresentationRequestStatusReason.NoPresenter) || (paywallPresentationRequestStatusReason instanceof PaywallPresentationRequestStatusReason.PaywallAlreadyPresented) || (paywallPresentationRequestStatusReason instanceof PaywallPresentationRequestStatusReason.NoConfig) || (paywallPresentationRequestStatusReason instanceof PaywallPresentationRequestStatusReason.SubscriptionStatusTimeout)) {
            return new PresentationResult.PaywallNotAvailable();
        }
        throw new NoWhenBranchMatchedException();
    }
}
