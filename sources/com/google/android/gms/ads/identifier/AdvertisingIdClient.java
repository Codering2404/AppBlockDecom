package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.BlockingServiceConnection;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.ads_identifier.zzf;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@ParametersAreNonnullByDefault
public class AdvertisingIdClient {
    private static final Object zzg = new Object();
    private static volatile AdvertisingIdClient zzh;
    BlockingServiceConnection zza;
    zzf zzb;
    boolean zzc;
    final Object zzd;
    zzb zze;
    final long zzf;
    private final Context zzi;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Info {
        private final String zza;
        private final boolean zzb;

        @Deprecated
        public Info(String str, boolean z2) {
            this.zza = str;
            this.zzb = z2;
        }

        public String getId() {
            return this.zza;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.zzb;
        }

        public String toString() {
            return "{" + this.zza + "}" + this.zzb;
        }
    }

    public AdvertisingIdClient(Context context) {
        this(context, 30000L, false, false);
    }

    public static Info getAdvertisingIdInfo(Context context) throws Throwable {
        Info infoZzf;
        long jElapsedRealtime;
        AdvertisingIdClient advertisingIdClient = zzh;
        if (advertisingIdClient == null) {
            synchronized (zzg) {
                try {
                    advertisingIdClient = zzh;
                    if (advertisingIdClient == null) {
                        Log.d("AdvertisingIdClient", "Creating AdvertisingIdClient");
                        advertisingIdClient = new AdvertisingIdClient(context);
                        zzh = advertisingIdClient;
                    }
                } finally {
                }
            }
        }
        AdvertisingIdClient advertisingIdClient2 = advertisingIdClient;
        Log.d("AdvertisingIdClient", "AdvertisingIdClient already created.");
        zzd zzdVarZza = zzd.zza(context);
        long jElapsedRealtime2 = SystemClock.elapsedRealtime();
        int i3 = -1;
        try {
            infoZzf = advertisingIdClient2.zzf(-1);
            jElapsedRealtime = SystemClock.elapsedRealtime() - jElapsedRealtime2;
            advertisingIdClient2.zze(infoZzf, true, 0.0f, jElapsedRealtime, "", null);
        } catch (Throwable th) {
            th = th;
        }
        try {
            zzdVarZza.zzc(35401, 0, jElapsedRealtime2, System.currentTimeMillis(), (int) (SystemClock.elapsedRealtime() - jElapsedRealtime2));
            jElapsedRealtime2 = jElapsedRealtime2;
            Log.i("AdvertisingIdClient", "GetInfoInternal elapse " + jElapsedRealtime + "ms");
            return infoZzf;
        } catch (Throwable th2) {
            th = th2;
            zzdVarZza = zzdVarZza;
            jElapsedRealtime2 = jElapsedRealtime2;
            Throwable th3 = th;
            advertisingIdClient2.zze(null, true, 0.0f, -1L, "", th3);
            if (th3 instanceof IOException) {
                i3 = 1;
            } else if (th3 instanceof GooglePlayServicesNotAvailableException) {
                i3 = 9;
            } else if (th3 instanceof GooglePlayServicesRepairableException) {
                i3 = 16;
            } else if (th3 instanceof IllegalStateException) {
                i3 = 8;
            }
            zzdVarZza.zzc(35401, i3, jElapsedRealtime2, System.currentTimeMillis(), (int) (SystemClock.elapsedRealtime() - jElapsedRealtime2));
            throw th3;
        }
    }

    public static boolean getIsAdIdFakeForDebugLogging(Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException, IOException {
        boolean zZzd;
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1L, false, false);
        try {
            advertisingIdClient.zzc(false);
            Preconditions.l("Calling this from your main thread can lead to deadlock");
            synchronized (advertisingIdClient) {
                advertisingIdClient.zzd();
                Preconditions.m(advertisingIdClient.zza);
                Preconditions.m(advertisingIdClient.zzb);
                try {
                    zZzd = advertisingIdClient.zzb.zzd();
                } catch (RemoteException e3) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e3);
                    throw new IOException("Remote exception", e3);
                }
            }
            advertisingIdClient.zzb();
            advertisingIdClient.zza();
            return zZzd;
        } catch (Throwable th) {
            advertisingIdClient.zza();
            throw th;
        }
    }

    private final Info zzf(int i3) throws IOException {
        Info info;
        Preconditions.l("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            zzd();
            Preconditions.m(this.zza);
            Preconditions.m(this.zzb);
            try {
                info = new Info(this.zzb.zzc(), this.zzb.zze(true));
            } catch (RemoteException e3) {
                Log.i("AdvertisingIdClient", "GMS remote exception ", e3);
                throw new IOException("Remote exception", e3);
            }
        }
        zzb();
        return info;
    }

    protected final void finalize() throws Throwable {
        zza();
        super.finalize();
    }

    public Info getInfo() throws IOException {
        return zzf(-1);
    }

    public void start() throws GooglePlayServicesRepairableException, IllegalStateException, GooglePlayServicesNotAvailableException, IOException {
        zzc(true);
    }

    public final void zza() {
        Preconditions.l("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (this.zzi == null || this.zza == null) {
                    return;
                }
                try {
                    if (this.zzc) {
                        ConnectionTracker.b().c(this.zzi, this.zza);
                    }
                } catch (Throwable th) {
                    Log.i("AdvertisingIdClient", "AdvertisingIdClient unbindService failed.", th);
                }
                this.zzc = false;
                this.zzb = null;
                this.zza = null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    final void zzb() {
        synchronized (this.zzd) {
            zzb zzbVar = this.zze;
            if (zzbVar != null) {
                zzbVar.zza.countDown();
                try {
                    this.zze.join();
                } catch (InterruptedException unused) {
                }
            }
            long j3 = this.zzf;
            if (j3 > 0) {
                this.zze = new zzb(this, j3);
            }
        }
    }

    protected final void zzc(boolean z2) throws GooglePlayServicesRepairableException, IllegalStateException, GooglePlayServicesNotAvailableException, IOException {
        IOException iOException;
        Preconditions.l("Calling this from your main thread can lead to deadlock");
        if (z2) {
            zzb();
        }
        synchronized (this) {
            try {
                if (this.zzc) {
                    return;
                }
                Context context = this.zzi;
                try {
                    context.getPackageManager().getPackageInfo("com.android.vending", 0);
                    int iJ = GoogleApiAvailabilityLight.h().j(context, 12451000);
                    if (iJ != 0 && iJ != 2) {
                        throw new IOException("Google Play services not available");
                    }
                    BlockingServiceConnection blockingServiceConnection = new BlockingServiceConnection();
                    Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                    intent.setPackage("com.google.android.gms");
                    try {
                        if (!ConnectionTracker.b().a(context, intent, blockingServiceConnection, 1)) {
                            throw new IOException("Connection failure");
                        }
                        this.zza = blockingServiceConnection;
                        try {
                            try {
                                this.zzb = com.google.android.gms.internal.ads_identifier.zze.zza(blockingServiceConnection.a(10000L, TimeUnit.MILLISECONDS));
                                this.zzc = true;
                            } catch (InterruptedException unused) {
                                throw new IOException("Interrupted exception");
                            }
                        } finally {
                        }
                    } finally {
                    }
                } catch (PackageManager.NameNotFoundException unused2) {
                    throw new GooglePlayServicesNotAvailableException(9);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    final synchronized void zzd() throws IOException {
        try {
            if (!this.zzc) {
                try {
                    Log.d("AdvertisingIdClient", "AdvertisingIdClient is not bounded. Starting to bind it...");
                    zzc(false);
                    Log.d("AdvertisingIdClient", "AdvertisingIdClient is bounded");
                    if (!this.zzc) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (Exception e3) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e3);
                }
            }
        } finally {
        }
    }

    final boolean zze(Info info, boolean z2, float f3, long j3, String str, Throwable th) {
        if (Math.random() > 0.0d) {
            return false;
        }
        HashMap map = new HashMap();
        String str2 = AppEventsConstants.EVENT_PARAM_VALUE_YES;
        map.put("app_context", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        if (info != null) {
            if (true != info.isLimitAdTrackingEnabled()) {
                str2 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
            map.put("limit_ad_tracking", str2);
            String id = info.getId();
            if (id != null) {
                map.put("ad_id_size", Integer.toString(id.length()));
            }
        }
        if (th != null) {
            map.put("error", th.getClass().getName());
        }
        map.put("tag", "AdvertisingIdClient");
        map.put("time_spent", Long.toString(j3));
        new zza(this, map).start();
        return true;
    }

    public AdvertisingIdClient(Context context, long j3, boolean z2, boolean z3) {
        this.zzd = new Object();
        Preconditions.m(context);
        this.zzi = context.getApplicationContext();
        this.zzc = false;
        this.zzf = j3;
    }

    public static void setShouldSkipGmsCoreVersionCheck(boolean z2) {
    }
}
