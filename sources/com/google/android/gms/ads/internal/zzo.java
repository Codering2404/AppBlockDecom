package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.internal.ads.zzfma;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzo extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzs f70431a;

    zzo(zzs zzsVar) {
        Objects.requireNonNull(zzsVar);
        this.f70431a = zzsVar;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        zzs zzsVar = this.f70431a;
        if (zzsVar.m5() != null) {
            try {
                zzsVar.m5().zzd(zzfma.zzd(1, null, null));
            } catch (RemoteException e3) {
                int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
            }
        }
        zzs zzsVar2 = this.f70431a;
        if (zzsVar2.m5() != null) {
            try {
                zzsVar2.m5().zzc(0);
            } catch (RemoteException e4) {
                int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e4);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        zzs zzsVar = this.f70431a;
        if (str.startsWith(zzsVar.j5())) {
            return false;
        }
        if (str.startsWith("gmsg://noAdLoaded")) {
            if (zzsVar.m5() != null) {
                try {
                    zzsVar.m5().zzd(zzfma.zzd(3, null, null));
                } catch (RemoteException e3) {
                    int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
                    com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
                }
            }
            zzs zzsVar2 = this.f70431a;
            if (zzsVar2.m5() != null) {
                try {
                    zzsVar2.m5().zzc(3);
                } catch (RemoteException e4) {
                    int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
                    com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e4);
                }
            }
            this.f70431a.h5(0);
            return true;
        }
        if (str.startsWith("gmsg://scriptLoadFailed")) {
            zzs zzsVar3 = this.f70431a;
            if (zzsVar3.m5() != null) {
                try {
                    zzsVar3.m5().zzd(zzfma.zzd(1, null, null));
                } catch (RemoteException e5) {
                    int i5 = com.google.android.gms.ads.internal.util.zze.f70328b;
                    com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e5);
                }
            }
            zzs zzsVar4 = this.f70431a;
            if (zzsVar4.m5() != null) {
                try {
                    zzsVar4.m5().zzc(0);
                } catch (RemoteException e6) {
                    int i6 = com.google.android.gms.ads.internal.util.zze.f70328b;
                    com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e6);
                }
            }
            this.f70431a.h5(0);
            return true;
        }
        if (str.startsWith("gmsg://adResized")) {
            zzs zzsVar5 = this.f70431a;
            if (zzsVar5.m5() != null) {
                try {
                    zzsVar5.m5().zzf();
                } catch (RemoteException e7) {
                    int i7 = com.google.android.gms.ads.internal.util.zze.f70328b;
                    com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e7);
                }
            }
            zzs zzsVar6 = this.f70431a;
            zzsVar6.h5(zzsVar6.x3(str));
            return true;
        }
        if (str.startsWith("gmsg://")) {
            return true;
        }
        zzs zzsVar7 = this.f70431a;
        if (zzsVar7.m5() != null) {
            try {
                zzsVar7.m5().zzh();
                zzsVar7.m5().zze();
            } catch (RemoteException e8) {
                int i8 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e8);
            }
        }
        this.f70431a.k5(str);
        return true;
    }
}
