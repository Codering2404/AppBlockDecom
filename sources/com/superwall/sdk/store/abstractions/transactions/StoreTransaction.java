package com.superwall.sdk.store.abstractions.transactions;

import com.android.billingclient.api.Purchase;
import com.superwall.sdk.models.serialization.DateSerializer;
import com.superwall.sdk.storage.core_data.ConvertersKt;
import com.superwall.sdk.store.abstractions.transactions.StoreTransaction;
import com.superwall.sdk.store.abstractions.transactions.StoreTransactionState;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
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
@Serializable
public final class StoreTransaction implements StoreTransactionType {
    public static final Companion Companion = new Companion(null);
    private final String appSessionId;
    private final String configRequestId;
    private final String id;
    private final transient GoogleBillingPurchaseTransaction transaction;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<StoreTransaction> serializer() {
            return StoreTransaction$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ StoreTransaction(int i3, GoogleBillingPurchaseTransaction googleBillingPurchaseTransaction, String str, String str2, String str3, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i3 & 7)) {
            PluginExceptionsKt.b(i3, 7, StoreTransaction$$serializer.INSTANCE.getDescriptor());
        }
        this.transaction = googleBillingPurchaseTransaction;
        this.configRequestId = str;
        this.appSessionId = str2;
        if ((i3 & 8) != 0) {
            this.id = str3;
            return;
        }
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        this.id = string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit toDictionary$lambda$0(JsonBuilder Json) {
        Intrinsics.checkNotNullParameter(Json, "$this$Json");
        Json.f(true);
        return Unit.f139807a;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(StoreTransaction storeTransaction, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.C(serialDescriptor, 0, GoogleBillingPurchaseTransaction$$serializer.INSTANCE, storeTransaction.transaction);
        compositeEncoder.y(serialDescriptor, 1, storeTransaction.configRequestId);
        compositeEncoder.y(serialDescriptor, 2, storeTransaction.appSessionId);
        if (!compositeEncoder.z(serialDescriptor, 3)) {
            String str = storeTransaction.id;
            String string = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            if (Intrinsics.areEqual(str, string)) {
                return;
            }
        }
        compositeEncoder.y(serialDescriptor, 3, storeTransaction.id);
    }

    @Override // com.superwall.sdk.store.abstractions.transactions.StoreTransactionType
    public String getAppAccountToken() {
        return this.transaction.getAppAccountToken();
    }

    @Override // com.superwall.sdk.store.abstractions.transactions.StoreTransactionType
    public String getAppBundleId() {
        return this.transaction.getAppBundleId();
    }

    public final String getAppSessionId() {
        return this.appSessionId;
    }

    public final String getConfigRequestId() {
        return this.configRequestId;
    }

    @Override // com.superwall.sdk.store.abstractions.transactions.StoreTransactionType
    public Date getExpirationDate() {
        return this.transaction.getExpirationDate();
    }

    public final String getId() {
        return this.id;
    }

    @Override // com.superwall.sdk.store.abstractions.transactions.StoreTransactionType
    public String getOfferId() {
        return this.transaction.getOfferId();
    }

    @Override // com.superwall.sdk.store.abstractions.transactions.StoreTransactionType
    public Date getOriginalTransactionDate() {
        return this.transaction.getOriginalTransactionDate();
    }

    @Override // com.superwall.sdk.store.abstractions.transactions.StoreTransactionType
    public String getOriginalTransactionIdentifier() {
        return this.transaction.getOriginalTransactionIdentifier();
    }

    @Override // com.superwall.sdk.store.abstractions.transactions.StoreTransactionType
    public StorePayment getPayment() {
        return this.transaction.getPayment();
    }

    @Override // com.superwall.sdk.store.abstractions.transactions.StoreTransactionType
    public String getPurchaseToken() {
        return this.transaction.getPurchaseToken();
    }

    @Override // com.superwall.sdk.store.abstractions.transactions.StoreTransactionType
    public Date getRevocationDate() {
        return this.transaction.getRevocationDate();
    }

    @Override // com.superwall.sdk.store.abstractions.transactions.StoreTransactionType
    public String getSignature() {
        Purchase underlyingSK2Transaction = this.transaction.getUnderlyingSK2Transaction();
        if (underlyingSK2Transaction != null) {
            return underlyingSK2Transaction.g();
        }
        return null;
    }

    @Override // com.superwall.sdk.store.abstractions.transactions.StoreTransactionType
    public StoreTransactionState getState() {
        return this.transaction.getState();
    }

    @Override // com.superwall.sdk.store.abstractions.transactions.StoreTransactionType
    public String getStoreTransactionId() {
        return this.transaction.getStoreTransactionId();
    }

    @Override // com.superwall.sdk.store.abstractions.transactions.StoreTransactionType
    public String getSubscriptionGroupId() {
        return this.transaction.getSubscriptionGroupId();
    }

    @Override // com.superwall.sdk.store.abstractions.transactions.StoreTransactionType
    public Date getTransactionDate() {
        return this.transaction.getTransactionDate();
    }

    @Override // com.superwall.sdk.store.abstractions.transactions.StoreTransactionType
    public String getWebOrderLineItemID() {
        return this.transaction.getWebOrderLineItemID();
    }

    @Override // com.superwall.sdk.store.abstractions.transactions.StoreTransactionType
    public Boolean isUpgraded() {
        return this.transaction.isUpgraded();
    }

    public final Map<String, Object> toDictionary() {
        Json jsonB = JsonKt.b(null, new Function1() { // from class: l0.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StoreTransaction.toDictionary$lambda$0((JsonBuilder) obj);
            }
        }, 1, null);
        Map<String, Object> mutableMap = MapsKt.toMutableMap(ConvertersKt.toNullableTypedMap(jsonB, jsonB.b(Companion.serializer(), this)));
        Object obj = mutableMap.get("transaction");
        Map<? extends String, ? extends Object> map = obj instanceof Map ? (Map) obj : null;
        if (map != null) {
            mutableMap.remove("transaction");
            mutableMap.putAll(map);
        }
        Object obj2 = mutableMap.get("payment");
        Map map2 = obj2 instanceof Map ? (Map) obj2 : null;
        if (map2 != null) {
            mutableMap.remove("payment");
            for (Map.Entry entry : map2.entrySet()) {
                String str = (String) entry.getKey();
                mutableMap.put("payment_" + str, entry.getValue());
            }
        }
        return mutableMap;
    }

    public StoreTransaction(GoogleBillingPurchaseTransaction transaction, String configRequestId, String appSessionId) {
        Intrinsics.checkNotNullParameter(transaction, "transaction");
        Intrinsics.checkNotNullParameter(configRequestId, "configRequestId");
        Intrinsics.checkNotNullParameter(appSessionId, "appSessionId");
        this.transaction = transaction;
        this.configRequestId = configRequestId;
        this.appSessionId = appSessionId;
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        this.id = string;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StoreTransaction(String customTransactionId, String productIdentifier, Date purchaseDate, String configRequestId, String appSessionId) {
        this(new GoogleBillingPurchaseTransaction(null, purchaseDate, customTransactionId, StoreTransactionState.Purchased.INSTANCE, customTransactionId, purchaseDate, null, null, null, null, null, null, null, null, "", new StorePayment(productIdentifier, 1, null), null), configRequestId, appSessionId);
        Intrinsics.checkNotNullParameter(customTransactionId, "customTransactionId");
        Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
        Intrinsics.checkNotNullParameter(purchaseDate, "purchaseDate");
        Intrinsics.checkNotNullParameter(configRequestId, "configRequestId");
        Intrinsics.checkNotNullParameter(appSessionId, "appSessionId");
    }

    @SerialName
    public static /* synthetic */ void getAppSessionId$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getConfigRequestId$annotations() {
    }

    @Serializable(with = DateSerializer.class)
    public static /* synthetic */ void getExpirationDate$annotations() {
    }

    @Serializable(with = DateSerializer.class)
    public static /* synthetic */ void getOriginalTransactionDate$annotations() {
    }

    @Serializable(with = DateSerializer.class)
    public static /* synthetic */ void getRevocationDate$annotations() {
    }
}
