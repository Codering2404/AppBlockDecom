package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.InstallIdProvider;
import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorkers;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.installations.InstallationTokenResult;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class IdManager implements InstallIdProvider {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Pattern f88438g = Pattern.compile("[^\\p{Alnum}]");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f88439h = Pattern.quote("/");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InstallerPackageNameProvider f88440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f88441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f88442c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final FirebaseInstallationsApi f88443d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final DataCollectionArbiter f88444e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private InstallIdProvider.InstallIds f88445f;

    public IdManager(Context context, String str, FirebaseInstallationsApi firebaseInstallationsApi, DataCollectionArbiter dataCollectionArbiter) {
        if (context == null) {
            throw new IllegalArgumentException("appContext must not be null");
        }
        if (str == null) {
            throw new IllegalArgumentException("appIdentifier must not be null");
        }
        this.f88441b = context;
        this.f88442c = str;
        this.f88443d = firebaseInstallationsApi;
        this.f88444e = dataCollectionArbiter;
        this.f88440a = new InstallerPackageNameProvider();
    }

    private synchronized String b(String str, SharedPreferences sharedPreferences) {
        String strE;
        strE = e(UUID.randomUUID().toString());
        Logger.f().i("Created new Crashlytics installation ID: " + strE + " for FID: " + str);
        sharedPreferences.edit().putString("crashlytics.installation.id", strE).putString("firebase.installation.id", str).apply();
        return strE;
    }

    static String c() {
        return "SYN_" + UUID.randomUUID().toString();
    }

    private static String e(String str) {
        return f88438g.matcher(str).replaceAll("").toLowerCase(Locale.US);
    }

    static boolean k(String str) {
        return str != null && str.startsWith("SYN_");
    }

    private String l(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString("crashlytics.installation.id", null);
    }

    private String m(String str) {
        return str.replaceAll(f88439h, "");
    }

    private boolean n() {
        InstallIdProvider.InstallIds installIds = this.f88445f;
        if (installIds != null) {
            return installIds.e() == null && this.f88444e.d();
        }
        return true;
    }

    @Override // com.google.firebase.crashlytics.internal.common.InstallIdProvider
    public synchronized InstallIdProvider.InstallIds a() {
        if (!n()) {
            return this.f88445f;
        }
        Logger.f().i("Determining Crashlytics installation ID...");
        SharedPreferences sharedPreferencesQ = CommonUtils.q(this.f88441b);
        String string = sharedPreferencesQ.getString("firebase.installation.id", null);
        Logger.f().i("Cached Firebase Installation ID: " + string);
        if (this.f88444e.d()) {
            FirebaseInstallationId firebaseInstallationIdD = d(false);
            Logger.f().i("Fetched Firebase Installation ID: " + firebaseInstallationIdD.b());
            if (firebaseInstallationIdD.b() == null) {
                firebaseInstallationIdD = new FirebaseInstallationId(string == null ? c() : string, null);
            }
            if (Objects.equals(firebaseInstallationIdD.b(), string)) {
                this.f88445f = InstallIdProvider.InstallIds.a(l(sharedPreferencesQ), firebaseInstallationIdD);
            } else {
                this.f88445f = InstallIdProvider.InstallIds.a(b(firebaseInstallationIdD.b(), sharedPreferencesQ), firebaseInstallationIdD);
            }
        } else if (k(string)) {
            this.f88445f = InstallIdProvider.InstallIds.b(l(sharedPreferencesQ));
        } else {
            this.f88445f = InstallIdProvider.InstallIds.b(b(c(), sharedPreferencesQ));
        }
        Logger.f().i("Install IDs: " + this.f88445f);
        return this.f88445f;
    }

    public FirebaseInstallationId d(boolean z2) {
        String strB;
        CrashlyticsWorkers.e();
        String str = null;
        if (z2) {
            try {
                strB = ((InstallationTokenResult) Tasks.await(this.f88443d.a(false), 10000L, TimeUnit.MILLISECONDS)).b();
            } catch (Exception e3) {
                Logger.f().l("Error getting Firebase authentication token.", e3);
                strB = null;
            }
        } else {
            strB = null;
        }
        try {
            str = (String) Tasks.await(this.f88443d.getId(), 10000L, TimeUnit.MILLISECONDS);
        } catch (Exception e4) {
            Logger.f().l("Error getting Firebase installation id.", e4);
        }
        return new FirebaseInstallationId(str, strB);
    }

    public String f() {
        return this.f88442c;
    }

    public String g() {
        return this.f88440a.a(this.f88441b);
    }

    public String h() {
        return String.format(Locale.US, "%s/%s", m(Build.MANUFACTURER), m(Build.MODEL));
    }

    public String i() {
        return m(Build.VERSION.INCREMENTAL);
    }

    public String j() {
        return m(Build.VERSION.RELEASE);
    }
}
