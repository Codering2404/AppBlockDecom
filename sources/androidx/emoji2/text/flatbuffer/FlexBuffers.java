package androidx.emoji2.text.flatbuffer;

import com.google.android.gms.ads_identifier.mrU.pMpIcGE;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class FlexBuffers {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ReadBuf f36959a = new ArrayReadWriteBuf(new byte[]{0}, 1);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Blob extends Sized {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        static final Blob f36960e = new Blob(FlexBuffers.f36959a, 1, 1);

        Blob(ReadBuf readBuf, int i3, int i4) {
            super(readBuf, i3, i4);
        }

        public static Blob c() {
            return f36960e;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public StringBuilder a(StringBuilder sb) {
            sb.append('\"');
            sb.append(this.f36964a.a(this.f36965b, b()));
            sb.append('\"');
            return sb;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Sized
        public /* bridge */ /* synthetic */ int b() {
            return super.b();
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public String toString() {
            return this.f36964a.a(this.f36965b, b());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class FlexBufferException extends RuntimeException {
        FlexBufferException(String str) {
            super(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Key extends Object {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final Key f36961d = new Key(FlexBuffers.f36959a, 0, 0);

        Key(ReadBuf readBuf, int i3, int i4) {
            super(readBuf, i3, i4);
        }

        public static Key c() {
            return f36961d;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public StringBuilder a(StringBuilder sb) {
            sb.append(toString());
            return sb;
        }

        public boolean equals(java.lang.Object obj) {
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            return key.f36965b == this.f36965b && key.f36966c == this.f36966c;
        }

        public int hashCode() {
            return this.f36965b ^ this.f36966c;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public String toString() {
            int i3 = this.f36965b;
            while (this.f36964a.get(i3) != 0) {
                i3++;
            }
            int i4 = this.f36965b;
            return this.f36964a.a(i4, i3 - i4);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class KeyVector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TypedVector f36962a;

        KeyVector(TypedVector typedVector) {
            this.f36962a = typedVector;
        }

        public Key a(int i3) {
            if (i3 >= b()) {
                return Key.f36961d;
            }
            TypedVector typedVector = this.f36962a;
            int i4 = typedVector.f36965b + (i3 * typedVector.f36966c);
            TypedVector typedVector2 = this.f36962a;
            ReadBuf readBuf = typedVector2.f36964a;
            return new Key(readBuf, FlexBuffers.g(readBuf, i4, typedVector2.f36966c), 1);
        }

        public int b() {
            return this.f36962a.b();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (int i3 = 0; i3 < this.f36962a.b(); i3++) {
                this.f36962a.d(i3).q(sb);
                if (i3 != this.f36962a.b() - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            return sb.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Map extends Vector {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final Map f36963f = new Map(FlexBuffers.f36959a, 1, 1);

        Map(ReadBuf readBuf, int i3, int i4) {
            super(readBuf, i3, i4);
        }

        public static Map e() {
            return f36963f;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Vector, androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public StringBuilder a(StringBuilder sb) {
            sb.append("{ ");
            KeyVector keyVectorF = f();
            int iB = b();
            Vector vectorG = g();
            for (int i3 = 0; i3 < iB; i3++) {
                sb.append('\"');
                sb.append(keyVectorF.a(i3).toString());
                sb.append("\" : ");
                sb.append(vectorG.d(i3).toString());
                if (i3 != iB - 1) {
                    sb.append(", ");
                }
            }
            sb.append(" }");
            return sb;
        }

        public KeyVector f() {
            int i3 = this.f36965b - (this.f36966c * 3);
            ReadBuf readBuf = this.f36964a;
            int iG = FlexBuffers.g(readBuf, i3, this.f36966c);
            ReadBuf readBuf2 = this.f36964a;
            int i4 = this.f36966c;
            return new KeyVector(new TypedVector(readBuf, iG, FlexBuffers.j(readBuf2, i3 + i4, i4), 4));
        }

        public Vector g() {
            return new Vector(this.f36964a, this.f36965b, this.f36966c);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static abstract class Object {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ReadBuf f36964a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f36965b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f36966c;

        Object(ReadBuf readBuf, int i3, int i4) {
            this.f36964a = readBuf;
            this.f36965b = i3;
            this.f36966c = i4;
        }

        public abstract StringBuilder a(StringBuilder sb);

        public String toString() {
            return a(new StringBuilder(ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD)).toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes2.dex */
    public static class Reference {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final Reference f36967f = new Reference(FlexBuffers.f36959a, 0, 1, 0);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ReadBuf f36968a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f36969b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f36970c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f36971d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f36972e;

        Reference(ReadBuf readBuf, int i3, int i4, int i5) {
            this(readBuf, i3, i4, 1 << (i5 & 3), i5 >> 2);
        }

        public Blob b() {
            if (!k() && !o()) {
                return Blob.c();
            }
            ReadBuf readBuf = this.f36968a;
            return new Blob(readBuf, FlexBuffers.g(readBuf, this.f36969b, this.f36970c), this.f36971d);
        }

        public boolean c() {
            return l() ? this.f36968a.get(this.f36969b) != 0 : i() != 0;
        }

        public double d() {
            int i3 = this.f36972e;
            if (i3 == 3) {
                return FlexBuffers.i(this.f36968a, this.f36969b, this.f36970c);
            }
            if (i3 == 1) {
                return FlexBuffers.j(this.f36968a, this.f36969b, this.f36970c);
            }
            if (i3 != 2) {
                if (i3 == 5) {
                    return Double.parseDouble(h());
                }
                if (i3 == 6) {
                    ReadBuf readBuf = this.f36968a;
                    return FlexBuffers.j(readBuf, FlexBuffers.g(readBuf, this.f36969b, this.f36970c), this.f36971d);
                }
                if (i3 == 7) {
                    ReadBuf readBuf2 = this.f36968a;
                    return FlexBuffers.l(readBuf2, FlexBuffers.g(readBuf2, this.f36969b, this.f36970c), this.f36971d);
                }
                if (i3 == 8) {
                    ReadBuf readBuf3 = this.f36968a;
                    return FlexBuffers.i(readBuf3, FlexBuffers.g(readBuf3, this.f36969b, this.f36970c), this.f36971d);
                }
                if (i3 == 10) {
                    return j().b();
                }
                if (i3 != 26) {
                    return 0.0d;
                }
            }
            return FlexBuffers.l(this.f36968a, this.f36969b, this.f36970c);
        }

        public Key e() {
            if (!m()) {
                return Key.c();
            }
            ReadBuf readBuf = this.f36968a;
            return new Key(readBuf, FlexBuffers.g(readBuf, this.f36969b, this.f36970c), this.f36971d);
        }

        public long f() {
            int i3 = this.f36972e;
            if (i3 == 1) {
                return FlexBuffers.k(this.f36968a, this.f36969b, this.f36970c);
            }
            if (i3 == 2) {
                return FlexBuffers.l(this.f36968a, this.f36969b, this.f36970c);
            }
            if (i3 == 3) {
                return (long) FlexBuffers.i(this.f36968a, this.f36969b, this.f36970c);
            }
            if (i3 == 5) {
                try {
                    return Long.parseLong(h());
                } catch (NumberFormatException unused) {
                    return 0L;
                }
            }
            if (i3 == 6) {
                ReadBuf readBuf = this.f36968a;
                return FlexBuffers.k(readBuf, FlexBuffers.g(readBuf, this.f36969b, this.f36970c), this.f36971d);
            }
            if (i3 == 7) {
                ReadBuf readBuf2 = this.f36968a;
                return FlexBuffers.l(readBuf2, FlexBuffers.g(readBuf2, this.f36969b, this.f36970c), this.f36970c);
            }
            if (i3 == 8) {
                ReadBuf readBuf3 = this.f36968a;
                return (long) FlexBuffers.i(readBuf3, FlexBuffers.g(readBuf3, this.f36969b, this.f36970c), this.f36971d);
            }
            if (i3 == 10) {
                return j().b();
            }
            if (i3 != 26) {
                return 0L;
            }
            return FlexBuffers.j(this.f36968a, this.f36969b, this.f36970c);
        }

        public Map g() {
            if (!n()) {
                return Map.e();
            }
            ReadBuf readBuf = this.f36968a;
            return new Map(readBuf, FlexBuffers.g(readBuf, this.f36969b, this.f36970c), this.f36971d);
        }

        public String h() {
            if (o()) {
                int iG = FlexBuffers.g(this.f36968a, this.f36969b, this.f36970c);
                ReadBuf readBuf = this.f36968a;
                int i3 = this.f36971d;
                return this.f36968a.a(iG, (int) FlexBuffers.l(readBuf, iG - i3, i3));
            }
            if (!m()) {
                return "";
            }
            int iG2 = FlexBuffers.g(this.f36968a, this.f36969b, this.f36971d);
            int i4 = iG2;
            while (this.f36968a.get(i4) != 0) {
                i4++;
            }
            return this.f36968a.a(iG2, i4 - iG2);
        }

        public long i() {
            int i3 = this.f36972e;
            if (i3 == 2) {
                return FlexBuffers.l(this.f36968a, this.f36969b, this.f36970c);
            }
            if (i3 == 1) {
                return FlexBuffers.k(this.f36968a, this.f36969b, this.f36970c);
            }
            if (i3 == 3) {
                return (long) FlexBuffers.i(this.f36968a, this.f36969b, this.f36970c);
            }
            if (i3 == 10) {
                return j().b();
            }
            if (i3 == 26) {
                return FlexBuffers.j(this.f36968a, this.f36969b, this.f36970c);
            }
            if (i3 == 5) {
                return Long.parseLong(h());
            }
            if (i3 == 6) {
                ReadBuf readBuf = this.f36968a;
                return FlexBuffers.k(readBuf, FlexBuffers.g(readBuf, this.f36969b, this.f36970c), this.f36971d);
            }
            if (i3 == 7) {
                ReadBuf readBuf2 = this.f36968a;
                return FlexBuffers.l(readBuf2, FlexBuffers.g(readBuf2, this.f36969b, this.f36970c), this.f36971d);
            }
            if (i3 != 8) {
                return 0L;
            }
            ReadBuf readBuf3 = this.f36968a;
            return (long) FlexBuffers.i(readBuf3, FlexBuffers.g(readBuf3, this.f36969b, this.f36970c), this.f36970c);
        }

        public Vector j() {
            if (p()) {
                ReadBuf readBuf = this.f36968a;
                return new Vector(readBuf, FlexBuffers.g(readBuf, this.f36969b, this.f36970c), this.f36971d);
            }
            int i3 = this.f36972e;
            if (i3 == 15) {
                ReadBuf readBuf2 = this.f36968a;
                return new TypedVector(readBuf2, FlexBuffers.g(readBuf2, this.f36969b, this.f36970c), this.f36971d, 4);
            }
            if (!FlexBuffers.h(i3)) {
                return Vector.c();
            }
            ReadBuf readBuf3 = this.f36968a;
            return new TypedVector(readBuf3, FlexBuffers.g(readBuf3, this.f36969b, this.f36970c), this.f36971d, FlexBuffers.m(this.f36972e));
        }

        public boolean k() {
            return this.f36972e == 25;
        }

        public boolean l() {
            return this.f36972e == 26;
        }

        public boolean m() {
            return this.f36972e == 4;
        }

        public boolean n() {
            return this.f36972e == 9;
        }

        public boolean o() {
            return this.f36972e == 5;
        }

        public boolean p() {
            int i3 = this.f36972e;
            return i3 == 10 || i3 == 9;
        }

        public String toString() {
            return q(new StringBuilder(ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD)).toString();
        }

        Reference(ReadBuf readBuf, int i3, int i4, int i5, int i6) {
            this.f36968a = readBuf;
            this.f36969b = i3;
            this.f36970c = i4;
            this.f36971d = i5;
            this.f36972e = i6;
        }

        StringBuilder q(StringBuilder sb) {
            int i3 = this.f36972e;
            if (i3 != 36) {
                switch (i3) {
                    case 0:
                        sb.append("null");
                        return sb;
                    case 1:
                    case 6:
                        sb.append(f());
                        return sb;
                    case 2:
                    case 7:
                        sb.append(i());
                        return sb;
                    case 3:
                    case 8:
                        sb.append(d());
                        return sb;
                    case 4:
                        Key keyE = e();
                        sb.append('\"');
                        StringBuilder sbA = keyE.a(sb);
                        sbA.append('\"');
                        return sbA;
                    case 5:
                        sb.append('\"');
                        sb.append(h());
                        sb.append('\"');
                        return sb;
                    case 9:
                        return g().a(sb);
                    case 10:
                        return j().a(sb);
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                        break;
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                        throw new FlexBufferException(pMpIcGE.sNrRztsZxpL + this.f36972e);
                    case 25:
                        return b().a(sb);
                    case 26:
                        sb.append(c());
                        return sb;
                    default:
                        return sb;
                }
            }
            sb.append(j());
            return sb;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static abstract class Sized extends Object {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        protected final int f36973d;

        Sized(ReadBuf readBuf, int i3, int i4) {
            super(readBuf, i3, i4);
            this.f36973d = FlexBuffers.j(this.f36964a, i3 - i4, i4);
        }

        public int b() {
            return this.f36973d;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class TypedVector extends Vector {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final TypedVector f36974g = new TypedVector(FlexBuffers.f36959a, 1, 1, 1);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f36975f;

        TypedVector(ReadBuf readBuf, int i3, int i4, int i5) {
            super(readBuf, i3, i4);
            this.f36975f = i5;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Vector
        public Reference d(int i3) {
            if (i3 >= b()) {
                return Reference.f36967f;
            }
            return new Reference(this.f36964a, this.f36965b + (i3 * this.f36966c), this.f36966c, 1, this.f36975f);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Unsigned {
        static int a(byte b3) {
            return b3 & 255;
        }

        static long b(int i3) {
            return ((long) i3) & 4294967295L;
        }

        static int c(short s2) {
            return s2 & 65535;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Vector extends Sized {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final Vector f36976e = new Vector(FlexBuffers.f36959a, 1, 1);

        Vector(ReadBuf readBuf, int i3, int i4) {
            super(readBuf, i3, i4);
        }

        public static Vector c() {
            return f36976e;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public StringBuilder a(StringBuilder sb) {
            sb.append("[ ");
            int iB = b();
            for (int i3 = 0; i3 < iB; i3++) {
                d(i3).q(sb);
                if (i3 != iB - 1) {
                    sb.append(", ");
                }
            }
            sb.append(" ]");
            return sb;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Sized
        public /* bridge */ /* synthetic */ int b() {
            return super.b();
        }

        public Reference d(int i3) {
            long jB = b();
            long j3 = i3;
            if (j3 >= jB) {
                return Reference.f36967f;
            }
            return new Reference(this.f36964a, this.f36965b + (i3 * this.f36966c), this.f36966c, Unsigned.a(this.f36964a.get((int) (((long) this.f36965b) + (jB * ((long) this.f36966c)) + j3))));
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int g(ReadBuf readBuf, int i3, int i4) {
        return (int) (((long) i3) - l(readBuf, i3, i4));
    }

    static boolean h(int i3) {
        return (i3 >= 11 && i3 <= 15) || i3 == 36;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double i(ReadBuf readBuf, int i3, int i4) {
        if (i4 == 4) {
            return readBuf.getFloat(i3);
        }
        if (i4 != 8) {
            return -1.0d;
        }
        return readBuf.getDouble(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int j(ReadBuf readBuf, int i3, int i4) {
        return (int) k(readBuf, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long k(ReadBuf readBuf, int i3, int i4) {
        int i5;
        if (i4 == 1) {
            i5 = readBuf.get(i3);
        } else if (i4 == 2) {
            i5 = readBuf.getShort(i3);
        } else {
            if (i4 != 4) {
                if (i4 != 8) {
                    return -1L;
                }
                return readBuf.getLong(i3);
            }
            i5 = readBuf.getInt(i3);
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long l(ReadBuf readBuf, int i3, int i4) {
        if (i4 == 1) {
            return Unsigned.a(readBuf.get(i3));
        }
        if (i4 == 2) {
            return Unsigned.c(readBuf.getShort(i3));
        }
        if (i4 == 4) {
            return Unsigned.b(readBuf.getInt(i3));
        }
        if (i4 != 8) {
            return -1L;
        }
        return readBuf.getLong(i3);
    }

    static int m(int i3) {
        return i3 - 10;
    }
}
