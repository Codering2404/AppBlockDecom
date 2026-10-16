package com.superwall.sdk.paywall.presentation.rule_logic.cel;

import com.superwall.sdk.dependencies.RuleAttributesFactory;
import com.superwall.sdk.models.events.EventData;
import com.superwall.sdk.models.triggers.TriggerRule;
import com.superwall.sdk.models.triggers.TriggerRuleOutcome;
import com.superwall.sdk.paywall.presentation.rule_logic.cel.models.PassableValue;
import com.superwall.sdk.paywall.presentation.rule_logic.expression_evaluator.ExpressionEvaluating;
import com.superwall.sdk.storage.core_data.CoreDataManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;

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
public final class ASTEvaluator implements ExpressionEvaluating {
    private final RuleAttributesFactory factory;
    private final Json json;
    private final CoreDataManager storage;

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.rule_logic.cel.ASTEvaluator$evaluateExpression$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.rule_logic.cel.ASTEvaluator", f = "ASTEvaluator.kt", l = {38, 53}, m = "evaluateExpression")
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ASTEvaluator.this.evaluateExpression(null, null, this);
        }
    }

    public ASTEvaluator(Json json, CoreDataManager storage, RuleAttributesFactory factory) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(storage, "storage");
        Intrinsics.checkNotNullParameter(factory, "factory");
        this.json = json;
        this.storage = storage;
        this.factory = factory;
    }

    @Override // com.superwall.sdk.paywall.presentation.rule_logic.expression_evaluator.ExpressionEvaluating
    public Object evaluateExpression(TriggerRule triggerRule, EventData eventData, PassableValue.MapValue mapValue, Continuation<? super TriggerRuleOutcome> continuation) {
        return ExpressionEvaluating.DefaultImpls.evaluateExpression(this, triggerRule, eventData, mapValue, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.superwall.sdk.paywall.presentation.rule_logic.expression_evaluator.ExpressionEvaluating
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object evaluateExpression(com.superwall.sdk.models.triggers.TriggerRule r8, com.superwall.sdk.models.events.EventData r9, kotlin.coroutines.Continuation<? super com.superwall.sdk.models.triggers.TriggerRuleOutcome> r10) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.superwall.sdk.paywall.presentation.rule_logic.cel.ASTEvaluator.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r10
            com.superwall.sdk.paywall.presentation.rule_logic.cel.ASTEvaluator$evaluateExpression$1 r0 = (com.superwall.sdk.paywall.presentation.rule_logic.cel.ASTEvaluator.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.paywall.presentation.rule_logic.cel.ASTEvaluator$evaluateExpression$1 r0 = new com.superwall.sdk.paywall.presentation.rule_logic.cel.ASTEvaluator$evaluateExpression$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r10)
            return r10
        L2c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L34:
            java.lang.Object r8 = r0.L$1
            com.superwall.sdk.models.triggers.TriggerRule r8 = (com.superwall.sdk.models.triggers.TriggerRule) r8
            java.lang.Object r9 = r0.L$0
            com.superwall.sdk.paywall.presentation.rule_logic.cel.ASTEvaluator r9 = (com.superwall.sdk.paywall.presentation.rule_logic.cel.ASTEvaluator) r9
            kotlin.ResultKt.b(r10)
            goto L66
        L40:
            kotlin.ResultKt.b(r10)
            com.superwall.sdk.models.triggers.TriggerRuleOutcome$Companion r10 = com.superwall.sdk.models.triggers.TriggerRuleOutcome.Companion
            com.superwall.sdk.models.triggers.UnmatchedRule$Source r2 = com.superwall.sdk.models.triggers.UnmatchedRule.Source.EXPRESSION
            com.superwall.sdk.models.triggers.RawExperiment r5 = r8.getExperiment()
            java.lang.String r5 = r5.getId()
            r10.noMatch(r2, r5)
            com.superwall.sdk.dependencies.RuleAttributesFactory r10 = r7.factory
            java.util.List r2 = r8.getComputedPropertyRequests()
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r4
            java.lang.Object r10 = r10.makeRuleAttributes(r9, r2, r0)
            if (r10 != r1) goto L65
            goto Lb0
        L65:
            r9 = r7
        L66:
            java.util.Map r10 = (java.util.Map) r10
            com.superwall.sdk.paywall.presentation.rule_logic.cel.SuperscriptEvaluatorKt.toPassableValue(r10)
            com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.CELExpression$And r10 = new com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.CELExpression$And
            com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.CELExpression$Atom r2 = new com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.CELExpression$Atom
            com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.CELAtom$Bool r5 = new com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.CELAtom$Bool
            r5.<init>(r4)
            r2.<init>(r5)
            com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.CELExpression$Atom r5 = new com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.CELExpression$Atom
            com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.CELAtom$Bool r6 = new com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.CELAtom$Bool
            r6.<init>(r4)
            r5.<init>(r6)
            r10.<init>(r2, r5)
            kotlinx.serialization.json.Json r2 = r9.json
            r2.a()
            com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.CELExpression$Companion r5 = com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.CELExpression.Companion
            kotlinx.serialization.KSerializer r5 = r5.serializer()
            kotlinx.serialization.SerializationStrategy r5 = (kotlinx.serialization.SerializationStrategy) r5
            java.lang.String r10 = r2.b(r5, r10)
            java.lang.String r10 = com.superwall.supercel.CELKt.evaluateAst(r10)
            java.lang.String r2 = "true"
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual(r10, r2)
            if (r10 == 0) goto Lb2
            com.superwall.sdk.storage.core_data.CoreDataManager r9 = r9.storage
            r10 = 0
            r0.L$0 = r10
            r0.L$1 = r10
            r0.label = r3
            java.lang.Object r8 = com.superwall.sdk.paywall.presentation.rule_logic.UtilsKt.tryToMatchOccurrence(r8, r9, r4, r0)
            if (r8 != r1) goto Lb1
        Lb0:
            return r1
        Lb1:
            return r8
        Lb2:
            com.superwall.sdk.models.triggers.TriggerRuleOutcome$Companion r9 = com.superwall.sdk.models.triggers.TriggerRuleOutcome.Companion
            com.superwall.sdk.models.triggers.UnmatchedRule$Source r10 = com.superwall.sdk.models.triggers.UnmatchedRule.Source.EXPRESSION
            com.superwall.sdk.models.triggers.RawExperiment r8 = r8.getExperiment()
            java.lang.String r8 = r8.getId()
            com.superwall.sdk.models.triggers.TriggerRuleOutcome r8 = r9.noMatch(r10, r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.presentation.rule_logic.cel.ASTEvaluator.evaluateExpression(com.superwall.sdk.models.triggers.TriggerRule, com.superwall.sdk.models.events.EventData, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
