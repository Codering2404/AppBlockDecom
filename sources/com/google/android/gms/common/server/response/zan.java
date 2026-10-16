package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zan extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zan> CREATOR = new zao();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f72240a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashMap f72241b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f72242c;

    zan(int i3, ArrayList arrayList, String str) {
        this.f72240a = i3;
        HashMap map = new HashMap();
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            zal zalVar = (zal) arrayList.get(i4);
            String str2 = zalVar.f72235b;
            HashMap map2 = new HashMap();
            int size2 = ((ArrayList) Preconditions.m(zalVar.f72236c)).size();
            for (int i5 = 0; i5 < size2; i5++) {
                zam zamVar = (zam) zalVar.f72236c.get(i5);
                map2.put(zamVar.f72238b, zamVar.f72239c);
            }
            map.put(str2, map2);
        }
        this.f72241b = map;
        this.f72242c = (String) Preconditions.m(str);
        O();
    }

    public final String M() {
        return this.f72242c;
    }

    public final Map N(String str) {
        return (Map) this.f72241b.get(str);
    }

    public final void O() {
        Iterator it = this.f72241b.keySet().iterator();
        while (it.hasNext()) {
            Map map = (Map) this.f72241b.get((String) it.next());
            Iterator it2 = map.keySet().iterator();
            while (it2.hasNext()) {
                ((FastJsonResponse.Field) map.get((String) it2.next())).O2(this);
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        for (String str : this.f72241b.keySet()) {
            sb.append(str);
            sb.append(":\n");
            Map map = (Map) this.f72241b.get(str);
            for (String str2 : map.keySet()) {
                sb.append("  ");
                sb.append(str2);
                sb.append(": ");
                sb.append(map.get(str2));
            }
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, this.f72240a);
        ArrayList arrayList = new ArrayList();
        for (String str : this.f72241b.keySet()) {
            arrayList.add(new zal(str, (Map) this.f72241b.get(str)));
        }
        SafeParcelWriter.K(parcel, 2, arrayList, false);
        SafeParcelWriter.G(parcel, 3, this.f72242c, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
