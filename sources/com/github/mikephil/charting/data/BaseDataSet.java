package com.github.mikephil.charting.data;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Typeface;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.model.GradientColor;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseDataSet<T extends Entry> implements IDataSet<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected List f68493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected GradientColor f68494b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected List f68495c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected List f68496d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f68497e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected YAxis.AxisDependency f68498f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected boolean f68499g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected transient ValueFormatter f68500h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected Typeface f68501i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Legend.LegendForm f68502j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f68503k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f68504l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private DashPathEffect f68505m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected boolean f68506n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected boolean f68507o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    protected MPPointF f68508p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected float f68509q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    protected boolean f68510r;

    public BaseDataSet() {
        this.f68493a = null;
        this.f68494b = null;
        this.f68495c = null;
        this.f68496d = null;
        this.f68497e = "DataSet";
        this.f68498f = YAxis.AxisDependency.LEFT;
        this.f68499g = true;
        this.f68502j = Legend.LegendForm.DEFAULT;
        this.f68503k = Float.NaN;
        this.f68504l = Float.NaN;
        this.f68505m = null;
        this.f68506n = true;
        this.f68507o = true;
        this.f68508p = new MPPointF();
        this.f68509q = 17.0f;
        this.f68510r = true;
        this.f68493a = new ArrayList();
        this.f68496d = new ArrayList();
        this.f68493a.add(Integer.valueOf(Color.rgb(140, 234, 255)));
        this.f68496d.add(-16777216);
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public List F() {
        return this.f68495c;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public boolean I() {
        return this.f68506n;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public YAxis.AxisDependency K() {
        return this.f68498f;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public MPPointF K0() {
        return this.f68508p;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public int M() {
        return ((Integer) this.f68493a.get(0)).intValue();
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public boolean M0() {
        return this.f68499g;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public GradientColor O0(int i3) {
        List list = this.f68495c;
        return (GradientColor) list.get(i3 % list.size());
    }

    public void T0(List list) {
        this.f68493a = list;
    }

    public void U0(boolean z2) {
        this.f68506n = z2;
    }

    public void V0(List list) {
        this.f68495c = list;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public DashPathEffect Z() {
        return this.f68505m;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public boolean c0() {
        return this.f68507o;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public GradientColor f0() {
        return this.f68494b;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public String getLabel() {
        return this.f68497e;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public float i0() {
        return this.f68509q;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public boolean isVisible() {
        return this.f68510r;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public Legend.LegendForm j() {
        return this.f68502j;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public float k0() {
        return this.f68504l;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public ValueFormatter p() {
        return t0() ? Utils.j() : this.f68500h;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public int p0(int i3) {
        List list = this.f68493a;
        return ((Integer) list.get(i3 % list.size())).intValue();
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public float s() {
        return this.f68503k;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public boolean t0() {
        return this.f68500h == null;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public void u0(ValueFormatter valueFormatter) {
        if (valueFormatter == null) {
            return;
        }
        this.f68500h = valueFormatter;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public Typeface v() {
        return this.f68501i;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public int x(int i3) {
        List list = this.f68496d;
        return ((Integer) list.get(i3 % list.size())).intValue();
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public List z() {
        return this.f68493a;
    }

    public BaseDataSet(String str) {
        this();
        this.f68497e = str;
    }
}
