package com.facebook.ads.redexgen.core;

import android.os.Build;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.1J, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1J extends C7M {
    public static String[] A00 = {"4mrgyhu5NuMSfoRJ7wvth", "0QrbVGKHuGc2eSGsbm7N10peHve4GVgP", "Meba3O6SWeMBrZzPyfP10SBJe7jX", "3Oa5wanHMWuCrkjHvXNfwyLB0ZtCKHr4", "YOQh7xYBrfW2123ECT3lDkRgUFpenV07", "JuO7BKBrPjkMVs4", "5m", "UWhmaXdvjdchgK72Wd2HML9QO634NCpp"};

    public C1J(C1648gi c1648gi) {
        super(c1648gi);
        setCarouselLayoutManager(c1648gi);
    }

    public AbstractC0719Ft getFullscreenCarouselRecyclerViewAdapter() {
        getAdapter();
        if (0 != 0) {
            getAdapter();
            return null;
        }
        if (A00[6].length() != 2) {
            throw new RuntimeException();
        }
        A00[2] = "XAsjP5XwQSgGjSaOGRXjEIyXW47w";
        return null;
    }

    @Override // com.facebook.ads.redexgen.core.C7M
    public C1718hr getLayoutManager() {
        return (C1718hr) super.getLayoutManager();
    }

    public R7 getOnScrollListener() {
        return new PY(this);
    }

    private void setCarouselLayoutManager(C1648gi c1648gi) {
        C1718hr c1718hr = new C1718hr(c1648gi, 0, false);
        if (Build.VERSION.SDK_INT >= 24) {
            c1718hr.A1T(true);
        }
        super.setLayoutManager(c1718hr);
    }

    @Override // com.facebook.ads.redexgen.core.C7M
    public void setLayoutManager(R2 r2) {
    }
}
