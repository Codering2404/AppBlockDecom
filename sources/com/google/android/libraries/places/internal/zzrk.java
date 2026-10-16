package com.google.android.libraries.places.internal;

import com.google.common.collect.ImmutableSet;
import java.util.UUID;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzrk extends zzqx implements zzrv {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final zzra f78512f = new zzrb();

    private zzrk(UUID uuid, String str, Exception exc, boolean z2, zzrt zzrtVar) {
        super("<missing root>", uuid, str, zzrtVar);
    }

    public static zzrk b(zzrt zzrtVar) {
        final UUID uuidC = zzri.a().c();
        String strA = zzqx.a(uuidC);
        ImmutableSet immutableSetA = zzrh.a();
        if (!immutableSetA.isEmpty()) {
            final Exception exc = null;
            immutableSetA.forEach(new Consumer(uuidC, exc) { // from class: com.google.android.libraries.places.internal.zzrj
                @Override // java.util.function.Consumer
                public final /* synthetic */ void accept(Object obj) {
                    zzra zzraVar = zzrk.f78512f;
                    ((zzrx) obj).zza();
                }
            });
        }
        return new zzrk(uuidC, strA, f78512f, false, zzrtVar);
    }

    @Override // com.google.android.libraries.places.internal.zzrv
    public final zzro zzg() {
        return zzrn.f78514e;
    }

    @Override // com.google.android.libraries.places.internal.zzrv
    public final long zzi() {
        return -1L;
    }
}
