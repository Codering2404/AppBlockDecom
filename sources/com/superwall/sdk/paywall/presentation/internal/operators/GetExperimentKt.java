package com.superwall.sdk.paywall.presentation.internal.operators;

import com.superwall.sdk.Superwall;
import com.superwall.sdk.paywall.presentation.internal.PresentationRequest;
import com.superwall.sdk.paywall.presentation.internal.PresentationRequestType;
import com.superwall.sdk.paywall.presentation.rule_logic.RuleEvaluationOutcome;
import com.superwall.sdk.storage.LocalStorage;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
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
public final class GetExperimentKt {

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.internal.operators.GetExperimentKt$getExperiment$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.internal.operators.GetExperimentKt", f = "GetExperiment.kt", l = {62, 68, 78, 80, 85, 101}, m = "getExperiment")
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GetExperimentKt.getExperiment(null, null, null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.internal.operators.GetExperimentKt$getExperiment$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.internal.operators.GetExperimentKt$getExperiment$2", f = "GetExperiment.kt", l = {51}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function3<PresentationRequest, RuleEvaluationOutcome, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(PresentationRequest presentationRequest, RuleEvaluationOutcome ruleEvaluationOutcome, Continuation<? super Unit> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
            anonymousClass2.L$0 = presentationRequest;
            anonymousClass2.L$1 = ruleEvaluationOutcome;
            return anonymousClass2.invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                PresentationRequest presentationRequest = (PresentationRequest) this.L$0;
                RuleEvaluationOutcome ruleEvaluationOutcome = (RuleEvaluationOutcome) this.L$1;
                Superwall companion = Superwall.Companion.getInstance();
                this.L$0 = null;
                this.label = 1;
                if (GetExperimentKt.activateSession(companion, presentationRequest, ruleEvaluationOutcome, this) == objF) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object activateSession(Superwall superwall, PresentationRequest presentationRequest, RuleEvaluationOutcome ruleEvaluationOutcome, Continuation<? super Unit> continuation) {
        if (Intrinsics.areEqual(presentationRequest.getFlags().getType(), PresentationRequestType.GetImplicitPresentationResult.INSTANCE) || Intrinsics.areEqual(presentationRequest.getFlags().getType(), PresentationRequestType.GetPresentationResult.INSTANCE)) {
            return Unit.f139807a;
        }
        Object objAttemptTriggerFire = GetPresenterKt.attemptTriggerFire(superwall, presentationRequest, ruleEvaluationOutcome.getTriggerResult(), continuation);
        return objAttemptTriggerFire == IntrinsicsKt.f() ? objAttemptTriggerFire : Unit.f139807a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00fa, code lost:
    
        if (r0.emit(r2, r5) == r6) goto L63;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object getExperiment(com.superwall.sdk.paywall.presentation.internal.PresentationRequest r17, com.superwall.sdk.paywall.presentation.rule_logic.RuleEvaluationOutcome r18, java.util.Map<java.lang.String, ? extends java.lang.Object> r19, kotlinx.coroutines.flow.MutableSharedFlow<com.superwall.sdk.paywall.presentation.internal.state.PaywallState> r20, com.superwall.sdk.storage.LocalStorage r21, kotlin.jvm.functions.Function3<? super com.superwall.sdk.paywall.presentation.internal.PresentationRequest, ? super com.superwall.sdk.paywall.presentation.rule_logic.RuleEvaluationOutcome, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r22, kotlin.coroutines.Continuation<? super com.superwall.sdk.models.triggers.Experiment> r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 408
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.presentation.internal.operators.GetExperimentKt.getExperiment(com.superwall.sdk.paywall.presentation.internal.PresentationRequest, com.superwall.sdk.paywall.presentation.rule_logic.RuleEvaluationOutcome, java.util.Map, kotlinx.coroutines.flow.MutableSharedFlow, com.superwall.sdk.storage.LocalStorage, kotlin.jvm.functions.Function3, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object getExperiment$default(PresentationRequest presentationRequest, RuleEvaluationOutcome ruleEvaluationOutcome, Map map, MutableSharedFlow mutableSharedFlow, LocalStorage localStorage, Function3 function3, Continuation continuation, int i3, Object obj) throws Throwable {
        if ((i3 & 8) != 0) {
            mutableSharedFlow = null;
        }
        if ((i3 & 32) != 0) {
            function3 = new AnonymousClass2(null);
        }
        return getExperiment(presentationRequest, ruleEvaluationOutcome, map, mutableSharedFlow, localStorage, function3, continuation);
    }
}
