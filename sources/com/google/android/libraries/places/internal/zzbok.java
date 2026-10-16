package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import java.io.InputStream;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class zzbok implements zzcab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Logger f76555a = Logger.getLogger(zzbok.class.getName());

    @Override // com.google.android.libraries.places.internal.zzcab
    public final void b(zzbjj zzbjjVar) {
        i().a((zzbjj) Preconditions.u(zzbjjVar, "compressor"));
    }

    @Override // com.google.android.libraries.places.internal.zzcab
    public final void f(InputStream inputStream) {
        Preconditions.u(inputStream, "message");
        try {
            if (!i().zzc()) {
                i().b(inputStream);
            }
        } finally {
            zzbsz.h(inputStream);
        }
    }

    protected abstract zzbsq i();

    protected abstract zzboj j();

    protected final void k(int i3) {
        j().q(i3);
    }

    @Override // com.google.android.libraries.places.internal.zzcab
    public final void zzr() {
        j().h();
    }

    @Override // com.google.android.libraries.places.internal.zzcab
    public final void zzs(int i3) {
        zzboj zzbojVarJ = j();
        zzbojVarJ.c(new zzboi(zzbojVarJ, zzcew.b(), i3));
    }

    @Override // com.google.android.libraries.places.internal.zzcab
    public final void zzu() {
        if (i().zzc()) {
            return;
        }
        i().zzb();
    }
}
