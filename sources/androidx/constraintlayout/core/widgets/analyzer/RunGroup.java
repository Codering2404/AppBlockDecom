package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class RunGroup {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f32458h;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    WidgetRun f32461c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    WidgetRun f32462d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f32464f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f32465g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f32459a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f32460b = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    ArrayList f32463e = new ArrayList();

    RunGroup(WidgetRun widgetRun, int i3) {
        this.f32461c = null;
        this.f32462d = null;
        int i4 = f32458h;
        this.f32464f = i4;
        f32458h = i4 + 1;
        this.f32461c = widgetRun;
        this.f32462d = widgetRun;
        this.f32465g = i3;
    }

    private long c(DependencyNode dependencyNode, long j3) {
        WidgetRun widgetRun = dependencyNode.f32434d;
        if (widgetRun instanceof HelperReferences) {
            return j3;
        }
        int size = dependencyNode.f32441k.size();
        long jMin = j3;
        for (int i3 = 0; i3 < size; i3++) {
            Dependency dependency = (Dependency) dependencyNode.f32441k.get(i3);
            if (dependency instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dependency;
                if (dependencyNode2.f32434d != widgetRun) {
                    jMin = Math.min(jMin, c(dependencyNode2, ((long) dependencyNode2.f32436f) + j3));
                }
            }
        }
        if (dependencyNode != widgetRun.f32491i) {
            return jMin;
        }
        long j4 = j3 - widgetRun.j();
        return Math.min(Math.min(jMin, c(widgetRun.f32490h, j4)), j4 - ((long) widgetRun.f32490h.f32436f));
    }

    private long d(DependencyNode dependencyNode, long j3) {
        WidgetRun widgetRun = dependencyNode.f32434d;
        if (widgetRun instanceof HelperReferences) {
            return j3;
        }
        int size = dependencyNode.f32441k.size();
        long jMax = j3;
        for (int i3 = 0; i3 < size; i3++) {
            Dependency dependency = (Dependency) dependencyNode.f32441k.get(i3);
            if (dependency instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dependency;
                if (dependencyNode2.f32434d != widgetRun) {
                    jMax = Math.max(jMax, d(dependencyNode2, ((long) dependencyNode2.f32436f) + j3));
                }
            }
        }
        if (dependencyNode != widgetRun.f32490h) {
            return jMax;
        }
        long j4 = j3 + widgetRun.j();
        return Math.max(Math.max(jMax, d(widgetRun.f32491i, j4)), j4 - ((long) widgetRun.f32491i.f32436f));
    }

    public void a(WidgetRun widgetRun) {
        this.f32463e.add(widgetRun);
        this.f32462d = widgetRun;
    }

    public long b(ConstraintWidgetContainer constraintWidgetContainer, int i3) {
        long j3;
        int i4;
        WidgetRun widgetRun = this.f32461c;
        if (widgetRun instanceof ChainRun) {
            if (((ChainRun) widgetRun).f32488f != i3) {
                return 0L;
            }
        } else if (i3 == 0) {
            if (!(widgetRun instanceof HorizontalWidgetRun)) {
                return 0L;
            }
        } else if (!(widgetRun instanceof VerticalWidgetRun)) {
            return 0L;
        }
        DependencyNode dependencyNode = (i3 == 0 ? constraintWidgetContainer.f32279e : constraintWidgetContainer.f32281f).f32490h;
        DependencyNode dependencyNode2 = (i3 == 0 ? constraintWidgetContainer.f32279e : constraintWidgetContainer.f32281f).f32491i;
        boolean zContains = widgetRun.f32490h.f32442l.contains(dependencyNode);
        boolean zContains2 = this.f32461c.f32491i.f32442l.contains(dependencyNode2);
        long j4 = this.f32461c.j();
        if (zContains && zContains2) {
            long jD = d(this.f32461c.f32490h, 0L);
            long jC = c(this.f32461c.f32491i, 0L);
            long j5 = jD - j4;
            WidgetRun widgetRun2 = this.f32461c;
            int i5 = widgetRun2.f32491i.f32436f;
            if (j5 >= (-i5)) {
                j5 += (long) i5;
            }
            int i6 = widgetRun2.f32490h.f32436f;
            long j6 = ((-jC) - j4) - ((long) i6);
            if (j6 >= i6) {
                j6 -= (long) i6;
            }
            float fS = widgetRun2.f32484b.s(i3);
            float f3 = fS > 0.0f ? (long) ((j6 / fS) + (j5 / (1.0f - fS))) : 0L;
            long j7 = ((long) ((f3 * fS) + 0.5f)) + j4 + ((long) ((f3 * (1.0f - fS)) + 0.5f));
            WidgetRun widgetRun3 = this.f32461c;
            j3 = ((long) widgetRun3.f32490h.f32436f) + j7;
            i4 = widgetRun3.f32491i.f32436f;
        } else {
            if (zContains) {
                return Math.max(d(this.f32461c.f32490h, r12.f32436f), ((long) this.f32461c.f32490h.f32436f) + j4);
            }
            if (zContains2) {
                return Math.max(-c(this.f32461c.f32491i, r12.f32436f), ((long) (-this.f32461c.f32491i.f32436f)) + j4);
            }
            WidgetRun widgetRun4 = this.f32461c;
            j3 = ((long) widgetRun4.f32490h.f32436f) + widgetRun4.j();
            i4 = this.f32461c.f32491i.f32436f;
        }
        return j3 - ((long) i4);
    }
}
