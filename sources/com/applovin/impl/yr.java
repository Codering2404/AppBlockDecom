package com.applovin.impl;

import android.text.TextUtils;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class yr extends ek {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final ah f65258o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final ur f65259p;

    public yr() {
        super("WebvttDecoder");
        this.f65258o = new ah();
        this.f65259p = new ur();
    }

    private static void b(ah ahVar) {
        while (!TextUtils.isEmpty(ahVar.l())) {
        }
    }

    @Override // com.applovin.impl.ek
    protected nl a(byte[] bArr, int i3, boolean z2) throws pl {
        wr wrVarA;
        this.f65258o.a(bArr, i3);
        ArrayList arrayList = new ArrayList();
        try {
            zr.b(this.f65258o);
            while (!TextUtils.isEmpty(this.f65258o.l())) {
            }
            ArrayList arrayList2 = new ArrayList();
            while (true) {
                int iA = a(this.f65258o);
                if (iA == 0) {
                    return new as(arrayList2);
                }
                if (iA == 1) {
                    b(this.f65258o);
                } else if (iA == 2) {
                    if (!arrayList2.isEmpty()) {
                        throw new pl("A style block was found after the first cue.");
                    }
                    this.f65258o.l();
                    arrayList.addAll(this.f65259p.c(this.f65258o));
                } else if (iA == 3 && (wrVarA = xr.a(this.f65258o, arrayList)) != null) {
                    arrayList2.add(wrVarA);
                }
            }
        } catch (ch e3) {
            throw new pl(e3);
        }
    }

    private static int a(ah ahVar) {
        int i3 = -1;
        int iD = 0;
        while (i3 == -1) {
            iD = ahVar.d();
            String strL = ahVar.l();
            if (strL == null) {
                i3 = 0;
            } else if ("STYLE".equals(strL)) {
                i3 = 2;
            } else {
                i3 = strL.startsWith("NOTE") ? 1 : 3;
            }
        }
        ahVar.f(iD);
        return i3;
    }
}
