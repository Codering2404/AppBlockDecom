package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class SafeParcelReader {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class ParseException extends RuntimeException {
        public ParseException(String str, Parcel parcel) {
            int iDataPosition = parcel.dataPosition();
            int iDataSize = parcel.dataSize();
            int length = String.valueOf(str).length();
            StringBuilder sb = new StringBuilder(length + 13 + String.valueOf(iDataPosition).length() + 6 + String.valueOf(iDataSize).length());
            sb.append(str);
            sb.append(" Parcel: pos=");
            sb.append(iDataPosition);
            sb.append(" size=");
            sb.append(iDataSize);
            super(sb.toString());
        }
    }

    public static double A(Parcel parcel, int i3) {
        P(parcel, i3, 8);
        return parcel.readDouble();
    }

    public static Double B(Parcel parcel, int i3) {
        int iM = M(parcel, i3);
        if (iM == 0) {
            return null;
        }
        Q(parcel, i3, iM, 8);
        return Double.valueOf(parcel.readDouble());
    }

    public static float C(Parcel parcel, int i3) {
        P(parcel, i3, 4);
        return parcel.readFloat();
    }

    public static Float D(Parcel parcel, int i3) {
        int iM = M(parcel, i3);
        if (iM == 0) {
            return null;
        }
        Q(parcel, i3, iM, 4);
        return Float.valueOf(parcel.readFloat());
    }

    public static int E(Parcel parcel) {
        return parcel.readInt();
    }

    public static IBinder F(Parcel parcel, int i3) {
        int iM = M(parcel, i3);
        int iDataPosition = parcel.dataPosition();
        if (iM == 0) {
            return null;
        }
        IBinder strongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(iDataPosition + iM);
        return strongBinder;
    }

    public static int G(Parcel parcel, int i3) {
        P(parcel, i3, 4);
        return parcel.readInt();
    }

    public static Integer H(Parcel parcel, int i3) {
        int iM = M(parcel, i3);
        if (iM == 0) {
            return null;
        }
        Q(parcel, i3, iM, 4);
        return Integer.valueOf(parcel.readInt());
    }

    public static void I(Parcel parcel, int i3, List list, ClassLoader classLoader) {
        int iM = M(parcel, i3);
        int iDataPosition = parcel.dataPosition();
        if (iM == 0) {
            return;
        }
        parcel.readList(list, classLoader);
        parcel.setDataPosition(iDataPosition + iM);
    }

    public static long J(Parcel parcel, int i3) {
        P(parcel, i3, 8);
        return parcel.readLong();
    }

    public static Long K(Parcel parcel, int i3) {
        int iM = M(parcel, i3);
        if (iM == 0) {
            return null;
        }
        Q(parcel, i3, iM, 8);
        return Long.valueOf(parcel.readLong());
    }

    public static short L(Parcel parcel, int i3) {
        P(parcel, i3, 4);
        return (short) parcel.readInt();
    }

    public static int M(Parcel parcel, int i3) {
        return (i3 & (-65536)) != -65536 ? (char) (i3 >> 16) : parcel.readInt();
    }

    public static void N(Parcel parcel, int i3) {
        parcel.setDataPosition(parcel.dataPosition() + M(parcel, i3));
    }

    public static int O(Parcel parcel) {
        int iE = E(parcel);
        int iM = M(parcel, iE);
        int iW = w(iE);
        int iDataPosition = parcel.dataPosition();
        if (iW != 20293) {
            throw new ParseException("Expected object header. Got 0x".concat(String.valueOf(Integer.toHexString(iE))), parcel);
        }
        int i3 = iM + iDataPosition;
        if (i3 >= iDataPosition && i3 <= parcel.dataSize()) {
            return i3;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(iDataPosition).length() + 32 + String.valueOf(i3).length());
        sb.append("Size read is invalid start=");
        sb.append(iDataPosition);
        sb.append(" end=");
        sb.append(i3);
        throw new ParseException(sb.toString(), parcel);
    }

    private static void P(Parcel parcel, int i3, int i4) {
        int iM = M(parcel, i3);
        if (iM == i4) {
            return;
        }
        String hexString = Integer.toHexString(iM);
        int length = String.valueOf(i4).length();
        StringBuilder sb = new StringBuilder(length + 19 + String.valueOf(iM).length() + 4 + String.valueOf(hexString).length() + 1);
        sb.append("Expected size ");
        sb.append(i4);
        sb.append(" got ");
        sb.append(iM);
        sb.append(" (0x");
        sb.append(hexString);
        sb.append(")");
        throw new ParseException(sb.toString(), parcel);
    }

    private static void Q(Parcel parcel, int i3, int i4, int i5) {
        if (i4 == i5) {
            return;
        }
        String hexString = Integer.toHexString(i4);
        int length = String.valueOf(i5).length();
        StringBuilder sb = new StringBuilder(length + 19 + String.valueOf(i4).length() + 4 + String.valueOf(hexString).length() + 1);
        sb.append("Expected size ");
        sb.append(i5);
        sb.append(" got ");
        sb.append(i4);
        sb.append(" (0x");
        sb.append(hexString);
        sb.append(")");
        throw new ParseException(sb.toString(), parcel);
    }

    public static BigDecimal a(Parcel parcel, int i3) {
        int iM = M(parcel, i3);
        int iDataPosition = parcel.dataPosition();
        if (iM == 0) {
            return null;
        }
        byte[] bArrCreateByteArray = parcel.createByteArray();
        int i4 = parcel.readInt();
        parcel.setDataPosition(iDataPosition + iM);
        return new BigDecimal(new BigInteger(bArrCreateByteArray), i4);
    }

    public static BigDecimal[] b(Parcel parcel, int i3) {
        int iM = M(parcel, i3);
        int iDataPosition = parcel.dataPosition();
        if (iM == 0) {
            return null;
        }
        int i4 = parcel.readInt();
        BigDecimal[] bigDecimalArr = new BigDecimal[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            byte[] bArrCreateByteArray = parcel.createByteArray();
            bigDecimalArr[i5] = new BigDecimal(new BigInteger(bArrCreateByteArray), parcel.readInt());
        }
        parcel.setDataPosition(iDataPosition + iM);
        return bigDecimalArr;
    }

    public static BigInteger c(Parcel parcel, int i3) {
        int iM = M(parcel, i3);
        int iDataPosition = parcel.dataPosition();
        if (iM == 0) {
            return null;
        }
        byte[] bArrCreateByteArray = parcel.createByteArray();
        parcel.setDataPosition(iDataPosition + iM);
        return new BigInteger(bArrCreateByteArray);
    }

    public static BigInteger[] d(Parcel parcel, int i3) {
        int iM = M(parcel, i3);
        int iDataPosition = parcel.dataPosition();
        if (iM == 0) {
            return null;
        }
        int i4 = parcel.readInt();
        BigInteger[] bigIntegerArr = new BigInteger[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            bigIntegerArr[i5] = new BigInteger(parcel.createByteArray());
        }
        parcel.setDataPosition(iDataPosition + iM);
        return bigIntegerArr;
    }

    public static boolean[] e(Parcel parcel, int i3) {
        int iM = M(parcel, i3);
        int iDataPosition = parcel.dataPosition();
        if (iM == 0) {
            return null;
        }
        boolean[] zArrCreateBooleanArray = parcel.createBooleanArray();
        parcel.setDataPosition(iDataPosition + iM);
        return zArrCreateBooleanArray;
    }

    public static Bundle f(Parcel parcel, int i3) {
        int iM = M(parcel, i3);
        int iDataPosition = parcel.dataPosition();
        if (iM == 0) {
            return null;
        }
        Bundle bundle = parcel.readBundle();
        parcel.setDataPosition(iDataPosition + iM);
        return bundle;
    }

    public static byte[] g(Parcel parcel, int i3) {
        int iM = M(parcel, i3);
        int iDataPosition = parcel.dataPosition();
        if (iM == 0) {
            return null;
        }
        byte[] bArrCreateByteArray = parcel.createByteArray();
        parcel.setDataPosition(iDataPosition + iM);
        return bArrCreateByteArray;
    }

    public static byte[][] h(Parcel parcel, int i3) {
        int iM = M(parcel, i3);
        int iDataPosition = parcel.dataPosition();
        if (iM == 0) {
            return null;
        }
        int i4 = parcel.readInt();
        byte[][] bArr = new byte[i4][];
        for (int i5 = 0; i5 < i4; i5++) {
            bArr[i5] = parcel.createByteArray();
        }
        parcel.setDataPosition(iDataPosition + iM);
        return bArr;
    }

    public static double[] i(Parcel parcel, int i3) {
        int iM = M(parcel, i3);
        int iDataPosition = parcel.dataPosition();
        if (iM == 0) {
            return null;
        }
        double[] dArrCreateDoubleArray = parcel.createDoubleArray();
        parcel.setDataPosition(iDataPosition + iM);
        return dArrCreateDoubleArray;
    }

    public static float[] j(Parcel parcel, int i3) {
        int iM = M(parcel, i3);
        int iDataPosition = parcel.dataPosition();
        if (iM == 0) {
            return null;
        }
        float[] fArrCreateFloatArray = parcel.createFloatArray();
        parcel.setDataPosition(iDataPosition + iM);
        return fArrCreateFloatArray;
    }

    public static int[] k(Parcel parcel, int i3) {
        int iM = M(parcel, i3);
        int iDataPosition = parcel.dataPosition();
        if (iM == 0) {
            return null;
        }
        int[] iArrCreateIntArray = parcel.createIntArray();
        parcel.setDataPosition(iDataPosition + iM);
        return iArrCreateIntArray;
    }

    public static ArrayList l(Parcel parcel, int i3) {
        int iM = M(parcel, i3);
        int iDataPosition = parcel.dataPosition();
        if (iM == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i4 = parcel.readInt();
        for (int i5 = 0; i5 < i4; i5++) {
            arrayList.add(Integer.valueOf(parcel.readInt()));
        }
        parcel.setDataPosition(iDataPosition + iM);
        return arrayList;
    }

    public static long[] m(Parcel parcel, int i3) {
        int iM = M(parcel, i3);
        int iDataPosition = parcel.dataPosition();
        if (iM == 0) {
            return null;
        }
        long[] jArrCreateLongArray = parcel.createLongArray();
        parcel.setDataPosition(iDataPosition + iM);
        return jArrCreateLongArray;
    }

    public static Parcel n(Parcel parcel, int i3) {
        int iM = M(parcel, i3);
        int iDataPosition = parcel.dataPosition();
        if (iM == 0) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.appendFrom(parcel, iDataPosition, iM);
        parcel.setDataPosition(iDataPosition + iM);
        return parcelObtain;
    }

    public static Parcel[] o(Parcel parcel, int i3) {
        int iM = M(parcel, i3);
        int iDataPosition = parcel.dataPosition();
        if (iM == 0) {
            return null;
        }
        int i4 = parcel.readInt();
        Parcel[] parcelArr = new Parcel[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = parcel.readInt();
            if (i6 != 0) {
                int iDataPosition2 = parcel.dataPosition();
                Parcel parcelObtain = Parcel.obtain();
                parcelObtain.appendFrom(parcel, iDataPosition2, i6);
                parcelArr[i5] = parcelObtain;
                parcel.setDataPosition(iDataPosition2 + i6);
            } else {
                parcelArr[i5] = null;
            }
        }
        parcel.setDataPosition(iDataPosition + iM);
        return parcelArr;
    }

    public static Parcelable p(Parcel parcel, int i3, Parcelable.Creator creator) {
        int iM = M(parcel, i3);
        int iDataPosition = parcel.dataPosition();
        if (iM == 0) {
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(iDataPosition + iM);
        return parcelable;
    }

    public static String q(Parcel parcel, int i3) {
        int iM = M(parcel, i3);
        int iDataPosition = parcel.dataPosition();
        if (iM == 0) {
            return null;
        }
        String string = parcel.readString();
        parcel.setDataPosition(iDataPosition + iM);
        return string;
    }

    public static String[] r(Parcel parcel, int i3) {
        int iM = M(parcel, i3);
        int iDataPosition = parcel.dataPosition();
        if (iM == 0) {
            return null;
        }
        String[] strArrCreateStringArray = parcel.createStringArray();
        parcel.setDataPosition(iDataPosition + iM);
        return strArrCreateStringArray;
    }

    public static ArrayList s(Parcel parcel, int i3) {
        int iM = M(parcel, i3);
        int iDataPosition = parcel.dataPosition();
        if (iM == 0) {
            return null;
        }
        ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(iDataPosition + iM);
        return arrayListCreateStringArrayList;
    }

    public static Object[] t(Parcel parcel, int i3, Parcelable.Creator creator) {
        int iM = M(parcel, i3);
        int iDataPosition = parcel.dataPosition();
        if (iM == 0) {
            return null;
        }
        Object[] objArrCreateTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(iDataPosition + iM);
        return objArrCreateTypedArray;
    }

    public static ArrayList u(Parcel parcel, int i3, Parcelable.Creator creator) {
        int iM = M(parcel, i3);
        int iDataPosition = parcel.dataPosition();
        if (iM == 0) {
            return null;
        }
        ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(iDataPosition + iM);
        return arrayListCreateTypedArrayList;
    }

    public static void v(Parcel parcel, int i3) {
        if (parcel.dataPosition() == i3) {
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 26);
        sb.append("Overread allowed size end=");
        sb.append(i3);
        throw new ParseException(sb.toString(), parcel);
    }

    public static int w(int i3) {
        return (char) i3;
    }

    public static boolean x(Parcel parcel, int i3) {
        P(parcel, i3, 4);
        return parcel.readInt() != 0;
    }

    public static Boolean y(Parcel parcel, int i3) {
        int iM = M(parcel, i3);
        if (iM == 0) {
            return null;
        }
        Q(parcel, i3, iM, 4);
        return Boolean.valueOf(parcel.readInt() != 0);
    }

    public static byte z(Parcel parcel, int i3) {
        P(parcel, i3, 4);
        return (byte) parcel.readInt();
    }
}
