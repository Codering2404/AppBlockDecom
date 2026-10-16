package androidx.preference;

import android.content.Context;
import android.util.AttributeSet;
import androidx.core.content.res.TypedArrayUtils;
import androidx.preference.PreferenceManager;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class PreferenceScreen extends PreferenceGroup {
    private boolean Z;

    public PreferenceScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, TypedArrayUtils.a(context, R.attr.f50963h, android.R.attr.preferenceScreenStyle));
        this.Z = true;
    }

    @Override // androidx.preference.PreferenceGroup
    protected boolean J0() {
        return false;
    }

    public boolean O0() {
        return this.Z;
    }

    @Override // androidx.preference.Preference
    protected void R() {
        PreferenceManager.OnNavigateToScreenListener onNavigateToScreenListenerF;
        if (n() != null || k() != null || I0() == 0 || (onNavigateToScreenListenerF = w().f()) == null) {
            return;
        }
        onNavigateToScreenListenerF.g(this);
    }
}
