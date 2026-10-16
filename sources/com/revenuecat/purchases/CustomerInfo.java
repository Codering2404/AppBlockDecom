package com.revenuecat.purchases;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.revenuecat.purchases.common.CustomerInfoFactory;
import com.revenuecat.purchases.common.responses.CustomerInfoResponseJsonKeys;
import com.revenuecat.purchases.models.RawDataContainer;
import com.revenuecat.purchases.models.Transaction;
import com.revenuecat.purchases.utils.DateHelper;
import com.revenuecat.purchases.utils.JSONObjectParceler;
import d.qFm.sECyKyO;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class CustomerInfo implements Parcelable, RawDataContainer<JSONObject> {
    public static final Parcelable.Creator<CustomerInfo> CREATOR = new Creator();
    private final Lazy activeSubscriptions$delegate;
    private final Map<String, Date> allExpirationDatesByProduct;
    private final Map<String, Date> allPurchaseDatesByProduct;
    private final Lazy allPurchasedProductIds$delegate;
    private final Lazy allPurchasedSkus$delegate;
    private final EntitlementInfos entitlements;
    private final Date firstSeen;
    private final JSONObject jsonObject;
    private final Lazy latestExpirationDate$delegate;
    private final boolean loadedFromCache;
    private final Uri managementURL;
    private final Lazy nonSubscriptionTransactions$delegate;
    private final String originalAppUserId;
    private final Date originalPurchaseDate;
    private final CustomerInfoOriginalSource originalSource;
    private final Date requestDate;
    private final int schemaVersion;
    private final JSONObject subscriberJSONObject;
    private final Lazy subscriptionsByProductIdentifier$delegate;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Creator implements Parcelable.Creator<CustomerInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CustomerInfo createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            EntitlementInfos entitlementInfosCreateFromParcel = EntitlementInfos.CREATOR.createFromParcel(parcel);
            int i3 = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(i3);
            for (int i4 = 0; i4 != i3; i4++) {
                linkedHashMap.put(parcel.readString(), parcel.readSerializable());
            }
            int i5 = parcel.readInt();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(i5);
            for (int i6 = 0; i6 != i5; i6++) {
                linkedHashMap2.put(parcel.readString(), parcel.readSerializable());
            }
            return new CustomerInfo(entitlementInfosCreateFromParcel, linkedHashMap, linkedHashMap2, (Date) parcel.readSerializable(), parcel.readInt(), (Date) parcel.readSerializable(), parcel.readString(), (Uri) parcel.readParcelable(CustomerInfo.class.getClassLoader()), (Date) parcel.readSerializable(), JSONObjectParceler.INSTANCE.create(parcel), CustomerInfoOriginalSource.valueOf(parcel.readString()), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CustomerInfo[] newArray(int i3) {
            return new CustomerInfo[i3];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CustomerInfo(EntitlementInfos entitlements, Map<String, ? extends Date> allExpirationDatesByProduct, Map<String, ? extends Date> allPurchaseDatesByProduct, Date requestDate, int i3, Date firstSeen, String originalAppUserId, Uri uri, Date date, JSONObject jsonObject, CustomerInfoOriginalSource originalSource, boolean z2) {
        Intrinsics.checkNotNullParameter(entitlements, "entitlements");
        Intrinsics.checkNotNullParameter(allExpirationDatesByProduct, "allExpirationDatesByProduct");
        Intrinsics.checkNotNullParameter(allPurchaseDatesByProduct, "allPurchaseDatesByProduct");
        Intrinsics.checkNotNullParameter(requestDate, "requestDate");
        Intrinsics.checkNotNullParameter(firstSeen, "firstSeen");
        Intrinsics.checkNotNullParameter(originalAppUserId, "originalAppUserId");
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Intrinsics.checkNotNullParameter(originalSource, "originalSource");
        this.entitlements = entitlements;
        this.allExpirationDatesByProduct = allExpirationDatesByProduct;
        this.allPurchaseDatesByProduct = allPurchaseDatesByProduct;
        this.requestDate = requestDate;
        this.schemaVersion = i3;
        this.firstSeen = firstSeen;
        this.originalAppUserId = originalAppUserId;
        this.managementURL = uri;
        this.originalPurchaseDate = date;
        this.jsonObject = jsonObject;
        this.originalSource = originalSource;
        this.loadedFromCache = z2;
        this.activeSubscriptions$delegate = LazyKt.b(new Function0<Set<? extends String>>() { // from class: com.revenuecat.purchases.CustomerInfo$activeSubscriptions$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Set<String> invoke() {
                CustomerInfo customerInfo = this.this$0;
                return customerInfo.activeIdentifiers(customerInfo.getAllExpirationDatesByProduct());
            }
        });
        this.allPurchasedSkus$delegate = LazyKt.b(new Function0<Set<? extends String>>() { // from class: com.revenuecat.purchases.CustomerInfo$allPurchasedSkus$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Set<String> invoke() {
                List<Transaction> nonSubscriptionTransactions = this.this$0.getNonSubscriptionTransactions();
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(nonSubscriptionTransactions, 10));
                Iterator<T> it = nonSubscriptionTransactions.iterator();
                while (it.hasNext()) {
                    arrayList.add(((Transaction) it.next()).getProductIdentifier());
                }
                return SetsKt.plus(CollectionsKt.toSet(arrayList), (Iterable) this.this$0.getAllExpirationDatesByProduct().keySet());
            }
        });
        this.allPurchasedProductIds$delegate = LazyKt.b(new Function0<Set<? extends String>>() { // from class: com.revenuecat.purchases.CustomerInfo$allPurchasedProductIds$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Set<String> invoke() {
                List<Transaction> nonSubscriptionTransactions = this.this$0.getNonSubscriptionTransactions();
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(nonSubscriptionTransactions, 10));
                Iterator<T> it = nonSubscriptionTransactions.iterator();
                while (it.hasNext()) {
                    arrayList.add(((Transaction) it.next()).getProductIdentifier());
                }
                return SetsKt.plus(CollectionsKt.toSet(arrayList), (Iterable) this.this$0.getAllExpirationDatesByProduct().keySet());
            }
        });
        this.latestExpirationDate$delegate = LazyKt.b(new Function0<Date>() { // from class: com.revenuecat.purchases.CustomerInfo$latestExpirationDate$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Date invoke() {
                List listSortedWith = CollectionsKt.sortedWith(this.this$0.getAllExpirationDatesByProduct().values(), new Comparator() { // from class: com.revenuecat.purchases.CustomerInfo$latestExpirationDate$2$invoke$$inlined$sortedBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t2, T t3) {
                        return ComparisonsKt.d((Date) t2, (Date) t3);
                    }
                });
                if (listSortedWith.isEmpty()) {
                    listSortedWith = null;
                }
                if (listSortedWith != null) {
                    return (Date) CollectionsKt.last(listSortedWith);
                }
                return null;
            }
        });
        this.nonSubscriptionTransactions$delegate = LazyKt.b(new Function0<List<? extends Transaction>>() { // from class: com.revenuecat.purchases.CustomerInfo$nonSubscriptionTransactions$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<Transaction> invoke() throws JSONException {
                ArrayList arrayList = new ArrayList();
                JSONObject jSONObject = this.this$0.subscriberJSONObject.getJSONObject(CustomerInfoResponseJsonKeys.NON_SUBSCRIPTIONS);
                Iterator<String> itKeys = jSONObject.keys();
                Intrinsics.checkNotNullExpressionValue(itKeys, "nonSubscriptions.keys()");
                while (itKeys.hasNext()) {
                    String productId = itKeys.next();
                    JSONArray jSONArray = jSONObject.getJSONArray(productId);
                    int length = jSONArray.length();
                    for (int i4 = 0; i4 < length; i4++) {
                        JSONObject transactionJSONObject = jSONArray.getJSONObject(i4);
                        Intrinsics.checkNotNullExpressionValue(productId, "productId");
                        Intrinsics.checkNotNullExpressionValue(transactionJSONObject, "transactionJSONObject");
                        arrayList.add(new Transaction(productId, transactionJSONObject, null, 4, null));
                    }
                }
                return CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.revenuecat.purchases.CustomerInfo$nonSubscriptionTransactions$2$invoke$$inlined$sortedBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t2, T t3) {
                        return ComparisonsKt.d(((Transaction) t2).getPurchaseDate(), ((Transaction) t3).getPurchaseDate());
                    }
                });
            }
        });
        this.subscriptionsByProductIdentifier$delegate = LazyKt.b(new Function0<Map<String, ? extends SubscriptionInfo>>() { // from class: com.revenuecat.purchases.CustomerInfo$subscriptionsByProductIdentifier$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Map<String, SubscriptionInfo> invoke() {
                CustomerInfoFactory customerInfoFactory = CustomerInfoFactory.INSTANCE;
                JSONObject subscriberJSONObject = this.this$0.subscriberJSONObject;
                Intrinsics.checkNotNullExpressionValue(subscriberJSONObject, "subscriberJSONObject");
                return customerInfoFactory.parseSubscriptionInfos(subscriberJSONObject, this.this$0.getRequestDate());
            }
        });
        this.subscriberJSONObject = jsonObject.getJSONObject(CustomerInfoResponseJsonKeys.SUBSCRIBER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Set<String> activeIdentifiers(Map<String, ? extends Date> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, ? extends Date> entry : map.entrySet()) {
            if (DateHelper.Companion.m1240isDateActiveSxA4cEA$default(DateHelper.Companion, entry.getValue(), this.requestDate, 0L, 4, null).isActive()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap.keySet();
    }

    public static /* synthetic */ void getActiveSubscriptions$annotations() {
    }

    public static /* synthetic */ void getAllPurchasedProductIds$annotations() {
    }

    @Deprecated
    public static /* synthetic */ void getAllPurchasedSkus$annotations() {
    }

    public static /* synthetic */ void getLatestExpirationDate$annotations() {
    }

    public static /* synthetic */ void getNonSubscriptionTransactions$annotations() {
    }

    public static /* synthetic */ void getRawData$annotations() {
    }

    private static /* synthetic */ void getSubscriberJSONObject$annotations() {
    }

    public static /* synthetic */ void getSubscriptionsByProductIdentifier$annotations() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return (obj instanceof CustomerInfo) && Intrinsics.areEqual(new ComparableData(this), new ComparableData((CustomerInfo) obj));
    }

    public final Set<String> getActiveSubscriptions() {
        return (Set) this.activeSubscriptions$delegate.getValue();
    }

    public final Map<String, Date> getAllExpirationDatesByProduct() {
        return this.allExpirationDatesByProduct;
    }

    public final Map<String, Date> getAllPurchaseDatesByProduct() {
        return this.allPurchaseDatesByProduct;
    }

    public final Set<String> getAllPurchasedProductIds() {
        return (Set) this.allPurchasedProductIds$delegate.getValue();
    }

    public final Set<String> getAllPurchasedSkus() {
        return (Set) this.allPurchasedSkus$delegate.getValue();
    }

    public final EntitlementInfos getEntitlements() {
        return this.entitlements;
    }

    public final Date getExpirationDateForEntitlement(String entitlement) {
        Intrinsics.checkNotNullParameter(entitlement, "entitlement");
        EntitlementInfo entitlementInfo = this.entitlements.getAll().get(entitlement);
        if (entitlementInfo != null) {
            return entitlementInfo.getExpirationDate();
        }
        return null;
    }

    public final Date getExpirationDateForProductId(String productId) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        return this.allExpirationDatesByProduct.get(productId);
    }

    @Deprecated
    public final Date getExpirationDateForSku(String sku) {
        Intrinsics.checkNotNullParameter(sku, "sku");
        return this.allExpirationDatesByProduct.get(sku);
    }

    public final Date getFirstSeen() {
        return this.firstSeen;
    }

    public final Date getLatestExpirationDate() {
        return (Date) this.latestExpirationDate$delegate.getValue();
    }

    public final boolean getLoadedFromCache$purchases_defaultsBc8Release() {
        return this.loadedFromCache;
    }

    public final Uri getManagementURL() {
        return this.managementURL;
    }

    public final List<Transaction> getNonSubscriptionTransactions() {
        return (List) this.nonSubscriptionTransactions$delegate.getValue();
    }

    public final String getOriginalAppUserId() {
        return this.originalAppUserId;
    }

    public final Date getOriginalPurchaseDate() {
        return this.originalPurchaseDate;
    }

    public final CustomerInfoOriginalSource getOriginalSource$purchases_defaultsBc8Release() {
        return this.originalSource;
    }

    public final Date getPurchaseDateForEntitlement(String entitlement) {
        Intrinsics.checkNotNullParameter(entitlement, "entitlement");
        EntitlementInfo entitlementInfo = this.entitlements.getAll().get(entitlement);
        if (entitlementInfo != null) {
            return entitlementInfo.getLatestPurchaseDate();
        }
        return null;
    }

    public final Date getPurchaseDateForProductId(String productId) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        return this.allPurchaseDatesByProduct.get(productId);
    }

    @Deprecated
    public final Date getPurchaseDateForSku(String sku) {
        Intrinsics.checkNotNullParameter(sku, "sku");
        return this.allPurchaseDatesByProduct.get(sku);
    }

    public final Date getRequestDate() {
        return this.requestDate;
    }

    public final int getSchemaVersion() {
        return this.schemaVersion;
    }

    public final Map<String, SubscriptionInfo> getSubscriptionsByProductIdentifier() {
        return (Map) this.subscriptionsByProductIdentifier$delegate.getValue();
    }

    public int hashCode() {
        return new ComparableData(this).hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<CustomerInfo\n latestExpirationDate: ");
        sb.append(getLatestExpirationDate());
        sb.append("\nactiveSubscriptions:  ");
        Set<String> activeSubscriptions = getActiveSubscriptions();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(activeSubscriptions, 10));
        for (String str : activeSubscriptions) {
            arrayList.add(TuplesKt.a(str, MapsKt.mapOf(TuplesKt.a("expiresDate", getExpirationDateForProductId(str)))));
        }
        sb.append(MapsKt.toMap(arrayList));
        sb.append(",\nactiveEntitlements: ");
        Map<String, EntitlementInfo> active = this.entitlements.getActive();
        ArrayList arrayList2 = new ArrayList(active.size());
        Iterator<Map.Entry<String, EntitlementInfo>> it = active.entrySet().iterator();
        while (it.hasNext()) {
            arrayList2.add(it.next().toString());
        }
        sb.append(arrayList2);
        sb.append(",\nentitlements: ");
        Map<String, EntitlementInfo> all = this.entitlements.getAll();
        ArrayList arrayList3 = new ArrayList(all.size());
        Iterator<Map.Entry<String, EntitlementInfo>> it2 = all.entrySet().iterator();
        while (it2.hasNext()) {
            arrayList3.add(it2.next().toString());
        }
        sb.append(arrayList3);
        sb.append(",\nnonSubscriptionTransactions: ");
        sb.append(getNonSubscriptionTransactions());
        sb.append(",\nrequestDate: ");
        sb.append(this.requestDate);
        sb.append("\n>");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        this.entitlements.writeToParcel(out, i3);
        Map<String, Date> map = this.allExpirationDatesByProduct;
        out.writeInt(map.size());
        for (Map.Entry<String, Date> entry : map.entrySet()) {
            out.writeString(entry.getKey());
            out.writeSerializable(entry.getValue());
        }
        Map<String, Date> map2 = this.allPurchaseDatesByProduct;
        out.writeInt(map2.size());
        for (Map.Entry<String, Date> entry2 : map2.entrySet()) {
            out.writeString(entry2.getKey());
            out.writeSerializable(entry2.getValue());
        }
        out.writeSerializable(this.requestDate);
        out.writeInt(this.schemaVersion);
        out.writeSerializable(this.firstSeen);
        out.writeString(this.originalAppUserId);
        out.writeParcelable(this.managementURL, i3);
        out.writeSerializable(this.originalPurchaseDate);
        JSONObjectParceler.INSTANCE.write(this.jsonObject, out, i3);
        out.writeString(this.originalSource.name());
        out.writeInt(this.loadedFromCache ? 1 : 0);
    }

    @Override // com.revenuecat.purchases.models.RawDataContainer
    public JSONObject getRawData() {
        return this.jsonObject;
    }

    public /* synthetic */ CustomerInfo(EntitlementInfos entitlementInfos, Map map, Map map2, Date date, int i3, Date date2, String str, Uri uri, Date date3, JSONObject jSONObject, CustomerInfoOriginalSource customerInfoOriginalSource, boolean z2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(entitlementInfos, map, map2, date, i3, date2, str, uri, date3, jSONObject, (i4 & 1024) != 0 ? CustomerInfoOriginalSource.Companion.getDEFAULT() : customerInfoOriginalSource, (i4 & 2048) != 0 ? false : z2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CustomerInfo(EntitlementInfos entitlements, Map<String, ? extends Date> allExpirationDatesByProduct, Map<String, ? extends Date> map, Date requestDate, int i3, Date firstSeen, String originalAppUserId, Uri uri, Date date, JSONObject jsonObject) {
        this(entitlements, allExpirationDatesByProduct, map, requestDate, i3, firstSeen, originalAppUserId, uri, date, jsonObject, CustomerInfoOriginalSource.Companion.getDEFAULT(), true);
        Intrinsics.checkNotNullParameter(entitlements, "entitlements");
        Intrinsics.checkNotNullParameter(allExpirationDatesByProduct, "allExpirationDatesByProduct");
        Intrinsics.checkNotNullParameter(map, sECyKyO.wZahKxLwzasYn);
        Intrinsics.checkNotNullParameter(requestDate, "requestDate");
        Intrinsics.checkNotNullParameter(firstSeen, "firstSeen");
        Intrinsics.checkNotNullParameter(originalAppUserId, "originalAppUserId");
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
    }
}
