package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;
import com.google.android.libraries.places.widget.model.AutocompleteListDensity;
import com.google.android.libraries.places.widget.model.AutocompleteUiCustomization;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzpv implements zzpu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zznf f78419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzmz f78420b;

    public zzpv(zznf zznfVar, zzmz zzmzVar) {
        this.f78419a = zznfVar;
        this.f78420b = zzmzVar;
    }

    @Override // com.google.android.libraries.places.internal.zzpu
    public final void a(zzamm zzammVar) {
        zzmz zzmzVar = this.f78420b;
        zzaoc zzaocVarA = zzng.a(zzmzVar, zzmzVar.c());
        zzaocVarA.O(19);
        zzaocVarA.M(zzammVar);
        this.f78419a.a(zzaocVarA);
    }

    @Override // com.google.android.libraries.places.internal.zzpu
    public final void b(zzanh zzanhVar) {
        zzmz zzmzVar = this.f78420b;
        zzaoc zzaocVarA = zzng.a(zzmzVar, zzmzVar.c());
        zzaocVarA.O(20);
        zzaocVarA.N(zzanhVar);
        this.f78419a.a(zzaocVarA);
    }

    @Override // com.google.android.libraries.places.internal.zzpu
    public final void c(zzom zzomVar) {
        int i3;
        zzans zzansVarG = zzanw.G();
        zzansVarG.y(zzomVar.s());
        zzansVarG.z(zzomVar.t());
        zzansVarG.A(zzomVar.u());
        zzansVarG.B(zzomVar.v());
        zzansVarG.D(zzomVar.w());
        zzansVarG.E(zzomVar.x());
        zzansVarG.M(zzomVar.y());
        zzansVarG.F(zzomVar.A());
        zzansVarG.G(zzomVar.B().length());
        zzansVarG.H(zzomVar.C());
        zzansVarG.I(zzomVar.D());
        zzansVarG.J(zzomVar.E());
        zzansVarG.K(zzomVar.F());
        int iOrdinal = zzomVar.l().ordinal();
        if (iOrdinal == 0) {
            i3 = 2;
        } else if (iOrdinal == 1) {
            i3 = 3;
        } else {
            if (iOrdinal != 2) {
                throw new RuntimeException(null, null);
            }
            i3 = 4;
        }
        zzansVarG.P(i3);
        AutocompleteUiCustomization autocompleteUiCustomizationM = zzomVar.m();
        if (autocompleteUiCustomizationM != null) {
            zzok zzokVarN = zzomVar.n();
            zzaoz zzaozVarL = zzapa.L();
            if (zzokVarN != null) {
                zzaozVarL.y(zzokVarN.c());
                zzaozVarL.z(zzokVarN.d());
                zzaozVarL.A(zzokVarN.e());
                zzaozVarL.B(zzokVarN.f());
                zzaozVarL.D(zzokVarN.g());
            }
            zzanq zzanqVarG = zzanr.G();
            zzanqVarG.z(autocompleteUiCustomizationM.c() == AutocompleteListDensity.f79386b ? 3 : 2);
            zzanqVarG.y((zzapa) zzaozVarL.zzG());
            zzansVarG.L((zzanr) zzanqVarG.zzG());
        }
        if (zzomVar.p() == zzor.FRAGMENT) {
            zzansVarG.N(2);
        } else if (zzomVar.p() == zzor.INTENT) {
            zzansVarG.N(3);
        } else {
            zzansVarG.N(1);
        }
        if (zzomVar.q() == AutocompleteActivityMode.FULLSCREEN) {
            zzansVarG.O(2);
        } else if (zzomVar.q() == AutocompleteActivityMode.OVERLAY) {
            zzansVarG.O(1);
        }
        zzanw zzanwVar = (zzanw) zzansVarG.zzG();
        zzmz zzmzVar = this.f78420b;
        zzaoc zzaocVarA = zzng.a(zzmzVar, zzmzVar.c());
        zzaocVarA.O(10);
        zzaocVarA.D(zzanwVar);
        this.f78419a.a(zzaocVarA);
    }
}
