package androidx.window.layout.adapter.sidecar;

import android.os.IBinder;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarInterface;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class DistinctElementSidecarCallback implements SidecarInterface.SidecarCallback {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SidecarDeviceState f54396b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SidecarAdapter f54398d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final SidecarInterface.SidecarCallback f54399e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f54395a = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f54397c = new WeakHashMap();

    DistinctElementSidecarCallback(SidecarAdapter sidecarAdapter, SidecarInterface.SidecarCallback sidecarCallback) {
        this.f54398d = sidecarAdapter;
        this.f54399e = sidecarCallback;
    }

    public void onDeviceStateChanged(SidecarDeviceState sidecarDeviceState) {
        if (sidecarDeviceState == null) {
            return;
        }
        synchronized (this.f54395a) {
            try {
                if (this.f54398d.a(this.f54396b, sidecarDeviceState)) {
                    return;
                }
                this.f54396b = sidecarDeviceState;
                this.f54399e.onDeviceStateChanged(sidecarDeviceState);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void onWindowLayoutChanged(IBinder iBinder, SidecarWindowLayoutInfo sidecarWindowLayoutInfo) {
        synchronized (this.f54395a) {
            try {
                if (this.f54398d.d((SidecarWindowLayoutInfo) this.f54397c.get(iBinder), sidecarWindowLayoutInfo)) {
                    return;
                }
                this.f54397c.put(iBinder, sidecarWindowLayoutInfo);
                this.f54399e.onWindowLayoutChanged(iBinder, sidecarWindowLayoutInfo);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
