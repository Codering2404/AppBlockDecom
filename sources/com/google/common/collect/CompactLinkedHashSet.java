package com.google.common.collect;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
class CompactLinkedHashSet<E> extends CompactHashSet<E> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private transient int[] f83849g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private transient int[] f83850h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private transient int f83851i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private transient int f83852j;

    CompactLinkedHashSet(int i3) {
        super(i3);
    }

    public static CompactLinkedHashSet I(int i3) {
        return new CompactLinkedHashSet(i3);
    }

    private int J(int i3) {
        return K()[i3] - 1;
    }

    private int[] K() {
        int[] iArr = this.f83849g;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    private int[] L() {
        int[] iArr = this.f83850h;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    private void M(int i3, int i4) {
        K()[i3] = i4 + 1;
    }

    private void N(int i3, int i4) {
        if (i3 == -2) {
            this.f83851i = i4;
        } else {
            P(i3, i4);
        }
        if (i4 == -2) {
            this.f83852j = i3;
        } else {
            M(i4, i3);
        }
    }

    private void P(int i3, int i4) {
        L()[i3] = i4 + 1;
    }

    @Override // com.google.common.collect.CompactHashSet
    void B(int i3) {
        super.B(i3);
        this.f83849g = Arrays.copyOf(K(), i3);
        this.f83850h = Arrays.copyOf(L(), i3);
    }

    @Override // com.google.common.collect.CompactHashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        if (x()) {
            return;
        }
        this.f83851i = -2;
        this.f83852j = -2;
        int[] iArr = this.f83849g;
        if (iArr != null && this.f83850h != null) {
            Arrays.fill(iArr, 0, size(), 0);
            Arrays.fill(this.f83850h, 0, size(), 0);
        }
        super.clear();
    }

    @Override // com.google.common.collect.CompactHashSet
    int d(int i3, int i4) {
        return i3 >= size() ? i4 : i3;
    }

    @Override // com.google.common.collect.CompactHashSet
    int e() {
        int iE = super.e();
        this.f83849g = new int[iE];
        this.f83850h = new int[iE];
        return iE;
    }

    @Override // com.google.common.collect.CompactHashSet
    Set f() {
        Set setF = super.f();
        this.f83849g = null;
        this.f83850h = null;
        return setF;
    }

    @Override // com.google.common.collect.CompactHashSet
    int p() {
        return this.f83851i;
    }

    @Override // com.google.common.collect.CompactHashSet
    int q(int i3) {
        return L()[i3] - 1;
    }

    @Override // com.google.common.collect.CompactHashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return ObjectArrays.h(this);
    }

    @Override // com.google.common.collect.CompactHashSet
    void u(int i3) {
        super.u(i3);
        this.f83851i = -2;
        this.f83852j = -2;
    }

    @Override // com.google.common.collect.CompactHashSet
    void v(int i3, Object obj, int i4, int i5) {
        super.v(i3, obj, i4, i5);
        N(this.f83852j, i3);
        N(i3, -2);
    }

    @Override // com.google.common.collect.CompactHashSet
    void w(int i3, int i4) {
        int size = size() - 1;
        super.w(i3, i4);
        N(J(i3), q(i3));
        if (i3 < size) {
            N(J(size), i3);
            N(i3, q(size));
        }
        K()[size] = 0;
        L()[size] = 0;
    }

    @Override // com.google.common.collect.CompactHashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray(Object[] objArr) {
        return ObjectArrays.i(this, objArr);
    }
}
