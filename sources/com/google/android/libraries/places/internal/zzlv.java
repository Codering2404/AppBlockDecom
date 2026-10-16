package com.google.android.libraries.places.internal;

import android.location.Location;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.places.api.model.LocationBias;
import com.google.android.libraries.places.api.model.LocationRestriction;
import com.google.android.libraries.places.api.model.RectangularBounds;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzlv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ImmutableMap f78178a = ImmutableMap.a().g(zzfn.NONE, "NONE").g(zzfn.PSK, "WPA_PSK").g(zzfn.EAP, "WPA_EAP").g(zzfn.OTHER, "SECURED_NONE").d();

    /* JADX WARN: Multi-variable type inference failed */
    public static String a(ImmutableList immutableList, int i3) {
        Preconditions.e(true, "maxLength must not be negative");
        StringBuilder sb = new StringBuilder();
        int size = immutableList.size();
        for (int i4 = 0; i4 < size; i4++) {
            zzfo zzfoVar = (zzfo) immutableList.get(i4);
            int length = sb.length();
            String strValueOf = String.valueOf(Joiner.i(",").m("=").f(ImmutableMap.a().g("mac", zzfoVar.a()).g("strength_dbm", Integer.valueOf(zzfoVar.b())).g("wifi_auth_type", f78178a.get(zzfoVar.c())).g("is_connected", Boolean.valueOf(zzfoVar.d())).g("frequency_mhz", Integer.valueOf(zzfoVar.e())).d()));
            int length2 = sb.length();
            String strConcat = (length > 0 ? "|" : "").concat(strValueOf);
            if (length2 + strConcat.length() > 4000) {
                break;
            }
            sb.append(strConcat);
        }
        return sb.toString();
    }

    public static String b(Location location) {
        if (location == null) {
            return null;
        }
        return f(location.getLatitude(), location.getLongitude());
    }

    public static String c(LatLng latLng) {
        if (latLng == null) {
            return null;
        }
        return f(latLng.f73163a, latLng.f73164b);
    }

    public static String d(LocationBias locationBias) {
        if (locationBias == null) {
            return null;
        }
        if (locationBias instanceof RectangularBounds) {
            return g((RectangularBounds) locationBias);
        }
        throw new AssertionError("Unknown LocationBias type.");
    }

    public static String e(LocationRestriction locationRestriction) {
        if (locationRestriction == null) {
            return null;
        }
        if (locationRestriction instanceof RectangularBounds) {
            return g((RectangularBounds) locationRestriction);
        }
        throw new AssertionError("Unknown LocationRestriction type.");
    }

    private static String f(double d3, double d4) {
        return String.format(Locale.US, "%.15f,%.15f", Double.valueOf(d3), Double.valueOf(d4));
    }

    private static String g(RectangularBounds rectangularBounds) {
        LatLng latLngD = rectangularBounds.d();
        double d3 = latLngD.f73163a;
        double d4 = latLngD.f73164b;
        LatLng latLngC = rectangularBounds.c();
        return String.format(Locale.US, "rectangle:%.15f,%.15f|%.15f,%.15f", Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(latLngC.f73163a), Double.valueOf(latLngC.f73164b));
    }
}
