package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Function;
import com.applovin.exoplayer2.common.base.Objects;
import com.applovin.exoplayer2.common.base.Preconditions;
import com.applovin.impl.rj;
import com.google.android.gms.common.api.Api;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class uc {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a extends yo {
        a(Iterator it) {
            super(it);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.applovin.impl.yo
        public Object a(Map.Entry entry) {
            return entry.getValue();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static abstract class b implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f64167a = new a("KEY", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f64168b = new C0126b("VALUE", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ b[] f64169c = a();

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        enum a extends b {
            a(String str, int i3) {
                super(str, i3, null);
            }

            @Override // com.applovin.exoplayer2.common.base.Function
            public Object apply(Map.Entry entry) {
                return entry.getKey();
            }
        }

        /* JADX INFO: renamed from: com.applovin.impl.uc$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        enum C0126b extends b {
            C0126b(String str, int i3) {
                super(str, i3, null);
            }

            @Override // com.applovin.exoplayer2.common.base.Function
            public Object apply(Map.Entry entry) {
                return entry.getValue();
            }
        }

        private b(String str, int i3) {
        }

        private static /* synthetic */ b[] a() {
            return new b[]{f64167a, f64168b};
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) f64169c.clone();
        }

        /* synthetic */ b(String str, int i3, tc tcVar) {
            this(str, i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class c extends rj.b {
        c() {
        }

        abstract Map a();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public abstract boolean contains(Object obj);

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return a().isEmpty();
        }

        @Override // com.applovin.impl.rj.b, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection collection) {
            try {
                return super.removeAll((Collection) Preconditions.checkNotNull(collection));
            } catch (UnsupportedOperationException unused) {
                return rj.a((Set) this, collection.iterator());
            }
        }

        @Override // com.applovin.impl.rj.b, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection collection) {
            try {
                return super.retainAll((Collection) Preconditions.checkNotNull(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet hashSetA = rj.a(collection.size());
                for (Object obj : collection) {
                    if (contains(obj)) {
                        hashSetA.add(((Map.Entry) obj).getKey());
                    }
                }
                return a().keySet().retainAll(hashSetA);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return a().size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class d extends rj.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Map f64170a;

        d(Map map) {
            this.f64170a = (Map) Preconditions.checkNotNull(map);
        }

        Map a() {
            return this.f64170a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return a().containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return a().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return a().size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class e extends AbstractCollection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Map f64171a;

        e(Map map) {
            this.f64171a = (Map) Preconditions.checkNotNull(map);
        }

        final Map a() {
            return this.f64171a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return a().containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return a().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return uc.a(a().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            try {
                return super.remove(obj);
            } catch (UnsupportedOperationException unused) {
                for (Map.Entry entry : a().entrySet()) {
                    if (Objects.equal(obj, entry.getValue())) {
                        a().remove(entry.getKey());
                        return true;
                    }
                }
                return false;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection collection) {
            try {
                return super.removeAll((Collection) Preconditions.checkNotNull(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet hashSetA = rj.a();
                for (Map.Entry entry : a().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        hashSetA.add(entry.getKey());
                    }
                }
                return a().keySet().removeAll(hashSetA);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection collection) {
            try {
                return super.retainAll((Collection) Preconditions.checkNotNull(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet hashSetA = rj.a();
                for (Map.Entry entry : a().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        hashSetA.add(entry.getKey());
                    }
                }
                return a().keySet().retainAll(hashSetA);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return a().size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class f extends AbstractMap {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private transient Set f64172a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private transient Collection f64173b;

        f() {
        }

        abstract Set a();

        Collection b() {
            return new e(this);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set entrySet() {
            Set set = this.f64172a;
            if (set != null) {
                return set;
            }
            Set setA = a();
            this.f64172a = setA;
            return setA;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection values() {
            Collection collection = this.f64173b;
            if (collection != null) {
                return collection;
            }
            Collection collectionB = b();
            this.f64173b = collectionB;
            return collectionB;
        }
    }

    static int a(int i3) {
        if (i3 >= 3) {
            return i3 < 1073741824 ? (int) ((i3 / 0.75f) + 1.0f) : Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
        p3.a(i3, "expectedSize");
        return i3 + 1;
    }

    static boolean b(Map map, Object obj) {
        Preconditions.checkNotNull(map);
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    static Object c(Map map, Object obj) {
        Preconditions.checkNotNull(map);
        try {
            return map.get(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    static Object d(Map map, Object obj) {
        Preconditions.checkNotNull(map);
        try {
            return map.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    static boolean a(Map map, Object obj) {
        if (map == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return map.entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    public static IdentityHashMap b() {
        return new IdentityHashMap();
    }

    static Function c() {
        return b.f64168b;
    }

    static String a(Map map) {
        StringBuilder sbA = q3.a(map.size());
        sbA.append('{');
        boolean z2 = true;
        for (Map.Entry entry : map.entrySet()) {
            if (!z2) {
                sbA.append(", ");
            }
            sbA.append(entry.getKey());
            sbA.append('=');
            sbA.append(entry.getValue());
            z2 = false;
        }
        sbA.append('}');
        return sbA.toString();
    }

    static Function a() {
        return b.f64167a;
    }

    static Iterator a(Iterator it) {
        return new a(it);
    }

    public static Map.Entry a(Object obj, Object obj2) {
        return new cb(obj, obj2);
    }
}
