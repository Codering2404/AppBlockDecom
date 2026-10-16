package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import com.applovin.impl.mediation.nativeAds.xNe.qRMDmh;
import com.facebook.internal.AnalyticsEvents;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationAppOpenAd;
import com.google.android.gms.ads.mediation.MediationAppOpenAdConfiguration;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.mediation.MediationInterscrollerAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.OnContextChangedListener;
import com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import cz.mobilesoft.coreblock.view.screen.ohO.MHoiDDglUlPJC;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbwd extends zzbve {
    private final Object zza;
    private zzbwf zzb;
    private zzcca zzc;
    private IObjectWrapper zzd;
    private View zze;
    private MediationInterstitialAd zzf;
    private UnifiedNativeAdMapper zzg;
    private NativeAdMapper zzh;
    private MediationRewardedAd zzi;
    private MediationInterscrollerAd zzj;
    private MediationAppOpenAd zzk;
    private final String zzl = "";

    public zzbwd(Adapter adapter) {
        this.zza = adapter;
    }

    private final Bundle zzV(String str, com.google.android.gms.ads.internal.client.zzm zzmVar, String str2) throws RemoteException {
        com.google.android.gms.ads.internal.util.client.zzo.a("Server parameters: ".concat(String.valueOf(str)));
        try {
            Bundle bundle = new Bundle();
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                Bundle bundle2 = new Bundle();
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    bundle2.putString(next, jSONObject.getString(next));
                }
                bundle = bundle2;
            }
            if (this.zza instanceof AdMobAdapter) {
                bundle.putString("adJson", str2);
                if (zzmVar != null) {
                    bundle.putInt("tagForChildDirectedTreatment", zzmVar.f69970h);
                }
            }
            bundle.remove("max_ad_content_rating");
            return bundle;
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", th);
            throw new RemoteException();
        }
    }

    private final Bundle zzW(com.google.android.gms.ads.internal.client.zzm zzmVar) {
        Bundle bundle;
        Bundle bundle2 = zzmVar.f69976n;
        return (bundle2 == null || (bundle = bundle2.getBundle(this.zza.getClass().getName())) == null) ? new Bundle() : bundle;
    }

    private static final boolean zzX(com.google.android.gms.ads.internal.client.zzm zzmVar) {
        if (zzmVar.f69969g) {
            return true;
        }
        com.google.android.gms.ads.internal.client.zzay.a();
        return com.google.android.gms.ads.internal.util.client.zzf.F();
    }

    private static final String zzY(String str, com.google.android.gms.ads.internal.client.zzm zzmVar) {
        try {
            return new JSONObject(str).getString("max_ad_content_rating");
        } catch (JSONException unused) {
            return zzmVar.f69984v;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final void zzA(boolean z2) throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof OnImmersiveModeUpdatedListener) {
            try {
                ((OnImmersiveModeUpdatedListener) obj).onImmersiveModeUpdated(z2);
                return;
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.util.client.zzo.d("", th);
                return;
            }
        }
        String canonicalName = OnImmersiveModeUpdatedListener.class.getCanonicalName();
        String canonicalName2 = obj.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        com.google.android.gms.ads.internal.util.client.zzo.a(sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final com.google.android.gms.ads.internal.client.zzea zzB() {
        Object obj = this.zza;
        if (obj instanceof com.google.android.gms.ads.mediation.zza) {
            try {
                return ((com.google.android.gms.ads.mediation.zza) obj).getVideoController();
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.util.client.zzo.d("", th);
            }
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final zzbvr zzC() {
        UnifiedNativeAdMapper unifiedNativeAdMapperZzb;
        Object obj = this.zza;
        if (obj instanceof MediationNativeAdapter) {
            zzbwf zzbwfVar = this.zzb;
            if (zzbwfVar == null || (unifiedNativeAdMapperZzb = zzbwfVar.zzb()) == null) {
                return null;
            }
            return new zzbwj(unifiedNativeAdMapperZzb);
        }
        if (!(obj instanceof Adapter)) {
            return null;
        }
        NativeAdMapper nativeAdMapper = this.zzh;
        if (nativeAdMapper != null) {
            return new zzbwh(nativeAdMapper);
        }
        UnifiedNativeAdMapper unifiedNativeAdMapper = this.zzg;
        if (unifiedNativeAdMapper != null) {
            return new zzbwj(unifiedNativeAdMapper);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final void zzD(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzbvi zzbviVar) throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof Adapter) {
            com.google.android.gms.ads.internal.util.client.zzo.a("Requesting rewarded ad from adapter.");
            try {
                ((Adapter) obj).loadRewardedAd(new MediationRewardedAdConfiguration((Context) ObjectWrapper.h5(iObjectWrapper), "", zzV(str, zzmVar, null), zzW(zzmVar), zzX(zzmVar), zzmVar.f69974l, zzmVar.f69970h, zzmVar.f69983u, zzY(str, zzmVar), ""), new zzbwb(this, zzbviVar));
                return;
            } catch (Exception e3) {
                com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
                zzbuz.zza(iObjectWrapper, e3, "adapter.loadRewardedAd");
                throw new RemoteException();
            }
        }
        String canonicalName = Adapter.class.getCanonicalName();
        String canonicalName2 = obj.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        com.google.android.gms.ads.internal.util.client.zzo.f(sb.toString());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final void zzE(IObjectWrapper iObjectWrapper) throws RemoteException {
        Object obj = this.zza;
        if (!(obj instanceof Adapter)) {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = obj.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            com.google.android.gms.ads.internal.util.client.zzo.f(sb.toString());
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzo.a("Show rewarded ad from adapter.");
        MediationRewardedAd mediationRewardedAd = this.zzi;
        if (mediationRewardedAd == null) {
            com.google.android.gms.ads.internal.util.client.zzo.c("Can not show null mediation rewarded ad.");
            throw new RemoteException();
        }
        try {
            mediationRewardedAd.showAd((Context) ObjectWrapper.h5(iObjectWrapper));
        } catch (RuntimeException e3) {
            zzbuz.zza(iObjectWrapper, e3, "adapter.rewarded.showAd");
            throw e3;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.google.android.gms.internal.ads.zzbvf
    public final void zzF(IObjectWrapper iObjectWrapper, zzbrt zzbrtVar, List list) throws RemoteException {
        Object obj = this.zza;
        if (!(obj instanceof Adapter)) {
            throw new RemoteException();
        }
        try {
            zzbvw zzbvwVar = new zzbvw(this, zzbrtVar);
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                zzbrz zzbrzVar = (zzbrz) it.next();
                String str = zzbrzVar.zza;
                AdFormat adFormat = null;
                switch (str.hashCode()) {
                    case -1396342996:
                        if (str.equals("banner")) {
                            adFormat = AdFormat.BANNER;
                        }
                        break;
                    case -1052618729:
                        if (str.equals(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE)) {
                            adFormat = AdFormat.NATIVE;
                        }
                        break;
                    case -239580146:
                        if (str.equals("rewarded")) {
                            adFormat = AdFormat.REWARDED;
                        }
                        break;
                    case 604727084:
                        if (str.equals("interstitial")) {
                            adFormat = AdFormat.INTERSTITIAL;
                        }
                        break;
                    case 1167692200:
                        if (str.equals("app_open")) {
                            adFormat = AdFormat.APP_OPEN_AD;
                        }
                        break;
                    case 1778294298:
                        if (str.equals("app_open_ad")) {
                            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzno)).booleanValue()) {
                                adFormat = AdFormat.APP_OPEN_AD;
                            }
                        }
                        break;
                    case 1911491517:
                        if (str.equals("rewarded_interstitial")) {
                            adFormat = AdFormat.REWARDED_INTERSTITIAL;
                        }
                        break;
                }
                if (adFormat != null) {
                    arrayList.add(new MediationConfiguration(adFormat, zzbrzVar.zzb));
                }
            }
            ((Adapter) obj).initialize((Context) ObjectWrapper.h5(iObjectWrapper), zzbvwVar, arrayList);
        } catch (Throwable th) {
            zzbuz.zza(iObjectWrapper, th, "adapter.initialize");
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final void zzG(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzbvi zzbviVar) throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof Adapter) {
            com.google.android.gms.ads.internal.util.client.zzo.a("Requesting rewarded interstitial ad from adapter.");
            try {
                ((Adapter) obj).loadRewardedInterstitialAd(new MediationRewardedAdConfiguration((Context) ObjectWrapper.h5(iObjectWrapper), "", zzV(str, zzmVar, null), zzW(zzmVar), zzX(zzmVar), zzmVar.f69974l, zzmVar.f69970h, zzmVar.f69983u, zzY(str, zzmVar), ""), new zzbwb(this, zzbviVar));
                return;
            } catch (Exception e3) {
                zzbuz.zza(iObjectWrapper, e3, "adapter.loadRewardedInterstitialAd");
                throw new RemoteException();
            }
        }
        String canonicalName = Adapter.class.getCanonicalName();
        String canonicalName2 = obj.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        com.google.android.gms.ads.internal.util.client.zzo.f(sb.toString());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final zzbxq zzH() {
        Object obj = this.zza;
        if (obj instanceof Adapter) {
            return zzbxq.zza(((Adapter) obj).getVersionInfo());
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final zzbxq zzI() {
        Object obj = this.zza;
        if (obj instanceof Adapter) {
            return zzbxq.zza(((Adapter) obj).getSDKVersionInfo());
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final void zzJ(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzr zzrVar, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, String str2, zzbvi zzbviVar) throws RemoteException {
        Object obj = this.zza;
        if (!(obj instanceof Adapter)) {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = obj.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            com.google.android.gms.ads.internal.util.client.zzo.f(sb.toString());
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzo.a("Requesting interscroller ad from adapter.");
        try {
            Adapter adapter = (Adapter) obj;
            zzbvv zzbvvVar = new zzbvv(this, zzbviVar, adapter);
            zzV(str, zzmVar, str2);
            zzW(zzmVar);
            zzX(zzmVar);
            Location location = zzmVar.f69974l;
            zzY(str, zzmVar);
            com.google.android.gms.ads.zzc.c(zzrVar.f70008f, zzrVar.f70005b);
            zzbvvVar.onFailure(new AdError(7, adapter.getClass().getSimpleName().concat(" does not support interscroller ads."), "com.google.android.gms.ads"));
        } catch (Exception e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
            zzbuz.zza(iObjectWrapper, e3, "adapter.loadInterscrollerAd");
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final zzbvl zzK() {
        MediationInterscrollerAd mediationInterscrollerAd = this.zzj;
        if (mediationInterscrollerAd != null) {
            return new zzbwe(mediationInterscrollerAd);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final void zzL(IObjectWrapper iObjectWrapper) throws RemoteException {
        Object obj = this.zza;
        if ((obj instanceof Adapter) || (obj instanceof MediationInterstitialAdapter)) {
            if (obj instanceof MediationInterstitialAdapter) {
                zzh();
                return;
            }
            com.google.android.gms.ads.internal.util.client.zzo.a("Show interstitial ad from adapter.");
            MediationInterstitialAd mediationInterstitialAd = this.zzf;
            if (mediationInterstitialAd == null) {
                com.google.android.gms.ads.internal.util.client.zzo.c("Can not show null mediation interstitial ad.");
                throw new RemoteException();
            }
            try {
                mediationInterstitialAd.showAd((Context) ObjectWrapper.h5(iObjectWrapper));
                return;
            } catch (RuntimeException e3) {
                zzbuz.zza(iObjectWrapper, e3, "adapter.interstitial.showAd");
                throw e3;
            }
        }
        String canonicalName = MediationInterstitialAdapter.class.getCanonicalName();
        String canonicalName2 = Adapter.class.getCanonicalName();
        String canonicalName3 = obj.getClass().getCanonicalName();
        int length = String.valueOf(canonicalName).length();
        StringBuilder sb = new StringBuilder(length + 4 + String.valueOf(canonicalName2).length() + 22 + String.valueOf(canonicalName3).length());
        sb.append(canonicalName);
        sb.append(" or ");
        sb.append(canonicalName2);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName3);
        com.google.android.gms.ads.internal.util.client.zzo.f(sb.toString());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final void zzM(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzbvi zzbviVar) throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof Adapter) {
            com.google.android.gms.ads.internal.util.client.zzo.a("Requesting app open ad from adapter.");
            try {
                ((Adapter) obj).loadAppOpenAd(new MediationAppOpenAdConfiguration((Context) ObjectWrapper.h5(iObjectWrapper), "", zzV(str, zzmVar, null), zzW(zzmVar), zzX(zzmVar), zzmVar.f69974l, zzmVar.f69970h, zzmVar.f69983u, zzY(str, zzmVar), ""), new zzbwc(this, zzbviVar));
                return;
            } catch (Exception e3) {
                com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
                zzbuz.zza(iObjectWrapper, e3, "adapter.loadAppOpenAd");
                throw new RemoteException();
            }
        }
        String canonicalName = Adapter.class.getCanonicalName();
        String canonicalName2 = obj.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        com.google.android.gms.ads.internal.util.client.zzo.f(sb.toString());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final void zzN(IObjectWrapper iObjectWrapper) throws RemoteException {
        Object obj = this.zza;
        if (!(obj instanceof Adapter)) {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = obj.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            com.google.android.gms.ads.internal.util.client.zzo.f(sb.toString());
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzo.a("Show app open ad from adapter.");
        MediationAppOpenAd mediationAppOpenAd = this.zzk;
        if (mediationAppOpenAd == null) {
            com.google.android.gms.ads.internal.util.client.zzo.c("Can not show null mediation app open ad.");
            throw new RemoteException();
        }
        try {
            mediationAppOpenAd.showAd((Context) ObjectWrapper.h5(iObjectWrapper));
        } catch (RuntimeException e3) {
            zzbuz.zza(iObjectWrapper, e3, "adapter.appOpen.showAd");
            throw e3;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final zzbvn zzO() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final zzbvo zzP() {
        return null;
    }

    final /* synthetic */ void zzQ(UnifiedNativeAdMapper unifiedNativeAdMapper) {
        this.zzg = unifiedNativeAdMapper;
    }

    final /* synthetic */ void zzR(NativeAdMapper nativeAdMapper) {
        this.zzh = nativeAdMapper;
    }

    final /* synthetic */ void zzS(MediationRewardedAd mediationRewardedAd) {
        this.zzi = mediationRewardedAd;
    }

    final /* synthetic */ void zzT(MediationInterscrollerAd mediationInterscrollerAd) {
        this.zzj = mediationInterscrollerAd;
    }

    final /* synthetic */ void zzU(MediationAppOpenAd mediationAppOpenAd) {
        this.zzk = mediationAppOpenAd;
    }

    final /* synthetic */ Object zzb() {
        return this.zza;
    }

    final /* synthetic */ void zzc(View view) {
        this.zze = view;
    }

    final /* synthetic */ void zzd(MediationInterstitialAd mediationInterstitialAd) {
        this.zzf = mediationInterstitialAd;
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final void zze(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzr zzrVar, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzbvi zzbviVar) throws RemoteException {
        zzj(iObjectWrapper, zzrVar, zzmVar, str, null, zzbviVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final void zzg(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzbvi zzbviVar) throws RemoteException {
        zzk(iObjectWrapper, zzmVar, str, null, zzbviVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final void zzh() throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof MediationInterstitialAdapter) {
            com.google.android.gms.ads.internal.util.client.zzo.a("Showing interstitial from adapter.");
            try {
                ((MediationInterstitialAdapter) obj).showInterstitial();
                return;
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.util.client.zzo.d("", th);
                throw new RemoteException();
            }
        }
        String canonicalName = MediationInterstitialAdapter.class.getCanonicalName();
        String canonicalName2 = obj.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        com.google.android.gms.ads.internal.util.client.zzo.f(sb.toString());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final void zzi() throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onDestroy();
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.util.client.zzo.d("", th);
                throw new RemoteException();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final void zzj(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzr zzrVar, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, String str2, zzbvi zzbviVar) throws RemoteException {
        String str3;
        MediationBannerAdapter mediationBannerAdapter;
        zzbvu zzbvuVar;
        Bundle bundle;
        Object obj = this.zza;
        boolean z2 = obj instanceof MediationBannerAdapter;
        if (!z2 && !(obj instanceof Adapter)) {
            String canonicalName = MediationBannerAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = obj.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 4 + String.valueOf(canonicalName2).length() + 22 + String.valueOf(canonicalName3).length());
            sb.append(canonicalName);
            sb.append(" or ");
            sb.append(canonicalName2);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName3);
            com.google.android.gms.ads.internal.util.client.zzo.f(sb.toString());
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzo.a("Requesting banner ad from adapter.");
        AdSize adSizeB = zzrVar.f70017o ? com.google.android.gms.ads.zzc.b(zzrVar.f70008f, zzrVar.f70005b) : com.google.android.gms.ads.zzc.a(zzrVar.f70008f, zzrVar.f70005b, zzrVar.f70004a);
        if (!z2) {
            Object obj2 = this.zza;
            if (obj2 instanceof Adapter) {
                try {
                    ((Adapter) obj2).loadBannerAd(new MediationBannerAdConfiguration((Context) ObjectWrapper.h5(iObjectWrapper), "", zzV(str, zzmVar, str2), zzW(zzmVar), zzX(zzmVar), zzmVar.f69974l, zzmVar.f69970h, zzmVar.f69983u, zzY(str, zzmVar), adSizeB, this.zzl), new zzbvx(this, zzbviVar));
                    return;
                } catch (Throwable th) {
                    com.google.android.gms.ads.internal.util.client.zzo.d("", th);
                    zzbuz.zza(iObjectWrapper, th, "adapter.loadBannerAd");
                    throw new RemoteException();
                }
            }
            return;
        }
        try {
            mediationBannerAdapter = (MediationBannerAdapter) obj;
            List list = zzmVar.f69968f;
            HashSet hashSet = list != null ? new HashSet(list) : null;
            long j3 = zzmVar.f69965b;
            zzbvuVar = new zzbvu(j3 == -1 ? null : new Date(j3), zzmVar.f69967d, hashSet, zzmVar.f69974l, zzX(zzmVar), zzmVar.f69970h, zzmVar.f69981s, zzmVar.f69983u, zzY(str, zzmVar));
            Bundle bundle2 = zzmVar.f69976n;
            bundle = bundle2 != null ? bundle2.getBundle(mediationBannerAdapter.getClass().getName()) : null;
            str3 = "";
        } catch (Throwable th2) {
            th = th2;
            str3 = "";
        }
        try {
            mediationBannerAdapter.requestBannerAd((Context) ObjectWrapper.h5(iObjectWrapper), new zzbwf(zzbviVar), zzV(str, zzmVar, str2), adSizeB, zzbvuVar, bundle);
        } catch (Throwable th3) {
            th = th3;
            com.google.android.gms.ads.internal.util.client.zzo.d(str3, th);
            zzbuz.zza(iObjectWrapper, th, "adapter.requestBannerAd");
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final void zzk(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, String str2, zzbvi zzbviVar) throws RemoteException {
        Object obj = this.zza;
        boolean z2 = obj instanceof MediationInterstitialAdapter;
        if (!z2 && !(obj instanceof Adapter)) {
            String canonicalName = MediationInterstitialAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = obj.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 4 + String.valueOf(canonicalName2).length() + 22 + String.valueOf(canonicalName3).length());
            sb.append(canonicalName);
            sb.append(" or ");
            sb.append(canonicalName2);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName3);
            com.google.android.gms.ads.internal.util.client.zzo.f(sb.toString());
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzo.a("Requesting interstitial ad from adapter.");
        if (!z2) {
            Object obj2 = this.zza;
            if (obj2 instanceof Adapter) {
                try {
                    ((Adapter) obj2).loadInterstitialAd(new MediationInterstitialAdConfiguration((Context) ObjectWrapper.h5(iObjectWrapper), "", zzV(str, zzmVar, str2), zzW(zzmVar), zzX(zzmVar), zzmVar.f69974l, zzmVar.f69970h, zzmVar.f69983u, zzY(str, zzmVar), this.zzl), new zzbvy(this, zzbviVar));
                    return;
                } catch (Throwable th) {
                    com.google.android.gms.ads.internal.util.client.zzo.d("", th);
                    zzbuz.zza(iObjectWrapper, th, "adapter.loadInterstitialAd");
                    throw new RemoteException();
                }
            }
            return;
        }
        try {
            MediationInterstitialAdapter mediationInterstitialAdapter = (MediationInterstitialAdapter) obj;
            List list = zzmVar.f69968f;
            HashSet hashSet = list != null ? new HashSet(list) : null;
            long j3 = zzmVar.f69965b;
            zzbvu zzbvuVar = new zzbvu(j3 == -1 ? null : new Date(j3), zzmVar.f69967d, hashSet, zzmVar.f69974l, zzX(zzmVar), zzmVar.f69970h, zzmVar.f69981s, zzmVar.f69983u, zzY(str, zzmVar));
            Bundle bundle = zzmVar.f69976n;
            mediationInterstitialAdapter.requestInterstitialAd((Context) ObjectWrapper.h5(iObjectWrapper), new zzbwf(zzbviVar), zzV(str, zzmVar, str2), zzbvuVar, bundle != null ? bundle.getBundle(mediationInterstitialAdapter.getClass().getName()) : null);
        } catch (Throwable th2) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", th2);
            zzbuz.zza(iObjectWrapper, th2, "adapter.requestInterstitialAd");
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final void zzl() throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onPause();
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.util.client.zzo.d("", th);
                throw new RemoteException();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final void zzm() throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onResume();
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.util.client.zzo.d("", th);
                throw new RemoteException();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final void zzn(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzcca zzccaVar, String str2) throws RemoteException {
        Object obj = this.zza;
        if ((obj instanceof Adapter) || Objects.equals(obj.getClass().getCanonicalName(), "com.google.ads.mediation.admob.AdMobAdapter")) {
            this.zzd = iObjectWrapper;
            this.zzc = zzccaVar;
            zzccaVar.zze(ObjectWrapper.i5(obj));
            return;
        }
        String canonicalName = Adapter.class.getCanonicalName();
        String canonicalName2 = obj.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        com.google.android.gms.ads.internal.util.client.zzo.f(sb.toString());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final void zzo(com.google.android.gms.ads.internal.client.zzm zzmVar, String str) throws RemoteException {
        zzv(zzmVar, str, null);
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final boolean zzq() throws RemoteException {
        Object obj = this.zza;
        if ((obj instanceof Adapter) || Objects.equals(obj.getClass().getCanonicalName(), "com.google.ads.mediation.admob.AdMobAdapter")) {
            return this.zzc != null;
        }
        String canonicalName = Adapter.class.getCanonicalName();
        String canonicalName2 = obj.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        com.google.android.gms.ads.internal.util.client.zzo.f(sb.toString());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final void zzr(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, String str2, zzbvi zzbviVar, zzblt zzbltVar, List list) throws RemoteException {
        Object obj = this.zza;
        boolean z2 = obj instanceof MediationNativeAdapter;
        if (!z2 && !(obj instanceof Adapter)) {
            String canonicalName = MediationNativeAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = obj.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 4 + String.valueOf(canonicalName2).length() + 22 + String.valueOf(canonicalName3).length());
            sb.append(canonicalName);
            sb.append(" or ");
            sb.append(canonicalName2);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName3);
            com.google.android.gms.ads.internal.util.client.zzo.f(sb.toString());
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzo.a("Requesting native ad from adapter.");
        if (z2) {
            try {
                MediationNativeAdapter mediationNativeAdapter = (MediationNativeAdapter) obj;
                List list2 = zzmVar.f69968f;
                HashSet hashSet = list2 != null ? new HashSet(list2) : null;
                long j3 = zzmVar.f69965b;
                zzbwi zzbwiVar = new zzbwi(j3 == -1 ? null : new Date(j3), zzmVar.f69967d, hashSet, zzmVar.f69974l, zzX(zzmVar), zzmVar.f69970h, zzbltVar, list, zzmVar.f69981s, zzmVar.f69983u, zzY(str, zzmVar));
                Bundle bundle = zzmVar.f69976n;
                Bundle bundle2 = bundle != null ? bundle.getBundle(mediationNativeAdapter.getClass().getName()) : null;
                this.zzb = new zzbwf(zzbviVar);
                mediationNativeAdapter.requestNativeAd((Context) ObjectWrapper.h5(iObjectWrapper), this.zzb, zzV(str, zzmVar, str2), zzbwiVar, bundle2);
                return;
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.util.client.zzo.d("", th);
                zzbuz.zza(iObjectWrapper, th, "adapter.requestNativeAd");
                throw new RemoteException();
            }
        }
        Object obj2 = this.zza;
        if (obj2 instanceof Adapter) {
            try {
                ((Adapter) obj2).loadNativeAdMapper(new MediationNativeAdConfiguration((Context) ObjectWrapper.h5(iObjectWrapper), "", zzV(str, zzmVar, str2), zzW(zzmVar), zzX(zzmVar), zzmVar.f69974l, zzmVar.f69970h, zzmVar.f69983u, zzY(str, zzmVar), this.zzl, zzbltVar), new zzbwa(this, zzbviVar));
            } catch (Throwable th2) {
                com.google.android.gms.ads.internal.util.client.zzo.d("", th2);
                zzbuz.zza(iObjectWrapper, th2, "adapter.loadNativeAdMapper");
                String message = th2.getMessage();
                if (TextUtils.isEmpty(message) || !message.equals("Method is not found")) {
                    throw new RemoteException();
                }
                try {
                    ((Adapter) this.zza).loadNativeAd(new MediationNativeAdConfiguration((Context) ObjectWrapper.h5(iObjectWrapper), "", zzV(str, zzmVar, str2), zzW(zzmVar), zzX(zzmVar), zzmVar.f69974l, zzmVar.f69970h, zzmVar.f69983u, zzY(str, zzmVar), this.zzl, zzbltVar), new zzbvz(this, zzbviVar));
                } catch (Throwable th3) {
                    com.google.android.gms.ads.internal.util.client.zzo.d("", th3);
                    zzbuz.zza(iObjectWrapper, th3, "adapter.loadNativeAd");
                    throw new RemoteException();
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final Bundle zzs() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final Bundle zzt() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final Bundle zzu() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final void zzv(com.google.android.gms.ads.internal.client.zzm zzmVar, String str, String str2) throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof Adapter) {
            zzD(this.zzd, zzmVar, str, new zzbwg((Adapter) obj, this.zzc));
            return;
        }
        String canonicalName = Adapter.class.getCanonicalName();
        String canonicalName2 = obj.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        com.google.android.gms.ads.internal.util.client.zzo.f(sb.toString());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final void zzw(IObjectWrapper iObjectWrapper) throws RemoteException {
        Context context = (Context) ObjectWrapper.h5(iObjectWrapper);
        Object obj = this.zza;
        if (obj instanceof OnContextChangedListener) {
            ((OnContextChangedListener) obj).onContextChanged(context);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final boolean zzx() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final void zzy(IObjectWrapper iObjectWrapper, zzcca zzccaVar, List list) throws RemoteException {
        com.google.android.gms.ads.internal.util.client.zzo.f("Could not initialize rewarded video adapter.");
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final zzbmv zzz() {
        zzbmw zzbmwVarZze;
        zzbwf zzbwfVar = this.zzb;
        if (zzbwfVar == null || (zzbmwVarZze = zzbwfVar.zze()) == null) {
            return null;
        }
        return zzbmwVarZze.zza();
    }

    public zzbwd(MediationAdapter mediationAdapter) {
        this.zza = mediationAdapter;
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final IObjectWrapper zzf() throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof MediationBannerAdapter) {
            try {
                return ObjectWrapper.i5(((MediationBannerAdapter) obj).getBannerView());
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.util.client.zzo.d("", th);
                throw new RemoteException();
            }
        }
        if (obj instanceof Adapter) {
            return ObjectWrapper.i5(this.zze);
        }
        String canonicalName = MediationBannerAdapter.class.getCanonicalName();
        String canonicalName2 = Adapter.class.getCanonicalName();
        String canonicalName3 = obj.getClass().getCanonicalName();
        int length = String.valueOf(canonicalName).length();
        StringBuilder sb = new StringBuilder(length + 4 + String.valueOf(canonicalName2).length() + 22 + String.valueOf(canonicalName3).length());
        sb.append(canonicalName);
        sb.append(" or ");
        sb.append(canonicalName2);
        sb.append(qRMDmh.CCppS);
        sb.append(canonicalName3);
        com.google.android.gms.ads.internal.util.client.zzo.f(sb.toString());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final void zzp() throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof Adapter) {
            MediationRewardedAd mediationRewardedAd = this.zzi;
            if (mediationRewardedAd == null) {
                com.google.android.gms.ads.internal.util.client.zzo.c("Can not show null mediated rewarded ad.");
                throw new RemoteException();
            }
            try {
                mediationRewardedAd.showAd((Context) ObjectWrapper.h5(this.zzd));
                return;
            } catch (RuntimeException e3) {
                zzbuz.zza(this.zzd, e3, "adapter.showVideo");
                throw e3;
            }
        }
        String canonicalName = Adapter.class.getCanonicalName();
        String canonicalName2 = obj.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(MHoiDDglUlPJC.vCNlCbWNSyiJ);
        sb.append(canonicalName2);
        com.google.android.gms.ads.internal.util.client.zzo.f(sb.toString());
        throw new RemoteException();
    }
}
