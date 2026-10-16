package com.superwall.sdk.paywall.presentation.internal.state;

import com.superwall.sdk.models.triggers.Experiment;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public abstract class PaywallSkippedReason extends Throwable {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Holdout extends PaywallSkippedReason {
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

        @Override // com.superwall.sdk.paywall.presentation.internal.state.PaywallSkippedReason
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

        @Override // java.lang.Throwable
        public String toString() {
            return "Holdout(experiment=" + this.experiment + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NoAudienceMatch extends PaywallSkippedReason {
        public NoAudienceMatch() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PlacementNotFound extends PaywallSkippedReason {
        public PlacementNotFound() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class UserIsSubscribed extends PaywallSkippedReason {
        public UserIsSubscribed() {
            super(null);
        }
    }

    public /* synthetic */ PaywallSkippedReason(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public boolean equals(Object obj) {
        if ((this instanceof Holdout) && (obj instanceof Holdout)) {
            return Intrinsics.areEqual(((Holdout) this).getExperiment(), ((Holdout) obj).getExperiment());
        }
        if ((this instanceof NoAudienceMatch) && (obj instanceof NoAudienceMatch)) {
            return true;
        }
        if ((this instanceof PlacementNotFound) && (obj instanceof PlacementNotFound)) {
            return true;
        }
        return (this instanceof UserIsSubscribed) && (obj instanceof UserIsSubscribed);
    }

    private PaywallSkippedReason() {
    }
}
