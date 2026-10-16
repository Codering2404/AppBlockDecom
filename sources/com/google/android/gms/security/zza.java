package com.google.android.gms.security;

import android.content.Context;
import android.os.AsyncTask;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.security.ProviderInstaller;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zza extends AsyncTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f74550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ProviderInstaller.ProviderInstallListener f74551b;

    @Override // android.os.AsyncTask
    protected final /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
        try {
            ProviderInstaller.a(this.f74550a);
            return 0;
        } catch (GooglePlayServicesNotAvailableException e3) {
            return Integer.valueOf(e3.f71456a);
        } catch (GooglePlayServicesRepairableException e4) {
            return Integer.valueOf(e4.a());
        }
    }

    @Override // android.os.AsyncTask
    protected final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        Integer num = (Integer) obj;
        if (num.intValue() == 0) {
            this.f74551b.a();
            return;
        }
        Context context = this.f74550a;
        int i3 = ProviderInstaller.f74549e;
        this.f74551b.b(num.intValue(), ProviderInstaller.f74545a.d(context, num.intValue(), "pi"));
    }
}
