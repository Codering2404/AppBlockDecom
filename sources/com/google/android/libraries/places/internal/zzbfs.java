package com.google.android.libraries.places.internal;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class zzbfs extends AbstractMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object[] f76164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f76165b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map f76166c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f76167d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile zzbfr f76168f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Map f76169g;

    private zzbfs() {
        Map map = Collections.EMPTY_MAP;
        this.f76166c = map;
        this.f76169g = map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public final Object g(int i3) {
        h();
        Object value = ((zzbfp) this.f76164a[i3]).getValue();
        Object[] objArr = this.f76164a;
        System.arraycopy(objArr, i3 + 1, objArr, i3, (this.f76165b - i3) - 1);
        this.f76165b--;
        if (!this.f76166c.isEmpty()) {
            Iterator it = o().entrySet().iterator();
            Object[] objArr2 = this.f76164a;
            int i4 = this.f76165b;
            Map.Entry entry = (Map.Entry) it.next();
            objArr2[i4] = new zzbfp(this, (Comparable) entry.getKey(), entry.getValue());
            this.f76165b++;
            it.remove();
        }
        return value;
    }

    private final int m(Comparable comparable) {
        int i3 = this.f76165b;
        int i4 = i3 - 1;
        int i5 = 0;
        if (i4 >= 0) {
            int iCompareTo = comparable.compareTo(((zzbfp) this.f76164a[i4]).a());
            if (iCompareTo > 0) {
                return -(i3 + 1);
            }
            if (iCompareTo == 0) {
                return i4;
            }
        }
        while (i5 <= i4) {
            int i6 = (i5 + i4) / 2;
            int iCompareTo2 = comparable.compareTo(((zzbfp) this.f76164a[i6]).a());
            if (iCompareTo2 < 0) {
                i4 = i6 - 1;
            } else {
                if (iCompareTo2 <= 0) {
                    return i6;
                }
                i5 = i6 + 1;
            }
        }
        return -(i5 + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public final void h() {
        if (this.f76167d) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap o() {
        h();
        if (this.f76166c.isEmpty() && !(this.f76166c instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f76166c = treeMap;
            this.f76169g = treeMap.descendingMap();
        }
        return (SortedMap) this.f76166c;
    }

    public void a() {
        if (this.f76167d) {
            return;
        }
        this.f76166c = this.f76166c.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.f76166c);
        this.f76169g = this.f76169g.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.f76169g);
        this.f76167d = true;
    }

    public final boolean b() {
        return this.f76167d;
    }

    public final int c() {
        return this.f76165b;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        h();
        if (this.f76165b != 0) {
            this.f76164a = null;
            this.f76165b = 0;
        }
        if (this.f76166c.isEmpty()) {
            return;
        }
        this.f76166c.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return m(comparable) >= 0 || this.f76166c.containsKey(comparable);
    }

    public final Map.Entry d(int i3) {
        if (i3 < this.f76165b) {
            return (zzbfp) this.f76164a[i3];
        }
        throw new ArrayIndexOutOfBoundsException(i3);
    }

    public final Iterable e() {
        return this.f76166c.isEmpty() ? Collections.EMPTY_SET : this.f76166c.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        if (this.f76168f == null) {
            this.f76168f = new zzbfr(this, null);
        }
        return this.f76168f;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbfs)) {
            return super.equals(obj);
        }
        zzbfs zzbfsVar = (zzbfs) obj;
        int size = size();
        if (size != zzbfsVar.size()) {
            return false;
        }
        int i3 = this.f76165b;
        if (i3 != zzbfsVar.f76165b) {
            return entrySet().equals(zzbfsVar.entrySet());
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!d(i4).equals(zzbfsVar.d(i4))) {
                return false;
            }
        }
        if (i3 != size) {
            return this.f76166c.equals(zzbfsVar.f76166c);
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Object put(Comparable comparable, Object obj) {
        h();
        int iM = m(comparable);
        if (iM >= 0) {
            return ((zzbfp) this.f76164a[iM]).setValue(obj);
        }
        h();
        if (this.f76164a == null) {
            this.f76164a = new Object[16];
        }
        int i3 = -(iM + 1);
        if (i3 >= 16) {
            return o().put(comparable, obj);
        }
        if (this.f76165b == 16) {
            zzbfp zzbfpVar = (zzbfp) this.f76164a[15];
            this.f76165b = 15;
            o().put(zzbfpVar.a(), zzbfpVar.getValue());
        }
        Object[] objArr = this.f76164a;
        int length = objArr.length;
        System.arraycopy(objArr, i3, objArr, i3 + 1, 15 - i3);
        this.f76164a[i3] = new zzbfp(this, comparable, obj);
        this.f76165b++;
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iM = m(comparable);
        return iM >= 0 ? ((zzbfp) this.f76164a[iM]).getValue() : this.f76166c.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int i3 = this.f76165b;
        int iHashCode = 0;
        for (int i4 = 0; i4 < i3; i4++) {
            iHashCode += this.f76164a[i4].hashCode();
        }
        return this.f76166c.size() > 0 ? iHashCode + this.f76166c.hashCode() : iHashCode;
    }

    final /* synthetic */ Object[] i() {
        return this.f76164a;
    }

    final /* synthetic */ int j() {
        return this.f76165b;
    }

    final /* synthetic */ Map k() {
        return this.f76166c;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        h();
        Comparable comparable = (Comparable) obj;
        int iM = m(comparable);
        if (iM >= 0) {
            return g(iM);
        }
        if (this.f76166c.isEmpty()) {
            return null;
        }
        return this.f76166c.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f76165b + this.f76166c.size();
    }

    /* synthetic */ zzbfs(byte[] bArr) {
        Map map = Collections.EMPTY_MAP;
        this.f76166c = map;
        this.f76169g = map;
    }
}
