package cz.mobilesoft.coreblock.scene.more.help;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.base.activity.BaseActivitySurface;
import cz.mobilesoft.coreblock.databinding.ActivityDokiBinding;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
public class DokiActivity extends BaseActivitySurface<ActivityDokiBinding> {
    @Override // cz.mobilesoft.coreblock.base.activity.BaseAdsBaseActivity
    /* JADX INFO: renamed from: A0, reason: merged with bridge method [inline-methods] */
    public ActivityDokiBinding o0(LayoutInflater layoutInflater) {
        return ActivityDokiBinding.c(layoutInflater);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseActivitySurface
    protected String v0() {
        return getString(R.string.Qo);
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseActivitySurface, cz.mobilesoft.coreblock.base.activity.BaseAdsBaseActivity
    /* JADX INFO: renamed from: z0, reason: merged with bridge method [inline-methods] */
    public void l0(ActivityDokiBinding activityDokiBinding, Bundle bundle) {
        super.l0(activityDokiBinding, bundle);
        findViewById(dev.doubledot.doki.R.id.buttonContainer).setVisibility(8);
        if (getSupportActionBar() != null) {
            getSupportActionBar().t(true);
            getSupportActionBar().x(R.drawable.C1);
        }
        activityDokiBinding.f96458b.loadContent(Build.MANUFACTURER.toLowerCase().replace(" ", "-"));
    }
}
