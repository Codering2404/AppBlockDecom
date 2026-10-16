package cz.mobilesoft.coreblock.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import cz.mobilesoft.coreblock.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class DialogRichEditTextBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FrameLayout f96530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f96531b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f96532c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final EditText f96533d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f96534e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f96535f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ProgressBar f96536g;

    private DialogRichEditTextBinding(FrameLayout frameLayout, ImageView imageView, TextView textView, EditText editText, TextView textView2, TextView textView3, ProgressBar progressBar) {
        this.f96530a = frameLayout;
        this.f96531b = imageView;
        this.f96532c = textView;
        this.f96533d = editText;
        this.f96534e = textView2;
        this.f96535f = textView3;
        this.f96536g = progressBar;
    }

    public static DialogRichEditTextBinding a(View view) {
        int i3 = R.id.E;
        ImageView imageView = (ImageView) ViewBindings.a(view, i3);
        if (imageView != null) {
            i3 = R.id.R;
            TextView textView = (TextView) ViewBindings.a(view, i3);
            if (textView != null) {
                i3 = R.id.f95622i0;
                EditText editText = (EditText) ViewBindings.a(view, i3);
                if (editText != null) {
                    i3 = R.id.f95646o0;
                    TextView textView2 = (TextView) ViewBindings.a(view, i3);
                    if (textView2 != null) {
                        i3 = R.id.T0;
                        TextView textView3 = (TextView) ViewBindings.a(view, i3);
                        if (textView3 != null) {
                            i3 = R.id.F1;
                            ProgressBar progressBar = (ProgressBar) ViewBindings.a(view, i3);
                            if (progressBar != null) {
                                return new DialogRichEditTextBinding((FrameLayout) view, imageView, textView, editText, textView2, textView3, progressBar);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static DialogRichEditTextBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static DialogRichEditTextBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.f95718r, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f96530a;
    }
}
