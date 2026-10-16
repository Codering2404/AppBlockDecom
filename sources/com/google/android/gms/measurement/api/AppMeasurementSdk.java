package com.google.android.gms.measurement.api;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzfb;
import com.google.android.gms.measurement.internal.zzjp;
import com.google.android.gms.measurement.internal.zzjq;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class AppMeasurementSdk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzfb f73362a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class ConditionalUserProperty {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface EventInterceptor extends zzjp {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnEventListener extends zzjq {
    }

    public AppMeasurementSdk(zzfb zzfbVar) {
        this.f73362a = zzfbVar;
    }

    public void a(String str, String str2, Bundle bundle) {
        this.f73362a.zzm(str, str2, bundle);
    }

    public List b(String str, String str2) {
        return this.f73362a.zzn(str, str2);
    }

    public int c(String str) {
        return this.f73362a.zzF(str);
    }

    public Map d(String str, String str2, boolean z2) {
        return this.f73362a.zzC(str, str2, z2);
    }

    public void e(String str, String str2, Bundle bundle) {
        this.f73362a.zzi(str, str2, bundle);
    }

    public void f(OnEventListener onEventListener) {
        this.f73362a.zzf(onEventListener);
    }

    public void g(Bundle bundle) {
        this.f73362a.zzl(bundle);
    }

    public void h(String str, String str2, Object obj) {
        this.f73362a.zzk(str, str2, obj, true);
    }

    public final void i(boolean z2) {
        this.f73362a.zzK(z2);
    }
}
