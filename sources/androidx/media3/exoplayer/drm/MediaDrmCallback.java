package androidx.media3.exoplayer.drm;

import androidx.media3.exoplayer.drm.ExoMediaDrm;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface MediaDrmCallback {
    byte[] a(UUID uuid, ExoMediaDrm.KeyRequest keyRequest);

    byte[] b(UUID uuid, ExoMediaDrm.ProvisionRequest provisionRequest);
}
