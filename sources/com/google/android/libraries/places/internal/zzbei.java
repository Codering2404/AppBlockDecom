package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class zzbei {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected volatile zzbex f76108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile zzbcl f76109b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f76110c;

    public final zzbex a(zzbex zzbexVar) {
        zzbex zzbexVar2 = this.f76108a;
        this.f76109b = null;
        this.f76108a = zzbexVar;
        return zzbexVar2;
    }

    public final int b() {
        if (this.f76109b != null) {
            return this.f76109b.d();
        }
        if (this.f76108a != null) {
            return this.f76108a.j();
        }
        return 0;
    }

    public final zzbcl c() {
        if (this.f76109b != null) {
            return this.f76109b;
        }
        synchronized (this) {
            try {
                if (this.f76109b != null) {
                    return this.f76109b;
                }
                if (this.f76108a == null) {
                    this.f76109b = zzbcl.f75997b;
                } else {
                    this.f76109b = this.f76108a.a();
                }
                return this.f76109b;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    protected final void d(zzbex zzbexVar) {
        if (this.f76108a != null) {
            return;
        }
        synchronized (this) {
            if (this.f76108a != null) {
                return;
            }
            try {
                this.f76108a = zzbexVar;
                this.f76109b = zzbcl.f75997b;
            } catch (zzbed unused) {
                this.f76110c = true;
                this.f76108a = zzbexVar;
                this.f76109b = zzbcl.f75997b;
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbei)) {
            return false;
        }
        zzbei zzbeiVar = (zzbei) obj;
        zzbex zzbexVar = this.f76108a;
        zzbex zzbexVar2 = zzbeiVar.f76108a;
        if (zzbexVar == null && zzbexVar2 == null) {
            return c().equals(zzbeiVar.c());
        }
        if (zzbexVar != null && zzbexVar2 != null) {
            return zzbexVar.equals(zzbexVar2);
        }
        if (zzbexVar != null) {
            zzbeiVar.d(zzbexVar.e());
            return zzbexVar.equals(zzbeiVar.f76108a);
        }
        d(zzbexVar2.e());
        return this.f76108a.equals(zzbexVar2);
    }

    public int hashCode() {
        return 1;
    }
}
