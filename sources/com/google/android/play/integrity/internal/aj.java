package com.google.android.play.integrity.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class aj implements an {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f83179c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile an f83180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile Object f83181b = f83179c;

    private aj(an anVar) {
        this.f83180a = anVar;
    }

    public static an b(an anVar) {
        return anVar instanceof aj ? anVar : new aj(anVar);
    }

    @Override // com.google.android.play.integrity.internal.an
    public final Object a() {
        Object objA;
        Object obj = this.f83181b;
        Object obj2 = f83179c;
        if (obj != obj2) {
            return obj;
        }
        synchronized (this) {
            try {
                objA = this.f83181b;
                if (objA == obj2) {
                    objA = this.f83180a.a();
                    Object obj3 = this.f83181b;
                    if (obj3 != obj2 && obj3 != objA) {
                        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj3 + " & " + objA + ". This is likely due to a circular dependency.");
                    }
                    this.f83181b = objA;
                    this.f83180a = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return objA;
    }
}
