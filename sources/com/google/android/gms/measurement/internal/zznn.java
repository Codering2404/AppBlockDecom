package com.google.android.gms.measurement.internal;

import android.content.pm.PackageManager;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zznn extends zzos {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map f74330d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final zzhe f74331e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final zzhe f74332f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final zzhe f74333g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final zzhe f74334h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final zzhe f74335i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final zzhe f74336j;

    zznn(zzpg zzpgVar) {
        super(zzpgVar);
        this.f74330d = new HashMap();
        zzhh zzhhVarX = this.f73997a.x();
        Objects.requireNonNull(zzhhVarX);
        this.f74331e = new zzhe(zzhhVarX, "last_delete_stale", 0L);
        zzhh zzhhVarX2 = this.f73997a.x();
        Objects.requireNonNull(zzhhVarX2);
        this.f74332f = new zzhe(zzhhVarX2, "last_delete_stale_batch", 0L);
        zzhh zzhhVarX3 = this.f73997a.x();
        Objects.requireNonNull(zzhhVarX3);
        this.f74333g = new zzhe(zzhhVarX3, "backoff", 0L);
        zzhh zzhhVarX4 = this.f73997a.x();
        Objects.requireNonNull(zzhhVarX4);
        this.f74334h = new zzhe(zzhhVarX4, "last_upload", 0L);
        zzhh zzhhVarX5 = this.f73997a.x();
        Objects.requireNonNull(zzhhVarX5);
        this.f74335i = new zzhe(zzhhVarX5, "last_upload_attempt", 0L);
        zzhh zzhhVarX6 = this.f73997a.x();
        Objects.requireNonNull(zzhhVarX6);
        this.f74336j = new zzhe(zzhhVarX6, "midnight_offset", 0L);
    }

    @Override // com.google.android.gms.measurement.internal.zzos
    protected final boolean l() {
        return false;
    }

    final Pair m(String str, zzjl zzjlVar) {
        return zzjlVar.o(zzjk.AD_STORAGE) ? n(str) : new Pair("", Boolean.FALSE);
    }

    final Pair n(String str) throws Throwable {
        zznm zznmVar;
        AdvertisingIdClient.Info advertisingIdInfo;
        h();
        zzic zzicVar = this.f73997a;
        long jA = zzicVar.e().a();
        zznm zznmVar2 = (zznm) this.f74330d.get(str);
        if (zznmVar2 != null && jA < zznmVar2.f74329c) {
            return new Pair(zznmVar2.f74327a, Boolean.valueOf(zznmVar2.f74328b));
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        long jD = zzicVar.w().D(str, zzfy.f73622b) + jA;
        try {
            try {
                advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(zzicVar.d());
            } catch (PackageManager.NameNotFoundException unused) {
                advertisingIdInfo = null;
                if (zznmVar2 != null && jA < zznmVar2.f74329c + this.f73997a.w().D(str, zzfy.f73625c)) {
                    return new Pair(zznmVar2.f74327a, Boolean.valueOf(zznmVar2.f74328b));
                }
            }
        } catch (Exception e3) {
            this.f73997a.a().v().b("Unable to get advertising id", e3);
            zznmVar = new zznm("", false, jD);
        }
        if (advertisingIdInfo == null) {
            return new Pair("00000000-0000-0000-0000-000000000000", Boolean.FALSE);
        }
        String id = advertisingIdInfo.getId();
        zznmVar = id != null ? new zznm(id, advertisingIdInfo.isLimitAdTrackingEnabled(), jD) : new zznm("", advertisingIdInfo.isLimitAdTrackingEnabled(), jD);
        this.f74330d.put(str, zznmVar);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair(zznmVar.f74327a, Boolean.valueOf(zznmVar.f74328b));
    }

    final String o(String str, boolean z2) {
        h();
        String str2 = z2 ? (String) n(str).first : "00000000-0000-0000-0000-000000000000";
        MessageDigest messageDigestC = zzpp.C();
        if (messageDigestC == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, messageDigestC.digest(str2.getBytes())));
    }
}
