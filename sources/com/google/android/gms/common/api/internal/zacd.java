package com.google.android.gms.common.api.internal;

import android.os.SystemClock;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.RootTelemetryConfigManager;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zacd implements OnCompleteListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final GoogleApiManager f71780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f71781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ApiKey f71782c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f71783d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f71784e;

    zacd(GoogleApiManager googleApiManager, int i3, ApiKey apiKey, long j3, long j4, String str, String str2) {
        this.f71780a = googleApiManager;
        this.f71781b = i3;
        this.f71782c = apiKey;
        this.f71783d = j3;
        this.f71784e = j4;
    }

    static zacd a(GoogleApiManager googleApiManager, int i3, ApiKey apiKey) {
        boolean zG0;
        if (!googleApiManager.e()) {
            return null;
        }
        RootTelemetryConfiguration rootTelemetryConfigurationA = RootTelemetryConfigManager.b().a();
        if (rootTelemetryConfigurationA == null) {
            zG0 = true;
        } else {
            if (!rootTelemetryConfigurationA.O()) {
                return null;
            }
            zG0 = rootTelemetryConfigurationA.g0();
            zabq zabqVarT = googleApiManager.t(apiKey);
            if (zabqVarT != null) {
                if (!(zabqVarT.t() instanceof BaseGmsClient)) {
                    return null;
                }
                BaseGmsClient baseGmsClient = (BaseGmsClient) zabqVarT.t();
                if (baseGmsClient.hasConnectionInfo() && !baseGmsClient.isConnecting()) {
                    ConnectionTelemetryConfiguration connectionTelemetryConfigurationB = b(zabqVarT, baseGmsClient, i3);
                    if (connectionTelemetryConfigurationB == null) {
                        return null;
                    }
                    zabqVarT.E();
                    zG0 = connectionTelemetryConfigurationB.j0();
                }
            }
        }
        return new zacd(googleApiManager, i3, apiKey, zG0 ? System.currentTimeMillis() : 0L, zG0 ? SystemClock.elapsedRealtime() : 0L, null, null);
    }

    private static ConnectionTelemetryConfiguration b(zabq zabqVar, BaseGmsClient baseGmsClient, int i3) {
        int[] iArrN;
        int[] iArrO;
        ConnectionTelemetryConfiguration telemetryConfiguration = baseGmsClient.getTelemetryConfiguration();
        if (telemetryConfiguration == null || !telemetryConfiguration.g0() || ((iArrN = telemetryConfiguration.N()) != null ? !ArrayUtils.a(iArrN, i3) : !((iArrO = telemetryConfiguration.O()) == null || !ArrayUtils.a(iArrO, i3))) || zabqVar.q() >= telemetryConfiguration.M()) {
            return null;
        }
        return telemetryConfiguration;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        zabq zabqVarT;
        int iD1;
        int i3;
        int i4;
        int iN;
        long j3;
        long j4;
        if (this.f71780a.e()) {
            RootTelemetryConfiguration rootTelemetryConfigurationA = RootTelemetryConfigManager.b().a();
            if ((rootTelemetryConfigurationA == null || rootTelemetryConfigurationA.O()) && (zabqVarT = this.f71780a.t(this.f71782c)) != null && (zabqVarT.t() instanceof BaseGmsClient)) {
                BaseGmsClient baseGmsClient = (BaseGmsClient) zabqVarT.t();
                int i5 = 0;
                boolean zG0 = this.f71783d > 0;
                int gCoreServiceId = baseGmsClient.getGCoreServiceId();
                int iO = 100;
                if (rootTelemetryConfigurationA != null) {
                    zG0 &= rootTelemetryConfigurationA.g0();
                    int iM = rootTelemetryConfigurationA.M();
                    int iN2 = rootTelemetryConfigurationA.N();
                    iD1 = rootTelemetryConfigurationA.d1();
                    if (baseGmsClient.hasConnectionInfo() && !baseGmsClient.isConnecting()) {
                        ConnectionTelemetryConfiguration connectionTelemetryConfigurationB = b(zabqVarT, baseGmsClient, this.f71781b);
                        if (connectionTelemetryConfigurationB == null) {
                            return;
                        }
                        boolean z2 = connectionTelemetryConfigurationB.j0() && this.f71783d > 0;
                        iN2 = connectionTelemetryConfigurationB.M();
                        zG0 = z2;
                    }
                    i4 = iM;
                    i3 = iN2;
                } else {
                    iD1 = 0;
                    i3 = 100;
                    i4 = 5000;
                }
                GoogleApiManager googleApiManager = this.f71780a;
                int iElapsedRealtime = -1;
                if (task.isSuccessful()) {
                    iN = 0;
                } else if (task.isCanceled()) {
                    i5 = iO;
                    iN = -1;
                } else {
                    Exception exception = task.getException();
                    if (exception instanceof ApiException) {
                        Status status = ((ApiException) exception).getStatus();
                        iO = status.O();
                        ConnectionResult connectionResultM = status.M();
                        if (connectionResultM != null) {
                            iN = connectionResultM.N();
                            i5 = iO;
                        }
                        i5 = iO;
                        iN = -1;
                    } else {
                        i5 = 101;
                        iN = -1;
                    }
                }
                if (zG0) {
                    long j5 = this.f71783d;
                    long j6 = this.f71784e;
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    iElapsedRealtime = (int) (SystemClock.elapsedRealtime() - j6);
                    j4 = jCurrentTimeMillis;
                    j3 = j5;
                } else {
                    j3 = 0;
                    j4 = 0;
                }
                googleApiManager.F(new MethodInvocation(this.f71781b, i5, iN, j3, j4, null, null, gCoreServiceId, iElapsedRealtime), iD1, i4, i3);
            }
        }
    }
}
