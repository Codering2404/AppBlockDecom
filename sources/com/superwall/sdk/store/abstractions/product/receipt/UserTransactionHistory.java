package com.superwall.sdk.store.abstractions.product.receipt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

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
public final class UserTransactionHistory {
    private final Map<String, StoredEntitlementTransaction> transactions;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {new LinkedHashMapSerializer(StringSerializer.f142891a, StoredEntitlementTransaction$$serializer.INSTANCE)};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<UserTransactionHistory> serializer() {
            return UserTransactionHistory$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UserTransactionHistory() {
        this((Map) null, 1, (DefaultConstructorMarker) (0 == true ? 1 : 0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UserTransactionHistory copy$default(UserTransactionHistory userTransactionHistory, Map map, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            map = userTransactionHistory.transactions;
        }
        return userTransactionHistory.copy(map);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(UserTransactionHistory userTransactionHistory, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        if (!compositeEncoder.z(serialDescriptor, 0) && Intrinsics.areEqual(userTransactionHistory.transactions, MapsKt.emptyMap())) {
            return;
        }
        compositeEncoder.C(serialDescriptor, 0, kSerializerArr[0], userTransactionHistory.transactions);
    }

    public final List<StoredEntitlementTransaction> activeTransactions() {
        Collection<StoredEntitlementTransaction> collectionValues = this.transactions.values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (((StoredEntitlementTransaction) obj).isActive()) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.superwall.sdk.store.abstractions.product.receipt.UserTransactionHistory$activeTransactions$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t2, T t3) {
                return ComparisonsKt.d(((StoredEntitlementTransaction) t3).getPurchaseDate(), ((StoredEntitlementTransaction) t2).getPurchaseDate());
            }
        });
    }

    public final List<StoredEntitlementTransaction> allTransactions() {
        return CollectionsKt.sortedWith(this.transactions.values(), new Comparator() { // from class: com.superwall.sdk.store.abstractions.product.receipt.UserTransactionHistory$allTransactions$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t2, T t3) {
                return ComparisonsKt.d(((StoredEntitlementTransaction) t3).getPurchaseDate(), ((StoredEntitlementTransaction) t2).getPurchaseDate());
            }
        });
    }

    public final Map<String, StoredEntitlementTransaction> component1() {
        return this.transactions;
    }

    public final UserTransactionHistory copy(Map<String, StoredEntitlementTransaction> transactions) {
        Intrinsics.checkNotNullParameter(transactions, "transactions");
        return new UserTransactionHistory(transactions);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof UserTransactionHistory) && Intrinsics.areEqual(this.transactions, ((UserTransactionHistory) obj).transactions);
    }

    public final Map<String, StoredEntitlementTransaction> getTransactions() {
        return this.transactions;
    }

    public int hashCode() {
        return this.transactions.hashCode();
    }

    public final UserTransactionHistory mergeWith(List<? extends EntitlementTransaction> currentTransactions) {
        Intrinsics.checkNotNullParameter(currentTransactions, "currentTransactions");
        List<? extends EntitlementTransaction> list = currentTransactions;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
        for (Object obj : list) {
            linkedHashMap.put(((EntitlementTransaction) obj).getTransactionId(), obj);
        }
        Map mutableMap = MapsKt.toMutableMap(this.transactions);
        for (Map.Entry<String, StoredEntitlementTransaction> entry : this.transactions.entrySet()) {
            String key = entry.getKey();
            StoredEntitlementTransaction value = entry.getValue();
            EntitlementTransaction entitlementTransaction = (EntitlementTransaction) linkedHashMap.get(key);
            if (entitlementTransaction != null) {
                mutableMap.put(key, StoredEntitlementTransaction.Companion.from(entitlementTransaction));
            } else {
                mutableMap.put(key, StoredEntitlementTransaction.Companion.withUpdatedActiveStatus(value, false));
            }
        }
        for (EntitlementTransaction entitlementTransaction2 : list) {
            if (!mutableMap.containsKey(entitlementTransaction2.getTransactionId())) {
                mutableMap.put(entitlementTransaction2.getTransactionId(), StoredEntitlementTransaction.Companion.from(entitlementTransaction2));
            }
        }
        return new UserTransactionHistory(mutableMap);
    }

    public String toString() {
        return "UserTransactionHistory(transactions=" + this.transactions + ")";
    }

    public /* synthetic */ UserTransactionHistory(int i3, Map map, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i3 & 1) == 0) {
            this.transactions = MapsKt.emptyMap();
        } else {
            this.transactions = map;
        }
    }

    public UserTransactionHistory(Map<String, StoredEntitlementTransaction> transactions) {
        Intrinsics.checkNotNullParameter(transactions, "transactions");
        this.transactions = transactions;
    }

    public /* synthetic */ UserTransactionHistory(Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? MapsKt.emptyMap() : map);
    }

    @SerialName
    public static /* synthetic */ void getTransactions$annotations() {
    }
}
