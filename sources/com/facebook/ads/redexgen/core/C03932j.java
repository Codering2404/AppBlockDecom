package com.facebook.ads.redexgen.core;

import android.view.View;
import android.view.animation.AlphaAnimation;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.facebook.ads.internal.settings.AdInternalSettings;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.2j, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C03932j extends Q9<C1593fp> implements T4 {
    public C1648gi A00;
    public boolean A01;

    public C03932j(C1593fp c1593fp, C1648gi c1648gi) {
        super(c1593fp);
        this.A00 = c1648gi;
        this.A01 = false;
    }

    private void A00(int i3) {
        if (!this.A01) {
            this.A00.A0F().A3v(i3);
        }
        this.A01 = true;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC1135Wc
    public final void A07() {
        C1593fp c1593fpA08 = A08();
        int iIntValue = 0;
        if (c1593fpA08 == null) {
            A00(0);
            return;
        }
        View view = c1593fpA08.A0C;
        AbstractC1592fo abstractC1592fo = (AbstractC1592fo) c1593fpA08.A0E.get();
        int i3 = 1;
        boolean z2 = view == null;
        if (!z2 && abstractC1592fo != null) {
            C1594fq c1594fqA0E = C1593fp.A0E(view, c1593fpA08.A0A, this.A00);
            if (c1594fqA0E.A04()) {
                C1593fp.A05(c1593fpA08);
            } else {
                c1593fpA08.A00 = 0;
            }
            boolean z3 = c1593fpA08.A00 > c1593fpA08.A09;
            boolean wasViewable = c1593fpA08.A05 != null && c1593fpA08.A05.A04();
            if (z3 || !c1594fqA0E.A04()) {
                c1593fpA08.A05 = c1594fqA0E;
            }
            String strValueOf = String.valueOf(c1594fqA0E.A01());
            synchronized (c1593fpA08) {
                if (c1593fpA08.A06.containsKey(strValueOf)) {
                    iIntValue = ((Integer) c1593fpA08.A06.get(strValueOf)).intValue();
                }
                c1593fpA08.A06.put(strValueOf, Integer.valueOf(iIntValue + 1));
            }
            if (z3 && !wasViewable) {
                this.A01 = true;
                c1593fpA08.A03 = System.currentTimeMillis();
                if (c1593fpA08.A07) {
                    this.A00.A0F().A3w();
                }
                abstractC1592fo.A03();
                if (BuildConfigApi.isDebug() && AdInternalSettings.isVisibleAnimation()) {
                    AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                    alphaAnimation.setDuration(500L);
                    view.startAnimation(alphaAnimation);
                }
                if (!c1593fpA08.A0F) {
                    return;
                }
            } else if (!z3 && wasViewable) {
                this.A01 = true;
                if (c1593fpA08.A07) {
                    this.A00.A0F().A3S(c1594fqA0E.A02());
                }
                abstractC1592fo.A00();
            } else {
                abstractC1592fo.A02();
                if (!this.A01 && c1593fpA08.A07) {
                    this.A00.A0F().A3u(c1594fqA0E.A02());
                }
                this.A01 = true;
            }
            if (!c1593fpA08.A08 && c1593fpA08.A04 != null) {
                c1593fpA08.A0B.postDelayed(c1593fpA08.A04, c1593fpA08.A02);
                return;
            }
            return;
        }
        if (c1593fpA08.A07) {
            if (!z2) {
                i3 = 2;
            }
            A00(i3);
        }
    }

    @Override // com.facebook.ads.redexgen.core.T4
    public final C1648gi A6m() {
        return this.A00;
    }
}
