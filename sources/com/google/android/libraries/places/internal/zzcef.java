package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzcef {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Logger f77706a = Logger.getLogger(zzcef.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final zzbir f77707b;

    static {
        if (!Strings.b(System.getenv("GRPC_CLIENT_CALL_REJECT_RUNNABLE"))) {
            Boolean.parseBoolean(System.getenv("GRPC_CLIENT_CALL_REJECT_RUNNABLE"));
        }
        f77707b = zzbir.a("internal-stub-type");
    }

    private zzcef() {
    }

    public static void a(zzbix zzbixVar, Object obj, zzcej zzcejVar) {
        Preconditions.u(zzcejVar, "responseObserver");
        d(zzbixVar, obj, new zzcec(zzcejVar, new zzcdz(zzbixVar, false)));
    }

    public static ListenableFuture b(zzbix zzbixVar, Object obj) {
        zzcea zzceaVar = new zzcea(zzbixVar);
        d(zzbixVar, obj, new zzcee(zzceaVar));
        return zzceaVar;
    }

    private static RuntimeException c(zzbix zzbixVar, Throwable th) {
        try {
            zzbixVar.e(null, th);
        } catch (Error | RuntimeException e3) {
            f77706a.logp(Level.SEVERE, "io.grpc.stub.ClientCalls", "cancelThrow", "RuntimeException encountered while closing call", e3);
        }
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        }
        if (th instanceof Error) {
            throw ((Error) th);
        }
        throw new AssertionError(th);
    }

    private static void d(zzbix zzbixVar, Object obj, zzceb zzcebVar) {
        zzbixVar.a(zzcebVar, new zzbmg());
        zzcebVar.e();
        try {
            zzbixVar.b(obj);
            zzbixVar.d();
        } catch (Error | RuntimeException e3) {
            throw c(zzbixVar, e3);
        }
    }
}
