package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.LoadAdError;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class zzaz extends AdListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f69837a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AdListener f69838b;

    public final void d(AdListener adListener) {
        synchronized (this.f69837a) {
            this.f69838b = adListener;
        }
    }

    @Override // com.google.android.gms.ads.AdListener, com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        synchronized (this.f69837a) {
            try {
                AdListener adListener = this.f69838b;
                if (adListener != null) {
                    adListener.onAdClicked();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdClosed() {
        synchronized (this.f69837a) {
            try {
                AdListener adListener = this.f69838b;
                if (adListener != null) {
                    adListener.onAdClosed();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdFailedToLoad(LoadAdError loadAdError) {
        synchronized (this.f69837a) {
            try {
                AdListener adListener = this.f69838b;
                if (adListener != null) {
                    adListener.onAdFailedToLoad(loadAdError);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdImpression() {
        synchronized (this.f69837a) {
            try {
                AdListener adListener = this.f69838b;
                if (adListener != null) {
                    adListener.onAdImpression();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdLoaded() {
        synchronized (this.f69837a) {
            try {
                AdListener adListener = this.f69838b;
                if (adListener != null) {
                    adListener.onAdLoaded();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdOpened() {
        synchronized (this.f69837a) {
            try {
                AdListener adListener = this.f69838b;
                if (adListener != null) {
                    adListener.onAdOpened();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
