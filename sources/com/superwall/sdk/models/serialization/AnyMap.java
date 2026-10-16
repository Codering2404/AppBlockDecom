package com.superwall.sdk.models.serialization;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

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
@Serializable(with = AnyMapSerializer.class)
public final class AnyMap {
    public static final Companion Companion = new Companion(null);
    private final Map<String, Object> map;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<AnyMap> serializer() {
            return AnyMapSerializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public AnyMap(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        this.map = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnyMap copy$default(AnyMap anyMap, Map map, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            map = anyMap.map;
        }
        return anyMap.copy(map);
    }

    public final Map<String, Object> component1() {
        return this.map;
    }

    public final AnyMap copy(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        return new AnyMap(map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AnyMap) && Intrinsics.areEqual(this.map, ((AnyMap) obj).map);
    }

    public final Map<String, Object> getMap() {
        return this.map;
    }

    public int hashCode() {
        return this.map.hashCode();
    }

    public String toString() {
        return "AnyMap(map=" + this.map + ")";
    }
}
