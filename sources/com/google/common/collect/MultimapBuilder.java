package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class MultimapBuilder<K0, V0> {

    /* JADX INFO: renamed from: com.google.common.collect.MultimapBuilder$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass2 extends MultimapBuilderWithKeys<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f84457a;

        @Override // com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys
        Map c() {
            return Platform.e(this.f84457a);
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.MultimapBuilder$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass4 extends MultimapBuilderWithKeys<Enum<Object>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Class f84459a;

        @Override // com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys
        Map c() {
            return new EnumMap(this.f84459a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ArrayListSupplier<V> implements Supplier<List<V>>, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f84460a;

        ArrayListSupplier(int i3) {
            this.f84460a = CollectPreconditions.b(i3, "expectedValuesPerKey");
        }

        @Override // com.google.common.base.Supplier
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List get() {
            return new ArrayList(this.f84460a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class EnumSetSupplier<V extends Enum<V>> implements Supplier<Set<V>>, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Class f84461a;

        @Override // com.google.common.base.Supplier
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Set get() {
            return EnumSet.noneOf(this.f84461a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class HashSetSupplier<V> implements Supplier<Set<V>>, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f84462a;

        @Override // com.google.common.base.Supplier
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Set get() {
            return Platform.d(this.f84462a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class LinkedHashSetSupplier<V> implements Supplier<Set<V>>, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f84463a;

        @Override // com.google.common.base.Supplier
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Set get() {
            return Platform.f(this.f84463a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private enum LinkedListSupplier implements Supplier<List<?>> {
        INSTANCE;

        public static Supplier c() {
            return INSTANCE;
        }

        @Override // com.google.common.base.Supplier
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public List get() {
            return new LinkedList();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class ListMultimapBuilder<K0, V0> extends MultimapBuilder<K0, V0> {
        ListMultimapBuilder() {
            super();
        }

        public abstract ListMultimap e();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class MultimapBuilderWithKeys<K0> {

        /* JADX INFO: renamed from: com.google.common.collect.MultimapBuilder$MultimapBuilderWithKeys$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass2 extends ListMultimapBuilder<Object, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ MultimapBuilderWithKeys f84468a;

            @Override // com.google.common.collect.MultimapBuilder.ListMultimapBuilder
            public ListMultimap e() {
                return Multimaps.d(this.f84468a.c(), LinkedListSupplier.c());
            }
        }

        /* JADX INFO: renamed from: com.google.common.collect.MultimapBuilder$MultimapBuilderWithKeys$3, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass3 extends SetMultimapBuilder<Object, Object> {
        }

        /* JADX INFO: renamed from: com.google.common.collect.MultimapBuilder$MultimapBuilderWithKeys$4, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass4 extends SetMultimapBuilder<Object, Object> {
        }

        /* JADX INFO: renamed from: com.google.common.collect.MultimapBuilder$MultimapBuilderWithKeys$5, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass5 extends SortedSetMultimapBuilder<Object, Object> {
        }

        /* JADX INFO: renamed from: com.google.common.collect.MultimapBuilder$MultimapBuilderWithKeys$6, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass6 extends SetMultimapBuilder<Object, Enum<Object>> {
        }

        MultimapBuilderWithKeys() {
        }

        public ListMultimapBuilder a() {
            return b(2);
        }

        public ListMultimapBuilder b(final int i3) {
            CollectPreconditions.b(i3, "expectedValuesPerKey");
            return new ListMultimapBuilder<K0, Object>(this) { // from class: com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys.1

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ MultimapBuilderWithKeys f84467b;

                {
                    this.f84467b = this;
                }

                @Override // com.google.common.collect.MultimapBuilder.ListMultimapBuilder
                public ListMultimap e() {
                    return Multimaps.d(this.f84467b.c(), new ArrayListSupplier(i3));
                }
            };
        }

        abstract Map c();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class SetMultimapBuilder<K0, V0> extends MultimapBuilder<K0, V0> {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class SortedSetMultimapBuilder<K0, V0> extends SetMultimapBuilder<K0, V0> {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class TreeSetSupplier<V> implements Supplier<SortedSet<V>>, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Comparator f84469a;

        @Override // com.google.common.base.Supplier
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public SortedSet get() {
            return new TreeSet(this.f84469a);
        }
    }

    public static MultimapBuilderWithKeys a() {
        return b(8);
    }

    public static MultimapBuilderWithKeys b(final int i3) {
        CollectPreconditions.b(i3, "expectedKeys");
        return new MultimapBuilderWithKeys<Object>() { // from class: com.google.common.collect.MultimapBuilder.1
            @Override // com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys
            Map c() {
                return Platform.c(i3);
            }
        };
    }

    public static MultimapBuilderWithKeys c() {
        return d(Ordering.f());
    }

    public static MultimapBuilderWithKeys d(final Comparator comparator) {
        Preconditions.t(comparator);
        return new MultimapBuilderWithKeys<Object>() { // from class: com.google.common.collect.MultimapBuilder.3
            @Override // com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys
            Map c() {
                return new TreeMap(comparator);
            }
        };
    }

    private MultimapBuilder() {
    }
}
