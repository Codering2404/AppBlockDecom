package com.jakewharton.threetenabp;

import android.app.Application;
import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;
import org.threeten.bp.zone.ZoneRulesInitializer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class AndroidThreeTen {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicBoolean f92233a = new AtomicBoolean();

    public static void a(Application application) {
        b(application);
    }

    public static void b(Context context) {
        c(context, "org/threeten/bp/TZDB.dat");
    }

    public static void c(Context context, String str) {
        if (f92233a.getAndSet(true)) {
            return;
        }
        ZoneRulesInitializer.c(new AssetsZoneRulesInitializer(context, str));
    }
}
