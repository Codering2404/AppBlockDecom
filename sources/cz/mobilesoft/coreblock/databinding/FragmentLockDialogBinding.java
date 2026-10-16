package cz.mobilesoft.coreblock.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import cz.mobilesoft.coreblock.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class FragmentLockDialogBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ScrollView f96669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f96670b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CheckBox f96671c;

    private FragmentLockDialogBinding(ScrollView scrollView, TextView textView, CheckBox checkBox) {
        this.f96669a = scrollView;
        this.f96670b = textView;
        this.f96671c = checkBox;
    }

    public static FragmentLockDialogBinding a(View view) {
        int i3 = R.id.f95599c1;
        TextView textView = (TextView) ViewBindings.a(view, i3);
        if (textView != null) {
            i3 = R.id.f95635l1;
            CheckBox checkBox = (CheckBox) ViewBindings.a(view, i3);
            if (checkBox != null) {
                return new FragmentLockDialogBinding((ScrollView) view, textView, checkBox);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static FragmentLockDialogBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.M, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ScrollView getRoot() {
        return this.f96669a;
    }
}
