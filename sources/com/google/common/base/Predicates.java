package com.google.common.base;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class Predicates {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class AndPredicate<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f83336a;

        @Override // com.google.common.base.Predicate
        public boolean apply(Object obj) {
            for (int i3 = 0; i3 < this.f83336a.size(); i3++) {
                if (!((Predicate) this.f83336a.get(i3)).apply(obj)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(Object obj) {
            if (obj instanceof AndPredicate) {
                return this.f83336a.equals(((AndPredicate) obj).f83336a);
            }
            return false;
        }

        public int hashCode() {
            return this.f83336a.hashCode() + 306654252;
        }

        public String toString() {
            return Predicates.k("and", this.f83336a);
        }

        private AndPredicate(List list) {
            this.f83336a = list;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class CompositionPredicate<A, B> implements Predicate<A>, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Predicate f83337a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f83338b;

        @Override // com.google.common.base.Predicate
        public boolean apply(Object obj) {
            return this.f83337a.apply(this.f83338b.apply(obj));
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(Object obj) {
            if (obj instanceof CompositionPredicate) {
                CompositionPredicate compositionPredicate = (CompositionPredicate) obj;
                if (this.f83338b.equals(compositionPredicate.f83338b) && this.f83337a.equals(compositionPredicate.f83337a)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return this.f83338b.hashCode() ^ this.f83337a.hashCode();
        }

        public String toString() {
            return this.f83337a + "(" + this.f83338b + ")";
        }

        private CompositionPredicate(Predicate predicate, Function function) {
            this.f83337a = (Predicate) Preconditions.t(predicate);
            this.f83338b = (Function) Preconditions.t(function);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ContainsPatternFromStringPredicate extends ContainsPatternPredicate {
        private static final long serialVersionUID = 0;

        @Override // com.google.common.base.Predicates.ContainsPatternPredicate
        public String toString() {
            return "Predicates.containsPattern(" + this.f83339a.c() + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ContainsPatternPredicate implements Predicate<CharSequence>, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final CommonPattern f83339a;

        @Override // com.google.common.base.Predicate
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean apply(CharSequence charSequence) {
            return this.f83339a.b(charSequence).b();
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(Object obj) {
            if (obj instanceof ContainsPatternPredicate) {
                ContainsPatternPredicate containsPatternPredicate = (ContainsPatternPredicate) obj;
                if (Objects.a(this.f83339a.c(), containsPatternPredicate.f83339a.c()) && this.f83339a.a() == containsPatternPredicate.f83339a.a()) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Objects.b(this.f83339a.c(), Integer.valueOf(this.f83339a.a()));
        }

        public String toString() {
            return "Predicates.contains(" + MoreObjects.c(this.f83339a).d("pattern", this.f83339a.c()).b("pattern.flags", this.f83339a.a()).toString() + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class InPredicate<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Collection f83340a;

        @Override // com.google.common.base.Predicate
        public boolean apply(Object obj) {
            try {
                return this.f83340a.contains(obj);
            } catch (ClassCastException | NullPointerException unused) {
                return false;
            }
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(Object obj) {
            if (obj instanceof InPredicate) {
                return this.f83340a.equals(((InPredicate) obj).f83340a);
            }
            return false;
        }

        public int hashCode() {
            return this.f83340a.hashCode();
        }

        public String toString() {
            return "Predicates.in(" + this.f83340a + ")";
        }

        private InPredicate(Collection collection) {
            this.f83340a = (Collection) Preconditions.t(collection);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class InstanceOfPredicate<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Class f83341a;

        @Override // com.google.common.base.Predicate
        public boolean apply(Object obj) {
            return this.f83341a.isInstance(obj);
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(Object obj) {
            return (obj instanceof InstanceOfPredicate) && this.f83341a == ((InstanceOfPredicate) obj).f83341a;
        }

        public int hashCode() {
            return this.f83341a.hashCode();
        }

        public String toString() {
            return "Predicates.instanceOf(" + this.f83341a.getName() + ")";
        }

        private InstanceOfPredicate(Class cls) {
            this.f83341a = (Class) Preconditions.t(cls);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class IsEqualToPredicate implements Predicate<Object>, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f83342a;

        @Override // com.google.common.base.Predicate
        public boolean apply(Object obj) {
            return this.f83342a.equals(obj);
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(Object obj) {
            if (obj instanceof IsEqualToPredicate) {
                return this.f83342a.equals(((IsEqualToPredicate) obj).f83342a);
            }
            return false;
        }

        public int hashCode() {
            return this.f83342a.hashCode();
        }

        public String toString() {
            return "Predicates.equalTo(" + this.f83342a + ")";
        }

        private IsEqualToPredicate(Object obj) {
            this.f83342a = obj;
        }

        Predicate a() {
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class NotPredicate<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Predicate f83343a;

        NotPredicate(Predicate predicate) {
            this.f83343a = (Predicate) Preconditions.t(predicate);
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(Object obj) {
            return !this.f83343a.apply(obj);
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(Object obj) {
            if (obj instanceof NotPredicate) {
                return this.f83343a.equals(((NotPredicate) obj).f83343a);
            }
            return false;
        }

        public int hashCode() {
            return ~this.f83343a.hashCode();
        }

        public String toString() {
            return "Predicates.not(" + this.f83343a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class OrPredicate<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f83349a;

        @Override // com.google.common.base.Predicate
        public boolean apply(Object obj) {
            for (int i3 = 0; i3 < this.f83349a.size(); i3++) {
                if (((Predicate) this.f83349a.get(i3)).apply(obj)) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(Object obj) {
            if (obj instanceof OrPredicate) {
                return this.f83349a.equals(((OrPredicate) obj).f83349a);
            }
            return false;
        }

        public int hashCode() {
            return this.f83349a.hashCode() + 87855567;
        }

        public String toString() {
            return Predicates.k("or", this.f83349a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class SubtypeOfPredicate implements Predicate<Class<?>>, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Class f83350a;

        @Override // com.google.common.base.Predicate
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean apply(Class cls) {
            return this.f83350a.isAssignableFrom(cls);
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(Object obj) {
            return (obj instanceof SubtypeOfPredicate) && this.f83350a == ((SubtypeOfPredicate) obj).f83350a;
        }

        public int hashCode() {
            return this.f83350a.hashCode();
        }

        public String toString() {
            return "Predicates.subtypeOf(" + this.f83350a.getName() + ")";
        }
    }

    public static Predicate b() {
        return ObjectPredicate.ALWAYS_TRUE.b();
    }

    public static Predicate c(Predicate predicate, Predicate predicate2) {
        return new AndPredicate(d((Predicate) Preconditions.t(predicate), (Predicate) Preconditions.t(predicate2)));
    }

    private static List d(Predicate predicate, Predicate predicate2) {
        return Arrays.asList(predicate, predicate2);
    }

    public static Predicate e(Predicate predicate, Function function) {
        return new CompositionPredicate(predicate, function);
    }

    public static Predicate f(Object obj) {
        return obj == null ? i() : new IsEqualToPredicate(obj).a();
    }

    public static Predicate g(Collection collection) {
        return new InPredicate(collection);
    }

    public static Predicate h(Class cls) {
        return new InstanceOfPredicate(cls);
    }

    public static Predicate i() {
        return ObjectPredicate.IS_NULL.b();
    }

    public static Predicate j(Predicate predicate) {
        return new NotPredicate(predicate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String k(String str, Iterable iterable) {
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

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    enum ObjectPredicate implements Predicate<Object> {
        ALWAYS_TRUE { // from class: com.google.common.base.Predicates.ObjectPredicate.1
            @Override // com.google.common.base.Predicate
            public boolean apply(Object obj) {
                return true;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.alwaysTrue()";
            }
        },
        ALWAYS_FALSE { // from class: com.google.common.base.Predicates.ObjectPredicate.2
            @Override // com.google.common.base.Predicate
            public boolean apply(Object obj) {
                return false;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.alwaysFalse()";
            }
        },
        IS_NULL { // from class: com.google.common.base.Predicates.ObjectPredicate.3
            @Override // com.google.common.base.Predicate
            public boolean apply(Object obj) {
                return obj == null;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.isNull()";
            }
        },
        NOT_NULL { // from class: com.google.common.base.Predicates.ObjectPredicate.4
            @Override // com.google.common.base.Predicate
            public boolean apply(Object obj) {
                return obj != null;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.notNull()";
            }
        };

        Predicate b() {
            return this;
        }
    }
}
