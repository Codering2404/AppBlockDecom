package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zal extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zal> CREATOR = new zap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f72234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final String f72235b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final ArrayList f72236c;

    zal(int i3, String str, ArrayList arrayList) {
        this.f72234a = i3;
        this.f72235b = str;
        this.f72236c = arrayList;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i4 = this.f72234a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, i4);
        SafeParcelWriter.G(parcel, 2, this.f72235b, false);
        SafeParcelWriter.K(parcel, 3, this.f72236c, false);
        SafeParcelWriter.b(parcel, iA);
    }

    zal(String str, Map map) {
        ArrayList arrayList;
        this.f72234a = 1;
        this.f72235b = str;
        if (map == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (String str2 : map.keySet()) {
                arrayList.add(new zam(str2, (FastJsonResponse.Field) map.get(str2)));
            }
        }
        this.f72236c = arrayList;
    }
}
