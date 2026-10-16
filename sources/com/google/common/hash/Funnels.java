package com.google.common.hash;

import com.google.common.base.Preconditions;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class Funnels {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private enum ByteArrayFunnel implements Funnel<byte[]> {
        INSTANCE;

        @Override // com.google.common.hash.Funnel
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void g0(byte[] bArr, PrimitiveSink primitiveSink) {
            primitiveSink.a(bArr);
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Funnels.byteArrayFunnel()";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private enum IntegerFunnel implements Funnel<Integer> {
        INSTANCE;

        @Override // com.google.common.hash.Funnel
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void g0(Integer num, PrimitiveSink primitiveSink) {
            primitiveSink.e(num.intValue());
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Funnels.integerFunnel()";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private enum LongFunnel implements Funnel<Long> {
        INSTANCE;

        @Override // com.google.common.hash.Funnel
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void g0(Long l3, PrimitiveSink primitiveSink) {
            primitiveSink.g(l3.longValue());
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Funnels.longFunnel()";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class SequentialFunnel<E> implements Funnel<Iterable<? extends E>>, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Funnel f85090a;

        @Override // com.google.common.hash.Funnel
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void g0(Iterable iterable, PrimitiveSink primitiveSink) {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                this.f85090a.g0(it.next(), primitiveSink);
            }
        }

        public boolean equals(Object obj) {
            if (obj instanceof SequentialFunnel) {
                return this.f85090a.equals(((SequentialFunnel) obj).f85090a);
            }
            return false;
        }

        public int hashCode() {
            return SequentialFunnel.class.hashCode() ^ this.f85090a.hashCode();
        }

        public String toString() {
            return "Funnels.sequentialFunnel(" + this.f85090a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class SinkAsStream extends OutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final PrimitiveSink f85091a;

        public String toString() {
            return "Funnels.asOutputStream(" + this.f85091a + ")";
        }

        @Override // java.io.OutputStream
        public void write(int i3) {
            this.f85091a.b((byte) i3);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) {
            this.f85091a.a(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i3, int i4) {
            this.f85091a.d(bArr, i3, i4);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class StringCharsetFunnel implements Funnel<CharSequence>, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Charset f85092a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static class SerializedForm implements Serializable {
            private static final long serialVersionUID = 0;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f85093a;

            SerializedForm(Charset charset) {
                this.f85093a = charset.name();
            }

            private Object readResolve() {
                return Funnels.a(Charset.forName(this.f85093a));
            }
        }

        StringCharsetFunnel(Charset charset) {
            this.f85092a = (Charset) Preconditions.t(charset);
        }

        private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
            throw new InvalidObjectException("Use SerializedForm");
        }

        @Override // com.google.common.hash.Funnel
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void g0(CharSequence charSequence, PrimitiveSink primitiveSink) {
            primitiveSink.f(charSequence, this.f85092a);
        }

        public boolean equals(Object obj) {
            if (obj instanceof StringCharsetFunnel) {
                return this.f85092a.equals(((StringCharsetFunnel) obj).f85092a);
            }
            return false;
        }

        public int hashCode() {
            return StringCharsetFunnel.class.hashCode() ^ this.f85092a.hashCode();
        }

        public String toString() {
            return "Funnels.stringFunnel(" + this.f85092a.name() + ")";
        }

        Object writeReplace() {
            return new SerializedForm(this.f85092a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private enum UnencodedCharsFunnel implements Funnel<CharSequence> {
        INSTANCE;

        @Override // com.google.common.hash.Funnel
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void g0(CharSequence charSequence, PrimitiveSink primitiveSink) {
            primitiveSink.c(charSequence);
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Funnels.unencodedCharsFunnel()";
        }
    }

    public static Funnel a(Charset charset) {
        return new StringCharsetFunnel(charset);
    }
}
