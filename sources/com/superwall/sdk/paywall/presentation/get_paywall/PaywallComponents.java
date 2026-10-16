package com.superwall.sdk.paywall.presentation.get_paywall;

import android.app.Activity;
import com.superwall.sdk.models.triggers.Experiment;
import com.superwall.sdk.paywall.presentation.rule_logic.RuleEvaluationOutcome;
import com.superwall.sdk.paywall.view.PaywallView;
import java.util.Map;
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
public final class PaywallComponents {
    private final Map<String, Object> debugInfo;
    private final Experiment experiment;
    private final Activity presenter;
    private final RuleEvaluationOutcome rulesOutcome;
    private final PaywallView view;

    public PaywallComponents(PaywallView view, Activity activity, RuleEvaluationOutcome rulesOutcome, Map<String, ? extends Object> debugInfo, Experiment experiment) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(rulesOutcome, "rulesOutcome");
        Intrinsics.checkNotNullParameter(debugInfo, "debugInfo");
        this.view = view;
        this.presenter = activity;
        this.rulesOutcome = rulesOutcome;
        this.debugInfo = debugInfo;
        this.experiment = experiment;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PaywallComponents copy$default(PaywallComponents paywallComponents, PaywallView paywallView, Activity activity, RuleEvaluationOutcome ruleEvaluationOutcome, Map map, Experiment experiment, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            paywallView = paywallComponents.view;
        }
        if ((i3 & 2) != 0) {
            activity = paywallComponents.presenter;
        }
        if ((i3 & 4) != 0) {
            ruleEvaluationOutcome = paywallComponents.rulesOutcome;
        }
        if ((i3 & 8) != 0) {
            map = paywallComponents.debugInfo;
        }
        if ((i3 & 16) != 0) {
            experiment = paywallComponents.experiment;
        }
        Experiment experiment2 = experiment;
        RuleEvaluationOutcome ruleEvaluationOutcome2 = ruleEvaluationOutcome;
        return paywallComponents.copy(paywallView, activity, ruleEvaluationOutcome2, map, experiment2);
    }

    public final PaywallView component1() {
        return this.view;
    }

    public final Activity component2() {
        return this.presenter;
    }

    public final RuleEvaluationOutcome component3() {
        return this.rulesOutcome;
    }

    public final Map<String, Object> component4() {
        return this.debugInfo;
    }

    public final Experiment component5() {
        return this.experiment;
    }

    public final PaywallComponents copy(PaywallView view, Activity activity, RuleEvaluationOutcome rulesOutcome, Map<String, ? extends Object> debugInfo, Experiment experiment) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(rulesOutcome, "rulesOutcome");
        Intrinsics.checkNotNullParameter(debugInfo, "debugInfo");
        return new PaywallComponents(view, activity, rulesOutcome, debugInfo, experiment);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaywallComponents)) {
            return false;
        }
        PaywallComponents paywallComponents = (PaywallComponents) obj;
        return Intrinsics.areEqual(this.view, paywallComponents.view) && Intrinsics.areEqual(this.presenter, paywallComponents.presenter) && Intrinsics.areEqual(this.rulesOutcome, paywallComponents.rulesOutcome) && Intrinsics.areEqual(this.debugInfo, paywallComponents.debugInfo) && Intrinsics.areEqual(this.experiment, paywallComponents.experiment);
    }

    public final Map<String, Object> getDebugInfo() {
        return this.debugInfo;
    }

    public final Experiment getExperiment() {
        return this.experiment;
    }

    public final Activity getPresenter() {
        return this.presenter;
    }

    public final RuleEvaluationOutcome getRulesOutcome() {
        return this.rulesOutcome;
    }

    public final PaywallView getView() {
        return this.view;
    }

    public int hashCode() {
        int iHashCode = this.view.hashCode() * 31;
        Activity activity = this.presenter;
        int iHashCode2 = (((((iHashCode + (activity == null ? 0 : activity.hashCode())) * 31) + this.rulesOutcome.hashCode()) * 31) + this.debugInfo.hashCode()) * 31;
        Experiment experiment = this.experiment;
        return iHashCode2 + (experiment != null ? experiment.hashCode() : 0);
    }

    public String toString() {
        return "PaywallComponents(view=" + this.view + ", presenter=" + this.presenter + ", rulesOutcome=" + this.rulesOutcome + ", debugInfo=" + this.debugInfo + ", experiment=" + this.experiment + ")";
    }
}
