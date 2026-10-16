package cz.mobilesoft.coreblock.service.job;

import android.content.Context;
import com.evernote.android.job.util.support.PersistableBundleCompat;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
public interface JobEventsListener {
    void a(Context context);

    boolean b(Context context);

    void c(Context context, long j3);

    void d(Context context);

    void e(Context context, long j3);

    void f(Context context);

    boolean g(Context context, PersistableBundleCompat persistableBundleCompat);

    void h(Context context, String str);

    void i(Context context, long j3);

    void j(Context context, CoroutineScope coroutineScope);
}
