package com.superwall.sdk.storage.core_data;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;

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
public final class Converters {
    public static final Companion Companion = new Companion(null);
    private static final Lazy<Json> jsonParser$delegate = LazyKt.b(new Function0() { // from class: com.superwall.sdk.storage.core_data.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Converters.jsonParser_delegate$lambda$2();
        }
    });

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Json getJsonParser() {
            return (Json) Converters.jsonParser$delegate.getValue();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Json jsonParser_delegate$lambda$2() {
        return JsonKt.b(null, new Function1() { // from class: com.superwall.sdk.storage.core_data.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Converters.jsonParser_delegate$lambda$2$lambda$1((JsonBuilder) obj);
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit jsonParser_delegate$lambda$2$lambda$1(JsonBuilder Json) {
        Intrinsics.checkNotNullParameter(Json, "$this$Json");
        Json.h(true);
        Json.i(true);
        return Unit.f139807a;
    }

    public final String fromMap(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        return ConvertersKt.fromTypedMap(Companion.getJsonParser(), sanitizeMap(map));
    }

    public final Map<String, Object> sanitizeMap(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            Object value = entry.getValue();
            if ((value instanceof String) || (value instanceof Number) || (value instanceof Boolean) || (value instanceof Date) || (value instanceof List) || (value instanceof Map)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    public final Date toDate(long j3) {
        return new Date(j3);
    }

    public final Map<String, Object> toMap(String json) {
        Intrinsics.checkNotNullParameter(json, "json");
        return sanitizeMap(ConvertersKt.toTypedMap(Companion.getJsonParser(), json));
    }

    public final Long toTimestamp(Date date) {
        if (date != null) {
            return Long.valueOf(date.getTime());
        }
        return null;
    }
}
