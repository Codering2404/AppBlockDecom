package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.applovin.sdk.AppLovinEventParameters;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.client.zzbh;
import com.google.android.gms.ads.internal.client.zzbk;
import com.google.android.gms.ads.internal.client.zzbt;
import com.google.android.gms.ads.internal.client.zzby;
import com.google.android.gms.ads.internal.client.zzcl;
import com.google.android.gms.ads.internal.client.zzcp;
import com.google.android.gms.ads.internal.client.zzcs;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.ads.internal.client.zzdx;
import com.google.android.gms.ads.internal.client.zzea;
import com.google.android.gms.ads.internal.client.zzee;
import com.google.android.gms.ads.internal.client.zzfw;
import com.google.android.gms.ads.internal.client.zzx;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbgm;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbkc;
import com.google.android.gms.internal.ads.zzbzk;
import com.google.android.gms.internal.ads.zzbzn;
import com.google.android.gms.internal.ads.zzcbv;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@ParametersAreNonnullByDefault
public final class zzs extends zzbt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final VersionInfoParcel f70439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.android.gms.ads.internal.client.zzr f70440b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f70441c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzr f70442d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private WebView f70443f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private zzbh f70444g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private AsyncTask f70445h;

    public zzs(Context context, com.google.android.gms.ads.internal.client.zzr zzrVar, String str, VersionInfoParcel versionInfoParcel) {
        this.f70441c = context;
        this.f70439a = versionInfoParcel;
        this.f70440b = zzrVar;
        this.f70443f = new WebView(context);
        this.f70442d = new zzr(context, str);
        h5(0);
        this.f70443f.setVerticalScrollBarEnabled(false);
        this.f70443f.getSettings().setJavaScriptEnabled(true);
        this.f70443f.setWebViewClient(new zzo(this));
        this.f70443f.setOnTouchListener(new zzp(this));
    }

    final void h5(int i3) {
        if (this.f70443f == null) {
            return;
        }
        this.f70443f.setLayoutParams(new ViewGroup.LayoutParams(-1, i3));
    }

    final String i5() {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https://").appendEncodedPath((String) zzbkc.zzd.zze());
        zzr zzrVar = this.f70442d;
        if (zzrVar.b() != null) {
            builder.appendQueryParameter(AppLovinEventParameters.SEARCH_QUERY, zzrVar.b());
        }
        builder.appendQueryParameter("pubId", zzrVar.c());
        builder.appendQueryParameter("mappver", zzrVar.d());
        Map mapE = zzrVar.e();
        for (String str : mapE.keySet()) {
            builder.appendQueryParameter(str, (String) mapE.get(str));
        }
        Uri uriBuild = builder.build();
        String strJ5 = j5();
        String encodedQuery = uriBuild.getEncodedQuery();
        StringBuilder sb = new StringBuilder(strJ5.length() + 1 + String.valueOf(encodedQuery).length());
        sb.append(strJ5);
        sb.append("#");
        sb.append(encodedQuery);
        return sb.toString();
    }

    final String j5() {
        String strA = this.f70442d.a();
        if (true == TextUtils.isEmpty(strA)) {
            strA = "www.google.com";
        }
        String str = (String) zzbkc.zzd.zze();
        StringBuilder sb = new StringBuilder(String.valueOf(strA).length() + 8 + String.valueOf(str).length());
        sb.append("https://");
        sb.append(strA);
        sb.append(str);
        return sb.toString();
    }

    final /* synthetic */ void k5(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        this.f70441c.startActivity(intent);
    }

    final /* synthetic */ WebView l5() {
        return this.f70443f;
    }

    final /* synthetic */ zzbh m5() {
        return this.f70444g;
    }

    final int x3(String str) {
        String queryParameter = Uri.parse(str).getQueryParameter(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
        if (TextUtils.isEmpty(queryParameter)) {
            return 0;
        }
        try {
            zzay.a();
            return com.google.android.gms.ads.internal.util.client.zzf.e(this.f70441c, Integer.parseInt(queryParameter));
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final boolean zzA() {
        return false;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final boolean zzB() {
        return false;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzC(zzcbv zzcbvVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzD(String str) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzE(String str) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final zzea zzF() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzG(zzfw zzfwVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzH(zzee zzeeVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzI(zzx zzxVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzJ(zzbgm zzbgmVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzK(boolean z2) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final long zzU() {
        return 0L;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzY(zzcp zzcpVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final IObjectWrapper zzb() {
        Preconditions.f("getAdFrame must be called on the main UI thread.");
        return ObjectWrapper.i5(this.f70443f);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzc() {
        Preconditions.f("destroy must be called on the main UI thread.");
        this.f70445h.cancel(true);
        this.f70443f.destroy();
        this.f70443f = null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final boolean zzd() {
        return false;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzdS(zzbh zzbhVar) {
        this.f70444g = zzbhVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final boolean zze(com.google.android.gms.ads.internal.client.zzm zzmVar) {
        Preconditions.n(this.f70443f, "This Search Ad has already been torn down");
        this.f70442d.f(zzmVar, this.f70439a);
        this.f70445h = new zzq(this, null).execute(new Void[0]);
        return true;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzf() {
        Preconditions.f("pause must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzg() {
        Preconditions.f("resume must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzi(zzcl zzclVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzj(zzby zzbyVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final Bundle zzk() {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzl() {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzm() {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final com.google.android.gms.ads.internal.client.zzr zzn() {
        return this.f70440b;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzo(com.google.android.gms.ads.internal.client.zzr zzrVar) {
        throw new IllegalStateException("AdSize must be set before initialization");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzp(zzbzk zzbzkVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzq(zzbzn zzbznVar, String str) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final String zzr() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final String zzs() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final zzdx zzt() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final String zzu() {
        throw new IllegalStateException("getAdUnitId not implemented");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final zzcl zzv() {
        throw new IllegalStateException("getIAppEventListener not implemented");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final zzbh zzw() {
        throw new IllegalStateException("getIAdListener not implemented");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzx(zzbjl zzbjlVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzy(zzbe zzbeVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzP(zzdq zzdqVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzR(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzS(zzcs zzcsVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzT(long j3) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzz(boolean z2) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzQ(com.google.android.gms.ads.internal.client.zzm zzmVar, zzbk zzbkVar) {
    }
}
