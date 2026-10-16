package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.maps.model.StrokeStyle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class PolylineOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PolylineOptions> CREATOR = new zzr();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f73214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f73215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f73216c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f73217d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f73218f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f73219g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f73220h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Cap f73221i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Cap f73222j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f73223k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private List f73224l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private List f73225m;

    public PolylineOptions() {
        this.f73215b = 10.0f;
        this.f73216c = -16777216;
        this.f73217d = 0.0f;
        this.f73218f = true;
        this.f73219g = false;
        this.f73220h = false;
        this.f73221i = new ButtCap();
        this.f73222j = new ButtCap();
        this.f73223k = 0;
        this.f73224l = null;
        this.f73225m = new ArrayList();
        this.f73214a = new ArrayList();
    }

    public List J2() {
        return this.f73224l;
    }

    public List K2() {
        return this.f73214a;
    }

    public Cap L2() {
        return this.f73221i.M();
    }

    public PolylineOptions M(Iterable iterable) {
        Preconditions.n(iterable, "points must not be null.");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            this.f73214a.add((LatLng) it.next());
        }
        return this;
    }

    public float M2() {
        return this.f73215b;
    }

    public PolylineOptions N(boolean z2) {
        this.f73220h = z2;
        return this;
    }

    public float N2() {
        return this.f73217d;
    }

    public PolylineOptions O(int i3) {
        this.f73216c = i3;
        return this;
    }

    public boolean O2() {
        return this.f73220h;
    }

    public boolean P2() {
        return this.f73219g;
    }

    public boolean Q2() {
        return this.f73218f;
    }

    public PolylineOptions R2(int i3) {
        this.f73223k = i3;
        return this;
    }

    public PolylineOptions S2(List list) {
        this.f73224l = list;
        return this;
    }

    public PolylineOptions T2(Cap cap) {
        this.f73221i = (Cap) Preconditions.n(cap, "startCap must not be null");
        return this;
    }

    public PolylineOptions U2(boolean z2) {
        this.f73218f = z2;
        return this;
    }

    public PolylineOptions V2(float f3) {
        this.f73215b = f3;
        return this;
    }

    public PolylineOptions W2(float f3) {
        this.f73217d = f3;
        return this;
    }

    public PolylineOptions g0(Cap cap) {
        this.f73222j = (Cap) Preconditions.n(cap, "endCap must not be null");
        return this;
    }

    public int h1() {
        return this.f73223k;
    }

    public PolylineOptions j0(boolean z2) {
        this.f73219g = z2;
        return this;
    }

    public int w0() {
        return this.f73216c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.K(parcel, 2, K2(), false);
        SafeParcelWriter.q(parcel, 3, M2());
        SafeParcelWriter.u(parcel, 4, w0());
        SafeParcelWriter.q(parcel, 5, N2());
        SafeParcelWriter.g(parcel, 6, Q2());
        SafeParcelWriter.g(parcel, 7, P2());
        SafeParcelWriter.g(parcel, 8, O2());
        SafeParcelWriter.E(parcel, 9, L2(), i3, false);
        SafeParcelWriter.E(parcel, 10, z0(), i3, false);
        SafeParcelWriter.u(parcel, 11, h1());
        SafeParcelWriter.K(parcel, 12, J2(), false);
        ArrayList arrayList = new ArrayList(this.f73225m.size());
        for (StyleSpan styleSpan : this.f73225m) {
            StrokeStyle.Builder builder = new StrokeStyle.Builder(styleSpan.N());
            builder.c(this.f73215b);
            builder.b(this.f73218f);
            arrayList.add(new StyleSpan(builder.a(), styleSpan.M()));
        }
        SafeParcelWriter.K(parcel, 13, arrayList, false);
        SafeParcelWriter.b(parcel, iA);
    }

    public Cap z0() {
        return this.f73222j.M();
    }

    PolylineOptions(List list, float f3, int i3, float f4, boolean z2, boolean z3, boolean z4, Cap cap, Cap cap2, int i4, List list2, List list3) {
        this.f73215b = 10.0f;
        this.f73216c = -16777216;
        this.f73217d = 0.0f;
        this.f73218f = true;
        this.f73219g = false;
        this.f73220h = false;
        this.f73221i = new ButtCap();
        this.f73222j = new ButtCap();
        this.f73223k = 0;
        this.f73224l = null;
        this.f73225m = new ArrayList();
        this.f73214a = list;
        this.f73215b = f3;
        this.f73216c = i3;
        this.f73217d = f4;
        this.f73218f = z2;
        this.f73219g = z3;
        this.f73220h = z4;
        if (cap != null) {
            this.f73221i = cap;
        }
        if (cap2 != null) {
            this.f73222j = cap2;
        }
        this.f73223k = i4;
        this.f73224l = list2;
        if (list3 != null) {
            this.f73225m = list3;
        }
    }
}
