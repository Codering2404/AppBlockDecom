package com.revenuecat.purchases.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

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
public final class JSONArrayExtensionsKt {
    public static final <T> List<T> replaceJsonNullWithKotlinNull(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        List<? extends T> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (T t2 : list2) {
            if (t2 instanceof Map) {
                Intrinsics.checkNotNull(t2, "null cannot be cast to non-null type kotlin.collections.Map<T of com.revenuecat.purchases.utils.JSONArrayExtensionsKt.replaceJsonNullWithKotlinNull, T of com.revenuecat.purchases.utils.JSONArrayExtensionsKt.replaceJsonNullWithKotlinNull?>");
                t2 = (T) JSONObjectExtensionsKt.replaceJsonNullWithKotlinNull((Map) t2);
            } else if (t2 instanceof List) {
                Intrinsics.checkNotNull(t2, "null cannot be cast to non-null type kotlin.collections.List<T of com.revenuecat.purchases.utils.JSONArrayExtensionsKt.replaceJsonNullWithKotlinNull?>");
                t2 = (T) replaceJsonNullWithKotlinNull((List) t2);
            } else if (Intrinsics.areEqual(t2, JSONObject.NULL)) {
                t2 = (T) null;
            }
            arrayList.add(t2);
        }
        return arrayList;
    }

    public static final <T> List<T> toList(JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(jSONArray, "<this>");
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            Object list = jSONArray.get(i3);
            if (list instanceof JSONObject) {
                list = JSONObjectExtensionsKt.toMap((JSONObject) list, true);
            } else if (list instanceof JSONArray) {
                list = toList((JSONArray) list);
            }
            arrayList.add(list);
        }
        return arrayList;
    }
}
