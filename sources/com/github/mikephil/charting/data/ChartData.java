package com.github.mikephil.charting.data;

import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ChartData<T extends IDataSet<? extends Entry>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected float f68521a = -3.4028235E38f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected float f68522b = Float.MAX_VALUE;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected float f68523c = -3.4028235E38f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected float f68524d = Float.MAX_VALUE;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected float f68525e = -3.4028235E38f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected float f68526f = Float.MAX_VALUE;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected float f68527g = -3.4028235E38f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected float f68528h = Float.MAX_VALUE;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected List f68529i;

    public ChartData(IDataSet... iDataSetArr) {
        this.f68529i = a(iDataSetArr);
        s();
    }

    private List a(IDataSet[] iDataSetArr) {
        ArrayList arrayList = new ArrayList();
        for (IDataSet iDataSet : iDataSetArr) {
            arrayList.add(iDataSet);
        }
        return arrayList;
    }

    protected void b() {
        List list = this.f68529i;
        if (list == null) {
            return;
        }
        this.f68521a = -3.4028235E38f;
        this.f68522b = Float.MAX_VALUE;
        this.f68523c = -3.4028235E38f;
        this.f68524d = Float.MAX_VALUE;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            c((IDataSet) it.next());
        }
        this.f68525e = -3.4028235E38f;
        this.f68526f = Float.MAX_VALUE;
        this.f68527g = -3.4028235E38f;
        this.f68528h = Float.MAX_VALUE;
        IDataSet iDataSetJ = j(this.f68529i);
        if (iDataSetJ != null) {
            this.f68525e = iDataSetJ.d();
            this.f68526f = iDataSetJ.l();
            for (IDataSet iDataSet : this.f68529i) {
                if (iDataSet.K() == YAxis.AxisDependency.LEFT) {
                    if (iDataSet.l() < this.f68526f) {
                        this.f68526f = iDataSet.l();
                    }
                    if (iDataSet.d() > this.f68525e) {
                        this.f68525e = iDataSet.d();
                    }
                }
            }
        }
        IDataSet iDataSetK = k(this.f68529i);
        if (iDataSetK != null) {
            this.f68527g = iDataSetK.d();
            this.f68528h = iDataSetK.l();
            for (IDataSet iDataSet2 : this.f68529i) {
                if (iDataSet2.K() == YAxis.AxisDependency.RIGHT) {
                    if (iDataSet2.l() < this.f68528h) {
                        this.f68528h = iDataSet2.l();
                    }
                    if (iDataSet2.d() > this.f68527g) {
                        this.f68527g = iDataSet2.d();
                    }
                }
            }
        }
    }

    protected void c(IDataSet iDataSet) {
        if (this.f68521a < iDataSet.d()) {
            this.f68521a = iDataSet.d();
        }
        if (this.f68522b > iDataSet.l()) {
            this.f68522b = iDataSet.l();
        }
        if (this.f68523c < iDataSet.D0()) {
            this.f68523c = iDataSet.D0();
        }
        if (this.f68524d > iDataSet.W()) {
            this.f68524d = iDataSet.W();
        }
        if (iDataSet.K() == YAxis.AxisDependency.LEFT) {
            if (this.f68525e < iDataSet.d()) {
                this.f68525e = iDataSet.d();
            }
            if (this.f68526f > iDataSet.l()) {
                this.f68526f = iDataSet.l();
                return;
            }
            return;
        }
        if (this.f68527g < iDataSet.d()) {
            this.f68527g = iDataSet.d();
        }
        if (this.f68528h > iDataSet.l()) {
            this.f68528h = iDataSet.l();
        }
    }

    public void d(float f3, float f4) {
        Iterator it = this.f68529i.iterator();
        while (it.hasNext()) {
            ((IDataSet) it.next()).C(f3, f4);
        }
        b();
    }

    public IDataSet e(int i3) {
        List list = this.f68529i;
        if (list == null || i3 < 0 || i3 >= list.size()) {
            return null;
        }
        return (IDataSet) this.f68529i.get(i3);
    }

    public int f() {
        List list = this.f68529i;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public List g() {
        return this.f68529i;
    }

    public int h() {
        Iterator it = this.f68529i.iterator();
        int iJ0 = 0;
        while (it.hasNext()) {
            iJ0 += ((IDataSet) it.next()).J0();
        }
        return iJ0;
    }

    public Entry i(Highlight highlight) {
        if (highlight.d() >= this.f68529i.size()) {
            return null;
        }
        return ((IDataSet) this.f68529i.get(highlight.d())).a0(highlight.h(), highlight.j());
    }

    protected IDataSet j(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            IDataSet iDataSet = (IDataSet) it.next();
            if (iDataSet.K() == YAxis.AxisDependency.LEFT) {
                return iDataSet;
            }
        }
        return null;
    }

    public IDataSet k(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            IDataSet iDataSet = (IDataSet) it.next();
            if (iDataSet.K() == YAxis.AxisDependency.RIGHT) {
                return iDataSet;
            }
        }
        return null;
    }

    public IDataSet l() {
        List list = this.f68529i;
        if (list == null || list.isEmpty()) {
            return null;
        }
        IDataSet iDataSet = (IDataSet) this.f68529i.get(0);
        for (IDataSet iDataSet2 : this.f68529i) {
            if (iDataSet2.J0() > iDataSet.J0()) {
                iDataSet = iDataSet2;
            }
        }
        return iDataSet;
    }

    public float m() {
        return this.f68523c;
    }

    public float n() {
        return this.f68524d;
    }

    public float o() {
        return this.f68521a;
    }

    public float p(YAxis.AxisDependency axisDependency) {
        if (axisDependency == YAxis.AxisDependency.LEFT) {
            float f3 = this.f68525e;
            return f3 == -3.4028235E38f ? this.f68527g : f3;
        }
        float f4 = this.f68527g;
        return f4 == -3.4028235E38f ? this.f68525e : f4;
    }

    public float q() {
        return this.f68522b;
    }

    public float r(YAxis.AxisDependency axisDependency) {
        if (axisDependency == YAxis.AxisDependency.LEFT) {
            float f3 = this.f68526f;
            return f3 == Float.MAX_VALUE ? this.f68528h : f3;
        }
        float f4 = this.f68528h;
        return f4 == Float.MAX_VALUE ? this.f68526f : f4;
    }

    public void s() {
        b();
    }
}
