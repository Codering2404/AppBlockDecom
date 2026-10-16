package com.github.mikephil.charting.data;

import com.github.mikephil.charting.data.Entry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class DataSet<T extends Entry> extends BaseDataSet<T> {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected List f68535s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected float f68536t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    protected float f68537u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    protected float f68538v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    protected float f68539w;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum Rounding {
        UP,
        DOWN,
        CLOSEST
    }

    public DataSet(List list, String str) {
        super(str);
        this.f68536t = -3.4028235E38f;
        this.f68537u = Float.MAX_VALUE;
        this.f68538v = -3.4028235E38f;
        this.f68539w = Float.MAX_VALUE;
        this.f68535s = list;
        if (list == null) {
            this.f68535s = new ArrayList();
        }
        W0();
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public void C(float f3, float f4) {
        List list = this.f68535s;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f68536t = -3.4028235E38f;
        this.f68537u = Float.MAX_VALUE;
        int iA1 = a1(f4, Float.NaN, Rounding.UP);
        for (int iA12 = a1(f3, Float.NaN, Rounding.DOWN); iA12 <= iA1; iA12++) {
            Z0((Entry) this.f68535s.get(iA12));
        }
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public float D0() {
        return this.f68538v;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public List E(float f3) {
        ArrayList arrayList = new ArrayList();
        int size = this.f68535s.size() - 1;
        int i3 = 0;
        while (true) {
            if (i3 > size) {
                break;
            }
            int i4 = (size + i3) / 2;
            Entry entry = (Entry) this.f68535s.get(i4);
            if (f3 == entry.h()) {
                while (i4 > 0 && ((Entry) this.f68535s.get(i4 - 1)).h() == f3) {
                    i4--;
                }
                int size2 = this.f68535s.size();
                while (i4 < size2) {
                    Entry entry2 = (Entry) this.f68535s.get(i4);
                    if (entry2.h() != f3) {
                        break;
                    }
                    arrayList.add(entry2);
                    i4++;
                }
            } else if (f3 > entry.h()) {
                i3 = i4 + 1;
            } else {
                size = i4 - 1;
            }
        }
        return arrayList;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public int J0() {
        return this.f68535s.size();
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public float W() {
        return this.f68539w;
    }

    public void W0() {
        List list = this.f68535s;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f68536t = -3.4028235E38f;
        this.f68537u = Float.MAX_VALUE;
        this.f68538v = -3.4028235E38f;
        this.f68539w = Float.MAX_VALUE;
        Iterator it = this.f68535s.iterator();
        while (it.hasNext()) {
            X0((Entry) it.next());
        }
    }

    protected void X0(Entry entry) {
        if (entry == null) {
            return;
        }
        Y0(entry);
        Z0(entry);
    }

    protected void Y0(Entry entry) {
        if (entry.h() < this.f68539w) {
            this.f68539w = entry.h();
        }
        if (entry.h() > this.f68538v) {
            this.f68538v = entry.h();
        }
    }

    protected void Z0(Entry entry) {
        if (entry.e() < this.f68537u) {
            this.f68537u = entry.e();
        }
        if (entry.e() > this.f68536t) {
            this.f68536t = entry.e();
        }
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public Entry a0(float f3, float f4) {
        return v0(f3, f4, Rounding.CLOSEST);
    }

    public int a1(float f3, float f4, Rounding rounding) {
        int i3;
        Entry entry;
        List list = this.f68535s;
        if (list == null || list.isEmpty()) {
            return -1;
        }
        int size = this.f68535s.size() - 1;
        int i4 = 0;
        while (i4 < size) {
            int i5 = (i4 + size) / 2;
            float fH = ((Entry) this.f68535s.get(i5)).h() - f3;
            int i6 = i5 + 1;
            float fH2 = ((Entry) this.f68535s.get(i6)).h() - f3;
            float fAbs = Math.abs(fH);
            float fAbs2 = Math.abs(fH2);
            if (fAbs2 >= fAbs) {
                if (fAbs >= fAbs2) {
                    double d3 = fH;
                    if (d3 < 0.0d) {
                        if (d3 < 0.0d) {
                        }
                    }
                }
                size = i5;
            }
            i4 = i6;
        }
        if (size != -1) {
            float fH3 = ((Entry) this.f68535s.get(size)).h();
            if (rounding == Rounding.UP) {
                if (fH3 < f3 && size < this.f68535s.size() - 1) {
                    size++;
                }
            } else if (rounding == Rounding.DOWN && fH3 > f3 && size > 0) {
                size--;
            }
            if (!Float.isNaN(f4)) {
                while (size > 0 && ((Entry) this.f68535s.get(size - 1)).h() == fH3) {
                    size--;
                }
                float fE = ((Entry) this.f68535s.get(size)).e();
                loop2: while (true) {
                    i3 = size;
                    do {
                        size++;
                        if (size >= this.f68535s.size()) {
                            break loop2;
                        }
                        entry = (Entry) this.f68535s.get(size);
                        if (entry.h() != fH3) {
                            break loop2;
                        }
                    } while (Math.abs(entry.e() - f4) >= Math.abs(fE - f4));
                    fE = f4;
                }
                return i3;
            }
        }
        return size;
    }

    public String b1() {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder sb = new StringBuilder();
        sb.append("DataSet, label: ");
        sb.append(getLabel() == null ? "" : getLabel());
        sb.append(", entries: ");
        sb.append(this.f68535s.size());
        sb.append("\n");
        stringBuffer.append(sb.toString());
        return stringBuffer.toString();
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public float d() {
        return this.f68536t;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public int e(Entry entry) {
        return this.f68535s.indexOf(entry);
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public float l() {
        return this.f68537u;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public Entry r(int i3) {
        return (Entry) this.f68535s.get(i3);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(b1());
        for (int i3 = 0; i3 < this.f68535s.size(); i3++) {
            stringBuffer.append(((Entry) this.f68535s.get(i3)).toString() + " ");
        }
        return stringBuffer.toString();
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public Entry v0(float f3, float f4, Rounding rounding) {
        int iA1 = a1(f3, f4, rounding);
        if (iA1 > -1) {
            return (Entry) this.f68535s.get(iA1);
        }
        return null;
    }
}
