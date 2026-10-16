package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.internal.auth.zzbz;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzo extends zzbz {
    public static final Parcelable.Creator<zzo> CREATOR = new zzp();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final HashMap f71013g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Set f71014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f71015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ArrayList f71016c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f71017d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private zzs f71018f;

    static {
        HashMap map = new HashMap();
        f71013g = map;
        map.put("authenticatorData", FastJsonResponse.Field.O("authenticatorData", 2, zzu.class));
        map.put("progress", FastJsonResponse.Field.N("progress", 4, zzs.class));
    }

    zzo(Set set, int i3, ArrayList arrayList, int i4, zzs zzsVar) {
        this.f71014a = set;
        this.f71015b = i3;
        this.f71016c = arrayList;
        this.f71017d = i4;
        this.f71018f = zzsVar;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void addConcreteTypeArrayInternal(FastJsonResponse.Field field, String str, ArrayList arrayList) {
        int iZ0 = field.z0();
        if (iZ0 != 2) {
            throw new IllegalArgumentException(String.format("Field with id=%d is not a known ConcreteTypeArray type. Found %s", Integer.valueOf(iZ0), arrayList.getClass().getCanonicalName()));
        }
        this.f71016c = arrayList;
        this.f71014a.add(Integer.valueOf(iZ0));
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void addConcreteTypeInternal(FastJsonResponse.Field field, String str, FastJsonResponse fastJsonResponse) {
        int iZ0 = field.z0();
        if (iZ0 != 4) {
            throw new IllegalArgumentException(String.format("Field with id=%d is not a known custom type. Found %s", Integer.valueOf(iZ0), fastJsonResponse.getClass().getCanonicalName()));
        }
        this.f71018f = (zzs) fastJsonResponse;
        this.f71014a.add(Integer.valueOf(iZ0));
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final /* synthetic */ Map getFieldMappings() {
        return f71013g;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final Object getFieldValue(FastJsonResponse.Field field) {
        int iZ0 = field.z0();
        if (iZ0 == 1) {
            return Integer.valueOf(this.f71015b);
        }
        if (iZ0 == 2) {
            return this.f71016c;
        }
        if (iZ0 == 4) {
            return this.f71018f;
        }
        throw new IllegalStateException("Unknown SafeParcelable id=" + field.z0());
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final boolean isFieldSet(FastJsonResponse.Field field) {
        return this.f71014a.contains(Integer.valueOf(field.z0()));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        Set set = this.f71014a;
        if (set.contains(1)) {
            SafeParcelWriter.u(parcel, 1, this.f71015b);
        }
        if (set.contains(2)) {
            SafeParcelWriter.K(parcel, 2, this.f71016c, true);
        }
        if (set.contains(3)) {
            SafeParcelWriter.u(parcel, 3, this.f71017d);
        }
        if (set.contains(4)) {
            SafeParcelWriter.E(parcel, 4, this.f71018f, i3, true);
        }
        SafeParcelWriter.b(parcel, iA);
    }
}
