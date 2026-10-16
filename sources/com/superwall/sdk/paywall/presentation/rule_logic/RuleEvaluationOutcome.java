package com.superwall.sdk.paywall.presentation.rule_logic;

import com.superwall.sdk.models.assignment.ConfirmableAssignment;
import com.superwall.sdk.models.triggers.InternalTriggerResult;
import com.superwall.sdk.models.triggers.TriggerRuleOccurrence;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class RuleEvaluationOutcome {
    private final ConfirmableAssignment confirmableAssignment;
    private final InternalTriggerResult triggerResult;
    private final TriggerRuleOccurrence unsavedOccurrence;

    public RuleEvaluationOutcome(ConfirmableAssignment confirmableAssignment, TriggerRuleOccurrence triggerRuleOccurrence, InternalTriggerResult triggerResult) {
        Intrinsics.checkNotNullParameter(triggerResult, "triggerResult");
        this.confirmableAssignment = confirmableAssignment;
        this.unsavedOccurrence = triggerRuleOccurrence;
        this.triggerResult = triggerResult;
    }

    public static /* synthetic */ RuleEvaluationOutcome copy$default(RuleEvaluationOutcome ruleEvaluationOutcome, ConfirmableAssignment confirmableAssignment, TriggerRuleOccurrence triggerRuleOccurrence, InternalTriggerResult internalTriggerResult, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            confirmableAssignment = ruleEvaluationOutcome.confirmableAssignment;
        }
        if ((i3 & 2) != 0) {
            triggerRuleOccurrence = ruleEvaluationOutcome.unsavedOccurrence;
        }
        if ((i3 & 4) != 0) {
            internalTriggerResult = ruleEvaluationOutcome.triggerResult;
        }
        return ruleEvaluationOutcome.copy(confirmableAssignment, triggerRuleOccurrence, internalTriggerResult);
    }

    public final ConfirmableAssignment component1() {
        return this.confirmableAssignment;
    }

    public final TriggerRuleOccurrence component2() {
        return this.unsavedOccurrence;
    }

    public final InternalTriggerResult component3() {
        return this.triggerResult;
    }

    public final RuleEvaluationOutcome copy(ConfirmableAssignment confirmableAssignment, TriggerRuleOccurrence triggerRuleOccurrence, InternalTriggerResult triggerResult) {
        Intrinsics.checkNotNullParameter(triggerResult, "triggerResult");
        return new RuleEvaluationOutcome(confirmableAssignment, triggerRuleOccurrence, triggerResult);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RuleEvaluationOutcome)) {
            return false;
        }
        RuleEvaluationOutcome ruleEvaluationOutcome = (RuleEvaluationOutcome) obj;
        return Intrinsics.areEqual(this.confirmableAssignment, ruleEvaluationOutcome.confirmableAssignment) && Intrinsics.areEqual(this.unsavedOccurrence, ruleEvaluationOutcome.unsavedOccurrence) && Intrinsics.areEqual(this.triggerResult, ruleEvaluationOutcome.triggerResult);
    }

    public final ConfirmableAssignment getConfirmableAssignment() {
        return this.confirmableAssignment;
    }

    public final InternalTriggerResult getTriggerResult() {
        return this.triggerResult;
    }

    public final TriggerRuleOccurrence getUnsavedOccurrence() {
        return this.unsavedOccurrence;
    }

    public int hashCode() {
        ConfirmableAssignment confirmableAssignment = this.confirmableAssignment;
        int iHashCode = (confirmableAssignment == null ? 0 : confirmableAssignment.hashCode()) * 31;
        TriggerRuleOccurrence triggerRuleOccurrence = this.unsavedOccurrence;
        return ((iHashCode + (triggerRuleOccurrence != null ? triggerRuleOccurrence.hashCode() : 0)) * 31) + this.triggerResult.hashCode();
    }

    public String toString() {
        return "RuleEvaluationOutcome(confirmableAssignment=" + this.confirmableAssignment + ", unsavedOccurrence=" + this.unsavedOccurrence + ", triggerResult=" + this.triggerResult + ")";
    }

    public /* synthetic */ RuleEvaluationOutcome(ConfirmableAssignment confirmableAssignment, TriggerRuleOccurrence triggerRuleOccurrence, InternalTriggerResult internalTriggerResult, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : confirmableAssignment, (i3 & 2) != 0 ? null : triggerRuleOccurrence, internalTriggerResult);
    }
}
