package com.superwall.sdk.paywall.presentation.internal.operators;

import com.superwall.sdk.Superwall;
import com.superwall.sdk.config.Assignments;
import com.superwall.sdk.dependencies.DependencyContainer;
import com.superwall.sdk.models.assignment.ConfirmableAssignment;
import com.superwall.sdk.models.triggers.InternalTriggerResult;
import com.superwall.sdk.paywall.presentation.internal.PresentationRequest;
import com.superwall.sdk.paywall.presentation.internal.PresentationRequestType;
import com.superwall.sdk.paywall.presentation.rule_logic.RuleEvaluationOutcome;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
public final class ConfirmHoldoutAssignmentKt {
    public static final void confirmHoldoutAssignment(Superwall superwall, PresentationRequest request, RuleEvaluationOutcome rulesOutcome, DependencyContainer dependencyContainer) {
        Intrinsics.checkNotNullParameter(superwall, "<this>");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(rulesOutcome, "rulesOutcome");
        if (dependencyContainer == null) {
            dependencyContainer = superwall.getDependencyContainer$superwall_release();
        }
        confirmHoldoutAssignment(request, dependencyContainer.getAssignments$superwall_release(), rulesOutcome);
    }

    public static /* synthetic */ void confirmHoldoutAssignment$default(Superwall superwall, PresentationRequest presentationRequest, RuleEvaluationOutcome ruleEvaluationOutcome, DependencyContainer dependencyContainer, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            dependencyContainer = null;
        }
        confirmHoldoutAssignment(superwall, presentationRequest, ruleEvaluationOutcome, dependencyContainer);
    }

    public static final void confirmHoldoutAssignment(PresentationRequest request, Assignments assignments, RuleEvaluationOutcome rulesOutcome) {
        ConfirmableAssignment confirmableAssignment;
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(assignments, "assignments");
        Intrinsics.checkNotNullParameter(rulesOutcome, "rulesOutcome");
        if (Intrinsics.areEqual(request.getFlags().getType(), PresentationRequestType.GetImplicitPresentationResult.INSTANCE) || !(rulesOutcome.getTriggerResult() instanceof InternalTriggerResult.Holdout) || (confirmableAssignment = rulesOutcome.getConfirmableAssignment()) == null) {
            return;
        }
        assignments.confirmAssignment(confirmableAssignment);
    }
}
