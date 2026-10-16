package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.internal.zzbdk;
import com.google.android.libraries.places.internal.zzbdq;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class zzbdk<MessageType extends zzbdq<MessageType, BuilderType>, BuilderType extends zzbdk<MessageType, BuilderType>> extends zzbbx<MessageType, BuilderType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbdq f76080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected zzbdq f76081b;

    protected zzbdk(zzbdq zzbdqVar) {
        this.f76080a = zzbdqVar;
        if (zzbdqVar.v()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.f76081b = zzbdqVar.x();
    }

    private static void v(Object obj, Object obj2) {
        zzbfh.a().b(obj.getClass()).zzd(obj, obj2);
    }

    @Override // com.google.android.libraries.places.internal.zzbey
    public final boolean c() {
        return zzbdq.F(this.f76081b, false);
    }

    @Override // com.google.android.libraries.places.internal.zzbey
    public final /* synthetic */ zzbex e() {
        return this.f76080a;
    }

    @Override // com.google.android.libraries.places.internal.zzbbx, com.google.android.libraries.places.internal.zzbew
    public final /* bridge */ /* synthetic */ zzbew m2(zzbco zzbcoVar, zzbdb zzbdbVar) throws IOException {
        if (!this.f76081b.v()) {
            x();
        }
        try {
            zzbfh.a().b(this.f76081b.getClass()).b(this.f76081b, zzbcp.r(zzbcoVar), zzbdbVar);
            return this;
        } catch (RuntimeException e3) {
            if (e3.getCause() instanceof IOException) {
                throw ((IOException) e3.getCause());
            }
            throw e3;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbbx
    protected final /* synthetic */ zzbbx p(zzbby zzbbyVar) {
        u((zzbdq) zzbbyVar);
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zzbbx
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final zzbdk o() {
        zzbdk zzbdkVar = (zzbdk) this.f76080a.l(5, null, null);
        zzbdkVar.f76081b = zzF();
        return zzbdkVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbew
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public zzbdq zzF() {
        if (!this.f76081b.v()) {
            return this.f76081b;
        }
        this.f76081b.z();
        return this.f76081b;
    }

    @Override // com.google.android.libraries.places.internal.zzbew
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public final zzbdq zzG() {
        zzbdq zzbdqVarZzF = zzF();
        if (zzbdqVarZzF.c()) {
            return zzbdqVarZzF;
        }
        throw new zzbfx(zzbdqVarZzF);
    }

    public final zzbdk u(zzbdq zzbdqVar) {
        if (!this.f76080a.equals(zzbdqVar)) {
            if (!this.f76081b.v()) {
                x();
            }
            v(this.f76081b, zzbdqVar);
        }
        return this;
    }

    protected final void w() {
        if (this.f76081b.v()) {
            return;
        }
        x();
    }

    protected void x() {
        zzbdq zzbdqVarX = this.f76080a.x();
        v(zzbdqVarX, this.f76081b);
        this.f76081b = zzbdqVarX;
    }
}
