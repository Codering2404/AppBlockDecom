package androidx.browser.customtabs;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public final class CustomTabColorSchemeParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f2589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f2590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f2591c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f2592d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Integer f2593a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Integer f2594b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Integer f2595c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Integer f2596d;

        public CustomTabColorSchemeParams a() {
            return new CustomTabColorSchemeParams(this.f2593a, this.f2594b, this.f2595c, this.f2596d);
        }

        public Builder b(int i3) {
            this.f2593a = Integer.valueOf(i3 | (-16777216));
            return this;
        }
    }

    CustomTabColorSchemeParams(Integer num, Integer num2, Integer num3, Integer num4) {
        this.f2589a = num;
        this.f2590b = num2;
        this.f2591c = num3;
        this.f2592d = num4;
    }

    Bundle a() {
        Bundle bundle = new Bundle();
        Integer num = this.f2589a;
        if (num != null) {
            bundle.putInt("android.support.customtabs.extra.TOOLBAR_COLOR", num.intValue());
        }
        Integer num2 = this.f2590b;
        if (num2 != null) {
            bundle.putInt("android.support.customtabs.extra.SECONDARY_TOOLBAR_COLOR", num2.intValue());
        }
        Integer num3 = this.f2591c;
        if (num3 != null) {
            bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_COLOR", num3.intValue());
        }
        Integer num4 = this.f2592d;
        if (num4 != null) {
            bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_DIVIDER_COLOR", num4.intValue());
        }
        return bundle;
    }
}
