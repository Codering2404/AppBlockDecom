package com.github.mikephil.charting.interfaces.datasets;

import android.graphics.DashPathEffect;
import android.graphics.Typeface;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.model.GradientColor;
import com.github.mikephil.charting.utils.MPPointF;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface IDataSet<T extends Entry> {
    void C(float f3, float f4);

    float D0();

    List E(float f3);

    List F();

    boolean I();

    int J0();

    YAxis.AxisDependency K();

    MPPointF K0();

    int M();

    boolean M0();

    GradientColor O0(int i3);

    float W();

    DashPathEffect Z();

    Entry a0(float f3, float f4);

    boolean c0();

    float d();

    int e(Entry entry);

    GradientColor f0();

    String getLabel();

    float i0();

    boolean isVisible();

    Legend.LegendForm j();

    float k0();

    float l();

    ValueFormatter p();

    int p0(int i3);

    Entry r(int i3);

    float s();

    boolean t0();

    void u0(ValueFormatter valueFormatter);

    Typeface v();

    Entry v0(float f3, float f4, DataSet.Rounding rounding);

    int x(int i3);

    List z();
}
