package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.AuthenticationToken;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.internal.auth.zzbz;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzu extends zzbz {
    public static final Parcelable.Creator<zzu> CREATOR = new zzv();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final HashMap f71028h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Set f71029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f71030b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private zzw f71031c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f71032d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f71033f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f71034g;

    static {
        HashMap map = new HashMap();
        f71028h = map;
        map.put("authenticatorInfo", FastJsonResponse.Field.N("authenticatorInfo", 2, zzw.class));
        map.put(AuthenticationToken.SIGNATURE_KEY, FastJsonResponse.Field.j0(AuthenticationToken.SIGNATURE_KEY, 3));
        map.put("package", FastJsonResponse.Field.j0("package", 4));
    }

    zzu(Set set, int i3, zzw zzwVar, String str, String str2, String str3) {
        this.f71029a = set;
        this.f71030b = i3;
        this.f71031c = zzwVar;
        this.f71032d = str;
        this.f71033f = str2;
        this.f71034g = str3;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void addConcreteTypeInternal(FastJsonResponse.Field field, String str, FastJsonResponse fastJsonResponse) {
        int iZ0 = field.z0();
        if (iZ0 != 2) {
            throw new IllegalArgumentException(String.format("Field with id=%d is not a known custom type. Found %s", Integer.valueOf(iZ0), fastJsonResponse.getClass().getCanonicalName()));
        }
        this.f71031c = (zzw) fastJsonResponse;
        this.f71029a.add(Integer.valueOf(iZ0));
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final /* synthetic */ Map getFieldMappings() {
        return f71028h;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final Object getFieldValue(FastJsonResponse.Field field) {
        int iZ0 = field.z0();
        if (iZ0 == 1) {
            return Integer.valueOf(this.f71030b);
        }
        if (iZ0 == 2) {
            return this.f71031c;
        }
        if (iZ0 == 3) {
            return this.f71032d;
        }
        if (iZ0 == 4) {
            return this.f71033f;
        }
        throw new IllegalStateException("Unknown SafeParcelable id=" + field.z0());
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final boolean isFieldSet(FastJsonResponse.Field field) {
        return this.f71029a.contains(Integer.valueOf(field.z0()));
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void setStringInternal(FastJsonResponse.Field field, String str, String str2) {
        int iZ0 = field.z0();
        if (iZ0 == 3) {
            this.f71032d = str2;
        } else {
            if (iZ0 != 4) {
                throw new IllegalArgumentException(String.format("Field with id=%d is not known to be a string.", Integer.valueOf(iZ0)));
            }
            this.f71033f = str2;
        }
        this.f71029a.add(Integer.valueOf(iZ0));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        Set set = this.f71029a;
        if (set.contains(1)) {
            SafeParcelWriter.u(parcel, 1, this.f71030b);
        }
        if (set.contains(2)) {
            SafeParcelWriter.E(parcel, 2, this.f71031c, i3, true);
        }
        if (set.contains(3)) {
            SafeParcelWriter.G(parcel, 3, this.f71032d, true);
        }
        if (set.contains(4)) {
            SafeParcelWriter.G(parcel, 4, this.f71033f, true);
        }
        if (set.contains(5)) {
            SafeParcelWriter.G(parcel, 5, this.f71034g, true);
        }
        SafeParcelWriter.b(parcel, iA);
    }
}
