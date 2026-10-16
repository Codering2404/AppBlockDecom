package com.revenuecat.purchases.subscriberattributes;

import com.revenuecat.purchases.common.BackendKt;
import com.revenuecat.purchases.common.SubscriberAttributeError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONException;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class BackendHelpersKt {
    public static final List<SubscriberAttributeError> getAttributeErrors(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return CollectionsKt.emptyList();
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(BackendKt.ATTRIBUTES_ERROR_RESPONSE_KEY);
        if (jSONObjectOptJSONObject != null) {
            jSONObject = jSONObjectOptJSONObject;
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(BackendKt.ATTRIBUTE_ERRORS_KEY);
        if (jSONArrayOptJSONArray != null) {
            int i3 = 0;
            IntRange intRangeB = RangesKt.B(0, jSONArrayOptJSONArray.length());
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeB, 10));
            Iterator<Integer> it = intRangeB.iterator();
            while (it.hasNext()) {
                arrayList.add(jSONArrayOptJSONArray.getJSONObject(((IntIterator) it).nextInt()));
            }
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj = arrayList.get(i4);
                i4++;
                JSONObject jSONObject2 = (JSONObject) obj;
                if (jSONObject2.has("key_name") && jSONObject2.has("message")) {
                    arrayList2.add(obj);
                }
            }
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            int size2 = arrayList2.size();
            while (i3 < size2) {
                Object obj2 = arrayList2.get(i3);
                i3++;
                JSONObject jSONObject3 = (JSONObject) obj2;
                String string = jSONObject3.getString("key_name");
                Intrinsics.checkNotNullExpressionValue(string, "it.getString(\"key_name\")");
                String string2 = jSONObject3.getString("message");
                Intrinsics.checkNotNullExpressionValue(string2, "it.getString(\"message\")");
                arrayList3.add(new SubscriberAttributeError(string, string2));
            }
            List<SubscriberAttributeError> list = CollectionsKt.toList(arrayList3);
            if (list != null) {
                return list;
            }
        }
        return CollectionsKt.emptyList();
    }

    public static final Map<String, Map<String, Object>> toBackendMap(Map<String, SubscriberAttribute> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, SubscriberAttribute> entry : map.entrySet()) {
            arrayList.add(TuplesKt.a(entry.getKey(), entry.getValue().toBackendMap()));
        }
        return MapsKt.toMap(arrayList);
    }
}
