package com.superwall.sdk.models.triggers;

import com.superwall.sdk.models.triggers.TriggerResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public abstract class InternalTriggerResult {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Error extends InternalTriggerResult {
        private final Exception error;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(Exception error) {
            super(null);
            Intrinsics.checkNotNullParameter(error, "error");
            this.error = error;
        }

        public static /* synthetic */ Error copy$default(Error error, Exception exc, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                exc = error.error;
            }
            return error.copy(exc);
        }

        public final Exception component1() {
            return this.error;
        }

        public final Error copy(Exception error) {
            Intrinsics.checkNotNullParameter(error, "error");
            return new Error(error);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Error) && Intrinsics.areEqual(this.error, ((Error) obj).error);
        }

        public final Exception getError() {
            return this.error;
        }

        public int hashCode() {
            return this.error.hashCode();
        }

        public String toString() {
            return "Error(error=" + this.error + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Holdout extends InternalTriggerResult {
        private final Experiment experiment;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Holdout(Experiment experiment) {
            super(null);
            Intrinsics.checkNotNullParameter(experiment, "experiment");
            this.experiment = experiment;
        }

        public static /* synthetic */ Holdout copy$default(Holdout holdout, Experiment experiment, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                experiment = holdout.experiment;
            }
            return holdout.copy(experiment);
        }

        public final Experiment component1() {
            return this.experiment;
        }

        public final Holdout copy(Experiment experiment) {
            Intrinsics.checkNotNullParameter(experiment, "experiment");
            return new Holdout(experiment);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Holdout) && Intrinsics.areEqual(this.experiment, ((Holdout) obj).experiment);
        }

        public final Experiment getExperiment() {
            return this.experiment;
        }

        public int hashCode() {
            return this.experiment.hashCode();
        }

        public String toString() {
            return "Holdout(experiment=" + this.experiment + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NoAudienceMatch extends InternalTriggerResult {
        private final List<UnmatchedRule> unmatchedRules;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NoAudienceMatch(List<UnmatchedRule> unmatchedRules) {
            super(null);
            Intrinsics.checkNotNullParameter(unmatchedRules, "unmatchedRules");
            this.unmatchedRules = unmatchedRules;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ NoAudienceMatch copy$default(NoAudienceMatch noAudienceMatch, List list, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                list = noAudienceMatch.unmatchedRules;
            }
            return noAudienceMatch.copy(list);
        }

        public final List<UnmatchedRule> component1() {
            return this.unmatchedRules;
        }

        public final NoAudienceMatch copy(List<UnmatchedRule> unmatchedRules) {
            Intrinsics.checkNotNullParameter(unmatchedRules, "unmatchedRules");
            return new NoAudienceMatch(unmatchedRules);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof NoAudienceMatch) && Intrinsics.areEqual(this.unmatchedRules, ((NoAudienceMatch) obj).unmatchedRules);
        }

        public final List<UnmatchedRule> getUnmatchedRules() {
            return this.unmatchedRules;
        }

        public int hashCode() {
            return this.unmatchedRules.hashCode();
        }

        public String toString() {
            return "NoAudienceMatch(unmatchedRules=" + this.unmatchedRules + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Paywall extends InternalTriggerResult {
        private final Experiment experiment;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Paywall(Experiment experiment) {
            super(null);
            Intrinsics.checkNotNullParameter(experiment, "experiment");
            this.experiment = experiment;
        }

        public static /* synthetic */ Paywall copy$default(Paywall paywall, Experiment experiment, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                experiment = paywall.experiment;
            }
            return paywall.copy(experiment);
        }

        public final Experiment component1() {
            return this.experiment;
        }

        public final Paywall copy(Experiment experiment) {
            Intrinsics.checkNotNullParameter(experiment, "experiment");
            return new Paywall(experiment);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Paywall) && Intrinsics.areEqual(this.experiment, ((Paywall) obj).experiment);
        }

        public final Experiment getExperiment() {
            return this.experiment;
        }

        public int hashCode() {
            return this.experiment.hashCode();
        }

        public String toString() {
            return "Paywall(experiment=" + this.experiment + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PlacementNotFound extends InternalTriggerResult {
        public static final PlacementNotFound INSTANCE = new PlacementNotFound();

        private PlacementNotFound() {
            super(null);
        }
    }

    public /* synthetic */ InternalTriggerResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final TriggerResult toPublicType() {
        if (this instanceof PlacementNotFound) {
            return TriggerResult.PlacementNotFound.INSTANCE;
        }
        if (this instanceof NoAudienceMatch) {
            return TriggerResult.NoAudienceMatch.INSTANCE;
        }
        if (this instanceof Paywall) {
            return new TriggerResult.Paywall(((Paywall) this).getExperiment());
        }
        if (this instanceof Holdout) {
            return new TriggerResult.Holdout(((Holdout) this).getExperiment());
        }
        if (this instanceof Error) {
            return new TriggerResult.Error(((Error) this).getError());
        }
        throw new NoWhenBranchMatchedException();
    }

    private InternalTriggerResult() {
    }
}
