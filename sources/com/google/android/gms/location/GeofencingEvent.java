package com.google.android.gms.location;

import android.location.Location;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class GeofencingEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f72911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f72912b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f72913c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Location f72914d;

    private GeofencingEvent(int i3, int i4, List list, Location location) {
        this.f72911a = i3;
        this.f72912b = i4;
        this.f72913c = list;
        this.f72914d = location;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.location.GeofencingEvent a(android.content.Intent r12) {
        /*
            r0 = 0
            if (r12 != 0) goto L5
            goto L6c
        L5:
            java.lang.String r1 = "gms_error_code"
            r2 = -1
            int r1 = r12.getIntExtra(r1, r2)
            java.lang.String r3 = "com.google.android.location.intent.extra.transition"
            int r3 = r12.getIntExtra(r3, r2)
            if (r3 != r2) goto L16
        L14:
            r3 = r2
            goto L20
        L16:
            r4 = 1
            if (r3 == r4) goto L20
            r4 = 2
            if (r3 == r4) goto L20
            r4 = 4
            if (r3 != r4) goto L14
            r3 = r4
        L20:
            java.lang.String r4 = "com.google.android.location.intent.extra.geofence_list"
            java.io.Serializable r4 = r12.getSerializableExtra(r4)
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            if (r4 != 0) goto L2c
            r5 = r0
            goto L5f
        L2c:
            java.util.ArrayList r5 = new java.util.ArrayList
            int r6 = r4.size()
            r5.<init>(r6)
            int r6 = r4.size()
            r7 = 0
            r8 = r7
        L3b:
            if (r8 >= r6) goto L5f
            java.lang.Object r9 = r4.get(r8)
            byte[] r9 = (byte[]) r9
            android.os.Parcel r10 = android.os.Parcel.obtain()
            int r11 = r9.length
            r10.unmarshall(r9, r7, r11)
            r10.setDataPosition(r7)
            android.os.Parcelable$Creator<com.google.android.gms.internal.location.zzek> r9 = com.google.android.gms.internal.location.zzek.CREATOR
            java.lang.Object r9 = r9.createFromParcel(r10)
            com.google.android.gms.internal.location.zzek r9 = (com.google.android.gms.internal.location.zzek) r9
            r10.recycle()
            r5.add(r9)
            int r8 = r8 + 1
            goto L3b
        L5f:
            java.lang.String r4 = "com.google.android.location.intent.extra.triggering_location"
            android.os.Parcelable r12 = r12.getParcelableExtra(r4)
            android.location.Location r12 = (android.location.Location) r12
            if (r5 != 0) goto L6d
            if (r1 == r2) goto L6c
            goto L6d
        L6c:
            return r0
        L6d:
            com.google.android.gms.location.GeofencingEvent r0 = new com.google.android.gms.location.GeofencingEvent
            r0.<init>(r1, r3, r5, r12)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.location.GeofencingEvent.a(android.content.Intent):com.google.android.gms.location.GeofencingEvent");
    }

    public int b() {
        return this.f72911a;
    }

    public int c() {
        return this.f72912b;
    }

    public List d() {
        return this.f72913c;
    }

    public boolean e() {
        return this.f72911a != -1;
    }
}
