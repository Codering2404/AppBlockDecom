package androidx.glance.appwidget.protobuf;

import androidx.glance.appwidget.protobuf.AbstractMessageLite;
import androidx.glance.appwidget.protobuf.AbstractMessageLite.Builder;
import androidx.glance.appwidget.protobuf.ByteString;
import androidx.glance.appwidget.protobuf.MessageLite;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractMessageLite<MessageType extends AbstractMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> implements MessageLite {
    protected int memoizedHashCode = 0;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    protected interface InternalOneOfEnum {
    }

    protected static void d(Iterable iterable, List list) {
        Builder.j(iterable, list);
    }

    private String l(String str) {
        return "Serializing " + getClass().getName() + " to a " + str + " threw an IOException (should never happen).";
    }

    @Override // androidx.glance.appwidget.protobuf.MessageLite
    public ByteString b() {
        try {
            ByteString.CodedBuilder codedBuilderA = ByteString.A(c());
            i(codedBuilderA.b());
            return codedBuilderA.a();
        } catch (IOException e3) {
            throw new RuntimeException(l("ByteString"), e3);
        }
    }

    int j() {
        throw new UnsupportedOperationException();
    }

    int k(Schema schema) {
        int iJ = j();
        if (iJ != -1) {
            return iJ;
        }
        int iD = schema.d(this);
        o(iD);
        return iD;
    }

    UninitializedMessageException m() {
        return new UninitializedMessageException(this);
    }

    void o(int i3) {
        throw new UnsupportedOperationException();
    }

    public void p(OutputStream outputStream) {
        CodedOutputStream codedOutputStreamW0 = CodedOutputStream.W0(outputStream, CodedOutputStream.A0(c()));
        i(codedOutputStreamW0);
        codedOutputStreamW0.T0();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Builder<MessageType extends AbstractMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> implements MessageLite.Builder {
        protected static void j(Iterable iterable, List list) {
            Internal.a(iterable);
            if (!(iterable instanceof LazyStringList)) {
                if (iterable instanceof PrimitiveNonBoxingCollection) {
                    list.addAll((Collection) iterable);
                    return;
                } else {
                    k(iterable, list);
                    return;
                }
            }
            List listK = ((LazyStringList) iterable).k();
            LazyStringList lazyStringList = (LazyStringList) list;
            int size = list.size();
            for (Object obj : listK) {
                if (obj == null) {
                    String str = "Element at index " + (lazyStringList.size() - size) + " is null.";
                    for (int size2 = lazyStringList.size() - 1; size2 >= size; size2--) {
                        lazyStringList.remove(size2);
                    }
                    throw new NullPointerException(str);
                }
                if (obj instanceof ByteString) {
                    lazyStringList.X0((ByteString) obj);
                } else {
                    lazyStringList.add((String) obj);
                }
            }
        }

        private static void k(Iterable iterable, List list) {
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
            }
            int size = list.size();
            for (Object obj : iterable) {
                if (obj == null) {
                    String str = "Element at index " + (list.size() - size) + " is null.";
                    for (int size2 = list.size() - 1; size2 >= size; size2--) {
                        list.remove(size2);
                    }
                    throw new NullPointerException(str);
                }
                list.add(obj);
            }
        }

        private String o(String str) {
            return "Reading " + getClass().getName() + " from a " + str + " threw an IOException (should never happen).";
        }

        protected static UninitializedMessageException v(MessageLite messageLite) {
            return new UninitializedMessageException(messageLite);
        }

        @Override // 
        public abstract Builder m();

        protected abstract Builder p(AbstractMessageLite abstractMessageLite);

        public Builder q(CodedInputStream codedInputStream) {
            return r(codedInputStream, ExtensionRegistryLite.b());
        }

        @Override // androidx.glance.appwidget.protobuf.MessageLite.Builder
        public abstract Builder r(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite);

        @Override // androidx.glance.appwidget.protobuf.MessageLite.Builder
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public Builder S1(MessageLite messageLite) {
            if (g().getClass().isInstance(messageLite)) {
                return p((AbstractMessageLite) messageLite);
            }
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }

        @Override // androidx.glance.appwidget.protobuf.MessageLite.Builder
        /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
        public Builder n(byte[] bArr) {
            return u(bArr, 0, bArr.length);
        }

        public Builder u(byte[] bArr, int i3, int i4) throws InvalidProtocolBufferException {
            try {
                CodedInputStream codedInputStreamK = CodedInputStream.k(bArr, i3, i4);
                q(codedInputStreamK);
                codedInputStreamK.a(0);
                return this;
            } catch (InvalidProtocolBufferException e3) {
                throw e3;
            } catch (IOException e4) {
                throw new RuntimeException(o("byte array"), e4);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static final class LimitedInputStream extends FilterInputStream {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private int f38771a;

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int available() {
                return Math.min(super.available(), this.f38771a);
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read() throws IOException {
                if (this.f38771a <= 0) {
                    return -1;
                }
                int i3 = super.read();
                if (i3 >= 0) {
                    this.f38771a--;
                }
                return i3;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public long skip(long j3) {
                int iSkip = (int) super.skip(Math.min(j3, this.f38771a));
                if (iSkip >= 0) {
                    this.f38771a -= iSkip;
                }
                return iSkip;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] bArr, int i3, int i4) throws IOException {
                int i5 = this.f38771a;
                if (i5 <= 0) {
                    return -1;
                }
                int i6 = super.read(bArr, i3, Math.min(i4, i5));
                if (i6 >= 0) {
                    this.f38771a -= i6;
                }
                return i6;
            }
        }
    }
}
