package com.google.android.gms.fido.u2f.api.common;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class SignRequestParams extends RequestParams {
    public static final Parcelable.Creator<SignRequestParams> CREATOR = new zzk();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Integer f72755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Double f72756b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Uri f72757c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final byte[] f72758d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List f72759f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ChannelIdValue f72760g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f72761h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Set f72762i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {
    }

    SignRequestParams(Integer num, Double d3, Uri uri, byte[] bArr, List list, ChannelIdValue channelIdValue, String str) {
        this.f72755a = num;
        this.f72756b = d3;
        this.f72757c = uri;
        this.f72758d = bArr;
        this.f72759f = list;
        this.f72760g = channelIdValue;
        HashSet hashSet = new HashSet();
        if (uri != null) {
            hashSet.add(uri);
        }
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                RegisteredKey registeredKey = (RegisteredKey) it.next();
                Preconditions.b((registeredKey.M() == null && uri == null) ? false : true, "registered key has null appId and no request appId is provided");
                registeredKey.N();
                Preconditions.b(true, "register request has null challenge and no default challenge isprovided");
                if (registeredKey.M() != null) {
                    hashSet.add(Uri.parse(registeredKey.M()));
                }
            }
        }
        this.f72762i = hashSet;
        Preconditions.b(str == null || str.length() <= 80, "Display Hint cannot be longer than 80 characters");
        this.f72761h = str;
    }

    public Uri M() {
        return this.f72757c;
    }

    public ChannelIdValue N() {
        return this.f72760g;
    }

    public byte[] O() {
        return this.f72758d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SignRequestParams)) {
            return false;
        }
        SignRequestParams signRequestParams = (SignRequestParams) obj;
        return Objects.b(this.f72755a, signRequestParams.f72755a) && Objects.b(this.f72756b, signRequestParams.f72756b) && Objects.b(this.f72757c, signRequestParams.f72757c) && Arrays.equals(this.f72758d, signRequestParams.f72758d) && this.f72759f.containsAll(signRequestParams.f72759f) && signRequestParams.f72759f.containsAll(this.f72759f) && Objects.b(this.f72760g, signRequestParams.f72760g) && Objects.b(this.f72761h, signRequestParams.f72761h);
    }

    public String g0() {
        return this.f72761h;
    }

    public int hashCode() {
        return Objects.c(this.f72755a, this.f72757c, this.f72756b, this.f72759f, this.f72760g, this.f72761h, Integer.valueOf(Arrays.hashCode(this.f72758d)));
    }

    public List j0() {
        return this.f72759f;
    }

    public Integer w0() {
        return this.f72755a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.x(parcel, 2, w0(), false);
        SafeParcelWriter.p(parcel, 3, z0(), false);
        SafeParcelWriter.E(parcel, 4, M(), i3, false);
        SafeParcelWriter.l(parcel, 5, O(), false);
        SafeParcelWriter.K(parcel, 6, j0(), false);
        SafeParcelWriter.E(parcel, 7, N(), i3, false);
        SafeParcelWriter.G(parcel, 8, g0(), false);
        SafeParcelWriter.b(parcel, iA);
    }

    public Double z0() {
        return this.f72756b;
    }
}
