package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.DoNotMock;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public class ImmutableRangeMap<K extends Comparable<?>, V> implements RangeMap<K, V>, Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ImmutableRangeMap f84085c = new ImmutableRangeMap(ImmutableList.y(), ImmutableList.y());
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final transient ImmutableList f84086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final transient ImmutableList f84087b;

    /* JADX INFO: renamed from: com.google.common.collect.ImmutableRangeMap$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 extends ImmutableList<Range<Comparable<?>>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f84088c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f84089d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Range f84090f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ ImmutableRangeMap f84091g;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.List
        /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
        public Range get(int i3) {
            Preconditions.r(i3, this.f84088c);
            return (i3 == 0 || i3 == this.f84088c + (-1)) ? ((Range) this.f84091g.f84086a.get(i3 + this.f84089d)).p(this.f84090f) : (Range) this.f84091g.f84086a.get(i3 + this.f84089d);
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean g() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f84088c;
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
        Object writeReplace() {
            return super.writeReplace();
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.ImmutableRangeMap$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass2 extends ImmutableRangeMap<Comparable<?>, Object> {
        @Override // com.google.common.collect.ImmutableRangeMap, com.google.common.collect.RangeMap
        public /* bridge */ /* synthetic */ Map a() {
            return super.a();
        }

        @Override // com.google.common.collect.ImmutableRangeMap
        Object writeReplace() {
            return super.writeReplace();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @DoNotMock
    public static final class Builder<K extends Comparable<?>, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f84092a = Lists.i();

        public ImmutableRangeMap a() {
            Collections.sort(this.f84092a, Range.x().i());
            ImmutableList.Builder builder = new ImmutableList.Builder(this.f84092a.size());
            ImmutableList.Builder builder2 = new ImmutableList.Builder(this.f84092a.size());
            for (int i3 = 0; i3 < this.f84092a.size(); i3++) {
                Range range = (Range) ((Map.Entry) this.f84092a.get(i3)).getKey();
                if (i3 > 0) {
                    Range range2 = (Range) ((Map.Entry) this.f84092a.get(i3 - 1)).getKey();
                    if (range.q(range2) && !range.p(range2).r()) {
                        throw new IllegalArgumentException("Overlapping ranges: range " + range2 + " overlaps with entry " + range);
                    }
                }
                builder.a(range);
                builder2.a(((Map.Entry) this.f84092a.get(i3)).getValue());
            }
            return new ImmutableRangeMap(builder.m(), builder2.m());
        }

        public Builder b(Range range, Object obj) {
            Preconditions.t(range);
            Preconditions.t(obj);
            Preconditions.m(!range.r(), "Range must not be empty, but was %s", range);
            this.f84092a.add(Maps.u(range, obj));
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class SerializedForm<K extends Comparable<?>, V> implements Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ImmutableMap f84093a;

        SerializedForm(ImmutableMap immutableMap) {
            this.f84093a = immutableMap;
        }

        Object a() {
            Builder builder = new Builder();
            UnmodifiableIterator it = this.f84093a.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                builder.b((Range) entry.getKey(), entry.getValue());
            }
            return builder.a();
        }

        Object readResolve() {
            return this.f84093a.isEmpty() ? ImmutableRangeMap.d() : a();
        }
    }

    ImmutableRangeMap(ImmutableList immutableList, ImmutableList immutableList2) {
        this.f84086a = immutableList;
        this.f84087b = immutableList2;
    }

    public static ImmutableRangeMap d() {
        return f84085c;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // com.google.common.collect.RangeMap
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public ImmutableMap a() {
        return this.f84086a.isEmpty() ? ImmutableMap.n() : new ImmutableSortedMap(new RegularImmutableSortedSet(this.f84086a, Range.x()), this.f84087b);
    }

    public boolean equals(Object obj) {
        if (obj instanceof RangeMap) {
            return a().equals(((RangeMap) obj).a());
        }
        return false;
    }

    public int hashCode() {
        return a().hashCode();
    }

    public String toString() {
        return a().toString();
    }

    Object writeReplace() {
        return new SerializedForm(a());
    }
}
