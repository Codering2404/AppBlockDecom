package com.facebook.ads.redexgen.core;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.e8, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1489e8 extends FrameLayout {
    public static final int A08 = XV.A0b;
    public C04906e A00;
    public C0695Eu A01;
    public C4L A02;
    public C0654Df A03;
    public C3S A04;
    public AnonymousClass34 A05;
    public final C1648gi A06;
    public final VI A07;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 12 out of bounds for length 12
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public final void A04(VA va, String str, Map<String, String> map) {
        A02();
        this.A02 = new C4L(this.A06, va, this.A00, str, null, map);
        if (C1098Up.A20(this.A06)) {
            this.A01 = new C0695Eu(this.A06, va, this.A00, str, false, this.A02, map);
        } else {
            this.A01 = null;
        }
    }

    public C1489e8(C1648gi c1648gi, VI vi) {
        super(c1648gi);
        this.A07 = vi;
        this.A06 = c1648gi;
        setUpView(c1648gi);
    }

    public final void A01() {
        A0i(true, 10);
    }

    public final void A02() {
        if (this.A01 != null) {
            this.A01.A07();
            this.A01 = null;
        }
        if (this.A02 != null) {
            this.A02.A0p();
            this.A02 = null;
        }
    }

    public final void A03(UN un) {
        getEventBus().A05(un);
    }

    public final void A05(EnumC1535et enumC1535et) {
        A0e(enumC1535et, 13);
    }

    public final boolean A06() {
        return A0p();
    }

    public C0685Ek getSimpleVideoView() {
        return this.A00;
    }

    public float getVolume() {
        return getVolume();
    }

    public void setPlaceholderUrl(String str) {
        this.A04.setImage(str);
    }

    private void setUpPlugins(C1648gi c1648gi) {
        A0Y();
        this.A04 = new C3S(c1648gi);
        A0f(this.A04);
        this.A03 = new C0654Df(c1648gi, this.A07);
        A0f(new C04243q(c1648gi));
        A0f(this.A03);
        this.A05 = new AnonymousClass34(c1648gi, true, this.A07);
        A0f(this.A05);
        A0f(new C0656Dh(this.A05, EnumC1551f9.A02, true, true));
        if (!A0k()) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        layoutParams.setMargins(A08, A08, A08, A08);
        this.A03.setLayoutParams(layoutParams);
        addView(this.A03);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.facebook.ads.redexgen.X.6e] */
    private void setUpVideo(final C1648gi c1648gi) {
        this.A00 = new C0685Ek(c1648gi) { // from class: com.facebook.ads.redexgen.X.6e
            @Override // android.widget.RelativeLayout, android.view.View
            public final void onMeasure(int i3, int i4) {
                int newWidthSpec = View.MeasureSpec.getMode(i3);
                if (newWidthSpec == 1073741824) {
                    i4 = i3;
                } else {
                    int newWidthSpec2 = View.MeasureSpec.getMode(i4);
                    if (newWidthSpec2 == 1073741824) {
                        i3 = i4;
                    }
                }
                super.onMeasure(i3, i4);
            }
        };
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        YB.A0K(this.A00);
        addView(this.A00);
        setOnClickListener(new ViewOnClickListenerC1488e7(this));
    }

    private void setUpView(C1648gi c1648gi) {
        setUpVideo(c1648gi);
        setUpPlugins(c1648gi);
    }

    public void setVideoURI(String str) {
        setVideoURI(str);
    }

    public void setVolume(float f3) {
        setVolume(f3);
        this.A03.A09();
    }
}
