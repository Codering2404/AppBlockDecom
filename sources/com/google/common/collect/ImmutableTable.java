package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Table;
import com.google.errorprone.annotations.DoNotMock;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class ImmutableTable<R, C, V> extends AbstractTable<R, C, V> implements Serializable {
    private static final long serialVersionUID = 912559;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @DoNotMock
    public static final class Builder<R, C, V> {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object[] f84151a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Object[] f84152b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Object[] f84153c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int[] f84154d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int[] f84155f;

        private SerializedForm(Object[] objArr, Object[] objArr2, Object[] objArr3, int[] iArr, int[] iArr2) {
            this.f84151a = objArr;
            this.f84152b = objArr2;
            this.f84153c = objArr3;
            this.f84154d = iArr;
            this.f84155f = iArr2;
        }

        static SerializedForm a(ImmutableTable immutableTable, int[] iArr, int[] iArr2) {
            return new SerializedForm(immutableTable.r().toArray(), immutableTable.k().toArray(), immutableTable.values().toArray(), iArr, iArr2);
        }

        Object readResolve() {
            Object[] objArr = this.f84153c;
            if (objArr.length == 0) {
                return ImmutableTable.p();
            }
            int i3 = 0;
            if (objArr.length == 1) {
                return ImmutableTable.q(this.f84151a[0], this.f84152b[0], objArr[0]);
            }
            ImmutableList.Builder builder = new ImmutableList.Builder(objArr.length);
            while (true) {
                Object[] objArr2 = this.f84153c;
                if (i3 >= objArr2.length) {
                    return RegularImmutableTable.v(builder.m(), ImmutableSet.w(this.f84151a), ImmutableSet.w(this.f84152b));
                }
                builder.a(ImmutableTable.i(this.f84151a[this.f84154d[i3]], this.f84152b[this.f84155f[i3]], objArr2[i3]));
                i3++;
            }
        }
    }

    ImmutableTable() {
    }

    static Table.Cell i(Object obj, Object obj2, Object obj3) {
        return Tables.d(Preconditions.u(obj, "rowKey"), Preconditions.u(obj2, "columnKey"), Preconditions.u(obj3, "value"));
    }

    public static ImmutableTable p() {
        return SparseImmutableTable.f84677h;
    }

    public static ImmutableTable q(Object obj, Object obj2, Object obj3) {
        return new SingletonImmutableTable(obj, obj2, obj3);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    @Override // com.google.common.collect.AbstractTable
    public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2) {
        return super.e(obj, obj2);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.AbstractTable
    public /* bridge */ /* synthetic */ boolean f() {
        return super.f();
    }

    @Override // com.google.common.collect.AbstractTable
    final Iterator g() {
        throw new AssertionError("should never be called");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.AbstractTable
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final UnmodifiableIterator a() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public ImmutableSet O0() {
        return (ImmutableSet) super.O0();
    }

    public ImmutableSet k() {
        return C().keySet();
    }

    @Override // com.google.common.collect.Table
    /* JADX INFO: renamed from: m */
    public abstract ImmutableMap C();

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.AbstractTable
    /* JADX INFO: renamed from: n */
    public abstract ImmutableSet c();

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.AbstractTable
    /* JADX INFO: renamed from: o */
    public abstract ImmutableCollection d();

    public ImmutableSet r() {
        return l().keySet();
    }

    @Override // com.google.common.collect.Table
    /* JADX INFO: renamed from: s */
    public abstract ImmutableMap l();

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public ImmutableCollection values() {
        return (ImmutableCollection) super.values();
    }

    @Override // com.google.common.collect.AbstractTable
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    abstract Object writeReplace();
}
