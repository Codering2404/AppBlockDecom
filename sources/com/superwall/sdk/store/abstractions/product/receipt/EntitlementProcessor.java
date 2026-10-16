package com.superwall.sdk.store.abstractions.product.receipt;

import com.superwall.sdk.models.customer.NonSubscriptionTransaction;
import com.superwall.sdk.models.customer.SubscriptionTransaction;
import com.superwall.sdk.models.entitlements.Entitlement;
import com.superwall.sdk.models.product.Store;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class EntitlementProcessor {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ProcessedTransactions {
        private final List<NonSubscriptionTransaction> nonSubscriptions;
        private final List<SubscriptionTransaction> subscriptions;

        public ProcessedTransactions(List<NonSubscriptionTransaction> nonSubscriptions, List<SubscriptionTransaction> subscriptions) {
            Intrinsics.checkNotNullParameter(nonSubscriptions, "nonSubscriptions");
            Intrinsics.checkNotNullParameter(subscriptions, "subscriptions");
            this.nonSubscriptions = nonSubscriptions;
            this.subscriptions = subscriptions;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ProcessedTransactions copy$default(ProcessedTransactions processedTransactions, List list, List list2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                list = processedTransactions.nonSubscriptions;
            }
            if ((i3 & 2) != 0) {
                list2 = processedTransactions.subscriptions;
            }
            return processedTransactions.copy(list, list2);
        }

        public final List<NonSubscriptionTransaction> component1() {
            return this.nonSubscriptions;
        }

        public final List<SubscriptionTransaction> component2() {
            return this.subscriptions;
        }

        public final ProcessedTransactions copy(List<NonSubscriptionTransaction> nonSubscriptions, List<SubscriptionTransaction> subscriptions) {
            Intrinsics.checkNotNullParameter(nonSubscriptions, "nonSubscriptions");
            Intrinsics.checkNotNullParameter(subscriptions, "subscriptions");
            return new ProcessedTransactions(nonSubscriptions, subscriptions);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ProcessedTransactions)) {
                return false;
            }
            ProcessedTransactions processedTransactions = (ProcessedTransactions) obj;
            return Intrinsics.areEqual(this.nonSubscriptions, processedTransactions.nonSubscriptions) && Intrinsics.areEqual(this.subscriptions, processedTransactions.subscriptions);
        }

        public final List<NonSubscriptionTransaction> getNonSubscriptions() {
            return this.nonSubscriptions;
        }

        public final List<SubscriptionTransaction> getSubscriptions() {
            return this.subscriptions;
        }

        public int hashCode() {
            return (this.nonSubscriptions.hashCode() * 31) + this.subscriptions.hashCode();
        }

        public String toString() {
            return "ProcessedTransactions(nonSubscriptions=" + this.nonSubscriptions + ", subscriptions=" + this.subscriptions + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EntitlementTransactionType.values().length];
            try {
                iArr[EntitlementTransactionType.NON_CONSUMABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EntitlementTransactionType.AUTO_RENEWABLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EntitlementTransactionType.NON_RENEWABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EntitlementTransactionType.CONSUMABLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x013a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.superwall.sdk.models.entitlements.Entitlement enrichEntitlement(java.lang.String r16, java.util.List<? extends com.superwall.sdk.store.abstractions.product.receipt.EntitlementTransaction> r17, com.superwall.sdk.models.entitlements.Entitlement r18, java.util.Set<java.lang.String> r19) {
        /*
            Method dump skipped, instruction units count: 484
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.store.abstractions.product.receipt.EntitlementProcessor.enrichEntitlement(java.lang.String, java.util.List, com.superwall.sdk.models.entitlements.Entitlement, java.util.Set):com.superwall.sdk.models.entitlements.Entitlement");
    }

    public final Map<String, List<Entitlement>> buildEntitlementsFromTransactions(Map<String, ? extends List<? extends EntitlementTransaction>> transactionsByEntitlement, Map<String, ? extends Set<Entitlement>> rawEntitlementsByProductId, Map<String, ? extends Set<String>> productIdsByEntitlementId) {
        Object next;
        Pair pairA;
        Intrinsics.checkNotNullParameter(transactionsByEntitlement, "transactionsByEntitlement");
        Intrinsics.checkNotNullParameter(rawEntitlementsByProductId, "rawEntitlementsByProductId");
        Intrinsics.checkNotNullParameter(productIdsByEntitlementId, "productIdsByEntitlementId");
        if (rawEntitlementsByProductId.isEmpty()) {
            return MapsKt.emptyMap();
        }
        ArrayList arrayList = new ArrayList(transactionsByEntitlement.size());
        for (Map.Entry<String, ? extends List<? extends EntitlementTransaction>> entry : transactionsByEntitlement.entrySet()) {
            String key = entry.getKey();
            List<? extends EntitlementTransaction> value = entry.getValue();
            Iterator it = CollectionsKt.flatten(rawEntitlementsByProductId.values()).iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (Intrinsics.areEqual(((Entitlement) next).getId(), key)) {
                    break;
                }
            }
            Entitlement entitlement = (Entitlement) next;
            if (entitlement == null) {
                pairA = null;
            } else {
                Set<String> setEmptySet = productIdsByEntitlementId.get(key);
                if (setEmptySet == null) {
                    setEmptySet = SetsKt.emptySet();
                }
                pairA = TuplesKt.a(key, enrichEntitlement(key, value, entitlement, setEmptySet));
            }
            arrayList.add(pairA);
        }
        Map map = MapsKt.toMap(CollectionsKt.filterNotNull(arrayList));
        ArrayList arrayList2 = new ArrayList(rawEntitlementsByProductId.size());
        for (Map.Entry<String, ? extends Set<Entitlement>> entry2 : rawEntitlementsByProductId.entrySet()) {
            String key2 = entry2.getKey();
            Set<Entitlement> value2 = entry2.getValue();
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(value2, 10));
            for (Entitlement entitlement2 : value2) {
                Entitlement entitlementCopy$default = (Entitlement) map.get(entitlement2.getId());
                if (entitlementCopy$default == null) {
                    Set<String> setEmptySet2 = productIdsByEntitlementId.get(entitlement2.getId());
                    if (setEmptySet2 == null) {
                        setEmptySet2 = SetsKt.emptySet();
                    }
                    entitlementCopy$default = Entitlement.copy$default(entitlement2, null, null, false, setEmptySet2, null, null, null, null, null, null, null, null, null, 8179, null);
                }
                arrayList3.add(entitlementCopy$default);
            }
            arrayList2.add(TuplesKt.a(key2, arrayList3));
        }
        return MapsKt.toMap(arrayList2);
    }

    public final ProcessedTransactions processTransactions(List<? extends EntitlementTransaction> transactions) {
        Intrinsics.checkNotNullParameter(transactions, "transactions");
        List<? extends EntitlementTransaction> list = transactions;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            EntitlementTransaction entitlementTransaction = (EntitlementTransaction) obj;
            if (entitlementTransaction.getProductType() == EntitlementTransactionType.CONSUMABLE || entitlementTransaction.getProductType() == EntitlementTransactionType.NON_CONSUMABLE) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        int size = arrayList.size();
        int i3 = 0;
        int i4 = 0;
        while (i4 < size) {
            Object obj2 = arrayList.get(i4);
            i4++;
            EntitlementTransaction entitlementTransaction2 = (EntitlementTransaction) obj2;
            arrayList2.add(new NonSubscriptionTransaction(entitlementTransaction2.getTransactionId(), entitlementTransaction2.getProductId(), entitlementTransaction2.getPurchaseDate(), entitlementTransaction2.getProductType() == EntitlementTransactionType.CONSUMABLE, entitlementTransaction2.isRevoked(), (Store) null, 32, (DefaultConstructorMarker) null));
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj3 : list) {
            EntitlementTransaction entitlementTransaction3 = (EntitlementTransaction) obj3;
            if (entitlementTransaction3.getProductType() == EntitlementTransactionType.AUTO_RENEWABLE || entitlementTransaction3.getProductType() == EntitlementTransactionType.NON_RENEWABLE) {
                arrayList3.add(obj3);
            }
        }
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
        int size2 = arrayList3.size();
        while (i3 < size2) {
            Object obj4 = arrayList3.get(i3);
            i3++;
            EntitlementTransaction entitlementTransaction4 = (EntitlementTransaction) obj4;
            arrayList4.add(new SubscriptionTransaction(entitlementTransaction4.getTransactionId(), entitlementTransaction4.getProductId(), entitlementTransaction4.getPurchaseDate(), entitlementTransaction4.getWillRenew(), entitlementTransaction4.isRevoked(), entitlementTransaction4.isInGracePeriod(), entitlementTransaction4.isInBillingRetryPeriod(), entitlementTransaction4.isActive(), entitlementTransaction4.getExpirationDate(), (Store) null, (LatestPeriodType) null, (String) null, 3584, (DefaultConstructorMarker) null));
        }
        return new ProcessedTransactions(arrayList2, arrayList4);
    }
}
