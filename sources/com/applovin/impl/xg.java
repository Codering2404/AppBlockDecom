package com.applovin.impl;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.view.WindowManager;
import com.applovin.impl.sdk.ad.b;
import com.applovin.sdk.AppLovinSdkUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class xg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Activity f64976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f64977b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f64978c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f64979d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f64980e;

    public xg(Activity activity) {
        this.f64976a = activity;
        int iC = yp.c(activity);
        this.f64978c = iC;
        boolean zIsTablet = AppLovinSdkUtils.isTablet(activity);
        this.f64979d = zIsTablet;
        this.f64977b = a(iC, zIsTablet);
        this.f64980e = zIsTablet && 2 == a(activity);
    }

    private int a(int i3, boolean z2) {
        if (z2 && this.f64980e) {
            if (i3 == 0) {
                return 0;
            }
            if (i3 == 1) {
                return 9;
            }
            if (i3 == 2) {
                return 8;
            }
            return i3 == 3 ? 1 : -1;
        }
        if (i3 == 0) {
            return 1;
        }
        if (i3 == 1) {
            return 0;
        }
        if (i3 == 2) {
            return 9;
        }
        return i3 == 3 ? 8 : -1;
    }

    private static int a(Context context) {
        Configuration configuration = context.getResources().getConfiguration();
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        return (((rotation == 0 || rotation == 2) && configuration.orientation == 2) || ((rotation == 1 || rotation == 3) && configuration.orientation == 1)) ? 2 : 1;
    }

    public void a(com.applovin.impl.sdk.ad.b bVar) {
        int i3;
        if (bVar.F0() && (i3 = this.f64977b) != -1) {
            a(i3);
        } else {
            a(bVar.f0());
        }
    }

    private void a(b.c cVar) {
        if (cVar == b.c.ACTIVITY_PORTRAIT) {
            if (this.f64979d && this.f64980e) {
                int i3 = this.f64978c;
                if (i3 != 1 && i3 != 3) {
                    a(1);
                    return;
                } else if (i3 == 1) {
                    a(9);
                    return;
                } else {
                    a(1);
                    return;
                }
            }
            int i4 = this.f64978c;
            if (i4 != 0 && i4 != 2) {
                a(1);
                return;
            } else {
                a(i4 != 0 ? 9 : 1);
                return;
            }
        }
        if (cVar == b.c.ACTIVITY_LANDSCAPE) {
            if (this.f64979d && this.f64980e) {
                int i5 = this.f64978c;
                if (i5 != 0 && i5 != 2) {
                    a(0);
                    return;
                } else {
                    a(i5 != 2 ? 0 : 8);
                    return;
                }
            }
            int i6 = this.f64978c;
            if (i6 != 1 && i6 != 3) {
                a(0);
            } else {
                a(i6 == 1 ? 0 : 8);
            }
        }
    }

    private void a(int i3) {
        try {
            this.f64976a.setRequestedOrientation(i3);
        } catch (Throwable unused) {
        }
    }
}
