package com.superwall.sdk.paywall.presentation.internal;

import android.app.Activity;
import com.superwall.sdk.Superwall;
import com.superwall.sdk.misc.ActivityProvider;
import com.superwall.sdk.models.assignment.ConfirmableAssignment;
import com.superwall.sdk.models.triggers.InternalTriggerResult;
import com.superwall.sdk.paywall.presentation.internal.operators.CheckDebuggerPresentationKt;
import com.superwall.sdk.paywall.presentation.internal.operators.ConfirmHoldoutAssignmentKt;
import com.superwall.sdk.paywall.presentation.internal.operators.ConfirmPaywallAssignmentKt;
import com.superwall.sdk.paywall.presentation.internal.operators.GetPresenterKt;
import com.superwall.sdk.paywall.presentation.internal.operators.WaitForSubsStatusAndConfigKt;
import com.superwall.sdk.paywall.presentation.internal.state.PaywallState;
import com.superwall.sdk.paywall.presentation.rule_logic.RuleEvaluationOutcome;
import com.superwall.sdk.paywall.view.PaywallView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
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
public final class DefaultGetPaywallComponentsFactory implements GetPaywallComponentsFactory {
    private final Superwall superwall;

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.internal.DefaultGetPaywallComponentsFactory$getPresenterIfNecessary$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.internal.DefaultGetPaywallComponentsFactory$getPresenterIfNecessary$2", f = "GetPaywallComponentsFactory.kt", l = {94}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function3<PresentationRequest, InternalTriggerResult, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(PresentationRequest presentationRequest, InternalTriggerResult internalTriggerResult, Continuation<? super Unit> continuation) {
            AnonymousClass2 anonymousClass2 = DefaultGetPaywallComponentsFactory.this.new AnonymousClass2(continuation);
            anonymousClass2.L$0 = presentationRequest;
            anonymousClass2.L$1 = internalTriggerResult;
            return anonymousClass2.invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                PresentationRequest presentationRequest = (PresentationRequest) this.L$0;
                InternalTriggerResult internalTriggerResult = (InternalTriggerResult) this.L$1;
                Superwall superwall = DefaultGetPaywallComponentsFactory.this.superwall;
                this.L$0 = null;
                this.label = 1;
                if (GetPresenterKt.attemptTriggerFire(superwall, presentationRequest, internalTriggerResult, this) == objF) {
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

    public DefaultGetPaywallComponentsFactory(Superwall superwall) {
        Intrinsics.checkNotNullParameter(superwall, "superwall");
        this.superwall = superwall;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Activity getPresenterIfNecessary$lambda$0(DefaultGetPaywallComponentsFactory defaultGetPaywallComponentsFactory) {
        ActivityProvider activityProvider = defaultGetPaywallComponentsFactory.superwall.getDependencyContainer$superwall_release().getActivityProvider();
        if (activityProvider != null) {
            return activityProvider.getCurrentActivity();
        }
        return null;
    }

    @Override // com.superwall.sdk.paywall.presentation.internal.GetPaywallComponentsFactory
    public Object checkDebuggerPresentation(PresentationRequest presentationRequest, MutableSharedFlow<PaywallState> mutableSharedFlow, Continuation<? super Unit> continuation) throws Throwable {
        Object objCheckDebuggerPresentation = CheckDebuggerPresentationKt.checkDebuggerPresentation(this.superwall, presentationRequest, mutableSharedFlow, continuation);
        return objCheckDebuggerPresentation == IntrinsicsKt.f() ? objCheckDebuggerPresentation : Unit.f139807a;
    }

    @Override // com.superwall.sdk.paywall.presentation.internal.GetPaywallComponentsFactory
    public Object confirmHoldoutAssignment(PresentationRequest presentationRequest, RuleEvaluationOutcome ruleEvaluationOutcome, Continuation<? super Unit> continuation) {
        ConfirmHoldoutAssignmentKt.confirmHoldoutAssignment$default(this.superwall, presentationRequest, ruleEvaluationOutcome, null, 4, null);
        return Unit.f139807a;
    }

    @Override // com.superwall.sdk.paywall.presentation.internal.GetPaywallComponentsFactory
    public Object confirmPaywallAssignment(ConfirmableAssignment confirmableAssignment, PresentationRequest presentationRequest, boolean z2, Continuation<? super Unit> continuation) {
        ConfirmPaywallAssignmentKt.confirmPaywallAssignment$default(this.superwall, confirmableAssignment, presentationRequest, z2, null, 8, null);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.superwall.sdk.paywall.presentation.internal.GetPaywallComponentsFactory
    /* JADX INFO: renamed from: evaluateRules-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo1326evaluateRulesgIAlus(com.superwall.sdk.paywall.presentation.internal.PresentationRequest r5, kotlin.coroutines.Continuation<? super kotlin.Result<com.superwall.sdk.paywall.presentation.rule_logic.RuleEvaluationOutcome>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.superwall.sdk.paywall.presentation.internal.DefaultGetPaywallComponentsFactory$evaluateRules$1
            if (r0 == 0) goto L13
            r0 = r6
            com.superwall.sdk.paywall.presentation.internal.DefaultGetPaywallComponentsFactory$evaluateRules$1 r0 = (com.superwall.sdk.paywall.presentation.internal.DefaultGetPaywallComponentsFactory$evaluateRules$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.paywall.presentation.internal.DefaultGetPaywallComponentsFactory$evaluateRules$1 r0 = new com.superwall.sdk.paywall.presentation.internal.DefaultGetPaywallComponentsFactory$evaluateRules$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            kotlin.ResultKt.b(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            java.lang.Object r5 = r6.j()
            return r5
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.ResultKt.b(r6)
            com.superwall.sdk.Superwall r6 = r4.superwall
            r0.label = r3
            java.lang.Object r5 = com.superwall.sdk.paywall.presentation.internal.operators.EvaluateRulesKt.evaluateRules(r6, r5, r0)
            if (r5 != r1) goto L45
            return r1
        L45:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.presentation.internal.DefaultGetPaywallComponentsFactory.mo1326evaluateRulesgIAlus(com.superwall.sdk.paywall.presentation.internal.PresentationRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // com.superwall.sdk.paywall.presentation.internal.GetPaywallComponentsFactory
    /* JADX INFO: renamed from: getPaywallView-yxL6bBk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo1327getPaywallViewyxL6bBk(com.superwall.sdk.paywall.presentation.internal.PresentationRequest r8, com.superwall.sdk.paywall.presentation.rule_logic.RuleEvaluationOutcome r9, java.util.Map<java.lang.String, ? extends java.lang.Object> r10, kotlinx.coroutines.flow.MutableSharedFlow<com.superwall.sdk.paywall.presentation.internal.state.PaywallState> r11, kotlin.coroutines.Continuation<? super kotlin.Result<com.superwall.sdk.paywall.view.PaywallView>> r12) {
        /*
            r7 = this;
            boolean r0 = r12 instanceof com.superwall.sdk.paywall.presentation.internal.DefaultGetPaywallComponentsFactory$getPaywallView$1
            if (r0 == 0) goto L14
            r0 = r12
            com.superwall.sdk.paywall.presentation.internal.DefaultGetPaywallComponentsFactory$getPaywallView$1 r0 = (com.superwall.sdk.paywall.presentation.internal.DefaultGetPaywallComponentsFactory$getPaywallView$1) r0
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
            com.superwall.sdk.paywall.presentation.internal.DefaultGetPaywallComponentsFactory$getPaywallView$1 r0 = new com.superwall.sdk.paywall.presentation.internal.DefaultGetPaywallComponentsFactory$getPaywallView$1
            r0.<init>(r7, r12)
            goto L12
        L1a:
            java.lang.Object r12 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L39
            if (r1 != r2) goto L31
            kotlin.ResultKt.b(r12)
            kotlin.Result r12 = (kotlin.Result) r12
            java.lang.Object r8 = r12.j()
            return r8
        L31:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L39:
            kotlin.ResultKt.b(r12)
            com.superwall.sdk.Superwall r12 = r7.superwall
            com.superwall.sdk.dependencies.DependencyContainer r5 = r12.getDependencyContainer$superwall_release()
            r6.label = r2
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r11
            java.lang.Object r8 = com.superwall.sdk.paywall.presentation.internal.operators.GetPaywallVCKt.getPaywallView(r1, r2, r3, r4, r5, r6)
            if (r8 != r0) goto L4f
            return r0
        L4f:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.presentation.internal.DefaultGetPaywallComponentsFactory.mo1327getPaywallViewyxL6bBk(com.superwall.sdk.paywall.presentation.internal.PresentationRequest, com.superwall.sdk.paywall.presentation.rule_logic.RuleEvaluationOutcome, java.util.Map, kotlinx.coroutines.flow.MutableSharedFlow, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.superwall.sdk.paywall.presentation.internal.GetPaywallComponentsFactory
    public Object getPresenterIfNecessary(PaywallView paywallView, RuleEvaluationOutcome ruleEvaluationOutcome, PresentationRequest presentationRequest, MutableSharedFlow<PaywallState> mutableSharedFlow, Continuation<? super Activity> continuation) {
        return GetPresenterKt.getPresenterIfNecessary(paywallView, ruleEvaluationOutcome, presentationRequest, mutableSharedFlow, new AnonymousClass2(null), new Function0() { // from class: com.superwall.sdk.paywall.presentation.internal.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DefaultGetPaywallComponentsFactory.getPresenterIfNecessary$lambda$0(this.f93619a);
            }
        }, continuation);
    }

    @Override // com.superwall.sdk.paywall.presentation.internal.GetPaywallComponentsFactory
    public Object waitForEntitlementsAndConfig(PresentationRequest presentationRequest, MutableSharedFlow<PaywallState> mutableSharedFlow, Continuation<? super Unit> continuation) throws Throwable {
        Object objWaitForEntitlementsAndConfig = WaitForSubsStatusAndConfigKt.waitForEntitlementsAndConfig(presentationRequest, mutableSharedFlow, this.superwall.getDependencyContainer$superwall_release(), continuation);
        return objWaitForEntitlementsAndConfig == IntrinsicsKt.f() ? objWaitForEntitlementsAndConfig : Unit.f139807a;
    }
}
