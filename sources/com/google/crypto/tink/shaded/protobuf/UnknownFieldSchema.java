package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@CheckReturnValue
abstract class UnknownFieldSchema<T, B> {
    UnknownFieldSchema() {
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

    final void l(Object obj, Reader reader) {
        while (reader.A() != Integer.MAX_VALUE && m(obj, reader)) {
        }
    }

    final boolean m(Object obj, Reader reader) throws InvalidProtocolBufferException {
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
        l(objN, reader);
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
