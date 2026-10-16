package com.google.common.collect;

import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class ComparisonChain {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ComparisonChain f83854a = new ComparisonChain() { // from class: com.google.common.collect.ComparisonChain.1
        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain d(int i3, int i4) {
            return l(Integer.compare(i3, i4));
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain e(long j3, long j4) {
            return l(Long.compare(j3, j4));
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain f(Comparable comparable, Comparable comparable2) {
            return l(comparable.compareTo(comparable2));
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain g(Object obj, Object obj2, Comparator comparator) {
            return l(comparator.compare(obj, obj2));
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain h(boolean z2, boolean z3) {
            return l(Boolean.compare(z2, z3));
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain i(boolean z2, boolean z3) {
            return l(Boolean.compare(z3, z2));
        }

        @Override // com.google.common.collect.ComparisonChain
        public int j() {
            return 0;
        }

        ComparisonChain l(int i3) {
            return i3 < 0 ? ComparisonChain.f83855b : i3 > 0 ? ComparisonChain.f83856c : ComparisonChain.f83854a;
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ComparisonChain f83855b = new InactiveComparisonChain(-1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ComparisonChain f83856c = new InactiveComparisonChain(1);

    public static ComparisonChain k() {
        return f83854a;
    }

    public abstract ComparisonChain d(int i3, int i4);

    public abstract ComparisonChain e(long j3, long j4);

    public abstract ComparisonChain f(Comparable comparable, Comparable comparable2);

    public abstract ComparisonChain g(Object obj, Object obj2, Comparator comparator);

    public abstract ComparisonChain h(boolean z2, boolean z3);

    public abstract ComparisonChain i(boolean z2, boolean z3);

    public abstract int j();

    private ComparisonChain() {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class InactiveComparisonChain extends ComparisonChain {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int f83857d;

        InactiveComparisonChain(int i3) {
            super();
            this.f83857d = i3;
        }

        @Override // com.google.common.collect.ComparisonChain
        public int j() {
            return this.f83857d;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain d(int i3, int i4) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain e(long j3, long j4) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain f(Comparable comparable, Comparable comparable2) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain h(boolean z2, boolean z3) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain i(boolean z2, boolean z3) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain g(Object obj, Object obj2, Comparator comparator) {
            return this;
        }
    }
}
