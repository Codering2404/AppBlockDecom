package com.google.android.libraries.places.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbqt extends zzbiw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbiw f76668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f76669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List f76670c = new ArrayList();

    public zzbqt(zzbiw zzbiwVar) {
        this.f76668a = zzbiwVar;
    }

    private final void g(Runnable runnable) {
        synchronized (this) {
            try {
                if (this.f76669b) {
                    runnable.run();
                } else {
                    this.f76670c.add(runnable);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbiw
    public final void a(zzbmg zzbmgVar) {
        if (this.f76669b) {
            this.f76668a.a(zzbmgVar);
        } else {
            g(new zzbqp(this, zzbmgVar));
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbiw
    public final void b(Object obj) {
        if (this.f76669b) {
            this.f76668a.b(obj);
        } else {
            g(new zzbqq(this, obj));
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbiw
    public final void c(zzbnp zzbnpVar, zzbmg zzbmgVar) {
        g(new zzbqr(this, zzbnpVar, zzbmgVar));
    }

    @Override // com.google.android.libraries.places.internal.zzbiw
    public final void d() {
        if (this.f76669b) {
            this.f76668a.d();
        } else {
            g(new zzbqs(this));
        }
    }

    final void e() {
        List list;
        List arrayList = new ArrayList();
        while (true) {
            synchronized (this) {
                try {
                    if (this.f76670c.isEmpty()) {
                        this.f76670c = null;
                        this.f76669b = true;
                        return;
                    } else {
                        list = this.f76670c;
                        this.f76670c = arrayList;
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

    final /* synthetic */ zzbiw f() {
        return this.f76668a;
    }
}
