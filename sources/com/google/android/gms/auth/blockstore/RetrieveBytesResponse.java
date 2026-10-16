package com.google.android.gms.auth.blockstore;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class RetrieveBytesResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RetrieveBytesResponse> CREATOR = new zzd();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Bundle f71279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f71280b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f71281c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class BlockstoreData extends AbstractSafeParcelable {
        public static final Parcelable.Creator<BlockstoreData> CREATOR = new zza();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final byte[] f71282a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f71283b;

        BlockstoreData(byte[] bArr, String str) {
            this.f71282a = bArr;
            this.f71283b = str;
        }

        public byte[] M() {
            return this.f71282a;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof BlockstoreData)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            return Arrays.equals(this.f71282a, ((BlockstoreData) obj).f71282a);
        }

        public int hashCode() {
            return Objects.c(Integer.valueOf(Arrays.hashCode(this.f71282a)));
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            int iA = SafeParcelWriter.a(parcel);
            SafeParcelWriter.l(parcel, 1, M(), false);
            SafeParcelWriter.G(parcel, 2, this.f71283b, false);
            SafeParcelWriter.b(parcel, iA);
        }

        public final String zza() {
            return this.f71283b;
        }
    }

    RetrieveBytesResponse(Bundle bundle, List list) {
        this.f71279a = bundle;
        this.f71280b = list;
        HashMap map = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            BlockstoreData blockstoreData = (BlockstoreData) it.next();
            map.put(blockstoreData.zza(), blockstoreData);
        }
        this.f71281c = map;
    }

    public Map M() {
        return Collections.unmodifiableMap(this.f71281c);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        Bundle bundle = this.f71279a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.j(parcel, 1, bundle, false);
        SafeParcelWriter.K(parcel, 2, this.f71280b, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
