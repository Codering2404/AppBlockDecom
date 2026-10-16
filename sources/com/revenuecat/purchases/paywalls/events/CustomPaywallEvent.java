package com.revenuecat.purchases.paywalls.events;

import com.revenuecat.purchases.common.events.FeatureEvent;
import java.util.Date;
import java.util.UUID;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public abstract class CustomPaywallEvent implements FeatureEvent {
    public /* synthetic */ CustomPaywallEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.revenuecat.purchases.common.events.FeatureEvent
    public boolean isPriorityEvent() {
        return true;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Impression extends CustomPaywallEvent {
        private final CreationData creationData;
        private final Data data;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class CreationData {
            private final Date date;
            private final UUID id;

            /* JADX WARN: Multi-variable type inference failed */
            public CreationData() {
                this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof CreationData)) {
                    return false;
                }
                CreationData creationData = (CreationData) obj;
                return Intrinsics.areEqual(this.id, creationData.id) && Intrinsics.areEqual(this.date, creationData.date);
            }

            public final Date getDate() {
                return this.date;
            }

            public final UUID getId() {
                return this.id;
            }

            public int hashCode() {
                return (this.id.hashCode() * 31) + this.date.hashCode();
            }

            public String toString() {
                return "CreationData(id=" + this.id + ", date=" + this.date + ')';
            }

            public CreationData(UUID id, Date date) {
                Intrinsics.checkNotNullParameter(id, "id");
                Intrinsics.checkNotNullParameter(date, "date");
                this.id = id;
                this.date = date;
            }

            /* JADX WARN: Illegal instructions before constructor call */
            public /* synthetic */ CreationData(UUID uuid, Date date, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                if ((i3 & 1) != 0) {
                    uuid = UUID.randomUUID();
                    Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID()");
                }
                this(uuid, (i3 & 2) != 0 ? new Date() : date);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public /* synthetic */ Impression(CreationData creationData, Data data, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            if ((i3 & 1) != 0) {
                creationData = new CreationData(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
            }
            this(creationData, data);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Impression)) {
                return false;
            }
            Impression impression = (Impression) obj;
            return Intrinsics.areEqual(this.creationData, impression.creationData) && Intrinsics.areEqual(this.data, impression.data);
        }

        public final CreationData getCreationData() {
            return this.creationData;
        }

        public final Data getData() {
            return this.data;
        }

        public int hashCode() {
            return (this.creationData.hashCode() * 31) + this.data.hashCode();
        }

        public String toString() {
            return "Impression(creationData=" + this.creationData + ", data=" + this.data + ')';
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Data {
            private final String offeringId;
            private final String paywallId;

            public Data(String str, String str2) {
                this.paywallId = str;
                this.offeringId = str2;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Data)) {
                    return false;
                }
                Data data = (Data) obj;
                return Intrinsics.areEqual(this.paywallId, data.paywallId) && Intrinsics.areEqual(this.offeringId, data.offeringId);
            }

            public final String getOfferingId() {
                return this.offeringId;
            }

            public final String getPaywallId() {
                return this.paywallId;
            }

            public int hashCode() {
                String str = this.paywallId;
                int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.offeringId;
                return iHashCode + (str2 != null ? str2.hashCode() : 0);
            }

            public String toString() {
                return "Data(paywallId=" + this.paywallId + ", offeringId=" + this.offeringId + ')';
            }

            public /* synthetic */ Data(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, (i3 & 2) != 0 ? null : str2);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Impression(CreationData creationData, Data data) {
            super(null);
            Intrinsics.checkNotNullParameter(creationData, "creationData");
            Intrinsics.checkNotNullParameter(data, "data");
            this.creationData = creationData;
            this.data = data;
        }
    }

    private CustomPaywallEvent() {
    }
}
