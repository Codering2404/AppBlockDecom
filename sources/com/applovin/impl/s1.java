package com.applovin.impl;

import com.applovin.impl.a;
import com.applovin.impl.e9;
import com.applovin.impl.xl;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class s1 extends xl {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int[] f62949e = {5512, 11025, 22050, 44100};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f62950b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f62951c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f62952d;

    public s1(qo qoVar) {
        super(qoVar);
    }

    @Override // com.applovin.impl.xl
    protected boolean a(ah ahVar) throws xl.a {
        if (this.f62950b) {
            ahVar.g(1);
        } else {
            int iW = ahVar.w();
            int i3 = (iW >> 4) & 15;
            this.f62952d = i3;
            if (i3 == 2) {
                this.f65002a.a(new e9.b().f("audio/mpeg").c(1).n(f62949e[(iW >> 2) & 3]).a());
                this.f62951c = true;
            } else if (i3 == 7 || i3 == 8) {
                this.f65002a.a(new e9.b().f(i3 == 7 ? "audio/g711-alaw" : "audio/g711-mlaw").c(1).n(8000).a());
                this.f62951c = true;
            } else if (i3 != 10) {
                throw new xl.a("Audio format not supported: " + this.f62952d);
            }
            this.f62950b = true;
        }
        return true;
    }

    @Override // com.applovin.impl.xl
    protected boolean b(ah ahVar, long j3) {
        if (this.f62952d == 2) {
            int iA = ahVar.a();
            this.f65002a.a(ahVar, iA);
            this.f65002a.a(j3, 1, iA, 0, null);
            return true;
        }
        int iW = ahVar.w();
        if (iW != 0 || this.f62951c) {
            if (this.f62952d == 10 && iW != 1) {
                return false;
            }
            int iA2 = ahVar.a();
            this.f65002a.a(ahVar, iA2);
            this.f65002a.a(j3, 1, iA2, 0, null);
            return true;
        }
        int iA3 = ahVar.a();
        byte[] bArr = new byte[iA3];
        ahVar.a(bArr, 0, iA3);
        a.b bVarA = a.a(bArr);
        this.f65002a.a(new e9.b().f("audio/mp4a-latm").a(bVarA.f58135c).c(bVarA.f58134b).n(bVarA.f58133a).a(Collections.singletonList(bArr)).a());
        this.f62951c = true;
        return false;
    }
}
