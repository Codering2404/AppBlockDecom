package androidx.glance.appwidget.protobuf;

import androidx.glance.appwidget.protobuf.GeneratedMessageLite;
import androidx.glance.appwidget.protobuf.Internal;
import androidx.glance.appwidget.protobuf.WireFormat;
import com.applovin.exoplayer2.common.base.Ascii;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
final class ArrayDecoders {

    /* JADX INFO: renamed from: androidx.glance.appwidget.protobuf.ArrayDecoders$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f38784a;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f38784a = iArr;
            try {
                iArr[WireFormat.FieldType.f39329c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f38784a[WireFormat.FieldType.f39330d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f38784a[WireFormat.FieldType.f39331f.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f38784a[WireFormat.FieldType.f39332g.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f38784a[WireFormat.FieldType.f39333h.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f38784a[WireFormat.FieldType.f39341p.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f38784a[WireFormat.FieldType.f39334i.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f38784a[WireFormat.FieldType.f39344s.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f38784a[WireFormat.FieldType.f39335j.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f38784a[WireFormat.FieldType.f39343r.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f38784a[WireFormat.FieldType.f39336k.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f38784a[WireFormat.FieldType.f39345t.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f38784a[WireFormat.FieldType.f39346u.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f38784a[WireFormat.FieldType.f39342q.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f38784a[WireFormat.FieldType.f39340o.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f38784a[WireFormat.FieldType.f39337l.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f38784a[WireFormat.FieldType.f39338m.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f38784a[WireFormat.FieldType.f39339n.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Registers {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f38785a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f38786b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f38787c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ExtensionRegistryLite f38788d;

        Registers(ExtensionRegistryLite extensionRegistryLite) {
            extensionRegistryLite.getClass();
            this.f38788d = extensionRegistryLite;
        }
    }

    static int A(int i3, byte[] bArr, int i4, int i5, Internal.ProtobufList protobufList, Registers registers) {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int I = I(bArr, i4, registers);
        intArrayList.e(CodedInputStream.b(registers.f38785a));
        while (I < i5) {
            int I2 = I(bArr, I, registers);
            if (i3 != registers.f38785a) {
                break;
            }
            I = I(bArr, I2, registers);
            intArrayList.e(CodedInputStream.b(registers.f38785a));
        }
        return I;
    }

    static int B(int i3, byte[] bArr, int i4, int i5, Internal.ProtobufList protobufList, Registers registers) {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int iL = L(bArr, i4, registers);
        longArrayList.f(CodedInputStream.c(registers.f38786b));
        while (iL < i5) {
            int I = I(bArr, iL, registers);
            if (i3 != registers.f38785a) {
                break;
            }
            iL = L(bArr, I, registers);
            longArrayList.f(CodedInputStream.c(registers.f38786b));
        }
        return iL;
    }

    static int C(byte[] bArr, int i3, Registers registers) throws InvalidProtocolBufferException {
        int I = I(bArr, i3, registers);
        int i4 = registers.f38785a;
        if (i4 < 0) {
            throw InvalidProtocolBufferException.g();
        }
        if (i4 == 0) {
            registers.f38787c = "";
            return I;
        }
        registers.f38787c = new String(bArr, I, i4, Internal.f39080b);
        return I + i4;
    }

    static int D(int i3, byte[] bArr, int i4, int i5, Internal.ProtobufList protobufList, Registers registers) throws InvalidProtocolBufferException {
        int I = I(bArr, i4, registers);
        int i6 = registers.f38785a;
        if (i6 < 0) {
            throw InvalidProtocolBufferException.g();
        }
        if (i6 == 0) {
            protobufList.add("");
        } else {
            protobufList.add(new String(bArr, I, i6, Internal.f39080b));
            I += i6;
        }
        while (I < i5) {
            int I2 = I(bArr, I, registers);
            if (i3 != registers.f38785a) {
                break;
            }
            I = I(bArr, I2, registers);
            int i7 = registers.f38785a;
            if (i7 < 0) {
                throw InvalidProtocolBufferException.g();
            }
            if (i7 == 0) {
                protobufList.add("");
            } else {
                protobufList.add(new String(bArr, I, i7, Internal.f39080b));
                I += i7;
            }
        }
        return I;
    }

    static int E(int i3, byte[] bArr, int i4, int i5, Internal.ProtobufList protobufList, Registers registers) throws InvalidProtocolBufferException {
        int I = I(bArr, i4, registers);
        int i6 = registers.f38785a;
        if (i6 < 0) {
            throw InvalidProtocolBufferException.g();
        }
        if (i6 == 0) {
            protobufList.add("");
        } else {
            int i7 = I + i6;
            if (!Utf8.u(bArr, I, i7)) {
                throw InvalidProtocolBufferException.d();
            }
            protobufList.add(new String(bArr, I, i6, Internal.f39080b));
            I = i7;
        }
        while (I < i5) {
            int I2 = I(bArr, I, registers);
            if (i3 != registers.f38785a) {
                break;
            }
            I = I(bArr, I2, registers);
            int i8 = registers.f38785a;
            if (i8 < 0) {
                throw InvalidProtocolBufferException.g();
            }
            if (i8 == 0) {
                protobufList.add("");
            } else {
                int i9 = I + i8;
                if (!Utf8.u(bArr, I, i9)) {
                    throw InvalidProtocolBufferException.d();
                }
                protobufList.add(new String(bArr, I, i8, Internal.f39080b));
                I = i9;
            }
        }
        return I;
    }

    static int F(byte[] bArr, int i3, Registers registers) throws InvalidProtocolBufferException {
        int I = I(bArr, i3, registers);
        int i4 = registers.f38785a;
        if (i4 < 0) {
            throw InvalidProtocolBufferException.g();
        }
        if (i4 == 0) {
            registers.f38787c = "";
            return I;
        }
        registers.f38787c = Utf8.h(bArr, I, i4);
        return I + i4;
    }

    static int G(int i3, byte[] bArr, int i4, int i5, UnknownFieldSetLite unknownFieldSetLite, Registers registers) throws InvalidProtocolBufferException {
        if (WireFormat.a(i3) == 0) {
            throw InvalidProtocolBufferException.c();
        }
        int iB = WireFormat.b(i3);
        if (iB == 0) {
            int iL = L(bArr, i4, registers);
            unknownFieldSetLite.n(i3, Long.valueOf(registers.f38786b));
            return iL;
        }
        if (iB == 1) {
            unknownFieldSetLite.n(i3, Long.valueOf(j(bArr, i4)));
            return i4 + 8;
        }
        if (iB == 2) {
            int I = I(bArr, i4, registers);
            int i6 = registers.f38785a;
            if (i6 < 0) {
                throw InvalidProtocolBufferException.g();
            }
            if (i6 > bArr.length - I) {
                throw InvalidProtocolBufferException.m();
            }
            if (i6 == 0) {
                unknownFieldSetLite.n(i3, ByteString.f38830b);
            } else {
                unknownFieldSetLite.n(i3, ByteString.q(bArr, I, i6));
            }
            return I + i6;
        }
        if (iB != 3) {
            if (iB != 5) {
                throw InvalidProtocolBufferException.c();
            }
            unknownFieldSetLite.n(i3, Integer.valueOf(h(bArr, i4)));
            return i4 + 4;
        }
        UnknownFieldSetLite unknownFieldSetLiteK = UnknownFieldSetLite.k();
        int i7 = (i3 & (-8)) | 4;
        int i8 = 0;
        while (true) {
            if (i4 >= i5) {
                break;
            }
            int I2 = I(bArr, i4, registers);
            i8 = registers.f38785a;
            if (i8 == i7) {
                i4 = I2;
                break;
            }
            i4 = G(i8, bArr, I2, i5, unknownFieldSetLiteK, registers);
        }
        if (i4 > i5 || i8 != i7) {
            throw InvalidProtocolBufferException.h();
        }
        unknownFieldSetLite.n(i3, unknownFieldSetLiteK);
        return i4;
    }

    static int H(int i3, byte[] bArr, int i4, Registers registers) {
        int i5 = i3 & 127;
        int i6 = i4 + 1;
        byte b3 = bArr[i4];
        if (b3 >= 0) {
            registers.f38785a = i5 | (b3 << 7);
            return i6;
        }
        int i7 = i5 | ((b3 & Ascii.DEL) << 7);
        int i8 = i4 + 2;
        byte b4 = bArr[i6];
        if (b4 >= 0) {
            registers.f38785a = i7 | (b4 << Ascii.SO);
            return i8;
        }
        int i9 = i7 | ((b4 & Ascii.DEL) << 14);
        int i10 = i4 + 3;
        byte b5 = bArr[i8];
        if (b5 >= 0) {
            registers.f38785a = i9 | (b5 << Ascii.NAK);
            return i10;
        }
        int i11 = i9 | ((b5 & Ascii.DEL) << 21);
        int i12 = i4 + 4;
        byte b6 = bArr[i10];
        if (b6 >= 0) {
            registers.f38785a = i11 | (b6 << Ascii.FS);
            return i12;
        }
        int i13 = i11 | ((b6 & Ascii.DEL) << 28);
        while (true) {
            int i14 = i12 + 1;
            if (bArr[i12] >= 0) {
                registers.f38785a = i13;
                return i14;
            }
            i12 = i14;
        }
    }

    static int I(byte[] bArr, int i3, Registers registers) {
        int i4 = i3 + 1;
        byte b3 = bArr[i3];
        if (b3 < 0) {
            return H(b3, bArr, i4, registers);
        }
        registers.f38785a = b3;
        return i4;
    }

    static int J(int i3, byte[] bArr, int i4, int i5, Internal.ProtobufList protobufList, Registers registers) {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int I = I(bArr, i4, registers);
        intArrayList.e(registers.f38785a);
        while (I < i5) {
            int I2 = I(bArr, I, registers);
            if (i3 != registers.f38785a) {
                break;
            }
            I = I(bArr, I2, registers);
            intArrayList.e(registers.f38785a);
        }
        return I;
    }

    static int K(long j3, byte[] bArr, int i3, Registers registers) {
        int i4 = i3 + 1;
        byte b3 = bArr[i3];
        long j4 = (j3 & 127) | (((long) (b3 & Ascii.DEL)) << 7);
        int i5 = 7;
        while (b3 < 0) {
            int i6 = i4 + 1;
            byte b4 = bArr[i4];
            i5 += 7;
            j4 |= ((long) (b4 & Ascii.DEL)) << i5;
            i4 = i6;
            b3 = b4;
        }
        registers.f38786b = j4;
        return i4;
    }

    static int L(byte[] bArr, int i3, Registers registers) {
        int i4 = i3 + 1;
        long j3 = bArr[i3];
        if (j3 < 0) {
            return K(j3, bArr, i4, registers);
        }
        registers.f38786b = j3;
        return i4;
    }

    static int M(int i3, byte[] bArr, int i4, int i5, Internal.ProtobufList protobufList, Registers registers) {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int iL = L(bArr, i4, registers);
        longArrayList.f(registers.f38786b);
        while (iL < i5) {
            int I = I(bArr, iL, registers);
            if (i3 != registers.f38785a) {
                break;
            }
            iL = L(bArr, I, registers);
            longArrayList.f(registers.f38786b);
        }
        return iL;
    }

    static int N(Object obj, Schema schema, byte[] bArr, int i3, int i4, int i5, Registers registers) {
        int iG0 = ((MessageSchema) schema).g0(obj, bArr, i3, i4, i5, registers);
        registers.f38787c = obj;
        return iG0;
    }

    static int O(Object obj, Schema schema, byte[] bArr, int i3, int i4, Registers registers) throws InvalidProtocolBufferException {
        int iH = i3 + 1;
        int i5 = bArr[i3];
        if (i5 < 0) {
            iH = H(i5, bArr, iH, registers);
            i5 = registers.f38785a;
        }
        int i6 = iH;
        if (i5 < 0 || i5 > i4 - i6) {
            throw InvalidProtocolBufferException.m();
        }
        int i7 = i6 + i5;
        schema.i(obj, bArr, i6, i7, registers);
        registers.f38787c = obj;
        return i7;
    }

    static int P(int i3, byte[] bArr, int i4, int i5, Registers registers) throws InvalidProtocolBufferException {
        if (WireFormat.a(i3) == 0) {
            throw InvalidProtocolBufferException.c();
        }
        int iB = WireFormat.b(i3);
        if (iB == 0) {
            return L(bArr, i4, registers);
        }
        if (iB == 1) {
            return i4 + 8;
        }
        if (iB == 2) {
            return I(bArr, i4, registers) + registers.f38785a;
        }
        if (iB != 3) {
            if (iB == 5) {
                return i4 + 4;
            }
            throw InvalidProtocolBufferException.c();
        }
        int i6 = (i3 & (-8)) | 4;
        int i7 = 0;
        while (i4 < i5) {
            i4 = I(bArr, i4, registers);
            i7 = registers.f38785a;
            if (i7 == i6) {
                break;
            }
            i4 = P(i7, bArr, i4, i5, registers);
        }
        if (i4 > i5 || i7 != i6) {
            throw InvalidProtocolBufferException.h();
        }
        return i4;
    }

    static int a(int i3, byte[] bArr, int i4, int i5, Internal.ProtobufList protobufList, Registers registers) {
        BooleanArrayList booleanArrayList = (BooleanArrayList) protobufList;
        int iL = L(bArr, i4, registers);
        booleanArrayList.f(registers.f38786b != 0);
        while (iL < i5) {
            int I = I(bArr, iL, registers);
            if (i3 != registers.f38785a) {
                break;
            }
            iL = L(bArr, I, registers);
            booleanArrayList.f(registers.f38786b != 0);
        }
        return iL;
    }

    static int b(byte[] bArr, int i3, Registers registers) throws InvalidProtocolBufferException {
        int I = I(bArr, i3, registers);
        int i4 = registers.f38785a;
        if (i4 < 0) {
            throw InvalidProtocolBufferException.g();
        }
        if (i4 > bArr.length - I) {
            throw InvalidProtocolBufferException.m();
        }
        if (i4 == 0) {
            registers.f38787c = ByteString.f38830b;
            return I;
        }
        registers.f38787c = ByteString.q(bArr, I, i4);
        return I + i4;
    }

    static int c(int i3, byte[] bArr, int i4, int i5, Internal.ProtobufList protobufList, Registers registers) throws InvalidProtocolBufferException {
        int I = I(bArr, i4, registers);
        int i6 = registers.f38785a;
        if (i6 < 0) {
            throw InvalidProtocolBufferException.g();
        }
        if (i6 > bArr.length - I) {
            throw InvalidProtocolBufferException.m();
        }
        if (i6 == 0) {
            protobufList.add(ByteString.f38830b);
        } else {
            protobufList.add(ByteString.q(bArr, I, i6));
            I += i6;
        }
        while (I < i5) {
            int I2 = I(bArr, I, registers);
            if (i3 != registers.f38785a) {
                break;
            }
            I = I(bArr, I2, registers);
            int i7 = registers.f38785a;
            if (i7 < 0) {
                throw InvalidProtocolBufferException.g();
            }
            if (i7 > bArr.length - I) {
                throw InvalidProtocolBufferException.m();
            }
            if (i7 == 0) {
                protobufList.add(ByteString.f38830b);
            } else {
                protobufList.add(ByteString.q(bArr, I, i7));
                I += i7;
            }
        }
        return I;
    }

    static double d(byte[] bArr, int i3) {
        return Double.longBitsToDouble(j(bArr, i3));
    }

    static int e(int i3, byte[] bArr, int i4, int i5, Internal.ProtobufList protobufList, Registers registers) {
        DoubleArrayList doubleArrayList = (DoubleArrayList) protobufList;
        doubleArrayList.e(d(bArr, i4));
        int i6 = i4 + 8;
        while (i6 < i5) {
            int I = I(bArr, i6, registers);
            if (i3 != registers.f38785a) {
                break;
            }
            doubleArrayList.e(d(bArr, I));
            i6 = I + 8;
        }
        return i6;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    static int f(int i3, byte[] bArr, int i4, int i5, GeneratedMessageLite.ExtendableMessage extendableMessage, GeneratedMessageLite.GeneratedExtension generatedExtension, UnknownFieldSchema unknownFieldSchema, Registers registers) throws InvalidProtocolBufferException {
        int i6;
        int i7;
        FieldSet<GeneratedMessageLite.ExtensionDescriptor> fieldSet = extendableMessage.extensions;
        int i8 = i3 >>> 3;
        if (generatedExtension.f39062b.K() && generatedExtension.f39062b.N()) {
            switch (AnonymousClass1.f38784a[generatedExtension.a().ordinal()]) {
                case 1:
                    DoubleArrayList doubleArrayList = new DoubleArrayList();
                    int iS = s(bArr, i4, doubleArrayList, registers);
                    fieldSet.y(generatedExtension.f39062b, doubleArrayList);
                    return iS;
                case 2:
                    FloatArrayList floatArrayList = new FloatArrayList();
                    int iV = v(bArr, i4, floatArrayList, registers);
                    fieldSet.y(generatedExtension.f39062b, floatArrayList);
                    return iV;
                case 3:
                case 4:
                    LongArrayList longArrayList = new LongArrayList();
                    int iZ = z(bArr, i4, longArrayList, registers);
                    fieldSet.y(generatedExtension.f39062b, longArrayList);
                    return iZ;
                case 5:
                case 6:
                    IntArrayList intArrayList = new IntArrayList();
                    int iY = y(bArr, i4, intArrayList, registers);
                    fieldSet.y(generatedExtension.f39062b, intArrayList);
                    return iY;
                case 7:
                case 8:
                    LongArrayList longArrayList2 = new LongArrayList();
                    int iU = u(bArr, i4, longArrayList2, registers);
                    fieldSet.y(generatedExtension.f39062b, longArrayList2);
                    return iU;
                case 9:
                case 10:
                    IntArrayList intArrayList2 = new IntArrayList();
                    int iT = t(bArr, i4, intArrayList2, registers);
                    fieldSet.y(generatedExtension.f39062b, intArrayList2);
                    return iT;
                case 11:
                    BooleanArrayList booleanArrayList = new BooleanArrayList();
                    int iR = r(bArr, i4, booleanArrayList, registers);
                    fieldSet.y(generatedExtension.f39062b, booleanArrayList);
                    return iR;
                case 12:
                    IntArrayList intArrayList3 = new IntArrayList();
                    int iW = w(bArr, i4, intArrayList3, registers);
                    fieldSet.y(generatedExtension.f39062b, intArrayList3);
                    return iW;
                case 13:
                    LongArrayList longArrayList3 = new LongArrayList();
                    int iX = x(bArr, i4, longArrayList3, registers);
                    fieldSet.y(generatedExtension.f39062b, longArrayList3);
                    return iX;
                case 14:
                    IntArrayList intArrayList4 = new IntArrayList();
                    int iY2 = y(bArr, i4, intArrayList4, registers);
                    SchemaUtil.z(extendableMessage, i8, intArrayList4, generatedExtension.f39062b.b(), null, unknownFieldSchema);
                    fieldSet.y(generatedExtension.f39062b, intArrayList4);
                    return iY2;
                default:
                    throw new IllegalStateException("Type cannot be packed: " + generatedExtension.f39062b.L());
            }
        }
        Object objValueOf = null;
        if (generatedExtension.a() == WireFormat.FieldType.f39342q) {
            i4 = I(bArr, i4, registers);
            if (generatedExtension.f39062b.b().a(registers.f38785a) == null) {
                SchemaUtil.L(extendableMessage, i8, registers.f38785a, null, unknownFieldSchema);
                return i4;
            }
            objValueOf = Integer.valueOf(registers.f38785a);
        } else {
            switch (AnonymousClass1.f38784a[generatedExtension.a().ordinal()]) {
                case 1:
                    i6 = i4;
                    objValueOf = Double.valueOf(d(bArr, i6));
                    i4 = i6 + 8;
                    break;
                case 2:
                    i7 = i4;
                    objValueOf = Float.valueOf(l(bArr, i7));
                    i4 = i7 + 4;
                    break;
                case 3:
                case 4:
                    i4 = L(bArr, i4, registers);
                    objValueOf = Long.valueOf(registers.f38786b);
                    break;
                case 5:
                case 6:
                    i4 = I(bArr, i4, registers);
                    objValueOf = Integer.valueOf(registers.f38785a);
                    break;
                case 7:
                case 8:
                    i6 = i4;
                    objValueOf = Long.valueOf(j(bArr, i6));
                    i4 = i6 + 8;
                    break;
                case 9:
                case 10:
                    i7 = i4;
                    objValueOf = Integer.valueOf(h(bArr, i7));
                    i4 = i7 + 4;
                    break;
                case 11:
                    i4 = L(bArr, i4, registers);
                    objValueOf = Boolean.valueOf(registers.f38786b != 0);
                    break;
                case 12:
                    i4 = I(bArr, i4, registers);
                    objValueOf = Integer.valueOf(CodedInputStream.b(registers.f38785a));
                    break;
                case 13:
                    i4 = L(bArr, i4, registers);
                    objValueOf = Long.valueOf(CodedInputStream.c(registers.f38786b));
                    break;
                case 14:
                    throw new IllegalStateException("Shouldn't reach here.");
                case 15:
                    i4 = b(bArr, i4, registers);
                    objValueOf = registers.f38787c;
                    break;
                case 16:
                    i4 = C(bArr, i4, registers);
                    objValueOf = registers.f38787c;
                    break;
                case 17:
                    int i9 = (i8 << 3) | 4;
                    Schema schemaC = Protobuf.a().c(generatedExtension.b().getClass());
                    if (generatedExtension.d()) {
                        int iN = n(schemaC, bArr, i4, i5, i9, registers);
                        fieldSet.a(generatedExtension.f39062b, registers.f38787c);
                        return iN;
                    }
                    Object objI = fieldSet.i(generatedExtension.f39062b);
                    if (objI == null) {
                        objI = schemaC.newInstance();
                        fieldSet.y(generatedExtension.f39062b, objI);
                    }
                    return N(objI, schemaC, bArr, i4, i5, i9, registers);
                case 18:
                    Schema schemaC2 = Protobuf.a().c(generatedExtension.b().getClass());
                    if (generatedExtension.d()) {
                        int iP = p(schemaC2, bArr, i4, i5, registers);
                        fieldSet.a(generatedExtension.f39062b, registers.f38787c);
                        return iP;
                    }
                    Object objI2 = fieldSet.i(generatedExtension.f39062b);
                    if (objI2 == null) {
                        objI2 = schemaC2.newInstance();
                        fieldSet.y(generatedExtension.f39062b, objI2);
                    }
                    return O(objI2, schemaC2, bArr, i4, i5, registers);
            }
        }
        if (generatedExtension.d()) {
            fieldSet.a(generatedExtension.f39062b, objValueOf);
            return i4;
        }
        fieldSet.y(generatedExtension.f39062b, objValueOf);
        return i4;
    }

    static int g(int i3, byte[] bArr, int i4, int i5, Object obj, MessageLite messageLite, UnknownFieldSchema unknownFieldSchema, Registers registers) {
        GeneratedMessageLite.GeneratedExtension generatedExtensionA = registers.f38788d.a(messageLite, i3 >>> 3);
        if (generatedExtensionA == null) {
            return G(i3, bArr, i4, i5, MessageSchema.w(obj), registers);
        }
        GeneratedMessageLite.ExtendableMessage extendableMessage = (GeneratedMessageLite.ExtendableMessage) obj;
        extendableMessage.T();
        return f(i3, bArr, i4, i5, extendableMessage, generatedExtensionA, unknownFieldSchema, registers);
    }

    static int h(byte[] bArr, int i3) {
        return ((bArr[i3 + 3] & 255) << 24) | (bArr[i3] & 255) | ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3 + 2] & 255) << 16);
    }

    static int i(int i3, byte[] bArr, int i4, int i5, Internal.ProtobufList protobufList, Registers registers) {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        intArrayList.e(h(bArr, i4));
        int i6 = i4 + 4;
        while (i6 < i5) {
            int I = I(bArr, i6, registers);
            if (i3 != registers.f38785a) {
                break;
            }
            intArrayList.e(h(bArr, I));
            i6 = I + 4;
        }
        return i6;
    }

    static long j(byte[] bArr, int i3) {
        return ((((long) bArr[i3 + 7]) & 255) << 56) | (((long) bArr[i3]) & 255) | ((((long) bArr[i3 + 1]) & 255) << 8) | ((((long) bArr[i3 + 2]) & 255) << 16) | ((((long) bArr[i3 + 3]) & 255) << 24) | ((((long) bArr[i3 + 4]) & 255) << 32) | ((((long) bArr[i3 + 5]) & 255) << 40) | ((((long) bArr[i3 + 6]) & 255) << 48);
    }

    static int k(int i3, byte[] bArr, int i4, int i5, Internal.ProtobufList protobufList, Registers registers) {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        longArrayList.f(j(bArr, i4));
        int i6 = i4 + 8;
        while (i6 < i5) {
            int I = I(bArr, i6, registers);
            if (i3 != registers.f38785a) {
                break;
            }
            longArrayList.f(j(bArr, I));
            i6 = I + 8;
        }
        return i6;
    }

    static float l(byte[] bArr, int i3) {
        return Float.intBitsToFloat(h(bArr, i3));
    }

    static int m(int i3, byte[] bArr, int i4, int i5, Internal.ProtobufList protobufList, Registers registers) {
        FloatArrayList floatArrayList = (FloatArrayList) protobufList;
        floatArrayList.e(l(bArr, i4));
        int i6 = i4 + 4;
        while (i6 < i5) {
            int I = I(bArr, i6, registers);
            if (i3 != registers.f38785a) {
                break;
            }
            floatArrayList.e(l(bArr, I));
            i6 = I + 4;
        }
        return i6;
    }

    static int n(Schema schema, byte[] bArr, int i3, int i4, int i5, Registers registers) {
        Object objNewInstance = schema.newInstance();
        int iN = N(objNewInstance, schema, bArr, i3, i4, i5, registers);
        schema.b(objNewInstance);
        registers.f38787c = objNewInstance;
        return iN;
    }

    static int o(Schema schema, int i3, byte[] bArr, int i4, int i5, Internal.ProtobufList protobufList, Registers registers) {
        int i6 = (i3 & (-8)) | 4;
        int iN = n(schema, bArr, i4, i5, i6, registers);
        protobufList.add(registers.f38787c);
        while (iN < i5) {
            int I = I(bArr, iN, registers);
            if (i3 != registers.f38785a) {
                break;
            }
            iN = n(schema, bArr, I, i5, i6, registers);
            protobufList.add(registers.f38787c);
        }
        return iN;
    }

    static int p(Schema schema, byte[] bArr, int i3, int i4, Registers registers) throws InvalidProtocolBufferException {
        Object objNewInstance = schema.newInstance();
        int iO = O(objNewInstance, schema, bArr, i3, i4, registers);
        schema.b(objNewInstance);
        registers.f38787c = objNewInstance;
        return iO;
    }

    static int q(Schema schema, int i3, byte[] bArr, int i4, int i5, Internal.ProtobufList protobufList, Registers registers) throws InvalidProtocolBufferException {
        int iP = p(schema, bArr, i4, i5, registers);
        protobufList.add(registers.f38787c);
        while (iP < i5) {
            int I = I(bArr, iP, registers);
            if (i3 != registers.f38785a) {
                break;
            }
            iP = p(schema, bArr, I, i5, registers);
            protobufList.add(registers.f38787c);
        }
        return iP;
    }

    static int r(byte[] bArr, int i3, Internal.ProtobufList protobufList, Registers registers) throws InvalidProtocolBufferException {
        BooleanArrayList booleanArrayList = (BooleanArrayList) protobufList;
        int I = I(bArr, i3, registers);
        int i4 = registers.f38785a + I;
        while (I < i4) {
            I = L(bArr, I, registers);
            booleanArrayList.f(registers.f38786b != 0);
        }
        if (I == i4) {
            return I;
        }
        throw InvalidProtocolBufferException.m();
    }

    static int s(byte[] bArr, int i3, Internal.ProtobufList protobufList, Registers registers) throws InvalidProtocolBufferException {
        DoubleArrayList doubleArrayList = (DoubleArrayList) protobufList;
        int I = I(bArr, i3, registers);
        int i4 = registers.f38785a + I;
        while (I < i4) {
            doubleArrayList.e(d(bArr, I));
            I += 8;
        }
        if (I == i4) {
            return I;
        }
        throw InvalidProtocolBufferException.m();
    }

    static int t(byte[] bArr, int i3, Internal.ProtobufList protobufList, Registers registers) throws InvalidProtocolBufferException {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int I = I(bArr, i3, registers);
        int i4 = registers.f38785a + I;
        while (I < i4) {
            intArrayList.e(h(bArr, I));
            I += 4;
        }
        if (I == i4) {
            return I;
        }
        throw InvalidProtocolBufferException.m();
    }

    static int u(byte[] bArr, int i3, Internal.ProtobufList protobufList, Registers registers) throws InvalidProtocolBufferException {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int I = I(bArr, i3, registers);
        int i4 = registers.f38785a + I;
        while (I < i4) {
            longArrayList.f(j(bArr, I));
            I += 8;
        }
        if (I == i4) {
            return I;
        }
        throw InvalidProtocolBufferException.m();
    }

    static int v(byte[] bArr, int i3, Internal.ProtobufList protobufList, Registers registers) throws InvalidProtocolBufferException {
        FloatArrayList floatArrayList = (FloatArrayList) protobufList;
        int I = I(bArr, i3, registers);
        int i4 = registers.f38785a + I;
        while (I < i4) {
            floatArrayList.e(l(bArr, I));
            I += 4;
        }
        if (I == i4) {
            return I;
        }
        throw InvalidProtocolBufferException.m();
    }

    static int w(byte[] bArr, int i3, Internal.ProtobufList protobufList, Registers registers) throws InvalidProtocolBufferException {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int I = I(bArr, i3, registers);
        int i4 = registers.f38785a + I;
        while (I < i4) {
            I = I(bArr, I, registers);
            intArrayList.e(CodedInputStream.b(registers.f38785a));
        }
        if (I == i4) {
            return I;
        }
        throw InvalidProtocolBufferException.m();
    }

    static int x(byte[] bArr, int i3, Internal.ProtobufList protobufList, Registers registers) throws InvalidProtocolBufferException {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int I = I(bArr, i3, registers);
        int i4 = registers.f38785a + I;
        while (I < i4) {
            I = L(bArr, I, registers);
            longArrayList.f(CodedInputStream.c(registers.f38786b));
        }
        if (I == i4) {
            return I;
        }
        throw InvalidProtocolBufferException.m();
    }

    static int y(byte[] bArr, int i3, Internal.ProtobufList protobufList, Registers registers) throws InvalidProtocolBufferException {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int I = I(bArr, i3, registers);
        int i4 = registers.f38785a + I;
        while (I < i4) {
            I = I(bArr, I, registers);
            intArrayList.e(registers.f38785a);
        }
        if (I == i4) {
            return I;
        }
        throw InvalidProtocolBufferException.m();
    }

    static int z(byte[] bArr, int i3, Internal.ProtobufList protobufList, Registers registers) throws InvalidProtocolBufferException {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int I = I(bArr, i3, registers);
        int i4 = registers.f38785a + I;
        while (I < i4) {
            I = L(bArr, I, registers);
            longArrayList.f(registers.f38786b);
        }
        if (I == i4) {
            return I;
        }
        throw InvalidProtocolBufferException.m();
    }
}
