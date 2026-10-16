package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.MapUtils;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class SafeParcelResponse extends FastSafeParcelableJsonResponse {
    public static final Parcelable.Creator<SafeParcelResponse> CREATOR = new zaq();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f72227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Parcel f72228b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f72229c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zan f72230d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f72231f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f72232g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f72233h;

    SafeParcelResponse(int i3, Parcel parcel, zan zanVar) {
        this.f72227a = i3;
        this.f72228b = (Parcel) Preconditions.m(parcel);
        this.f72230d = zanVar;
        this.f72231f = zanVar == null ? null : zanVar.M();
        this.f72232g = 2;
    }

    private final void f(FastJsonResponse.Field field) {
        if (field.f72208h == -1) {
            throw new IllegalStateException("Field does not have a valid safe parcelable field id.");
        }
        Parcel parcel = this.f72228b;
        if (parcel == null) {
            throw new IllegalStateException("Internal Parcel object is null.");
        }
        int i3 = this.f72232g;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("Attempted to parse JSON with a SafeParcelResponse object that is already filled with data.");
            }
        } else {
            this.f72233h = SafeParcelWriter.a(parcel);
            this.f72232g = 1;
        }
    }

    private final void g(StringBuilder sb, Map map, Parcel parcel) {
        SparseArray sparseArray = new SparseArray();
        for (Map.Entry entry : map.entrySet()) {
            sparseArray.put(((FastJsonResponse.Field) entry.getValue()).z0(), entry);
        }
        sb.append('{');
        int iO = SafeParcelReader.O(parcel);
        boolean z2 = false;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            Map.Entry entry2 = (Map.Entry) sparseArray.get(SafeParcelReader.w(iE));
            if (entry2 != null) {
                if (z2) {
                    sb.append(",");
                }
                String str = (String) entry2.getKey();
                FastJsonResponse.Field field = (FastJsonResponse.Field) entry2.getValue();
                sb.append("\"");
                sb.append(str);
                sb.append("\":");
                if (field.P2()) {
                    int i3 = field.f72205d;
                    switch (i3) {
                        case 0:
                            i(sb, field, FastJsonResponse.zaD(field, Integer.valueOf(SafeParcelReader.G(parcel, iE))));
                            break;
                        case 1:
                            i(sb, field, FastJsonResponse.zaD(field, SafeParcelReader.c(parcel, iE)));
                            break;
                        case 2:
                            i(sb, field, FastJsonResponse.zaD(field, Long.valueOf(SafeParcelReader.J(parcel, iE))));
                            break;
                        case 3:
                            i(sb, field, FastJsonResponse.zaD(field, Float.valueOf(SafeParcelReader.C(parcel, iE))));
                            break;
                        case 4:
                            i(sb, field, FastJsonResponse.zaD(field, Double.valueOf(SafeParcelReader.A(parcel, iE))));
                            break;
                        case 5:
                            i(sb, field, FastJsonResponse.zaD(field, SafeParcelReader.a(parcel, iE)));
                            break;
                        case 6:
                            i(sb, field, FastJsonResponse.zaD(field, Boolean.valueOf(SafeParcelReader.x(parcel, iE))));
                            break;
                        case 7:
                            i(sb, field, FastJsonResponse.zaD(field, SafeParcelReader.q(parcel, iE)));
                            break;
                        case 8:
                        case 9:
                            i(sb, field, FastJsonResponse.zaD(field, SafeParcelReader.g(parcel, iE)));
                            break;
                        case 10:
                            Bundle bundleF = SafeParcelReader.f(parcel, iE);
                            HashMap map2 = new HashMap();
                            for (String str2 : bundleF.keySet()) {
                                map2.put(str2, (String) Preconditions.m(bundleF.getString(str2)));
                            }
                            i(sb, field, FastJsonResponse.zaD(field, map2));
                            break;
                        case 11:
                            throw new IllegalArgumentException("Method does not accept concrete type.");
                        default:
                            throw new IllegalArgumentException("Unknown field out type = " + i3);
                    }
                } else if (field.f72206f) {
                    sb.append("[");
                    switch (field.f72205d) {
                        case 0:
                            ArrayUtils.e(sb, SafeParcelReader.k(parcel, iE));
                            break;
                        case 1:
                            ArrayUtils.g(sb, SafeParcelReader.d(parcel, iE));
                            break;
                        case 2:
                            ArrayUtils.f(sb, SafeParcelReader.m(parcel, iE));
                            break;
                        case 3:
                            ArrayUtils.d(sb, SafeParcelReader.j(parcel, iE));
                            break;
                        case 4:
                            ArrayUtils.c(sb, SafeParcelReader.i(parcel, iE));
                            break;
                        case 5:
                            ArrayUtils.g(sb, SafeParcelReader.b(parcel, iE));
                            break;
                        case 6:
                            ArrayUtils.h(sb, SafeParcelReader.e(parcel, iE));
                            break;
                        case 7:
                            ArrayUtils.i(sb, SafeParcelReader.r(parcel, iE));
                            break;
                        case 8:
                        case 9:
                        case 10:
                            throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                        case 11:
                            Parcel[] parcelArrO = SafeParcelReader.o(parcel, iE);
                            int length = parcelArrO.length;
                            for (int i4 = 0; i4 < length; i4++) {
                                if (i4 > 0) {
                                    sb.append(",");
                                }
                                parcelArrO[i4].setDataPosition(0);
                                g(sb, field.N2(), parcelArrO[i4]);
                            }
                            break;
                        default:
                            throw new IllegalStateException("Unknown field type out.");
                    }
                    sb.append("]");
                } else {
                    switch (field.f72205d) {
                        case 0:
                            sb.append(SafeParcelReader.G(parcel, iE));
                            break;
                        case 1:
                            sb.append(SafeParcelReader.c(parcel, iE));
                            break;
                        case 2:
                            sb.append(SafeParcelReader.J(parcel, iE));
                            break;
                        case 3:
                            sb.append(SafeParcelReader.C(parcel, iE));
                            break;
                        case 4:
                            sb.append(SafeParcelReader.A(parcel, iE));
                            break;
                        case 5:
                            sb.append(SafeParcelReader.a(parcel, iE));
                            break;
                        case 6:
                            sb.append(SafeParcelReader.x(parcel, iE));
                            break;
                        case 7:
                            String strQ = SafeParcelReader.q(parcel, iE);
                            sb.append("\"");
                            sb.append(JsonUtils.a(strQ));
                            sb.append("\"");
                            break;
                        case 8:
                            byte[] bArrG = SafeParcelReader.g(parcel, iE);
                            sb.append("\"");
                            sb.append(Base64Utils.c(bArrG));
                            sb.append("\"");
                            break;
                        case 9:
                            byte[] bArrG2 = SafeParcelReader.g(parcel, iE);
                            sb.append("\"");
                            sb.append(Base64Utils.d(bArrG2));
                            sb.append("\"");
                            break;
                        case 10:
                            Bundle bundleF2 = SafeParcelReader.f(parcel, iE);
                            Set<String> setKeySet = bundleF2.keySet();
                            sb.append("{");
                            boolean z3 = true;
                            for (String str3 : setKeySet) {
                                if (!z3) {
                                    sb.append(",");
                                }
                                sb.append("\"");
                                sb.append(str3);
                                sb.append("\":\"");
                                sb.append(JsonUtils.a(bundleF2.getString(str3)));
                                sb.append("\"");
                                z3 = false;
                            }
                            sb.append("}");
                            break;
                        case 11:
                            Parcel parcelN = SafeParcelReader.n(parcel, iE);
                            parcelN.setDataPosition(0);
                            g(sb, field.N2(), parcelN);
                            break;
                        default:
                            throw new IllegalStateException("Unknown field type out");
                    }
                }
                z2 = true;
            }
        }
        if (parcel.dataPosition() == iO) {
            sb.append('}');
            return;
        }
        throw new SafeParcelReader.ParseException("Overread allowed size end=" + iO, parcel);
    }

    private static final void h(StringBuilder sb, int i3, Object obj) {
        switch (i3) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                sb.append(obj);
                return;
            case 7:
                sb.append("\"");
                sb.append(JsonUtils.a(Preconditions.m(obj).toString()));
                sb.append("\"");
                return;
            case 8:
                sb.append("\"");
                sb.append(Base64Utils.c((byte[]) obj));
                sb.append("\"");
                return;
            case 9:
                sb.append("\"");
                sb.append(Base64Utils.d((byte[]) obj));
                sb.append("\"");
                return;
            case 10:
                MapUtils.a(sb, (HashMap) Preconditions.m(obj));
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown type = " + i3);
        }
    }

    private static final void i(StringBuilder sb, FastJsonResponse.Field field, Object obj) {
        if (!field.f72204c) {
            h(sb, field.f72203b, obj);
            return;
        }
        ArrayList arrayList = (ArrayList) obj;
        sb.append("[");
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (i3 != 0) {
                sb.append(",");
            }
            h(sb, field.f72203b, arrayList.get(i3));
        }
        sb.append("]");
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void addConcreteTypeArrayInternal(FastJsonResponse.Field field, String str, ArrayList arrayList) {
        f(field);
        ArrayList arrayList2 = new ArrayList();
        ((ArrayList) Preconditions.m(arrayList)).size();
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            arrayList2.add(((SafeParcelResponse) ((FastJsonResponse) arrayList.get(i3))).e());
        }
        SafeParcelWriter.D(this.f72228b, field.z0(), arrayList2, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void addConcreteTypeInternal(FastJsonResponse.Field field, String str, FastJsonResponse fastJsonResponse) {
        f(field);
        SafeParcelWriter.C(this.f72228b, field.z0(), ((SafeParcelResponse) fastJsonResponse).e(), true);
    }

    public final Parcel e() {
        int i3 = this.f72232g;
        if (i3 == 0) {
            int iA = SafeParcelWriter.a(this.f72228b);
            this.f72233h = iA;
            SafeParcelWriter.b(this.f72228b, iA);
            this.f72232g = 2;
        } else if (i3 == 1) {
            SafeParcelWriter.b(this.f72228b, this.f72233h);
            this.f72232g = 2;
        }
        return this.f72228b;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final Map getFieldMappings() {
        zan zanVar = this.f72230d;
        if (zanVar == null) {
            return null;
        }
        return zanVar.N((String) Preconditions.m(this.f72231f));
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse, com.google.android.gms.common.server.response.FastJsonResponse
    public final Object getValueObject(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse, com.google.android.gms.common.server.response.FastJsonResponse
    public final boolean isPrimitiveFieldSet(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void setBooleanInternal(FastJsonResponse.Field field, String str, boolean z2) {
        f(field);
        SafeParcelWriter.g(this.f72228b, field.z0(), z2);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void setDecodedBytesInternal(FastJsonResponse.Field field, String str, byte[] bArr) {
        f(field);
        SafeParcelWriter.l(this.f72228b, field.z0(), bArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void setIntegerInternal(FastJsonResponse.Field field, String str, int i3) {
        f(field);
        SafeParcelWriter.u(this.f72228b, field.z0(), i3);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void setLongInternal(FastJsonResponse.Field field, String str, long j3) {
        f(field);
        SafeParcelWriter.z(this.f72228b, field.z0(), j3);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void setStringInternal(FastJsonResponse.Field field, String str, String str2) {
        f(field);
        SafeParcelWriter.G(this.f72228b, field.z0(), str2, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void setStringMapInternal(FastJsonResponse.Field field, String str, Map map) {
        f(field);
        Bundle bundle = new Bundle();
        for (String str2 : ((Map) Preconditions.m(map)).keySet()) {
            bundle.putString(str2, (String) map.get(str2));
        }
        SafeParcelWriter.j(this.f72228b, field.z0(), bundle, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void setStringsInternal(FastJsonResponse.Field field, String str, ArrayList arrayList) {
        f(field);
        int size = ((ArrayList) Preconditions.m(arrayList)).size();
        String[] strArr = new String[size];
        for (int i3 = 0; i3 < size; i3++) {
            strArr[i3] = (String) arrayList.get(i3);
        }
        SafeParcelWriter.H(this.f72228b, field.z0(), strArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final String toString() {
        Preconditions.n(this.f72230d, "Cannot convert to JSON on client side.");
        Parcel parcelE = e();
        parcelE.setDataPosition(0);
        StringBuilder sb = new StringBuilder(100);
        g(sb, (Map) Preconditions.m(this.f72230d.N((String) Preconditions.m(this.f72231f))), parcelE);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i4 = this.f72227a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, i4);
        SafeParcelWriter.C(parcel, 2, e(), false);
        int i5 = this.f72229c;
        SafeParcelWriter.E(parcel, 3, i5 != 0 ? i5 != 1 ? this.f72230d : this.f72230d : null, i3, false);
        SafeParcelWriter.b(parcel, iA);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void zab(FastJsonResponse.Field field, String str, BigDecimal bigDecimal) {
        f(field);
        SafeParcelWriter.c(this.f72228b, field.z0(), bigDecimal, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void zad(FastJsonResponse.Field field, String str, ArrayList arrayList) {
        f(field);
        int size = ((ArrayList) Preconditions.m(arrayList)).size();
        BigDecimal[] bigDecimalArr = new BigDecimal[size];
        for (int i3 = 0; i3 < size; i3++) {
            bigDecimalArr[i3] = (BigDecimal) arrayList.get(i3);
        }
        SafeParcelWriter.d(this.f72228b, field.z0(), bigDecimalArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void zaf(FastJsonResponse.Field field, String str, BigInteger bigInteger) {
        f(field);
        SafeParcelWriter.e(this.f72228b, field.z0(), bigInteger, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void zah(FastJsonResponse.Field field, String str, ArrayList arrayList) {
        f(field);
        int size = ((ArrayList) Preconditions.m(arrayList)).size();
        BigInteger[] bigIntegerArr = new BigInteger[size];
        for (int i3 = 0; i3 < size; i3++) {
            bigIntegerArr[i3] = (BigInteger) arrayList.get(i3);
        }
        SafeParcelWriter.f(this.f72228b, field.z0(), bigIntegerArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void zak(FastJsonResponse.Field field, String str, ArrayList arrayList) {
        f(field);
        int size = ((ArrayList) Preconditions.m(arrayList)).size();
        boolean[] zArr = new boolean[size];
        for (int i3 = 0; i3 < size; i3++) {
            zArr[i3] = ((Boolean) arrayList.get(i3)).booleanValue();
        }
        SafeParcelWriter.h(this.f72228b, field.z0(), zArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void zan(FastJsonResponse.Field field, String str, double d3) {
        f(field);
        SafeParcelWriter.n(this.f72228b, field.z0(), d3);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void zap(FastJsonResponse.Field field, String str, ArrayList arrayList) {
        f(field);
        int size = ((ArrayList) Preconditions.m(arrayList)).size();
        double[] dArr = new double[size];
        for (int i3 = 0; i3 < size; i3++) {
            dArr[i3] = ((Double) arrayList.get(i3)).doubleValue();
        }
        SafeParcelWriter.o(this.f72228b, field.z0(), dArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void zar(FastJsonResponse.Field field, String str, float f3) {
        f(field);
        SafeParcelWriter.q(this.f72228b, field.z0(), f3);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void zat(FastJsonResponse.Field field, String str, ArrayList arrayList) {
        f(field);
        int size = ((ArrayList) Preconditions.m(arrayList)).size();
        float[] fArr = new float[size];
        for (int i3 = 0; i3 < size; i3++) {
            fArr[i3] = ((Float) arrayList.get(i3)).floatValue();
        }
        SafeParcelWriter.r(this.f72228b, field.z0(), fArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void zaw(FastJsonResponse.Field field, String str, ArrayList arrayList) {
        f(field);
        int size = ((ArrayList) Preconditions.m(arrayList)).size();
        int[] iArr = new int[size];
        for (int i3 = 0; i3 < size; i3++) {
            iArr[i3] = ((Integer) arrayList.get(i3)).intValue();
        }
        SafeParcelWriter.v(this.f72228b, field.z0(), iArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void zaz(FastJsonResponse.Field field, String str, ArrayList arrayList) {
        f(field);
        int size = ((ArrayList) Preconditions.m(arrayList)).size();
        long[] jArr = new long[size];
        for (int i3 = 0; i3 < size; i3++) {
            jArr[i3] = ((Long) arrayList.get(i3)).longValue();
        }
        SafeParcelWriter.A(this.f72228b, field.z0(), jArr, true);
    }
}
