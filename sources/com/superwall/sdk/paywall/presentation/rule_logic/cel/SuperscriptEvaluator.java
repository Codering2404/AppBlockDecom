package com.superwall.sdk.paywall.presentation.rule_logic.cel;

import com.superwall.sdk.dependencies.RuleAttributesFactory;
import com.superwall.sdk.misc.IOScope;
import com.superwall.sdk.models.events.EventData;
import com.superwall.sdk.models.triggers.TriggerRule;
import com.superwall.sdk.models.triggers.TriggerRuleOutcome;
import com.superwall.sdk.paywall.presentation.rule_logic.cel.models.PassableValue;
import com.superwall.sdk.paywall.presentation.rule_logic.expression_evaluator.ExpressionEvaluating;
import com.superwall.sdk.storage.core_data.CoreDataManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
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
public final class SuperscriptEvaluator implements ExpressionEvaluating {
    private final RuleAttributesFactory factory;
    private final SuperscriptHostContext hostContext;
    private final IOScope ioScope;
    private final Json json;
    private final CoreDataManager storage;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NotError extends Throwable {
        private final String string;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NotError(String string) {
            super(string);
            Intrinsics.checkNotNullParameter(string, "string");
            this.string = string;
        }

        public final String getString() {
            return this.string;
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.rule_logic.cel.SuperscriptEvaluator$evaluateExpression$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.rule_logic.cel.SuperscriptEvaluator", f = "SuperscriptEvaluator.kt", l = {69, 73, 123}, m = "evaluateExpression")
    static final class AnonymousClass2 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SuperscriptEvaluator.this.evaluateExpression(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.rule_logic.cel.SuperscriptEvaluator$evaluateExpression$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.rule_logic.cel.SuperscriptEvaluator$evaluateExpression$3", f = "SuperscriptEvaluator.kt", l = {76, 77, 114}, m = "invokeSuspend")
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super TriggerRuleOutcome>, Object> {
        final /* synthetic */ EventData $eventData;
        final /* synthetic */ TriggerRule $rule;
        final /* synthetic */ PassableValue.MapValue $sharedAttributes;
        int label;
        final /* synthetic */ SuperscriptEvaluator this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(PassableValue.MapValue mapValue, SuperscriptEvaluator superscriptEvaluator, EventData eventData, TriggerRule triggerRule, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$sharedAttributes = mapValue;
            this.this$0 = superscriptEvaluator;
            this.$eventData = eventData;
            this.$rule = triggerRule;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.$sharedAttributes, this.this$0, this.$eventData, this.$rule, continuation);
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: E */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x003d, code lost:
        
            if (r14 == r0) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0059, code lost:
        
            if (r14 == r0) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x01a7, code lost:
        
            if (r14 == r0) goto L43;
         */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0045  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x009f A[LOOP:0: B:24:0x0097->B:26:0x009f, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00e1 A[LOOP:1: B:28:0x00db->B:30:0x00e1, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:33:0x013f  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x017f  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 454
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.presentation.rule_logic.cel.SuperscriptEvaluator.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super TriggerRuleOutcome> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    public SuperscriptEvaluator(Json json, IOScope ioScope, CoreDataManager storage, RuleAttributesFactory factory, SuperscriptHostContext hostContext) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(ioScope, "ioScope");
        Intrinsics.checkNotNullParameter(storage, "storage");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(hostContext, "hostContext");
        this.json = json;
        this.ioScope = ioScope;
        this.storage = storage;
        this.factory = factory;
        this.hostContext = hostContext;
    }

    @Override // com.superwall.sdk.paywall.presentation.rule_logic.expression_evaluator.ExpressionEvaluating
    public Object evaluateExpression(TriggerRule triggerRule, EventData eventData, Continuation<? super TriggerRuleOutcome> continuation) {
        return evaluateExpression(triggerRule, eventData, null, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0087 -> B:24:0x008d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object overlayComputedProperties$superwall_release(com.superwall.sdk.paywall.presentation.rule_logic.cel.models.PassableValue.MapValue r10, com.superwall.sdk.models.events.EventData r11, java.util.List<com.superwall.sdk.models.config.ComputedPropertyRequest> r12, kotlin.coroutines.Continuation<? super com.superwall.sdk.paywall.presentation.rule_logic.cel.models.PassableValue.MapValue> r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 255
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.presentation.rule_logic.cel.SuperscriptEvaluator.overlayComputedProperties$superwall_release(com.superwall.sdk.paywall.presentation.rule_logic.cel.models.PassableValue$MapValue, com.superwall.sdk.models.events.EventData, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x008e, code lost:
    
        if (r15 == r1) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.superwall.sdk.paywall.presentation.rule_logic.expression_evaluator.ExpressionEvaluating
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object evaluateExpression(com.superwall.sdk.models.triggers.TriggerRule r12, com.superwall.sdk.models.events.EventData r13, com.superwall.sdk.paywall.presentation.rule_logic.cel.models.PassableValue.MapValue r14, kotlin.coroutines.Continuation<? super com.superwall.sdk.models.triggers.TriggerRuleOutcome> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.presentation.rule_logic.cel.SuperscriptEvaluator.evaluateExpression(com.superwall.sdk.models.triggers.TriggerRule, com.superwall.sdk.models.events.EventData, com.superwall.sdk.paywall.presentation.rule_logic.cel.models.PassableValue$MapValue, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public /* synthetic */ SuperscriptEvaluator(Json json, IOScope iOScope, CoreDataManager coreDataManager, RuleAttributesFactory ruleAttributesFactory, SuperscriptHostContext superscriptHostContext, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(json, iOScope, coreDataManager, ruleAttributesFactory, (i3 & 16) != 0 ? new SuperscriptHostContext(json, coreDataManager) : superscriptHostContext);
    }
}
