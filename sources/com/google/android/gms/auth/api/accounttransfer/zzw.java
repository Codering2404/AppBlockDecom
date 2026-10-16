package com.google.android.gms.auth.api.accounttransfer;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.internal.auth.zzbz;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzw extends zzbz {
    public static final Parcelable.Creator<zzw> CREATOR = new zzx();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final HashMap f71035i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Set f71036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f71037b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f71038c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f71039d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private byte[] f71040f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private PendingIntent f71041g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private DeviceMetaData f71042h;

    static {
        HashMap map = new HashMap();
        f71035i = map;
        map.put("accountType", FastJsonResponse.Field.j0("accountType", 2));
        map.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, FastJsonResponse.Field.g0(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, 3));
        map.put("transferBytes", FastJsonResponse.Field.M("transferBytes", 4));
    }

    zzw(Set set, int i3, String str, int i4, byte[] bArr, PendingIntent pendingIntent, DeviceMetaData deviceMetaData) {
        this.f71036a = set;
        this.f71037b = i3;
        this.f71038c = str;
        this.f71039d = i4;
        this.f71040f = bArr;
        this.f71041g = pendingIntent;
        this.f71042h = deviceMetaData;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final /* synthetic */ Map getFieldMappings() {
        return f71035i;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final Object getFieldValue(FastJsonResponse.Field field) {
        int iZ0 = field.z0();
        if (iZ0 == 1) {
            return Integer.valueOf(this.f71037b);
        }
        if (iZ0 == 2) {
            return this.f71038c;
        }
        if (iZ0 == 3) {
            return Integer.valueOf(this.f71039d);
        }
        if (iZ0 == 4) {
            return this.f71040f;
        }
        throw new IllegalStateException("Unknown SafeParcelable id=" + field.z0());
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final boolean isFieldSet(FastJsonResponse.Field field) {
        return this.f71036a.contains(Integer.valueOf(field.z0()));
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void setDecodedBytesInternal(FastJsonResponse.Field field, String str, byte[] bArr) {
        int iZ0 = field.z0();
        if (iZ0 == 4) {
            this.f71040f = bArr;
            this.f71036a.add(Integer.valueOf(iZ0));
        } else {
            throw new IllegalArgumentException("Field with id=" + iZ0 + " is not known to be a byte array.");
        }
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void setIntegerInternal(FastJsonResponse.Field field, String str, int i3) {
        int iZ0 = field.z0();
        if (iZ0 == 3) {
            this.f71039d = i3;
            this.f71036a.add(Integer.valueOf(iZ0));
        } else {
            throw new IllegalArgumentException("Field with id=" + iZ0 + " is not known to be an int.");
        }
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void setStringInternal(FastJsonResponse.Field field, String str, String str2) {
        int iZ0 = field.z0();
        if (iZ0 != 2) {
            throw new IllegalArgumentException(String.format("Field with id=%d is not known to be a string.", Integer.valueOf(iZ0)));
        }
        this.f71038c = str2;
        this.f71036a.add(Integer.valueOf(iZ0));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        Set set = this.f71036a;
        if (set.contains(1)) {
            SafeParcelWriter.u(parcel, 1, this.f71037b);
        }
        if (set.contains(2)) {
            SafeParcelWriter.G(parcel, 2, this.f71038c, true);
        }
        if (set.contains(3)) {
            SafeParcelWriter.u(parcel, 3, this.f71039d);
        }
        if (set.contains(4)) {
            SafeParcelWriter.l(parcel, 4, this.f71040f, true);
        }
        if (set.contains(5)) {
            SafeParcelWriter.E(parcel, 5, this.f71041g, i3, true);
        }
        if (set.contains(6)) {
            SafeParcelWriter.E(parcel, 6, this.f71042h, i3, true);
        }
        SafeParcelWriter.b(parcel, iA);
    }
}
