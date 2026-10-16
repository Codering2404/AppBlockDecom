package com.applovin.impl;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import com.applovin.impl.cc;
import com.applovin.impl.je;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class bg extends cc {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final je f58644n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Context f58645o;

    public bg(je jeVar, Context context) {
        super(cc.c.DETAIL);
        this.f58644n = jeVar;
        this.f58645o = context;
        this.f58864c = t();
        this.f58865d = s();
    }

    private SpannedString q() {
        if (!this.f58644n.A()) {
            return StringUtils.createListItemDetailSpannedString("Adapter Missing", -65536);
        }
        if (TextUtils.isEmpty(this.f58644n.c())) {
            return StringUtils.createListItemDetailSpannedString("Adapter Found", -16777216);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(StringUtils.createListItemDetailSubSpannedString("ADAPTER  ", -7829368));
        spannableStringBuilder.append((CharSequence) StringUtils.createListItemDetailSpannedString(this.f58644n.c(), -16777216));
        if (this.f58644n.B()) {
            spannableStringBuilder.append((CharSequence) StringUtils.createListItemDetailSubSpannedString("  LATEST  ", Color.rgb(255, 127, 0)));
            spannableStringBuilder.append((CharSequence) StringUtils.createListItemDetailSpannedString(this.f58644n.k(), -16777216));
        }
        return new SpannedString(spannableStringBuilder);
    }

    private SpannedString s() {
        if (!o()) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) u());
        spannableStringBuilder.append((CharSequence) new SpannableString("\n"));
        spannableStringBuilder.append((CharSequence) q());
        if (this.f58644n.q() == je.a.INVALID_INTEGRATION) {
            spannableStringBuilder.append((CharSequence) new SpannableString("\n"));
            spannableStringBuilder.append((CharSequence) StringUtils.createListItemDetailSpannedString("Invalid Integration", -65536));
        }
        return new SpannedString(spannableStringBuilder);
    }

    private SpannedString t() {
        return StringUtils.createSpannedString(this.f58644n.g(), o() ? -16777216 : -7829368, 18, 1);
    }

    private SpannedString u() {
        if (!this.f58644n.E()) {
            return StringUtils.createListItemDetailSpannedString("SDK Missing", -65536);
        }
        if (!StringUtils.isValidString(this.f58644n.p())) {
            return StringUtils.createListItemDetailSpannedString(this.f58644n.A() ? "Retrieving SDK Version..." : "SDK Found", -16777216);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(StringUtils.createListItemDetailSubSpannedString("SDK\t\t\t\t\t  ", -7829368));
        spannableStringBuilder.append((CharSequence) StringUtils.createListItemDetailSpannedString(this.f58644n.p(), -16777216));
        return new SpannedString(spannableStringBuilder);
    }

    @Override // com.applovin.impl.cc
    public int d() {
        return o() ? R.drawable.applovin_ic_disclosure_arrow : super.h();
    }

    @Override // com.applovin.impl.cc
    public int e() {
        return t3.a(R.color.applovin_sdk_disclosureButtonColor, this.f58645o);
    }

    @Override // com.applovin.impl.cc
    public int h() {
        int iH = this.f58644n.h();
        return iH > 0 ? iH : R.drawable.applovin_ic_mediation_placeholder;
    }

    @Override // com.applovin.impl.cc
    public boolean o() {
        return this.f58644n.q() != je.a.MISSING;
    }

    public je r() {
        return this.f58644n;
    }

    public String toString() {
        return "MediatedNetworkListItemViewModel{text=" + ((Object) this.f58864c) + ", detailText=" + ((Object) this.f58865d) + ", network=" + this.f58644n + "}";
    }
}
