package io.reactivex.internal.util;

import io.reactivex.functions.BiFunction;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class MergerBiFunction<T> implements BiFunction<List<T>, List<T>, List<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Comparator f139212a;

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0037, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.BiFunction
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List apply(java.util.List r6, java.util.List r7) {
        /*
            r5 = this;
            int r0 = r6.size()
            int r1 = r7.size()
            int r0 = r0 + r1
            if (r0 != 0) goto L11
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            return r6
        L11:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r0)
            java.util.Iterator r6 = r6.iterator()
            java.util.Iterator r7 = r7.iterator()
            boolean r0 = r6.hasNext()
            r2 = 0
            if (r0 == 0) goto L2a
            java.lang.Object r0 = r6.next()
            goto L2b
        L2a:
            r0 = r2
        L2b:
            boolean r3 = r7.hasNext()
            if (r3 == 0) goto L36
            java.lang.Object r3 = r7.next()
            goto L37
        L36:
            r3 = r2
        L37:
            if (r0 == 0) goto L61
            if (r3 == 0) goto L61
            java.util.Comparator r4 = r5.f139212a
            int r4 = r4.compare(r0, r3)
            if (r4 >= 0) goto L53
            r1.add(r0)
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L51
            java.lang.Object r0 = r6.next()
            goto L37
        L51:
            r0 = r2
            goto L37
        L53:
            r1.add(r3)
            boolean r3 = r7.hasNext()
            if (r3 == 0) goto L36
            java.lang.Object r3 = r7.next()
            goto L37
        L61:
            if (r0 == 0) goto L74
            r1.add(r0)
        L66:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L85
            java.lang.Object r7 = r6.next()
            r1.add(r7)
            goto L66
        L74:
            r1.add(r3)
        L77:
            boolean r6 = r7.hasNext()
            if (r6 == 0) goto L85
            java.lang.Object r6 = r7.next()
            r1.add(r6)
            goto L77
        L85:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.util.MergerBiFunction.apply(java.util.List, java.util.List):java.util.List");
    }
}
