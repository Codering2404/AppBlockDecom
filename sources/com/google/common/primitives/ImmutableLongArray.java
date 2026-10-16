package com.google.common.primitives;

import com.google.android.gms.common.api.Api;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
@Immutable
public final class ImmutableLongArray implements Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ImmutableLongArray f85476d = new ImmutableLongArray(new long[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long[] f85477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final transient int f85478b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f85479c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class AsList extends AbstractList<Long> implements RandomAccess, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ImmutableLongArray f85480a;

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Long get(int i3) {
            return Long.valueOf(this.f85480a.f(i3));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return indexOf(obj) >= 0;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            if (obj instanceof AsList) {
                return this.f85480a.equals(((AsList) obj).f85480a);
            }
            if (!(obj instanceof List)) {
                return false;
            }
            List list = (List) obj;
            if (size() != list.size()) {
                return false;
            }
            int i3 = this.f85480a.f85478b;
            for (Object obj2 : list) {
                if (obj2 instanceof Long) {
                    int i4 = i3 + 1;
                    if (this.f85480a.f85477a[i3] == ((Long) obj2).longValue()) {
                        i3 = i4;
                    }
                }
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            return this.f85480a.hashCode();
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            if (obj instanceof Long) {
                return this.f85480a.g(((Long) obj).longValue());
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            if (obj instanceof Long) {
                return this.f85480a.j(((Long) obj).longValue());
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f85480a.k();
        }

        @Override // java.util.AbstractList, java.util.List
        public List subList(int i3, int i4) {
            return this.f85480a.l(i3, i4).d();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return this.f85480a.toString();
        }

        private AsList(ImmutableLongArray immutableLongArray) {
            this.f85480a = immutableLongArray;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long[] f85481a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f85482b = 0;

        Builder(int i3) {
            this.f85481a = new long[i3];
        }

        private void c(int i3) {
            int i4 = this.f85482b + i3;
            long[] jArr = this.f85481a;
            if (i4 > jArr.length) {
                this.f85481a = Arrays.copyOf(jArr, d(jArr.length, i4));
            }
        }

        private static int d(int i3, int i4) {
            if (i4 < 0) {
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
            int iHighestOneBit = i3 + (i3 >> 1) + 1;
            if (iHighestOneBit < i4) {
                iHighestOneBit = Integer.highestOneBit(i4 - 1) << 1;
            }
            return iHighestOneBit < 0 ? Api.BaseClientBuilder.API_PRIORITY_OTHER : iHighestOneBit;
        }

        public Builder a(long j3) {
            c(1);
            long[] jArr = this.f85481a;
            int i3 = this.f85482b;
            jArr[i3] = j3;
            this.f85482b = i3 + 1;
            return this;
        }

        public ImmutableLongArray b() {
            if (this.f85482b == 0) {
                return ImmutableLongArray.f85476d;
            }
            return new ImmutableLongArray(this.f85481a, 0, this.f85482b);
        }
    }

    public static Builder e() {
        return new Builder(10);
    }

    private boolean i() {
        return this.f85478b > 0 || this.f85479c < this.f85477a.length;
    }

    public List d() {
        return new AsList();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableLongArray)) {
            return false;
        }
        ImmutableLongArray immutableLongArray = (ImmutableLongArray) obj;
        if (k() != immutableLongArray.k()) {
            return false;
        }
        for (int i3 = 0; i3 < k(); i3++) {
            if (f(i3) != immutableLongArray.f(i3)) {
                return false;
            }
        }
        return true;
    }

    public long f(int i3) {
        Preconditions.r(i3, k());
        return this.f85477a[this.f85478b + i3];
    }

    public int g(long j3) {
        for (int i3 = this.f85478b; i3 < this.f85479c; i3++) {
            if (this.f85477a[i3] == j3) {
                return i3 - this.f85478b;
            }
        }
        return -1;
    }

    public boolean h() {
        return this.f85479c == this.f85478b;
    }

    public int hashCode() {
        int iE = 1;
        for (int i3 = this.f85478b; i3 < this.f85479c; i3++) {
            iE = (iE * 31) + Longs.e(this.f85477a[i3]);
        }
        return iE;
    }

    public int j(long j3) {
        int i3;
        int i4 = this.f85479c;
        do {
            i4--;
            i3 = this.f85478b;
            if (i4 < i3) {
                return -1;
            }
        } while (this.f85477a[i4] != j3);
        return i4 - i3;
    }

    public int k() {
        return this.f85479c - this.f85478b;
    }

    public ImmutableLongArray l(int i3, int i4) {
        Preconditions.y(i3, i4, k());
        if (i3 == i4) {
            return f85476d;
        }
        long[] jArr = this.f85477a;
        int i5 = this.f85478b;
        return new ImmutableLongArray(jArr, i3 + i5, i5 + i4);
    }

    public long[] m() {
        return Arrays.copyOfRange(this.f85477a, this.f85478b, this.f85479c);
    }

    public ImmutableLongArray n() {
        return i() ? new ImmutableLongArray(m()) : this;
    }

    Object readResolve() {
        return h() ? f85476d : this;
    }

    public String toString() {
        if (h()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(k() * 5);
        sb.append('[');
        sb.append(this.f85477a[this.f85478b]);
        int i3 = this.f85478b;
        while (true) {
            i3++;
            if (i3 >= this.f85479c) {
                sb.append(']');
                return sb.toString();
            }
            sb.append(", ");
            sb.append(this.f85477a[i3]);
        }
    }

    Object writeReplace() {
        return n();
    }

    private ImmutableLongArray(long[] jArr) {
        this(jArr, 0, jArr.length);
    }

    private ImmutableLongArray(long[] jArr, int i3, int i4) {
        this.f85477a = jArr;
        this.f85478b = i3;
        this.f85479c = i4;
    }
}
