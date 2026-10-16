package com.applovin.exoplayer2.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import com.applovin.exoplayer2.ui.SubtitleView;
import com.applovin.impl.a5;
import com.applovin.impl.x2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class a extends View implements SubtitleView.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f57990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List f57991b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f57992c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f57993d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private x2 f57994f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f57995g;

    public a(Context context) {
        this(context, null);
    }

    private static a5 a(a5 a5Var) {
        a5.b bVarB = a5Var.a().b(-3.4028235E38f).b(Integer.MIN_VALUE).b((Layout.Alignment) null);
        if (a5Var.f58178g == 0) {
            bVarB.a(1.0f - a5Var.f58177f, 0);
        } else {
            bVarB.a((-a5Var.f58177f) - 1.0f, 1);
        }
        int i3 = a5Var.f58179h;
        if (i3 == 0) {
            bVarB.a(2);
        } else if (i3 == 2) {
            bVarB.a(0);
        }
        return bVarB.a();
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
        List list = this.f57991b;
        if (list.isEmpty()) {
            return;
        }
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int paddingBottom = height - getPaddingBottom();
        if (paddingBottom <= paddingTop || width <= paddingLeft) {
            return;
        }
        int i3 = paddingBottom - paddingTop;
        float fA = h.a(this.f57992c, this.f57993d, height, i3);
        if (fA <= 0.0f) {
            return;
        }
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            a5 a5VarA = (a5) list.get(i4);
            if (a5VarA.f58188q != Integer.MIN_VALUE) {
                a5VarA = a(a5VarA);
            }
            ((g) this.f57990a.get(i4)).a(a5VarA, this.f57994f, fA, h.a(a5VarA.f58186o, a5VarA.f58187p, height, i3), this.f57995g, canvas, paddingLeft, paddingTop, width, paddingBottom);
        }
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f57990a = new ArrayList();
        this.f57991b = Collections.EMPTY_LIST;
        this.f57992c = 0;
        this.f57993d = 0.0533f;
        this.f57994f = x2.f64786g;
        this.f57995g = 0.08f;
    }

    @Override // com.applovin.exoplayer2.ui.SubtitleView.a
    public void a(List list, x2 x2Var, float f3, int i3, float f4) {
        this.f57991b = list;
        this.f57994f = x2Var;
        this.f57993d = f3;
        this.f57992c = i3;
        this.f57995g = f4;
        while (this.f57990a.size() < list.size()) {
            this.f57990a.add(new g(getContext()));
        }
        invalidate();
    }
}
