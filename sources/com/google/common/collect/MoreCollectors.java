package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.MoreCollectors;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class MoreCollectors {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Collector f84451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f84452b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Collector f84453c;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ToOptionalState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f84454a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        List f84455b = Collections.EMPTY_LIST;

        ToOptionalState() {
        }

        void a(Object obj) {
            Preconditions.t(obj);
            if (this.f84454a == null) {
                this.f84454a = obj;
                return;
            }
            if (this.f84455b.isEmpty()) {
                ArrayList arrayList = new ArrayList(4);
                this.f84455b = arrayList;
                arrayList.add(obj);
            } else {
                if (this.f84455b.size() >= 4) {
                    throw e(true);
                }
                this.f84455b.add(obj);
            }
        }

        ToOptionalState b(ToOptionalState toOptionalState) {
            if (this.f84454a == null) {
                return toOptionalState;
            }
            if (toOptionalState.f84454a != null) {
                if (this.f84455b.isEmpty()) {
                    this.f84455b = new ArrayList();
                }
                this.f84455b.add(toOptionalState.f84454a);
                this.f84455b.addAll(toOptionalState.f84455b);
                if (this.f84455b.size() > 4) {
                    List list = this.f84455b;
                    list.subList(4, list.size()).clear();
                    throw e(true);
                }
            }
            return this;
        }

        Object c() {
            if (this.f84454a == null) {
                throw new NoSuchElementException();
            }
            if (this.f84455b.isEmpty()) {
                return this.f84454a;
            }
            throw e(false);
        }

        Optional d() {
            if (this.f84455b.isEmpty()) {
                return Optional.ofNullable(this.f84454a);
            }
            throw e(false);
        }

        IllegalArgumentException e(boolean z2) {
            StringBuilder sb = new StringBuilder();
            sb.append("expected one element but was: <");
            sb.append(this.f84454a);
            for (Object obj : this.f84455b) {
                sb.append(", ");
                sb.append(obj);
            }
            if (z2) {
                sb.append(", ...");
            }
            sb.append('>');
            throw new IllegalArgumentException(sb.toString());
        }
    }

    static {
        Supplier supplier = new Supplier() { // from class: com.google.common.collect.w
            @Override // java.util.function.Supplier
            public final Object get() {
                return new MoreCollectors.ToOptionalState();
            }
        };
        BiConsumer biConsumer = new BiConsumer() { // from class: com.google.common.collect.x
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((MoreCollectors.ToOptionalState) obj).a(obj2);
            }
        };
        BinaryOperator binaryOperator = new BinaryOperator() { // from class: com.google.common.collect.y
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ((MoreCollectors.ToOptionalState) obj).b((MoreCollectors.ToOptionalState) obj2);
            }
        };
        Function function = new Function() { // from class: com.google.common.collect.z
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((MoreCollectors.ToOptionalState) obj).d();
            }
        };
        Collector.Characteristics characteristics = Collector.Characteristics.UNORDERED;
        f84451a = Collector.of(supplier, biConsumer, binaryOperator, function, characteristics);
        f84452b = new Object();
        f84453c = Collector.of(new Supplier() { // from class: com.google.common.collect.w
            @Override // java.util.function.Supplier
            public final Object get() {
                return new MoreCollectors.ToOptionalState();
            }
        }, new BiConsumer() { // from class: com.google.common.collect.a0
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                MoreCollectors.a((MoreCollectors.ToOptionalState) obj, obj2);
            }
        }, new BinaryOperator() { // from class: com.google.common.collect.y
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ((MoreCollectors.ToOptionalState) obj).b((MoreCollectors.ToOptionalState) obj2);
            }
        }, new Function() { // from class: com.google.common.collect.b0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MoreCollectors.b((MoreCollectors.ToOptionalState) obj);
            }
        }, characteristics);
    }

    public static /* synthetic */ void a(ToOptionalState toOptionalState, Object obj) {
        if (obj == null) {
            obj = f84452b;
        }
        toOptionalState.a(obj);
    }

    public static /* synthetic */ Object b(ToOptionalState toOptionalState) {
        Object objC = toOptionalState.c();
        if (objC == f84452b) {
            return null;
        }
        return objC;
    }
}
