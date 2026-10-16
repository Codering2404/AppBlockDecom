package com.google.maps.android.ktx;

import com.google.android.gms.maps.model.IndoorBuilding;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class IndoorLevelActivatedEvent extends IndoorChangeEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IndoorBuilding f91486a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IndoorLevelActivatedEvent(IndoorBuilding building) {
        super(null);
        Intrinsics.checkNotNullParameter(building, "building");
        this.f91486a = building;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof IndoorLevelActivatedEvent) && Intrinsics.areEqual(this.f91486a, ((IndoorLevelActivatedEvent) obj).f91486a);
    }

    public int hashCode() {
        return this.f91486a.hashCode();
    }

    public String toString() {
        return "IndoorLevelActivatedEvent(building=" + this.f91486a + ')';
    }
}
