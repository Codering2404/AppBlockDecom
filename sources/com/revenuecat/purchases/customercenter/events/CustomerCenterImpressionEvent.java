package com.revenuecat.purchases.customercenter.events;

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
public final class CustomerCenterImpressionEvent implements FeatureEvent {
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

    public CustomerCenterImpressionEvent(CreationData creationData, Data data) {
        Intrinsics.checkNotNullParameter(creationData, "creationData");
        Intrinsics.checkNotNullParameter(data, "data");
        this.creationData = creationData;
        this.data = data;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CustomerCenterImpressionEvent)) {
            return false;
        }
        CustomerCenterImpressionEvent customerCenterImpressionEvent = (CustomerCenterImpressionEvent) obj;
        return Intrinsics.areEqual(this.creationData, customerCenterImpressionEvent.creationData) && Intrinsics.areEqual(this.data, customerCenterImpressionEvent.data);
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
        return "CustomerCenterImpressionEvent(creationData=" + this.creationData + ", data=" + this.data + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ CustomerCenterImpressionEvent(CreationData creationData, Data data, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i3 & 1) != 0) {
            creationData = new CreationData(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }
        this(creationData, data);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Data {
        private final boolean darkMode;
        private final CustomerCenterDisplayMode displayMode;
        private final String locale;
        private final int revisionID;
        private final Date timestamp;
        private final CustomerCenterEventType type;
        private final int version;

        public Data(Date timestamp, boolean z2, String locale, int i3, int i4, CustomerCenterDisplayMode displayMode) {
            Intrinsics.checkNotNullParameter(timestamp, "timestamp");
            Intrinsics.checkNotNullParameter(locale, "locale");
            Intrinsics.checkNotNullParameter(displayMode, "displayMode");
            this.timestamp = timestamp;
            this.darkMode = z2;
            this.locale = locale;
            this.version = i3;
            this.revisionID = i4;
            this.displayMode = displayMode;
            this.type = CustomerCenterEventType.IMPRESSION;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Data)) {
                return false;
            }
            Data data = (Data) obj;
            return Intrinsics.areEqual(this.timestamp, data.timestamp) && this.darkMode == data.darkMode && Intrinsics.areEqual(this.locale, data.locale) && this.version == data.version && this.revisionID == data.revisionID && this.displayMode == data.displayMode;
        }

        public final boolean getDarkMode() {
            return this.darkMode;
        }

        public final CustomerCenterDisplayMode getDisplayMode() {
            return this.displayMode;
        }

        public final String getLocale() {
            return this.locale;
        }

        public final int getRevisionID() {
            return this.revisionID;
        }

        public final Date getTimestamp() {
            return this.timestamp;
        }

        public final CustomerCenterEventType getType() {
            return this.type;
        }

        public final int getVersion() {
            return this.version;
        }

        public int hashCode() {
            return (((((((((this.timestamp.hashCode() * 31) + Boolean.hashCode(this.darkMode)) * 31) + this.locale.hashCode()) * 31) + this.version) * 31) + this.revisionID) * 31) + this.displayMode.hashCode();
        }

        public String toString() {
            return "Data(timestamp=" + this.timestamp + ", darkMode=" + this.darkMode + ", locale=" + this.locale + ", version=" + this.version + ", revisionID=" + this.revisionID + ", displayMode=" + this.displayMode + ')';
        }

        public /* synthetic */ Data(Date date, boolean z2, String str, int i3, int i4, CustomerCenterDisplayMode customerCenterDisplayMode, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this(date, z2, str, (i5 & 8) != 0 ? 1 : i3, (i5 & 16) != 0 ? 1 : i4, (i5 & 32) != 0 ? CustomerCenterDisplayMode.FULL_SCREEN : customerCenterDisplayMode);
        }
    }
}
