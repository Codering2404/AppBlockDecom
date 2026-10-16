package com.google.zxing.aztec.encoder;

import com.sun.jna.Function;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class HighLevelEncoder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final String[] f91664b = {"UPPER", "LOWER", "DIGIT", "MIXED", "PUNCT"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final int[][] f91665c = {new int[]{0, 327708, 327710, 327709, 656318}, new int[]{590318, 0, 327710, 327709, 656318}, new int[]{262158, 590300, 0, 590301, 932798}, new int[]{327709, 327708, 656318, 0, 327710}, new int[]{327711, 656380, 656382, 656381, 0}};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[][] f91666d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final int[][] f91667e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f91668a;

    static {
        int[] iArr = {5, Function.MAX_NARGS};
        Class cls = Integer.TYPE;
        int[][] iArr2 = (int[][]) Array.newInstance((Class<?>) cls, iArr);
        f91666d = iArr2;
        iArr2[0][32] = 1;
        for (int i3 = 65; i3 <= 90; i3++) {
            f91666d[0][i3] = i3 - 63;
        }
        f91666d[1][32] = 1;
        for (int i4 = 97; i4 <= 122; i4++) {
            f91666d[1][i4] = i4 - 95;
        }
        f91666d[2][32] = 1;
        for (int i5 = 48; i5 <= 57; i5++) {
            f91666d[2][i5] = i5 - 46;
        }
        int[] iArr3 = f91666d[2];
        iArr3[44] = 12;
        iArr3[46] = 13;
        int[] iArr4 = {0, 32, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 27, 28, 29, 30, 31, 64, 92, 94, 95, 96, 124, 126, 127};
        for (int i6 = 0; i6 < 28; i6++) {
            f91666d[3][iArr4[i6]] = i6;
        }
        int[] iArr5 = {0, 13, 0, 0, 0, 0, 33, 39, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 58, 59, 60, 61, 62, 63, 91, 93, 123, 125};
        for (int i7 = 0; i7 < 31; i7++) {
            int i8 = iArr5[i7];
            if (i8 > 0) {
                f91666d[4][i8] = i7;
            }
        }
        int[][] iArr6 = (int[][]) Array.newInstance((Class<?>) cls, 6, 6);
        f91667e = iArr6;
        for (int[] iArr7 : iArr6) {
            Arrays.fill(iArr7, -1);
        }
        int[][] iArr8 = f91667e;
        iArr8[0][4] = 0;
        int[] iArr9 = iArr8[1];
        iArr9[4] = 0;
        iArr9[0] = 28;
        iArr8[3][4] = 0;
        int[] iArr10 = iArr8[2];
        iArr10[4] = 0;
        iArr10[0] = 15;
    }

    public HighLevelEncoder(byte[] bArr) {
        this.f91668a = bArr;
    }

    private static Collection b(Iterable iterable) {
        LinkedList linkedList = new LinkedList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            State state = (State) it.next();
            Iterator it2 = linkedList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    linkedList.add(state);
                    break;
                }
                State state2 = (State) it2.next();
                if (state2.f(state)) {
                    break;
                }
                if (state.f(state2)) {
                    it2.remove();
                }
            }
        }
        return linkedList;
    }

    private void c(State state, int i3, Collection collection) {
        char c3 = (char) (this.f91668a[i3] & 255);
        boolean z2 = f91666d[state.e()][c3] > 0;
        State stateB = null;
        for (int i4 = 0; i4 <= 4; i4++) {
            int i5 = f91666d[i4][c3];
            if (i5 > 0) {
                if (stateB == null) {
                    stateB = state.b(i3);
                }
                if (!z2 || i4 == state.e() || i4 == 2) {
                    collection.add(stateB.g(i4, i5));
                }
                if (!z2 && f91667e[state.e()][i4] >= 0) {
                    collection.add(stateB.h(i4, i5));
                }
            }
        }
        if (state.c() > 0 || f91666d[state.e()][c3] == 0) {
            collection.add(state.a(i3));
        }
    }

    private static void d(State state, int i3, int i4, Collection collection) {
        State stateB = state.b(i3);
        collection.add(stateB.g(4, i4));
        if (state.e() != 4) {
            collection.add(stateB.h(4, i4));
        }
        if (i4 == 3 || i4 == 4) {
            collection.add(stateB.g(2, 16 - i4).g(2, 1));
        }
        if (state.c() > 0) {
            collection.add(state.a(i3).a(i3 + 1));
        }
    }

    private Collection e(Iterable iterable, int i3) {
        LinkedList linkedList = new LinkedList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            c((State) it.next(), i3, linkedList);
        }
        return b(linkedList);
    }

    private static Collection f(Iterable iterable, int i3, int i4) {
        LinkedList linkedList = new LinkedList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            d((State) it.next(), i3, i4, linkedList);
        }
        return b(linkedList);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.google.zxing.common.BitArray a() {
        /*
            r8 = this;
            com.google.zxing.aztec.encoder.State r0 = com.google.zxing.aztec.encoder.State.f91672e
            java.util.List r0 = java.util.Collections.singletonList(r0)
            r1 = 0
            r2 = r1
        L8:
            byte[] r3 = r8.f91668a
            int r4 = r3.length
            if (r2 >= r4) goto L4c
            int r4 = r2 + 1
            int r5 = r3.length
            if (r4 >= r5) goto L15
            r5 = r3[r4]
            goto L16
        L15:
            r5 = r1
        L16:
            r3 = r3[r2]
            r6 = 13
            if (r3 == r6) goto L38
            r6 = 44
            r7 = 32
            if (r3 == r6) goto L34
            r6 = 46
            if (r3 == r6) goto L30
            r6 = 58
            if (r3 == r6) goto L2c
        L2a:
            r3 = r1
            goto L3d
        L2c:
            if (r5 != r7) goto L2a
            r3 = 5
            goto L3d
        L30:
            if (r5 != r7) goto L2a
            r3 = 3
            goto L3d
        L34:
            if (r5 != r7) goto L2a
            r3 = 4
            goto L3d
        L38:
            r3 = 10
            if (r5 != r3) goto L2a
            r3 = 2
        L3d:
            if (r3 <= 0) goto L45
            java.util.Collection r0 = f(r0, r2, r3)
            r2 = r4
            goto L49
        L45:
            java.util.Collection r0 = r8.e(r0, r2)
        L49:
            int r2 = r2 + 1
            goto L8
        L4c:
            com.google.zxing.aztec.encoder.HighLevelEncoder$1 r1 = new com.google.zxing.aztec.encoder.HighLevelEncoder$1
            r1.<init>()
            java.lang.Object r0 = java.util.Collections.min(r0, r1)
            com.google.zxing.aztec.encoder.State r0 = (com.google.zxing.aztec.encoder.State) r0
            byte[] r1 = r8.f91668a
            com.google.zxing.common.BitArray r0 = r0.i(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.aztec.encoder.HighLevelEncoder.a():com.google.zxing.common.BitArray");
    }
}
