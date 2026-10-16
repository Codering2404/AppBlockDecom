package com.applovin.impl;

import com.applovin.impl.e9;
import com.applovin.impl.fr;
import com.applovin.impl.gl;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class er extends gl {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private a f59536n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f59537o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f59538p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private fr.d f59539q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private fr.b f59540r;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final fr.d f59541a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final fr.b f59542b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f59543c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final fr.c[] f59544d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f59545e;

        public a(fr.d dVar, fr.b bVar, byte[] bArr, fr.c[] cVarArr, int i3) {
            this.f59541a = dVar;
            this.f59542b = bVar;
            this.f59543c = bArr;
            this.f59544d = cVarArr;
            this.f59545e = i3;
        }
    }

    er() {
    }

    static int a(byte b3, int i3, int i4) {
        return (b3 >> i4) & (255 >>> (8 - i3));
    }

    a b(ah ahVar) throws ch {
        fr.d dVar = this.f59539q;
        if (dVar == null) {
            this.f59539q = fr.b(ahVar);
            return null;
        }
        fr.b bVar = this.f59540r;
        if (bVar == null) {
            this.f59540r = fr.a(ahVar);
            return null;
        }
        byte[] bArr = new byte[ahVar.e()];
        System.arraycopy(ahVar.c(), 0, bArr, 0, ahVar.e());
        return new a(dVar, bVar, bArr, fr.a(ahVar, dVar.f59815b), fr.a(r4.length - 1));
    }

    @Override // com.applovin.impl.gl
    protected void c(long j3) {
        super.c(j3);
        this.f59538p = j3 != 0;
        fr.d dVar = this.f59539q;
        this.f59537o = dVar != null ? dVar.f59820g : 0;
    }

    static void a(ah ahVar, long j3) {
        if (ahVar.b() < ahVar.e() + 4) {
            ahVar.a(Arrays.copyOf(ahVar.c(), ahVar.e() + 4));
        } else {
            ahVar.e(ahVar.e() + 4);
        }
        byte[] bArrC = ahVar.c();
        bArrC[ahVar.e() - 4] = (byte) (j3 & 255);
        bArrC[ahVar.e() - 3] = (byte) ((j3 >>> 8) & 255);
        bArrC[ahVar.e() - 2] = (byte) ((j3 >>> 16) & 255);
        bArrC[ahVar.e() - 1] = (byte) ((j3 >>> 24) & 255);
    }

    public static boolean c(ah ahVar) {
        try {
            return fr.a(1, ahVar, true);
        } catch (ch unused) {
            return false;
        }
    }

    private static int a(byte b3, a aVar) {
        if (!aVar.f59544d[a(b3, aVar.f59545e, 1)].f59810a) {
            return aVar.f59541a.f59820g;
        }
        return aVar.f59541a.f59821h;
    }

    @Override // com.applovin.impl.gl
    protected long a(ah ahVar) {
        if ((ahVar.c()[0] & 1) == 1) {
            return -1L;
        }
        int iA = a(ahVar.c()[0], (a) b1.b(this.f59536n));
        long j3 = this.f59538p ? (this.f59537o + iA) / 4 : 0;
        a(ahVar, j3);
        this.f59538p = true;
        this.f59537o = iA;
        return j3;
    }

    @Override // com.applovin.impl.gl
    protected boolean a(ah ahVar, long j3, gl.b bVar) throws ch {
        if (this.f59536n != null) {
            b1.a(bVar.f60010a);
            return false;
        }
        a aVarB = b(ahVar);
        this.f59536n = aVarB;
        if (aVarB == null) {
            return true;
        }
        fr.d dVar = aVarB.f59541a;
        ArrayList arrayList = new ArrayList();
        arrayList.add(dVar.f59823j);
        arrayList.add(aVarB.f59543c);
        bVar.f60010a = new e9.b().f("audio/vorbis").b(dVar.f59818e).k(dVar.f59817d).c(dVar.f59815b).n(dVar.f59816c).a(arrayList).a();
        return true;
    }

    @Override // com.applovin.impl.gl
    protected void a(boolean z2) {
        super.a(z2);
        if (z2) {
            this.f59536n = null;
            this.f59539q = null;
            this.f59540r = null;
        }
        this.f59537o = 0;
        this.f59538p = false;
    }
}
