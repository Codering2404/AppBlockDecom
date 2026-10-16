package com.superwall.sdk.paywall.presentation.rule_logic.expression_evaluator;

import com.superwall.sdk.models.events.EventData;
import com.superwall.sdk.models.triggers.TriggerRule;
import com.superwall.sdk.models.triggers.TriggerRuleOutcome;
import com.superwall.sdk.paywall.presentation.rule_logic.cel.SuperscriptEvaluator;
import com.superwall.sdk.storage.LocalStorage;
import kotlin.Metadata;
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
public final class CombinedExpressionEvaluator implements ExpressionEvaluating {
    private final LocalStorage storage;
    private final SuperscriptEvaluator superscriptEvaluator;

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.rule_logic.expression_evaluator.CombinedExpressionEvaluator$evaluateExpression$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.rule_logic.expression_evaluator.CombinedExpressionEvaluator", f = "CombinedExpressionEvaluator.kt", l = {44, 51}, m = "evaluateExpression")
    static final class AnonymousClass2 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CombinedExpressionEvaluator.this.evaluateExpression(null, null, null, this);
        }
    }

    public CombinedExpressionEvaluator(LocalStorage storage, SuperscriptEvaluator superscriptEvaluator) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        Intrinsics.checkNotNullParameter(superscriptEvaluator, "superscriptEvaluator");
        this.storage = storage;
        this.superscriptEvaluator = superscriptEvaluator;
    }

    @Override // com.superwall.sdk.paywall.presentation.rule_logic.expression_evaluator.ExpressionEvaluating
    public Object evaluateExpression(TriggerRule triggerRule, EventData eventData, Continuation<? super TriggerRuleOutcome> continuation) {
        return evaluateExpression(triggerRule, eventData, null, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x006b, code lost:
    
        if (r9 == r1) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.superwall.sdk.paywall.presentation.rule_logic.expression_evaluator.ExpressionEvaluating
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object evaluateExpression(com.superwall.sdk.models.triggers.TriggerRule r6, com.superwall.sdk.models.events.EventData r7, com.superwall.sdk.paywall.presentation.rule_logic.cel.models.PassableValue.MapValue r8, kotlin.coroutines.Continuation<? super com.superwall.sdk.models.triggers.TriggerRuleOutcome> r9) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r9 instanceof com.superwall.sdk.paywall.presentation.rule_logic.expression_evaluator.CombinedExpressionEvaluator.AnonymousClass2
            if (r0 == 0) goto L13
            r0 = r9
            com.superwall.sdk.paywall.presentation.rule_logic.expression_evaluator.CombinedExpressionEvaluator$evaluateExpression$2 r0 = (com.superwall.sdk.paywall.presentation.rule_logic.expression_evaluator.CombinedExpressionEvaluator.AnonymousClass2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.paywall.presentation.rule_logic.expression_evaluator.CombinedExpressionEvaluator$evaluateExpression$2 r0 = new com.superwall.sdk.paywall.presentation.rule_logic.expression_evaluator.CombinedExpressionEvaluator$evaluateExpression$2
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r6 = r0.L$0
            com.superwall.sdk.models.triggers.TriggerRule r6 = (com.superwall.sdk.models.triggers.TriggerRule) r6
            kotlin.ResultKt.b(r9)     // Catch: java.lang.Exception -> L71
            goto L6e
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L38:
            kotlin.ResultKt.b(r9)
            return r9
        L3c:
            kotlin.ResultKt.b(r9)
            java.lang.String r9 = r6.getExpressionJs()
            if (r9 != 0) goto L61
            java.lang.String r9 = r6.getExpression()
            if (r9 != 0) goto L61
            java.lang.String r9 = r6.getExpressionCEL()
            if (r9 != 0) goto L61
            com.superwall.sdk.storage.LocalStorage r7 = r5.storage
            com.superwall.sdk.storage.core_data.CoreDataManager r7 = r7.getCoreDataManager()
            r0.label = r4
            java.lang.Object r6 = com.superwall.sdk.paywall.presentation.rule_logic.UtilsKt.tryToMatchOccurrence(r6, r7, r4, r0)
            if (r6 != r1) goto L60
            goto L6d
        L60:
            return r6
        L61:
            com.superwall.sdk.paywall.presentation.rule_logic.cel.SuperscriptEvaluator r9 = r5.superscriptEvaluator     // Catch: java.lang.Exception -> L71
            r0.L$0 = r6     // Catch: java.lang.Exception -> L71
            r0.label = r3     // Catch: java.lang.Exception -> L71
            java.lang.Object r9 = r9.evaluateExpression(r6, r7, r8, r0)     // Catch: java.lang.Exception -> L71
            if (r9 != r1) goto L6e
        L6d:
            return r1
        L6e:
            com.superwall.sdk.models.triggers.TriggerRuleOutcome r9 = (com.superwall.sdk.models.triggers.TriggerRuleOutcome) r9     // Catch: java.lang.Exception -> L71
            return r9
        L71:
            com.superwall.sdk.models.triggers.TriggerRuleOutcome$Companion r7 = com.superwall.sdk.models.triggers.TriggerRuleOutcome.Companion
            com.superwall.sdk.models.triggers.UnmatchedRule$Source r8 = com.superwall.sdk.models.triggers.UnmatchedRule.Source.EXPRESSION
            com.superwall.sdk.models.triggers.RawExperiment r6 = r6.getExperiment()
            java.lang.String r6 = r6.getId()
            com.superwall.sdk.models.triggers.TriggerRuleOutcome r6 = r7.noMatch(r8, r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.presentation.rule_logic.expression_evaluator.CombinedExpressionEvaluator.evaluateExpression(com.superwall.sdk.models.triggers.TriggerRule, com.superwall.sdk.models.events.EventData, com.superwall.sdk.paywall.presentation.rule_logic.cel.models.PassableValue$MapValue, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
