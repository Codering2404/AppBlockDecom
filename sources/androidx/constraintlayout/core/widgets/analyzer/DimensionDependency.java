package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class DimensionDependency extends DependencyNode {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f32452m;

    DimensionDependency(WidgetRun widgetRun) {
        super(widgetRun);
        if (widgetRun instanceof HorizontalWidgetRun) {
            this.f32435e = DependencyNode.Type.HORIZONTAL_DIMENSION;
        } else {
            this.f32435e = DependencyNode.Type.VERTICAL_DIMENSION;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.DependencyNode
    public void d(int i3) {
        if (this.f32440j) {
            return;
        }
        this.f32440j = true;
        this.f32437g = i3;
        for (Dependency dependency : this.f32441k) {
            dependency.a(dependency);
        }
    }
}
