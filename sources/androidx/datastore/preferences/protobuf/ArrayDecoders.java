package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.WireFormat;
import com.applovin.exoplayer2.common.base.Ascii;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
final class ArrayDecoders {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile int f35972a = 100;

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.ArrayDecoders$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f35973a;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f35973a = iArr;
            try {
                iArr[WireFormat.FieldType.f36688c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f35973a[WireFormat.FieldType.f36689d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f35973a[WireFormat.FieldType.f36690f.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f35973a[WireFormat.FieldType.f36691g.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f35973a[WireFormat.FieldType.f36692h.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f35973a[WireFormat.FieldType.f36700p.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f35973a[WireFormat.FieldType.f36693i.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f35973a[WireFormat.FieldType.f36703s.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f35973a[WireFormat.FieldType.f36694j.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f35973a[WireFormat.FieldType.f36702r.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f35973a[WireFormat.FieldType.f36695k.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f35973a[WireFormat.FieldType.f36704t.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f35973a[WireFormat.FieldType.f36705u.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f35973a[WireFormat.FieldType.f36701q.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f35973a[WireFormat.FieldType.f36699o.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f35973a[WireFormat.FieldType.f36696l.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f35973a[WireFormat.FieldType.f36697m.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f35973a[WireFormat.FieldType.f36698n.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Registers {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f35974a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f35975b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f35976c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ExtensionRegistryLite f35977d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f35978e;

        Registers(ExtensionRegistryLite extensionRegistryLite) {
            extensionRegistryLite.getClass();
            this.f35977d = extensionRegistryLite;
        }
    }

    static int A(byte[] bArr, int i3, Internal.ProtobufList protobufList, Registers registers) throws InvalidProtocolBufferException {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int iJ = J(bArr, i3, registers);
        int i4 = registers.f35974a + iJ;
        while (iJ < i4) {
            iJ = M(bArr, iJ, registers);
            longArrayList.f(registers.f35975b);
        }
        if (iJ == i4) {
            return iJ;
        }
        throw InvalidProtocolBufferException.m();
    }

    static int B(int i3, byte[] bArr, int i4, int i5, Internal.ProtobufList protobufList, Registers registers) {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int iJ = J(bArr, i4, registers);
        intArrayList.e(CodedInputStream.c(registers.f35974a));
        while (iJ < i5) {
            int iJ2 = J(bArr, iJ, registers);
            if (i3 != registers.f35974a) {
                break;
            }
            iJ = J(bArr, iJ2, registers);
            intArrayList.e(CodedInputStream.c(registers.f35974a));
        }
        return iJ;
    }

    static int C(int i3, byte[] bArr, int i4, int i5, Internal.ProtobufList protobufList, Registers registers) {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int iM = M(bArr, i4, registers);
        longArrayList.f(CodedInputStream.d(registers.f35975b));
        while (iM < i5) {
            int iJ = J(bArr, iM, registers);
            if (i3 != registers.f35974a) {
                break;
            }
            iM = M(bArr, iJ, registers);
            longArrayList.f(CodedInputStream.d(registers.f35975b));
        }
        return iM;
    }

    static int D(byte[] bArr, int i3, Registers registers) throws InvalidProtocolBufferException {
        int iJ = J(bArr, i3, registers);
        int i4 = registers.f35974a;
        if (i4 < 0) {
            throw InvalidProtocolBufferException.g();
        }
        if (i4 == 0) {
            registers.f35976c = "";
            return iJ;
        }
        registers.f35976c = new String(bArr, iJ, i4, Internal.f36424b);
        return iJ + i4;
    }

    static int E(int i3, byte[] bArr, int i4, int i5, Internal.ProtobufList protobufList, Registers registers) throws InvalidProtocolBufferException {
        int iJ = J(bArr, i4, registers);
        int i6 = registers.f35974a;
        if (i6 < 0) {
            throw InvalidProtocolBufferException.g();
        }
        if (i6 == 0) {
            protobufList.add("");
        } else {
            protobufList.add(new String(bArr, iJ, i6, Internal.f36424b));
            iJ += i6;
        }
        while (iJ < i5) {
            int iJ2 = J(bArr, iJ, registers);
            if (i3 != registers.f35974a) {
                break;
            }
            iJ = J(bArr, iJ2, registers);
            int i7 = registers.f35974a;
            if (i7 < 0) {
                throw InvalidProtocolBufferException.g();
            }
            if (i7 == 0) {
                protobufList.add("");
            } else {
                protobufList.add(new String(bArr, iJ, i7, Internal.f36424b));
                iJ += i7;
            }
        }
        return iJ;
    }

    static int F(int i3, byte[] bArr, int i4, int i5, Internal.ProtobufList protobufList, Registers registers) throws InvalidProtocolBufferException {
        int iJ = J(bArr, i4, registers);
        int i6 = registers.f35974a;
        if (i6 < 0) {
            throw InvalidProtocolBufferException.g();
        }
        if (i6 == 0) {
            protobufList.add("");
        } else {
            int i7 = iJ + i6;
            if (!Utf8.u(bArr, iJ, i7)) {
                throw InvalidProtocolBufferException.d();
            }
            protobufList.add(new String(bArr, iJ, i6, Internal.f36424b));
            iJ = i7;
        }
        while (iJ < i5) {
            int iJ2 = J(bArr, iJ, registers);
            if (i3 != registers.f35974a) {
                break;
            }
            iJ = J(bArr, iJ2, registers);
            int i8 = registers.f35974a;
            if (i8 < 0) {
                throw InvalidProtocolBufferException.g();
            }
            if (i8 == 0) {
                protobufList.add("");
            } else {
                int i9 = iJ + i8;
                if (!Utf8.u(bArr, iJ, i9)) {
                    throw InvalidProtocolBufferException.d();
                }
                protobufList.add(new String(bArr, iJ, i8, Internal.f36424b));
                iJ = i9;
            }
        }
        return iJ;
    }

    static int G(byte[] bArr, int i3, Registers registers) throws InvalidProtocolBufferException {
        int iJ = J(bArr, i3, registers);
        int i4 = registers.f35974a;
        if (i4 < 0) {
            throw InvalidProtocolBufferException.g();
        }
        if (i4 == 0) {
            registers.f35976c = "";
            return iJ;
        }
        registers.f35976c = Utf8.h(bArr, iJ, i4);
        return iJ + i4;
    }

    static int H(int i3, byte[] bArr, int i4, int i5, UnknownFieldSetLite unknownFieldSetLite, Registers registers) throws InvalidProtocolBufferException {
        if (WireFormat.a(i3) == 0) {
            throw InvalidProtocolBufferException.c();
        }
        int iB = WireFormat.b(i3);
        if (iB == 0) {
            int iM = M(bArr, i4, registers);
            unknownFieldSetLite.n(i3, Long.valueOf(registers.f35975b));
            return iM;
        }
        if (iB == 1) {
            unknownFieldSetLite.n(i3, Long.valueOf(k(bArr, i4)));
            return i4 + 8;
        }
        if (iB == 2) {
            int iJ = J(bArr, i4, registers);
            int i6 = registers.f35974a;
            if (i6 < 0) {
                throw InvalidProtocolBufferException.g();
            }
            if (i6 > bArr.length - iJ) {
                throw InvalidProtocolBufferException.m();
            }
            if (i6 == 0) {
                unknownFieldSetLite.n(i3, ByteString.f36020b);
            } else {
                unknownFieldSetLite.n(i3, ByteString.q(bArr, iJ, i6));
            }
            return iJ + i6;
        }
        if (iB != 3) {
            if (iB != 5) {
                throw InvalidProtocolBufferException.c();
            }
            unknownFieldSetLite.n(i3, Integer.valueOf(i(bArr, i4)));
            return i4 + 4;
        }
        UnknownFieldSetLite unknownFieldSetLiteK = UnknownFieldSetLite.k();
        int i7 = (i3 & (-8)) | 4;
        int i8 = registers.f35978e + 1;
        registers.f35978e = i8;
        a(i8);
        int i9 = 0;
        while (true) {
            if (i4 >= i5) {
                break;
            }
            int iJ2 = J(bArr, i4, registers);
            i9 = registers.f35974a;
            if (i9 == i7) {
                i4 = iJ2;
                break;
            }
            i4 = H(i9, bArr, iJ2, i5, unknownFieldSetLiteK, registers);
        }
        registers.f35978e--;
        if (i4 > i5 || i9 != i7) {
            throw InvalidProtocolBufferException.h();
        }
        unknownFieldSetLite.n(i3, unknownFieldSetLiteK);
        return i4;
    }

    static int I(int i3, byte[] bArr, int i4, Registers registers) {
        int i5 = i3 & 127;
        int i6 = i4 + 1;
        byte b3 = bArr[i4];
        if (b3 >= 0) {
            registers.f35974a = i5 | (b3 << 7);
            return i6;
        }
        int i7 = i5 | ((b3 & Ascii.DEL) << 7);
        int i8 = i4 + 2;
        byte b4 = bArr[i6];
        if (b4 >= 0) {
            registers.f35974a = i7 | (b4 << Ascii.SO);
            return i8;
        }
        int i9 = i7 | ((b4 & Ascii.DEL) << 14);
        int i10 = i4 + 3;
        byte b5 = bArr[i8];
        if (b5 >= 0) {
            registers.f35974a = i9 | (b5 << Ascii.NAK);
            return i10;
        }
        int i11 = i9 | ((b5 & Ascii.DEL) << 21);
        int i12 = i4 + 4;
        byte b6 = bArr[i10];
        if (b6 >= 0) {
            registers.f35974a = i11 | (b6 << Ascii.FS);
            return i12;
        }
        int i13 = i11 | ((b6 & Ascii.DEL) << 28);
        while (true) {
            int i14 = i12 + 1;
            if (bArr[i12] >= 0) {
                registers.f35974a = i13;
                return i14;
            }
            i12 = i14;
        }
    }

    static int J(byte[] bArr, int i3, Registers registers) {
        int i4 = i3 + 1;
        byte b3 = bArr[i3];
        if (b3 < 0) {
            return I(b3, bArr, i4, registers);
        }
        registers.f35974a = b3;
        return i4;
    }

    static int K(int i3, byte[] bArr, int i4, int i5, Internal.ProtobufList protobufList, Registers registers) {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int iJ = J(bArr, i4, registers);
        intArrayList.e(registers.f35974a);
        while (iJ < i5) {
            int iJ2 = J(bArr, iJ, registers);
            if (i3 != registers.f35974a) {
                break;
            }
            iJ = J(bArr, iJ2, registers);
            intArrayList.e(registers.f35974a);
        }
        return iJ;
    }

    static int L(long j3, byte[] bArr, int i3, Registers registers) {
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
        registers.f35975b = j4;
        return i4;
    }

    static int M(byte[] bArr, int i3, Registers registers) {
        int i4 = i3 + 1;
        long j3 = bArr[i3];
        if (j3 < 0) {
            return L(j3, bArr, i4, registers);
        }
        registers.f35975b = j3;
        return i4;
    }

    static int N(int i3, byte[] bArr, int i4, int i5, Internal.ProtobufList protobufList, Registers registers) {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int iM = M(bArr, i4, registers);
        longArrayList.f(registers.f35975b);
        while (iM < i5) {
            int iJ = J(bArr, iM, registers);
            if (i3 != registers.f35974a) {
                break;
            }
            iM = M(bArr, iJ, registers);
            longArrayList.f(registers.f35975b);
        }
        return iM;
    }

    static int O(Object obj, Schema schema, byte[] bArr, int i3, int i4, int i5, Registers registers) throws InvalidProtocolBufferException {
        int i6 = registers.f35978e + 1;
        registers.f35978e = i6;
        a(i6);
        int iD0 = ((MessageSchema) schema).d0(obj, bArr, i3, i4, i5, registers);
        registers.f35978e--;
        registers.f35976c = obj;
        return iD0;
    }

    static int P(Object obj, Schema schema, byte[] bArr, int i3, int i4, Registers registers) throws InvalidProtocolBufferException {
        int I = i3 + 1;
        int i5 = bArr[i3];
        if (i5 < 0) {
            I = I(i5, bArr, I, registers);
            i5 = registers.f35974a;
        }
        int i6 = I;
        if (i5 < 0 || i5 > i4 - i6) {
            throw InvalidProtocolBufferException.m();
        }
        int i7 = registers.f35978e + 1;
        registers.f35978e = i7;
        a(i7);
        int i8 = i6 + i5;
        schema.i(obj, bArr, i6, i8, registers);
        registers.f35978e--;
        registers.f35976c = obj;
        return i8;
    }

    static int Q(int i3, byte[] bArr, int i4, int i5, Registers registers) throws InvalidProtocolBufferException {
        if (WireFormat.a(i3) == 0) {
            throw InvalidProtocolBufferException.c();
        }
        int iB = WireFormat.b(i3);
        if (iB == 0) {
            return M(bArr, i4, registers);
        }
        if (iB == 1) {
            return i4 + 8;
        }
        if (iB == 2) {
            return J(bArr, i4, registers) + registers.f35974a;
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
            i4 = J(bArr, i4, registers);
            i7 = registers.f35974a;
            if (i7 == i6) {
                break;
            }
            i4 = Q(i7, bArr, i4, i5, registers);
        }
        if (i4 > i5 || i7 != i6) {
            throw InvalidProtocolBufferException.h();
        }
        return i4;
    }

    private static void a(int i3) throws InvalidProtocolBufferException {
        if (i3 >= f35972a) {
            throw InvalidProtocolBufferException.i();
        }
    }

    static int b(int i3, byte[] bArr, int i4, int i5, Internal.ProtobufList protobufList, Registers registers) {
        BooleanArrayList booleanArrayList = (BooleanArrayList) protobufList;
        int iM = M(bArr, i4, registers);
        booleanArrayList.f(registers.f35975b != 0);
        while (iM < i5) {
            int iJ = J(bArr, iM, registers);
            if (i3 != registers.f35974a) {
                break;
            }
            iM = M(bArr, iJ, registers);
            booleanArrayList.f(registers.f35975b != 0);
        }
        return iM;
    }

    static int c(byte[] bArr, int i3, Registers registers) throws InvalidProtocolBufferException {
        int iJ = J(bArr, i3, registers);
        int i4 = registers.f35974a;
        if (i4 < 0) {
            throw InvalidProtocolBufferException.g();
        }
        if (i4 > bArr.length - iJ) {
            throw InvalidProtocolBufferException.m();
        }
        if (i4 == 0) {
            registers.f35976c = ByteString.f36020b;
            return iJ;
        }
        registers.f35976c = ByteString.q(bArr, iJ, i4);
        return iJ + i4;
    }

    static int d(int i3, byte[] bArr, int i4, int i5, Internal.ProtobufList protobufList, Registers registers) throws InvalidProtocolBufferException {
        int iJ = J(bArr, i4, registers);
        int i6 = registers.f35974a;
        if (i6 < 0) {
            throw InvalidProtocolBufferException.g();
        }
        if (i6 > bArr.length - iJ) {
            throw InvalidProtocolBufferException.m();
        }
        if (i6 == 0) {
            protobufList.add(ByteString.f36020b);
        } else {
            protobufList.add(ByteString.q(bArr, iJ, i6));
            iJ += i6;
        }
        while (iJ < i5) {
            int iJ2 = J(bArr, iJ, registers);
            if (i3 != registers.f35974a) {
                break;
            }
            iJ = J(bArr, iJ2, registers);
            int i7 = registers.f35974a;
            if (i7 < 0) {
                throw InvalidProtocolBufferException.g();
            }
            if (i7 > bArr.length - iJ) {
                throw InvalidProtocolBufferException.m();
            }
            if (i7 == 0) {
                protobufList.add(ByteString.f36020b);
            } else {
                protobufList.add(ByteString.q(bArr, iJ, i7));
                iJ += i7;
            }
        }
        return iJ;
    }

    static double e(byte[] bArr, int i3) {
        return Double.longBitsToDouble(k(bArr, i3));
    }

    static int f(int i3, byte[] bArr, int i4, int i5, Internal.ProtobufList protobufList, Registers registers) {
        DoubleArrayList doubleArrayList = (DoubleArrayList) protobufList;
        doubleArrayList.e(e(bArr, i4));
        int i6 = i4 + 8;
        while (i6 < i5) {
            int iJ = J(bArr, i6, registers);
            if (i3 != registers.f35974a) {
                break;
            }
            doubleArrayList.e(e(bArr, iJ));
            i6 = iJ + 8;
        }
        return i6;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    static int g(int i3, byte[] bArr, int i4, int i5, GeneratedMessageLite.ExtendableMessage extendableMessage, GeneratedMessageLite.GeneratedExtension generatedExtension, UnknownFieldSchema unknownFieldSchema, Registers registers) throws InvalidProtocolBufferException {
        int i6;
        int i7;
        FieldSet<GeneratedMessageLite.ExtensionDescriptor> fieldSet = extendableMessage.extensions;
        int i8 = i3 >>> 3;
        if (generatedExtension.f36406d.K() && generatedExtension.f36406d.N()) {
            switch (AnonymousClass1.f35973a[generatedExtension.a().ordinal()]) {
                case 1:
                    DoubleArrayList doubleArrayList = new DoubleArrayList();
                    int iT = t(bArr, i4, doubleArrayList, registers);
                    fieldSet.y(generatedExtension.f36406d, doubleArrayList);
                    return iT;
                case 2:
                    FloatArrayList floatArrayList = new FloatArrayList();
                    int iW = w(bArr, i4, floatArrayList, registers);
                    fieldSet.y(generatedExtension.f36406d, floatArrayList);
                    return iW;
                case 3:
                case 4:
                    LongArrayList longArrayList = new LongArrayList();
                    int iA = A(bArr, i4, longArrayList, registers);
                    fieldSet.y(generatedExtension.f36406d, longArrayList);
                    return iA;
                case 5:
                case 6:
                    IntArrayList intArrayList = new IntArrayList();
                    int iZ = z(bArr, i4, intArrayList, registers);
                    fieldSet.y(generatedExtension.f36406d, intArrayList);
                    return iZ;
                case 7:
                case 8:
                    LongArrayList longArrayList2 = new LongArrayList();
                    int iV = v(bArr, i4, longArrayList2, registers);
                    fieldSet.y(generatedExtension.f36406d, longArrayList2);
                    return iV;
                case 9:
                case 10:
                    IntArrayList intArrayList2 = new IntArrayList();
                    int iU = u(bArr, i4, intArrayList2, registers);
                    fieldSet.y(generatedExtension.f36406d, intArrayList2);
                    return iU;
                case 11:
                    BooleanArrayList booleanArrayList = new BooleanArrayList();
                    int iS = s(bArr, i4, booleanArrayList, registers);
                    fieldSet.y(generatedExtension.f36406d, booleanArrayList);
                    return iS;
                case 12:
                    IntArrayList intArrayList3 = new IntArrayList();
                    int iX = x(bArr, i4, intArrayList3, registers);
                    fieldSet.y(generatedExtension.f36406d, intArrayList3);
                    return iX;
                case 13:
                    LongArrayList longArrayList3 = new LongArrayList();
                    int iY = y(bArr, i4, longArrayList3, registers);
                    fieldSet.y(generatedExtension.f36406d, longArrayList3);
                    return iY;
                case 14:
                    IntArrayList intArrayList4 = new IntArrayList();
                    int iZ2 = z(bArr, i4, intArrayList4, registers);
                    SchemaUtil.z(extendableMessage, i8, intArrayList4, generatedExtension.f36406d.b(), null, unknownFieldSchema);
                    fieldSet.y(generatedExtension.f36406d, intArrayList4);
                    return iZ2;
                default:
                    throw new IllegalStateException("Type cannot be packed: " + generatedExtension.f36406d.L());
            }
        }
        Object objValueOf = null;
        if (generatedExtension.a() == WireFormat.FieldType.f36701q) {
            i4 = J(bArr, i4, registers);
            if (generatedExtension.f36406d.b().a(registers.f35974a) == null) {
                SchemaUtil.J(extendableMessage, i8, registers.f35974a, null, unknownFieldSchema);
                return i4;
            }
            objValueOf = Integer.valueOf(registers.f35974a);
        } else {
            switch (AnonymousClass1.f35973a[generatedExtension.a().ordinal()]) {
                case 1:
                    i6 = i4;
                    objValueOf = Double.valueOf(e(bArr, i6));
                    i4 = i6 + 8;
                    break;
                case 2:
                    i7 = i4;
                    objValueOf = Float.valueOf(m(bArr, i7));
                    i4 = i7 + 4;
                    break;
                case 3:
                case 4:
                    i4 = M(bArr, i4, registers);
                    objValueOf = Long.valueOf(registers.f35975b);
                    break;
                case 5:
                case 6:
                    i4 = J(bArr, i4, registers);
                    objValueOf = Integer.valueOf(registers.f35974a);
                    break;
                case 7:
                case 8:
                    i6 = i4;
                    objValueOf = Long.valueOf(k(bArr, i6));
                    i4 = i6 + 8;
                    break;
                case 9:
                case 10:
                    i7 = i4;
                    objValueOf = Integer.valueOf(i(bArr, i7));
                    i4 = i7 + 4;
                    break;
                case 11:
                    i4 = M(bArr, i4, registers);
                    objValueOf = Boolean.valueOf(registers.f35975b != 0);
                    break;
                case 12:
                    i4 = J(bArr, i4, registers);
                    objValueOf = Integer.valueOf(CodedInputStream.c(registers.f35974a));
                    break;
                case 13:
                    i4 = M(bArr, i4, registers);
                    objValueOf = Long.valueOf(CodedInputStream.d(registers.f35975b));
                    break;
                case 14:
                    throw new IllegalStateException("Shouldn't reach here.");
                case 15:
                    i4 = c(bArr, i4, registers);
                    objValueOf = registers.f35976c;
                    break;
                case 16:
                    i4 = D(bArr, i4, registers);
                    objValueOf = registers.f35976c;
                    break;
                case 17:
                    int i9 = (i8 << 3) | 4;
                    Schema schemaC = Protobuf.a().c(generatedExtension.b().getClass());
                    if (generatedExtension.d()) {
                        int iO = o(schemaC, bArr, i4, i5, i9, registers);
                        fieldSet.a(generatedExtension.f36406d, registers.f35976c);
                        return iO;
                    }
                    Object objI = fieldSet.i(generatedExtension.f36406d);
                    if (objI == null) {
                        objI = schemaC.newInstance();
                        fieldSet.y(generatedExtension.f36406d, objI);
                    }
                    return O(objI, schemaC, bArr, i4, i5, i9, registers);
                case 18:
                    Schema schemaC2 = Protobuf.a().c(generatedExtension.b().getClass());
                    if (generatedExtension.d()) {
                        int iQ = q(schemaC2, bArr, i4, i5, registers);
                        fieldSet.a(generatedExtension.f36406d, registers.f35976c);
                        return iQ;
                    }
                    Object objI2 = fieldSet.i(generatedExtension.f36406d);
                    if (objI2 == null) {
                        objI2 = schemaC2.newInstance();
                        fieldSet.y(generatedExtension.f36406d, objI2);
                    }
                    return P(objI2, schemaC2, bArr, i4, i5, registers);
            }
        }
        if (generatedExtension.d()) {
            fieldSet.a(generatedExtension.f36406d, objValueOf);
            return i4;
        }
        fieldSet.y(generatedExtension.f36406d, objValueOf);
        return i4;
    }

    static int h(int i3, byte[] bArr, int i4, int i5, Object obj, MessageLite messageLite, UnknownFieldSchema unknownFieldSchema, Registers registers) {
        GeneratedMessageLite.GeneratedExtension generatedExtensionA = registers.f35977d.a(messageLite, i3 >>> 3);
        if (generatedExtensionA == null) {
            return H(i3, bArr, i4, i5, MessageSchema.w(obj), registers);
        }
        GeneratedMessageLite.ExtendableMessage extendableMessage = (GeneratedMessageLite.ExtendableMessage) obj;
        extendableMessage.W();
        return g(i3, bArr, i4, i5, extendableMessage, generatedExtensionA, unknownFieldSchema, registers);
    }

    static int i(byte[] bArr, int i3) {
        return ((bArr[i3 + 3] & 255) << 24) | (bArr[i3] & 255) | ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3 + 2] & 255) << 16);
    }

    static int j(int i3, byte[] bArr, int i4, int i5, Internal.ProtobufList protobufList, Registers registers) {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        intArrayList.e(i(bArr, i4));
        int i6 = i4 + 4;
        while (i6 < i5) {
            int iJ = J(bArr, i6, registers);
            if (i3 != registers.f35974a) {
                break;
            }
            intArrayList.e(i(bArr, iJ));
            i6 = iJ + 4;
        }
        return i6;
    }

    static long k(byte[] bArr, int i3) {
        return ((((long) bArr[i3 + 7]) & 255) << 56) | (((long) bArr[i3]) & 255) | ((((long) bArr[i3 + 1]) & 255) << 8) | ((((long) bArr[i3 + 2]) & 255) << 16) | ((((long) bArr[i3 + 3]) & 255) << 24) | ((((long) bArr[i3 + 4]) & 255) << 32) | ((((long) bArr[i3 + 5]) & 255) << 40) | ((((long) bArr[i3 + 6]) & 255) << 48);
    }

    static int l(int i3, byte[] bArr, int i4, int i5, Internal.ProtobufList protobufList, Registers registers) {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        longArrayList.f(k(bArr, i4));
        int i6 = i4 + 8;
        while (i6 < i5) {
            int iJ = J(bArr, i6, registers);
            if (i3 != registers.f35974a) {
                break;
            }
            longArrayList.f(k(bArr, iJ));
            i6 = iJ + 8;
        }
        return i6;
    }

    static float m(byte[] bArr, int i3) {
        return Float.intBitsToFloat(i(bArr, i3));
    }

    static int n(int i3, byte[] bArr, int i4, int i5, Internal.ProtobufList protobufList, Registers registers) {
        FloatArrayList floatArrayList = (FloatArrayList) protobufList;
        floatArrayList.e(m(bArr, i4));
        int i6 = i4 + 4;
        while (i6 < i5) {
            int iJ = J(bArr, i6, registers);
            if (i3 != registers.f35974a) {
                break;
            }
            floatArrayList.e(m(bArr, iJ));
            i6 = iJ + 4;
        }
        return i6;
    }

    static int o(Schema schema, byte[] bArr, int i3, int i4, int i5, Registers registers) throws InvalidProtocolBufferException {
        Object objNewInstance = schema.newInstance();
        int iO = O(objNewInstance, schema, bArr, i3, i4, i5, registers);
        schema.b(objNewInstance);
        registers.f35976c = objNewInstance;
        return iO;
    }

    static int p(Schema schema, int i3, byte[] bArr, int i4, int i5, Internal.ProtobufList protobufList, Registers registers) throws InvalidProtocolBufferException {
        int i6 = (i3 & (-8)) | 4;
        int iO = o(schema, bArr, i4, i5, i6, registers);
        protobufList.add(registers.f35976c);
        while (iO < i5) {
            int iJ = J(bArr, iO, registers);
            if (i3 != registers.f35974a) {
                break;
            }
            iO = o(schema, bArr, iJ, i5, i6, registers);
            protobufList.add(registers.f35976c);
        }
        return iO;
    }

    static int q(Schema schema, byte[] bArr, int i3, int i4, Registers registers) throws InvalidProtocolBufferException {
        Object objNewInstance = schema.newInstance();
        int iP = P(objNewInstance, schema, bArr, i3, i4, registers);
        schema.b(objNewInstance);
        registers.f35976c = objNewInstance;
        return iP;
    }

    static int r(Schema schema, int i3, byte[] bArr, int i4, int i5, Internal.ProtobufList protobufList, Registers registers) throws InvalidProtocolBufferException {
        int iQ = q(schema, bArr, i4, i5, registers);
        protobufList.add(registers.f35976c);
        while (iQ < i5) {
            int iJ = J(bArr, iQ, registers);
            if (i3 != registers.f35974a) {
                break;
            }
            iQ = q(schema, bArr, iJ, i5, registers);
            protobufList.add(registers.f35976c);
        }
        return iQ;
    }

    static int s(byte[] bArr, int i3, Internal.ProtobufList protobufList, Registers registers) throws InvalidProtocolBufferException {
        BooleanArrayList booleanArrayList = (BooleanArrayList) protobufList;
        int iJ = J(bArr, i3, registers);
        int i4 = registers.f35974a + iJ;
        while (iJ < i4) {
            iJ = M(bArr, iJ, registers);
            booleanArrayList.f(registers.f35975b != 0);
        }
        if (iJ == i4) {
            return iJ;
        }
        throw InvalidProtocolBufferException.m();
    }

    static int t(byte[] bArr, int i3, Internal.ProtobufList protobufList, Registers registers) throws InvalidProtocolBufferException {
        DoubleArrayList doubleArrayList = (DoubleArrayList) protobufList;
        int iJ = J(bArr, i3, registers);
        int i4 = registers.f35974a + iJ;
        while (iJ < i4) {
            doubleArrayList.e(e(bArr, iJ));
            iJ += 8;
        }
        if (iJ == i4) {
            return iJ;
        }
        throw InvalidProtocolBufferException.m();
    }

    static int u(byte[] bArr, int i3, Internal.ProtobufList protobufList, Registers registers) throws InvalidProtocolBufferException {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int iJ = J(bArr, i3, registers);
        int i4 = registers.f35974a + iJ;
        while (iJ < i4) {
            intArrayList.e(i(bArr, iJ));
            iJ += 4;
        }
        if (iJ == i4) {
            return iJ;
        }
        throw InvalidProtocolBufferException.m();
    }

    static int v(byte[] bArr, int i3, Internal.ProtobufList protobufList, Registers registers) throws InvalidProtocolBufferException {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int iJ = J(bArr, i3, registers);
        int i4 = registers.f35974a + iJ;
        while (iJ < i4) {
            longArrayList.f(k(bArr, iJ));
            iJ += 8;
        }
        if (iJ == i4) {
            return iJ;
        }
        throw InvalidProtocolBufferException.m();
    }

    static int w(byte[] bArr, int i3, Internal.ProtobufList protobufList, Registers registers) throws InvalidProtocolBufferException {
        FloatArrayList floatArrayList = (FloatArrayList) protobufList;
        int iJ = J(bArr, i3, registers);
        int i4 = registers.f35974a + iJ;
        while (iJ < i4) {
            floatArrayList.e(m(bArr, iJ));
            iJ += 4;
        }
        if (iJ == i4) {
            return iJ;
        }
        throw InvalidProtocolBufferException.m();
    }

    static int x(byte[] bArr, int i3, Internal.ProtobufList protobufList, Registers registers) throws InvalidProtocolBufferException {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int iJ = J(bArr, i3, registers);
        int i4 = registers.f35974a + iJ;
        while (iJ < i4) {
            iJ = J(bArr, iJ, registers);
            intArrayList.e(CodedInputStream.c(registers.f35974a));
        }
        if (iJ == i4) {
            return iJ;
        }
        throw InvalidProtocolBufferException.m();
    }

    static int y(byte[] bArr, int i3, Internal.ProtobufList protobufList, Registers registers) throws InvalidProtocolBufferException {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int iJ = J(bArr, i3, registers);
        int i4 = registers.f35974a + iJ;
        while (iJ < i4) {
            iJ = M(bArr, iJ, registers);
            longArrayList.f(CodedInputStream.d(registers.f35975b));
        }
        if (iJ == i4) {
            return iJ;
        }
        throw InvalidProtocolBufferException.m();
    }

    static int z(byte[] bArr, int i3, Internal.ProtobufList protobufList, Registers registers) throws InvalidProtocolBufferException {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int iJ = J(bArr, i3, registers);
        int i4 = registers.f35974a + iJ;
        while (iJ < i4) {
            iJ = J(bArr, iJ, registers);
            intArrayList.e(registers.f35974a);
        }
        if (iJ == i4) {
            return iJ;
        }
        throw InvalidProtocolBufferException.m();
    }
}
