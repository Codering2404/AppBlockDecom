package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.Chain;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import com.facebook.internal.AnalyticsEvents;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class WidgetGroup {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static int f32469g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f32471b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f32473d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ArrayList f32470a = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f32472c = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    ArrayList f32474e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f32475f = -1;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class MeasureResult {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        WeakReference f32476a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f32477b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f32478c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f32479d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f32480e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f32481f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f32482g;

        MeasureResult(ConstraintWidget constraintWidget, LinearSystem linearSystem, int i3) {
            this.f32476a = new WeakReference(constraintWidget);
            this.f32477b = linearSystem.A(constraintWidget.Q);
            this.f32478c = linearSystem.A(constraintWidget.R);
            this.f32479d = linearSystem.A(constraintWidget.S);
            this.f32480e = linearSystem.A(constraintWidget.T);
            this.f32481f = linearSystem.A(constraintWidget.U);
            this.f32482g = i3;
        }
    }

    public WidgetGroup(int i3) {
        int i4 = f32469g;
        f32469g = i4 + 1;
        this.f32471b = i4;
        this.f32473d = i3;
    }

    private String e() {
        int i3 = this.f32473d;
        return i3 == 0 ? "Horizontal" : i3 == 1 ? "Vertical" : i3 == 2 ? "Both" : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    }

    private int j(LinearSystem linearSystem, ArrayList arrayList, int i3) {
        int iA;
        int iA2;
        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) ((ConstraintWidget) arrayList.get(0)).N();
        linearSystem.G();
        constraintWidgetContainer.g(linearSystem, false);
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            ((ConstraintWidget) arrayList.get(i4)).g(linearSystem, false);
        }
        if (i3 == 0 && constraintWidgetContainer.f32336h1 > 0) {
            Chain.b(constraintWidgetContainer, linearSystem, arrayList, 0);
        }
        if (i3 == 1 && constraintWidgetContainer.f32337i1 > 0) {
            Chain.b(constraintWidgetContainer, linearSystem, arrayList, 1);
        }
        try {
            linearSystem.C();
        } catch (Exception e3) {
            System.err.println(e3.toString() + "\n" + Arrays.toString(e3.getStackTrace()).replace("[", "   at ").replace(",", "\n   at").replace("]", ""));
        }
        this.f32474e = new ArrayList();
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            this.f32474e.add(new MeasureResult((ConstraintWidget) arrayList.get(i5), linearSystem, i3));
        }
        if (i3 == 0) {
            iA = linearSystem.A(constraintWidgetContainer.Q);
            iA2 = linearSystem.A(constraintWidgetContainer.S);
            linearSystem.G();
        } else {
            iA = linearSystem.A(constraintWidgetContainer.R);
            iA2 = linearSystem.A(constraintWidgetContainer.T);
            linearSystem.G();
        }
        return iA2 - iA;
    }

    public boolean a(ConstraintWidget constraintWidget) {
        if (this.f32470a.contains(constraintWidget)) {
            return false;
        }
        this.f32470a.add(constraintWidget);
        return true;
    }

    public void b(ArrayList arrayList) {
        int size = this.f32470a.size();
        if (this.f32475f != -1 && size > 0) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                WidgetGroup widgetGroup = (WidgetGroup) arrayList.get(i3);
                if (this.f32475f == widgetGroup.f32471b) {
                    g(this.f32473d, widgetGroup);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public int c() {
        return this.f32471b;
    }

    public int d() {
        return this.f32473d;
    }

    public int f(LinearSystem linearSystem, int i3) {
        if (this.f32470a.size() == 0) {
            return 0;
        }
        return j(linearSystem, this.f32470a, i3);
    }

    public void g(int i3, WidgetGroup widgetGroup) {
        ArrayList arrayList = this.f32470a;
        int size = arrayList.size();
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList.get(i4);
            i4++;
            ConstraintWidget constraintWidget = (ConstraintWidget) obj;
            widgetGroup.a(constraintWidget);
            if (i3 == 0) {
                constraintWidget.S0 = widgetGroup.c();
            } else {
                constraintWidget.T0 = widgetGroup.c();
            }
        }
        this.f32475f = widgetGroup.f32471b;
    }

    public void h(boolean z2) {
        this.f32472c = z2;
    }

    public void i(int i3) {
        this.f32473d = i3;
    }

    public String toString() {
        String str = e() + " [" + this.f32471b + "] <";
        ArrayList arrayList = this.f32470a;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            str = str + " " + ((ConstraintWidget) obj).v();
        }
        return str + " >";
    }
}
