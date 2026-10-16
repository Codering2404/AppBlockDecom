package kotlin.collections;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public class CollectionsKt___CollectionsJvmKt extends CollectionsKt__ReversedViewsKt {
    public static final <R> List<R> filterIsInstance(Iterable<?> iterable, Class<R> klass) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(klass, "klass");
        return (List) filterIsInstanceTo(iterable, new ArrayList(), klass);
    }

    public static final <C extends Collection<? super R>, R> C filterIsInstanceTo(Iterable<?> iterable, C destination, Class<R> klass) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(klass, "klass");
        for (Object obj : iterable) {
            if (klass.isInstance(obj)) {
                destination.add(obj);
            }
        }
        return destination;
    }

    @Deprecated
    @DeprecatedSinceKotlin
    /* JADX INFO: renamed from: max, reason: collision with other method in class */
    public static final /* synthetic */ Double m1447max(Iterable iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return CollectionsKt___CollectionsKt.m1455maxOrNull((Iterable<Double>) iterable);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ <T, R extends Comparable<? super R>> T maxBy(Iterable<? extends T> iterable, Function1<? super T, ? extends R> selector) {
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

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ Object maxWith(Iterable iterable, Comparator comparator) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return CollectionsKt___CollectionsKt.maxWithOrNull(iterable, comparator);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    /* JADX INFO: renamed from: min, reason: collision with other method in class */
    public static final /* synthetic */ Double m1449min(Iterable iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return CollectionsKt___CollectionsKt.m1463minOrNull((Iterable<Double>) iterable);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ <T, R extends Comparable<? super R>> T minBy(Iterable<? extends T> iterable, Function1<? super T, ? extends R> selector) {
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

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ Object minWith(Iterable iterable, Comparator comparator) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return CollectionsKt___CollectionsKt.minWithOrNull(iterable, comparator);
    }

    public static <T> void reverse(List<T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Collections.reverse(list);
    }

    private static final <T> BigDecimal sumOfBigDecimal(Iterable<? extends T> iterable, Function1<? super T, ? extends BigDecimal> selector) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, "valueOf(...)");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            bigDecimalValueOf = bigDecimalValueOf.add((BigDecimal) selector.invoke(it.next()));
            Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, "add(...)");
        }
        return bigDecimalValueOf;
    }

    private static final <T> BigInteger sumOfBigInteger(Iterable<? extends T> iterable, Function1<? super T, ? extends BigInteger> selector) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, "valueOf(...)");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            bigIntegerValueOf = bigIntegerValueOf.add((BigInteger) selector.invoke(it.next()));
            Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, "add(...)");
        }
        return bigIntegerValueOf;
    }

    public static final <T extends Comparable<? super T>> SortedSet<T> toSortedSet(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return (SortedSet) CollectionsKt___CollectionsKt.toCollection(iterable, new TreeSet());
    }

    @Deprecated
    @DeprecatedSinceKotlin
    /* JADX INFO: renamed from: max, reason: collision with other method in class */
    public static final /* synthetic */ Float m1448max(Iterable iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return CollectionsKt___CollectionsKt.m1456maxOrNull((Iterable<Float>) iterable);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    /* JADX INFO: renamed from: min, reason: collision with other method in class */
    public static final /* synthetic */ Float m1450min(Iterable iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return CollectionsKt___CollectionsKt.m1464minOrNull((Iterable<Float>) iterable);
    }

    public static final <T> SortedSet<T> toSortedSet(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return (SortedSet) CollectionsKt___CollectionsKt.toCollection(iterable, new TreeSet(comparator));
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ Comparable max(Iterable iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return CollectionsKt___CollectionsKt.maxOrNull(iterable);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final /* synthetic */ Comparable min(Iterable iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return CollectionsKt___CollectionsKt.minOrNull(iterable);
    }
}
