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
public class DeleteBytesRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DeleteBytesRequest> CREATOR = new zzb();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f71271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f71272b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private List f71273a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f71274b = false;

        public DeleteBytesRequest a() {
            return new DeleteBytesRequest(this.f71273a, this.f71274b);
        }

        public Builder b(List list) {
            Preconditions.n(list, "Keys cannot be set to null");
            this.f71273a = list;
            return this;
        }
    }

    DeleteBytesRequest(List list, boolean z2) {
        if (z2) {
            boolean z3 = true;
            if (list != null && !list.isEmpty()) {
                z3 = false;
            }
            Preconditions.r(z3, "deleteAll was set to true but other constraint(s) was also provided: keys");
        }
        this.f71272b = z2;
        this.f71271a = new ArrayList();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                Preconditions.h(str, "Element in keys cannot be null or empty");
                this.f71271a.add(str);
            }
        }
    }

    public boolean M() {
        return this.f71272b;
    }

    public List N() {
        return Collections.unmodifiableList(this.f71271a);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.I(parcel, 1, N(), false);
        SafeParcelWriter.g(parcel, 2, M());
        SafeParcelWriter.b(parcel, iA);
    }
}
