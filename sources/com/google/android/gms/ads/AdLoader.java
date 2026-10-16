package com.google.android.gms.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzbn;
import com.google.android.gms.ads.internal.client.zzbq;
import com.google.android.gms.ads.internal.client.zzeh;
import com.google.android.gms.ads.internal.client.zzff;
import com.google.android.gms.ads.internal.client.zzfw;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbiq;
import com.google.android.gms.internal.ads.zzbko;
import com.google.android.gms.internal.ads.zzblt;
import com.google.android.gms.internal.ads.zzbob;
import com.google.android.gms.internal.ads.zzboe;
import com.google.android.gms.internal.ads.zzbuy;
import com.google.android.gms.internal.ads.zzbyq;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AdLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzq f69639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f69640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzbn f69641c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f69642a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final zzbq f69643b;

        public Builder(Context context, String str) {
            Context context2 = (Context) Preconditions.n(context, "context cannot be null");
            zzbq zzbqVarC = zzay.b().c(context, str, new zzbuy());
            this.f69642a = context2;
            this.f69643b = zzbqVarC;
        }

        public AdLoader a() {
            try {
                return new AdLoader(this.f69642a, this.f69643b.zze(), zzq.f70003a);
            } catch (RemoteException e3) {
                zzo.d("Failed to build AdLoader.", e3);
                return new AdLoader(this.f69642a, new zzff().x3(), zzq.f70003a);
            }
        }

        public Builder b(NativeAd.OnNativeAdLoadedListener onNativeAdLoadedListener) {
            try {
                this.f69643b.zzm(new zzbyq(onNativeAdLoadedListener));
                return this;
            } catch (RemoteException e3) {
                zzo.g("Failed to add google native ad listener", e3);
                return this;
            }
        }

        public Builder c(AdListener adListener) {
            try {
                this.f69643b.zzf(new com.google.android.gms.ads.internal.client.zzg(adListener));
                return this;
            } catch (RemoteException e3) {
                zzo.g("Failed to set AdListener.", e3);
                return this;
            }
        }

        public Builder d(NativeAdOptions nativeAdOptions) {
            try {
                this.f69643b.zzj(new zzblt(4, nativeAdOptions.e(), -1, nativeAdOptions.d(), nativeAdOptions.a(), nativeAdOptions.c() != null ? new zzfw(nativeAdOptions.c()) : null, nativeAdOptions.f(), nativeAdOptions.b(), nativeAdOptions.g(), nativeAdOptions.h(), nativeAdOptions.i() - 1));
                return this;
            } catch (RemoteException e3) {
                zzo.g("Failed to specify native ad options", e3);
                return this;
            }
        }

        public final Builder e(com.google.android.gms.ads.formats.zzg zzgVar) {
            try {
                this.f69643b.zzm(new zzboe(zzgVar));
                return this;
            } catch (RemoteException e3) {
                zzo.g("Failed to add google native ad listener", e3);
                return this;
            }
        }

        public final Builder f(String str, com.google.android.gms.ads.formats.zze zzeVar, com.google.android.gms.ads.formats.zzd zzdVar) {
            zzbob zzbobVar = new zzbob(zzeVar, zzdVar);
            try {
                this.f69643b.zzi(str, zzbobVar.zza(), zzbobVar.zzb());
                return this;
            } catch (RemoteException e3) {
                zzo.g("Failed to add custom template ad listener", e3);
                return this;
            }
        }

        public final Builder g(com.google.android.gms.ads.formats.NativeAdOptions nativeAdOptions) {
            try {
                this.f69643b.zzj(new zzblt(nativeAdOptions));
                return this;
            } catch (RemoteException e3) {
                zzo.g("Failed to specify native ad options", e3);
                return this;
            }
        }
    }

    AdLoader(Context context, zzbn zzbnVar, zzq zzqVar) {
        this.f69640b = context;
        this.f69641c = zzbnVar;
        this.f69639a = zzqVar;
    }

    private final void c(final zzeh zzehVar) {
        Context context = this.f69640b;
        zzbiq.zza(context);
        if (((Boolean) zzbko.zzc.zze()).booleanValue()) {
            if (((Boolean) zzba.c().zzd(zzbiq.zzmD)).booleanValue()) {
                com.google.android.gms.ads.internal.util.client.zzb.f70157b.execute(new Runnable() { // from class: com.google.android.gms.ads.zza
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.f70848a.b(zzehVar);
                    }
                });
                return;
            }
        }
        try {
            this.f69641c.zze(this.f69639a.a(context, zzehVar));
        } catch (RemoteException e3) {
            zzo.d("Failed to load ad.", e3);
        }
    }

    public void a(AdRequest adRequest) {
        c(adRequest.f69644a);
    }

    final /* synthetic */ void b(zzeh zzehVar) {
        try {
            this.f69641c.zze(this.f69639a.a(this.f69640b, zzehVar));
        } catch (RemoteException e3) {
            zzo.d("Failed to load ad.", e3);
        }
    }
}
