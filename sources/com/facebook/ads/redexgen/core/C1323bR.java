package com.facebook.ads.redexgen.core;

import android.os.Handler;
import android.os.Looper;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bR, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1323bR extends RelativeLayout {
    public Runnable A00;
    public boolean A01;
    public boolean A02;
    public final int A03;
    public final Handler A04;
    public final RelativeLayout A05;
    public final AbstractC1813jd A06;
    public final C1648gi A07;
    public final ViewOnClickListenerC0846Kr A08;
    public final boolean A09;
    public static String[] A0A = {"kYsHPXjvuexLDNrmkTwQRT55JzcBiXge", "zR3fYtNBsqomhYEo3ppbb9RnVT1IpAxV", "wFb9hYTzbBEOXc5fjtd4fRZ2PpBU", "Jmvb938kXbh75xCyq", "upuGJiFXYhI8XO38RIbXHNvluMbxxtSG", "1OgTCiUraoc2pkcUsvx3qQ0hwrqmeKBW", "dxUwSJcX1cxyOWbOOT9qAgg5mCGn3F5b", "jNBoK2eCg"};
    public static final int A0F = XV.A0J;
    public static final int A0B = XV.A0T;
    public static final int A0C = XV.A09;
    public static final int A0G = XV.A05;
    public static final int A0E = XV.A0H;
    public static final int A0D = XV.A08;

    public C1323bR(C1648gi c1648gi, AbstractC1813jd abstractC1813jd, ViewOnClickListenerC0846Kr viewOnClickListenerC0846Kr, int i3, boolean z2) {
        super(c1648gi);
        this.A01 = false;
        this.A02 = false;
        this.A04 = new Handler(Looper.getMainLooper());
        this.A07 = c1648gi;
        this.A06 = abstractC1813jd;
        this.A08 = viewOnClickListenerC0846Kr;
        this.A03 = i3;
        this.A09 = z2;
        this.A05 = A00();
        A0I(getResources().getConfiguration().orientation);
        this.A05.setTranslationY(A0D);
        addView(this.A05);
        A07();
    }

    private RelativeLayout A00() {
        RelativeLayout relativeLayout = new RelativeLayout(this.A07);
        relativeLayout.setPadding(XV.A05, XV.A05, XV.A05, XV.A05);
        YB.A0P(relativeLayout, -1, A0C);
        relativeLayout.setElevation(XV.A0I);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(XV.A0U, XV.A01, XV.A00, XV.A01);
        if (this.A08 != null) {
            RelativeLayout.LayoutParams ctaButtonParams = new RelativeLayout.LayoutParams(-2, A0E);
            ctaButtonParams.addRule(11);
            ctaButtonParams.addRule(15);
            layoutParams.addRule(0, this.A08.getId());
            relativeLayout.addView(this.A08, ctaButtonParams);
        }
        C1342bk appIcon = getAppIcon();
        YB.A0K(appIcon);
        relativeLayout.addView(appIcon);
        layoutParams.addRule(1, appIcon.getId());
        RelativeLayout bannerOverlayView = getTitleAndRatings();
        relativeLayout.addView(bannerOverlayView, layoutParams);
        return relativeLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A04() {
        this.A07.A0F().ADH();
        this.A05.animate().translationY(A0D).setDuration(300L).setListener(new C1322bQ(this)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A05() {
        this.A05.animate().translationY(0.0f).setDuration(300L).setListener(new C1321bP(this)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A06() {
        if (this.A00 != null) {
            this.A04.removeCallbacks(this.A00);
            this.A00 = null;
        }
        if (A0A[5].charAt(7) != 'r') {
            throw new RuntimeException();
        }
        A0A[2] = "cQXagcaAbk5GCnj2W1DiXrWYc93f";
        this.A01 = false;
    }

    private void A07() {
        new YJ(100, 500, this.A07, new C0849Ku(this)).A00(this.A05);
    }

    public final void A0E() {
        this.A00 = new Runnable() { // from class: com.facebook.ads.redexgen.X.bO
            @Override // java.lang.Runnable
            public final void run() {
                this.A00.A05();
            }
        };
        this.A01 = true;
        this.A04.postDelayed(this.A00, this.A03);
    }

    public final void A0F() {
        A06();
        this.A04.removeCallbacksAndMessages(null);
        if (this.A05 != null) {
            RelativeLayout relativeLayout = this.A05;
            String[] strArr = A0A;
            if (strArr[3].length() == strArr[7].length()) {
                throw new RuntimeException();
            }
            A0A[5] = "MnxsWfXrlV78UabQbsjfyCXWA2ulRwGh";
            relativeLayout.clearAnimation();
        }
    }

    public final void A0G() {
        A06();
        if (!this.A02 && this.A05 != null) {
            this.A05.clearAnimation();
        }
    }

    public final void A0H() {
        if (!this.A02 && !this.A01 && this.A05 != null) {
            A0E();
        }
    }

    public final void A0I(int i3) {
        RelativeLayout.LayoutParams bannerOverlayParams;
        if (i3 == 1) {
            bannerOverlayParams = new RelativeLayout.LayoutParams(-1, A0B);
            bannerOverlayParams.setMargins(XV.A09, XV.A00, XV.A09, XV.A00);
        } else {
            int screenWidth = getResources().getDisplayMetrics().widthPixels;
            bannerOverlayParams = new RelativeLayout.LayoutParams((int) (((double) screenWidth) * 0.5d), A0B);
        }
        this.A05.setLayoutParams(bannerOverlayParams);
    }

    private C1342bk getAppIcon() {
        C1342bk c1342bk = new C1342bk(this.A07);
        YB.A0N(c1342bk, 0);
        new LM(c1342bk, this.A07).A05(A0F, A0F).A07(this.A06.A2C().A01());
        RelativeLayout.LayoutParams iconViewParams = new RelativeLayout.LayoutParams(A0F, A0F);
        iconViewParams.addRule(9);
        c1342bk.setLayoutParams(iconViewParams);
        return c1342bk;
    }

    private LinearLayout getRatingCountAndStar() {
        LinearLayout linearLayout = new LinearLayout(this.A07);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        TextView textView = new TextView(this.A07);
        YB.A0K(textView);
        textView.setTextColor(this.A06.A28().A01().A07(false));
        textView.setText(this.A06.A29().A0I().A0C());
        textView.setTextSize(13.0f);
        linearLayout.addView(textView);
        C1345bn c1345bn = new C1345bn(this.A07, -16777216, -16777216);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(A0G, A0G);
        layoutParams.setMargins(XV.A0I, XV.A0I, XV.A0I, XV.A0I);
        linearLayout.addView(c1345bn, layoutParams);
        return linearLayout;
    }

    private TextView getTitle() {
        TextView textView = new TextView(this.A07);
        textView.setTextColor(this.A06.A28().A01().A07(false));
        textView.setText(this.A06.A29().A0I().A0G());
        textView.setTextSize(15.0f);
        textView.setMaxLines(1);
        return textView;
    }

    private RelativeLayout getTitleAndRatings() {
        RelativeLayout relativeLayout = new RelativeLayout(this.A07);
        relativeLayout.setGravity(16);
        TextView title = getTitle();
        YB.A0K(title);
        relativeLayout.addView(title);
        LinearLayout ratingCountAndStar = getRatingCountAndStar();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(3, title.getId());
        layoutParams.addRule(12);
        relativeLayout.addView(ratingCountAndStar, layoutParams);
        return relativeLayout;
    }
}
