package com.google.android.gms.ads.internal;

import android.os.AsyncTask;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzq extends AsyncTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzs f70432a;

    /* synthetic */ zzq(zzs zzsVar, byte[] bArr) {
        Objects.requireNonNull(zzsVar);
        this.f70432a = zzsVar;
    }

    @Override // android.os.AsyncTask
    protected final /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
        return this.f70432a.i5();
    }

    @Override // android.os.AsyncTask
    protected final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        zzs zzsVar = this.f70432a;
        String str = (String) obj;
        if (zzsVar.l5() == null || str == null) {
            return;
        }
        zzsVar.l5().loadUrl(str);
    }
}
