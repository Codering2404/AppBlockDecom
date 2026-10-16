package kotlin.collections;

import androidx.compose.material.icons.twotone.Phg.QaXmqxvjHhxVy;
import androidx.datastore.preferences.core.SfRj.rnFwbPAQmQTnL;
import androidx.glance.color.Tq.KqqtdetwHMIO;
import androidx.glance.session.ecY.lisODU;
import androidx.legacy.content.Werj.QgXempTBEfV;
import androidx.media3.extractor.jpeg.xWt.jTYhJgqLBN;
import coil.target.Yb.oUcQRqOVfOC;
import com.applovin.impl.mediation.nativeAds.xNe.qRMDmh;
import com.bumptech.glide.load.data.Bwyd.SbbqvQlxi;
import com.facebook.internal.instrument.anrreport.jRA.jlWo;
import com.facebook.share.HKJ.pnxuebdT;
import com.google.android.material.bottomsheet.lKiE.YznnJpHcAmeoW;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.revenuecat.purchases.ui.revenuecatui.templates.VWmQ.cJfnYMIyomoWf;
import cz.mobilesoft.coreblock.scene.lockscreen.EI.MrGIhy;
import cz.mobilesoft.coreblock.scene.permission.permissions.success.lbR.YgVrd;
import cz.mobilesoft.coreblock.view.screen.ohO.MHoiDDglUlPJC;
import d.qFm.sECyKyO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
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
import kotlin.comparisons.xn.YvFRmou;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.ArrayIteratorsKt;
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
public class ArraysKt___ArraysKt extends ArraysKt___ArraysJvmKt {
    public static final <T> boolean all(T[] tArr, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (T t2 : tArr) {
            if (!((Boolean) predicate.invoke(t2)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <T> boolean any(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return !(tArr.length == 0);
    }

    public static <T> Iterable<T> asIterable(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return tArr.length == 0 ? CollectionsKt__CollectionsKt.emptyList() : new ArraysKt___ArraysKt$asIterable$$inlined$Iterable$1(tArr);
    }

    public static <T> Sequence<T> asSequence(final T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return tArr.length == 0 ? SequencesKt.g() : new Sequence<T>() { // from class: kotlin.collections.ArraysKt___ArraysKt$asSequence$$inlined$Sequence$1
            @Override // kotlin.sequences.Sequence
            public Iterator<T> iterator() {
                return ArrayIteratorKt.a(tArr);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K, V> Map<K, V> associate(T[] tArr, Function1<? super T, ? extends Pair<? extends K, ? extends V>> transform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt__MapsJVMKt.mapCapacity(tArr.length), 16));
        for (T t2 : tArr) {
            Pair pair = (Pair) transform.invoke(t2);
            linkedHashMap.put(pair.e(), pair.f());
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K> Map<K, T> associateBy(T[] tArr, Function1<? super T, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt__MapsJVMKt.mapCapacity(tArr.length), 16));
        for (T t2 : tArr) {
            linkedHashMap.put(keySelector.invoke(t2), t2);
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K, M extends Map<? super K, ? super T>> M associateByTo(T[] tArr, M destination, Function1<? super T, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (T t2 : tArr) {
            destination.put(keySelector.invoke(t2), t2);
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K, V, M extends Map<? super K, ? super V>> M associateTo(T[] tArr, M destination, Function1<? super T, ? extends Pair<? extends K, ? extends V>> transform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (T t2 : tArr) {
            Pair pair = (Pair) transform.invoke(t2);
            destination.put(pair.e(), pair.f());
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> associateWith(K[] kArr, Function1<? super K, ? extends V> valueSelector) {
        Intrinsics.checkNotNullParameter(kArr, "<this>");
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt__MapsJVMKt.mapCapacity(kArr.length), 16));
        for (K k3 : kArr) {
            linkedHashMap.put(k3, valueSelector.invoke(k3));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, ? super V>> M associateWithTo(K[] kArr, M destination, Function1<? super K, ? extends V> valueSelector) {
        Intrinsics.checkNotNullParameter(kArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        for (K k3 : kArr) {
            destination.put(k3, valueSelector.invoke(k3));
        }
        return destination;
    }

    public static final double average(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        double d3 = 0.0d;
        int i3 = 0;
        for (byte b3 : bArr) {
            d3 += (double) b3;
            i3++;
        }
        if (i3 == 0) {
            return Double.NaN;
        }
        return d3 / ((double) i3);
    }

    public static final double averageOfByte(Byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        double dByteValue = 0.0d;
        int i3 = 0;
        for (Byte b3 : bArr) {
            dByteValue += (double) b3.byteValue();
            i3++;
        }
        if (i3 == 0) {
            return Double.NaN;
        }
        return dByteValue / ((double) i3);
    }

    public static final double averageOfDouble(Double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        double dDoubleValue = 0.0d;
        int i3 = 0;
        for (Double d3 : dArr) {
            dDoubleValue += d3.doubleValue();
            i3++;
        }
        if (i3 == 0) {
            return Double.NaN;
        }
        return dDoubleValue / ((double) i3);
    }

    public static final double averageOfFloat(Float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        double dFloatValue = 0.0d;
        int i3 = 0;
        for (Float f3 : fArr) {
            dFloatValue += (double) f3.floatValue();
            i3++;
        }
        if (i3 == 0) {
            return Double.NaN;
        }
        return dFloatValue / ((double) i3);
    }

    public static final double averageOfInt(Integer[] numArr) {
        Intrinsics.checkNotNullParameter(numArr, "<this>");
        double dIntValue = 0.0d;
        int i3 = 0;
        for (Integer num : numArr) {
            dIntValue += (double) num.intValue();
            i3++;
        }
        if (i3 == 0) {
            return Double.NaN;
        }
        return dIntValue / ((double) i3);
    }

    public static final double averageOfLong(Long[] lArr) {
        Intrinsics.checkNotNullParameter(lArr, "<this>");
        double dLongValue = 0.0d;
        int i3 = 0;
        for (Long l3 : lArr) {
            dLongValue += l3.longValue();
            i3++;
        }
        if (i3 == 0) {
            return Double.NaN;
        }
        return dLongValue / ((double) i3);
    }

    public static final double averageOfShort(Short[] shArr) {
        Intrinsics.checkNotNullParameter(shArr, "<this>");
        double dShortValue = 0.0d;
        int i3 = 0;
        for (Short sh : shArr) {
            dShortValue += (double) sh.shortValue();
            i3++;
        }
        if (i3 == 0) {
            return Double.NaN;
        }
        return dShortValue / ((double) i3);
    }

    private static final <T> T component1(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return tArr[0];
    }

    private static final <T> T component2(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return tArr[1];
    }

    private static final <T> T component3(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return tArr[2];
    }

    private static final <T> T component4(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return tArr[3];
    }

    private static final <T> T component5(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return tArr[4];
    }

    public static <T> boolean contains(T[] tArr, T t2) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return indexOf(tArr, t2) >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> T[] copyOf(T[] tArr, int i3, Function1<? super Integer, ? extends T> init) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(init, "init");
        if (i3 < 0) {
            throw new IllegalArgumentException(("Invalid new array size: " + i3 + '.').toString());
        }
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, i3);
        Intrinsics.checkNotNullExpressionValue(tArr2, "copyOf(...)");
        for (int length = tArr.length; length < i3; length++) {
            tArr2[length] = init.invoke(Integer.valueOf(length));
        }
        return tArr2;
    }

    private static final <T> int count(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return tArr.length;
    }

    public static final <T> List<T> distinct(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return CollectionsKt___CollectionsKt.toList(toMutableSet(tArr));
    }

    public static final <T, K> List<T> distinctBy(T[] tArr, Function1<? super T, ? extends K> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (T t2 : tArr) {
            if (hashSet.add(selector.invoke(t2))) {
                arrayList.add(t2);
            }
        }
        return arrayList;
    }

    public static <T> List<T> drop(T[] tArr, int i3) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (i3 >= 0) {
            return takeLast(tArr, RangesKt.f(tArr.length - i3, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
    }

    public static final <T> List<T> dropLast(T[] tArr, int i3) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (i3 >= 0) {
            return take(tArr, RangesKt.f(tArr.length - i3, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
    }

    public static final <T> List<T> dropLastWhile(T[] tArr, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = getLastIndex(tArr); -1 < lastIndex; lastIndex--) {
            if (!((Boolean) predicate.invoke(tArr[lastIndex])).booleanValue()) {
                return take(tArr, lastIndex + 1);
            }
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    public static final <T> List<T> dropWhile(T[] tArr, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z2 = false;
        for (T t2 : tArr) {
            if (z2) {
                arrayList.add(t2);
            } else if (!((Boolean) predicate.invoke(t2)).booleanValue()) {
                arrayList.add(t2);
                z2 = true;
            }
        }
        return arrayList;
    }

    private static final <T> T elementAtOrElse(T[] tArr, int i3, Function1<? super Integer, ? extends T> defaultValue) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return (i3 < 0 || i3 >= tArr.length) ? (T) defaultValue.invoke(Integer.valueOf(i3)) : tArr[i3];
    }

    private static final <T> T elementAtOrNull(T[] tArr, int i3) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return (T) getOrNull(tArr, i3);
    }

    public static final <T> List<T> filter(T[] tArr, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t2 : tArr) {
            if (((Boolean) predicate.invoke(t2)).booleanValue()) {
                arrayList.add(t2);
            }
        }
        return arrayList;
    }

    public static final <T> List<T> filterIndexed(T[] tArr, Function2<? super Integer, ? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = tArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            T t2 = tArr[i3];
            int i5 = i4 + 1;
            if (((Boolean) predicate.invoke(Integer.valueOf(i4), t2)).booleanValue()) {
                arrayList.add(t2);
            }
            i3++;
            i4 = i5;
        }
        return arrayList;
    }

    public static final <T, C extends Collection<? super T>> C filterIndexedTo(T[] tArr, C destination, Function2<? super Integer, ? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = tArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            T t2 = tArr[i3];
            int i5 = i4 + 1;
            if (((Boolean) predicate.invoke(Integer.valueOf(i4), t2)).booleanValue()) {
                destination.add(t2);
            }
            i3++;
            i4 = i5;
        }
        return destination;
    }

    public static final /* synthetic */ <R> List<R> filterIsInstance(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            Intrinsics.reifiedOperationMarker(3, "R");
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final /* synthetic */ <R, C extends Collection<? super R>> C filterIsInstanceTo(Object[] objArr, C destination) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        for (Object obj : objArr) {
            Intrinsics.reifiedOperationMarker(3, "R");
            if (obj != null) {
                destination.add(obj);
            }
        }
        return destination;
    }

    public static final <T> List<T> filterNot(T[] tArr, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t2 : tArr) {
            if (!((Boolean) predicate.invoke(t2)).booleanValue()) {
                arrayList.add(t2);
            }
        }
        return arrayList;
    }

    public static <T> List<T> filterNotNull(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return (List) filterNotNullTo(tArr, new ArrayList());
    }

    public static final <C extends Collection<? super T>, T> C filterNotNullTo(T[] tArr, C destination) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        for (T t2 : tArr) {
            if (t2 != null) {
                destination.add(t2);
            }
        }
        return destination;
    }

    public static final <T, C extends Collection<? super T>> C filterNotTo(T[] tArr, C destination, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (T t2 : tArr) {
            if (!((Boolean) predicate.invoke(t2)).booleanValue()) {
                destination.add(t2);
            }
        }
        return destination;
    }

    public static final <T, C extends Collection<? super T>> C filterTo(T[] tArr, C destination, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (T t2 : tArr) {
            if (((Boolean) predicate.invoke(t2)).booleanValue()) {
                destination.add(t2);
            }
        }
        return destination;
    }

    private static final <T> T find(T[] tArr, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (T t2 : tArr) {
            if (((Boolean) predicate.invoke(t2)).booleanValue()) {
                return t2;
            }
        }
        return null;
    }

    private static final <T> T findLast(T[] tArr, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, oUcQRqOVfOC.TnmYf);
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = tArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i3 = length - 1;
            T t2 = tArr[length];
            if (((Boolean) predicate.invoke(t2)).booleanValue()) {
                return t2;
            }
            if (i3 < 0) {
                return null;
            }
            length = i3;
        }
    }

    public static <T> T first(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length != 0) {
            return tArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    private static final <T, R> R firstNotNullOfOrNull(T[] tArr, Function1<? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (T t2 : tArr) {
            R r2 = (R) transform.invoke(t2);
            if (r2 != null) {
                return r2;
            }
        }
        return null;
    }

    public static <T> T firstOrNull(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length == 0) {
            return null;
        }
        return tArr[0];
    }

    public static final <T, R> List<R> flatMap(T[] tArr, Function1<? super T, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (T t2 : tArr) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, (Iterable) transform.invoke(t2));
        }
        return arrayList;
    }

    private static final <T, R> List<R> flatMapIndexedIterable(T[] tArr, Function2<? super Integer, ? super T, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = tArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, (Iterable) transform.invoke(Integer.valueOf(i4), tArr[i3]));
            i3++;
            i4++;
        }
        return arrayList;
    }

    private static final <T, R, C extends Collection<? super R>> C flatMapIndexedIterableTo(T[] tArr, C destination, Function2<? super Integer, ? super T, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = tArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            CollectionsKt__MutableCollectionsKt.addAll(destination, (Iterable) transform.invoke(Integer.valueOf(i4), tArr[i3]));
            i3++;
            i4++;
        }
        return destination;
    }

    private static final <T, R> List<R> flatMapIndexedSequence(T[] tArr, Function2<? super Integer, ? super T, ? extends Sequence<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = tArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, (Sequence) transform.invoke(Integer.valueOf(i4), tArr[i3]));
            i3++;
            i4++;
        }
        return arrayList;
    }

    private static final <T, R, C extends Collection<? super R>> C flatMapIndexedSequenceTo(T[] tArr, C destination, Function2<? super Integer, ? super T, ? extends Sequence<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = tArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            CollectionsKt__MutableCollectionsKt.addAll(destination, (Sequence) transform.invoke(Integer.valueOf(i4), tArr[i3]));
            i3++;
            i4++;
        }
        return destination;
    }

    public static final <T, R> List<R> flatMapSequence(T[] tArr, Function1<? super T, ? extends Sequence<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (T t2 : tArr) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, (Sequence) transform.invoke(t2));
        }
        return arrayList;
    }

    public static final <T, R, C extends Collection<? super R>> C flatMapSequenceTo(T[] tArr, C destination, Function1<? super T, ? extends Sequence<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (T t2 : tArr) {
            CollectionsKt__MutableCollectionsKt.addAll(destination, (Sequence) transform.invoke(t2));
        }
        return destination;
    }

    public static final <T, R, C extends Collection<? super R>> C flatMapTo(T[] tArr, C destination, Function1<? super T, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (T t2 : tArr) {
            CollectionsKt__MutableCollectionsKt.addAll(destination, (Iterable) transform.invoke(t2));
        }
        return destination;
    }

    public static final <T, R> R fold(T[] tArr, R r2, Function2<? super R, ? super T, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (T t2 : tArr) {
            r2 = (R) operation.invoke(r2, t2);
        }
        return r2;
    }

    public static final <T, R> R foldIndexed(T[] tArr, R r2, Function3<? super Integer, ? super R, ? super T, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int length = tArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            r2 = (R) operation.invoke(Integer.valueOf(i4), r2, tArr[i3]);
            i3++;
            i4++;
        }
        return r2;
    }

    public static final <T, R> R foldRight(T[] tArr, R r2, Function2<? super T, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = getLastIndex(tArr); lastIndex >= 0; lastIndex--) {
            r2 = (R) operation.invoke(tArr[lastIndex], r2);
        }
        return r2;
    }

    public static final <T, R> R foldRightIndexed(T[] tArr, R r2, Function3<? super Integer, ? super T, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = getLastIndex(tArr); lastIndex >= 0; lastIndex--) {
            r2 = (R) operation.invoke(Integer.valueOf(lastIndex), tArr[lastIndex], r2);
        }
        return r2;
    }

    public static final <T> void forEach(T[] tArr, Function1<? super T, Unit> action) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        for (T t2 : tArr) {
            action.invoke(t2);
        }
    }

    public static final <T> void forEachIndexed(T[] tArr, Function2<? super Integer, ? super T, Unit> action) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int length = tArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            action.invoke(Integer.valueOf(i4), tArr[i3]);
            i3++;
            i4++;
        }
    }

    public static <T> IntRange getIndices(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return new IntRange(0, getLastIndex(tArr));
    }

    public static <T> int getLastIndex(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return tArr.length - 1;
    }

    private static final <T> T getOrElse(T[] tArr, int i3, Function1<? super Integer, ? extends T> defaultValue) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return (i3 < 0 || i3 >= tArr.length) ? (T) defaultValue.invoke(Integer.valueOf(i3)) : tArr[i3];
    }

    public static <T> T getOrNull(T[] tArr, int i3) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (i3 < 0 || i3 >= tArr.length) {
            return null;
        }
        return tArr[i3];
    }

    public static final <T, K> Map<K, List<T>> groupBy(T[] tArr, Function1<? super T, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t2 : tArr) {
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

    public static final <T, K, M extends Map<? super K, List<T>>> M groupByTo(T[] tArr, M destination, Function1<? super T, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (T t2 : tArr) {
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

    public static final <T, K> Grouping<T, K> groupingBy(final T[] tArr, final Function1<? super T, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        return new Grouping<T, K>() { // from class: kotlin.collections.ArraysKt___ArraysKt.groupingBy.1
            @Override // kotlin.collections.Grouping
            public K keyOf(T t2) {
                return (K) keySelector.invoke(t2);
            }

            @Override // kotlin.collections.Grouping
            public Iterator<T> sourceIterator() {
                return ArrayIteratorKt.a(tArr);
            }
        };
    }

    public static <T> int indexOf(T[] tArr, T t2) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        int i3 = 0;
        if (t2 == null) {
            int length = tArr.length;
            while (i3 < length) {
                if (tArr[i3] == null) {
                    return i3;
                }
                i3++;
            }
            return -1;
        }
        int length2 = tArr.length;
        while (i3 < length2) {
            if (Intrinsics.areEqual(t2, tArr[i3])) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    public static final <T> int indexOfFirst(T[] tArr, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = tArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (((Boolean) predicate.invoke(tArr[i3])).booleanValue()) {
                return i3;
            }
        }
        return -1;
    }

    public static final <T> int indexOfLast(T[] tArr, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = tArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i3 = length - 1;
                if (((Boolean) predicate.invoke(tArr[length])).booleanValue()) {
                    return length;
                }
                if (i3 < 0) {
                    break;
                }
                length = i3;
            }
        }
        return -1;
    }

    public static final <T> Set<T> intersect(T[] tArr, Iterable<? extends T> other) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<T> mutableSet = toMutableSet(tArr);
        CollectionsKt__MutableCollectionsKt.retainAll(mutableSet, other);
        return mutableSet;
    }

    private static final <T> boolean isEmpty(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return tArr.length == 0;
    }

    private static final <T> boolean isNotEmpty(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return !(tArr.length == 0);
    }

    public static final <T, A extends Appendable> A joinTo(T[] tArr, A a3, CharSequence separator, CharSequence prefix, CharSequence postfix, int i3, CharSequence truncated, Function1<? super T, ? extends CharSequence> function1) throws IOException {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(a3, YgVrd.OfCcvOXFsomS);
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        a3.append(prefix);
        int i4 = 0;
        for (T t2 : tArr) {
            i4++;
            if (i4 > 1) {
                a3.append(separator);
            }
            if (i3 >= 0 && i4 > i3) {
                break;
            }
            StringsKt.a(a3, t2, function1);
        }
        if (i3 >= 0 && i4 > i3) {
            a3.append(truncated);
        }
        a3.append(postfix);
        return a3;
    }

    public static final <T> String joinToString(T[] tArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i3, CharSequence truncated, Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        return ((StringBuilder) joinTo(tArr, new StringBuilder(), separator, prefix, postfix, i3, truncated, function1)).toString();
    }

    public static /* synthetic */ String joinToString$default(Object[] objArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i3, CharSequence charSequence4, Function1 function1, int i4, Object obj) {
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
        return joinToString(objArr, charSequence, charSequence2, charSequence3, i3, charSequence5, function12);
    }

    public static <T> T last(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length != 0) {
            return tArr[getLastIndex(tArr)];
        }
        throw new NoSuchElementException(QaXmqxvjHhxVy.tbVYRb);
    }

    public static <T> int lastIndexOf(T[] tArr, T t2) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (t2 == null) {
            int length = tArr.length - 1;
            if (length >= 0) {
                while (true) {
                    int i3 = length - 1;
                    if (tArr[length] == null) {
                        return length;
                    }
                    if (i3 < 0) {
                        break;
                    }
                    length = i3;
                }
            }
        } else {
            int length2 = tArr.length - 1;
            if (length2 >= 0) {
                while (true) {
                    int i4 = length2 - 1;
                    if (Intrinsics.areEqual(t2, tArr[length2])) {
                        return length2;
                    }
                    if (i4 < 0) {
                        break;
                    }
                    length2 = i4;
                }
            }
        }
        return -1;
    }

    public static <T> T lastOrNull(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length == 0) {
            return null;
        }
        return tArr[tArr.length - 1];
    }

    public static final <T, R> List<R> map(T[] tArr, Function1<? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(tArr.length);
        for (T t2 : tArr) {
            arrayList.add(transform.invoke(t2));
        }
        return arrayList;
    }

    public static final <T, R> List<R> mapIndexed(T[] tArr, Function2<? super Integer, ? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(tArr.length);
        int length = tArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            arrayList.add(transform.invoke(Integer.valueOf(i4), tArr[i3]));
            i3++;
            i4++;
        }
        return arrayList;
    }

    public static final <T, R> List<R> mapIndexedNotNull(T[] tArr, Function2<? super Integer, ? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = tArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            int i5 = i4 + 1;
            Object objInvoke = transform.invoke(Integer.valueOf(i4), tArr[i3]);
            if (objInvoke != null) {
                arrayList.add(objInvoke);
            }
            i3++;
            i4 = i5;
        }
        return arrayList;
    }

    public static final <T, R, C extends Collection<? super R>> C mapIndexedNotNullTo(T[] tArr, C destination, Function2<? super Integer, ? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = tArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            int i5 = i4 + 1;
            Object objInvoke = transform.invoke(Integer.valueOf(i4), tArr[i3]);
            if (objInvoke != null) {
                destination.add(objInvoke);
            }
            i3++;
            i4 = i5;
        }
        return destination;
    }

    public static final <T, R, C extends Collection<? super R>> C mapIndexedTo(T[] tArr, C destination, Function2<? super Integer, ? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = tArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            destination.add(transform.invoke(Integer.valueOf(i4), tArr[i3]));
            i3++;
            i4++;
        }
        return destination;
    }

    public static final <T, R> List<R> mapNotNull(T[] tArr, Function1<? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (T t2 : tArr) {
            Object objInvoke = transform.invoke(t2);
            if (objInvoke != null) {
                arrayList.add(objInvoke);
            }
        }
        return arrayList;
    }

    public static final <T, R, C extends Collection<? super R>> C mapNotNullTo(T[] tArr, C destination, Function1<? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (T t2 : tArr) {
            Object objInvoke = transform.invoke(t2);
            if (objInvoke != null) {
                destination.add(objInvoke);
            }
        }
        return destination;
    }

    public static final <T, R, C extends Collection<? super R>> C mapTo(T[] tArr, C destination, Function1<? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (T t2 : tArr) {
            destination.add(transform.invoke(t2));
        }
        return destination;
    }

    public static final <T, R extends Comparable<? super R>> T maxByOrNull(T[] tArr, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        T t2 = tArr[0];
        int lastIndex = getLastIndex(tArr);
        if (lastIndex != 0) {
            Comparable comparable = (Comparable) selector.invoke(t2);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    T t3 = tArr[i3];
                    Comparable comparable2 = (Comparable) selector.invoke(t3);
                    if (comparable.compareTo(comparable2) < 0) {
                        t2 = t3;
                        comparable = comparable2;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
        }
        return t2;
    }

    public static final <T, R extends Comparable<? super R>> T maxByOrThrow(T[] tArr, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        T t2 = tArr[0];
        int lastIndex = getLastIndex(tArr);
        if (lastIndex != 0) {
            Comparable comparable = (Comparable) selector.invoke(t2);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    T t3 = tArr[i3];
                    Comparable comparable2 = (Comparable) selector.invoke(t3);
                    if (comparable.compareTo(comparable2) < 0) {
                        t2 = t3;
                        comparable = comparable2;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
        }
        return t2;
    }

    private static final <T> double maxOf(T[] tArr, Function1<? super T, Double> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = ((Number) selector.invoke(tArr[0])).doubleValue();
        int lastIndex = getLastIndex(tArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.max(dDoubleValue, ((Number) selector.invoke(tArr[i3])).doubleValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return dDoubleValue;
    }

    /* JADX INFO: renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final <T> Double m1399maxOfOrNull(T[] tArr, Function1<? super T, Double> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        double dDoubleValue = ((Number) selector.invoke(tArr[0])).doubleValue();
        int lastIndex = getLastIndex(tArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.max(dDoubleValue, ((Number) selector.invoke(tArr[i3])).doubleValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    private static final <T, R> R maxOfWith(T[] tArr, Comparator<? super R> comparator, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        R r2 = (Object) selector.invoke(tArr[0]);
        int lastIndex = getLastIndex(tArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object obj = (Object) selector.invoke(tArr[i3]);
                if (comparator.compare(r2, obj) < 0) {
                    r2 = (R) obj;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    private static final <T, R> R maxOfWithOrNull(T[] tArr, Comparator<? super R> comparator, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        R r2 = (Object) selector.invoke(tArr[0]);
        int lastIndex = getLastIndex(tArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object obj = (Object) selector.invoke(tArr[i3]);
                if (comparator.compare(r2, obj) < 0) {
                    r2 = (R) obj;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    public static final Double maxOrNull(Double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (dArr.length == 0) {
            return null;
        }
        double dDoubleValue = dArr[0].doubleValue();
        int lastIndex = getLastIndex(dArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.max(dDoubleValue, dArr[i3].doubleValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    public static final double maxOrThrow(Double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = dArr[0].doubleValue();
        int lastIndex = getLastIndex(dArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.max(dDoubleValue, dArr[i3].doubleValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return dDoubleValue;
    }

    public static final <T> T maxWithOrNull(T[] tArr, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (tArr.length == 0) {
            return null;
        }
        T t2 = tArr[0];
        int lastIndex = getLastIndex(tArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                T t3 = tArr[i3];
                if (comparator.compare(t2, t3) < 0) {
                    t2 = t3;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return t2;
    }

    public static final <T> T maxWithOrThrow(T[] tArr, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        T t2 = tArr[0];
        int lastIndex = getLastIndex(tArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                T t3 = tArr[i3];
                if (comparator.compare(t2, t3) < 0) {
                    t2 = t3;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return t2;
    }

    public static final <T, R extends Comparable<? super R>> T minByOrNull(T[] tArr, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        T t2 = tArr[0];
        int lastIndex = getLastIndex(tArr);
        if (lastIndex != 0) {
            Comparable comparable = (Comparable) selector.invoke(t2);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    T t3 = tArr[i3];
                    Comparable comparable2 = (Comparable) selector.invoke(t3);
                    if (comparable.compareTo(comparable2) > 0) {
                        t2 = t3;
                        comparable = comparable2;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
        }
        return t2;
    }

    public static final <T, R extends Comparable<? super R>> T minByOrThrow(T[] tArr, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        T t2 = tArr[0];
        int lastIndex = getLastIndex(tArr);
        if (lastIndex != 0) {
            Comparable comparable = (Comparable) selector.invoke(t2);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    T t3 = tArr[i3];
                    Comparable comparable2 = (Comparable) selector.invoke(t3);
                    if (comparable.compareTo(comparable2) > 0) {
                        t2 = t3;
                        comparable = comparable2;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
        }
        return t2;
    }

    private static final <T> double minOf(T[] tArr, Function1<? super T, Double> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = ((Number) selector.invoke(tArr[0])).doubleValue();
        int lastIndex = getLastIndex(tArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.min(dDoubleValue, ((Number) selector.invoke(tArr[i3])).doubleValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return dDoubleValue;
    }

    /* JADX INFO: renamed from: minOfOrNull, reason: collision with other method in class */
    private static final <T> Double m1435minOfOrNull(T[] tArr, Function1<? super T, Double> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        double dDoubleValue = ((Number) selector.invoke(tArr[0])).doubleValue();
        int lastIndex = getLastIndex(tArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.min(dDoubleValue, ((Number) selector.invoke(tArr[i3])).doubleValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    private static final <T, R> R minOfWith(T[] tArr, Comparator<? super R> comparator, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        R r2 = (Object) selector.invoke(tArr[0]);
        int lastIndex = getLastIndex(tArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object obj = (Object) selector.invoke(tArr[i3]);
                if (comparator.compare(r2, obj) > 0) {
                    r2 = (R) obj;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    private static final <T, R> R minOfWithOrNull(T[] tArr, Comparator<? super R> comparator, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        R r2 = (Object) selector.invoke(tArr[0]);
        int lastIndex = getLastIndex(tArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object obj = (Object) selector.invoke(tArr[i3]);
                if (comparator.compare(r2, obj) > 0) {
                    r2 = (R) obj;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    public static final Double minOrNull(Double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (dArr.length == 0) {
            return null;
        }
        double dDoubleValue = dArr[0].doubleValue();
        int lastIndex = getLastIndex(dArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.min(dDoubleValue, dArr[i3].doubleValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    public static final double minOrThrow(Double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = dArr[0].doubleValue();
        int lastIndex = getLastIndex(dArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.min(dDoubleValue, dArr[i3].doubleValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return dDoubleValue;
    }

    public static final <T> T minWithOrNull(T[] tArr, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (tArr.length == 0) {
            return null;
        }
        T t2 = tArr[0];
        int lastIndex = getLastIndex(tArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                T t3 = tArr[i3];
                if (comparator.compare(t2, t3) > 0) {
                    t2 = t3;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return t2;
    }

    public static final <T> T minWithOrThrow(T[] tArr, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        T t2 = tArr[0];
        int lastIndex = getLastIndex(tArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                T t3 = tArr[i3];
                if (comparator.compare(t2, t3) > 0) {
                    t2 = t3;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return t2;
    }

    public static final <T> boolean none(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return tArr.length == 0;
    }

    private static final <T> T[] onEach(T[] tArr, Function1<? super T, Unit> action) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        for (T t2 : tArr) {
            action.invoke(t2);
        }
        return tArr;
    }

    private static final <T> T[] onEachIndexed(T[] tArr, Function2<? super Integer, ? super T, Unit> action) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int length = tArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            action.invoke(Integer.valueOf(i4), tArr[i3]);
            i3++;
            i4++;
        }
        return tArr;
    }

    public static final <T> Pair<List<T>, List<T>> partition(T[] tArr, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (T t2 : tArr) {
            if (((Boolean) predicate.invoke(t2)).booleanValue()) {
                arrayList.add(t2);
            } else {
                arrayList2.add(t2);
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    private static final <T> T random(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return (T) random(tArr, Random.f140182a);
    }

    private static final <T> T randomOrNull(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return (T) randomOrNull(tArr, Random.f140182a);
    }

    public static final <S, T extends S> S reduce(T[] tArr, Function2<? super S, ? super T, ? extends S> operation) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (tArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        S s2 = (S) tArr[0];
        int lastIndex = getLastIndex(tArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                s2 = (S) operation.invoke(s2, tArr[i3]);
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return s2;
    }

    public static final <S, T extends S> S reduceIndexed(T[] tArr, Function3<? super Integer, ? super S, ? super T, ? extends S> operation) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (tArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        S s2 = (S) tArr[0];
        int lastIndex = getLastIndex(tArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                s2 = (S) operation.invoke(Integer.valueOf(i3), s2, tArr[i3]);
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return s2;
    }

    public static final <S, T extends S> S reduceIndexedOrNull(T[] tArr, Function3<? super Integer, ? super S, ? super T, ? extends S> operation) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (tArr.length == 0) {
            return null;
        }
        S s2 = (S) tArr[0];
        int lastIndex = getLastIndex(tArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                s2 = (S) operation.invoke(Integer.valueOf(i3), s2, tArr[i3]);
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return s2;
    }

    public static final <S, T extends S> S reduceOrNull(T[] tArr, Function2<? super S, ? super T, ? extends S> operation) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (tArr.length == 0) {
            return null;
        }
        S s2 = (S) tArr[0];
        int lastIndex = getLastIndex(tArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                s2 = (S) operation.invoke(s2, tArr[i3]);
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return s2;
    }

    public static final <S, T extends S> S reduceRight(T[] tArr, Function2<? super T, ? super S, ? extends S> operation) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(tArr);
        if (lastIndex < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        S s2 = (S) tArr[lastIndex];
        for (int i3 = lastIndex - 1; i3 >= 0; i3--) {
            s2 = (S) operation.invoke(tArr[i3], s2);
        }
        return s2;
    }

    public static final <S, T extends S> S reduceRightIndexed(T[] tArr, Function3<? super Integer, ? super T, ? super S, ? extends S> operation) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(tArr);
        if (lastIndex < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        S s2 = (S) tArr[lastIndex];
        for (int i3 = lastIndex - 1; i3 >= 0; i3--) {
            s2 = (S) operation.invoke(Integer.valueOf(i3), tArr[i3], s2);
        }
        return s2;
    }

    public static final <S, T extends S> S reduceRightIndexedOrNull(T[] tArr, Function3<? super Integer, ? super T, ? super S, ? extends S> operation) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(tArr);
        if (lastIndex < 0) {
            return null;
        }
        S s2 = (S) tArr[lastIndex];
        for (int i3 = lastIndex - 1; i3 >= 0; i3--) {
            s2 = (S) operation.invoke(Integer.valueOf(i3), tArr[i3], s2);
        }
        return s2;
    }

    public static final <S, T extends S> S reduceRightOrNull(T[] tArr, Function2<? super T, ? super S, ? extends S> operation) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(tArr);
        if (lastIndex < 0) {
            return null;
        }
        S s2 = (S) tArr[lastIndex];
        for (int i3 = lastIndex - 1; i3 >= 0; i3--) {
            s2 = (S) operation.invoke(tArr[i3], s2);
        }
        return s2;
    }

    public static <T> T[] requireNoNulls(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        for (T t2 : tArr) {
            if (t2 == null) {
                throw new IllegalArgumentException("null element found in " + tArr + '.');
            }
        }
        return tArr;
    }

    public static final <T> void reverse(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        int length = (tArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int lastIndex = getLastIndex(tArr);
        if (length < 0) {
            return;
        }
        int i3 = 0;
        while (true) {
            T t2 = tArr[i3];
            tArr[i3] = tArr[lastIndex];
            tArr[lastIndex] = t2;
            lastIndex--;
            if (i3 == length) {
                return;
            } else {
                i3++;
            }
        }
    }

    public static final <T> List<T> reversed(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<T> mutableList = toMutableList(tArr);
        CollectionsKt___CollectionsJvmKt.reverse(mutableList);
        return mutableList;
    }

    public static final <T> T[] reversedArray(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length == 0) {
            return tArr;
        }
        T[] tArr2 = (T[]) ArraysKt__ArraysJVMKt.arrayOfNulls(tArr, tArr.length);
        int lastIndex = getLastIndex(tArr);
        if (lastIndex >= 0) {
            int i3 = 0;
            while (true) {
                tArr2[lastIndex - i3] = tArr[i3];
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return tArr2;
    }

    public static final <T, R> List<R> runningFold(T[] tArr, R r2, Function2<? super R, ? super T, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (tArr.length == 0) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(tArr.length + 1);
        arrayList.add(r2);
        for (T t2 : tArr) {
            r2 = (R) operation.invoke(r2, t2);
            arrayList.add(r2);
        }
        return arrayList;
    }

    public static final <T, R> List<R> runningFoldIndexed(T[] tArr, R r2, Function3<? super Integer, ? super R, ? super T, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (tArr.length == 0) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(tArr.length + 1);
        arrayList.add(r2);
        int length = tArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            r2 = (R) operation.invoke(Integer.valueOf(i3), r2, tArr[i3]);
            arrayList.add(r2);
        }
        return arrayList;
    }

    public static final <S, T extends S> List<S> runningReduce(T[] tArr, Function2<? super S, ? super T, ? extends S> operation) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (tArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        T t2 = tArr[0];
        ArrayList arrayList = new ArrayList(tArr.length);
        arrayList.add(t2);
        int length = tArr.length;
        int i3 = 1;
        Object obj = t2;
        while (i3 < length) {
            Object objInvoke = operation.invoke(obj, tArr[i3]);
            arrayList.add(objInvoke);
            i3++;
            obj = objInvoke;
        }
        return arrayList;
    }

    public static final <S, T extends S> List<S> runningReduceIndexed(T[] tArr, Function3<? super Integer, ? super S, ? super T, ? extends S> operation) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (tArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        T t2 = tArr[0];
        ArrayList arrayList = new ArrayList(tArr.length);
        arrayList.add(t2);
        int length = tArr.length;
        int i3 = 1;
        Object obj = t2;
        while (i3 < length) {
            Object objInvoke = operation.invoke(Integer.valueOf(i3), obj, tArr[i3]);
            arrayList.add(objInvoke);
            i3++;
            obj = objInvoke;
        }
        return arrayList;
    }

    private static final <R> List<R> scan(byte[] bArr, R r2, Function2<? super R, ? super Byte, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (bArr.length == 0) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(bArr.length + 1);
        arrayList.add(r2);
        for (byte b3 : bArr) {
            r2 = (R) operation.invoke(r2, Byte.valueOf(b3));
            arrayList.add(r2);
        }
        return arrayList;
    }

    private static final <R> List<R> scanIndexed(byte[] bArr, R r2, Function3<? super Integer, ? super R, ? super Byte, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (bArr.length == 0) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(bArr.length + 1);
        arrayList.add(r2);
        int length = bArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            r2 = (R) operation.invoke(Integer.valueOf(i3), r2, Byte.valueOf(bArr[i3]));
            arrayList.add(r2);
        }
        return arrayList;
    }

    public static final <T> void shuffle(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        shuffle(tArr, Random.f140182a);
    }

    public static final <T> T single(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        int length = tArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return tArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static <T> T singleOrNull(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length == 1) {
            return tArr[0];
        }
        return null;
    }

    public static <T> List<T> slice(T[] tArr, IntRange indices) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? CollectionsKt__CollectionsKt.emptyList() : ArraysKt___ArraysJvmKt.asList(ArraysKt___ArraysJvmKt.copyOfRange(tArr, indices.a().intValue(), indices.e().intValue() + 1));
    }

    public static final <T> T[] sliceArray(T[] tArr, Collection<Integer> indices) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        T[] tArr2 = (T[]) ArraysKt__ArraysJVMKt.arrayOfNulls(tArr, indices.size());
        Iterator<Integer> it = indices.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            tArr2[i3] = tArr[it.next().intValue()];
            i3++;
        }
        return tArr2;
    }

    public static final <T, R extends Comparable<? super R>> void sortBy(T[] tArr, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (tArr.length > 1) {
            ArraysKt___ArraysJvmKt.sortWith(tArr, new ComparisonsKt__ComparisonsKt$compareBy$2(selector));
        }
    }

    public static final <T, R extends Comparable<? super R>> void sortByDescending(T[] tArr, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (tArr.length > 1) {
            ArraysKt___ArraysJvmKt.sortWith(tArr, new ComparisonsKt__ComparisonsKt$compareByDescending$1(selector));
        }
    }

    public static final <T extends Comparable<? super T>> void sortDescending(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        ArraysKt___ArraysJvmKt.sortWith(tArr, ComparisonsKt.h());
    }

    public static final <T extends Comparable<? super T>> List<T> sorted(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return ArraysKt___ArraysJvmKt.asList(sortedArray(tArr));
    }

    public static final <T extends Comparable<? super T>> T[] sortedArray(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length == 0) {
            return tArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(tArr, tArr.length);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
        T[] tArr2 = (T[]) ((Comparable[]) objArrCopyOf);
        ArraysKt___ArraysJvmKt.sort((Object[]) tArr2);
        return tArr2;
    }

    public static final <T extends Comparable<? super T>> T[] sortedArrayDescending(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length == 0) {
            return tArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(tArr, tArr.length);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
        T[] tArr2 = (T[]) ((Comparable[]) objArrCopyOf);
        ArraysKt___ArraysJvmKt.sortWith(tArr2, ComparisonsKt.h());
        return tArr2;
    }

    public static final <T> T[] sortedArrayWith(T[] tArr, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (tArr.length == 0) {
            return tArr;
        }
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, tArr.length);
        Intrinsics.checkNotNullExpressionValue(tArr2, "copyOf(...)");
        ArraysKt___ArraysJvmKt.sortWith(tArr2, comparator);
        return tArr2;
    }

    public static final <T, R extends Comparable<? super R>> List<T> sortedBy(T[] tArr, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(tArr, new ComparisonsKt__ComparisonsKt$compareBy$2(selector));
    }

    public static final <T, R extends Comparable<? super R>> List<T> sortedByDescending(T[] tArr, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(tArr, new ComparisonsKt__ComparisonsKt$compareByDescending$1(selector));
    }

    public static final <T extends Comparable<? super T>> List<T> sortedDescending(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return sortedWith(tArr, ComparisonsKt.h());
    }

    public static <T> List<T> sortedWith(T[] tArr, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return ArraysKt___ArraysJvmKt.asList(sortedArrayWith(tArr, comparator));
    }

    public static final <T> Set<T> subtract(T[] tArr, Iterable<? extends T> other) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<T> mutableSet = toMutableSet(tArr);
        CollectionsKt__MutableCollectionsKt.removeAll(mutableSet, other);
        return mutableSet;
    }

    public static final int sum(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int i3 = 0;
        for (byte b3 : bArr) {
            i3 += b3;
        }
        return i3;
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final <T> int sumBy(T[] tArr, Function1<? super T, Integer> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iIntValue = 0;
        for (T t2 : tArr) {
            iIntValue += ((Number) selector.invoke(t2)).intValue();
        }
        return iIntValue;
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final <T> double sumByDouble(T[] tArr, Function1<? super T, Double> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        double dDoubleValue = 0.0d;
        for (T t2 : tArr) {
            dDoubleValue += ((Number) selector.invoke(t2)).doubleValue();
        }
        return dDoubleValue;
    }

    public static final int sumOfByte(Byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int iByteValue = 0;
        for (Byte b3 : bArr) {
            iByteValue += b3.byteValue();
        }
        return iByteValue;
    }

    private static final <T> double sumOfDouble(T[] tArr, Function1<? super T, Double> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        double dDoubleValue = 0.0d;
        for (T t2 : tArr) {
            dDoubleValue += ((Number) selector.invoke(t2)).doubleValue();
        }
        return dDoubleValue;
    }

    public static final float sumOfFloat(Float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        float fFloatValue = 0.0f;
        for (Float f3 : fArr) {
            fFloatValue += f3.floatValue();
        }
        return fFloatValue;
    }

    private static final <T> int sumOfInt(T[] tArr, Function1<? super T, Integer> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iIntValue = 0;
        for (T t2 : tArr) {
            iIntValue += ((Number) selector.invoke(t2)).intValue();
        }
        return iIntValue;
    }

    private static final <T> long sumOfLong(T[] tArr, Function1<? super T, Long> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        long jLongValue = 0;
        for (T t2 : tArr) {
            jLongValue += ((Number) selector.invoke(t2)).longValue();
        }
        return jLongValue;
    }

    public static final int sumOfShort(Short[] shArr) {
        Intrinsics.checkNotNullParameter(shArr, "<this>");
        int iShortValue = 0;
        for (Short sh : shArr) {
            iShortValue += sh.shortValue();
        }
        return iShortValue;
    }

    private static final <T> int sumOfUInt(T[] tArr, Function1<? super T, UInt> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iB = UInt.b(0);
        for (T t2 : tArr) {
            iB = UInt.b(iB + ((UInt) selector.invoke(t2)).f());
        }
        return iB;
    }

    private static final <T> long sumOfULong(T[] tArr, Function1<? super T, ULong> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        long jB = ULong.b(0L);
        for (T t2 : tArr) {
            jB = ULong.b(jB + ((ULong) selector.invoke(t2)).g());
        }
        return jB;
    }

    public static final <T> List<T> take(T[] tArr, int i3) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (i3 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
        }
        if (i3 == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (i3 >= tArr.length) {
            return toList(tArr);
        }
        if (i3 == 1) {
            return CollectionsKt__CollectionsJVMKt.listOf(tArr[0]);
        }
        ArrayList arrayList = new ArrayList(i3);
        int i4 = 0;
        for (T t2 : tArr) {
            arrayList.add(t2);
            i4++;
            if (i4 == i3) {
                break;
            }
        }
        return arrayList;
    }

    public static final <T> List<T> takeLast(T[] tArr, int i3) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (i3 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
        }
        if (i3 == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        int length = tArr.length;
        if (i3 >= length) {
            return toList(tArr);
        }
        if (i3 == 1) {
            return CollectionsKt__CollectionsJVMKt.listOf(tArr[length - 1]);
        }
        ArrayList arrayList = new ArrayList(i3);
        for (int i4 = length - i3; i4 < length; i4++) {
            arrayList.add(tArr[i4]);
        }
        return arrayList;
    }

    public static final <T> List<T> takeLastWhile(T[] tArr, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = getLastIndex(tArr); -1 < lastIndex; lastIndex--) {
            if (!((Boolean) predicate.invoke(tArr[lastIndex])).booleanValue()) {
                return drop(tArr, lastIndex + 1);
            }
        }
        return toList(tArr);
    }

    public static final <T> List<T> takeWhile(T[] tArr, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t2 : tArr) {
            if (!((Boolean) predicate.invoke(t2)).booleanValue()) {
                break;
            }
            arrayList.add(t2);
        }
        return arrayList;
    }

    public static final boolean[] toBooleanArray(Boolean[] boolArr) {
        Intrinsics.checkNotNullParameter(boolArr, "<this>");
        int length = boolArr.length;
        boolean[] zArr = new boolean[length];
        for (int i3 = 0; i3 < length; i3++) {
            zArr[i3] = boolArr[i3].booleanValue();
        }
        return zArr;
    }

    public static final byte[] toByteArray(Byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        for (int i3 = 0; i3 < length; i3++) {
            bArr2[i3] = bArr[i3].byteValue();
        }
        return bArr2;
    }

    public static final char[] toCharArray(Character[] chArr) {
        Intrinsics.checkNotNullParameter(chArr, "<this>");
        int length = chArr.length;
        char[] cArr = new char[length];
        for (int i3 = 0; i3 < length; i3++) {
            cArr[i3] = chArr[i3].charValue();
        }
        return cArr;
    }

    public static final <T, C extends Collection<? super T>> C toCollection(T[] tArr, C destination) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        for (T t2 : tArr) {
            destination.add(t2);
        }
        return destination;
    }

    public static final double[] toDoubleArray(Double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        int length = dArr.length;
        double[] dArr2 = new double[length];
        for (int i3 = 0; i3 < length; i3++) {
            dArr2[i3] = dArr[i3].doubleValue();
        }
        return dArr2;
    }

    public static float[] toFloatArray(Float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        int length = fArr.length;
        float[] fArr2 = new float[length];
        for (int i3 = 0; i3 < length; i3++) {
            fArr2[i3] = fArr[i3].floatValue();
        }
        return fArr2;
    }

    public static <T> HashSet<T> toHashSet(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return (HashSet) toCollection(tArr, new HashSet(MapsKt__MapsJVMKt.mapCapacity(tArr.length)));
    }

    public static final int[] toIntArray(Integer[] numArr) {
        Intrinsics.checkNotNullParameter(numArr, "<this>");
        int length = numArr.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = numArr[i3].intValue();
        }
        return iArr;
    }

    public static <T> List<T> toList(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        int length = tArr.length;
        return length != 0 ? length != 1 ? toMutableList(tArr) : CollectionsKt__CollectionsJVMKt.listOf(tArr[0]) : CollectionsKt__CollectionsKt.emptyList();
    }

    public static final long[] toLongArray(Long[] lArr) {
        Intrinsics.checkNotNullParameter(lArr, "<this>");
        int length = lArr.length;
        long[] jArr = new long[length];
        for (int i3 = 0; i3 < length; i3++) {
            jArr[i3] = lArr[i3].longValue();
        }
        return jArr;
    }

    public static <T> List<T> toMutableList(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return new ArrayList(CollectionsKt__CollectionsKt.asCollection$default(tArr, false, 1, null));
    }

    public static <T> Set<T> toMutableSet(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return (Set) toCollection(tArr, new LinkedHashSet(MapsKt__MapsJVMKt.mapCapacity(tArr.length)));
    }

    public static <T> Set<T> toSet(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        int length = tArr.length;
        return length != 0 ? length != 1 ? (Set) toCollection(tArr, new LinkedHashSet(MapsKt__MapsJVMKt.mapCapacity(tArr.length))) : SetsKt__SetsJVMKt.setOf(tArr[0]) : SetsKt__SetsKt.emptySet();
    }

    public static final short[] toShortArray(Short[] shArr) {
        Intrinsics.checkNotNullParameter(shArr, "<this>");
        int length = shArr.length;
        short[] sArr = new short[length];
        for (int i3 = 0; i3 < length; i3++) {
            sArr[i3] = shArr[i3].shortValue();
        }
        return sArr;
    }

    public static final <T> Set<T> union(T[] tArr, Iterable<? extends T> other) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<T> mutableSet = toMutableSet(tArr);
        CollectionsKt__MutableCollectionsKt.addAll(mutableSet, other);
        return mutableSet;
    }

    public static <T> Iterable<IndexedValue<T>> withIndex(final T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return new IndexingIterable(new Function0() { // from class: kotlin.collections.i
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ArrayIteratorKt.a(tArr);
            }
        });
    }

    public static final <T, R, V> List<V> zip(T[] tArr, R[] other, Function2<? super T, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iMin = Math.min(tArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i3 = 0; i3 < iMin; i3++) {
            arrayList.add(transform.invoke(tArr[i3], other[i3]));
        }
        return arrayList;
    }

    public static final boolean all(byte[] bArr, Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (byte b3 : bArr) {
            if (!((Boolean) predicate.invoke(Byte.valueOf(b3))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static boolean any(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return !(bArr.length == 0);
    }

    public static final double average(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        double d3 = 0.0d;
        int i3 = 0;
        for (short s2 : sArr) {
            d3 += (double) s2;
            i3++;
        }
        if (i3 == 0) {
            return Double.NaN;
        }
        return d3 / ((double) i3);
    }

    private static final byte component1(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return bArr[0];
    }

    private static final byte component2(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return bArr[1];
    }

    private static final byte component3(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return bArr[2];
    }

    private static final byte component4(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return bArr[3];
    }

    private static final byte component5(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return bArr[4];
    }

    public static boolean contains(byte[] bArr, byte b3) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return indexOf(bArr, b3) >= 0;
    }

    private static final int count(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return bArr.length;
    }

    public static final List<Byte> distinct(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return CollectionsKt___CollectionsKt.toList(toMutableSet(bArr));
    }

    private static final byte elementAtOrElse(byte[] bArr, int i3, Function1<? super Integer, Byte> defaultValue) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return (i3 < 0 || i3 >= bArr.length) ? ((Number) defaultValue.invoke(Integer.valueOf(i3))).byteValue() : bArr[i3];
    }

    private static final Byte elementAtOrNull(byte[] bArr, int i3) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return getOrNull(bArr, i3);
    }

    public static final <C extends Collection<? super Byte>> C filterNotTo(byte[] bArr, C destination, Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (byte b3 : bArr) {
            if (!((Boolean) predicate.invoke(Byte.valueOf(b3))).booleanValue()) {
                destination.add(Byte.valueOf(b3));
            }
        }
        return destination;
    }

    public static final <C extends Collection<? super Byte>> C filterTo(byte[] bArr, C destination, Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (byte b3 : bArr) {
            if (((Boolean) predicate.invoke(Byte.valueOf(b3))).booleanValue()) {
                destination.add(Byte.valueOf(b3));
            }
        }
        return destination;
    }

    private static final Byte find(byte[] bArr, Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (byte b3 : bArr) {
            if (((Boolean) predicate.invoke(Byte.valueOf(b3))).booleanValue()) {
                return Byte.valueOf(b3);
            }
        }
        return null;
    }

    private static final <T, R> R firstNotNullOf(T[] tArr, Function1<? super T, ? extends R> transform) {
        R r2;
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = tArr.length;
        int i3 = 0;
        while (true) {
            if (i3 < length) {
                r2 = (R) transform.invoke(tArr[i3]);
                if (r2 != null) {
                    break;
                }
                i3++;
            } else {
                r2 = null;
                break;
            }
        }
        if (r2 != null) {
            return r2;
        }
        throw new NoSuchElementException(rnFwbPAQmQTnL.lLG);
    }

    public static final Byte firstOrNull(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (bArr.length == 0) {
            return null;
        }
        return Byte.valueOf(bArr[0]);
    }

    private static final <R> List<R> flatMapIndexedIterable(byte[] bArr, Function2<? super Integer, ? super Byte, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = bArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, (Iterable) transform.invoke(Integer.valueOf(i4), Byte.valueOf(bArr[i3])));
            i3++;
            i4++;
        }
        return arrayList;
    }

    public static final <R> R fold(byte[] bArr, R r2, Function2<? super R, ? super Byte, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (byte b3 : bArr) {
            r2 = (R) operation.invoke(r2, Byte.valueOf(b3));
        }
        return r2;
    }

    public static final <R> R foldIndexed(byte[] bArr, R r2, Function3<? super Integer, ? super R, ? super Byte, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int length = bArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            r2 = (R) operation.invoke(Integer.valueOf(i4), r2, Byte.valueOf(bArr[i3]));
            i3++;
            i4++;
        }
        return r2;
    }

    public static final void forEach(byte[] bArr, Function1<? super Byte, Unit> action) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        for (byte b3 : bArr) {
            action.invoke(Byte.valueOf(b3));
        }
    }

    public static final void forEachIndexed(byte[] bArr, Function2<? super Integer, ? super Byte, Unit> action) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int length = bArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            action.invoke(Integer.valueOf(i4), Byte.valueOf(bArr[i3]));
            i3++;
            i4++;
        }
    }

    public static IntRange getIndices(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return new IntRange(0, getLastIndex(bArr));
    }

    public static int getLastIndex(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return bArr.length - 1;
    }

    private static final byte getOrElse(byte[] bArr, int i3, Function1<? super Integer, Byte> defaultValue) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return (i3 < 0 || i3 >= bArr.length) ? ((Number) defaultValue.invoke(Integer.valueOf(i3))).byteValue() : bArr[i3];
    }

    public static final Byte getOrNull(byte[] bArr, int i3) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (i3 < 0 || i3 >= bArr.length) {
            return null;
        }
        return Byte.valueOf(bArr[i3]);
    }

    private static final boolean isEmpty(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return bArr.length == 0;
    }

    private static final boolean isNotEmpty(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return !(bArr.length == 0);
    }

    public static final String joinToString(byte[] bArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i3, CharSequence truncated, Function1<? super Byte, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        return ((StringBuilder) joinTo(bArr, new StringBuilder(), separator, prefix, postfix, i3, truncated, function1)).toString();
    }

    public static /* synthetic */ String joinToString$default(byte[] bArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i3, CharSequence charSequence4, Function1 function1, int i4, Object obj) {
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
        return joinToString(bArr, charSequence, charSequence2, charSequence3, i3, charSequence5, (Function1<? super Byte, ? extends CharSequence>) function12);
    }

    public static final Byte lastOrNull(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (bArr.length == 0) {
            return null;
        }
        return Byte.valueOf(bArr[bArr.length - 1]);
    }

    public static final boolean none(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return bArr.length == 0;
    }

    private static final byte[] onEach(byte[] bArr, Function1<? super Byte, Unit> action) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        for (byte b3 : bArr) {
            action.invoke(Byte.valueOf(b3));
        }
        return bArr;
    }

    private static final byte[] onEachIndexed(byte[] bArr, Function2<? super Integer, ? super Byte, Unit> action) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int length = bArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            action.invoke(Integer.valueOf(i4), Byte.valueOf(bArr[i3]));
            i3++;
            i4++;
        }
        return bArr;
    }

    private static final byte random(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return random(bArr, (Random) Random.f140182a);
    }

    private static final Byte randomOrNull(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return randomOrNull(bArr, (Random) Random.f140182a);
    }

    private static final <R> List<R> scan(short[] sArr, R r2, Function2<? super R, ? super Short, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (sArr.length == 0) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(sArr.length + 1);
        arrayList.add(r2);
        for (short s2 : sArr) {
            r2 = (R) operation.invoke(r2, Short.valueOf(s2));
            arrayList.add(r2);
        }
        return arrayList;
    }

    private static final <R> List<R> scanIndexed(short[] sArr, R r2, Function3<? super Integer, ? super R, ? super Short, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (sArr.length == 0) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(sArr.length + 1);
        arrayList.add(r2);
        int length = sArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            r2 = (R) operation.invoke(Integer.valueOf(i3), r2, Short.valueOf(sArr[i3]));
            arrayList.add(r2);
        }
        return arrayList;
    }

    public static final void shuffle(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        shuffle(bArr, (Random) Random.f140182a);
    }

    public static final Byte singleOrNull(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (bArr.length == 1) {
            return Byte.valueOf(bArr[0]);
        }
        return null;
    }

    public static final void sortDescending(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (bArr.length > 1) {
            ArraysKt___ArraysJvmKt.sort(bArr);
            reverse(bArr);
        }
    }

    public static final List<Byte> sorted(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Byte[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(bArr);
        ArraysKt___ArraysJvmKt.sort((Object[]) typedArray);
        return ArraysKt___ArraysJvmKt.asList(typedArray);
    }

    public static final <R extends Comparable<? super R>> List<Byte> sortedBy(byte[] bArr, Function1<? super Byte, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(bArr, (Comparator<? super Byte>) new ComparisonsKt__ComparisonsKt$compareBy$2(selector));
    }

    public static final <R extends Comparable<? super R>> List<Byte> sortedByDescending(byte[] bArr, Function1<? super Byte, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(bArr, (Comparator<? super Byte>) new ComparisonsKt__ComparisonsKt$compareByDescending$1(selector));
    }

    public static final List<Byte> sortedDescending(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        ArraysKt___ArraysJvmKt.sort(bArrCopyOf);
        return reversed(bArrCopyOf);
    }

    public static final List<Byte> sortedWith(byte[] bArr, Comparator<? super Byte> comparator) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Byte[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(bArr);
        ArraysKt___ArraysJvmKt.sortWith(typedArray, comparator);
        return ArraysKt___ArraysJvmKt.asList(typedArray);
    }

    public static final int sum(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        int i3 = 0;
        for (short s2 : sArr) {
            i3 += s2;
        }
        return i3;
    }

    public static final HashSet<Byte> toHashSet(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return (HashSet) toCollection(bArr, new HashSet(MapsKt__MapsJVMKt.mapCapacity(bArr.length)));
    }

    public static final List<Byte> toMutableList(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte b3 : bArr) {
            arrayList.add(Byte.valueOf(b3));
        }
        return arrayList;
    }

    public static final Set<Byte> toMutableSet(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return (Set) toCollection(bArr, new LinkedHashSet(MapsKt__MapsJVMKt.mapCapacity(bArr.length)));
    }

    public static final Iterable<IndexedValue<Byte>> withIndex(final byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return new IndexingIterable(new Function0() { // from class: kotlin.collections.h
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ArrayIteratorsKt.b(bArr);
            }
        });
    }

    public static final boolean all(short[] sArr, Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (short s2 : sArr) {
            if (!((Boolean) predicate.invoke(Short.valueOf(s2))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static boolean any(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return !(sArr.length == 0);
    }

    public static final Iterable<Byte> asIterable(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return bArr.length == 0 ? CollectionsKt__CollectionsKt.emptyList() : new ArraysKt___ArraysKt$asIterable$$inlined$Iterable$2(bArr);
    }

    public static final Sequence<Byte> asSequence(final byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return bArr.length == 0 ? SequencesKt.g() : new Sequence<Byte>() { // from class: kotlin.collections.ArraysKt___ArraysKt$asSequence$$inlined$Sequence$2
            @Override // kotlin.sequences.Sequence
            public Iterator<Byte> iterator() {
                return ArrayIteratorsKt.b(bArr);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, M extends Map<? super K, ? super Byte>> M associateByTo(byte[] bArr, M destination, Function1<? super Byte, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (byte b3 : bArr) {
            destination.put(keySelector.invoke(Byte.valueOf(b3)), Byte.valueOf(b3));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(byte[] bArr, M destination, Function1<? super Byte, ? extends Pair<? extends K, ? extends V>> transform) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (byte b3 : bArr) {
            Pair pair = (Pair) transform.invoke(Byte.valueOf(b3));
            destination.put(pair.e(), pair.f());
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <V, M extends Map<? super Byte, ? super V>> M associateWithTo(byte[] bArr, M destination, Function1<? super Byte, ? extends V> valueSelector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        for (byte b3 : bArr) {
            destination.put(Byte.valueOf(b3), valueSelector.invoke(Byte.valueOf(b3)));
        }
        return destination;
    }

    public static final double average(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        double d3 = 0.0d;
        int i3 = 0;
        for (int i4 : iArr) {
            d3 += (double) i4;
            i3++;
        }
        if (i3 == 0) {
            return Double.NaN;
        }
        return d3 / ((double) i3);
    }

    private static final short component1(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return sArr[0];
    }

    private static final short component2(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return sArr[1];
    }

    private static final short component3(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return sArr[2];
    }

    private static final short component4(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return sArr[3];
    }

    private static final short component5(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return sArr[4];
    }

    public static boolean contains(short[] sArr, short s2) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return indexOf(sArr, s2) >= 0;
    }

    private static final int count(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return sArr.length;
    }

    public static final List<Short> distinct(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return CollectionsKt___CollectionsKt.toList(toMutableSet(sArr));
    }

    public static final List<Byte> drop(byte[] bArr, int i3) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (i3 >= 0) {
            return takeLast(bArr, RangesKt.f(bArr.length - i3, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
    }

    public static final List<Byte> dropLast(byte[] bArr, int i3) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (i3 >= 0) {
            return take(bArr, RangesKt.f(bArr.length - i3, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
    }

    private static final short elementAtOrElse(short[] sArr, int i3, Function1<? super Integer, Short> defaultValue) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return (i3 < 0 || i3 >= sArr.length) ? ((Number) defaultValue.invoke(Integer.valueOf(i3))).shortValue() : sArr[i3];
    }

    private static final Short elementAtOrNull(short[] sArr, int i3) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return getOrNull(sArr, i3);
    }

    public static final List<Byte> filter(byte[] bArr, Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (byte b3 : bArr) {
            if (((Boolean) predicate.invoke(Byte.valueOf(b3))).booleanValue()) {
                arrayList.add(Byte.valueOf(b3));
            }
        }
        return arrayList;
    }

    public static final <C extends Collection<? super Byte>> C filterIndexedTo(byte[] bArr, C destination, Function2<? super Integer, ? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = bArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            byte b3 = bArr[i3];
            int i5 = i4 + 1;
            if (((Boolean) predicate.invoke(Integer.valueOf(i4), Byte.valueOf(b3))).booleanValue()) {
                destination.add(Byte.valueOf(b3));
            }
            i3++;
            i4 = i5;
        }
        return destination;
    }

    public static final List<Byte> filterNot(byte[] bArr, Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (byte b3 : bArr) {
            if (!((Boolean) predicate.invoke(Byte.valueOf(b3))).booleanValue()) {
                arrayList.add(Byte.valueOf(b3));
            }
        }
        return arrayList;
    }

    public static final <C extends Collection<? super Short>> C filterNotTo(short[] sArr, C destination, Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (short s2 : sArr) {
            if (!((Boolean) predicate.invoke(Short.valueOf(s2))).booleanValue()) {
                destination.add(Short.valueOf(s2));
            }
        }
        return destination;
    }

    public static final <C extends Collection<? super Short>> C filterTo(short[] sArr, C destination, Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (short s2 : sArr) {
            if (((Boolean) predicate.invoke(Short.valueOf(s2))).booleanValue()) {
                destination.add(Short.valueOf(s2));
            }
        }
        return destination;
    }

    private static final Short find(short[] sArr, Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (short s2 : sArr) {
            if (((Boolean) predicate.invoke(Short.valueOf(s2))).booleanValue()) {
                return Short.valueOf(s2);
            }
        }
        return null;
    }

    public static final Short firstOrNull(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        if (sArr.length == 0) {
            return null;
        }
        return Short.valueOf(sArr[0]);
    }

    private static final <R> List<R> flatMapIndexedIterable(short[] sArr, Function2<? super Integer, ? super Short, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = sArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, (Iterable) transform.invoke(Integer.valueOf(i4), Short.valueOf(sArr[i3])));
            i3++;
            i4++;
        }
        return arrayList;
    }

    public static final <R> R fold(short[] sArr, R r2, Function2<? super R, ? super Short, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (short s2 : sArr) {
            r2 = (R) operation.invoke(r2, Short.valueOf(s2));
        }
        return r2;
    }

    public static final <R> R foldIndexed(short[] sArr, R r2, Function3<? super Integer, ? super R, ? super Short, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int length = sArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            r2 = (R) operation.invoke(Integer.valueOf(i4), r2, Short.valueOf(sArr[i3]));
            i3++;
            i4++;
        }
        return r2;
    }

    public static final <R> R foldRight(byte[] bArr, R r2, Function2<? super Byte, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = getLastIndex(bArr); lastIndex >= 0; lastIndex--) {
            r2 = (R) operation.invoke(Byte.valueOf(bArr[lastIndex]), r2);
        }
        return r2;
    }

    public static final <R> R foldRightIndexed(byte[] bArr, R r2, Function3<? super Integer, ? super Byte, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = getLastIndex(bArr); lastIndex >= 0; lastIndex--) {
            r2 = (R) operation.invoke(Integer.valueOf(lastIndex), Byte.valueOf(bArr[lastIndex]), r2);
        }
        return r2;
    }

    public static final void forEach(short[] sArr, Function1<? super Short, Unit> action) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        for (short s2 : sArr) {
            action.invoke(Short.valueOf(s2));
        }
    }

    public static final void forEachIndexed(short[] sArr, Function2<? super Integer, ? super Short, Unit> action) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int length = sArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            action.invoke(Integer.valueOf(i4), Short.valueOf(sArr[i3]));
            i3++;
            i4++;
        }
    }

    public static IntRange getIndices(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return new IntRange(0, getLastIndex(sArr));
    }

    public static int getLastIndex(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return sArr.length - 1;
    }

    private static final short getOrElse(short[] sArr, int i3, Function1<? super Integer, Short> defaultValue) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return (i3 < 0 || i3 >= sArr.length) ? ((Number) defaultValue.invoke(Integer.valueOf(i3))).shortValue() : sArr[i3];
    }

    public static final Short getOrNull(short[] sArr, int i3) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        if (i3 < 0 || i3 >= sArr.length) {
            return null;
        }
        return Short.valueOf(sArr[i3]);
    }

    public static final int indexOfFirst(byte[] bArr, Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = bArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (((Boolean) predicate.invoke(Byte.valueOf(bArr[i3]))).booleanValue()) {
                return i3;
            }
        }
        return -1;
    }

    public static final int indexOfLast(byte[] bArr, Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = bArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i3 = length - 1;
                if (((Boolean) predicate.invoke(Byte.valueOf(bArr[length]))).booleanValue()) {
                    return length;
                }
                if (i3 < 0) {
                    break;
                }
                length = i3;
            }
        }
        return -1;
    }

    public static final Set<Byte> intersect(byte[] bArr, Iterable<Byte> other) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Byte> mutableSet = toMutableSet(bArr);
        CollectionsKt__MutableCollectionsKt.retainAll(mutableSet, other);
        return mutableSet;
    }

    private static final boolean isEmpty(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return sArr.length == 0;
    }

    private static final boolean isNotEmpty(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return !(sArr.length == 0);
    }

    public static final String joinToString(short[] sArr, CharSequence charSequence, CharSequence prefix, CharSequence postfix, int i3, CharSequence truncated, Function1<? super Short, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(charSequence, KqqtdetwHMIO.GBIIOesdaE);
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        return ((StringBuilder) joinTo(sArr, new StringBuilder(), charSequence, prefix, postfix, i3, truncated, function1)).toString();
    }

    public static /* synthetic */ String joinToString$default(short[] sArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i3, CharSequence charSequence4, Function1 function1, int i4, Object obj) {
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
        return joinToString(sArr, charSequence, charSequence2, charSequence3, i3, charSequence5, (Function1<? super Short, ? extends CharSequence>) function12);
    }

    public static final Short lastOrNull(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        if (sArr.length == 0) {
            return null;
        }
        return Short.valueOf(sArr[sArr.length - 1]);
    }

    public static final <R, C extends Collection<? super R>> C mapIndexedTo(byte[] bArr, C destination, Function2<? super Integer, ? super Byte, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = bArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            destination.add(transform.invoke(Integer.valueOf(i4), Byte.valueOf(bArr[i3])));
            i3++;
            i4++;
        }
        return destination;
    }

    public static final <R, C extends Collection<? super R>> C mapTo(byte[] bArr, C destination, Function1<? super Byte, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (byte b3 : bArr) {
            destination.add(transform.invoke(Byte.valueOf(b3)));
        }
        return destination;
    }

    public static final boolean none(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return sArr.length == 0;
    }

    private static final short[] onEach(short[] sArr, Function1<? super Short, Unit> action) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        for (short s2 : sArr) {
            action.invoke(Short.valueOf(s2));
        }
        return sArr;
    }

    private static final short[] onEachIndexed(short[] sArr, Function2<? super Integer, ? super Short, Unit> action) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int length = sArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            action.invoke(Integer.valueOf(i4), Short.valueOf(sArr[i3]));
            i3++;
            i4++;
        }
        return sArr;
    }

    private static final short random(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return random(sArr, (Random) Random.f140182a);
    }

    private static final Short randomOrNull(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return randomOrNull(sArr, (Random) Random.f140182a);
    }

    private static final <R> List<R> scan(int[] iArr, R r2, Function2<? super R, ? super Integer, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (iArr.length == 0) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(iArr.length + 1);
        arrayList.add(r2);
        for (int i3 : iArr) {
            r2 = (R) operation.invoke(r2, Integer.valueOf(i3));
            arrayList.add(r2);
        }
        return arrayList;
    }

    private static final <R> List<R> scanIndexed(int[] iArr, R r2, Function3<? super Integer, ? super R, ? super Integer, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (iArr.length == 0) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(iArr.length + 1);
        arrayList.add(r2);
        int length = iArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            r2 = (R) operation.invoke(Integer.valueOf(i3), r2, Integer.valueOf(iArr[i3]));
            arrayList.add(r2);
        }
        return arrayList;
    }

    public static final void shuffle(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        shuffle(sArr, (Random) Random.f140182a);
    }

    public static final Short singleOrNull(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        if (sArr.length == 1) {
            return Short.valueOf(sArr[0]);
        }
        return null;
    }

    public static final List<Byte> slice(byte[] bArr, IntRange indices) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? CollectionsKt__CollectionsKt.emptyList() : ArraysKt___ArraysJvmKt.asList(ArraysKt___ArraysJvmKt.copyOfRange(bArr, indices.a().intValue(), indices.e().intValue() + 1));
    }

    public static final List<Short> sorted(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Short[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(sArr);
        ArraysKt___ArraysJvmKt.sort((Object[]) typedArray);
        return ArraysKt___ArraysJvmKt.asList(typedArray);
    }

    public static final byte[] sortedArray(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (bArr.length == 0) {
            return bArr;
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        ArraysKt___ArraysJvmKt.sort(bArrCopyOf);
        return bArrCopyOf;
    }

    public static final byte[] sortedArrayDescending(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (bArr.length == 0) {
            return bArr;
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        sortDescending(bArrCopyOf);
        return bArrCopyOf;
    }

    public static final <R extends Comparable<? super R>> List<Short> sortedBy(short[] sArr, Function1<? super Short, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(sArr, (Comparator<? super Short>) new ComparisonsKt__ComparisonsKt$compareBy$2(selector));
    }

    public static final <R extends Comparable<? super R>> List<Short> sortedByDescending(short[] sArr, Function1<? super Short, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(sArr, (Comparator<? super Short>) new ComparisonsKt__ComparisonsKt$compareByDescending$1(selector));
    }

    public static final List<Short> sortedDescending(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        short[] sArrCopyOf = Arrays.copyOf(sArr, sArr.length);
        Intrinsics.checkNotNullExpressionValue(sArrCopyOf, "copyOf(...)");
        ArraysKt___ArraysJvmKt.sort(sArrCopyOf);
        return reversed(sArrCopyOf);
    }

    public static final List<Short> sortedWith(short[] sArr, Comparator<? super Short> comparator) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Short[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(sArr);
        ArraysKt___ArraysJvmKt.sortWith(typedArray, comparator);
        return ArraysKt___ArraysJvmKt.asList(typedArray);
    }

    public static final Set<Byte> subtract(byte[] bArr, Iterable<Byte> other) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Byte> mutableSet = toMutableSet(bArr);
        CollectionsKt__MutableCollectionsKt.removeAll(mutableSet, other);
        return mutableSet;
    }

    public static int sum(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int i3 = 0;
        for (int i4 : iArr) {
            i3 += i4;
        }
        return i3;
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final int sumBy(byte[] bArr, Function1<? super Byte, Integer> selector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iIntValue = 0;
        for (byte b3 : bArr) {
            iIntValue += ((Number) selector.invoke(Byte.valueOf(b3))).intValue();
        }
        return iIntValue;
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final double sumByDouble(byte[] bArr, Function1<? super Byte, Double> selector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        double dDoubleValue = 0.0d;
        for (byte b3 : bArr) {
            dDoubleValue += ((Number) selector.invoke(Byte.valueOf(b3))).doubleValue();
        }
        return dDoubleValue;
    }

    private static final double sumOfDouble(byte[] bArr, Function1<? super Byte, Double> selector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        double dDoubleValue = 0.0d;
        for (byte b3 : bArr) {
            dDoubleValue += ((Number) selector.invoke(Byte.valueOf(b3))).doubleValue();
        }
        return dDoubleValue;
    }

    private static final int sumOfInt(byte[] bArr, Function1<? super Byte, Integer> selector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iIntValue = 0;
        for (byte b3 : bArr) {
            iIntValue += ((Number) selector.invoke(Byte.valueOf(b3))).intValue();
        }
        return iIntValue;
    }

    private static final long sumOfLong(byte[] bArr, Function1<? super Byte, Long> selector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        long jLongValue = 0;
        for (byte b3 : bArr) {
            jLongValue += ((Number) selector.invoke(Byte.valueOf(b3))).longValue();
        }
        return jLongValue;
    }

    public static final <C extends Collection<? super Byte>> C toCollection(byte[] bArr, C destination) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        for (byte b3 : bArr) {
            destination.add(Byte.valueOf(b3));
        }
        return destination;
    }

    public static final HashSet<Short> toHashSet(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return (HashSet) toCollection(sArr, new HashSet(MapsKt__MapsJVMKt.mapCapacity(sArr.length)));
    }

    public static final Set<Short> toMutableSet(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return (Set) toCollection(sArr, new LinkedHashSet(MapsKt__MapsJVMKt.mapCapacity(sArr.length)));
    }

    public static final Set<Byte> union(byte[] bArr, Iterable<Byte> other) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Byte> mutableSet = toMutableSet(bArr);
        CollectionsKt__MutableCollectionsKt.addAll(mutableSet, other);
        return mutableSet;
    }

    public static final Iterable<IndexedValue<Short>> withIndex(final short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return new IndexingIterable(new Function0() { // from class: kotlin.collections.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ArrayIteratorsKt.h(sArr);
            }
        });
    }

    public static final boolean all(int[] iArr, Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int i3 : iArr) {
            if (!((Boolean) predicate.invoke(Integer.valueOf(i3))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static boolean any(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return !(iArr.length == 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <V> Map<Byte, V> associateWith(byte[] bArr, Function1<? super Byte, ? extends V> valueSelector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt__MapsJVMKt.mapCapacity(bArr.length), 16));
        for (byte b3 : bArr) {
            linkedHashMap.put(Byte.valueOf(b3), valueSelector.invoke(Byte.valueOf(b3)));
        }
        return linkedHashMap;
    }

    public static final double average(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        double d3 = 0.0d;
        int i3 = 0;
        for (long j3 : jArr) {
            d3 += j3;
            i3++;
        }
        if (i3 == 0) {
            return Double.NaN;
        }
        return d3 / ((double) i3);
    }

    private static final int component1(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return iArr[0];
    }

    private static final int component2(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return iArr[1];
    }

    private static final int component3(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return iArr[2];
    }

    private static final int component4(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return iArr[3];
    }

    private static final int component5(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return iArr[4];
    }

    public static boolean contains(int[] iArr, int i3) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return indexOf(iArr, i3) >= 0;
    }

    private static final int count(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return iArr.length;
    }

    public static List<Integer> distinct(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return CollectionsKt___CollectionsKt.toList(toMutableSet(iArr));
    }

    private static final int elementAtOrElse(int[] iArr, int i3, Function1<? super Integer, Integer> defaultValue) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return (i3 < 0 || i3 >= iArr.length) ? ((Number) defaultValue.invoke(Integer.valueOf(i3))).intValue() : iArr[i3];
    }

    private static final Integer elementAtOrNull(int[] iArr, int i3) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return getOrNull(iArr, i3);
    }

    public static final List<Byte> filterIndexed(byte[] bArr, Function2<? super Integer, ? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = bArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            byte b3 = bArr[i3];
            int i5 = i4 + 1;
            if (((Boolean) predicate.invoke(Integer.valueOf(i4), Byte.valueOf(b3))).booleanValue()) {
                arrayList.add(Byte.valueOf(b3));
            }
            i3++;
            i4 = i5;
        }
        return arrayList;
    }

    public static final <C extends Collection<? super Integer>> C filterNotTo(int[] iArr, C destination, Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int i3 : iArr) {
            if (!((Boolean) predicate.invoke(Integer.valueOf(i3))).booleanValue()) {
                destination.add(Integer.valueOf(i3));
            }
        }
        return destination;
    }

    public static final <C extends Collection<? super Integer>> C filterTo(int[] iArr, C destination, Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int i3 : iArr) {
            if (((Boolean) predicate.invoke(Integer.valueOf(i3))).booleanValue()) {
                destination.add(Integer.valueOf(i3));
            }
        }
        return destination;
    }

    private static final Integer find(int[] iArr, Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int i3 : iArr) {
            if (((Boolean) predicate.invoke(Integer.valueOf(i3))).booleanValue()) {
                return Integer.valueOf(i3);
            }
        }
        return null;
    }

    private static final Byte findLast(byte[] bArr, Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = bArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i3 = length - 1;
            byte b3 = bArr[length];
            if (((Boolean) predicate.invoke(Byte.valueOf(b3))).booleanValue()) {
                return Byte.valueOf(b3);
            }
            if (i3 < 0) {
                return null;
            }
            length = i3;
        }
    }

    public static byte first(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (bArr.length != 0) {
            return bArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final Integer firstOrNull(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (iArr.length == 0) {
            return null;
        }
        return Integer.valueOf(iArr[0]);
    }

    private static final <R> List<R> flatMapIndexedIterable(int[] iArr, Function2<? super Integer, ? super Integer, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = iArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, (Iterable) transform.invoke(Integer.valueOf(i4), Integer.valueOf(iArr[i3])));
            i3++;
            i4++;
        }
        return arrayList;
    }

    private static final <R, C extends Collection<? super R>> C flatMapIndexedIterableTo(byte[] bArr, C destination, Function2<? super Integer, ? super Byte, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = bArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            CollectionsKt__MutableCollectionsKt.addAll(destination, (Iterable) transform.invoke(Integer.valueOf(i4), Byte.valueOf(bArr[i3])));
            i3++;
            i4++;
        }
        return destination;
    }

    public static final <R, C extends Collection<? super R>> C flatMapTo(byte[] bArr, C destination, Function1<? super Byte, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (byte b3 : bArr) {
            CollectionsKt__MutableCollectionsKt.addAll(destination, (Iterable) transform.invoke(Byte.valueOf(b3)));
        }
        return destination;
    }

    public static final <R> R fold(int[] iArr, R r2, Function2<? super R, ? super Integer, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int i3 : iArr) {
            r2 = (R) operation.invoke(r2, Integer.valueOf(i3));
        }
        return r2;
    }

    public static final <R> R foldIndexed(int[] iArr, R r2, Function3<? super Integer, ? super R, ? super Integer, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int length = iArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            r2 = (R) operation.invoke(Integer.valueOf(i4), r2, Integer.valueOf(iArr[i3]));
            i3++;
            i4++;
        }
        return r2;
    }

    public static final void forEach(int[] iArr, Function1<? super Integer, Unit> action) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        for (int i3 : iArr) {
            action.invoke(Integer.valueOf(i3));
        }
    }

    public static final void forEachIndexed(int[] iArr, Function2<? super Integer, ? super Integer, Unit> action) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int length = iArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            action.invoke(Integer.valueOf(i4), Integer.valueOf(iArr[i3]));
            i3++;
            i4++;
        }
    }

    public static IntRange getIndices(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return new IntRange(0, getLastIndex(iArr));
    }

    public static int getLastIndex(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return iArr.length - 1;
    }

    private static final int getOrElse(int[] iArr, int i3, Function1<? super Integer, Integer> defaultValue) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return (i3 < 0 || i3 >= iArr.length) ? ((Number) defaultValue.invoke(Integer.valueOf(i3))).intValue() : iArr[i3];
    }

    public static Integer getOrNull(int[] iArr, int i3) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (i3 < 0 || i3 >= iArr.length) {
            return null;
        }
        return Integer.valueOf(iArr[i3]);
    }

    private static final boolean isEmpty(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return iArr.length == 0;
    }

    private static final boolean isNotEmpty(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return !(iArr.length == 0);
    }

    public static final String joinToString(int[] iArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i3, CharSequence truncated, Function1<? super Integer, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        return ((StringBuilder) joinTo(iArr, new StringBuilder(), separator, prefix, postfix, i3, truncated, function1)).toString();
    }

    public static /* synthetic */ String joinToString$default(int[] iArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i3, CharSequence charSequence4, Function1 function1, int i4, Object obj) {
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
        return joinToString(iArr, charSequence, charSequence2, charSequence3, i3, charSequence5, (Function1<? super Integer, ? extends CharSequence>) function12);
    }

    public static byte last(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (bArr.length != 0) {
            return bArr[getLastIndex(bArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final Integer lastOrNull(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (iArr.length == 0) {
            return null;
        }
        return Integer.valueOf(iArr[iArr.length - 1]);
    }

    public static final <R> List<R> map(byte[] bArr, Function1<? super Byte, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte b3 : bArr) {
            arrayList.add(transform.invoke(Byte.valueOf(b3)));
        }
        return arrayList;
    }

    public static final <R> List<R> mapIndexed(byte[] bArr, Function2<? super Integer, ? super Byte, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(bArr.length);
        int length = bArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            arrayList.add(transform.invoke(Integer.valueOf(i4), Byte.valueOf(bArr[i3])));
            i3++;
            i4++;
        }
        return arrayList;
    }

    public static final boolean none(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return iArr.length == 0;
    }

    private static final int[] onEach(int[] iArr, Function1<? super Integer, Unit> action) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        for (int i3 : iArr) {
            action.invoke(Integer.valueOf(i3));
        }
        return iArr;
    }

    private static final int[] onEachIndexed(int[] iArr, Function2<? super Integer, ? super Integer, Unit> action) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int length = iArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            action.invoke(Integer.valueOf(i4), Integer.valueOf(iArr[i3]));
            i3++;
            i4++;
        }
        return iArr;
    }

    private static final int random(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return random(iArr, (Random) Random.f140182a);
    }

    private static final Integer randomOrNull(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return randomOrNull(iArr, (Random) Random.f140182a);
    }

    public static final Byte reduceRightIndexedOrNull(byte[] bArr, Function3<? super Integer, ? super Byte, ? super Byte, Byte> operation) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(bArr);
        if (lastIndex < 0) {
            return null;
        }
        byte bByteValue = bArr[lastIndex];
        for (int i3 = lastIndex - 1; i3 >= 0; i3--) {
            bByteValue = ((Number) operation.invoke(Integer.valueOf(i3), Byte.valueOf(bArr[i3]), Byte.valueOf(bByteValue))).byteValue();
        }
        return Byte.valueOf(bByteValue);
    }

    public static final Byte reduceRightOrNull(byte[] bArr, Function2<? super Byte, ? super Byte, Byte> operation) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(bArr);
        if (lastIndex < 0) {
            return null;
        }
        byte bByteValue = bArr[lastIndex];
        for (int i3 = lastIndex - 1; i3 >= 0; i3--) {
            bByteValue = ((Number) operation.invoke(Byte.valueOf(bArr[i3]), Byte.valueOf(bByteValue))).byteValue();
        }
        return Byte.valueOf(bByteValue);
    }

    public static final List<Byte> reversed(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (bArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<Byte> mutableList = toMutableList(bArr);
        CollectionsKt___CollectionsJvmKt.reverse(mutableList);
        return mutableList;
    }

    private static final <R> List<R> scan(long[] jArr, R r2, Function2<? super R, ? super Long, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (jArr.length == 0) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(jArr.length + 1);
        arrayList.add(r2);
        for (long j3 : jArr) {
            r2 = (R) operation.invoke(r2, Long.valueOf(j3));
            arrayList.add(r2);
        }
        return arrayList;
    }

    private static final <R> List<R> scanIndexed(long[] jArr, R r2, Function3<? super Integer, ? super R, ? super Long, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (jArr.length == 0) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(jArr.length + 1);
        arrayList.add(r2);
        int length = jArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            r2 = (R) operation.invoke(Integer.valueOf(i3), r2, Long.valueOf(jArr[i3]));
            arrayList.add(r2);
        }
        return arrayList;
    }

    public static final void shuffle(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        shuffle(iArr, (Random) Random.f140182a);
    }

    public static final Integer singleOrNull(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (iArr.length == 1) {
            return Integer.valueOf(iArr[0]);
        }
        return null;
    }

    public static byte[] sliceArray(byte[] bArr, Collection<Integer> indices) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        byte[] bArr2 = new byte[indices.size()];
        Iterator<Integer> it = indices.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            bArr2[i3] = bArr[it.next().intValue()];
            i3++;
        }
        return bArr2;
    }

    public static final List<Integer> sorted(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Integer[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(iArr);
        ArraysKt___ArraysJvmKt.sort((Object[]) typedArray);
        return ArraysKt___ArraysJvmKt.asList(typedArray);
    }

    public static final <R extends Comparable<? super R>> List<Integer> sortedBy(int[] iArr, Function1<? super Integer, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(iArr, (Comparator<? super Integer>) new ComparisonsKt__ComparisonsKt$compareBy$2(selector));
    }

    public static final <R extends Comparable<? super R>> List<Integer> sortedByDescending(int[] iArr, Function1<? super Integer, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(iArr, (Comparator<? super Integer>) new ComparisonsKt__ComparisonsKt$compareByDescending$1(selector));
    }

    public static final List<Integer> sortedDescending(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
        ArraysKt___ArraysJvmKt.sort(iArrCopyOf);
        return reversed(iArrCopyOf);
    }

    public static final List<Integer> sortedWith(int[] iArr, Comparator<? super Integer> comparator) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Integer[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(iArr);
        ArraysKt___ArraysJvmKt.sortWith(typedArray, comparator);
        return ArraysKt___ArraysJvmKt.asList(typedArray);
    }

    public static long sum(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        long j3 = 0;
        for (long j4 : jArr) {
            j3 += j4;
        }
        return j3;
    }

    private static final int sumOfUInt(byte[] bArr, Function1<? super Byte, UInt> selector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iB = UInt.b(0);
        for (byte b3 : bArr) {
            iB = UInt.b(iB + ((UInt) selector.invoke(Byte.valueOf(b3))).f());
        }
        return iB;
    }

    private static final long sumOfULong(byte[] bArr, Function1<? super Byte, ULong> selector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        long jB = ULong.b(0L);
        for (byte b3 : bArr) {
            jB = ULong.b(jB + ((ULong) selector.invoke(Byte.valueOf(b3))).g());
        }
        return jB;
    }

    public static final HashSet<Integer> toHashSet(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return (HashSet) toCollection(iArr, new HashSet(MapsKt__MapsJVMKt.mapCapacity(iArr.length)));
    }

    public static final List<Short> toMutableList(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        ArrayList arrayList = new ArrayList(sArr.length);
        for (short s2 : sArr) {
            arrayList.add(Short.valueOf(s2));
        }
        return arrayList;
    }

    public static final Set<Integer> toMutableSet(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return (Set) toCollection(iArr, new LinkedHashSet(MapsKt__MapsJVMKt.mapCapacity(iArr.length)));
    }

    public static final Iterable<IndexedValue<Integer>> withIndex(final int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return new IndexingIterable(new Function0() { // from class: kotlin.collections.j
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ArrayIteratorsKt.f(iArr);
            }
        });
    }

    public static final <R, V> List<V> zip(byte[] bArr, R[] other, Function2<? super Byte, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iMin = Math.min(bArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i3 = 0; i3 < iMin; i3++) {
            arrayList.add(transform.invoke(Byte.valueOf(bArr[i3]), other[i3]));
        }
        return arrayList;
    }

    public static final boolean all(long[] jArr, Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (long j3 : jArr) {
            if (!((Boolean) predicate.invoke(Long.valueOf(j3))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static boolean any(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return !(jArr.length == 0);
    }

    public static final Iterable<Short> asIterable(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return sArr.length == 0 ? CollectionsKt__CollectionsKt.emptyList() : new ArraysKt___ArraysKt$asIterable$$inlined$Iterable$3(sArr);
    }

    public static final Sequence<Short> asSequence(final short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return sArr.length == 0 ? SequencesKt.g() : new Sequence<Short>() { // from class: kotlin.collections.ArraysKt___ArraysKt$asSequence$$inlined$Sequence$3
            @Override // kotlin.sequences.Sequence
            public Iterator<Short> iterator() {
                return ArrayIteratorsKt.h(sArr);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> associate(byte[] bArr, Function1<? super Byte, ? extends Pair<? extends K, ? extends V>> transform) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt__MapsJVMKt.mapCapacity(bArr.length), 16));
        for (byte b3 : bArr) {
            Pair pair = (Pair) transform.invoke(Byte.valueOf(b3));
            linkedHashMap.put(pair.e(), pair.f());
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K> Map<K, Byte> associateBy(byte[] bArr, Function1<? super Byte, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt__MapsJVMKt.mapCapacity(bArr.length), 16));
        for (byte b3 : bArr) {
            linkedHashMap.put(keySelector.invoke(Byte.valueOf(b3)), Byte.valueOf(b3));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, M extends Map<? super K, ? super Short>> M associateByTo(short[] sArr, M destination, Function1<? super Short, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (short s2 : sArr) {
            destination.put(keySelector.invoke(Short.valueOf(s2)), Short.valueOf(s2));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(short[] sArr, M destination, Function1<? super Short, ? extends Pair<? extends K, ? extends V>> transform) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (short s2 : sArr) {
            Pair pair = (Pair) transform.invoke(Short.valueOf(s2));
            destination.put(pair.e(), pair.f());
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <V, M extends Map<? super Short, ? super V>> M associateWithTo(short[] sArr, M destination, Function1<? super Short, ? extends V> valueSelector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        for (short s2 : sArr) {
            destination.put(Short.valueOf(s2), valueSelector.invoke(Short.valueOf(s2)));
        }
        return destination;
    }

    public static final double average(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        double d3 = 0.0d;
        int i3 = 0;
        for (float f3 : fArr) {
            d3 += (double) f3;
            i3++;
        }
        if (i3 == 0) {
            return Double.NaN;
        }
        return d3 / ((double) i3);
    }

    private static final long component1(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return jArr[0];
    }

    private static final long component2(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return jArr[1];
    }

    private static final long component3(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return jArr[2];
    }

    private static final long component4(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return jArr[3];
    }

    private static final long component5(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return jArr[4];
    }

    public static boolean contains(long[] jArr, long j3) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return indexOf(jArr, j3) >= 0;
    }

    private static final byte[] copyOf(byte[] bArr, int i3, Function1<? super Integer, Byte> init) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(init, "init");
        if (i3 >= 0) {
            byte[] bArrCopyOf = Arrays.copyOf(bArr, i3);
            Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
            for (int length = bArr.length; length < i3; length++) {
                bArrCopyOf[length] = ((Number) init.invoke(Integer.valueOf(length))).byteValue();
            }
            return bArrCopyOf;
        }
        throw new IllegalArgumentException(("Invalid new array size: " + i3 + '.').toString());
    }

    private static final int count(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return jArr.length;
    }

    public static final List<Long> distinct(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return CollectionsKt___CollectionsKt.toList(toMutableSet(jArr));
    }

    public static final List<Short> drop(short[] sArr, int i3) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        if (i3 >= 0) {
            return takeLast(sArr, RangesKt.f(sArr.length - i3, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
    }

    public static final List<Short> dropLast(short[] sArr, int i3) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        if (i3 >= 0) {
            return take(sArr, RangesKt.f(sArr.length - i3, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
    }

    public static final List<Byte> dropLastWhile(byte[] bArr, Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = getLastIndex(bArr); -1 < lastIndex; lastIndex--) {
            if (!((Boolean) predicate.invoke(Byte.valueOf(bArr[lastIndex]))).booleanValue()) {
                return take(bArr, lastIndex + 1);
            }
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    private static final long elementAtOrElse(long[] jArr, int i3, Function1<? super Integer, Long> defaultValue) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return (i3 < 0 || i3 >= jArr.length) ? ((Number) defaultValue.invoke(Integer.valueOf(i3))).longValue() : jArr[i3];
    }

    private static final Long elementAtOrNull(long[] jArr, int i3) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return getOrNull(jArr, i3);
    }

    public static final List<Short> filter(short[] sArr, Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (short s2 : sArr) {
            if (((Boolean) predicate.invoke(Short.valueOf(s2))).booleanValue()) {
                arrayList.add(Short.valueOf(s2));
            }
        }
        return arrayList;
    }

    public static final <C extends Collection<? super Short>> C filterIndexedTo(short[] sArr, C destination, Function2<? super Integer, ? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = sArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            short s2 = sArr[i3];
            int i5 = i4 + 1;
            if (((Boolean) predicate.invoke(Integer.valueOf(i4), Short.valueOf(s2))).booleanValue()) {
                destination.add(Short.valueOf(s2));
            }
            i3++;
            i4 = i5;
        }
        return destination;
    }

    public static final List<Short> filterNot(short[] sArr, Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (short s2 : sArr) {
            if (!((Boolean) predicate.invoke(Short.valueOf(s2))).booleanValue()) {
                arrayList.add(Short.valueOf(s2));
            }
        }
        return arrayList;
    }

    public static final <C extends Collection<? super Long>> C filterNotTo(long[] jArr, C destination, Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (long j3 : jArr) {
            if (!((Boolean) predicate.invoke(Long.valueOf(j3))).booleanValue()) {
                destination.add(Long.valueOf(j3));
            }
        }
        return destination;
    }

    public static final <C extends Collection<? super Long>> C filterTo(long[] jArr, C destination, Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (long j3 : jArr) {
            if (((Boolean) predicate.invoke(Long.valueOf(j3))).booleanValue()) {
                destination.add(Long.valueOf(j3));
            }
        }
        return destination;
    }

    private static final Long find(long[] jArr, Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (long j3 : jArr) {
            if (((Boolean) predicate.invoke(Long.valueOf(j3))).booleanValue()) {
                return Long.valueOf(j3);
            }
        }
        return null;
    }

    public static final Long firstOrNull(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        if (jArr.length == 0) {
            return null;
        }
        return Long.valueOf(jArr[0]);
    }

    public static final <R> List<R> flatMap(byte[] bArr, Function1<? super Byte, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (byte b3 : bArr) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, (Iterable) transform.invoke(Byte.valueOf(b3)));
        }
        return arrayList;
    }

    private static final <R> List<R> flatMapIndexedIterable(long[] jArr, Function2<? super Integer, ? super Long, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = jArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, (Iterable) transform.invoke(Integer.valueOf(i4), Long.valueOf(jArr[i3])));
            i3++;
            i4++;
        }
        return arrayList;
    }

    public static final <R> R fold(long[] jArr, R r2, Function2<? super R, ? super Long, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (long j3 : jArr) {
            r2 = (R) operation.invoke(r2, Long.valueOf(j3));
        }
        return r2;
    }

    public static final <R> R foldIndexed(long[] jArr, R r2, Function3<? super Integer, ? super R, ? super Long, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int length = jArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            r2 = (R) operation.invoke(Integer.valueOf(i4), r2, Long.valueOf(jArr[i3]));
            i3++;
            i4++;
        }
        return r2;
    }

    public static final <R> R foldRight(short[] sArr, R r2, Function2<? super Short, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = getLastIndex(sArr); lastIndex >= 0; lastIndex--) {
            r2 = (R) operation.invoke(Short.valueOf(sArr[lastIndex]), r2);
        }
        return r2;
    }

    public static final <R> R foldRightIndexed(short[] sArr, R r2, Function3<? super Integer, ? super Short, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = getLastIndex(sArr); lastIndex >= 0; lastIndex--) {
            r2 = (R) operation.invoke(Integer.valueOf(lastIndex), Short.valueOf(sArr[lastIndex]), r2);
        }
        return r2;
    }

    public static final void forEach(long[] jArr, Function1<? super Long, Unit> action) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        for (long j3 : jArr) {
            action.invoke(Long.valueOf(j3));
        }
    }

    public static final void forEachIndexed(long[] jArr, Function2<? super Integer, ? super Long, Unit> action) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int length = jArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            action.invoke(Integer.valueOf(i4), Long.valueOf(jArr[i3]));
            i3++;
            i4++;
        }
    }

    public static IntRange getIndices(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return new IntRange(0, getLastIndex(jArr));
    }

    public static int getLastIndex(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return jArr.length - 1;
    }

    private static final long getOrElse(long[] jArr, int i3, Function1<? super Integer, Long> defaultValue) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return (i3 < 0 || i3 >= jArr.length) ? ((Number) defaultValue.invoke(Integer.valueOf(i3))).longValue() : jArr[i3];
    }

    public static final Long getOrNull(long[] jArr, int i3) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        if (i3 < 0 || i3 >= jArr.length) {
            return null;
        }
        return Long.valueOf(jArr[i3]);
    }

    public static int indexOf(byte[] bArr, byte b3) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int length = bArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (b3 == bArr[i3]) {
                return i3;
            }
        }
        return -1;
    }

    public static final int indexOfFirst(short[] sArr, Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = sArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (((Boolean) predicate.invoke(Short.valueOf(sArr[i3]))).booleanValue()) {
                return i3;
            }
        }
        return -1;
    }

    public static final int indexOfLast(short[] sArr, Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = sArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i3 = length - 1;
                if (((Boolean) predicate.invoke(Short.valueOf(sArr[length]))).booleanValue()) {
                    return length;
                }
                if (i3 < 0) {
                    break;
                }
                length = i3;
            }
        }
        return -1;
    }

    public static final Set<Short> intersect(short[] sArr, Iterable<Short> other) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Short> mutableSet = toMutableSet(sArr);
        CollectionsKt__MutableCollectionsKt.retainAll(mutableSet, other);
        return mutableSet;
    }

    private static final boolean isEmpty(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return jArr.length == 0;
    }

    private static final boolean isNotEmpty(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return !(jArr.length == 0);
    }

    public static final String joinToString(long[] jArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i3, CharSequence truncated, Function1<? super Long, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        return ((StringBuilder) joinTo(jArr, new StringBuilder(), separator, prefix, postfix, i3, truncated, function1)).toString();
    }

    public static /* synthetic */ String joinToString$default(long[] jArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i3, CharSequence charSequence4, Function1 function1, int i4, Object obj) {
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
        return joinToString(jArr, charSequence, charSequence2, charSequence3, i3, charSequence5, (Function1<? super Long, ? extends CharSequence>) function12);
    }

    public static int lastIndexOf(byte[] bArr, byte b3) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int length = bArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i3 = length - 1;
                if (b3 == bArr[length]) {
                    return length;
                }
                if (i3 < 0) {
                    break;
                }
                length = i3;
            }
        }
        return -1;
    }

    public static final Long lastOrNull(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        if (jArr.length == 0) {
            return null;
        }
        return Long.valueOf(jArr[jArr.length - 1]);
    }

    public static final <R, C extends Collection<? super R>> C mapIndexedTo(short[] sArr, C destination, Function2<? super Integer, ? super Short, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = sArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            destination.add(transform.invoke(Integer.valueOf(i4), Short.valueOf(sArr[i3])));
            i3++;
            i4++;
        }
        return destination;
    }

    public static final <R, C extends Collection<? super R>> C mapTo(short[] sArr, C destination, Function1<? super Short, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (short s2 : sArr) {
            destination.add(transform.invoke(Short.valueOf(s2)));
        }
        return destination;
    }

    public static final boolean none(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return jArr.length == 0;
    }

    private static final long[] onEach(long[] jArr, Function1<? super Long, Unit> action) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        for (long j3 : jArr) {
            action.invoke(Long.valueOf(j3));
        }
        return jArr;
    }

    private static final long[] onEachIndexed(long[] jArr, Function2<? super Integer, ? super Long, Unit> action) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int length = jArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            action.invoke(Integer.valueOf(i4), Long.valueOf(jArr[i3]));
            i3++;
            i4++;
        }
        return jArr;
    }

    private static final long random(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return random(jArr, (Random) Random.f140182a);
    }

    private static final Long randomOrNull(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return randomOrNull(jArr, (Random) Random.f140182a);
    }

    public static final Byte reduceIndexedOrNull(byte[] bArr, Function3<? super Integer, ? super Byte, ? super Byte, Byte> operation) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (bArr.length == 0) {
            return null;
        }
        byte bByteValue = bArr[0];
        int lastIndex = getLastIndex(bArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                bByteValue = ((Number) operation.invoke(Integer.valueOf(i3), Byte.valueOf(bByteValue), Byte.valueOf(bArr[i3]))).byteValue();
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Byte.valueOf(bByteValue);
    }

    public static final Byte reduceOrNull(byte[] bArr, Function2<? super Byte, ? super Byte, Byte> operation) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (bArr.length == 0) {
            return null;
        }
        byte bByteValue = bArr[0];
        int lastIndex = getLastIndex(bArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                bByteValue = ((Number) operation.invoke(Byte.valueOf(bByteValue), Byte.valueOf(bArr[i3]))).byteValue();
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Byte.valueOf(bByteValue);
    }

    public static final byte reduceRight(byte[] bArr, Function2<? super Byte, ? super Byte, Byte> operation) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(bArr);
        if (lastIndex >= 0) {
            byte bByteValue = bArr[lastIndex];
            for (int i3 = lastIndex - 1; i3 >= 0; i3--) {
                bByteValue = ((Number) operation.invoke(Byte.valueOf(bArr[i3]), Byte.valueOf(bByteValue))).byteValue();
            }
            return bByteValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final byte reduceRightIndexed(byte[] bArr, Function3<? super Integer, ? super Byte, ? super Byte, Byte> operation) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(bArr);
        if (lastIndex >= 0) {
            byte bByteValue = bArr[lastIndex];
            for (int i3 = lastIndex - 1; i3 >= 0; i3--) {
                bByteValue = ((Number) operation.invoke(Integer.valueOf(i3), Byte.valueOf(bArr[i3]), Byte.valueOf(bByteValue))).byteValue();
            }
            return bByteValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static byte[] reversedArray(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (bArr.length == 0) {
            return bArr;
        }
        byte[] bArr2 = new byte[bArr.length];
        int lastIndex = getLastIndex(bArr);
        if (lastIndex >= 0) {
            int i3 = 0;
            while (true) {
                bArr2[lastIndex - i3] = bArr[i3];
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return bArr2;
    }

    private static final <R> List<R> scan(float[] fArr, R r2, Function2<? super R, ? super Float, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (fArr.length == 0) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(fArr.length + 1);
        arrayList.add(r2);
        for (float f3 : fArr) {
            r2 = (R) operation.invoke(r2, Float.valueOf(f3));
            arrayList.add(r2);
        }
        return arrayList;
    }

    private static final <R> List<R> scanIndexed(float[] fArr, R r2, Function3<? super Integer, ? super R, ? super Float, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (fArr.length == 0) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(fArr.length + 1);
        arrayList.add(r2);
        int length = fArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            r2 = (R) operation.invoke(Integer.valueOf(i3), r2, Float.valueOf(fArr[i3]));
            arrayList.add(r2);
        }
        return arrayList;
    }

    public static final void shuffle(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        shuffle(jArr, (Random) Random.f140182a);
    }

    public static byte single(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int length = bArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return bArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static final Long singleOrNull(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        if (jArr.length == 1) {
            return Long.valueOf(jArr[0]);
        }
        return null;
    }

    public static final List<Short> slice(short[] sArr, IntRange indices) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? CollectionsKt__CollectionsKt.emptyList() : ArraysKt___ArraysJvmKt.asList(ArraysKt___ArraysJvmKt.copyOfRange(sArr, indices.a().intValue(), indices.e().intValue() + 1));
    }

    public static final void sortDescending(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        if (sArr.length > 1) {
            ArraysKt___ArraysJvmKt.sort(sArr);
            reverse(sArr);
        }
    }

    public static final List<Long> sorted(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Long[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(jArr);
        ArraysKt___ArraysJvmKt.sort((Object[]) typedArray);
        return ArraysKt___ArraysJvmKt.asList(typedArray);
    }

    public static final short[] sortedArray(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        if (sArr.length == 0) {
            return sArr;
        }
        short[] sArrCopyOf = Arrays.copyOf(sArr, sArr.length);
        Intrinsics.checkNotNullExpressionValue(sArrCopyOf, qRMDmh.MHWJqOHAKw);
        ArraysKt___ArraysJvmKt.sort(sArrCopyOf);
        return sArrCopyOf;
    }

    public static final short[] sortedArrayDescending(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        if (sArr.length == 0) {
            return sArr;
        }
        short[] sArrCopyOf = Arrays.copyOf(sArr, sArr.length);
        Intrinsics.checkNotNullExpressionValue(sArrCopyOf, "copyOf(...)");
        sortDescending(sArrCopyOf);
        return sArrCopyOf;
    }

    public static final <R extends Comparable<? super R>> List<Long> sortedBy(long[] jArr, Function1<? super Long, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(jArr, (Comparator<? super Long>) new ComparisonsKt__ComparisonsKt$compareBy$2(selector));
    }

    public static final <R extends Comparable<? super R>> List<Long> sortedByDescending(long[] jArr, Function1<? super Long, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(jArr, (Comparator<? super Long>) new ComparisonsKt__ComparisonsKt$compareByDescending$1(selector));
    }

    public static final List<Long> sortedDescending(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        long[] jArrCopyOf = Arrays.copyOf(jArr, jArr.length);
        Intrinsics.checkNotNullExpressionValue(jArrCopyOf, "copyOf(...)");
        ArraysKt___ArraysJvmKt.sort(jArrCopyOf);
        return reversed(jArrCopyOf);
    }

    public static final List<Long> sortedWith(long[] jArr, Comparator<? super Long> comparator) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Long[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(jArr);
        ArraysKt___ArraysJvmKt.sortWith(typedArray, comparator);
        return ArraysKt___ArraysJvmKt.asList(typedArray);
    }

    public static final Set<Short> subtract(short[] sArr, Iterable<Short> other) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Short> mutableSet = toMutableSet(sArr);
        CollectionsKt__MutableCollectionsKt.removeAll(mutableSet, other);
        return mutableSet;
    }

    public static final float sum(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        float f3 = 0.0f;
        for (float f4 : fArr) {
            f3 += f4;
        }
        return f3;
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final int sumBy(short[] sArr, Function1<? super Short, Integer> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iIntValue = 0;
        for (short s2 : sArr) {
            iIntValue += ((Number) selector.invoke(Short.valueOf(s2))).intValue();
        }
        return iIntValue;
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final double sumByDouble(short[] sArr, Function1<? super Short, Double> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        double dDoubleValue = 0.0d;
        for (short s2 : sArr) {
            dDoubleValue += ((Number) selector.invoke(Short.valueOf(s2))).doubleValue();
        }
        return dDoubleValue;
    }

    private static final double sumOfDouble(short[] sArr, Function1<? super Short, Double> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        double dDoubleValue = 0.0d;
        for (short s2 : sArr) {
            dDoubleValue += ((Number) selector.invoke(Short.valueOf(s2))).doubleValue();
        }
        return dDoubleValue;
    }

    private static final int sumOfInt(short[] sArr, Function1<? super Short, Integer> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iIntValue = 0;
        for (short s2 : sArr) {
            iIntValue += ((Number) selector.invoke(Short.valueOf(s2))).intValue();
        }
        return iIntValue;
    }

    private static final long sumOfLong(short[] sArr, Function1<? super Short, Long> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        long jLongValue = 0;
        for (short s2 : sArr) {
            jLongValue += ((Number) selector.invoke(Short.valueOf(s2))).longValue();
        }
        return jLongValue;
    }

    public static final List<Byte> takeLastWhile(byte[] bArr, Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = getLastIndex(bArr); -1 < lastIndex; lastIndex--) {
            if (!((Boolean) predicate.invoke(Byte.valueOf(bArr[lastIndex]))).booleanValue()) {
                return drop(bArr, lastIndex + 1);
            }
        }
        return toList(bArr);
    }

    public static final List<Byte> takeWhile(byte[] bArr, Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (byte b3 : bArr) {
            if (!((Boolean) predicate.invoke(Byte.valueOf(b3))).booleanValue()) {
                break;
            }
            arrayList.add(Byte.valueOf(b3));
        }
        return arrayList;
    }

    public static final <C extends Collection<? super Short>> C toCollection(short[] sArr, C destination) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        for (short s2 : sArr) {
            destination.add(Short.valueOf(s2));
        }
        return destination;
    }

    public static final HashSet<Long> toHashSet(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return (HashSet) toCollection(jArr, new HashSet(MapsKt__MapsJVMKt.mapCapacity(jArr.length)));
    }

    public static List<Byte> toList(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int length = bArr.length;
        if (length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (length != 1) {
            return toMutableList(bArr);
        }
        return CollectionsKt__CollectionsJVMKt.listOf(Byte.valueOf(bArr[0]));
    }

    public static final Set<Long> toMutableSet(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return (Set) toCollection(jArr, new LinkedHashSet(MapsKt__MapsJVMKt.mapCapacity(jArr.length)));
    }

    public static final Set<Byte> toSet(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int length = bArr.length;
        if (length == 0) {
            return SetsKt__SetsKt.emptySet();
        }
        if (length != 1) {
            return (Set) toCollection(bArr, new LinkedHashSet(MapsKt__MapsJVMKt.mapCapacity(bArr.length)));
        }
        return SetsKt__SetsJVMKt.setOf(Byte.valueOf(bArr[0]));
    }

    public static final Set<Short> union(short[] sArr, Iterable<Short> other) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Short> mutableSet = toMutableSet(sArr);
        CollectionsKt__MutableCollectionsKt.addAll(mutableSet, other);
        return mutableSet;
    }

    public static final Iterable<IndexedValue<Long>> withIndex(final long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return new IndexingIterable(new Function0() { // from class: kotlin.collections.g
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ArrayIteratorsKt.g(jArr);
            }
        });
    }

    public static final boolean all(float[] fArr, Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (float f3 : fArr) {
            if (!((Boolean) predicate.invoke(Float.valueOf(f3))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean any(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return !(fArr.length == 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <V> Map<Short, V> associateWith(short[] sArr, Function1<? super Short, ? extends V> valueSelector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt__MapsJVMKt.mapCapacity(sArr.length), 16));
        for (short s2 : sArr) {
            linkedHashMap.put(Short.valueOf(s2), valueSelector.invoke(Short.valueOf(s2)));
        }
        return linkedHashMap;
    }

    public static final double average(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        double d3 = 0.0d;
        int i3 = 0;
        for (double d4 : dArr) {
            d3 += d4;
            i3++;
        }
        if (i3 == 0) {
            return Double.NaN;
        }
        return d3 / ((double) i3);
    }

    private static final float component1(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return fArr[0];
    }

    private static final float component2(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return fArr[1];
    }

    private static final float component3(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return fArr[2];
    }

    private static final float component4(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return fArr[3];
    }

    private static final float component5(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return fArr[4];
    }

    public static final boolean contains(boolean[] zArr, boolean z2) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return indexOf(zArr, z2) >= 0;
    }

    private static final int count(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return fArr.length;
    }

    public static final List<Float> distinct(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return CollectionsKt___CollectionsKt.toList(toMutableSet(fArr));
    }

    public static final List<Byte> dropWhile(byte[] bArr, Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z2 = false;
        for (byte b3 : bArr) {
            if (z2) {
                arrayList.add(Byte.valueOf(b3));
            } else if (!((Boolean) predicate.invoke(Byte.valueOf(b3))).booleanValue()) {
                arrayList.add(Byte.valueOf(b3));
                z2 = true;
            }
        }
        return arrayList;
    }

    private static final float elementAtOrElse(float[] fArr, int i3, Function1<? super Integer, Float> defaultValue) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return (i3 < 0 || i3 >= fArr.length) ? ((Number) defaultValue.invoke(Integer.valueOf(i3))).floatValue() : fArr[i3];
    }

    private static final Float elementAtOrNull(float[] fArr, int i3) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return getOrNull(fArr, i3);
    }

    public static final <C extends Collection<? super Float>> C filterNotTo(float[] fArr, C destination, Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (float f3 : fArr) {
            if (!((Boolean) predicate.invoke(Float.valueOf(f3))).booleanValue()) {
                destination.add(Float.valueOf(f3));
            }
        }
        return destination;
    }

    public static final <C extends Collection<? super Float>> C filterTo(float[] fArr, C destination, Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (float f3 : fArr) {
            if (((Boolean) predicate.invoke(Float.valueOf(f3))).booleanValue()) {
                destination.add(Float.valueOf(f3));
            }
        }
        return destination;
    }

    private static final Float find(float[] fArr, Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (float f3 : fArr) {
            if (((Boolean) predicate.invoke(Float.valueOf(f3))).booleanValue()) {
                return Float.valueOf(f3);
            }
        }
        return null;
    }

    public static final Float firstOrNull(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (fArr.length == 0) {
            return null;
        }
        return Float.valueOf(fArr[0]);
    }

    private static final <R> List<R> flatMapIndexedIterable(float[] fArr, Function2<? super Integer, ? super Float, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = fArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, (Iterable) transform.invoke(Integer.valueOf(i4), Float.valueOf(fArr[i3])));
            i3++;
            i4++;
        }
        return arrayList;
    }

    public static final <R> R fold(float[] fArr, R r2, Function2<? super R, ? super Float, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (float f3 : fArr) {
            r2 = (R) operation.invoke(r2, Float.valueOf(f3));
        }
        return r2;
    }

    public static final <R> R foldIndexed(float[] fArr, R r2, Function3<? super Integer, ? super R, ? super Float, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int length = fArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            r2 = (R) operation.invoke(Integer.valueOf(i4), r2, Float.valueOf(fArr[i3]));
            i3++;
            i4++;
        }
        return r2;
    }

    public static final void forEach(float[] fArr, Function1<? super Float, Unit> action) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        for (float f3 : fArr) {
            action.invoke(Float.valueOf(f3));
        }
    }

    public static final void forEachIndexed(float[] fArr, Function2<? super Integer, ? super Float, Unit> action) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int length = fArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            action.invoke(Integer.valueOf(i4), Float.valueOf(fArr[i3]));
            i3++;
            i4++;
        }
    }

    public static final IntRange getIndices(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return new IntRange(0, getLastIndex(fArr));
    }

    public static int getLastIndex(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return fArr.length - 1;
    }

    private static final float getOrElse(float[] fArr, int i3, Function1<? super Integer, Float> defaultValue) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return (i3 < 0 || i3 >= fArr.length) ? ((Number) defaultValue.invoke(Integer.valueOf(i3))).floatValue() : fArr[i3];
    }

    public static final Float getOrNull(float[] fArr, int i3) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (i3 < 0 || i3 >= fArr.length) {
            return null;
        }
        return Float.valueOf(fArr[i3]);
    }

    private static final boolean isEmpty(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return fArr.length == 0;
    }

    private static final boolean isNotEmpty(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return !(fArr.length == 0);
    }

    public static /* synthetic */ Appendable joinTo$default(float[] fArr, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i3, CharSequence charSequence4, Function1 function1, int i4, Object obj) {
        CharSequence charSequence5 = (i4 & 2) != 0 ? ", " : charSequence;
        int i5 = i4 & 4;
        CharSequence charSequence6 = jlWo.zIWn;
        CharSequence charSequence7 = i5 != 0 ? charSequence6 : charSequence2;
        if ((i4 & 8) == 0) {
            charSequence6 = charSequence3;
        }
        return joinTo(fArr, appendable, charSequence5, charSequence7, charSequence6, (i4 & 16) != 0 ? -1 : i3, (i4 & 32) != 0 ? "..." : charSequence4, (Function1<? super Float, ? extends CharSequence>) ((i4 & 64) != 0 ? null : function1));
    }

    public static final String joinToString(float[] fArr, CharSequence separator, CharSequence charSequence, CharSequence postfix, int i3, CharSequence truncated, Function1<? super Float, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(charSequence, YznnJpHcAmeoW.vPUvEDyd);
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        return ((StringBuilder) joinTo(fArr, new StringBuilder(), separator, charSequence, postfix, i3, truncated, function1)).toString();
    }

    public static /* synthetic */ String joinToString$default(float[] fArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i3, CharSequence charSequence4, Function1 function1, int i4, Object obj) {
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
        return joinToString(fArr, charSequence, charSequence2, charSequence3, i3, charSequence5, (Function1<? super Float, ? extends CharSequence>) function12);
    }

    public static final Float lastOrNull(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (fArr.length == 0) {
            return null;
        }
        return Float.valueOf(fArr[fArr.length - 1]);
    }

    private static final <R> R maxOfWithOrNull(byte[] bArr, Comparator<? super R> comparator, Function1<? super Byte, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        R r2 = (Object) selector.invoke(Byte.valueOf(bArr[0]));
        int lastIndex = getLastIndex(bArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object obj = (Object) selector.invoke(Byte.valueOf(bArr[i3]));
                if (comparator.compare(r2, obj) < 0) {
                    r2 = (R) obj;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    public static final Byte maxWithOrNull(byte[] bArr, Comparator<? super Byte> comparator) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (bArr.length == 0) {
            return null;
        }
        byte b3 = bArr[0];
        int lastIndex = getLastIndex(bArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte b4 = bArr[i3];
                if (comparator.compare(Byte.valueOf(b3), Byte.valueOf(b4)) < 0) {
                    b3 = b4;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Byte.valueOf(b3);
    }

    private static final <R> R minOfWithOrNull(byte[] bArr, Comparator<? super R> comparator, Function1<? super Byte, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        R r2 = (Object) selector.invoke(Byte.valueOf(bArr[0]));
        int lastIndex = getLastIndex(bArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object obj = (Object) selector.invoke(Byte.valueOf(bArr[i3]));
                if (comparator.compare(r2, obj) > 0) {
                    r2 = (R) obj;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    public static final Byte minWithOrNull(byte[] bArr, Comparator<? super Byte> comparator) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (bArr.length == 0) {
            return null;
        }
        byte b3 = bArr[0];
        int lastIndex = getLastIndex(bArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte b4 = bArr[i3];
                if (comparator.compare(Byte.valueOf(b3), Byte.valueOf(b4)) > 0) {
                    b3 = b4;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Byte.valueOf(b3);
    }

    public static final boolean none(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return fArr.length == 0;
    }

    private static final float[] onEach(float[] fArr, Function1<? super Float, Unit> action) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        for (float f3 : fArr) {
            action.invoke(Float.valueOf(f3));
        }
        return fArr;
    }

    private static final float[] onEachIndexed(float[] fArr, Function2<? super Integer, ? super Float, Unit> action) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int length = fArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            action.invoke(Integer.valueOf(i4), Float.valueOf(fArr[i3]));
            i3++;
            i4++;
        }
        return fArr;
    }

    private static final float random(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return random(fArr, (Random) Random.f140182a);
    }

    private static final Float randomOrNull(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return randomOrNull(fArr, (Random) Random.f140182a);
    }

    public static final byte reduce(byte[] bArr, Function2<? super Byte, ? super Byte, Byte> operation) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (bArr.length != 0) {
            byte bByteValue = bArr[0];
            int lastIndex = getLastIndex(bArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    bByteValue = ((Number) operation.invoke(Byte.valueOf(bByteValue), Byte.valueOf(bArr[i3]))).byteValue();
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return bByteValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final byte reduceIndexed(byte[] bArr, Function3<? super Integer, ? super Byte, ? super Byte, Byte> operation) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (bArr.length != 0) {
            byte bByteValue = bArr[0];
            int lastIndex = getLastIndex(bArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    bByteValue = ((Number) operation.invoke(Integer.valueOf(i3), Byte.valueOf(bByteValue), Byte.valueOf(bArr[i3]))).byteValue();
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return bByteValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static void reverse(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int length = (bArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int lastIndex = getLastIndex(bArr);
        if (length < 0) {
            return;
        }
        int i3 = 0;
        while (true) {
            byte b3 = bArr[i3];
            bArr[i3] = bArr[lastIndex];
            bArr[lastIndex] = b3;
            lastIndex--;
            if (i3 == length) {
                return;
            } else {
                i3++;
            }
        }
    }

    private static final <R> List<R> runningFold(byte[] bArr, R r2, Function2<? super R, ? super Byte, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (bArr.length == 0) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(bArr.length + 1);
        arrayList.add(r2);
        for (byte b3 : bArr) {
            r2 = (R) operation.invoke(r2, Byte.valueOf(b3));
            arrayList.add(r2);
        }
        return arrayList;
    }

    private static final <R> List<R> runningFoldIndexed(byte[] bArr, R r2, Function3<? super Integer, ? super R, ? super Byte, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (bArr.length == 0) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(bArr.length + 1);
        arrayList.add(r2);
        int length = bArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            r2 = (R) operation.invoke(Integer.valueOf(i3), r2, Byte.valueOf(bArr[i3]));
            arrayList.add(r2);
        }
        return arrayList;
    }

    private static final <R> List<R> scan(double[] dArr, R r2, Function2<? super R, ? super Double, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (dArr.length == 0) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(dArr.length + 1);
        arrayList.add(r2);
        for (double d3 : dArr) {
            r2 = (R) operation.invoke(r2, Double.valueOf(d3));
            arrayList.add(r2);
        }
        return arrayList;
    }

    private static final <R> List<R> scanIndexed(double[] dArr, R r2, Function3<? super Integer, ? super R, ? super Double, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (dArr.length == 0) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(dArr.length + 1);
        arrayList.add(r2);
        int length = dArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            r2 = (R) operation.invoke(Integer.valueOf(i3), r2, Double.valueOf(dArr[i3]));
            arrayList.add(r2);
        }
        return arrayList;
    }

    public static final void shuffle(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        shuffle(fArr, (Random) Random.f140182a);
    }

    public static final Float singleOrNull(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (fArr.length == 1) {
            return Float.valueOf(fArr[0]);
        }
        return null;
    }

    public static final List<Float> sorted(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Float[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(fArr);
        ArraysKt___ArraysJvmKt.sort((Object[]) typedArray);
        return ArraysKt___ArraysJvmKt.asList(typedArray);
    }

    public static final <R extends Comparable<? super R>> List<Float> sortedBy(float[] fArr, Function1<? super Float, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(fArr, (Comparator<? super Float>) new ComparisonsKt__ComparisonsKt$compareBy$2(selector));
    }

    public static final <R extends Comparable<? super R>> List<Float> sortedByDescending(float[] fArr, Function1<? super Float, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(fArr, (Comparator<? super Float>) new ComparisonsKt__ComparisonsKt$compareByDescending$1(selector));
    }

    public static final List<Float> sortedDescending(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
        Intrinsics.checkNotNullExpressionValue(fArrCopyOf, "copyOf(...)");
        ArraysKt___ArraysJvmKt.sort(fArrCopyOf);
        return reversed(fArrCopyOf);
    }

    public static final List<Float> sortedWith(float[] fArr, Comparator<? super Float> comparator) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Float[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(fArr);
        ArraysKt___ArraysJvmKt.sortWith(typedArray, comparator);
        return ArraysKt___ArraysJvmKt.asList(typedArray);
    }

    public static final double sum(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        double d3 = 0.0d;
        for (double d4 : dArr) {
            d3 += d4;
        }
        return d3;
    }

    public static final HashSet<Float> toHashSet(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return (HashSet) toCollection(fArr, new HashSet(MapsKt__MapsJVMKt.mapCapacity(fArr.length)));
    }

    public static List<Integer> toMutableList(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i3 : iArr) {
            arrayList.add(Integer.valueOf(i3));
        }
        return arrayList;
    }

    public static final Set<Float> toMutableSet(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return (Set) toCollection(fArr, new LinkedHashSet(MapsKt__MapsJVMKt.mapCapacity(fArr.length)));
    }

    public static final Iterable<IndexedValue<Float>> withIndex(final float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return new IndexingIterable(new Function0() { // from class: kotlin.collections.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ArrayIteratorsKt.e(fArr);
            }
        });
    }

    public static final boolean all(double[] dArr, Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (double d3 : dArr) {
            if (!((Boolean) predicate.invoke(Double.valueOf(d3))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean any(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        return !(dArr.length == 0);
    }

    public static Iterable<Integer> asIterable(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return iArr.length == 0 ? CollectionsKt__CollectionsKt.emptyList() : new ArraysKt___ArraysKt$asIterable$$inlined$Iterable$4(iArr);
    }

    public static final Sequence<Integer> asSequence(final int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return iArr.length == 0 ? SequencesKt.g() : new Sequence<Integer>() { // from class: kotlin.collections.ArraysKt___ArraysKt$asSequence$$inlined$Sequence$4
            @Override // kotlin.sequences.Sequence
            public Iterator<Integer> iterator() {
                return ArrayIteratorsKt.f(iArr);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, M extends Map<? super K, ? super Integer>> M associateByTo(int[] iArr, M destination, Function1<? super Integer, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (int i3 : iArr) {
            destination.put(keySelector.invoke(Integer.valueOf(i3)), Integer.valueOf(i3));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(int[] iArr, M destination, Function1<? super Integer, ? extends Pair<? extends K, ? extends V>> transform) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (int i3 : iArr) {
            Pair pair = (Pair) transform.invoke(Integer.valueOf(i3));
            destination.put(pair.e(), pair.f());
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <V, M extends Map<? super Integer, ? super V>> M associateWithTo(int[] iArr, M destination, Function1<? super Integer, ? extends V> valueSelector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        for (int i3 : iArr) {
            destination.put(Integer.valueOf(i3), valueSelector.invoke(Integer.valueOf(i3)));
        }
        return destination;
    }

    private static final double component1(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        return dArr[0];
    }

    private static final double component2(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        return dArr[1];
    }

    private static final double component3(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        return dArr[2];
    }

    private static final double component4(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        return dArr[3];
    }

    private static final double component5(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        return dArr[4];
    }

    public static boolean contains(char[] cArr, char c3) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return indexOf(cArr, c3) >= 0;
    }

    private static final int count(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        return dArr.length;
    }

    public static final List<Double> distinct(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        return CollectionsKt___CollectionsKt.toList(toMutableSet(dArr));
    }

    public static final <K> List<Byte> distinctBy(byte[] bArr, Function1<? super Byte, ? extends K> selector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (byte b3 : bArr) {
            if (hashSet.add(selector.invoke(Byte.valueOf(b3)))) {
                arrayList.add(Byte.valueOf(b3));
            }
        }
        return arrayList;
    }

    public static final List<Integer> drop(int[] iArr, int i3) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (i3 >= 0) {
            return takeLast(iArr, RangesKt.f(iArr.length - i3, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
    }

    public static final List<Integer> dropLast(int[] iArr, int i3) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (i3 >= 0) {
            return take(iArr, RangesKt.f(iArr.length - i3, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
    }

    private static final double elementAtOrElse(double[] dArr, int i3, Function1<? super Integer, Double> defaultValue) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return (i3 < 0 || i3 >= dArr.length) ? ((Number) defaultValue.invoke(Integer.valueOf(i3))).doubleValue() : dArr[i3];
    }

    private static final Double elementAtOrNull(double[] dArr, int i3) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        return getOrNull(dArr, i3);
    }

    public static final List<Integer> filter(int[] iArr, Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (int i3 : iArr) {
            if (((Boolean) predicate.invoke(Integer.valueOf(i3))).booleanValue()) {
                arrayList.add(Integer.valueOf(i3));
            }
        }
        return arrayList;
    }

    public static final List<Short> filterIndexed(short[] sArr, Function2<? super Integer, ? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = sArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            short s2 = sArr[i3];
            int i5 = i4 + 1;
            if (((Boolean) predicate.invoke(Integer.valueOf(i4), Short.valueOf(s2))).booleanValue()) {
                arrayList.add(Short.valueOf(s2));
            }
            i3++;
            i4 = i5;
        }
        return arrayList;
    }

    public static final <C extends Collection<? super Integer>> C filterIndexedTo(int[] iArr, C destination, Function2<? super Integer, ? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = iArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            int i5 = iArr[i3];
            int i6 = i4 + 1;
            if (((Boolean) predicate.invoke(Integer.valueOf(i4), Integer.valueOf(i5))).booleanValue()) {
                destination.add(Integer.valueOf(i5));
            }
            i3++;
            i4 = i6;
        }
        return destination;
    }

    public static final List<Integer> filterNot(int[] iArr, Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (int i3 : iArr) {
            if (!((Boolean) predicate.invoke(Integer.valueOf(i3))).booleanValue()) {
                arrayList.add(Integer.valueOf(i3));
            }
        }
        return arrayList;
    }

    public static final <C extends Collection<? super Double>> C filterNotTo(double[] dArr, C destination, Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (double d3 : dArr) {
            if (!((Boolean) predicate.invoke(Double.valueOf(d3))).booleanValue()) {
                destination.add(Double.valueOf(d3));
            }
        }
        return destination;
    }

    public static final <C extends Collection<? super Double>> C filterTo(double[] dArr, C destination, Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (double d3 : dArr) {
            if (((Boolean) predicate.invoke(Double.valueOf(d3))).booleanValue()) {
                destination.add(Double.valueOf(d3));
            }
        }
        return destination;
    }

    private static final Double find(double[] dArr, Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (double d3 : dArr) {
            if (((Boolean) predicate.invoke(Double.valueOf(d3))).booleanValue()) {
                return Double.valueOf(d3);
            }
        }
        return null;
    }

    private static final Short findLast(short[] sArr, Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = sArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i3 = length - 1;
            short s2 = sArr[length];
            if (((Boolean) predicate.invoke(Short.valueOf(s2))).booleanValue()) {
                return Short.valueOf(s2);
            }
            if (i3 < 0) {
                return null;
            }
            length = i3;
        }
    }

    public static short first(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        if (sArr.length != 0) {
            return sArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final Double firstOrNull(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (dArr.length == 0) {
            return null;
        }
        return Double.valueOf(dArr[0]);
    }

    private static final <R> List<R> flatMapIndexedIterable(double[] dArr, Function2<? super Integer, ? super Double, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = dArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, (Iterable) transform.invoke(Integer.valueOf(i4), Double.valueOf(dArr[i3])));
            i3++;
            i4++;
        }
        return arrayList;
    }

    private static final <R, C extends Collection<? super R>> C flatMapIndexedIterableTo(short[] sArr, C destination, Function2<? super Integer, ? super Short, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = sArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            CollectionsKt__MutableCollectionsKt.addAll(destination, (Iterable) transform.invoke(Integer.valueOf(i4), Short.valueOf(sArr[i3])));
            i3++;
            i4++;
        }
        return destination;
    }

    public static final <R, C extends Collection<? super R>> C flatMapTo(short[] sArr, C destination, Function1<? super Short, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (short s2 : sArr) {
            CollectionsKt__MutableCollectionsKt.addAll(destination, (Iterable) transform.invoke(Short.valueOf(s2)));
        }
        return destination;
    }

    public static final <R> R fold(double[] dArr, R r2, Function2<? super R, ? super Double, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (double d3 : dArr) {
            r2 = (R) operation.invoke(r2, Double.valueOf(d3));
        }
        return r2;
    }

    public static final <R> R foldIndexed(double[] dArr, R r2, Function3<? super Integer, ? super R, ? super Double, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int length = dArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            r2 = (R) operation.invoke(Integer.valueOf(i4), r2, Double.valueOf(dArr[i3]));
            i3++;
            i4++;
        }
        return r2;
    }

    public static final <R> R foldRight(int[] iArr, R r2, Function2<? super Integer, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = getLastIndex(iArr); lastIndex >= 0; lastIndex--) {
            r2 = (R) operation.invoke(Integer.valueOf(iArr[lastIndex]), r2);
        }
        return r2;
    }

    public static final <R> R foldRightIndexed(int[] iArr, R r2, Function3<? super Integer, ? super Integer, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = getLastIndex(iArr); lastIndex >= 0; lastIndex--) {
            r2 = (R) operation.invoke(Integer.valueOf(lastIndex), Integer.valueOf(iArr[lastIndex]), r2);
        }
        return r2;
    }

    public static final void forEach(double[] dArr, Function1<? super Double, Unit> action) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        for (double d3 : dArr) {
            action.invoke(Double.valueOf(d3));
        }
    }

    public static final void forEachIndexed(double[] dArr, Function2<? super Integer, ? super Double, Unit> action) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int length = dArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            action.invoke(Integer.valueOf(i4), Double.valueOf(dArr[i3]));
            i3++;
            i4++;
        }
    }

    public static final IntRange getIndices(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        return new IntRange(0, getLastIndex(dArr));
    }

    public static final int getLastIndex(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        return dArr.length - 1;
    }

    private static final double getOrElse(double[] dArr, int i3, Function1<? super Integer, Double> defaultValue) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return (i3 < 0 || i3 >= dArr.length) ? ((Number) defaultValue.invoke(Integer.valueOf(i3))).doubleValue() : dArr[i3];
    }

    public static final Double getOrNull(double[] dArr, int i3) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (i3 < 0 || i3 >= dArr.length) {
            return null;
        }
        return Double.valueOf(dArr[i3]);
    }

    public static int indexOf(short[] sArr, short s2) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        int length = sArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (s2 == sArr[i3]) {
                return i3;
            }
        }
        return -1;
    }

    public static final int indexOfFirst(int[] iArr, Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = iArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (((Boolean) predicate.invoke(Integer.valueOf(iArr[i3]))).booleanValue()) {
                return i3;
            }
        }
        return -1;
    }

    public static final int indexOfLast(int[] iArr, Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = iArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i3 = length - 1;
                if (((Boolean) predicate.invoke(Integer.valueOf(iArr[length]))).booleanValue()) {
                    return length;
                }
                if (i3 < 0) {
                    break;
                }
                length = i3;
            }
        }
        return -1;
    }

    public static final Set<Integer> intersect(int[] iArr, Iterable<Integer> other) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Integer> mutableSet = toMutableSet(iArr);
        CollectionsKt__MutableCollectionsKt.retainAll(mutableSet, other);
        return mutableSet;
    }

    private static final boolean isEmpty(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        return dArr.length == 0;
    }

    private static final boolean isNotEmpty(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        return !(dArr.length == 0);
    }

    public static final <A extends Appendable> A joinTo(byte[] bArr, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i3, CharSequence truncated, Function1<? super Byte, ? extends CharSequence> function1) throws IOException {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        buffer.append(prefix);
        int i4 = 0;
        for (byte b3 : bArr) {
            i4++;
            if (i4 > 1) {
                buffer.append(separator);
            }
            if (i3 >= 0 && i4 > i3) {
                break;
            }
            if (function1 != null) {
                buffer.append((CharSequence) function1.invoke(Byte.valueOf(b3)));
            } else {
                buffer.append(String.valueOf((int) b3));
            }
        }
        if (i3 >= 0 && i4 > i3) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final String joinToString(double[] dArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i3, CharSequence truncated, Function1<? super Double, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        return ((StringBuilder) joinTo(dArr, new StringBuilder(), separator, prefix, postfix, i3, truncated, function1)).toString();
    }

    public static /* synthetic */ String joinToString$default(double[] dArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i3, CharSequence charSequence4, Function1 function1, int i4, Object obj) {
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
        return joinToString(dArr, charSequence, charSequence2, charSequence3, i3, charSequence5, (Function1<? super Double, ? extends CharSequence>) function12);
    }

    public static short last(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        if (sArr.length != 0) {
            return sArr[getLastIndex(sArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static int lastIndexOf(short[] sArr, short s2) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        int length = sArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i3 = length - 1;
                if (s2 == sArr[length]) {
                    return length;
                }
                if (i3 < 0) {
                    break;
                }
                length = i3;
            }
        }
        return -1;
    }

    public static final Double lastOrNull(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (dArr.length == 0) {
            return null;
        }
        return Double.valueOf(dArr[dArr.length - 1]);
    }

    public static final <R> List<R> map(short[] sArr, Function1<? super Short, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(sArr.length);
        for (short s2 : sArr) {
            arrayList.add(transform.invoke(Short.valueOf(s2)));
        }
        return arrayList;
    }

    public static final <R> List<R> mapIndexed(short[] sArr, Function2<? super Integer, ? super Short, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(sArr.length);
        int length = sArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            arrayList.add(transform.invoke(Integer.valueOf(i4), Short.valueOf(sArr[i3])));
            i3++;
            i4++;
        }
        return arrayList;
    }

    public static final <R, C extends Collection<? super R>> C mapIndexedTo(int[] iArr, C destination, Function2<? super Integer, ? super Integer, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = iArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            destination.add(transform.invoke(Integer.valueOf(i4), Integer.valueOf(iArr[i3])));
            i3++;
            i4++;
        }
        return destination;
    }

    public static final <R, C extends Collection<? super R>> C mapTo(int[] iArr, C destination, Function1<? super Integer, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (int i3 : iArr) {
            destination.add(transform.invoke(Integer.valueOf(i3)));
        }
        return destination;
    }

    private static final double maxOf(byte[] bArr, Function1<? super Byte, Double> selector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (bArr.length != 0) {
            double dDoubleValue = ((Number) selector.invoke(Byte.valueOf(bArr[0]))).doubleValue();
            int lastIndex = getLastIndex(bArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    dDoubleValue = Math.max(dDoubleValue, ((Number) selector.invoke(Byte.valueOf(bArr[i3]))).doubleValue());
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return dDoubleValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final Double m1393maxOfOrNull(byte[] bArr, Function1<? super Byte, Double> selector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        double dDoubleValue = ((Number) selector.invoke(Byte.valueOf(bArr[0]))).doubleValue();
        int lastIndex = getLastIndex(bArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.max(dDoubleValue, ((Number) selector.invoke(Byte.valueOf(bArr[i3]))).doubleValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    private static final <R> R maxOfWith(byte[] bArr, Comparator<? super R> comparator, Function1<? super Byte, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (bArr.length != 0) {
            R r2 = (Object) selector.invoke(Byte.valueOf(bArr[0]));
            int lastIndex = getLastIndex(bArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Object obj = (Object) selector.invoke(Byte.valueOf(bArr[i3]));
                    if (comparator.compare(r2, obj) < 0) {
                        r2 = (R) obj;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return r2;
        }
        throw new NoSuchElementException();
    }

    public static final Float maxOrNull(Float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (fArr.length == 0) {
            return null;
        }
        float fFloatValue = fArr[0].floatValue();
        int lastIndex = getLastIndex(fArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.max(fFloatValue, fArr[i3].floatValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    public static final float maxOrThrow(Float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (fArr.length != 0) {
            float fFloatValue = fArr[0].floatValue();
            int lastIndex = getLastIndex(fArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = Math.max(fFloatValue, fArr[i3].floatValue());
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    public static final byte maxWithOrThrow(byte[] bArr, Comparator<? super Byte> comparator) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (bArr.length != 0) {
            byte b3 = bArr[0];
            int lastIndex = getLastIndex(bArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    byte b4 = bArr[i3];
                    if (comparator.compare(Byte.valueOf(b3), Byte.valueOf(b4)) < 0) {
                        b3 = b4;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return b3;
        }
        throw new NoSuchElementException();
    }

    private static final double minOf(byte[] bArr, Function1<? super Byte, Double> selector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (bArr.length != 0) {
            double dDoubleValue = ((Number) selector.invoke(Byte.valueOf(bArr[0]))).doubleValue();
            int lastIndex = getLastIndex(bArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    dDoubleValue = Math.min(dDoubleValue, ((Number) selector.invoke(Byte.valueOf(bArr[i3]))).doubleValue());
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return dDoubleValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOfOrNull, reason: collision with other method in class */
    private static final Double m1429minOfOrNull(byte[] bArr, Function1<? super Byte, Double> selector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        double dDoubleValue = ((Number) selector.invoke(Byte.valueOf(bArr[0]))).doubleValue();
        int lastIndex = getLastIndex(bArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.min(dDoubleValue, ((Number) selector.invoke(Byte.valueOf(bArr[i3]))).doubleValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    private static final <R> R minOfWith(byte[] bArr, Comparator<? super R> comparator, Function1<? super Byte, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (bArr.length != 0) {
            R r2 = (Object) selector.invoke(Byte.valueOf(bArr[0]));
            int lastIndex = getLastIndex(bArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Object obj = (Object) selector.invoke(Byte.valueOf(bArr[i3]));
                    if (comparator.compare(r2, obj) > 0) {
                        r2 = (R) obj;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return r2;
        }
        throw new NoSuchElementException();
    }

    public static final Float minOrNull(Float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (fArr.length == 0) {
            return null;
        }
        float fFloatValue = fArr[0].floatValue();
        int lastIndex = getLastIndex(fArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.min(fFloatValue, fArr[i3].floatValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    public static final float minOrThrow(Float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (fArr.length != 0) {
            float fFloatValue = fArr[0].floatValue();
            int lastIndex = getLastIndex(fArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = Math.min(fFloatValue, fArr[i3].floatValue());
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    public static final byte minWithOrThrow(byte[] bArr, Comparator<? super Byte> comparator) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (bArr.length != 0) {
            byte b3 = bArr[0];
            int lastIndex = getLastIndex(bArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    byte b4 = bArr[i3];
                    if (comparator.compare(Byte.valueOf(b3), Byte.valueOf(b4)) > 0) {
                        b3 = b4;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return b3;
        }
        throw new NoSuchElementException();
    }

    public static final boolean none(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        return dArr.length == 0;
    }

    private static final double[] onEach(double[] dArr, Function1<? super Double, Unit> action) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        for (double d3 : dArr) {
            action.invoke(Double.valueOf(d3));
        }
        return dArr;
    }

    private static final double[] onEachIndexed(double[] dArr, Function2<? super Integer, ? super Double, Unit> action) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int length = dArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            action.invoke(Integer.valueOf(i4), Double.valueOf(dArr[i3]));
            i3++;
            i4++;
        }
        return dArr;
    }

    private static final double random(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        return random(dArr, Random.f140182a);
    }

    private static final Double randomOrNull(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        return randomOrNull(dArr, Random.f140182a);
    }

    public static final List<Short> reversed(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        if (sArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<Short> mutableList = toMutableList(sArr);
        CollectionsKt___CollectionsJvmKt.reverse(mutableList);
        return mutableList;
    }

    private static final List<Byte> runningReduce(byte[] bArr, Function2<? super Byte, ? super Byte, Byte> operation) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (bArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        byte bByteValue = bArr[0];
        ArrayList arrayList = new ArrayList(bArr.length);
        arrayList.add(Byte.valueOf(bByteValue));
        int length = bArr.length;
        for (int i3 = 1; i3 < length; i3++) {
            bByteValue = ((Number) operation.invoke(Byte.valueOf(bByteValue), Byte.valueOf(bArr[i3]))).byteValue();
            arrayList.add(Byte.valueOf(bByteValue));
        }
        return arrayList;
    }

    private static final List<Byte> runningReduceIndexed(byte[] bArr, Function3<? super Integer, ? super Byte, ? super Byte, Byte> operation) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (bArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        byte bByteValue = bArr[0];
        ArrayList arrayList = new ArrayList(bArr.length);
        arrayList.add(Byte.valueOf(bByteValue));
        int length = bArr.length;
        for (int i3 = 1; i3 < length; i3++) {
            bByteValue = ((Number) operation.invoke(Integer.valueOf(i3), Byte.valueOf(bByteValue), Byte.valueOf(bArr[i3]))).byteValue();
            arrayList.add(Byte.valueOf(bByteValue));
        }
        return arrayList;
    }

    private static final <R> List<R> scan(boolean[] zArr, R r2, Function2<? super R, ? super Boolean, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (zArr.length == 0) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(zArr.length + 1);
        arrayList.add(r2);
        for (boolean z2 : zArr) {
            r2 = (R) operation.invoke(r2, Boolean.valueOf(z2));
            arrayList.add(r2);
        }
        return arrayList;
    }

    private static final <R> List<R> scanIndexed(boolean[] zArr, R r2, Function3<? super Integer, ? super R, ? super Boolean, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (zArr.length == 0) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(zArr.length + 1);
        arrayList.add(r2);
        int length = zArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            r2 = (R) operation.invoke(Integer.valueOf(i3), r2, Boolean.valueOf(zArr[i3]));
            arrayList.add(r2);
        }
        return arrayList;
    }

    public static final void shuffle(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        shuffle(dArr, Random.f140182a);
    }

    public static final Double singleOrNull(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (dArr.length == 1) {
            return Double.valueOf(dArr[0]);
        }
        return null;
    }

    public static final List<Integer> slice(int[] iArr, IntRange indices) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? CollectionsKt__CollectionsKt.emptyList() : ArraysKt___ArraysJvmKt.asList(ArraysKt___ArraysJvmKt.copyOfRange(iArr, indices.a().intValue(), indices.e().intValue() + 1));
    }

    public static short[] sliceArray(short[] sArr, Collection<Integer> indices) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        short[] sArr2 = new short[indices.size()];
        Iterator<Integer> it = indices.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            sArr2[i3] = sArr[it.next().intValue()];
            i3++;
        }
        return sArr2;
    }

    public static final List<Double> sorted(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Double[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(dArr);
        ArraysKt___ArraysJvmKt.sort((Object[]) typedArray);
        return ArraysKt___ArraysJvmKt.asList(typedArray);
    }

    public static final int[] sortedArray(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (iArr.length == 0) {
            return iArr;
        }
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
        ArraysKt___ArraysJvmKt.sort(iArrCopyOf);
        return iArrCopyOf;
    }

    public static final int[] sortedArrayDescending(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (iArr.length == 0) {
            return iArr;
        }
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
        sortDescending(iArrCopyOf);
        return iArrCopyOf;
    }

    public static final <R extends Comparable<? super R>> List<Double> sortedBy(double[] dArr, Function1<? super Double, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(dArr, new ComparisonsKt__ComparisonsKt$compareBy$2(selector));
    }

    public static final <R extends Comparable<? super R>> List<Double> sortedByDescending(double[] dArr, Function1<? super Double, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(dArr, new ComparisonsKt__ComparisonsKt$compareByDescending$1(selector));
    }

    public static final List<Double> sortedDescending(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        double[] dArrCopyOf = Arrays.copyOf(dArr, dArr.length);
        Intrinsics.checkNotNullExpressionValue(dArrCopyOf, "copyOf(...)");
        ArraysKt___ArraysJvmKt.sort(dArrCopyOf);
        return reversed(dArrCopyOf);
    }

    public static final List<Double> sortedWith(double[] dArr, Comparator<? super Double> comparator) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Double[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(dArr);
        ArraysKt___ArraysJvmKt.sortWith(typedArray, comparator);
        return ArraysKt___ArraysJvmKt.asList(typedArray);
    }

    public static final Set<Integer> subtract(int[] iArr, Iterable<Integer> other) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Integer> mutableSet = toMutableSet(iArr);
        CollectionsKt__MutableCollectionsKt.removeAll(mutableSet, other);
        return mutableSet;
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final int sumBy(int[] iArr, Function1<? super Integer, Integer> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iIntValue = 0;
        for (int i3 : iArr) {
            iIntValue += ((Number) selector.invoke(Integer.valueOf(i3))).intValue();
        }
        return iIntValue;
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final double sumByDouble(int[] iArr, Function1<? super Integer, Double> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        double dDoubleValue = 0.0d;
        for (int i3 : iArr) {
            dDoubleValue += ((Number) selector.invoke(Integer.valueOf(i3))).doubleValue();
        }
        return dDoubleValue;
    }

    private static final double sumOfDouble(int[] iArr, Function1<? super Integer, Double> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        double dDoubleValue = 0.0d;
        for (int i3 : iArr) {
            dDoubleValue += ((Number) selector.invoke(Integer.valueOf(i3))).doubleValue();
        }
        return dDoubleValue;
    }

    private static final int sumOfInt(int[] iArr, Function1<? super Integer, Integer> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iIntValue = 0;
        for (int i3 : iArr) {
            iIntValue += ((Number) selector.invoke(Integer.valueOf(i3))).intValue();
        }
        return iIntValue;
    }

    private static final long sumOfLong(int[] iArr, Function1<? super Integer, Long> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        long jLongValue = 0;
        for (int i3 : iArr) {
            jLongValue += ((Number) selector.invoke(Integer.valueOf(i3))).longValue();
        }
        return jLongValue;
    }

    private static final int sumOfUInt(short[] sArr, Function1<? super Short, UInt> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iB = UInt.b(0);
        for (short s2 : sArr) {
            iB = UInt.b(iB + ((UInt) selector.invoke(Short.valueOf(s2))).f());
        }
        return iB;
    }

    private static final long sumOfULong(short[] sArr, Function1<? super Short, ULong> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        long jB = ULong.b(0L);
        for (short s2 : sArr) {
            jB = ULong.b(jB + ((ULong) selector.invoke(Short.valueOf(s2))).g());
        }
        return jB;
    }

    public static final <C extends Collection<? super Integer>> C toCollection(int[] iArr, C destination) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        for (int i3 : iArr) {
            destination.add(Integer.valueOf(i3));
        }
        return destination;
    }

    public static final HashSet<Double> toHashSet(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        return (HashSet) toCollection(dArr, new HashSet(MapsKt__MapsJVMKt.mapCapacity(dArr.length)));
    }

    public static final Set<Double> toMutableSet(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        return (Set) toCollection(dArr, new LinkedHashSet(MapsKt__MapsJVMKt.mapCapacity(dArr.length)));
    }

    public static final Set<Integer> union(int[] iArr, Iterable<Integer> other) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Integer> mutableSet = toMutableSet(iArr);
        CollectionsKt__MutableCollectionsKt.addAll(mutableSet, other);
        return mutableSet;
    }

    public static final Iterable<IndexedValue<Double>> withIndex(final double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        return new IndexingIterable(new Function0() { // from class: kotlin.collections.k
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ArrayIteratorsKt.d(dArr);
            }
        });
    }

    public static final <R, V> List<V> zip(short[] sArr, R[] other, Function2<? super Short, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iMin = Math.min(sArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i3 = 0; i3 < iMin; i3++) {
            arrayList.add(transform.invoke(Short.valueOf(sArr[i3]), other[i3]));
        }
        return arrayList;
    }

    public static final boolean all(boolean[] zArr, Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (boolean z2 : zArr) {
            if (!((Boolean) predicate.invoke(Boolean.valueOf(z2))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean any(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return !(zArr.length == 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <V> Map<Integer, V> associateWith(int[] iArr, Function1<? super Integer, ? extends V> valueSelector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt__MapsJVMKt.mapCapacity(iArr.length), 16));
        for (int i3 : iArr) {
            linkedHashMap.put(Integer.valueOf(i3), valueSelector.invoke(Integer.valueOf(i3)));
        }
        return linkedHashMap;
    }

    private static final boolean component1(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return zArr[0];
    }

    private static final boolean component2(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return zArr[1];
    }

    private static final boolean component3(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return zArr[2];
    }

    private static final boolean component4(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return zArr[3];
    }

    private static final boolean component5(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return zArr[4];
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ boolean contains(float[] fArr, float f3) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        for (float f4 : fArr) {
            if (f4 == f3) {
                return true;
            }
        }
        return false;
    }

    private static final int count(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return zArr.length;
    }

    public static final List<Boolean> distinct(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return CollectionsKt___CollectionsKt.toList(toMutableSet(zArr));
    }

    private static final boolean elementAtOrElse(boolean[] zArr, int i3, Function1<? super Integer, Boolean> defaultValue) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return (i3 < 0 || i3 >= zArr.length) ? ((Boolean) defaultValue.invoke(Integer.valueOf(i3))).booleanValue() : zArr[i3];
    }

    private static final Boolean elementAtOrNull(boolean[] zArr, int i3) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return getOrNull(zArr, i3);
    }

    public static final <C extends Collection<? super Boolean>> C filterNotTo(boolean[] zArr, C destination, Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (boolean z2 : zArr) {
            if (!((Boolean) predicate.invoke(Boolean.valueOf(z2))).booleanValue()) {
                destination.add(Boolean.valueOf(z2));
            }
        }
        return destination;
    }

    public static final <C extends Collection<? super Boolean>> C filterTo(boolean[] zArr, C destination, Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (boolean z2 : zArr) {
            if (((Boolean) predicate.invoke(Boolean.valueOf(z2))).booleanValue()) {
                destination.add(Boolean.valueOf(z2));
            }
        }
        return destination;
    }

    private static final Boolean find(boolean[] zArr, Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (boolean z2 : zArr) {
            if (((Boolean) predicate.invoke(Boolean.valueOf(z2))).booleanValue()) {
                return Boolean.valueOf(z2);
            }
        }
        return null;
    }

    public static final Boolean firstOrNull(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        if (zArr.length == 0) {
            return null;
        }
        return Boolean.valueOf(zArr[0]);
    }

    private static final <R> List<R> flatMapIndexedIterable(boolean[] zArr, Function2<? super Integer, ? super Boolean, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = zArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, (Iterable) transform.invoke(Integer.valueOf(i4), Boolean.valueOf(zArr[i3])));
            i3++;
            i4++;
        }
        return arrayList;
    }

    public static final <R> R fold(boolean[] zArr, R r2, Function2<? super R, ? super Boolean, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (boolean z2 : zArr) {
            r2 = (R) operation.invoke(r2, Boolean.valueOf(z2));
        }
        return r2;
    }

    public static final <R> R foldIndexed(boolean[] zArr, R r2, Function3<? super Integer, ? super R, ? super Boolean, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int length = zArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            r2 = (R) operation.invoke(Integer.valueOf(i4), r2, Boolean.valueOf(zArr[i3]));
            i3++;
            i4++;
        }
        return r2;
    }

    public static final void forEach(boolean[] zArr, Function1<? super Boolean, Unit> action) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        for (boolean z2 : zArr) {
            action.invoke(Boolean.valueOf(z2));
        }
    }

    public static final void forEachIndexed(boolean[] zArr, Function2<? super Integer, ? super Boolean, Unit> action) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int length = zArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            action.invoke(Integer.valueOf(i4), Boolean.valueOf(zArr[i3]));
            i3++;
            i4++;
        }
    }

    public static final IntRange getIndices(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return new IntRange(0, getLastIndex(zArr));
    }

    public static final int getLastIndex(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return zArr.length - 1;
    }

    private static final boolean getOrElse(boolean[] zArr, int i3, Function1<? super Integer, Boolean> defaultValue) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return (i3 < 0 || i3 >= zArr.length) ? ((Boolean) defaultValue.invoke(Integer.valueOf(i3))).booleanValue() : zArr[i3];
    }

    public static final Boolean getOrNull(boolean[] zArr, int i3) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        if (i3 < 0 || i3 >= zArr.length) {
            return null;
        }
        return Boolean.valueOf(zArr[i3]);
    }

    public static final <K, M extends Map<? super K, List<Byte>>> M groupByTo(byte[] bArr, M destination, Function1<? super Byte, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (byte b3 : bArr) {
            Object objInvoke = keySelector.invoke(Byte.valueOf(b3));
            Object arrayList = destination.get(objInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(objInvoke, arrayList);
            }
            ((List) arrayList).add(Byte.valueOf(b3));
        }
        return destination;
    }

    private static final boolean isEmpty(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return zArr.length == 0;
    }

    private static final boolean isNotEmpty(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return !(zArr.length == 0);
    }

    public static final String joinToString(boolean[] zArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i3, CharSequence truncated, Function1<? super Boolean, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        return ((StringBuilder) joinTo(zArr, new StringBuilder(), separator, prefix, postfix, i3, truncated, function1)).toString();
    }

    public static /* synthetic */ String joinToString$default(boolean[] zArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i3, CharSequence charSequence4, Function1 function1, int i4, Object obj) {
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
        return joinToString(zArr, charSequence, charSequence2, charSequence3, i3, charSequence5, (Function1<? super Boolean, ? extends CharSequence>) function12);
    }

    public static final Boolean lastOrNull(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        if (zArr.length == 0) {
            return null;
        }
        return Boolean.valueOf(zArr[zArr.length - 1]);
    }

    public static final <R extends Comparable<? super R>> Byte maxByOrNull(byte[] bArr, Function1<? super Byte, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        byte b3 = bArr[0];
        int lastIndex = getLastIndex(bArr);
        if (lastIndex == 0) {
            return Byte.valueOf(b3);
        }
        Comparable comparable = (Comparable) selector.invoke(Byte.valueOf(b3));
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte b4 = bArr[i3];
                Comparable comparable2 = (Comparable) selector.invoke(Byte.valueOf(b4));
                if (comparable.compareTo(comparable2) < 0) {
                    b3 = b4;
                    comparable = comparable2;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Byte.valueOf(b3);
    }

    public static final <R extends Comparable<? super R>> Byte minByOrNull(byte[] bArr, Function1<? super Byte, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        byte b3 = bArr[0];
        int lastIndex = getLastIndex(bArr);
        if (lastIndex == 0) {
            return Byte.valueOf(b3);
        }
        Comparable comparable = (Comparable) selector.invoke(Byte.valueOf(b3));
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte b4 = bArr[i3];
                Comparable comparable2 = (Comparable) selector.invoke(Byte.valueOf(b4));
                if (comparable.compareTo(comparable2) > 0) {
                    b3 = b4;
                    comparable = comparable2;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Byte.valueOf(b3);
    }

    public static final boolean none(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return zArr.length == 0;
    }

    private static final boolean[] onEach(boolean[] zArr, Function1<? super Boolean, Unit> action) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        for (boolean z2 : zArr) {
            action.invoke(Boolean.valueOf(z2));
        }
        return zArr;
    }

    private static final boolean[] onEachIndexed(boolean[] zArr, Function2<? super Integer, ? super Boolean, Unit> action) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int length = zArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            action.invoke(Integer.valueOf(i4), Boolean.valueOf(zArr[i3]));
            i3++;
            i4++;
        }
        return zArr;
    }

    public static final Pair<List<Byte>, List<Byte>> partition(byte[] bArr, Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (byte b3 : bArr) {
            if (((Boolean) predicate.invoke(Byte.valueOf(b3))).booleanValue()) {
                arrayList.add(Byte.valueOf(b3));
            } else {
                arrayList2.add(Byte.valueOf(b3));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    private static final boolean random(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return random(zArr, Random.f140182a);
    }

    private static final Boolean randomOrNull(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return randomOrNull(zArr, Random.f140182a);
    }

    public static final Short reduceRightIndexedOrNull(short[] sArr, Function3<? super Integer, ? super Short, ? super Short, Short> operation) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(sArr);
        if (lastIndex < 0) {
            return null;
        }
        short sShortValue = sArr[lastIndex];
        for (int i3 = lastIndex - 1; i3 >= 0; i3--) {
            sShortValue = ((Number) operation.invoke(Integer.valueOf(i3), Short.valueOf(sArr[i3]), Short.valueOf(sShortValue))).shortValue();
        }
        return Short.valueOf(sShortValue);
    }

    public static final Short reduceRightOrNull(short[] sArr, Function2<? super Short, ? super Short, Short> operation) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(sArr);
        if (lastIndex < 0) {
            return null;
        }
        short sShortValue = sArr[lastIndex];
        for (int i3 = lastIndex - 1; i3 >= 0; i3--) {
            sShortValue = ((Number) operation.invoke(Short.valueOf(sArr[i3]), Short.valueOf(sShortValue))).shortValue();
        }
        return Short.valueOf(sShortValue);
    }

    private static final <R> List<R> scan(char[] cArr, R r2, Function2<? super R, ? super Character, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (cArr.length == 0) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(cArr.length + 1);
        arrayList.add(r2);
        for (char c3 : cArr) {
            r2 = (R) operation.invoke(r2, Character.valueOf(c3));
            arrayList.add(r2);
        }
        return arrayList;
    }

    private static final <R> List<R> scanIndexed(char[] cArr, R r2, Function3<? super Integer, ? super R, ? super Character, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (cArr.length == 0) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(cArr.length + 1);
        arrayList.add(r2);
        int length = cArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            r2 = (R) operation.invoke(Integer.valueOf(i3), r2, Character.valueOf(cArr[i3]));
            arrayList.add(r2);
        }
        return arrayList;
    }

    public static final void shuffle(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        shuffle(zArr, Random.f140182a);
    }

    public static final Boolean singleOrNull(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        if (zArr.length == 1) {
            return Boolean.valueOf(zArr[0]);
        }
        return null;
    }

    public static final void sortDescending(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (iArr.length > 1) {
            ArraysKt___ArraysJvmKt.sort(iArr);
            reverse(iArr);
        }
    }

    public static final List<Character> sorted(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Character[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(cArr);
        ArraysKt___ArraysJvmKt.sort((Object[]) typedArray);
        return ArraysKt___ArraysJvmKt.asList(typedArray);
    }

    public static final <R extends Comparable<? super R>> List<Boolean> sortedBy(boolean[] zArr, Function1<? super Boolean, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(zArr, new ComparisonsKt__ComparisonsKt$compareBy$2(selector));
    }

    public static final <R extends Comparable<? super R>> List<Boolean> sortedByDescending(boolean[] zArr, Function1<? super Boolean, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(zArr, new ComparisonsKt__ComparisonsKt$compareByDescending$1(selector));
    }

    public static final List<Character> sortedDescending(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        char[] cArrCopyOf = Arrays.copyOf(cArr, cArr.length);
        Intrinsics.checkNotNullExpressionValue(cArrCopyOf, "copyOf(...)");
        ArraysKt___ArraysJvmKt.sort(cArrCopyOf);
        return reversed(cArrCopyOf);
    }

    public static final List<Boolean> sortedWith(boolean[] zArr, Comparator<? super Boolean> comparator) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Boolean[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(zArr);
        ArraysKt___ArraysJvmKt.sortWith(typedArray, comparator);
        return ArraysKt___ArraysJvmKt.asList(typedArray);
    }

    public static final List<Byte> take(byte[] bArr, int i3) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (i3 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
        }
        if (i3 == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (i3 >= bArr.length) {
            return toList(bArr);
        }
        if (i3 == 1) {
            return CollectionsKt__CollectionsJVMKt.listOf(Byte.valueOf(bArr[0]));
        }
        ArrayList arrayList = new ArrayList(i3);
        int i4 = 0;
        for (byte b3 : bArr) {
            arrayList.add(Byte.valueOf(b3));
            i4++;
            if (i4 == i3) {
                break;
            }
        }
        return arrayList;
    }

    public static final List<Byte> takeLast(byte[] bArr, int i3) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (i3 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
        }
        if (i3 == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        int length = bArr.length;
        if (i3 >= length) {
            return toList(bArr);
        }
        if (i3 == 1) {
            return CollectionsKt__CollectionsJVMKt.listOf(Byte.valueOf(bArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i3);
        for (int i4 = length - i3; i4 < length; i4++) {
            arrayList.add(Byte.valueOf(bArr[i4]));
        }
        return arrayList;
    }

    public static final HashSet<Boolean> toHashSet(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return (HashSet) toCollection(zArr, new HashSet(MapsKt__MapsJVMKt.mapCapacity(zArr.length)));
    }

    public static final List<Long> toMutableList(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        ArrayList arrayList = new ArrayList(jArr.length);
        for (long j3 : jArr) {
            arrayList.add(Long.valueOf(j3));
        }
        return arrayList;
    }

    public static final Set<Boolean> toMutableSet(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return (Set) toCollection(zArr, new LinkedHashSet(MapsKt__MapsJVMKt.mapCapacity(zArr.length)));
    }

    public static final Iterable<IndexedValue<Boolean>> withIndex(final boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return new IndexingIterable(new Function0() { // from class: kotlin.collections.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ArrayIteratorsKt.a(zArr);
            }
        });
    }

    public static final boolean all(char[] cArr, Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (char c3 : cArr) {
            if (!((Boolean) predicate.invoke(Character.valueOf(c3))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean any(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return !(cArr.length == 0);
    }

    public static Iterable<Long> asIterable(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return jArr.length == 0 ? CollectionsKt__CollectionsKt.emptyList() : new ArraysKt___ArraysKt$asIterable$$inlined$Iterable$5(jArr);
    }

    public static final Sequence<Long> asSequence(final long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return jArr.length == 0 ? SequencesKt.g() : new Sequence<Long>() { // from class: kotlin.collections.ArraysKt___ArraysKt$asSequence$$inlined$Sequence$5
            @Override // kotlin.sequences.Sequence
            public Iterator<Long> iterator() {
                return ArrayIteratorsKt.g(jArr);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> associate(short[] sArr, Function1<? super Short, ? extends Pair<? extends K, ? extends V>> transform) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt__MapsJVMKt.mapCapacity(sArr.length), 16));
        for (short s2 : sArr) {
            Pair pair = (Pair) transform.invoke(Short.valueOf(s2));
            linkedHashMap.put(pair.e(), pair.f());
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K> Map<K, Short> associateBy(short[] sArr, Function1<? super Short, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt__MapsJVMKt.mapCapacity(sArr.length), 16));
        for (short s2 : sArr) {
            linkedHashMap.put(keySelector.invoke(Short.valueOf(s2)), Short.valueOf(s2));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, M extends Map<? super K, ? super Long>> M associateByTo(long[] jArr, M destination, Function1<? super Long, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (long j3 : jArr) {
            destination.put(keySelector.invoke(Long.valueOf(j3)), Long.valueOf(j3));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(long[] jArr, M destination, Function1<? super Long, ? extends Pair<? extends K, ? extends V>> transform) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (long j3 : jArr) {
            Pair pair = (Pair) transform.invoke(Long.valueOf(j3));
            destination.put(pair.e(), pair.f());
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <V, M extends Map<? super Long, ? super V>> M associateWithTo(long[] jArr, M destination, Function1<? super Long, ? extends V> valueSelector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        for (long j3 : jArr) {
            destination.put(Long.valueOf(j3), valueSelector.invoke(Long.valueOf(j3)));
        }
        return destination;
    }

    private static final char component1(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return cArr[0];
    }

    private static final char component2(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return cArr[1];
    }

    private static final char component3(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return cArr[2];
    }

    private static final char component4(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return cArr[3];
    }

    private static final char component5(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return cArr[4];
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ boolean contains(double[] dArr, double d3) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        for (double d4 : dArr) {
            if (d4 == d3) {
                return true;
            }
        }
        return false;
    }

    private static final short[] copyOf(short[] sArr, int i3, Function1<? super Integer, Short> init) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(init, "init");
        if (i3 >= 0) {
            short[] sArrCopyOf = Arrays.copyOf(sArr, i3);
            Intrinsics.checkNotNullExpressionValue(sArrCopyOf, "copyOf(...)");
            for (int length = sArr.length; length < i3; length++) {
                sArrCopyOf[length] = ((Number) init.invoke(Integer.valueOf(length))).shortValue();
            }
            return sArrCopyOf;
        }
        throw new IllegalArgumentException(("Invalid new array size: " + i3 + '.').toString());
    }

    private static final int count(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return cArr.length;
    }

    public static final List<Character> distinct(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return CollectionsKt___CollectionsKt.toList(toMutableSet(cArr));
    }

    public static final List<Long> drop(long[] jArr, int i3) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        if (i3 >= 0) {
            return takeLast(jArr, RangesKt.f(jArr.length - i3, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
    }

    public static final List<Long> dropLast(long[] jArr, int i3) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        if (i3 >= 0) {
            return take(jArr, RangesKt.f(jArr.length - i3, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
    }

    public static final List<Short> dropLastWhile(short[] sArr, Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = getLastIndex(sArr); -1 < lastIndex; lastIndex--) {
            if (!((Boolean) predicate.invoke(Short.valueOf(sArr[lastIndex]))).booleanValue()) {
                return take(sArr, lastIndex + 1);
            }
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    private static final char elementAtOrElse(char[] cArr, int i3, Function1<? super Integer, Character> defaultValue) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return (i3 < 0 || i3 >= cArr.length) ? ((Character) defaultValue.invoke(Integer.valueOf(i3))).charValue() : cArr[i3];
    }

    private static final Character elementAtOrNull(char[] cArr, int i3) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return getOrNull(cArr, i3);
    }

    public static final List<Long> filter(long[] jArr, Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (long j3 : jArr) {
            if (((Boolean) predicate.invoke(Long.valueOf(j3))).booleanValue()) {
                arrayList.add(Long.valueOf(j3));
            }
        }
        return arrayList;
    }

    public static final <C extends Collection<? super Long>> C filterIndexedTo(long[] jArr, C destination, Function2<? super Integer, ? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = jArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            long j3 = jArr[i3];
            int i5 = i4 + 1;
            if (((Boolean) predicate.invoke(Integer.valueOf(i4), Long.valueOf(j3))).booleanValue()) {
                destination.add(Long.valueOf(j3));
            }
            i3++;
            i4 = i5;
        }
        return destination;
    }

    public static final List<Long> filterNot(long[] jArr, Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (long j3 : jArr) {
            if (!((Boolean) predicate.invoke(Long.valueOf(j3))).booleanValue()) {
                arrayList.add(Long.valueOf(j3));
            }
        }
        return arrayList;
    }

    public static final <C extends Collection<? super Character>> C filterNotTo(char[] cArr, C destination, Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (char c3 : cArr) {
            if (!((Boolean) predicate.invoke(Character.valueOf(c3))).booleanValue()) {
                destination.add(Character.valueOf(c3));
            }
        }
        return destination;
    }

    public static final <C extends Collection<? super Character>> C filterTo(char[] cArr, C destination, Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (char c3 : cArr) {
            if (((Boolean) predicate.invoke(Character.valueOf(c3))).booleanValue()) {
                destination.add(Character.valueOf(c3));
            }
        }
        return destination;
    }

    private static final Character find(char[] cArr, Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (char c3 : cArr) {
            if (((Boolean) predicate.invoke(Character.valueOf(c3))).booleanValue()) {
                return Character.valueOf(c3);
            }
        }
        return null;
    }

    public static final Character firstOrNull(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (cArr.length == 0) {
            return null;
        }
        return Character.valueOf(cArr[0]);
    }

    public static final <R> List<R> flatMap(short[] sArr, Function1<? super Short, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (short s2 : sArr) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, (Iterable) transform.invoke(Short.valueOf(s2)));
        }
        return arrayList;
    }

    private static final <R> List<R> flatMapIndexedIterable(char[] cArr, Function2<? super Integer, ? super Character, ? extends Iterable<? extends R>> function2) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(function2, jTYhJgqLBN.gkshb);
        ArrayList arrayList = new ArrayList();
        int length = cArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, (Iterable) function2.invoke(Integer.valueOf(i4), Character.valueOf(cArr[i3])));
            i3++;
            i4++;
        }
        return arrayList;
    }

    public static final <R> R fold(char[] cArr, R r2, Function2<? super R, ? super Character, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (char c3 : cArr) {
            r2 = (R) operation.invoke(r2, Character.valueOf(c3));
        }
        return r2;
    }

    public static final <R> R foldIndexed(char[] cArr, R r2, Function3<? super Integer, ? super R, ? super Character, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int length = cArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            r2 = (R) operation.invoke(Integer.valueOf(i4), r2, Character.valueOf(cArr[i3]));
            i3++;
            i4++;
        }
        return r2;
    }

    public static final <R> R foldRight(long[] jArr, R r2, Function2<? super Long, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = getLastIndex(jArr); lastIndex >= 0; lastIndex--) {
            r2 = (R) operation.invoke(Long.valueOf(jArr[lastIndex]), r2);
        }
        return r2;
    }

    public static final <R> R foldRightIndexed(long[] jArr, R r2, Function3<? super Integer, ? super Long, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = getLastIndex(jArr); lastIndex >= 0; lastIndex--) {
            r2 = (R) operation.invoke(Integer.valueOf(lastIndex), Long.valueOf(jArr[lastIndex]), r2);
        }
        return r2;
    }

    public static final void forEach(char[] cArr, Function1<? super Character, Unit> action) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        for (char c3 : cArr) {
            action.invoke(Character.valueOf(c3));
        }
    }

    public static final void forEachIndexed(char[] cArr, Function2<? super Integer, ? super Character, Unit> action) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int length = cArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            action.invoke(Integer.valueOf(i4), Character.valueOf(cArr[i3]));
            i3++;
            i4++;
        }
    }

    public static final IntRange getIndices(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return new IntRange(0, getLastIndex(cArr));
    }

    public static final int getLastIndex(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return cArr.length - 1;
    }

    private static final char getOrElse(char[] cArr, int i3, Function1<? super Integer, Character> defaultValue) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return (i3 < 0 || i3 >= cArr.length) ? ((Character) defaultValue.invoke(Integer.valueOf(i3))).charValue() : cArr[i3];
    }

    public static final Character getOrNull(char[] cArr, int i3) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (i3 < 0 || i3 >= cArr.length) {
            return null;
        }
        return Character.valueOf(cArr[i3]);
    }

    public static final <K> Map<K, List<Byte>> groupBy(byte[] bArr, Function1<? super Byte, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (byte b3 : bArr) {
            Object objInvoke = keySelector.invoke(Byte.valueOf(b3));
            Object arrayList = linkedHashMap.get(objInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(objInvoke, arrayList);
            }
            ((List) arrayList).add(Byte.valueOf(b3));
        }
        return linkedHashMap;
    }

    public static int indexOf(int[] iArr, int i3) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int length = iArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            if (i3 == iArr[i4]) {
                return i4;
            }
        }
        return -1;
    }

    public static final int indexOfFirst(long[] jArr, Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = jArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (((Boolean) predicate.invoke(Long.valueOf(jArr[i3]))).booleanValue()) {
                return i3;
            }
        }
        return -1;
    }

    public static final int indexOfLast(long[] jArr, Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = jArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i3 = length - 1;
                if (((Boolean) predicate.invoke(Long.valueOf(jArr[length]))).booleanValue()) {
                    return length;
                }
                if (i3 < 0) {
                    break;
                }
                length = i3;
            }
        }
        return -1;
    }

    public static final Set<Long> intersect(long[] jArr, Iterable<Long> other) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Long> mutableSet = toMutableSet(jArr);
        CollectionsKt__MutableCollectionsKt.retainAll(mutableSet, other);
        return mutableSet;
    }

    private static final boolean isEmpty(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return cArr.length == 0;
    }

    private static final boolean isNotEmpty(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return !(cArr.length == 0);
    }

    public static final String joinToString(char[] cArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i3, CharSequence truncated, Function1<? super Character, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        return ((StringBuilder) joinTo(cArr, new StringBuilder(), separator, prefix, postfix, i3, truncated, function1)).toString();
    }

    public static /* synthetic */ String joinToString$default(char[] cArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i3, CharSequence charSequence4, Function1 function1, int i4, Object obj) {
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
        return joinToString(cArr, charSequence, charSequence2, charSequence3, i3, charSequence5, (Function1<? super Character, ? extends CharSequence>) function12);
    }

    public static int lastIndexOf(int[] iArr, int i3) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int length = iArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i4 = length - 1;
                if (i3 == iArr[length]) {
                    return length;
                }
                if (i4 < 0) {
                    break;
                }
                length = i4;
            }
        }
        return -1;
    }

    public static final Character lastOrNull(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (cArr.length == 0) {
            return null;
        }
        return Character.valueOf(cArr[cArr.length - 1]);
    }

    public static final <R, C extends Collection<? super R>> C mapIndexedTo(long[] jArr, C destination, Function2<? super Integer, ? super Long, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = jArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            destination.add(transform.invoke(Integer.valueOf(i4), Long.valueOf(jArr[i3])));
            i3++;
            i4++;
        }
        return destination;
    }

    public static final <R, C extends Collection<? super R>> C mapTo(long[] jArr, C destination, Function1<? super Long, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (long j3 : jArr) {
            destination.add(transform.invoke(Long.valueOf(j3)));
        }
        return destination;
    }

    public static final <R extends Comparable<? super R>> byte maxByOrThrow(byte[] bArr, Function1<? super Byte, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (bArr.length != 0) {
            byte b3 = bArr[0];
            int lastIndex = getLastIndex(bArr);
            if (lastIndex != 0) {
                Comparable comparable = (Comparable) selector.invoke(Byte.valueOf(b3));
                int i3 = 1;
                if (1 <= lastIndex) {
                    while (true) {
                        byte b4 = bArr[i3];
                        Comparable comparable2 = (Comparable) selector.invoke(Byte.valueOf(b4));
                        if (comparable.compareTo(comparable2) < 0) {
                            b3 = b4;
                            comparable = comparable2;
                        }
                        if (i3 == lastIndex) {
                            break;
                        }
                        i3++;
                    }
                }
            }
            return b3;
        }
        throw new NoSuchElementException();
    }

    public static final <R extends Comparable<? super R>> byte minByOrThrow(byte[] bArr, Function1<? super Byte, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (bArr.length != 0) {
            byte b3 = bArr[0];
            int lastIndex = getLastIndex(bArr);
            if (lastIndex != 0) {
                Comparable comparable = (Comparable) selector.invoke(Byte.valueOf(b3));
                int i3 = 1;
                if (1 <= lastIndex) {
                    while (true) {
                        byte b4 = bArr[i3];
                        Comparable comparable2 = (Comparable) selector.invoke(Byte.valueOf(b4));
                        if (comparable.compareTo(comparable2) > 0) {
                            b3 = b4;
                            comparable = comparable2;
                        }
                        if (i3 == lastIndex) {
                            break;
                        }
                        i3++;
                    }
                }
            }
            return b3;
        }
        throw new NoSuchElementException();
    }

    public static final boolean none(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return cArr.length == 0;
    }

    private static final char[] onEach(char[] cArr, Function1<? super Character, Unit> action) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        for (char c3 : cArr) {
            action.invoke(Character.valueOf(c3));
        }
        return cArr;
    }

    private static final char[] onEachIndexed(char[] cArr, Function2<? super Integer, ? super Character, Unit> action) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int length = cArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            action.invoke(Integer.valueOf(i4), Character.valueOf(cArr[i3]));
            i3++;
            i4++;
        }
        return cArr;
    }

    private static final char random(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return random(cArr, (Random) Random.f140182a);
    }

    private static final Character randomOrNull(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return randomOrNull(cArr, (Random) Random.f140182a);
    }

    public static final short reduceRight(short[] sArr, Function2<? super Short, ? super Short, Short> operation) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(sArr);
        if (lastIndex >= 0) {
            short sShortValue = sArr[lastIndex];
            for (int i3 = lastIndex - 1; i3 >= 0; i3--) {
                sShortValue = ((Number) operation.invoke(Short.valueOf(sArr[i3]), Short.valueOf(sShortValue))).shortValue();
            }
            return sShortValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final short reduceRightIndexed(short[] sArr, Function3<? super Integer, ? super Short, ? super Short, Short> operation) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(sArr);
        if (lastIndex >= 0) {
            short sShortValue = sArr[lastIndex];
            for (int i3 = lastIndex - 1; i3 >= 0; i3--) {
                sShortValue = ((Number) operation.invoke(Integer.valueOf(i3), Short.valueOf(sArr[i3]), Short.valueOf(sShortValue))).shortValue();
            }
            return sShortValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static short[] reversedArray(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        if (sArr.length == 0) {
            return sArr;
        }
        short[] sArr2 = new short[sArr.length];
        int lastIndex = getLastIndex(sArr);
        if (lastIndex >= 0) {
            int i3 = 0;
            while (true) {
                sArr2[lastIndex - i3] = sArr[i3];
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return sArr2;
    }

    public static final <T, R> List<R> scan(T[] tArr, R r2, Function2<? super R, ? super T, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (tArr.length == 0) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(tArr.length + 1);
        arrayList.add(r2);
        for (T t2 : tArr) {
            r2 = (R) operation.invoke(r2, t2);
            arrayList.add(r2);
        }
        return arrayList;
    }

    public static final <T, R> List<R> scanIndexed(T[] tArr, R r2, Function3<? super Integer, ? super R, ? super T, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (tArr.length == 0) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(tArr.length + 1);
        arrayList.add(r2);
        int length = tArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            r2 = (R) operation.invoke(Integer.valueOf(i3), r2, tArr[i3]);
            arrayList.add(r2);
        }
        return arrayList;
    }

    public static final void shuffle(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        shuffle(cArr, (Random) Random.f140182a);
    }

    public static short single(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        int length = sArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return sArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static final Character singleOrNull(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (cArr.length == 1) {
            return Character.valueOf(cArr[0]);
        }
        return null;
    }

    public static final List<Long> slice(long[] jArr, IntRange indices) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? CollectionsKt__CollectionsKt.emptyList() : ArraysKt___ArraysJvmKt.asList(ArraysKt___ArraysJvmKt.copyOfRange(jArr, indices.a().intValue(), indices.e().intValue() + 1));
    }

    public static final long[] sortedArray(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        if (jArr.length == 0) {
            return jArr;
        }
        long[] jArrCopyOf = Arrays.copyOf(jArr, jArr.length);
        Intrinsics.checkNotNullExpressionValue(jArrCopyOf, "copyOf(...)");
        ArraysKt___ArraysJvmKt.sort(jArrCopyOf);
        return jArrCopyOf;
    }

    public static final long[] sortedArrayDescending(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        if (jArr.length == 0) {
            return jArr;
        }
        long[] jArrCopyOf = Arrays.copyOf(jArr, jArr.length);
        Intrinsics.checkNotNullExpressionValue(jArrCopyOf, "copyOf(...)");
        sortDescending(jArrCopyOf);
        return jArrCopyOf;
    }

    public static final <R extends Comparable<? super R>> List<Character> sortedBy(char[] cArr, Function1<? super Character, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(cArr, (Comparator<? super Character>) new ComparisonsKt__ComparisonsKt$compareBy$2(selector));
    }

    public static final <R extends Comparable<? super R>> List<Character> sortedByDescending(char[] cArr, Function1<? super Character, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(cArr, (Comparator<? super Character>) new ComparisonsKt__ComparisonsKt$compareByDescending$1(selector));
    }

    public static final List<Character> sortedWith(char[] cArr, Comparator<? super Character> comparator) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Character[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(cArr);
        ArraysKt___ArraysJvmKt.sortWith(typedArray, comparator);
        return ArraysKt___ArraysJvmKt.asList(typedArray);
    }

    public static final Set<Long> subtract(long[] jArr, Iterable<Long> other) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Long> mutableSet = toMutableSet(jArr);
        CollectionsKt__MutableCollectionsKt.removeAll(mutableSet, other);
        return mutableSet;
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final int sumBy(long[] jArr, Function1<? super Long, Integer> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iIntValue = 0;
        for (long j3 : jArr) {
            iIntValue += ((Number) selector.invoke(Long.valueOf(j3))).intValue();
        }
        return iIntValue;
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final double sumByDouble(long[] jArr, Function1<? super Long, Double> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        double dDoubleValue = 0.0d;
        for (long j3 : jArr) {
            dDoubleValue += ((Number) selector.invoke(Long.valueOf(j3))).doubleValue();
        }
        return dDoubleValue;
    }

    private static final double sumOfDouble(long[] jArr, Function1<? super Long, Double> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        double dDoubleValue = 0.0d;
        for (long j3 : jArr) {
            dDoubleValue += ((Number) selector.invoke(Long.valueOf(j3))).doubleValue();
        }
        return dDoubleValue;
    }

    private static final int sumOfInt(long[] jArr, Function1<? super Long, Integer> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iIntValue = 0;
        for (long j3 : jArr) {
            iIntValue += ((Number) selector.invoke(Long.valueOf(j3))).intValue();
        }
        return iIntValue;
    }

    private static final long sumOfLong(long[] jArr, Function1<? super Long, Long> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        long jLongValue = 0;
        for (long j3 : jArr) {
            jLongValue += ((Number) selector.invoke(Long.valueOf(j3))).longValue();
        }
        return jLongValue;
    }

    public static final List<Short> takeLastWhile(short[] sArr, Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = getLastIndex(sArr); -1 < lastIndex; lastIndex--) {
            if (!((Boolean) predicate.invoke(Short.valueOf(sArr[lastIndex]))).booleanValue()) {
                return drop(sArr, lastIndex + 1);
            }
        }
        return toList(sArr);
    }

    public static final List<Short> takeWhile(short[] sArr, Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (short s2 : sArr) {
            if (!((Boolean) predicate.invoke(Short.valueOf(s2))).booleanValue()) {
                break;
            }
            arrayList.add(Short.valueOf(s2));
        }
        return arrayList;
    }

    public static final <C extends Collection<? super Long>> C toCollection(long[] jArr, C destination) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        for (long j3 : jArr) {
            destination.add(Long.valueOf(j3));
        }
        return destination;
    }

    public static final HashSet<Character> toHashSet(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return (HashSet) toCollection(cArr, new HashSet(MapsKt__MapsJVMKt.mapCapacity(RangesKt.k(cArr.length, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD))));
    }

    public static List<Short> toList(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        int length = sArr.length;
        if (length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (length != 1) {
            return toMutableList(sArr);
        }
        return CollectionsKt__CollectionsJVMKt.listOf(Short.valueOf(sArr[0]));
    }

    public static final Set<Character> toMutableSet(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return (Set) toCollection(cArr, new LinkedHashSet(MapsKt__MapsJVMKt.mapCapacity(RangesKt.k(cArr.length, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD))));
    }

    public static final Set<Short> toSet(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        int length = sArr.length;
        if (length == 0) {
            return SetsKt__SetsKt.emptySet();
        }
        if (length != 1) {
            return (Set) toCollection(sArr, new LinkedHashSet(MapsKt__MapsJVMKt.mapCapacity(sArr.length)));
        }
        return SetsKt__SetsJVMKt.setOf(Short.valueOf(sArr[0]));
    }

    public static final Set<Long> union(long[] jArr, Iterable<Long> other) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Long> mutableSet = toMutableSet(jArr);
        CollectionsKt__MutableCollectionsKt.addAll(mutableSet, other);
        return mutableSet;
    }

    public static final Iterable<IndexedValue<Character>> withIndex(final char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return new IndexingIterable(new Function0() { // from class: kotlin.collections.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ArrayIteratorsKt.c(cArr);
            }
        });
    }

    public static final <T> boolean any(T[] tArr, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (T t2 : tArr) {
            if (((Boolean) predicate.invoke(t2)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <V> Map<Long, V> associateWith(long[] jArr, Function1<? super Long, ? extends V> valueSelector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt__MapsJVMKt.mapCapacity(jArr.length), 16));
        for (long j3 : jArr) {
            linkedHashMap.put(Long.valueOf(j3), valueSelector.invoke(Long.valueOf(j3)));
        }
        return linkedHashMap;
    }

    public static final <T> int count(T[] tArr, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i3 = 0;
        for (T t2 : tArr) {
            if (((Boolean) predicate.invoke(t2)).booleanValue()) {
                i3++;
            }
        }
        return i3;
    }

    public static final List<Integer> filterIndexed(int[] iArr, Function2<? super Integer, ? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = iArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            int i5 = iArr[i3];
            int i6 = i4 + 1;
            if (((Boolean) predicate.invoke(Integer.valueOf(i4), Integer.valueOf(i5))).booleanValue()) {
                arrayList.add(Integer.valueOf(i5));
            }
            i3++;
            i4 = i6;
        }
        return arrayList;
    }

    private static final Integer findLast(int[] iArr, Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = iArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i3 = length - 1;
            int i4 = iArr[length];
            if (((Boolean) predicate.invoke(Integer.valueOf(i4))).booleanValue()) {
                return Integer.valueOf(i4);
            }
            if (i3 < 0) {
                return null;
            }
            length = i3;
        }
    }

    public static int first(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (iArr.length != 0) {
            return iArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final <T> T firstOrNull(T[] tArr, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (T t2 : tArr) {
            if (((Boolean) predicate.invoke(t2)).booleanValue()) {
                return t2;
            }
        }
        return null;
    }

    private static final <R, C extends Collection<? super R>> C flatMapIndexedIterableTo(int[] iArr, C destination, Function2<? super Integer, ? super Integer, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = iArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            CollectionsKt__MutableCollectionsKt.addAll(destination, (Iterable) transform.invoke(Integer.valueOf(i4), Integer.valueOf(iArr[i3])));
            i3++;
            i4++;
        }
        return destination;
    }

    public static final <R, C extends Collection<? super R>> C flatMapTo(int[] iArr, C destination, Function1<? super Integer, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (int i3 : iArr) {
            CollectionsKt__MutableCollectionsKt.addAll(destination, (Iterable) transform.invoke(Integer.valueOf(i3)));
        }
        return destination;
    }

    public static int last(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (iArr.length != 0) {
            return iArr[getLastIndex(iArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final <T> T lastOrNull(T[] tArr, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = tArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i3 = length - 1;
            T t2 = tArr[length];
            if (((Boolean) predicate.invoke(t2)).booleanValue()) {
                return t2;
            }
            if (i3 < 0) {
                return null;
            }
            length = i3;
        }
    }

    public static final <R> List<R> map(int[] iArr, Function1<? super Integer, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i3 : iArr) {
            arrayList.add(transform.invoke(Integer.valueOf(i3)));
        }
        return arrayList;
    }

    public static final <R> List<R> mapIndexed(int[] iArr, Function2<? super Integer, ? super Integer, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(iArr.length);
        int length = iArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            arrayList.add(transform.invoke(Integer.valueOf(i4), Integer.valueOf(iArr[i3])));
            i3++;
            i4++;
        }
        return arrayList;
    }

    public static final <T> boolean none(T[] tArr, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (T t2 : tArr) {
            if (((Boolean) predicate.invoke(t2)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <T> T random(T[] tArr, Random random) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (tArr.length != 0) {
            return tArr[random.j(tArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final <T> T randomOrNull(T[] tArr, Random random) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (tArr.length == 0) {
            return null;
        }
        return tArr[random.j(tArr.length)];
    }

    public static final Short reduceIndexedOrNull(short[] sArr, Function3<? super Integer, ? super Short, ? super Short, Short> operation) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (sArr.length == 0) {
            return null;
        }
        short sShortValue = sArr[0];
        int lastIndex = getLastIndex(sArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                sShortValue = ((Number) operation.invoke(Integer.valueOf(i3), Short.valueOf(sShortValue), Short.valueOf(sArr[i3]))).shortValue();
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Short.valueOf(sShortValue);
    }

    public static final Short reduceOrNull(short[] sArr, Function2<? super Short, ? super Short, Short> operation) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (sArr.length == 0) {
            return null;
        }
        short sShortValue = sArr[0];
        int lastIndex = getLastIndex(sArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                sShortValue = ((Number) operation.invoke(Short.valueOf(sShortValue), Short.valueOf(sArr[i3]))).shortValue();
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Short.valueOf(sShortValue);
    }

    public static final List<Integer> reversed(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (iArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<Integer> mutableList = toMutableList(iArr);
        CollectionsKt___CollectionsJvmKt.reverse(mutableList);
        return mutableList;
    }

    public static final <T> void shuffle(T[] tArr, Random random) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = getLastIndex(tArr); lastIndex > 0; lastIndex--) {
            int iJ = random.j(lastIndex + 1);
            T t2 = tArr[lastIndex];
            tArr[lastIndex] = tArr[iJ];
            tArr[iJ] = t2;
        }
    }

    public static final <T> T singleOrNull(T[] tArr, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        T t2 = null;
        boolean z2 = false;
        for (T t3 : tArr) {
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

    public static int[] sliceArray(int[] iArr, Collection<Integer> indices) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        int[] iArr2 = new int[indices.size()];
        Iterator<Integer> it = indices.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            iArr2[i3] = iArr[it.next().intValue()];
            i3++;
        }
        return iArr2;
    }

    private static final int sumOfUInt(int[] iArr, Function1<? super Integer, UInt> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iB = UInt.b(0);
        for (int i3 : iArr) {
            iB = UInt.b(iB + ((UInt) selector.invoke(Integer.valueOf(i3))).f());
        }
        return iB;
    }

    private static final long sumOfULong(int[] iArr, Function1<? super Integer, ULong> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        long jB = ULong.b(0L);
        for (int i3 : iArr) {
            jB = ULong.b(jB + ((ULong) selector.invoke(Integer.valueOf(i3))).g());
        }
        return jB;
    }

    public static final List<Float> toMutableList(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float f3 : fArr) {
            arrayList.add(Float.valueOf(f3));
        }
        return arrayList;
    }

    public static final <R, V> List<V> zip(int[] iArr, R[] other, Function2<? super Integer, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iMin = Math.min(iArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i3 = 0; i3 < iMin; i3++) {
            arrayList.add(transform.invoke(Integer.valueOf(iArr[i3]), other[i3]));
        }
        return arrayList;
    }

    public static final boolean any(byte[] bArr, Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (byte b3 : bArr) {
            if (((Boolean) predicate.invoke(Byte.valueOf(b3))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public static Iterable<Float> asIterable(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return fArr.length == 0 ? CollectionsKt__CollectionsKt.emptyList() : new ArraysKt___ArraysKt$asIterable$$inlined$Iterable$6(fArr);
    }

    public static final Sequence<Float> asSequence(final float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return fArr.length == 0 ? SequencesKt.g() : new Sequence<Float>() { // from class: kotlin.collections.ArraysKt___ArraysKt$asSequence$$inlined$Sequence$6
            @Override // kotlin.sequences.Sequence
            public Iterator<Float> iterator() {
                return ArrayIteratorsKt.e(fArr);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, M extends Map<? super K, ? super Float>> M associateByTo(float[] fArr, M destination, Function1<? super Float, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (float f3 : fArr) {
            destination.put(keySelector.invoke(Float.valueOf(f3)), Float.valueOf(f3));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(float[] fArr, M destination, Function1<? super Float, ? extends Pair<? extends K, ? extends V>> transform) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (float f3 : fArr) {
            Pair pair = (Pair) transform.invoke(Float.valueOf(f3));
            destination.put(pair.e(), pair.f());
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <V, M extends Map<? super Float, ? super V>> M associateWithTo(float[] fArr, M destination, Function1<? super Float, ? extends V> valueSelector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        for (float f3 : fArr) {
            destination.put(Float.valueOf(f3), valueSelector.invoke(Float.valueOf(f3)));
        }
        return destination;
    }

    public static final int count(byte[] bArr, Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i3 = 0;
        for (byte b3 : bArr) {
            if (((Boolean) predicate.invoke(Byte.valueOf(b3))).booleanValue()) {
                i3++;
            }
        }
        return i3;
    }

    public static final List<Float> drop(float[] fArr, int i3) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (i3 >= 0) {
            return takeLast(fArr, RangesKt.f(fArr.length - i3, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
    }

    public static final List<Float> dropLast(float[] fArr, int i3) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (i3 >= 0) {
            return take(fArr, RangesKt.f(fArr.length - i3, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
    }

    public static final List<Short> dropWhile(short[] sArr, Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z2 = false;
        for (short s2 : sArr) {
            if (z2) {
                arrayList.add(Short.valueOf(s2));
            } else if (!((Boolean) predicate.invoke(Short.valueOf(s2))).booleanValue()) {
                arrayList.add(Short.valueOf(s2));
                z2 = true;
            }
        }
        return arrayList;
    }

    public static final List<Float> filter(float[] fArr, Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (float f3 : fArr) {
            if (((Boolean) predicate.invoke(Float.valueOf(f3))).booleanValue()) {
                arrayList.add(Float.valueOf(f3));
            }
        }
        return arrayList;
    }

    public static final <C extends Collection<? super Float>> C filterIndexedTo(float[] fArr, C destination, Function2<? super Integer, ? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = fArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            float f3 = fArr[i3];
            int i5 = i4 + 1;
            if (((Boolean) predicate.invoke(Integer.valueOf(i4), Float.valueOf(f3))).booleanValue()) {
                destination.add(Float.valueOf(f3));
            }
            i3++;
            i4 = i5;
        }
        return destination;
    }

    public static final List<Float> filterNot(float[] fArr, Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (float f3 : fArr) {
            if (!((Boolean) predicate.invoke(Float.valueOf(f3))).booleanValue()) {
                arrayList.add(Float.valueOf(f3));
            }
        }
        return arrayList;
    }

    public static final Byte firstOrNull(byte[] bArr, Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (byte b3 : bArr) {
            if (((Boolean) predicate.invoke(Byte.valueOf(b3))).booleanValue()) {
                return Byte.valueOf(b3);
            }
        }
        return null;
    }

    public static final <R> R foldRight(float[] fArr, R r2, Function2<? super Float, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = getLastIndex(fArr); lastIndex >= 0; lastIndex--) {
            r2 = (R) operation.invoke(Float.valueOf(fArr[lastIndex]), r2);
        }
        return r2;
    }

    public static final <R> R foldRightIndexed(float[] fArr, R r2, Function3<? super Integer, ? super Float, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = getLastIndex(fArr); lastIndex >= 0; lastIndex--) {
            r2 = (R) operation.invoke(Integer.valueOf(lastIndex), Float.valueOf(fArr[lastIndex]), r2);
        }
        return r2;
    }

    public static int indexOf(long[] jArr, long j3) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        int length = jArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (j3 == jArr[i3]) {
                return i3;
            }
        }
        return -1;
    }

    public static final int indexOfFirst(float[] fArr, Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = fArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (((Boolean) predicate.invoke(Float.valueOf(fArr[i3]))).booleanValue()) {
                return i3;
            }
        }
        return -1;
    }

    public static final int indexOfLast(float[] fArr, Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = fArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i3 = length - 1;
                if (((Boolean) predicate.invoke(Float.valueOf(fArr[length]))).booleanValue()) {
                    return length;
                }
                if (i3 < 0) {
                    break;
                }
                length = i3;
            }
        }
        return -1;
    }

    public static final Set<Float> intersect(float[] fArr, Iterable<Float> other) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Float> mutableSet = toMutableSet(fArr);
        CollectionsKt__MutableCollectionsKt.retainAll(mutableSet, other);
        return mutableSet;
    }

    public static int lastIndexOf(long[] jArr, long j3) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        int length = jArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i3 = length - 1;
                if (j3 == jArr[length]) {
                    return length;
                }
                if (i3 < 0) {
                    break;
                }
                length = i3;
            }
        }
        return -1;
    }

    public static final <R, C extends Collection<? super R>> C mapIndexedTo(float[] fArr, C destination, Function2<? super Integer, ? super Float, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = fArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            destination.add(transform.invoke(Integer.valueOf(i4), Float.valueOf(fArr[i3])));
            i3++;
            i4++;
        }
        return destination;
    }

    public static final <R, C extends Collection<? super R>> C mapTo(float[] fArr, C destination, Function1<? super Float, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (float f3 : fArr) {
            destination.add(transform.invoke(Float.valueOf(f3)));
        }
        return destination;
    }

    private static final <R> R maxOfWithOrNull(short[] sArr, Comparator<? super R> comparator, Function1<? super Short, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        R r2 = (Object) selector.invoke(Short.valueOf(sArr[0]));
        int lastIndex = getLastIndex(sArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object obj = (Object) selector.invoke(Short.valueOf(sArr[i3]));
                if (comparator.compare(r2, obj) < 0) {
                    r2 = (R) obj;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    private static final <R> R minOfWithOrNull(short[] sArr, Comparator<? super R> comparator, Function1<? super Short, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        R r2 = (Object) selector.invoke(Short.valueOf(sArr[0]));
        int lastIndex = getLastIndex(sArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object obj = (Object) selector.invoke(Short.valueOf(sArr[i3]));
                if (comparator.compare(r2, obj) > 0) {
                    r2 = (R) obj;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    public static final boolean none(byte[] bArr, Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (byte b3 : bArr) {
            if (((Boolean) predicate.invoke(Byte.valueOf(b3))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final short reduce(short[] sArr, Function2<? super Short, ? super Short, Short> operation) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (sArr.length != 0) {
            short sShortValue = sArr[0];
            int lastIndex = getLastIndex(sArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    sShortValue = ((Number) operation.invoke(Short.valueOf(sShortValue), Short.valueOf(sArr[i3]))).shortValue();
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return sShortValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final short reduceIndexed(short[] sArr, Function3<? super Integer, ? super Short, ? super Short, Short> operation) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (sArr.length != 0) {
            short sShortValue = sArr[0];
            int lastIndex = getLastIndex(sArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    sShortValue = ((Number) operation.invoke(Integer.valueOf(i3), Short.valueOf(sShortValue), Short.valueOf(sArr[i3]))).shortValue();
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return sShortValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static void reverse(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        int length = (sArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int lastIndex = getLastIndex(sArr);
        if (length < 0) {
            return;
        }
        int i3 = 0;
        while (true) {
            short s2 = sArr[i3];
            sArr[i3] = sArr[lastIndex];
            sArr[lastIndex] = s2;
            lastIndex--;
            if (i3 == length) {
                return;
            } else {
                i3++;
            }
        }
    }

    private static final <R> List<R> runningFold(short[] sArr, R r2, Function2<? super R, ? super Short, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (sArr.length == 0) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(sArr.length + 1);
        arrayList.add(r2);
        for (short s2 : sArr) {
            r2 = (R) operation.invoke(r2, Short.valueOf(s2));
            arrayList.add(r2);
        }
        return arrayList;
    }

    private static final <R> List<R> runningFoldIndexed(short[] sArr, R r2, Function3<? super Integer, ? super R, ? super Short, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (sArr.length == 0) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(sArr.length + 1);
        arrayList.add(r2);
        int length = sArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            r2 = (R) operation.invoke(Integer.valueOf(i3), r2, Short.valueOf(sArr[i3]));
            arrayList.add(r2);
        }
        return arrayList;
    }

    public static final List<Float> slice(float[] fArr, IntRange indices) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? CollectionsKt__CollectionsKt.emptyList() : ArraysKt___ArraysJvmKt.asList(ArraysKt___ArraysJvmKt.copyOfRange(fArr, indices.a().intValue(), indices.e().intValue() + 1));
    }

    public static final void sortDescending(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        if (jArr.length > 1) {
            ArraysKt___ArraysJvmKt.sort(jArr);
            reverse(jArr);
        }
    }

    public static final float[] sortedArray(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (fArr.length == 0) {
            return fArr;
        }
        float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
        Intrinsics.checkNotNullExpressionValue(fArrCopyOf, "copyOf(...)");
        ArraysKt___ArraysJvmKt.sort(fArrCopyOf);
        return fArrCopyOf;
    }

    public static final float[] sortedArrayDescending(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (fArr.length == 0) {
            return fArr;
        }
        float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
        Intrinsics.checkNotNullExpressionValue(fArrCopyOf, "copyOf(...)");
        sortDescending(fArrCopyOf);
        return fArrCopyOf;
    }

    public static final Set<Float> subtract(float[] fArr, Iterable<Float> other) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Float> mutableSet = toMutableSet(fArr);
        CollectionsKt__MutableCollectionsKt.removeAll(mutableSet, other);
        return mutableSet;
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final int sumBy(float[] fArr, Function1<? super Float, Integer> selector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iIntValue = 0;
        for (float f3 : fArr) {
            iIntValue += ((Number) selector.invoke(Float.valueOf(f3))).intValue();
        }
        return iIntValue;
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final double sumByDouble(float[] fArr, Function1<? super Float, Double> selector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        double dDoubleValue = 0.0d;
        for (float f3 : fArr) {
            dDoubleValue += ((Number) selector.invoke(Float.valueOf(f3))).doubleValue();
        }
        return dDoubleValue;
    }

    private static final double sumOfDouble(float[] fArr, Function1<? super Float, Double> selector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        double dDoubleValue = 0.0d;
        for (float f3 : fArr) {
            dDoubleValue += ((Number) selector.invoke(Float.valueOf(f3))).doubleValue();
        }
        return dDoubleValue;
    }

    private static final int sumOfInt(float[] fArr, Function1<? super Float, Integer> selector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iIntValue = 0;
        for (float f3 : fArr) {
            iIntValue += ((Number) selector.invoke(Float.valueOf(f3))).intValue();
        }
        return iIntValue;
    }

    private static final long sumOfLong(float[] fArr, Function1<? super Float, Long> selector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        long jLongValue = 0;
        for (float f3 : fArr) {
            jLongValue += ((Number) selector.invoke(Float.valueOf(f3))).longValue();
        }
        return jLongValue;
    }

    public static final <C extends Collection<? super Float>> C toCollection(float[] fArr, C destination) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        for (float f3 : fArr) {
            destination.add(Float.valueOf(f3));
        }
        return destination;
    }

    public static final Set<Float> union(float[] fArr, Iterable<Float> other) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Float> mutableSet = toMutableSet(fArr);
        CollectionsKt__MutableCollectionsKt.addAll(mutableSet, other);
        return mutableSet;
    }

    public static final boolean any(short[] sArr, Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (short s2 : sArr) {
            if (((Boolean) predicate.invoke(Short.valueOf(s2))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <V> Map<Float, V> associateWith(float[] fArr, Function1<? super Float, ? extends V> valueSelector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt__MapsJVMKt.mapCapacity(fArr.length), 16));
        for (float f3 : fArr) {
            linkedHashMap.put(Float.valueOf(f3), valueSelector.invoke(Float.valueOf(f3)));
        }
        return linkedHashMap;
    }

    public static final int count(short[] sArr, Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i3 = 0;
        for (short s2 : sArr) {
            if (((Boolean) predicate.invoke(Short.valueOf(s2))).booleanValue()) {
                i3++;
            }
        }
        return i3;
    }

    public static final Short firstOrNull(short[] sArr, Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (short s2 : sArr) {
            if (((Boolean) predicate.invoke(Short.valueOf(s2))).booleanValue()) {
                return Short.valueOf(s2);
            }
        }
        return null;
    }

    public static final Short maxWithOrNull(short[] sArr, Comparator<? super Short> comparator) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (sArr.length == 0) {
            return null;
        }
        short s2 = sArr[0];
        int lastIndex = getLastIndex(sArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                short s3 = sArr[i3];
                if (comparator.compare(Short.valueOf(s2), Short.valueOf(s3)) < 0) {
                    s2 = s3;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Short.valueOf(s2);
    }

    public static final Short minWithOrNull(short[] sArr, Comparator<? super Short> comparator) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (sArr.length == 0) {
            return null;
        }
        short s2 = sArr[0];
        int lastIndex = getLastIndex(sArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                short s3 = sArr[i3];
                if (comparator.compare(Short.valueOf(s2), Short.valueOf(s3)) > 0) {
                    s2 = s3;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Short.valueOf(s2);
    }

    public static final boolean none(short[] sArr, Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (short s2 : sArr) {
            if (((Boolean) predicate.invoke(Short.valueOf(s2))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final Byte randomOrNull(byte[] bArr, Random random) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (bArr.length == 0) {
            return null;
        }
        return Byte.valueOf(bArr[random.j(bArr.length)]);
    }

    public static final Integer reduceRightIndexedOrNull(int[] iArr, Function3<? super Integer, ? super Integer, ? super Integer, Integer> operation) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(iArr);
        if (lastIndex < 0) {
            return null;
        }
        int iIntValue = iArr[lastIndex];
        for (int i3 = lastIndex - 1; i3 >= 0; i3--) {
            iIntValue = ((Number) operation.invoke(Integer.valueOf(i3), Integer.valueOf(iArr[i3]), Integer.valueOf(iIntValue))).intValue();
        }
        return Integer.valueOf(iIntValue);
    }

    public static final Integer reduceRightOrNull(int[] iArr, Function2<? super Integer, ? super Integer, Integer> operation) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(iArr);
        if (lastIndex < 0) {
            return null;
        }
        int iIntValue = iArr[lastIndex];
        for (int i3 = lastIndex - 1; i3 >= 0; i3--) {
            iIntValue = ((Number) operation.invoke(Integer.valueOf(iArr[i3]), Integer.valueOf(iIntValue))).intValue();
        }
        return Integer.valueOf(iIntValue);
    }

    public static final Byte singleOrNull(byte[] bArr, Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Byte bValueOf = null;
        boolean z2 = false;
        for (byte b3 : bArr) {
            if (((Boolean) predicate.invoke(Byte.valueOf(b3))).booleanValue()) {
                if (z2) {
                    return null;
                }
                bValueOf = Byte.valueOf(b3);
                z2 = true;
            }
        }
        if (z2) {
            return bValueOf;
        }
        return null;
    }

    public static final List<Double> toMutableList(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        ArrayList arrayList = new ArrayList(dArr.length);
        for (double d3 : dArr) {
            arrayList.add(Double.valueOf(d3));
        }
        return arrayList;
    }

    public static final boolean any(int[] iArr, Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int i3 : iArr) {
            if (((Boolean) predicate.invoke(Integer.valueOf(i3))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public static Iterable<Double> asIterable(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        return dArr.length == 0 ? CollectionsKt__CollectionsKt.emptyList() : new ArraysKt___ArraysKt$asIterable$$inlined$Iterable$7(dArr);
    }

    public static final Sequence<Double> asSequence(final double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        return dArr.length == 0 ? SequencesKt.g() : new Sequence<Double>() { // from class: kotlin.collections.ArraysKt___ArraysKt$asSequence$$inlined$Sequence$7
            @Override // kotlin.sequences.Sequence
            public Iterator<Double> iterator() {
                return ArrayIteratorsKt.d(dArr);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> associate(int[] iArr, Function1<? super Integer, ? extends Pair<? extends K, ? extends V>> transform) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt__MapsJVMKt.mapCapacity(iArr.length), 16));
        for (int i3 : iArr) {
            Pair pair = (Pair) transform.invoke(Integer.valueOf(i3));
            linkedHashMap.put(pair.e(), pair.f());
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K> Map<K, Integer> associateBy(int[] iArr, Function1<? super Integer, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt__MapsJVMKt.mapCapacity(iArr.length), 16));
        for (int i3 : iArr) {
            linkedHashMap.put(keySelector.invoke(Integer.valueOf(i3)), Integer.valueOf(i3));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, M extends Map<? super K, ? super Double>> M associateByTo(double[] dArr, M destination, Function1<? super Double, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (double d3 : dArr) {
            destination.put(keySelector.invoke(Double.valueOf(d3)), Double.valueOf(d3));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(double[] dArr, M destination, Function1<? super Double, ? extends Pair<? extends K, ? extends V>> transform) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (double d3 : dArr) {
            Pair pair = (Pair) transform.invoke(Double.valueOf(d3));
            destination.put(pair.e(), pair.f());
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <V, M extends Map<? super Double, ? super V>> M associateWithTo(double[] dArr, M destination, Function1<? super Double, ? extends V> valueSelector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        for (double d3 : dArr) {
            destination.put(Double.valueOf(d3), valueSelector.invoke(Double.valueOf(d3)));
        }
        return destination;
    }

    private static final int[] copyOf(int[] iArr, int i3, Function1<? super Integer, Integer> init) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(init, "init");
        if (i3 >= 0) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, i3);
            Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
            for (int length = iArr.length; length < i3; length++) {
                iArrCopyOf[length] = ((Number) init.invoke(Integer.valueOf(length))).intValue();
            }
            return iArrCopyOf;
        }
        throw new IllegalArgumentException(("Invalid new array size: " + i3 + '.').toString());
    }

    public static final int count(int[] iArr, Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i3 = 0;
        for (int i4 : iArr) {
            if (((Boolean) predicate.invoke(Integer.valueOf(i4))).booleanValue()) {
                i3++;
            }
        }
        return i3;
    }

    public static final <K> List<Short> distinctBy(short[] sArr, Function1<? super Short, ? extends K> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (short s2 : sArr) {
            if (hashSet.add(selector.invoke(Short.valueOf(s2)))) {
                arrayList.add(Short.valueOf(s2));
            }
        }
        return arrayList;
    }

    public static final List<Double> drop(double[] dArr, int i3) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (i3 >= 0) {
            return takeLast(dArr, RangesKt.f(dArr.length - i3, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
    }

    public static final List<Double> dropLast(double[] dArr, int i3) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (i3 >= 0) {
            return take(dArr, RangesKt.f(dArr.length - i3, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
    }

    public static final List<Integer> dropLastWhile(int[] iArr, Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = getLastIndex(iArr); -1 < lastIndex; lastIndex--) {
            if (!((Boolean) predicate.invoke(Integer.valueOf(iArr[lastIndex]))).booleanValue()) {
                return take(iArr, lastIndex + 1);
            }
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    public static final List<Double> filter(double[] dArr, Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (double d3 : dArr) {
            if (((Boolean) predicate.invoke(Double.valueOf(d3))).booleanValue()) {
                arrayList.add(Double.valueOf(d3));
            }
        }
        return arrayList;
    }

    public static final List<Long> filterIndexed(long[] jArr, Function2<? super Integer, ? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = jArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            long j3 = jArr[i3];
            int i5 = i4 + 1;
            if (((Boolean) predicate.invoke(Integer.valueOf(i4), Long.valueOf(j3))).booleanValue()) {
                arrayList.add(Long.valueOf(j3));
            }
            i3++;
            i4 = i5;
        }
        return arrayList;
    }

    public static final <C extends Collection<? super Double>> C filterIndexedTo(double[] dArr, C destination, Function2<? super Integer, ? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = dArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            double d3 = dArr[i3];
            int i5 = i4 + 1;
            if (((Boolean) predicate.invoke(Integer.valueOf(i4), Double.valueOf(d3))).booleanValue()) {
                destination.add(Double.valueOf(d3));
            }
            i3++;
            i4 = i5;
        }
        return destination;
    }

    public static final List<Double> filterNot(double[] dArr, Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (double d3 : dArr) {
            if (!((Boolean) predicate.invoke(Double.valueOf(d3))).booleanValue()) {
                arrayList.add(Double.valueOf(d3));
            }
        }
        return arrayList;
    }

    private static final Long findLast(long[] jArr, Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = jArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i3 = length - 1;
            long j3 = jArr[length];
            if (((Boolean) predicate.invoke(Long.valueOf(j3))).booleanValue()) {
                return Long.valueOf(j3);
            }
            if (i3 < 0) {
                return null;
            }
            length = i3;
        }
    }

    public static long first(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        if (jArr.length != 0) {
            return jArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final Integer firstOrNull(int[] iArr, Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int i3 : iArr) {
            if (((Boolean) predicate.invoke(Integer.valueOf(i3))).booleanValue()) {
                return Integer.valueOf(i3);
            }
        }
        return null;
    }

    public static final <R> List<R> flatMap(int[] iArr, Function1<? super Integer, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (int i3 : iArr) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, (Iterable) transform.invoke(Integer.valueOf(i3)));
        }
        return arrayList;
    }

    private static final <R, C extends Collection<? super R>> C flatMapIndexedIterableTo(long[] jArr, C destination, Function2<? super Integer, ? super Long, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = jArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            CollectionsKt__MutableCollectionsKt.addAll(destination, (Iterable) transform.invoke(Integer.valueOf(i4), Long.valueOf(jArr[i3])));
            i3++;
            i4++;
        }
        return destination;
    }

    public static final <R, C extends Collection<? super R>> C flatMapTo(long[] jArr, C destination, Function1<? super Long, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (long j3 : jArr) {
            CollectionsKt__MutableCollectionsKt.addAll(destination, (Iterable) transform.invoke(Long.valueOf(j3)));
        }
        return destination;
    }

    public static final <R> R foldRight(double[] dArr, R r2, Function2<? super Double, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = getLastIndex(dArr); lastIndex >= 0; lastIndex--) {
            r2 = (R) operation.invoke(Double.valueOf(dArr[lastIndex]), r2);
        }
        return r2;
    }

    public static final <R> R foldRightIndexed(double[] dArr, R r2, Function3<? super Integer, ? super Double, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = getLastIndex(dArr); lastIndex >= 0; lastIndex--) {
            r2 = (R) operation.invoke(Integer.valueOf(lastIndex), Double.valueOf(dArr[lastIndex]), r2);
        }
        return r2;
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ int indexOf(float[] fArr, float f3) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        int length = fArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (f3 == fArr[i3]) {
                return i3;
            }
        }
        return -1;
    }

    public static final int indexOfFirst(double[] dArr, Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = dArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (((Boolean) predicate.invoke(Double.valueOf(dArr[i3]))).booleanValue()) {
                return i3;
            }
        }
        return -1;
    }

    public static final int indexOfLast(double[] dArr, Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = dArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i3 = length - 1;
                if (((Boolean) predicate.invoke(Double.valueOf(dArr[length]))).booleanValue()) {
                    return length;
                }
                if (i3 < 0) {
                    break;
                }
                length = i3;
            }
        }
        return -1;
    }

    public static final Set<Double> intersect(double[] dArr, Iterable<Double> other) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Double> mutableSet = toMutableSet(dArr);
        CollectionsKt__MutableCollectionsKt.retainAll(mutableSet, other);
        return mutableSet;
    }

    public static long last(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        if (jArr.length != 0) {
            return jArr[getLastIndex(jArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ int lastIndexOf(float[] fArr, float f3) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        int length = fArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i3 = length - 1;
                if (f3 == fArr[length]) {
                    return length;
                }
                if (i3 < 0) {
                    break;
                }
                length = i3;
            }
        }
        return -1;
    }

    public static final Byte lastOrNull(byte[] bArr, Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = bArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i3 = length - 1;
            byte b3 = bArr[length];
            if (((Boolean) predicate.invoke(Byte.valueOf(b3))).booleanValue()) {
                return Byte.valueOf(b3);
            }
            if (i3 < 0) {
                return null;
            }
            length = i3;
        }
    }

    public static final <R> List<R> map(long[] jArr, Function1<? super Long, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(jArr.length);
        for (long j3 : jArr) {
            arrayList.add(transform.invoke(Long.valueOf(j3)));
        }
        return arrayList;
    }

    public static final <R> List<R> mapIndexed(long[] jArr, Function2<? super Integer, ? super Long, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(jArr.length);
        int length = jArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            arrayList.add(transform.invoke(Integer.valueOf(i4), Long.valueOf(jArr[i3])));
            i3++;
            i4++;
        }
        return arrayList;
    }

    public static final <R, C extends Collection<? super R>> C mapIndexedTo(double[] dArr, C destination, Function2<? super Integer, ? super Double, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = dArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            destination.add(transform.invoke(Integer.valueOf(i4), Double.valueOf(dArr[i3])));
            i3++;
            i4++;
        }
        return destination;
    }

    public static final <R, C extends Collection<? super R>> C mapTo(double[] dArr, C destination, Function1<? super Double, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (double d3 : dArr) {
            destination.add(transform.invoke(Double.valueOf(d3)));
        }
        return destination;
    }

    private static final double maxOf(short[] sArr, Function1<? super Short, Double> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (sArr.length != 0) {
            double dDoubleValue = ((Number) selector.invoke(Short.valueOf(sArr[0]))).doubleValue();
            int lastIndex = getLastIndex(sArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    dDoubleValue = Math.max(dDoubleValue, ((Number) selector.invoke(Short.valueOf(sArr[i3]))).doubleValue());
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return dDoubleValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final Double m1400maxOfOrNull(short[] sArr, Function1<? super Short, Double> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        double dDoubleValue = ((Number) selector.invoke(Short.valueOf(sArr[0]))).doubleValue();
        int lastIndex = getLastIndex(sArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.max(dDoubleValue, ((Number) selector.invoke(Short.valueOf(sArr[i3]))).doubleValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    private static final <R> R maxOfWith(short[] sArr, Comparator<? super R> comparator, Function1<? super Short, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (sArr.length != 0) {
            R r2 = (Object) selector.invoke(Short.valueOf(sArr[0]));
            int lastIndex = getLastIndex(sArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Object obj = (Object) selector.invoke(Short.valueOf(sArr[i3]));
                    if (comparator.compare(r2, obj) < 0) {
                        r2 = (R) obj;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return r2;
        }
        throw new NoSuchElementException();
    }

    public static final <T extends Comparable<? super T>> T maxOrNull(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length == 0) {
            return null;
        }
        T t2 = tArr[0];
        int lastIndex = getLastIndex(tArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                T t3 = tArr[i3];
                if (t2.compareTo(t3) < 0) {
                    t2 = t3;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return t2;
    }

    public static final <T extends Comparable<? super T>> T maxOrThrow(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length != 0) {
            T t2 = tArr[0];
            int lastIndex = getLastIndex(tArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    T t3 = tArr[i3];
                    if (t2.compareTo(t3) < 0) {
                        t2 = t3;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return t2;
        }
        throw new NoSuchElementException();
    }

    public static final short maxWithOrThrow(short[] sArr, Comparator<? super Short> comparator) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (sArr.length != 0) {
            short s2 = sArr[0];
            int lastIndex = getLastIndex(sArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    short s3 = sArr[i3];
                    if (comparator.compare(Short.valueOf(s2), Short.valueOf(s3)) < 0) {
                        s2 = s3;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return s2;
        }
        throw new NoSuchElementException();
    }

    private static final double minOf(short[] sArr, Function1<? super Short, Double> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (sArr.length != 0) {
            double dDoubleValue = ((Number) selector.invoke(Short.valueOf(sArr[0]))).doubleValue();
            int lastIndex = getLastIndex(sArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    dDoubleValue = Math.min(dDoubleValue, ((Number) selector.invoke(Short.valueOf(sArr[i3]))).doubleValue());
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return dDoubleValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOfOrNull, reason: collision with other method in class */
    private static final Double m1436minOfOrNull(short[] sArr, Function1<? super Short, Double> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        double dDoubleValue = ((Number) selector.invoke(Short.valueOf(sArr[0]))).doubleValue();
        int lastIndex = getLastIndex(sArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.min(dDoubleValue, ((Number) selector.invoke(Short.valueOf(sArr[i3]))).doubleValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    private static final <R> R minOfWith(short[] sArr, Comparator<? super R> comparator, Function1<? super Short, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (sArr.length != 0) {
            R r2 = (Object) selector.invoke(Short.valueOf(sArr[0]));
            int lastIndex = getLastIndex(sArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Object obj = (Object) selector.invoke(Short.valueOf(sArr[i3]));
                    if (comparator.compare(r2, obj) > 0) {
                        r2 = (R) obj;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return r2;
        }
        throw new NoSuchElementException();
    }

    public static final <T extends Comparable<? super T>> T minOrNull(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length == 0) {
            return null;
        }
        T t2 = tArr[0];
        int lastIndex = getLastIndex(tArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                T t3 = tArr[i3];
                if (t2.compareTo(t3) > 0) {
                    t2 = t3;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return t2;
    }

    public static final <T extends Comparable<? super T>> T minOrThrow(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length != 0) {
            T t2 = tArr[0];
            int lastIndex = getLastIndex(tArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    T t3 = tArr[i3];
                    if (t2.compareTo(t3) > 0) {
                        t2 = t3;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return t2;
        }
        throw new NoSuchElementException();
    }

    public static final short minWithOrThrow(short[] sArr, Comparator<? super Short> comparator) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (sArr.length != 0) {
            short s2 = sArr[0];
            int lastIndex = getLastIndex(sArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    short s3 = sArr[i3];
                    if (comparator.compare(Short.valueOf(s2), Short.valueOf(s3)) > 0) {
                        s2 = s3;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return s2;
        }
        throw new NoSuchElementException();
    }

    public static final boolean none(int[] iArr, Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int i3 : iArr) {
            if (((Boolean) predicate.invoke(Integer.valueOf(i3))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final byte random(byte[] bArr, Random random) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (bArr.length != 0) {
            return bArr[random.j(bArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final int reduceRight(int[] iArr, Function2<? super Integer, ? super Integer, Integer> operation) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(iArr);
        if (lastIndex >= 0) {
            int iIntValue = iArr[lastIndex];
            for (int i3 = lastIndex - 1; i3 >= 0; i3--) {
                iIntValue = ((Number) operation.invoke(Integer.valueOf(iArr[i3]), Integer.valueOf(iIntValue))).intValue();
            }
            return iIntValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final int reduceRightIndexed(int[] iArr, Function3<? super Integer, ? super Integer, ? super Integer, Integer> operation) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(iArr);
        if (lastIndex >= 0) {
            int iIntValue = iArr[lastIndex];
            for (int i3 = lastIndex - 1; i3 >= 0; i3--) {
                iIntValue = ((Number) operation.invoke(Integer.valueOf(i3), Integer.valueOf(iArr[i3]), Integer.valueOf(iIntValue))).intValue();
            }
            return iIntValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final List<Long> reversed(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        if (jArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<Long> mutableList = toMutableList(jArr);
        CollectionsKt___CollectionsJvmKt.reverse(mutableList);
        return mutableList;
    }

    public static int[] reversedArray(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (iArr.length == 0) {
            return iArr;
        }
        int[] iArr2 = new int[iArr.length];
        int lastIndex = getLastIndex(iArr);
        if (lastIndex >= 0) {
            int i3 = 0;
            while (true) {
                iArr2[lastIndex - i3] = iArr[i3];
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return iArr2;
    }

    private static final List<Short> runningReduce(short[] sArr, Function2<? super Short, ? super Short, Short> operation) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (sArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        short sShortValue = sArr[0];
        ArrayList arrayList = new ArrayList(sArr.length);
        arrayList.add(Short.valueOf(sShortValue));
        int length = sArr.length;
        for (int i3 = 1; i3 < length; i3++) {
            sShortValue = ((Number) operation.invoke(Short.valueOf(sShortValue), Short.valueOf(sArr[i3]))).shortValue();
            arrayList.add(Short.valueOf(sShortValue));
        }
        return arrayList;
    }

    private static final List<Short> runningReduceIndexed(short[] sArr, Function3<? super Integer, ? super Short, ? super Short, Short> operation) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (sArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        short sShortValue = sArr[0];
        ArrayList arrayList = new ArrayList(sArr.length);
        arrayList.add(Short.valueOf(sShortValue));
        int length = sArr.length;
        for (int i3 = 1; i3 < length; i3++) {
            sShortValue = ((Number) operation.invoke(Integer.valueOf(i3), Short.valueOf(sShortValue), Short.valueOf(sArr[i3]))).shortValue();
            arrayList.add(Short.valueOf(sShortValue));
        }
        return arrayList;
    }

    public static int single(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int length = iArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return iArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static final List<Double> slice(double[] dArr, IntRange indices) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? CollectionsKt__CollectionsKt.emptyList() : ArraysKt___ArraysJvmKt.asList(ArraysKt___ArraysJvmKt.copyOfRange(dArr, indices.a().intValue(), indices.e().intValue() + 1));
    }

    public static long[] sliceArray(long[] jArr, Collection<Integer> indices) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        long[] jArr2 = new long[indices.size()];
        Iterator<Integer> it = indices.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            jArr2[i3] = jArr[it.next().intValue()];
            i3++;
        }
        return jArr2;
    }

    public static final double[] sortedArray(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (dArr.length == 0) {
            return dArr;
        }
        double[] dArrCopyOf = Arrays.copyOf(dArr, dArr.length);
        Intrinsics.checkNotNullExpressionValue(dArrCopyOf, "copyOf(...)");
        ArraysKt___ArraysJvmKt.sort(dArrCopyOf);
        return dArrCopyOf;
    }

    public static final double[] sortedArrayDescending(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (dArr.length == 0) {
            return dArr;
        }
        double[] dArrCopyOf = Arrays.copyOf(dArr, dArr.length);
        Intrinsics.checkNotNullExpressionValue(dArrCopyOf, "copyOf(...)");
        sortDescending(dArrCopyOf);
        return dArrCopyOf;
    }

    public static final Set<Double> subtract(double[] dArr, Iterable<Double> other) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Double> mutableSet = toMutableSet(dArr);
        CollectionsKt__MutableCollectionsKt.removeAll(mutableSet, other);
        return mutableSet;
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final int sumBy(double[] dArr, Function1<? super Double, Integer> selector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iIntValue = 0;
        for (double d3 : dArr) {
            iIntValue += ((Number) selector.invoke(Double.valueOf(d3))).intValue();
        }
        return iIntValue;
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final double sumByDouble(double[] dArr, Function1<? super Double, Double> selector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        double dDoubleValue = 0.0d;
        for (double d3 : dArr) {
            dDoubleValue += ((Number) selector.invoke(Double.valueOf(d3))).doubleValue();
        }
        return dDoubleValue;
    }

    private static final double sumOfDouble(double[] dArr, Function1<? super Double, Double> selector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        double dDoubleValue = 0.0d;
        for (double d3 : dArr) {
            dDoubleValue += ((Number) selector.invoke(Double.valueOf(d3))).doubleValue();
        }
        return dDoubleValue;
    }

    private static final int sumOfInt(double[] dArr, Function1<? super Double, Integer> selector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iIntValue = 0;
        for (double d3 : dArr) {
            iIntValue += ((Number) selector.invoke(Double.valueOf(d3))).intValue();
        }
        return iIntValue;
    }

    private static final long sumOfLong(double[] dArr, Function1<? super Double, Long> selector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        long jLongValue = 0;
        for (double d3 : dArr) {
            jLongValue += ((Number) selector.invoke(Double.valueOf(d3))).longValue();
        }
        return jLongValue;
    }

    private static final int sumOfUInt(long[] jArr, Function1<? super Long, UInt> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iB = UInt.b(0);
        for (long j3 : jArr) {
            iB = UInt.b(iB + ((UInt) selector.invoke(Long.valueOf(j3))).f());
        }
        return iB;
    }

    private static final long sumOfULong(long[] jArr, Function1<? super Long, ULong> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        long jB = ULong.b(0L);
        for (long j3 : jArr) {
            jB = ULong.b(jB + ((ULong) selector.invoke(Long.valueOf(j3))).g());
        }
        return jB;
    }

    public static final List<Integer> takeLastWhile(int[] iArr, Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = getLastIndex(iArr); -1 < lastIndex; lastIndex--) {
            if (!((Boolean) predicate.invoke(Integer.valueOf(iArr[lastIndex]))).booleanValue()) {
                return drop(iArr, lastIndex + 1);
            }
        }
        return toList(iArr);
    }

    public static final List<Integer> takeWhile(int[] iArr, Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (int i3 : iArr) {
            if (!((Boolean) predicate.invoke(Integer.valueOf(i3))).booleanValue()) {
                break;
            }
            arrayList.add(Integer.valueOf(i3));
        }
        return arrayList;
    }

    public static final <C extends Collection<? super Double>> C toCollection(double[] dArr, C destination) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        for (double d3 : dArr) {
            destination.add(Double.valueOf(d3));
        }
        return destination;
    }

    public static List<Integer> toList(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int length = iArr.length;
        if (length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (length != 1) {
            return toMutableList(iArr);
        }
        return CollectionsKt__CollectionsJVMKt.listOf(Integer.valueOf(iArr[0]));
    }

    public static final Set<Integer> toSet(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int length = iArr.length;
        if (length == 0) {
            return SetsKt__SetsKt.emptySet();
        }
        if (length != 1) {
            return (Set) toCollection(iArr, new LinkedHashSet(MapsKt__MapsJVMKt.mapCapacity(iArr.length)));
        }
        return SetsKt__SetsJVMKt.setOf(Integer.valueOf(iArr[0]));
    }

    public static final Set<Double> union(double[] dArr, Iterable<Double> other) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Double> mutableSet = toMutableSet(dArr);
        CollectionsKt__MutableCollectionsKt.addAll(mutableSet, other);
        return mutableSet;
    }

    public static final <R, V> List<V> zip(long[] jArr, R[] other, Function2<? super Long, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iMin = Math.min(jArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i3 = 0; i3 < iMin; i3++) {
            arrayList.add(transform.invoke(Long.valueOf(jArr[i3]), other[i3]));
        }
        return arrayList;
    }

    public static final boolean any(long[] jArr, Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (long j3 : jArr) {
            if (((Boolean) predicate.invoke(Long.valueOf(j3))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <V> Map<Double, V> associateWith(double[] dArr, Function1<? super Double, ? extends V> valueSelector) {
        Intrinsics.checkNotNullParameter(dArr, QgXempTBEfV.zfQvfJlqcpgbQqv);
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt__MapsJVMKt.mapCapacity(dArr.length), 16));
        for (double d3 : dArr) {
            linkedHashMap.put(Double.valueOf(d3), valueSelector.invoke(Double.valueOf(d3)));
        }
        return linkedHashMap;
    }

    public static final int count(long[] jArr, Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i3 = 0;
        for (long j3 : jArr) {
            if (((Boolean) predicate.invoke(Long.valueOf(j3))).booleanValue()) {
                i3++;
            }
        }
        return i3;
    }

    public static final Long firstOrNull(long[] jArr, Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (long j3 : jArr) {
            if (((Boolean) predicate.invoke(Long.valueOf(j3))).booleanValue()) {
                return Long.valueOf(j3);
            }
        }
        return null;
    }

    public static final <A extends Appendable> A joinTo(short[] sArr, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i3, CharSequence truncated, Function1<? super Short, ? extends CharSequence> function1) throws IOException {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        buffer.append(prefix);
        int i4 = 0;
        for (short s2 : sArr) {
            i4++;
            if (i4 > 1) {
                buffer.append(separator);
            }
            if (i3 >= 0 && i4 > i3) {
                break;
            }
            if (function1 != null) {
                buffer.append((CharSequence) function1.invoke(Short.valueOf(s2)));
            } else {
                buffer.append(String.valueOf((int) s2));
            }
        }
        if (i3 >= 0 && i4 > i3) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final boolean none(long[] jArr, Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (long j3 : jArr) {
            if (((Boolean) predicate.invoke(Long.valueOf(j3))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final Short randomOrNull(short[] sArr, Random random) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (sArr.length == 0) {
            return null;
        }
        return Short.valueOf(sArr[random.j(sArr.length)]);
    }

    public static final void sortDescending(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (fArr.length > 1) {
            ArraysKt___ArraysJvmKt.sort(fArr);
            reverse(fArr);
        }
    }

    public static final List<Boolean> toMutableList(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        ArrayList arrayList = new ArrayList(zArr.length);
        for (boolean z2 : zArr) {
            arrayList.add(Boolean.valueOf(z2));
        }
        return arrayList;
    }

    public static final boolean any(float[] fArr, Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (float f3 : fArr) {
            if (((Boolean) predicate.invoke(Float.valueOf(f3))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public static final Iterable<Boolean> asIterable(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return zArr.length == 0 ? CollectionsKt__CollectionsKt.emptyList() : new ArraysKt___ArraysKt$asIterable$$inlined$Iterable$8(zArr);
    }

    public static final Sequence<Boolean> asSequence(final boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return zArr.length == 0 ? SequencesKt.g() : new Sequence<Boolean>() { // from class: kotlin.collections.ArraysKt___ArraysKt$asSequence$$inlined$Sequence$8
            @Override // kotlin.sequences.Sequence
            public Iterator<Boolean> iterator() {
                return ArrayIteratorsKt.a(zArr);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, M extends Map<? super K, ? super Boolean>> M associateByTo(boolean[] zArr, M m3, Function1<? super Boolean, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(m3, jTYhJgqLBN.FmLpBvtMsD);
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (boolean z2 : zArr) {
            m3.put(keySelector.invoke(Boolean.valueOf(z2)), Boolean.valueOf(z2));
        }
        return m3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(boolean[] zArr, M destination, Function1<? super Boolean, ? extends Pair<? extends K, ? extends V>> transform) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (boolean z2 : zArr) {
            Pair pair = (Pair) transform.invoke(Boolean.valueOf(z2));
            destination.put(pair.e(), pair.f());
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <V, M extends Map<? super Boolean, ? super V>> M associateWithTo(boolean[] zArr, M destination, Function1<? super Boolean, ? extends V> valueSelector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        for (boolean z2 : zArr) {
            destination.put(Boolean.valueOf(z2), valueSelector.invoke(Boolean.valueOf(z2)));
        }
        return destination;
    }

    public static final int count(float[] fArr, Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i3 = 0;
        for (float f3 : fArr) {
            if (((Boolean) predicate.invoke(Float.valueOf(f3))).booleanValue()) {
                i3++;
            }
        }
        return i3;
    }

    public static final List<Boolean> drop(boolean[] zArr, int i3) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        if (i3 >= 0) {
            return takeLast(zArr, RangesKt.f(zArr.length - i3, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
    }

    public static final List<Boolean> dropLast(boolean[] zArr, int i3) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        if (i3 >= 0) {
            return take(zArr, RangesKt.f(zArr.length - i3, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
    }

    public static final List<Boolean> filter(boolean[] zArr, Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (boolean z2 : zArr) {
            if (((Boolean) predicate.invoke(Boolean.valueOf(z2))).booleanValue()) {
                arrayList.add(Boolean.valueOf(z2));
            }
        }
        return arrayList;
    }

    public static final <C extends Collection<? super Boolean>> C filterIndexedTo(boolean[] zArr, C destination, Function2<? super Integer, ? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = zArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            boolean z2 = zArr[i3];
            int i5 = i4 + 1;
            if (((Boolean) predicate.invoke(Integer.valueOf(i4), Boolean.valueOf(z2))).booleanValue()) {
                destination.add(Boolean.valueOf(z2));
            }
            i3++;
            i4 = i5;
        }
        return destination;
    }

    public static final List<Boolean> filterNot(boolean[] zArr, Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (boolean z2 : zArr) {
            if (!((Boolean) predicate.invoke(Boolean.valueOf(z2))).booleanValue()) {
                arrayList.add(Boolean.valueOf(z2));
            }
        }
        return arrayList;
    }

    public static final Float firstOrNull(float[] fArr, Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (float f3 : fArr) {
            if (((Boolean) predicate.invoke(Float.valueOf(f3))).booleanValue()) {
                return Float.valueOf(f3);
            }
        }
        return null;
    }

    public static final <R> R foldRight(boolean[] zArr, R r2, Function2<? super Boolean, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = getLastIndex(zArr); lastIndex >= 0; lastIndex--) {
            r2 = (R) operation.invoke(Boolean.valueOf(zArr[lastIndex]), r2);
        }
        return r2;
    }

    public static final <R> R foldRightIndexed(boolean[] zArr, R r2, Function3<? super Integer, ? super Boolean, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = getLastIndex(zArr); lastIndex >= 0; lastIndex--) {
            r2 = (R) operation.invoke(Integer.valueOf(lastIndex), Boolean.valueOf(zArr[lastIndex]), r2);
        }
        return r2;
    }

    public static final <K, M extends Map<? super K, List<Short>>> M groupByTo(short[] sArr, M destination, Function1<? super Short, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (short s2 : sArr) {
            Object objInvoke = keySelector.invoke(Short.valueOf(s2));
            Object arrayList = destination.get(objInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(objInvoke, arrayList);
            }
            ((List) arrayList).add(Short.valueOf(s2));
        }
        return destination;
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ int indexOf(double[] dArr, double d3) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        int length = dArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (d3 == dArr[i3]) {
                return i3;
            }
        }
        return -1;
    }

    public static final int indexOfFirst(boolean[] zArr, Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = zArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (((Boolean) predicate.invoke(Boolean.valueOf(zArr[i3]))).booleanValue()) {
                return i3;
            }
        }
        return -1;
    }

    public static final int indexOfLast(boolean[] zArr, Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = zArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i3 = length - 1;
                if (((Boolean) predicate.invoke(Boolean.valueOf(zArr[length]))).booleanValue()) {
                    return length;
                }
                if (i3 < 0) {
                    break;
                }
                length = i3;
            }
        }
        return -1;
    }

    public static final Set<Boolean> intersect(boolean[] zArr, Iterable<Boolean> other) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Boolean> mutableSet = toMutableSet(zArr);
        CollectionsKt__MutableCollectionsKt.retainAll(mutableSet, other);
        return mutableSet;
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ int lastIndexOf(double[] dArr, double d3) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        int length = dArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i3 = length - 1;
                if (d3 == dArr[length]) {
                    return length;
                }
                if (i3 < 0) {
                    break;
                }
                length = i3;
            }
        }
        return -1;
    }

    public static final <R, C extends Collection<? super R>> C mapIndexedTo(boolean[] zArr, C destination, Function2<? super Integer, ? super Boolean, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = zArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            destination.add(transform.invoke(Integer.valueOf(i4), Boolean.valueOf(zArr[i3])));
            i3++;
            i4++;
        }
        return destination;
    }

    public static final <R, C extends Collection<? super R>> C mapTo(boolean[] zArr, C destination, Function1<? super Boolean, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (boolean z2 : zArr) {
            destination.add(transform.invoke(Boolean.valueOf(z2)));
        }
        return destination;
    }

    public static final boolean none(float[] fArr, Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (float f3 : fArr) {
            if (((Boolean) predicate.invoke(Float.valueOf(f3))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final Pair<List<Short>, List<Short>> partition(short[] sArr, Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (short s2 : sArr) {
            if (((Boolean) predicate.invoke(Short.valueOf(s2))).booleanValue()) {
                arrayList.add(Short.valueOf(s2));
            } else {
                arrayList2.add(Short.valueOf(s2));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    public static final Integer reduceIndexedOrNull(int[] iArr, Function3<? super Integer, ? super Integer, ? super Integer, Integer> operation) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (iArr.length == 0) {
            return null;
        }
        int iIntValue = iArr[0];
        int lastIndex = getLastIndex(iArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                iIntValue = ((Number) operation.invoke(Integer.valueOf(i3), Integer.valueOf(iIntValue), Integer.valueOf(iArr[i3]))).intValue();
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Integer.valueOf(iIntValue);
    }

    public static final Integer reduceOrNull(int[] iArr, Function2<? super Integer, ? super Integer, Integer> operation) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (iArr.length == 0) {
            return null;
        }
        int iIntValue = iArr[0];
        int lastIndex = getLastIndex(iArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                iIntValue = ((Number) operation.invoke(Integer.valueOf(iIntValue), Integer.valueOf(iArr[i3]))).intValue();
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Integer.valueOf(iIntValue);
    }

    public static final void shuffle(byte[] bArr, Random random) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = getLastIndex(bArr); lastIndex > 0; lastIndex--) {
            int iJ = random.j(lastIndex + 1);
            byte b3 = bArr[lastIndex];
            bArr[lastIndex] = bArr[iJ];
            bArr[iJ] = b3;
        }
    }

    public static final Short singleOrNull(short[] sArr, Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Short shValueOf = null;
        boolean z2 = false;
        for (short s2 : sArr) {
            if (((Boolean) predicate.invoke(Short.valueOf(s2))).booleanValue()) {
                if (z2) {
                    return null;
                }
                shValueOf = Short.valueOf(s2);
                z2 = true;
            }
        }
        if (z2) {
            return shValueOf;
        }
        return null;
    }

    public static final List<Boolean> slice(boolean[] zArr, IntRange indices) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? CollectionsKt__CollectionsKt.emptyList() : ArraysKt___ArraysJvmKt.asList(ArraysKt___ArraysJvmKt.copyOfRange(zArr, indices.a().intValue(), indices.e().intValue() + 1));
    }

    public static final char[] sortedArray(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (cArr.length == 0) {
            return cArr;
        }
        char[] cArrCopyOf = Arrays.copyOf(cArr, cArr.length);
        Intrinsics.checkNotNullExpressionValue(cArrCopyOf, "copyOf(...)");
        ArraysKt___ArraysJvmKt.sort(cArrCopyOf);
        return cArrCopyOf;
    }

    public static final char[] sortedArrayDescending(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (cArr.length == 0) {
            return cArr;
        }
        char[] cArrCopyOf = Arrays.copyOf(cArr, cArr.length);
        Intrinsics.checkNotNullExpressionValue(cArrCopyOf, "copyOf(...)");
        sortDescending(cArrCopyOf);
        return cArrCopyOf;
    }

    public static final Set<Boolean> subtract(boolean[] zArr, Iterable<Boolean> other) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Boolean> mutableSet = toMutableSet(zArr);
        CollectionsKt__MutableCollectionsKt.removeAll(mutableSet, other);
        return mutableSet;
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final int sumBy(boolean[] zArr, Function1<? super Boolean, Integer> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iIntValue = 0;
        for (boolean z2 : zArr) {
            iIntValue += ((Number) selector.invoke(Boolean.valueOf(z2))).intValue();
        }
        return iIntValue;
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final double sumByDouble(boolean[] zArr, Function1<? super Boolean, Double> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        double dDoubleValue = 0.0d;
        for (boolean z2 : zArr) {
            dDoubleValue += ((Number) selector.invoke(Boolean.valueOf(z2))).doubleValue();
        }
        return dDoubleValue;
    }

    private static final double sumOfDouble(boolean[] zArr, Function1<? super Boolean, Double> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        double dDoubleValue = 0.0d;
        for (boolean z2 : zArr) {
            dDoubleValue += ((Number) selector.invoke(Boolean.valueOf(z2))).doubleValue();
        }
        return dDoubleValue;
    }

    private static final int sumOfInt(boolean[] zArr, Function1<? super Boolean, Integer> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iIntValue = 0;
        for (boolean z2 : zArr) {
            iIntValue += ((Number) selector.invoke(Boolean.valueOf(z2))).intValue();
        }
        return iIntValue;
    }

    private static final long sumOfLong(boolean[] zArr, Function1<? super Boolean, Long> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        long jLongValue = 0;
        for (boolean z2 : zArr) {
            jLongValue += ((Number) selector.invoke(Boolean.valueOf(z2))).longValue();
        }
        return jLongValue;
    }

    public static final List<Short> take(short[] sArr, int i3) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        if (i3 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
        }
        if (i3 == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (i3 >= sArr.length) {
            return toList(sArr);
        }
        if (i3 == 1) {
            return CollectionsKt__CollectionsJVMKt.listOf(Short.valueOf(sArr[0]));
        }
        ArrayList arrayList = new ArrayList(i3);
        int i4 = 0;
        for (short s2 : sArr) {
            arrayList.add(Short.valueOf(s2));
            i4++;
            if (i4 == i3) {
                break;
            }
        }
        return arrayList;
    }

    public static final List<Short> takeLast(short[] sArr, int i3) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        if (i3 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
        }
        if (i3 == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        int length = sArr.length;
        if (i3 >= length) {
            return toList(sArr);
        }
        if (i3 == 1) {
            return CollectionsKt__CollectionsJVMKt.listOf(Short.valueOf(sArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i3);
        for (int i4 = length - i3; i4 < length; i4++) {
            arrayList.add(Short.valueOf(sArr[i4]));
        }
        return arrayList;
    }

    public static final <C extends Collection<? super Boolean>> C toCollection(boolean[] zArr, C destination) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        for (boolean z2 : zArr) {
            destination.add(Boolean.valueOf(z2));
        }
        return destination;
    }

    public static final Set<Boolean> union(boolean[] zArr, Iterable<Boolean> other) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Boolean> mutableSet = toMutableSet(zArr);
        CollectionsKt__MutableCollectionsKt.addAll(mutableSet, other);
        return mutableSet;
    }

    public static final boolean any(double[] dArr, Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (double d3 : dArr) {
            if (((Boolean) predicate.invoke(Double.valueOf(d3))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <V> Map<Boolean, V> associateWith(boolean[] zArr, Function1<? super Boolean, ? extends V> valueSelector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt__MapsJVMKt.mapCapacity(zArr.length), 16));
        for (boolean z2 : zArr) {
            linkedHashMap.put(Boolean.valueOf(z2), valueSelector.invoke(Boolean.valueOf(z2)));
        }
        return linkedHashMap;
    }

    public static final int count(double[] dArr, Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i3 = 0;
        for (double d3 : dArr) {
            if (((Boolean) predicate.invoke(Double.valueOf(d3))).booleanValue()) {
                i3++;
            }
        }
        return i3;
    }

    public static final List<Integer> dropWhile(int[] iArr, Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z2 = false;
        for (int i3 : iArr) {
            if (z2) {
                arrayList.add(Integer.valueOf(i3));
            } else if (!((Boolean) predicate.invoke(Integer.valueOf(i3))).booleanValue()) {
                arrayList.add(Integer.valueOf(i3));
                z2 = true;
            }
        }
        return arrayList;
    }

    public static final List<Float> filterIndexed(float[] fArr, Function2<? super Integer, ? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = fArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            float f3 = fArr[i3];
            int i5 = i4 + 1;
            if (((Boolean) predicate.invoke(Integer.valueOf(i4), Float.valueOf(f3))).booleanValue()) {
                arrayList.add(Float.valueOf(f3));
            }
            i3++;
            i4 = i5;
        }
        return arrayList;
    }

    private static final Float findLast(float[] fArr, Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = fArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i3 = length - 1;
            float f3 = fArr[length];
            if (((Boolean) predicate.invoke(Float.valueOf(f3))).booleanValue()) {
                return Float.valueOf(f3);
            }
            if (i3 < 0) {
                return null;
            }
            length = i3;
        }
    }

    public static final float first(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (fArr.length != 0) {
            return fArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final Double firstOrNull(double[] dArr, Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (double d3 : dArr) {
            if (((Boolean) predicate.invoke(Double.valueOf(d3))).booleanValue()) {
                return Double.valueOf(d3);
            }
        }
        return null;
    }

    private static final <R, C extends Collection<? super R>> C flatMapIndexedIterableTo(float[] fArr, C destination, Function2<? super Integer, ? super Float, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = fArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            CollectionsKt__MutableCollectionsKt.addAll(destination, (Iterable) transform.invoke(Integer.valueOf(i4), Float.valueOf(fArr[i3])));
            i3++;
            i4++;
        }
        return destination;
    }

    public static final <R, C extends Collection<? super R>> C flatMapTo(float[] fArr, C destination, Function1<? super Float, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (float f3 : fArr) {
            CollectionsKt__MutableCollectionsKt.addAll(destination, (Iterable) transform.invoke(Float.valueOf(f3)));
        }
        return destination;
    }

    public static final float last(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (fArr.length != 0) {
            return fArr[getLastIndex(fArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final Short lastOrNull(short[] sArr, Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = sArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i3 = length - 1;
            short s2 = sArr[length];
            if (((Boolean) predicate.invoke(Short.valueOf(s2))).booleanValue()) {
                return Short.valueOf(s2);
            }
            if (i3 < 0) {
                return null;
            }
            length = i3;
        }
    }

    public static final <R> List<R> map(float[] fArr, Function1<? super Float, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float f3 : fArr) {
            arrayList.add(transform.invoke(Float.valueOf(f3)));
        }
        return arrayList;
    }

    public static final <R> List<R> mapIndexed(float[] fArr, Function2<? super Integer, ? super Float, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(fArr.length);
        int length = fArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            arrayList.add(transform.invoke(Integer.valueOf(i4), Float.valueOf(fArr[i3])));
            i3++;
            i4++;
        }
        return arrayList;
    }

    private static final <R> R maxOfWithOrNull(int[] iArr, Comparator<? super R> comparator, Function1<? super Integer, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        R r2 = (Object) selector.invoke(Integer.valueOf(iArr[0]));
        int lastIndex = getLastIndex(iArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object obj = (Object) selector.invoke(Integer.valueOf(iArr[i3]));
                if (comparator.compare(r2, obj) < 0) {
                    r2 = (R) obj;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    private static final <R> R minOfWithOrNull(int[] iArr, Comparator<? super R> comparator, Function1<? super Integer, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        R r2 = (Object) selector.invoke(Integer.valueOf(iArr[0]));
        int lastIndex = getLastIndex(iArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object obj = (Object) selector.invoke(Integer.valueOf(iArr[i3]));
                if (comparator.compare(r2, obj) > 0) {
                    r2 = (R) obj;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    public static final boolean none(double[] dArr, Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (double d3 : dArr) {
            if (((Boolean) predicate.invoke(Double.valueOf(d3))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final short random(short[] sArr, Random random) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (sArr.length != 0) {
            return sArr[random.j(sArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final Integer randomOrNull(int[] iArr, Random random) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (iArr.length == 0) {
            return null;
        }
        return Integer.valueOf(iArr[random.j(iArr.length)]);
    }

    public static final int reduce(int[] iArr, Function2<? super Integer, ? super Integer, Integer> operation) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (iArr.length != 0) {
            int iIntValue = iArr[0];
            int lastIndex = getLastIndex(iArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    iIntValue = ((Number) operation.invoke(Integer.valueOf(iIntValue), Integer.valueOf(iArr[i3]))).intValue();
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return iIntValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final int reduceIndexed(int[] iArr, Function3<? super Integer, ? super Integer, ? super Integer, Integer> operation) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (iArr.length != 0) {
            int iIntValue = iArr[0];
            int lastIndex = getLastIndex(iArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    iIntValue = ((Number) operation.invoke(Integer.valueOf(i3), Integer.valueOf(iIntValue), Integer.valueOf(iArr[i3]))).intValue();
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return iIntValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final Long reduceRightIndexedOrNull(long[] jArr, Function3<? super Integer, ? super Long, ? super Long, Long> operation) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(jArr);
        if (lastIndex < 0) {
            return null;
        }
        long jLongValue = jArr[lastIndex];
        for (int i3 = lastIndex - 1; i3 >= 0; i3--) {
            jLongValue = ((Number) operation.invoke(Integer.valueOf(i3), Long.valueOf(jArr[i3]), Long.valueOf(jLongValue))).longValue();
        }
        return Long.valueOf(jLongValue);
    }

    public static final Long reduceRightOrNull(long[] jArr, Function2<? super Long, ? super Long, Long> operation) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(jArr);
        if (lastIndex < 0) {
            return null;
        }
        long jLongValue = jArr[lastIndex];
        for (int i3 = lastIndex - 1; i3 >= 0; i3--) {
            jLongValue = ((Number) operation.invoke(Long.valueOf(jArr[i3]), Long.valueOf(jLongValue))).longValue();
        }
        return Long.valueOf(jLongValue);
    }

    public static void reverse(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int length = (iArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int lastIndex = getLastIndex(iArr);
        if (length < 0) {
            return;
        }
        int i3 = 0;
        while (true) {
            int i4 = iArr[i3];
            iArr[i3] = iArr[lastIndex];
            iArr[lastIndex] = i4;
            lastIndex--;
            if (i3 == length) {
                return;
            } else {
                i3++;
            }
        }
    }

    public static final List<Float> reversed(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (fArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<Float> mutableList = toMutableList(fArr);
        CollectionsKt___CollectionsJvmKt.reverse(mutableList);
        return mutableList;
    }

    private static final <R> List<R> runningFold(int[] iArr, R r2, Function2<? super R, ? super Integer, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (iArr.length == 0) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(iArr.length + 1);
        arrayList.add(r2);
        for (int i3 : iArr) {
            r2 = (R) operation.invoke(r2, Integer.valueOf(i3));
            arrayList.add(r2);
        }
        return arrayList;
    }

    private static final <R> List<R> runningFoldIndexed(int[] iArr, R r2, Function3<? super Integer, ? super R, ? super Integer, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (iArr.length == 0) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(iArr.length + 1);
        arrayList.add(r2);
        int length = iArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            r2 = (R) operation.invoke(Integer.valueOf(i3), r2, Integer.valueOf(iArr[i3]));
            arrayList.add(r2);
        }
        return arrayList;
    }

    public static final float[] sliceArray(float[] fArr, Collection<Integer> indices) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        float[] fArr2 = new float[indices.size()];
        Iterator<Integer> it = indices.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            fArr2[i3] = fArr[it.next().intValue()];
            i3++;
        }
        return fArr2;
    }

    private static final int sumOfUInt(float[] fArr, Function1<? super Float, UInt> selector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iB = UInt.b(0);
        for (float f3 : fArr) {
            iB = UInt.b(iB + ((UInt) selector.invoke(Float.valueOf(f3))).f());
        }
        return iB;
    }

    private static final long sumOfULong(float[] fArr, Function1<? super Float, ULong> selector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        long jB = ULong.b(0L);
        for (float f3 : fArr) {
            jB = ULong.b(jB + ((ULong) selector.invoke(Float.valueOf(f3))).g());
        }
        return jB;
    }

    public static final List<Character> toMutableList(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        ArrayList arrayList = new ArrayList(cArr.length);
        for (char c3 : cArr) {
            arrayList.add(Character.valueOf(c3));
        }
        return arrayList;
    }

    public static final <R, V> List<V> zip(float[] fArr, R[] other, Function2<? super Float, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iMin = Math.min(fArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i3 = 0; i3 < iMin; i3++) {
            arrayList.add(transform.invoke(Float.valueOf(fArr[i3]), other[i3]));
        }
        return arrayList;
    }

    public static final boolean any(boolean[] zArr, Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (boolean z2 : zArr) {
            if (((Boolean) predicate.invoke(Boolean.valueOf(z2))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public static final Iterable<Character> asIterable(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return cArr.length == 0 ? CollectionsKt__CollectionsKt.emptyList() : new ArraysKt___ArraysKt$asIterable$$inlined$Iterable$9(cArr);
    }

    public static final Sequence<Character> asSequence(final char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return cArr.length == 0 ? SequencesKt.g() : new Sequence<Character>() { // from class: kotlin.collections.ArraysKt___ArraysKt$asSequence$$inlined$Sequence$9
            @Override // kotlin.sequences.Sequence
            public Iterator<Character> iterator() {
                return ArrayIteratorsKt.c(cArr);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> associate(long[] jArr, Function1<? super Long, ? extends Pair<? extends K, ? extends V>> transform) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt__MapsJVMKt.mapCapacity(jArr.length), 16));
        for (long j3 : jArr) {
            Pair pair = (Pair) transform.invoke(Long.valueOf(j3));
            linkedHashMap.put(pair.e(), pair.f());
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K> Map<K, Long> associateBy(long[] jArr, Function1<? super Long, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt__MapsJVMKt.mapCapacity(jArr.length), 16));
        for (long j3 : jArr) {
            linkedHashMap.put(keySelector.invoke(Long.valueOf(j3)), Long.valueOf(j3));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, M extends Map<? super K, ? super Character>> M associateByTo(char[] cArr, M destination, Function1<? super Character, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (char c3 : cArr) {
            destination.put(keySelector.invoke(Character.valueOf(c3)), Character.valueOf(c3));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(char[] cArr, M destination, Function1<? super Character, ? extends Pair<? extends K, ? extends V>> transform) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (char c3 : cArr) {
            Pair pair = (Pair) transform.invoke(Character.valueOf(c3));
            destination.put(pair.e(), pair.f());
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <V, M extends Map<? super Character, ? super V>> M associateWithTo(char[] cArr, M destination, Function1<? super Character, ? extends V> valueSelector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        for (char c3 : cArr) {
            destination.put(Character.valueOf(c3), valueSelector.invoke(Character.valueOf(c3)));
        }
        return destination;
    }

    private static final long[] copyOf(long[] jArr, int i3, Function1<? super Integer, Long> init) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(init, "init");
        if (i3 >= 0) {
            long[] jArrCopyOf = Arrays.copyOf(jArr, i3);
            Intrinsics.checkNotNullExpressionValue(jArrCopyOf, "copyOf(...)");
            for (int length = jArr.length; length < i3; length++) {
                jArrCopyOf[length] = ((Number) init.invoke(Integer.valueOf(length))).longValue();
            }
            return jArrCopyOf;
        }
        throw new IllegalArgumentException(("Invalid new array size: " + i3 + '.').toString());
    }

    public static final int count(boolean[] zArr, Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i3 = 0;
        for (boolean z2 : zArr) {
            if (((Boolean) predicate.invoke(Boolean.valueOf(z2))).booleanValue()) {
                i3++;
            }
        }
        return i3;
    }

    public static final List<Character> drop(char[] cArr, int i3) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (i3 >= 0) {
            return takeLast(cArr, RangesKt.f(cArr.length - i3, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
    }

    public static final List<Character> dropLast(char[] cArr, int i3) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (i3 >= 0) {
            return take(cArr, RangesKt.f(cArr.length - i3, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
    }

    public static final List<Long> dropLastWhile(long[] jArr, Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = getLastIndex(jArr); -1 < lastIndex; lastIndex--) {
            if (!((Boolean) predicate.invoke(Long.valueOf(jArr[lastIndex]))).booleanValue()) {
                return take(jArr, lastIndex + 1);
            }
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    public static final List<Character> filter(char[] cArr, Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (char c3 : cArr) {
            if (((Boolean) predicate.invoke(Character.valueOf(c3))).booleanValue()) {
                arrayList.add(Character.valueOf(c3));
            }
        }
        return arrayList;
    }

    public static final <C extends Collection<? super Character>> C filterIndexedTo(char[] cArr, C destination, Function2<? super Integer, ? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = cArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            char c3 = cArr[i3];
            int i5 = i4 + 1;
            if (((Boolean) predicate.invoke(Integer.valueOf(i4), Character.valueOf(c3))).booleanValue()) {
                destination.add(Character.valueOf(c3));
            }
            i3++;
            i4 = i5;
        }
        return destination;
    }

    public static final List<Character> filterNot(char[] cArr, Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (char c3 : cArr) {
            if (!((Boolean) predicate.invoke(Character.valueOf(c3))).booleanValue()) {
                arrayList.add(Character.valueOf(c3));
            }
        }
        return arrayList;
    }

    public static final Boolean firstOrNull(boolean[] zArr, Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (boolean z2 : zArr) {
            if (((Boolean) predicate.invoke(Boolean.valueOf(z2))).booleanValue()) {
                return Boolean.valueOf(z2);
            }
        }
        return null;
    }

    public static final <R> List<R> flatMap(long[] jArr, Function1<? super Long, ? extends Iterable<? extends R>> function1) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(function1, pnxuebdT.cphnpJngxMMafZ);
        ArrayList arrayList = new ArrayList();
        for (long j3 : jArr) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, (Iterable) function1.invoke(Long.valueOf(j3)));
        }
        return arrayList;
    }

    public static final <R> R foldRight(char[] cArr, R r2, Function2<? super Character, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = getLastIndex(cArr); lastIndex >= 0; lastIndex--) {
            r2 = (R) operation.invoke(Character.valueOf(cArr[lastIndex]), r2);
        }
        return r2;
    }

    public static final <R> R foldRightIndexed(char[] cArr, R r2, Function3<? super Integer, ? super Character, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = getLastIndex(cArr); lastIndex >= 0; lastIndex--) {
            r2 = (R) operation.invoke(Integer.valueOf(lastIndex), Character.valueOf(cArr[lastIndex]), r2);
        }
        return r2;
    }

    public static final <K> Map<K, List<Short>> groupBy(short[] sArr, Function1<? super Short, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (short s2 : sArr) {
            Object objInvoke = keySelector.invoke(Short.valueOf(s2));
            Object arrayList = linkedHashMap.get(objInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(objInvoke, arrayList);
            }
            ((List) arrayList).add(Short.valueOf(s2));
        }
        return linkedHashMap;
    }

    public static final int indexOf(boolean[] zArr, boolean z2) {
        Intrinsics.checkNotNullParameter(zArr, sECyKyO.HVEkTneihtcJD);
        int length = zArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (z2 == zArr[i3]) {
                return i3;
            }
        }
        return -1;
    }

    public static final int indexOfFirst(char[] cArr, Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = cArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (((Boolean) predicate.invoke(Character.valueOf(cArr[i3]))).booleanValue()) {
                return i3;
            }
        }
        return -1;
    }

    public static final int indexOfLast(char[] cArr, Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = cArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i3 = length - 1;
                if (((Boolean) predicate.invoke(Character.valueOf(cArr[length]))).booleanValue()) {
                    return length;
                }
                if (i3 < 0) {
                    break;
                }
                length = i3;
            }
        }
        return -1;
    }

    public static final Set<Character> intersect(char[] cArr, Iterable<Character> other) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Character> mutableSet = toMutableSet(cArr);
        CollectionsKt__MutableCollectionsKt.retainAll(mutableSet, other);
        return mutableSet;
    }

    public static final int lastIndexOf(boolean[] zArr, boolean z2) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        int length = zArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i3 = length - 1;
                if (z2 == zArr[length]) {
                    return length;
                }
                if (i3 < 0) {
                    break;
                }
                length = i3;
            }
        }
        return -1;
    }

    public static final <R, C extends Collection<? super R>> C mapIndexedTo(char[] cArr, C destination, Function2<? super Integer, ? super Character, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = cArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            destination.add(transform.invoke(Integer.valueOf(i4), Character.valueOf(cArr[i3])));
            i3++;
            i4++;
        }
        return destination;
    }

    public static final <R, C extends Collection<? super R>> C mapTo(char[] cArr, C destination, Function1<? super Character, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (char c3 : cArr) {
            destination.add(transform.invoke(Character.valueOf(c3)));
        }
        return destination;
    }

    public static final <R extends Comparable<? super R>> Short maxByOrNull(short[] sArr, Function1<? super Short, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        short s2 = sArr[0];
        int lastIndex = getLastIndex(sArr);
        if (lastIndex == 0) {
            return Short.valueOf(s2);
        }
        Comparable comparable = (Comparable) selector.invoke(Short.valueOf(s2));
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                short s3 = sArr[i3];
                Comparable comparable2 = (Comparable) selector.invoke(Short.valueOf(s3));
                if (comparable.compareTo(comparable2) < 0) {
                    s2 = s3;
                    comparable = comparable2;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Short.valueOf(s2);
    }

    public static final <R extends Comparable<? super R>> short maxByOrThrow(short[] sArr, Function1<? super Short, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (sArr.length != 0) {
            short s2 = sArr[0];
            int lastIndex = getLastIndex(sArr);
            if (lastIndex != 0) {
                Comparable comparable = (Comparable) selector.invoke(Short.valueOf(s2));
                int i3 = 1;
                if (1 <= lastIndex) {
                    while (true) {
                        short s3 = sArr[i3];
                        Comparable comparable2 = (Comparable) selector.invoke(Short.valueOf(s3));
                        if (comparable.compareTo(comparable2) < 0) {
                            s2 = s3;
                            comparable = comparable2;
                        }
                        if (i3 == lastIndex) {
                            break;
                        }
                        i3++;
                    }
                }
            }
            return s2;
        }
        throw new NoSuchElementException();
    }

    public static final <R extends Comparable<? super R>> Short minByOrNull(short[] sArr, Function1<? super Short, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        short s2 = sArr[0];
        int lastIndex = getLastIndex(sArr);
        if (lastIndex == 0) {
            return Short.valueOf(s2);
        }
        Comparable comparable = (Comparable) selector.invoke(Short.valueOf(s2));
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                short s3 = sArr[i3];
                Comparable comparable2 = (Comparable) selector.invoke(Short.valueOf(s3));
                if (comparable.compareTo(comparable2) > 0) {
                    s2 = s3;
                    comparable = comparable2;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Short.valueOf(s2);
    }

    public static final <R extends Comparable<? super R>> short minByOrThrow(short[] sArr, Function1<? super Short, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (sArr.length != 0) {
            short s2 = sArr[0];
            int lastIndex = getLastIndex(sArr);
            if (lastIndex != 0) {
                Comparable comparable = (Comparable) selector.invoke(Short.valueOf(s2));
                int i3 = 1;
                if (1 <= lastIndex) {
                    while (true) {
                        short s3 = sArr[i3];
                        Comparable comparable2 = (Comparable) selector.invoke(Short.valueOf(s3));
                        if (comparable.compareTo(comparable2) > 0) {
                            s2 = s3;
                            comparable = comparable2;
                        }
                        if (i3 == lastIndex) {
                            break;
                        }
                        i3++;
                    }
                }
            }
            return s2;
        }
        throw new NoSuchElementException();
    }

    public static final boolean none(boolean[] zArr, Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (boolean z2 : zArr) {
            if (((Boolean) predicate.invoke(Boolean.valueOf(z2))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final long reduceRight(long[] jArr, Function2<? super Long, ? super Long, Long> operation) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(jArr);
        if (lastIndex >= 0) {
            long jLongValue = jArr[lastIndex];
            for (int i3 = lastIndex - 1; i3 >= 0; i3--) {
                jLongValue = ((Number) operation.invoke(Long.valueOf(jArr[i3]), Long.valueOf(jLongValue))).longValue();
            }
            return jLongValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final long reduceRightIndexed(long[] jArr, Function3<? super Integer, ? super Long, ? super Long, Long> operation) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(jArr);
        if (lastIndex >= 0) {
            long jLongValue = jArr[lastIndex];
            for (int i3 = lastIndex - 1; i3 >= 0; i3--) {
                jLongValue = ((Number) operation.invoke(Integer.valueOf(i3), Long.valueOf(jArr[i3]), Long.valueOf(jLongValue))).longValue();
            }
            return jLongValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static long[] reversedArray(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        if (jArr.length == 0) {
            return jArr;
        }
        long[] jArr2 = new long[jArr.length];
        int lastIndex = getLastIndex(jArr);
        if (lastIndex >= 0) {
            int i3 = 0;
            while (true) {
                jArr2[lastIndex - i3] = jArr[i3];
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return jArr2;
    }

    public static long single(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        int length = jArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return jArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static final List<Character> slice(char[] cArr, IntRange indices) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? CollectionsKt__CollectionsKt.emptyList() : ArraysKt___ArraysJvmKt.asList(ArraysKt___ArraysJvmKt.copyOfRange(cArr, indices.a().intValue(), indices.e().intValue() + 1));
    }

    public static final void sortDescending(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (dArr.length > 1) {
            ArraysKt___ArraysJvmKt.sort(dArr);
            reverse(dArr);
        }
    }

    public static final Set<Character> subtract(char[] cArr, Iterable<Character> other) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Character> mutableSet = toMutableSet(cArr);
        CollectionsKt__MutableCollectionsKt.removeAll(mutableSet, other);
        return mutableSet;
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final int sumBy(char[] cArr, Function1<? super Character, Integer> selector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iIntValue = 0;
        for (char c3 : cArr) {
            iIntValue += ((Number) selector.invoke(Character.valueOf(c3))).intValue();
        }
        return iIntValue;
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final double sumByDouble(char[] cArr, Function1<? super Character, Double> selector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        double dDoubleValue = 0.0d;
        for (char c3 : cArr) {
            dDoubleValue += ((Number) selector.invoke(Character.valueOf(c3))).doubleValue();
        }
        return dDoubleValue;
    }

    private static final double sumOfDouble(char[] cArr, Function1<? super Character, Double> selector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        double dDoubleValue = 0.0d;
        for (char c3 : cArr) {
            dDoubleValue += ((Number) selector.invoke(Character.valueOf(c3))).doubleValue();
        }
        return dDoubleValue;
    }

    private static final int sumOfInt(char[] cArr, Function1<? super Character, Integer> selector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iIntValue = 0;
        for (char c3 : cArr) {
            iIntValue += ((Number) selector.invoke(Character.valueOf(c3))).intValue();
        }
        return iIntValue;
    }

    private static final long sumOfLong(char[] cArr, Function1<? super Character, Long> selector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        long jLongValue = 0;
        for (char c3 : cArr) {
            jLongValue += ((Number) selector.invoke(Character.valueOf(c3))).longValue();
        }
        return jLongValue;
    }

    public static final List<Long> takeLastWhile(long[] jArr, Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = getLastIndex(jArr); -1 < lastIndex; lastIndex--) {
            if (!((Boolean) predicate.invoke(Long.valueOf(jArr[lastIndex]))).booleanValue()) {
                return drop(jArr, lastIndex + 1);
            }
        }
        return toList(jArr);
    }

    public static final List<Long> takeWhile(long[] jArr, Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (long j3 : jArr) {
            if (!((Boolean) predicate.invoke(Long.valueOf(j3))).booleanValue()) {
                break;
            }
            arrayList.add(Long.valueOf(j3));
        }
        return arrayList;
    }

    public static final <C extends Collection<? super Character>> C toCollection(char[] cArr, C destination) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        for (char c3 : cArr) {
            destination.add(Character.valueOf(c3));
        }
        return destination;
    }

    public static List<Long> toList(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        int length = jArr.length;
        if (length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (length != 1) {
            return toMutableList(jArr);
        }
        return CollectionsKt__CollectionsJVMKt.listOf(Long.valueOf(jArr[0]));
    }

    public static Set<Long> toSet(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        int length = jArr.length;
        if (length == 0) {
            return SetsKt__SetsKt.emptySet();
        }
        if (length != 1) {
            return (Set) toCollection(jArr, new LinkedHashSet(MapsKt__MapsJVMKt.mapCapacity(jArr.length)));
        }
        return SetsKt__SetsJVMKt.setOf(Long.valueOf(jArr[0]));
    }

    public static final Set<Character> union(char[] cArr, Iterable<Character> other) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Character> mutableSet = toMutableSet(cArr);
        CollectionsKt__MutableCollectionsKt.addAll(mutableSet, other);
        return mutableSet;
    }

    public static final boolean any(char[] cArr, Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (char c3 : cArr) {
            if (((Boolean) predicate.invoke(Character.valueOf(c3))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <V> Map<Character, V> associateWith(char[] cArr, Function1<? super Character, ? extends V> valueSelector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt__MapsJVMKt.mapCapacity(RangesKt.k(cArr.length, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD)), 16));
        for (char c3 : cArr) {
            linkedHashMap.put(Character.valueOf(c3), valueSelector.invoke(Character.valueOf(c3)));
        }
        return linkedHashMap;
    }

    public static final int count(char[] cArr, Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i3 = 0;
        for (char c3 : cArr) {
            if (((Boolean) predicate.invoke(Character.valueOf(c3))).booleanValue()) {
                i3++;
            }
        }
        return i3;
    }

    public static final Character firstOrNull(char[] cArr, Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (char c3 : cArr) {
            if (((Boolean) predicate.invoke(Character.valueOf(c3))).booleanValue()) {
                return Character.valueOf(c3);
            }
        }
        return null;
    }

    public static final Byte maxOrNull(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (bArr.length == 0) {
            return null;
        }
        byte b3 = bArr[0];
        int lastIndex = getLastIndex(bArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte b4 = bArr[i3];
                if (b3 < b4) {
                    b3 = b4;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Byte.valueOf(b3);
    }

    public static final Integer maxWithOrNull(int[] iArr, Comparator<? super Integer> comparator) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (iArr.length == 0) {
            return null;
        }
        int i3 = iArr[0];
        int lastIndex = getLastIndex(iArr);
        int i4 = 1;
        if (1 <= lastIndex) {
            while (true) {
                int i5 = iArr[i4];
                if (comparator.compare(Integer.valueOf(i3), Integer.valueOf(i5)) < 0) {
                    i3 = i5;
                }
                if (i4 == lastIndex) {
                    break;
                }
                i4++;
            }
        }
        return Integer.valueOf(i3);
    }

    public static final Byte minOrNull(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (bArr.length == 0) {
            return null;
        }
        byte b3 = bArr[0];
        int lastIndex = getLastIndex(bArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte b4 = bArr[i3];
                if (b3 > b4) {
                    b3 = b4;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Byte.valueOf(b3);
    }

    public static final Integer minWithOrNull(int[] iArr, Comparator<? super Integer> comparator) {
        Intrinsics.checkNotNullParameter(iArr, pnxuebdT.eEZa);
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (iArr.length == 0) {
            return null;
        }
        int i3 = iArr[0];
        int lastIndex = getLastIndex(iArr);
        int i4 = 1;
        if (1 <= lastIndex) {
            while (true) {
                int i5 = iArr[i4];
                if (comparator.compare(Integer.valueOf(i3), Integer.valueOf(i5)) > 0) {
                    i3 = i5;
                }
                if (i4 == lastIndex) {
                    break;
                }
                i4++;
            }
        }
        return Integer.valueOf(i3);
    }

    public static final boolean none(char[] cArr, Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (char c3 : cArr) {
            if (((Boolean) predicate.invoke(Character.valueOf(c3))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final Long randomOrNull(long[] jArr, Random random) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (jArr.length == 0) {
            return null;
        }
        return Long.valueOf(jArr[random.j(jArr.length)]);
    }

    public static final Integer singleOrNull(int[] iArr, Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Integer numValueOf = null;
        boolean z2 = false;
        for (int i3 : iArr) {
            if (((Boolean) predicate.invoke(Integer.valueOf(i3))).booleanValue()) {
                if (z2) {
                    return null;
                }
                numValueOf = Integer.valueOf(i3);
                z2 = true;
            }
        }
        if (z2) {
            return numValueOf;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K, V, M extends Map<? super K, ? super V>> M associateByTo(T[] tArr, M destination, Function1<? super T, ? extends K> keySelector, Function1<? super T, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (T t2 : tArr) {
            destination.put(keySelector.invoke(t2), valueTransform.invoke(t2));
        }
        return destination;
    }

    public static final <K> List<Integer> distinctBy(int[] iArr, Function1<? super Integer, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(function1, YvFRmou.ZUuqLXhLDIyyAKT);
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (int i3 : iArr) {
            if (hashSet.add(function1.invoke(Integer.valueOf(i3)))) {
                arrayList.add(Integer.valueOf(i3));
            }
        }
        return arrayList;
    }

    public static final List<Double> filterIndexed(double[] dArr, Function2<? super Integer, ? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = dArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            double d3 = dArr[i3];
            int i5 = i4 + 1;
            if (((Boolean) predicate.invoke(Integer.valueOf(i4), Double.valueOf(d3))).booleanValue()) {
                arrayList.add(Double.valueOf(d3));
            }
            i3++;
            i4 = i5;
        }
        return arrayList;
    }

    private static final Double findLast(double[] dArr, Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = dArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i3 = length - 1;
            double d3 = dArr[length];
            if (((Boolean) predicate.invoke(Double.valueOf(d3))).booleanValue()) {
                return Double.valueOf(d3);
            }
            if (i3 < 0) {
                return null;
            }
            length = i3;
        }
    }

    public static final double first(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (dArr.length != 0) {
            return dArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    private static final <R, C extends Collection<? super R>> C flatMapIndexedIterableTo(double[] dArr, C destination, Function2<? super Integer, ? super Double, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = dArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            CollectionsKt__MutableCollectionsKt.addAll(destination, (Iterable) transform.invoke(Integer.valueOf(i4), Double.valueOf(dArr[i3])));
            i3++;
            i4++;
        }
        return destination;
    }

    public static final <R, C extends Collection<? super R>> C flatMapTo(double[] dArr, C destination, Function1<? super Double, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (double d3 : dArr) {
            CollectionsKt__MutableCollectionsKt.addAll(destination, (Iterable) transform.invoke(Double.valueOf(d3)));
        }
        return destination;
    }

    public static final int indexOf(char[] cArr, char c3) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        int length = cArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (c3 == cArr[i3]) {
                return i3;
            }
        }
        return -1;
    }

    public static final double last(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (dArr.length != 0) {
            return dArr[getLastIndex(dArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final int lastIndexOf(char[] cArr, char c3) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        int length = cArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i3 = length - 1;
                if (c3 == cArr[length]) {
                    return length;
                }
                if (i3 < 0) {
                    break;
                }
                length = i3;
            }
        }
        return -1;
    }

    public static final Integer lastOrNull(int[] iArr, Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = iArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i3 = length - 1;
            int i4 = iArr[length];
            if (((Boolean) predicate.invoke(Integer.valueOf(i4))).booleanValue()) {
                return Integer.valueOf(i4);
            }
            if (i3 < 0) {
                return null;
            }
            length = i3;
        }
    }

    public static final <R> List<R> map(double[] dArr, Function1<? super Double, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(dArr.length);
        for (double d3 : dArr) {
            arrayList.add(transform.invoke(Double.valueOf(d3)));
        }
        return arrayList;
    }

    public static final <R> List<R> mapIndexed(double[] dArr, Function2<? super Integer, ? super Double, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(dArr.length);
        int length = dArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            arrayList.add(transform.invoke(Integer.valueOf(i4), Double.valueOf(dArr[i3])));
            i3++;
            i4++;
        }
        return arrayList;
    }

    private static final double maxOf(int[] iArr, Function1<? super Integer, Double> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (iArr.length != 0) {
            double dDoubleValue = ((Number) selector.invoke(Integer.valueOf(iArr[0]))).doubleValue();
            int lastIndex = getLastIndex(iArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    dDoubleValue = Math.max(dDoubleValue, ((Number) selector.invoke(Integer.valueOf(iArr[i3]))).doubleValue());
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return dDoubleValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final Double m1397maxOfOrNull(int[] iArr, Function1<? super Integer, Double> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        double dDoubleValue = ((Number) selector.invoke(Integer.valueOf(iArr[0]))).doubleValue();
        int lastIndex = getLastIndex(iArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.max(dDoubleValue, ((Number) selector.invoke(Integer.valueOf(iArr[i3]))).doubleValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    private static final <R> R maxOfWith(int[] iArr, Comparator<? super R> comparator, Function1<? super Integer, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (iArr.length != 0) {
            R r2 = (Object) selector.invoke(Integer.valueOf(iArr[0]));
            int lastIndex = getLastIndex(iArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Object obj = (Object) selector.invoke(Integer.valueOf(iArr[i3]));
                    if (comparator.compare(r2, obj) < 0) {
                        r2 = (R) obj;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return r2;
        }
        throw new NoSuchElementException();
    }

    public static final byte maxOrThrow(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (bArr.length != 0) {
            byte b3 = bArr[0];
            int lastIndex = getLastIndex(bArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    byte b4 = bArr[i3];
                    if (b3 < b4) {
                        b3 = b4;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return b3;
        }
        throw new NoSuchElementException();
    }

    public static final int maxWithOrThrow(int[] iArr, Comparator<? super Integer> comparator) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (iArr.length != 0) {
            int i3 = iArr[0];
            int lastIndex = getLastIndex(iArr);
            int i4 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    int i5 = iArr[i4];
                    if (comparator.compare(Integer.valueOf(i3), Integer.valueOf(i5)) < 0) {
                        i3 = i5;
                    }
                    if (i4 == lastIndex) {
                        break;
                    }
                    i4++;
                }
            }
            return i3;
        }
        throw new NoSuchElementException();
    }

    private static final double minOf(int[] iArr, Function1<? super Integer, Double> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (iArr.length != 0) {
            double dDoubleValue = ((Number) selector.invoke(Integer.valueOf(iArr[0]))).doubleValue();
            int lastIndex = getLastIndex(iArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    dDoubleValue = Math.min(dDoubleValue, ((Number) selector.invoke(Integer.valueOf(iArr[i3]))).doubleValue());
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return dDoubleValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOfOrNull, reason: collision with other method in class */
    private static final Double m1433minOfOrNull(int[] iArr, Function1<? super Integer, Double> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        double dDoubleValue = ((Number) selector.invoke(Integer.valueOf(iArr[0]))).doubleValue();
        int lastIndex = getLastIndex(iArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.min(dDoubleValue, ((Number) selector.invoke(Integer.valueOf(iArr[i3]))).doubleValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    private static final <R> R minOfWith(int[] iArr, Comparator<? super R> comparator, Function1<? super Integer, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (iArr.length != 0) {
            R r2 = (Object) selector.invoke(Integer.valueOf(iArr[0]));
            int lastIndex = getLastIndex(iArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Object obj = (Object) selector.invoke(Integer.valueOf(iArr[i3]));
                    if (comparator.compare(r2, obj) > 0) {
                        r2 = (R) obj;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return r2;
        }
        throw new NoSuchElementException();
    }

    public static final byte minOrThrow(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (bArr.length != 0) {
            byte b3 = bArr[0];
            int lastIndex = getLastIndex(bArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    byte b4 = bArr[i3];
                    if (b3 > b4) {
                        b3 = b4;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return b3;
        }
        throw new NoSuchElementException();
    }

    public static final int minWithOrThrow(int[] iArr, Comparator<? super Integer> comparator) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (iArr.length != 0) {
            int i3 = iArr[0];
            int lastIndex = getLastIndex(iArr);
            int i4 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    int i5 = iArr[i4];
                    if (comparator.compare(Integer.valueOf(i3), Integer.valueOf(i5)) > 0) {
                        i3 = i5;
                    }
                    if (i4 == lastIndex) {
                        break;
                    }
                    i4++;
                }
            }
            return i3;
        }
        throw new NoSuchElementException();
    }

    public static final int random(int[] iArr, Random random) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (iArr.length != 0) {
            return iArr[random.j(iArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final List<Double> reversed(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (dArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<Double> mutableList = toMutableList(dArr);
        CollectionsKt___CollectionsJvmKt.reverse(mutableList);
        return mutableList;
    }

    private static final List<Integer> runningReduce(int[] iArr, Function2<? super Integer, ? super Integer, Integer> operation) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (iArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        int iIntValue = iArr[0];
        ArrayList arrayList = new ArrayList(iArr.length);
        arrayList.add(Integer.valueOf(iIntValue));
        int length = iArr.length;
        for (int i3 = 1; i3 < length; i3++) {
            iIntValue = ((Number) operation.invoke(Integer.valueOf(iIntValue), Integer.valueOf(iArr[i3]))).intValue();
            arrayList.add(Integer.valueOf(iIntValue));
        }
        return arrayList;
    }

    private static final List<Integer> runningReduceIndexed(int[] iArr, Function3<? super Integer, ? super Integer, ? super Integer, Integer> operation) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (iArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        int iIntValue = iArr[0];
        ArrayList arrayList = new ArrayList(iArr.length);
        arrayList.add(Integer.valueOf(iIntValue));
        int length = iArr.length;
        for (int i3 = 1; i3 < length; i3++) {
            iIntValue = ((Number) operation.invoke(Integer.valueOf(i3), Integer.valueOf(iIntValue), Integer.valueOf(iArr[i3]))).intValue();
            arrayList.add(Integer.valueOf(iIntValue));
        }
        return arrayList;
    }

    public static final <T> List<T> slice(T[] tArr, Iterable<Integer> indices) {
        Intrinsics.checkNotNullParameter(tArr, sECyKyO.FIDtoXlhefjbZMx);
        Intrinsics.checkNotNullParameter(indices, "indices");
        int iCollectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(indices, 10);
        if (iCollectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(tArr[it.next().intValue()]);
        }
        return arrayList;
    }

    public static final double[] sliceArray(double[] dArr, Collection<Integer> indices) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        double[] dArr2 = new double[indices.size()];
        Iterator<Integer> it = indices.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            dArr2[i3] = dArr[it.next().intValue()];
            i3++;
        }
        return dArr2;
    }

    public static final double sumOfDouble(Double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        double dDoubleValue = 0.0d;
        for (Double d3 : dArr) {
            dDoubleValue += d3.doubleValue();
        }
        return dDoubleValue;
    }

    public static final int sumOfInt(Integer[] numArr) {
        Intrinsics.checkNotNullParameter(numArr, "<this>");
        int iIntValue = 0;
        for (Integer num : numArr) {
            iIntValue += num.intValue();
        }
        return iIntValue;
    }

    public static final long sumOfLong(Long[] lArr) {
        Intrinsics.checkNotNullParameter(lArr, "<this>");
        long jLongValue = 0;
        for (Long l3 : lArr) {
            jLongValue += l3.longValue();
        }
        return jLongValue;
    }

    private static final int sumOfUInt(double[] dArr, Function1<? super Double, UInt> selector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iB = UInt.b(0);
        for (double d3 : dArr) {
            iB = UInt.b(iB + ((UInt) selector.invoke(Double.valueOf(d3))).f());
        }
        return iB;
    }

    private static final long sumOfULong(double[] dArr, Function1<? super Double, ULong> selector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        long jB = ULong.b(0L);
        for (double d3 : dArr) {
            jB = ULong.b(jB + ((ULong) selector.invoke(Double.valueOf(d3))).g());
        }
        return jB;
    }

    public static final <R, V> List<V> zip(double[] dArr, R[] other, Function2<? super Double, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iMin = Math.min(dArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i3 = 0; i3 < iMin; i3++) {
            arrayList.add(transform.invoke(Double.valueOf(dArr[i3]), other[i3]));
        }
        return arrayList;
    }

    public static final Float randomOrNull(float[] fArr, Random random) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (fArr.length == 0) {
            return null;
        }
        return Float.valueOf(fArr[random.j(fArr.length)]);
    }

    public static final Long reduceIndexedOrNull(long[] jArr, Function3<? super Integer, ? super Long, ? super Long, Long> operation) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (jArr.length == 0) {
            return null;
        }
        long jLongValue = jArr[0];
        int lastIndex = getLastIndex(jArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                jLongValue = ((Number) operation.invoke(Integer.valueOf(i3), Long.valueOf(jLongValue), Long.valueOf(jArr[i3]))).longValue();
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Long.valueOf(jLongValue);
    }

    public static final Long reduceOrNull(long[] jArr, Function2<? super Long, ? super Long, Long> operation) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (jArr.length == 0) {
            return null;
        }
        long jLongValue = jArr[0];
        int lastIndex = getLastIndex(jArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                jLongValue = ((Number) operation.invoke(Long.valueOf(jLongValue), Long.valueOf(jArr[i3]))).longValue();
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Long.valueOf(jLongValue);
    }

    public static final Float reduceRightIndexedOrNull(float[] fArr, Function3<? super Integer, ? super Float, ? super Float, Float> operation) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(fArr);
        if (lastIndex < 0) {
            return null;
        }
        float fFloatValue = fArr[lastIndex];
        for (int i3 = lastIndex - 1; i3 >= 0; i3--) {
            fFloatValue = ((Number) operation.invoke(Integer.valueOf(i3), Float.valueOf(fArr[i3]), Float.valueOf(fFloatValue))).floatValue();
        }
        return Float.valueOf(fFloatValue);
    }

    public static final Float reduceRightOrNull(float[] fArr, Function2<? super Float, ? super Float, Float> operation) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(fArr);
        if (lastIndex < 0) {
            return null;
        }
        float fFloatValue = fArr[lastIndex];
        for (int i3 = lastIndex - 1; i3 >= 0; i3--) {
            fFloatValue = ((Number) operation.invoke(Float.valueOf(fArr[i3]), Float.valueOf(fFloatValue))).floatValue();
        }
        return Float.valueOf(fFloatValue);
    }

    public static final void shuffle(short[] sArr, Random random) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = getLastIndex(sArr); lastIndex > 0; lastIndex--) {
            int iJ = random.j(lastIndex + 1);
            short s2 = sArr[lastIndex];
            sArr[lastIndex] = sArr[iJ];
            sArr[iJ] = s2;
        }
    }

    public static final void sortDescending(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (cArr.length > 1) {
            ArraysKt___ArraysJvmKt.sort(cArr);
            reverse(cArr);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> associate(float[] fArr, Function1<? super Float, ? extends Pair<? extends K, ? extends V>> transform) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt__MapsJVMKt.mapCapacity(fArr.length), 16));
        for (float f3 : fArr) {
            Pair pair = (Pair) transform.invoke(Float.valueOf(f3));
            linkedHashMap.put(pair.e(), pair.f());
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K> Map<K, Float> associateBy(float[] fArr, Function1<? super Float, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt__MapsJVMKt.mapCapacity(fArr.length), 16));
        for (float f3 : fArr) {
            linkedHashMap.put(keySelector.invoke(Float.valueOf(f3)), Float.valueOf(f3));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(byte[] bArr, M destination, Function1<? super Byte, ? extends K> keySelector, Function1<? super Byte, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (byte b3 : bArr) {
            destination.put(keySelector.invoke(Byte.valueOf(b3)), valueTransform.invoke(Byte.valueOf(b3)));
        }
        return destination;
    }

    private static final float[] copyOf(float[] fArr, int i3, Function1<? super Integer, Float> init) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(init, "init");
        if (i3 >= 0) {
            float[] fArrCopyOf = Arrays.copyOf(fArr, i3);
            Intrinsics.checkNotNullExpressionValue(fArrCopyOf, "copyOf(...)");
            for (int length = fArr.length; length < i3; length++) {
                fArrCopyOf[length] = ((Number) init.invoke(Integer.valueOf(length))).floatValue();
            }
            return fArrCopyOf;
        }
        throw new IllegalArgumentException(("Invalid new array size: " + i3 + '.').toString());
    }

    public static final List<Float> dropLastWhile(float[] fArr, Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = getLastIndex(fArr); -1 < lastIndex; lastIndex--) {
            if (!((Boolean) predicate.invoke(Float.valueOf(fArr[lastIndex]))).booleanValue()) {
                return take(fArr, lastIndex + 1);
            }
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    public static final List<Long> dropWhile(long[] jArr, Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z2 = false;
        for (long j3 : jArr) {
            if (z2) {
                arrayList.add(Long.valueOf(j3));
            } else if (!((Boolean) predicate.invoke(Long.valueOf(j3))).booleanValue()) {
                arrayList.add(Long.valueOf(j3));
                z2 = true;
            }
        }
        return arrayList;
    }

    public static final <R> List<R> flatMap(float[] fArr, Function1<? super Float, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (float f3 : fArr) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, (Iterable) transform.invoke(Float.valueOf(f3)));
        }
        return arrayList;
    }

    public static final <A extends Appendable> A joinTo(int[] iArr, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i3, CharSequence truncated, Function1<? super Integer, ? extends CharSequence> function1) throws IOException {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        buffer.append(prefix);
        int i4 = 0;
        for (int i5 : iArr) {
            i4++;
            if (i4 > 1) {
                buffer.append(separator);
            }
            if (i3 >= 0 && i4 > i3) {
                break;
            }
            if (function1 != null) {
                buffer.append((CharSequence) function1.invoke(Integer.valueOf(i5)));
            } else {
                buffer.append(String.valueOf(i5));
            }
        }
        if (i3 >= 0 && i4 > i3) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    private static final <R> R maxOfWithOrNull(long[] jArr, Comparator<? super R> comparator, Function1<? super Long, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        R r2 = (Object) selector.invoke(Long.valueOf(jArr[0]));
        int lastIndex = getLastIndex(jArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object obj = (Object) selector.invoke(Long.valueOf(jArr[i3]));
                if (comparator.compare(r2, obj) < 0) {
                    r2 = (R) obj;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    private static final <R> R minOfWithOrNull(long[] jArr, Comparator<? super R> comparator, Function1<? super Long, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        R r2 = (Object) selector.invoke(Long.valueOf(jArr[0]));
        int lastIndex = getLastIndex(jArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object obj = (Object) selector.invoke(Long.valueOf(jArr[i3]));
                if (comparator.compare(r2, obj) > 0) {
                    r2 = (R) obj;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    public static final long reduce(long[] jArr, Function2<? super Long, ? super Long, Long> operation) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (jArr.length != 0) {
            long jLongValue = jArr[0];
            int lastIndex = getLastIndex(jArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    jLongValue = ((Number) operation.invoke(Long.valueOf(jLongValue), Long.valueOf(jArr[i3]))).longValue();
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return jLongValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final long reduceIndexed(long[] jArr, Function3<? super Integer, ? super Long, ? super Long, Long> operation) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (jArr.length != 0) {
            long jLongValue = jArr[0];
            int lastIndex = getLastIndex(jArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    jLongValue = ((Number) operation.invoke(Integer.valueOf(i3), Long.valueOf(jLongValue), Long.valueOf(jArr[i3]))).longValue();
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return jLongValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final float reduceRight(float[] fArr, Function2<? super Float, ? super Float, Float> operation) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(fArr);
        if (lastIndex >= 0) {
            float fFloatValue = fArr[lastIndex];
            for (int i3 = lastIndex - 1; i3 >= 0; i3--) {
                fFloatValue = ((Number) operation.invoke(Float.valueOf(fArr[i3]), Float.valueOf(fFloatValue))).floatValue();
            }
            return fFloatValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final float reduceRightIndexed(float[] fArr, Function3<? super Integer, ? super Float, ? super Float, Float> operation) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(fArr);
        if (lastIndex >= 0) {
            float fFloatValue = fArr[lastIndex];
            for (int i3 = lastIndex - 1; i3 >= 0; i3--) {
                fFloatValue = ((Number) operation.invoke(Integer.valueOf(i3), Float.valueOf(fArr[i3]), Float.valueOf(fFloatValue))).floatValue();
            }
            return fFloatValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static void reverse(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        int length = (jArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int lastIndex = getLastIndex(jArr);
        if (length < 0) {
            return;
        }
        int i3 = 0;
        while (true) {
            long j3 = jArr[i3];
            jArr[i3] = jArr[lastIndex];
            jArr[lastIndex] = j3;
            lastIndex--;
            if (i3 == length) {
                return;
            } else {
                i3++;
            }
        }
    }

    public static final float[] reversedArray(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (fArr.length == 0) {
            return fArr;
        }
        float[] fArr2 = new float[fArr.length];
        int lastIndex = getLastIndex(fArr);
        if (lastIndex >= 0) {
            int i3 = 0;
            while (true) {
                fArr2[lastIndex - i3] = fArr[i3];
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return fArr2;
    }

    private static final <R> List<R> runningFold(long[] jArr, R r2, Function2<? super R, ? super Long, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (jArr.length == 0) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(jArr.length + 1);
        arrayList.add(r2);
        for (long j3 : jArr) {
            r2 = (R) operation.invoke(r2, Long.valueOf(j3));
            arrayList.add(r2);
        }
        return arrayList;
    }

    private static final <R> List<R> runningFoldIndexed(long[] jArr, R r2, Function3<? super Integer, ? super R, ? super Long, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (jArr.length == 0) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(jArr.length + 1);
        arrayList.add(r2);
        int length = jArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            r2 = (R) operation.invoke(Integer.valueOf(i3), r2, Long.valueOf(jArr[i3]));
            arrayList.add(r2);
        }
        return arrayList;
    }

    public static final float single(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        int length = fArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return fArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static final Long singleOrNull(long[] jArr, Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Long lValueOf = null;
        boolean z2 = false;
        for (long j3 : jArr) {
            if (((Boolean) predicate.invoke(Long.valueOf(j3))).booleanValue()) {
                if (z2) {
                    return null;
                }
                lValueOf = Long.valueOf(j3);
                z2 = true;
            }
        }
        if (z2) {
            return lValueOf;
        }
        return null;
    }

    public static final List<Float> takeLastWhile(float[] fArr, Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = getLastIndex(fArr); -1 < lastIndex; lastIndex--) {
            if (!((Boolean) predicate.invoke(Float.valueOf(fArr[lastIndex]))).booleanValue()) {
                return drop(fArr, lastIndex + 1);
            }
        }
        return toList(fArr);
    }

    public static final List<Float> takeWhile(float[] fArr, Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (float f3 : fArr) {
            if (!((Boolean) predicate.invoke(Float.valueOf(f3))).booleanValue()) {
                break;
            }
            arrayList.add(Float.valueOf(f3));
        }
        return arrayList;
    }

    public static List<Float> toList(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        int length = fArr.length;
        if (length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (length != 1) {
            return toMutableList(fArr);
        }
        return CollectionsKt__CollectionsJVMKt.listOf(Float.valueOf(fArr[0]));
    }

    public static final Set<Float> toSet(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        int length = fArr.length;
        if (length == 0) {
            return SetsKt__SetsKt.emptySet();
        }
        if (length != 1) {
            return (Set) toCollection(fArr, new LinkedHashSet(MapsKt__MapsJVMKt.mapCapacity(fArr.length)));
        }
        return SetsKt__SetsJVMKt.setOf(Float.valueOf(fArr[0]));
    }

    public static final List<Boolean> filterIndexed(boolean[] zArr, Function2<? super Integer, ? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = zArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            boolean z2 = zArr[i3];
            int i5 = i4 + 1;
            if (((Boolean) predicate.invoke(Integer.valueOf(i4), Boolean.valueOf(z2))).booleanValue()) {
                arrayList.add(Boolean.valueOf(z2));
            }
            i3++;
            i4 = i5;
        }
        return arrayList;
    }

    private static final Boolean findLast(boolean[] zArr, Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = zArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i3 = length - 1;
            boolean z2 = zArr[length];
            if (((Boolean) predicate.invoke(Boolean.valueOf(z2))).booleanValue()) {
                return Boolean.valueOf(z2);
            }
            if (i3 < 0) {
                return null;
            }
            length = i3;
        }
    }

    public static final boolean first(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        if (zArr.length != 0) {
            return zArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    private static final <R, C extends Collection<? super R>> C flatMapIndexedIterableTo(boolean[] zArr, C destination, Function2<? super Integer, ? super Boolean, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = zArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            CollectionsKt__MutableCollectionsKt.addAll(destination, (Iterable) transform.invoke(Integer.valueOf(i4), Boolean.valueOf(zArr[i3])));
            i3++;
            i4++;
        }
        return destination;
    }

    public static final <R, C extends Collection<? super R>> C flatMapTo(boolean[] zArr, C destination, Function1<? super Boolean, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (boolean z2 : zArr) {
            CollectionsKt__MutableCollectionsKt.addAll(destination, (Iterable) transform.invoke(Boolean.valueOf(z2)));
        }
        return destination;
    }

    public static final <K, M extends Map<? super K, List<Integer>>> M groupByTo(int[] iArr, M destination, Function1<? super Integer, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (int i3 : iArr) {
            Object objInvoke = keySelector.invoke(Integer.valueOf(i3));
            Object arrayList = destination.get(objInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(objInvoke, arrayList);
            }
            ((List) arrayList).add(Integer.valueOf(i3));
        }
        return destination;
    }

    public static final boolean last(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        if (zArr.length != 0) {
            return zArr[getLastIndex(zArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final Long lastOrNull(long[] jArr, Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = jArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i3 = length - 1;
            long j3 = jArr[length];
            if (((Boolean) predicate.invoke(Long.valueOf(j3))).booleanValue()) {
                return Long.valueOf(j3);
            }
            if (i3 < 0) {
                return null;
            }
            length = i3;
        }
    }

    public static final <R> List<R> map(boolean[] zArr, Function1<? super Boolean, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(zArr.length);
        for (boolean z2 : zArr) {
            arrayList.add(transform.invoke(Boolean.valueOf(z2)));
        }
        return arrayList;
    }

    public static final <R> List<R> mapIndexed(boolean[] zArr, Function2<? super Integer, ? super Boolean, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(zArr.length);
        int length = zArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            arrayList.add(transform.invoke(Integer.valueOf(i4), Boolean.valueOf(zArr[i3])));
            i3++;
            i4++;
        }
        return arrayList;
    }

    public static final Pair<List<Integer>, List<Integer>> partition(int[] iArr, Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i3 : iArr) {
            if (((Boolean) predicate.invoke(Integer.valueOf(i3))).booleanValue()) {
                arrayList.add(Integer.valueOf(i3));
            } else {
                arrayList2.add(Integer.valueOf(i3));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    public static final long random(long[] jArr, Random random) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (jArr.length != 0) {
            return jArr[random.j(jArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final Double randomOrNull(double[] dArr, Random random) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (dArr.length == 0) {
            return null;
        }
        return Double.valueOf(dArr[random.j(dArr.length)]);
    }

    public static final List<Boolean> reversed(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        if (zArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<Boolean> mutableList = toMutableList(zArr);
        CollectionsKt___CollectionsJvmKt.reverse(mutableList);
        return mutableList;
    }

    public static final boolean[] sliceArray(boolean[] zArr, Collection<Integer> indices) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        boolean[] zArr2 = new boolean[indices.size()];
        Iterator<Integer> it = indices.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            zArr2[i3] = zArr[it.next().intValue()];
            i3++;
        }
        return zArr2;
    }

    private static final int sumOfUInt(boolean[] zArr, Function1<? super Boolean, UInt> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iB = UInt.b(0);
        for (boolean z2 : zArr) {
            iB = UInt.b(iB + ((UInt) selector.invoke(Boolean.valueOf(z2))).f());
        }
        return iB;
    }

    private static final long sumOfULong(boolean[] zArr, Function1<? super Boolean, ULong> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        long jB = ULong.b(0L);
        for (boolean z2 : zArr) {
            jB = ULong.b(jB + ((ULong) selector.invoke(Boolean.valueOf(z2))).g());
        }
        return jB;
    }

    public static final List<Integer> take(int[] iArr, int i3) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (i3 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
        }
        if (i3 == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (i3 >= iArr.length) {
            return toList(iArr);
        }
        if (i3 == 1) {
            return CollectionsKt__CollectionsJVMKt.listOf(Integer.valueOf(iArr[0]));
        }
        ArrayList arrayList = new ArrayList(i3);
        int i4 = 0;
        for (int i5 : iArr) {
            arrayList.add(Integer.valueOf(i5));
            i4++;
            if (i4 == i3) {
                break;
            }
        }
        return arrayList;
    }

    public static final List<Integer> takeLast(int[] iArr, int i3) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (i3 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
        }
        if (i3 == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        int length = iArr.length;
        if (i3 >= length) {
            return toList(iArr);
        }
        if (i3 == 1) {
            return CollectionsKt__CollectionsJVMKt.listOf(Integer.valueOf(iArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i3);
        for (int i4 = length - i3; i4 < length; i4++) {
            arrayList.add(Integer.valueOf(iArr[i4]));
        }
        return arrayList;
    }

    public static final <R, V> List<V> zip(boolean[] zArr, R[] other, Function2<? super Boolean, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iMin = Math.min(zArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i3 = 0; i3 < iMin; i3++) {
            arrayList.add(transform.invoke(Boolean.valueOf(zArr[i3]), other[i3]));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(short[] sArr, M destination, Function1<? super Short, ? extends K> keySelector, Function1<? super Short, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (short s2 : sArr) {
            destination.put(keySelector.invoke(Short.valueOf(s2)), valueTransform.invoke(Short.valueOf(s2)));
        }
        return destination;
    }

    public static final Short maxOrNull(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        if (sArr.length == 0) {
            return null;
        }
        short s2 = sArr[0];
        int lastIndex = getLastIndex(sArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                short s3 = sArr[i3];
                if (s2 < s3) {
                    s2 = s3;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Short.valueOf(s2);
    }

    public static final Short minOrNull(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        if (sArr.length == 0) {
            return null;
        }
        short s2 = sArr[0];
        int lastIndex = getLastIndex(sArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                short s3 = sArr[i3];
                if (s2 > s3) {
                    s2 = s3;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Short.valueOf(s2);
    }

    public static final <T extends Comparable<? super T>> void sortDescending(T[] tArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        ArraysKt___ArraysJvmKt.sortWith(tArr, ComparisonsKt.h(), i3, i4);
    }

    public static final short maxOrThrow(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        if (sArr.length != 0) {
            short s2 = sArr[0];
            int lastIndex = getLastIndex(sArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    short s3 = sArr[i3];
                    if (s2 < s3) {
                        s2 = s3;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return s2;
        }
        throw new NoSuchElementException();
    }

    public static final Long maxWithOrNull(long[] jArr, Comparator<? super Long> comparator) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (jArr.length == 0) {
            return null;
        }
        long j3 = jArr[0];
        int lastIndex = getLastIndex(jArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                long j4 = jArr[i3];
                if (comparator.compare(Long.valueOf(j3), Long.valueOf(j4)) < 0) {
                    j3 = j4;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Long.valueOf(j3);
    }

    public static final short minOrThrow(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        if (sArr.length != 0) {
            short s2 = sArr[0];
            int lastIndex = getLastIndex(sArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    short s3 = sArr[i3];
                    if (s2 > s3) {
                        s2 = s3;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return s2;
        }
        throw new NoSuchElementException();
    }

    public static final Long minWithOrNull(long[] jArr, Comparator<? super Long> comparator) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (jArr.length == 0) {
            return null;
        }
        long j3 = jArr[0];
        int lastIndex = getLastIndex(jArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                long j4 = jArr[i3];
                if (comparator.compare(Long.valueOf(j3), Long.valueOf(j4)) > 0) {
                    j3 = j4;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Long.valueOf(j3);
    }

    public static final Boolean randomOrNull(boolean[] zArr, Random random) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (zArr.length == 0) {
            return null;
        }
        return Boolean.valueOf(zArr[random.j(zArr.length)]);
    }

    public static final Double reduceRightIndexedOrNull(double[] dArr, Function3<? super Integer, ? super Double, ? super Double, Double> operation) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(dArr);
        if (lastIndex < 0) {
            return null;
        }
        double dDoubleValue = dArr[lastIndex];
        for (int i3 = lastIndex - 1; i3 >= 0; i3--) {
            dDoubleValue = ((Number) operation.invoke(Integer.valueOf(i3), Double.valueOf(dArr[i3]), Double.valueOf(dDoubleValue))).doubleValue();
        }
        return Double.valueOf(dDoubleValue);
    }

    public static final Double reduceRightOrNull(double[] dArr, Function2<? super Double, ? super Double, Double> operation) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(dArr);
        if (lastIndex < 0) {
            return null;
        }
        double dDoubleValue = dArr[lastIndex];
        for (int i3 = lastIndex - 1; i3 >= 0; i3--) {
            dDoubleValue = ((Number) operation.invoke(Double.valueOf(dArr[i3]), Double.valueOf(dDoubleValue))).doubleValue();
        }
        return Double.valueOf(dDoubleValue);
    }

    public static final Float singleOrNull(float[] fArr, Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Float fValueOf = null;
        boolean z2 = false;
        for (float f3 : fArr) {
            if (((Boolean) predicate.invoke(Float.valueOf(f3))).booleanValue()) {
                if (z2) {
                    return null;
                }
                fValueOf = Float.valueOf(f3);
                z2 = true;
            }
        }
        if (z2) {
            return fValueOf;
        }
        return null;
    }

    public static final List<Byte> slice(byte[] bArr, Iterable<Integer> indices) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        int iCollectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(indices, 10);
        if (iCollectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(Byte.valueOf(bArr[it.next().intValue()]));
        }
        return arrayList;
    }

    public static final void sortDescending(byte[] bArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        ArraysKt___ArraysJvmKt.sort(bArr, i3, i4);
        reverse(bArr, i3, i4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> associate(double[] dArr, Function1<? super Double, ? extends Pair<? extends K, ? extends V>> transform) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt__MapsJVMKt.mapCapacity(dArr.length), 16));
        for (double d3 : dArr) {
            Pair pair = (Pair) transform.invoke(Double.valueOf(d3));
            linkedHashMap.put(pair.e(), pair.f());
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K> Map<K, Double> associateBy(double[] dArr, Function1<? super Double, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt__MapsJVMKt.mapCapacity(dArr.length), 16));
        for (double d3 : dArr) {
            linkedHashMap.put(keySelector.invoke(Double.valueOf(d3)), Double.valueOf(d3));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(int[] iArr, M destination, Function1<? super Integer, ? extends K> keySelector, Function1<? super Integer, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (int i3 : iArr) {
            destination.put(keySelector.invoke(Integer.valueOf(i3)), valueTransform.invoke(Integer.valueOf(i3)));
        }
        return destination;
    }

    private static final double[] copyOf(double[] dArr, int i3, Function1<? super Integer, Double> init) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(init, "init");
        if (i3 >= 0) {
            double[] dArrCopyOf = Arrays.copyOf(dArr, i3);
            Intrinsics.checkNotNullExpressionValue(dArrCopyOf, "copyOf(...)");
            for (int length = dArr.length; length < i3; length++) {
                dArrCopyOf[length] = ((Number) init.invoke(Integer.valueOf(length))).doubleValue();
            }
            return dArrCopyOf;
        }
        throw new IllegalArgumentException(("Invalid new array size: " + i3 + '.').toString());
    }

    public static final <K> List<Long> distinctBy(long[] jArr, Function1<? super Long, ? extends K> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (long j3 : jArr) {
            if (hashSet.add(selector.invoke(Long.valueOf(j3)))) {
                arrayList.add(Long.valueOf(j3));
            }
        }
        return arrayList;
    }

    public static final List<Double> dropLastWhile(double[] dArr, Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = getLastIndex(dArr); -1 < lastIndex; lastIndex--) {
            if (!((Boolean) predicate.invoke(Double.valueOf(dArr[lastIndex]))).booleanValue()) {
                return take(dArr, lastIndex + 1);
            }
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    public static final List<Character> filterIndexed(char[] cArr, Function2<? super Integer, ? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = cArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            char c3 = cArr[i3];
            int i5 = i4 + 1;
            if (((Boolean) predicate.invoke(Integer.valueOf(i4), Character.valueOf(c3))).booleanValue()) {
                arrayList.add(Character.valueOf(c3));
            }
            i3++;
            i4 = i5;
        }
        return arrayList;
    }

    private static final Character findLast(char[] cArr, Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = cArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i3 = length - 1;
            char c3 = cArr[length];
            if (((Boolean) predicate.invoke(Character.valueOf(c3))).booleanValue()) {
                return Character.valueOf(c3);
            }
            if (i3 < 0) {
                return null;
            }
            length = i3;
        }
    }

    public static final char first(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (cArr.length != 0) {
            return cArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final <R> List<R> flatMap(double[] dArr, Function1<? super Double, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (double d3 : dArr) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, (Iterable) transform.invoke(Double.valueOf(d3)));
        }
        return arrayList;
    }

    private static final <R, C extends Collection<? super R>> C flatMapIndexedIterableTo(char[] cArr, C destination, Function2<? super Integer, ? super Character, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = cArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            CollectionsKt__MutableCollectionsKt.addAll(destination, (Iterable) transform.invoke(Integer.valueOf(i4), Character.valueOf(cArr[i3])));
            i3++;
            i4++;
        }
        return destination;
    }

    public static final <R, C extends Collection<? super R>> C flatMapTo(char[] cArr, C destination, Function1<? super Character, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (char c3 : cArr) {
            CollectionsKt__MutableCollectionsKt.addAll(destination, (Iterable) transform.invoke(Character.valueOf(c3)));
        }
        return destination;
    }

    public static final <K> Map<K, List<Integer>> groupBy(int[] iArr, Function1<? super Integer, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i3 : iArr) {
            Object objInvoke = keySelector.invoke(Integer.valueOf(i3));
            Object arrayList = linkedHashMap.get(objInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(objInvoke, arrayList);
            }
            ((List) arrayList).add(Integer.valueOf(i3));
        }
        return linkedHashMap;
    }

    public static final char last(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (cArr.length != 0) {
            return cArr[getLastIndex(cArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final Float lastOrNull(float[] fArr, Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = fArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i3 = length - 1;
            float f3 = fArr[length];
            if (((Boolean) predicate.invoke(Float.valueOf(f3))).booleanValue()) {
                return Float.valueOf(f3);
            }
            if (i3 < 0) {
                return null;
            }
            length = i3;
        }
    }

    public static final <R> List<R> map(char[] cArr, Function1<? super Character, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(cArr.length);
        for (char c3 : cArr) {
            arrayList.add(transform.invoke(Character.valueOf(c3)));
        }
        return arrayList;
    }

    public static final <R> List<R> mapIndexed(char[] cArr, Function2<? super Integer, ? super Character, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(cArr.length);
        int length = cArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            arrayList.add(transform.invoke(Integer.valueOf(i4), Character.valueOf(cArr[i3])));
            i3++;
            i4++;
        }
        return arrayList;
    }

    public static final <R extends Comparable<? super R>> int maxByOrThrow(int[] iArr, Function1<? super Integer, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (iArr.length != 0) {
            int i3 = iArr[0];
            int lastIndex = getLastIndex(iArr);
            if (lastIndex != 0) {
                Comparable comparable = (Comparable) selector.invoke(Integer.valueOf(i3));
                int i4 = 1;
                if (1 <= lastIndex) {
                    while (true) {
                        int i5 = iArr[i4];
                        Comparable comparable2 = (Comparable) selector.invoke(Integer.valueOf(i5));
                        if (comparable.compareTo(comparable2) < 0) {
                            i3 = i5;
                            comparable = comparable2;
                        }
                        if (i4 == lastIndex) {
                            break;
                        }
                        i4++;
                    }
                }
            }
            return i3;
        }
        throw new NoSuchElementException();
    }

    private static final double maxOf(long[] jArr, Function1<? super Long, Double> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (jArr.length != 0) {
            double dDoubleValue = ((Number) selector.invoke(Long.valueOf(jArr[0]))).doubleValue();
            int lastIndex = getLastIndex(jArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    dDoubleValue = Math.max(dDoubleValue, ((Number) selector.invoke(Long.valueOf(jArr[i3]))).doubleValue());
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return dDoubleValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final Double m1398maxOfOrNull(long[] jArr, Function1<? super Long, Double> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        double dDoubleValue = ((Number) selector.invoke(Long.valueOf(jArr[0]))).doubleValue();
        int lastIndex = getLastIndex(jArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.max(dDoubleValue, ((Number) selector.invoke(Long.valueOf(jArr[i3]))).doubleValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    private static final <R> R maxOfWith(long[] jArr, Comparator<? super R> comparator, Function1<? super Long, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (jArr.length != 0) {
            R r2 = (Object) selector.invoke(Long.valueOf(jArr[0]));
            int lastIndex = getLastIndex(jArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Object obj = (Object) selector.invoke(Long.valueOf(jArr[i3]));
                    if (comparator.compare(r2, obj) < 0) {
                        r2 = (R) obj;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return r2;
        }
        throw new NoSuchElementException();
    }

    public static final long maxWithOrThrow(long[] jArr, Comparator<? super Long> comparator) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (jArr.length != 0) {
            long j3 = jArr[0];
            int lastIndex = getLastIndex(jArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    long j4 = jArr[i3];
                    if (comparator.compare(Long.valueOf(j3), Long.valueOf(j4)) < 0) {
                        j3 = j4;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return j3;
        }
        throw new NoSuchElementException();
    }

    public static final <R extends Comparable<? super R>> int minByOrThrow(int[] iArr, Function1<? super Integer, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (iArr.length != 0) {
            int i3 = iArr[0];
            int lastIndex = getLastIndex(iArr);
            if (lastIndex != 0) {
                Comparable comparable = (Comparable) selector.invoke(Integer.valueOf(i3));
                int i4 = 1;
                if (1 <= lastIndex) {
                    while (true) {
                        int i5 = iArr[i4];
                        Comparable comparable2 = (Comparable) selector.invoke(Integer.valueOf(i5));
                        if (comparable.compareTo(comparable2) > 0) {
                            i3 = i5;
                            comparable = comparable2;
                        }
                        if (i4 == lastIndex) {
                            break;
                        }
                        i4++;
                    }
                }
            }
            return i3;
        }
        throw new NoSuchElementException();
    }

    private static final double minOf(long[] jArr, Function1<? super Long, Double> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (jArr.length != 0) {
            double dDoubleValue = ((Number) selector.invoke(Long.valueOf(jArr[0]))).doubleValue();
            int lastIndex = getLastIndex(jArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    dDoubleValue = Math.min(dDoubleValue, ((Number) selector.invoke(Long.valueOf(jArr[i3]))).doubleValue());
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return dDoubleValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOfOrNull, reason: collision with other method in class */
    private static final Double m1434minOfOrNull(long[] jArr, Function1<? super Long, Double> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        double dDoubleValue = ((Number) selector.invoke(Long.valueOf(jArr[0]))).doubleValue();
        int lastIndex = getLastIndex(jArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.min(dDoubleValue, ((Number) selector.invoke(Long.valueOf(jArr[i3]))).doubleValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    private static final <R> R minOfWith(long[] jArr, Comparator<? super R> comparator, Function1<? super Long, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (jArr.length != 0) {
            R r2 = (Object) selector.invoke(Long.valueOf(jArr[0]));
            int lastIndex = getLastIndex(jArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Object obj = (Object) selector.invoke(Long.valueOf(jArr[i3]));
                    if (comparator.compare(r2, obj) > 0) {
                        r2 = (R) obj;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return r2;
        }
        throw new NoSuchElementException();
    }

    public static final long minWithOrThrow(long[] jArr, Comparator<? super Long> comparator) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (jArr.length != 0) {
            long j3 = jArr[0];
            int lastIndex = getLastIndex(jArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    long j4 = jArr[i3];
                    if (comparator.compare(Long.valueOf(j3), Long.valueOf(j4)) > 0) {
                        j3 = j4;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return j3;
        }
        throw new NoSuchElementException();
    }

    public static final float random(float[] fArr, Random random) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (fArr.length != 0) {
            return fArr[random.j(fArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final Float reduceIndexedOrNull(float[] fArr, Function3<? super Integer, ? super Float, ? super Float, Float> operation) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (fArr.length == 0) {
            return null;
        }
        float fFloatValue = fArr[0];
        int lastIndex = getLastIndex(fArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = ((Number) operation.invoke(Integer.valueOf(i3), Float.valueOf(fFloatValue), Float.valueOf(fArr[i3]))).floatValue();
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    public static final Float reduceOrNull(float[] fArr, Function2<? super Float, ? super Float, Float> operation) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (fArr.length == 0) {
            return null;
        }
        float fFloatValue = fArr[0];
        int lastIndex = getLastIndex(fArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = ((Number) operation.invoke(Float.valueOf(fFloatValue), Float.valueOf(fArr[i3]))).floatValue();
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    public static final double reduceRight(double[] dArr, Function2<? super Double, ? super Double, Double> operation) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(dArr);
        if (lastIndex >= 0) {
            double dDoubleValue = dArr[lastIndex];
            for (int i3 = lastIndex - 1; i3 >= 0; i3--) {
                dDoubleValue = ((Number) operation.invoke(Double.valueOf(dArr[i3]), Double.valueOf(dDoubleValue))).doubleValue();
            }
            return dDoubleValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final double reduceRightIndexed(double[] dArr, Function3<? super Integer, ? super Double, ? super Double, Double> operation) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(dArr);
        if (lastIndex >= 0) {
            double dDoubleValue = dArr[lastIndex];
            for (int i3 = lastIndex - 1; i3 >= 0; i3--) {
                dDoubleValue = ((Number) operation.invoke(Integer.valueOf(i3), Double.valueOf(dArr[i3]), Double.valueOf(dDoubleValue))).doubleValue();
            }
            return dDoubleValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final List<Character> reversed(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (cArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<Character> mutableList = toMutableList(cArr);
        CollectionsKt___CollectionsJvmKt.reverse(mutableList);
        return mutableList;
    }

    public static final double[] reversedArray(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (dArr.length == 0) {
            return dArr;
        }
        double[] dArr2 = new double[dArr.length];
        int lastIndex = getLastIndex(dArr);
        if (lastIndex >= 0) {
            int i3 = 0;
            while (true) {
                dArr2[lastIndex - i3] = dArr[i3];
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return dArr2;
    }

    private static final List<Long> runningReduce(long[] jArr, Function2<? super Long, ? super Long, Long> operation) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (jArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        long jLongValue = jArr[0];
        ArrayList arrayList = new ArrayList(jArr.length);
        arrayList.add(Long.valueOf(jLongValue));
        int length = jArr.length;
        for (int i3 = 1; i3 < length; i3++) {
            jLongValue = ((Number) operation.invoke(Long.valueOf(jLongValue), Long.valueOf(jArr[i3]))).longValue();
            arrayList.add(Long.valueOf(jLongValue));
        }
        return arrayList;
    }

    private static final List<Long> runningReduceIndexed(long[] jArr, Function3<? super Integer, ? super Long, ? super Long, Long> operation) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (jArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        long jLongValue = jArr[0];
        ArrayList arrayList = new ArrayList(jArr.length);
        arrayList.add(Long.valueOf(jLongValue));
        int length = jArr.length;
        for (int i3 = 1; i3 < length; i3++) {
            jLongValue = ((Number) operation.invoke(Integer.valueOf(i3), Long.valueOf(jLongValue), Long.valueOf(jArr[i3]))).longValue();
            arrayList.add(Long.valueOf(jLongValue));
        }
        return arrayList;
    }

    public static final void shuffle(int[] iArr, Random random) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = getLastIndex(iArr); lastIndex > 0; lastIndex--) {
            int iJ = random.j(lastIndex + 1);
            int i3 = iArr[lastIndex];
            iArr[lastIndex] = iArr[iJ];
            iArr[iJ] = i3;
        }
    }

    public static final double single(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        int length = dArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return dArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static final char[] sliceArray(char[] cArr, Collection<Integer> indices) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        char[] cArr2 = new char[indices.size()];
        Iterator<Integer> it = indices.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            cArr2[i3] = cArr[it.next().intValue()];
            i3++;
        }
        return cArr2;
    }

    private static final int sumOfUInt(char[] cArr, Function1<? super Character, UInt> selector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int iB = UInt.b(0);
        for (char c3 : cArr) {
            iB = UInt.b(iB + ((UInt) selector.invoke(Character.valueOf(c3))).f());
        }
        return iB;
    }

    private static final long sumOfULong(char[] cArr, Function1<? super Character, ULong> selector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        long jB = ULong.b(0L);
        for (char c3 : cArr) {
            jB = ULong.b(jB + ((ULong) selector.invoke(Character.valueOf(c3))).g());
        }
        return jB;
    }

    public static final List<Double> takeLastWhile(double[] dArr, Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = getLastIndex(dArr); -1 < lastIndex; lastIndex--) {
            if (!((Boolean) predicate.invoke(Double.valueOf(dArr[lastIndex]))).booleanValue()) {
                return drop(dArr, lastIndex + 1);
            }
        }
        return toList(dArr);
    }

    public static final List<Double> takeWhile(double[] dArr, Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (double d3 : dArr) {
            if (!((Boolean) predicate.invoke(Double.valueOf(d3))).booleanValue()) {
                break;
            }
            arrayList.add(Double.valueOf(d3));
        }
        return arrayList;
    }

    public static List<Double> toList(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        int length = dArr.length;
        if (length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (length != 1) {
            return toMutableList(dArr);
        }
        return CollectionsKt__CollectionsJVMKt.listOf(Double.valueOf(dArr[0]));
    }

    public static final Set<Double> toSet(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        int length = dArr.length;
        if (length == 0) {
            return SetsKt__SetsKt.emptySet();
        }
        if (length != 1) {
            return (Set) toCollection(dArr, new LinkedHashSet(MapsKt__MapsJVMKt.mapCapacity(dArr.length)));
        }
        return SetsKt__SetsJVMKt.setOf(Double.valueOf(dArr[0]));
    }

    public static final <R, V> List<V> zip(char[] cArr, R[] other, Function2<? super Character, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iMin = Math.min(cArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i3 = 0; i3 < iMin; i3++) {
            arrayList.add(transform.invoke(Character.valueOf(cArr[i3]), other[i3]));
        }
        return arrayList;
    }

    public static final List<Float> dropWhile(float[] fArr, Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z2 = false;
        for (float f3 : fArr) {
            if (z2) {
                arrayList.add(Float.valueOf(f3));
            } else if (!((Boolean) predicate.invoke(Float.valueOf(f3))).booleanValue()) {
                arrayList.add(Float.valueOf(f3));
                z2 = true;
            }
        }
        return arrayList;
    }

    public static final <R extends Comparable<? super R>> Integer maxByOrNull(int[] iArr, Function1<? super Integer, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        int i3 = iArr[0];
        int lastIndex = getLastIndex(iArr);
        if (lastIndex == 0) {
            return Integer.valueOf(i3);
        }
        Comparable comparable = (Comparable) selector.invoke(Integer.valueOf(i3));
        int i4 = 1;
        if (1 <= lastIndex) {
            while (true) {
                int i5 = iArr[i4];
                Comparable comparable2 = (Comparable) selector.invoke(Integer.valueOf(i5));
                if (comparable.compareTo(comparable2) < 0) {
                    i3 = i5;
                    comparable = comparable2;
                }
                if (i4 == lastIndex) {
                    break;
                }
                i4++;
            }
        }
        return Integer.valueOf(i3);
    }

    private static final <R> R maxOfWithOrNull(float[] fArr, Comparator<? super R> comparator, Function1<? super Float, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        R r2 = (Object) selector.invoke(Float.valueOf(fArr[0]));
        int lastIndex = getLastIndex(fArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object obj = (Object) selector.invoke(Float.valueOf(fArr[i3]));
                if (comparator.compare(r2, obj) < 0) {
                    r2 = (R) obj;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    public static final <R extends Comparable<? super R>> Integer minByOrNull(int[] iArr, Function1<? super Integer, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        int i3 = iArr[0];
        int lastIndex = getLastIndex(iArr);
        if (lastIndex == 0) {
            return Integer.valueOf(i3);
        }
        Comparable comparable = (Comparable) selector.invoke(Integer.valueOf(i3));
        int i4 = 1;
        if (1 <= lastIndex) {
            while (true) {
                int i5 = iArr[i4];
                Comparable comparable2 = (Comparable) selector.invoke(Integer.valueOf(i5));
                if (comparable.compareTo(comparable2) > 0) {
                    i3 = i5;
                    comparable = comparable2;
                }
                if (i4 == lastIndex) {
                    break;
                }
                i4++;
            }
        }
        return Integer.valueOf(i3);
    }

    private static final <R> R minOfWithOrNull(float[] fArr, Comparator<? super R> comparator, Function1<? super Float, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        R r2 = (Object) selector.invoke(Float.valueOf(fArr[0]));
        int lastIndex = getLastIndex(fArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object obj = (Object) selector.invoke(Float.valueOf(fArr[i3]));
                if (comparator.compare(r2, obj) > 0) {
                    r2 = (R) obj;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    public static final Character randomOrNull(char[] cArr, Random random) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (cArr.length == 0) {
            return null;
        }
        return Character.valueOf(cArr[random.j(cArr.length)]);
    }

    public static final float reduce(float[] fArr, Function2<? super Float, ? super Float, Float> operation) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (fArr.length != 0) {
            float fFloatValue = fArr[0];
            int lastIndex = getLastIndex(fArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = ((Number) operation.invoke(Float.valueOf(fFloatValue), Float.valueOf(fArr[i3]))).floatValue();
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return fFloatValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final float reduceIndexed(float[] fArr, Function3<? super Integer, ? super Float, ? super Float, Float> operation) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (fArr.length != 0) {
            float fFloatValue = fArr[0];
            int lastIndex = getLastIndex(fArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = ((Number) operation.invoke(Integer.valueOf(i3), Float.valueOf(fFloatValue), Float.valueOf(fArr[i3]))).floatValue();
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return fFloatValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final void reverse(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        int length = (fArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int lastIndex = getLastIndex(fArr);
        if (length < 0) {
            return;
        }
        int i3 = 0;
        while (true) {
            float f3 = fArr[i3];
            fArr[i3] = fArr[lastIndex];
            fArr[lastIndex] = f3;
            lastIndex--;
            if (i3 == length) {
                return;
            } else {
                i3++;
            }
        }
    }

    private static final <R> List<R> runningFold(float[] fArr, R r2, Function2<? super R, ? super Float, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (fArr.length == 0) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(fArr.length + 1);
        arrayList.add(r2);
        for (float f3 : fArr) {
            r2 = (R) operation.invoke(r2, Float.valueOf(f3));
            arrayList.add(r2);
        }
        return arrayList;
    }

    private static final <R> List<R> runningFoldIndexed(float[] fArr, R r2, Function3<? super Integer, ? super R, ? super Float, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (fArr.length == 0) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(fArr.length + 1);
        arrayList.add(r2);
        int length = fArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            r2 = (R) operation.invoke(Integer.valueOf(i3), r2, Float.valueOf(fArr[i3]));
            arrayList.add(r2);
        }
        return arrayList;
    }

    public static final void sortDescending(short[] sArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        ArraysKt___ArraysJvmKt.sort(sArr, i3, i4);
        reverse(sArr, i3, i4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(long[] jArr, M destination, Function1<? super Long, ? extends K> keySelector, Function1<? super Long, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (long j3 : jArr) {
            destination.put(keySelector.invoke(Long.valueOf(j3)), valueTransform.invoke(Long.valueOf(j3)));
        }
        return destination;
    }

    public static final Double singleOrNull(double[] dArr, Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Double dValueOf = null;
        boolean z2 = false;
        for (double d3 : dArr) {
            if (((Boolean) predicate.invoke(Double.valueOf(d3))).booleanValue()) {
                if (z2) {
                    return null;
                }
                dValueOf = Double.valueOf(d3);
                z2 = true;
            }
        }
        if (z2) {
            return dValueOf;
        }
        return null;
    }

    public static final <T> T first(T[] tArr, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (T t2 : tArr) {
            if (((Boolean) predicate.invoke(t2)).booleanValue()) {
                return t2;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final <A extends Appendable> A joinTo(long[] jArr, A buffer, CharSequence separator, CharSequence prefix, CharSequence charSequence, int i3, CharSequence truncated, Function1<? super Long, ? extends CharSequence> function1) throws IOException {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(charSequence, MrGIhy.BILhG);
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        buffer.append(prefix);
        int i4 = 0;
        for (long j3 : jArr) {
            i4++;
            if (i4 > 1) {
                buffer.append(separator);
            }
            if (i3 >= 0 && i4 > i3) {
                break;
            }
            if (function1 != null) {
                buffer.append((CharSequence) function1.invoke(Long.valueOf(j3)));
            } else {
                buffer.append(String.valueOf(j3));
            }
        }
        if (i3 >= 0 && i4 > i3) {
            buffer.append(truncated);
        }
        buffer.append(charSequence);
        return buffer;
    }

    public static final <T> T last(T[] tArr, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = tArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i3 = length - 1;
                T t2 = tArr[length];
                if (!((Boolean) predicate.invoke(t2)).booleanValue()) {
                    if (i3 < 0) {
                        break;
                    }
                    length = i3;
                } else {
                    return t2;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final Double lastOrNull(double[] dArr, Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = dArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i3 = length - 1;
            double d3 = dArr[length];
            if (((Boolean) predicate.invoke(Double.valueOf(d3))).booleanValue()) {
                return Double.valueOf(d3);
            }
            if (i3 < 0) {
                return null;
            }
            length = i3;
        }
    }

    public static Integer maxOrNull(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (iArr.length == 0) {
            return null;
        }
        int i3 = iArr[0];
        int lastIndex = getLastIndex(iArr);
        int i4 = 1;
        if (1 <= lastIndex) {
            while (true) {
                int i5 = iArr[i4];
                if (i3 < i5) {
                    i3 = i5;
                }
                if (i4 == lastIndex) {
                    break;
                }
                i4++;
            }
        }
        return Integer.valueOf(i3);
    }

    public static Integer minOrNull(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (iArr.length == 0) {
            return null;
        }
        int i3 = iArr[0];
        int lastIndex = getLastIndex(iArr);
        int i4 = 1;
        if (1 <= lastIndex) {
            while (true) {
                int i5 = iArr[i4];
                if (i3 > i5) {
                    i3 = i5;
                }
                if (i4 == lastIndex) {
                    break;
                }
                i4++;
            }
        }
        return Integer.valueOf(i3);
    }

    public static final double random(double[] dArr, Random random) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (dArr.length != 0) {
            return dArr[random.j(dArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final Boolean reduceRightIndexedOrNull(boolean[] zArr, Function3<? super Integer, ? super Boolean, ? super Boolean, Boolean> operation) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(zArr);
        if (lastIndex < 0) {
            return null;
        }
        boolean zBooleanValue = zArr[lastIndex];
        for (int i3 = lastIndex - 1; i3 >= 0; i3--) {
            zBooleanValue = ((Boolean) operation.invoke(Integer.valueOf(i3), Boolean.valueOf(zArr[i3]), Boolean.valueOf(zBooleanValue))).booleanValue();
        }
        return Boolean.valueOf(zBooleanValue);
    }

    public static final Boolean reduceRightOrNull(boolean[] zArr, Function2<? super Boolean, ? super Boolean, Boolean> operation) {
        Intrinsics.checkNotNullParameter(zArr, vgWWUoTKYyuC.fYe);
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(zArr);
        if (lastIndex < 0) {
            return null;
        }
        boolean zBooleanValue = zArr[lastIndex];
        for (int i3 = lastIndex - 1; i3 >= 0; i3--) {
            zBooleanValue = ((Boolean) operation.invoke(Boolean.valueOf(zArr[i3]), Boolean.valueOf(zBooleanValue))).booleanValue();
        }
        return Boolean.valueOf(zBooleanValue);
    }

    public static final <T> T[] sliceArray(T[] tArr, IntRange indices) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? (T[]) ArraysKt___ArraysJvmKt.copyOfRange(tArr, 0, 0) : (T[]) ArraysKt___ArraysJvmKt.copyOfRange(tArr, indices.a().intValue(), indices.e().intValue() + 1);
    }

    public static final void sortDescending(int[] iArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        ArraysKt___ArraysJvmKt.sort(iArr, i3, i4);
        reverse(iArr, i3, i4);
    }

    public static final <T, R, V> List<V> zip(T[] tArr, Iterable<? extends R> other, Function2<? super T, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = tArr.length;
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(other, 10), length));
        int i3 = 0;
        for (R r2 : other) {
            if (i3 >= length) {
                break;
            }
            arrayList.add(transform.invoke(tArr[i3], r2));
            i3++;
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> associate(boolean[] zArr, Function1<? super Boolean, ? extends Pair<? extends K, ? extends V>> transform) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt__MapsJVMKt.mapCapacity(zArr.length), 16));
        for (boolean z2 : zArr) {
            Pair pair = (Pair) transform.invoke(Boolean.valueOf(z2));
            linkedHashMap.put(pair.e(), pair.f());
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K> Map<K, Boolean> associateBy(boolean[] zArr, Function1<? super Boolean, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt__MapsJVMKt.mapCapacity(zArr.length), 16));
        for (boolean z2 : zArr) {
            linkedHashMap.put(keySelector.invoke(Boolean.valueOf(z2)), Boolean.valueOf(z2));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(float[] fArr, M destination, Function1<? super Float, ? extends K> keySelector, Function1<? super Float, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (float f3 : fArr) {
            destination.put(keySelector.invoke(Float.valueOf(f3)), valueTransform.invoke(Float.valueOf(f3)));
        }
        return destination;
    }

    private static final boolean[] copyOf(boolean[] zArr, int i3, Function1<? super Integer, Boolean> init) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(init, "init");
        if (i3 >= 0) {
            boolean[] zArrCopyOf = Arrays.copyOf(zArr, i3);
            Intrinsics.checkNotNullExpressionValue(zArrCopyOf, "copyOf(...)");
            for (int length = zArr.length; length < i3; length++) {
                zArrCopyOf[length] = ((Boolean) init.invoke(Integer.valueOf(length))).booleanValue();
            }
            return zArrCopyOf;
        }
        throw new IllegalArgumentException(("Invalid new array size: " + i3 + '.').toString());
    }

    public static final List<Boolean> dropLastWhile(boolean[] zArr, Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = getLastIndex(zArr); -1 < lastIndex; lastIndex--) {
            if (!((Boolean) predicate.invoke(Boolean.valueOf(zArr[lastIndex]))).booleanValue()) {
                return take(zArr, lastIndex + 1);
            }
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    public static final <R> List<R> flatMap(boolean[] zArr, Function1<? super Boolean, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (boolean z2 : zArr) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, (Iterable) transform.invoke(Boolean.valueOf(z2)));
        }
        return arrayList;
    }

    public static final <K, M extends Map<? super K, List<Long>>> M groupByTo(long[] jArr, M destination, Function1<? super Long, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (long j3 : jArr) {
            Object objInvoke = keySelector.invoke(Long.valueOf(j3));
            Object arrayList = destination.get(objInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(objInvoke, arrayList);
            }
            ((List) arrayList).add(Long.valueOf(j3));
        }
        return destination;
    }

    public static int maxOrThrow(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (iArr.length != 0) {
            int i3 = iArr[0];
            int lastIndex = getLastIndex(iArr);
            int i4 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    int i5 = iArr[i4];
                    if (i3 < i5) {
                        i3 = i5;
                    }
                    if (i4 == lastIndex) {
                        break;
                    }
                    i4++;
                }
            }
            return i3;
        }
        throw new NoSuchElementException();
    }

    public static int minOrThrow(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (iArr.length != 0) {
            int i3 = iArr[0];
            int lastIndex = getLastIndex(iArr);
            int i4 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    int i5 = iArr[i4];
                    if (i3 > i5) {
                        i3 = i5;
                    }
                    if (i4 == lastIndex) {
                        break;
                    }
                    i4++;
                }
            }
            return i3;
        }
        throw new NoSuchElementException();
    }

    public static final Pair<List<Long>, List<Long>> partition(long[] jArr, Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (long j3 : jArr) {
            if (((Boolean) predicate.invoke(Long.valueOf(j3))).booleanValue()) {
                arrayList.add(Long.valueOf(j3));
            } else {
                arrayList2.add(Long.valueOf(j3));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    public static final boolean reduceRight(boolean[] zArr, Function2<? super Boolean, ? super Boolean, Boolean> operation) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(zArr);
        if (lastIndex >= 0) {
            boolean zBooleanValue = zArr[lastIndex];
            for (int i3 = lastIndex - 1; i3 >= 0; i3--) {
                zBooleanValue = ((Boolean) operation.invoke(Boolean.valueOf(zArr[i3]), Boolean.valueOf(zBooleanValue))).booleanValue();
            }
            return zBooleanValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final boolean reduceRightIndexed(boolean[] zArr, Function3<? super Integer, ? super Boolean, ? super Boolean, Boolean> operation) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(zArr);
        if (lastIndex >= 0) {
            boolean zBooleanValue = zArr[lastIndex];
            for (int i3 = lastIndex - 1; i3 >= 0; i3--) {
                zBooleanValue = ((Boolean) operation.invoke(Integer.valueOf(i3), Boolean.valueOf(zArr[i3]), Boolean.valueOf(zBooleanValue))).booleanValue();
            }
            return zBooleanValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final boolean[] reversedArray(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        if (zArr.length == 0) {
            return zArr;
        }
        boolean[] zArr2 = new boolean[zArr.length];
        int lastIndex = getLastIndex(zArr);
        if (lastIndex >= 0) {
            int i3 = 0;
            while (true) {
                zArr2[lastIndex - i3] = zArr[i3];
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return zArr2;
    }

    public static final boolean single(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        int length = zArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return zArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static final List<Short> slice(short[] sArr, Iterable<Integer> indices) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        int iCollectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(indices, 10);
        if (iCollectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(Short.valueOf(sArr[it.next().intValue()]));
        }
        return arrayList;
    }

    public static final List<Long> take(long[] jArr, int i3) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        if (i3 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
        }
        if (i3 == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (i3 >= jArr.length) {
            return toList(jArr);
        }
        if (i3 == 1) {
            return CollectionsKt__CollectionsJVMKt.listOf(Long.valueOf(jArr[0]));
        }
        ArrayList arrayList = new ArrayList(i3);
        int i4 = 0;
        for (long j3 : jArr) {
            arrayList.add(Long.valueOf(j3));
            i4++;
            if (i4 == i3) {
                break;
            }
        }
        return arrayList;
    }

    public static final List<Long> takeLast(long[] jArr, int i3) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        if (i3 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
        }
        if (i3 == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        int length = jArr.length;
        if (i3 >= length) {
            return toList(jArr);
        }
        if (i3 == 1) {
            return CollectionsKt__CollectionsJVMKt.listOf(Long.valueOf(jArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i3);
        for (int i4 = length - i3; i4 < length; i4++) {
            arrayList.add(Long.valueOf(jArr[i4]));
        }
        return arrayList;
    }

    public static final List<Boolean> takeLastWhile(boolean[] zArr, Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = getLastIndex(zArr); -1 < lastIndex; lastIndex--) {
            if (!((Boolean) predicate.invoke(Boolean.valueOf(zArr[lastIndex]))).booleanValue()) {
                return drop(zArr, lastIndex + 1);
            }
        }
        return toList(zArr);
    }

    public static final List<Boolean> takeWhile(boolean[] zArr, Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (boolean z2 : zArr) {
            if (!((Boolean) predicate.invoke(Boolean.valueOf(z2))).booleanValue()) {
                break;
            }
            arrayList.add(Boolean.valueOf(z2));
        }
        return arrayList;
    }

    public static List<Boolean> toList(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        int length = zArr.length;
        if (length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (length != 1) {
            return toMutableList(zArr);
        }
        return CollectionsKt__CollectionsJVMKt.listOf(Boolean.valueOf(zArr[0]));
    }

    public static final Set<Boolean> toSet(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        int length = zArr.length;
        if (length == 0) {
            return SetsKt__SetsKt.emptySet();
        }
        if (length != 1) {
            return (Set) toCollection(zArr, new LinkedHashSet(MapsKt__MapsJVMKt.mapCapacity(zArr.length)));
        }
        return SetsKt__SetsJVMKt.setOf(Boolean.valueOf(zArr[0]));
    }

    public static final byte first(byte[] bArr, Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (byte b3 : bArr) {
            if (((Boolean) predicate.invoke(Byte.valueOf(b3))).booleanValue()) {
                return b3;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final Float maxWithOrNull(float[] fArr, Comparator<? super Float> comparator) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (fArr.length == 0) {
            return null;
        }
        float f3 = fArr[0];
        int lastIndex = getLastIndex(fArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                float f4 = fArr[i3];
                if (comparator.compare(Float.valueOf(f3), Float.valueOf(f4)) < 0) {
                    f3 = f4;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Float.valueOf(f3);
    }

    public static final Float minWithOrNull(float[] fArr, Comparator<? super Float> comparator) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (fArr.length == 0) {
            return null;
        }
        float f3 = fArr[0];
        int lastIndex = getLastIndex(fArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                float f4 = fArr[i3];
                if (comparator.compare(Float.valueOf(f3), Float.valueOf(f4)) > 0) {
                    f3 = f4;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Float.valueOf(f3);
    }

    public static final Double reduceIndexedOrNull(double[] dArr, Function3<? super Integer, ? super Double, ? super Double, Double> operation) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (dArr.length == 0) {
            return null;
        }
        double dDoubleValue = dArr[0];
        int lastIndex = getLastIndex(dArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = ((Number) operation.invoke(Integer.valueOf(i3), Double.valueOf(dDoubleValue), Double.valueOf(dArr[i3]))).doubleValue();
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    public static final Double reduceOrNull(double[] dArr, Function2<? super Double, ? super Double, Double> operation) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (dArr.length == 0) {
            return null;
        }
        double dDoubleValue = dArr[0];
        int lastIndex = getLastIndex(dArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = ((Number) operation.invoke(Double.valueOf(dDoubleValue), Double.valueOf(dArr[i3]))).doubleValue();
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    public static final void shuffle(long[] jArr, Random random) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = getLastIndex(jArr); lastIndex > 0; lastIndex--) {
            int iJ = random.j(lastIndex + 1);
            long j3 = jArr[lastIndex];
            jArr[lastIndex] = jArr[iJ];
            jArr[iJ] = j3;
        }
    }

    public static final Boolean singleOrNull(boolean[] zArr, Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Boolean boolValueOf = null;
        boolean z2 = false;
        for (boolean z3 : zArr) {
            if (((Boolean) predicate.invoke(Boolean.valueOf(z3))).booleanValue()) {
                if (z2) {
                    return null;
                }
                boolValueOf = Boolean.valueOf(z3);
                z2 = true;
            }
        }
        if (z2) {
            return boolValueOf;
        }
        return null;
    }

    public static byte[] sliceArray(byte[] bArr, IntRange indices) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? new byte[0] : ArraysKt___ArraysJvmKt.copyOfRange(bArr, indices.a().intValue(), indices.e().intValue() + 1);
    }

    public static final void sortDescending(long[] jArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        ArraysKt___ArraysJvmKt.sort(jArr, i3, i4);
        reverse(jArr, i3, i4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(double[] dArr, M destination, Function1<? super Double, ? extends K> keySelector, Function1<? super Double, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (double d3 : dArr) {
            destination.put(keySelector.invoke(Double.valueOf(d3)), valueTransform.invoke(Double.valueOf(d3)));
        }
        return destination;
    }

    public static final <K> List<Float> distinctBy(float[] fArr, Function1<? super Float, ? extends K> selector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (float f3 : fArr) {
            if (hashSet.add(selector.invoke(Float.valueOf(f3)))) {
                arrayList.add(Float.valueOf(f3));
            }
        }
        return arrayList;
    }

    public static final List<Double> dropWhile(double[] dArr, Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z2 = false;
        for (double d3 : dArr) {
            if (z2) {
                arrayList.add(Double.valueOf(d3));
            } else if (!((Boolean) predicate.invoke(Double.valueOf(d3))).booleanValue()) {
                arrayList.add(Double.valueOf(d3));
                z2 = true;
            }
        }
        return arrayList;
    }

    public static final Boolean lastOrNull(boolean[] zArr, Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = zArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i3 = length - 1;
            boolean z2 = zArr[length];
            if (((Boolean) predicate.invoke(Boolean.valueOf(z2))).booleanValue()) {
                return Boolean.valueOf(z2);
            }
            if (i3 < 0) {
                return null;
            }
            length = i3;
        }
    }

    private static final double maxOf(float[] fArr, Function1<? super Float, Double> selector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (fArr.length != 0) {
            double dDoubleValue = ((Number) selector.invoke(Float.valueOf(fArr[0]))).doubleValue();
            int lastIndex = getLastIndex(fArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    dDoubleValue = Math.max(dDoubleValue, ((Number) selector.invoke(Float.valueOf(fArr[i3]))).doubleValue());
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return dDoubleValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final Double m1396maxOfOrNull(float[] fArr, Function1<? super Float, Double> selector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        double dDoubleValue = ((Number) selector.invoke(Float.valueOf(fArr[0]))).doubleValue();
        int lastIndex = getLastIndex(fArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.max(dDoubleValue, ((Number) selector.invoke(Float.valueOf(fArr[i3]))).doubleValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    private static final <R> R maxOfWith(float[] fArr, Comparator<? super R> comparator, Function1<? super Float, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (fArr.length != 0) {
            R r2 = (Object) selector.invoke(Float.valueOf(fArr[0]));
            int lastIndex = getLastIndex(fArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Object obj = (Object) selector.invoke(Float.valueOf(fArr[i3]));
                    if (comparator.compare(r2, obj) < 0) {
                        r2 = (R) obj;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return r2;
        }
        throw new NoSuchElementException();
    }

    private static final <R> R maxOfWithOrNull(double[] dArr, Comparator<? super R> comparator, Function1<? super Double, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        R r2 = (Object) selector.invoke(Double.valueOf(dArr[0]));
        int lastIndex = getLastIndex(dArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object obj = (Object) selector.invoke(Double.valueOf(dArr[i3]));
                if (comparator.compare(r2, obj) < 0) {
                    r2 = (R) obj;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    public static final float maxWithOrThrow(float[] fArr, Comparator<? super Float> comparator) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (fArr.length != 0) {
            float f3 = fArr[0];
            int lastIndex = getLastIndex(fArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    float f4 = fArr[i3];
                    if (comparator.compare(Float.valueOf(f3), Float.valueOf(f4)) < 0) {
                        f3 = f4;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return f3;
        }
        throw new NoSuchElementException();
    }

    private static final double minOf(float[] fArr, Function1<? super Float, Double> selector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (fArr.length != 0) {
            double dDoubleValue = ((Number) selector.invoke(Float.valueOf(fArr[0]))).doubleValue();
            int lastIndex = getLastIndex(fArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    dDoubleValue = Math.min(dDoubleValue, ((Number) selector.invoke(Float.valueOf(fArr[i3]))).doubleValue());
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return dDoubleValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOfOrNull, reason: collision with other method in class */
    private static final Double m1432minOfOrNull(float[] fArr, Function1<? super Float, Double> selector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        double dDoubleValue = ((Number) selector.invoke(Float.valueOf(fArr[0]))).doubleValue();
        int lastIndex = getLastIndex(fArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.min(dDoubleValue, ((Number) selector.invoke(Float.valueOf(fArr[i3]))).doubleValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    private static final <R> R minOfWith(float[] fArr, Comparator<? super R> comparator, Function1<? super Float, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (fArr.length != 0) {
            R r2 = (Object) selector.invoke(Float.valueOf(fArr[0]));
            int lastIndex = getLastIndex(fArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Object obj = (Object) selector.invoke(Float.valueOf(fArr[i3]));
                    if (comparator.compare(r2, obj) > 0) {
                        r2 = (R) obj;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return r2;
        }
        throw new NoSuchElementException();
    }

    private static final <R> R minOfWithOrNull(double[] dArr, Comparator<? super R> comparator, Function1<? super Double, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        R r2 = (Object) selector.invoke(Double.valueOf(dArr[0]));
        int lastIndex = getLastIndex(dArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object obj = (Object) selector.invoke(Double.valueOf(dArr[i3]));
                if (comparator.compare(r2, obj) > 0) {
                    r2 = (R) obj;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    public static final float minWithOrThrow(float[] fArr, Comparator<? super Float> comparator) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (fArr.length != 0) {
            float f3 = fArr[0];
            int lastIndex = getLastIndex(fArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    float f4 = fArr[i3];
                    if (comparator.compare(Float.valueOf(f3), Float.valueOf(f4)) > 0) {
                        f3 = f4;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return f3;
        }
        throw new NoSuchElementException();
    }

    public static final boolean random(boolean[] zArr, Random random) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (zArr.length != 0) {
            return zArr[random.j(zArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final double reduce(double[] dArr, Function2<? super Double, ? super Double, Double> operation) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (dArr.length != 0) {
            double dDoubleValue = dArr[0];
            int lastIndex = getLastIndex(dArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    dDoubleValue = ((Number) operation.invoke(Double.valueOf(dDoubleValue), Double.valueOf(dArr[i3]))).doubleValue();
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return dDoubleValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final double reduceIndexed(double[] dArr, Function3<? super Integer, ? super Double, ? super Double, Double> operation) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (dArr.length != 0) {
            double dDoubleValue = dArr[0];
            int lastIndex = getLastIndex(dArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    dDoubleValue = ((Number) operation.invoke(Integer.valueOf(i3), Double.valueOf(dDoubleValue), Double.valueOf(dArr[i3]))).doubleValue();
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return dDoubleValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final void reverse(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        int length = (dArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int lastIndex = getLastIndex(dArr);
        if (length < 0) {
            return;
        }
        int i3 = 0;
        while (true) {
            double d3 = dArr[i3];
            dArr[i3] = dArr[lastIndex];
            dArr[lastIndex] = d3;
            lastIndex--;
            if (i3 == length) {
                return;
            } else {
                i3++;
            }
        }
    }

    private static final <R> List<R> runningFold(double[] dArr, R r2, Function2<? super R, ? super Double, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (dArr.length == 0) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(dArr.length + 1);
        arrayList.add(r2);
        for (double d3 : dArr) {
            r2 = (R) operation.invoke(r2, Double.valueOf(d3));
            arrayList.add(r2);
        }
        return arrayList;
    }

    private static final <R> List<R> runningFoldIndexed(double[] dArr, R r2, Function3<? super Integer, ? super R, ? super Double, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (dArr.length == 0) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(dArr.length + 1);
        arrayList.add(r2);
        int length = dArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            r2 = (R) operation.invoke(Integer.valueOf(i3), r2, Double.valueOf(dArr[i3]));
            arrayList.add(r2);
        }
        return arrayList;
    }

    private static final List<Float> runningReduce(float[] fArr, Function2<? super Float, ? super Float, Float> operation) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (fArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        float fFloatValue = fArr[0];
        ArrayList arrayList = new ArrayList(fArr.length);
        arrayList.add(Float.valueOf(fFloatValue));
        int length = fArr.length;
        for (int i3 = 1; i3 < length; i3++) {
            fFloatValue = ((Number) operation.invoke(Float.valueOf(fFloatValue), Float.valueOf(fArr[i3]))).floatValue();
            arrayList.add(Float.valueOf(fFloatValue));
        }
        return arrayList;
    }

    private static final List<Float> runningReduceIndexed(float[] fArr, Function3<? super Integer, ? super Float, ? super Float, Float> operation) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (fArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        float fFloatValue = fArr[0];
        ArrayList arrayList = new ArrayList(fArr.length);
        arrayList.add(Float.valueOf(fFloatValue));
        int length = fArr.length;
        for (int i3 = 1; i3 < length; i3++) {
            fFloatValue = ((Number) operation.invoke(Integer.valueOf(i3), Float.valueOf(fFloatValue), Float.valueOf(fArr[i3]))).floatValue();
            arrayList.add(Float.valueOf(fFloatValue));
        }
        return arrayList;
    }

    public static final short first(short[] sArr, Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (short s2 : sArr) {
            if (((Boolean) predicate.invoke(Short.valueOf(s2))).booleanValue()) {
                return s2;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final byte last(byte[] bArr, Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = bArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i3 = length - 1;
                byte b3 = bArr[length];
                if (!((Boolean) predicate.invoke(Byte.valueOf(b3))).booleanValue()) {
                    if (i3 < 0) {
                        break;
                    }
                    length = i3;
                } else {
                    return b3;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final Character reduceRightIndexedOrNull(char[] cArr, Function3<? super Integer, ? super Character, ? super Character, Character> operation) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(cArr);
        if (lastIndex < 0) {
            return null;
        }
        char cCharValue = cArr[lastIndex];
        for (int i3 = lastIndex - 1; i3 >= 0; i3--) {
            cCharValue = ((Character) operation.invoke(Integer.valueOf(i3), Character.valueOf(cArr[i3]), Character.valueOf(cCharValue))).charValue();
        }
        return Character.valueOf(cCharValue);
    }

    public static final Character reduceRightOrNull(char[] cArr, Function2<? super Character, ? super Character, Character> operation) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(cArr);
        if (lastIndex < 0) {
            return null;
        }
        char cCharValue = cArr[lastIndex];
        for (int i3 = lastIndex - 1; i3 >= 0; i3--) {
            cCharValue = ((Character) operation.invoke(Character.valueOf(cArr[i3]), Character.valueOf(cCharValue))).charValue();
        }
        return Character.valueOf(cCharValue);
    }

    public static short[] sliceArray(short[] sArr, IntRange indices) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? new short[0] : ArraysKt___ArraysJvmKt.copyOfRange(sArr, indices.a().intValue(), indices.e().intValue() + 1);
    }

    public static final void sortDescending(float[] fArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        ArraysKt___ArraysJvmKt.sort(fArr, i3, i4);
        reverse(fArr, i3, i4);
    }

    public static final <R, V> List<V> zip(byte[] bArr, Iterable<? extends R> other, Function2<? super Byte, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = bArr.length;
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(other, 10), length));
        int i3 = 0;
        for (R r2 : other) {
            if (i3 >= length) {
                break;
            }
            arrayList.add(transform.invoke(Byte.valueOf(bArr[i3]), r2));
            i3++;
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> associate(char[] cArr, Function1<? super Character, ? extends Pair<? extends K, ? extends V>> transform) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt__MapsJVMKt.mapCapacity(cArr.length), 16));
        for (char c3 : cArr) {
            Pair pair = (Pair) transform.invoke(Character.valueOf(c3));
            linkedHashMap.put(pair.e(), pair.f());
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K> Map<K, Character> associateBy(char[] cArr, Function1<? super Character, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt__MapsJVMKt.mapCapacity(cArr.length), 16));
        for (char c3 : cArr) {
            linkedHashMap.put(keySelector.invoke(Character.valueOf(c3)), Character.valueOf(c3));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(boolean[] zArr, M destination, Function1<? super Boolean, ? extends K> keySelector, Function1<? super Boolean, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (boolean z2 : zArr) {
            destination.put(keySelector.invoke(Boolean.valueOf(z2)), valueTransform.invoke(Boolean.valueOf(z2)));
        }
        return destination;
    }

    private static final char[] copyOf(char[] cArr, int i3, Function1<? super Integer, Character> init) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(init, "init");
        if (i3 >= 0) {
            char[] cArrCopyOf = Arrays.copyOf(cArr, i3);
            Intrinsics.checkNotNullExpressionValue(cArrCopyOf, "copyOf(...)");
            for (int length = cArr.length; length < i3; length++) {
                cArrCopyOf[length] = ((Character) init.invoke(Integer.valueOf(length))).charValue();
            }
            return cArrCopyOf;
        }
        throw new IllegalArgumentException(("Invalid new array size: " + i3 + '.').toString());
    }

    public static final List<Character> dropLastWhile(char[] cArr, Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = getLastIndex(cArr); -1 < lastIndex; lastIndex--) {
            if (!((Boolean) predicate.invoke(Character.valueOf(cArr[lastIndex]))).booleanValue()) {
                return take(cArr, lastIndex + 1);
            }
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    public static final <R> List<R> flatMap(char[] cArr, Function1<? super Character, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (char c3 : cArr) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, (Iterable) transform.invoke(Character.valueOf(c3)));
        }
        return arrayList;
    }

    public static final <K> Map<K, List<Long>> groupBy(long[] jArr, Function1<? super Long, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (long j3 : jArr) {
            Object objInvoke = keySelector.invoke(Long.valueOf(j3));
            Object arrayList = linkedHashMap.get(objInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(objInvoke, arrayList);
            }
            ((List) arrayList).add(Long.valueOf(j3));
        }
        return linkedHashMap;
    }

    public static final <R extends Comparable<? super R>> long maxByOrThrow(long[] jArr, Function1<? super Long, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (jArr.length != 0) {
            long j3 = jArr[0];
            int lastIndex = getLastIndex(jArr);
            if (lastIndex != 0) {
                Comparable comparable = (Comparable) selector.invoke(Long.valueOf(j3));
                int i3 = 1;
                if (1 <= lastIndex) {
                    while (true) {
                        long j4 = jArr[i3];
                        Comparable comparable2 = (Comparable) selector.invoke(Long.valueOf(j4));
                        if (comparable.compareTo(comparable2) < 0) {
                            j3 = j4;
                            comparable = comparable2;
                        }
                        if (i3 == lastIndex) {
                            break;
                        }
                        i3++;
                    }
                }
            }
            return j3;
        }
        throw new NoSuchElementException();
    }

    public static final Long maxOrNull(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        if (jArr.length == 0) {
            return null;
        }
        long j3 = jArr[0];
        int lastIndex = getLastIndex(jArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                long j4 = jArr[i3];
                if (j3 < j4) {
                    j3 = j4;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Long.valueOf(j3);
    }

    public static final <R extends Comparable<? super R>> long minByOrThrow(long[] jArr, Function1<? super Long, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (jArr.length != 0) {
            long j3 = jArr[0];
            int lastIndex = getLastIndex(jArr);
            if (lastIndex != 0) {
                Comparable comparable = (Comparable) selector.invoke(Long.valueOf(j3));
                int i3 = 1;
                if (1 <= lastIndex) {
                    while (true) {
                        long j4 = jArr[i3];
                        Comparable comparable2 = (Comparable) selector.invoke(Long.valueOf(j4));
                        if (comparable.compareTo(comparable2) > 0) {
                            j3 = j4;
                            comparable = comparable2;
                        }
                        if (i3 == lastIndex) {
                            break;
                        }
                        i3++;
                    }
                }
            }
            return j3;
        }
        throw new NoSuchElementException();
    }

    public static final Long minOrNull(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        if (jArr.length == 0) {
            return null;
        }
        long j3 = jArr[0];
        int lastIndex = getLastIndex(jArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                long j4 = jArr[i3];
                if (j3 > j4) {
                    j3 = j4;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Long.valueOf(j3);
    }

    public static final char reduceRight(char[] cArr, Function2<? super Character, ? super Character, Character> operation) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(cArr);
        if (lastIndex >= 0) {
            char cCharValue = cArr[lastIndex];
            for (int i3 = lastIndex - 1; i3 >= 0; i3--) {
                cCharValue = ((Character) operation.invoke(Character.valueOf(cArr[i3]), Character.valueOf(cCharValue))).charValue();
            }
            return cCharValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final char reduceRightIndexed(char[] cArr, Function3<? super Integer, ? super Character, ? super Character, Character> operation) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(cArr);
        if (lastIndex >= 0) {
            char cCharValue = cArr[lastIndex];
            for (int i3 = lastIndex - 1; i3 >= 0; i3--) {
                cCharValue = ((Character) operation.invoke(Integer.valueOf(i3), Character.valueOf(cArr[i3]), Character.valueOf(cCharValue))).charValue();
            }
            return cCharValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final char[] reversedArray(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (cArr.length == 0) {
            return cArr;
        }
        char[] cArr2 = new char[cArr.length];
        int lastIndex = getLastIndex(cArr);
        if (lastIndex >= 0) {
            int i3 = 0;
            while (true) {
                cArr2[lastIndex - i3] = cArr[i3];
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return cArr2;
    }

    public static char single(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return cArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static final Character singleOrNull(char[] cArr, Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Character chValueOf = null;
        boolean z2 = false;
        for (char c3 : cArr) {
            if (((Boolean) predicate.invoke(Character.valueOf(c3))).booleanValue()) {
                if (z2) {
                    return null;
                }
                chValueOf = Character.valueOf(c3);
                z2 = true;
            }
        }
        if (z2) {
            return chValueOf;
        }
        return null;
    }

    public static final List<Character> takeLastWhile(char[] cArr, Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = getLastIndex(cArr); -1 < lastIndex; lastIndex--) {
            if (!((Boolean) predicate.invoke(Character.valueOf(cArr[lastIndex]))).booleanValue()) {
                return drop(cArr, lastIndex + 1);
            }
        }
        return toList(cArr);
    }

    public static final List<Character> takeWhile(char[] cArr, Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (char c3 : cArr) {
            if (!((Boolean) predicate.invoke(Character.valueOf(c3))).booleanValue()) {
                break;
            }
            arrayList.add(Character.valueOf(c3));
        }
        return arrayList;
    }

    public static final List<Character> toList(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (length != 1) {
            return toMutableList(cArr);
        }
        return CollectionsKt__CollectionsJVMKt.listOf(Character.valueOf(cArr[0]));
    }

    public static final Set<Character> toSet(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            return SetsKt__SetsKt.emptySet();
        }
        if (length != 1) {
            return (Set) toCollection(cArr, new LinkedHashSet(MapsKt__MapsJVMKt.mapCapacity(RangesKt.k(cArr.length, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD))));
        }
        return SetsKt__SetsJVMKt.setOf(Character.valueOf(cArr[0]));
    }

    public static final int first(int[] iArr, Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int i3 : iArr) {
            if (((Boolean) predicate.invoke(Integer.valueOf(i3))).booleanValue()) {
                return i3;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final Character lastOrNull(char[] cArr, Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = cArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i3 = length - 1;
            char c3 = cArr[length];
            if (((Boolean) predicate.invoke(Character.valueOf(c3))).booleanValue()) {
                return Character.valueOf(c3);
            }
            if (i3 < 0) {
                return null;
            }
            length = i3;
        }
    }

    public static final long maxOrThrow(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        if (jArr.length != 0) {
            long j3 = jArr[0];
            int lastIndex = getLastIndex(jArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    long j4 = jArr[i3];
                    if (j3 < j4) {
                        j3 = j4;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return j3;
        }
        throw new NoSuchElementException();
    }

    public static final long minOrThrow(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        if (jArr.length != 0) {
            long j3 = jArr[0];
            int lastIndex = getLastIndex(jArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    long j4 = jArr[i3];
                    if (j3 > j4) {
                        j3 = j4;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return j3;
        }
        throw new NoSuchElementException();
    }

    public static final char random(char[] cArr, Random random) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (cArr.length != 0) {
            return cArr[random.j(cArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final List<Integer> slice(int[] iArr, Iterable<Integer> indices) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        int iCollectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(indices, 10);
        if (iCollectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(iArr[it.next().intValue()]));
        }
        return arrayList;
    }

    public static int[] sliceArray(int[] iArr, IntRange indices) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? new int[0] : ArraysKt___ArraysJvmKt.copyOfRange(iArr, indices.a().intValue(), indices.e().intValue() + 1);
    }

    public static final void sortDescending(double[] dArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        ArraysKt___ArraysJvmKt.sort(dArr, i3, i4);
        reverse(dArr, i3, i4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(char[] cArr, M destination, Function1<? super Character, ? extends K> keySelector, Function1<? super Character, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (char c3 : cArr) {
            destination.put(keySelector.invoke(Character.valueOf(c3)), valueTransform.invoke(Character.valueOf(c3)));
        }
        return destination;
    }

    public static final <A extends Appendable> A joinTo(float[] fArr, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i3, CharSequence truncated, Function1<? super Float, ? extends CharSequence> function1) throws IOException {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        buffer.append(prefix);
        int i4 = 0;
        for (float f3 : fArr) {
            i4++;
            if (i4 > 1) {
                buffer.append(separator);
            }
            if (i3 >= 0 && i4 > i3) {
                break;
            }
            if (function1 != null) {
                buffer.append((CharSequence) function1.invoke(Float.valueOf(f3)));
            } else {
                buffer.append(String.valueOf(f3));
            }
        }
        if (i3 >= 0 && i4 > i3) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final <R extends Comparable<? super R>> Long maxByOrNull(long[] jArr, Function1<? super Long, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        long j3 = jArr[0];
        int lastIndex = getLastIndex(jArr);
        if (lastIndex == 0) {
            return Long.valueOf(j3);
        }
        Comparable comparable = (Comparable) selector.invoke(Long.valueOf(j3));
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                long j4 = jArr[i3];
                Comparable comparable2 = (Comparable) selector.invoke(Long.valueOf(j4));
                if (comparable.compareTo(comparable2) < 0) {
                    j3 = j4;
                    comparable = comparable2;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Long.valueOf(j3);
    }

    public static final <R extends Comparable<? super R>> Long minByOrNull(long[] jArr, Function1<? super Long, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(function1, SbbqvQlxi.sXzQOjMPvkRiqK);
        if (jArr.length == 0) {
            return null;
        }
        long j3 = jArr[0];
        int lastIndex = getLastIndex(jArr);
        if (lastIndex == 0) {
            return Long.valueOf(j3);
        }
        Comparable comparable = (Comparable) function1.invoke(Long.valueOf(j3));
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                long j4 = jArr[i3];
                Comparable comparable2 = (Comparable) function1.invoke(Long.valueOf(j4));
                if (comparable.compareTo(comparable2) > 0) {
                    j3 = j4;
                    comparable = comparable2;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Long.valueOf(j3);
    }

    public static final Boolean reduceIndexedOrNull(boolean[] zArr, Function3<? super Integer, ? super Boolean, ? super Boolean, Boolean> operation) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (zArr.length == 0) {
            return null;
        }
        boolean zBooleanValue = zArr[0];
        int lastIndex = getLastIndex(zArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                zBooleanValue = ((Boolean) operation.invoke(Integer.valueOf(i3), Boolean.valueOf(zBooleanValue), Boolean.valueOf(zArr[i3]))).booleanValue();
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Boolean.valueOf(zBooleanValue);
    }

    public static final Boolean reduceOrNull(boolean[] zArr, Function2<? super Boolean, ? super Boolean, Boolean> operation) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (zArr.length == 0) {
            return null;
        }
        boolean zBooleanValue = zArr[0];
        int lastIndex = getLastIndex(zArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                zBooleanValue = ((Boolean) operation.invoke(Boolean.valueOf(zBooleanValue), Boolean.valueOf(zArr[i3]))).booleanValue();
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Boolean.valueOf(zBooleanValue);
    }

    public static final void shuffle(float[] fArr, Random random) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = getLastIndex(fArr); lastIndex > 0; lastIndex--) {
            int iJ = random.j(lastIndex + 1);
            float f3 = fArr[lastIndex];
            fArr[lastIndex] = fArr[iJ];
            fArr[iJ] = f3;
        }
    }

    public static final List<Boolean> dropWhile(boolean[] zArr, Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, pnxuebdT.dCNtXfyticeUPvo);
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z2 = false;
        for (boolean z3 : zArr) {
            if (z2) {
                arrayList.add(Boolean.valueOf(z3));
            } else if (!((Boolean) predicate.invoke(Boolean.valueOf(z3))).booleanValue()) {
                arrayList.add(Boolean.valueOf(z3));
                z2 = true;
            }
        }
        return arrayList;
    }

    public static final long first(long[] jArr, Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (long j3 : jArr) {
            if (((Boolean) predicate.invoke(Long.valueOf(j3))).booleanValue()) {
                return j3;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final <K, M extends Map<? super K, List<Float>>> M groupByTo(float[] fArr, M destination, Function1<? super Float, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (float f3 : fArr) {
            Object objInvoke = keySelector.invoke(Float.valueOf(f3));
            Object arrayList = destination.get(objInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(objInvoke, arrayList);
            }
            ((List) arrayList).add(Float.valueOf(f3));
        }
        return destination;
    }

    public static final short last(short[] sArr, Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = sArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i3 = length - 1;
                short s2 = sArr[length];
                if (!((Boolean) predicate.invoke(Short.valueOf(s2))).booleanValue()) {
                    if (i3 < 0) {
                        break;
                    }
                    length = i3;
                } else {
                    return s2;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    private static final <R> R maxOfWithOrNull(boolean[] zArr, Comparator<? super R> comparator, Function1<? super Boolean, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        R r2 = (Object) selector.invoke(Boolean.valueOf(zArr[0]));
        int lastIndex = getLastIndex(zArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object obj = (Object) selector.invoke(Boolean.valueOf(zArr[i3]));
                if (comparator.compare(r2, obj) < 0) {
                    r2 = (R) obj;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    public static final Double maxWithOrNull(double[] dArr, Comparator<? super Double> comparator) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (dArr.length == 0) {
            return null;
        }
        double d3 = dArr[0];
        int lastIndex = getLastIndex(dArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                double d4 = dArr[i3];
                if (comparator.compare(Double.valueOf(d3), Double.valueOf(d4)) < 0) {
                    d3 = d4;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Double.valueOf(d3);
    }

    private static final <R> R minOfWithOrNull(boolean[] zArr, Comparator<? super R> comparator, Function1<? super Boolean, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        R r2 = (Object) selector.invoke(Boolean.valueOf(zArr[0]));
        int lastIndex = getLastIndex(zArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object obj = (Object) selector.invoke(Boolean.valueOf(zArr[i3]));
                if (comparator.compare(r2, obj) > 0) {
                    r2 = (R) obj;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    public static final Double minWithOrNull(double[] dArr, Comparator<? super Double> comparator) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (dArr.length == 0) {
            return null;
        }
        double d3 = dArr[0];
        int lastIndex = getLastIndex(dArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                double d4 = dArr[i3];
                if (comparator.compare(Double.valueOf(d3), Double.valueOf(d4)) > 0) {
                    d3 = d4;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Double.valueOf(d3);
    }

    public static final Pair<List<Float>, List<Float>> partition(float[] fArr, Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (float f3 : fArr) {
            if (((Boolean) predicate.invoke(Float.valueOf(f3))).booleanValue()) {
                arrayList.add(Float.valueOf(f3));
            } else {
                arrayList2.add(Float.valueOf(f3));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    public static final boolean reduce(boolean[] zArr, Function2<? super Boolean, ? super Boolean, Boolean> operation) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (zArr.length != 0) {
            boolean zBooleanValue = zArr[0];
            int lastIndex = getLastIndex(zArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    zBooleanValue = ((Boolean) operation.invoke(Boolean.valueOf(zBooleanValue), Boolean.valueOf(zArr[i3]))).booleanValue();
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return zBooleanValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final boolean reduceIndexed(boolean[] zArr, Function3<? super Integer, ? super Boolean, ? super Boolean, Boolean> operation) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (zArr.length != 0) {
            boolean zBooleanValue = zArr[0];
            int lastIndex = getLastIndex(zArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    zBooleanValue = ((Boolean) operation.invoke(Integer.valueOf(i3), Boolean.valueOf(zBooleanValue), Boolean.valueOf(zArr[i3]))).booleanValue();
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return zBooleanValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final void reverse(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        int length = (zArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int lastIndex = getLastIndex(zArr);
        if (length < 0) {
            return;
        }
        int i3 = 0;
        while (true) {
            boolean z2 = zArr[i3];
            zArr[i3] = zArr[lastIndex];
            zArr[lastIndex] = z2;
            lastIndex--;
            if (i3 == length) {
                return;
            } else {
                i3++;
            }
        }
    }

    private static final <R> List<R> runningFold(boolean[] zArr, R r2, Function2<? super R, ? super Boolean, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (zArr.length == 0) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(zArr.length + 1);
        arrayList.add(r2);
        for (boolean z2 : zArr) {
            r2 = (R) operation.invoke(r2, Boolean.valueOf(z2));
            arrayList.add(r2);
        }
        return arrayList;
    }

    private static final <R> List<R> runningFoldIndexed(boolean[] zArr, R r2, Function3<? super Integer, ? super R, ? super Boolean, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (zArr.length == 0) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(zArr.length + 1);
        arrayList.add(r2);
        int length = zArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            r2 = (R) operation.invoke(Integer.valueOf(i3), r2, Boolean.valueOf(zArr[i3]));
            arrayList.add(r2);
        }
        return arrayList;
    }

    public static long[] sliceArray(long[] jArr, IntRange indices) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? new long[0] : ArraysKt___ArraysJvmKt.copyOfRange(jArr, indices.a().intValue(), indices.e().intValue() + 1);
    }

    public static final void sortDescending(char[] cArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        ArraysKt___ArraysJvmKt.sort(cArr, i3, i4);
        reverse(cArr, i3, i4);
    }

    public static final List<Float> take(float[] fArr, int i3) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (i3 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
        }
        if (i3 == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (i3 >= fArr.length) {
            return toList(fArr);
        }
        if (i3 == 1) {
            return CollectionsKt__CollectionsJVMKt.listOf(Float.valueOf(fArr[0]));
        }
        ArrayList arrayList = new ArrayList(i3);
        int i4 = 0;
        for (float f3 : fArr) {
            arrayList.add(Float.valueOf(f3));
            i4++;
            if (i4 == i3) {
                break;
            }
        }
        return arrayList;
    }

    public static final List<Float> takeLast(float[] fArr, int i3) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (i3 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
        }
        if (i3 == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        int length = fArr.length;
        if (i3 >= length) {
            return toList(fArr);
        }
        if (i3 == 1) {
            return CollectionsKt__CollectionsJVMKt.listOf(Float.valueOf(fArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i3);
        for (int i4 = length - i3; i4 < length; i4++) {
            arrayList.add(Float.valueOf(fArr[i4]));
        }
        return arrayList;
    }

    public static final <R, V> List<V> zip(short[] sArr, Iterable<? extends R> other, Function2<? super Short, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = sArr.length;
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(other, 10), length));
        int i3 = 0;
        for (R r2 : other) {
            if (i3 >= length) {
                break;
            }
            arrayList.add(transform.invoke(Short.valueOf(sArr[i3]), r2));
            i3++;
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K, V> Map<K, V> associateBy(T[] tArr, Function1<? super T, ? extends K> keySelector, Function1<? super T, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt__MapsJVMKt.mapCapacity(tArr.length), 16));
        for (T t2 : tArr) {
            linkedHashMap.put(keySelector.invoke(t2), valueTransform.invoke(t2));
        }
        return linkedHashMap;
    }

    public static final <K> List<Double> distinctBy(double[] dArr, Function1<? super Double, ? extends K> selector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (double d3 : dArr) {
            if (hashSet.add(selector.invoke(Double.valueOf(d3)))) {
                arrayList.add(Double.valueOf(d3));
            }
        }
        return arrayList;
    }

    private static final double maxOf(double[] dArr, Function1<? super Double, Double> selector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (dArr.length != 0) {
            double dDoubleValue = ((Number) selector.invoke(Double.valueOf(dArr[0]))).doubleValue();
            int lastIndex = getLastIndex(dArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    dDoubleValue = Math.max(dDoubleValue, ((Number) selector.invoke(Double.valueOf(dArr[i3]))).doubleValue());
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return dDoubleValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final Double m1395maxOfOrNull(double[] dArr, Function1<? super Double, Double> selector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        double dDoubleValue = ((Number) selector.invoke(Double.valueOf(dArr[0]))).doubleValue();
        int lastIndex = getLastIndex(dArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.max(dDoubleValue, ((Number) selector.invoke(Double.valueOf(dArr[i3]))).doubleValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    private static final <R> R maxOfWith(double[] dArr, Comparator<? super R> comparator, Function1<? super Double, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (dArr.length != 0) {
            R r2 = (Object) selector.invoke(Double.valueOf(dArr[0]));
            int lastIndex = getLastIndex(dArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Object obj = (Object) selector.invoke(Double.valueOf(dArr[i3]));
                    if (comparator.compare(r2, obj) < 0) {
                        r2 = (R) obj;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return r2;
        }
        throw new NoSuchElementException();
    }

    public static final double maxWithOrThrow(double[] dArr, Comparator<? super Double> comparator) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, MHoiDDglUlPJC.EtmdjX);
        if (dArr.length != 0) {
            double d3 = dArr[0];
            int lastIndex = getLastIndex(dArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    double d4 = dArr[i3];
                    if (comparator.compare(Double.valueOf(d3), Double.valueOf(d4)) < 0) {
                        d3 = d4;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return d3;
        }
        throw new NoSuchElementException();
    }

    private static final double minOf(double[] dArr, Function1<? super Double, Double> selector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (dArr.length != 0) {
            double dDoubleValue = ((Number) selector.invoke(Double.valueOf(dArr[0]))).doubleValue();
            int lastIndex = getLastIndex(dArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    dDoubleValue = Math.min(dDoubleValue, ((Number) selector.invoke(Double.valueOf(dArr[i3]))).doubleValue());
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return dDoubleValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOfOrNull, reason: collision with other method in class */
    private static final Double m1431minOfOrNull(double[] dArr, Function1<? super Double, Double> selector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        double dDoubleValue = ((Number) selector.invoke(Double.valueOf(dArr[0]))).doubleValue();
        int lastIndex = getLastIndex(dArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.min(dDoubleValue, ((Number) selector.invoke(Double.valueOf(dArr[i3]))).doubleValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    private static final <R> R minOfWith(double[] dArr, Comparator<? super R> comparator, Function1<? super Double, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (dArr.length != 0) {
            R r2 = (Object) selector.invoke(Double.valueOf(dArr[0]));
            int lastIndex = getLastIndex(dArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Object obj = (Object) selector.invoke(Double.valueOf(dArr[i3]));
                    if (comparator.compare(r2, obj) > 0) {
                        r2 = (R) obj;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return r2;
        }
        throw new NoSuchElementException();
    }

    public static final double minWithOrThrow(double[] dArr, Comparator<? super Double> comparator) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (dArr.length != 0) {
            double d3 = dArr[0];
            int lastIndex = getLastIndex(dArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    double d4 = dArr[i3];
                    if (comparator.compare(Double.valueOf(d3), Double.valueOf(d4)) > 0) {
                        d3 = d4;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return d3;
        }
        throw new NoSuchElementException();
    }

    private static final List<Double> runningReduce(double[] dArr, Function2<? super Double, ? super Double, Double> operation) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (dArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        double dDoubleValue = dArr[0];
        ArrayList arrayList = new ArrayList(dArr.length);
        arrayList.add(Double.valueOf(dDoubleValue));
        int length = dArr.length;
        for (int i3 = 1; i3 < length; i3++) {
            dDoubleValue = ((Number) operation.invoke(Double.valueOf(dDoubleValue), Double.valueOf(dArr[i3]))).doubleValue();
            arrayList.add(Double.valueOf(dDoubleValue));
        }
        return arrayList;
    }

    private static final List<Double> runningReduceIndexed(double[] dArr, Function3<? super Integer, ? super Double, ? super Double, Double> operation) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (dArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        double dDoubleValue = dArr[0];
        ArrayList arrayList = new ArrayList(dArr.length);
        arrayList.add(Double.valueOf(dDoubleValue));
        int length = dArr.length;
        for (int i3 = 1; i3 < length; i3++) {
            dDoubleValue = ((Number) operation.invoke(Integer.valueOf(i3), Double.valueOf(dDoubleValue), Double.valueOf(dArr[i3]))).doubleValue();
            arrayList.add(Double.valueOf(dDoubleValue));
        }
        return arrayList;
    }

    public static final <T> T single(T[] tArr, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        T t2 = null;
        boolean z2 = false;
        for (T t3 : tArr) {
            if (((Boolean) predicate.invoke(t3)).booleanValue()) {
                if (z2) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                z2 = true;
                t2 = t3;
            }
        }
        if (z2) {
            return t2;
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final float first(float[] fArr, Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (float f3 : fArr) {
            if (((Boolean) predicate.invoke(Float.valueOf(f3))).booleanValue()) {
                return f3;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static Float maxOrNull(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (fArr.length == 0) {
            return null;
        }
        float fMax = fArr[0];
        int lastIndex = getLastIndex(fArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fMax = Math.max(fMax, fArr[i3]);
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Float.valueOf(fMax);
    }

    public static Float minOrNull(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (fArr.length == 0) {
            return null;
        }
        float fMin = fArr[0];
        int lastIndex = getLastIndex(fArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fMin = Math.min(fMin, fArr[i3]);
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Float.valueOf(fMin);
    }

    public static final float[] sliceArray(float[] fArr, IntRange indices) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? new float[0] : ArraysKt___ArraysJvmKt.copyOfRange(fArr, indices.a().intValue(), indices.e().intValue() + 1);
    }

    public static final float maxOrThrow(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (fArr.length != 0) {
            float fMax = fArr[0];
            int lastIndex = getLastIndex(fArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fMax = Math.max(fMax, fArr[i3]);
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return fMax;
        }
        throw new NoSuchElementException();
    }

    public static final float minOrThrow(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (fArr.length != 0) {
            float fMin = fArr[0];
            int lastIndex = getLastIndex(fArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fMin = Math.min(fMin, fArr[i3]);
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return fMin;
        }
        throw new NoSuchElementException();
    }

    public static final List<Long> slice(long[] jArr, Iterable<Integer> indices) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        int iCollectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(indices, 10);
        if (iCollectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(jArr[it.next().intValue()]));
        }
        return arrayList;
    }

    public static final double first(double[] dArr, Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (double d3 : dArr) {
            if (((Boolean) predicate.invoke(Double.valueOf(d3))).booleanValue()) {
                return d3;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final int last(int[] iArr, Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = iArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i3 = length - 1;
                int i4 = iArr[length];
                if (!((Boolean) predicate.invoke(Integer.valueOf(i4))).booleanValue()) {
                    if (i3 < 0) {
                        break;
                    }
                    length = i3;
                } else {
                    return i4;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final Character reduceIndexedOrNull(char[] cArr, Function3<? super Integer, ? super Character, ? super Character, Character> operation) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (cArr.length == 0) {
            return null;
        }
        char cCharValue = cArr[0];
        int lastIndex = getLastIndex(cArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                cCharValue = ((Character) operation.invoke(Integer.valueOf(i3), Character.valueOf(cCharValue), Character.valueOf(cArr[i3]))).charValue();
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Character.valueOf(cCharValue);
    }

    public static final Character reduceOrNull(char[] cArr, Function2<? super Character, ? super Character, Character> operation) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (cArr.length == 0) {
            return null;
        }
        char cCharValue = cArr[0];
        int lastIndex = getLastIndex(cArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                cCharValue = ((Character) operation.invoke(Character.valueOf(cCharValue), Character.valueOf(cArr[i3]))).charValue();
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Character.valueOf(cCharValue);
    }

    public static final void shuffle(double[] dArr, Random random) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = getLastIndex(dArr); lastIndex > 0; lastIndex--) {
            int iJ = random.j(lastIndex + 1);
            double d3 = dArr[lastIndex];
            dArr[lastIndex] = dArr[iJ];
            dArr[iJ] = d3;
        }
    }

    public static final double[] sliceArray(double[] dArr, IntRange indices) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? new double[0] : ArraysKt___ArraysJvmKt.copyOfRange(dArr, indices.a().intValue(), indices.e().intValue() + 1);
    }

    public static final <R, V> List<V> zip(int[] iArr, Iterable<? extends R> other, Function2<? super Integer, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = iArr.length;
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(other, 10), length));
        int i3 = 0;
        for (R r2 : other) {
            if (i3 >= length) {
                break;
            }
            arrayList.add(transform.invoke(Integer.valueOf(iArr[i3]), r2));
            i3++;
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> associateBy(byte[] bArr, Function1<? super Byte, ? extends K> keySelector, Function1<? super Byte, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt__MapsJVMKt.mapCapacity(bArr.length), 16));
        for (byte b3 : bArr) {
            linkedHashMap.put(keySelector.invoke(Byte.valueOf(b3)), valueTransform.invoke(Byte.valueOf(b3)));
        }
        return linkedHashMap;
    }

    public static final List<Character> dropWhile(char[] cArr, Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z2 = false;
        for (char c3 : cArr) {
            if (z2) {
                arrayList.add(Character.valueOf(c3));
            } else if (!((Boolean) predicate.invoke(Character.valueOf(c3))).booleanValue()) {
                arrayList.add(Character.valueOf(c3));
                z2 = true;
            }
        }
        return arrayList;
    }

    public static final <K> Map<K, List<Float>> groupBy(float[] fArr, Function1<? super Float, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (float f3 : fArr) {
            Object objInvoke = keySelector.invoke(Float.valueOf(f3));
            Object arrayList = linkedHashMap.get(objInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(objInvoke, arrayList);
            }
            ((List) arrayList).add(Float.valueOf(f3));
        }
        return linkedHashMap;
    }

    public static final <R extends Comparable<? super R>> float maxByOrThrow(float[] fArr, Function1<? super Float, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (fArr.length != 0) {
            float f3 = fArr[0];
            int lastIndex = getLastIndex(fArr);
            if (lastIndex != 0) {
                Comparable comparable = (Comparable) selector.invoke(Float.valueOf(f3));
                int i3 = 1;
                if (1 <= lastIndex) {
                    while (true) {
                        float f4 = fArr[i3];
                        Comparable comparable2 = (Comparable) selector.invoke(Float.valueOf(f4));
                        if (comparable.compareTo(comparable2) < 0) {
                            f3 = f4;
                            comparable = comparable2;
                        }
                        if (i3 == lastIndex) {
                            break;
                        }
                        i3++;
                    }
                }
            }
            return f3;
        }
        throw new NoSuchElementException();
    }

    private static final <R> R maxOfWithOrNull(char[] cArr, Comparator<? super R> comparator, Function1<? super Character, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        R r2 = (Object) selector.invoke(Character.valueOf(cArr[0]));
        int lastIndex = getLastIndex(cArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object obj = (Object) selector.invoke(Character.valueOf(cArr[i3]));
                if (comparator.compare(r2, obj) < 0) {
                    r2 = (R) obj;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    public static final <R extends Comparable<? super R>> float minByOrThrow(float[] fArr, Function1<? super Float, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (fArr.length != 0) {
            float f3 = fArr[0];
            int lastIndex = getLastIndex(fArr);
            if (lastIndex != 0) {
                Comparable comparable = (Comparable) selector.invoke(Float.valueOf(f3));
                int i3 = 1;
                if (1 <= lastIndex) {
                    while (true) {
                        float f4 = fArr[i3];
                        Comparable comparable2 = (Comparable) selector.invoke(Float.valueOf(f4));
                        if (comparable.compareTo(comparable2) > 0) {
                            f3 = f4;
                            comparable = comparable2;
                        }
                        if (i3 == lastIndex) {
                            break;
                        }
                        i3++;
                    }
                }
            }
            return f3;
        }
        throw new NoSuchElementException();
    }

    private static final <R> R minOfWithOrNull(char[] cArr, Comparator<? super R> comparator, Function1<? super Character, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        R r2 = (Object) selector.invoke(Character.valueOf(cArr[0]));
        int lastIndex = getLastIndex(cArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object obj = (Object) selector.invoke(Character.valueOf(cArr[i3]));
                if (comparator.compare(r2, obj) > 0) {
                    r2 = (R) obj;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    public static final char reduce(char[] cArr, Function2<? super Character, ? super Character, Character> operation) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (cArr.length != 0) {
            char cCharValue = cArr[0];
            int lastIndex = getLastIndex(cArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    cCharValue = ((Character) operation.invoke(Character.valueOf(cCharValue), Character.valueOf(cArr[i3]))).charValue();
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return cCharValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final char reduceIndexed(char[] cArr, Function3<? super Integer, ? super Character, ? super Character, Character> operation) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (cArr.length != 0) {
            char cCharValue = cArr[0];
            int lastIndex = getLastIndex(cArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    cCharValue = ((Character) operation.invoke(Integer.valueOf(i3), Character.valueOf(cCharValue), Character.valueOf(cArr[i3]))).charValue();
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return cCharValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final void reverse(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        int length = (cArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int lastIndex = getLastIndex(cArr);
        if (length < 0) {
            return;
        }
        int i3 = 0;
        while (true) {
            char c3 = cArr[i3];
            cArr[i3] = cArr[lastIndex];
            cArr[lastIndex] = c3;
            lastIndex--;
            if (i3 == length) {
                return;
            } else {
                i3++;
            }
        }
    }

    private static final <R> List<R> runningFold(char[] cArr, R r2, Function2<? super R, ? super Character, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (cArr.length == 0) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(cArr.length + 1);
        arrayList.add(r2);
        for (char c3 : cArr) {
            r2 = (R) operation.invoke(r2, Character.valueOf(c3));
            arrayList.add(r2);
        }
        return arrayList;
    }

    private static final <R> List<R> runningFoldIndexed(char[] cArr, R r2, Function3<? super Integer, ? super R, ? super Character, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (cArr.length == 0) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(cArr.length + 1);
        arrayList.add(r2);
        int length = cArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            r2 = (R) operation.invoke(Integer.valueOf(i3), r2, Character.valueOf(cArr[i3]));
            arrayList.add(r2);
        }
        return arrayList;
    }

    public static final byte single(byte[] bArr, Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Byte bValueOf = null;
        boolean z2 = false;
        for (byte b3 : bArr) {
            if (((Boolean) predicate.invoke(Byte.valueOf(b3))).booleanValue()) {
                if (!z2) {
                    bValueOf = Byte.valueOf(b3);
                    z2 = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (z2) {
            Intrinsics.checkNotNull(bValueOf, "null cannot be cast to non-null type kotlin.Byte");
            return bValueOf.byteValue();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final boolean first(boolean[] zArr, Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (boolean z2 : zArr) {
            if (((Boolean) predicate.invoke(Boolean.valueOf(z2))).booleanValue()) {
                return z2;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final <A extends Appendable> A joinTo(double[] dArr, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i3, CharSequence truncated, Function1<? super Double, ? extends CharSequence> function1) throws IOException {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        buffer.append(prefix);
        int i4 = 0;
        for (double d3 : dArr) {
            i4++;
            if (i4 > 1) {
                buffer.append(separator);
            }
            if (i3 >= 0 && i4 > i3) {
                break;
            }
            if (function1 != null) {
                buffer.append((CharSequence) function1.invoke(Double.valueOf(d3)));
            } else {
                buffer.append(String.valueOf(d3));
            }
        }
        if (i3 >= 0 && i4 > i3) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final Boolean maxWithOrNull(boolean[] zArr, Comparator<? super Boolean> comparator) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (zArr.length == 0) {
            return null;
        }
        boolean z2 = zArr[0];
        int lastIndex = getLastIndex(zArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                boolean z3 = zArr[i3];
                if (comparator.compare(Boolean.valueOf(z2), Boolean.valueOf(z3)) < 0) {
                    z2 = z3;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Boolean.valueOf(z2);
    }

    public static final Boolean minWithOrNull(boolean[] zArr, Comparator<? super Boolean> comparator) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (zArr.length == 0) {
            return null;
        }
        boolean z2 = zArr[0];
        int lastIndex = getLastIndex(zArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                boolean z3 = zArr[i3];
                if (comparator.compare(Boolean.valueOf(z2), Boolean.valueOf(z3)) > 0) {
                    z2 = z3;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Boolean.valueOf(z2);
    }

    public static final boolean[] sliceArray(boolean[] zArr, IntRange indices) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? new boolean[0] : ArraysKt___ArraysJvmKt.copyOfRange(zArr, indices.a().intValue(), indices.e().intValue() + 1);
    }

    public static final <K> List<Boolean> distinctBy(boolean[] zArr, Function1<? super Boolean, ? extends K> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (boolean z2 : zArr) {
            if (hashSet.add(selector.invoke(Boolean.valueOf(z2)))) {
                arrayList.add(Boolean.valueOf(z2));
            }
        }
        return arrayList;
    }

    public static final <K, M extends Map<? super K, List<Double>>> M groupByTo(double[] dArr, M destination, Function1<? super Double, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (double d3 : dArr) {
            Object objInvoke = keySelector.invoke(Double.valueOf(d3));
            Object arrayList = destination.get(objInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(objInvoke, arrayList);
            }
            ((List) arrayList).add(Double.valueOf(d3));
        }
        return destination;
    }

    private static final double maxOf(boolean[] zArr, Function1<? super Boolean, Double> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (zArr.length != 0) {
            double dDoubleValue = ((Number) selector.invoke(Boolean.valueOf(zArr[0]))).doubleValue();
            int lastIndex = getLastIndex(zArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    dDoubleValue = Math.max(dDoubleValue, ((Number) selector.invoke(Boolean.valueOf(zArr[i3]))).doubleValue());
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return dDoubleValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final Double m1401maxOfOrNull(boolean[] zArr, Function1<? super Boolean, Double> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        double dDoubleValue = ((Number) selector.invoke(Boolean.valueOf(zArr[0]))).doubleValue();
        int lastIndex = getLastIndex(zArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.max(dDoubleValue, ((Number) selector.invoke(Boolean.valueOf(zArr[i3]))).doubleValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    private static final <R> R maxOfWith(boolean[] zArr, Comparator<? super R> comparator, Function1<? super Boolean, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (zArr.length != 0) {
            R r2 = (Object) selector.invoke(Boolean.valueOf(zArr[0]));
            int lastIndex = getLastIndex(zArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Object obj = (Object) selector.invoke(Boolean.valueOf(zArr[i3]));
                    if (comparator.compare(r2, obj) < 0) {
                        r2 = (R) obj;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return r2;
        }
        throw new NoSuchElementException();
    }

    public static final boolean maxWithOrThrow(boolean[] zArr, Comparator<? super Boolean> comparator) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (zArr.length != 0) {
            boolean z2 = zArr[0];
            int lastIndex = getLastIndex(zArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    boolean z3 = zArr[i3];
                    if (comparator.compare(Boolean.valueOf(z2), Boolean.valueOf(z3)) < 0) {
                        z2 = z3;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return z2;
        }
        throw new NoSuchElementException();
    }

    private static final double minOf(boolean[] zArr, Function1<? super Boolean, Double> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (zArr.length != 0) {
            double dDoubleValue = ((Number) selector.invoke(Boolean.valueOf(zArr[0]))).doubleValue();
            int lastIndex = getLastIndex(zArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    dDoubleValue = Math.min(dDoubleValue, ((Number) selector.invoke(Boolean.valueOf(zArr[i3]))).doubleValue());
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return dDoubleValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOfOrNull, reason: collision with other method in class */
    private static final Double m1437minOfOrNull(boolean[] zArr, Function1<? super Boolean, Double> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        double dDoubleValue = ((Number) selector.invoke(Boolean.valueOf(zArr[0]))).doubleValue();
        int lastIndex = getLastIndex(zArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.min(dDoubleValue, ((Number) selector.invoke(Boolean.valueOf(zArr[i3]))).doubleValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    private static final <R> R minOfWith(boolean[] zArr, Comparator<? super R> comparator, Function1<? super Boolean, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (zArr.length != 0) {
            R r2 = (Object) selector.invoke(Boolean.valueOf(zArr[0]));
            int lastIndex = getLastIndex(zArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Object obj = (Object) selector.invoke(Boolean.valueOf(zArr[i3]));
                    if (comparator.compare(r2, obj) > 0) {
                        r2 = (R) obj;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return r2;
        }
        throw new NoSuchElementException();
    }

    public static final boolean minWithOrThrow(boolean[] zArr, Comparator<? super Boolean> comparator) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (zArr.length != 0) {
            boolean z2 = zArr[0];
            int lastIndex = getLastIndex(zArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    boolean z3 = zArr[i3];
                    if (comparator.compare(Boolean.valueOf(z2), Boolean.valueOf(z3)) > 0) {
                        z2 = z3;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return z2;
        }
        throw new NoSuchElementException();
    }

    public static final Pair<List<Double>, List<Double>> partition(double[] dArr, Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (double d3 : dArr) {
            if (((Boolean) predicate.invoke(Double.valueOf(d3))).booleanValue()) {
                arrayList.add(Double.valueOf(d3));
            } else {
                arrayList2.add(Double.valueOf(d3));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    private static final List<Boolean> runningReduce(boolean[] zArr, Function2<? super Boolean, ? super Boolean, Boolean> operation) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (zArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        boolean z2 = zArr[0];
        ArrayList arrayList = new ArrayList(zArr.length);
        arrayList.add(Boolean.valueOf(z2));
        int length = zArr.length;
        int i3 = 1;
        while (i3 < length) {
            Boolean bool = (Boolean) operation.invoke(Boolean.valueOf(z2), Boolean.valueOf(zArr[i3]));
            boolean zBooleanValue = bool.booleanValue();
            arrayList.add(bool);
            i3++;
            z2 = zBooleanValue;
        }
        return arrayList;
    }

    private static final List<Boolean> runningReduceIndexed(boolean[] zArr, Function3<? super Integer, ? super Boolean, ? super Boolean, Boolean> operation) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (zArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        boolean z2 = zArr[0];
        ArrayList arrayList = new ArrayList(zArr.length);
        arrayList.add(Boolean.valueOf(z2));
        int length = zArr.length;
        int i3 = 1;
        while (i3 < length) {
            Boolean bool = (Boolean) operation.invoke(Integer.valueOf(i3), Boolean.valueOf(z2), Boolean.valueOf(zArr[i3]));
            boolean zBooleanValue = bool.booleanValue();
            arrayList.add(bool);
            i3++;
            z2 = zBooleanValue;
        }
        return arrayList;
    }

    public static final List<Double> take(double[] dArr, int i3) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (i3 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
        }
        if (i3 == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (i3 >= dArr.length) {
            return toList(dArr);
        }
        if (i3 == 1) {
            return CollectionsKt__CollectionsJVMKt.listOf(Double.valueOf(dArr[0]));
        }
        ArrayList arrayList = new ArrayList(i3);
        int i4 = 0;
        for (double d3 : dArr) {
            arrayList.add(Double.valueOf(d3));
            i4++;
            if (i4 == i3) {
                break;
            }
        }
        return arrayList;
    }

    public static final List<Double> takeLast(double[] dArr, int i3) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (i3 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
        }
        if (i3 == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        int length = dArr.length;
        if (i3 >= length) {
            return toList(dArr);
        }
        if (i3 == 1) {
            return CollectionsKt__CollectionsJVMKt.listOf(Double.valueOf(dArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i3);
        for (int i4 = length - i3; i4 < length; i4++) {
            arrayList.add(Double.valueOf(dArr[i4]));
        }
        return arrayList;
    }

    public static final char first(char[] cArr, Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (char c3 : cArr) {
            if (((Boolean) predicate.invoke(Character.valueOf(c3))).booleanValue()) {
                return c3;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final long last(long[] jArr, Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = jArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i3 = length - 1;
                long j3 = jArr[length];
                if (!((Boolean) predicate.invoke(Long.valueOf(j3))).booleanValue()) {
                    if (i3 < 0) {
                        break;
                    }
                    length = i3;
                } else {
                    return j3;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final <R extends Comparable<? super R>> Float maxByOrNull(float[] fArr, Function1<? super Float, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        float f3 = fArr[0];
        int lastIndex = getLastIndex(fArr);
        if (lastIndex == 0) {
            return Float.valueOf(f3);
        }
        Comparable comparable = (Comparable) selector.invoke(Float.valueOf(f3));
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                float f4 = fArr[i3];
                Comparable comparable2 = (Comparable) selector.invoke(Float.valueOf(f4));
                if (comparable.compareTo(comparable2) < 0) {
                    f3 = f4;
                    comparable = comparable2;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Float.valueOf(f3);
    }

    public static final Double maxOrNull(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (dArr.length == 0) {
            return null;
        }
        double dMax = dArr[0];
        int lastIndex = getLastIndex(dArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dMax = Math.max(dMax, dArr[i3]);
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Double.valueOf(dMax);
    }

    public static final <R extends Comparable<? super R>> Float minByOrNull(float[] fArr, Function1<? super Float, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        float f3 = fArr[0];
        int lastIndex = getLastIndex(fArr);
        if (lastIndex == 0) {
            return Float.valueOf(f3);
        }
        Comparable comparable = (Comparable) selector.invoke(Float.valueOf(f3));
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                float f4 = fArr[i3];
                Comparable comparable2 = (Comparable) selector.invoke(Float.valueOf(f4));
                if (comparable.compareTo(comparable2) > 0) {
                    f3 = f4;
                    comparable = comparable2;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Float.valueOf(f3);
    }

    public static final Double minOrNull(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (dArr.length == 0) {
            return null;
        }
        double dMin = dArr[0];
        int lastIndex = getLastIndex(dArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dMin = Math.min(dMin, dArr[i3]);
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Double.valueOf(dMin);
    }

    public static final List<Float> slice(float[] fArr, Iterable<Integer> indices) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        int iCollectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(indices, 10);
        if (iCollectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(Float.valueOf(fArr[it.next().intValue()]));
        }
        return arrayList;
    }

    public static final char[] sliceArray(char[] cArr, IntRange indices) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? new char[0] : ArraysKt___ArraysJvmKt.copyOfRange(cArr, indices.a().intValue(), indices.e().intValue() + 1);
    }

    public static final <R, V> List<V> zip(long[] jArr, Iterable<? extends R> other, Function2<? super Long, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = jArr.length;
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(other, 10), length));
        int i3 = 0;
        for (R r2 : other) {
            if (i3 >= length) {
                break;
            }
            arrayList.add(transform.invoke(Long.valueOf(jArr[i3]), r2));
            i3++;
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> associateBy(short[] sArr, Function1<? super Short, ? extends K> keySelector, Function1<? super Short, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt__MapsJVMKt.mapCapacity(sArr.length), 16));
        for (short s2 : sArr) {
            linkedHashMap.put(keySelector.invoke(Short.valueOf(s2)), valueTransform.invoke(Short.valueOf(s2)));
        }
        return linkedHashMap;
    }

    public static final double maxOrThrow(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (dArr.length != 0) {
            double dMax = dArr[0];
            int lastIndex = getLastIndex(dArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    dMax = Math.max(dMax, dArr[i3]);
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return dMax;
        }
        throw new NoSuchElementException();
    }

    public static final double minOrThrow(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (dArr.length != 0) {
            double dMin = dArr[0];
            int lastIndex = getLastIndex(dArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    dMin = Math.min(dMin, dArr[i3]);
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return dMin;
        }
        throw new NoSuchElementException();
    }

    public static final void shuffle(boolean[] zArr, Random random) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = getLastIndex(zArr); lastIndex > 0; lastIndex--) {
            int iJ = random.j(lastIndex + 1);
            boolean z2 = zArr[lastIndex];
            zArr[lastIndex] = zArr[iJ];
            zArr[iJ] = z2;
        }
    }

    public static final <T> void reverse(T[] tArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i3, i4, tArr.length);
        int i5 = (i3 + i4) / 2;
        if (i3 == i5) {
            return;
        }
        int i6 = i4 - 1;
        while (i3 < i5) {
            T t2 = tArr[i3];
            tArr[i3] = tArr[i6];
            tArr[i6] = t2;
            i6--;
            i3++;
        }
    }

    public static final short single(short[] sArr, Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Short shValueOf = null;
        boolean z2 = false;
        for (short s2 : sArr) {
            if (((Boolean) predicate.invoke(Short.valueOf(s2))).booleanValue()) {
                if (!z2) {
                    shValueOf = Short.valueOf(s2);
                    z2 = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (z2) {
            Intrinsics.checkNotNull(shValueOf, "null cannot be cast to non-null type kotlin.Short");
            return shValueOf.shortValue();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final float last(float[] fArr, Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = fArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i3 = length - 1;
                float f3 = fArr[length];
                if (!((Boolean) predicate.invoke(Float.valueOf(f3))).booleanValue()) {
                    if (i3 < 0) {
                        break;
                    }
                    length = i3;
                } else {
                    return f3;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final Character maxWithOrNull(char[] cArr, Comparator<? super Character> comparator) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (cArr.length == 0) {
            return null;
        }
        char c3 = cArr[0];
        int lastIndex = getLastIndex(cArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                char c4 = cArr[i3];
                if (comparator.compare(Character.valueOf(c3), Character.valueOf(c4)) < 0) {
                    c3 = c4;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Character.valueOf(c3);
    }

    public static final Character minWithOrNull(char[] cArr, Comparator<? super Character> comparator) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (cArr.length == 0) {
            return null;
        }
        char c3 = cArr[0];
        int lastIndex = getLastIndex(cArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                char c4 = cArr[i3];
                if (comparator.compare(Character.valueOf(c3), Character.valueOf(c4)) > 0) {
                    c3 = c4;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Character.valueOf(c3);
    }

    public static final <R, V> List<V> zip(float[] fArr, Iterable<? extends R> other, Function2<? super Float, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = fArr.length;
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(other, 10), length));
        int i3 = 0;
        for (R r2 : other) {
            if (i3 >= length) {
                break;
            }
            arrayList.add(transform.invoke(Float.valueOf(fArr[i3]), r2));
            i3++;
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> associateBy(int[] iArr, Function1<? super Integer, ? extends K> keySelector, Function1<? super Integer, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt__MapsJVMKt.mapCapacity(iArr.length), 16));
        for (int i3 : iArr) {
            linkedHashMap.put(keySelector.invoke(Integer.valueOf(i3)), valueTransform.invoke(Integer.valueOf(i3)));
        }
        return linkedHashMap;
    }

    public static final <K> List<Character> distinctBy(char[] cArr, Function1<? super Character, ? extends K> selector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (char c3 : cArr) {
            if (hashSet.add(selector.invoke(Character.valueOf(c3)))) {
                arrayList.add(Character.valueOf(c3));
            }
        }
        return arrayList;
    }

    public static final <K> Map<K, List<Double>> groupBy(double[] dArr, Function1<? super Double, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (double d3 : dArr) {
            Object objInvoke = keySelector.invoke(Double.valueOf(d3));
            Object arrayList = linkedHashMap.get(objInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(objInvoke, arrayList);
            }
            ((List) arrayList).add(Double.valueOf(d3));
        }
        return linkedHashMap;
    }

    public static final <A extends Appendable> A joinTo(boolean[] zArr, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i3, CharSequence truncated, Function1<? super Boolean, ? extends CharSequence> function1) throws IOException {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        buffer.append(prefix);
        int i4 = 0;
        for (boolean z2 : zArr) {
            i4++;
            if (i4 > 1) {
                buffer.append(separator);
            }
            if (i3 >= 0 && i4 > i3) {
                break;
            }
            if (function1 != null) {
                buffer.append((CharSequence) function1.invoke(Boolean.valueOf(z2)));
            } else {
                buffer.append(String.valueOf(z2));
            }
        }
        if (i3 >= 0 && i4 > i3) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final <R extends Comparable<? super R>> double maxByOrThrow(double[] dArr, Function1<? super Double, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (dArr.length != 0) {
            double d3 = dArr[0];
            int lastIndex = getLastIndex(dArr);
            if (lastIndex != 0) {
                Comparable comparable = (Comparable) selector.invoke(Double.valueOf(d3));
                int i3 = 1;
                if (1 <= lastIndex) {
                    while (true) {
                        double d4 = dArr[i3];
                        Comparable comparable2 = (Comparable) selector.invoke(Double.valueOf(d4));
                        if (comparable.compareTo(comparable2) < 0) {
                            d3 = d4;
                            comparable = comparable2;
                        }
                        if (i3 == lastIndex) {
                            break;
                        }
                        i3++;
                    }
                }
            }
            return d3;
        }
        throw new NoSuchElementException();
    }

    private static final double maxOf(char[] cArr, Function1<? super Character, Double> selector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (cArr.length != 0) {
            double dDoubleValue = ((Number) selector.invoke(Character.valueOf(cArr[0]))).doubleValue();
            int lastIndex = getLastIndex(cArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    dDoubleValue = Math.max(dDoubleValue, ((Number) selector.invoke(Character.valueOf(cArr[i3]))).doubleValue());
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return dDoubleValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final Double m1394maxOfOrNull(char[] cArr, Function1<? super Character, Double> selector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        double dDoubleValue = ((Number) selector.invoke(Character.valueOf(cArr[0]))).doubleValue();
        int lastIndex = getLastIndex(cArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.max(dDoubleValue, ((Number) selector.invoke(Character.valueOf(cArr[i3]))).doubleValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    private static final <R> R maxOfWith(char[] cArr, Comparator<? super R> comparator, Function1<? super Character, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (cArr.length != 0) {
            R r2 = (Object) selector.invoke(Character.valueOf(cArr[0]));
            int lastIndex = getLastIndex(cArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Object obj = (Object) selector.invoke(Character.valueOf(cArr[i3]));
                    if (comparator.compare(r2, obj) < 0) {
                        r2 = (R) obj;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return r2;
        }
        throw new NoSuchElementException();
    }

    public static final char maxWithOrThrow(char[] cArr, Comparator<? super Character> comparator) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (cArr.length != 0) {
            char c3 = cArr[0];
            int lastIndex = getLastIndex(cArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    char c4 = cArr[i3];
                    if (comparator.compare(Character.valueOf(c3), Character.valueOf(c4)) < 0) {
                        c3 = c4;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return c3;
        }
        throw new NoSuchElementException();
    }

    public static final <R extends Comparable<? super R>> double minByOrThrow(double[] dArr, Function1<? super Double, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (dArr.length != 0) {
            double d3 = dArr[0];
            int lastIndex = getLastIndex(dArr);
            if (lastIndex != 0) {
                Comparable comparable = (Comparable) selector.invoke(Double.valueOf(d3));
                int i3 = 1;
                if (1 <= lastIndex) {
                    while (true) {
                        double d4 = dArr[i3];
                        Comparable comparable2 = (Comparable) selector.invoke(Double.valueOf(d4));
                        if (comparable.compareTo(comparable2) > 0) {
                            d3 = d4;
                            comparable = comparable2;
                        }
                        if (i3 == lastIndex) {
                            break;
                        }
                        i3++;
                    }
                }
            }
            return d3;
        }
        throw new NoSuchElementException();
    }

    private static final double minOf(char[] cArr, Function1<? super Character, Double> selector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (cArr.length != 0) {
            double dDoubleValue = ((Number) selector.invoke(Character.valueOf(cArr[0]))).doubleValue();
            int lastIndex = getLastIndex(cArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    dDoubleValue = Math.min(dDoubleValue, ((Number) selector.invoke(Character.valueOf(cArr[i3]))).doubleValue());
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return dDoubleValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOfOrNull, reason: collision with other method in class */
    private static final Double m1430minOfOrNull(char[] cArr, Function1<? super Character, Double> selector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        double dDoubleValue = ((Number) selector.invoke(Character.valueOf(cArr[0]))).doubleValue();
        int lastIndex = getLastIndex(cArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.min(dDoubleValue, ((Number) selector.invoke(Character.valueOf(cArr[i3]))).doubleValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    private static final <R> R minOfWith(char[] cArr, Comparator<? super R> comparator, Function1<? super Character, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (cArr.length != 0) {
            R r2 = (Object) selector.invoke(Character.valueOf(cArr[0]));
            int lastIndex = getLastIndex(cArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Object obj = (Object) selector.invoke(Character.valueOf(cArr[i3]));
                    if (comparator.compare(r2, obj) > 0) {
                        r2 = (R) obj;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return r2;
        }
        throw new NoSuchElementException();
    }

    public static final char minWithOrThrow(char[] cArr, Comparator<? super Character> comparator) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (cArr.length != 0) {
            char c3 = cArr[0];
            int lastIndex = getLastIndex(cArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    char c4 = cArr[i3];
                    if (comparator.compare(Character.valueOf(c3), Character.valueOf(c4)) > 0) {
                        c3 = c4;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return c3;
        }
        throw new NoSuchElementException();
    }

    private static final List<Character> runningReduce(char[] cArr, Function2<? super Character, ? super Character, Character> operation) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (cArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        char c3 = cArr[0];
        ArrayList arrayList = new ArrayList(cArr.length);
        arrayList.add(Character.valueOf(c3));
        int length = cArr.length;
        int i3 = 1;
        while (i3 < length) {
            Character ch = (Character) operation.invoke(Character.valueOf(c3), Character.valueOf(cArr[i3]));
            char cCharValue = ch.charValue();
            arrayList.add(ch);
            i3++;
            c3 = cCharValue;
        }
        return arrayList;
    }

    private static final List<Character> runningReduceIndexed(char[] cArr, Function3<? super Integer, ? super Character, ? super Character, Character> operation) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (cArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        char c3 = cArr[0];
        ArrayList arrayList = new ArrayList(cArr.length);
        arrayList.add(Character.valueOf(c3));
        int length = cArr.length;
        int i3 = 1;
        while (i3 < length) {
            Character ch = (Character) operation.invoke(Integer.valueOf(i3), Character.valueOf(c3), Character.valueOf(cArr[i3]));
            char cCharValue = ch.charValue();
            arrayList.add(ch);
            i3++;
            c3 = cCharValue;
        }
        return arrayList;
    }

    public static final List<Double> slice(double[] dArr, Iterable<Integer> indices) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        int iCollectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(indices, 10);
        if (iCollectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(Double.valueOf(dArr[it.next().intValue()]));
        }
        return arrayList;
    }

    public static final <K, M extends Map<? super K, List<Boolean>>> M groupByTo(boolean[] zArr, M destination, Function1<? super Boolean, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (boolean z2 : zArr) {
            Object objInvoke = keySelector.invoke(Boolean.valueOf(z2));
            Object arrayList = destination.get(objInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(objInvoke, arrayList);
            }
            ((List) arrayList).add(Boolean.valueOf(z2));
        }
        return destination;
    }

    public static final Character maxOrNull(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (cArr.length == 0) {
            return null;
        }
        char c3 = cArr[0];
        int lastIndex = getLastIndex(cArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                char c4 = cArr[i3];
                if (Intrinsics.compare((int) c3, (int) c4) < 0) {
                    c3 = c4;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Character.valueOf(c3);
    }

    public static final Character minOrNull(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (cArr.length == 0) {
            return null;
        }
        char c3 = cArr[0];
        int lastIndex = getLastIndex(cArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                char c4 = cArr[i3];
                if (Intrinsics.compare((int) c3, (int) c4) > 0) {
                    c3 = c4;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Character.valueOf(c3);
    }

    public static final Pair<List<Boolean>, List<Boolean>> partition(boolean[] zArr, Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (boolean z2 : zArr) {
            if (((Boolean) predicate.invoke(Boolean.valueOf(z2))).booleanValue()) {
                arrayList.add(Boolean.valueOf(z2));
            } else {
                arrayList2.add(Boolean.valueOf(z2));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    public static final void shuffle(char[] cArr, Random random) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = getLastIndex(cArr); lastIndex > 0; lastIndex--) {
            int iJ = random.j(lastIndex + 1);
            char c3 = cArr[lastIndex];
            cArr[lastIndex] = cArr[iJ];
            cArr[iJ] = c3;
        }
    }

    public static final List<Boolean> take(boolean[] zArr, int i3) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        if (i3 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
        }
        if (i3 == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (i3 >= zArr.length) {
            return toList(zArr);
        }
        if (i3 == 1) {
            return CollectionsKt__CollectionsJVMKt.listOf(Boolean.valueOf(zArr[0]));
        }
        ArrayList arrayList = new ArrayList(i3);
        int i4 = 0;
        for (boolean z2 : zArr) {
            arrayList.add(Boolean.valueOf(z2));
            i4++;
            if (i4 == i3) {
                break;
            }
        }
        return arrayList;
    }

    public static final List<Boolean> takeLast(boolean[] zArr, int i3) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        if (i3 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
        }
        if (i3 == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        int length = zArr.length;
        if (i3 >= length) {
            return toList(zArr);
        }
        if (i3 == 1) {
            return CollectionsKt__CollectionsJVMKt.listOf(Boolean.valueOf(zArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i3);
        for (int i4 = length - i3; i4 < length; i4++) {
            arrayList.add(Boolean.valueOf(zArr[i4]));
        }
        return arrayList;
    }

    public static final char maxOrThrow(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (cArr.length != 0) {
            char c3 = cArr[0];
            int lastIndex = getLastIndex(cArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    char c4 = cArr[i3];
                    if (Intrinsics.compare((int) c3, (int) c4) < 0) {
                        c3 = c4;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return c3;
        }
        throw new NoSuchElementException();
    }

    public static final char minOrThrow(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (cArr.length != 0) {
            char c3 = cArr[0];
            int lastIndex = getLastIndex(cArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    char c4 = cArr[i3];
                    if (Intrinsics.compare((int) c3, (int) c4) > 0) {
                        c3 = c4;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return c3;
        }
        throw new NoSuchElementException();
    }

    public static void reverse(byte[] bArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i3, i4, bArr.length);
        int i5 = (i3 + i4) / 2;
        if (i3 == i5) {
            return;
        }
        int i6 = i4 - 1;
        while (i3 < i5) {
            byte b3 = bArr[i3];
            bArr[i3] = bArr[i6];
            bArr[i6] = b3;
            i6--;
            i3++;
        }
    }

    public static final double last(double[] dArr, Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = dArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i3 = length - 1;
                double d3 = dArr[length];
                if (!((Boolean) predicate.invoke(Double.valueOf(d3))).booleanValue()) {
                    if (i3 < 0) {
                        break;
                    }
                    length = i3;
                } else {
                    return d3;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final <R, V> List<V> zip(double[] dArr, Iterable<? extends R> other, Function2<? super Double, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = dArr.length;
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(other, 10), length));
        int i3 = 0;
        for (R r2 : other) {
            if (i3 >= length) {
                break;
            }
            arrayList.add(transform.invoke(Double.valueOf(dArr[i3]), r2));
            i3++;
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> associateBy(long[] jArr, Function1<? super Long, ? extends K> keySelector, Function1<? super Long, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt__MapsJVMKt.mapCapacity(jArr.length), 16));
        for (long j3 : jArr) {
            linkedHashMap.put(keySelector.invoke(Long.valueOf(j3)), valueTransform.invoke(Long.valueOf(j3)));
        }
        return linkedHashMap;
    }

    public static final <R extends Comparable<? super R>> Double maxByOrNull(double[] dArr, Function1<? super Double, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        double d3 = dArr[0];
        int lastIndex = getLastIndex(dArr);
        if (lastIndex == 0) {
            return Double.valueOf(d3);
        }
        Comparable comparable = (Comparable) selector.invoke(Double.valueOf(d3));
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                double d4 = dArr[i3];
                Comparable comparable2 = (Comparable) selector.invoke(Double.valueOf(d4));
                if (comparable.compareTo(comparable2) < 0) {
                    d3 = d4;
                    comparable = comparable2;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Double.valueOf(d3);
    }

    public static final <R extends Comparable<? super R>> Double minByOrNull(double[] dArr, Function1<? super Double, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        double d3 = dArr[0];
        int lastIndex = getLastIndex(dArr);
        if (lastIndex == 0) {
            return Double.valueOf(d3);
        }
        Comparable comparable = (Comparable) selector.invoke(Double.valueOf(d3));
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                double d4 = dArr[i3];
                Comparable comparable2 = (Comparable) selector.invoke(Double.valueOf(d4));
                if (comparable.compareTo(comparable2) > 0) {
                    d3 = d4;
                    comparable = comparable2;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Double.valueOf(d3);
    }

    public static final int single(int[] iArr, Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Integer numValueOf = null;
        boolean z2 = false;
        for (int i3 : iArr) {
            if (((Boolean) predicate.invoke(Integer.valueOf(i3))).booleanValue()) {
                if (!z2) {
                    numValueOf = Integer.valueOf(i3);
                    z2 = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (!z2) {
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
        Intrinsics.checkNotNull(numValueOf, SbbqvQlxi.FGfYNQrbcS);
        return numValueOf.intValue();
    }

    public static final List<Boolean> slice(boolean[] zArr, Iterable<Integer> indices) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        int iCollectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(indices, 10);
        if (iCollectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(Boolean.valueOf(zArr[it.next().intValue()]));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: maxOf, reason: collision with other method in class */
    private static final <T> float m1381maxOf(T[] tArr, Function1<? super T, Float> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (tArr.length != 0) {
            float fFloatValue = ((Number) selector.invoke(tArr[0])).floatValue();
            int lastIndex = getLastIndex(tArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = Math.max(fFloatValue, ((Number) selector.invoke(tArr[i3])).floatValue());
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final <T> Float m1408maxOfOrNull(T[] tArr, Function1<? super T, Float> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        float fFloatValue = ((Number) selector.invoke(tArr[0])).floatValue();
        int lastIndex = getLastIndex(tArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.max(fFloatValue, ((Number) selector.invoke(tArr[i3])).floatValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: renamed from: minOf, reason: collision with other method in class */
    private static final <T> float m1417minOf(T[] tArr, Function1<? super T, Float> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (tArr.length != 0) {
            float fFloatValue = ((Number) selector.invoke(tArr[0])).floatValue();
            int lastIndex = getLastIndex(tArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = Math.min(fFloatValue, ((Number) selector.invoke(tArr[i3])).floatValue());
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOfOrNull, reason: collision with other method in class */
    private static final <T> Float m1444minOfOrNull(T[] tArr, Function1<? super T, Float> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        float fFloatValue = ((Number) selector.invoke(tArr[0])).floatValue();
        int lastIndex = getLastIndex(tArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.min(fFloatValue, ((Number) selector.invoke(tArr[i3])).floatValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    public static final <A extends Appendable> A joinTo(char[] cArr, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i3, CharSequence truncated, Function1<? super Character, ? extends CharSequence> function1) throws IOException {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        buffer.append(prefix);
        int i4 = 0;
        for (char c3 : cArr) {
            i4++;
            if (i4 > 1) {
                buffer.append(separator);
            }
            if (i3 >= 0 && i4 > i3) {
                break;
            }
            if (function1 != null) {
                buffer.append((CharSequence) function1.invoke(Character.valueOf(c3)));
            } else {
                buffer.append(c3);
            }
        }
        if (i3 >= 0 && i4 > i3) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final boolean last(boolean[] zArr, Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = zArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i3 = length - 1;
                boolean z2 = zArr[length];
                if (!((Boolean) predicate.invoke(Boolean.valueOf(z2))).booleanValue()) {
                    if (i3 < 0) {
                        break;
                    }
                    length = i3;
                } else {
                    return z2;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static void reverse(short[] sArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i3, i4, sArr.length);
        int i5 = (i3 + i4) / 2;
        if (i3 == i5) {
            return;
        }
        int i6 = i4 - 1;
        while (i3 < i5) {
            short s2 = sArr[i3];
            sArr[i3] = sArr[i6];
            sArr[i6] = s2;
            i6--;
            i3++;
        }
    }

    public static final <R, V> List<V> zip(boolean[] zArr, Iterable<? extends R> other, Function2<? super Boolean, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = zArr.length;
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(other, 10), length));
        int i3 = 0;
        for (R r2 : other) {
            if (i3 >= length) {
                break;
            }
            arrayList.add(transform.invoke(Boolean.valueOf(zArr[i3]), r2));
            i3++;
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> associateBy(float[] fArr, Function1<? super Float, ? extends K> keySelector, Function1<? super Float, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt__MapsJVMKt.mapCapacity(fArr.length), 16));
        for (float f3 : fArr) {
            linkedHashMap.put(keySelector.invoke(Float.valueOf(f3)), valueTransform.invoke(Float.valueOf(f3)));
        }
        return linkedHashMap;
    }

    public static final <K> Map<K, List<Boolean>> groupBy(boolean[] zArr, Function1<? super Boolean, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (boolean z2 : zArr) {
            Object objInvoke = keySelector.invoke(Boolean.valueOf(z2));
            Object arrayList = linkedHashMap.get(objInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(objInvoke, arrayList);
            }
            ((List) arrayList).add(Boolean.valueOf(z2));
        }
        return linkedHashMap;
    }

    public static final <K, M extends Map<? super K, List<Character>>> M groupByTo(char[] cArr, M destination, Function1<? super Character, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (char c3 : cArr) {
            Object objInvoke = keySelector.invoke(Character.valueOf(c3));
            Object arrayList = destination.get(objInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(objInvoke, arrayList);
            }
            ((List) arrayList).add(Character.valueOf(c3));
        }
        return destination;
    }

    public static final <R extends Comparable<? super R>> boolean maxByOrThrow(boolean[] zArr, Function1<? super Boolean, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (zArr.length != 0) {
            boolean z2 = zArr[0];
            int lastIndex = getLastIndex(zArr);
            if (lastIndex != 0) {
                Comparable comparable = (Comparable) selector.invoke(Boolean.valueOf(z2));
                int i3 = 1;
                if (1 <= lastIndex) {
                    while (true) {
                        boolean z3 = zArr[i3];
                        Comparable comparable2 = (Comparable) selector.invoke(Boolean.valueOf(z3));
                        if (comparable.compareTo(comparable2) < 0) {
                            z2 = z3;
                            comparable = comparable2;
                        }
                        if (i3 == lastIndex) {
                            break;
                        }
                        i3++;
                    }
                }
            }
            return z2;
        }
        throw new NoSuchElementException();
    }

    public static final <R extends Comparable<? super R>> boolean minByOrThrow(boolean[] zArr, Function1<? super Boolean, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (zArr.length != 0) {
            boolean z2 = zArr[0];
            int lastIndex = getLastIndex(zArr);
            if (lastIndex != 0) {
                Comparable comparable = (Comparable) selector.invoke(Boolean.valueOf(z2));
                int i3 = 1;
                if (1 <= lastIndex) {
                    while (true) {
                        boolean z3 = zArr[i3];
                        Comparable comparable2 = (Comparable) selector.invoke(Boolean.valueOf(z3));
                        if (comparable.compareTo(comparable2) > 0) {
                            z2 = z3;
                            comparable = comparable2;
                        }
                        if (i3 == lastIndex) {
                            break;
                        }
                        i3++;
                    }
                }
            }
            return z2;
        }
        throw new NoSuchElementException();
    }

    public static final Pair<List<Character>, List<Character>> partition(char[] cArr, Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (char c3 : cArr) {
            if (((Boolean) predicate.invoke(Character.valueOf(c3))).booleanValue()) {
                arrayList.add(Character.valueOf(c3));
            } else {
                arrayList2.add(Character.valueOf(c3));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    public static final List<Character> take(char[] cArr, int i3) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (i3 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
        }
        if (i3 == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (i3 >= cArr.length) {
            return toList(cArr);
        }
        if (i3 == 1) {
            return CollectionsKt__CollectionsJVMKt.listOf(Character.valueOf(cArr[0]));
        }
        ArrayList arrayList = new ArrayList(i3);
        int i4 = 0;
        for (char c3 : cArr) {
            arrayList.add(Character.valueOf(c3));
            i4++;
            if (i4 == i3) {
                break;
            }
        }
        return arrayList;
    }

    public static final List<Character> takeLast(char[] cArr, int i3) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (i3 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
        }
        if (i3 == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        int length = cArr.length;
        if (i3 >= length) {
            return toList(cArr);
        }
        if (i3 == 1) {
            return CollectionsKt__CollectionsJVMKt.listOf(Character.valueOf(cArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i3);
        for (int i4 = length - i3; i4 < length; i4++) {
            arrayList.add(Character.valueOf(cArr[i4]));
        }
        return arrayList;
    }

    public static final long single(long[] jArr, Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Long lValueOf = null;
        boolean z2 = false;
        for (long j3 : jArr) {
            if (((Boolean) predicate.invoke(Long.valueOf(j3))).booleanValue()) {
                if (!z2) {
                    lValueOf = Long.valueOf(j3);
                    z2 = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (z2) {
            Intrinsics.checkNotNull(lValueOf, "null cannot be cast to non-null type kotlin.Long");
            return lValueOf.longValue();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final List<Character> slice(char[] cArr, Iterable<Integer> indices) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        int iCollectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(indices, 10);
        if (iCollectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(Character.valueOf(cArr[it.next().intValue()]));
        }
        return arrayList;
    }

    public static final char last(char[] cArr, Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = cArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i3 = length - 1;
                char c3 = cArr[length];
                if (!((Boolean) predicate.invoke(Character.valueOf(c3))).booleanValue()) {
                    if (i3 < 0) {
                        break;
                    }
                    length = i3;
                } else {
                    return c3;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final <R, V> List<V> zip(char[] cArr, Iterable<? extends R> other, Function2<? super Character, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = cArr.length;
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(other, 10), length));
        int i3 = 0;
        for (R r2 : other) {
            if (i3 >= length) {
                break;
            }
            arrayList.add(transform.invoke(Character.valueOf(cArr[i3]), r2));
            i3++;
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> associateBy(double[] dArr, Function1<? super Double, ? extends K> keySelector, Function1<? super Double, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt__MapsJVMKt.mapCapacity(dArr.length), 16));
        for (double d3 : dArr) {
            linkedHashMap.put(keySelector.invoke(Double.valueOf(d3)), valueTransform.invoke(Double.valueOf(d3)));
        }
        return linkedHashMap;
    }

    /* JADX INFO: renamed from: maxOf, reason: collision with other method in class */
    private static final float m1375maxOf(byte[] bArr, Function1<? super Byte, Float> selector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (bArr.length != 0) {
            float fFloatValue = ((Number) selector.invoke(Byte.valueOf(bArr[0]))).floatValue();
            int lastIndex = getLastIndex(bArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = Math.max(fFloatValue, ((Number) selector.invoke(Byte.valueOf(bArr[i3]))).floatValue());
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final Float m1402maxOfOrNull(byte[] bArr, Function1<? super Byte, Float> selector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        float fFloatValue = ((Number) selector.invoke(Byte.valueOf(bArr[0]))).floatValue();
        int lastIndex = getLastIndex(bArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.max(fFloatValue, ((Number) selector.invoke(Byte.valueOf(bArr[i3]))).floatValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: renamed from: minOf, reason: collision with other method in class */
    private static final float m1411minOf(byte[] bArr, Function1<? super Byte, Float> selector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (bArr.length != 0) {
            float fFloatValue = ((Number) selector.invoke(Byte.valueOf(bArr[0]))).floatValue();
            int lastIndex = getLastIndex(bArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = Math.min(fFloatValue, ((Number) selector.invoke(Byte.valueOf(bArr[i3]))).floatValue());
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOfOrNull, reason: collision with other method in class */
    private static final Float m1438minOfOrNull(byte[] bArr, Function1<? super Byte, Float> selector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        float fFloatValue = ((Number) selector.invoke(Byte.valueOf(bArr[0]))).floatValue();
        int lastIndex = getLastIndex(bArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.min(fFloatValue, ((Number) selector.invoke(Byte.valueOf(bArr[i3]))).floatValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    public static void reverse(int[] iArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i3, i4, iArr.length);
        int i5 = (i3 + i4) / 2;
        if (i3 == i5) {
            return;
        }
        int i6 = i4 - 1;
        while (i3 < i5) {
            int i7 = iArr[i3];
            iArr[i3] = iArr[i6];
            iArr[i6] = i7;
            i6--;
            i3++;
        }
    }

    public static final <R extends Comparable<? super R>> Boolean maxByOrNull(boolean[] zArr, Function1<? super Boolean, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        boolean z2 = zArr[0];
        int lastIndex = getLastIndex(zArr);
        if (lastIndex == 0) {
            return Boolean.valueOf(z2);
        }
        Comparable comparable = (Comparable) selector.invoke(Boolean.valueOf(z2));
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                boolean z3 = zArr[i3];
                Comparable comparable2 = (Comparable) selector.invoke(Boolean.valueOf(z3));
                if (comparable.compareTo(comparable2) < 0) {
                    z2 = z3;
                    comparable = comparable2;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Boolean.valueOf(z2);
    }

    public static final <R extends Comparable<? super R>> Boolean minByOrNull(boolean[] zArr, Function1<? super Boolean, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        boolean z2 = zArr[0];
        int lastIndex = getLastIndex(zArr);
        if (lastIndex == 0) {
            return Boolean.valueOf(z2);
        }
        Comparable comparable = (Comparable) selector.invoke(Boolean.valueOf(z2));
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                boolean z3 = zArr[i3];
                Comparable comparable2 = (Comparable) selector.invoke(Boolean.valueOf(z3));
                if (comparable.compareTo(comparable2) > 0) {
                    z2 = z3;
                    comparable = comparable2;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Boolean.valueOf(z2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K, V, M extends Map<? super K, List<V>>> M groupByTo(T[] tArr, M destination, Function1<? super T, ? extends K> keySelector, Function1<? super T, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (T t2 : tArr) {
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

    public static final <V> List<V> zip(byte[] bArr, byte[] other, Function2<? super Byte, ? super Byte, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iMin = Math.min(bArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i3 = 0; i3 < iMin; i3++) {
            arrayList.add(transform.invoke(Byte.valueOf(bArr[i3]), Byte.valueOf(other[i3])));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> associateBy(boolean[] zArr, Function1<? super Boolean, ? extends K> keySelector, Function1<? super Boolean, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt__MapsJVMKt.mapCapacity(zArr.length), 16));
        for (boolean z2 : zArr) {
            linkedHashMap.put(keySelector.invoke(Boolean.valueOf(z2)), valueTransform.invoke(Boolean.valueOf(z2)));
        }
        return linkedHashMap;
    }

    public static final <K> Map<K, List<Character>> groupBy(char[] cArr, Function1<? super Character, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (char c3 : cArr) {
            Object objInvoke = keySelector.invoke(Character.valueOf(c3));
            Object arrayList = linkedHashMap.get(objInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(objInvoke, arrayList);
            }
            ((List) arrayList).add(Character.valueOf(c3));
        }
        return linkedHashMap;
    }

    public static final <R extends Comparable<? super R>> char maxByOrThrow(char[] cArr, Function1<? super Character, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (cArr.length != 0) {
            char c3 = cArr[0];
            int lastIndex = getLastIndex(cArr);
            if (lastIndex != 0) {
                Comparable comparable = (Comparable) selector.invoke(Character.valueOf(c3));
                int i3 = 1;
                if (1 <= lastIndex) {
                    while (true) {
                        char c4 = cArr[i3];
                        Comparable comparable2 = (Comparable) selector.invoke(Character.valueOf(c4));
                        if (comparable.compareTo(comparable2) < 0) {
                            c3 = c4;
                            comparable = comparable2;
                        }
                        if (i3 == lastIndex) {
                            break;
                        }
                        i3++;
                    }
                }
            }
            return c3;
        }
        throw new NoSuchElementException();
    }

    public static final <R extends Comparable<? super R>> char minByOrThrow(char[] cArr, Function1<? super Character, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (cArr.length != 0) {
            char c3 = cArr[0];
            int lastIndex = getLastIndex(cArr);
            if (lastIndex != 0) {
                Comparable comparable = (Comparable) selector.invoke(Character.valueOf(c3));
                int i3 = 1;
                if (1 <= lastIndex) {
                    while (true) {
                        char c4 = cArr[i3];
                        Comparable comparable2 = (Comparable) selector.invoke(Character.valueOf(c4));
                        if (comparable.compareTo(comparable2) > 0) {
                            c3 = c4;
                            comparable = comparable2;
                        }
                        if (i3 == lastIndex) {
                            break;
                        }
                        i3++;
                    }
                }
            }
            return c3;
        }
        throw new NoSuchElementException();
    }

    public static final float single(float[] fArr, Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Float fValueOf = null;
        boolean z2 = false;
        for (float f3 : fArr) {
            if (((Boolean) predicate.invoke(Float.valueOf(f3))).booleanValue()) {
                if (!z2) {
                    fValueOf = Float.valueOf(f3);
                    z2 = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (z2) {
            Intrinsics.checkNotNull(fValueOf, "null cannot be cast to non-null type kotlin.Float");
            return fValueOf.floatValue();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static void reverse(long[] jArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i3, i4, jArr.length);
        int i5 = (i3 + i4) / 2;
        if (i3 == i5) {
            return;
        }
        int i6 = i4 - 1;
        while (i3 < i5) {
            long j3 = jArr[i3];
            jArr[i3] = jArr[i6];
            jArr[i6] = j3;
            i6--;
            i3++;
        }
    }

    /* JADX INFO: renamed from: maxOf, reason: collision with other method in class */
    private static final float m1382maxOf(short[] sArr, Function1<? super Short, Float> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (sArr.length != 0) {
            float fFloatValue = ((Number) selector.invoke(Short.valueOf(sArr[0]))).floatValue();
            int lastIndex = getLastIndex(sArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = Math.max(fFloatValue, ((Number) selector.invoke(Short.valueOf(sArr[i3]))).floatValue());
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final Float m1409maxOfOrNull(short[] sArr, Function1<? super Short, Float> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        float fFloatValue = ((Number) selector.invoke(Short.valueOf(sArr[0]))).floatValue();
        int lastIndex = getLastIndex(sArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.max(fFloatValue, ((Number) selector.invoke(Short.valueOf(sArr[i3]))).floatValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: renamed from: minOf, reason: collision with other method in class */
    private static final float m1418minOf(short[] sArr, Function1<? super Short, Float> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (sArr.length != 0) {
            float fFloatValue = ((Number) selector.invoke(Short.valueOf(sArr[0]))).floatValue();
            int lastIndex = getLastIndex(sArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = Math.min(fFloatValue, ((Number) selector.invoke(Short.valueOf(sArr[i3]))).floatValue());
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOfOrNull, reason: collision with other method in class */
    private static final Float m1445minOfOrNull(short[] sArr, Function1<? super Short, Float> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        float fFloatValue = ((Number) selector.invoke(Short.valueOf(sArr[0]))).floatValue();
        int lastIndex = getLastIndex(sArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.min(fFloatValue, ((Number) selector.invoke(Short.valueOf(sArr[i3]))).floatValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    public static final <V> List<V> zip(short[] sArr, short[] other, Function2<? super Short, ? super Short, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iMin = Math.min(sArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i3 = 0; i3 < iMin; i3++) {
            arrayList.add(transform.invoke(Short.valueOf(sArr[i3]), Short.valueOf(other[i3])));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> associateBy(char[] cArr, Function1<? super Character, ? extends K> keySelector, Function1<? super Character, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt__MapsJVMKt.mapCapacity(cArr.length), 16));
        for (char c3 : cArr) {
            linkedHashMap.put(keySelector.invoke(Character.valueOf(c3)), valueTransform.invoke(Character.valueOf(c3)));
        }
        return linkedHashMap;
    }

    public static final <V> List<V> zip(int[] iArr, int[] other, Function2<? super Integer, ? super Integer, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iMin = Math.min(iArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i3 = 0; i3 < iMin; i3++) {
            arrayList.add(transform.invoke(Integer.valueOf(iArr[i3]), Integer.valueOf(other[i3])));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(byte[] bArr, M destination, Function1<? super Byte, ? extends K> keySelector, Function1<? super Byte, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (byte b3 : bArr) {
            Object objInvoke = keySelector.invoke(Byte.valueOf(b3));
            Object arrayList = destination.get(objInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(objInvoke, arrayList);
            }
            ((List) arrayList).add(valueTransform.invoke(Byte.valueOf(b3)));
        }
        return destination;
    }

    public static final <R extends Comparable<? super R>> Character maxByOrNull(char[] cArr, Function1<? super Character, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        char c3 = cArr[0];
        int lastIndex = getLastIndex(cArr);
        if (lastIndex == 0) {
            return Character.valueOf(c3);
        }
        Comparable comparable = (Comparable) selector.invoke(Character.valueOf(c3));
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                char c4 = cArr[i3];
                Comparable comparable2 = (Comparable) selector.invoke(Character.valueOf(c4));
                if (comparable.compareTo(comparable2) < 0) {
                    c3 = c4;
                    comparable = comparable2;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Character.valueOf(c3);
    }

    public static final <R extends Comparable<? super R>> Character minByOrNull(char[] cArr, Function1<? super Character, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        char c3 = cArr[0];
        int lastIndex = getLastIndex(cArr);
        if (lastIndex == 0) {
            return Character.valueOf(c3);
        }
        Comparable comparable = (Comparable) selector.invoke(Character.valueOf(c3));
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                char c4 = cArr[i3];
                Comparable comparable2 = (Comparable) selector.invoke(Character.valueOf(c4));
                if (comparable.compareTo(comparable2) > 0) {
                    c3 = c4;
                    comparable = comparable2;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Character.valueOf(c3);
    }

    public static final void reverse(float[] fArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i3, i4, fArr.length);
        int i5 = (i3 + i4) / 2;
        if (i3 == i5) {
            return;
        }
        int i6 = i4 - 1;
        while (i3 < i5) {
            float f3 = fArr[i3];
            fArr[i3] = fArr[i6];
            fArr[i6] = f3;
            i6--;
            i3++;
        }
    }

    public static final double single(double[] dArr, Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Double dValueOf = null;
        boolean z2 = false;
        for (double d3 : dArr) {
            if (((Boolean) predicate.invoke(Double.valueOf(d3))).booleanValue()) {
                if (!z2) {
                    dValueOf = Double.valueOf(d3);
                    z2 = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (z2) {
            Intrinsics.checkNotNull(dValueOf, "null cannot be cast to non-null type kotlin.Double");
            return dValueOf.doubleValue();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K, V> Map<K, List<V>> groupBy(T[] tArr, Function1<? super T, ? extends K> keySelector, Function1<? super T, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t2 : tArr) {
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

    /* JADX INFO: renamed from: maxOf, reason: collision with other method in class */
    private static final float m1379maxOf(int[] iArr, Function1<? super Integer, Float> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (iArr.length != 0) {
            float fFloatValue = ((Number) selector.invoke(Integer.valueOf(iArr[0]))).floatValue();
            int lastIndex = getLastIndex(iArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = Math.max(fFloatValue, ((Number) selector.invoke(Integer.valueOf(iArr[i3]))).floatValue());
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final Float m1406maxOfOrNull(int[] iArr, Function1<? super Integer, Float> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        float fFloatValue = ((Number) selector.invoke(Integer.valueOf(iArr[0]))).floatValue();
        int lastIndex = getLastIndex(iArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.max(fFloatValue, ((Number) selector.invoke(Integer.valueOf(iArr[i3]))).floatValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: renamed from: minOf, reason: collision with other method in class */
    private static final float m1415minOf(int[] iArr, Function1<? super Integer, Float> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (iArr.length != 0) {
            float fFloatValue = ((Number) selector.invoke(Integer.valueOf(iArr[0]))).floatValue();
            int lastIndex = getLastIndex(iArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = Math.min(fFloatValue, ((Number) selector.invoke(Integer.valueOf(iArr[i3]))).floatValue());
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOfOrNull, reason: collision with other method in class */
    private static final Float m1442minOfOrNull(int[] iArr, Function1<? super Integer, Float> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        float fFloatValue = ((Number) selector.invoke(Integer.valueOf(iArr[0]))).floatValue();
        int lastIndex = getLastIndex(iArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.min(fFloatValue, ((Number) selector.invoke(Integer.valueOf(iArr[i3]))).floatValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    public static final <V> List<V> zip(long[] jArr, long[] other, Function2<? super Long, ? super Long, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iMin = Math.min(jArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i3 = 0; i3 < iMin; i3++) {
            arrayList.add(transform.invoke(Long.valueOf(jArr[i3]), Long.valueOf(other[i3])));
        }
        return arrayList;
    }

    public static final void reverse(double[] dArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i3, i4, dArr.length);
        int i5 = (i3 + i4) / 2;
        if (i3 == i5) {
            return;
        }
        int i6 = i4 - 1;
        while (i3 < i5) {
            double d3 = dArr[i3];
            dArr[i3] = dArr[i6];
            dArr[i6] = d3;
            i6--;
            i3++;
        }
    }

    public static final <V> List<V> zip(float[] fArr, float[] other, Function2<? super Float, ? super Float, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iMin = Math.min(fArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i3 = 0; i3 < iMin; i3++) {
            arrayList.add(transform.invoke(Float.valueOf(fArr[i3]), Float.valueOf(other[i3])));
        }
        return arrayList;
    }

    public static final boolean single(boolean[] zArr, Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Boolean boolValueOf = null;
        boolean z2 = false;
        for (boolean z3 : zArr) {
            if (((Boolean) predicate.invoke(Boolean.valueOf(z3))).booleanValue()) {
                if (!z2) {
                    boolValueOf = Boolean.valueOf(z3);
                    z2 = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (z2) {
            Intrinsics.checkNotNull(boolValueOf, "null cannot be cast to non-null type kotlin.Boolean");
            return boolValueOf.booleanValue();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(short[] sArr, M destination, Function1<? super Short, ? extends K> keySelector, Function1<? super Short, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (short s2 : sArr) {
            Object objInvoke = keySelector.invoke(Short.valueOf(s2));
            Object arrayList = destination.get(objInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(objInvoke, arrayList);
            }
            ((List) arrayList).add(valueTransform.invoke(Short.valueOf(s2)));
        }
        return destination;
    }

    /* JADX INFO: renamed from: maxOf, reason: collision with other method in class */
    private static final float m1380maxOf(long[] jArr, Function1<? super Long, Float> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (jArr.length != 0) {
            float fFloatValue = ((Number) selector.invoke(Long.valueOf(jArr[0]))).floatValue();
            int lastIndex = getLastIndex(jArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = Math.max(fFloatValue, ((Number) selector.invoke(Long.valueOf(jArr[i3]))).floatValue());
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final Float m1407maxOfOrNull(long[] jArr, Function1<? super Long, Float> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        float fFloatValue = ((Number) selector.invoke(Long.valueOf(jArr[0]))).floatValue();
        int lastIndex = getLastIndex(jArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.max(fFloatValue, ((Number) selector.invoke(Long.valueOf(jArr[i3]))).floatValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: renamed from: minOf, reason: collision with other method in class */
    private static final float m1416minOf(long[] jArr, Function1<? super Long, Float> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (jArr.length != 0) {
            float fFloatValue = ((Number) selector.invoke(Long.valueOf(jArr[0]))).floatValue();
            int lastIndex = getLastIndex(jArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = Math.min(fFloatValue, ((Number) selector.invoke(Long.valueOf(jArr[i3]))).floatValue());
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOfOrNull, reason: collision with other method in class */
    private static final Float m1443minOfOrNull(long[] jArr, Function1<? super Long, Float> selector) {
        Intrinsics.checkNotNullParameter(jArr, lisODU.GnhYfUsFEpDBX);
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        float fFloatValue = ((Number) selector.invoke(Long.valueOf(jArr[0]))).floatValue();
        int lastIndex = getLastIndex(jArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.min(fFloatValue, ((Number) selector.invoke(Long.valueOf(jArr[i3]))).floatValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    public static final <V> List<V> zip(double[] dArr, double[] other, Function2<? super Double, ? super Double, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iMin = Math.min(dArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i3 = 0; i3 < iMin; i3++) {
            arrayList.add(transform.invoke(Double.valueOf(dArr[i3]), Double.valueOf(other[i3])));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, List<V>> groupBy(byte[] bArr, Function1<? super Byte, ? extends K> keySelector, Function1<? super Byte, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (byte b3 : bArr) {
            Object objInvoke = keySelector.invoke(Byte.valueOf(b3));
            Object arrayList = linkedHashMap.get(objInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(objInvoke, arrayList);
            }
            ((List) arrayList).add(valueTransform.invoke(Byte.valueOf(b3)));
        }
        return linkedHashMap;
    }

    public static final void reverse(boolean[] zArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i3, i4, zArr.length);
        int i5 = (i3 + i4) / 2;
        if (i3 == i5) {
            return;
        }
        int i6 = i4 - 1;
        while (i3 < i5) {
            boolean z2 = zArr[i3];
            zArr[i3] = zArr[i6];
            zArr[i6] = z2;
            i6--;
            i3++;
        }
    }

    public static final <V> List<V> zip(boolean[] zArr, boolean[] other, Function2<? super Boolean, ? super Boolean, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iMin = Math.min(zArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i3 = 0; i3 < iMin; i3++) {
            arrayList.add(transform.invoke(Boolean.valueOf(zArr[i3]), Boolean.valueOf(other[i3])));
        }
        return arrayList;
    }

    public static final char single(char[] cArr, Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Character chValueOf = null;
        boolean z2 = false;
        for (char c3 : cArr) {
            if (((Boolean) predicate.invoke(Character.valueOf(c3))).booleanValue()) {
                if (!z2) {
                    chValueOf = Character.valueOf(c3);
                    z2 = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (z2) {
            Intrinsics.checkNotNull(chValueOf, "null cannot be cast to non-null type kotlin.Char");
            return chValueOf.charValue();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(int[] iArr, M destination, Function1<? super Integer, ? extends K> keySelector, Function1<? super Integer, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (int i3 : iArr) {
            Object objInvoke = keySelector.invoke(Integer.valueOf(i3));
            Object arrayList = destination.get(objInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(objInvoke, arrayList);
            }
            ((List) arrayList).add(valueTransform.invoke(Integer.valueOf(i3)));
        }
        return destination;
    }

    /* JADX INFO: renamed from: maxOf, reason: collision with other method in class */
    private static final float m1378maxOf(float[] fArr, Function1<? super Float, Float> selector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (fArr.length != 0) {
            float fFloatValue = ((Number) selector.invoke(Float.valueOf(fArr[0]))).floatValue();
            int lastIndex = getLastIndex(fArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = Math.max(fFloatValue, ((Number) selector.invoke(Float.valueOf(fArr[i3]))).floatValue());
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final Float m1405maxOfOrNull(float[] fArr, Function1<? super Float, Float> selector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        float fFloatValue = ((Number) selector.invoke(Float.valueOf(fArr[0]))).floatValue();
        int lastIndex = getLastIndex(fArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.max(fFloatValue, ((Number) selector.invoke(Float.valueOf(fArr[i3]))).floatValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: renamed from: minOf, reason: collision with other method in class */
    private static final float m1414minOf(float[] fArr, Function1<? super Float, Float> selector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (fArr.length != 0) {
            float fFloatValue = ((Number) selector.invoke(Float.valueOf(fArr[0]))).floatValue();
            int lastIndex = getLastIndex(fArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = Math.min(fFloatValue, ((Number) selector.invoke(Float.valueOf(fArr[i3]))).floatValue());
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOfOrNull, reason: collision with other method in class */
    private static final Float m1441minOfOrNull(float[] fArr, Function1<? super Float, Float> selector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        float fFloatValue = ((Number) selector.invoke(Float.valueOf(fArr[0]))).floatValue();
        int lastIndex = getLastIndex(fArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.min(fFloatValue, ((Number) selector.invoke(Float.valueOf(fArr[i3]))).floatValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    public static final <V> List<V> zip(char[] cArr, char[] other, Function2<? super Character, ? super Character, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int iMin = Math.min(cArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i3 = 0; i3 < iMin; i3++) {
            arrayList.add(transform.invoke(Character.valueOf(cArr[i3]), Character.valueOf(other[i3])));
        }
        return arrayList;
    }

    public static final void reverse(char[] cArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i3, i4, cArr.length);
        int i5 = (i3 + i4) / 2;
        if (i3 == i5) {
            return;
        }
        int i6 = i4 - 1;
        while (i3 < i5) {
            char c3 = cArr[i3];
            cArr[i3] = cArr[i6];
            cArr[i6] = c3;
            i6--;
            i3++;
        }
    }

    public static <T, R> List<Pair<T, R>> zip(T[] tArr, R[] other) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int iMin = Math.min(tArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i3 = 0; i3 < iMin; i3++) {
            arrayList.add(TuplesKt.a(tArr[i3], other[i3]));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, List<V>> groupBy(short[] sArr, Function1<? super Short, ? extends K> keySelector, Function1<? super Short, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (short s2 : sArr) {
            Object objInvoke = keySelector.invoke(Short.valueOf(s2));
            Object arrayList = linkedHashMap.get(objInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(objInvoke, arrayList);
            }
            ((List) arrayList).add(valueTransform.invoke(Short.valueOf(s2)));
        }
        return linkedHashMap;
    }

    /* JADX INFO: renamed from: maxOf, reason: collision with other method in class */
    private static final float m1377maxOf(double[] dArr, Function1<? super Double, Float> selector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (dArr.length != 0) {
            float fFloatValue = ((Number) selector.invoke(Double.valueOf(dArr[0]))).floatValue();
            int lastIndex = getLastIndex(dArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = Math.max(fFloatValue, ((Number) selector.invoke(Double.valueOf(dArr[i3]))).floatValue());
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final Float m1404maxOfOrNull(double[] dArr, Function1<? super Double, Float> selector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        float fFloatValue = ((Number) selector.invoke(Double.valueOf(dArr[0]))).floatValue();
        int lastIndex = getLastIndex(dArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.max(fFloatValue, ((Number) selector.invoke(Double.valueOf(dArr[i3]))).floatValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: renamed from: minOf, reason: collision with other method in class */
    private static final float m1413minOf(double[] dArr, Function1<? super Double, Float> selector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (dArr.length != 0) {
            float fFloatValue = ((Number) selector.invoke(Double.valueOf(dArr[0]))).floatValue();
            int lastIndex = getLastIndex(dArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = Math.min(fFloatValue, ((Number) selector.invoke(Double.valueOf(dArr[i3]))).floatValue());
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOfOrNull, reason: collision with other method in class */
    private static final Float m1440minOfOrNull(double[] dArr, Function1<? super Double, Float> selector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        float fFloatValue = ((Number) selector.invoke(Double.valueOf(dArr[0]))).floatValue();
        int lastIndex = getLastIndex(dArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.min(fFloatValue, ((Number) selector.invoke(Double.valueOf(dArr[i3]))).floatValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(long[] jArr, M destination, Function1<? super Long, ? extends K> keySelector, Function1<? super Long, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (long j3 : jArr) {
            Object objInvoke = keySelector.invoke(Long.valueOf(j3));
            Object arrayList = destination.get(objInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(objInvoke, arrayList);
            }
            ((List) arrayList).add(valueTransform.invoke(Long.valueOf(j3)));
        }
        return destination;
    }

    public static final <R> List<Pair<Byte, R>> zip(byte[] bArr, R[] other) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int iMin = Math.min(bArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i3 = 0; i3 < iMin; i3++) {
            byte b3 = bArr[i3];
            arrayList.add(TuplesKt.a(Byte.valueOf(b3), other[i3]));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, List<V>> groupBy(int[] iArr, Function1<? super Integer, ? extends K> keySelector, Function1<? super Integer, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i3 : iArr) {
            Object objInvoke = keySelector.invoke(Integer.valueOf(i3));
            Object arrayList = linkedHashMap.get(objInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(objInvoke, arrayList);
            }
            ((List) arrayList).add(valueTransform.invoke(Integer.valueOf(i3)));
        }
        return linkedHashMap;
    }

    /* JADX INFO: renamed from: maxOf, reason: collision with other method in class */
    private static final float m1383maxOf(boolean[] zArr, Function1<? super Boolean, Float> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (zArr.length != 0) {
            float fFloatValue = ((Number) selector.invoke(Boolean.valueOf(zArr[0]))).floatValue();
            int lastIndex = getLastIndex(zArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = Math.max(fFloatValue, ((Number) selector.invoke(Boolean.valueOf(zArr[i3]))).floatValue());
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final Float m1410maxOfOrNull(boolean[] zArr, Function1<? super Boolean, Float> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        float fFloatValue = ((Number) selector.invoke(Boolean.valueOf(zArr[0]))).floatValue();
        int lastIndex = getLastIndex(zArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.max(fFloatValue, ((Number) selector.invoke(Boolean.valueOf(zArr[i3]))).floatValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: renamed from: minOf, reason: collision with other method in class */
    private static final float m1419minOf(boolean[] zArr, Function1<? super Boolean, Float> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (zArr.length != 0) {
            float fFloatValue = ((Number) selector.invoke(Boolean.valueOf(zArr[0]))).floatValue();
            int lastIndex = getLastIndex(zArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = Math.min(fFloatValue, ((Number) selector.invoke(Boolean.valueOf(zArr[i3]))).floatValue());
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOfOrNull, reason: collision with other method in class */
    private static final Float m1446minOfOrNull(boolean[] zArr, Function1<? super Boolean, Float> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        float fFloatValue = ((Number) selector.invoke(Boolean.valueOf(zArr[0]))).floatValue();
        int lastIndex = getLastIndex(zArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.min(fFloatValue, ((Number) selector.invoke(Boolean.valueOf(zArr[i3]))).floatValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    public static final <R> List<Pair<Short, R>> zip(short[] sArr, R[] other) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int iMin = Math.min(sArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i3 = 0; i3 < iMin; i3++) {
            short s2 = sArr[i3];
            arrayList.add(TuplesKt.a(Short.valueOf(s2), other[i3]));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(float[] fArr, M destination, Function1<? super Float, ? extends K> keySelector, Function1<? super Float, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (float f3 : fArr) {
            Object objInvoke = keySelector.invoke(Float.valueOf(f3));
            Object arrayList = destination.get(objInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(objInvoke, arrayList);
            }
            ((List) arrayList).add(valueTransform.invoke(Float.valueOf(f3)));
        }
        return destination;
    }

    /* JADX INFO: renamed from: maxOf, reason: collision with other method in class */
    private static final float m1376maxOf(char[] cArr, Function1<? super Character, Float> selector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (cArr.length != 0) {
            float fFloatValue = ((Number) selector.invoke(Character.valueOf(cArr[0]))).floatValue();
            int lastIndex = getLastIndex(cArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = Math.max(fFloatValue, ((Number) selector.invoke(Character.valueOf(cArr[i3]))).floatValue());
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final Float m1403maxOfOrNull(char[] cArr, Function1<? super Character, Float> selector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        float fFloatValue = ((Number) selector.invoke(Character.valueOf(cArr[0]))).floatValue();
        int lastIndex = getLastIndex(cArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.max(fFloatValue, ((Number) selector.invoke(Character.valueOf(cArr[i3]))).floatValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: renamed from: minOf, reason: collision with other method in class */
    private static final float m1412minOf(char[] cArr, Function1<? super Character, Float> selector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (cArr.length != 0) {
            float fFloatValue = ((Number) selector.invoke(Character.valueOf(cArr[0]))).floatValue();
            int lastIndex = getLastIndex(cArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = Math.min(fFloatValue, ((Number) selector.invoke(Character.valueOf(cArr[i3]))).floatValue());
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOfOrNull, reason: collision with other method in class */
    private static final Float m1439minOfOrNull(char[] cArr, Function1<? super Character, Float> selector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        float fFloatValue = ((Number) selector.invoke(Character.valueOf(cArr[0]))).floatValue();
        int lastIndex = getLastIndex(cArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.min(fFloatValue, ((Number) selector.invoke(Character.valueOf(cArr[i3]))).floatValue());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    public static final <R> List<Pair<Integer, R>> zip(int[] iArr, R[] other) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int iMin = Math.min(iArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i3 = 0; i3 < iMin; i3++) {
            int i4 = iArr[i3];
            arrayList.add(TuplesKt.a(Integer.valueOf(i4), other[i3]));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, List<V>> groupBy(long[] jArr, Function1<? super Long, ? extends K> keySelector, Function1<? super Long, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (long j3 : jArr) {
            Object objInvoke = keySelector.invoke(Long.valueOf(j3));
            Object arrayList = linkedHashMap.get(objInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(objInvoke, arrayList);
            }
            ((List) arrayList).add(valueTransform.invoke(Long.valueOf(j3)));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(double[] dArr, M destination, Function1<? super Double, ? extends K> keySelector, Function1<? super Double, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (double d3 : dArr) {
            Object objInvoke = keySelector.invoke(Double.valueOf(d3));
            Object arrayList = destination.get(objInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(objInvoke, arrayList);
            }
            ((List) arrayList).add(valueTransform.invoke(Double.valueOf(d3)));
        }
        return destination;
    }

    public static final <R> List<Pair<Long, R>> zip(long[] jArr, R[] other) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int iMin = Math.min(jArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i3 = 0; i3 < iMin; i3++) {
            long j3 = jArr[i3];
            arrayList.add(TuplesKt.a(Long.valueOf(j3), other[i3]));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: maxOf, reason: collision with other method in class */
    private static final <T, R extends Comparable<? super R>> R m1390maxOf(T[] tArr, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (tArr.length != 0) {
            R r2 = (R) selector.invoke(tArr[0]);
            int lastIndex = getLastIndex(tArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable comparable = (Comparable) selector.invoke(tArr[i3]);
                    if (r2.compareTo(comparable) < 0) {
                        r2 = (R) comparable;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return r2;
        }
        throw new NoSuchElementException();
    }

    private static final <T, R extends Comparable<? super R>> R maxOfOrNull(T[] tArr, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        R r2 = (R) selector.invoke(tArr[0]);
        int lastIndex = getLastIndex(tArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Comparable comparable = (Comparable) selector.invoke(tArr[i3]);
                if (r2.compareTo(comparable) < 0) {
                    r2 = (R) comparable;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    /* JADX INFO: renamed from: minOf, reason: collision with other method in class */
    private static final <T, R extends Comparable<? super R>> R m1426minOf(T[] tArr, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (tArr.length != 0) {
            R r2 = (R) selector.invoke(tArr[0]);
            int lastIndex = getLastIndex(tArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable comparable = (Comparable) selector.invoke(tArr[i3]);
                    if (r2.compareTo(comparable) > 0) {
                        r2 = (R) comparable;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return r2;
        }
        throw new NoSuchElementException();
    }

    private static final <T, R extends Comparable<? super R>> R minOfOrNull(T[] tArr, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        R r2 = (R) selector.invoke(tArr[0]);
        int lastIndex = getLastIndex(tArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Comparable comparable = (Comparable) selector.invoke(tArr[i3]);
                if (r2.compareTo(comparable) > 0) {
                    r2 = (R) comparable;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, List<V>> groupBy(float[] fArr, Function1<? super Float, ? extends K> keySelector, Function1<? super Float, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (float f3 : fArr) {
            Object objInvoke = keySelector.invoke(Float.valueOf(f3));
            Object arrayList = linkedHashMap.get(objInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(objInvoke, arrayList);
            }
            ((List) arrayList).add(valueTransform.invoke(Float.valueOf(f3)));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(boolean[] zArr, M destination, Function1<? super Boolean, ? extends K> keySelector, Function1<? super Boolean, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (boolean z2 : zArr) {
            Object objInvoke = keySelector.invoke(Boolean.valueOf(z2));
            Object arrayList = destination.get(objInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(objInvoke, arrayList);
            }
            ((List) arrayList).add(valueTransform.invoke(Boolean.valueOf(z2)));
        }
        return destination;
    }

    public static final <R> List<Pair<Float, R>> zip(float[] fArr, R[] other) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int iMin = Math.min(fArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i3 = 0; i3 < iMin; i3++) {
            float f3 = fArr[i3];
            arrayList.add(TuplesKt.a(Float.valueOf(f3), other[i3]));
        }
        return arrayList;
    }

    private static final <R extends Comparable<? super R>> R maxOfOrNull(byte[] bArr, Function1<? super Byte, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        R r2 = (R) selector.invoke(Byte.valueOf(bArr[0]));
        int lastIndex = getLastIndex(bArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Comparable comparable = (Comparable) selector.invoke(Byte.valueOf(bArr[i3]));
                if (r2.compareTo(comparable) < 0) {
                    r2 = (R) comparable;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    private static final <R extends Comparable<? super R>> R minOfOrNull(byte[] bArr, Function1<? super Byte, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        R r2 = (R) selector.invoke(Byte.valueOf(bArr[0]));
        int lastIndex = getLastIndex(bArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Comparable comparable = (Comparable) selector.invoke(Byte.valueOf(bArr[i3]));
                if (r2.compareTo(comparable) > 0) {
                    r2 = (R) comparable;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    /* JADX INFO: renamed from: maxOf, reason: collision with other method in class */
    private static final <R extends Comparable<? super R>> R m1384maxOf(byte[] bArr, Function1<? super Byte, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (bArr.length != 0) {
            R r2 = (R) selector.invoke(Byte.valueOf(bArr[0]));
            int lastIndex = getLastIndex(bArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable comparable = (Comparable) selector.invoke(Byte.valueOf(bArr[i3]));
                    if (r2.compareTo(comparable) < 0) {
                        r2 = (R) comparable;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return r2;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOf, reason: collision with other method in class */
    private static final <R extends Comparable<? super R>> R m1420minOf(byte[] bArr, Function1<? super Byte, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (bArr.length != 0) {
            R r2 = (R) selector.invoke(Byte.valueOf(bArr[0]));
            int lastIndex = getLastIndex(bArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable comparable = (Comparable) selector.invoke(Byte.valueOf(bArr[i3]));
                    if (r2.compareTo(comparable) > 0) {
                        r2 = (R) comparable;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return r2;
        }
        throw new NoSuchElementException();
    }

    public static final <R> List<Pair<Double, R>> zip(double[] dArr, R[] other) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int iMin = Math.min(dArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i3 = 0; i3 < iMin; i3++) {
            double d3 = dArr[i3];
            arrayList.add(TuplesKt.a(Double.valueOf(d3), other[i3]));
        }
        return arrayList;
    }

    private static final <R extends Comparable<? super R>> R maxOfOrNull(short[] sArr, Function1<? super Short, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        R r2 = (R) selector.invoke(Short.valueOf(sArr[0]));
        int lastIndex = getLastIndex(sArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Comparable comparable = (Comparable) selector.invoke(Short.valueOf(sArr[i3]));
                if (r2.compareTo(comparable) < 0) {
                    r2 = (R) comparable;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    private static final <R extends Comparable<? super R>> R minOfOrNull(short[] sArr, Function1<? super Short, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        R r2 = (R) selector.invoke(Short.valueOf(sArr[0]));
        int lastIndex = getLastIndex(sArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Comparable comparable = (Comparable) selector.invoke(Short.valueOf(sArr[i3]));
                if (r2.compareTo(comparable) > 0) {
                    r2 = (R) comparable;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(char[] cArr, M destination, Function1<? super Character, ? extends K> keySelector, Function1<? super Character, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (char c3 : cArr) {
            Object objInvoke = keySelector.invoke(Character.valueOf(c3));
            Object arrayList = destination.get(objInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(objInvoke, arrayList);
            }
            ((List) arrayList).add(valueTransform.invoke(Character.valueOf(c3)));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, List<V>> groupBy(double[] dArr, Function1<? super Double, ? extends K> keySelector, Function1<? super Double, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (double d3 : dArr) {
            Object objInvoke = keySelector.invoke(Double.valueOf(d3));
            Object arrayList = linkedHashMap.get(objInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(objInvoke, arrayList);
            }
            ((List) arrayList).add(valueTransform.invoke(Double.valueOf(d3)));
        }
        return linkedHashMap;
    }

    /* JADX INFO: renamed from: maxOf, reason: collision with other method in class */
    private static final <R extends Comparable<? super R>> R m1391maxOf(short[] sArr, Function1<? super Short, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (sArr.length != 0) {
            R r2 = (R) selector.invoke(Short.valueOf(sArr[0]));
            int lastIndex = getLastIndex(sArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable comparable = (Comparable) selector.invoke(Short.valueOf(sArr[i3]));
                    if (r2.compareTo(comparable) < 0) {
                        r2 = (R) comparable;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return r2;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOf, reason: collision with other method in class */
    private static final <R extends Comparable<? super R>> R m1427minOf(short[] sArr, Function1<? super Short, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (sArr.length != 0) {
            R r2 = (R) selector.invoke(Short.valueOf(sArr[0]));
            int lastIndex = getLastIndex(sArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable comparable = (Comparable) selector.invoke(Short.valueOf(sArr[i3]));
                    if (r2.compareTo(comparable) > 0) {
                        r2 = (R) comparable;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return r2;
        }
        throw new NoSuchElementException();
    }

    public static final <R> List<Pair<Boolean, R>> zip(boolean[] zArr, R[] other) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int iMin = Math.min(zArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i3 = 0; i3 < iMin; i3++) {
            boolean z2 = zArr[i3];
            arrayList.add(TuplesKt.a(Boolean.valueOf(z2), other[i3]));
        }
        return arrayList;
    }

    private static final <R extends Comparable<? super R>> R maxOfOrNull(int[] iArr, Function1<? super Integer, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        R r2 = (R) selector.invoke(Integer.valueOf(iArr[0]));
        int lastIndex = getLastIndex(iArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Comparable comparable = (Comparable) selector.invoke(Integer.valueOf(iArr[i3]));
                if (r2.compareTo(comparable) < 0) {
                    r2 = (R) comparable;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    private static final <R extends Comparable<? super R>> R minOfOrNull(int[] iArr, Function1<? super Integer, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        R r2 = (R) selector.invoke(Integer.valueOf(iArr[0]));
        int lastIndex = getLastIndex(iArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Comparable comparable = (Comparable) selector.invoke(Integer.valueOf(iArr[i3]));
                if (r2.compareTo(comparable) > 0) {
                    r2 = (R) comparable;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    /* JADX INFO: renamed from: maxOf, reason: collision with other method in class */
    private static final <R extends Comparable<? super R>> R m1388maxOf(int[] iArr, Function1<? super Integer, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (iArr.length != 0) {
            R r2 = (R) selector.invoke(Integer.valueOf(iArr[0]));
            int lastIndex = getLastIndex(iArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable comparable = (Comparable) selector.invoke(Integer.valueOf(iArr[i3]));
                    if (r2.compareTo(comparable) < 0) {
                        r2 = (R) comparable;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return r2;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOf, reason: collision with other method in class */
    private static final <R extends Comparable<? super R>> R m1424minOf(int[] iArr, Function1<? super Integer, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (iArr.length != 0) {
            R r2 = (R) selector.invoke(Integer.valueOf(iArr[0]));
            int lastIndex = getLastIndex(iArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable comparable = (Comparable) selector.invoke(Integer.valueOf(iArr[i3]));
                    if (r2.compareTo(comparable) > 0) {
                        r2 = (R) comparable;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return r2;
        }
        throw new NoSuchElementException();
    }

    public static final <R> List<Pair<Character, R>> zip(char[] cArr, R[] other) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int iMin = Math.min(cArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i3 = 0; i3 < iMin; i3++) {
            char c3 = cArr[i3];
            arrayList.add(TuplesKt.a(Character.valueOf(c3), other[i3]));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, List<V>> groupBy(boolean[] zArr, Function1<? super Boolean, ? extends K> keySelector, Function1<? super Boolean, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (boolean z2 : zArr) {
            Object objInvoke = keySelector.invoke(Boolean.valueOf(z2));
            Object arrayList = linkedHashMap.get(objInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(objInvoke, arrayList);
            }
            ((List) arrayList).add(valueTransform.invoke(Boolean.valueOf(z2)));
        }
        return linkedHashMap;
    }

    private static final <R extends Comparable<? super R>> R maxOfOrNull(long[] jArr, Function1<? super Long, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        R r2 = (R) selector.invoke(Long.valueOf(jArr[0]));
        int lastIndex = getLastIndex(jArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Comparable comparable = (Comparable) selector.invoke(Long.valueOf(jArr[i3]));
                if (r2.compareTo(comparable) < 0) {
                    r2 = (R) comparable;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    private static final <R extends Comparable<? super R>> R minOfOrNull(long[] jArr, Function1<? super Long, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        R r2 = (R) selector.invoke(Long.valueOf(jArr[0]));
        int lastIndex = getLastIndex(jArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Comparable comparable = (Comparable) selector.invoke(Long.valueOf(jArr[i3]));
                if (r2.compareTo(comparable) > 0) {
                    r2 = (R) comparable;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    /* JADX INFO: renamed from: maxOf, reason: collision with other method in class */
    private static final <R extends Comparable<? super R>> R m1389maxOf(long[] jArr, Function1<? super Long, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (jArr.length != 0) {
            R r2 = (R) selector.invoke(Long.valueOf(jArr[0]));
            int lastIndex = getLastIndex(jArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable comparable = (Comparable) selector.invoke(Long.valueOf(jArr[i3]));
                    if (r2.compareTo(comparable) < 0) {
                        r2 = (R) comparable;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return r2;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOf, reason: collision with other method in class */
    private static final <R extends Comparable<? super R>> R m1425minOf(long[] jArr, Function1<? super Long, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (jArr.length != 0) {
            R r2 = (R) selector.invoke(Long.valueOf(jArr[0]));
            int lastIndex = getLastIndex(jArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable comparable = (Comparable) selector.invoke(Long.valueOf(jArr[i3]));
                    if (r2.compareTo(comparable) > 0) {
                        r2 = (R) comparable;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return r2;
        }
        throw new NoSuchElementException();
    }

    public static final <T, R> List<Pair<T, R>> zip(T[] tArr, Iterable<? extends R> other) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int length = tArr.length;
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(other, 10), length));
        int i3 = 0;
        for (R r2 : other) {
            if (i3 >= length) {
                break;
            }
            arrayList.add(TuplesKt.a(tArr[i3], r2));
            i3++;
        }
        return arrayList;
    }

    private static final <R extends Comparable<? super R>> R maxOfOrNull(float[] fArr, Function1<? super Float, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        R r2 = (R) selector.invoke(Float.valueOf(fArr[0]));
        int lastIndex = getLastIndex(fArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Comparable comparable = (Comparable) selector.invoke(Float.valueOf(fArr[i3]));
                if (r2.compareTo(comparable) < 0) {
                    r2 = (R) comparable;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    private static final <R extends Comparable<? super R>> R minOfOrNull(float[] fArr, Function1<? super Float, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        R r2 = (R) selector.invoke(Float.valueOf(fArr[0]));
        int lastIndex = getLastIndex(fArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Comparable comparable = (Comparable) selector.invoke(Float.valueOf(fArr[i3]));
                if (r2.compareTo(comparable) > 0) {
                    r2 = (R) comparable;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, List<V>> groupBy(char[] cArr, Function1<? super Character, ? extends K> keySelector, Function1<? super Character, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (char c3 : cArr) {
            Object objInvoke = keySelector.invoke(Character.valueOf(c3));
            Object arrayList = linkedHashMap.get(objInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(objInvoke, arrayList);
            }
            ((List) arrayList).add(valueTransform.invoke(Character.valueOf(c3)));
        }
        return linkedHashMap;
    }

    /* JADX INFO: renamed from: maxOf, reason: collision with other method in class */
    private static final <R extends Comparable<? super R>> R m1387maxOf(float[] fArr, Function1<? super Float, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (fArr.length != 0) {
            R r2 = (R) selector.invoke(Float.valueOf(fArr[0]));
            int lastIndex = getLastIndex(fArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable comparable = (Comparable) selector.invoke(Float.valueOf(fArr[i3]));
                    if (r2.compareTo(comparable) < 0) {
                        r2 = (R) comparable;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return r2;
        }
        throw new NoSuchElementException();
    }

    private static final <R extends Comparable<? super R>> R maxOfOrNull(double[] dArr, Function1<? super Double, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        R r2 = (R) selector.invoke(Double.valueOf(dArr[0]));
        int lastIndex = getLastIndex(dArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Comparable comparable = (Comparable) selector.invoke(Double.valueOf(dArr[i3]));
                if (r2.compareTo(comparable) < 0) {
                    r2 = (R) comparable;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    /* JADX INFO: renamed from: minOf, reason: collision with other method in class */
    private static final <R extends Comparable<? super R>> R m1423minOf(float[] fArr, Function1<? super Float, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (fArr.length != 0) {
            R r2 = (R) selector.invoke(Float.valueOf(fArr[0]));
            int lastIndex = getLastIndex(fArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable comparable = (Comparable) selector.invoke(Float.valueOf(fArr[i3]));
                    if (r2.compareTo(comparable) > 0) {
                        r2 = (R) comparable;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return r2;
        }
        throw new NoSuchElementException();
    }

    private static final <R extends Comparable<? super R>> R minOfOrNull(double[] dArr, Function1<? super Double, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        R r2 = (R) selector.invoke(Double.valueOf(dArr[0]));
        int lastIndex = getLastIndex(dArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Comparable comparable = (Comparable) selector.invoke(Double.valueOf(dArr[i3]));
                if (r2.compareTo(comparable) > 0) {
                    r2 = (R) comparable;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    public static final <R> List<Pair<Byte, R>> zip(byte[] bArr, Iterable<? extends R> other) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int length = bArr.length;
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(other, 10), length));
        int i3 = 0;
        for (R r2 : other) {
            if (i3 >= length) {
                break;
            }
            arrayList.add(TuplesKt.a(Byte.valueOf(bArr[i3]), r2));
            i3++;
        }
        return arrayList;
    }

    private static final <R extends Comparable<? super R>> R maxOfOrNull(boolean[] zArr, Function1<? super Boolean, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        R r2 = (R) selector.invoke(Boolean.valueOf(zArr[0]));
        int lastIndex = getLastIndex(zArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Comparable comparable = (Comparable) selector.invoke(Boolean.valueOf(zArr[i3]));
                if (r2.compareTo(comparable) < 0) {
                    r2 = (R) comparable;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    private static final <R extends Comparable<? super R>> R minOfOrNull(boolean[] zArr, Function1<? super Boolean, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        R r2 = (R) selector.invoke(Boolean.valueOf(zArr[0]));
        int lastIndex = getLastIndex(zArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Comparable comparable = (Comparable) selector.invoke(Boolean.valueOf(zArr[i3]));
                if (r2.compareTo(comparable) > 0) {
                    r2 = (R) comparable;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    /* JADX INFO: renamed from: maxOf, reason: collision with other method in class */
    private static final <R extends Comparable<? super R>> R m1386maxOf(double[] dArr, Function1<? super Double, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (dArr.length != 0) {
            R r2 = (R) selector.invoke(Double.valueOf(dArr[0]));
            int lastIndex = getLastIndex(dArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable comparable = (Comparable) selector.invoke(Double.valueOf(dArr[i3]));
                    if (r2.compareTo(comparable) < 0) {
                        r2 = (R) comparable;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return r2;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOf, reason: collision with other method in class */
    private static final <R extends Comparable<? super R>> R m1422minOf(double[] dArr, Function1<? super Double, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (dArr.length != 0) {
            R r2 = (R) selector.invoke(Double.valueOf(dArr[0]));
            int lastIndex = getLastIndex(dArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable comparable = (Comparable) selector.invoke(Double.valueOf(dArr[i3]));
                    if (r2.compareTo(comparable) > 0) {
                        r2 = (R) comparable;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return r2;
        }
        throw new NoSuchElementException();
    }

    public static final <R> List<Pair<Short, R>> zip(short[] sArr, Iterable<? extends R> other) {
        Intrinsics.checkNotNullParameter(sArr, cJfnYMIyomoWf.MsoOYhPJVrZNQ);
        Intrinsics.checkNotNullParameter(other, "other");
        int length = sArr.length;
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(other, 10), length));
        int i3 = 0;
        for (R r2 : other) {
            if (i3 >= length) {
                break;
            }
            arrayList.add(TuplesKt.a(Short.valueOf(sArr[i3]), r2));
            i3++;
        }
        return arrayList;
    }

    private static final <R extends Comparable<? super R>> R maxOfOrNull(char[] cArr, Function1<? super Character, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        R r2 = (R) selector.invoke(Character.valueOf(cArr[0]));
        int lastIndex = getLastIndex(cArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Comparable comparable = (Comparable) selector.invoke(Character.valueOf(cArr[i3]));
                if (r2.compareTo(comparable) < 0) {
                    r2 = (R) comparable;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    private static final <R extends Comparable<? super R>> R minOfOrNull(char[] cArr, Function1<? super Character, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        R r2 = (R) selector.invoke(Character.valueOf(cArr[0]));
        int lastIndex = getLastIndex(cArr);
        int i3 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Comparable comparable = (Comparable) selector.invoke(Character.valueOf(cArr[i3]));
                if (r2.compareTo(comparable) > 0) {
                    r2 = (R) comparable;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return r2;
    }

    /* JADX INFO: renamed from: maxOf, reason: collision with other method in class */
    private static final <R extends Comparable<? super R>> R m1392maxOf(boolean[] zArr, Function1<? super Boolean, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (zArr.length != 0) {
            R r2 = (R) selector.invoke(Boolean.valueOf(zArr[0]));
            int lastIndex = getLastIndex(zArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable comparable = (Comparable) selector.invoke(Boolean.valueOf(zArr[i3]));
                    if (r2.compareTo(comparable) < 0) {
                        r2 = (R) comparable;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return r2;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOf, reason: collision with other method in class */
    private static final <R extends Comparable<? super R>> R m1428minOf(boolean[] zArr, Function1<? super Boolean, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (zArr.length != 0) {
            R r2 = (R) selector.invoke(Boolean.valueOf(zArr[0]));
            int lastIndex = getLastIndex(zArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable comparable = (Comparable) selector.invoke(Boolean.valueOf(zArr[i3]));
                    if (r2.compareTo(comparable) > 0) {
                        r2 = (R) comparable;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return r2;
        }
        throw new NoSuchElementException();
    }

    public static final <R> List<Pair<Integer, R>> zip(int[] iArr, Iterable<? extends R> other) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int length = iArr.length;
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(other, 10), length));
        int i3 = 0;
        for (R r2 : other) {
            if (i3 >= length) {
                break;
            }
            arrayList.add(TuplesKt.a(Integer.valueOf(iArr[i3]), r2));
            i3++;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: maxOf, reason: collision with other method in class */
    private static final <R extends Comparable<? super R>> R m1385maxOf(char[] cArr, Function1<? super Character, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (cArr.length != 0) {
            R r2 = (R) selector.invoke(Character.valueOf(cArr[0]));
            int lastIndex = getLastIndex(cArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable comparable = (Comparable) selector.invoke(Character.valueOf(cArr[i3]));
                    if (r2.compareTo(comparable) < 0) {
                        r2 = (R) comparable;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return r2;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOf, reason: collision with other method in class */
    private static final <R extends Comparable<? super R>> R m1421minOf(char[] cArr, Function1<? super Character, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (cArr.length != 0) {
            R r2 = (R) selector.invoke(Character.valueOf(cArr[0]));
            int lastIndex = getLastIndex(cArr);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable comparable = (Comparable) selector.invoke(Character.valueOf(cArr[i3]));
                    if (r2.compareTo(comparable) > 0) {
                        r2 = (R) comparable;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            return r2;
        }
        throw new NoSuchElementException();
    }

    public static final <R> List<Pair<Long, R>> zip(long[] jArr, Iterable<? extends R> other) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int length = jArr.length;
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(other, 10), length));
        int i3 = 0;
        for (R r2 : other) {
            if (i3 >= length) {
                break;
            }
            arrayList.add(TuplesKt.a(Long.valueOf(jArr[i3]), r2));
            i3++;
        }
        return arrayList;
    }

    public static final <R> List<Pair<Float, R>> zip(float[] fArr, Iterable<? extends R> other) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int length = fArr.length;
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(other, 10), length));
        int i3 = 0;
        for (R r2 : other) {
            if (i3 >= length) {
                break;
            }
            arrayList.add(TuplesKt.a(Float.valueOf(fArr[i3]), r2));
            i3++;
        }
        return arrayList;
    }

    public static final <R> List<Pair<Double, R>> zip(double[] dArr, Iterable<? extends R> other) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int length = dArr.length;
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(other, 10), length));
        int i3 = 0;
        for (R r2 : other) {
            if (i3 >= length) {
                break;
            }
            arrayList.add(TuplesKt.a(Double.valueOf(dArr[i3]), r2));
            i3++;
        }
        return arrayList;
    }

    public static final <R> List<Pair<Boolean, R>> zip(boolean[] zArr, Iterable<? extends R> other) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int length = zArr.length;
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(other, 10), length));
        int i3 = 0;
        for (R r2 : other) {
            if (i3 >= length) {
                break;
            }
            arrayList.add(TuplesKt.a(Boolean.valueOf(zArr[i3]), r2));
            i3++;
        }
        return arrayList;
    }

    public static final <R> List<Pair<Character, R>> zip(char[] cArr, Iterable<? extends R> other) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int length = cArr.length;
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(other, 10), length));
        int i3 = 0;
        for (R r2 : other) {
            if (i3 >= length) {
                break;
            }
            arrayList.add(TuplesKt.a(Character.valueOf(cArr[i3]), r2));
            i3++;
        }
        return arrayList;
    }

    public static final List<Pair<Byte, Byte>> zip(byte[] bArr, byte[] other) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int iMin = Math.min(bArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i3 = 0; i3 < iMin; i3++) {
            arrayList.add(TuplesKt.a(Byte.valueOf(bArr[i3]), Byte.valueOf(other[i3])));
        }
        return arrayList;
    }

    public static final List<Pair<Short, Short>> zip(short[] sArr, short[] other) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int iMin = Math.min(sArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i3 = 0; i3 < iMin; i3++) {
            arrayList.add(TuplesKt.a(Short.valueOf(sArr[i3]), Short.valueOf(other[i3])));
        }
        return arrayList;
    }

    public static final List<Pair<Integer, Integer>> zip(int[] iArr, int[] other) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int iMin = Math.min(iArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i3 = 0; i3 < iMin; i3++) {
            arrayList.add(TuplesKt.a(Integer.valueOf(iArr[i3]), Integer.valueOf(other[i3])));
        }
        return arrayList;
    }

    public static final List<Pair<Long, Long>> zip(long[] jArr, long[] other) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int iMin = Math.min(jArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i3 = 0; i3 < iMin; i3++) {
            arrayList.add(TuplesKt.a(Long.valueOf(jArr[i3]), Long.valueOf(other[i3])));
        }
        return arrayList;
    }

    public static final List<Pair<Float, Float>> zip(float[] fArr, float[] other) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int iMin = Math.min(fArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i3 = 0; i3 < iMin; i3++) {
            arrayList.add(TuplesKt.a(Float.valueOf(fArr[i3]), Float.valueOf(other[i3])));
        }
        return arrayList;
    }

    public static final List<Pair<Double, Double>> zip(double[] dArr, double[] other) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int iMin = Math.min(dArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i3 = 0; i3 < iMin; i3++) {
            arrayList.add(TuplesKt.a(Double.valueOf(dArr[i3]), Double.valueOf(other[i3])));
        }
        return arrayList;
    }

    public static final List<Pair<Boolean, Boolean>> zip(boolean[] zArr, boolean[] other) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int iMin = Math.min(zArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i3 = 0; i3 < iMin; i3++) {
            arrayList.add(TuplesKt.a(Boolean.valueOf(zArr[i3]), Boolean.valueOf(other[i3])));
        }
        return arrayList;
    }

    public static final List<Pair<Character, Character>> zip(char[] cArr, char[] other) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int iMin = Math.min(cArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i3 = 0; i3 < iMin; i3++) {
            arrayList.add(TuplesKt.a(Character.valueOf(cArr[i3]), Character.valueOf(other[i3])));
        }
        return arrayList;
    }
}
