package com.superwall.sdk.store;

import com.revenuecat.purchases.common.Constants;
import com.superwall.sdk.billing.DecomposedProductIds;
import com.superwall.sdk.models.customer.CustomerInfo;
import com.superwall.sdk.models.customer.CustomerInfoMergingKt;
import com.superwall.sdk.models.entitlements.Entitlement;
import com.superwall.sdk.models.entitlements.SubscriptionStatus;
import com.superwall.sdk.models.internal.WebRedemptionResponse;
import com.superwall.sdk.storage.LatestRedemptionResponse;
import com.superwall.sdk.storage.Storage;
import com.superwall.sdk.storage.StoredEntitlementsByProductId;
import com.superwall.sdk.storage.StoredSubscriptionStatus;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

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
public final class Entitlements {
    private final Set<Entitlement> _activeDeviceEntitlements;
    private final Set<Entitlement> _all;
    private final Set<Entitlement> _inactive;
    private final MutableStateFlow<SubscriptionStatus> _status;
    private Set<Entitlement> backingActive;
    private final ConcurrentHashMap<String, Set<Entitlement>> entitlementsByProduct;
    private final CoroutineScope scope;
    private final Storage storage;

    /* JADX INFO: renamed from: com.superwall.sdk.store.Entitlements$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.store.Entitlements$3", f = "Entitlements.kt", l = {118}, m = "invokeSuspend")
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return Entitlements.this.new AnonymousClass3(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                StateFlow<SubscriptionStatus> status = Entitlements.this.getStatus();
                final Entitlements entitlements = Entitlements.this;
                FlowCollector flowCollector = new FlowCollector() { // from class: com.superwall.sdk.store.Entitlements.3.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((SubscriptionStatus) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(SubscriptionStatus subscriptionStatus, Continuation<? super Unit> continuation) {
                        entitlements.storage.write(StoredSubscriptionStatus.INSTANCE, subscriptionStatus);
                        return Unit.f139807a;
                    }
                };
                this.label = 1;
                if (status.collect(flowCollector, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            throw new KotlinNothingValueException();
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    public Entitlements(Storage storage, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.storage = storage;
        this.scope = scope;
        this.entitlementsByProduct = new ConcurrentHashMap<>();
        this._status = StateFlowKt.a(SubscriptionStatus.Unknown.INSTANCE);
        this.backingActive = new LinkedHashSet();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this._all = linkedHashSet;
        this._activeDeviceEntitlements = new LinkedHashSet();
        this._inactive = CollectionsKt.toMutableSet(CollectionsKt.subtract(linkedHashSet, this.backingActive));
        try {
            SubscriptionStatus subscriptionStatus = (SubscriptionStatus) storage.read(StoredSubscriptionStatus.INSTANCE);
            if (subscriptionStatus != null) {
                setSubscriptionStatus(subscriptionStatus);
            }
        } catch (ClassCastException unused) {
            this.storage.delete(StoredSubscriptionStatus.INSTANCE);
            setSubscriptionStatus(SubscriptionStatus.Unknown.INSTANCE);
        }
        try {
            Map<? extends String, ? extends Set<Entitlement>> map = (Map) this.storage.read(StoredEntitlementsByProductId.INSTANCE);
            if (map != null) {
                this.entitlementsByProduct.putAll(map);
            }
        } catch (ClassCastException unused2) {
            this.storage.delete(StoredEntitlementsByProductId.INSTANCE);
        }
        BuildersKt__Builders_commonKt.d(this.scope, null, null, new AnonymousClass3(null), 3, null);
    }

    private final Set<Entitlement> checkFor(List<String> list, boolean z2) {
        Set<Entitlement> set;
        boolean zA0;
        Object obj = null;
        if (list.isEmpty()) {
            return null;
        }
        String str = (String) CollectionsKt.first((List) list);
        List<String> listDrop = CollectionsKt.drop(list, 1);
        Set<Map.Entry<String, Set<Entitlement>>> setEntrySet = this.entitlementsByProduct.entrySet();
        Intrinsics.checkNotNullExpressionValue(setEntrySet, "<get-entries>(...)");
        Iterator<T> it = setEntrySet.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            Map.Entry entry = (Map.Entry) next;
            boolean z3 = false;
            if (z2) {
                zA0 = Intrinsics.areEqual(entry.getKey(), str);
            } else {
                Object key = entry.getKey();
                Intrinsics.checkNotNullExpressionValue(key, "<get-key>(...)");
                zA0 = StringsKt.a0((CharSequence) key, str, false, 2, null);
            }
            if (zA0) {
                Object value = entry.getValue();
                Intrinsics.checkNotNullExpressionValue(value, "<get-value>(...)");
                if (!((Collection) value).isEmpty()) {
                    z3 = true;
                }
            }
            if (z3) {
                obj = next;
                break;
            }
        }
        Map.Entry entry2 = (Map.Entry) obj;
        return (entry2 == null || (set = (Set) entry2.getValue()) == null) ? checkFor(listDrop, z2) : set;
    }

    static /* synthetic */ Set checkFor$default(Entitlements entitlements, List list, boolean z2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z2 = true;
        }
        return entitlements.checkFor(list, z2);
    }

    public final void addEntitlementsByProductId$superwall_release(Map<String, ? extends Set<Entitlement>> idToEntitlements) {
        Intrinsics.checkNotNullParameter(idToEntitlements, "idToEntitlements");
        ConcurrentHashMap<String, Set<Entitlement>> concurrentHashMap = this.entitlementsByProduct;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(idToEntitlements.size()));
        Iterator<T> it = idToEntitlements.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), CollectionsKt.toSet((Set) entry.getValue()));
        }
        concurrentHashMap.putAll(MapsKt.toMap(linkedHashMap));
        this._all.clear();
        Set<Entitlement> set = this._all;
        Collection<Set<Entitlement>> collectionValues = this.entitlementsByProduct.values();
        Intrinsics.checkNotNullExpressionValue(collectionValues, "<get-values>(...)");
        set.addAll(CollectionsKt.flatten(collectionValues));
        this.storage.write(StoredEntitlementsByProductId.INSTANCE, this.entitlementsByProduct);
    }

    public final Set<Entitlement> byProductId$superwall_release(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        DecomposedProductIds decomposedProductIdsFrom = DecomposedProductIds.Companion.from(id);
        String fullId = decomposedProductIdsFrom.getFullId();
        String subscriptionId = decomposedProductIdsFrom.getSubscriptionId();
        String basePlanId = decomposedProductIdsFrom.getBasePlanId();
        if (basePlanId == null) {
            basePlanId = "";
        }
        String specificId = decomposedProductIdsFrom.getOfferType().getSpecificId();
        if (specificId == null) {
            specificId = "";
        }
        String str = subscriptionId + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + basePlanId + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + specificId;
        String subscriptionId2 = decomposedProductIdsFrom.getSubscriptionId();
        String basePlanId2 = decomposedProductIdsFrom.getBasePlanId();
        if (basePlanId2 == null) {
            basePlanId2 = "";
        }
        Set<Entitlement> setCheckFor$default = checkFor$default(this, CollectionsKt.listOf((Object[]) new String[]{fullId, str, subscriptionId2 + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + basePlanId2}), false, 2, null);
        if (setCheckFor$default != null) {
            return setCheckFor$default;
        }
        String subscriptionId3 = decomposedProductIdsFrom.getSubscriptionId();
        String basePlanId3 = decomposedProductIdsFrom.getBasePlanId();
        Set<Entitlement> setCheckFor = checkFor(CollectionsKt.listOf((Object[]) new String[]{subscriptionId3 + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + (basePlanId3 != null ? basePlanId3 : "") + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, decomposedProductIdsFrom.getSubscriptionId()}), false);
        return setCheckFor == null ? SetsKt.emptySet() : setCheckFor;
    }

    public final Set<Entitlement> byProductIds(Set<String> ids) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = ids.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(arrayList, byProductId$superwall_release((String) it.next()));
        }
        return CustomerInfoMergingKt.toSet(arrayList);
    }

    public final Set<Entitlement> getActive() {
        return CustomerInfoMergingKt.toSet(CustomerInfoMergingKt.mergeEntitlementsPrioritized(CollectionsKt.toList(SetsKt.plus(SetsKt.plus((Set) this.backingActive, (Iterable) this._activeDeviceEntitlements), (Iterable) getWeb()))));
    }

    public final Set<Entitlement> getActiveDeviceEntitlements$superwall_release() {
        return this._activeDeviceEntitlements;
    }

    public final Set<Entitlement> getAll() {
        Set set = CollectionsKt.toSet(this._all);
        Collection<Set<Entitlement>> collectionValues = this.entitlementsByProduct.values();
        Intrinsics.checkNotNullExpressionValue(collectionValues, "<get-values>(...)");
        return SetsKt.plus(SetsKt.plus(set, (Iterable) CollectionsKt.flatten(collectionValues)), (Iterable) CollectionsKt.toSet(getWeb()));
    }

    public final ConcurrentHashMap<String, Set<Entitlement>> getEntitlementsByProduct$superwall_release() {
        return this.entitlementsByProduct;
    }

    public final Map<String, Set<Entitlement>> getEntitlementsByProductId() {
        return MapsKt.toMap(this.entitlementsByProduct);
    }

    public final Set<Entitlement> getInactive() {
        return SetsKt.plus(CollectionsKt.toSet(this._inactive), (Iterable) SetsKt.minus((Set) getAll(), (Iterable) getActive()));
    }

    public final StateFlow<SubscriptionStatus> getStatus() {
        return FlowKt.c(this._status);
    }

    public final Set<Entitlement> getWeb() {
        CustomerInfo customerInfo;
        List<Entitlement> entitlements;
        WebRedemptionResponse webRedemptionResponse = (WebRedemptionResponse) this.storage.read(LatestRedemptionResponse.INSTANCE);
        if (webRedemptionResponse != null && (customerInfo = webRedemptionResponse.getCustomerInfo()) != null && (entitlements = customerInfo.getEntitlements()) != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : entitlements) {
                if (((Entitlement) obj).isActive()) {
                    arrayList.add(obj);
                }
            }
            Set<Entitlement> set = CustomerInfoMergingKt.toSet(arrayList);
            if (set != null) {
                return set;
            }
        }
        return SetsKt.emptySet();
    }

    public final void setActiveDeviceEntitlements$superwall_release(Set<Entitlement> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this._activeDeviceEntitlements.clear();
        this._activeDeviceEntitlements.addAll(value);
    }

    public final void setSubscriptionStatus(SubscriptionStatus value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (!(value instanceof SubscriptionStatus.Active)) {
            if (value instanceof SubscriptionStatus.Inactive) {
                this._activeDeviceEntitlements.clear();
                this.backingActive.clear();
                this._inactive.clear();
                this._status.setValue(value);
                return;
            }
            if (!(value instanceof SubscriptionStatus.Unknown)) {
                throw new NoWhenBranchMatchedException();
            }
            this.backingActive.clear();
            this._activeDeviceEntitlements.clear();
            this._inactive.clear();
            this._status.setValue(value);
            return;
        }
        SubscriptionStatus.Active active = (SubscriptionStatus.Active) value;
        if (active.getEntitlements().isEmpty()) {
            setSubscriptionStatus(SubscriptionStatus.Inactive.INSTANCE);
            return;
        }
        Set<Entitlement> set = CustomerInfoMergingKt.toSet(CollectionsKt.toList(active.getEntitlements()));
        Set<Entitlement> set2 = this.backingActive;
        ArrayList arrayList = new ArrayList();
        for (Object obj : set) {
            if (((Entitlement) obj).isActive()) {
                arrayList.add(obj);
            }
        }
        set2.addAll(arrayList);
        Set<Entitlement> set3 = set;
        this._all.addAll(set3);
        this._inactive.removeAll(set3);
        this._status.setValue(value);
    }

    public /* synthetic */ Entitlements(Storage storage, CoroutineScope coroutineScope, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(storage, (i3 & 2) != 0 ? CoroutineScopeKt.a(Dispatchers.a()) : coroutineScope);
    }
}
