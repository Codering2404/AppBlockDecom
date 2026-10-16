package cz.mobilesoft.coreblock.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import cz.mobilesoft.coreblock.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class ItemListSectionHeaderBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextView f96741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f96742b;

    private ItemListSectionHeaderBinding(TextView textView, TextView textView2) {
        this.f96741a = textView;
        this.f96742b = textView2;
    }

    public static ItemListSectionHeaderBinding a(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        TextView textView = (TextView) view;
        return new ItemListSectionHeaderBinding(textView, textView);
    }

    public static ItemListSectionHeaderBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.Y, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public TextView getRoot() {
        return this.f96741a;
    }
}
