package androidx.recyclerview.widget;

import androidx.recyclerview.widget.AdapterHelper;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class OpReorderer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Callback f51827a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface Callback {
        AdapterHelper.UpdateOp a(int i3, int i4, int i5, Object obj);

        void b(AdapterHelper.UpdateOp updateOp);
    }

    OpReorderer(Callback callback) {
        this.f51827a = callback;
    }

    private int a(List list) {
        boolean z2 = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (((AdapterHelper.UpdateOp) list.get(size)).f51467a != 8) {
                z2 = true;
            } else if (z2) {
                return size;
            }
        }
        return -1;
    }

    private void c(List list, int i3, AdapterHelper.UpdateOp updateOp, int i4, AdapterHelper.UpdateOp updateOp2) {
        int i5 = updateOp.f51470d;
        int i6 = updateOp2.f51468b;
        int i7 = i5 < i6 ? -1 : 0;
        int i8 = updateOp.f51468b;
        if (i8 < i6) {
            i7++;
        }
        if (i6 <= i8) {
            updateOp.f51468b = i8 + updateOp2.f51470d;
        }
        int i9 = updateOp2.f51468b;
        if (i9 <= i5) {
            updateOp.f51470d = i5 + updateOp2.f51470d;
        }
        updateOp2.f51468b = i9 + i7;
        list.set(i3, updateOp2);
        list.set(i4, updateOp);
    }

    private void d(List list, int i3, int i4) {
        AdapterHelper.UpdateOp updateOp = (AdapterHelper.UpdateOp) list.get(i3);
        AdapterHelper.UpdateOp updateOp2 = (AdapterHelper.UpdateOp) list.get(i4);
        int i5 = updateOp2.f51467a;
        if (i5 == 1) {
            c(list, i3, updateOp, i4, updateOp2);
        } else if (i5 == 2) {
            e(list, i3, updateOp, i4, updateOp2);
        } else {
            if (i5 != 4) {
                return;
            }
            f(list, i3, updateOp, i4, updateOp2);
        }
    }

    void b(List list) {
        while (true) {
            int iA = a(list);
            if (iA == -1) {
                return;
            } else {
                d(list, iA, iA + 1);
            }
        }
    }

    void e(List list, int i3, AdapterHelper.UpdateOp updateOp, int i4, AdapterHelper.UpdateOp updateOp2) {
        boolean z2;
        int i5 = updateOp.f51468b;
        int i6 = updateOp.f51470d;
        boolean z3 = false;
        if (i5 < i6) {
            if (updateOp2.f51468b == i5 && updateOp2.f51470d == i6 - i5) {
                z2 = false;
                z3 = true;
            } else {
                z2 = false;
            }
        } else if (updateOp2.f51468b == i6 + 1 && updateOp2.f51470d == i5 - i6) {
            z2 = true;
            z3 = true;
        } else {
            z2 = true;
        }
        int i7 = updateOp2.f51468b;
        if (i6 < i7) {
            updateOp2.f51468b = i7 - 1;
        } else {
            int i8 = updateOp2.f51470d;
            if (i6 < i7 + i8) {
                updateOp2.f51470d = i8 - 1;
                updateOp.f51467a = 2;
                updateOp.f51470d = 1;
                if (updateOp2.f51470d == 0) {
                    list.remove(i4);
                    this.f51827a.b(updateOp2);
                    return;
                }
                return;
            }
        }
        int i9 = updateOp.f51468b;
        int i10 = updateOp2.f51468b;
        AdapterHelper.UpdateOp updateOpA = null;
        if (i9 <= i10) {
            updateOp2.f51468b = i10 + 1;
        } else {
            int i11 = updateOp2.f51470d;
            if (i9 < i10 + i11) {
                updateOpA = this.f51827a.a(2, i9 + 1, (i10 + i11) - i9, null);
                updateOp2.f51470d = updateOp.f51468b - updateOp2.f51468b;
            }
        }
        if (z3) {
            list.set(i3, updateOp2);
            list.remove(i4);
            this.f51827a.b(updateOp);
            return;
        }
        if (z2) {
            if (updateOpA != null) {
                int i12 = updateOp.f51468b;
                if (i12 > updateOpA.f51468b) {
                    updateOp.f51468b = i12 - updateOpA.f51470d;
                }
                int i13 = updateOp.f51470d;
                if (i13 > updateOpA.f51468b) {
                    updateOp.f51470d = i13 - updateOpA.f51470d;
                }
            }
            int i14 = updateOp.f51468b;
            if (i14 > updateOp2.f51468b) {
                updateOp.f51468b = i14 - updateOp2.f51470d;
            }
            int i15 = updateOp.f51470d;
            if (i15 > updateOp2.f51468b) {
                updateOp.f51470d = i15 - updateOp2.f51470d;
            }
        } else {
            if (updateOpA != null) {
                int i16 = updateOp.f51468b;
                if (i16 >= updateOpA.f51468b) {
                    updateOp.f51468b = i16 - updateOpA.f51470d;
                }
                int i17 = updateOp.f51470d;
                if (i17 >= updateOpA.f51468b) {
                    updateOp.f51470d = i17 - updateOpA.f51470d;
                }
            }
            int i18 = updateOp.f51468b;
            if (i18 >= updateOp2.f51468b) {
                updateOp.f51468b = i18 - updateOp2.f51470d;
            }
            int i19 = updateOp.f51470d;
            if (i19 >= updateOp2.f51468b) {
                updateOp.f51470d = i19 - updateOp2.f51470d;
            }
        }
        list.set(i3, updateOp2);
        if (updateOp.f51468b != updateOp.f51470d) {
            list.set(i4, updateOp);
        } else {
            list.remove(i4);
        }
        if (updateOpA != null) {
            list.add(i3, updateOpA);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void f(java.util.List r9, int r10, androidx.recyclerview.widget.AdapterHelper.UpdateOp r11, int r12, androidx.recyclerview.widget.AdapterHelper.UpdateOp r13) {
        /*
            r8 = this;
            int r0 = r11.f51470d
            int r1 = r13.f51468b
            r2 = 4
            r3 = 1
            r4 = 0
            if (r0 >= r1) goto Ld
            int r1 = r1 - r3
            r13.f51468b = r1
            goto L20
        Ld:
            int r5 = r13.f51470d
            int r1 = r1 + r5
            if (r0 >= r1) goto L20
            int r5 = r5 - r3
            r13.f51470d = r5
            androidx.recyclerview.widget.OpReorderer$Callback r0 = r8.f51827a
            int r1 = r11.f51468b
            java.lang.Object r5 = r13.f51469c
            androidx.recyclerview.widget.AdapterHelper$UpdateOp r0 = r0.a(r2, r1, r3, r5)
            goto L21
        L20:
            r0 = r4
        L21:
            int r1 = r11.f51468b
            int r5 = r13.f51468b
            if (r1 > r5) goto L2b
            int r5 = r5 + r3
            r13.f51468b = r5
            goto L41
        L2b:
            int r6 = r13.f51470d
            int r7 = r5 + r6
            if (r1 >= r7) goto L41
            int r5 = r5 + r6
            int r5 = r5 - r1
            androidx.recyclerview.widget.OpReorderer$Callback r4 = r8.f51827a
            int r1 = r1 + r3
            java.lang.Object r3 = r13.f51469c
            androidx.recyclerview.widget.AdapterHelper$UpdateOp r4 = r4.a(r2, r1, r5, r3)
            int r1 = r13.f51470d
            int r1 = r1 - r5
            r13.f51470d = r1
        L41:
            r9.set(r12, r11)
            int r11 = r13.f51470d
            if (r11 <= 0) goto L4c
            r9.set(r10, r13)
            goto L54
        L4c:
            r9.remove(r10)
            androidx.recyclerview.widget.OpReorderer$Callback r11 = r8.f51827a
            r11.b(r13)
        L54:
            if (r0 == 0) goto L59
            r9.add(r10, r0)
        L59:
            if (r4 == 0) goto L5e
            r9.add(r10, r4)
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.OpReorderer.f(java.util.List, int, androidx.recyclerview.widget.AdapterHelper$UpdateOp, int, androidx.recyclerview.widget.AdapterHelper$UpdateOp):void");
    }
}
