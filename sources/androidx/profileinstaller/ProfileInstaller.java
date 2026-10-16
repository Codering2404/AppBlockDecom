package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.util.Log;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ProfileInstaller {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final DiagnosticsCallback f51404a = new DiagnosticsCallback() { // from class: androidx.profileinstaller.ProfileInstaller.1
        @Override // androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback
        public void a(int i3, Object obj) {
        }

        @Override // androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback
        public void b(int i3, Object obj) {
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final DiagnosticsCallback f51405b = new DiagnosticsCallback() { // from class: androidx.profileinstaller.ProfileInstaller.2
        @Override // androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback
        public void a(int i3, Object obj) {
            String str;
            switch (i3) {
                case 1:
                    str = "RESULT_INSTALL_SUCCESS";
                    break;
                case 2:
                    str = "RESULT_ALREADY_INSTALLED";
                    break;
                case 3:
                    str = "RESULT_UNSUPPORTED_ART_VERSION";
                    break;
                case 4:
                    str = "RESULT_NOT_WRITABLE";
                    break;
                case 5:
                    str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                    break;
                case 6:
                    str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                    break;
                case 7:
                    str = "RESULT_IO_EXCEPTION";
                    break;
                case 8:
                    str = "RESULT_PARSE_EXCEPTION";
                    break;
                case 9:
                default:
                    str = "";
                    break;
                case 10:
                    str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                    break;
                case 11:
                    str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                    break;
            }
            if (i3 == 6 || i3 == 7 || i3 == 8) {
                Log.e("ProfileInstaller", str, (Throwable) obj);
            } else {
                Log.d("ProfileInstaller", str);
            }
        }

        @Override // androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback
        public void b(int i3, Object obj) {
            Log.d("ProfileInstaller", i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? i3 != 5 ? "" : "DIAGNOSTIC_PROFILE_IS_COMPRESSED" : "DIAGNOSTIC_REF_PROFILE_DOES_NOT_EXIST" : "DIAGNOSTIC_REF_PROFILE_EXISTS" : "DIAGNOSTIC_CURRENT_PROFILE_DOES_NOT_EXIST" : "DIAGNOSTIC_CURRENT_PROFILE_EXISTS");
        }
    };

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface DiagnosticCode {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface DiagnosticsCallback {
        void a(int i3, Object obj);

        void b(int i3, Object obj);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ResultCode {
    }

    static boolean b(File file) {
        return new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat").delete();
    }

    static void c(Context context, Executor executor, DiagnosticsCallback diagnosticsCallback) {
        b(context.getFilesDir());
        f(executor, diagnosticsCallback, 11, null);
    }

    static boolean d(PackageInfo packageInfo, File file, DiagnosticsCallback diagnosticsCallback) {
        File file2 = new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat");
        if (!file2.exists()) {
            return false;
        }
        try {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file2));
            try {
                long j3 = dataInputStream.readLong();
                dataInputStream.close();
                boolean z2 = j3 == packageInfo.lastUpdateTime;
                if (z2) {
                    diagnosticsCallback.a(2, null);
                }
                return z2;
            } finally {
            }
        } catch (IOException unused) {
            return false;
        }
    }

    static void e(PackageInfo packageInfo, File file) {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat")));
            try {
                dataOutputStream.writeLong(packageInfo.lastUpdateTime);
                dataOutputStream.close();
            } finally {
            }
        } catch (IOException unused) {
        }
    }

    static void f(Executor executor, final DiagnosticsCallback diagnosticsCallback, final int i3, final Object obj) {
        executor.execute(new Runnable() { // from class: androidx.profileinstaller.b
            @Override // java.lang.Runnable
            public final void run() {
                diagnosticsCallback.a(i3, obj);
            }
        });
    }

    private static boolean g(AssetManager assetManager, String str, PackageInfo packageInfo, File file, String str2, Executor executor, DiagnosticsCallback diagnosticsCallback) {
        DeviceProfileWriter deviceProfileWriter = new DeviceProfileWriter(assetManager, executor, diagnosticsCallback, str2, "dexopt/baseline.prof", "dexopt/baseline.profm", new File(new File("/data/misc/profiles/cur/0", str), "primary.prof"));
        if (!deviceProfileWriter.e()) {
            return false;
        }
        boolean zM = deviceProfileWriter.h().l().m();
        if (zM) {
            e(packageInfo, file);
        }
        return zM;
    }

    public static void h(Context context) {
        i(context, new androidx.credentials.c(), f51404a);
    }

    public static void i(Context context, Executor executor, DiagnosticsCallback diagnosticsCallback) {
        j(context, executor, diagnosticsCallback, false);
    }

    static void j(Context context, Executor executor, DiagnosticsCallback diagnosticsCallback, boolean z2) {
        Context applicationContext = context.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        ApplicationInfo applicationInfo = applicationContext.getApplicationInfo();
        AssetManager assets = applicationContext.getAssets();
        String name = new File(applicationInfo.sourceDir).getName();
        boolean z3 = false;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            File filesDir = context.getFilesDir();
            if (!z2 && d(packageInfo, filesDir, diagnosticsCallback)) {
                Log.d("ProfileInstaller", "Skipping profile installation for " + context.getPackageName());
                ProfileVerifier.c(context, false);
                return;
            }
            Log.d("ProfileInstaller", "Installing profile for " + context.getPackageName());
            if (g(assets, packageName, packageInfo, filesDir, name, executor, diagnosticsCallback) && z2) {
                z3 = true;
            }
            ProfileVerifier.c(context, z3);
        } catch (PackageManager.NameNotFoundException e3) {
            diagnosticsCallback.a(7, e3);
            ProfileVerifier.c(context, false);
        }
    }

    static void k(Context context, Executor executor, DiagnosticsCallback diagnosticsCallback) {
        try {
            e(context.getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0), context.getFilesDir());
            f(executor, diagnosticsCallback, 10, null);
        } catch (PackageManager.NameNotFoundException e3) {
            f(executor, diagnosticsCallback, 7, e3);
        }
    }
}
