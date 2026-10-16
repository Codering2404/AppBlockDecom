package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class AppMeasurementDynamiteService extends com.google.android.gms.internal.measurement.zzcq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    zzic f73363a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f73364b = new ArrayMap();

    private final void x3(com.google.android.gms.internal.measurement.zzcu zzcuVar, String str) {
        zzb();
        this.f73363a.C().a0(zzcuVar, str);
    }

    private final void zzb() {
        if (this.f73363a == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void beginAdUnitExposure(String str, long j3) throws RemoteException {
        zzb();
        this.f73363a.M().i(str, j3);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        zzb();
        this.f73363a.B().O(str, str2, bundle);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void clearMeasurementEnabled(long j3) throws RemoteException {
        zzb();
        this.f73363a.B().n0(null);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void endAdUnitExposure(String str, long j3) throws RemoteException {
        zzb();
        this.f73363a.M().j(str, j3);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void generateEventId(com.google.android.gms.internal.measurement.zzcu zzcuVar) throws RemoteException {
        zzb();
        long jP0 = this.f73363a.C().p0();
        zzb();
        this.f73363a.C().b0(zzcuVar, jP0);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void getAppInstanceId(com.google.android.gms.internal.measurement.zzcu zzcuVar) throws RemoteException {
        zzb();
        this.f73363a.b().t(new zzi(this, zzcuVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void getCachedAppInstanceId(com.google.android.gms.internal.measurement.zzcu zzcuVar) throws RemoteException {
        zzb();
        x3(zzcuVar, this.f73363a.B().D());
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void getConditionalUserProperties(String str, String str2, com.google.android.gms.internal.measurement.zzcu zzcuVar) throws RemoteException {
        zzb();
        this.f73363a.b().t(new zzm(this, zzcuVar, str, str2));
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void getCurrentScreenClass(com.google.android.gms.internal.measurement.zzcu zzcuVar) throws RemoteException {
        zzb();
        x3(zzcuVar, this.f73363a.B().R());
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void getCurrentScreenName(com.google.android.gms.internal.measurement.zzcu zzcuVar) throws RemoteException {
        zzb();
        x3(zzcuVar, this.f73363a.B().Q());
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void getGmpAppId(com.google.android.gms.internal.measurement.zzcu zzcuVar) throws RemoteException {
        zzb();
        x3(zzcuVar, this.f73363a.B().S());
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void getMaxUserProperties(String str, com.google.android.gms.internal.measurement.zzcu zzcuVar) throws RemoteException {
        zzb();
        this.f73363a.B().L(str);
        zzb();
        this.f73363a.C().c0(zzcuVar, 25);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void getSessionId(com.google.android.gms.internal.measurement.zzcu zzcuVar) throws RemoteException {
        zzb();
        zzlj zzljVarB = this.f73363a.B();
        zzljVarB.f73997a.b().t(new zzkm(zzljVarB, zzcuVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void getTestFlag(com.google.android.gms.internal.measurement.zzcu zzcuVar, int i3) throws RemoteException {
        zzb();
        if (i3 == 0) {
            this.f73363a.C().a0(zzcuVar, this.f73363a.B().j0());
            return;
        }
        if (i3 == 1) {
            this.f73363a.C().b0(zzcuVar, this.f73363a.B().k0().longValue());
            return;
        }
        if (i3 != 2) {
            if (i3 == 3) {
                this.f73363a.C().c0(zzcuVar, this.f73363a.B().l0().intValue());
                return;
            } else {
                if (i3 != 4) {
                    return;
                }
                this.f73363a.C().e0(zzcuVar, this.f73363a.B().i0().booleanValue());
                return;
            }
        }
        zzpp zzppVarC = this.f73363a.C();
        double dDoubleValue = this.f73363a.B().m0().doubleValue();
        Bundle bundle = new Bundle();
        bundle.putDouble("r", dDoubleValue);
        try {
            zzcuVar.zzb(bundle);
        } catch (RemoteException e3) {
            zzppVarC.f73997a.a().r().b("Error returning double value to wrapper", e3);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void getUserProperties(String str, String str2, boolean z2, com.google.android.gms.internal.measurement.zzcu zzcuVar) throws RemoteException {
        zzb();
        this.f73363a.b().t(new zzk(this, zzcuVar, str, str2, z2));
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void initForTests(Map map) throws RemoteException {
        zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void initialize(IObjectWrapper iObjectWrapper, com.google.android.gms.internal.measurement.zzdd zzddVar, long j3) throws RemoteException {
        zzic zzicVar = this.f73363a;
        if (zzicVar == null) {
            this.f73363a = zzic.O((Context) Preconditions.m((Context) ObjectWrapper.h5(iObjectWrapper)), zzddVar, Long.valueOf(j3));
        } else {
            zzicVar.a().r().a("Attempting to initialize multiple times");
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void isDataCollectionEnabled(com.google.android.gms.internal.measurement.zzcu zzcuVar) throws RemoteException {
        zzb();
        this.f73363a.b().t(new zzn(this, zzcuVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void logEvent(String str, String str2, Bundle bundle, boolean z2, boolean z3, long j3) throws RemoteException {
        zzb();
        this.f73363a.B().q(str, str2, bundle, z2, z3, j3);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void logEventAndBundle(String str, String str2, Bundle bundle, com.google.android.gms.internal.measurement.zzcu zzcuVar, long j3) throws RemoteException {
        zzb();
        Preconditions.g(str2);
        (bundle != null ? new Bundle(bundle) : new Bundle()).putString("_o", "app");
        this.f73363a.b().t(new zzj(this, zzcuVar, new zzbg(str2, new zzbe(bundle), "app", j3), str));
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void logHealthData(int i3, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        zzb();
        this.f73363a.a().y(i3, true, false, str, iObjectWrapper == null ? null : ObjectWrapper.h5(iObjectWrapper), iObjectWrapper2 == null ? null : ObjectWrapper.h5(iObjectWrapper2), iObjectWrapper3 != null ? ObjectWrapper.h5(iObjectWrapper3) : null);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j3) throws RemoteException {
        zzb();
        onActivityCreatedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf.zza((Activity) Preconditions.m((Activity) ObjectWrapper.h5(iObjectWrapper))), bundle, j3);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivityCreatedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf zzdfVar, Bundle bundle, long j3) {
        zzb();
        zzky zzkyVar = this.f73363a.B().f74136c;
        if (zzkyVar != null) {
            this.f73363a.B().h0();
            zzkyVar.e(zzdfVar, bundle);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j3) throws RemoteException {
        zzb();
        onActivityDestroyedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf.zza((Activity) Preconditions.m((Activity) ObjectWrapper.h5(iObjectWrapper))), j3);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivityDestroyedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf zzdfVar, long j3) throws RemoteException {
        zzb();
        zzky zzkyVar = this.f73363a.B().f74136c;
        if (zzkyVar != null) {
            this.f73363a.B().h0();
            zzkyVar.b(zzdfVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivityPaused(IObjectWrapper iObjectWrapper, long j3) throws RemoteException {
        zzb();
        onActivityPausedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf.zza((Activity) Preconditions.m((Activity) ObjectWrapper.h5(iObjectWrapper))), j3);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivityPausedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf zzdfVar, long j3) throws RemoteException {
        zzb();
        zzky zzkyVar = this.f73363a.B().f74136c;
        if (zzkyVar != null) {
            this.f73363a.B().h0();
            zzkyVar.a(zzdfVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivityResumed(IObjectWrapper iObjectWrapper, long j3) throws RemoteException {
        zzb();
        onActivityResumedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf.zza((Activity) Preconditions.m((Activity) ObjectWrapper.h5(iObjectWrapper))), j3);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivityResumedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf zzdfVar, long j3) throws RemoteException {
        zzb();
        zzky zzkyVar = this.f73363a.B().f74136c;
        if (zzkyVar != null) {
            this.f73363a.B().h0();
            zzkyVar.d(zzdfVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, com.google.android.gms.internal.measurement.zzcu zzcuVar, long j3) throws RemoteException {
        zzb();
        onActivitySaveInstanceStateByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf.zza((Activity) Preconditions.m((Activity) ObjectWrapper.h5(iObjectWrapper))), zzcuVar, j3);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivitySaveInstanceStateByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf zzdfVar, com.google.android.gms.internal.measurement.zzcu zzcuVar, long j3) throws RemoteException {
        zzb();
        zzky zzkyVar = this.f73363a.B().f74136c;
        Bundle bundle = new Bundle();
        if (zzkyVar != null) {
            this.f73363a.B().h0();
            zzkyVar.c(zzdfVar, bundle);
        }
        try {
            zzcuVar.zzb(bundle);
        } catch (RemoteException e3) {
            this.f73363a.a().r().b("Error returning bundle value to wrapper", e3);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivityStarted(IObjectWrapper iObjectWrapper, long j3) throws RemoteException {
        zzb();
        onActivityStartedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf.zza((Activity) Preconditions.m((Activity) ObjectWrapper.h5(iObjectWrapper))), j3);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivityStartedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf zzdfVar, long j3) throws RemoteException {
        zzb();
        if (this.f73363a.B().f74136c != null) {
            this.f73363a.B().h0();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivityStopped(IObjectWrapper iObjectWrapper, long j3) throws RemoteException {
        zzb();
        onActivityStoppedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf.zza((Activity) Preconditions.m((Activity) ObjectWrapper.h5(iObjectWrapper))), j3);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivityStoppedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf zzdfVar, long j3) throws RemoteException {
        zzb();
        if (this.f73363a.B().f74136c != null) {
            this.f73363a.B().h0();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void performAction(Bundle bundle, com.google.android.gms.internal.measurement.zzcu zzcuVar, long j3) throws RemoteException {
        zzb();
        zzcuVar.zzb(null);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void registerOnMeasurementEventListener(com.google.android.gms.internal.measurement.zzda zzdaVar) throws RemoteException {
        zzjq zzqVar;
        zzb();
        Map map = this.f73364b;
        synchronized (map) {
            try {
                zzqVar = (zzjq) map.get(Integer.valueOf(zzdaVar.zzf()));
                if (zzqVar == null) {
                    zzqVar = new zzq(this, zzdaVar);
                    map.put(Integer.valueOf(zzdaVar.zzf()), zzqVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f73363a.B().J(zzqVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void resetAnalyticsData(long j3) throws RemoteException {
        zzb();
        this.f73363a.B().G(j3);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void retrieveAndUploadBatches(final com.google.android.gms.internal.measurement.zzcx zzcxVar) {
        zzb();
        this.f73363a.B().r0(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzo
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                try {
                    zzcxVar.zze();
                } catch (RemoteException e3) {
                    ((zzic) Preconditions.m(this.f74360a.f73363a)).a().r().b("Failed to call IDynamiteUploadBatchesCallback", e3);
                }
            }
        });
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setConditionalUserProperty(Bundle bundle, long j3) throws RemoteException {
        zzb();
        if (bundle == null) {
            this.f73363a.a().o().a("Conditional user property must not be null");
        } else {
            this.f73363a.B().N(bundle, j3);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setConsentThirdParty(Bundle bundle, long j3) throws RemoteException {
        zzb();
        this.f73363a.B().o0(bundle, -20, j3);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j3) throws RemoteException {
        zzb();
        setCurrentScreenByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf.zza((Activity) Preconditions.m((Activity) ObjectWrapper.h5(iObjectWrapper))), str, str2, j3);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setCurrentScreenByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf zzdfVar, String str, String str2, long j3) throws RemoteException {
        zzb();
        this.f73363a.I().t(zzdfVar, str, str2);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setDataCollectionEnabled(boolean z2) throws RemoteException {
        zzb();
        zzlj zzljVarB = this.f73363a.B();
        zzljVarB.j();
        zzljVarB.f73997a.b().t(new zzjy(zzljVarB, z2));
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setDefaultEventParameters(Bundle bundle) {
        zzb();
        final zzlj zzljVarB = this.f73363a.B();
        final Bundle bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
        zzljVarB.f73997a.b().t(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzlf
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzljVarB.U(bundle2);
            }
        });
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setEventInterceptor(com.google.android.gms.internal.measurement.zzda zzdaVar) throws RemoteException {
        zzb();
        zzp zzpVar = new zzp(this, zzdaVar);
        if (this.f73363a.b().p()) {
            this.f73363a.B().I(zzpVar);
        } else {
            this.f73363a.b().t(new zzl(this, zzpVar));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setInstanceIdProvider(com.google.android.gms.internal.measurement.zzdc zzdcVar) throws RemoteException {
        zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setMeasurementEnabled(boolean z2, long j3) throws RemoteException {
        zzb();
        this.f73363a.B().n0(Boolean.valueOf(z2));
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setMinimumSessionDuration(long j3) throws RemoteException {
        zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setSessionTimeoutDuration(long j3) throws RemoteException {
        zzb();
        zzlj zzljVarB = this.f73363a.B();
        zzljVarB.f73997a.b().t(new zzka(zzljVarB, j3));
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setSgtmDebugInfo(Intent intent) throws RemoteException {
        zzb();
        zzlj zzljVarB = this.f73363a.B();
        Uri data = intent.getData();
        if (data == null) {
            zzljVarB.f73997a.a().u().a("Activity intent has no data. Preview Mode was not enabled.");
            return;
        }
        String queryParameter = data.getQueryParameter("sgtm_debug_enable");
        if (queryParameter == null || !queryParameter.equals(AppEventsConstants.EVENT_PARAM_VALUE_YES)) {
            zzic zzicVar = zzljVarB.f73997a;
            zzicVar.a().u().a("[sgtm] Preview Mode was not enabled.");
            zzicVar.w().Q(null);
        } else {
            String queryParameter2 = data.getQueryParameter("sgtm_preview_key");
            if (TextUtils.isEmpty(queryParameter2)) {
                return;
            }
            zzic zzicVar2 = zzljVarB.f73997a;
            zzicVar2.a().u().b("[sgtm] Preview Mode was enabled. Using the sgtmPreviewKey: ", queryParameter2);
            zzicVar2.w().Q(queryParameter2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setUserId(final String str, long j3) throws RemoteException {
        zzb();
        final zzlj zzljVarB = this.f73363a.B();
        if (str != null && TextUtils.isEmpty(str)) {
            zzljVarB.f73997a.a().r().a("User ID must be non-empty or null");
        } else {
            zzljVarB.f73997a.b().t(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzlg
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzic zzicVar = zzljVarB.f73997a;
                    if (zzicVar.L().x(str)) {
                        zzicVar.L().p();
                    }
                }
            });
            zzljVarB.z(null, "_id", str, true, j3);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z2, long j3) throws RemoteException {
        zzb();
        this.f73363a.B().z(str, str2, ObjectWrapper.h5(iObjectWrapper), z2, j3);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void unregisterOnMeasurementEventListener(com.google.android.gms.internal.measurement.zzda zzdaVar) throws RemoteException {
        zzjq zzqVar;
        zzb();
        Map map = this.f73364b;
        synchronized (map) {
            zzqVar = (zzjq) map.remove(Integer.valueOf(zzdaVar.zzf()));
        }
        if (zzqVar == null) {
            zzqVar = new zzq(this, zzdaVar);
        }
        this.f73363a.B().K(zzqVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setConsent(Bundle bundle, long j3) throws RemoteException {
    }
}
