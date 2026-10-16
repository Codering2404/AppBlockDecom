package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbxi extends zzblp {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzblg f77150f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private zzblm f77151g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private zzbjn f77152h = zzbjn.IDLE;

    zzbxi(zzblg zzblgVar) {
        this.f77150f = (zzblg) Preconditions.u(zzblgVar, "helper");
    }

    private final void g(zzbjn zzbjnVar, zzbln zzblnVar) {
        this.f77152h = zzbjnVar;
        this.f77150f.b(zzbjnVar, zzblnVar);
    }

    @Override // com.google.android.libraries.places.internal.zzblp
    public final zzbnp a(zzbll zzbllVar) {
        Boolean bool;
        List listC = zzbllVar.c();
        if (listC.isEmpty()) {
            zzbnp zzbnpVar = zzbnp.f76496m;
            String strValueOf = String.valueOf(zzbllVar.c());
            String strValueOf2 = String.valueOf(zzbllVar.d());
            StringBuilder sb = new StringBuilder(strValueOf.length() + 55 + strValueOf2.length());
            sb.append("NameResolver returned no usable address. addrs=");
            sb.append(strValueOf);
            sb.append(", attrs=");
            sb.append(strValueOf2);
            zzbnp zzbnpVarE = zzbnpVar.e(sb.toString());
            b(zzbnpVarE);
            return zzbnpVarE;
        }
        if ((zzbllVar.e() instanceof zzbxe) && (bool = ((zzbxe) zzbllVar.e()).f77144a) != null && bool.booleanValue()) {
            ArrayList arrayList = new ArrayList(listC);
            Collections.shuffle(arrayList, new Random());
            listC = arrayList;
        }
        zzblm zzblmVar = this.f77151g;
        if (zzblmVar == null) {
            zzblg zzblgVar = this.f77150f;
            zzblb zzblbVarD = zzbld.d();
            zzblbVarD.b(listC);
            zzblm zzblmVarA = zzblgVar.a(zzblbVarD.c());
            zzblmVarA.a(new zzbxd(this, zzblmVarA));
            this.f77151g = zzblmVarA;
            g(zzbjn.CONNECTING, new zzbxf(zzbli.a(zzblmVarA, null)));
            zzblmVarA.c();
        } else {
            zzblmVar.d(listC);
        }
        return zzbnp.f76488e;
    }

    @Override // com.google.android.libraries.places.internal.zzblp
    public final void b(zzbnp zzbnpVar) {
        zzblm zzblmVar = this.f77151g;
        if (zzblmVar != null) {
            zzblmVar.b();
            this.f77151g = null;
        }
        g(zzbjn.TRANSIENT_FAILURE, new zzbxf(zzbli.b(zzbnpVar)));
    }

    @Override // com.google.android.libraries.places.internal.zzblp
    public final void c() {
        zzblm zzblmVar = this.f77151g;
        if (zzblmVar != null) {
            zzblmVar.b();
        }
    }

    @Override // com.google.android.libraries.places.internal.zzblp
    public final void d() {
        zzblm zzblmVar = this.f77151g;
        if (zzblmVar != null) {
            zzblmVar.c();
        }
    }

    final /* synthetic */ void e(zzblm zzblmVar, zzbjo zzbjoVar) {
        zzbln zzbxfVar;
        zzbjn zzbjnVarC = zzbjoVar.c();
        if (zzbjnVarC == zzbjn.SHUTDOWN) {
            return;
        }
        zzbjn zzbjnVar = zzbjn.TRANSIENT_FAILURE;
        if (zzbjnVarC == zzbjnVar || zzbjnVarC == zzbjn.IDLE) {
            this.f77150f.c();
        }
        if (this.f77152h == zzbjnVar) {
            if (zzbjnVarC == zzbjn.CONNECTING) {
                return;
            }
            if (zzbjnVarC == zzbjn.IDLE) {
                d();
                return;
            }
        }
        int iOrdinal = zzbjnVarC.ordinal();
        if (iOrdinal == 0) {
            zzbxfVar = new zzbxf(zzbli.d());
        } else if (iOrdinal == 1) {
            zzbxfVar = new zzbxf(zzbli.a(zzblmVar, null));
        } else if (iOrdinal == 2) {
            zzbxfVar = new zzbxf(zzbli.b(zzbjoVar.d()));
        } else {
            if (iOrdinal != 3) {
                throw new IllegalArgumentException("Unsupported state:".concat(String.valueOf(zzbjnVarC)));
            }
            zzbxfVar = new zzbxh(this, null);
        }
        g(zzbjnVarC, zzbxfVar);
    }

    final /* synthetic */ zzblg f() {
        return this.f77150f;
    }
}
