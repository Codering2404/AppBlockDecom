package com.applovin.impl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.applovin.sdk.AppLovinMediationProvider;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class h3 extends View {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final int f60099x = Color.rgb(66, 145, 241);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final int f60100y = Color.rgb(66, 145, 241);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final int f60101z = Color.rgb(66, 145, 241);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Paint f60102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Paint f60103b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected Paint f60104c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected Paint f60105d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private RectF f60106f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f60107g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f60108h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f60109i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f60110j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f60111k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f60112l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f60113m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f60114n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f60115o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f60116p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f60117q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f60118r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private float f60119s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final float f60120t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final float f60121u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final float f60122v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final int f60123w;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class a {
        /* JADX INFO: Access modifiers changed from: private */
        public static float c(Resources resources, float f3) {
            return (f3 * resources.getDisplayMetrics().density) + 0.5f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static float d(Resources resources, float f3) {
            return f3 * resources.getDisplayMetrics().scaledDensity;
        }
    }

    public h3(Context context) {
        this(context, null);
    }

    private float getProgressAngle() {
        return (getProgress() / this.f60111k) * 360.0f;
    }

    protected void a() {
        this.f60112l = f60099x;
        this.f60108h = f60100y;
        this.f60107g = this.f60121u;
        setMax(100);
        setProgress(0);
        this.f60113m = this.f60120t;
        this.f60114n = 0;
        this.f60117q = this.f60122v;
        this.f60109i = f60101z;
    }

    protected void b() {
        TextPaint textPaint = new TextPaint();
        this.f60104c = textPaint;
        textPaint.setColor(this.f60108h);
        this.f60104c.setTextSize(this.f60107g);
        this.f60104c.setAntiAlias(true);
        TextPaint textPaint2 = new TextPaint();
        this.f60105d = textPaint2;
        textPaint2.setColor(this.f60109i);
        this.f60105d.setTextSize(this.f60117q);
        this.f60105d.setAntiAlias(true);
        Paint paint = new Paint();
        this.f60102a = paint;
        paint.setColor(this.f60112l);
        this.f60102a.setStyle(Paint.Style.STROKE);
        this.f60102a.setAntiAlias(true);
        this.f60102a.setStrokeWidth(this.f60113m);
        Paint paint2 = new Paint();
        this.f60103b = paint2;
        paint2.setColor(this.f60114n);
        this.f60103b.setAntiAlias(true);
    }

    public int getFinishedStrokeColor() {
        return this.f60112l;
    }

    public float getFinishedStrokeWidth() {
        return this.f60113m;
    }

    public int getInnerBackgroundColor() {
        return this.f60114n;
    }

    public String getInnerBottomText() {
        return this.f60118r;
    }

    public int getInnerBottomTextColor() {
        return this.f60109i;
    }

    public float getInnerBottomTextSize() {
        return this.f60117q;
    }

    public int getMax() {
        return this.f60111k;
    }

    public String getPrefixText() {
        return this.f60115o;
    }

    public int getProgress() {
        return this.f60110j;
    }

    public String getSuffixText() {
        return this.f60116p;
    }

    public int getTextColor() {
        return this.f60108h;
    }

    public float getTextSize() {
        return this.f60107g;
    }

    @Override // android.view.View
    public void invalidate() {
        b();
        super.invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f3 = this.f60113m;
        this.f60106f.set(f3, f3, getWidth() - f3, getHeight() - f3);
        float width = getWidth();
        float f4 = this.f60113m;
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, ((width - f4) + f4) / 2.0f, this.f60103b);
        canvas.drawArc(this.f60106f, 270.0f, -getProgressAngle(), false, this.f60102a);
        String str = this.f60115o + this.f60110j + this.f60116p;
        if (!TextUtils.isEmpty(str)) {
            canvas.drawText(str, (getWidth() - this.f60104c.measureText(str)) / 2.0f, (getWidth() - (this.f60104c.descent() + this.f60104c.ascent())) / 2.0f, this.f60104c);
        }
        if (TextUtils.isEmpty(getInnerBottomText())) {
            return;
        }
        this.f60105d.setTextSize(this.f60117q);
        canvas.drawText(getInnerBottomText(), (getWidth() - this.f60105d.measureText(getInnerBottomText())) / 2.0f, (getHeight() - this.f60119s) - ((this.f60104c.descent() + this.f60104c.ascent()) / 2.0f), this.f60105d);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        setMeasuredDimension(a(i3), a(i4));
        this.f60119s = getHeight() - ((getHeight() * 3) / 4);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        this.f60108h = bundle.getInt("text_color");
        this.f60107g = bundle.getFloat("text_size");
        this.f60117q = bundle.getFloat("inner_bottom_text_size");
        this.f60118r = bundle.getString("inner_bottom_text");
        this.f60109i = bundle.getInt("inner_bottom_text_color");
        this.f60112l = bundle.getInt("finished_stroke_color");
        this.f60113m = bundle.getFloat("finished_stroke_width");
        this.f60114n = bundle.getInt("inner_background_color");
        b();
        setMax(bundle.getInt(AppLovinMediationProvider.MAX));
        setProgress(bundle.getInt("progress"));
        this.f60115o = bundle.getString("prefix");
        this.f60116p = bundle.getString("suffix");
        super.onRestoreInstanceState(bundle.getParcelable("saved_instance"));
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("saved_instance", super.onSaveInstanceState());
        bundle.putInt("text_color", getTextColor());
        bundle.putFloat("text_size", getTextSize());
        bundle.putFloat("inner_bottom_text_size", getInnerBottomTextSize());
        bundle.putFloat("inner_bottom_text_color", getInnerBottomTextColor());
        bundle.putString("inner_bottom_text", getInnerBottomText());
        bundle.putInt("inner_bottom_text_color", getInnerBottomTextColor());
        bundle.putInt("finished_stroke_color", getFinishedStrokeColor());
        bundle.putInt(AppLovinMediationProvider.MAX, getMax());
        bundle.putInt("progress", getProgress());
        bundle.putString("suffix", getSuffixText());
        bundle.putString("prefix", getPrefixText());
        bundle.putFloat("finished_stroke_width", getFinishedStrokeWidth());
        bundle.putInt("inner_background_color", getInnerBackgroundColor());
        return bundle;
    }

    public void setFinishedStrokeColor(int i3) {
        this.f60112l = i3;
        invalidate();
    }

    public void setFinishedStrokeWidth(float f3) {
        this.f60113m = f3;
        invalidate();
    }

    public void setInnerBackgroundColor(int i3) {
        this.f60114n = i3;
        invalidate();
    }

    public void setInnerBottomText(String str) {
        this.f60118r = str;
        invalidate();
    }

    public void setInnerBottomTextColor(int i3) {
        this.f60109i = i3;
        invalidate();
    }

    public void setInnerBottomTextSize(float f3) {
        this.f60117q = f3;
        invalidate();
    }

    public void setMax(int i3) {
        if (i3 > 0) {
            this.f60111k = i3;
            invalidate();
        }
    }

    public void setPrefixText(String str) {
        this.f60115o = str;
        invalidate();
    }

    public void setProgress(int i3) {
        this.f60110j = i3;
        if (i3 > getMax()) {
            this.f60110j %= getMax();
        }
        invalidate();
    }

    public void setSuffixText(String str) {
        this.f60116p = str;
        invalidate();
    }

    public void setTextColor(int i3) {
        this.f60108h = i3;
        invalidate();
    }

    public void setTextSize(float f3) {
        this.f60107g = f3;
        invalidate();
    }

    public h3(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public h3(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f60106f = new RectF();
        this.f60110j = 0;
        this.f60115o = "";
        this.f60116p = "";
        this.f60118r = "";
        this.f60121u = a.d(getResources(), 14.0f);
        this.f60123w = (int) a.c(getResources(), 100.0f);
        this.f60120t = a.c(getResources(), 4.0f);
        this.f60122v = a.d(getResources(), 18.0f);
        a();
        b();
    }

    private int a(int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode == 1073741824) {
            return size;
        }
        int i4 = this.f60123w;
        return mode == Integer.MIN_VALUE ? Math.min(i4, size) : i4;
    }
}
