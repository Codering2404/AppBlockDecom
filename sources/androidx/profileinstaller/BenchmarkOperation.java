package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import androidx.profileinstaller.ProfileInstallReceiver;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class BenchmarkOperation {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Api21ContextHelper {
        static File a(Context context) {
            return context.getCodeCacheDir();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Api24ContextHelper {
        static Context a(Context context) {
            return context.createDeviceProtectedStorageContext();
        }
    }

    static boolean a(File file) {
        if (!file.isDirectory()) {
            file.delete();
            return true;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return false;
        }
        boolean z2 = true;
        for (File file2 : fileArrListFiles) {
            z2 = a(file2) && z2;
        }
        return z2;
    }

    static void b(Context context, ProfileInstallReceiver.ResultDiagnostics resultDiagnostics) {
        if (a(Build.VERSION.SDK_INT >= 34 ? Api24ContextHelper.a(context).getCacheDir() : Api21ContextHelper.a(Api24ContextHelper.a(context)))) {
            resultDiagnostics.a(14, null);
        } else {
            resultDiagnostics.a(15, null);
        }
    }
}
