package com.superwall.sdk.paywall.presentation.internal.operators;

import com.superwall.sdk.paywall.presentation.internal.PresentationRequest;
import com.superwall.sdk.paywall.presentation.rule_logic.RuleEvaluationOutcome;
import com.superwall.sdk.paywall.view.PaywallView;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
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
public final class GetPresenterKt {

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.internal.operators.GetPresenterKt$attemptTriggerFire$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.internal.operators.GetPresenterKt", f = "GetPresenter.kt", l = {112}, m = "attemptTriggerFire")
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GetPresenterKt.attemptTriggerFire(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.internal.operators.GetPresenterKt$getPresenterIfNecessary$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.internal.operators.GetPresenterKt", f = "GetPresenter.kt", l = {44, 61, 82}, m = "getPresenterIfNecessary")
    static final class C28471 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C28471(Continuation<? super C28471> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GetPresenterKt.getPresenterIfNecessary(null, null, null, null, null, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object attemptTriggerFire(com.superwall.sdk.Superwall r10, com.superwall.sdk.paywall.presentation.internal.PresentationRequest r11, com.superwall.sdk.models.triggers.InternalTriggerResult r12, kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            boolean r0 = r13 instanceof com.superwall.sdk.paywall.presentation.internal.operators.GetPresenterKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r13
            com.superwall.sdk.paywall.presentation.internal.operators.GetPresenterKt$attemptTriggerFire$1 r0 = (com.superwall.sdk.paywall.presentation.internal.operators.GetPresenterKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.paywall.presentation.internal.operators.GetPresenterKt$attemptTriggerFire$1 r0 = new com.superwall.sdk.paywall.presentation.internal.operators.GetPresenterKt$attemptTriggerFire$1
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            kotlin.ResultKt.b(r13)
            kotlin.Result r13 = (kotlin.Result) r13
            r13.j()
            goto L79
        L2e:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L36:
            kotlin.ResultKt.b(r13)
            com.superwall.sdk.paywall.presentation.internal.request.PresentationInfo r13 = r11.getPresentationInfo()
            java.lang.String r6 = r13.getEventName()
            if (r6 != 0) goto L46
            kotlin.Unit r10 = kotlin.Unit.f139807a
            return r10
        L46:
            com.superwall.sdk.paywall.presentation.internal.request.PresentationInfo r11 = r11.getPresentationInfo()
            boolean r13 = r11 instanceof com.superwall.sdk.paywall.presentation.internal.request.PresentationInfo.ExplicitTrigger
            if (r13 != 0) goto L5e
            boolean r13 = r11 instanceof com.superwall.sdk.paywall.presentation.internal.request.PresentationInfo.ImplicitTrigger
            if (r13 == 0) goto L53
            goto L5e
        L53:
            boolean r11 = r11 instanceof com.superwall.sdk.paywall.presentation.internal.request.PresentationInfo.FromIdentifier
            if (r11 == 0) goto L58
            goto L67
        L58:
            kotlin.NoWhenBranchMatchedException r10 = new kotlin.NoWhenBranchMatchedException
            r10.<init>()
            throw r10
        L5e:
            boolean r11 = r12 instanceof com.superwall.sdk.models.triggers.InternalTriggerResult.Error
            if (r11 != 0) goto L7c
            boolean r11 = r12 instanceof com.superwall.sdk.models.triggers.InternalTriggerResult.PlacementNotFound
            if (r11 == 0) goto L67
            goto L7c
        L67:
            com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent$TriggerFire r4 = new com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent$TriggerFire
            r8 = 4
            r9 = 0
            r7 = 0
            r5 = r12
            r4.<init>(r5, r6, r7, r8, r9)
            r0.label = r3
            java.lang.Object r10 = com.superwall.sdk.analytics.internal.TrackingKt.track(r10, r4, r0)
            if (r10 != r1) goto L79
            return r1
        L79:
            kotlin.Unit r10 = kotlin.Unit.f139807a
            return r10
        L7c:
            kotlin.Unit r10 = kotlin.Unit.f139807a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.presentation.internal.operators.GetPresenterKt.attemptTriggerFire(com.superwall.sdk.Superwall, com.superwall.sdk.paywall.presentation.internal.PresentationRequest, com.superwall.sdk.models.triggers.InternalTriggerResult, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x00d0, code lost:
    
        if (r1.emit(r2, r3) == r4) goto L45;
     */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object getPresenterIfNecessary(com.superwall.sdk.paywall.view.PaywallView r18, com.superwall.sdk.paywall.presentation.rule_logic.RuleEvaluationOutcome r19, com.superwall.sdk.paywall.presentation.internal.PresentationRequest r20, kotlinx.coroutines.flow.MutableSharedFlow<com.superwall.sdk.paywall.presentation.internal.state.PaywallState> r21, kotlin.jvm.functions.Function3<? super com.superwall.sdk.paywall.presentation.internal.PresentationRequest, ? super com.superwall.sdk.models.triggers.InternalTriggerResult, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r22, kotlin.jvm.functions.Function0<? extends android.app.Activity> r23, kotlin.coroutines.Continuation<? super android.app.Activity> r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 218
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.presentation.internal.operators.GetPresenterKt.getPresenterIfNecessary(com.superwall.sdk.paywall.view.PaywallView, com.superwall.sdk.paywall.presentation.rule_logic.RuleEvaluationOutcome, com.superwall.sdk.paywall.presentation.internal.PresentationRequest, kotlinx.coroutines.flow.MutableSharedFlow, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object getPresenterIfNecessary$default(PaywallView paywallView, RuleEvaluationOutcome ruleEvaluationOutcome, PresentationRequest presentationRequest, MutableSharedFlow mutableSharedFlow, Function3 function3, Function0 function0, Continuation continuation, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            mutableSharedFlow = null;
        }
        return getPresenterIfNecessary(paywallView, ruleEvaluationOutcome, presentationRequest, mutableSharedFlow, function3, function0, continuation);
    }
}
