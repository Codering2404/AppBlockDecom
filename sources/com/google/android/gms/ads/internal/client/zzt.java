package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.applovin.sdk.AppLovinEventParameters;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@ParametersAreNonnullByDefault
public final class zzt extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzt> CREATOR = new zzu();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f70020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f70021b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f70022c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f70023d;

    public zzt(int i3, int i4, String str, long j3) {
        this.f70020a = i3;
        this.f70021b = i4;
        this.f70022c = str;
        this.f70023d = j3;
    }

    public static zzt M(JSONObject jSONObject) {
        return new zzt(jSONObject.getInt("type_num"), jSONObject.getInt("precision_num"), jSONObject.getString(AppLovinEventParameters.REVENUE_CURRENCY), jSONObject.getLong("value"));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i4 = this.f70020a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, i4);
        SafeParcelWriter.u(parcel, 2, this.f70021b);
        SafeParcelWriter.G(parcel, 3, this.f70022c, false);
        SafeParcelWriter.z(parcel, 4, this.f70023d);
        SafeParcelWriter.b(parcel, iA);
    }
}
