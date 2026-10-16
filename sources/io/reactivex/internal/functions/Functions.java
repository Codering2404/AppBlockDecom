package io.reactivex.internal.functions;

import io.reactivex.Notification;
import io.reactivex.Scheduler;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import io.reactivex.functions.Function4;
import io.reactivex.functions.Function5;
import io.reactivex.functions.Function6;
import io.reactivex.functions.Function7;
import io.reactivex.functions.Function8;
import io.reactivex.functions.Function9;
import io.reactivex.functions.LongConsumer;
import io.reactivex.functions.Predicate;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Timed;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class Functions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Function f134905a = new Identity();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Runnable f134906b = new EmptyRunnable();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Action f134907c = new EmptyAction();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final Consumer f134908d = new EmptyConsumer();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Consumer f134909e = new ErrorConsumer();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Consumer f134910f = new OnErrorMissingConsumer();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final LongConsumer f134911g = new EmptyLongConsumer();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final Predicate f134912h = new TruePredicate();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final Predicate f134913i = new FalsePredicate();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static final Callable f134914j = new NullCallable();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final Comparator f134915k = new NaturalObjectComparator();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Consumer f134916l = new MaxRequestSubscription();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ActionConsumer<T> implements Consumer<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Action f134917a;

        @Override // io.reactivex.functions.Consumer
        public void accept(Object obj) {
            this.f134917a.run();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Array2Func<T1, T2, R> implements Function<Object[], R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final BiFunction f134918a;

        @Override // io.reactivex.functions.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object apply(Object[] objArr) {
            if (objArr.length == 2) {
                return this.f134918a.apply(objArr[0], objArr[1]);
            }
            throw new IllegalArgumentException("Array of size 2 expected but got " + objArr.length);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Array3Func<T1, T2, T3, R> implements Function<Object[], R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Function3 f134919a;

        @Override // io.reactivex.functions.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object apply(Object[] objArr) {
            if (objArr.length == 3) {
                return this.f134919a.a(objArr[0], objArr[1], objArr[2]);
            }
            throw new IllegalArgumentException("Array of size 3 expected but got " + objArr.length);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Array4Func<T1, T2, T3, T4, R> implements Function<Object[], R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Function4 f134920a;

        @Override // io.reactivex.functions.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object apply(Object[] objArr) {
            if (objArr.length == 4) {
                return this.f134920a.a(objArr[0], objArr[1], objArr[2], objArr[3]);
            }
            throw new IllegalArgumentException("Array of size 4 expected but got " + objArr.length);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Array5Func<T1, T2, T3, T4, T5, R> implements Function<Object[], R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Function5 f134921a;

        @Override // io.reactivex.functions.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object apply(Object[] objArr) {
            if (objArr.length == 5) {
                return this.f134921a.a(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4]);
            }
            throw new IllegalArgumentException("Array of size 5 expected but got " + objArr.length);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Array6Func<T1, T2, T3, T4, T5, T6, R> implements Function<Object[], R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Function6 f134922a;

        @Override // io.reactivex.functions.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object apply(Object[] objArr) {
            if (objArr.length == 6) {
                return this.f134922a.a(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5]);
            }
            throw new IllegalArgumentException("Array of size 6 expected but got " + objArr.length);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Array7Func<T1, T2, T3, T4, T5, T6, T7, R> implements Function<Object[], R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Function7 f134923a;

        @Override // io.reactivex.functions.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object apply(Object[] objArr) {
            if (objArr.length == 7) {
                return this.f134923a.a(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6]);
            }
            throw new IllegalArgumentException("Array of size 7 expected but got " + objArr.length);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Array8Func<T1, T2, T3, T4, T5, T6, T7, T8, R> implements Function<Object[], R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Function8 f134924a;

        @Override // io.reactivex.functions.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object apply(Object[] objArr) {
            if (objArr.length == 8) {
                return this.f134924a.a(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7]);
            }
            throw new IllegalArgumentException("Array of size 8 expected but got " + objArr.length);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Array9Func<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> implements Function<Object[], R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Function9 f134925a;

        @Override // io.reactivex.functions.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object apply(Object[] objArr) {
            if (objArr.length == 9) {
                return this.f134925a.a(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7], objArr[8]);
            }
            throw new IllegalArgumentException("Array of size 9 expected but got " + objArr.length);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ArrayListCapacityCallable<T> implements Callable<List<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f134926a;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            return new ArrayList(this.f134926a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class BooleanSupplierPredicateReverse<T> implements Predicate<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final BooleanSupplier f134927a;

        @Override // io.reactivex.functions.Predicate
        public boolean test(Object obj) {
            return !this.f134927a.a();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class BoundedConsumer implements Consumer<Subscription> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f134928a;

        @Override // io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Subscription subscription) {
            subscription.y(this.f134928a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class CastToClass<T, U> implements Function<T, U> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Class f134929a;

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            return this.f134929a.cast(obj);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ClassFilter<T, U> implements Predicate<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Class f134930a;

        @Override // io.reactivex.functions.Predicate
        public boolean test(Object obj) {
            return this.f134930a.isInstance(obj);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class EqualsPredicate<T> implements Predicate<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f134931a;

        @Override // io.reactivex.functions.Predicate
        public boolean test(Object obj) {
            return ObjectHelper.c(obj, this.f134931a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ErrorConsumer implements Consumer<Throwable> {
        ErrorConsumer() {
        }

        @Override // io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) {
            RxJavaPlugins.s(th);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class FalsePredicate implements Predicate<Object> {
        FalsePredicate() {
        }

        @Override // io.reactivex.functions.Predicate
        public boolean test(Object obj) {
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class FutureAction implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Future f134932a;

        @Override // io.reactivex.functions.Action
        public void run() throws ExecutionException, InterruptedException {
            this.f134932a.get();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    enum HashSetCallable implements Callable<Set<Object>> {
        INSTANCE;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Set call() {
            return new HashSet();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class JustValue<T, U> implements Callable<U>, Function<T, U> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f134935a;

        JustValue(Object obj) {
            this.f134935a = obj;
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            return this.f134935a;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return this.f134935a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ListSorter<T> implements Function<List<T>, List<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Comparator f134936a;

        @Override // io.reactivex.functions.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List apply(List list) {
            Collections.sort(list, this.f134936a);
            return list;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class MaxRequestSubscription implements Consumer<Subscription> {
        MaxRequestSubscription() {
        }

        @Override // io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Subscription subscription) {
            subscription.y(Long.MAX_VALUE);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    enum NaturalComparator implements Comparator<Object> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class NaturalObjectComparator implements Comparator<Object> {
        NaturalObjectComparator() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class NotificationOnComplete<T> implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Consumer f134939a;

        @Override // io.reactivex.functions.Action
        public void run() {
            this.f134939a.accept(Notification.a());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class NotificationOnError<T> implements Consumer<Throwable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Consumer f134940a;

        @Override // io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) {
            this.f134940a.accept(Notification.b(th));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class NotificationOnNext<T> implements Consumer<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Consumer f134941a;

        @Override // io.reactivex.functions.Consumer
        public void accept(Object obj) {
            this.f134941a.accept(Notification.c(obj));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class NullCallable implements Callable<Object> {
        NullCallable() {
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class OnErrorMissingConsumer implements Consumer<Throwable> {
        OnErrorMissingConsumer() {
        }

        @Override // io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) {
            RxJavaPlugins.s(new OnErrorNotImplementedException(th));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class TimestampFunction<T> implements Function<T, Timed<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final TimeUnit f134942a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Scheduler f134943b;

        @Override // io.reactivex.functions.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Timed apply(Object obj) {
            return new Timed(obj, this.f134943b.c(this.f134942a), this.f134942a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ToMapKeySelector<K, T> implements BiConsumer<Map<K, T>, T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Function f134944a;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.BiConsumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Map map, Object obj) {
            map.put(this.f134944a.apply(obj), obj);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ToMapKeyValueSelector<K, V, T> implements BiConsumer<Map<K, V>, T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Function f134945a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Function f134946b;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.BiConsumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Map map, Object obj) {
            map.put(this.f134946b.apply(obj), this.f134945a.apply(obj));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ToMultimapKeyValueSelector<K, V, T> implements BiConsumer<Map<K, Collection<V>>, T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Function f134947a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Function f134948b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Function f134949c;

        @Override // io.reactivex.functions.BiConsumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Map map, Object obj) {
            Object objApply = this.f134949c.apply(obj);
            Collection collection = (Collection) map.get(objApply);
            if (collection == null) {
                collection = (Collection) this.f134947a.apply(objApply);
                map.put(objApply, collection);
            }
            collection.add(this.f134948b.apply(obj));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class TruePredicate implements Predicate<Object> {
        TruePredicate() {
        }

        @Override // io.reactivex.functions.Predicate
        public boolean test(Object obj) {
            return true;
        }
    }

    public static Consumer a() {
        return f134908d;
    }

    public static Function b(Object obj) {
        return new JustValue(obj);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class EmptyAction implements Action {
        EmptyAction() {
        }

        public String toString() {
            return "EmptyAction";
        }

        @Override // io.reactivex.functions.Action
        public void run() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class EmptyRunnable implements Runnable {
        EmptyRunnable() {
        }

        public String toString() {
            return "EmptyRunnable";
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class EmptyConsumer implements Consumer<Object> {
        EmptyConsumer() {
        }

        public String toString() {
            return "EmptyConsumer";
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(Object obj) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class EmptyLongConsumer implements LongConsumer {
        EmptyLongConsumer() {
        }

        @Override // io.reactivex.functions.LongConsumer
        public void accept(long j3) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Identity implements Function<Object, Object> {
        Identity() {
        }

        public String toString() {
            return "IdentityFunction";
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            return obj;
        }
    }
}
