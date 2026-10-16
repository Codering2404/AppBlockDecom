package com.superwall.sdk.storage.core_data.entities;

import java.util.Date;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ManagedTriggerRuleOccurrence {
    private Date createdAt;
    private Integer id;
    private String occurrenceKey;

    public ManagedTriggerRuleOccurrence(Integer num, Date createdAt, String occurrenceKey) {
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        Intrinsics.checkNotNullParameter(occurrenceKey, "occurrenceKey");
        this.id = num;
        this.createdAt = createdAt;
        this.occurrenceKey = occurrenceKey;
    }

    public static /* synthetic */ ManagedTriggerRuleOccurrence copy$default(ManagedTriggerRuleOccurrence managedTriggerRuleOccurrence, Integer num, Date date, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            num = managedTriggerRuleOccurrence.id;
        }
        if ((i3 & 2) != 0) {
            date = managedTriggerRuleOccurrence.createdAt;
        }
        if ((i3 & 4) != 0) {
            str = managedTriggerRuleOccurrence.occurrenceKey;
        }
        return managedTriggerRuleOccurrence.copy(num, date, str);
    }

    public final Integer component1() {
        return this.id;
    }

    public final Date component2() {
        return this.createdAt;
    }

    public final String component3() {
        return this.occurrenceKey;
    }

    public final ManagedTriggerRuleOccurrence copy(Integer num, Date createdAt, String occurrenceKey) {
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        Intrinsics.checkNotNullParameter(occurrenceKey, "occurrenceKey");
        return new ManagedTriggerRuleOccurrence(num, createdAt, occurrenceKey);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ManagedTriggerRuleOccurrence)) {
            return false;
        }
        ManagedTriggerRuleOccurrence managedTriggerRuleOccurrence = (ManagedTriggerRuleOccurrence) obj;
        return Intrinsics.areEqual(this.id, managedTriggerRuleOccurrence.id) && Intrinsics.areEqual(this.createdAt, managedTriggerRuleOccurrence.createdAt) && Intrinsics.areEqual(this.occurrenceKey, managedTriggerRuleOccurrence.occurrenceKey);
    }

    public final Date getCreatedAt() {
        return this.createdAt;
    }

    public final Integer getId() {
        return this.id;
    }

    public final String getOccurrenceKey() {
        return this.occurrenceKey;
    }

    public int hashCode() {
        Integer num = this.id;
        return ((((num == null ? 0 : num.hashCode()) * 31) + this.createdAt.hashCode()) * 31) + this.occurrenceKey.hashCode();
    }

    public final void setCreatedAt(Date date) {
        Intrinsics.checkNotNullParameter(date, "<set-?>");
        this.createdAt = date;
    }

    public final void setId(Integer num) {
        this.id = num;
    }

    public final void setOccurrenceKey(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.occurrenceKey = str;
    }

    public String toString() {
        return "ManagedTriggerRuleOccurrence(id=" + this.id + ", createdAt=" + this.createdAt + ", occurrenceKey=" + this.occurrenceKey + ")";
    }

    public /* synthetic */ ManagedTriggerRuleOccurrence(Integer num, Date date, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : num, (i3 & 2) != 0 ? new Date() : date, str);
    }
}
