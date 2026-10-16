package com.revenuecat.purchases.subscriberattributes;

import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class SubscriberAttributesFactoriesKt {
    public static final Map<String, SubscriberAttribute> buildLegacySubscriberAttributes(JSONObject jSONObject) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        JSONObject attributesJSONObject = jSONObject.getJSONObject("attributes");
        Intrinsics.checkNotNullExpressionValue(attributesJSONObject, "attributesJSONObject");
        return buildSubscriberAttributesMap(attributesJSONObject);
    }

    public static final Map<String, SubscriberAttribute> buildSubscriberAttributesMap(final JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Iterator<String> itKeys = jSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(itKeys, "this.keys()");
        return MapsKt.toMap(SequencesKt.M(SequencesKt.e(itKeys), new Function1<String, Pair<? extends String, ? extends SubscriberAttribute>>() { // from class: com.revenuecat.purchases.subscriberattributes.SubscriberAttributesFactoriesKt.buildSubscriberAttributesMap.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Pair<String, SubscriberAttribute> invoke(String str) throws JSONException {
                Object obj = jSONObject.get(str);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
                return TuplesKt.a(str, new SubscriberAttribute((JSONObject) obj));
            }
        }));
    }

    public static final Map<String, Map<String, SubscriberAttribute>> buildSubscriberAttributesMapPerUser(JSONObject jSONObject) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        final JSONObject jSONObject2 = jSONObject.getJSONObject("attributes");
        Iterator<String> itKeys = jSONObject2.keys();
        Intrinsics.checkNotNullExpressionValue(itKeys, "attributesJSONObject.keys()");
        return MapsKt.toMap(SequencesKt.M(SequencesKt.e(itKeys), new Function1<String, Pair<? extends String, ? extends Map<String, ? extends SubscriberAttribute>>>() { // from class: com.revenuecat.purchases.subscriberattributes.SubscriberAttributesFactoriesKt.buildSubscriberAttributesMapPerUser.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Pair<String, Map<String, SubscriberAttribute>> invoke(String str) throws JSONException {
                Object obj = jSONObject2.get(str);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
                return TuplesKt.a(str, SubscriberAttributesFactoriesKt.buildSubscriberAttributesMap((JSONObject) obj));
            }
        }));
    }
}
