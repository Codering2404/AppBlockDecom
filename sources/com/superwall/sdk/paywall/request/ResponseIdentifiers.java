package com.superwall.sdk.paywall.request;

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
public final class ResponseIdentifiers {
    public static final Companion Companion = new Companion(null);
    private Experiment experiment;
    private final String paywallId;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ResponseIdentifiers getNone() {
            return new ResponseIdentifiers(null, null);
        }

        private Companion() {
        }
    }

    public ResponseIdentifiers(String str, Experiment experiment) {
        this.paywallId = str;
        this.experiment = experiment;
    }

    public static /* synthetic */ ResponseIdentifiers copy$default(ResponseIdentifiers responseIdentifiers, String str, Experiment experiment, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = responseIdentifiers.paywallId;
        }
        if ((i3 & 2) != 0) {
            experiment = responseIdentifiers.experiment;
        }
        return responseIdentifiers.copy(str, experiment);
    }

    public final String component1() {
        return this.paywallId;
    }

    public final Experiment component2() {
        return this.experiment;
    }

    public final ResponseIdentifiers copy(String str, Experiment experiment) {
        return new ResponseIdentifiers(str, experiment);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResponseIdentifiers)) {
            return false;
        }
        ResponseIdentifiers responseIdentifiers = (ResponseIdentifiers) obj;
        return Intrinsics.areEqual(this.paywallId, responseIdentifiers.paywallId) && Intrinsics.areEqual(this.experiment, responseIdentifiers.experiment);
    }

    public final Experiment getExperiment() {
        return this.experiment;
    }

    public final String getPaywallId() {
        return this.paywallId;
    }

    public int hashCode() {
        String str = this.paywallId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Experiment experiment = this.experiment;
        return iHashCode + (experiment != null ? experiment.hashCode() : 0);
    }

    public final void setExperiment(Experiment experiment) {
        this.experiment = experiment;
    }

    public String toString() {
        return "ResponseIdentifiers(paywallId=" + this.paywallId + ", experiment=" + this.experiment + ")";
    }

    public /* synthetic */ ResponseIdentifiers(String str, Experiment experiment, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? null : experiment);
    }
}
