package com.google.android.gms.analytics;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.gtm.zzbu;
import com.google.android.gms.internal.gtm.zzbx;
import com.google.android.gms.internal.gtm.zzft;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzv extends zzbu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f70931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f70932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f70933c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f70934d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f70935f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Tracker f70936g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected zzv(Tracker tracker, zzbx zzbxVar) {
        super(zzbxVar);
        this.f70936g = tracker;
        this.f70933c = -1L;
    }

    public final void b(Activity activity) throws Throwable {
        String canonicalName;
        if (this.f70932b == 0 && zzC().a() >= this.f70935f + Math.max(1000L, this.f70933c)) {
            this.f70934d = true;
        }
        this.f70932b++;
        if (this.f70931a) {
            Intent intent = activity.getIntent();
            if (intent != null) {
                this.f70936g.i(intent.getData());
            }
            HashMap map = new HashMap();
            map.put("&t", "screenview");
            Tracker tracker = this.f70936g;
            if (tracker.f70883g != null) {
                zzft zzftVar = tracker.f70883g;
                canonicalName = activity.getClass().getCanonicalName();
                String str = (String) zzftVar.zzg.get(canonicalName);
                if (str != null) {
                    canonicalName = str;
                }
            } else {
                canonicalName = activity.getClass().getCanonicalName();
            }
            tracker.f("&cd", canonicalName);
            if (TextUtils.isEmpty((CharSequence) map.get("&dr"))) {
                Preconditions.m(activity);
                Intent intent2 = activity.getIntent();
                String str2 = null;
                if (intent2 != null) {
                    String stringExtra = intent2.getStringExtra("android.intent.extra.REFERRER_NAME");
                    if (!TextUtils.isEmpty(stringExtra)) {
                        str2 = stringExtra;
                    }
                }
                if (!TextUtils.isEmpty(str2)) {
                    map.put("&dr", str2);
                }
            }
            this.f70936g.c(map);
        }
    }

    public final void c(Activity activity) {
        int i3 = this.f70932b - 1;
        this.f70932b = i3;
        int iMax = Math.max(0, i3);
        this.f70932b = iMax;
        if (iMax == 0) {
            this.f70935f = zzC().a();
        }
    }

    public final synchronized boolean zzf() {
        boolean z2;
        z2 = this.f70934d;
        this.f70934d = false;
        return z2;
    }

    @Override // com.google.android.gms.internal.gtm.zzbu
    protected final void zzd() {
    }
}
