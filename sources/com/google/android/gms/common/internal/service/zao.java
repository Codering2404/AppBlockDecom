package com.google.android.gms.common.internal.service;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.TelemetryLoggingClient;
import com.google.android.gms.common.internal.TelemetryLoggingOptions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zao extends GoogleApi implements TelemetryLoggingClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Api.ClientKey f72035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Api.AbstractClientBuilder f72036b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Api f72037c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f72038d = 0;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        f72035a = clientKey;
        zan zanVar = new zan();
        f72036b = zanVar;
        f72037c = new Api("ClientTelemetry.API", zanVar, clientKey);
    }

    public zao(Context context, TelemetryLoggingOptions telemetryLoggingOptions) {
        super(context, f72037c, telemetryLoggingOptions, GoogleApi.Settings.f71506c);
    }

    @Override // com.google.android.gms.common.internal.TelemetryLoggingClient
    public final Task b(final TelemetryData telemetryData) {
        TaskApiCall.Builder builderA = TaskApiCall.a();
        builderA.d(com.google.android.gms.internal.base.zaf.zaa);
        builderA.c(false);
        builderA.b(new RemoteCall() { // from class: com.google.android.gms.common.internal.service.zam
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                int i3 = zao.f72038d;
                ((zai) ((zap) obj).getService()).x3(telemetryData);
                ((TaskCompletionSource) obj2).setResult(null);
            }
        });
        return doBestEffortWrite(builderA.a());
    }
}
