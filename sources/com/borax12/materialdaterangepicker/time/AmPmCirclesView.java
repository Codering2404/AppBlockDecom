package com.borax12.materialdaterangepicker.time;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import com.borax12.materialdaterangepicker.R;
import java.text.DateFormatSymbols;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AmPmCirclesView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Paint f65881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f65882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f65883c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f65884d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f65885f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f65886g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f65887h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f65888i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f65889j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f65890k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f65891l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f65892m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f65893n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f65894o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f65895p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f65896q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f65897r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f65898s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f65899t;

    public AmPmCirclesView(Context context) {
        super(context);
        this.f65881a = new Paint();
        this.f65892m = false;
    }

    public int a(float f3, float f4) {
        if (!this.f65893n) {
            return -1;
        }
        int i3 = this.f65897r;
        int i4 = (int) ((f4 - i3) * (f4 - i3));
        int i5 = this.f65895p;
        float f5 = i4;
        if (((int) Math.sqrt(((f3 - i5) * (f3 - i5)) + f5)) <= this.f65894o) {
            return 0;
        }
        int i6 = this.f65896q;
        return ((int) Math.sqrt((double) (((f3 - ((float) i6)) * (f3 - ((float) i6))) + f5))) <= this.f65894o ? 1 : -1;
    }

    public void b(Context context, int i3) {
        if (this.f65892m) {
            Log.e("AmPmCirclesView", "AmPmCirclesView may only be initialized once.");
            return;
        }
        Resources resources = context.getResources();
        int i4 = R.color.f65689w;
        this.f65884d = resources.getColor(i4);
        this.f65887h = resources.getColor(R.color.f65667a);
        this.f65883c = resources.getColor(R.color.f65668b);
        this.f65885f = resources.getColor(R.color.f65670d);
        this.f65886g = resources.getColor(i4);
        this.f65882b = 255;
        this.f65881a.setTypeface(ResourcesCompat.i(getContext(), R.font.f65698a));
        this.f65881a.setAntiAlias(true);
        this.f65881a.setTextAlign(Paint.Align.CENTER);
        this.f65888i = Float.parseFloat(resources.getString(R.string.f65731c));
        this.f65889j = Float.parseFloat(resources.getString(R.string.f65730b));
        String[] amPmStrings = new DateFormatSymbols().getAmPmStrings();
        this.f65890k = amPmStrings[0];
        this.f65891l = amPmStrings[1];
        setAmOrPm(i3);
        this.f65899t = -1;
        this.f65892m = true;
    }

    void c(Context context, boolean z2) {
        Resources resources = context.getResources();
        if (z2) {
            this.f65884d = resources.getColor(R.color.f65673g);
            this.f65887h = resources.getColor(R.color.f65687u);
            this.f65885f = resources.getColor(R.color.f65689w);
            this.f65882b = 255;
            return;
        }
        this.f65884d = resources.getColor(R.color.f65689w);
        this.f65887h = resources.getColor(R.color.f65667a);
        this.f65885f = resources.getColor(R.color.f65670d);
        this.f65882b = 255;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i3;
        int i4;
        int i5;
        if (getWidth() == 0 || !this.f65892m) {
            return;
        }
        if (!this.f65893n) {
            int width = getWidth() / 2;
            int height = getHeight() / 2;
            int iMin = (int) (Math.min(width, height) * this.f65888i);
            int i6 = (int) (iMin * this.f65889j);
            this.f65894o = i6;
            int i7 = (int) (((double) height) + (((double) i6) * 0.75d));
            this.f65881a.setTextSize((i6 * 3) / 4);
            int i8 = this.f65894o;
            this.f65897r = (i7 - (i8 / 2)) + iMin;
            this.f65895p = (width - iMin) + i8;
            this.f65896q = (width + iMin) - i8;
            this.f65893n = true;
        }
        int i9 = this.f65884d;
        int i10 = this.f65885f;
        int i11 = this.f65898s;
        int i12 = 255;
        if (i11 == 0) {
            int i13 = this.f65887h;
            int i14 = this.f65882b;
            i3 = i9;
            i9 = i13;
            i4 = i10;
            i10 = this.f65886g;
            i5 = 255;
            i12 = i14;
        } else if (i11 == 1) {
            i3 = this.f65887h;
            i5 = this.f65882b;
            i4 = this.f65886g;
        } else {
            i3 = i9;
            i4 = i10;
            i5 = 255;
        }
        int i15 = this.f65899t;
        if (i15 == 0) {
            i9 = this.f65883c;
            i12 = this.f65882b;
        } else if (i15 == 1) {
            i3 = this.f65883c;
            i5 = this.f65882b;
        }
        this.f65881a.setColor(i9);
        this.f65881a.setAlpha(i12);
        canvas.drawCircle(this.f65895p, this.f65897r, this.f65894o, this.f65881a);
        this.f65881a.setColor(i3);
        this.f65881a.setAlpha(i5);
        canvas.drawCircle(this.f65896q, this.f65897r, this.f65894o, this.f65881a);
        this.f65881a.setColor(i10);
        float fDescent = this.f65897r - (((int) (this.f65881a.descent() + this.f65881a.ascent())) / 2);
        canvas.drawText(this.f65890k, this.f65895p, fDescent, this.f65881a);
        this.f65881a.setColor(i4);
        canvas.drawText(this.f65891l, this.f65896q, fDescent, this.f65881a);
    }

    public void setAccentColor(int i3) {
        this.f65887h = i3;
    }

    public void setAmOrPm(int i3) {
        this.f65898s = i3;
    }

    public void setAmOrPmPressed(int i3) {
        this.f65899t = i3;
    }
}
