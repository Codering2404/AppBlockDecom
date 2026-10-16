package com.google.android.gms.maps.model;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.stetho.common.Utf8Charset;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.IOUtils;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class MapStyleOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<MapStyleOptions> CREATOR = new zzk();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f73168a;

    public MapStyleOptions(String str) {
        Preconditions.n(str, "json must not be null");
        this.f73168a = str;
    }

    public static MapStyleOptions M(Context context, int i3) {
        try {
            return new MapStyleOptions(new String(IOUtils.d(context.getResources().openRawResource(i3)), Utf8Charset.NAME));
        } catch (IOException e3) {
            throw new Resources.NotFoundException("Failed to read resource " + i3 + ": " + e3.toString());
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        String str = this.f73168a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.G(parcel, 2, str, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
