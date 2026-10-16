package com.jakewharton.threetenabp;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import org.threeten.bp.zone.TzdbZoneRulesProvider;
import org.threeten.bp.zone.ZoneRulesInitializer;
import org.threeten.bp.zone.ZoneRulesProvider;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class AssetsZoneRulesInitializer extends ZoneRulesInitializer {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Context f92234d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f92235e;

    AssetsZoneRulesInitializer(Context context, String str) {
        this.f92234d = context;
        this.f92235e = str;
    }

    @Override // org.threeten.bp.zone.ZoneRulesInitializer
    protected void b() {
        InputStream inputStreamOpen = null;
        try {
            try {
                inputStreamOpen = this.f92234d.getAssets().open(this.f92235e);
                TzdbZoneRulesProvider tzdbZoneRulesProvider = new TzdbZoneRulesProvider(inputStreamOpen);
                if (inputStreamOpen != null) {
                    try {
                        inputStreamOpen.close();
                    } catch (IOException unused) {
                    }
                }
                ZoneRulesProvider.f(tzdbZoneRulesProvider);
            } catch (IOException e3) {
                throw new IllegalStateException(this.f92235e + " missing from assets", e3);
            }
        } catch (Throwable th) {
            if (inputStreamOpen != null) {
                try {
                    inputStreamOpen.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }
}
