package com.google.android.libraries.places.internal;

import com.google.android.gms.common.api.Api;
import com.google.common.base.Preconditions;
import java.security.GeneralSecurityException;
import java.util.EnumSet;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzcbd extends zzbkb {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final zzcch f77383i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final zzbzx f77384j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final zzbwo f77385k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbvw f77386a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private SSLSocketFactory f77390e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzcaj f77387b = zzcal.e();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzbwo f77388c = f77385k;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzbwo f77389d = zzbzz.a(zzbsz.f76836q);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzcch f77391f = f77383i;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f77393h = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f77392g = zzbsz.f76831l;

    static {
        Logger.getLogger(zzcbd.class.getName());
        zzccg zzccgVar = new zzccg(zzcch.f77549f);
        zzccgVar.a(zzccf.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, zzccf.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, zzccf.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, zzccf.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, zzccf.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, zzccf.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256);
        zzccgVar.c(zzcct.TLS_1_2);
        zzccgVar.e(true);
        f77383i = zzccgVar.f();
        TimeUnit.DAYS.toNanos(1000L);
        zzcay zzcayVar = new zzcay();
        f77384j = zzcayVar;
        f77385k = zzbzz.a(zzcayVar);
        EnumSet.of(zzbnz.MTLS, zzbnz.CUSTOM_MANAGERS);
    }

    private zzcbd(String str) {
        this.f77386a = new zzbvw(str, null, null, new zzcba(this, null), new zzcaz(this, null));
    }

    public static zzcbd e(String str, int i3) {
        return new zzcbd(zzbsz.c(str, 443));
    }

    @Override // com.google.android.libraries.places.internal.zzbkb
    protected final zzbly b() {
        return this.f77386a;
    }

    public final zzcbd f() {
        Preconditions.A(true, "Cannot change security when using ChannelCredentials");
        this.f77393h = 1;
        return this;
    }

    final zzcbc g() {
        long j3 = this.f77392g;
        zzcch zzcchVar = this.f77391f;
        zzcaj zzcajVar = this.f77387b;
        return new zzcbc(this.f77388c, this.f77389d, null, i(), null, zzcchVar, 4194304, false, Long.MAX_VALUE, j3, 65535, false, Api.BaseClientBuilder.API_PRIORITY_OTHER, zzcajVar, false, null, null);
    }

    final int h() {
        int i3 = this.f77393h;
        int i4 = i3 - 1;
        if (i3 == 0) {
            throw null;
        }
        if (i4 == 0) {
            return 443;
        }
        throw new AssertionError("TLS not handled");
    }

    final SSLSocketFactory i() {
        int i3 = this.f77393h;
        int i4 = i3 - 1;
        if (i3 == 0) {
            throw null;
        }
        if (i4 != 0) {
            throw new RuntimeException("Unknown negotiation type: TLS");
        }
        try {
            if (this.f77390e == null) {
                this.f77390e = SSLContext.getInstance("Default", zzccr.e().f()).getSocketFactory();
            }
            return this.f77390e;
        } catch (GeneralSecurityException e3) {
            throw new RuntimeException("TLS Provider failure", e3);
        }
    }
}
