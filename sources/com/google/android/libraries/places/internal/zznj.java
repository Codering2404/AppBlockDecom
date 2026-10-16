package com.google.android.libraries.places.internal;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.places.api.model.AutocompleteSessionToken;
import com.google.android.libraries.places.api.model.LocationBias;
import com.google.android.libraries.places.api.model.LocationRestriction;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;
import com.google.android.libraries.places.widget.model.AutocompleteUiCustomization;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zznj extends zznp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private zzow f78250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AutocompleteActivityMode f78251b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ImmutableList f78252c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private zzor f78253d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private LatLng f78254e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f78255f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f78256g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private LocationBias f78257h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private LocationRestriction f78258i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ImmutableList f78259j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ImmutableList f78260k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f78261l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f78262m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f78263n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private AutocompleteUiCustomization f78264o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f78265p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private AutocompleteSessionToken f78266q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private byte f78267r;

    zznj() {
    }

    @Override // com.google.android.libraries.places.internal.zznp
    public final zznp a(zzow zzowVar) {
        if (zzowVar == null) {
            throw new NullPointerException("Null widgetBackend");
        }
        this.f78250a = zzowVar;
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zznp
    public final zznp b(AutocompleteActivityMode autocompleteActivityMode) {
        if (autocompleteActivityMode == null) {
            throw new NullPointerException("Null mode");
        }
        this.f78251b = autocompleteActivityMode;
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zznp
    public final zznp c(List list) {
        this.f78252c = ImmutableList.t(list);
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zznp
    public final zznp d(zzor zzorVar) {
        if (zzorVar == null) {
            throw new NullPointerException("Null activityOrigin");
        }
        this.f78253d = zzorVar;
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zznp
    public final zznp e(String str) {
        this.f78255f = str;
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zznp
    public final zznp f(List list) {
        this.f78260k = ImmutableList.t(list);
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zznp
    public final zznp g(int i3) {
        this.f78261l = i3;
        this.f78267r = (byte) (this.f78267r | 1);
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zznp
    public final zznp h(int i3) {
        this.f78262m = i3;
        this.f78267r = (byte) (this.f78267r | 2);
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zznp
    public final zznp i(boolean z2) {
        this.f78265p = z2;
        this.f78267r = (byte) (this.f78267r | 4);
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zznp
    public final zznq j() {
        zzow zzowVar;
        AutocompleteActivityMode autocompleteActivityMode;
        ImmutableList immutableList;
        zzor zzorVar;
        ImmutableList immutableList2;
        ImmutableList immutableList3;
        if (this.f78267r == 7 && (zzowVar = this.f78250a) != null && (autocompleteActivityMode = this.f78251b) != null && (immutableList = this.f78252c) != null && (zzorVar = this.f78253d) != null && (immutableList2 = this.f78259j) != null && (immutableList3 = this.f78260k) != null) {
            return new zznm(zzowVar, autocompleteActivityMode, immutableList, zzorVar, this.f78254e, this.f78255f, this.f78256g, this.f78257h, this.f78258i, immutableList2, immutableList3, this.f78261l, this.f78262m, this.f78263n, this.f78264o, this.f78265p, this.f78266q);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f78250a == null) {
            sb.append(" widgetBackend");
        }
        if (this.f78251b == null) {
            sb.append(" mode");
        }
        if (this.f78252c == null) {
            sb.append(" placeFields");
        }
        if (this.f78253d == null) {
            sb.append(" activityOrigin");
        }
        if (this.f78259j == null) {
            sb.append(" countries");
        }
        if (this.f78260k == null) {
            sb.append(" typesFilter");
        }
        if ((this.f78267r & 1) == 0) {
            sb.append(" primaryColor");
        }
        if ((this.f78267r & 2) == 0) {
            sb.append(" primaryColorDark");
        }
        if ((this.f78267r & 4) == 0) {
            sb.append(" pureServiceAreaBusinessesIncluded");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    public final zznp k(List list) {
        this.f78259j = ImmutableList.t(list);
        return this;
    }

    zznj(zznq zznqVar) {
        this.f78250a = zznqVar.c();
        this.f78251b = zznqVar.d();
        this.f78252c = zznqVar.e();
        this.f78253d = zznqVar.f();
        this.f78254e = zznqVar.g();
        this.f78255f = zznqVar.h();
        this.f78256g = zznqVar.i();
        this.f78257h = zznqVar.j();
        this.f78258i = zznqVar.k();
        this.f78259j = zznqVar.l();
        this.f78260k = zznqVar.m();
        this.f78261l = zznqVar.n();
        this.f78262m = zznqVar.o();
        this.f78263n = zznqVar.p();
        this.f78264o = zznqVar.q();
        this.f78265p = zznqVar.r();
        this.f78266q = zznqVar.s();
        this.f78267r = (byte) 7;
    }
}
