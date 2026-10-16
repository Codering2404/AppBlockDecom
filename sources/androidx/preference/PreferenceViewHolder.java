package androidx.preference;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class PreferenceViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Drawable f50951b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ColorStateList f50952c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SparseArray f50953d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f50954e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f50955f;

    PreferenceViewHolder(View view) {
        super(view);
        SparseArray sparseArray = new SparseArray(4);
        this.f50953d = sparseArray;
        TextView textView = (TextView) view.findViewById(android.R.id.title);
        sparseArray.put(android.R.id.title, textView);
        sparseArray.put(android.R.id.summary, view.findViewById(android.R.id.summary));
        sparseArray.put(android.R.id.icon, view.findViewById(android.R.id.icon));
        int i3 = R.id.f50972a;
        sparseArray.put(i3, view.findViewById(i3));
        sparseArray.put(android.R.id.icon_frame, view.findViewById(android.R.id.icon_frame));
        this.f50951b = view.getBackground();
        if (textView != null) {
            this.f50952c = textView.getTextColors();
        }
    }

    public View b(int i3) {
        View view = (View) this.f50953d.get(i3);
        if (view != null) {
            return view;
        }
        View viewFindViewById = this.itemView.findViewById(i3);
        if (viewFindViewById != null) {
            this.f50953d.put(i3, viewFindViewById);
        }
        return viewFindViewById;
    }

    public boolean c() {
        return this.f50954e;
    }

    public boolean d() {
        return this.f50955f;
    }

    void e() {
        Drawable background = this.itemView.getBackground();
        Drawable drawable = this.f50951b;
        if (background != drawable) {
            ViewCompat.q0(this.itemView, drawable);
        }
        TextView textView = (TextView) b(android.R.id.title);
        if (textView == null || this.f50952c == null || textView.getTextColors().equals(this.f50952c)) {
            return;
        }
        textView.setTextColor(this.f50952c);
    }

    public void f(boolean z2) {
        this.f50954e = z2;
    }

    public void g(boolean z2) {
        this.f50955f = z2;
    }
}
