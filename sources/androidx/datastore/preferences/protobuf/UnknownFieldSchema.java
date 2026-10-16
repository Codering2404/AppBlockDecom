package androidx.datastore.preferences.protobuf;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
abstract class UnknownFieldSchema<T, B> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile int f36635a = 100;

    UnknownFieldSchema() {
    }

    private final void l(Object obj, Reader reader, int i3) {
        while (reader.A() != Integer.MAX_VALUE && m(obj, reader, i3)) {
        }
    }

    abstract void a(Object obj, int i3, int i4);

    abstract void b(Object obj, int i3, long j3);

    abstract void c(Object obj, int i3, Object obj2);

    abstract void d(Object obj, int i3, ByteString byteString);

    abstract void e(Object obj, int i3, long j3);

    abstract Object f(Object obj);

    abstract Object g(Object obj);

    abstract int h(Object obj);

    abstract int i(Object obj);

    abstract void j(Object obj);

    abstract Object k(Object obj, Object obj2);

    final boolean m(Object obj, Reader reader, int i3) throws InvalidProtocolBufferException {
        int iC = reader.c();
        int iA = WireFormat.a(iC);
        int iB = WireFormat.b(iC);
        if (iB == 0) {
            e(obj, iA, reader.H());
            return true;
        }
        if (iB == 1) {
            b(obj, iA, reader.a());
            return true;
        }
        if (iB == 2) {
            d(obj, iA, reader.o());
            return true;
        }
        if (iB != 3) {
            if (iB == 4) {
                return false;
            }
            if (iB != 5) {
                throw InvalidProtocolBufferException.e();
            }
            a(obj, iA, reader.u());
            return true;
        }
        Object objN = n();
        int iC2 = WireFormat.c(iA, 4);
        int i4 = i3 + 1;
        if (i4 >= f36635a) {
            throw InvalidProtocolBufferException.i();
        }
        l(objN, reader, i4);
        if (iC2 != reader.c()) {
            throw InvalidProtocolBufferException.b();
        }
        c(obj, iA, r(objN));
        return true;
    }

    abstract Object n();

    abstract void o(Object obj, Object obj2);

    abstract void p(Object obj, Object obj2);

    abstract boolean q(Reader reader);

    abstract Object r(Object obj);

    abstract void s(Object obj, Writer writer);

    abstract void t(Object obj, Writer writer);
}
