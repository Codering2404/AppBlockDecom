package com.google.android.gms.auth.blockstore;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class StoreBytesData extends AbstractSafeParcelable {
    public static final Parcelable.Creator<StoreBytesData> CREATOR = new zze();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f71284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f71285b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f71286c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private byte[] f71287a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f71288b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f71289c = "com.google.android.gms.auth.blockstore.DEFAULT_BYTES_DATA_KEY";

        public StoreBytesData a() {
            return new StoreBytesData(this.f71287a, this.f71288b, this.f71289c);
        }

        public Builder b(byte[] bArr) {
            this.f71287a = bArr;
            return this;
        }

        public Builder c(String str) {
            Preconditions.h(str, "key cannot be null or empty");
            this.f71289c = str;
            return this;
        }

        public Builder d(boolean z2) {
            this.f71288b = z2;
            return this;
        }
    }

    StoreBytesData(byte[] bArr, boolean z2, String str) {
        this.f71284a = bArr;
        this.f71285b = z2;
        this.f71286c = str;
    }

    public byte[] M() {
        return this.f71284a;
    }

    public String N() {
        return this.f71286c;
    }

    public boolean O() {
        return this.f71285b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, M(), false);
        SafeParcelWriter.g(parcel, 2, O());
        SafeParcelWriter.G(parcel, 3, N(), false);
        SafeParcelWriter.b(parcel, iA);
    }
}
