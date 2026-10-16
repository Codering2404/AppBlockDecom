package androidx.media3.exoplayer.drm;

import android.net.Uri;
import android.text.TextUtils;
import androidx.media3.common.C;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSpec;
import androidx.media3.exoplayer.drm.ExoMediaDrm;
import com.google.common.collect.ImmutableMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class HttpMediaDrmCallback implements MediaDrmCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DataSource.Factory f44078a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f44079b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f44080c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map f44081d;

    public HttpMediaDrmCallback(String str, boolean z2, DataSource.Factory factory) {
        Assertions.a((z2 && TextUtils.isEmpty(str)) ? false : true);
        this.f44078a = factory;
        this.f44079b = str;
        this.f44080c = z2;
        this.f44081d = new HashMap();
    }

    @Override // androidx.media3.exoplayer.drm.MediaDrmCallback
    public byte[] a(UUID uuid, ExoMediaDrm.KeyRequest keyRequest) throws MediaDrmCallbackException {
        String strB = keyRequest.b();
        if (this.f44080c || TextUtils.isEmpty(strB)) {
            strB = this.f44079b;
        }
        if (TextUtils.isEmpty(strB)) {
            DataSpec.Builder builder = new DataSpec.Builder();
            Uri uri = Uri.EMPTY;
            throw new MediaDrmCallbackException(builder.i(uri).a(), uri, ImmutableMap.n(), 0L, new IllegalStateException("No license URL"));
        }
        HashMap map = new HashMap();
        UUID uuid2 = C.f40545e;
        map.put("Content-Type", uuid2.equals(uuid) ? "text/xml" : C.f40543c.equals(uuid) ? "application/json" : "application/octet-stream");
        if (uuid2.equals(uuid)) {
            map.put("SOAPAction", "http://schemas.microsoft.com/DRM/2007/03/protocols/AcquireLicense");
        }
        synchronized (this.f44081d) {
            map.putAll(this.f44081d);
        }
        return DrmUtil.a(this.f44078a.a(), strB, keyRequest.a(), map);
    }

    @Override // androidx.media3.exoplayer.drm.MediaDrmCallback
    public byte[] b(UUID uuid, ExoMediaDrm.ProvisionRequest provisionRequest) {
        return DrmUtil.a(this.f44078a.a(), provisionRequest.b() + "&signedRequest=" + Util.K(provisionRequest.a()), null, Collections.EMPTY_MAP);
    }

    public void c(String str, String str2) {
        Assertions.e(str);
        Assertions.e(str2);
        synchronized (this.f44081d) {
            this.f44081d.put(str, str2);
        }
    }
}
