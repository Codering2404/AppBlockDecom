package com.superwall.sdk.store.testmode.ui;

import com.facebook.internal.AnalyticsEvents;
import java.util.List;
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
public abstract class RestoreSimulationResult {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Cancelled extends RestoreSimulationResult {
        public static final Cancelled INSTANCE = new Cancelled();

        private Cancelled() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof Cancelled);
        }

        public int hashCode() {
            return -1662610499;
        }

        public String toString() {
            return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_CANCELLED;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Restored extends RestoreSimulationResult {
        private final List<EntitlementSelection> selectedEntitlements;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Restored(List<EntitlementSelection> selectedEntitlements) {
            super(null);
            Intrinsics.checkNotNullParameter(selectedEntitlements, "selectedEntitlements");
            this.selectedEntitlements = selectedEntitlements;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Restored copy$default(Restored restored, List list, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                list = restored.selectedEntitlements;
            }
            return restored.copy(list);
        }

        public final List<EntitlementSelection> component1() {
            return this.selectedEntitlements;
        }

        public final Restored copy(List<EntitlementSelection> selectedEntitlements) {
            Intrinsics.checkNotNullParameter(selectedEntitlements, "selectedEntitlements");
            return new Restored(selectedEntitlements);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Restored) && Intrinsics.areEqual(this.selectedEntitlements, ((Restored) obj).selectedEntitlements);
        }

        public final List<EntitlementSelection> getSelectedEntitlements() {
            return this.selectedEntitlements;
        }

        public int hashCode() {
            return this.selectedEntitlements.hashCode();
        }

        public String toString() {
            return "Restored(selectedEntitlements=" + this.selectedEntitlements + ")";
        }
    }

    public /* synthetic */ RestoreSimulationResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private RestoreSimulationResult() {
    }
}
