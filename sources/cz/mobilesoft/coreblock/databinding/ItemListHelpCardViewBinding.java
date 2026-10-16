package cz.mobilesoft.coreblock.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.view.stack.HelpCardView;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class ItemListHelpCardViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HelpCardView f96729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HelpCardView f96730b;

    private ItemListHelpCardViewBinding(HelpCardView helpCardView, HelpCardView helpCardView2) {
        this.f96729a = helpCardView;
        this.f96730b = helpCardView2;
    }

    public static ItemListHelpCardViewBinding a(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        HelpCardView helpCardView = (HelpCardView) view;
        return new ItemListHelpCardViewBinding(helpCardView, helpCardView);
    }

    public static ItemListHelpCardViewBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.T, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public HelpCardView getRoot() {
        return this.f96729a;
    }
}
