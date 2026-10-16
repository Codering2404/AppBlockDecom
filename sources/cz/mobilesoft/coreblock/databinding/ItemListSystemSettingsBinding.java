package cz.mobilesoft.coreblock.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import cz.mobilesoft.coreblock.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class ItemListSystemSettingsBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextView f96747a;

    private ItemListSystemSettingsBinding(TextView textView) {
        this.f96747a = textView;
    }

    public static ItemListSystemSettingsBinding a(View view) {
        if (view != null) {
            return new ItemListSystemSettingsBinding((TextView) view);
        }
        throw new NullPointerException("rootView");
    }

    public static ItemListSystemSettingsBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.f95687b0, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public TextView getRoot() {
        return this.f96747a;
    }
}
