package com.google.android.gms.fido.u2f.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class ChannelIdValue extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ChannelIdValue> CREATOR = new zzb();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ChannelIdValue f72696d = new ChannelIdValue();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ChannelIdValue f72697f = new ChannelIdValue("unavailable");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ChannelIdValue f72698g = new ChannelIdValue("unused");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ChannelIdValueType f72699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f72700b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f72701c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum ChannelIdValueType implements Parcelable {
        ABSENT(0),
        STRING(1),
        OBJECT(2);

        public static final Parcelable.Creator<ChannelIdValueType> CREATOR = new zza();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f72706a;

        ChannelIdValueType(int i3) {
            this.f72706a = i3;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeInt(this.f72706a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class UnsupportedChannelIdValueTypeException extends Exception {
        public UnsupportedChannelIdValueTypeException(int i3) {
            super(String.format("ChannelIdValueType %s not supported", Integer.valueOf(i3)));
        }
    }

    private ChannelIdValue() {
        this.f72699a = ChannelIdValueType.ABSENT;
        this.f72701c = null;
        this.f72700b = null;
    }

    public static ChannelIdValueType g0(int i3) throws UnsupportedChannelIdValueTypeException {
        for (ChannelIdValueType channelIdValueType : ChannelIdValueType.values()) {
            if (i3 == channelIdValueType.f72706a) {
                return channelIdValueType;
            }
        }
        throw new UnsupportedChannelIdValueTypeException(i3);
    }

    public String M() {
        return this.f72701c;
    }

    public String N() {
        return this.f72700b;
    }

    public int O() {
        return this.f72699a.f72706a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChannelIdValue)) {
            return false;
        }
        ChannelIdValue channelIdValue = (ChannelIdValue) obj;
        if (!this.f72699a.equals(channelIdValue.f72699a)) {
            return false;
        }
        int iOrdinal = this.f72699a.ordinal();
        if (iOrdinal == 0) {
            return true;
        }
        if (iOrdinal == 1) {
            return this.f72700b.equals(channelIdValue.f72700b);
        }
        if (iOrdinal != 2) {
            return false;
        }
        return this.f72701c.equals(channelIdValue.f72701c);
    }

    public int hashCode() {
        int i3;
        int iHashCode;
        int iHashCode2 = this.f72699a.hashCode() + 31;
        int iOrdinal = this.f72699a.ordinal();
        if (iOrdinal == 1) {
            i3 = iHashCode2 * 31;
            iHashCode = this.f72700b.hashCode();
        } else {
            if (iOrdinal != 2) {
                return iHashCode2;
            }
            i3 = iHashCode2 * 31;
            iHashCode = this.f72701c.hashCode();
        }
        return i3 + iHashCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 2, O());
        SafeParcelWriter.G(parcel, 3, N(), false);
        SafeParcelWriter.G(parcel, 4, M(), false);
        SafeParcelWriter.b(parcel, iA);
    }

    ChannelIdValue(int i3, String str, String str2) {
        try {
            this.f72699a = g0(i3);
            this.f72700b = str;
            this.f72701c = str2;
        } catch (UnsupportedChannelIdValueTypeException e3) {
            throw new IllegalArgumentException(e3);
        }
    }

    private ChannelIdValue(String str) {
        this.f72700b = (String) Preconditions.m(str);
        this.f72699a = ChannelIdValueType.STRING;
        this.f72701c = null;
    }
}
