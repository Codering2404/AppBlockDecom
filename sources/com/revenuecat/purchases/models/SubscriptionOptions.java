package com.revenuecat.purchases.models;

import com.revenuecat.purchases.common.SharedConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

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
public final class SubscriptionOptions implements List<SubscriptionOption>, KMappedMarker {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String RC_IGNORE_OFFER_TAG = "rc-ignore-offer";
    private final List<SubscriptionOption> subscriptionOptions;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SubscriptionOptions(List<? extends SubscriptionOption> subscriptionOptions) {
        Intrinsics.checkNotNullParameter(subscriptionOptions, "subscriptionOptions");
        this.subscriptionOptions = subscriptionOptions;
    }

    private final SubscriptionOption findLongestFreeTrial(List<? extends SubscriptionOption> list) {
        Object next;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            SubscriptionOption subscriptionOption = (SubscriptionOption) it.next();
            PricingPhase freePhase = subscriptionOption.getFreePhase();
            Pair pair = freePhase != null ? new Pair(subscriptionOption, Integer.valueOf(billingPeriodToDays$purchases_defaultsBc8Release(freePhase.getBillingPeriod()))) : null;
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        Iterator it2 = arrayList.iterator();
        if (it2.hasNext()) {
            next = it2.next();
            if (it2.hasNext()) {
                int iIntValue = ((Number) ((Pair) next).f()).intValue();
                do {
                    Object next2 = it2.next();
                    int iIntValue2 = ((Number) ((Pair) next2).f()).intValue();
                    if (iIntValue < iIntValue2) {
                        next = next2;
                        iIntValue = iIntValue2;
                    }
                } while (it2.hasNext());
            }
        } else {
            next = null;
        }
        Pair pair2 = (Pair) next;
        if (pair2 != null) {
            return (SubscriptionOption) pair2.e();
        }
        return null;
    }

    private final SubscriptionOption findLowestNonFreeOffer(List<? extends SubscriptionOption> list) {
        Object next;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            SubscriptionOption subscriptionOption = (SubscriptionOption) it.next();
            PricingPhase introPhase = subscriptionOption.getIntroPhase();
            Pair pair = introPhase != null ? new Pair(subscriptionOption, Long.valueOf(introPhase.getPrice().getAmountMicros())) : null;
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        Iterator it2 = arrayList.iterator();
        if (it2.hasNext()) {
            next = it2.next();
            if (it2.hasNext()) {
                long jLongValue = ((Number) ((Pair) next).f()).longValue();
                do {
                    Object next2 = it2.next();
                    long jLongValue2 = ((Number) ((Pair) next2).f()).longValue();
                    if (jLongValue > jLongValue2) {
                        next = next2;
                        jLongValue = jLongValue2;
                    }
                } while (it2.hasNext());
            }
        } else {
            next = null;
        }
        Pair pair2 = (Pair) next;
        if (pair2 != null) {
            return (SubscriptionOption) pair2.e();
        }
        return null;
    }

    /* JADX INFO: renamed from: add, reason: avoid collision after fix types in other method */
    public void add2(int i3, SubscriptionOption subscriptionOption) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i3, Collection<? extends SubscriptionOption> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void addFirst(SubscriptionOption subscriptionOption) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void addLast(SubscriptionOption subscriptionOption) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final int billingPeriodToDays$purchases_defaultsBc8Release(Period period) {
        Intrinsics.checkNotNullParameter(period, "period");
        Integer num = (Integer) SubscriptionOptionsKt.DAYS_IN_UNIT.get(period.getUnit());
        return period.getValue() * (num != null ? num.intValue() : 0);
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean contains(SubscriptionOption element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return this.subscriptionOptions.contains(element);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.subscriptionOptions.containsAll(elements);
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(SubscriptionOptions.class, obj != null ? obj.getClass() : null)) {
            return (obj instanceof SubscriptionOptions ? (SubscriptionOptions) obj : null) != null && Intrinsics.areEqual(CollectionsKt.listOf(this.subscriptionOptions), CollectionsKt.listOf(((SubscriptionOptions) obj).subscriptionOptions));
        }
        return false;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.List
    public SubscriptionOption get(int i3) {
        return this.subscriptionOptions.get(i3);
    }

    public final SubscriptionOption getBasePlan() {
        SubscriptionOption next;
        Iterator<SubscriptionOption> it = iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (next.isBasePlan()) {
                break;
            }
        }
        return next;
    }

    public final SubscriptionOption getDefaultOffer() {
        SubscriptionOption next;
        Iterator<SubscriptionOption> it = iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (next.isBasePlan()) {
                break;
            }
        }
        SubscriptionOption subscriptionOption = next;
        if (subscriptionOption == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (SubscriptionOption subscriptionOption2 : this) {
            if (!subscriptionOption2.isBasePlan()) {
                arrayList.add(subscriptionOption2);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i3 = 0;
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList.get(i4);
            i4++;
            if (!((SubscriptionOption) obj).getTags().contains(RC_IGNORE_OFFER_TAG)) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        int size2 = arrayList2.size();
        while (i3 < size2) {
            Object obj2 = arrayList2.get(i3);
            i3++;
            if (!((SubscriptionOption) obj2).getTags().contains(SharedConstants.RC_CUSTOMER_CENTER_TAG)) {
                arrayList3.add(obj2);
            }
        }
        SubscriptionOption subscriptionOptionFindLongestFreeTrial = findLongestFreeTrial(arrayList3);
        if (subscriptionOptionFindLongestFreeTrial != null) {
            return subscriptionOptionFindLongestFreeTrial;
        }
        SubscriptionOption subscriptionOptionFindLowestNonFreeOffer = findLowestNonFreeOffer(arrayList3);
        return subscriptionOptionFindLowestNonFreeOffer == null ? subscriptionOption : subscriptionOptionFindLowestNonFreeOffer;
    }

    public final SubscriptionOption getFreeTrial() {
        SubscriptionOption next;
        Iterator<SubscriptionOption> it = iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (next.getFreePhase() != null) {
                break;
            }
        }
        return next;
    }

    public final SubscriptionOption getIntroOffer() {
        SubscriptionOption next;
        Iterator<SubscriptionOption> it = iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (next.getIntroPhase() != null) {
                break;
            }
        }
        return next;
    }

    public int getSize() {
        return this.subscriptionOptions.size();
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return CollectionsKt.listOf(this.subscriptionOptions).hashCode();
    }

    public int indexOf(SubscriptionOption element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return this.subscriptionOptions.indexOf(element);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.subscriptionOptions.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<SubscriptionOption> iterator() {
        return this.subscriptionOptions.iterator();
    }

    public int lastIndexOf(SubscriptionOption element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return this.subscriptionOptions.lastIndexOf(element);
    }

    @Override // java.util.List
    public ListIterator<SubscriptionOption> listIterator() {
        return this.subscriptionOptions.listIterator();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.List
    public SubscriptionOption remove(int i3) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public SubscriptionOption removeFirst() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public SubscriptionOption removeLast() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public void replaceAll(UnaryOperator<SubscriptionOption> unaryOperator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: renamed from: set, reason: avoid collision after fix types in other method */
    public SubscriptionOption set2(int i3, SubscriptionOption subscriptionOption) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.List
    public void sort(Comparator<? super SubscriptionOption> comparator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public List<SubscriptionOption> subList(int i3, int i4) {
        return this.subscriptionOptions.subList(i3, i4);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.a(this);
    }

    public final List<SubscriptionOption> withTag(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        ArrayList arrayList = new ArrayList();
        for (SubscriptionOption subscriptionOption : this) {
            if (subscriptionOption.getTags().contains(tag)) {
                arrayList.add(subscriptionOption);
            }
        }
        return arrayList;
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ void add(int i3, SubscriptionOption subscriptionOption) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends SubscriptionOption> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ void addFirst(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ void addLast(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof SubscriptionOption) {
            return contains((SubscriptionOption) obj);
        }
        return false;
    }

    @Override // java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof SubscriptionOption) {
            return indexOf((SubscriptionOption) obj);
        }
        return -1;
    }

    @Override // java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof SubscriptionOption) {
            return lastIndexOf((SubscriptionOption) obj);
        }
        return -1;
    }

    @Override // java.util.List
    public ListIterator<SubscriptionOption> listIterator(int i3) {
        return this.subscriptionOptions.listIterator(i3);
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ SubscriptionOption remove(int i3) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: renamed from: removeFirst, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m570removeFirst() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: renamed from: removeLast, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m571removeLast() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ SubscriptionOption set(int i3, SubscriptionOption subscriptionOption) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return (T[]) CollectionToArray.b(this, array);
    }

    public boolean add(SubscriptionOption subscriptionOption) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public static /* synthetic */ void getDefaultOffer$annotations() {
    }
}
