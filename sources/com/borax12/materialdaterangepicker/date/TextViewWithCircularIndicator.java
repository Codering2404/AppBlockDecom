package com.borax12.materialdaterangepicker.date;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;
import com.borax12.materialdaterangepicker.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class TextViewWithCircularIndicator extends TextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Paint f65866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f65867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f65868c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f65869d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f65870f;

    public TextViewWithCircularIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f65866a = new Paint();
        Resources resources = context.getResources();
        this.f65868c = resources.getColor(R.color.f65667a);
        this.f65867b = resources.getDimensionPixelOffset(R.dimen.f65696g);
        this.f65869d = context.getResources().getString(R.string.f65736h);
        c();
    }

    private ColorStateList a(int i3) {
        return new ColorStateList(new int[][]{new int[]{android.R.attr.state_pressed}, new int[]{android.R.attr.state_selected}, new int[0]}, new int[]{i3, -1, -16777216});
    }

    private void c() {
        this.f65866a.setFakeBoldText(true);
        this.f65866a.setAntiAlias(true);
        this.f65866a.setColor(this.f65868c);
        this.f65866a.setTextAlign(Paint.Align.CENTER);
        this.f65866a.setStyle(Paint.Style.FILL);
        this.f65866a.setAlpha(255);
    }

    public void b(boolean z2) {
        this.f65870f = z2;
    }

    @Override // android.view.View
    public CharSequence getContentDescription() {
        CharSequence text = getText();
        return this.f65870f ? String.format(this.f65869d, text) : text;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f65870f) {
            int width = getWidth();
            int height = getHeight();
            canvas.drawCircle(width / 2, height / 2, Math.min(width, height) / 2, this.f65866a);
        }
        setSelected(this.f65870f);
        super.onDraw(canvas);
    }

    public void setAccentColor(int i3) {
        this.f65868c = i3;
        this.f65866a.setColor(i3);
        setTextColor(a(i3));
    }
}
