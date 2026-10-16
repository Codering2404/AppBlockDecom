package com.google.android.libraries.places.internal;

import java.io.InputStream;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbpg extends zzbqd {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzcac f76597b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzbpj f76598c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbpg(zzbpj zzbpjVar, zzcev zzcevVar, zzcac zzcacVar) {
        super(zzbpjVar.f76605c.l());
        this.f76597b = zzcacVar;
        Objects.requireNonNull(zzbpjVar);
        this.f76598c = zzbpjVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbqd
    public final void a() {
        int i3 = zzcew.f77735a;
        zzbpj zzbpjVar = this.f76598c;
        zzbpk zzbpkVar = zzbpjVar.f76605c;
        if (zzbpjVar.f() != null) {
            zzbsz.g(this.f76597b);
            return;
        }
        while (true) {
            try {
                InputStream inputStreamZza = this.f76597b.zza();
                if (inputStreamZza == null) {
                    return;
                }
                try {
                    zzbpjVar.e().b(zzbpkVar.i().d(inputStreamZza));
                    inputStreamZza.close();
                } catch (Throwable th) {
                    zzbsz.h(inputStreamZza);
                    throw th;
                }
            } catch (Throwable th2) {
                zzbsz.g(this.f76597b);
                this.f76598c.d(zzbnp.f76489f.d(th2).e("Failed to read message."));
                return;
            }
        }
    }
}
