package cz.mobilesoft.coreblock.storage.sharedprefs;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
public class PreferencesHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f126900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SharedPreferences f126901b;

    public PreferencesHolder(SharedPreferences sharedPreferences, Context context) {
        this.f126901b = sharedPreferences;
        this.f126900a = context;
    }

    public boolean a(String str, boolean z2) {
        return this.f126901b.getBoolean(str, z2);
    }

    public Context b() {
        return this.f126900a;
    }

    public int c(String str, int i3) {
        return this.f126901b.getInt(str, i3);
    }

    public long d(String str, long j3) {
        return this.f126901b.getLong(str, j3);
    }

    public String e(String str, String str2) {
        return this.f126901b.getString(str, str2);
    }

    public Set f(String str, Set set) {
        return this.f126901b.getStringSet(str, set);
    }

    public SharedPreferences.Editor g(String str, boolean z2) {
        return this.f126901b.edit().putBoolean(str, z2);
    }

    public SharedPreferences.Editor h(String str, int i3) {
        return this.f126901b.edit().putInt(str, i3);
    }

    public SharedPreferences.Editor i(String str, long j3) {
        return this.f126901b.edit().putLong(str, j3);
    }

    public SharedPreferences.Editor j(String str, String str2) {
        return this.f126901b.edit().putString(str, str2);
    }

    public SharedPreferences.Editor k(String str, Set set) {
        return this.f126901b.edit().putStringSet(str, set);
    }
}
