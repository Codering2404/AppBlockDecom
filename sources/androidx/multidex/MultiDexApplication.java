package androidx.multidex;

import android.app.Application;
import android.content.Context;
import com.pairip.StartupLauncher;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes2.dex */
public class MultiDexApplication extends Application {
    static {
        StartupLauncher.launch();
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.l(this);
    }
}
