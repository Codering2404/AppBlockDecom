package com.superwall.sdk.models.customer;

import com.superwall.sdk.models.entitlements.Entitlement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
public final class CustomerInfoMergingKt {
    public static final CustomerInfo merge(CustomerInfo customerInfo, CustomerInfo other) {
        Intrinsics.checkNotNullParameter(customerInfo, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        List listPlus = CollectionsKt.plus((Collection) customerInfo.getSubscriptions(), (Iterable) other.getSubscriptions());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : listPlus) {
            String transactionId = ((SubscriptionTransaction) obj).getTransactionId();
            Object arrayList = linkedHashMap.get(transactionId);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(transactionId, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        ArrayList arrayList2 = new ArrayList(linkedHashMap.size());
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            List list = (List) ((Map.Entry) it.next()).getValue();
            SubscriptionTransaction subscriptionTransaction = (SubscriptionTransaction) CollectionsKt.maxWithOrNull(list, SubscriptionTransactionComparator.INSTANCE);
            if (subscriptionTransaction == null) {
                subscriptionTransaction = (SubscriptionTransaction) CollectionsKt.first(list);
            }
            arrayList2.add(subscriptionTransaction);
        }
        List listSortedWith = CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: com.superwall.sdk.models.customer.CustomerInfoMergingKt$merge$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t2, T t3) {
                return ComparisonsKt.d(((SubscriptionTransaction) t2).getPurchaseDate(), ((SubscriptionTransaction) t3).getPurchaseDate());
            }
        });
        List listPlus2 = CollectionsKt.plus((Collection) customerInfo.getNonSubscriptions(), (Iterable) other.getNonSubscriptions());
        HashSet hashSet = new HashSet();
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : listPlus2) {
            if (hashSet.add(((NonSubscriptionTransaction) obj2).getTransactionId())) {
                arrayList3.add(obj2);
            }
        }
        List listSortedWith2 = CollectionsKt.sortedWith(arrayList3, new Comparator() { // from class: com.superwall.sdk.models.customer.CustomerInfoMergingKt$merge$$inlined$sortedBy$2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t2, T t3) {
                return ComparisonsKt.d(((NonSubscriptionTransaction) t2).getPurchaseDate(), ((NonSubscriptionTransaction) t3).getPurchaseDate());
            }
        });
        List<Entitlement> listMergeEntitlements = mergeEntitlements(customerInfo.getEntitlements(), other.getEntitlements());
        return new CustomerInfo(listSortedWith, listSortedWith2, !StringsKt.p0(customerInfo.getUserId()) ? customerInfo.getUserId() : !StringsKt.p0(other.getUserId()) ? other.getUserId() : "", listMergeEntitlements, listSortedWith.isEmpty() && listSortedWith2.isEmpty() && listMergeEntitlements.isEmpty());
    }

    public static final List<Entitlement> mergeEntitlements(Collection<Entitlement> first, Collection<Entitlement> second) {
        Intrinsics.checkNotNullParameter(first, "first");
        Intrinsics.checkNotNullParameter(second, "second");
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        listCreateListBuilder.addAll(first);
        listCreateListBuilder.addAll(second);
        return mergeEntitlementsPrioritized(CollectionsKt.build(listCreateListBuilder));
    }

    public static final List<Entitlement> mergeEntitlementsPrioritized(List<Entitlement> entitlements) {
        Intrinsics.checkNotNullParameter(entitlements, "entitlements");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : entitlements) {
            String id = ((Entitlement) obj).getId();
            Object arrayList = linkedHashMap.get(id);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(id, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        ArrayList arrayList2 = new ArrayList(linkedHashMap.size());
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            List list = (List) ((Map.Entry) it.next()).getValue();
            List list2 = list;
            Entitlement entitlement = (Entitlement) CollectionsKt.maxWithOrNull(list2, EntitlementPriorityComparator.INSTANCE);
            if (entitlement == null) {
                entitlement = (Entitlement) CollectionsKt.first(list);
            }
            Entitlement entitlementCopy$default = entitlement;
            ArrayList arrayList3 = new ArrayList();
            Iterator it2 = list2.iterator();
            while (it2.hasNext()) {
                CollectionsKt.addAll(arrayList3, ((Entitlement) it2.next()).getProductIds());
            }
            Set set = CollectionsKt.toSet(arrayList3);
            if (!Intrinsics.areEqual(set, entitlementCopy$default.getProductIds())) {
                entitlementCopy$default = Entitlement.copy$default(entitlementCopy$default, null, null, false, set, null, null, null, null, null, null, null, null, null, 8183, null);
            }
            arrayList2.add(entitlementCopy$default);
        }
        return arrayList2;
    }

    public static final List<Entitlement> plus(Collection<Entitlement> collection, Collection<Entitlement> second) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(second, "second");
        return mergeEntitlements(collection, second);
    }

    public static final Set<Entitlement> toSet(List<Entitlement> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Entitlement[] entitlementArr = (Entitlement[]) mergeEntitlementsPrioritized(list).toArray(new Entitlement[0]);
        return SetsKt.setOf(Arrays.copyOf(entitlementArr, entitlementArr.length));
    }
}
