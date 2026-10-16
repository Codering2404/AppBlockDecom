package cz.mobilesoft.coreblock.databinding;

import android.view.View;
import android.widget.Spinner;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.MaterialToolbar;
import cz.mobilesoft.coreblock.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class LayoutStatisticsToolbarBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MaterialToolbar f96827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MaterialToolbar f96828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Spinner f96829c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Spinner f96830d;

    private LayoutStatisticsToolbarBinding(MaterialToolbar materialToolbar, MaterialToolbar materialToolbar2, Spinner spinner, Spinner spinner2) {
        this.f96827a = materialToolbar;
        this.f96828b = materialToolbar2;
        this.f96829c = spinner;
        this.f96830d = spinner2;
    }

    public static LayoutStatisticsToolbarBinding a(View view) {
        MaterialToolbar materialToolbar = (MaterialToolbar) view;
        int i3 = R.id.f95624i2;
        Spinner spinner = (Spinner) ViewBindings.a(view, i3);
        if (spinner != null) {
            i3 = R.id.u2;
            Spinner spinner2 = (Spinner) ViewBindings.a(view, i3);
            if (spinner2 != null) {
                return new LayoutStatisticsToolbarBinding(materialToolbar, materialToolbar, spinner, spinner2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public MaterialToolbar getRoot() {
        return this.f96827a;
    }
}
