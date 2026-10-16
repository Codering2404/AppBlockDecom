package com.revenuecat.purchases.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.revenuecat.purchases.JsonTools;
import com.revenuecat.purchases.Store;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import com.revenuecat.purchases.common.responses.SubscriptionInfoResponse;
import com.revenuecat.purchases.utils.JSONObjectExtensionsKt;
import com.sun.jna.Function;
import java.util.Date;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.Json;
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
public final class Transaction implements Parcelable {
    public static final Parcelable.Creator<Transaction> CREATOR = new Creator();
    private final String displayName;
    private final boolean isSandbox;
    private final Date originalPurchaseDate;
    private final Price price;
    private final String productId;
    private final String productIdentifier;
    private final Date purchaseDate;
    private final String revenuecatId;
    private final Store store;
    private final String storeTransactionId;
    private final String transactionIdentifier;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Creator implements Parcelable.Creator<Transaction> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Transaction createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new Transaction(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), (Date) parcel.readSerializable(), parcel.readString(), Store.valueOf(parcel.readString()), parcel.readString(), parcel.readInt() != 0, (Date) parcel.readSerializable(), parcel.readInt() == 0 ? null : Price.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Transaction[] newArray(int i3) {
            return new Transaction[i3];
        }
    }

    public Transaction(String transactionIdentifier, String revenuecatId, String productIdentifier, String productId, Date purchaseDate, String str, Store store, String str2, boolean z2, Date date, Price price) {
        Intrinsics.checkNotNullParameter(transactionIdentifier, "transactionIdentifier");
        Intrinsics.checkNotNullParameter(revenuecatId, "revenuecatId");
        Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(purchaseDate, "purchaseDate");
        Intrinsics.checkNotNullParameter(store, "store");
        this.transactionIdentifier = transactionIdentifier;
        this.revenuecatId = revenuecatId;
        this.productIdentifier = productIdentifier;
        this.productId = productId;
        this.purchaseDate = purchaseDate;
        this.storeTransactionId = str;
        this.store = store;
        this.displayName = str2;
        this.isSandbox = z2;
        this.originalPurchaseDate = date;
        this.price = price;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Transaction)) {
            return false;
        }
        Transaction transaction = (Transaction) obj;
        return Intrinsics.areEqual(this.transactionIdentifier, transaction.transactionIdentifier) && Intrinsics.areEqual(this.revenuecatId, transaction.revenuecatId) && Intrinsics.areEqual(this.productIdentifier, transaction.productIdentifier) && Intrinsics.areEqual(this.productId, transaction.productId) && Intrinsics.areEqual(this.purchaseDate, transaction.purchaseDate) && Intrinsics.areEqual(this.storeTransactionId, transaction.storeTransactionId) && this.store == transaction.store && Intrinsics.areEqual(this.displayName, transaction.displayName) && this.isSandbox == transaction.isSandbox && Intrinsics.areEqual(this.originalPurchaseDate, transaction.originalPurchaseDate) && Intrinsics.areEqual(this.price, transaction.price);
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final Date getOriginalPurchaseDate() {
        return this.originalPurchaseDate;
    }

    public final Price getPrice() {
        return this.price;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getProductIdentifier() {
        return this.productIdentifier;
    }

    public final Date getPurchaseDate() {
        return this.purchaseDate;
    }

    public final String getRevenuecatId() {
        return this.revenuecatId;
    }

    public final Store getStore() {
        return this.store;
    }

    public final String getStoreTransactionId() {
        return this.storeTransactionId;
    }

    public final String getTransactionIdentifier() {
        return this.transactionIdentifier;
    }

    public int hashCode() {
        int iHashCode = ((((((((this.transactionIdentifier.hashCode() * 31) + this.revenuecatId.hashCode()) * 31) + this.productIdentifier.hashCode()) * 31) + this.productId.hashCode()) * 31) + this.purchaseDate.hashCode()) * 31;
        String str = this.storeTransactionId;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.store.hashCode()) * 31;
        String str2 = this.displayName;
        int iHashCode3 = (((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + Boolean.hashCode(this.isSandbox)) * 31;
        Date date = this.originalPurchaseDate;
        int iHashCode4 = (iHashCode3 + (date == null ? 0 : date.hashCode())) * 31;
        Price price = this.price;
        return iHashCode4 + (price != null ? price.hashCode() : 0);
    }

    public final boolean isSandbox() {
        return this.isSandbox;
    }

    public String toString() {
        return "Transaction(transactionIdentifier=" + this.transactionIdentifier + ", revenuecatId=" + this.revenuecatId + ", productIdentifier=" + this.productIdentifier + ", productId=" + this.productId + ", purchaseDate=" + this.purchaseDate + ", storeTransactionId=" + this.storeTransactionId + ", store=" + this.store + ", displayName=" + this.displayName + ", isSandbox=" + this.isSandbox + ", originalPurchaseDate=" + this.originalPurchaseDate + ", price=" + this.price + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.transactionIdentifier);
        out.writeString(this.revenuecatId);
        out.writeString(this.productIdentifier);
        out.writeString(this.productId);
        out.writeSerializable(this.purchaseDate);
        out.writeString(this.storeTransactionId);
        out.writeString(this.store.name());
        out.writeString(this.displayName);
        out.writeInt(this.isSandbox ? 1 : 0);
        out.writeSerializable(this.originalPurchaseDate);
        Price price = this.price;
        if (price == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            price.writeToParcel(out, i3);
        }
    }

    public /* synthetic */ Transaction(String str, String str2, String str3, String str4, Date date, String str5, Store store, String str6, boolean z2, Date date2, Price price, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, date, str5, store, str6, (i3 & Function.MAX_NARGS) != 0 ? false : z2, date2, price);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public Transaction(String transactionIdentifier, String revenuecatId, String productIdentifier, String productId, Date purchaseDate, String str, Store store) {
        this(transactionIdentifier, revenuecatId, productIdentifier, productId, purchaseDate, str, store, null, false, null, null);
        Intrinsics.checkNotNullParameter(transactionIdentifier, "transactionIdentifier");
        Intrinsics.checkNotNullParameter(revenuecatId, "revenuecatId");
        Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(purchaseDate, "purchaseDate");
        Intrinsics.checkNotNullParameter(store, "store");
    }

    @Deprecated
    public static /* synthetic */ void getProductId$annotations() {
    }

    @Deprecated
    public static /* synthetic */ void getRevenuecatId$annotations() {
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ Transaction(String str, JSONObject jSONObject, Locale locale, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i3 & 4) != 0) {
            locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        }
        this(str, jSONObject, locale);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Transaction(String productId, JSONObject jsonObject, Locale locale) throws JSONException {
        String string;
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Intrinsics.checkNotNullParameter(locale, "locale");
        String string2 = jsonObject.getString("id");
        Intrinsics.checkNotNullExpressionValue(string2, "jsonObject.getString(\"id\")");
        String string3 = jsonObject.getString("id");
        Intrinsics.checkNotNullExpressionValue(string3, "jsonObject.getString(\"id\")");
        Date date = JSONObjectExtensionsKt.getDate(jsonObject, "purchase_date");
        String it = jsonObject.optString("store_transaction_id");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        Price price = null;
        it = StringsKt.p0(it) ? null : it;
        String it2 = jsonObject.getString(ProductResponseJsonKeys.STORE);
        Store.Companion companion = Store.Companion;
        Intrinsics.checkNotNullExpressionValue(it2, "it");
        Store storeFromString = companion.fromString(it2);
        String it3 = jsonObject.optString("display_name");
        Intrinsics.checkNotNullExpressionValue(it3, "it");
        String str = !StringsKt.p0(it3) ? it3 : null;
        boolean zOptBoolean = jsonObject.optBoolean(ProductResponseJsonKeys.IS_SANDBOX, false);
        Date dateOptDate = JSONObjectExtensionsKt.optDate(jsonObject, "original_purchase_date");
        JSONObject jSONObjectOptJSONObject = jsonObject.optJSONObject("price");
        if (jSONObjectOptJSONObject != null && (string = jSONObjectOptJSONObject.toString()) != null) {
            Json json = JsonTools.INSTANCE.getJson();
            json.a();
            price = ((SubscriptionInfoResponse.PriceResponse) json.d(SubscriptionInfoResponse.PriceResponse.Companion.serializer(), string)).toPrice(locale);
        }
        this(string2, string3, productId, productId, date, it, storeFromString, str, zOptBoolean, dateOptDate, price);
    }
}
