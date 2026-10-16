package com.applovin.impl.sdk;

import com.applovin.impl.go;
import com.applovin.impl.i8;
import com.applovin.impl.sdk.a;
import com.applovin.impl.sj;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f63233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WeakReference f63234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final WeakReference f63235c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private go f63236d;

    private b(i8 i8Var, a.InterfaceC0121a interfaceC0121a, j jVar) {
        this.f63234b = new WeakReference(i8Var);
        this.f63235c = new WeakReference(interfaceC0121a);
        this.f63233a = jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        d();
        this.f63233a.f().a(this);
    }

    public i8 b() {
        return (i8) this.f63234b.get();
    }

    public void d() {
        a();
        i8 i8VarB = b();
        if (i8VarB == null) {
            return;
        }
        i8VarB.setExpired();
        a.InterfaceC0121a interfaceC0121a = (a.InterfaceC0121a) this.f63235c.get();
        if (interfaceC0121a == null) {
            return;
        }
        interfaceC0121a.onAdExpired(i8VarB);
    }

    public static b a(i8 i8Var, a.InterfaceC0121a interfaceC0121a, j jVar) {
        b bVar = new b(i8Var, interfaceC0121a, jVar);
        bVar.a(i8Var.getTimeToLiveMillis());
        return bVar;
    }

    public void a(long j3) {
        a();
        if (((Boolean) this.f63233a.a(sj.f63728c1)).booleanValue() || !this.f63233a.e0().isApplicationPaused()) {
            this.f63236d = go.a(j3, this.f63233a, new Runnable() { // from class: com.applovin.impl.sdk.a0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f63172a.c();
                }
            });
        }
    }

    public void a() {
        go goVar = this.f63236d;
        if (goVar != null) {
            goVar.a();
            this.f63236d = null;
        }
    }
}
