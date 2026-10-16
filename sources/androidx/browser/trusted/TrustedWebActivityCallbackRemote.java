package androidx.browser.trusted;

import android.os.IBinder;
import android.support.customtabs.trusted.ITrustedWebActivityCallback;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class TrustedWebActivityCallbackRemote {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ITrustedWebActivityCallback f2702a;

    private TrustedWebActivityCallbackRemote(ITrustedWebActivityCallback iTrustedWebActivityCallback) {
        this.f2702a = iTrustedWebActivityCallback;
    }

    static TrustedWebActivityCallbackRemote a(IBinder iBinder) {
        ITrustedWebActivityCallback iTrustedWebActivityCallbackX3 = iBinder == null ? null : ITrustedWebActivityCallback.Stub.x3(iBinder);
        if (iTrustedWebActivityCallbackX3 == null) {
            return null;
        }
        return new TrustedWebActivityCallbackRemote(iTrustedWebActivityCallbackX3);
    }
}
