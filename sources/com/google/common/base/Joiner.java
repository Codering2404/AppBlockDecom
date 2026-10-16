package com.google.common.base;

import java.io.IOException;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public class Joiner {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f83314a;

    /* JADX INFO: renamed from: com.google.common.base.Joiner$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass3 extends AbstractList<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object[] f83318a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f83319b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f83320c;

        @Override // java.util.AbstractList, java.util.List
        public Object get(int i3) {
            return i3 != 0 ? i3 != 1 ? this.f83318a[i3 - 2] : this.f83320c : this.f83319b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f83318a.length + 2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class MapJoiner {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Joiner f83321a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f83322b;

        public Appendable a(Appendable appendable, Iterator it) throws IOException {
            Preconditions.t(appendable);
            if (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                appendable.append(this.f83321a.k(entry.getKey()));
                appendable.append(this.f83322b);
                appendable.append(this.f83321a.k(entry.getValue()));
                while (it.hasNext()) {
                    appendable.append(this.f83321a.f83314a);
                    Map.Entry entry2 = (Map.Entry) it.next();
                    appendable.append(this.f83321a.k(entry2.getKey()));
                    appendable.append(this.f83322b);
                    appendable.append(this.f83321a.k(entry2.getValue()));
                }
            }
            return appendable;
        }

        public StringBuilder b(StringBuilder sb, Iterable iterable) {
            return c(sb, iterable.iterator());
        }

        public StringBuilder c(StringBuilder sb, Iterator it) {
            try {
                a(sb, it);
                return sb;
            } catch (IOException e3) {
                throw new AssertionError(e3);
            }
        }

        public String d(Iterable iterable) {
            return e(iterable.iterator());
        }

        public String e(Iterator it) {
            return c(new StringBuilder(), it).toString();
        }

        public String f(Map map) {
            return d(map.entrySet());
        }

        private MapJoiner(Joiner joiner, String str) {
            this.f83321a = joiner;
            this.f83322b = (String) Preconditions.t(str);
        }
    }

    public static Joiner h(char c3) {
        return new Joiner(String.valueOf(c3));
    }

    public static Joiner i(String str) {
        return new Joiner(str);
    }

    public Appendable b(Appendable appendable, Iterator it) throws IOException {
        Preconditions.t(appendable);
        if (it.hasNext()) {
            appendable.append(k(it.next()));
            while (it.hasNext()) {
                appendable.append(this.f83314a);
                appendable.append(k(it.next()));
            }
        }
        return appendable;
    }

    public final StringBuilder c(StringBuilder sb, Iterable iterable) {
        return d(sb, iterable.iterator());
    }

    public final StringBuilder d(StringBuilder sb, Iterator it) {
        try {
            b(sb, it);
            return sb;
        } catch (IOException e3) {
            throw new AssertionError(e3);
        }
    }

    public final String e(Iterable iterable) {
        return f(iterable.iterator());
    }

    public final String f(Iterator it) {
        return d(new StringBuilder(), it).toString();
    }

    public final String g(Object[] objArr) {
        return e(Arrays.asList(objArr));
    }

    public Joiner j() {
        return new Joiner(this) { // from class: com.google.common.base.Joiner.2
            @Override // com.google.common.base.Joiner
            public Appendable b(Appendable appendable, Iterator it) throws IOException {
                Preconditions.u(appendable, "appendable");
                Preconditions.u(it, "parts");
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (next != null) {
                        appendable.append(Joiner.this.k(next));
                        break;
                    }
                }
                while (it.hasNext()) {
                    Object next2 = it.next();
                    if (next2 != null) {
                        appendable.append(Joiner.this.f83314a);
                        appendable.append(Joiner.this.k(next2));
                    }
                }
                return appendable;
            }

            @Override // com.google.common.base.Joiner
            public Joiner l(String str) {
                throw new UnsupportedOperationException("already specified skipNulls");
            }

            @Override // com.google.common.base.Joiner
            public MapJoiner m(String str) {
                throw new UnsupportedOperationException("can't use .skipNulls() with maps");
            }
        };
    }

    CharSequence k(Object obj) {
        java.util.Objects.requireNonNull(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    public Joiner l(final String str) {
        Preconditions.t(str);
        return new Joiner(this, this) { // from class: com.google.common.base.Joiner.1

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ Joiner f83316c;

            {
                this.f83316c = this;
            }

            @Override // com.google.common.base.Joiner
            public Joiner j() {
                throw new UnsupportedOperationException("already specified useForNull");
            }

            @Override // com.google.common.base.Joiner
            CharSequence k(Object obj) {
                return obj == null ? str : this.f83316c.k(obj);
            }

            @Override // com.google.common.base.Joiner
            public Joiner l(String str2) {
                throw new UnsupportedOperationException("already specified useForNull");
            }
        };
    }

    public MapJoiner m(String str) {
        return new MapJoiner(str);
    }

    private Joiner(String str) {
        this.f83314a = (String) Preconditions.t(str);
    }

    private Joiner(Joiner joiner) {
        this.f83314a = joiner.f83314a;
    }
}
