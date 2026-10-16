package io.reactivex.internal.util;

import io.reactivex.functions.Predicate;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class AppendOnlyLinkedArrayList<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f139190a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Object[] f139191b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object[] f139192c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f139193d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface NonThrowingPredicate<T> extends Predicate<T> {
        @Override // io.reactivex.functions.Predicate
        boolean test(Object obj);
    }

    public AppendOnlyLinkedArrayList(int i3) {
        this.f139190a = i3;
        Object[] objArr = new Object[i3 + 1];
        this.f139191b = objArr;
        this.f139192c = objArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0019, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(io.reactivex.Observer r5) {
        /*
            r4 = this;
            java.lang.Object[] r0 = r4.f139191b
            int r1 = r4.f139190a
        L4:
            r2 = 0
            if (r0 == 0) goto L1e
        L7:
            if (r2 >= r1) goto L19
            r3 = r0[r2]
            if (r3 != 0) goto Le
            goto L19
        Le:
            boolean r3 = io.reactivex.internal.util.NotificationLite.c(r3, r5)
            if (r3 == 0) goto L16
            r5 = 1
            return r5
        L16:
            int r2 = r2 + 1
            goto L7
        L19:
            r0 = r0[r1]
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            goto L4
        L1e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.util.AppendOnlyLinkedArrayList.a(io.reactivex.Observer):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0019, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean b(org.reactivestreams.Subscriber r5) {
        /*
            r4 = this;
            java.lang.Object[] r0 = r4.f139191b
            int r1 = r4.f139190a
        L4:
            r2 = 0
            if (r0 == 0) goto L1e
        L7:
            if (r2 >= r1) goto L19
            r3 = r0[r2]
            if (r3 != 0) goto Le
            goto L19
        Le:
            boolean r3 = io.reactivex.internal.util.NotificationLite.d(r3, r5)
            if (r3 == 0) goto L16
            r5 = 1
            return r5
        L16:
            int r2 = r2 + 1
            goto L7
        L19:
            r0 = r0[r1]
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            goto L4
        L1e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.util.AppendOnlyLinkedArrayList.b(org.reactivestreams.Subscriber):boolean");
    }

    public void c(Object obj) {
        int i3 = this.f139190a;
        int i4 = this.f139193d;
        if (i4 == i3) {
            Object[] objArr = new Object[i3 + 1];
            this.f139192c[i3] = objArr;
            this.f139192c = objArr;
            i4 = 0;
        }
        this.f139192c[i4] = obj;
        this.f139193d = i4 + 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0018, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d(io.reactivex.internal.util.AppendOnlyLinkedArrayList.NonThrowingPredicate r5) {
        /*
            r4 = this;
            java.lang.Object[] r0 = r4.f139191b
            int r1 = r4.f139190a
        L4:
            if (r0 == 0) goto L1d
            r2 = 0
        L7:
            if (r2 >= r1) goto L18
            r3 = r0[r2]
            if (r3 != 0) goto Le
            goto L18
        Le:
            boolean r3 = r5.test(r3)
            if (r3 == 0) goto L15
            goto L1d
        L15:
            int r2 = r2 + 1
            goto L7
        L18:
            r0 = r0[r1]
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            goto L4
        L1d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.util.AppendOnlyLinkedArrayList.d(io.reactivex.internal.util.AppendOnlyLinkedArrayList$NonThrowingPredicate):void");
    }

    public void e(Object obj) {
        this.f139191b[0] = obj;
    }
}
