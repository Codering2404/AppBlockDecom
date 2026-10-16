package com.superwall.sdk.paywall.presentation.rule_logic;

import com.revenuecat.purchases.ui.revenuecatui.templates.VWmQ.cJfnYMIyomoWf;
import com.superwall.sdk.config.Assignments;
import com.superwall.sdk.dependencies.RuleAttributesFactory;
import com.superwall.sdk.models.triggers.Experiment;
import com.superwall.sdk.paywall.presentation.rule_logic.expression_evaluator.ExpressionEvaluating;
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
public final class RuleLogic {
    private final Assignments assignments;
    private final RuleAttributesFactory factory;
    private final ExpressionEvaluating ruleEvaluator;
    private final LocalStorage storage;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Experiment.Variant.VariantType.values().length];
            try {
                iArr[Experiment.Variant.VariantType.HOLDOUT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Experiment.Variant.VariantType.TREATMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.rule_logic.RuleLogic$evaluateRules$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.rule_logic.RuleLogic", f = "RuleLogic.kt", l = {52}, m = "evaluateRules")
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
            return RuleLogic.this.evaluateRules(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.rule_logic.RuleLogic$findMatchingRule$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.rule_logic.RuleLogic", f = "RuleLogic.kt", l = {136, 140}, m = "findMatchingRule")
    static final class C28501 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C28501(Continuation<? super C28501> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RuleLogic.this.findMatchingRule(null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x0105 -> B:13:0x0049). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object findMatchingRule(com.superwall.sdk.models.events.EventData r13, com.superwall.sdk.models.triggers.Trigger r14, kotlin.coroutines.Continuation<? super com.superwall.sdk.paywall.presentation.rule_logic.RuleMatchOutcome> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 315
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.presentation.rule_logic.RuleLogic.findMatchingRule(com.superwall.sdk.models.events.EventData, com.superwall.sdk.models.triggers.Trigger, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object evaluateRules(com.superwall.sdk.models.events.EventData r11, java.util.Map<java.lang.String, com.superwall.sdk.models.triggers.Trigger> r12, kotlin.coroutines.Continuation<? super com.superwall.sdk.misc.Either<com.superwall.sdk.paywall.presentation.rule_logic.RuleEvaluationOutcome, java.lang.Throwable>> r13) {
        /*
            Method dump skipped, instruction units count: 363
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.presentation.rule_logic.RuleLogic.evaluateRules(com.superwall.sdk.models.events.EventData, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public RuleLogic(Assignments assignments, LocalStorage storage, RuleAttributesFactory factory, ExpressionEvaluating ruleEvaluator) {
        Intrinsics.checkNotNullParameter(assignments, cJfnYMIyomoWf.BgjYCcZwbz);
        Intrinsics.checkNotNullParameter(storage, "storage");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(ruleEvaluator, "ruleEvaluator");
        this.assignments = assignments;
        this.storage = storage;
        this.factory = factory;
        this.ruleEvaluator = ruleEvaluator;
    }
}
