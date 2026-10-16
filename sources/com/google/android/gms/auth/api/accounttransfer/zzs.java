package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.ArrayMap;
import com.facebook.GraphResponse;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.internal.auth.zzbz;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzs extends zzbz {
    public static final Parcelable.Creator<zzs> CREATOR = new zzt();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final ArrayMap f71021h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f71022a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List f71023b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List f71024c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List f71025d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List f71026f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List f71027g;

    static {
        ArrayMap arrayMap = new ArrayMap();
        f71021h = arrayMap;
        arrayMap.put("registered", FastJsonResponse.Field.w0("registered", 2));
        arrayMap.put("in_progress", FastJsonResponse.Field.w0("in_progress", 3));
        arrayMap.put(GraphResponse.SUCCESS_KEY, FastJsonResponse.Field.w0(GraphResponse.SUCCESS_KEY, 4));
        arrayMap.put("failed", FastJsonResponse.Field.w0("failed", 5));
        arrayMap.put("escrowed", FastJsonResponse.Field.w0("escrowed", 6));
    }

    zzs(int i3, List list, List list2, List list3, List list4, List list5) {
        this.f71022a = i3;
        this.f71023b = list;
        this.f71024c = list2;
        this.f71025d = list3;
        this.f71026f = list4;
        this.f71027g = list5;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final Map getFieldMappings() {
        return f71021h;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final Object getFieldValue(FastJsonResponse.Field field) {
        switch (field.z0()) {
            case 1:
                return Integer.valueOf(this.f71022a);
            case 2:
                return this.f71023b;
            case 3:
                return this.f71024c;
            case 4:
                return this.f71025d;
            case 5:
                return this.f71026f;
            case 6:
                return this.f71027g;
            default:
                throw new IllegalStateException("Unknown SafeParcelable id=" + field.z0());
        }
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final boolean isFieldSet(FastJsonResponse.Field field) {
        return true;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void setStringsInternal(FastJsonResponse.Field field, String str, ArrayList arrayList) {
        int iZ0 = field.z0();
        if (iZ0 == 2) {
            this.f71023b = arrayList;
            return;
        }
        if (iZ0 == 3) {
            this.f71024c = arrayList;
            return;
        }
        if (iZ0 == 4) {
            this.f71025d = arrayList;
        } else if (iZ0 == 5) {
            this.f71026f = arrayList;
        } else {
            if (iZ0 != 6) {
                throw new IllegalArgumentException(String.format("Field with id=%d is not known to be a string list.", Integer.valueOf(iZ0)));
            }
            this.f71027g = arrayList;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, this.f71022a);
        SafeParcelWriter.I(parcel, 2, this.f71023b, false);
        SafeParcelWriter.I(parcel, 3, this.f71024c, false);
        SafeParcelWriter.I(parcel, 4, this.f71025d, false);
        SafeParcelWriter.I(parcel, 5, this.f71026f, false);
        SafeParcelWriter.I(parcel, 6, this.f71027g, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
