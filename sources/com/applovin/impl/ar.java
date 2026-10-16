package com.applovin.impl;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.animation.Animation;
import coil.target.Yb.oUcQRqOVfOC;
import com.applovin.sdk.AppLovinSdkUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f58507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.applovin.impl.sdk.n f58508b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final View f58509c;

    public ar(View view, com.applovin.impl.sdk.j jVar) {
        this.f58507a = jVar;
        this.f58508b = jVar.I();
        this.f58509c = view;
    }

    public long a(me meVar) {
        long j3;
        if (com.applovin.impl.sdk.n.a()) {
            this.f58508b.a("ViewabilityTracker", "Checking visibility...");
        }
        Point pointB = z3.b(this.f58509c.getContext());
        if (!this.f58509c.isShown()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f58508b.b("ViewabilityTracker", "View is hidden");
            }
            j3 = 2;
        } else {
            j3 = 0;
        }
        if (this.f58509c.getAlpha() < meVar.f0()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f58508b.b("ViewabilityTracker", "View is transparent");
            }
            j3 |= 4;
        }
        Animation animation = this.f58509c.getAnimation();
        if (animation != null && animation.hasStarted() && !animation.hasEnded()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f58508b.b("ViewabilityTracker", oUcQRqOVfOC.fmtIRBxDXCUBOi);
            }
            j3 |= 8;
        }
        if (this.f58509c.getParent() == null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f58508b.b("ViewabilityTracker", "No parent view found");
            }
            j3 |= 16;
        }
        int iPxToDp = AppLovinSdkUtils.pxToDp(this.f58509c.getContext(), this.f58509c.getWidth());
        if (iPxToDp < Math.min(meVar.l0(), pointB.x)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f58508b.b("ViewabilityTracker", "View has width (" + iPxToDp + ") below threshold");
            }
            j3 |= 32;
        }
        int iPxToDp2 = AppLovinSdkUtils.pxToDp(this.f58509c.getContext(), this.f58509c.getHeight());
        if (iPxToDp2 < meVar.h0()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f58508b.b("ViewabilityTracker", "View has height (" + iPxToDp2 + ") below threshold");
            }
            j3 |= 64;
        }
        Rect rect = new Rect(0, 0, pointB.x, pointB.y);
        int[] iArr = {-1, -1};
        this.f58509c.getLocationOnScreen(iArr);
        int i3 = iArr[0];
        Rect rect2 = new Rect(i3, iArr[1], this.f58509c.getWidth() + i3, iArr[1] + this.f58509c.getHeight());
        if (!Rect.intersects(rect, rect2)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f58508b.b("ViewabilityTracker", "Rect (" + rect2 + ") outside of screen's bounds (" + rect + ")");
            }
            j3 |= 128;
        }
        Activity activityB = this.f58507a.e().b();
        if (activityB != null && !zq.a(this.f58509c, activityB)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f58508b.b("ViewabilityTracker", "View is not in top activity's view hierarchy");
            }
            j3 |= 256;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f58508b.a("ViewabilityTracker", "Returning flags: " + Long.toBinaryString(j3));
        }
        return j3;
    }
}
