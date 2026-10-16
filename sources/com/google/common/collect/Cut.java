package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
abstract class Cut<C extends Comparable> implements Comparable<Cut<C>>, Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Comparable f83872a;

    /* JADX INFO: renamed from: com.google.common.collect.Cut$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f83873a;

        static {
            int[] iArr = new int[BoundType.values().length];
            f83873a = iArr;
            try {
                iArr[BoundType.CLOSED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f83873a[BoundType.OPEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class AboveAll extends Cut<Comparable<?>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final AboveAll f83874b = new AboveAll();
        private static final long serialVersionUID = 0;

        private AboveAll() {
            super("");
        }

        private Object readResolve() {
            return f83874b;
        }

        @Override // com.google.common.collect.Cut, java.lang.Comparable
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public int compareTo(Cut cut) {
            return cut == this ? 0 : 1;
        }

        @Override // com.google.common.collect.Cut
        void g(StringBuilder sb) {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.Cut
        void h(StringBuilder sb) {
            sb.append("+∞)");
        }

        @Override // com.google.common.collect.Cut
        public int hashCode() {
            return System.identityHashCode(this);
        }

        @Override // com.google.common.collect.Cut
        Comparable i() {
            throw new IllegalStateException("range unbounded on this side");
        }

        @Override // com.google.common.collect.Cut
        Comparable j(DiscreteDomain discreteDomain) {
            return discreteDomain.b();
        }

        @Override // com.google.common.collect.Cut
        boolean k(Comparable comparable) {
            return false;
        }

        @Override // com.google.common.collect.Cut
        Comparable l(DiscreteDomain discreteDomain) {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.Cut
        BoundType m() {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // com.google.common.collect.Cut
        BoundType n() {
            throw new IllegalStateException();
        }

        @Override // com.google.common.collect.Cut
        Cut o(BoundType boundType, DiscreteDomain discreteDomain) {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // com.google.common.collect.Cut
        Cut p(BoundType boundType, DiscreteDomain discreteDomain) {
            throw new IllegalStateException();
        }

        public String toString() {
            return "+∞";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class AboveValue<C extends Comparable> extends Cut<C> {
        private static final long serialVersionUID = 0;

        AboveValue(Comparable comparable) {
            super((Comparable) Preconditions.t(comparable));
        }

        @Override // com.google.common.collect.Cut, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return super.compareTo((Cut) obj);
        }

        @Override // com.google.common.collect.Cut
        Cut e(DiscreteDomain discreteDomain) {
            Comparable comparableL = l(discreteDomain);
            return comparableL != null ? Cut.d(comparableL) : Cut.a();
        }

        @Override // com.google.common.collect.Cut
        void g(StringBuilder sb) {
            sb.append('(');
            sb.append(this.f83872a);
        }

        @Override // com.google.common.collect.Cut
        void h(StringBuilder sb) {
            sb.append(this.f83872a);
            sb.append(']');
        }

        @Override // com.google.common.collect.Cut
        public int hashCode() {
            return ~this.f83872a.hashCode();
        }

        @Override // com.google.common.collect.Cut
        Comparable j(DiscreteDomain discreteDomain) {
            return this.f83872a;
        }

        @Override // com.google.common.collect.Cut
        boolean k(Comparable comparable) {
            return Range.h(this.f83872a, comparable) < 0;
        }

        @Override // com.google.common.collect.Cut
        Comparable l(DiscreteDomain discreteDomain) {
            return discreteDomain.d(this.f83872a);
        }

        @Override // com.google.common.collect.Cut
        BoundType m() {
            return BoundType.OPEN;
        }

        @Override // com.google.common.collect.Cut
        BoundType n() {
            return BoundType.CLOSED;
        }

        @Override // com.google.common.collect.Cut
        Cut o(BoundType boundType, DiscreteDomain discreteDomain) {
            int i3 = AnonymousClass1.f83873a[boundType.ordinal()];
            if (i3 == 1) {
                Comparable comparableD = discreteDomain.d(this.f83872a);
                return comparableD == null ? Cut.c() : Cut.d(comparableD);
            }
            if (i3 == 2) {
                return this;
            }
            throw new AssertionError();
        }

        @Override // com.google.common.collect.Cut
        Cut p(BoundType boundType, DiscreteDomain discreteDomain) {
            int i3 = AnonymousClass1.f83873a[boundType.ordinal()];
            if (i3 == 1) {
                return this;
            }
            if (i3 != 2) {
                throw new AssertionError();
            }
            Comparable comparableD = discreteDomain.d(this.f83872a);
            return comparableD == null ? Cut.a() : Cut.d(comparableD);
        }

        public String toString() {
            return "/" + this.f83872a + "\\";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class BelowAll extends Cut<Comparable<?>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final BelowAll f83875b = new BelowAll();
        private static final long serialVersionUID = 0;

        private BelowAll() {
            super("");
        }

        private Object readResolve() {
            return f83875b;
        }

        @Override // com.google.common.collect.Cut
        Cut e(DiscreteDomain discreteDomain) {
            try {
                return Cut.d(discreteDomain.c());
            } catch (NoSuchElementException unused) {
                return this;
            }
        }

        @Override // com.google.common.collect.Cut, java.lang.Comparable
        /* JADX INFO: renamed from: f */
        public int compareTo(Cut cut) {
            return cut == this ? 0 : -1;
        }

        @Override // com.google.common.collect.Cut
        void g(StringBuilder sb) {
            sb.append("(-∞");
        }

        @Override // com.google.common.collect.Cut
        void h(StringBuilder sb) {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.Cut
        public int hashCode() {
            return System.identityHashCode(this);
        }

        @Override // com.google.common.collect.Cut
        Comparable i() {
            throw new IllegalStateException("range unbounded on this side");
        }

        @Override // com.google.common.collect.Cut
        Comparable j(DiscreteDomain discreteDomain) {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.Cut
        boolean k(Comparable comparable) {
            return true;
        }

        @Override // com.google.common.collect.Cut
        Comparable l(DiscreteDomain discreteDomain) {
            return discreteDomain.c();
        }

        @Override // com.google.common.collect.Cut
        BoundType m() {
            throw new IllegalStateException();
        }

        @Override // com.google.common.collect.Cut
        BoundType n() {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // com.google.common.collect.Cut
        Cut o(BoundType boundType, DiscreteDomain discreteDomain) {
            throw new IllegalStateException();
        }

        @Override // com.google.common.collect.Cut
        Cut p(BoundType boundType, DiscreteDomain discreteDomain) {
            throw new AssertionError("this statement should be unreachable");
        }

        public String toString() {
            return "-∞";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class BelowValue<C extends Comparable> extends Cut<C> {
        private static final long serialVersionUID = 0;

        BelowValue(Comparable comparable) {
            super((Comparable) Preconditions.t(comparable));
        }

        @Override // com.google.common.collect.Cut, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return super.compareTo((Cut) obj);
        }

        @Override // com.google.common.collect.Cut
        void g(StringBuilder sb) {
            sb.append('[');
            sb.append(this.f83872a);
        }

        @Override // com.google.common.collect.Cut
        void h(StringBuilder sb) {
            sb.append(this.f83872a);
            sb.append(')');
        }

        @Override // com.google.common.collect.Cut
        public int hashCode() {
            return this.f83872a.hashCode();
        }

        @Override // com.google.common.collect.Cut
        Comparable j(DiscreteDomain discreteDomain) {
            return discreteDomain.f(this.f83872a);
        }

        @Override // com.google.common.collect.Cut
        boolean k(Comparable comparable) {
            return Range.h(this.f83872a, comparable) <= 0;
        }

        @Override // com.google.common.collect.Cut
        Comparable l(DiscreteDomain discreteDomain) {
            return this.f83872a;
        }

        @Override // com.google.common.collect.Cut
        BoundType m() {
            return BoundType.CLOSED;
        }

        @Override // com.google.common.collect.Cut
        BoundType n() {
            return BoundType.OPEN;
        }

        @Override // com.google.common.collect.Cut
        Cut o(BoundType boundType, DiscreteDomain discreteDomain) {
            int i3 = AnonymousClass1.f83873a[boundType.ordinal()];
            if (i3 == 1) {
                return this;
            }
            if (i3 != 2) {
                throw new AssertionError();
            }
            Comparable comparableF = discreteDomain.f(this.f83872a);
            return comparableF == null ? Cut.c() : new AboveValue(comparableF);
        }

        @Override // com.google.common.collect.Cut
        Cut p(BoundType boundType, DiscreteDomain discreteDomain) {
            int i3 = AnonymousClass1.f83873a[boundType.ordinal()];
            if (i3 == 1) {
                Comparable comparableF = discreteDomain.f(this.f83872a);
                return comparableF == null ? Cut.a() : new AboveValue(comparableF);
            }
            if (i3 == 2) {
                return this;
            }
            throw new AssertionError();
        }

        public String toString() {
            return "\\" + this.f83872a + "/";
        }
    }

    Cut(Comparable comparable) {
        this.f83872a = comparable;
    }

    static Cut a() {
        return AboveAll.f83874b;
    }

    static Cut b(Comparable comparable) {
        return new AboveValue(comparable);
    }

    static Cut c() {
        return BelowAll.f83875b;
    }

    static Cut d(Comparable comparable) {
        return new BelowValue(comparable);
    }

    public boolean equals(Object obj) {
        if (obj instanceof Cut) {
            try {
                if (compareTo((Cut) obj) == 0) {
                    return true;
                }
            } catch (ClassCastException unused) {
            }
        }
        return false;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: f */
    public int compareTo(Cut cut) {
        if (cut == c()) {
            return 1;
        }
        if (cut == a()) {
            return -1;
        }
        int iH = Range.h(this.f83872a, cut.f83872a);
        return iH != 0 ? iH : Boolean.compare(this instanceof AboveValue, cut instanceof AboveValue);
    }

    abstract void g(StringBuilder sb);

    abstract void h(StringBuilder sb);

    public abstract int hashCode();

    Comparable i() {
        return this.f83872a;
    }

    abstract Comparable j(DiscreteDomain discreteDomain);

    abstract boolean k(Comparable comparable);

    abstract Comparable l(DiscreteDomain discreteDomain);

    abstract BoundType m();

    abstract BoundType n();

    abstract Cut o(BoundType boundType, DiscreteDomain discreteDomain);

    abstract Cut p(BoundType boundType, DiscreteDomain discreteDomain);

    Cut e(DiscreteDomain discreteDomain) {
        return this;
    }
}
