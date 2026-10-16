package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.server.response.FastJsonResponse;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zaa extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zaa> CREATOR = new zab();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f72197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final StringToIntConverter f72198b;

    zaa(int i3, StringToIntConverter stringToIntConverter) {
        this.f72197a = i3;
        this.f72198b = stringToIntConverter;
    }

    public static zaa M(FastJsonResponse.FieldConverter fieldConverter) {
        if (fieldConverter instanceof StringToIntConverter) {
            return new zaa((StringToIntConverter) fieldConverter);
        }
        throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    }

    public final FastJsonResponse.FieldConverter N() {
        StringToIntConverter stringToIntConverter = this.f72198b;
        if (stringToIntConverter != null) {
            return stringToIntConverter;
        }
        throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i4 = this.f72197a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, i4);
        SafeParcelWriter.E(parcel, 2, this.f72198b, i3, false);
        SafeParcelWriter.b(parcel, iA);
    }

    private zaa(StringToIntConverter stringToIntConverter) {
        this.f72197a = 1;
        this.f72198b = stringToIntConverter;
    }
}
