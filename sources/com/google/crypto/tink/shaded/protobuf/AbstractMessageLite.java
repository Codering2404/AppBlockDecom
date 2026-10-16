package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.AbstractMessageLite;
import com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import java.io.FilterInputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractMessageLite<MessageType extends AbstractMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> implements MessageLite {
    protected int memoizedHashCode = 0;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    protected interface InternalOneOfEnum {
    }

    private String l(String str) {
        return "Serializing " + getClass().getName() + " to a " + str + " threw an IOException (should never happen).";
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLite
    public ByteString b() {
        try {
            ByteString.CodedBuilder codedBuilderA = ByteString.A(c());
            j(codedBuilderA.b());
            return codedBuilderA.a();
        } catch (IOException e3) {
            throw new RuntimeException(l("ByteString"), e3);
        }
    }

    int d() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLite
    public byte[] i() {
        try {
            byte[] bArr = new byte[c()];
            CodedOutputStream codedOutputStreamU0 = CodedOutputStream.U0(bArr);
            j(codedOutputStreamU0);
            codedOutputStreamU0.U();
            return bArr;
        } catch (IOException e3) {
            throw new RuntimeException(l("byte array"), e3);
        }
    }

    int k(Schema schema) {
        int iD = d();
        if (iD != -1) {
            return iD;
        }
        int iD2 = schema.d(this);
        o(iD2);
        return iD2;
    }

    UninitializedMessageException m() {
        return new UninitializedMessageException(this);
    }

    void o(int i3) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Builder<MessageType extends AbstractMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> implements MessageLite.Builder {
        private String m(String str) {
            return "Reading " + getClass().getName() + " from a " + str + " threw an IOException (should never happen).";
        }

        protected static UninitializedMessageException u(MessageLite messageLite) {
            return new UninitializedMessageException(messageLite);
        }

        @Override // 
        public abstract Builder k();

        protected abstract Builder o(AbstractMessageLite abstractMessageLite);

        public Builder p(CodedInputStream codedInputStream) {
            return q(codedInputStream, ExtensionRegistryLite.b());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public abstract Builder q(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite);

        @Override // com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public Builder c2(MessageLite messageLite) {
            if (g().getClass().isInstance(messageLite)) {
                return o((AbstractMessageLite) messageLite);
            }
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }

        @Override // com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public Builder n(byte[] bArr) {
            return t(bArr, 0, bArr.length);
        }

        public Builder t(byte[] bArr, int i3, int i4) throws InvalidProtocolBufferException {
            try {
                CodedInputStream codedInputStreamK = CodedInputStream.k(bArr, i3, i4);
                p(codedInputStreamK);
                codedInputStreamK.a(0);
                return this;
            } catch (InvalidProtocolBufferException e3) {
                throw e3;
            } catch (IOException e4) {
                throw new RuntimeException(m("byte array"), e4);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static final class LimitedInputStream extends FilterInputStream {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private int f86636a;

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int available() {
                return Math.min(super.available(), this.f86636a);
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read() throws IOException {
                if (this.f86636a <= 0) {
                    return -1;
                }
                int i3 = super.read();
                if (i3 >= 0) {
                    this.f86636a--;
                }
                return i3;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public long skip(long j3) {
                int iSkip = (int) super.skip(Math.min(j3, this.f86636a));
                if (iSkip >= 0) {
                    this.f86636a -= iSkip;
                }
                return iSkip;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] bArr, int i3, int i4) throws IOException {
                int i5 = this.f86636a;
                if (i5 <= 0) {
                    return -1;
                }
                int i6 = super.read(bArr, i3, Math.min(i4, i5));
                if (i6 >= 0) {
                    this.f86636a -= i6;
                }
                return i6;
            }
        }
    }
}
