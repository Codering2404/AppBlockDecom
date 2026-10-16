package com.applovin.impl;

import com.applovin.impl.a5;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class pf extends ek {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final ah f62434o;

    public pf() {
        super("Mp4WebvttDecoder");
        this.f62434o = new ah();
    }

    @Override // com.applovin.impl.ek
    protected nl a(byte[] bArr, int i3, boolean z2) throws pl {
        this.f62434o.a(bArr, i3);
        ArrayList arrayList = new ArrayList();
        while (this.f62434o.a() > 0) {
            if (this.f62434o.a() < 8) {
                throw new pl("Incomplete Mp4Webvtt Top Level box header found.");
            }
            int iJ = this.f62434o.j();
            if (this.f62434o.j() == 1987343459) {
                arrayList.add(a(this.f62434o, iJ - 8));
            } else {
                this.f62434o.g(iJ - 8);
            }
        }
        return new qf(arrayList);
    }

    private static a5 a(ah ahVar, int i3) throws pl {
        CharSequence charSequenceA = null;
        a5.b bVarC = null;
        while (i3 > 0) {
            if (i3 >= 8) {
                int iJ = ahVar.j();
                int iJ2 = ahVar.j();
                int i4 = iJ - 8;
                String strA = xp.a(ahVar.c(), ahVar.d(), i4);
                ahVar.g(i4);
                i3 = (i3 - 8) - i4;
                if (iJ2 == 1937011815) {
                    bVarC = xr.c(strA);
                } else if (iJ2 == 1885436268) {
                    charSequenceA = xr.a((String) null, strA.trim(), Collections.EMPTY_LIST);
                }
            } else {
                throw new pl("Incomplete vtt cue box header found.");
            }
        }
        if (charSequenceA == null) {
            charSequenceA = "";
        }
        if (bVarC != null) {
            return bVarC.a(charSequenceA).a();
        }
        return xr.a(charSequenceA);
    }
}
