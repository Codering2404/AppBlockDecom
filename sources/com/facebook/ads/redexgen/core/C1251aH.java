package com.facebook.ads.redexgen.core;

import android.animation.Animator;
import android.animation.TimeInterpolator;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.aH, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1251aH extends Animator {
    public final /* synthetic */ int A00;
    public final /* synthetic */ InterfaceC1240a6 A01;
    public final /* synthetic */ C1253aJ A02;

    public C1251aH(C1253aJ c1253aJ, int i3, InterfaceC1240a6 interfaceC1240a6) {
        this.A02 = c1253aJ;
        this.A00 = i3;
        this.A01 = interfaceC1240a6;
    }

    @Override // android.animation.Animator
    public final void addListener(Animator.AnimatorListener animatorListener) {
    }

    @Override // android.animation.Animator
    public final void cancel() {
    }

    @Override // android.animation.Animator
    public final void end() {
    }

    @Override // android.animation.Animator
    public final long getDuration() {
        return this.A00;
    }

    @Override // android.animation.Animator
    public final long getStartDelay() {
        return 0L;
    }

    @Override // android.animation.Animator
    public final boolean isRunning() {
        return this.A02.A04;
    }

    @Override // android.animation.Animator
    public final Animator setDuration(long j3) {
        return null;
    }

    @Override // android.animation.Animator
    public final void setInterpolator(TimeInterpolator timeInterpolator) {
    }

    @Override // android.animation.Animator
    public final void setStartDelay(long j3) {
    }

    @Override // android.animation.Animator
    public final void setTarget(Object obj) {
        this.A01.AK7(obj, getDuration());
    }

    @Override // android.animation.Animator
    public final void start() {
    }
}
