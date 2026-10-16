package com.facebook.ads.redexgen.core;

import android.animation.Animator;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.fQ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1568fQ implements Animator.AnimatorListener {
    public final /* synthetic */ int A00;
    public final /* synthetic */ int A01;
    public final /* synthetic */ DB A02;

    public C1568fQ(DB db, int i3, int i4) {
        this.A02 = db;
        this.A01 = i3;
        this.A00 = i4;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.A02.A07(this.A00, this.A01, false);
        if (this.A02.A00 != null) {
            this.A02.A00.removeAllListeners();
            this.A02.A00 = null;
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        EnumC1561fJ enumC1561fJ;
        DB db = this.A02;
        if (this.A01 == this.A02.A04) {
            enumC1561fJ = EnumC1561fJ.A02;
        } else {
            enumC1561fJ = EnumC1561fJ.A04;
        }
        db.A01 = enumC1561fJ;
        if (this.A02.A00 != null) {
            this.A02.A00.removeAllListeners();
            this.A02.A00 = null;
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
    }
}
