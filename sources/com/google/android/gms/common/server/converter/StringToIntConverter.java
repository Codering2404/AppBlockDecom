package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class StringToIntConverter extends AbstractSafeParcelable implements FastJsonResponse.FieldConverter<String, Integer> {
    public static final Parcelable.Creator<StringToIntConverter> CREATOR = new zad();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f72194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashMap f72195b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SparseArray f72196c = new SparseArray();

    StringToIntConverter(int i3, ArrayList arrayList) {
        this.f72194a = i3;
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            zac zacVar = (zac) arrayList.get(i4);
            M(zacVar.f72200b, zacVar.f72201c);
        }
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse.FieldConverter
    public final /* bridge */ /* synthetic */ Object J(Object obj) {
        Integer num = (Integer) this.f72195b.get((String) obj);
        return num == null ? (Integer) this.f72195b.get("gms_unknown") : num;
    }

    public StringToIntConverter M(String str, int i3) {
        this.f72195b.put(str, Integer.valueOf(i3));
        this.f72196c.put(i3, str);
        return this;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse.FieldConverter
    public final /* bridge */ /* synthetic */ Object a(Object obj) {
        String str = (String) this.f72196c.get(((Integer) obj).intValue());
        return (str == null && this.f72195b.containsKey("gms_unknown")) ? "gms_unknown" : str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i4 = this.f72194a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, i4);
        ArrayList arrayList = new ArrayList();
        for (String str : this.f72195b.keySet()) {
            arrayList.add(new zac(str, ((Integer) this.f72195b.get(str)).intValue()));
        }
        SafeParcelWriter.K(parcel, 2, arrayList, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
