package cz.mobilesoft.coreblock.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import cz.mobilesoft.coreblock.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class FragmentBackupCreateBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final NestedScrollView f96602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Button f96603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f96604c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f96605d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final NestedScrollView f96606e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f96607f;

    private FragmentBackupCreateBinding(NestedScrollView nestedScrollView, Button button, TextView textView, ImageView imageView, NestedScrollView nestedScrollView2, TextView textView2) {
        this.f96602a = nestedScrollView;
        this.f96603b = button;
        this.f96604c = textView;
        this.f96605d = imageView;
        this.f96606e = nestedScrollView2;
        this.f96607f = textView2;
    }

    public static FragmentBackupCreateBinding a(View view) {
        int i3 = R.id.f95649p;
        Button button = (Button) ViewBindings.a(view, i3);
        if (button != null) {
            i3 = R.id.X;
            TextView textView = (TextView) ViewBindings.a(view, i3);
            if (textView != null) {
                i3 = R.id.R0;
                ImageView imageView = (ImageView) ViewBindings.a(view, i3);
                if (imageView != null) {
                    NestedScrollView nestedScrollView = (NestedScrollView) view;
                    i3 = R.id.f95628j2;
                    TextView textView2 = (TextView) ViewBindings.a(view, i3);
                    if (textView2 != null) {
                        return new FragmentBackupCreateBinding(nestedScrollView, button, textView, imageView, nestedScrollView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static FragmentBackupCreateBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.f95732z, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public NestedScrollView getRoot() {
        return this.f96602a;
    }
}
