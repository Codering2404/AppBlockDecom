package com.superwall.sdk.paywall.presentation.internal;

import android.app.Activity;
import com.superwall.sdk.models.assignment.ConfirmableAssignment;
import com.superwall.sdk.paywall.presentation.internal.state.PaywallState;
import com.superwall.sdk.paywall.presentation.rule_logic.RuleEvaluationOutcome;
import com.superwall.sdk.paywall.view.PaywallView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.MutableSharedFlow;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public interface GetPaywallComponentsFactory {
    Object checkDebuggerPresentation(PresentationRequest presentationRequest, MutableSharedFlow<PaywallState> mutableSharedFlow, Continuation<? super Unit> continuation);

    Object confirmHoldoutAssignment(PresentationRequest presentationRequest, RuleEvaluationOutcome ruleEvaluationOutcome, Continuation<? super Unit> continuation);

    Object confirmPaywallAssignment(ConfirmableAssignment confirmableAssignment, PresentationRequest presentationRequest, boolean z2, Continuation<? super Unit> continuation);

    /* JADX INFO: renamed from: evaluateRules-gIAlu-s */
    Object mo1326evaluateRulesgIAlus(PresentationRequest presentationRequest, Continuation<? super Result<RuleEvaluationOutcome>> continuation);

    /* JADX INFO: renamed from: getPaywallView-yxL6bBk */
    Object mo1327getPaywallViewyxL6bBk(PresentationRequest presentationRequest, RuleEvaluationOutcome ruleEvaluationOutcome, Map<String, ? extends Object> map, MutableSharedFlow<PaywallState> mutableSharedFlow, Continuation<? super Result<PaywallView>> continuation);

    Object getPresenterIfNecessary(PaywallView paywallView, RuleEvaluationOutcome ruleEvaluationOutcome, PresentationRequest presentationRequest, MutableSharedFlow<PaywallState> mutableSharedFlow, Continuation<? super Activity> continuation);

    Object waitForEntitlementsAndConfig(PresentationRequest presentationRequest, MutableSharedFlow<PaywallState> mutableSharedFlow, Continuation<? super Unit> continuation);
}
