package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class SafeParcelWriter {
    public static void A(Parcel parcel, int i3, long[] jArr, boolean z2) {
        if (jArr == null) {
            if (z2) {
                L(parcel, i3, 0);
            }
        } else {
            int iM = M(parcel, i3);
            parcel.writeLongArray(jArr);
            N(parcel, iM);
        }
    }

    public static void B(Parcel parcel, int i3, Long l3, boolean z2) {
        if (l3 != null) {
            L(parcel, i3, 8);
            parcel.writeLong(l3.longValue());
        } else if (z2) {
            L(parcel, i3, 0);
        }
    }

    public static void C(Parcel parcel, int i3, Parcel parcel2, boolean z2) {
        if (parcel2 == null) {
            if (z2) {
                L(parcel, i3, 0);
            }
        } else {
            int iM = M(parcel, i3);
            parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            N(parcel, iM);
        }
    }

    public static void D(Parcel parcel, int i3, List list, boolean z2) {
        if (list == null) {
            if (z2) {
                L(parcel, i3, 0);
                return;
            }
            return;
        }
        int iM = M(parcel, i3);
        int size = list.size();
        parcel.writeInt(size);
        for (int i4 = 0; i4 < size; i4++) {
            Parcel parcel2 = (Parcel) list.get(i4);
            if (parcel2 != null) {
                parcel.writeInt(parcel2.dataSize());
                parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            } else {
                parcel.writeInt(0);
            }
        }
        N(parcel, iM);
    }

    public static void E(Parcel parcel, int i3, Parcelable parcelable, int i4, boolean z2) {
        if (parcelable == null) {
            if (z2) {
                L(parcel, i3, 0);
            }
        } else {
            int iM = M(parcel, i3);
            parcelable.writeToParcel(parcel, i4);
            N(parcel, iM);
        }
    }

    public static void F(Parcel parcel, int i3, short s2) {
        L(parcel, i3, 4);
        parcel.writeInt(s2);
    }

    public static void G(Parcel parcel, int i3, String str, boolean z2) {
        if (str == null) {
            if (z2) {
                L(parcel, i3, 0);
            }
        } else {
            int iM = M(parcel, i3);
            parcel.writeString(str);
            N(parcel, iM);
        }
    }

    public static void H(Parcel parcel, int i3, String[] strArr, boolean z2) {
        if (strArr == null) {
            if (z2) {
                L(parcel, i3, 0);
            }
        } else {
            int iM = M(parcel, i3);
            parcel.writeStringArray(strArr);
            N(parcel, iM);
        }
    }

    public static void I(Parcel parcel, int i3, List list, boolean z2) {
        if (list == null) {
            if (z2) {
                L(parcel, i3, 0);
            }
        } else {
            int iM = M(parcel, i3);
            parcel.writeStringList(list);
            N(parcel, iM);
        }
    }

    public static void J(Parcel parcel, int i3, Parcelable[] parcelableArr, int i4, boolean z2) {
        if (parcelableArr == null) {
            if (z2) {
                L(parcel, i3, 0);
                return;
            }
            return;
        }
        int iM = M(parcel, i3);
        parcel.writeInt(parcelableArr.length);
        for (Parcelable parcelable : parcelableArr) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                O(parcel, parcelable, i4);
            }
        }
        N(parcel, iM);
    }

    public static void K(Parcel parcel, int i3, List list, boolean z2) {
        if (list == null) {
            if (z2) {
                L(parcel, i3, 0);
                return;
            }
            return;
        }
        int iM = M(parcel, i3);
        int size = list.size();
        parcel.writeInt(size);
        for (int i4 = 0; i4 < size; i4++) {
            Parcelable parcelable = (Parcelable) list.get(i4);
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                O(parcel, parcelable, 0);
            }
        }
        N(parcel, iM);
    }

    private static void L(Parcel parcel, int i3, int i4) {
        parcel.writeInt(i3 | (i4 << 16));
    }

    private static int M(Parcel parcel, int i3) {
        parcel.writeInt(i3 | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void N(Parcel parcel, int i3) {
        int iDataPosition = parcel.dataPosition();
        parcel.setDataPosition(i3 - 4);
        parcel.writeInt(iDataPosition - i3);
        parcel.setDataPosition(iDataPosition);
    }

    private static void O(Parcel parcel, Parcelable parcelable, int i3) {
        int iDataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int iDataPosition2 = parcel.dataPosition();
        parcelable.writeToParcel(parcel, i3);
        int iDataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(iDataPosition);
        parcel.writeInt(iDataPosition3 - iDataPosition2);
        parcel.setDataPosition(iDataPosition3);
    }

    public static int a(Parcel parcel) {
        return M(parcel, 20293);
    }

    public static void b(Parcel parcel, int i3) {
        N(parcel, i3);
    }

    public static void c(Parcel parcel, int i3, BigDecimal bigDecimal, boolean z2) {
        if (bigDecimal == null) {
            if (z2) {
                L(parcel, i3, 0);
            }
        } else {
            int iM = M(parcel, i3);
            parcel.writeByteArray(bigDecimal.unscaledValue().toByteArray());
            parcel.writeInt(bigDecimal.scale());
            N(parcel, iM);
        }
    }

    public static void d(Parcel parcel, int i3, BigDecimal[] bigDecimalArr, boolean z2) {
        if (bigDecimalArr == null) {
            if (z2) {
                L(parcel, i3, 0);
                return;
            }
            return;
        }
        int iM = M(parcel, i3);
        int length = bigDecimalArr.length;
        parcel.writeInt(length);
        for (int i4 = 0; i4 < length; i4++) {
            parcel.writeByteArray(bigDecimalArr[i4].unscaledValue().toByteArray());
            parcel.writeInt(bigDecimalArr[i4].scale());
        }
        N(parcel, iM);
    }

    public static void e(Parcel parcel, int i3, BigInteger bigInteger, boolean z2) {
        if (bigInteger == null) {
            if (z2) {
                L(parcel, i3, 0);
            }
        } else {
            int iM = M(parcel, i3);
            parcel.writeByteArray(bigInteger.toByteArray());
            N(parcel, iM);
        }
    }

    public static void f(Parcel parcel, int i3, BigInteger[] bigIntegerArr, boolean z2) {
        if (bigIntegerArr == null) {
            if (z2) {
                L(parcel, i3, 0);
                return;
            }
            return;
        }
        int iM = M(parcel, i3);
        parcel.writeInt(bigIntegerArr.length);
        for (BigInteger bigInteger : bigIntegerArr) {
            parcel.writeByteArray(bigInteger.toByteArray());
        }
        N(parcel, iM);
    }

    public static void g(Parcel parcel, int i3, boolean z2) {
        L(parcel, i3, 4);
        parcel.writeInt(z2 ? 1 : 0);
    }

    public static void h(Parcel parcel, int i3, boolean[] zArr, boolean z2) {
        if (zArr == null) {
            if (z2) {
                L(parcel, i3, 0);
            }
        } else {
            int iM = M(parcel, i3);
            parcel.writeBooleanArray(zArr);
            N(parcel, iM);
        }
    }

    public static void i(Parcel parcel, int i3, Boolean bool, boolean z2) {
        if (bool != null) {
            L(parcel, i3, 4);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        } else if (z2) {
            L(parcel, i3, 0);
        }
    }

    public static void j(Parcel parcel, int i3, Bundle bundle, boolean z2) {
        if (bundle == null) {
            if (z2) {
                L(parcel, i3, 0);
            }
        } else {
            int iM = M(parcel, i3);
            parcel.writeBundle(bundle);
            N(parcel, iM);
        }
    }

    public static void k(Parcel parcel, int i3, byte b3) {
        L(parcel, i3, 4);
        parcel.writeInt(b3);
    }

    public static void l(Parcel parcel, int i3, byte[] bArr, boolean z2) {
        if (bArr == null) {
            if (z2) {
                L(parcel, i3, 0);
            }
        } else {
            int iM = M(parcel, i3);
            parcel.writeByteArray(bArr);
            N(parcel, iM);
        }
    }

    public static void m(Parcel parcel, int i3, byte[][] bArr, boolean z2) {
        if (bArr == null) {
            if (z2) {
                L(parcel, i3, 0);
                return;
            }
            return;
        }
        int iM = M(parcel, i3);
        parcel.writeInt(bArr.length);
        for (byte[] bArr2 : bArr) {
            parcel.writeByteArray(bArr2);
        }
        N(parcel, iM);
    }

    public static void n(Parcel parcel, int i3, double d3) {
        L(parcel, i3, 8);
        parcel.writeDouble(d3);
    }

    public static void o(Parcel parcel, int i3, double[] dArr, boolean z2) {
        if (dArr == null) {
            if (z2) {
                L(parcel, i3, 0);
            }
        } else {
            int iM = M(parcel, i3);
            parcel.writeDoubleArray(dArr);
            N(parcel, iM);
        }
    }

    public static void p(Parcel parcel, int i3, Double d3, boolean z2) {
        if (d3 != null) {
            L(parcel, i3, 8);
            parcel.writeDouble(d3.doubleValue());
        } else if (z2) {
            L(parcel, i3, 0);
        }
    }

    public static void q(Parcel parcel, int i3, float f3) {
        L(parcel, i3, 4);
        parcel.writeFloat(f3);
    }

    public static void r(Parcel parcel, int i3, float[] fArr, boolean z2) {
        if (fArr == null) {
            if (z2) {
                L(parcel, i3, 0);
            }
        } else {
            int iM = M(parcel, i3);
            parcel.writeFloatArray(fArr);
            N(parcel, iM);
        }
    }

    public static void s(Parcel parcel, int i3, Float f3, boolean z2) {
        if (f3 != null) {
            L(parcel, i3, 4);
            parcel.writeFloat(f3.floatValue());
        } else if (z2) {
            L(parcel, i3, 0);
        }
    }

    public static void t(Parcel parcel, int i3, IBinder iBinder, boolean z2) {
        if (iBinder == null) {
            if (z2) {
                L(parcel, i3, 0);
            }
        } else {
            int iM = M(parcel, i3);
            parcel.writeStrongBinder(iBinder);
            N(parcel, iM);
        }
    }

    public static void u(Parcel parcel, int i3, int i4) {
        L(parcel, i3, 4);
        parcel.writeInt(i4);
    }

    public static void v(Parcel parcel, int i3, int[] iArr, boolean z2) {
        if (iArr == null) {
            if (z2) {
                L(parcel, i3, 0);
            }
        } else {
            int iM = M(parcel, i3);
            parcel.writeIntArray(iArr);
            N(parcel, iM);
        }
    }

    public static void w(Parcel parcel, int i3, List list, boolean z2) {
        if (list == null) {
            if (z2) {
                L(parcel, i3, 0);
                return;
            }
            return;
        }
        int iM = M(parcel, i3);
        int size = list.size();
        parcel.writeInt(size);
        for (int i4 = 0; i4 < size; i4++) {
            parcel.writeInt(((Integer) list.get(i4)).intValue());
        }
        N(parcel, iM);
    }

    public static void x(Parcel parcel, int i3, Integer num, boolean z2) {
        if (num != null) {
            L(parcel, i3, 4);
            parcel.writeInt(num.intValue());
        } else if (z2) {
            L(parcel, i3, 0);
        }
    }

    public static void y(Parcel parcel, int i3, List list, boolean z2) {
        if (list == null) {
            if (z2) {
                L(parcel, i3, 0);
            }
        } else {
            int iM = M(parcel, i3);
            parcel.writeList(list);
            N(parcel, iM);
        }
    }

    public static void z(Parcel parcel, int i3, long j3) {
        L(parcel, i3, 8);
        parcel.writeLong(j3);
    }
}
