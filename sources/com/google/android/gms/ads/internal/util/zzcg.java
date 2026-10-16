package com.google.android.gms.ads.internal.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import com.google.android.gms.internal.ads.zzbiq;
import java.util.ArrayList;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcg {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f70317d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Context f70318e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f70316c = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f70315b = new WeakHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BroadcastReceiver f70314a = new zzcf(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public final synchronized void d(Context context, Intent intent) {
        try {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry : this.f70315b.entrySet()) {
                if (((IntentFilter) entry.getValue()).hasAction(intent.getAction())) {
                    arrayList.add((BroadcastReceiver) entry.getKey());
                }
            }
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                ((BroadcastReceiver) arrayList.get(i3)).onReceive(context, intent);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void a(Context context) {
        try {
            if (this.f70316c) {
                return;
            }
            Context applicationContext = context.getApplicationContext();
            this.f70318e = applicationContext;
            if (applicationContext == null) {
                this.f70318e = context;
            }
            zzbiq.zza(this.f70318e);
            this.f70317d = ((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzeJ)).booleanValue();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzmu)).booleanValue() || Build.VERSION.SDK_INT < 33) {
                this.f70318e.registerReceiver(this.f70314a, intentFilter);
            } else {
                this.f70318e.registerReceiver(this.f70314a, intentFilter, 4);
            }
            this.f70316c = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void b(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (this.f70317d) {
            this.f70315b.put(broadcastReceiver, intentFilter);
            return;
        }
        zzbiq.zza(context);
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzmu)).booleanValue() || Build.VERSION.SDK_INT < 33) {
            context.registerReceiver(broadcastReceiver, intentFilter);
        } else {
            context.registerReceiver(broadcastReceiver, intentFilter, 4);
        }
    }

    public final synchronized void c(Context context, BroadcastReceiver broadcastReceiver) {
        if (this.f70317d) {
            this.f70315b.remove(broadcastReceiver);
        } else {
            context.unregisterReceiver(broadcastReceiver);
        }
    }
}
