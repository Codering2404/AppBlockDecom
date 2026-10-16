package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class PolygonOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PolygonOptions> CREATOR = new zzq();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f73202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f73203b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f73204c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f73205d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f73206f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f73207g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f73208h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f73209i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f73210j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f73211k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private List f73212l;

    public PolygonOptions() {
        this.f73204c = 10.0f;
        this.f73205d = -16777216;
        this.f73206f = 0;
        this.f73207g = 0.0f;
        this.f73208h = true;
        this.f73209i = false;
        this.f73210j = false;
        this.f73211k = 0;
        this.f73212l = null;
        this.f73202a = new ArrayList();
        this.f73203b = new ArrayList();
    }

    public int J2() {
        return this.f73211k;
    }

    public List K2() {
        return this.f73212l;
    }

    public float L2() {
        return this.f73204c;
    }

    public PolygonOptions M(Iterable iterable) {
        Preconditions.n(iterable, "points must not be null.");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            this.f73202a.add((LatLng) it.next());
        }
        return this;
    }

    public float M2() {
        return this.f73207g;
    }

    public PolygonOptions N(Iterable iterable) {
        Preconditions.n(iterable, "points must not be null.");
        ArrayList arrayList = new ArrayList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add((LatLng) it.next());
        }
        this.f73203b.add(arrayList);
        return this;
    }

    public boolean N2() {
        return this.f73210j;
    }

    public PolygonOptions O(boolean z2) {
        this.f73210j = z2;
        return this;
    }

    public boolean O2() {
        return this.f73209i;
    }

    public boolean P2() {
        return this.f73208h;
    }

    public PolygonOptions Q2(int i3) {
        this.f73205d = i3;
        return this;
    }

    public PolygonOptions R2(int i3) {
        this.f73211k = i3;
        return this;
    }

    public PolygonOptions S2(List list) {
        this.f73212l = list;
        return this;
    }

    public PolygonOptions T2(float f3) {
        this.f73204c = f3;
        return this;
    }

    public PolygonOptions U2(boolean z2) {
        this.f73208h = z2;
        return this;
    }

    public PolygonOptions V2(float f3) {
        this.f73207g = f3;
        return this;
    }

    public PolygonOptions g0(int i3) {
        this.f73206f = i3;
        return this;
    }

    public int h1() {
        return this.f73205d;
    }

    public PolygonOptions j0(boolean z2) {
        this.f73209i = z2;
        return this;
    }

    public int w0() {
        return this.f73206f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.K(parcel, 2, z0(), false);
        SafeParcelWriter.y(parcel, 3, this.f73203b, false);
        SafeParcelWriter.q(parcel, 4, L2());
        SafeParcelWriter.u(parcel, 5, h1());
        SafeParcelWriter.u(parcel, 6, w0());
        SafeParcelWriter.q(parcel, 7, M2());
        SafeParcelWriter.g(parcel, 8, P2());
        SafeParcelWriter.g(parcel, 9, O2());
        SafeParcelWriter.g(parcel, 10, N2());
        SafeParcelWriter.u(parcel, 11, J2());
        SafeParcelWriter.K(parcel, 12, K2(), false);
        SafeParcelWriter.b(parcel, iA);
    }

    public List z0() {
        return this.f73202a;
    }

    PolygonOptions(List list, List list2, float f3, int i3, int i4, float f4, boolean z2, boolean z3, boolean z4, int i5, List list3) {
        this.f73202a = list;
        this.f73203b = list2;
        this.f73204c = f3;
        this.f73205d = i3;
        this.f73206f = i4;
        this.f73207g = f4;
        this.f73208h = z2;
        this.f73209i = z3;
        this.f73210j = z4;
        this.f73211k = i5;
        this.f73212l = list3;
    }
}
