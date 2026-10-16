package com.google.android.material.internal;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import com.google.android.gms.common.api.Api;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class StaticLayoutBuilderCompat {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    static final int f81270o = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CharSequence f81271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextPaint f81272b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f81273c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f81275e;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f81282l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private StaticLayoutBuilderConfigurer f81284n;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f81274d = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Layout.Alignment f81276f = Layout.Alignment.ALIGN_NORMAL;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f81277g = Api.BaseClientBuilder.API_PRIORITY_OTHER;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f81278h = 0.0f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f81279i = 1.0f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f81280j = f81270o;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f81281k = true;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private TextUtils.TruncateAt f81283m = null;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class StaticLayoutBuilderCompatException extends Exception {
    }

    private StaticLayoutBuilderCompat(CharSequence charSequence, TextPaint textPaint, int i3) {
        this.f81271a = charSequence;
        this.f81272b = textPaint;
        this.f81273c = i3;
        this.f81275e = charSequence.length();
    }

    public static StaticLayoutBuilderCompat b(CharSequence charSequence, TextPaint textPaint, int i3) {
        return new StaticLayoutBuilderCompat(charSequence, textPaint, i3);
    }

    public StaticLayout a() {
        if (this.f81271a == null) {
            this.f81271a = "";
        }
        int iMax = Math.max(0, this.f81273c);
        CharSequence charSequenceEllipsize = this.f81271a;
        if (this.f81277g == 1) {
            charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, this.f81272b, iMax, this.f81283m);
        }
        int iMin = Math.min(charSequenceEllipsize.length(), this.f81275e);
        this.f81275e = iMin;
        if (this.f81282l && this.f81277g == 1) {
            this.f81276f = Layout.Alignment.ALIGN_OPPOSITE;
        }
        StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequenceEllipsize, this.f81274d, iMin, this.f81272b, iMax);
        builderObtain.setAlignment(this.f81276f);
        builderObtain.setIncludePad(this.f81281k);
        builderObtain.setTextDirection(this.f81282l ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
        TextUtils.TruncateAt truncateAt = this.f81283m;
        if (truncateAt != null) {
            builderObtain.setEllipsize(truncateAt);
        }
        builderObtain.setMaxLines(this.f81277g);
        float f3 = this.f81278h;
        if (f3 != 0.0f || this.f81279i != 1.0f) {
            builderObtain.setLineSpacing(f3, this.f81279i);
        }
        if (this.f81277g > 1) {
            builderObtain.setHyphenationFrequency(this.f81280j);
        }
        StaticLayoutBuilderConfigurer staticLayoutBuilderConfigurer = this.f81284n;
        if (staticLayoutBuilderConfigurer != null) {
            staticLayoutBuilderConfigurer.a(builderObtain);
        }
        return builderObtain.build();
    }

    public StaticLayoutBuilderCompat c(Layout.Alignment alignment) {
        this.f81276f = alignment;
        return this;
    }

    public StaticLayoutBuilderCompat d(TextUtils.TruncateAt truncateAt) {
        this.f81283m = truncateAt;
        return this;
    }

    public StaticLayoutBuilderCompat e(int i3) {
        this.f81280j = i3;
        return this;
    }

    public StaticLayoutBuilderCompat f(boolean z2) {
        this.f81281k = z2;
        return this;
    }

    public StaticLayoutBuilderCompat g(boolean z2) {
        this.f81282l = z2;
        return this;
    }

    public StaticLayoutBuilderCompat h(float f3, float f4) {
        this.f81278h = f3;
        this.f81279i = f4;
        return this;
    }

    public StaticLayoutBuilderCompat i(int i3) {
        this.f81277g = i3;
        return this;
    }

    public StaticLayoutBuilderCompat j(StaticLayoutBuilderConfigurer staticLayoutBuilderConfigurer) {
        this.f81284n = staticLayoutBuilderConfigurer;
        return this;
    }
}
