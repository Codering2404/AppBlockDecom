package com.google.android.libraries.places.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbrs implements zzbpn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbpn f76733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f76734b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List f76735c = new ArrayList();

    public zzbrs(zzbpn zzbpnVar) {
        this.f76733a = zzbpnVar;
    }

    private final void f(Runnable runnable) {
        synchronized (this) {
            try {
                if (this.f76734b) {
                    runnable.run();
                } else {
                    this.f76735c.add(runnable);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbpn
    public final void a(zzbmg zzbmgVar) {
        f(new zzbrq(this, zzbmgVar));
    }

    @Override // com.google.android.libraries.places.internal.zzbpn
    public final void b(zzbnp zzbnpVar, zzbpm zzbpmVar, zzbmg zzbmgVar) {
        f(new zzbrr(this, zzbnpVar, zzbpmVar, zzbmgVar));
    }

    @Override // com.google.android.libraries.places.internal.zzcad
    public final void c(zzcac zzcacVar) {
        if (this.f76734b) {
            this.f76733a.c(zzcacVar);
        } else {
            f(new zzbro(this, zzcacVar));
        }
    }

    public final void d() {
        List list;
        List arrayList = new ArrayList();
        while (true) {
            synchronized (this) {
                try {
                    if (this.f76735c.isEmpty()) {
                        this.f76735c = null;
                        this.f76734b = true;
                        return;
                    } else {
                        list = this.f76735c;
                        this.f76735c = arrayList;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
            list.clear();
            arrayList = list;
        }
    }

    final /* synthetic */ zzbpn e() {
        return this.f76733a;
    }

    @Override // com.google.android.libraries.places.internal.zzcad
    public final void zzd() {
        if (this.f76734b) {
            this.f76733a.zzd();
        } else {
            f(new zzbrp(this));
        }
    }
}
