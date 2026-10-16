package com.google.android.gms.tagmanager;

import android.util.Log;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zza implements zzc {
    final /* synthetic */ zzd zza;

    zza(zzd zzdVar) {
        this.zza = zzdVar;
    }

    @Override // com.google.android.gms.tagmanager.zzc
    public final AdvertisingIdClient.Info zza() {
        try {
            return AdvertisingIdClient.getAdvertisingIdInfo(this.zza.zzi);
        } catch (GooglePlayServicesNotAvailableException e3) {
            this.zza.zze();
            Log.w("GoogleTagManager", "GooglePlayServicesNotAvailableException getting Advertising Id Info", e3);
            return null;
        } catch (GooglePlayServicesRepairableException e4) {
            Log.w("GoogleTagManager", "GooglePlayServicesRepairableException getting Advertising Id Info", e4);
            return null;
        } catch (IOException e5) {
            Log.w("GoogleTagManager", "IOException getting Ad Id Info", e5);
            return null;
        } catch (IllegalStateException e6) {
            Log.w("GoogleTagManager", "IllegalStateException getting Advertising Id Info", e6);
            return null;
        } catch (Exception e7) {
            Log.w("GoogleTagManager", "Unknown exception. Could not get the Advertising Id Info.", e7);
            return null;
        }
    }
}
