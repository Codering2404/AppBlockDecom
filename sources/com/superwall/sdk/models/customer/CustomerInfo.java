package com.superwall.sdk.models.customer;

import com.superwall.sdk.models.entitlements.Entitlement;
import com.superwall.sdk.models.entitlements.Entitlement$$serializer;
import com.superwall.sdk.models.entitlements.SubscriptionStatus;
import com.superwall.sdk.models.internal.WebRedemptionResponse;
import com.superwall.sdk.models.product.Store;
import com.superwall.sdk.network.JsonFactory;
import com.superwall.sdk.storage.LatestDeviceCustomerInfo;
import com.superwall.sdk.storage.LatestRedemptionResponse;
import com.superwall.sdk.storage.Storage;
import com.superwall.sdk.storage.core_data.ConvertersKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.Transient;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;

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
public final class CustomerInfo {
    private final List<Entitlement> entitlements;
    private final boolean isPlaceholder;
    private final List<NonSubscriptionTransaction> nonSubscriptions;
    private final List<SubscriptionTransaction> subscriptions;
    private final String userId;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(SubscriptionTransaction$$serializer.INSTANCE), new ArrayListSerializer(NonSubscriptionTransaction$$serializer.INSTANCE), null, new ArrayListSerializer(Entitlement$$serializer.INSTANCE), null};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CustomerInfo empty() {
            return new CustomerInfo(CollectionsKt.emptyList(), CollectionsKt.emptyList(), "", CollectionsKt.emptyList(), true);
        }

        public final CustomerInfo forExternalPurchaseController(Storage storage, SubscriptionStatus subscriptionStatus) {
            CustomerInfo customerInfoEmpty;
            Collection collectionEmptyList;
            Intrinsics.checkNotNullParameter(storage, "storage");
            Intrinsics.checkNotNullParameter(subscriptionStatus, "subscriptionStatus");
            WebRedemptionResponse webRedemptionResponse = (WebRedemptionResponse) storage.read(LatestRedemptionResponse.INSTANCE);
            if (webRedemptionResponse == null || (customerInfoEmpty = webRedemptionResponse.getCustomerInfo()) == null) {
                customerInfoEmpty = empty();
            }
            CustomerInfo customerInfoEmpty2 = (CustomerInfo) storage.read(LatestDeviceCustomerInfo.INSTANCE);
            if (customerInfoEmpty2 == null) {
                customerInfoEmpty2 = empty();
            }
            CustomerInfo customerInfoMerge = CustomerInfoMergingKt.merge(customerInfoEmpty2, customerInfoEmpty);
            List<Entitlement> entitlements = customerInfoEmpty2.getEntitlements();
            ArrayList arrayList = new ArrayList();
            for (Object obj : entitlements) {
                if (!((Entitlement) obj).isActive()) {
                    arrayList.add(obj);
                }
            }
            if (subscriptionStatus instanceof SubscriptionStatus.Active) {
                Set<Entitlement> entitlements2 = ((SubscriptionStatus.Active) subscriptionStatus).getEntitlements();
                collectionEmptyList = new ArrayList();
                for (Object obj2 : entitlements2) {
                    if (((Entitlement) obj2).getStore() == Store.PLAY_STORE) {
                        collectionEmptyList.add(obj2);
                    }
                }
            } else {
                if (!Intrinsics.areEqual(subscriptionStatus, SubscriptionStatus.Inactive.INSTANCE) && !Intrinsics.areEqual(subscriptionStatus, SubscriptionStatus.Unknown.INSTANCE)) {
                    throw new NoWhenBranchMatchedException();
                }
                collectionEmptyList = CollectionsKt.emptyList();
            }
            return new CustomerInfo(customerInfoMerge.getSubscriptions(), customerInfoMerge.getNonSubscriptions(), customerInfoMerge.getUserId(), CollectionsKt.sortedWith(CustomerInfoMergingKt.mergeEntitlementsPrioritized(CustomerInfoMergingKt.plus(CustomerInfoMergingKt.plus(collectionEmptyList, customerInfoEmpty.getEntitlements()), arrayList)), new Comparator() { // from class: com.superwall.sdk.models.customer.CustomerInfo$Companion$forExternalPurchaseController$$inlined$sortedBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t2, T t3) {
                    return ComparisonsKt.d(((Entitlement) t2).getId(), ((Entitlement) t3).getId());
                }
            }), false);
        }

        public final KSerializer<CustomerInfo> serializer() {
            return CustomerInfo$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ CustomerInfo(int i3, List list, List list2, String str, List list3, boolean z2, SerializationConstructorMarker serializationConstructorMarker) {
        if (11 != (i3 & 11)) {
            PluginExceptionsKt.b(i3, 11, CustomerInfo$$serializer.INSTANCE.getDescriptor());
        }
        this.subscriptions = list;
        this.nonSubscriptions = list2;
        if ((i3 & 4) == 0) {
            this.userId = "";
        } else {
            this.userId = str;
        }
        this.entitlements = list3;
        if ((i3 & 16) == 0) {
            this.isPlaceholder = false;
        } else {
            this.isPlaceholder = z2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CustomerInfo copy$default(CustomerInfo customerInfo, List list, List list2, String str, List list3, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = customerInfo.subscriptions;
        }
        if ((i3 & 2) != 0) {
            list2 = customerInfo.nonSubscriptions;
        }
        if ((i3 & 4) != 0) {
            str = customerInfo.userId;
        }
        if ((i3 & 8) != 0) {
            list3 = customerInfo.entitlements;
        }
        if ((i3 & 16) != 0) {
            z2 = customerInfo.isPlaceholder;
        }
        boolean z3 = z2;
        String str2 = str;
        return customerInfo.copy(list, list2, str2, list3, z3);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(CustomerInfo customerInfo, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        compositeEncoder.C(serialDescriptor, 0, kSerializerArr[0], customerInfo.subscriptions);
        compositeEncoder.C(serialDescriptor, 1, kSerializerArr[1], customerInfo.nonSubscriptions);
        if (compositeEncoder.z(serialDescriptor, 2) || !Intrinsics.areEqual(customerInfo.userId, "")) {
            compositeEncoder.y(serialDescriptor, 2, customerInfo.userId);
        }
        compositeEncoder.C(serialDescriptor, 3, kSerializerArr[3], customerInfo.entitlements);
        if (compositeEncoder.z(serialDescriptor, 4) || customerInfo.isPlaceholder) {
            compositeEncoder.x(serialDescriptor, 4, customerInfo.isPlaceholder);
        }
    }

    public final List<SubscriptionTransaction> component1() {
        return this.subscriptions;
    }

    public final List<NonSubscriptionTransaction> component2() {
        return this.nonSubscriptions;
    }

    public final String component3() {
        return this.userId;
    }

    public final List<Entitlement> component4() {
        return this.entitlements;
    }

    public final boolean component5$superwall_release() {
        return this.isPlaceholder;
    }

    public final CustomerInfo copy(List<SubscriptionTransaction> subscriptions, List<NonSubscriptionTransaction> nonSubscriptions, String userId, List<Entitlement> entitlements, boolean z2) {
        Intrinsics.checkNotNullParameter(subscriptions, "subscriptions");
        Intrinsics.checkNotNullParameter(nonSubscriptions, "nonSubscriptions");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(entitlements, "entitlements");
        return new CustomerInfo(subscriptions, nonSubscriptions, userId, entitlements, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CustomerInfo)) {
            return false;
        }
        CustomerInfo customerInfo = (CustomerInfo) obj;
        return Intrinsics.areEqual(this.subscriptions, customerInfo.subscriptions) && Intrinsics.areEqual(this.nonSubscriptions, customerInfo.nonSubscriptions) && Intrinsics.areEqual(this.userId, customerInfo.userId) && Intrinsics.areEqual(this.entitlements, customerInfo.entitlements) && this.isPlaceholder == customerInfo.isPlaceholder;
    }

    public final Set<String> getActiveSubscriptionProductIds() {
        List<SubscriptionTransaction> list = this.subscriptions;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((SubscriptionTransaction) obj).isActive()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj2 = arrayList.get(i3);
            i3++;
            arrayList2.add(((SubscriptionTransaction) obj2).getProductId());
        }
        return CollectionsKt.toSet(arrayList2);
    }

    public final List<Entitlement> getEntitlements() {
        return this.entitlements;
    }

    public final List<NonSubscriptionTransaction> getNonSubscriptions() {
        return this.nonSubscriptions;
    }

    public final List<SubscriptionTransaction> getSubscriptions() {
        return this.subscriptions;
    }

    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        return (((((((this.subscriptions.hashCode() * 31) + this.nonSubscriptions.hashCode()) * 31) + this.userId.hashCode()) * 31) + this.entitlements.hashCode()) * 31) + Boolean.hashCode(this.isPlaceholder);
    }

    public final boolean isPlaceholder$superwall_release() {
        return this.isPlaceholder;
    }

    public final Map<String, Object> toParams() {
        if (this.isPlaceholder) {
            return MapsKt.emptyMap();
        }
        JsonObject jsonObjectO = JsonElementKt.o(JsonFactory.Companion.getJSON().e(Companion.serializer(), this));
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(jsonObjectO.size()));
        Iterator<T> it = jsonObjectO.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), ConvertersKt.convertFromJsonElement((JsonElement) entry.getValue()));
        }
        return linkedHashMap;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CustomerInfo(");
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        sb.append("  userId=" + this.userId + ",");
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        sb.append("  isPlaceholder=" + this.isPlaceholder + ",");
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        sb.append("  subscriptions=[");
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        int i3 = 0;
        int i4 = 0;
        for (Object obj : this.subscriptions) {
            int i5 = i4 + 1;
            if (i4 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            sb.append("    #" + i4 + " " + ((SubscriptionTransaction) obj));
            Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            sb.append('\n');
            Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            i4 = i5;
        }
        sb.append("  ],");
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        sb.append("  nonSubscriptions=[");
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        int i6 = 0;
        for (Object obj2 : this.nonSubscriptions) {
            int i7 = i6 + 1;
            if (i6 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            sb.append("    #" + i6 + " " + ((NonSubscriptionTransaction) obj2));
            Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            sb.append('\n');
            Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            i6 = i7;
        }
        sb.append("  ],");
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        sb.append("  entitlements=[");
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        for (Object obj3 : this.entitlements) {
            int i8 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            sb.append("    #" + i3 + " " + ((Entitlement) obj3));
            Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            sb.append('\n');
            Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            i3 = i8;
        }
        sb.append("  ],");
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        sb.append(")");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public CustomerInfo(List<SubscriptionTransaction> subscriptions, List<NonSubscriptionTransaction> nonSubscriptions, String userId, List<Entitlement> entitlements, boolean z2) {
        Intrinsics.checkNotNullParameter(subscriptions, "subscriptions");
        Intrinsics.checkNotNullParameter(nonSubscriptions, "nonSubscriptions");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(entitlements, "entitlements");
        this.subscriptions = subscriptions;
        this.nonSubscriptions = nonSubscriptions;
        this.userId = userId;
        this.entitlements = entitlements;
        this.isPlaceholder = z2;
    }

    public /* synthetic */ CustomerInfo(List list, List list2, String str, List list3, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, list2, (i3 & 4) != 0 ? "" : str, list3, (i3 & 16) != 0 ? false : z2);
    }

    @Transient
    public static /* synthetic */ void getActiveSubscriptionProductIds$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getEntitlements$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getNonSubscriptions$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getSubscriptions$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getUserId$annotations() {
    }

    @SerialName
    public static /* synthetic */ void isPlaceholder$superwall_release$annotations() {
    }
}
