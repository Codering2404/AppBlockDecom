package com.applovin.exoplayer2.common.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class Predicates {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class b implements Predicate, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f57936a;

        @Override // com.applovin.exoplayer2.common.base.Predicate
        public boolean apply(Object obj) {
            for (int i3 = 0; i3 < this.f57936a.size(); i3++) {
                if (!((Predicate) this.f57936a.get(i3)).apply(obj)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.applovin.exoplayer2.common.base.Predicate
        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.f57936a.equals(((b) obj).f57936a);
            }
            return false;
        }

        public int hashCode() {
            return this.f57936a.hashCode() + 306654252;
        }

        public String toString() {
            return Predicates.toStringHelper("and", this.f57936a);
        }

        private b(List list) {
            this.f57936a = list;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class c implements Predicate, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Predicate f57937a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f57938b;

        @Override // com.applovin.exoplayer2.common.base.Predicate
        public boolean apply(Object obj) {
            return this.f57937a.apply(this.f57938b.apply(obj));
        }

        @Override // com.applovin.exoplayer2.common.base.Predicate
        public boolean equals(Object obj) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                if (this.f57938b.equals(cVar.f57938b) && this.f57937a.equals(cVar.f57937a)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return this.f57938b.hashCode() ^ this.f57937a.hashCode();
        }

        public String toString() {
            return this.f57937a + "(" + this.f57938b + ")";
        }

        private c(Predicate predicate, Function function) {
            this.f57937a = (Predicate) Preconditions.checkNotNull(predicate);
            this.f57938b = (Function) Preconditions.checkNotNull(function);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class d implements Predicate, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Collection f57939a;

        @Override // com.applovin.exoplayer2.common.base.Predicate
        public boolean apply(Object obj) {
            try {
                return this.f57939a.contains(obj);
            } catch (ClassCastException | NullPointerException unused) {
                return false;
            }
        }

        @Override // com.applovin.exoplayer2.common.base.Predicate
        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return this.f57939a.equals(((d) obj).f57939a);
            }
            return false;
        }

        public int hashCode() {
            return this.f57939a.hashCode();
        }

        public String toString() {
            return "Predicates.in(" + this.f57939a + ")";
        }

        private d(Collection collection) {
            this.f57939a = (Collection) Preconditions.checkNotNull(collection);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class e implements Predicate, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Class f57940a;

        @Override // com.applovin.exoplayer2.common.base.Predicate
        public boolean apply(Object obj) {
            return this.f57940a.isInstance(obj);
        }

        @Override // com.applovin.exoplayer2.common.base.Predicate
        public boolean equals(Object obj) {
            return (obj instanceof e) && this.f57940a == ((e) obj).f57940a;
        }

        public int hashCode() {
            return this.f57940a.hashCode();
        }

        public String toString() {
            return "Predicates.instanceOf(" + this.f57940a.getName() + ")";
        }

        private e(Class cls) {
            this.f57940a = (Class) Preconditions.checkNotNull(cls);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class f implements Predicate, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f57941a;

        @Override // com.applovin.exoplayer2.common.base.Predicate
        public boolean apply(Object obj) {
            return this.f57941a.equals(obj);
        }

        @Override // com.applovin.exoplayer2.common.base.Predicate
        public boolean equals(Object obj) {
            if (obj instanceof f) {
                return this.f57941a.equals(((f) obj).f57941a);
            }
            return false;
        }

        public int hashCode() {
            return this.f57941a.hashCode();
        }

        public String toString() {
            return "Predicates.equalTo(" + this.f57941a + ")";
        }

        private f(Object obj) {
            this.f57941a = obj;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class g implements Predicate, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Predicate f57942a;

        g(Predicate predicate) {
            this.f57942a = (Predicate) Preconditions.checkNotNull(predicate);
        }

        @Override // com.applovin.exoplayer2.common.base.Predicate
        public boolean apply(Object obj) {
            return !this.f57942a.apply(obj);
        }

        @Override // com.applovin.exoplayer2.common.base.Predicate
        public boolean equals(Object obj) {
            if (obj instanceof g) {
                return this.f57942a.equals(((g) obj).f57942a);
            }
            return false;
        }

        public int hashCode() {
            return ~this.f57942a.hashCode();
        }

        public String toString() {
            return "Predicates.not(" + this.f57942a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class i implements Predicate, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f57948a;

        @Override // com.applovin.exoplayer2.common.base.Predicate
        public boolean apply(Object obj) {
            for (int i3 = 0; i3 < this.f57948a.size(); i3++) {
                if (((Predicate) this.f57948a.get(i3)).apply(obj)) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.applovin.exoplayer2.common.base.Predicate
        public boolean equals(Object obj) {
            if (obj instanceof i) {
                return this.f57948a.equals(((i) obj).f57948a);
            }
            return false;
        }

        public int hashCode() {
            return this.f57948a.hashCode() + 87855567;
        }

        public String toString() {
            return Predicates.toStringHelper("or", this.f57948a);
        }

        private i(List list) {
            this.f57948a = list;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class j implements Predicate, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Class f57949a;

        @Override // com.applovin.exoplayer2.common.base.Predicate
        public boolean equals(Object obj) {
            return (obj instanceof j) && this.f57949a == ((j) obj).f57949a;
        }

        public int hashCode() {
            return this.f57949a.hashCode();
        }

        public String toString() {
            return "Predicates.subtypeOf(" + this.f57949a.getName() + ")";
        }

        private j(Class cls) {
            this.f57949a = (Class) Preconditions.checkNotNull(cls);
        }

        @Override // com.applovin.exoplayer2.common.base.Predicate
        public boolean apply(Class cls) {
            return this.f57949a.isAssignableFrom(cls);
        }
    }

    private Predicates() {
    }

    public static <T> Predicate<T> alwaysFalse() {
        return h.f57944b.b();
    }

    public static <T> Predicate<T> alwaysTrue() {
        return h.f57943a.b();
    }

    public static <T> Predicate<T> and(Iterable<? extends Predicate<? super T>> iterable) {
        return new b(defensiveCopy(iterable));
    }

    private static <T> List<Predicate<? super T>> asList(Predicate<? super T> predicate, Predicate<? super T> predicate2) {
        return Arrays.asList(predicate, predicate2);
    }

    public static <A, B> Predicate<A> compose(Predicate<B> predicate, Function<A, ? extends B> function) {
        return new c(predicate, function);
    }

    private static <T> List<T> defensiveCopy(T... tArr) {
        return defensiveCopy(Arrays.asList(tArr));
    }

    public static <T> Predicate<T> equalTo(@NullableDecl T t2) {
        return t2 == null ? isNull() : new f(t2);
    }

    public static <T> Predicate<T> in(Collection<? extends T> collection) {
        return new d(collection);
    }

    public static Predicate<Object> instanceOf(Class<?> cls) {
        return new e(cls);
    }

    public static <T> Predicate<T> isNull() {
        return h.f57945c.b();
    }

    public static <T> Predicate<T> not(Predicate<T> predicate) {
        return new g(predicate);
    }

    public static <T> Predicate<T> notNull() {
        return h.f57946d.b();
    }

    public static <T> Predicate<T> or(Iterable<? extends Predicate<? super T>> iterable) {
        return new i(defensiveCopy(iterable));
    }

    public static Predicate<Class<?>> subtypeOf(Class<?> cls) {
        return new j(cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String toStringHelper(String str, Iterable<?> iterable) {
        StringBuilder sb = new StringBuilder("Predicates.");
        sb.append(str);
        sb.append('(');
        boolean z2 = true;
        for (Object obj : iterable) {
            if (!z2) {
                sb.append(',');
            }
            sb.append(obj);
            z2 = false;
        }
        sb.append(')');
        return sb.toString();
    }

    @SafeVarargs
    public static <T> Predicate<T> and(Predicate<? super T>... predicateArr) {
        return new b(defensiveCopy(predicateArr));
    }

    static <T> List<T> defensiveCopy(Iterable<T> iterable) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(Preconditions.checkNotNull(it.next()));
        }
        return arrayList;
    }

    @SafeVarargs
    public static <T> Predicate<T> or(Predicate<? super T>... predicateArr) {
        return new i(defensiveCopy(predicateArr));
    }

    public static <T> Predicate<T> and(Predicate<? super T> predicate, Predicate<? super T> predicate2) {
        return new b(asList((Predicate) Preconditions.checkNotNull(predicate), (Predicate) Preconditions.checkNotNull(predicate2)));
    }

    public static <T> Predicate<T> or(Predicate<? super T> predicate, Predicate<? super T> predicate2) {
        return new i(asList((Predicate) Preconditions.checkNotNull(predicate), (Predicate) Preconditions.checkNotNull(predicate2)));
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class h implements Predicate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f57943a = new a("ALWAYS_TRUE", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final h f57944b = new b("ALWAYS_FALSE", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final h f57945c = new c("IS_NULL", 2);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final h f57946d = new d("NOT_NULL", 3);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final /* synthetic */ h[] f57947f = a();

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        enum a extends h {
            a(String str, int i3) {
                super(str, i3);
            }

            @Override // com.applovin.exoplayer2.common.base.Predicate
            public boolean apply(Object obj) {
                return true;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.alwaysTrue()";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        enum b extends h {
            b(String str, int i3) {
                super(str, i3);
            }

            @Override // com.applovin.exoplayer2.common.base.Predicate
            public boolean apply(Object obj) {
                return false;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.alwaysFalse()";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        enum c extends h {
            c(String str, int i3) {
                super(str, i3);
            }

            @Override // com.applovin.exoplayer2.common.base.Predicate
            public boolean apply(Object obj) {
                return obj == null;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.isNull()";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        enum d extends h {
            d(String str, int i3) {
                super(str, i3);
            }

            @Override // com.applovin.exoplayer2.common.base.Predicate
            public boolean apply(Object obj) {
                return obj != null;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.notNull()";
            }
        }

        private h(String str, int i3) {
        }

        private static /* synthetic */ h[] a() {
            return new h[]{f57943a, f57944b, f57945c, f57946d};
        }

        public static h valueOf(String str) {
            return (h) Enum.valueOf(h.class, str);
        }

        public static h[] values() {
            return (h[]) f57947f.clone();
        }

        Predicate b() {
            return this;
        }
    }
}
