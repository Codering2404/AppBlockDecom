package com.superwall.sdk.store.testmode.ui;

import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public abstract class PurchaseSimulationResult {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Abandoned extends PurchaseSimulationResult {
        public static final Abandoned INSTANCE = new Abandoned();

        private Abandoned() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof Abandoned);
        }

        public int hashCode() {
            return -1620608413;
        }

        public String toString() {
            return "Abandoned";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Failed extends PurchaseSimulationResult {
        public static final Failed INSTANCE = new Failed();

        private Failed() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof Failed);
        }

        public int hashCode() {
            return 512200206;
        }

        public String toString() {
            return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Purchased extends PurchaseSimulationResult {
        public static final Purchased INSTANCE = new Purchased();

        private Purchased() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof Purchased);
        }

        public int hashCode() {
            return 1977025554;
        }

        public String toString() {
            return "Purchased";
        }
    }

    public /* synthetic */ PurchaseSimulationResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private PurchaseSimulationResult() {
    }
}
