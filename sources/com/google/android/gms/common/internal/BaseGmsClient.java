package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.AttributionSource;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.wrappers.AttributionSourceWrapper;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseGmsClient<T extends IInterface> {
    public static final int CONNECT_STATE_CONNECTED = 4;
    public static final int CONNECT_STATE_DISCONNECTED = 1;
    public static final int CONNECT_STATE_DISCONNECTING = 5;
    public static final String DEFAULT_ACCOUNT = "<<default account>>";
    public static final String KEY_PENDING_INTENT = "pendingIntent";
    private volatile String zzA;
    private volatile AttributionSourceWrapper zzB;
    private ConnectionResult zzC;
    private boolean zzD;
    private volatile zzj zzE;
    zzs zza;
    final Handler zzb;
    protected ConnectionProgressReportCallbacks zzc;
    protected AtomicInteger zzd;
    private int zzf;
    private long zzg;
    private long zzh;
    private int zzi;
    private long zzj;
    private volatile String zzk;
    private final Context zzl;
    private final Looper zzm;
    private final GmsClientSupervisor zzn;
    private final GoogleApiAvailabilityLight zzo;
    private final Object zzp;
    private final Object zzq;
    private IGmsServiceBroker zzr;
    private IInterface zzs;
    private final ArrayList zzt;
    private zze zzu;
    private int zzv;
    private final BaseConnectionCallbacks zzw;
    private final BaseOnConnectionFailedListener zzx;
    private final int zzy;
    private final String zzz;
    private static final Feature[] zze = new Feature[0];
    public static final String[] GOOGLE_PLUS_REQUIRED_FEATURES = {"service_esmobile", "service_googleme"};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface BaseConnectionCallbacks {
        void onConnected(Bundle bundle);

        void onConnectionSuspended(int i3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface BaseOnConnectionFailedListener {
        void onConnectionFailed(ConnectionResult connectionResult);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface ConnectionProgressReportCallbacks {
        void a(ConnectionResult connectionResult);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    protected class LegacyClientCallbackAdapter implements ConnectionProgressReportCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaseGmsClient f71948a;

        public LegacyClientCallbackAdapter(BaseGmsClient baseGmsClient) {
            java.util.Objects.requireNonNull(baseGmsClient);
            this.f71948a = baseGmsClient;
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks
        public final void a(ConnectionResult connectionResult) {
            if (connectionResult.w0()) {
                BaseGmsClient baseGmsClient = this.f71948a;
                baseGmsClient.getRemoteService(null, baseGmsClient.getScopes());
            } else {
                BaseGmsClient baseGmsClient2 = this.f71948a;
                if (baseGmsClient2.zzl() != null) {
                    baseGmsClient2.zzl().onConnectionFailed(connectionResult);
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface SignOutCallbacks {
        void a();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    protected BaseGmsClient(Context context, Looper looper, int i3, BaseConnectionCallbacks baseConnectionCallbacks, BaseOnConnectionFailedListener baseOnConnectionFailedListener, String str) {
        GmsClientSupervisor gmsClientSupervisorB = GmsClientSupervisor.b(context);
        GoogleApiAvailabilityLight googleApiAvailabilityLightH = GoogleApiAvailabilityLight.h();
        Preconditions.m(baseConnectionCallbacks);
        Preconditions.m(baseOnConnectionFailedListener);
        this(context, looper, gmsClientSupervisorB, googleApiAvailabilityLightH, i3, baseConnectionCallbacks, baseOnConnectionFailedListener, str);
    }

    private final void e(int i3, IInterface iInterface) {
        zzs zzsVar;
        Preconditions.a((i3 == 4) == (iInterface != null));
        synchronized (this.zzp) {
            try {
                this.zzv = i3;
                this.zzs = iInterface;
                Bundle bundle = null;
                if (i3 == 1) {
                    zze zzeVar = this.zzu;
                    if (zzeVar != null) {
                        GmsClientSupervisor gmsClientSupervisor = this.zzn;
                        String strA = this.zza.a();
                        Preconditions.m(strA);
                        gmsClientSupervisor.e(strA, this.zza.b(), 4225, zzeVar, zza(), this.zza.c());
                        this.zzu = null;
                    }
                } else if (i3 == 2 || i3 == 3) {
                    zze zzeVar2 = this.zzu;
                    if (zzeVar2 != null && (zzsVar = this.zza) != null) {
                        String strA2 = zzsVar.a();
                        String strB = zzsVar.b();
                        StringBuilder sb = new StringBuilder(String.valueOf(strA2).length() + 70 + String.valueOf(strB).length());
                        sb.append("Calling connect() while still connected, missing disconnect() for ");
                        sb.append(strA2);
                        sb.append(" on ");
                        sb.append(strB);
                        Log.e("GmsClient", sb.toString());
                        GmsClientSupervisor gmsClientSupervisor2 = this.zzn;
                        String strA3 = this.zza.a();
                        Preconditions.m(strA3);
                        gmsClientSupervisor2.e(strA3, this.zza.b(), 4225, zzeVar2, zza(), this.zza.c());
                        this.zzd.incrementAndGet();
                    }
                    zze zzeVar3 = new zze(this, this.zzd.get());
                    this.zzu = zzeVar3;
                    zzs zzsVar2 = (this.zzv != 3 || getLocalStartServiceAction() == null) ? new zzs(getStartServicePackage(), getStartServiceAction(), false, 4225, getUseDynamicLookup()) : new zzs(getContext().getPackageName(), getLocalStartServiceAction(), true, 4225, false);
                    this.zza = zzsVar2;
                    if (zzsVar2.c() && getMinApkVersion() < 17895000) {
                        throw new IllegalStateException("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(String.valueOf(this.zza.a())));
                    }
                    GmsClientSupervisor gmsClientSupervisor3 = this.zzn;
                    String strA4 = this.zza.a();
                    Preconditions.m(strA4);
                    ConnectionResult connectionResultD = gmsClientSupervisor3.d(new zzn(strA4, this.zza.b(), 4225, this.zza.c()), zzeVar3, zza(), getBindServiceExecutor());
                    if (!connectionResultD.w0()) {
                        String strA5 = this.zza.a();
                        String strB2 = this.zza.b();
                        StringBuilder sb2 = new StringBuilder(String.valueOf(strA5).length() + 34 + String.valueOf(strB2).length());
                        sb2.append("unable to connect to service: ");
                        sb2.append(strA5);
                        sb2.append(" on ");
                        sb2.append(strB2);
                        Log.w("GmsClient", sb2.toString());
                        int iN = connectionResultD.N() == -1 ? 16 : connectionResultD.N();
                        if (connectionResultD.g0() != null) {
                            bundle = new Bundle();
                            bundle.putParcelable(KEY_PENDING_INTENT, connectionResultD.g0());
                        }
                        zzb(iN, bundle, this.zzd.get());
                    }
                } else if (i3 == 4) {
                    Preconditions.m(iInterface);
                    onConnectedLocked(iInterface);
                }
            } finally {
            }
        }
    }

    public void checkAvailabilityAndConnect() {
        int iJ = this.zzo.j(this.zzl, getMinApkVersion());
        if (iJ == 0) {
            connect(new LegacyClientCallbackAdapter(this));
        } else {
            e(1, null);
            triggerNotAvailable(new LegacyClientCallbackAdapter(this), iJ, null);
        }
    }

    protected final void checkConnected() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public void connect(ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        Preconditions.n(connectionProgressReportCallbacks, "Connection progress callbacks cannot be null.");
        this.zzc = connectionProgressReportCallbacks;
        e(2, null);
    }

    protected abstract IInterface createServiceInterface(IBinder iBinder);

    public void disconnect() {
        this.zzd.incrementAndGet();
        ArrayList arrayList = this.zzt;
        synchronized (arrayList) {
            try {
                int size = arrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((zzc) arrayList.get(i3)).d();
                }
                arrayList.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (this.zzq) {
            this.zzr = null;
        }
        e(1, null);
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i3;
        IInterface iInterface;
        IGmsServiceBroker iGmsServiceBroker;
        long j3;
        synchronized (this.zzp) {
            i3 = this.zzv;
            iInterface = this.zzs;
        }
        synchronized (this.zzq) {
            iGmsServiceBroker = this.zzr;
        }
        printWriter.append((CharSequence) str).append("mConnectState=");
        if (i3 == 1) {
            printWriter.print("DISCONNECTED");
        } else if (i3 == 2) {
            printWriter.print("REMOTE_CONNECTING");
        } else if (i3 == 3) {
            printWriter.print("LOCAL_CONNECTING");
        } else if (i3 == 4) {
            printWriter.print("CONNECTED");
        } else if (i3 != 5) {
            printWriter.print("UNKNOWN");
        } else {
            printWriter.print("DISCONNECTING");
        }
        printWriter.append(" mService=");
        if (iInterface == null) {
            printWriter.append("null");
        } else {
            printWriter.append((CharSequence) getServiceDescriptor()).append("@").append((CharSequence) Integer.toHexString(System.identityHashCode(iInterface.asBinder())));
        }
        printWriter.append(" mServiceBroker=");
        if (iGmsServiceBroker == null) {
            printWriter.println("null");
        } else {
            printWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(iGmsServiceBroker.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.zzh > 0) {
            PrintWriter printWriterAppend = printWriter.append((CharSequence) str).append("lastConnectedTime=");
            long j4 = this.zzh;
            String str2 = simpleDateFormat.format(new Date(j4));
            j3 = 0;
            StringBuilder sb = new StringBuilder(String.valueOf(j4).length() + 1 + String.valueOf(str2).length());
            sb.append(j4);
            sb.append(" ");
            sb.append(str2);
            printWriterAppend.println(sb.toString());
        } else {
            j3 = 0;
        }
        if (this.zzg > j3) {
            printWriter.append((CharSequence) str).append("lastSuspendedCause=");
            int i4 = this.zzf;
            if (i4 == 1) {
                printWriter.append("CAUSE_SERVICE_DISCONNECTED");
            } else if (i4 == 2) {
                printWriter.append("CAUSE_NETWORK_LOST");
            } else if (i4 != 3) {
                printWriter.append((CharSequence) String.valueOf(i4));
            } else {
                printWriter.append("CAUSE_DEAD_OBJECT_EXCEPTION");
            }
            PrintWriter printWriterAppend2 = printWriter.append(" lastSuspendedTime=");
            long j5 = this.zzg;
            String str3 = simpleDateFormat.format(new Date(j5));
            StringBuilder sb2 = new StringBuilder(String.valueOf(j5).length() + 1 + String.valueOf(str3).length());
            sb2.append(j5);
            sb2.append(" ");
            sb2.append(str3);
            printWriterAppend2.println(sb2.toString());
        }
        if (this.zzj > j3) {
            printWriter.append((CharSequence) str).append("lastFailedStatus=").append((CharSequence) CommonStatusCodes.a(this.zzi));
            PrintWriter printWriterAppend3 = printWriter.append(" lastFailedTime=");
            long j6 = this.zzj;
            String str4 = simpleDateFormat.format(new Date(j6));
            StringBuilder sb3 = new StringBuilder(String.valueOf(j6).length() + 1 + String.valueOf(str4).length());
            sb3.append(j6);
            sb3.append(" ");
            sb3.append(str4);
            printWriterAppend3.println(sb3.toString());
        }
    }

    protected boolean enableLocalFallback() {
        return false;
    }

    public Account getAccount() {
        return null;
    }

    public Feature[] getApiFeatures() {
        return zze;
    }

    public AttributionSourceWrapper getAttributionSourceWrapper() {
        return this.zzB;
    }

    public final Feature[] getAvailableFeatures() {
        zzj zzjVar = this.zzE;
        if (zzjVar == null) {
            return null;
        }
        return zzjVar.f72107b;
    }

    protected Executor getBindServiceExecutor() {
        return null;
    }

    public Bundle getConnectionHint() {
        return null;
    }

    public final Context getContext() {
        return this.zzl;
    }

    public String getEndpointPackageName() {
        zzs zzsVar;
        if (!isConnected() || (zzsVar = this.zza) == null) {
            throw new RuntimeException("Failed to connect when checking package");
        }
        return zzsVar.b();
    }

    public int getGCoreServiceId() {
        return this.zzy;
    }

    protected Bundle getGetServiceRequestExtraArgs() {
        return new Bundle();
    }

    public String getLastDisconnectMessage() {
        return this.zzk;
    }

    protected String getLocalStartServiceAction() {
        return null;
    }

    public final Looper getLooper() {
        return this.zzm;
    }

    public int getMinApkVersion() {
        return GoogleApiAvailabilityLight.f71453a;
    }

    public void getRemoteService(IAccountAccessor iAccountAccessor, Set<Scope> set) {
        AttributionSource attributionSourceA;
        Bundle getServiceRequestExtraArgs = getGetServiceRequestExtraArgs();
        String attributionTag = (Build.VERSION.SDK_INT < 31 || this.zzB == null || (attributionSourceA = this.zzB.a()) == null || attributionSourceA.getAttributionTag() == null) ? this.zzA : attributionSourceA.getAttributionTag();
        String str = attributionTag;
        int i3 = this.zzy;
        int i4 = GoogleApiAvailabilityLight.f71453a;
        Scope[] scopeArr = GetServiceRequest.f71974p;
        Bundle bundle = new Bundle();
        Feature[] featureArr = GetServiceRequest.f71975q;
        GetServiceRequest getServiceRequest = new GetServiceRequest(6, i3, i4, null, null, scopeArr, bundle, null, featureArr, featureArr, true, 0, false, str);
        getServiceRequest.f71979d = this.zzl.getPackageName();
        getServiceRequest.f71982h = getServiceRequestExtraArgs;
        if (set != null) {
            getServiceRequest.f71981g = (Scope[]) set.toArray(new Scope[0]);
        }
        if (requiresSignIn()) {
            Account account = getAccount();
            if (account == null) {
                account = new Account(DEFAULT_ACCOUNT, "com.google");
            }
            getServiceRequest.f71983i = account;
            if (iAccountAccessor != null) {
                getServiceRequest.f71980f = iAccountAccessor.asBinder();
            }
        } else if (requiresAccount()) {
            getServiceRequest.f71983i = getAccount();
        }
        getServiceRequest.f71984j = zze;
        getServiceRequest.f71985k = getApiFeatures();
        if (usesClientTelemetry()) {
            getServiceRequest.f71988n = true;
        }
        try {
            synchronized (this.zzq) {
                try {
                    IGmsServiceBroker iGmsServiceBroker = this.zzr;
                    if (iGmsServiceBroker != null) {
                        iGmsServiceBroker.N2(new zzd(this, this.zzd.get()), getServiceRequest);
                    } else {
                        Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                    }
                } finally {
                }
            }
        } catch (DeadObjectException e3) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e3);
            triggerConnectionSuspended(3);
        } catch (RemoteException e4) {
            e = e4;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            onPostInitHandler(8, null, null, this.zzd.get());
        } catch (SecurityException e5) {
            throw e5;
        } catch (RuntimeException e6) {
            e = e6;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            onPostInitHandler(8, null, null, this.zzd.get());
        }
    }

    protected Set<Scope> getScopes() {
        return Collections.EMPTY_SET;
    }

    public final T getService() throws DeadObjectException {
        T t2;
        synchronized (this.zzp) {
            try {
                if (this.zzv == 5) {
                    throw new DeadObjectException();
                }
                checkConnected();
                IInterface iInterface = this.zzs;
                Preconditions.n(iInterface, "Client is connected but service is null");
                t2 = (T) iInterface;
            } catch (Throwable th) {
                throw th;
            }
        }
        return t2;
    }

    public IBinder getServiceBrokerBinder() {
        synchronized (this.zzq) {
            try {
                IGmsServiceBroker iGmsServiceBroker = this.zzr;
                if (iGmsServiceBroker == null) {
                    return null;
                }
                return iGmsServiceBroker.asBinder();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    protected abstract String getServiceDescriptor();

    public Intent getSignInIntent() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    protected abstract String getStartServiceAction();

    protected String getStartServicePackage() {
        return "com.google.android.gms";
    }

    public ConnectionTelemetryConfiguration getTelemetryConfiguration() {
        zzj zzjVar = this.zzE;
        if (zzjVar == null) {
            return null;
        }
        return zzjVar.f72109d;
    }

    protected boolean getUseDynamicLookup() {
        return getMinApkVersion() >= 211700000;
    }

    public boolean hasConnectionInfo() {
        return this.zzE != null;
    }

    public boolean isConnected() {
        boolean z2;
        synchronized (this.zzp) {
            z2 = this.zzv == 4;
        }
        return z2;
    }

    public boolean isConnecting() {
        boolean z2;
        synchronized (this.zzp) {
            int i3 = this.zzv;
            z2 = true;
            if (i3 != 2 && i3 != 3) {
                z2 = false;
            }
        }
        return z2;
    }

    protected void onConnectedLocked(T t2) {
        this.zzh = System.currentTimeMillis();
    }

    protected void onConnectionFailed(ConnectionResult connectionResult) {
        this.zzi = connectionResult.N();
        this.zzj = System.currentTimeMillis();
    }

    protected void onConnectionSuspended(int i3) {
        this.zzf = i3;
        this.zzg = System.currentTimeMillis();
    }

    protected void onPostInitHandler(int i3, IBinder iBinder, Bundle bundle, int i4) {
        zzf zzfVar = new zzf(this, i3, iBinder, bundle);
        Handler handler = this.zzb;
        handler.sendMessage(handler.obtainMessage(1, i4, -1, zzfVar));
    }

    public void onUserSignOut(SignOutCallbacks signOutCallbacks) {
        signOutCallbacks.a();
    }

    public boolean providesSignIn() {
        return false;
    }

    public boolean requiresAccount() {
        return false;
    }

    public boolean requiresGooglePlayServices() {
        return true;
    }

    public boolean requiresSignIn() {
        return false;
    }

    public void setAttributionSourceWrapper(AttributionSourceWrapper attributionSourceWrapper) {
        this.zzB = attributionSourceWrapper;
    }

    public void setAttributionTag(String str) {
        this.zzA = str;
    }

    public void triggerConnectionSuspended(int i3) {
        int i4 = this.zzd.get();
        Handler handler = this.zzb;
        handler.sendMessage(handler.obtainMessage(6, i4, i3));
    }

    protected void triggerNotAvailable(ConnectionProgressReportCallbacks connectionProgressReportCallbacks, int i3, PendingIntent pendingIntent) {
        Preconditions.n(connectionProgressReportCallbacks, "Connection progress callbacks cannot be null.");
        this.zzc = connectionProgressReportCallbacks;
        int i4 = this.zzd.get();
        Handler handler = this.zzb;
        handler.sendMessage(handler.obtainMessage(3, i4, i3, pendingIntent));
    }

    public boolean usesClientTelemetry() {
        return false;
    }

    protected final String zza() {
        String str = this.zzz;
        return str == null ? this.zzl.getClass().getName() : str;
    }

    protected final void zzb(int i3, Bundle bundle, int i4) {
        zzg zzgVar = new zzg(this, i3, bundle);
        Handler handler = this.zzb;
        handler.sendMessage(handler.obtainMessage(7, i4, -1, zzgVar));
    }

    final /* synthetic */ void zzc(zzj zzjVar) {
        this.zzE = zzjVar;
        if (usesClientTelemetry()) {
            ConnectionTelemetryConfiguration connectionTelemetryConfiguration = zzjVar.f72109d;
            RootTelemetryConfigManager.b().c(connectionTelemetryConfiguration == null ? null : connectionTelemetryConfiguration.w0());
        }
    }

    final /* synthetic */ void zzd(int i3, IInterface iInterface) {
        e(i3, null);
    }

    final /* synthetic */ boolean zze(int i3, int i4, IInterface iInterface) {
        synchronized (this.zzp) {
            try {
                if (this.zzv != i3) {
                    return false;
                }
                e(i4, iInterface);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    final /* synthetic */ void zzf(int i3) {
        int i4;
        int i5;
        synchronized (this.zzp) {
            i4 = this.zzv;
        }
        if (i4 == 3) {
            this.zzD = true;
            i5 = 5;
        } else {
            i5 = 4;
        }
        Handler handler = this.zzb;
        handler.sendMessage(handler.obtainMessage(i5, this.zzd.get(), 16));
    }

    final /* synthetic */ boolean zzg() {
        if (this.zzD || TextUtils.isEmpty(getServiceDescriptor()) || TextUtils.isEmpty(getLocalStartServiceAction())) {
            return false;
        }
        try {
            Class.forName(getServiceDescriptor());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    final /* synthetic */ Object zzh() {
        return this.zzq;
    }

    final /* synthetic */ void zzi(IGmsServiceBroker iGmsServiceBroker) {
        this.zzr = iGmsServiceBroker;
    }

    final /* synthetic */ ArrayList zzj() {
        return this.zzt;
    }

    final /* synthetic */ BaseConnectionCallbacks zzk() {
        return this.zzw;
    }

    final /* synthetic */ BaseOnConnectionFailedListener zzl() {
        return this.zzx;
    }

    final /* synthetic */ ConnectionResult zzm() {
        return this.zzC;
    }

    final /* synthetic */ void zzn(ConnectionResult connectionResult) {
        this.zzC = connectionResult;
    }

    final /* synthetic */ boolean zzo() {
        return this.zzD;
    }

    protected BaseGmsClient(Context context, Looper looper, GmsClientSupervisor gmsClientSupervisor, GoogleApiAvailabilityLight googleApiAvailabilityLight, int i3, BaseConnectionCallbacks baseConnectionCallbacks, BaseOnConnectionFailedListener baseOnConnectionFailedListener, String str) {
        this.zzk = null;
        this.zzp = new Object();
        this.zzq = new Object();
        this.zzt = new ArrayList();
        this.zzv = 1;
        this.zzC = null;
        this.zzD = false;
        this.zzE = null;
        this.zzd = new AtomicInteger(0);
        Preconditions.n(context, "Context must not be null");
        this.zzl = context;
        Preconditions.n(looper, "Looper must not be null");
        this.zzm = looper;
        Preconditions.n(gmsClientSupervisor, "Supervisor must not be null");
        this.zzn = gmsClientSupervisor;
        Preconditions.n(googleApiAvailabilityLight, "API availability must not be null");
        this.zzo = googleApiAvailabilityLight;
        this.zzb = new zzb(this, looper);
        this.zzy = i3;
        this.zzw = baseConnectionCallbacks;
        this.zzx = baseOnConnectionFailedListener;
        this.zzz = str;
    }

    public void disconnect(String str) {
        this.zzk = str;
        disconnect();
    }
}
