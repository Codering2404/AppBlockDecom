package com.borax12.materialdaterangepicker.time;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;
import com.borax12.materialdaterangepicker.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class CircleView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Paint f65900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f65901b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f65902c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f65903d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f65904f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f65905g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f65906h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f65907i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f65908j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f65909k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f65910l;

    public CircleView(Context context) {
        super(context);
        Paint paint = new Paint();
        this.f65900a = paint;
        Resources resources = context.getResources();
        this.f65902c = resources.getColor(R.color.f65674h);
        this.f65903d = resources.getColor(R.color.f65667a);
        paint.setAntiAlias(true);
        this.f65906h = false;
    }

    public void a(Context context, boolean z2) {
        if (this.f65906h) {
            Log.e("CircleView", "CircleView may only be initialized once.");
            return;
        }
        Resources resources = context.getResources();
        this.f65901b = z2;
        if (z2) {
            this.f65904f = Float.parseFloat(resources.getString(R.string.f65732d));
        } else {
            this.f65904f = Float.parseFloat(resources.getString(R.string.f65731c));
            this.f65905g = Float.parseFloat(resources.getString(R.string.f65730b));
        }
        this.f65906h = true;
    }

    void b(Context context, boolean z2) {
        Resources resources = context.getResources();
        if (z2) {
            this.f65902c = resources.getColor(R.color.f65673g);
        } else {
            this.f65902c = resources.getColor(R.color.f65674h);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (getWidth() == 0 || !this.f65906h) {
            return;
        }
        if (!this.f65907i) {
            this.f65908j = getWidth() / 2;
            this.f65909k = getHeight() / 2;
            int iMin = (int) (Math.min(this.f65908j, r0) * this.f65904f);
            this.f65910l = iMin;
            if (!this.f65901b) {
                this.f65909k = (int) (((double) this.f65909k) - (((double) ((int) (iMin * this.f65905g))) * 0.75d));
            }
            this.f65907i = true;
        }
        this.f65900a.setColor(this.f65902c);
        canvas.drawCircle(this.f65908j, this.f65909k, this.f65910l, this.f65900a);
        this.f65900a.setColor(this.f65903d);
        canvas.drawCircle(this.f65908j, this.f65909k, 8.0f, this.f65900a);
    }

    void setAccentColor(int i3) {
        this.f65903d = i3;
    }
}
