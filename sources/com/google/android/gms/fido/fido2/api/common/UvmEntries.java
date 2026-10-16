package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class UvmEntries extends AbstractSafeParcelable {
    public static final Parcelable.Creator<UvmEntries> CREATOR = new zzbd();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f72635a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {
    }

    UvmEntries(List list) {
        this.f72635a = list;
    }

    public List M() {
        return this.f72635a;
    }

    public final JSONArray N() {
        try {
            JSONArray jSONArray = new JSONArray();
            if (this.f72635a != null) {
                for (int i3 = 0; i3 < this.f72635a.size(); i3++) {
                    UvmEntry uvmEntry = (UvmEntry) this.f72635a.get(i3);
                    JSONArray jSONArray2 = new JSONArray();
                    jSONArray2.put((int) uvmEntry.N());
                    jSONArray2.put((int) uvmEntry.M());
                    jSONArray2.put((int) uvmEntry.N());
                    jSONArray.put(i3, jSONArray2);
                }
            }
            return jSONArray;
        } catch (JSONException e3) {
            throw new RuntimeException("Error encoding UvmEntries to JSON object", e3);
        }
    }

    public boolean equals(Object obj) {
        List list;
        if (!(obj instanceof UvmEntries)) {
            return false;
        }
        UvmEntries uvmEntries = (UvmEntries) obj;
        List list2 = this.f72635a;
        if (list2 == null && uvmEntries.f72635a == null) {
            return true;
        }
        return list2 != null && (list = uvmEntries.f72635a) != null && list2.containsAll(list) && uvmEntries.f72635a.containsAll(this.f72635a);
    }

    public int hashCode() {
        List list = this.f72635a;
        return Objects.c(list == null ? null : new HashSet(list));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.K(parcel, 1, M(), false);
        SafeParcelWriter.b(parcel, iA);
    }
}
