package androidx.appcompat.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import androidx.appcompat.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class ActionBarPolicy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f1263a;

    private ActionBarPolicy(Context context) {
        this.f1263a = context;
    }

    public static ActionBarPolicy b(Context context) {
        return new ActionBarPolicy(context);
    }

    public boolean a() {
        return this.f1263a.getApplicationInfo().targetSdkVersion < 14;
    }

    public int c() {
        return this.f1263a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public int d() {
        Configuration configuration = this.f1263a.getResources().getConfiguration();
        int i3 = configuration.screenWidthDp;
        int i4 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i3 > 600) {
            return 5;
        }
        if (i3 > 960 && i4 > 720) {
            return 5;
        }
        if (i3 > 720 && i4 > 960) {
            return 5;
        }
        if (i3 >= 500) {
            return 4;
        }
        if (i3 > 640 && i4 > 480) {
            return 4;
        }
        if (i3 <= 480 || i4 <= 640) {
            return i3 >= 360 ? 3 : 2;
        }
        return 4;
    }

    public int e() {
        return this.f1263a.getResources().getDimensionPixelSize(R.dimen.f693b);
    }

    public int f() {
        TypedArray typedArrayObtainStyledAttributes = this.f1263a.obtainStyledAttributes(null, R.styleable.f805a, R.attr.f635c, 0);
        int layoutDimension = typedArrayObtainStyledAttributes.getLayoutDimension(R.styleable.f841j, 0);
        Resources resources = this.f1263a.getResources();
        if (!g()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(R.dimen.f692a));
        }
        typedArrayObtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public boolean g() {
        return this.f1263a.getResources().getBoolean(R.bool.f683a);
    }

    public boolean h() {
        return true;
    }
}
