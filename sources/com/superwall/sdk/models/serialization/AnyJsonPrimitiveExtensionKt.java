package com.superwall.sdk.models.serialization;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonPrimitive;

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
public final class AnyJsonPrimitiveExtensionKt {
    public static final boolean isJsonPrimitable(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        return (obj instanceof String) || (obj instanceof Boolean) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Double);
    }

    public static final JsonPrimitive jsonPrimitive(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        if (obj instanceof String) {
            return JsonElementKt.c((String) obj);
        }
        if (obj instanceof Boolean) {
            return JsonElementKt.a((Boolean) obj);
        }
        if (obj instanceof Integer) {
            return JsonElementKt.b((Number) obj);
        }
        if (obj instanceof Long) {
            return JsonElementKt.b((Number) obj);
        }
        if (obj instanceof Float) {
            return JsonElementKt.b((Number) obj);
        }
        if (obj instanceof Double) {
            return JsonElementKt.b((Number) obj);
        }
        return null;
    }
}
