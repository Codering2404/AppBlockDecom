package com.revenuecat.purchases.ui.revenuecatui.workflow;

import com.revenuecat.purchases.common.workflows.PublishedWorkflow;
import com.revenuecat.purchases.common.workflows.WorkflowStep;
import com.revenuecat.purchases.common.workflows.WorkflowTrigger;
import com.revenuecat.purchases.common.workflows.WorkflowTriggerAction;
import com.revenuecat.purchases.common.workflows.WorkflowTriggerType;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Logger;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

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
public final class WorkflowNavigator {
    public static final int $stable = 8;
    private final MutableStateFlow<String> _currentStepId;
    private final ArrayDeque<String> backStack;
    private final StateFlow<String> currentStepId;
    private final PublishedWorkflow workflow;

    public WorkflowNavigator(PublishedWorkflow workflow) {
        Intrinsics.checkNotNullParameter(workflow, "workflow");
        this.workflow = workflow;
        MutableStateFlow<String> mutableStateFlowA = StateFlowKt.a(workflow.getInitialStepId());
        this._currentStepId = mutableStateFlowA;
        this.currentStepId = FlowKt.c(mutableStateFlowA);
        this.backStack = new ArrayDeque<>();
    }

    public final WorkflowStep currentStep() {
        return this.workflow.getSteps().get(this._currentStepId.getValue());
    }

    public final boolean getCanNavigateBack() {
        return !this.backStack.isEmpty();
    }

    public final StateFlow<String> getCurrentStepId() {
        return this.currentStepId;
    }

    public final WorkflowStep getPeekBackStep() {
        String strLastOrNull = this.backStack.lastOrNull();
        if (strLastOrNull != null) {
            return this.workflow.getSteps().get(strLastOrNull);
        }
        return null;
    }

    public final WorkflowStep navigateBack() {
        if (this.backStack.isEmpty()) {
            return null;
        }
        String strRemoveLast = this.backStack.removeLast();
        this._currentStepId.setValue(strRemoveLast);
        return this.workflow.getSteps().get(strRemoveLast);
    }

    public final WorkflowStep peekTriggerStep(String componentId, WorkflowTriggerType triggerType) {
        Object next;
        WorkflowTriggerAction workflowTriggerAction;
        Intrinsics.checkNotNullParameter(componentId, "componentId");
        Intrinsics.checkNotNullParameter(triggerType, "triggerType");
        WorkflowStep workflowStepCurrentStep = currentStep();
        if (workflowStepCurrentStep == null) {
            return null;
        }
        Iterator<T> it = workflowStepCurrentStep.getTriggers().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            WorkflowTrigger workflowTrigger = (WorkflowTrigger) next;
            if (Intrinsics.areEqual(workflowTrigger.getComponentId(), componentId) && workflowTrigger.getType() == triggerType) {
                break;
            }
        }
        WorkflowTrigger workflowTrigger2 = (WorkflowTrigger) next;
        if (workflowTrigger2 == null || (workflowTriggerAction = workflowStepCurrentStep.getTriggerActions().get(workflowTrigger2.getActionId())) == null || !(workflowTriggerAction instanceof WorkflowTriggerAction.Step)) {
            return null;
        }
        return this.workflow.getSteps().get(((WorkflowTriggerAction.Step) workflowTriggerAction).getStepId());
    }

    public final WorkflowStep triggerAction(String componentId, WorkflowTriggerType triggerType) {
        Object next;
        Intrinsics.checkNotNullParameter(componentId, "componentId");
        Intrinsics.checkNotNullParameter(triggerType, "triggerType");
        WorkflowStep workflowStepCurrentStep = currentStep();
        if (workflowStepCurrentStep == null) {
            return null;
        }
        Iterator<T> it = workflowStepCurrentStep.getTriggers().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            WorkflowTrigger workflowTrigger = (WorkflowTrigger) next;
            if (Intrinsics.areEqual(workflowTrigger.getComponentId(), componentId) && workflowTrigger.getType() == triggerType) {
                break;
            }
        }
        WorkflowTrigger workflowTrigger2 = (WorkflowTrigger) next;
        if (workflowTrigger2 == null) {
            Logger.INSTANCE.w("No trigger found for componentId '" + componentId + "' and type '" + triggerType + "' in step '" + workflowStepCurrentStep.getId() + '\'');
            return null;
        }
        WorkflowTriggerAction workflowTriggerAction = workflowStepCurrentStep.getTriggerActions().get(workflowTrigger2.getActionId());
        if (workflowTriggerAction == null) {
            Logger.INSTANCE.w("No trigger action found for actionId '" + workflowTrigger2.getActionId() + "' in step '" + workflowStepCurrentStep.getId() + '\'');
            return null;
        }
        if (!(workflowTriggerAction instanceof WorkflowTriggerAction.Step)) {
            Logger.INSTANCE.w("Unknown workflow trigger action type for actionId '" + workflowTrigger2.getActionId() + "' — ignoring");
            return null;
        }
        String stepId = ((WorkflowTriggerAction.Step) workflowTriggerAction).getStepId();
        WorkflowStep workflowStep = this.workflow.getSteps().get(stepId);
        if (workflowStep != null) {
            this.backStack.addLast((String) this._currentStepId.getValue());
            this._currentStepId.setValue(stepId);
            return workflowStep;
        }
        Logger.INSTANCE.w("Step '" + stepId + "' not found in workflow '" + this.workflow.getId() + '\'');
        return null;
    }
}
