package com.singular.sdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.facebook.internal.ServerProtocol;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class DeviceIDManager {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static DeviceIDManager f92528e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final SingularLog f92529f = SingularLog.f(DeviceIDManager.class.getSimpleName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SdidModel f92531b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private SdidModel f92532c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SdidModel f92530a = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f92533d = false;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class SdidModel {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f92534a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final SdidSource f92535b;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public enum SdidSource {
            custom,
            resolved
        }

        SdidModel(String str, SdidSource sdidSource) {
            this.f92534a = str;
            this.f92535b = sdidSource;
        }

        public SdidSource a() {
            return this.f92535b;
        }

        public String b() {
            return this.f92534a;
        }
    }

    public static DeviceIDManager c() {
        if (f92528e == null) {
            f92528e = new DeviceIDManager();
        }
        return f92528e;
    }

    private SdidModel f(ConfigManager configManager, Context context) {
        try {
            if (context == null) {
                f92529f.a("failed to pick actual sdid model because context is null");
                return null;
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences("singular-pref-session", 0);
            String string = sharedPreferences.getString("custom-sdid", null);
            if (!Utils.U(string)) {
                f92529f.a("returning persisted custom sdid from prefs");
                return new SdidModel(string, SdidModel.SdidSource.custom);
            }
            String string2 = sharedPreferences.getString("pref-singular-device-id", null);
            if (!Utils.U(string2)) {
                f92529f.a("returning persisted resolved sdid from prefs");
                return new SdidModel(string2, SdidModel.SdidSource.resolved);
            }
            boolean zJ = j();
            boolean zH = configManager.h();
            if (zJ && zH) {
                SingularLog singularLog = f92529f;
                singularLog.a("persisting custom set sdid to prefs");
                SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                editorEdit.putString("custom-sdid", this.f92530a.b());
                editorEdit.commit();
                singularLog.a("returning custom set sdid");
                return this.f92530a;
            }
            String strD = configManager.d();
            if (Utils.U(strD)) {
                f92529f.a("returning null - can't pick an actual valid SDID.");
                return null;
            }
            SingularLog singularLog2 = f92529f;
            singularLog2.a("persisting resolved sdid to prefs");
            SharedPreferences.Editor editorEdit2 = sharedPreferences.edit();
            editorEdit2.putString("pref-singular-device-id", strD);
            editorEdit2.commit();
            singularLog2.a("returning resolved sdid from config");
            return new SdidModel(strD, SdidModel.SdidSource.resolved);
        } catch (Throwable th) {
            f92529f.c("caught throwable during pick actual sdid model. returning null: " + Utils.l(th));
            return null;
        }
    }

    private void g(SingularInstance singularInstance) {
        if (b(ConfigManager.c(), singularInstance.o()) != null) {
            f92529f.a("ignoring set candidate custom sdid because one exists.");
            return;
        }
        String str = singularInstance.C().f92439x;
        if (Utils.U(str)) {
            this.f92530a = null;
            f92529f.a("setting candidate custom sdid to null");
            return;
        }
        this.f92530a = new SdidModel(str, SdidModel.SdidSource.custom);
        f92529f.a("setting candidate custom sdid: " + str);
    }

    boolean a(Context context) {
        try {
            if (this.f92533d) {
                return true;
            }
            boolean z2 = context.getSharedPreferences("singular-pref-session", 0).getBoolean("DID_SEND_START_SESSION_WITH_SDID", false);
            this.f92533d = z2;
            return z2;
        } catch (Throwable unused) {
            f92529f.a("failed getting pref boolean flag did send start session with SDID");
            return false;
        }
    }

    public SdidModel b(ConfigManager configManager, Context context) {
        if (this.f92532c == null) {
            f92529f.a("current sdid is null, trying to pick actual sdid model");
            this.f92532c = f(configManager, context);
        }
        return this.f92532c;
    }

    public boolean d(Context context) {
        SdidModel sdidModelB = b(ConfigManager.c(), context);
        boolean z2 = this.f92531b == null && sdidModelB != null;
        this.f92531b = sdidModelB;
        SingularLog singularLog = f92529f;
        StringBuilder sb = new StringBuilder();
        sb.append("is fresh sdid = ");
        sb.append(z2 ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false");
        singularLog.a(sb.toString());
        return z2;
    }

    void e(Context context) {
        this.f92531b = b(ConfigManager.c(), context);
        f92529f.a("loaded previous sdid for comparison");
    }

    void h(Context context) {
        try {
            f92529f.a("setting pref did send start session with SDID to true");
            this.f92533d = true;
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("singular-pref-session", 0).edit();
            editorEdit.putBoolean("DID_SEND_START_SESSION_WITH_SDID", this.f92533d);
            editorEdit.commit();
        } catch (Throwable unused) {
            f92529f.a("failed setting pref did send start session with SDID");
        }
    }

    public void i(SingularInstance singularInstance) {
        e(singularInstance.o());
        c().g(singularInstance);
    }

    public boolean j() {
        return this.f92530a != null;
    }
}
