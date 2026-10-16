package com.github.mikephil.charting.components;

import android.graphics.DashPathEffect;
import com.github.mikephil.charting.formatter.DefaultAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AxisBase extends ComponentBase {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected ValueFormatter f68375g;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f68382n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f68383o;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    protected List f68394z;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f68376h = -7829368;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f68377i = 1.0f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f68378j = -7829368;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f68379k = 1.0f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float[] f68380l = new float[0];

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float[] f68381m = new float[0];

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f68384p = 6;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected float f68385q = 1.0f;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    protected boolean f68386r = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected boolean f68387s = false;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected boolean f68388t = true;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    protected boolean f68389u = true;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    protected boolean f68390v = true;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    protected boolean f68391w = false;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private DashPathEffect f68392x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private DashPathEffect f68393y = null;
    protected boolean A = false;
    protected boolean B = true;
    protected float C = 0.0f;
    protected float D = 0.0f;
    protected boolean E = false;
    protected boolean F = false;
    public float G = 0.0f;
    public float H = 0.0f;
    public float I = 0.0f;

    public AxisBase() {
        this.f68399e = Utils.e(10.0f);
        this.f68396b = Utils.e(5.0f);
        this.f68397c = Utils.e(5.0f);
        this.f68394z = new ArrayList();
    }

    public boolean A() {
        return this.B;
    }

    public boolean B() {
        return this.f68388t;
    }

    public boolean C() {
        return this.f68390v;
    }

    public boolean D() {
        return this.A;
    }

    public boolean E() {
        return this.f68387s;
    }

    public boolean F() {
        return this.f68386r;
    }

    public void G() {
        this.F = false;
    }

    public void H() {
        this.E = false;
    }

    public void I(float f3) {
        this.F = true;
        this.G = f3;
        this.I = Math.abs(f3 - this.H);
    }

    public void J(float f3) {
        this.E = true;
        this.H = f3;
        this.I = Math.abs(this.G - f3);
    }

    public void K(boolean z2) {
        this.f68391w = z2;
    }

    public void L(boolean z2) {
        this.f68389u = z2;
    }

    public void M(boolean z2) {
        this.f68388t = z2;
    }

    public void N(boolean z2) {
        this.f68390v = z2;
    }

    public void O(float f3) {
        this.f68385q = f3;
        this.f68386r = true;
    }

    public void P(boolean z2) {
        this.f68386r = z2;
    }

    public void Q(int i3) {
        this.f68376h = i3;
    }

    public void R(int i3) {
        if (i3 > 25) {
            i3 = 25;
        }
        if (i3 < 2) {
            i3 = 2;
        }
        this.f68384p = i3;
        this.f68387s = false;
    }

    public void S(float f3) {
        this.D = f3;
    }

    public void T(float f3) {
        this.C = f3;
    }

    public void U(ValueFormatter valueFormatter) {
        if (valueFormatter == null) {
            this.f68375g = new DefaultAxisValueFormatter(this.f68383o);
        } else {
            this.f68375g = valueFormatter;
        }
    }

    public void l(float f3, float f4) {
        float f5 = this.E ? this.H : f3 - this.C;
        float f6 = this.F ? this.G : f4 + this.D;
        if (Math.abs(f6 - f5) == 0.0f) {
            f6 += 1.0f;
            f5 -= 1.0f;
        }
        this.H = f5;
        this.G = f6;
        this.I = Math.abs(f6 - f5);
    }

    public int m() {
        return this.f68378j;
    }

    public DashPathEffect n() {
        return this.f68392x;
    }

    public float o() {
        return this.f68379k;
    }

    public String p(int i3) {
        return (i3 < 0 || i3 >= this.f68380l.length) ? "" : x().a(this.f68380l[i3], this);
    }

    public float q() {
        return this.f68385q;
    }

    public int r() {
        return this.f68376h;
    }

    public DashPathEffect s() {
        return this.f68393y;
    }

    public float t() {
        return this.f68377i;
    }

    public int u() {
        return this.f68384p;
    }

    public List v() {
        return this.f68394z;
    }

    public String w() {
        String str = "";
        for (int i3 = 0; i3 < this.f68380l.length; i3++) {
            String strP = p(i3);
            if (strP != null && str.length() < strP.length()) {
                str = strP;
            }
        }
        return str;
    }

    public ValueFormatter x() {
        ValueFormatter valueFormatter = this.f68375g;
        if (valueFormatter == null || ((valueFormatter instanceof DefaultAxisValueFormatter) && ((DefaultAxisValueFormatter) valueFormatter).j() != this.f68383o)) {
            this.f68375g = new DefaultAxisValueFormatter(this.f68383o);
        }
        return this.f68375g;
    }

    public boolean y() {
        return this.f68391w && this.f68382n > 0;
    }

    public boolean z() {
        return this.f68389u;
    }
}
