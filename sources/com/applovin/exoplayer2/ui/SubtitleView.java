package com.applovin.exoplayer2.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import android.widget.FrameLayout;
import com.applovin.impl.a5;
import com.applovin.impl.qh;
import com.applovin.impl.x2;
import com.applovin.impl.xp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class SubtitleView extends FrameLayout implements qh.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List f57980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private x2 f57981b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f57982c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f57983d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f57984f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f57985g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f57986h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f57987i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private a f57988j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private View f57989k;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface a {
        void a(List list, x2 x2Var, float f3, int i3, float f4);
    }

    public SubtitleView(Context context) {
        this(context, null);
    }

    private a5 a(a5 a5Var) {
        a5.b bVarA = a5Var.a();
        if (!this.f57985g) {
            h.a(bVarA);
        } else if (!this.f57986h) {
            h.b(bVarA);
        }
        return bVarA.a();
    }

    private void e() {
        this.f57988j.a(getCuesWithStylingPreferencesApplied(), this.f57981b, this.f57983d, this.f57982c, this.f57984f);
    }

    private List<a5> getCuesWithStylingPreferencesApplied() {
        if (this.f57985g && this.f57986h) {
            return this.f57980a;
        }
        ArrayList arrayList = new ArrayList(this.f57980a.size());
        for (int i3 = 0; i3 < this.f57980a.size(); i3++) {
            arrayList.add(a((a5) this.f57980a.get(i3)));
        }
        return arrayList;
    }

    private float getUserCaptionFontScale() {
        CaptioningManager captioningManager;
        if (xp.f65027a < 19 || isInEditMode() || (captioningManager = (CaptioningManager) getContext().getSystemService("captioning")) == null || !captioningManager.isEnabled()) {
            return 1.0f;
        }
        return captioningManager.getFontScale();
    }

    private x2 getUserCaptionStyle() {
        if (xp.f65027a < 19 || isInEditMode()) {
            return x2.f64786g;
        }
        CaptioningManager captioningManager = (CaptioningManager) getContext().getSystemService("captioning");
        return (captioningManager == null || !captioningManager.isEnabled()) ? x2.f64786g : x2.a(captioningManager.getUserStyle());
    }

    private <T extends View & a> void setView(T t2) {
        removeView(this.f57989k);
        View view = this.f57989k;
        if (view instanceof j) {
            ((j) view).a();
        }
        this.f57989k = t2;
        this.f57988j = t2;
        addView(t2);
    }

    public void c() {
        setStyle(getUserCaptionStyle());
    }

    public void d() {
        setFractionalTextSize(getUserCaptionFontScale() * 0.0533f);
    }

    public void setApplyEmbeddedFontSizes(boolean z2) {
        this.f57986h = z2;
        e();
    }

    public void setApplyEmbeddedStyles(boolean z2) {
        this.f57985g = z2;
        e();
    }

    public void setBottomPaddingFraction(float f3) {
        this.f57984f = f3;
        e();
    }

    public void setCues(List<a5> list) {
        if (list == null) {
            list = Collections.EMPTY_LIST;
        }
        this.f57980a = list;
        e();
    }

    public void setFractionalTextSize(float f3) {
        a(f3, false);
    }

    public void setStyle(x2 x2Var) {
        this.f57981b = x2Var;
        e();
    }

    public void setViewType(int i3) {
        if (this.f57987i == i3) {
            return;
        }
        if (i3 == 1) {
            setView(new com.applovin.exoplayer2.ui.a(getContext()));
        } else {
            if (i3 != 2) {
                throw new IllegalArgumentException();
            }
            setView(new j(getContext()));
        }
        this.f57987i = i3;
    }

    public SubtitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f57980a = Collections.EMPTY_LIST;
        this.f57981b = x2.f64786g;
        this.f57982c = 0;
        this.f57983d = 0.0533f;
        this.f57984f = 0.08f;
        this.f57985g = true;
        this.f57986h = true;
        com.applovin.exoplayer2.ui.a aVar = new com.applovin.exoplayer2.ui.a(context);
        this.f57988j = aVar;
        this.f57989k = aVar;
        addView(aVar);
        this.f57987i = 1;
    }

    @Override // com.applovin.impl.qh.e
    public void a(List list) {
        setCues(list);
    }

    public void a(float f3, boolean z2) {
        a(z2 ? 1 : 0, f3);
    }

    private void a(int i3, float f3) {
        this.f57982c = i3;
        this.f57983d = f3;
        e();
    }
}
