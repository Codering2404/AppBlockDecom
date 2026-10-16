package com.google.common.collect;

import com.google.common.collect.CollectCollectors;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableRangeSet;
import com.google.common.collect.ImmutableSet;
import java.util.EnumSet;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class CollectCollectors {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Collector f83794a = Collector.of(new Supplier() { // from class: com.google.common.collect.k
        @Override // java.util.function.Supplier
        public final Object get() {
            return ImmutableList.o();
        }
    }, new BiConsumer() { // from class: com.google.common.collect.n
        @Override // java.util.function.BiConsumer
        public final void accept(Object obj, Object obj2) {
            ((ImmutableList.Builder) obj).a(obj2);
        }
    }, new BinaryOperator() { // from class: com.google.common.collect.o
        @Override // java.util.function.BiFunction
        public final Object apply(Object obj, Object obj2) {
            return ((ImmutableList.Builder) obj).o((ImmutableList.Builder) obj2);
        }
    }, new Function() { // from class: com.google.common.collect.p
        @Override // java.util.function.Function
        public final Object apply(Object obj) {
            return ((ImmutableList.Builder) obj).m();
        }
    }, new Collector.Characteristics[0]);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Collector f83795b = Collector.of(new Supplier() { // from class: com.google.common.collect.b
        @Override // java.util.function.Supplier
        public final Object get() {
            return ImmutableSet.o();
        }
    }, new BiConsumer() { // from class: com.google.common.collect.c
        @Override // java.util.function.BiConsumer
        public final void accept(Object obj, Object obj2) {
            ((ImmutableSet.Builder) obj).e(obj2);
        }
    }, new BinaryOperator() { // from class: com.google.common.collect.d
        @Override // java.util.function.BiFunction
        public final Object apply(Object obj, Object obj2) {
            return ((ImmutableSet.Builder) obj).o((ImmutableSet.Builder) obj2);
        }
    }, new Function() { // from class: com.google.common.collect.e
        @Override // java.util.function.Function
        public final Object apply(Object obj) {
            return ((ImmutableSet.Builder) obj).n();
        }
    }, new Collector.Characteristics[0]);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Collector f83796c = Collector.of(new Supplier() { // from class: com.google.common.collect.f
        @Override // java.util.function.Supplier
        public final Object get() {
            return ImmutableRangeSet.h();
        }
    }, new BiConsumer() { // from class: com.google.common.collect.g
        @Override // java.util.function.BiConsumer
        public final void accept(Object obj, Object obj2) {
            ((ImmutableRangeSet.Builder) obj).a((Range) obj2);
        }
    }, new BinaryOperator() { // from class: com.google.common.collect.l
        @Override // java.util.function.BiFunction
        public final Object apply(Object obj, Object obj2) {
            return ((ImmutableRangeSet.Builder) obj).d((ImmutableRangeSet.Builder) obj2);
        }
    }, new Function() { // from class: com.google.common.collect.m
        @Override // java.util.function.Function
        public final Object apply(Object obj) {
            return ((ImmutableRangeSet.Builder) obj).c();
        }
    }, new Collector.Characteristics[0]);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class EnumMapAccumulator<K extends Enum<K>, V> {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class EnumSetAccumulator<E extends Enum<E>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final Collector f83797b = CollectCollectors.c();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private EnumSet f83798a;

        private EnumSetAccumulator() {
        }

        void a(Enum r2) {
            EnumSet enumSet = this.f83798a;
            if (enumSet == null) {
                this.f83798a = EnumSet.of(r2);
            } else {
                enumSet.add(r2);
            }
        }

        EnumSetAccumulator b(EnumSetAccumulator enumSetAccumulator) {
            EnumSet enumSet = this.f83798a;
            if (enumSet == null) {
                return enumSetAccumulator;
            }
            EnumSet enumSet2 = enumSetAccumulator.f83798a;
            if (enumSet2 == null) {
                return this;
            }
            enumSet.addAll(enumSet2);
            return this;
        }

        ImmutableSet c() {
            EnumSet enumSet = this.f83798a;
            if (enumSet == null) {
                return ImmutableSet.z();
            }
            ImmutableSet immutableSetI = ImmutableEnumSet.I(enumSet);
            this.f83798a = null;
            return immutableSetI;
        }
    }

    public static /* synthetic */ EnumSetAccumulator a() {
        return new EnumSetAccumulator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Collector c() {
        return Collector.of(new Supplier() { // from class: com.google.common.collect.a
            @Override // java.util.function.Supplier
            public final Object get() {
                return CollectCollectors.a();
            }
        }, new BiConsumer() { // from class: com.google.common.collect.h
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((CollectCollectors.EnumSetAccumulator) obj).a((Enum) obj2);
            }
        }, new BinaryOperator() { // from class: com.google.common.collect.i
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ((CollectCollectors.EnumSetAccumulator) obj).b((CollectCollectors.EnumSetAccumulator) obj2);
            }
        }, new Function() { // from class: com.google.common.collect.j
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((CollectCollectors.EnumSetAccumulator) obj).c();
            }
        }, Collector.Characteristics.UNORDERED);
    }

    static Collector d() {
        return f83794a;
    }
}
