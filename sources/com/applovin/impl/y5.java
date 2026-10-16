package com.applovin.impl;

import android.net.Uri;
import com.applovin.impl.c6;
import com.applovin.impl.pa;
import com.applovin.impl.sd;
import com.applovin.impl.x5;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class y5 implements b7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f65152a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private sd.e f65153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a7 f65154c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private pa.b f65155d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f65156e;

    private a7 a(sd.e eVar) {
        pa.b bVarA = this.f65155d;
        if (bVarA == null) {
            bVarA = new c6.b().a(this.f65156e);
        }
        Uri uri = eVar.f63062b;
        qa qaVar = new qa(uri == null ? null : uri.toString(), eVar.f63066f, bVarA);
        pp it = eVar.f63063c.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            qaVar.a((String) entry.getKey(), (String) entry.getValue());
        }
        x5 x5VarA = new x5.b().a(eVar.f63061a, l9.f61168d).a(eVar.f63064d).b(eVar.f63065e).a(tb.a(eVar.f63067g)).a(qaVar);
        x5VarA.a(0, eVar.b());
        return x5VarA;
    }

    @Override // com.applovin.impl.b7
    public a7 a(sd sdVar) {
        a7 a7Var;
        b1.a(sdVar.f63036b);
        sd.e eVar = sdVar.f63036b.f63091c;
        if (eVar != null && xp.f65027a >= 18) {
            synchronized (this.f65152a) {
                try {
                    if (!xp.a(eVar, this.f65153b)) {
                        this.f65153b = eVar;
                        this.f65154c = a(eVar);
                    }
                    a7Var = (a7) b1.a(this.f65154c);
                } catch (Throwable th) {
                    throw th;
                }
            }
            return a7Var;
        }
        return a7.f58214a;
    }
}
