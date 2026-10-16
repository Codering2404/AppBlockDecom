package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class RegularImmutableMap<K, V> extends ImmutableMap<K, V> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final ImmutableMap f84581i = new RegularImmutableMap(null, new Object[0], 0);
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final transient Object f84582f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final transient Object[] f84583g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final transient int f84584h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class EntrySet<K, V> extends ImmutableSet<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final transient ImmutableMap f84585c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final transient Object[] f84586d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final transient int f84587f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final transient int f84588g;

        EntrySet(ImmutableMap immutableMap, Object[] objArr, int i3, int i4) {
            this.f84585c = immutableMap;
            this.f84586d = objArr;
            this.f84587f = i3;
            this.f84588g = i4;
        }

        @Override // com.google.common.collect.ImmutableCollection
        int b(Object[] objArr, int i3) {
            return a().b(objArr, i3);
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Object value = entry.getValue();
                if (value != null && value.equals(this.f84585c.get(key))) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean g() {
            return true;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        /* JADX INFO: renamed from: h */
        public UnmodifiableIterator iterator() {
            return a().iterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f84588g;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        Object writeReplace() {
            return super.writeReplace();
        }

        @Override // com.google.common.collect.ImmutableSet
        ImmutableList x() {
            return new ImmutableList<Map.Entry<K, V>>() { // from class: com.google.common.collect.RegularImmutableMap.EntrySet.1
                @Override // java.util.List
                /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
                public Map.Entry get(int i3) {
                    Preconditions.r(i3, EntrySet.this.f84588g);
                    int i4 = i3 * 2;
                    Object obj = EntrySet.this.f84586d[EntrySet.this.f84587f + i4];
                    Objects.requireNonNull(obj);
                    Object obj2 = EntrySet.this.f84586d[i4 + (EntrySet.this.f84587f ^ 1)];
                    Objects.requireNonNull(obj2);
                    return new AbstractMap.SimpleImmutableEntry(obj, obj2);
                }

                @Override // com.google.common.collect.ImmutableCollection
                public boolean g() {
                    return true;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return EntrySet.this.f84588g;
                }

                @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
                Object writeReplace() {
                    return super.writeReplace();
                }
            };
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class KeySet<K> extends ImmutableSet<K> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final transient ImmutableMap f84590c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final transient ImmutableList f84591d;

        KeySet(ImmutableMap immutableMap, ImmutableList immutableList) {
            this.f84590c = immutableMap;
            this.f84591d = immutableList;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        public ImmutableList a() {
            return this.f84591d;
        }

        @Override // com.google.common.collect.ImmutableCollection
        int b(Object[] objArr, int i3) {
            return a().b(objArr, i3);
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.f84590c.get(obj) != null;
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean g() {
            return true;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        /* JADX INFO: renamed from: h */
        public UnmodifiableIterator iterator() {
            return a().iterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f84590c.size();
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        Object writeReplace() {
            return super.writeReplace();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class KeysOrValuesAsList extends ImmutableList<Object> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final transient Object[] f84592c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final transient int f84593d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final transient int f84594f;

        KeysOrValuesAsList(Object[] objArr, int i3, int i4) {
            this.f84592c = objArr;
            this.f84593d = i3;
            this.f84594f = i4;
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean g() {
            return true;
        }

        @Override // java.util.List
        public Object get(int i3) {
            Preconditions.r(i3, this.f84594f);
            Object obj = this.f84592c[(i3 * 2) + this.f84593d];
            Objects.requireNonNull(obj);
            return obj;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f84594f;
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
        Object writeReplace() {
            return super.writeReplace();
        }
    }

    private RegularImmutableMap(Object obj, Object[] objArr, int i3) {
        this.f84582f = obj;
        this.f84583g = objArr;
        this.f84584h = i3;
    }

    static RegularImmutableMap t(int i3, Object[] objArr) {
        return u(i3, objArr, null);
    }

    static RegularImmutableMap u(int i3, Object[] objArr, ImmutableMap.Builder builder) {
        if (i3 == 0) {
            return (RegularImmutableMap) f84581i;
        }
        if (i3 == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            Object obj2 = objArr[1];
            Objects.requireNonNull(obj2);
            CollectPreconditions.a(obj, obj2);
            return new RegularImmutableMap(null, objArr, 1);
        }
        Preconditions.w(i3, objArr.length >> 1);
        Object objV = v(objArr, i3, ImmutableSet.q(i3), 0);
        if (objV instanceof Object[]) {
            Object[] objArr2 = (Object[]) objV;
            ImmutableMap.Builder.DuplicateKey duplicateKey = (ImmutableMap.Builder.DuplicateKey) objArr2[2];
            if (builder == null) {
                throw duplicateKey.a();
            }
            builder.f84032e = duplicateKey;
            Object obj3 = objArr2[0];
            int iIntValue = ((Integer) objArr2[1]).intValue();
            objArr = Arrays.copyOf(objArr, iIntValue * 2);
            objV = obj3;
            i3 = iIntValue;
        }
        return new RegularImmutableMap(objV, objArr, i3);
    }

    private static Object v(Object[] objArr, int i3, int i4, int i5) {
        int i6;
        ImmutableMap.Builder.DuplicateKey duplicateKey = null;
        int i7 = 1;
        if (i3 == 1) {
            Object obj = objArr[i5];
            Objects.requireNonNull(obj);
            Object obj2 = objArr[i5 ^ 1];
            Objects.requireNonNull(obj2);
            CollectPreconditions.a(obj, obj2);
            return null;
        }
        int i8 = i4 - 1;
        if (i4 <= 128) {
            byte[] bArr = new byte[i4];
            Arrays.fill(bArr, (byte) -1);
            int i9 = 0;
            for (int i10 = 0; i10 < i3; i10++) {
                int i11 = (i10 * 2) + i5;
                int i12 = (i9 * 2) + i5;
                Object obj3 = objArr[i11];
                Objects.requireNonNull(obj3);
                Object obj4 = objArr[i11 ^ 1];
                Objects.requireNonNull(obj4);
                CollectPreconditions.a(obj3, obj4);
                int iC = Hashing.c(obj3.hashCode());
                while (true) {
                    int i13 = iC & i8;
                    int i14 = bArr[i13] & 255;
                    if (i14 == 255) {
                        bArr[i13] = (byte) i12;
                        if (i9 < i10) {
                            objArr[i12] = obj3;
                            objArr[i12 ^ 1] = obj4;
                        }
                        i9++;
                    } else {
                        if (obj3.equals(objArr[i14])) {
                            int i15 = i14 ^ 1;
                            Object obj5 = objArr[i15];
                            Objects.requireNonNull(obj5);
                            duplicateKey = new ImmutableMap.Builder.DuplicateKey(obj3, obj4, obj5);
                            objArr[i15] = obj4;
                            break;
                        }
                        iC = i13 + 1;
                    }
                }
            }
            return i9 == i3 ? bArr : new Object[]{bArr, Integer.valueOf(i9), duplicateKey};
        }
        if (i4 <= 32768) {
            short[] sArr = new short[i4];
            Arrays.fill(sArr, (short) -1);
            int i16 = 0;
            for (int i17 = 0; i17 < i3; i17++) {
                int i18 = (i17 * 2) + i5;
                int i19 = (i16 * 2) + i5;
                Object obj6 = objArr[i18];
                Objects.requireNonNull(obj6);
                Object obj7 = objArr[i18 ^ 1];
                Objects.requireNonNull(obj7);
                CollectPreconditions.a(obj6, obj7);
                int iC2 = Hashing.c(obj6.hashCode());
                while (true) {
                    int i20 = iC2 & i8;
                    int i21 = sArr[i20] & 65535;
                    if (i21 == 65535) {
                        sArr[i20] = (short) i19;
                        if (i16 < i17) {
                            objArr[i19] = obj6;
                            objArr[i19 ^ 1] = obj7;
                        }
                        i16++;
                    } else {
                        if (obj6.equals(objArr[i21])) {
                            int i22 = i21 ^ 1;
                            Object obj8 = objArr[i22];
                            Objects.requireNonNull(obj8);
                            duplicateKey = new ImmutableMap.Builder.DuplicateKey(obj6, obj7, obj8);
                            objArr[i22] = obj7;
                            break;
                        }
                        iC2 = i20 + 1;
                    }
                }
            }
            return i16 == i3 ? sArr : new Object[]{sArr, Integer.valueOf(i16), duplicateKey};
        }
        int[] iArr = new int[i4];
        Arrays.fill(iArr, -1);
        int i23 = 0;
        int i24 = 0;
        while (i23 < i3) {
            int i25 = (i23 * 2) + i5;
            int i26 = (i24 * 2) + i5;
            Object obj9 = objArr[i25];
            Objects.requireNonNull(obj9);
            Object obj10 = objArr[i25 ^ i7];
            Objects.requireNonNull(obj10);
            CollectPreconditions.a(obj9, obj10);
            int iC3 = Hashing.c(obj9.hashCode());
            while (true) {
                int i27 = iC3 & i8;
                int i28 = iArr[i27];
                if (i28 == -1) {
                    iArr[i27] = i26;
                    if (i24 < i23) {
                        objArr[i26] = obj9;
                        objArr[i26 ^ 1] = obj10;
                    }
                    i24++;
                    i6 = i7;
                } else {
                    i6 = i7;
                    if (obj9.equals(objArr[i28])) {
                        int i29 = i28 ^ 1;
                        Object obj11 = objArr[i29];
                        Objects.requireNonNull(obj11);
                        duplicateKey = new ImmutableMap.Builder.DuplicateKey(obj9, obj10, obj11);
                        objArr[i29] = obj10;
                        break;
                    }
                    iC3 = i27 + 1;
                    i7 = i6;
                }
            }
            i23++;
            i7 = i6;
        }
        int i30 = i7;
        if (i24 == i3) {
            return iArr;
        }
        Object[] objArr2 = new Object[3];
        objArr2[0] = iArr;
        objArr2[i30] = Integer.valueOf(i24);
        objArr2[2] = duplicateKey;
        return objArr2;
    }

    static Object w(Object[] objArr, int i3, int i4, int i5) {
        Object objV = v(objArr, i3, i4, i5);
        if (objV instanceof Object[]) {
            throw ((ImmutableMap.Builder.DuplicateKey) ((Object[]) objV)[2]).a();
        }
        return objV;
    }

    static Object x(Object obj, Object[] objArr, int i3, int i4, Object obj2) {
        if (obj2 == null) {
            return null;
        }
        if (i3 == 1) {
            Object obj3 = objArr[i4];
            Objects.requireNonNull(obj3);
            if (!obj3.equals(obj2)) {
                return null;
            }
            Object obj4 = objArr[i4 ^ 1];
            Objects.requireNonNull(obj4);
            return obj4;
        }
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            int length = bArr.length - 1;
            int iC = Hashing.c(obj2.hashCode());
            while (true) {
                int i5 = iC & length;
                int i6 = bArr[i5] & 255;
                if (i6 == 255) {
                    return null;
                }
                if (obj2.equals(objArr[i6])) {
                    return objArr[i6 ^ 1];
                }
                iC = i5 + 1;
            }
        } else if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            int length2 = sArr.length - 1;
            int iC2 = Hashing.c(obj2.hashCode());
            while (true) {
                int i7 = iC2 & length2;
                int i8 = sArr[i7] & 65535;
                if (i8 == 65535) {
                    return null;
                }
                if (obj2.equals(objArr[i8])) {
                    return objArr[i8 ^ 1];
                }
                iC2 = i7 + 1;
            }
        } else {
            int[] iArr = (int[]) obj;
            int length3 = iArr.length - 1;
            int iC3 = Hashing.c(obj2.hashCode());
            while (true) {
                int i9 = iC3 & length3;
                int i10 = iArr[i9];
                if (i10 == -1) {
                    return null;
                }
                if (obj2.equals(objArr[i10])) {
                    return objArr[i10 ^ 1];
                }
                iC3 = i9 + 1;
            }
        }
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet f() {
        return new EntrySet(this, this.f84583g, 0, this.f84584h);
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet g() {
        return new KeySet(this, new KeysOrValuesAsList(this.f84583g, 0, this.f84584h));
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public Object get(Object obj) {
        Object objX = x(this.f84582f, this.f84583g, this.f84584h, 0, obj);
        if (objX == null) {
            return null;
        }
        return objX;
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableCollection h() {
        return new KeysOrValuesAsList(this.f84583g, 1, this.f84584h);
    }

    @Override // com.google.common.collect.ImmutableMap
    boolean k() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return this.f84584h;
    }

    @Override // com.google.common.collect.ImmutableMap
    Object writeReplace() {
        return super.writeReplace();
    }
}
