package androidx.work;

import android.content.Context;
import androidx.startup.Initializer;
import androidx.work.Configuration;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class WorkManagerInitializer implements Initializer<WorkManager> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f54588a = Logger.i("WrkMgrInitializer");

    @Override // androidx.startup.Initializer
    public List a() {
        return Collections.EMPTY_LIST;
    }

    @Override // androidx.startup.Initializer
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public WorkManager create(Context context) {
        Logger.e().a(f54588a, "Initializing WorkManager with default configuration.");
        WorkManager.l(context, new Configuration.Builder().a());
        return WorkManager.h(context);
    }
}
