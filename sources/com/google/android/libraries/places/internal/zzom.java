package com.google.android.libraries.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.places.api.model.AutocompleteSessionToken;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;
import com.google.android.libraries.places.widget.model.AutocompleteUiCustomization;
import com.google.common.base.Strings;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzom implements Parcelable {
    public static final Parcelable.Creator<zzom> CREATOR = new zzol();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzow f78335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AutocompleteUiCustomization f78336b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private zzok f78337c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzor f78338d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AutocompleteActivityMode f78339f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AutocompleteSessionToken f78340g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f78341h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f78342i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f78343j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f78344k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f78345l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f78346m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f78347n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f78348o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f78349p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f78350q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f78351r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f78352s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f78353t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f78354u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private long f78355v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final zzef f78356w;

    /* synthetic */ zzom(Parcel parcel, byte[] bArr) {
        this.f78335a = (zzow) parcel.readParcelable(zzow.class.getClassLoader());
        this.f78336b = (AutocompleteUiCustomization) parcel.readParcelable(AutocompleteUiCustomization.class.getClassLoader());
        this.f78337c = (zzok) parcel.readParcelable(zzok.class.getClassLoader());
        this.f78338d = (zzor) parcel.readParcelable(zzor.class.getClassLoader());
        this.f78339f = (AutocompleteActivityMode) parcel.readParcelable(AutocompleteActivityMode.class.getClassLoader());
        this.f78340g = (AutocompleteSessionToken) parcel.readParcelable(AutocompleteSessionToken.class.getClassLoader());
        this.f78348o = j(parcel);
        this.f78341h = j(parcel);
        this.f78342i = j(parcel);
        this.f78347n = parcel.readInt();
        this.f78343j = parcel.readInt();
        this.f78344k = parcel.readInt();
        this.f78345l = parcel.readInt();
        this.f78349p = j(parcel);
        this.f78346m = parcel.readInt();
        this.f78350q = Strings.e(parcel.readString());
        this.f78351r = parcel.readInt();
        this.f78352s = parcel.readInt();
        this.f78353t = j(parcel);
        this.f78354u = parcel.readInt();
        this.f78355v = parcel.readLong();
        this.f78356w = new zzei();
    }

    private static boolean j(Parcel parcel) {
        return parcel.readInt() != 0;
    }

    private final boolean k() {
        return this.f78355v != -1;
    }

    public final int A() {
        return this.f78346m;
    }

    public final String B() {
        return this.f78350q;
    }

    public final int C() {
        return this.f78351r;
    }

    public final int D() {
        return this.f78352s;
    }

    public final boolean E() {
        return this.f78353t;
    }

    public final int F() {
        return this.f78354u;
    }

    public final void G(int i3) {
        this.f78348o = true;
        this.f78347n = i3;
    }

    public final void H() {
        this.f78341h = true;
    }

    public final void I() {
        if (this.f78341h || this.f78349p) {
            return;
        }
        this.f78342i = true;
    }

    public final void J() {
        this.f78343j++;
    }

    public final void K() {
        this.f78344k++;
    }

    public final void L() {
        this.f78345l++;
    }

    public final void c() {
        this.f78349p = true;
    }

    public final void d() {
        this.f78346m++;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final void e(String str) {
        this.f78351r++;
        this.f78350q = str;
    }

    public final void f() {
        this.f78352s++;
    }

    public final void g() {
        this.f78353t = true;
    }

    public final void h() {
        if (k()) {
            return;
        }
        this.f78355v = this.f78356w.zzb();
    }

    public final void i() {
        if (k()) {
            this.f78354u += (int) (this.f78356w.zzb() - this.f78355v);
            this.f78355v = -1L;
        }
    }

    public final zzow l() {
        return this.f78335a;
    }

    public final AutocompleteUiCustomization m() {
        return this.f78336b;
    }

    public final zzok n() {
        return this.f78337c;
    }

    public final void o(zzok zzokVar) {
        this.f78337c = zzokVar;
    }

    public final zzor p() {
        return this.f78338d;
    }

    public final AutocompleteActivityMode q() {
        return this.f78339f;
    }

    public final AutocompleteSessionToken r() {
        return this.f78340g;
    }

    public final boolean s() {
        return this.f78348o;
    }

    public final boolean t() {
        return this.f78341h;
    }

    public final boolean u() {
        return this.f78342i;
    }

    public final int v() {
        return this.f78347n;
    }

    public final int w() {
        return this.f78343j;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeParcelable(this.f78335a, i3);
        parcel.writeParcelable(this.f78336b, i3);
        parcel.writeParcelable(this.f78337c, i3);
        parcel.writeParcelable(this.f78338d, i3);
        parcel.writeParcelable(this.f78339f, i3);
        parcel.writeParcelable(this.f78340g, i3);
        parcel.writeInt(this.f78348o ? 1 : 0);
        parcel.writeInt(this.f78341h ? 1 : 0);
        parcel.writeInt(this.f78342i ? 1 : 0);
        parcel.writeInt(this.f78347n);
        parcel.writeInt(this.f78343j);
        parcel.writeInt(this.f78344k);
        parcel.writeInt(this.f78345l);
        parcel.writeInt(this.f78349p ? 1 : 0);
        parcel.writeInt(this.f78346m);
        parcel.writeString(this.f78350q);
        parcel.writeInt(this.f78351r);
        parcel.writeInt(this.f78352s);
        parcel.writeInt(this.f78353t ? 1 : 0);
        parcel.writeInt(this.f78354u);
        parcel.writeLong(this.f78355v);
    }

    public final int x() {
        return this.f78344k;
    }

    public final int y() {
        return this.f78345l;
    }

    public zzom(zzow zzowVar, AutocompleteUiCustomization autocompleteUiCustomization, zzor zzorVar, AutocompleteActivityMode autocompleteActivityMode, String str, AutocompleteSessionToken autocompleteSessionToken, zzef zzefVar) {
        this.f78335a = zzowVar;
        this.f78336b = autocompleteUiCustomization;
        this.f78338d = zzorVar;
        this.f78339f = autocompleteActivityMode;
        if (autocompleteSessionToken == null) {
            this.f78340g = AutocompleteSessionToken.c();
        } else {
            this.f78340g = autocompleteSessionToken;
        }
        AutocompleteSessionToken.c();
        this.f78350q = Strings.e(str);
        this.f78347n = -1;
        this.f78355v = -1L;
        this.f78356w = zzefVar;
    }
}
