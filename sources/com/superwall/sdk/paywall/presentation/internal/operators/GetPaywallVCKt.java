package com.superwall.sdk.paywall.presentation.internal.operators;

import com.superwall.sdk.dependencies.DependencyContainer;
import com.superwall.sdk.paywall.presentation.internal.PresentationRequest;
import com.superwall.sdk.paywall.presentation.rule_logic.RuleEvaluationOutcome;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.MutableSharedFlow;

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
public final class GetPaywallVCKt {

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.internal.operators.GetPaywallVCKt$getPaywallView$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.internal.operators.GetPaywallVCKt", f = "GetPaywallVC.kt", l = {28, 64, 87}, m = "getPaywallView")
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            Object paywallView = GetPaywallVCKt.getPaywallView(null, null, null, null, null, this);
            return paywallView == IntrinsicsKt.f() ? paywallView : Result.a(paywallView);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.internal.operators.GetPaywallVCKt$presentationFailure$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.internal.operators.GetPaywallVCKt", f = "GetPaywallVC.kt", l = {103}, m = "presentationFailure")
    static final class C28461 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C28461(Continuation<? super C28461> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GetPaywallVCKt.presentationFailure(null, null, null, this);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:0|2|(2:4|(1:6)(1:8))(0)|7|9|(1:(1:(1:(3:14|68|69)(2:15|16))(7:17|71|18|48|(1:50)(2:51|(1:53)(2:59|60))|54|(1:56)(2:57|58)))(1:22))(3:23|(1:26)|67)|27|(1:29)(1:30)|31|70|32|(1:39)(1:36)|40|(6:42|43|72|44|(5:47|48|(0)(0)|54|(0)(0))|67)(2:63|64)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0104, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01b6, code lost:
    
        if (r0 == r1) goto L67;
     */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0149 A[Catch: all -> 0x004a, TryCatch #1 {all -> 0x004a, blocks: (B:18:0x0045, B:48:0x0143, B:50:0x0149, B:54:0x016a, B:57:0x0171, B:58:0x0178, B:51:0x0156, B:53:0x015a, B:59:0x0179, B:60:0x017e), top: B:71:0x0045 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0156 A[Catch: all -> 0x004a, TryCatch #1 {all -> 0x004a, blocks: (B:18:0x0045, B:48:0x0143, B:50:0x0149, B:54:0x016a, B:57:0x0171, B:58:0x0178, B:51:0x0156, B:53:0x015a, B:59:0x0179, B:60:0x017e), top: B:71:0x0045 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0170 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0171 A[Catch: all -> 0x004a, TryCatch #1 {all -> 0x004a, blocks: (B:18:0x0045, B:48:0x0143, B:50:0x0149, B:54:0x016a, B:57:0x0171, B:58:0x0178, B:51:0x0156, B:53:0x015a, B:59:0x0179, B:60:0x017e), top: B:71:0x0045 }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object getPaywallView(com.superwall.sdk.paywall.presentation.internal.PresentationRequest r24, com.superwall.sdk.paywall.presentation.rule_logic.RuleEvaluationOutcome r25, java.util.Map<java.lang.String, ? extends java.lang.Object> r26, kotlinx.coroutines.flow.MutableSharedFlow<com.superwall.sdk.paywall.presentation.internal.state.PaywallState> r27, com.superwall.sdk.dependencies.DependencyContainer r28, kotlin.coroutines.Continuation<? super kotlin.Result<com.superwall.sdk.paywall.view.PaywallView>> r29) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 452
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.presentation.internal.operators.GetPaywallVCKt.getPaywallView(com.superwall.sdk.paywall.presentation.internal.PresentationRequest, com.superwall.sdk.paywall.presentation.rule_logic.RuleEvaluationOutcome, java.util.Map, kotlinx.coroutines.flow.MutableSharedFlow, com.superwall.sdk.dependencies.DependencyContainer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object getPaywallView$default(PresentationRequest presentationRequest, RuleEvaluationOutcome ruleEvaluationOutcome, Map map, MutableSharedFlow mutableSharedFlow, DependencyContainer dependencyContainer, Continuation continuation, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            mutableSharedFlow = null;
        }
        return getPaywallView(presentationRequest, ruleEvaluationOutcome, map, mutableSharedFlow, dependencyContainer, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object presentationFailure(java.lang.Throwable r10, java.util.Map<java.lang.String, ? extends java.lang.Object> r11, kotlinx.coroutines.flow.MutableSharedFlow<com.superwall.sdk.paywall.presentation.internal.state.PaywallState> r12, kotlin.coroutines.Continuation<? super java.lang.Throwable> r13) throws java.lang.Throwable {
        /*
            boolean r0 = r13 instanceof com.superwall.sdk.paywall.presentation.internal.operators.GetPaywallVCKt.C28461
            if (r0 == 0) goto L13
            r0 = r13
            com.superwall.sdk.paywall.presentation.internal.operators.GetPaywallVCKt$presentationFailure$1 r0 = (com.superwall.sdk.paywall.presentation.internal.operators.GetPaywallVCKt.C28461) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.paywall.presentation.internal.operators.GetPaywallVCKt$presentationFailure$1 r0 = new com.superwall.sdk.paywall.presentation.internal.operators.GetPaywallVCKt$presentationFailure$1
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r10 = r0.L$0
            java.lang.Throwable r10 = (java.lang.Throwable) r10
            kotlin.ResultKt.b(r13)
            goto L58
        L2d:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L35:
            kotlin.ResultKt.b(r13)
            com.superwall.sdk.logger.Logger r4 = com.superwall.sdk.logger.Logger.INSTANCE
            com.superwall.sdk.logger.LogLevel r5 = com.superwall.sdk.logger.LogLevel.error
            com.superwall.sdk.logger.LogScope r6 = com.superwall.sdk.logger.LogScope.paywallPresentation
            java.lang.String r7 = "Error Getting Paywall View"
            r9 = r10
            r8 = r11
            r4.debug(r5, r6, r7, r8, r9)
            if (r12 == 0) goto L57
            com.superwall.sdk.paywall.presentation.internal.state.PaywallState$PresentationError r10 = new com.superwall.sdk.paywall.presentation.internal.state.PaywallState$PresentationError
            r10.<init>(r9)
            r0.L$0 = r9
            r0.label = r3
            java.lang.Object r10 = r12.emit(r10, r0)
            if (r10 != r1) goto L57
            return r1
        L57:
            r10 = r9
        L58:
            boolean r11 = r10 instanceof com.superwall.sdk.billing.BillingError
            if (r11 == 0) goto L77
            com.superwall.sdk.paywall.presentation.internal.PaywallPresentationRequestStatusReason$SubscriptionStatusTimeout r11 = new com.superwall.sdk.paywall.presentation.internal.PaywallPresentationRequestStatusReason$SubscriptionStatusTimeout
            java.lang.String r10 = r10.getMessage()
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "Google Play Billing is not available or has an error: "
            r12.append(r13)
            r12.append(r10)
            java.lang.String r10 = r12.toString()
            r11.<init>(r10)
            return r11
        L77:
            com.superwall.sdk.paywall.presentation.internal.PaywallPresentationRequestStatusReason$NoPaywallView r11 = new com.superwall.sdk.paywall.presentation.internal.PaywallPresentationRequestStatusReason$NoPaywallView
            java.lang.String r10 = r10.getMessage()
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "The paywall view could not be created: "
            r12.append(r13)
            r12.append(r10)
            java.lang.String r10 = r12.toString()
            r11.<init>(r10)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.presentation.internal.operators.GetPaywallVCKt.presentationFailure(java.lang.Throwable, java.util.Map, kotlinx.coroutines.flow.MutableSharedFlow, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
