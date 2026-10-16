package com.applovin.impl;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class bc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f58631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f58632b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f58633c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ImageView f58634d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private cc f58635e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f58636f;

    public int a() {
        return this.f58636f;
    }

    public cc b() {
        return this.f58635e;
    }

    public void a(int i3) {
        this.f58636f = i3;
    }

    public void a(cc ccVar) {
        this.f58635e = ccVar;
        this.f58631a.setText(ccVar.k());
        this.f58631a.setTextColor(ccVar.l());
        if (this.f58632b != null) {
            if (!TextUtils.isEmpty(ccVar.f())) {
                this.f58632b.setTypeface(null, 0);
                this.f58632b.setVisibility(0);
                this.f58632b.setText(ccVar.f());
                this.f58632b.setTextColor(ccVar.g());
                if (ccVar.p()) {
                    this.f58632b.setTypeface(null, 1);
                }
            } else {
                this.f58632b.setVisibility(8);
            }
        }
        if (this.f58633c != null) {
            if (ccVar.h() > 0) {
                this.f58633c.setImageResource(ccVar.h());
                this.f58633c.setColorFilter(ccVar.i());
                this.f58633c.setVisibility(0);
            } else {
                this.f58633c.setVisibility(8);
            }
        }
        if (this.f58634d != null) {
            if (ccVar.d() > 0) {
                this.f58634d.setImageResource(ccVar.d());
                this.f58634d.setColorFilter(ccVar.e());
                this.f58634d.setVisibility(0);
                return;
            }
            this.f58634d.setVisibility(8);
        }
    }
}
