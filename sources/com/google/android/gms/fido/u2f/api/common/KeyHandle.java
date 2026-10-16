package com.google.android.gms.fido.u2f.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.fido.u2f.api.common.ProtocolVersion;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class KeyHandle extends AbstractSafeParcelable {
    public static final Parcelable.Creator<KeyHandle> CREATOR = new zze();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f72728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f72729b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ProtocolVersion f72730c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f72731d;

    KeyHandle(int i3, byte[] bArr, String str, List list) {
        this.f72728a = i3;
        this.f72729b = bArr;
        try {
            this.f72730c = ProtocolVersion.a(str);
            this.f72731d = list;
        } catch (ProtocolVersion.UnsupportedProtocolException e3) {
            throw new IllegalArgumentException(e3);
        }
    }

    public byte[] M() {
        return this.f72729b;
    }

    public ProtocolVersion N() {
        return this.f72730c;
    }

    public List O() {
        return this.f72731d;
    }

    public boolean equals(Object obj) {
        List list;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KeyHandle)) {
            return false;
        }
        KeyHandle keyHandle = (KeyHandle) obj;
        if (!Arrays.equals(this.f72729b, keyHandle.f72729b) || !this.f72730c.equals(keyHandle.f72730c)) {
            return false;
        }
        List list2 = this.f72731d;
        if (list2 == null && keyHandle.f72731d == null) {
            return true;
        }
        return list2 != null && (list = keyHandle.f72731d) != null && list2.containsAll(list) && keyHandle.f72731d.containsAll(this.f72731d);
    }

    public int g0() {
        return this.f72728a;
    }

    public int hashCode() {
        return Objects.c(Integer.valueOf(Arrays.hashCode(this.f72729b)), this.f72730c, this.f72731d);
    }

    public String toString() {
        List list = this.f72731d;
        return String.format("{keyHandle: %s, version: %s, transports: %s}", Base64Utils.c(this.f72729b), this.f72730c, list == null ? "null" : list.toString());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, g0());
        SafeParcelWriter.l(parcel, 2, M(), false);
        SafeParcelWriter.G(parcel, 3, this.f72730c.toString(), false);
        SafeParcelWriter.K(parcel, 4, O(), false);
        SafeParcelWriter.b(parcel, iA);
    }
}
