package androidx.media3.exoplayer.drm;

import androidx.media3.decoder.CryptoConfig;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class FrameworkCryptoConfig implements CryptoConfig {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f44070d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UUID f44071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f44072b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f44073c;

    /* JADX WARN: Removed duplicated region for block: B:9:0x001e  */
    static {
        /*
            java.lang.String r0 = "Amazon"
            java.lang.String r1 = android.os.Build.MANUFACTURER
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L1e
            java.lang.String r0 = android.os.Build.MODEL
            java.lang.String r1 = "AFTM"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L1c
            java.lang.String r1 = "AFTB"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L1e
        L1c:
            r0 = 1
            goto L1f
        L1e:
            r0 = 0
        L1f:
            androidx.media3.exoplayer.drm.FrameworkCryptoConfig.f44070d = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.drm.FrameworkCryptoConfig.<clinit>():void");
    }

    public FrameworkCryptoConfig(UUID uuid, byte[] bArr) {
        this(uuid, bArr, false);
    }

    public FrameworkCryptoConfig(UUID uuid, byte[] bArr, boolean z2) {
        this.f44071a = uuid;
        this.f44072b = bArr;
        this.f44073c = z2;
    }
}
