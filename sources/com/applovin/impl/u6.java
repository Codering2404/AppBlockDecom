package com.applovin.impl;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import com.applovin.impl.cc;
import com.applovin.sdk.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class u6 extends cc {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final v6 f64111n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Context f64112o;

    public u6(v6 v6Var, Context context) {
        super(cc.c.DETAIL);
        this.f64111n = v6Var;
        this.f64112o = context;
        this.f58864c = r();
        this.f58865d = q();
    }

    private SpannedString q() {
        return new SpannedString("Displayed " + yp.a(this.f64111n.b(), true));
    }

    private SpannedString r() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.f64111n.c());
        spannableStringBuilder.append((CharSequence) " - ");
        spannableStringBuilder.append((CharSequence) this.f64111n.d());
        return new SpannedString(spannableStringBuilder);
    }

    @Override // com.applovin.impl.cc
    public int d() {
        return o() ? R.drawable.applovin_ic_disclosure_arrow : super.h();
    }

    @Override // com.applovin.impl.cc
    public int e() {
        return t3.a(R.color.applovin_sdk_disclosureButtonColor, this.f64112o);
    }

    @Override // com.applovin.impl.cc
    public boolean o() {
        return true;
    }
}
