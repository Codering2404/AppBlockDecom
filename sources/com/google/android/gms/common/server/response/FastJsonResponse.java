package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.MapUtils;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class FastJsonResponse {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface FieldConverter<I, O> {
        Object J(Object obj);

        Object a(Object obj);
    }

    private final void a(Field field, Object obj) {
        int i3 = field.f72205d;
        Object objK2 = field.K2(obj);
        String str = field.f72207g;
        switch (i3) {
            case 0:
                if (objK2 != null) {
                    setIntegerInternal(field, str, ((Integer) objK2).intValue());
                    return;
                } else {
                    d(str);
                    return;
                }
            case 1:
                zaf(field, str, (BigInteger) objK2);
                return;
            case 2:
                if (objK2 != null) {
                    setLongInternal(field, str, ((Long) objK2).longValue());
                    return;
                } else {
                    d(str);
                    return;
                }
            case 3:
            default:
                throw new IllegalStateException("Unsupported type for conversion: " + i3);
            case 4:
                if (objK2 != null) {
                    zan(field, str, ((Double) objK2).doubleValue());
                    return;
                } else {
                    d(str);
                    return;
                }
            case 5:
                zab(field, str, (BigDecimal) objK2);
                return;
            case 6:
                if (objK2 != null) {
                    setBooleanInternal(field, str, ((Boolean) objK2).booleanValue());
                    return;
                } else {
                    d(str);
                    return;
                }
            case 7:
                setStringInternal(field, str, (String) objK2);
                return;
            case 8:
            case 9:
                if (objK2 != null) {
                    setDecodedBytesInternal(field, str, (byte[]) objK2);
                    return;
                } else {
                    d(str);
                    return;
                }
        }
    }

    private static final void c(StringBuilder sb, Field field, Object obj) {
        int i3 = field.f72203b;
        if (i3 == 11) {
            Class cls = field.f72209i;
            Preconditions.m(cls);
            sb.append(((FastJsonResponse) cls.cast(obj)).toString());
        } else {
            if (i3 != 7) {
                sb.append(obj);
                return;
            }
            sb.append("\"");
            sb.append(JsonUtils.a((String) obj));
            sb.append("\"");
        }
    }

    private static final void d(String str) {
        if (Log.isLoggable("FastJsonResponse", 6)) {
            Log.e("FastJsonResponse", "Output field (" + str + ") has a null value, but expected a primitive");
        }
    }

    protected static final Object zaD(Field field, Object obj) {
        return field.f72212l != null ? field.L2(obj) : obj;
    }

    public <T extends FastJsonResponse> void addConcreteTypeArrayInternal(Field field, String str, ArrayList<T> arrayList) {
        throw new UnsupportedOperationException("Concrete type array not supported");
    }

    public <T extends FastJsonResponse> void addConcreteTypeInternal(Field field, String str, T t2) {
        throw new UnsupportedOperationException("Concrete type not supported");
    }

    public abstract Map<String, Field<?, ?>> getFieldMappings();

    protected Object getFieldValue(Field field) {
        String str = field.f72207g;
        if (field.f72209i == null) {
            return getValueObject(str);
        }
        Preconditions.s(getValueObject(str) == null, "Concrete field shouldn't be value object: %s", field.f72207g);
        try {
            return getClass().getMethod("get" + Character.toUpperCase(str.charAt(0)) + str.substring(1), null).invoke(this, null);
        } catch (Exception e3) {
            throw new RuntimeException(e3);
        }
    }

    protected abstract Object getValueObject(String str);

    protected boolean isFieldSet(Field field) {
        if (field.f72205d != 11) {
            return isPrimitiveFieldSet(field.f72207g);
        }
        if (field.f72206f) {
            throw new UnsupportedOperationException("Concrete type arrays not supported");
        }
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    protected abstract boolean isPrimitiveFieldSet(String str);

    protected void setBooleanInternal(Field<?, ?> field, String str, boolean z2) {
        throw new UnsupportedOperationException("Boolean not supported");
    }

    protected void setDecodedBytesInternal(Field<?, ?> field, String str, byte[] bArr) {
        throw new UnsupportedOperationException("byte[] not supported");
    }

    protected void setIntegerInternal(Field<?, ?> field, String str, int i3) {
        throw new UnsupportedOperationException("Integer not supported");
    }

    protected void setLongInternal(Field<?, ?> field, String str, long j3) {
        throw new UnsupportedOperationException("Long not supported");
    }

    protected void setStringInternal(Field<?, ?> field, String str, String str2) {
        throw new UnsupportedOperationException("String not supported");
    }

    protected void setStringMapInternal(Field<?, ?> field, String str, Map<String, String> map) {
        throw new UnsupportedOperationException("String map not supported");
    }

    protected void setStringsInternal(Field<?, ?> field, String str, ArrayList<String> arrayList) {
        throw new UnsupportedOperationException("String list not supported");
    }

    public String toString() {
        Map<String, Field<?, ?>> fieldMappings = getFieldMappings();
        StringBuilder sb = new StringBuilder(100);
        for (String str : fieldMappings.keySet()) {
            Field<?, ?> field = fieldMappings.get(str);
            if (isFieldSet(field)) {
                Object objZaD = zaD(field, getFieldValue(field));
                if (sb.length() == 0) {
                    sb.append("{");
                } else {
                    sb.append(",");
                }
                sb.append("\"");
                sb.append(str);
                sb.append("\":");
                if (objZaD != null) {
                    switch (field.f72205d) {
                        case 8:
                            sb.append("\"");
                            sb.append(Base64Utils.c((byte[]) objZaD));
                            sb.append("\"");
                            break;
                        case 9:
                            sb.append("\"");
                            sb.append(Base64Utils.d((byte[]) objZaD));
                            sb.append("\"");
                            break;
                        case 10:
                            MapUtils.a(sb, (HashMap) objZaD);
                            break;
                        default:
                            if (field.f72204c) {
                                ArrayList arrayList = (ArrayList) objZaD;
                                sb.append("[");
                                int size = arrayList.size();
                                for (int i3 = 0; i3 < size; i3++) {
                                    if (i3 > 0) {
                                        sb.append(",");
                                    }
                                    Object obj = arrayList.get(i3);
                                    if (obj != null) {
                                        c(sb, field, obj);
                                    }
                                }
                                sb.append("]");
                            } else {
                                c(sb, field, objZaD);
                            }
                            break;
                    }
                } else {
                    sb.append("null");
                }
            }
        }
        if (sb.length() > 0) {
            sb.append("}");
        } else {
            sb.append(com.applovin.impl.sdk.utils.JsonUtils.EMPTY_JSON);
        }
        return sb.toString();
    }

    public final void zaA(Field field, String str) {
        if (field.f72212l != null) {
            a(field, str);
        } else {
            setStringInternal(field, field.f72207g, str);
        }
    }

    public final void zaB(Field field, Map map) {
        if (field.f72212l != null) {
            a(field, map);
        } else {
            setStringMapInternal(field, field.f72207g, map);
        }
    }

    public final void zaC(Field field, ArrayList arrayList) {
        if (field.f72212l != null) {
            a(field, arrayList);
        } else {
            setStringsInternal(field, field.f72207g, arrayList);
        }
    }

    public final void zaa(Field field, BigDecimal bigDecimal) {
        if (field.f72212l != null) {
            a(field, bigDecimal);
        } else {
            zab(field, field.f72207g, bigDecimal);
        }
    }

    protected void zab(Field field, String str, BigDecimal bigDecimal) {
        throw new UnsupportedOperationException("BigDecimal not supported");
    }

    public final void zac(Field field, ArrayList arrayList) {
        if (field.f72212l != null) {
            a(field, arrayList);
        } else {
            zad(field, field.f72207g, arrayList);
        }
    }

    protected void zad(Field field, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("BigDecimal list not supported");
    }

    public final void zae(Field field, BigInteger bigInteger) {
        if (field.f72212l != null) {
            a(field, bigInteger);
        } else {
            zaf(field, field.f72207g, bigInteger);
        }
    }

    protected void zaf(Field field, String str, BigInteger bigInteger) {
        throw new UnsupportedOperationException("BigInteger not supported");
    }

    public final void zag(Field field, ArrayList arrayList) {
        if (field.f72212l != null) {
            a(field, arrayList);
        } else {
            zah(field, field.f72207g, arrayList);
        }
    }

    protected void zah(Field field, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("BigInteger list not supported");
    }

    public final void zai(Field field, boolean z2) {
        if (field.f72212l != null) {
            a(field, Boolean.valueOf(z2));
        } else {
            setBooleanInternal(field, field.f72207g, z2);
        }
    }

    public final void zaj(Field field, ArrayList arrayList) {
        if (field.f72212l != null) {
            a(field, arrayList);
        } else {
            zak(field, field.f72207g, arrayList);
        }
    }

    protected void zak(Field field, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("Boolean list not supported");
    }

    public final void zal(Field field, byte[] bArr) {
        if (field.f72212l != null) {
            a(field, bArr);
        } else {
            setDecodedBytesInternal(field, field.f72207g, bArr);
        }
    }

    public final void zam(Field field, double d3) {
        if (field.f72212l != null) {
            a(field, Double.valueOf(d3));
        } else {
            zan(field, field.f72207g, d3);
        }
    }

    protected void zan(Field field, String str, double d3) {
        throw new UnsupportedOperationException("Double not supported");
    }

    public final void zao(Field field, ArrayList arrayList) {
        if (field.f72212l != null) {
            a(field, arrayList);
        } else {
            zap(field, field.f72207g, arrayList);
        }
    }

    protected void zap(Field field, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("Double list not supported");
    }

    public final void zaq(Field field, float f3) {
        if (field.f72212l != null) {
            a(field, Float.valueOf(f3));
        } else {
            zar(field, field.f72207g, f3);
        }
    }

    protected void zar(Field field, String str, float f3) {
        throw new UnsupportedOperationException("Float not supported");
    }

    public final void zas(Field field, ArrayList arrayList) {
        if (field.f72212l != null) {
            a(field, arrayList);
        } else {
            zat(field, field.f72207g, arrayList);
        }
    }

    protected void zat(Field field, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("Float list not supported");
    }

    public final void zau(Field field, int i3) {
        if (field.f72212l != null) {
            a(field, Integer.valueOf(i3));
        } else {
            setIntegerInternal(field, field.f72207g, i3);
        }
    }

    public final void zav(Field field, ArrayList arrayList) {
        if (field.f72212l != null) {
            a(field, arrayList);
        } else {
            zaw(field, field.f72207g, arrayList);
        }
    }

    protected void zaw(Field field, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("Integer list not supported");
    }

    public final void zax(Field field, long j3) {
        if (field.f72212l != null) {
            a(field, Long.valueOf(j3));
        } else {
            setLongInternal(field, field.f72207g, j3);
        }
    }

    public final void zay(Field field, ArrayList arrayList) {
        if (field.f72212l != null) {
            a(field, arrayList);
        } else {
            zaz(field, field.f72207g, arrayList);
        }
    }

    protected void zaz(Field field, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("Long list not supported");
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Field<I, O> extends AbstractSafeParcelable {
        public static final zaj CREATOR = new zaj();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f72202a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected final int f72203b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        protected final boolean f72204c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        protected final int f72205d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        protected final boolean f72206f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        protected final String f72207g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        protected final int f72208h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        protected final Class f72209i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        protected final String f72210j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private zan f72211k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final FieldConverter f72212l;

        Field(int i3, int i4, boolean z2, int i5, boolean z3, String str, int i6, String str2, com.google.android.gms.common.server.converter.zaa zaaVar) {
            this.f72202a = i3;
            this.f72203b = i4;
            this.f72204c = z2;
            this.f72205d = i5;
            this.f72206f = z3;
            this.f72207g = str;
            this.f72208h = i6;
            if (str2 == null) {
                this.f72209i = null;
                this.f72210j = null;
            } else {
                this.f72209i = SafeParcelResponse.class;
                this.f72210j = str2;
            }
            if (zaaVar == null) {
                this.f72212l = null;
            } else {
                this.f72212l = zaaVar.N();
            }
        }

        public static Field M(String str, int i3) {
            return new Field(8, false, 8, false, str, i3, null, null);
        }

        public static Field N(String str, int i3, Class cls) {
            return new Field(11, false, 11, false, str, i3, cls, null);
        }

        public static Field O(String str, int i3, Class cls) {
            return new Field(11, true, 11, true, str, i3, cls, null);
        }

        public static Field g0(String str, int i3) {
            return new Field(0, false, 0, false, str, i3, null, null);
        }

        public static Field j0(String str, int i3) {
            return new Field(7, false, 7, false, str, i3, null, null);
        }

        public static Field w0(String str, int i3) {
            return new Field(7, true, 7, true, str, i3, null, null);
        }

        public final Object K2(Object obj) {
            Preconditions.m(this.f72212l);
            return Preconditions.m(this.f72212l.J(obj));
        }

        public final Object L2(Object obj) {
            Preconditions.m(this.f72212l);
            return this.f72212l.a(obj);
        }

        final String M2() {
            String str = this.f72210j;
            if (str == null) {
                return null;
            }
            return str;
        }

        public final Map N2() {
            Preconditions.m(this.f72210j);
            Preconditions.m(this.f72211k);
            return (Map) Preconditions.m(this.f72211k.N(this.f72210j));
        }

        public final void O2(zan zanVar) {
            this.f72211k = zanVar;
        }

        public final boolean P2() {
            return this.f72212l != null;
        }

        final com.google.android.gms.common.server.converter.zaa h1() {
            FieldConverter fieldConverter = this.f72212l;
            if (fieldConverter == null) {
                return null;
            }
            return com.google.android.gms.common.server.converter.zaa.M(fieldConverter);
        }

        public final String toString() {
            Objects.ToStringHelper toStringHelperA = Objects.d(this).a("versionCode", Integer.valueOf(this.f72202a)).a("typeIn", Integer.valueOf(this.f72203b)).a("typeInArray", Boolean.valueOf(this.f72204c)).a("typeOut", Integer.valueOf(this.f72205d)).a("typeOutArray", Boolean.valueOf(this.f72206f)).a("outputFieldName", this.f72207g).a("safeParcelFieldId", Integer.valueOf(this.f72208h)).a("concreteTypeName", M2());
            Class cls = this.f72209i;
            if (cls != null) {
                toStringHelperA.a("concreteType.class", cls.getCanonicalName());
            }
            FieldConverter fieldConverter = this.f72212l;
            if (fieldConverter != null) {
                toStringHelperA.a("converterName", fieldConverter.getClass().getCanonicalName());
            }
            return toStringHelperA.toString();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i3) {
            int i4 = this.f72202a;
            int iA = SafeParcelWriter.a(parcel);
            SafeParcelWriter.u(parcel, 1, i4);
            SafeParcelWriter.u(parcel, 2, this.f72203b);
            SafeParcelWriter.g(parcel, 3, this.f72204c);
            SafeParcelWriter.u(parcel, 4, this.f72205d);
            SafeParcelWriter.g(parcel, 5, this.f72206f);
            SafeParcelWriter.G(parcel, 6, this.f72207g, false);
            SafeParcelWriter.u(parcel, 7, z0());
            SafeParcelWriter.G(parcel, 8, M2(), false);
            SafeParcelWriter.E(parcel, 9, h1(), i3, false);
            SafeParcelWriter.b(parcel, iA);
        }

        public int z0() {
            return this.f72208h;
        }

        protected Field(int i3, boolean z2, int i4, boolean z3, String str, int i5, Class cls, FieldConverter fieldConverter) {
            this.f72202a = 1;
            this.f72203b = i3;
            this.f72204c = z2;
            this.f72205d = i4;
            this.f72206f = z3;
            this.f72207g = str;
            this.f72208h = i5;
            this.f72209i = cls;
            if (cls == null) {
                this.f72210j = null;
            } else {
                this.f72210j = cls.getCanonicalName();
            }
            this.f72212l = fieldConverter;
        }
    }
}
