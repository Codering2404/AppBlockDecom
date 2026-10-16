package com.google.android.libraries.places.internal;

import android.location.Location;
import com.google.android.libraries.places.api.net.FindCurrentPlaceRequest;
import com.google.common.collect.ImmutableList;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzky extends zzld {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Location f78082e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ImmutableList f78083f;

    zzky(FindCurrentPlaceRequest findCurrentPlaceRequest, Location location, ImmutableList immutableList, Locale locale, String str, zznh zznhVar) {
        super(findCurrentPlaceRequest, locale, str, zznhVar);
        this.f78082e = location;
        this.f78083f = immutableList;
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0026  */
    @Override // com.google.android.libraries.places.internal.zzld
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.Map e() {
        /*
            r6 = this;
            com.google.android.libraries.places.internal.zzmq r0 = r6.a()
            com.google.android.libraries.places.api.net.FindCurrentPlaceRequest r0 = (com.google.android.libraries.places.api.net.FindCurrentPlaceRequest) r0
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            android.location.Location r2 = r6.f78082e
            java.lang.String r3 = com.google.android.libraries.places.internal.zzlv.b(r2)
            java.lang.String r4 = "location"
            r5 = 0
            com.google.android.libraries.places.internal.zzld.g(r1, r4, r3, r5)
            com.google.common.collect.ImmutableList r3 = r6.f78083f
            r4 = 4000(0xfa0, float:5.605E-42)
            java.lang.String r3 = com.google.android.libraries.places.internal.zzlv.a(r3, r4)
            java.lang.String r4 = "wifiaccesspoints"
            com.google.android.libraries.places.internal.zzld.g(r1, r4, r3, r5)
            if (r2 != 0) goto L28
        L26:
            r3 = r5
            goto L42
        L28:
            float r3 = r2.getAccuracy()
            boolean r4 = r2.hasAccuracy()
            if (r4 == 0) goto L26
            r4 = 0
            int r4 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r4 <= 0) goto L26
            r4 = 1120403456(0x42c80000, float:100.0)
            float r3 = r3 * r4
            int r3 = java.lang.Math.round(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
        L42:
            java.lang.String r4 = "precision"
            com.google.android.libraries.places.internal.zzld.g(r1, r4, r3, r5)
            long r2 = r2.getTime()
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            java.lang.String r3 = "timestamp"
            com.google.android.libraries.places.internal.zzld.g(r1, r3, r2, r5)
            java.util.List r0 = r0.c()
            java.lang.String r0 = com.google.android.libraries.places.internal.zzlw.b(r0)
            java.lang.String r2 = "fields"
            com.google.android.libraries.places.internal.zzld.g(r1, r2, r0, r5)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzky.e():java.util.Map");
    }

    @Override // com.google.android.libraries.places.internal.zzld
    protected final String f() {
        return "findplacefromuserlocation/json";
    }
}
