package androidx.preference;

import android.content.Context;
import android.util.AttributeSet;
import androidx.core.content.res.TypedArrayUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class PreferenceCategory extends PreferenceGroup {
    public PreferenceCategory(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
    }

    @Override // androidx.preference.Preference
    public boolean D() {
        return false;
    }

    @Override // androidx.preference.Preference
    public void Q(PreferenceViewHolder preferenceViewHolder) {
        super.Q(preferenceViewHolder);
        preferenceViewHolder.itemView.setAccessibilityHeading(true);
    }

    @Override // androidx.preference.Preference
    public boolean x0() {
        return !super.D();
    }

    public PreferenceCategory(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public PreferenceCategory(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.a(context, R.attr.f50960e, android.R.attr.preferenceCategoryStyle));
    }
}
