package com.superwall.sdk.paywall.presentation.get_presentation_result;

import com.superwall.sdk.models.triggers.InternalTriggerResult;
import com.superwall.sdk.paywall.presentation.result.PresentationResult;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
public final class GetPresentationResultLogic {
    public static final GetPresentationResultLogic INSTANCE = new GetPresentationResultLogic();

    private GetPresentationResultLogic() {
    }

    public final PresentationResult convertTriggerResult(InternalTriggerResult triggerResult) {
        Intrinsics.checkNotNullParameter(triggerResult, "triggerResult");
        if (triggerResult instanceof InternalTriggerResult.PlacementNotFound) {
            return new PresentationResult.PlacementNotFound();
        }
        if (triggerResult instanceof InternalTriggerResult.Holdout) {
            return new PresentationResult.Holdout(((InternalTriggerResult.Holdout) triggerResult).getExperiment());
        }
        if (triggerResult instanceof InternalTriggerResult.Error) {
            return new PresentationResult.PaywallNotAvailable();
        }
        if (triggerResult instanceof InternalTriggerResult.NoAudienceMatch) {
            return new PresentationResult.NoAudienceMatch();
        }
        if (triggerResult instanceof InternalTriggerResult.Paywall) {
            return new PresentationResult.Paywall(((InternalTriggerResult.Paywall) triggerResult).getExperiment());
        }
        throw new NoWhenBranchMatchedException();
    }
}
