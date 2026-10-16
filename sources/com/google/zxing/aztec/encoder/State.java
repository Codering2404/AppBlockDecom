package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class State {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final State f91672e = new State(Token.f91677b, 0, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f91673a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Token f91674b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f91675c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f91676d;

    private State(Token token, int i3, int i4, int i5) {
        this.f91674b = token;
        this.f91673a = i3;
        this.f91675c = i4;
        this.f91676d = i5;
    }

    State a(int i3) {
        Token tokenA = this.f91674b;
        int i4 = this.f91673a;
        int i5 = this.f91676d;
        if (i4 == 4 || i4 == 2) {
            int i6 = HighLevelEncoder.f91665c[i4][0];
            int i7 = 65535 & i6;
            int i8 = i6 >> 16;
            tokenA = tokenA.a(i7, i8);
            i5 += i8;
            i4 = 0;
        }
        int i9 = this.f91675c;
        State state = new State(tokenA, i4, i9 + 1, i5 + ((i9 == 0 || i9 == 31) ? 18 : i9 == 62 ? 9 : 8));
        return state.f91675c == 2078 ? state.b(i3 + 1) : state;
    }

    State b(int i3) {
        int i4 = this.f91675c;
        return i4 == 0 ? this : new State(this.f91674b.b(i3 - i4, i4), this.f91673a, 0, this.f91676d);
    }

    int c() {
        return this.f91675c;
    }

    int d() {
        return this.f91676d;
    }

    int e() {
        return this.f91673a;
    }

    boolean f(State state) {
        int i3;
        int i4 = this.f91676d + (HighLevelEncoder.f91665c[this.f91673a][state.f91673a] >> 16);
        int i5 = state.f91675c;
        if (i5 > 0 && ((i3 = this.f91675c) == 0 || i3 > i5)) {
            i4 += 10;
        }
        return i4 <= state.f91676d;
    }

    State g(int i3, int i4) {
        int i5 = this.f91676d;
        Token tokenA = this.f91674b;
        int i6 = this.f91673a;
        if (i3 != i6) {
            int i7 = HighLevelEncoder.f91665c[i6][i3];
            int i8 = 65535 & i7;
            int i9 = i7 >> 16;
            tokenA = tokenA.a(i8, i9);
            i5 += i9;
        }
        int i10 = i3 == 2 ? 4 : 5;
        return new State(tokenA.a(i4, i10), i3, 0, i5 + i10);
    }

    State h(int i3, int i4) {
        Token token = this.f91674b;
        int i5 = this.f91673a;
        int i6 = i5 == 2 ? 4 : 5;
        return new State(token.a(HighLevelEncoder.f91667e[i5][i3], i6).a(i4, 5), this.f91673a, 0, this.f91676d + i6 + 5);
    }

    BitArray i(byte[] bArr) {
        LinkedList linkedList = new LinkedList();
        for (Token tokenD = b(bArr.length).f91674b; tokenD != null; tokenD = tokenD.d()) {
            linkedList.addFirst(tokenD);
        }
        BitArray bitArray = new BitArray();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((Token) it.next()).c(bitArray, bArr);
        }
        return bitArray;
    }

    public String toString() {
        return String.format("%s bits=%d bytes=%d", HighLevelEncoder.f91664b[this.f91673a], Integer.valueOf(this.f91676d), Integer.valueOf(this.f91675c));
    }
}
