package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
class TooltipPopup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f2339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final View f2340b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TextView f2341c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final WindowManager.LayoutParams f2342d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Rect f2343e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int[] f2344f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int[] f2345g;

    TooltipPopup(Context context) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f2342d = layoutParams;
        this.f2343e = new Rect();
        this.f2344f = new int[2];
        this.f2345g = new int[2];
        this.f2339a = context;
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.f779u, (ViewGroup) null);
        this.f2340b = viewInflate;
        this.f2341c = (TextView) viewInflate.findViewById(R.id.f757y);
        layoutParams.setTitle(getClass().getSimpleName());
        layoutParams.packageName = context.getPackageName();
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = R.style.f799a;
        layoutParams.flags = 24;
    }

    private void a(View view, int i3, int i4, boolean z2, WindowManager.LayoutParams layoutParams) {
        int height;
        int i5;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = this.f2339a.getResources().getDimensionPixelOffset(R.dimen.f704m);
        if (view.getWidth() < dimensionPixelOffset) {
            i3 = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = this.f2339a.getResources().getDimensionPixelOffset(R.dimen.f703l);
            height = i4 + dimensionPixelOffset2;
            i5 = i4 - dimensionPixelOffset2;
        } else {
            height = view.getHeight();
            i5 = 0;
        }
        layoutParams.gravity = 49;
        int dimensionPixelOffset3 = this.f2339a.getResources().getDimensionPixelOffset(z2 ? R.dimen.f706o : R.dimen.f705n);
        View viewB = b(view);
        if (viewB == null) {
            Log.e("TooltipPopup", "Cannot find app view");
            return;
        }
        viewB.getWindowVisibleDisplayFrame(this.f2343e);
        Rect rect = this.f2343e;
        if (rect.left < 0 && rect.top < 0) {
            Resources resources = this.f2339a.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            this.f2343e.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        viewB.getLocationOnScreen(this.f2345g);
        view.getLocationOnScreen(this.f2344f);
        int[] iArr = this.f2344f;
        int i6 = iArr[0];
        int[] iArr2 = this.f2345g;
        int i7 = i6 - iArr2[0];
        iArr[0] = i7;
        iArr[1] = iArr[1] - iArr2[1];
        layoutParams.x = (i7 + i3) - (viewB.getWidth() / 2);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f2340b.measure(iMakeMeasureSpec, iMakeMeasureSpec);
        int measuredHeight = this.f2340b.getMeasuredHeight();
        int i8 = this.f2344f[1];
        int i9 = ((i5 + i8) - dimensionPixelOffset3) - measuredHeight;
        int i10 = i8 + height + dimensionPixelOffset3;
        if (z2) {
            if (i9 >= 0) {
                layoutParams.y = i9;
                return;
            } else {
                layoutParams.y = i10;
                return;
            }
        }
        if (measuredHeight + i10 <= this.f2343e.height()) {
            layoutParams.y = i10;
        } else {
            layoutParams.y = i9;
        }
    }

    private static View b(View view) {
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if (!(layoutParams instanceof WindowManager.LayoutParams) || ((WindowManager.LayoutParams) layoutParams).type != 2) {
            for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
                if (context instanceof Activity) {
                    return ((Activity) context).getWindow().getDecorView();
                }
            }
        }
        return rootView;
    }

    void c() {
        if (d()) {
            ((WindowManager) this.f2339a.getSystemService("window")).removeView(this.f2340b);
        }
    }

    boolean d() {
        return this.f2340b.getParent() != null;
    }

    void e(View view, int i3, int i4, boolean z2, CharSequence charSequence) {
        if (d()) {
            c();
        }
        this.f2341c.setText(charSequence);
        a(view, i3, i4, z2, this.f2342d);
        ((WindowManager) this.f2339a.getSystemService("window")).addView(this.f2340b, this.f2342d);
    }
}
