package com.google.firebase.installations;

import android.text.TextUtils;
import com.google.firebase.installations.local.PersistedInstallationEntry;
import com.google.firebase.installations.time.Clock;
import com.google.firebase.installations.time.SystemClock;
import com.revenuecat.purchases.common.Constants;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class Utils {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f89251b = TimeUnit.HOURS.toSeconds(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Pattern f89252c = Pattern.compile("\\AA[\\w-]{38}\\z");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Utils f89253d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Clock f89254a;

    private Utils(Clock clock) {
        this.f89254a = clock;
    }

    public static Utils c() {
        return d(SystemClock.a());
    }

    public static Utils d(Clock clock) {
        if (f89253d == null) {
            f89253d = new Utils(clock);
        }
        return f89253d;
    }

    static boolean g(String str) {
        return f89252c.matcher(str).matches();
    }

    static boolean h(String str) {
        return str.contains(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
    }

    public long a() {
        return this.f89254a.currentTimeMillis();
    }

    public long b() {
        return TimeUnit.MILLISECONDS.toSeconds(a());
    }

    public long e() {
        return (long) (Math.random() * 1000.0d);
    }

    public boolean f(PersistedInstallationEntry persistedInstallationEntry) {
        return TextUtils.isEmpty(persistedInstallationEntry.b()) || persistedInstallationEntry.h() + persistedInstallationEntry.c() < b() + f89251b;
    }
}
