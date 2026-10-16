package com.superwall.sdk.paywall.presentation;

import androidx.glance.color.Tq.KqqtdetwHMIO;
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
public final class CustomCallback {
    private final String name;
    private final Map<String, Object> variables;

    public CustomCallback(String name, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.variables = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CustomCallback copy$default(CustomCallback customCallback, String str, Map map, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = customCallback.name;
        }
        if ((i3 & 2) != 0) {
            map = customCallback.variables;
        }
        return customCallback.copy(str, map);
    }

    public final String component1() {
        return this.name;
    }

    public final Map<String, Object> component2() {
        return this.variables;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CustomCallback)) {
            return false;
        }
        CustomCallback customCallback = (CustomCallback) obj;
        return Intrinsics.areEqual(this.name, customCallback.name) && Intrinsics.areEqual(this.variables, customCallback.variables);
    }

    public final String getName() {
        return this.name;
    }

    public final Map<String, Object> getVariables() {
        return this.variables;
    }

    public int hashCode() {
        int iHashCode = this.name.hashCode() * 31;
        Map<String, Object> map = this.variables;
        return iHashCode + (map == null ? 0 : map.hashCode());
    }

    public String toString() {
        return "CustomCallback(name=" + this.name + ", variables=" + this.variables + ")";
    }

    public final CustomCallback copy(String str, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, KqqtdetwHMIO.YViZuYgBZLi);
        return new CustomCallback(str, map);
    }
}
