package ru.noties.markwon.core;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import java.util.Arrays;
import java.util.Locale;
import ru.noties.markwon.utils.ColorUtils;
import ru.noties.markwon.utils.Dip;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class MarkwonTheme {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final float[] f147107w = {2.0f, 1.5f, 1.17f, 1.0f, 0.83f, 0.67f};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final int f147108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final int f147109b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final int f147110c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final int f147111d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final int f147112e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected final int f147113f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected final int f147114g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected final int f147115h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected final int f147116i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected final int f147117j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected final int f147118k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected final int f147119l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected final Typeface f147120m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected final Typeface f147121n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected final int f147122o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    protected final int f147123p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected final int f147124q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    protected final int f147125r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected final Typeface f147126s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected final float[] f147127t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    protected final int f147128u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    protected final int f147129v;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f147130a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f147131b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f147132c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f147133d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f147134e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f147135f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f147136g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f147137h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f147138i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f147139j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f147140k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f147141l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private Typeface f147142m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private Typeface f147143n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private int f147144o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private int f147145p;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private int f147147r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private Typeface f147148s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private float[] f147149t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private int f147150u;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private int f147146q = -1;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private int f147151v = -1;

        Builder() {
        }

        public Builder A(int i3) {
            this.f147139j = i3;
            return this;
        }

        public Builder B(int i3) {
            this.f147140k = i3;
            return this;
        }

        public Builder C(int i3) {
            this.f147141l = i3;
            return this;
        }

        public Builder D(int i3) {
            this.f147146q = i3;
            return this;
        }

        public Builder E(int i3) {
            this.f147130a = i3;
            return this;
        }

        public Builder F(int i3) {
            this.f147151v = i3;
            return this;
        }

        public Builder w(int i3) {
            this.f147131b = i3;
            return this;
        }

        public Builder x(int i3) {
            this.f147132c = i3;
            return this;
        }

        public MarkwonTheme y() {
            return new MarkwonTheme(this);
        }

        public Builder z(int i3) {
            this.f147135f = i3;
            return this;
        }
    }

    protected MarkwonTheme(Builder builder) {
        this.f147108a = builder.f147130a;
        this.f147109b = builder.f147131b;
        this.f147110c = builder.f147132c;
        this.f147111d = builder.f147133d;
        this.f147112e = builder.f147134e;
        this.f147113f = builder.f147135f;
        this.f147114g = builder.f147136g;
        this.f147115h = builder.f147137h;
        this.f147116i = builder.f147138i;
        this.f147117j = builder.f147139j;
        this.f147118k = builder.f147140k;
        this.f147119l = builder.f147141l;
        this.f147120m = builder.f147142m;
        this.f147121n = builder.f147143n;
        this.f147122o = builder.f147144o;
        this.f147123p = builder.f147145p;
        this.f147124q = builder.f147146q;
        this.f147125r = builder.f147147r;
        this.f147126s = builder.f147148s;
        this.f147127t = builder.f147149t;
        this.f147128u = builder.f147150u;
        this.f147129v = builder.f147151v;
    }

    public static Builder j(Context context) {
        Dip dipA = Dip.a(context);
        return new Builder().C(dipA.b(8)).w(dipA.b(24)).x(dipA.b(4)).z(dipA.b(1)).D(dipA.b(1)).F(dipA.b(4));
    }

    public void a(Paint paint) {
        int iA = this.f147111d;
        if (iA == 0) {
            iA = ColorUtils.a(paint.getColor(), 25);
        }
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(iA);
    }

    public void b(Paint paint) {
        int i3 = this.f147116i;
        if (i3 == 0) {
            i3 = this.f147115h;
        }
        if (i3 != 0) {
            paint.setColor(i3);
        }
        Typeface typeface = this.f147121n;
        if (typeface == null) {
            typeface = this.f147120m;
        }
        if (typeface != null) {
            paint.setTypeface(typeface);
            int i4 = this.f147123p;
            if (i4 <= 0) {
                i4 = this.f147122o;
            }
            if (i4 > 0) {
                paint.setTextSize(i4);
                return;
            }
            return;
        }
        paint.setTypeface(Typeface.MONOSPACE);
        int i5 = this.f147123p;
        if (i5 <= 0) {
            i5 = this.f147122o;
        }
        if (i5 > 0) {
            paint.setTextSize(i5);
        } else {
            paint.setTextSize(paint.getTextSize() * 0.87f);
        }
    }

    public void c(Paint paint) {
        int i3 = this.f147115h;
        if (i3 != 0) {
            paint.setColor(i3);
        }
        Typeface typeface = this.f147120m;
        if (typeface != null) {
            paint.setTypeface(typeface);
            int i4 = this.f147122o;
            if (i4 > 0) {
                paint.setTextSize(i4);
                return;
            }
            return;
        }
        paint.setTypeface(Typeface.MONOSPACE);
        int i5 = this.f147122o;
        if (i5 > 0) {
            paint.setTextSize(i5);
        } else {
            paint.setTextSize(paint.getTextSize() * 0.87f);
        }
    }

    public void d(Paint paint) {
        int iA = this.f147125r;
        if (iA == 0) {
            iA = ColorUtils.a(paint.getColor(), 75);
        }
        paint.setColor(iA);
        paint.setStyle(Paint.Style.FILL);
        int i3 = this.f147124q;
        if (i3 >= 0) {
            paint.setStrokeWidth(i3);
        }
    }

    public void e(Paint paint, int i3) {
        Typeface typeface = this.f147126s;
        if (typeface == null) {
            paint.setFakeBoldText(true);
        } else {
            paint.setTypeface(typeface);
        }
        float[] fArr = this.f147127t;
        if (fArr == null) {
            fArr = f147107w;
        }
        if (fArr == null || fArr.length < i3) {
            throw new IllegalStateException(String.format(Locale.US, "Supplied heading level: %d is invalid, where configured heading sizes are: `%s`", Integer.valueOf(i3), Arrays.toString(fArr)));
        }
        paint.setTextSize(paint.getTextSize() * fArr[i3 - 1]);
    }

    public void f(Paint paint) {
        paint.setUnderlineText(true);
        int i3 = this.f147108a;
        if (i3 != 0) {
            paint.setColor(i3);
        } else if (paint instanceof TextPaint) {
            paint.setColor(((TextPaint) paint).linkColor);
        }
    }

    public void g(TextPaint textPaint) {
        textPaint.setUnderlineText(true);
        int i3 = this.f147108a;
        if (i3 != 0) {
            textPaint.setColor(i3);
        } else {
            textPaint.setColor(textPaint.linkColor);
        }
    }

    public void h(Paint paint) {
        int color = this.f147112e;
        if (color == 0) {
            color = paint.getColor();
        }
        paint.setColor(color);
        int i3 = this.f147113f;
        if (i3 != 0) {
            paint.setStrokeWidth(i3);
        }
    }

    public void i(Paint paint) {
        int iA = this.f147128u;
        if (iA == 0) {
            iA = ColorUtils.a(paint.getColor(), 25);
        }
        paint.setColor(iA);
        paint.setStyle(Paint.Style.FILL);
        int i3 = this.f147129v;
        if (i3 >= 0) {
            paint.setStrokeWidth(i3);
        }
    }

    public int k() {
        return this.f147109b;
    }

    public int l() {
        int i3 = this.f147110c;
        return i3 == 0 ? (int) ((this.f147109b * 0.25f) + 0.5f) : i3;
    }

    public int m(int i3) {
        int iMin = Math.min(this.f147109b, i3) / 2;
        int i4 = this.f147114g;
        return (i4 == 0 || i4 > iMin) ? iMin : i4;
    }

    public int n(Paint paint) {
        int i3 = this.f147117j;
        return i3 != 0 ? i3 : ColorUtils.a(paint.getColor(), 25);
    }

    public int o(Paint paint) {
        int i3 = this.f147118k;
        if (i3 == 0) {
            i3 = this.f147117j;
        }
        return i3 != 0 ? i3 : ColorUtils.a(paint.getColor(), 25);
    }

    public int p() {
        return this.f147119l;
    }
}
