package com.google.android.libraries.places.internal;

import androidx.compose.animation.core.h;
import com.google.common.base.Preconditions;
import d.qFm.sECyKyO;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzatp extends zzbkc {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicReference f75876b;

    public zzatp(zzbix zzbixVar) {
        super(zzbixVar);
        this.f75876b = new AtomicReference(zzato.b(1));
    }

    @Override // com.google.android.libraries.places.internal.zzbkd, com.google.android.libraries.places.internal.zzbix
    public final void a(zzbiw zzbiwVar, zzbmg zzbmgVar) {
        AtomicReference atomicReference;
        zzato zzatoVar;
        do {
            atomicReference = this.f75876b;
            zzatoVar = (zzato) atomicReference.get();
        } while (!h.a(atomicReference, zzatoVar, zzatoVar.d() == 1 ? zzato.b(2) : zzatoVar));
        if (zzatoVar.d() == 1) {
            f().a(zzbiwVar, zzbmgVar);
        } else if (zzatoVar.d() == 4) {
            zzbiwVar.c(zzatoVar.a(), new zzbmg());
        } else {
            IllegalStateException illegalStateException = new IllegalStateException("Already started");
            f().e("start() called more than once", illegalStateException);
            throw illegalStateException;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbkd, com.google.android.libraries.places.internal.zzbix
    public final void b(Object obj) {
        Preconditions.u(obj, "Message must be non-null");
        int iD = ((zzato) this.f75876b.get()).d();
        if (iD == 2) {
            f().b(obj);
        } else if (iD != 5) {
            throw new IllegalStateException("Call was either not started or already half-closed.");
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbnd, com.google.android.libraries.places.internal.zzbix
    public final void d() {
        AtomicReference atomicReference;
        zzato zzatoVar;
        do {
            atomicReference = this.f75876b;
            zzatoVar = (zzato) atomicReference.get();
            if (zzatoVar.d() != 2) {
                throw new IllegalStateException("Call was either not started or already half-closed.");
            }
        } while (!h.a(atomicReference, zzatoVar, zzato.b(3)));
        f().d();
    }

    @Override // com.google.android.libraries.places.internal.zzbnd, com.google.android.libraries.places.internal.zzbix
    public final void e(String str, Throwable th) {
        AtomicReference atomicReference;
        zzato zzatoVar;
        zzbnp zzbnpVarD = zzbnp.f76489f;
        if (str != null) {
            zzbnpVarD = zzbnpVarD.e(str);
        }
        if (th != null) {
            zzbnpVarD = zzbnpVarD.d(th);
        }
        do {
            atomicReference = this.f75876b;
            zzatoVar = (zzato) atomicReference.get();
        } while (!h.a(atomicReference, zzatoVar, zzatoVar.d() == 4 ? zzatoVar : zzatoVar.d() == 1 ? zzato.c(4, zzbnpVarD) : zzato.c(5, zzbnpVarD)));
        f().e(str, th);
    }

    @Override // com.google.android.libraries.places.internal.zzbnd, com.google.android.libraries.places.internal.zzbix
    public final void c(int i3) {
        zzato zzatoVar = (zzato) this.f75876b.get();
        if (zzatoVar.d() == 1 || zzatoVar.d() == 4) {
            throw new IllegalStateException(sECyKyO.sJCLLuALkzg);
        }
        Preconditions.e(true, "Number requested must be non-negative");
        f().c(i3);
    }
}
