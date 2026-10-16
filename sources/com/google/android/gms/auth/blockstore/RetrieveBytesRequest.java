package com.google.android.gms.auth.blockstore;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class RetrieveBytesRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RetrieveBytesRequest> CREATOR = new zzc();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f71275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f71276b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private List f71277a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f71278b = false;

        public RetrieveBytesRequest a() {
            return new RetrieveBytesRequest(this.f71277a, this.f71278b);
        }

        public Builder b(boolean z2) {
            this.f71278b = z2;
            return this;
        }
    }

    RetrieveBytesRequest(List list, boolean z2) {
        if (z2) {
            boolean z3 = true;
            if (list != null && !list.isEmpty()) {
                z3 = false;
            }
            Preconditions.r(z3, "retrieveAll was set to true but other constraint(s) was also provided: keys");
        }
        this.f71276b = z2;
        this.f71275a = new ArrayList();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                Preconditions.h(str, "Element in keys cannot be null or empty");
                this.f71275a.add(str);
            }
        }
    }

    public List M() {
        return Collections.unmodifiableList(this.f71275a);
    }

    public boolean N() {
        return this.f71276b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.I(parcel, 1, M(), false);
        SafeParcelWriter.g(parcel, 2, N());
        SafeParcelWriter.b(parcel, iA);
    }
}
