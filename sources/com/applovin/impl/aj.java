package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Ascii;
import com.applovin.impl.bj;
import com.applovin.impl.qo;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class aj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n0 f58438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f58439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ah f58440c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f58441d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private a f58442e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private a f58443f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f58444g;

    public aj(n0 n0Var) {
        this.f58438a = n0Var;
        int iC = n0Var.c();
        this.f58439b = iC;
        this.f58440c = new ah(32);
        a aVar = new a(0L, iC);
        this.f58441d = aVar;
        this.f58442e = aVar;
        this.f58443f = aVar;
    }

    private void a(a aVar) {
        if (aVar.f58447c) {
            a aVar2 = this.f58443f;
            boolean z2 = aVar2.f58447c;
            int i3 = (z2 ? 1 : 0) + (((int) (aVar2.f58445a - aVar.f58445a)) / this.f58439b);
            m0[] m0VarArr = new m0[i3];
            for (int i4 = 0; i4 < i3; i4++) {
                m0VarArr[i4] = aVar.f58448d;
                aVar = aVar.a();
            }
            this.f58438a.a(m0VarArr);
        }
    }

    private int b(int i3) {
        a aVar = this.f58443f;
        if (!aVar.f58447c) {
            aVar.a(this.f58438a.b(), new a(this.f58443f.f58446b, this.f58439b));
        }
        return Math.min(i3, (int) (this.f58443f.f58446b - this.f58444g));
    }

    public void c() {
        this.f58442e = this.f58441d;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f58445a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f58446b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f58447c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public m0 f58448d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public a f58449e;

        public a(long j3, int i3) {
            this.f58445a = j3;
            this.f58446b = j3 + ((long) i3);
        }

        public a a() {
            this.f58448d = null;
            a aVar = this.f58449e;
            this.f58449e = null;
            return aVar;
        }

        public void a(m0 m0Var, a aVar) {
            this.f58448d = m0Var;
            this.f58449e = aVar;
            this.f58447c = true;
        }

        public int a(long j3) {
            return ((int) (j3 - this.f58445a)) + this.f58448d.f61320b;
        }
    }

    private static a b(a aVar, o5 o5Var, bj.b bVar, ah ahVar) {
        if (o5Var.h()) {
            aVar = a(aVar, o5Var, bVar, ahVar);
        }
        if (o5Var.c()) {
            ahVar.d(4);
            a aVarA = a(aVar, bVar.f58697b, ahVar.c(), 4);
            int iA = ahVar.A();
            bVar.f58697b += 4;
            bVar.f58696a -= 4;
            o5Var.g(iA);
            a aVarA2 = a(aVarA, bVar.f58697b, o5Var.f62183c, iA);
            bVar.f58697b += (long) iA;
            int i3 = bVar.f58696a - iA;
            bVar.f58696a = i3;
            o5Var.h(i3);
            return a(aVarA2, bVar.f58697b, o5Var.f62186g, bVar.f58696a);
        }
        o5Var.g(bVar.f58696a);
        return a(aVar, bVar.f58697b, o5Var.f62183c, bVar.f58696a);
    }

    public void a(long j3) {
        a aVar;
        if (j3 == -1) {
            return;
        }
        while (true) {
            aVar = this.f58441d;
            if (j3 < aVar.f58446b) {
                break;
            }
            this.f58438a.a(aVar.f58448d);
            this.f58441d = this.f58441d.a();
        }
        if (this.f58442e.f58445a < aVar.f58445a) {
            this.f58442e = aVar;
        }
    }

    private static a a(a aVar, long j3) {
        while (j3 >= aVar.f58446b) {
            aVar = aVar.f58449e;
        }
        return aVar;
    }

    public long a() {
        return this.f58444g;
    }

    public void a(o5 o5Var, bj.b bVar) {
        b(this.f58442e, o5Var, bVar, this.f58440c);
    }

    private void a(int i3) {
        long j3 = this.f58444g + ((long) i3);
        this.f58444g = j3;
        a aVar = this.f58443f;
        if (j3 == aVar.f58446b) {
            this.f58443f = aVar.f58449e;
        }
    }

    private static a a(a aVar, long j3, ByteBuffer byteBuffer, int i3) {
        a aVarA = a(aVar, j3);
        while (i3 > 0) {
            int iMin = Math.min(i3, (int) (aVarA.f58446b - j3));
            byteBuffer.put(aVarA.f58448d.f61319a, aVarA.a(j3), iMin);
            i3 -= iMin;
            j3 += (long) iMin;
            if (j3 == aVarA.f58446b) {
                aVarA = aVarA.f58449e;
            }
        }
        return aVarA;
    }

    public void b(o5 o5Var, bj.b bVar) {
        this.f58442e = b(this.f58442e, o5Var, bVar, this.f58440c);
    }

    private static a a(a aVar, long j3, byte[] bArr, int i3) {
        a aVarA = a(aVar, j3);
        int i4 = i3;
        while (i4 > 0) {
            int iMin = Math.min(i4, (int) (aVarA.f58446b - j3));
            System.arraycopy(aVarA.f58448d.f61319a, aVarA.a(j3), bArr, i3 - i4, iMin);
            i4 -= iMin;
            j3 += (long) iMin;
            if (j3 == aVarA.f58446b) {
                aVarA = aVarA.f58449e;
            }
        }
        return aVarA;
    }

    public void b() {
        a(this.f58441d);
        a aVar = new a(0L, this.f58439b);
        this.f58441d = aVar;
        this.f58442e = aVar;
        this.f58443f = aVar;
        this.f58444g = 0L;
        this.f58438a.a();
    }

    private static a a(a aVar, o5 o5Var, bj.b bVar, ah ahVar) {
        long j3 = bVar.f58697b;
        int iC = 1;
        ahVar.d(1);
        a aVarA = a(aVar, j3, ahVar.c(), 1);
        long j4 = j3 + 1;
        byte b3 = ahVar.c()[0];
        boolean z2 = (b3 & 128) != 0;
        int i3 = b3 & Ascii.DEL;
        z4 z4Var = o5Var.f62182b;
        byte[] bArr = z4Var.f65350a;
        if (bArr == null) {
            z4Var.f65350a = new byte[16];
        } else {
            Arrays.fill(bArr, (byte) 0);
        }
        a aVarA2 = a(aVarA, j4, z4Var.f65350a, i3);
        long j5 = j4 + ((long) i3);
        if (z2) {
            ahVar.d(2);
            aVarA2 = a(aVarA2, j5, ahVar.c(), 2);
            j5 += 2;
            iC = ahVar.C();
        }
        int i4 = iC;
        int[] iArr = z4Var.f65353d;
        if (iArr == null || iArr.length < i4) {
            iArr = new int[i4];
        }
        int[] iArr2 = iArr;
        int[] iArr3 = z4Var.f65354e;
        if (iArr3 == null || iArr3.length < i4) {
            iArr3 = new int[i4];
        }
        int[] iArr4 = iArr3;
        if (z2) {
            int i5 = i4 * 6;
            ahVar.d(i5);
            aVarA2 = a(aVarA2, j5, ahVar.c(), i5);
            j5 += (long) i5;
            ahVar.f(0);
            for (int i6 = 0; i6 < i4; i6++) {
                iArr2[i6] = ahVar.C();
                iArr4[i6] = ahVar.A();
            }
        } else {
            iArr2[0] = 0;
            iArr4[0] = bVar.f58696a - ((int) (j5 - bVar.f58697b));
        }
        qo.a aVar2 = (qo.a) xp.a(bVar.f58698c);
        z4Var.a(i4, iArr2, iArr4, aVar2.f62661b, z4Var.f65350a, aVar2.f62660a, aVar2.f62662c, aVar2.f62663d);
        long j6 = bVar.f58697b;
        int i7 = (int) (j5 - j6);
        bVar.f58697b = j6 + ((long) i7);
        bVar.f58696a -= i7;
        return aVarA2;
    }

    public int a(f5 f5Var, int i3, boolean z2) throws EOFException {
        int iB = b(i3);
        a aVar = this.f58443f;
        int iA = f5Var.a(aVar.f58448d.f61319a, aVar.a(this.f58444g), iB);
        if (iA != -1) {
            a(iA);
            return iA;
        }
        if (z2) {
            return -1;
        }
        throw new EOFException();
    }

    public void a(ah ahVar, int i3) {
        while (i3 > 0) {
            int iB = b(i3);
            a aVar = this.f58443f;
            ahVar.a(aVar.f58448d.f61319a, aVar.a(this.f58444g), iB);
            i3 -= iB;
            a(iB);
        }
    }
}
