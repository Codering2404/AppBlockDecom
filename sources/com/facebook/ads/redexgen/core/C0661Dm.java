package com.facebook.ads.redexgen.core;

import android.os.Handler;
import com.facebook.ads.AdError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Dm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0661Dm implements InterfaceC1536eu {
    public static String[] A0E = {"2ZSu0wXuDbQnaud22BC", "QCmSLF", "fQxhtf", "E3sU0uCnWEnB3ZcSzOkvj4xNFgaNSXPe", "Ye0yKWwaCEsRuR61siA7kBVWrkv2bkox", "1q930HE08Ni0sTckStF", "wfAs2pJjw0biCEJKLi3nGPcNksloIp8Y", "ZBBhRoR6L"};
    public C0685Ek A01;
    public boolean A03;
    public boolean A04;
    public boolean A05;
    public boolean A06;
    public final E4 A09 = new E4() { // from class: com.facebook.ads.redexgen.X.42
        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.facebook.ads.redexgen.core.UN
        /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
        public final void A03(C4B c4b) {
            this.A00.A07.removeCallbacksAndMessages(null);
            if (this.A00.A0G(EnumC1561fJ.A04)) {
                this.A00.A03();
                this.A00.A06(true, false);
            }
            this.A00.A05 = true;
        }
    };
    public final EA A08 = new EA() { // from class: com.facebook.ads.redexgen.X.41
        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.facebook.ads.redexgen.core.UN
        /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
        public final void A03(C4K c4k) {
            this.A00.A02 = true;
            if (this.A00.A03) {
                return;
            }
            this.A00.A03();
            this.A00.A06(false, false);
            this.A00.A05 = true;
        }
    };
    public final E2 A0A = new C04313x(this);
    public final AbstractC0674Dz A0B = new AbstractC0674Dz() { // from class: com.facebook.ads.redexgen.X.3w
        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.facebook.ads.redexgen.core.UN
        /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
        public final void A03(C4A c4a) {
            if (this.A00.A04 || !this.A00.A0G(EnumC1561fJ.A04)) {
                return;
            }
            this.A00.A03();
            this.A00.A06(true, false);
        }
    };
    public final AbstractC0668Dt A0C = new C04293v(this);
    public final Handler A07 = new Handler();
    public final List<InterfaceC1562fK> A0D = new ArrayList();
    public int A00 = AdError.SERVER_ERROR_CODE;
    public boolean A02 = false;

    public C0661Dm(boolean z2, boolean z3) {
        this.A04 = z2;
        this.A03 = z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A03() {
        this.A07.removeCallbacksAndMessages(null);
        Iterator<InterfaceC1562fK> it = this.A0D.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            if (A0E[7].length() != 9) {
                throw new RuntimeException();
            }
            String[] strArr = A0E;
            strArr[6] = "Y40dGjVL9Zscw9FMyiKWKh6z3JvZ0T5u";
            strArr[4] = "hO4VpYUkDoigTR3nwiJ8PFOPPoG0N1QG";
            if (zHasNext) {
                it.next().cancel();
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A06(boolean z2, boolean z3) {
        Iterator<InterfaceC1562fK> it = this.A0D.iterator();
        while (it.hasNext()) {
            it.next().A4A(z2, z3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A0G(EnumC1561fJ enumC1561fJ) {
        Iterator<InterfaceC1562fK> it = this.A0D.iterator();
        while (it.hasNext()) {
            if (it.next().A9B() != enumC1561fJ) {
                return false;
            }
        }
        return true;
    }

    public final void A0H() {
        this.A0D.clear();
    }

    public final void A0I() {
        if (this.A04) {
            this.A07.removeCallbacksAndMessages(null);
            this.A04 = false;
        }
    }

    public final void A0J() {
        this.A06 = true;
        this.A05 = true;
        A06(false, false);
    }

    public final void A0K(int i3) {
        this.A00 = i3;
    }

    public final void A0L(InterfaceC1562fK interfaceC1562fK) {
        this.A0D.add(interfaceC1562fK);
    }

    public final boolean A0M() {
        return this.A04;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1536eu
    public final void AAv(C0685Ek c0685Ek) {
        this.A01 = c0685Ek;
        c0685Ek.getEventBus().A03(this.A09, this.A0C, this.A0A, this.A0B, this.A08);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1536eu
    public final void AKV(C0685Ek c0685Ek) {
        A03();
        c0685Ek.getEventBus().A04(this.A08, this.A0C, this.A0A, this.A0B, this.A09);
        this.A01 = null;
    }
}
