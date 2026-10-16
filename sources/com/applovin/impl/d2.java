package com.applovin.impl;

import com.applovin.impl.fo;
import com.applovin.impl.qh;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class d2 implements qh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final fo.d f59059a = new fo.d();

    protected d2() {
    }

    private int J() {
        int iM = m();
        if (iM == 1) {
            return 0;
        }
        return iM;
    }

    @Override // com.applovin.impl.qh
    public final void B() {
        b(-F());
    }

    @Override // com.applovin.impl.qh
    public final void D() {
        if (n().c() || d()) {
            return;
        }
        boolean zL = L();
        if (N() && !y()) {
            if (zL) {
                Q();
            }
        } else if (!zL || getCurrentPosition() > q()) {
            a(0L);
        } else {
            Q();
        }
    }

    public final long G() {
        fo foVarN = n();
        if (foVarN.c()) {
            return -9223372036854775807L;
        }
        return foVarN.a(t(), this.f59059a).d();
    }

    public final int H() {
        fo foVarN = n();
        if (foVarN.c()) {
            return -1;
        }
        return foVarN.a(t(), J(), r());
    }

    public final int I() {
        fo foVarN = n();
        if (foVarN.c()) {
            return -1;
        }
        return foVarN.b(t(), J(), r());
    }

    public final boolean K() {
        return H() != -1;
    }

    public final boolean L() {
        return I() != -1;
    }

    public final boolean M() {
        fo foVarN = n();
        return !foVarN.c() && foVarN.a(t(), this.f59059a).f59758j;
    }

    public final boolean N() {
        fo foVarN = n();
        return !foVarN.c() && foVarN.a(t(), this.f59059a).e();
    }

    public final void O() {
        c(t());
    }

    public final void P() {
        int iH = H();
        if (iH != -1) {
            c(iH);
        }
    }

    public final void Q() {
        int I = I();
        if (I != -1) {
            c(I);
        }
    }

    @Override // com.applovin.impl.qh
    public final void a(long j3) {
        a(t(), j3);
    }

    @Override // com.applovin.impl.qh
    public final boolean b(int i3) {
        return i().a(i3);
    }

    public final void c(int i3) {
        a(i3, -9223372036854775807L);
    }

    @Override // com.applovin.impl.qh
    public final boolean isPlaying() {
        return o() == 3 && l() && j() == 0;
    }

    @Override // com.applovin.impl.qh
    public final void u() {
        if (n().c() || d()) {
            return;
        }
        if (K()) {
            P();
        } else if (N() && M()) {
            O();
        }
    }

    @Override // com.applovin.impl.qh
    public final void w() {
        b(e());
    }

    @Override // com.applovin.impl.qh
    public final boolean y() {
        fo foVarN = n();
        return !foVarN.c() && foVarN.a(t(), this.f59059a).f59757i;
    }

    private void b(long j3) {
        long currentPosition = getCurrentPosition() + j3;
        long duration = getDuration();
        if (duration != -9223372036854775807L) {
            currentPosition = Math.min(currentPosition, duration);
        }
        a(Math.max(currentPosition, 0L));
    }

    protected qh.b a(qh.b bVar) {
        return new qh.b.a().a(bVar).a(3, !d()).a(4, y() && !d()).a(5, L() && !d()).a(6, !n().c() && (L() || !N() || y()) && !d()).a(7, K() && !d()).a(8, !n().c() && (K() || (N() && M())) && !d()).a(9, !d()).a(10, y() && !d()).a(11, y() && !d()).a();
    }
}
