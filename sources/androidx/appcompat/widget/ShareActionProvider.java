package androidx.appcompat.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.view.ActionProvider;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class ShareActionProvider extends ActionProvider {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f2162d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ShareMenuItemOnMenuItemClickListener f2163e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Context f2164f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    String f2165g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    OnShareTargetSelectedListener f2166h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnShareTargetSelectedListener {
        boolean a(ShareActionProvider shareActionProvider, Intent intent);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class ShareActivityChooserModelPolicy implements ActivityChooserModel.OnChooseActivityListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ShareActionProvider f2167a;

        @Override // androidx.appcompat.widget.ActivityChooserModel.OnChooseActivityListener
        public boolean a(ActivityChooserModel activityChooserModel, Intent intent) {
            ShareActionProvider shareActionProvider = this.f2167a;
            OnShareTargetSelectedListener onShareTargetSelectedListener = shareActionProvider.f2166h;
            if (onShareTargetSelectedListener == null) {
                return false;
            }
            onShareTargetSelectedListener.a(shareActionProvider, intent);
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class ShareMenuItemOnMenuItemClickListener implements MenuItem.OnMenuItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ShareActionProvider f2168a;

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            ShareActionProvider shareActionProvider = this.f2168a;
            Intent intentB = ActivityChooserModel.d(shareActionProvider.f2164f, shareActionProvider.f2165g).b(menuItem.getItemId());
            if (intentB == null) {
                return true;
            }
            String action = intentB.getAction();
            if ("android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action)) {
                this.f2168a.l(intentB);
            }
            this.f2168a.f2164f.startActivity(intentB);
            return true;
        }
    }

    @Override // androidx.core.view.ActionProvider
    public boolean a() {
        return true;
    }

    @Override // androidx.core.view.ActionProvider
    public View c() {
        ActivityChooserView activityChooserView = new ActivityChooserView(this.f2164f);
        if (!activityChooserView.isInEditMode()) {
            activityChooserView.setActivityChooserModel(ActivityChooserModel.d(this.f2164f, this.f2165g));
        }
        TypedValue typedValue = new TypedValue();
        this.f2164f.getTheme().resolveAttribute(R.attr.f649j, typedValue, true);
        activityChooserView.setExpandActivityOverflowButtonDrawable(AppCompatResources.b(this.f2164f, typedValue.resourceId));
        activityChooserView.setProvider(this);
        activityChooserView.setDefaultActionButtonContentDescription(R.string.f798r);
        activityChooserView.setExpandActivityOverflowButtonContentDescription(R.string.f797q);
        return activityChooserView;
    }

    @Override // androidx.core.view.ActionProvider
    public void f(SubMenu subMenu) {
        subMenu.clear();
        ActivityChooserModel activityChooserModelD = ActivityChooserModel.d(this.f2164f, this.f2165g);
        PackageManager packageManager = this.f2164f.getPackageManager();
        int iF = activityChooserModelD.f();
        int iMin = Math.min(iF, this.f2162d);
        for (int i3 = 0; i3 < iMin; i3++) {
            ResolveInfo resolveInfoE = activityChooserModelD.e(i3);
            subMenu.add(0, i3, i3, resolveInfoE.loadLabel(packageManager)).setIcon(resolveInfoE.loadIcon(packageManager)).setOnMenuItemClickListener(this.f2163e);
        }
        if (iMin < iF) {
            SubMenu subMenuAddSubMenu = subMenu.addSubMenu(0, iMin, iMin, this.f2164f.getString(R.string.f782b));
            for (int i4 = 0; i4 < iF; i4++) {
                ResolveInfo resolveInfoE2 = activityChooserModelD.e(i4);
                subMenuAddSubMenu.add(0, i4, i4, resolveInfoE2.loadLabel(packageManager)).setIcon(resolveInfoE2.loadIcon(packageManager)).setOnMenuItemClickListener(this.f2163e);
            }
        }
    }

    void l(Intent intent) {
        intent.addFlags(134742016);
    }
}
