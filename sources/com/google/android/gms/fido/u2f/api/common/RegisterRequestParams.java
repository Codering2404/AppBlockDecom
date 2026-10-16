package com.google.android.gms.fido.u2f.api.common;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class RegisterRequestParams extends RequestParams {
    public static final Parcelable.Creator<RegisterRequestParams> CREATOR = new zzh();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Integer f72741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Double f72742b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Uri f72743c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f72744d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List f72745f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ChannelIdValue f72746g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f72747h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Set f72748i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {
    }

    RegisterRequestParams(Integer num, Double d3, Uri uri, List list, List list2, ChannelIdValue channelIdValue, String str) {
        this.f72741a = num;
        this.f72742b = d3;
        this.f72743c = uri;
        Preconditions.b((list == null || list.isEmpty()) ? false : true, "empty list of register requests is provided");
        this.f72744d = list;
        this.f72745f = list2;
        this.f72746g = channelIdValue;
        HashSet hashSet = new HashSet();
        if (uri != null) {
            hashSet.add(uri);
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            RegisterRequest registerRequest = (RegisterRequest) it.next();
            Preconditions.b((uri == null && registerRequest.M() == null) ? false : true, "register request has null appId and no request appId is provided");
            if (registerRequest.M() != null) {
                hashSet.add(Uri.parse(registerRequest.M()));
            }
        }
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            RegisteredKey registeredKey = (RegisteredKey) it2.next();
            Preconditions.b((uri == null && registeredKey.M() == null) ? false : true, "registered key has null appId and no request appId is provided");
            if (registeredKey.M() != null) {
                hashSet.add(Uri.parse(registeredKey.M()));
            }
        }
        this.f72748i = hashSet;
        Preconditions.b(str == null || str.length() <= 80, "Display Hint cannot be longer than 80 characters");
        this.f72747h = str;
    }

    public Uri M() {
        return this.f72743c;
    }

    public ChannelIdValue N() {
        return this.f72746g;
    }

    public String O() {
        return this.f72747h;
    }

    public boolean equals(Object obj) {
        List list;
        List list2;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RegisterRequestParams)) {
            return false;
        }
        RegisterRequestParams registerRequestParams = (RegisterRequestParams) obj;
        return Objects.b(this.f72741a, registerRequestParams.f72741a) && Objects.b(this.f72742b, registerRequestParams.f72742b) && Objects.b(this.f72743c, registerRequestParams.f72743c) && Objects.b(this.f72744d, registerRequestParams.f72744d) && (((list = this.f72745f) == null && registerRequestParams.f72745f == null) || (list != null && (list2 = registerRequestParams.f72745f) != null && list.containsAll(list2) && registerRequestParams.f72745f.containsAll(this.f72745f))) && Objects.b(this.f72746g, registerRequestParams.f72746g) && Objects.b(this.f72747h, registerRequestParams.f72747h);
    }

    public List g0() {
        return this.f72744d;
    }

    public int hashCode() {
        return Objects.c(this.f72741a, this.f72743c, this.f72742b, this.f72744d, this.f72745f, this.f72746g, this.f72747h);
    }

    public List j0() {
        return this.f72745f;
    }

    public Integer w0() {
        return this.f72741a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.x(parcel, 2, w0(), false);
        SafeParcelWriter.p(parcel, 3, z0(), false);
        SafeParcelWriter.E(parcel, 4, M(), i3, false);
        SafeParcelWriter.K(parcel, 5, g0(), false);
        SafeParcelWriter.K(parcel, 6, j0(), false);
        SafeParcelWriter.E(parcel, 7, N(), i3, false);
        SafeParcelWriter.G(parcel, 8, O(), false);
        SafeParcelWriter.b(parcel, iA);
    }

    public Double z0() {
        return this.f72742b;
    }
}
