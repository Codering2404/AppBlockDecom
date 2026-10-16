package com.superwall.sdk.paywall.presentation.internal.operators;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

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
public final class EvaluateRulesKt {

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.internal.operators.EvaluateRulesKt$evaluateRules$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.internal.operators.EvaluateRulesKt", f = "EvaluateRules.kt", l = {29, 25}, m = "evaluateRules")
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            Object objEvaluateRules = EvaluateRulesKt.evaluateRules(null, null, this);
            return objEvaluateRules == IntrinsicsKt.f() ? objEvaluateRules : Result.a(objEvaluateRules);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.internal.operators.EvaluateRulesKt$evaluateRules$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.internal.operators.EvaluateRulesKt", f = "EvaluateRules.kt", l = {53}, m = "evaluateRules")
    static final class AnonymousClass2 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            Object objEvaluateRules = EvaluateRulesKt.evaluateRules(null, null, null, null, null, null, this);
            return objEvaluateRules == IntrinsicsKt.f() ? objEvaluateRules : Result.a(objEvaluateRules);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object evaluateRules(com.superwall.sdk.Superwall r8, com.superwall.sdk.paywall.presentation.internal.PresentationRequest r9, kotlin.coroutines.Continuation<? super kotlin.Result<com.superwall.sdk.paywall.presentation.rule_logic.RuleEvaluationOutcome>> r10) throws java.lang.Throwable {
        /*
            boolean r0 = r10 instanceof com.superwall.sdk.paywall.presentation.internal.operators.EvaluateRulesKt.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r10
            com.superwall.sdk.paywall.presentation.internal.operators.EvaluateRulesKt$evaluateRules$1 r0 = (com.superwall.sdk.paywall.presentation.internal.operators.EvaluateRulesKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r7 = r0
            goto L1a
        L14:
            com.superwall.sdk.paywall.presentation.internal.operators.EvaluateRulesKt$evaluateRules$1 r0 = new com.superwall.sdk.paywall.presentation.internal.operators.EvaluateRulesKt$evaluateRules$1
            r0.<init>(r10)
            goto L12
        L1a:
            java.lang.Object r10 = r7.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r7.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L57
            if (r1 == r3) goto L3c
            if (r1 != r2) goto L34
            kotlin.ResultKt.b(r10)
            kotlin.Result r10 = (kotlin.Result) r10
            java.lang.Object r8 = r10.j()
            return r8
        L34:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3c:
            java.lang.Object r8 = r7.L$4
            com.superwall.sdk.dependencies.RuleAttributesFactory r8 = (com.superwall.sdk.dependencies.RuleAttributesFactory) r8
            java.lang.Object r9 = r7.L$3
            com.superwall.sdk.storage.LocalStorage r9 = (com.superwall.sdk.storage.LocalStorage) r9
            java.lang.Object r1 = r7.L$2
            com.superwall.sdk.config.Assignments r1 = (com.superwall.sdk.config.Assignments) r1
            java.lang.Object r3 = r7.L$1
            com.superwall.sdk.paywall.presentation.internal.PresentationRequest r3 = (com.superwall.sdk.paywall.presentation.internal.PresentationRequest) r3
            java.lang.Object r4 = r7.L$0
            com.superwall.sdk.Superwall r4 = (com.superwall.sdk.Superwall) r4
            kotlin.ResultKt.b(r10)
            r6 = r3
            r3 = r8
            r8 = r4
            goto L8d
        L57:
            kotlin.ResultKt.b(r10)
            com.superwall.sdk.dependencies.DependencyContainer r10 = r8.getDependencyContainer$superwall_release()
            com.superwall.sdk.config.Assignments r1 = r10.getAssignments$superwall_release()
            com.superwall.sdk.dependencies.DependencyContainer r10 = r8.getDependencyContainer$superwall_release()
            com.superwall.sdk.storage.LocalStorage r10 = r10.getStorage()
            com.superwall.sdk.dependencies.DependencyContainer r4 = r8.getDependencyContainer$superwall_release()
            com.superwall.sdk.dependencies.DependencyContainer r5 = r8.getDependencyContainer$superwall_release()
            android.content.Context r6 = r8.getContext$superwall_release()
            r7.L$0 = r8
            r7.L$1 = r9
            r7.L$2 = r1
            r7.L$3 = r10
            r7.L$4 = r4
            r7.label = r3
            java.lang.Object r3 = r5.provideRuleEvaluator(r6, r7)
            if (r3 != r0) goto L89
            goto Lb0
        L89:
            r6 = r9
            r9 = r10
            r10 = r3
            r3 = r4
        L8d:
            r4 = r10
            com.superwall.sdk.paywall.presentation.rule_logic.expression_evaluator.ExpressionEvaluating r4 = (com.superwall.sdk.paywall.presentation.rule_logic.expression_evaluator.ExpressionEvaluating) r4
            com.superwall.sdk.dependencies.DependencyContainer r8 = r8.getDependencyContainer$superwall_release()
            com.superwall.sdk.config.ConfigManager r8 = r8.getConfigManager()
            java.util.Map r5 = r8.getTriggersByEventName()
            r8 = 0
            r7.L$0 = r8
            r7.L$1 = r8
            r7.L$2 = r8
            r7.L$3 = r8
            r7.L$4 = r8
            r7.label = r2
            r2 = r9
            java.lang.Object r8 = evaluateRules(r1, r2, r3, r4, r5, r6, r7)
            if (r8 != r0) goto Lb1
        Lb0:
            return r0
        Lb1:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.presentation.internal.operators.EvaluateRulesKt.evaluateRules(com.superwall.sdk.Superwall, com.superwall.sdk.paywall.presentation.internal.PresentationRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object evaluateRules(com.superwall.sdk.config.Assignments r6, com.superwall.sdk.storage.LocalStorage r7, com.superwall.sdk.dependencies.RuleAttributesFactory r8, com.superwall.sdk.paywall.presentation.rule_logic.expression_evaluator.ExpressionEvaluating r9, java.util.Map<java.lang.String, com.superwall.sdk.models.triggers.Trigger> r10, com.superwall.sdk.paywall.presentation.internal.PresentationRequest r11, kotlin.coroutines.Continuation<? super kotlin.Result<com.superwall.sdk.paywall.presentation.rule_logic.RuleEvaluationOutcome>> r12) throws java.lang.Throwable {
        /*
            boolean r0 = r12 instanceof com.superwall.sdk.paywall.presentation.internal.operators.EvaluateRulesKt.AnonymousClass2
            if (r0 == 0) goto L13
            r0 = r12
            com.superwall.sdk.paywall.presentation.internal.operators.EvaluateRulesKt$evaluateRules$2 r0 = (com.superwall.sdk.paywall.presentation.internal.operators.EvaluateRulesKt.AnonymousClass2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.paywall.presentation.internal.operators.EvaluateRulesKt$evaluateRules$2 r0 = new com.superwall.sdk.paywall.presentation.internal.operators.EvaluateRulesKt$evaluateRules$2
            r0.<init>(r12)
        L18:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r12)
            goto L4c
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            kotlin.ResultKt.b(r12)
            com.superwall.sdk.paywall.presentation.internal.request.PresentationInfo r12 = r11.getPresentationInfo()
            com.superwall.sdk.models.events.EventData r12 = r12.getEventData()
            if (r12 == 0) goto L7a
            com.superwall.sdk.paywall.presentation.rule_logic.RuleLogic r11 = new com.superwall.sdk.paywall.presentation.rule_logic.RuleLogic
            r11.<init>(r6, r7, r8, r9)
            r0.label = r3
            java.lang.Object r12 = r11.evaluateRules(r12, r10, r0)
            if (r12 != r1) goto L4c
            return r1
        L4c:
            com.superwall.sdk.misc.Either r12 = (com.superwall.sdk.misc.Either) r12
            boolean r6 = r12 instanceof com.superwall.sdk.misc.Either.Success
            if (r6 == 0) goto L5f
            kotlin.Result$Companion r6 = kotlin.Result.f139772b
            com.superwall.sdk.misc.Either$Success r12 = (com.superwall.sdk.misc.Either.Success) r12
            java.lang.Object r6 = r12.getValue()
            java.lang.Object r6 = kotlin.Result.b(r6)
            return r6
        L5f:
            boolean r6 = r12 instanceof com.superwall.sdk.misc.Either.Failure
            if (r6 == 0) goto L74
            kotlin.Result$Companion r6 = kotlin.Result.f139772b
            com.superwall.sdk.misc.Either$Failure r12 = (com.superwall.sdk.misc.Either.Failure) r12
            java.lang.Throwable r6 = r12.getError()
            java.lang.Object r6 = kotlin.ResultKt.a(r6)
            java.lang.Object r6 = kotlin.Result.b(r6)
            return r6
        L74:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        L7a:
            com.superwall.sdk.paywall.presentation.internal.request.PresentationInfo r6 = r11.getPresentationInfo()
            java.lang.String r6 = r6.getIdentifier()
            if (r6 != 0) goto L96
            kotlin.Result$Companion r6 = kotlin.Result.f139772b
            com.superwall.sdk.paywall.presentation.internal.PaywallPresentationRequestStatusReason$NoPaywallView r6 = new com.superwall.sdk.paywall.presentation.internal.PaywallPresentationRequestStatusReason$NoPaywallView
            java.lang.String r7 = "No paywall identifier provided for debugger presentation."
            r6.<init>(r7)
            java.lang.Object r6 = kotlin.ResultKt.a(r6)
            java.lang.Object r6 = kotlin.Result.b(r6)
            return r6
        L96:
            kotlin.Result$Companion r7 = kotlin.Result.f139772b
            com.superwall.sdk.paywall.presentation.rule_logic.RuleEvaluationOutcome r0 = new com.superwall.sdk.paywall.presentation.rule_logic.RuleEvaluationOutcome
            com.superwall.sdk.models.triggers.InternalTriggerResult$Paywall r3 = new com.superwall.sdk.models.triggers.InternalTriggerResult$Paywall
            com.superwall.sdk.models.triggers.Experiment$Companion r7 = com.superwall.sdk.models.triggers.Experiment.Companion
            com.superwall.sdk.models.triggers.Experiment r6 = r7.presentById(r6)
            r3.<init>(r6)
            r4 = 3
            r5 = 0
            r1 = 0
            r2 = 0
            r0.<init>(r1, r2, r3, r4, r5)
            java.lang.Object r6 = kotlin.Result.b(r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.presentation.internal.operators.EvaluateRulesKt.evaluateRules(com.superwall.sdk.config.Assignments, com.superwall.sdk.storage.LocalStorage, com.superwall.sdk.dependencies.RuleAttributesFactory, com.superwall.sdk.paywall.presentation.rule_logic.expression_evaluator.ExpressionEvaluating, java.util.Map, com.superwall.sdk.paywall.presentation.internal.PresentationRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
