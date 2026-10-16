package kotlin.collections;

import com.bumptech.glide.load.data.Bwyd.SbbqvQlxi;
import com.google.android.gms.ads_identifier.mrU.pMpIcGE;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt$compareBy$2;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt$compareByDescending$1;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.OBeo.vgWWUoTKYyuC;

/* JADX INFO: Access modifiers changed from: package-private */
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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public class CollectionsKt___CollectionsKt extends CollectionsKt___CollectionsJvmKt {
    public static final <T> boolean all(Iterable<? extends T> iterable, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return true;
        }
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (!((Boolean) predicate.invoke(it.next())).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <T> boolean any(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return iterable instanceof Collection ? !((Collection) iterable).isEmpty() : iterable.iterator().hasNext();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> Iterable<T> asIterable(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return iterable;
    }

    public static <T> Sequence<T> asSequence(final Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return new Sequence<T>() { // from class: kotlin.collections.CollectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1
            @Override // kotlin.sequences.Sequence
            public Iterator<T> iterator() {
                return iterable.iterator();
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K, V> Map<K, V> associate(Iterable<? extends T> iterable, Function1<? super T, ? extends Pair<? extends K, ? extends V>> transform) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10)), 16));
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) transform.invoke(it.next());
            linkedHashMap.put(pair.e(), pair.f());
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K> Map<K, T> associateBy(Iterable<? extends T> iterable, Function1<? super T, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10)), 16));
        for (T t2 : iterable) {
            linkedHashMap.put(keySelector.invoke(t2), t2);
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K, M extends Map<? super K, ? super T>> M associateByTo(Iterable<? extends T> iterable, M destination, Function1<? super T, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (T t2 : iterable) {
            destination.put(keySelector.invoke(t2), t2);
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K, V, M extends Map<? super K, ? super V>> M associateTo(Iterable<? extends T> iterable, M destination, Function1<? super T, ? extends Pair<? extends K, ? extends V>> transform) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) transform.invoke(it.next());
            destination.put(pair.e(), pair.f());
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> associateWith(Iterable<? extends K> iterable, Function1<? super K, ? extends V> valueSelector) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10)), 16));
        for (K k3 : iterable) {
            linkedHashMap.put(k3, valueSelector.invoke(k3));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, ? super V>> M associateWithTo(Iterable<? extends K> iterable, M destination, Function1<? super K, ? extends V> valueSelector) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        for (K k3 : iterable) {
            destination.put(k3, valueSelector.invoke(k3));
        }
        return destination;
    }

    public static final double averageOfByte(Iterable<Byte> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<Byte> it = iterable.iterator();
        double dByteValue = 0.0d;
        int i3 = 0;
        while (it.hasNext()) {
            dByteValue += (double) it.next().byteValue();
            i3++;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwCountOverflow();
            }
        }
        if (i3 == 0) {
            return Double.NaN;
        }
        return dByteValue / ((double) i3);
    }

    public static final double averageOfDouble(Iterable<Double> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<Double> it = iterable.iterator();
        double dDoubleValue = 0.0d;
        int i3 = 0;
        while (it.hasNext()) {
            dDoubleValue += it.next().doubleValue();
            i3++;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwCountOverflow();
            }
        }
        if (i3 == 0) {
            return Double.NaN;
        }
        return dDoubleValue / ((double) i3);
    }

    public static double averageOfFloat(Iterable<Float> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<Float> it = iterable.iterator();
        double dFloatValue = 0.0d;
        int i3 = 0;
        while (it.hasNext()) {
            dFloatValue += (double) it.next().floatValue();
            i3++;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwCountOverflow();
            }
        }
        if (i3 == 0) {
            return Double.NaN;
        }
        return dFloatValue / ((double) i3);
    }

    public static final double averageOfInt(Iterable<Integer> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<Integer> it = iterable.iterator();
        double dIntValue = 0.0d;
        int i3 = 0;
        while (it.hasNext()) {
            dIntValue += (double) it.next().intValue();
            i3++;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwCountOverflow();
            }
        }
        if (i3 == 0) {
            return Double.NaN;
        }
        return dIntValue / ((double) i3);
    }

    public static double averageOfLong(Iterable<Long> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<Long> it = iterable.iterator();
        double dLongValue = 0.0d;
        int i3 = 0;
        while (it.hasNext()) {
            dLongValue += it.next().longValue();
            i3++;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwCountOverflow();
            }
        }
        if (i3 == 0) {
            return Double.NaN;
        }
        return dLongValue / ((double) i3);
    }

    public static final double averageOfShort(Iterable<Short> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<Short> it = iterable.iterator();
        double dShortValue = 0.0d;
        int i3 = 0;
        while (it.hasNext()) {
            dShortValue += (double) it.next().shortValue();
            i3++;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwCountOverflow();
            }
        }
        if (i3 == 0) {
            return Double.NaN;
        }
        return dShortValue / ((double) i3);
    }

    public static <T> List<List<T>> chunked(Iterable<? extends T> iterable, int i3) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return windowed(iterable, i3, i3, true);
    }

    private static final <T> T component1(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return list.get(0);
    }

    private static final <T> T component2(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return list.get(1);
    }

    private static final <T> T component3(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return list.get(2);
    }

    private static final <T> T component4(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return list.get(3);
    }

    private static final <T> T component5(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return list.get(4);
    }

    public static <T> boolean contains(Iterable<? extends T> iterable, T t2) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).contains(t2) : indexOf(iterable, t2) >= 0;
    }

    public static <T> int count(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        Iterator<? extends T> it = iterable.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            it.next();
            i3++;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwCountOverflow();
            }
        }
        return i3;
    }

    public static <T> List<T> distinct(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return toList(toMutableSet(iterable));
    }

    public static final <T, K> List<T> distinctBy(Iterable<? extends T> iterable, Function1<? super T, ? extends K> selector) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (T t2 : iterable) {
            if (hashSet.add(selector.invoke(t2))) {
                arrayList.add(t2);
            }
        }
        return arrayList;
    }

    public static <T> List<T> drop(Iterable<? extends T> iterable, int i3) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (i3 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
        }
        if (i3 == 0) {
            return toList(iterable);
        }
        if (iterable instanceof Collection) {
            int size = ((Collection) iterable).size() - i3;
            if (size <= 0) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
            if (size == 1) {
                return CollectionsKt__CollectionsJVMKt.listOf(last(iterable));
            }
            arrayList = new ArrayList(size);
            if (iterable instanceof List) {
                if (iterable instanceof RandomAccess) {
                    List list = (List) iterable;
                    int size2 = list.size();
                    while (i3 < size2) {
                        arrayList.add(list.get(i3));
                        i3++;
                    }
                } else {
                    ListIterator listIterator = ((List) iterable).listIterator(i3);
                    while (listIterator.hasNext()) {
                        arrayList.add(listIterator.next());
                    }
                }
                return arrayList;
            }
        } else {
            arrayList = new ArrayList();
        }
        int i4 = 0;
        for (T t2 : iterable) {
            if (i4 >= i3) {
                arrayList.add(t2);
            } else {
                i4++;
            }
        }
        return CollectionsKt__CollectionsKt.optimizeReadOnlyList(arrayList);
    }

    public static <T> List<T> dropLast(List<? extends T> list, int i3) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (i3 >= 0) {
            return take(list, RangesKt.f(list.size() - i3, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
    }

    public static final <T> List<T> dropLastWhile(List<? extends T> list, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        if (!list.isEmpty()) {
            ListIterator<? extends T> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                if (!((Boolean) predicate.invoke(listIterator.previous())).booleanValue()) {
                    return take(list, listIterator.nextIndex() + 1);
                }
            }
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    public static final <T> List<T> dropWhile(Iterable<? extends T> iterable, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z2 = false;
        for (T t2 : iterable) {
            if (z2) {
                arrayList.add(t2);
            } else if (!((Boolean) predicate.invoke(t2)).booleanValue()) {
                arrayList.add(t2);
                z2 = true;
            }
        }
        return arrayList;
    }

    public static final <T> T elementAt(Iterable<? extends T> iterable, final int i3) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return iterable instanceof List ? (T) ((List) iterable).get(i3) : (T) elementAtOrElse(iterable, i3, new Function1() { // from class: kotlin.collections.m
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CollectionsKt___CollectionsKt.elementAt$lambda$0$CollectionsKt___CollectionsKt(i3, ((Integer) obj).intValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object elementAt$lambda$0$CollectionsKt___CollectionsKt(int i3, int i4) {
        throw new IndexOutOfBoundsException("Collection doesn't contain element at index " + i3 + '.');
    }

    public static final <T> T elementAtOrElse(Iterable<? extends T> iterable, int i3, Function1<? super Integer, ? extends T> defaultValue) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        if (iterable instanceof List) {
            List list = (List) iterable;
            return (i3 < 0 || i3 >= list.size()) ? (T) defaultValue.invoke(Integer.valueOf(i3)) : (T) list.get(i3);
        }
        if (i3 < 0) {
            return (T) defaultValue.invoke(Integer.valueOf(i3));
        }
        int i4 = 0;
        for (T t2 : iterable) {
            int i5 = i4 + 1;
            if (i3 == i4) {
                return t2;
            }
            i4 = i5;
        }
        return (T) defaultValue.invoke(Integer.valueOf(i3));
    }

    public static final <T> T elementAtOrNull(Iterable<? extends T> iterable, int i3) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) getOrNull((List) iterable, i3);
        }
        if (i3 < 0) {
            return null;
        }
        int i4 = 0;
        for (T t2 : iterable) {
            int i5 = i4 + 1;
            if (i3 == i4) {
                return t2;
            }
            i4 = i5;
        }
        return null;
    }

    public static final <T> List<T> filter(Iterable<? extends T> iterable, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t2 : iterable) {
            if (((Boolean) predicate.invoke(t2)).booleanValue()) {
                arrayList.add(t2);
            }
        }
        return arrayList;
    }

    public static final <T> List<T> filterIndexed(Iterable<? extends T> iterable, Function2<? super Integer, ? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        for (T t2 : iterable) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (((Boolean) predicate.invoke(Integer.valueOf(i3), t2)).booleanValue()) {
                arrayList.add(t2);
            }
            i3 = i4;
        }
        return arrayList;
    }

    public static final <T, C extends Collection<? super T>> C filterIndexedTo(Iterable<? extends T> iterable, C destination, Function2<? super Integer, ? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i3 = 0;
        for (T t2 : iterable) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (((Boolean) predicate.invoke(Integer.valueOf(i3), t2)).booleanValue()) {
                destination.add(t2);
            }
            i3 = i4;
        }
        return destination;
    }

    public static final /* synthetic */ <R> List<R> filterIsInstance(Iterable<?> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        ArrayList arrayList = new ArrayList();
        for (Object obj : iterable) {
            Intrinsics.reifiedOperationMarker(3, "R");
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final /* synthetic */ <R, C extends Collection<? super R>> C filterIsInstanceTo(Iterable<?> iterable, C destination) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        for (Object obj : iterable) {
            Intrinsics.reifiedOperationMarker(3, "R");
            if (obj != null) {
                destination.add(obj);
            }
        }
        return destination;
    }

    public static final <T> List<T> filterNot(Iterable<? extends T> iterable, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t2 : iterable) {
            if (!((Boolean) predicate.invoke(t2)).booleanValue()) {
                arrayList.add(t2);
            }
        }
        return arrayList;
    }

    public static <T> List<T> filterNotNull(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return (List) filterNotNullTo(iterable, new ArrayList());
    }

    public static final <C extends Collection<? super T>, T> C filterNotNullTo(Iterable<? extends T> iterable, C destination) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        for (T t2 : iterable) {
            if (t2 != null) {
                destination.add(t2);
            }
        }
        return destination;
    }

    public static final <T, C extends Collection<? super T>> C filterNotTo(Iterable<? extends T> iterable, C destination, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (T t2 : iterable) {
            if (!((Boolean) predicate.invoke(t2)).booleanValue()) {
                destination.add(t2);
            }
        }
        return destination;
    }

    public static final <T, C extends Collection<? super T>> C filterTo(Iterable<? extends T> iterable, C destination, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (T t2 : iterable) {
            if (((Boolean) predicate.invoke(t2)).booleanValue()) {
                destination.add(t2);
            }
        }
        return destination;
    }

    private static final <T> T find(Iterable<? extends T> iterable, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (T t2 : iterable) {
            if (((Boolean) predicate.invoke(t2)).booleanValue()) {
                return t2;
            }
        }
        return null;
    }

    private static final <T> T findLast(Iterable<? extends T> iterable, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        T t2 = null;
        for (T t3 : iterable) {
            if (((Boolean) predicate.invoke(t3)).booleanValue()) {
                t2 = t3;
            }
        }
        return t2;
    }

    public static <T> T first(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) first((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    private static final <T, R> R firstNotNullOf(Iterable<? extends T> iterable, Function1<? super T, ? extends R> transform) {
        R r2;
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        Iterator<? extends T> it = iterable.iterator();
        while (true) {
            if (!it.hasNext()) {
                r2 = null;
                break;
            }
            r2 = (R) transform.invoke(it.next());
            if (r2 != null) {
                break;
            }
        }
        if (r2 != null) {
            return r2;
        }
        throw new NoSuchElementException("No element of the collection was transformed to a non-null value.");
    }

    private static final <T, R> R firstNotNullOfOrNull(Iterable<? extends T> iterable, Function1<? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            R r2 = (R) transform.invoke(it.next());
            if (r2 != null) {
                return r2;
            }
        }
        return null;
    }

    public static <T> T firstOrNull(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return (T) list.get(0);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public static final <T, R> List<R> flatMap(Iterable<? extends T> iterable, Function1<? super T, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, (Iterable) transform.invoke(it.next()));
        }
        return arrayList;
    }

    private static final <T, R> List<R> flatMapIndexedIterable(Iterable<? extends T> iterable, Function2<? super Integer, ? super T, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        for (T t2 : iterable) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, (Iterable) transform.invoke(Integer.valueOf(i3), t2));
            i3 = i4;
        }
        return arrayList;
    }

    private static final <T, R, C extends Collection<? super R>> C flatMapIndexedIterableTo(Iterable<? extends T> iterable, C destination, Function2<? super Integer, ? super T, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int i3 = 0;
        for (T t2 : iterable) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            CollectionsKt__MutableCollectionsKt.addAll(destination, (Iterable) transform.invoke(Integer.valueOf(i3), t2));
            i3 = i4;
        }
        return destination;
    }

    private static final <T, R> List<R> flatMapIndexedSequence(Iterable<? extends T> iterable, Function2<? super Integer, ? super T, ? extends Sequence<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        for (T t2 : iterable) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, (Sequence) transform.invoke(Integer.valueOf(i3), t2));
            i3 = i4;
        }
        return arrayList;
    }

    private static final <T, R, C extends Collection<? super R>> C flatMapIndexedSequenceTo(Iterable<? extends T> iterable, C destination, Function2<? super Integer, ? super T, ? extends Sequence<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int i3 = 0;
        for (T t2 : iterable) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            CollectionsKt__MutableCollectionsKt.addAll(destination, (Sequence) transform.invoke(Integer.valueOf(i3), t2));
            i3 = i4;
        }
        return destination;
    }

    public static final <T, R> List<R> flatMapSequence(Iterable<? extends T> iterable, Function1<? super T, ? extends Sequence<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, (Sequence) transform.invoke(it.next()));
        }
        return arrayList;
    }

    public static final <T, R, C extends Collection<? super R>> C flatMapSequenceTo(Iterable<? extends T> iterable, C destination, Function1<? super T, ? extends Sequence<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            CollectionsKt__MutableCollectionsKt.addAll(destination, (Sequence) transform.invoke(it.next()));
        }
        return destination;
    }

    public static final <T, R, C extends Collection<? super R>> C flatMapTo(Iterable<? extends T> iterable, C destination, Function1<? super T, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            CollectionsKt__MutableCollectionsKt.addAll(destination, (Iterable) transform.invoke(it.next()));
        }
        return destination;
    }

    public static final <T, R> R fold(Iterable<? extends T> iterable, R r2, Function2<? super R, ? super T, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            r2 = (R) operation.invoke(r2, it.next());
        }
        return r2;
    }

    public static final <T, R> R foldRight(List<? extends T> list, R r2, Function2<? super T, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (!list.isEmpty()) {
            ListIterator<? extends T> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                r2 = (R) operation.invoke(listIterator.previous(), r2);
            }
        }
        return r2;
    }

    public static final <T> void forEach(Iterable<? extends T> iterable, Function1<? super T, Unit> action) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            action.invoke(it.next());
        }
    }

    public static final <T> void forEachIndexed(Iterable<? extends T> iterable, Function2<? super Integer, ? super T, Unit> action) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int i3 = 0;
        for (T t2 : iterable) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            action.invoke(Integer.valueOf(i3), t2);
            i3 = i4;
        }
    }

    private static final <T> T getOrElse(List<? extends T> list, int i3, Function1<? super Integer, ? extends T> defaultValue) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return (i3 < 0 || i3 >= list.size()) ? (T) defaultValue.invoke(Integer.valueOf(i3)) : list.get(i3);
    }

    public static <T> T getOrNull(List<? extends T> list, int i3) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (i3 < 0 || i3 >= list.size()) {
            return null;
        }
        return list.get(i3);
    }

    public static final <T, K> Map<K, List<T>> groupBy(Iterable<? extends T> iterable, Function1<? super T, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t2 : iterable) {
            Object objInvoke = keySelector.invoke(t2);
            Object arrayList = linkedHashMap.get(objInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(objInvoke, arrayList);
            }
            ((List) arrayList).add(t2);
        }
        return linkedHashMap;
    }

    public static final <T, K, M extends Map<? super K, List<T>>> M groupByTo(Iterable<? extends T> iterable, M destination, Function1<? super T, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (T t2 : iterable) {
            Object objInvoke = keySelector.invoke(t2);
            Object arrayList = destination.get(objInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(objInvoke, arrayList);
            }
            ((List) arrayList).add(t2);
        }
        return destination;
    }

    public static final <T, K> Grouping<T, K> groupingBy(final Iterable<? extends T> iterable, final Function1<? super T, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        return new Grouping<T, K>() { // from class: kotlin.collections.CollectionsKt___CollectionsKt.groupingBy.1
            @Override // kotlin.collections.Grouping
            public K keyOf(T t2) {
                return (K) keySelector.invoke(t2);
            }

            @Override // kotlin.collections.Grouping
            public Iterator<T> sourceIterator() {
                return iterable.iterator();
            }
        };
    }

    public static <T> int indexOf(Iterable<? extends T> iterable, T t2) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(t2);
        }
        int i3 = 0;
        for (T t3 : iterable) {
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (Intrinsics.areEqual(t2, t3)) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    public static final <T> int indexOfFirst(Iterable<? extends T> iterable, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i3 = 0;
        for (T t2 : iterable) {
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (((Boolean) predicate.invoke(t2)).booleanValue()) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    public static final <T> int indexOfLast(Iterable<? extends T> iterable, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i3 = -1;
        int i4 = 0;
        for (T t2 : iterable) {
            if (i4 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (((Boolean) predicate.invoke(t2)).booleanValue()) {
                i3 = i4;
            }
            i4++;
        }
        return i3;
    }

    public static <T> Set<T> intersect(Iterable<? extends T> iterable, Iterable<? extends T> other) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<T> mutableSet = toMutableSet(iterable);
        CollectionsKt__MutableCollectionsKt.retainAll(mutableSet, other);
        return mutableSet;
    }

    public static final <T, A extends Appendable> A joinTo(Iterable<? extends T> iterable, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i3, CharSequence truncated, Function1<? super T, ? extends CharSequence> function1) throws IOException {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        buffer.append(prefix);
        int i4 = 0;
        for (T t2 : iterable) {
            i4++;
            if (i4 > 1) {
                buffer.append(separator);
            }
            if (i3 >= 0 && i4 > i3) {
                break;
            }
            StringsKt.a(buffer, t2, function1);
        }
        if (i3 >= 0 && i4 > i3) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final <T> String joinToString(Iterable<? extends T> iterable, CharSequence separator, CharSequence prefix, CharSequence postfix, int i3, CharSequence truncated, Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        return ((StringBuilder) joinTo(iterable, new StringBuilder(), separator, prefix, postfix, i3, truncated, function1)).toString();
    }

    public static /* synthetic */ String joinToString$default(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i3, CharSequence charSequence4, Function1 function1, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i4 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i4 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i4 & 8) != 0) {
            i3 = -1;
        }
        if ((i4 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i4 & 32) != 0) {
            function1 = null;
        }
        CharSequence charSequence5 = charSequence4;
        Function1 function12 = function1;
        return joinToString(iterable, charSequence, charSequence2, charSequence3, i3, charSequence5, function12);
    }

    public static <T> T last(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) last((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        T next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    public static final <T> int lastIndexOf(Iterable<? extends T> iterable, T t2) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).lastIndexOf(t2);
        }
        int i3 = -1;
        int i4 = 0;
        for (T t3 : iterable) {
            if (i4 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (Intrinsics.areEqual(t2, t3)) {
                i3 = i4;
            }
            i4++;
        }
        return i3;
    }

    public static <T> T lastOrNull(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return (T) list.get(list.size() - 1);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    public static final <T, R> List<R> map(Iterable<? extends T> iterable, Function1<? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(transform.invoke(it.next()));
        }
        return arrayList;
    }

    public static final <T, R> List<R> mapIndexed(Iterable<? extends T> iterable, Function2<? super Integer, ? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        int i3 = 0;
        for (T t2 : iterable) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(transform.invoke(Integer.valueOf(i3), t2));
            i3 = i4;
        }
        return arrayList;
    }

    public static final <T, R> List<R> mapIndexedNotNull(Iterable<? extends T> iterable, Function2<? super Integer, ? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        for (T t2 : iterable) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            Object objInvoke = transform.invoke(Integer.valueOf(i3), t2);
            if (objInvoke != null) {
                arrayList.add(objInvoke);
            }
            i3 = i4;
        }
        return arrayList;
    }

    public static final <T, R, C extends Collection<? super R>> C mapIndexedNotNullTo(Iterable<? extends T> iterable, C destination, Function2<? super Integer, ? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int i3 = 0;
        for (T t2 : iterable) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            Object objInvoke = transform.invoke(Integer.valueOf(i3), t2);
            if (objInvoke != null) {
                destination.add(objInvoke);
            }
            i3 = i4;
        }
        return destination;
    }

    public static final <T, R, C extends Collection<? super R>> C mapIndexedTo(Iterable<? extends T> iterable, C destination, Function2<? super Integer, ? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int i3 = 0;
        for (T t2 : iterable) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            destination.add(transform.invoke(Integer.valueOf(i3), t2));
            i3 = i4;
        }
        return destination;
    }

    public static final <T, R> List<R> mapNotNull(Iterable<? extends T> iterable, Function1<? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Object objInvoke = transform.invoke(it.next());
            if (objInvoke != null) {
                arrayList.add(objInvoke);
            }
        }
        return arrayList;
    }

    public static final <T, R, C extends Collection<? super R>> C mapNotNullTo(Iterable<? extends T> iterable, C destination, Function1<? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Object objInvoke = transform.invoke(it.next());
            if (objInvoke != null) {
                destination.add(objInvoke);
            }
        }
        return destination;
    }

    public static final <T, R, C extends Collection<? super R>> C mapTo(Iterable<? extends T> iterable, C destination, Function1<? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            destination.add(transform.invoke(it.next()));
        }
        return destination;
    }

    public static final <T, R extends Comparable<? super R>> T maxByOrNull(Iterable<? extends T> iterable, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        Comparable comparable = (Comparable) selector.invoke(next);
        do {
            T next2 = it.next();
            Comparable comparable2 = (Comparable) selector.invoke(next2);
            if (comparable.compareTo(comparable2) < 0) {
                next = next2;
                comparable = comparable2;
            }
        } while (it.hasNext());
        return next;
    }

    public static final <T, R extends Comparable<? super R>> T maxByOrThrow(Iterable<? extends T> iterable, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        T next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        Comparable comparable = (Comparable) selector.invoke(next);
        do {
            T next2 = it.next();
            Comparable comparable2 = (Comparable) selector.invoke(next2);
            if (comparable.compareTo(comparable2) < 0) {
                next = next2;
                comparable = comparable2;
            }
        } while (it.hasNext());
        return next;
    }

    private static final <T> double maxOf(Iterable<? extends T> iterable, Function1<? super T, Double> selector) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = ((Number) selector.invoke(it.next())).doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, ((Number) selector.invoke(it.next())).doubleValue());
        }
        return dDoubleValue;
    }

    /* JADX INFO: renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final <T> Double m1453maxOfOrNull(Iterable<? extends T> iterable, Function1<? super T, Double> selector) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        double dDoubleValue = ((Number) selector.invoke(it.next())).doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, ((Number) selector.invoke(it.next())).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    private static final <T, R> R maxOfWith(Iterable<? extends T> iterable, Comparator<? super R> comparator, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        R r2 = (R) selector.invoke(it.next());
        while (it.hasNext()) {
            Object obj = (Object) selector.invoke(it.next());
            if (comparator.compare(r2, obj) < 0) {
                r2 = (R) obj;
            }
        }
        return r2;
    }

    private static final <T, R> R maxOfWithOrNull(Iterable<? extends T> iterable, Comparator<? super R> comparator, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        R r2 = (R) selector.invoke(it.next());
        while (it.hasNext()) {
            Object obj = (Object) selector.invoke(it.next());
            if (comparator.compare(r2, obj) < 0) {
                r2 = (R) obj;
            }
        }
        return r2;
    }

    /* JADX INFO: renamed from: maxOrNull, reason: collision with other method in class */
    public static Double m1455maxOrNull(Iterable<Double> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<Double> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        double dDoubleValue = it.next().doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, it.next().doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    public static final double maxOrThrow(Iterable<Double> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<Double> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = it.next().doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, it.next().doubleValue());
        }
        return dDoubleValue;
    }

    public static <T> T maxWithOrNull(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (comparator.compare(next, next2) < 0) {
                next = next2;
            }
        }
        return next;
    }

    public static final <T> T maxWithOrThrow(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (comparator.compare(next, next2) < 0) {
                next = next2;
            }
        }
        return next;
    }

    public static final <T, R extends Comparable<? super R>> T minByOrNull(Iterable<? extends T> iterable, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        Comparable comparable = (Comparable) selector.invoke(next);
        do {
            T next2 = it.next();
            Comparable comparable2 = (Comparable) selector.invoke(next2);
            if (comparable.compareTo(comparable2) > 0) {
                next = next2;
                comparable = comparable2;
            }
        } while (it.hasNext());
        return next;
    }

    public static final <T, R extends Comparable<? super R>> T minByOrThrow(Iterable<? extends T> iterable, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        T next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        Comparable comparable = (Comparable) selector.invoke(next);
        do {
            T next2 = it.next();
            Comparable comparable2 = (Comparable) selector.invoke(next2);
            if (comparable.compareTo(comparable2) > 0) {
                next = next2;
                comparable = comparable2;
            }
        } while (it.hasNext());
        return next;
    }

    private static final <T> double minOf(Iterable<? extends T> iterable, Function1<? super T, Double> selector) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = ((Number) selector.invoke(it.next())).doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, ((Number) selector.invoke(it.next())).doubleValue());
        }
        return dDoubleValue;
    }

    /* JADX INFO: renamed from: minOfOrNull, reason: collision with other method in class */
    private static final <T> Double m1461minOfOrNull(Iterable<? extends T> iterable, Function1<? super T, Double> selector) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        double dDoubleValue = ((Number) selector.invoke(it.next())).doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, ((Number) selector.invoke(it.next())).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    private static final <T, R> R minOfWith(Iterable<? extends T> iterable, Comparator<? super R> comparator, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        R r2 = (R) selector.invoke(it.next());
        while (it.hasNext()) {
            Object obj = (Object) selector.invoke(it.next());
            if (comparator.compare(r2, obj) > 0) {
                r2 = (R) obj;
            }
        }
        return r2;
    }

    private static final <T, R> R minOfWithOrNull(Iterable<? extends T> iterable, Comparator<? super R> comparator, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        R r2 = (R) selector.invoke(it.next());
        while (it.hasNext()) {
            Object obj = (Object) selector.invoke(it.next());
            if (comparator.compare(r2, obj) > 0) {
                r2 = (R) obj;
            }
        }
        return r2;
    }

    /* JADX INFO: renamed from: minOrNull, reason: collision with other method in class */
    public static final Double m1463minOrNull(Iterable<Double> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<Double> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        double dDoubleValue = it.next().doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, it.next().doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    public static final double minOrThrow(Iterable<Double> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<Double> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = it.next().doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, it.next().doubleValue());
        }
        return dDoubleValue;
    }

    public static final <T> T minWithOrNull(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (comparator.compare(next, next2) > 0) {
                next = next2;
            }
        }
        return next;
    }

    public static final <T> T minWithOrThrow(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (comparator.compare(next, next2) > 0) {
                next = next2;
            }
        }
        return next;
    }

    public static <T> List<T> minus(Iterable<? extends T> iterable, T t2) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        boolean z2 = false;
        for (T t3 : iterable) {
            boolean z3 = true;
            if (!z2 && Intrinsics.areEqual(t3, t2)) {
                z2 = true;
                z3 = false;
            }
            if (z3) {
                arrayList.add(t3);
            }
        }
        return arrayList;
    }

    private static final <T> List<T> minusElement(Iterable<? extends T> iterable, T t2) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return minus(iterable, t2);
    }

    public static final <T> boolean none(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).isEmpty() : !iterable.iterator().hasNext();
    }

    public static final <T, C extends Iterable<? extends T>> C onEach(C c3, Function1<? super T, Unit> action) {
        Intrinsics.checkNotNullParameter(c3, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        Iterator<T> it = c3.iterator();
        while (it.hasNext()) {
            action.invoke(it.next());
        }
        return c3;
    }

    public static final <T, C extends Iterable<? extends T>> C onEachIndexed(C c3, Function2<? super Integer, ? super T, Unit> action) {
        Intrinsics.checkNotNullParameter(c3, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int i3 = 0;
        for (T t2 : c3) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            action.invoke(Integer.valueOf(i3), t2);
            i3 = i4;
        }
        return c3;
    }

    public static final <T> Pair<List<T>, List<T>> partition(Iterable<? extends T> iterable, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (T t2 : iterable) {
            if (((Boolean) predicate.invoke(t2)).booleanValue()) {
                arrayList.add(t2);
            } else {
                arrayList2.add(t2);
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    public static final <T> List<T> plus(Iterable<? extends T> iterable, T t2) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof Collection) {
            return plus((Collection) iterable, (Object) t2);
        }
        ArrayList arrayList = new ArrayList();
        CollectionsKt__MutableCollectionsKt.addAll(arrayList, iterable);
        arrayList.add(t2);
        return arrayList;
    }

    private static final <T> List<T> plusElement(Iterable<? extends T> iterable, T t2) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return plus(iterable, t2);
    }

    private static final <T> T random(Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        return (T) random(collection, Random.f140182a);
    }

    private static final <T> T randomOrNull(Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        return (T) randomOrNull(collection, Random.f140182a);
    }

    public static final <S, T extends S> S reduce(Iterable<? extends T> iterable, Function2<? super S, ? super T, ? extends S> operation) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }
        T next = it.next();
        while (it.hasNext()) {
            next = (S) operation.invoke(next, it.next());
        }
        return next;
    }

    public static final <S, T extends S> S reduceIndexed(Iterable<? extends T> iterable, Function3<? super Integer, ? super S, ? super T, ? extends S> operation) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }
        T next = it.next();
        int i3 = 1;
        while (it.hasNext()) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            next = (S) operation.invoke(Integer.valueOf(i3), next, it.next());
            i3 = i4;
        }
        return next;
    }

    public static final <S, T extends S> S reduceIndexedOrNull(Iterable<? extends T> iterable, Function3<? super Integer, ? super S, ? super T, ? extends S> operation) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        int i3 = 1;
        while (it.hasNext()) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            next = (S) operation.invoke(Integer.valueOf(i3), next, it.next());
            i3 = i4;
        }
        return next;
    }

    public static final <S, T extends S> S reduceOrNull(Iterable<? extends T> iterable, Function2<? super S, ? super T, ? extends S> operation) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            next = (S) operation.invoke(next, it.next());
        }
        return next;
    }

    public static final <S, T extends S> S reduceRight(List<? extends T> list, Function2<? super T, ? super S, ? extends S> operation) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        if (!listIterator.hasPrevious()) {
            throw new UnsupportedOperationException("Empty list can't be reduced.");
        }
        T tPrevious = listIterator.previous();
        while (listIterator.hasPrevious()) {
            tPrevious = (S) operation.invoke(listIterator.previous(), tPrevious);
        }
        return tPrevious;
    }

    public static final <S, T extends S> S reduceRightIndexed(List<? extends T> list, Function3<? super Integer, ? super T, ? super S, ? extends S> operation) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        if (!listIterator.hasPrevious()) {
            throw new UnsupportedOperationException("Empty list can't be reduced.");
        }
        T tPrevious = listIterator.previous();
        while (listIterator.hasPrevious()) {
            tPrevious = (S) operation.invoke(Integer.valueOf(listIterator.previousIndex()), listIterator.previous(), tPrevious);
        }
        return tPrevious;
    }

    public static final <S, T extends S> S reduceRightIndexedOrNull(List<? extends T> list, Function3<? super Integer, ? super T, ? super S, ? extends S> operation) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        if (!listIterator.hasPrevious()) {
            return null;
        }
        T tPrevious = listIterator.previous();
        while (listIterator.hasPrevious()) {
            tPrevious = (S) operation.invoke(Integer.valueOf(listIterator.previousIndex()), listIterator.previous(), tPrevious);
        }
        return tPrevious;
    }

    public static final <S, T extends S> S reduceRightOrNull(List<? extends T> list, Function2<? super T, ? super S, ? extends S> operation) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        if (!listIterator.hasPrevious()) {
            return null;
        }
        T tPrevious = listIterator.previous();
        while (listIterator.hasPrevious()) {
            tPrevious = (S) operation.invoke(listIterator.previous(), tPrevious);
        }
        return tPrevious;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Iterable<T> requireNoNulls(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("null element found in " + iterable + '.');
            }
        }
        return iterable;
    }

    public static <T> List<T> reversed(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if ((iterable instanceof Collection) && ((Collection) iterable).size() <= 1) {
            return toList(iterable);
        }
        List<T> mutableList = toMutableList(iterable);
        CollectionsKt___CollectionsJvmKt.reverse(mutableList);
        return mutableList;
    }

    public static final <T, R> List<R> runningFold(Iterable<? extends T> iterable, R r2, Function2<? super R, ? super T, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int iCollectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 9);
        if (iCollectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault + 1);
        arrayList.add(r2);
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            r2 = (R) operation.invoke(r2, it.next());
            arrayList.add(r2);
        }
        return arrayList;
    }

    public static final <T, R> List<R> runningFoldIndexed(Iterable<? extends T> iterable, R r2, Function3<? super Integer, ? super R, ? super T, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int iCollectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 9);
        if (iCollectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault + 1);
        arrayList.add(r2);
        Iterator<? extends T> it = iterable.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            r2 = (R) operation.invoke(Integer.valueOf(i3), r2, it.next());
            arrayList.add(r2);
            i3++;
        }
        return arrayList;
    }

    public static final <S, T extends S> List<S> runningReduce(Iterable<? extends T> iterable, Function2<? super S, ? super T, ? extends S> operation) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        Object next = it.next();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        arrayList.add(next);
        while (it.hasNext()) {
            next = operation.invoke(next, it.next());
            arrayList.add(next);
        }
        return arrayList;
    }

    public static final <S, T extends S> List<S> runningReduceIndexed(Iterable<? extends T> iterable, Function3<? super Integer, ? super S, ? super T, ? extends S> operation) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        Object next = it.next();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        arrayList.add(next);
        int i3 = 1;
        while (it.hasNext()) {
            next = operation.invoke(Integer.valueOf(i3), next, it.next());
            arrayList.add(next);
            i3++;
        }
        return arrayList;
    }

    public static final <T, R> List<R> scan(Iterable<? extends T> iterable, R r2, Function2<? super R, ? super T, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int iCollectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 9);
        if (iCollectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault + 1);
        arrayList.add(r2);
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            r2 = (R) operation.invoke(r2, it.next());
            arrayList.add(r2);
        }
        return arrayList;
    }

    public static final <T, R> List<R> scanIndexed(Iterable<? extends T> iterable, R r2, Function3<? super Integer, ? super R, ? super T, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int iCollectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 9);
        if (iCollectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault + 1);
        arrayList.add(r2);
        Iterator<? extends T> it = iterable.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            r2 = (R) operation.invoke(Integer.valueOf(i3), r2, it.next());
            arrayList.add(r2);
            i3++;
        }
        return arrayList;
    }

    public static final <T> void shuffle(List<T> list, Random random) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(list); lastIndex > 0; lastIndex--) {
            int iJ = random.j(lastIndex + 1);
            list.set(iJ, list.set(lastIndex, list.get(iJ)));
        }
    }

    public static <T> T single(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) single((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        T next = it.next();
        if (it.hasNext()) {
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        return next;
    }

    public static <T> T singleOrNull(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.size() == 1) {
                return (T) list.get(0);
            }
            return null;
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        if (it.hasNext()) {
            return null;
        }
        return next;
    }

    public static <T> List<T> slice(List<? extends T> list, IntRange indices) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? CollectionsKt__CollectionsKt.emptyList() : toList(list.subList(indices.a().intValue(), indices.e().intValue() + 1));
    }

    public static final <T, R extends Comparable<? super R>> void sortBy(List<T> list, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (list.size() > 1) {
            CollectionsKt__MutableCollectionsJVMKt.sortWith(list, new ComparisonsKt__ComparisonsKt$compareBy$2(selector));
        }
    }

    public static final <T, R extends Comparable<? super R>> void sortByDescending(List<T> list, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (list.size() > 1) {
            CollectionsKt__MutableCollectionsJVMKt.sortWith(list, new ComparisonsKt__ComparisonsKt$compareByDescending$1(selector));
        }
    }

    public static final <T extends Comparable<? super T>> void sortDescending(List<T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        CollectionsKt__MutableCollectionsJVMKt.sortWith(list, ComparisonsKt.h());
    }

    public static <T extends Comparable<? super T>> List<T> sorted(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            List<T> mutableList = toMutableList(iterable);
            CollectionsKt__MutableCollectionsJVMKt.sort(mutableList);
            return mutableList;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return toList(iterable);
        }
        Object[] array = collection.toArray(new Comparable[0]);
        ArraysKt___ArraysJvmKt.sort(array);
        return ArraysKt___ArraysJvmKt.asList(array);
    }

    public static final <T, R extends Comparable<? super R>> List<T> sortedByDescending(Iterable<? extends T> iterable, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(iterable, new ComparisonsKt__ComparisonsKt$compareByDescending$1(selector));
    }

    public static final <T extends Comparable<? super T>> List<T> sortedDescending(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return sortedWith(iterable, ComparisonsKt.h());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> List<T> sortedWith(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (!(iterable instanceof Collection)) {
            List<T> mutableList = toMutableList(iterable);
            CollectionsKt__MutableCollectionsJVMKt.sortWith(mutableList, comparator);
            return mutableList;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return toList(iterable);
        }
        Object[] array = collection.toArray(new Object[0]);
        ArraysKt___ArraysJvmKt.sortWith(array, comparator);
        return ArraysKt___ArraysJvmKt.asList(array);
    }

    public static <T> Set<T> subtract(Iterable<? extends T> iterable, Iterable<? extends T> other) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<T> mutableSet = toMutableSet(iterable);
        CollectionsKt__MutableCollectionsKt.removeAll(mutableSet, other);
        return mutableSet;
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final <T> int sumBy(Iterable<? extends T> iterable, Function1<? super T, Integer> selector) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        int iIntValue = 0;
        while (it.hasNext()) {
            iIntValue += ((Number) selector.invoke(it.next())).intValue();
        }
        return iIntValue;
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final <T> double sumByDouble(Iterable<? extends T> iterable, Function1<? super T, Double> selector) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        double dDoubleValue = 0.0d;
        while (it.hasNext()) {
            dDoubleValue += ((Number) selector.invoke(it.next())).doubleValue();
        }
        return dDoubleValue;
    }

    public static final int sumOfByte(Iterable<Byte> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<Byte> it = iterable.iterator();
        int iByteValue = 0;
        while (it.hasNext()) {
            iByteValue += it.next().byteValue();
        }
        return iByteValue;
    }

    private static final <T> double sumOfDouble(Iterable<? extends T> iterable, Function1<? super T, Double> selector) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        double dDoubleValue = 0.0d;
        while (it.hasNext()) {
            dDoubleValue += ((Number) selector.invoke(it.next())).doubleValue();
        }
        return dDoubleValue;
    }

    public static final float sumOfFloat(Iterable<Float> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<Float> it = iterable.iterator();
        float fFloatValue = 0.0f;
        while (it.hasNext()) {
            fFloatValue += it.next().floatValue();
        }
        return fFloatValue;
    }

    private static final <T> int sumOfInt(Iterable<? extends T> iterable, Function1<? super T, Integer> selector) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        int iIntValue = 0;
        while (it.hasNext()) {
            iIntValue += ((Number) selector.invoke(it.next())).intValue();
        }
        return iIntValue;
    }

    private static final <T> long sumOfLong(Iterable<? extends T> iterable, Function1<? super T, Long> selector) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        long jLongValue = 0;
        while (it.hasNext()) {
            jLongValue += ((Number) selector.invoke(it.next())).longValue();
        }
        return jLongValue;
    }

    public static final int sumOfShort(Iterable<Short> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<Short> it = iterable.iterator();
        int iShortValue = 0;
        while (it.hasNext()) {
            iShortValue += it.next().shortValue();
        }
        return iShortValue;
    }

    private static final <T> int sumOfUInt(Iterable<? extends T> iterable, Function1<? super T, UInt> selector) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iB = UInt.b(0);
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            iB = UInt.b(iB + ((UInt) selector.invoke(it.next())).f());
        }
        return iB;
    }

    private static final <T> long sumOfULong(Iterable<? extends T> iterable, Function1<? super T, ULong> selector) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        long jB = ULong.b(0L);
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            jB = ULong.b(jB + ((ULong) selector.invoke(it.next())).g());
        }
        return jB;
    }

    public static <T> List<T> take(Iterable<? extends T> iterable, int i3) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (i3 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
        }
        if (i3 == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (iterable instanceof Collection) {
            if (i3 >= ((Collection) iterable).size()) {
                return toList(iterable);
            }
            if (i3 == 1) {
                return CollectionsKt__CollectionsJVMKt.listOf(first(iterable));
            }
        }
        ArrayList arrayList = new ArrayList(i3);
        Iterator<? extends T> it = iterable.iterator();
        int i4 = 0;
        while (it.hasNext()) {
            arrayList.add(it.next());
            i4++;
            if (i4 == i3) {
                break;
            }
        }
        return CollectionsKt__CollectionsKt.optimizeReadOnlyList(arrayList);
    }

    public static <T> List<T> takeLast(List<? extends T> list, int i3) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (i3 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
        }
        if (i3 == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        int size = list.size();
        if (i3 >= size) {
            return toList(list);
        }
        if (i3 == 1) {
            return CollectionsKt__CollectionsJVMKt.listOf(last((List) list));
        }
        ArrayList arrayList = new ArrayList(i3);
        if (list instanceof RandomAccess) {
            for (int i4 = size - i3; i4 < size; i4++) {
                arrayList.add(list.get(i4));
            }
        } else {
            ListIterator<? extends T> listIterator = list.listIterator(size - i3);
            while (listIterator.hasNext()) {
                arrayList.add(listIterator.next());
            }
        }
        return arrayList;
    }

    public static final <T> List<T> takeLastWhile(List<? extends T> list, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        if (list.isEmpty()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (!((Boolean) predicate.invoke(listIterator.previous())).booleanValue()) {
                listIterator.next();
                int size = list.size() - listIterator.nextIndex();
                if (size == 0) {
                    return CollectionsKt__CollectionsKt.emptyList();
                }
                ArrayList arrayList = new ArrayList(size);
                while (listIterator.hasNext()) {
                    arrayList.add(listIterator.next());
                }
                return arrayList;
            }
        }
        return toList(list);
    }

    public static final <T> List<T> takeWhile(Iterable<? extends T> iterable, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t2 : iterable) {
            if (!((Boolean) predicate.invoke(t2)).booleanValue()) {
                break;
            }
            arrayList.add(t2);
        }
        return arrayList;
    }

    public static boolean[] toBooleanArray(Collection<Boolean> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        boolean[] zArr = new boolean[collection.size()];
        Iterator<Boolean> it = collection.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            zArr[i3] = it.next().booleanValue();
            i3++;
        }
        return zArr;
    }

    public static byte[] toByteArray(Collection<Byte> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        byte[] bArr = new byte[collection.size()];
        Iterator<Byte> it = collection.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            bArr[i3] = it.next().byteValue();
            i3++;
        }
        return bArr;
    }

    public static final char[] toCharArray(Collection<Character> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        char[] cArr = new char[collection.size()];
        Iterator<Character> it = collection.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            cArr[i3] = it.next().charValue();
            i3++;
        }
        return cArr;
    }

    public static final <T, C extends Collection<? super T>> C toCollection(Iterable<? extends T> iterable, C destination) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            destination.add(it.next());
        }
        return destination;
    }

    public static double[] toDoubleArray(Collection<Double> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        double[] dArr = new double[collection.size()];
        Iterator<Double> it = collection.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            dArr[i3] = it.next().doubleValue();
            i3++;
        }
        return dArr;
    }

    public static float[] toFloatArray(Collection<Float> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        float[] fArr = new float[collection.size()];
        Iterator<Float> it = collection.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            fArr[i3] = it.next().floatValue();
            i3++;
        }
        return fArr;
    }

    public static <T> HashSet<T> toHashSet(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return (HashSet) toCollection(iterable, new HashSet(MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 12))));
    }

    public static int[] toIntArray(Collection<Integer> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        int[] iArr = new int[collection.size()];
        Iterator<Integer> it = collection.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            iArr[i3] = it.next().intValue();
            i3++;
        }
        return iArr;
    }

    public static <T> List<T> toList(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return CollectionsKt__CollectionsKt.optimizeReadOnlyList(toMutableList(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (size != 1) {
            return toMutableList(collection);
        }
        return CollectionsKt__CollectionsJVMKt.listOf(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
    }

    public static long[] toLongArray(Collection<Long> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        long[] jArr = new long[collection.size()];
        Iterator<Long> it = collection.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            jArr[i3] = it.next().longValue();
            i3++;
        }
        return jArr;
    }

    public static final <T> List<T> toMutableList(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return iterable instanceof Collection ? toMutableList((Collection) iterable) : (List) toCollection(iterable, new ArrayList());
    }

    public static <T> Set<T> toMutableSet(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return iterable instanceof Collection ? new LinkedHashSet((Collection) iterable) : (Set) toCollection(iterable, new LinkedHashSet());
    }

    public static <T> Set<T> toSet(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return SetsKt__SetsKt.optimizeReadOnlySet((Set) toCollection(iterable, new LinkedHashSet()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return SetsKt__SetsKt.emptySet();
        }
        if (size != 1) {
            return (Set) toCollection(iterable, new LinkedHashSet(MapsKt__MapsJVMKt.mapCapacity(collection.size())));
        }
        return SetsKt__SetsJVMKt.setOf(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
    }

    public static final short[] toShortArray(Collection<Short> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        short[] sArr = new short[collection.size()];
        Iterator<Short> it = collection.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            sArr[i3] = it.next().shortValue();
            i3++;
        }
        return sArr;
    }

    public static final <T> Set<T> union(Iterable<? extends T> iterable, Iterable<? extends T> other) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<T> mutableSet = toMutableSet(iterable);
        CollectionsKt__MutableCollectionsKt.addAll(mutableSet, other);
        return mutableSet;
    }

    public static <T> List<List<T>> windowed(Iterable<? extends T> iterable, int i3, int i4, boolean z2) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        SlidingWindowKt.checkWindowSizeStep(i3, i4);
        if (!(iterable instanceof RandomAccess) || !(iterable instanceof List)) {
            ArrayList arrayList = new ArrayList();
            Iterator itWindowedIterator = SlidingWindowKt.windowedIterator(iterable.iterator(), i3, i4, z2, false);
            while (itWindowedIterator.hasNext()) {
                arrayList.add((List) itWindowedIterator.next());
            }
            return arrayList;
        }
        List list = (List) iterable;
        int size = list.size();
        ArrayList arrayList2 = new ArrayList((size / i4) + (size % i4 == 0 ? 0 : 1));
        int i5 = 0;
        while (i5 >= 0 && i5 < size) {
            int iK = RangesKt.k(i3, size - i5);
            if (iK < i3 && !z2) {
                return arrayList2;
            }
            ArrayList arrayList3 = new ArrayList(iK);
            for (int i6 = 0; i6 < iK; i6++) {
                arrayList3.add(list.get(i6 + i5));
            }
            arrayList2.add(arrayList3);
            i5 += i4;
        }
        return arrayList2;
    }

    public static /* synthetic */ List windowed$default(Iterable iterable, int i3, int i4, boolean z2, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i4 = 1;
        }
        if ((i5 & 4) != 0) {
            z2 = false;
        }
        return windowed(iterable, i3, i4, z2);
    }

    public static <T> Iterable<IndexedValue<T>> withIndex(final Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return new IndexingIterable(new Function0() { // from class: kotlin.collections.l
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return iterable.iterator();
            }
        });
    }

    public static final <T, R, V> List<V> zip(Iterable<? extends T> iterable, R[] other, Function2<? super T, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = other.length;
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10), length));
        int i3 = 0;
        for (T t2 : iterable) {
            if (i3 >= length) {
                break;
            }
            arrayList.add(transform.invoke(t2, other[i3]));
            i3++;
        }
        return arrayList;
    }

    public static final <T, R> List<R> zipWithNext(Iterable<? extends T> iterable, Function2<? super T, ? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            arrayList.add(transform.invoke(next, next2));
            next = next2;
        }
        return arrayList;
    }

    public static final <T, R> List<R> chunked(Iterable<? extends T> iterable, int i3, Function1<? super List<? extends T>, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        return windowed(iterable, i3, i3, true, transform);
    }

    public static final <T, R> R foldIndexed(Iterable<? extends T> iterable, R r2, Function3<? super Integer, ? super R, ? super T, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(iterable, vgWWUoTKYyuC.GJzUGLuUG);
        Intrinsics.checkNotNullParameter(operation, "operation");
        int i3 = 0;
        for (T t2 : iterable) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            r2 = (R) operation.invoke(Integer.valueOf(i3), r2, t2);
            i3 = i4;
        }
        return r2;
    }

    public static final <T, R> R foldRightIndexed(List<? extends T> list, R r2, Function3<? super Integer, ? super T, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(list, pMpIcGE.BEPYZQEQKgjlE);
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (!list.isEmpty()) {
            ListIterator<? extends T> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                r2 = (R) operation.invoke(Integer.valueOf(listIterator.previousIndex()), listIterator.previous(), r2);
            }
        }
        return r2;
    }

    private static final <T> List<T> plusElement(Collection<? extends T> collection, T t2) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        return plus((Collection) collection, (Object) t2);
    }

    public static <T> T random(Collection<? extends T> collection, Random random) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (collection.isEmpty()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        return (T) elementAt(collection, random.j(collection.size()));
    }

    public static final <T> T randomOrNull(Collection<? extends T> collection, Random random) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (collection.isEmpty()) {
            return null;
        }
        return (T) elementAt(collection, random.j(collection.size()));
    }

    public static final <T, R extends Comparable<? super R>> List<T> sortedBy(Iterable<? extends T> iterable, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iterable, SbbqvQlxi.oNHeZtv);
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(iterable, new ComparisonsKt__ComparisonsKt$compareBy$2(selector));
    }

    public static /* synthetic */ List windowed$default(Iterable iterable, int i3, int i4, boolean z2, Function1 function1, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i4 = 1;
        }
        if ((i5 & 4) != 0) {
            z2 = false;
        }
        return windowed(iterable, i3, i4, z2, function1);
    }

    public static final <T> boolean any(Iterable<? extends T> iterable, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return false;
        }
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (((Boolean) predicate.invoke(it.next())).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K, V, M extends Map<? super K, ? super V>> M associateByTo(Iterable<? extends T> iterable, M destination, Function1<? super T, ? extends K> keySelector, Function1<? super T, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (T t2 : iterable) {
            destination.put(keySelector.invoke(t2), valueTransform.invoke(t2));
        }
        return destination;
    }

    private static final <T> int count(Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        return collection.size();
    }

    private static final <T> T findLast(List<? extends T> list, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            T tPrevious = listIterator.previous();
            if (((Boolean) predicate.invoke(tPrevious)).booleanValue()) {
                return tPrevious;
            }
        }
        return null;
    }

    public static <T> boolean none(Iterable<? extends T> iterable, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return true;
        }
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (((Boolean) predicate.invoke(it.next())).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> requireNoNulls(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("null element found in " + list + '.');
            }
        }
        return list;
    }

    public static final <T> List<T> slice(List<? extends T> list, Iterable<Integer> indices) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        int iCollectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(indices, 10);
        if (iCollectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(list.get(it.next().intValue()));
        }
        return arrayList;
    }

    public static double sumOfDouble(Iterable<Double> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<Double> it = iterable.iterator();
        double dDoubleValue = 0.0d;
        while (it.hasNext()) {
            dDoubleValue += it.next().doubleValue();
        }
        return dDoubleValue;
    }

    public static final int sumOfInt(Iterable<Integer> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<Integer> it = iterable.iterator();
        int iIntValue = 0;
        while (it.hasNext()) {
            iIntValue += it.next().intValue();
        }
        return iIntValue;
    }

    public static long sumOfLong(Iterable<Long> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<Long> it = iterable.iterator();
        long jLongValue = 0;
        while (it.hasNext()) {
            jLongValue += it.next().longValue();
        }
        return jLongValue;
    }

    public static final <T> int count(Iterable<? extends T> iterable, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i3 = 0;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return 0;
        }
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (((Boolean) predicate.invoke(it.next())).booleanValue() && (i3 = i3 + 1) < 0) {
                CollectionsKt__CollectionsKt.throwCountOverflow();
            }
        }
        return i3;
    }

    private static final <T> T elementAt(List<? extends T> list, int i3) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return list.get(i3);
    }

    public static final <T> int indexOfFirst(List<? extends T> list, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Iterator<? extends T> it = list.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (((Boolean) predicate.invoke(it.next())).booleanValue()) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    public static final <T> int indexOfLast(List<? extends T> list, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (((Boolean) predicate.invoke(listIterator.previous())).booleanValue()) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    public static <T> List<T> toMutableList(Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        return new ArrayList(collection);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K, V> Map<K, V> associateBy(Iterable<? extends T> iterable, Function1<? super T, ? extends K> keySelector, Function1<? super T, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10)), 16));
        for (T t2 : iterable) {
            linkedHashMap.put(keySelector.invoke(t2), valueTransform.invoke(t2));
        }
        return linkedHashMap;
    }

    public static <T> int indexOf(List<? extends T> list, T t2) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return list.indexOf(t2);
    }

    public static final <T> int lastIndexOf(List<? extends T> list, T t2) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return list.lastIndexOf(t2);
    }

    public static final <T> List<T> minus(Iterable<? extends T> iterable, T[] elements) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements.length == 0) {
            return toList(iterable);
        }
        ArrayList arrayList = new ArrayList();
        for (T t2 : iterable) {
            if (!ArraysKt___ArraysKt.contains(elements, t2)) {
                arrayList.add(t2);
            }
        }
        return arrayList;
    }

    public static <T> List<T> plus(Collection<? extends T> collection, T t2) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(t2);
        return arrayList;
    }

    public static final <T, R, V> List<V> zip(Iterable<? extends T> iterable, Iterable<? extends R> other, Function2<? super T, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        Iterator<? extends T> it = iterable.iterator();
        Iterator<? extends R> it2 = other.iterator();
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10), CollectionsKt__IterablesKt.collectionSizeOrDefault(other, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(transform.invoke(it.next(), it2.next()));
        }
        return arrayList;
    }

    private static final <T> T elementAtOrNull(List<? extends T> list, int i3) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return (T) getOrNull(list, i3);
    }

    public static <T> T first(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (!list.isEmpty()) {
            return list.get(0);
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static <T> T singleOrNull(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    public static <T> T firstOrNull(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static <T> T lastOrNull(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    public static final <T> T singleOrNull(Iterable<? extends T> iterable, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        boolean z2 = false;
        T t2 = null;
        for (T t3 : iterable) {
            if (((Boolean) predicate.invoke(t3)).booleanValue()) {
                if (z2) {
                    return null;
                }
                z2 = true;
                t2 = t3;
            }
        }
        if (z2) {
            return t2;
        }
        return null;
    }

    private static final <T> T elementAtOrElse(List<? extends T> list, int i3, Function1<? super Integer, ? extends T> defaultValue) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return (i3 < 0 || i3 >= list.size()) ? (T) defaultValue.invoke(Integer.valueOf(i3)) : list.get(i3);
    }

    public static final <T> T firstOrNull(Iterable<? extends T> iterable, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (T t2 : iterable) {
            if (((Boolean) predicate.invoke(t2)).booleanValue()) {
                return t2;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K, V, M extends Map<? super K, List<V>>> M groupByTo(Iterable<? extends T> iterable, M destination, Function1<? super T, ? extends K> keySelector, Function1<? super T, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (T t2 : iterable) {
            Object objInvoke = keySelector.invoke(t2);
            Object arrayList = destination.get(objInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(objInvoke, arrayList);
            }
            ((List) arrayList).add(valueTransform.invoke(t2));
        }
        return destination;
    }

    public static <T> T last(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (!list.isEmpty()) {
            return list.get(CollectionsKt__CollectionsKt.getLastIndex(list));
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static final <T> T lastOrNull(Iterable<? extends T> iterable, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        T t2 = null;
        for (T t3 : iterable) {
            if (((Boolean) predicate.invoke(t3)).booleanValue()) {
                t2 = t3;
            }
        }
        return t2;
    }

    /* JADX INFO: renamed from: maxOf, reason: collision with other method in class */
    private static final <T> float m1451maxOf(Iterable<? extends T> iterable, Function1<? super T, Float> selector) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            float fFloatValue = ((Number) selector.invoke(it.next())).floatValue();
            while (it.hasNext()) {
                fFloatValue = Math.max(fFloatValue, ((Number) selector.invoke(it.next())).floatValue());
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final <T> Float m1454maxOfOrNull(Iterable<? extends T> iterable, Function1<? super T, Float> selector) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        float fFloatValue = ((Number) selector.invoke(it.next())).floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, ((Number) selector.invoke(it.next())).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: renamed from: maxOrNull, reason: collision with other method in class */
    public static Float m1456maxOrNull(Iterable<Float> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<Float> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        float fFloatValue = it.next().floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, it.next().floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: renamed from: maxOrThrow, reason: collision with other method in class */
    public static final float m1457maxOrThrow(Iterable<Float> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<Float> it = iterable.iterator();
        if (it.hasNext()) {
            float fFloatValue = it.next().floatValue();
            while (it.hasNext()) {
                fFloatValue = Math.max(fFloatValue, it.next().floatValue());
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOf, reason: collision with other method in class */
    private static final <T> float m1459minOf(Iterable<? extends T> iterable, Function1<? super T, Float> selector) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            float fFloatValue = ((Number) selector.invoke(it.next())).floatValue();
            while (it.hasNext()) {
                fFloatValue = Math.min(fFloatValue, ((Number) selector.invoke(it.next())).floatValue());
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOfOrNull, reason: collision with other method in class */
    private static final <T> Float m1462minOfOrNull(Iterable<? extends T> iterable, Function1<? super T, Float> selector) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        float fFloatValue = ((Number) selector.invoke(it.next())).floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, ((Number) selector.invoke(it.next())).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: renamed from: minOrNull, reason: collision with other method in class */
    public static Float m1464minOrNull(Iterable<Float> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<Float> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        float fFloatValue = it.next().floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, it.next().floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: renamed from: minOrThrow, reason: collision with other method in class */
    public static final float m1465minOrThrow(Iterable<Float> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<Float> it = iterable.iterator();
        if (it.hasNext()) {
            float fFloatValue = it.next().floatValue();
            while (it.hasNext()) {
                fFloatValue = Math.min(fFloatValue, it.next().floatValue());
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    public static final <T> List<T> plus(Iterable<? extends T> iterable, T[] elements) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (iterable instanceof Collection) {
            return plus((Collection) iterable, (Object[]) elements);
        }
        ArrayList arrayList = new ArrayList();
        CollectionsKt__MutableCollectionsKt.addAll(arrayList, iterable);
        CollectionsKt__MutableCollectionsKt.addAll(arrayList, elements);
        return arrayList;
    }

    public static <T> T single(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        }
        if (size == 1) {
            return list.get(0);
        }
        throw new IllegalArgumentException("List has more than one element.");
    }

    public static final <T> List<Pair<T, T>> zipWithNext(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            arrayList.add(TuplesKt.a(next, next2));
            next = next2;
        }
        return arrayList;
    }

    public static final <T> T first(Iterable<? extends T> iterable, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (T t2 : iterable) {
            if (((Boolean) predicate.invoke(t2)).booleanValue()) {
                return t2;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K, V> Map<K, List<V>> groupBy(Iterable<? extends T> iterable, Function1<? super T, ? extends K> keySelector, Function1<? super T, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t2 : iterable) {
            Object objInvoke = keySelector.invoke(t2);
            Object arrayList = linkedHashMap.get(objInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(objInvoke, arrayList);
            }
            ((List) arrayList).add(valueTransform.invoke(t2));
        }
        return linkedHashMap;
    }

    public static final <T> T lastOrNull(List<? extends T> list, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            T tPrevious = listIterator.previous();
            if (((Boolean) predicate.invoke(tPrevious)).booleanValue()) {
                return tPrevious;
            }
        }
        return null;
    }

    public static <T> List<T> minus(Iterable<? extends T> iterable, Iterable<? extends T> elements) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        Collection collectionConvertToListIfNotCollection = CollectionsKt__MutableCollectionsKt.convertToListIfNotCollection(elements);
        if (collectionConvertToListIfNotCollection.isEmpty()) {
            return toList(iterable);
        }
        ArrayList arrayList = new ArrayList();
        for (T t2 : iterable) {
            if (!collectionConvertToListIfNotCollection.contains(t2)) {
                arrayList.add(t2);
            }
        }
        return arrayList;
    }

    public static final <T, R> List<Pair<T, R>> zip(Iterable<? extends T> iterable, R[] other) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int length = other.length;
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10), length));
        int i3 = 0;
        for (T t2 : iterable) {
            if (i3 >= length) {
                break;
            }
            arrayList.add(TuplesKt.a(t2, other[i3]));
            i3++;
        }
        return arrayList;
    }

    public static final <T> T last(Iterable<? extends T> iterable, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        T t2 = null;
        boolean z2 = false;
        for (T t3 : iterable) {
            if (((Boolean) predicate.invoke(t3)).booleanValue()) {
                z2 = true;
                t2 = t3;
            }
        }
        if (z2) {
            return t2;
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public static <T> List<T> plus(Collection<? extends T> collection, T[] elements) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        ArrayList arrayList = new ArrayList(collection.size() + elements.length);
        arrayList.addAll(collection);
        CollectionsKt__MutableCollectionsKt.addAll(arrayList, elements);
        return arrayList;
    }

    public static final <T> T single(Iterable<? extends T> iterable, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        T t2 = null;
        boolean z2 = false;
        for (T t3 : iterable) {
            if (((Boolean) predicate.invoke(t3)).booleanValue()) {
                if (z2) {
                    throw new IllegalArgumentException("Collection contains more than one matching element.");
                }
                z2 = true;
                t2 = t3;
            }
        }
        if (z2) {
            return t2;
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public static final <T, R> List<R> windowed(Iterable<? extends T> iterable, int i3, int i4, boolean z2, Function1<? super List<? extends T>, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        SlidingWindowKt.checkWindowSizeStep(i3, i4);
        if ((iterable instanceof RandomAccess) && (iterable instanceof List)) {
            List list = (List) iterable;
            int size = list.size();
            int i5 = 0;
            ArrayList arrayList = new ArrayList((size / i4) + (size % i4 == 0 ? 0 : 1));
            MovingSubList movingSubList = new MovingSubList(list);
            while (i5 >= 0 && i5 < size) {
                int iK = RangesKt.k(i3, size - i5);
                if (!z2 && iK < i3) {
                    return arrayList;
                }
                movingSubList.move(i5, iK + i5);
                arrayList.add(transform.invoke(movingSubList));
                i5 += i4;
            }
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator itWindowedIterator = SlidingWindowKt.windowedIterator(iterable.iterator(), i3, i4, z2, true);
        while (itWindowedIterator.hasNext()) {
            arrayList2.add(transform.invoke((List) itWindowedIterator.next()));
        }
        return arrayList2;
    }

    public static final <T> T last(List<? extends T> list, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            T tPrevious = listIterator.previous();
            if (((Boolean) predicate.invoke(tPrevious)).booleanValue()) {
                return tPrevious;
            }
        }
        throw new NoSuchElementException("List contains no element matching the predicate.");
    }

    /* JADX INFO: renamed from: maxOf, reason: collision with other method in class */
    private static final <T, R extends Comparable<? super R>> R m1452maxOf(Iterable<? extends T> iterable, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            R r2 = (R) selector.invoke(it.next());
            while (it.hasNext()) {
                Comparable comparable = (Comparable) selector.invoke(it.next());
                if (r2.compareTo(comparable) < 0) {
                    r2 = (R) comparable;
                }
            }
            return r2;
        }
        throw new NoSuchElementException();
    }

    private static final <T, R extends Comparable<? super R>> R maxOfOrNull(Iterable<? extends T> iterable, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        R r2 = (R) selector.invoke(it.next());
        while (it.hasNext()) {
            Comparable comparable = (Comparable) selector.invoke(it.next());
            if (r2.compareTo(comparable) < 0) {
                r2 = (R) comparable;
            }
        }
        return r2;
    }

    public static <T extends Comparable<? super T>> T maxOrNull(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) < 0) {
                next = next2;
            }
        }
        return next;
    }

    /* JADX INFO: renamed from: maxOrThrow, reason: collision with other method in class */
    public static final <T extends Comparable<? super T>> T m1458maxOrThrow(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            while (it.hasNext()) {
                T next2 = it.next();
                if (next.compareTo(next2) < 0) {
                    next = next2;
                }
            }
            return next;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOf, reason: collision with other method in class */
    private static final <T, R extends Comparable<? super R>> R m1460minOf(Iterable<? extends T> iterable, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            R r2 = (R) selector.invoke(it.next());
            while (it.hasNext()) {
                Comparable comparable = (Comparable) selector.invoke(it.next());
                if (r2.compareTo(comparable) > 0) {
                    r2 = (R) comparable;
                }
            }
            return r2;
        }
        throw new NoSuchElementException();
    }

    private static final <T, R extends Comparable<? super R>> R minOfOrNull(Iterable<? extends T> iterable, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        R r2 = (R) selector.invoke(it.next());
        while (it.hasNext()) {
            Comparable comparable = (Comparable) selector.invoke(it.next());
            if (r2.compareTo(comparable) > 0) {
                r2 = (R) comparable;
            }
        }
        return r2;
    }

    public static <T extends Comparable<? super T>> T minOrNull(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) > 0) {
                next = next2;
            }
        }
        return next;
    }

    /* JADX INFO: renamed from: minOrThrow, reason: collision with other method in class */
    public static final <T extends Comparable<? super T>> T m1466minOrThrow(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            while (it.hasNext()) {
                T next2 = it.next();
                if (next.compareTo(next2) > 0) {
                    next = next2;
                }
            }
            return next;
        }
        throw new NoSuchElementException();
    }

    public static <T> List<T> plus(Iterable<? extends T> iterable, Iterable<? extends T> elements) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (iterable instanceof Collection) {
            return plus((Collection) iterable, (Iterable) elements);
        }
        ArrayList arrayList = new ArrayList();
        CollectionsKt__MutableCollectionsKt.addAll(arrayList, iterable);
        CollectionsKt__MutableCollectionsKt.addAll(arrayList, elements);
        return arrayList;
    }

    public static <T, R> List<Pair<T, R>> zip(Iterable<? extends T> iterable, Iterable<? extends R> other) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Iterator<? extends T> it = iterable.iterator();
        Iterator<? extends R> it2 = other.iterator();
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10), CollectionsKt__IterablesKt.collectionSizeOrDefault(other, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(TuplesKt.a(it.next(), it2.next()));
        }
        return arrayList;
    }

    public static final <T> List<T> minus(Iterable<? extends T> iterable, Sequence<? extends T> elements) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        List listS = SequencesKt.S(elements);
        if (listS.isEmpty()) {
            return toList(iterable);
        }
        ArrayList arrayList = new ArrayList();
        for (T t2 : iterable) {
            if (!listS.contains(t2)) {
                arrayList.add(t2);
            }
        }
        return arrayList;
    }

    public static <T> List<T> plus(Collection<? extends T> collection, Iterable<? extends T> elements) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements instanceof Collection) {
            Collection collection2 = (Collection) elements;
            ArrayList arrayList = new ArrayList(collection.size() + collection2.size());
            arrayList.addAll(collection);
            arrayList.addAll(collection2);
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(collection);
        CollectionsKt__MutableCollectionsKt.addAll(arrayList2, elements);
        return arrayList2;
    }

    public static final <T> List<T> plus(Iterable<? extends T> iterable, Sequence<? extends T> elements) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        ArrayList arrayList = new ArrayList();
        CollectionsKt__MutableCollectionsKt.addAll(arrayList, iterable);
        CollectionsKt__MutableCollectionsKt.addAll(arrayList, elements);
        return arrayList;
    }

    public static final <T> List<T> plus(Collection<? extends T> collection, Sequence<? extends T> elements) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        ArrayList arrayList = new ArrayList(collection.size() + 10);
        arrayList.addAll(collection);
        CollectionsKt__MutableCollectionsKt.addAll(arrayList, elements);
        return arrayList;
    }
}
