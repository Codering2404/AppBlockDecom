package com.revenuecat.purchases.subscriberattributes;

import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import com.revenuecat.purchases.common.subscriberattributes.SpecialSubscriberAttributesKt;
import com.revenuecat.purchases.common.subscriberattributes.SubscriberAttributeKey;
import com.revenuecat.purchases.utils.JSONObjectExtensionsKt;
import java.util.Date;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
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
public final class SubscriberAttribute {
    private final DateProvider dateProvider;
    private final boolean isSynced;
    private final SubscriberAttributeKey key;
    private final Date setTime;
    private final String value;

    public SubscriberAttribute(SubscriberAttributeKey key, String str, DateProvider dateProvider, Date setTime, boolean z2) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        Intrinsics.checkNotNullParameter(setTime, "setTime");
        this.key = key;
        this.value = str;
        this.dateProvider = dateProvider;
        this.setTime = setTime;
        this.isSynced = z2;
    }

    public static /* synthetic */ SubscriberAttribute copy$default(SubscriberAttribute subscriberAttribute, SubscriberAttributeKey subscriberAttributeKey, String str, DateProvider dateProvider, Date date, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            subscriberAttributeKey = subscriberAttribute.key;
        }
        if ((i3 & 2) != 0) {
            str = subscriberAttribute.value;
        }
        if ((i3 & 4) != 0) {
            dateProvider = subscriberAttribute.dateProvider;
        }
        if ((i3 & 8) != 0) {
            date = subscriberAttribute.setTime;
        }
        if ((i3 & 16) != 0) {
            z2 = subscriberAttribute.isSynced;
        }
        boolean z3 = z2;
        DateProvider dateProvider2 = dateProvider;
        return subscriberAttribute.copy(subscriberAttributeKey, str, dateProvider2, date, z3);
    }

    public final SubscriberAttributeKey component1() {
        return this.key;
    }

    public final String component2() {
        return this.value;
    }

    public final DateProvider component3() {
        return this.dateProvider;
    }

    public final Date component4() {
        return this.setTime;
    }

    public final boolean component5() {
        return this.isSynced;
    }

    public final SubscriberAttribute copy(SubscriberAttributeKey key, String str, DateProvider dateProvider, Date setTime, boolean z2) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        Intrinsics.checkNotNullParameter(setTime, "setTime");
        return new SubscriberAttribute(key, str, dateProvider, setTime, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(SubscriberAttribute.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.revenuecat.purchases.subscriberattributes.SubscriberAttribute");
        SubscriberAttribute subscriberAttribute = (SubscriberAttribute) obj;
        return Intrinsics.areEqual(this.key, subscriberAttribute.key) && Intrinsics.areEqual(this.value, subscriberAttribute.value) && Intrinsics.areEqual(this.setTime, subscriberAttribute.setTime) && this.isSynced == subscriberAttribute.isSynced;
    }

    public final DateProvider getDateProvider() {
        return this.dateProvider;
    }

    public final SubscriberAttributeKey getKey() {
        return this.key;
    }

    public final Date getSetTime() {
        return this.setTime;
    }

    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        int iHashCode = this.key.hashCode() * 31;
        String str = this.value;
        return ((((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + this.setTime.hashCode()) * 31) + Boolean.hashCode(this.isSynced);
    }

    public final boolean isSynced() {
        return this.isSynced;
    }

    public final Map<String, Object> toBackendMap() {
        return MapsKt.mapOf(TuplesKt.a("value", this.value), TuplesKt.a(SubscriberAttributeKt.BACKEND_NAME_TIMESTAMP, Long.valueOf(this.setTime.getTime())));
    }

    public final JSONObject toJSONObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("key", this.key.getBackendKey());
        String str = this.value;
        if (str == null || jSONObject.put("value", str) == null) {
            jSONObject.put("value", JSONObject.NULL);
        }
        jSONObject.put(SubscriberAttributeKt.JSON_NAME_SET_TIME, this.setTime.getTime());
        jSONObject.put(SubscriberAttributeKt.JSON_NAME_IS_SYNCED, this.isSynced);
        return jSONObject;
    }

    public String toString() {
        return "SubscriberAttribute(key=" + this.key + ", value=" + this.value + ", setTime=" + this.setTime + ", isSynced=" + this.isSynced + ')';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ SubscriberAttribute(SubscriberAttributeKey subscriberAttributeKey, String str, DateProvider dateProvider, Date date, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        DateProvider defaultDateProvider = (i3 & 4) != 0 ? new DefaultDateProvider() : dateProvider;
        this(subscriberAttributeKey, str, defaultDateProvider, (i3 & 8) != 0 ? defaultDateProvider.getNow() : date, (i3 & 16) != 0 ? false : z2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ SubscriberAttribute(String str, String str2, DateProvider dateProvider, Date date, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        DateProvider defaultDateProvider = (i3 & 4) != 0 ? new DefaultDateProvider() : dateProvider;
        this(str, str2, defaultDateProvider, (i3 & 8) != 0 ? defaultDateProvider.getNow() : date, (i3 & 16) != 0 ? false : z2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SubscriberAttribute(String key, String str, DateProvider dateProvider, Date setTime, boolean z2) {
        this(SpecialSubscriberAttributesKt.getSubscriberAttributeKey(key), str, (DateProvider) null, setTime, z2, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        Intrinsics.checkNotNullParameter(setTime, "setTime");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SubscriberAttribute(JSONObject jsonObject) throws JSONException {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        String string = jsonObject.getString("key");
        Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(JSON_NAME_KEY)");
        this(SpecialSubscriberAttributesKt.getSubscriberAttributeKey(string), JSONObjectExtensionsKt.getNullableString(jsonObject, "value"), (DateProvider) null, new Date(jsonObject.getLong(SubscriberAttributeKt.JSON_NAME_SET_TIME)), jsonObject.getBoolean(SubscriberAttributeKt.JSON_NAME_IS_SYNCED), 4, (DefaultConstructorMarker) null);
    }
}
