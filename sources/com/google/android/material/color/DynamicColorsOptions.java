package com.google.android.material.color;

import android.app.Activity;
import com.google.android.material.color.DynamicColors;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class DynamicColorsOptions {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final DynamicColors.Precondition f80580e = new DynamicColors.Precondition() { // from class: com.google.android.material.color.DynamicColorsOptions.1
        @Override // com.google.android.material.color.DynamicColors.Precondition
        public boolean a(Activity activity, int i3) {
            return true;
        }
    };

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final DynamicColors.OnAppliedCallback f80581f = new DynamicColors.OnAppliedCallback() { // from class: com.google.android.material.color.DynamicColorsOptions.2
        @Override // com.google.android.material.color.DynamicColors.OnAppliedCallback
        public void a(Activity activity) {
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f80582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DynamicColors.Precondition f80583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final DynamicColors.OnAppliedCallback f80584c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Integer f80585d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder {
    }

    public Integer a() {
        return this.f80585d;
    }

    public DynamicColors.OnAppliedCallback b() {
        return this.f80584c;
    }

    public DynamicColors.Precondition c() {
        return this.f80583b;
    }

    public int d() {
        return this.f80582a;
    }
}
