package com.applovin.impl;

import com.applovin.impl.e9;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class z8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f65388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f65389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f65390c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f65391d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f65392e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f65393f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f65394g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f65395h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f65396i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f65397j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final a f65398k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final af f65399l;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long[] f65400a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long[] f65401b;

        public a(long[] jArr, long[] jArr2) {
            this.f65400a = jArr;
            this.f65401b = jArr2;
        }
    }

    private z8(int i3, int i4, int i5, int i6, int i7, int i8, int i9, long j3, a aVar, af afVar) {
        this.f65388a = i3;
        this.f65389b = i4;
        this.f65390c = i5;
        this.f65391d = i6;
        this.f65392e = i7;
        this.f65393f = b(i7);
        this.f65394g = i8;
        this.f65395h = i9;
        this.f65396i = a(i9);
        this.f65397j = j3;
        this.f65398k = aVar;
        this.f65399l = afVar;
    }

    private static int a(int i3) {
        if (i3 == 8) {
            return 1;
        }
        if (i3 == 12) {
            return 2;
        }
        if (i3 == 16) {
            return 4;
        }
        if (i3 != 20) {
            return i3 != 24 ? -1 : 6;
        }
        return 5;
    }

    private static int b(int i3) {
        switch (i3) {
            case 8000:
                return 4;
            case 16000:
                return 5;
            case 22050:
                return 6;
            case 24000:
                return 7;
            case 32000:
                return 8;
            case 44100:
                return 9;
            case 48000:
                return 10;
            case 88200:
                return 1;
            case 96000:
                return 11;
            case 176400:
                return 2;
            case 192000:
                return 3;
            default:
                return -1;
        }
    }

    private static af a(List list, List list2) {
        if (list.isEmpty() && list2.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            String str = (String) list.get(i3);
            String[] strArrB = xp.b(str, "=");
            if (strArrB.length != 2) {
                oc.d("FlacStreamMetadata", "Failed to parse Vorbis comment: " + str);
            } else {
                arrayList.add(new dr(strArrB[0], strArrB[1]));
            }
        }
        arrayList.addAll(list2);
        if (arrayList.isEmpty()) {
            return null;
        }
        return new af(arrayList);
    }

    public z8 b(List list) {
        return new z8(this.f65388a, this.f65389b, this.f65390c, this.f65391d, this.f65392e, this.f65394g, this.f65395h, this.f65397j, this.f65398k, a(a(list, Collections.EMPTY_LIST)));
    }

    public long b() {
        long j3 = this.f65397j;
        if (j3 == 0) {
            return -9223372036854775807L;
        }
        return (j3 * 1000000) / ((long) this.f65392e);
    }

    public z8 a(List list) {
        return new z8(this.f65388a, this.f65389b, this.f65390c, this.f65391d, this.f65392e, this.f65394g, this.f65395h, this.f65397j, this.f65398k, a(a(Collections.EMPTY_LIST, list)));
    }

    public z8(byte[] bArr, int i3) {
        zg zgVar = new zg(bArr);
        zgVar.c(i3 * 8);
        this.f65388a = zgVar.a(16);
        this.f65389b = zgVar.a(16);
        this.f65390c = zgVar.a(24);
        this.f65391d = zgVar.a(24);
        int iA = zgVar.a(20);
        this.f65392e = iA;
        this.f65393f = b(iA);
        this.f65394g = zgVar.a(3) + 1;
        int iA2 = zgVar.a(5) + 1;
        this.f65395h = iA2;
        this.f65396i = a(iA2);
        this.f65397j = zgVar.b(36);
        this.f65398k = null;
        this.f65399l = null;
    }

    public long a() {
        long j3;
        long j4;
        int i3 = this.f65391d;
        if (i3 > 0) {
            j3 = (((long) i3) + ((long) this.f65390c)) / 2;
            j4 = 1;
        } else {
            int i4 = this.f65388a;
            j3 = ((((i4 != this.f65389b || i4 <= 0) ? 4096L : i4) * ((long) this.f65394g)) * ((long) this.f65395h)) / 8;
            j4 = 64;
        }
        return j3 + j4;
    }

    public e9 a(byte[] bArr, af afVar) {
        bArr[4] = -128;
        int i3 = this.f65391d;
        if (i3 <= 0) {
            i3 = -1;
        }
        return new e9.b().f("audio/flac").i(i3).c(this.f65394g).n(this.f65392e).a(Collections.singletonList(bArr)).a(a(afVar)).a();
    }

    public af a(af afVar) {
        af afVar2 = this.f65399l;
        return afVar2 == null ? afVar : afVar2.a(afVar);
    }

    public long a(long j3) {
        return xp.b((j3 * ((long) this.f65392e)) / 1000000, 0L, this.f65397j - 1);
    }

    public z8 a(a aVar) {
        return new z8(this.f65388a, this.f65389b, this.f65390c, this.f65391d, this.f65392e, this.f65394g, this.f65395h, this.f65397j, aVar, this.f65399l);
    }
}
