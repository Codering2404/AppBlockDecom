package androidx.work.impl.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.Preference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class PreferenceUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WorkDatabase f55161a;

    public PreferenceUtils(WorkDatabase workDatabase) {
        this.f55161a = workDatabase;
    }

    public static void d(Context context, SupportSQLiteDatabase supportSQLiteDatabase) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("androidx.work.util.preferences", 0);
        if (sharedPreferences.contains("reschedule_needed") || sharedPreferences.contains("last_cancel_all_time_ms")) {
            long j3 = sharedPreferences.getLong("last_cancel_all_time_ms", 0L);
            long j4 = sharedPreferences.getBoolean("reschedule_needed", false) ? 1L : 0L;
            supportSQLiteDatabase.H();
            try {
                supportSQLiteDatabase.u0("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"last_cancel_all_time_ms", Long.valueOf(j3)});
                supportSQLiteDatabase.u0("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"reschedule_needed", Long.valueOf(j4)});
                sharedPreferences.edit().clear().apply();
                supportSQLiteDatabase.t0();
            } finally {
                supportSQLiteDatabase.G0();
            }
        }
    }

    public long a() {
        Long lB = this.f55161a.o().b("last_cancel_all_time_ms");
        if (lB != null) {
            return lB.longValue();
        }
        return 0L;
    }

    public long b() {
        Long lB = this.f55161a.o().b("last_force_stop_ms");
        if (lB != null) {
            return lB.longValue();
        }
        return 0L;
    }

    public boolean c() {
        Long lB = this.f55161a.o().b("reschedule_needed");
        return lB != null && lB.longValue() == 1;
    }

    public void e(long j3) {
        this.f55161a.o().a(new Preference("last_cancel_all_time_ms", Long.valueOf(j3)));
    }

    public void f(long j3) {
        this.f55161a.o().a(new Preference("last_force_stop_ms", Long.valueOf(j3)));
    }

    public void g(boolean z2) {
        this.f55161a.o().a(new Preference("reschedule_needed", z2));
    }
}
