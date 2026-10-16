package com.superwall.sdk.storage.core_data.entities;

import java.util.Date;
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
public final class ManagedEventData {
    private final Date createdAt;
    private final String id;
    private final String name;
    private final Map<String, Object> parameters;

    public ManagedEventData(String id, Date createdAt, String name, Map<String, ? extends Object> parameters) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        this.id = id;
        this.createdAt = createdAt;
        this.name = name;
        this.parameters = parameters;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ManagedEventData copy$default(ManagedEventData managedEventData, String str, Date date, String str2, Map map, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = managedEventData.id;
        }
        if ((i3 & 2) != 0) {
            date = managedEventData.createdAt;
        }
        if ((i3 & 4) != 0) {
            str2 = managedEventData.name;
        }
        if ((i3 & 8) != 0) {
            map = managedEventData.parameters;
        }
        return managedEventData.copy(str, date, str2, map);
    }

    public final String component1() {
        return this.id;
    }

    public final Date component2() {
        return this.createdAt;
    }

    public final String component3() {
        return this.name;
    }

    public final Map<String, Object> component4() {
        return this.parameters;
    }

    public final ManagedEventData copy(String id, Date createdAt, String name, Map<String, ? extends Object> parameters) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        return new ManagedEventData(id, createdAt, name, parameters);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ManagedEventData)) {
            return false;
        }
        ManagedEventData managedEventData = (ManagedEventData) obj;
        return Intrinsics.areEqual(this.id, managedEventData.id) && Intrinsics.areEqual(this.createdAt, managedEventData.createdAt) && Intrinsics.areEqual(this.name, managedEventData.name) && Intrinsics.areEqual(this.parameters, managedEventData.parameters);
    }

    public final Date getCreatedAt() {
        return this.createdAt;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final Map<String, Object> getParameters() {
        return this.parameters;
    }

    public int hashCode() {
        return (((((this.id.hashCode() * 31) + this.createdAt.hashCode()) * 31) + this.name.hashCode()) * 31) + this.parameters.hashCode();
    }

    public String toString() {
        return "ManagedEventData(id=" + this.id + ", createdAt=" + this.createdAt + ", name=" + this.name + ", parameters=" + this.parameters + ")";
    }
}
