package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final zzic f73838a;

    zzhk(zzpg zzpgVar) {
        this.f73838a = zzpgVar.g0();
    }

    final boolean a() {
        try {
            zzic zzicVar = this.f73838a;
            PackageManagerWrapper packageManagerWrapperA = Wrappers.a(zzicVar.d());
            if (packageManagerWrapperA != null) {
                return packageManagerWrapperA.f("com.android.vending", ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD).versionCode >= 80837300;
            }
            zzicVar.a().w().a("Failed to get PackageManager for Install Referrer Play Store compatibility check");
            return false;
        } catch (Exception e3) {
            this.f73838a.a().w().b("Failed to retrieve Play Store version for Install Referrer", e3);
            return false;
        }
    }
}
