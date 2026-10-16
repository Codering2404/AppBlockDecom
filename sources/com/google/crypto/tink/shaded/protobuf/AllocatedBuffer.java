package com.google.crypto.tink.shaded.protobuf;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@CheckReturnValue
abstract class AllocatedBuffer {
    AllocatedBuffer() {
    }

    public static AllocatedBuffer i(final ByteBuffer byteBuffer) {
        Internal.b(byteBuffer, "buffer");
        return new AllocatedBuffer() { // from class: com.google.crypto.tink.shaded.protobuf.AllocatedBuffer.1
            @Override // com.google.crypto.tink.shaded.protobuf.AllocatedBuffer
            public byte[] a() {
                return byteBuffer.array();
            }

            @Override // com.google.crypto.tink.shaded.protobuf.AllocatedBuffer
            public int b() {
                return byteBuffer.arrayOffset();
            }

            @Override // com.google.crypto.tink.shaded.protobuf.AllocatedBuffer
            public boolean c() {
                return byteBuffer.hasArray();
            }

            @Override // com.google.crypto.tink.shaded.protobuf.AllocatedBuffer
            public boolean d() {
                return true;
            }

            @Override // com.google.crypto.tink.shaded.protobuf.AllocatedBuffer
            public int e() {
                return byteBuffer.limit();
            }

            @Override // com.google.crypto.tink.shaded.protobuf.AllocatedBuffer
            public ByteBuffer f() {
                return byteBuffer;
            }

            @Override // com.google.crypto.tink.shaded.protobuf.AllocatedBuffer
            public int g() {
                return byteBuffer.position();
            }

            @Override // com.google.crypto.tink.shaded.protobuf.AllocatedBuffer
            public AllocatedBuffer h(int i3) {
                byteBuffer.position(i3);
                return this;
            }
        };
    }

    public static AllocatedBuffer j(byte[] bArr) {
        return l(bArr, 0, bArr.length);
    }

    public static AllocatedBuffer k(byte[] bArr, int i3, int i4) {
        if (i3 < 0 || i4 < 0 || i3 + i4 > bArr.length) {
            throw new IndexOutOfBoundsException(String.format("bytes.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i3), Integer.valueOf(i4)));
        }
        return l(bArr, i3, i4);
    }

    private static AllocatedBuffer l(final byte[] bArr, final int i3, final int i4) {
        return new AllocatedBuffer() { // from class: com.google.crypto.tink.shaded.protobuf.AllocatedBuffer.2

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private int f86640a;

            @Override // com.google.crypto.tink.shaded.protobuf.AllocatedBuffer
            public byte[] a() {
                return bArr;
            }

            @Override // com.google.crypto.tink.shaded.protobuf.AllocatedBuffer
            public int b() {
                return i3;
            }

            @Override // com.google.crypto.tink.shaded.protobuf.AllocatedBuffer
            public boolean c() {
                return true;
            }

            @Override // com.google.crypto.tink.shaded.protobuf.AllocatedBuffer
            public boolean d() {
                return false;
            }

            @Override // com.google.crypto.tink.shaded.protobuf.AllocatedBuffer
            public int e() {
                return i4;
            }

            @Override // com.google.crypto.tink.shaded.protobuf.AllocatedBuffer
            public ByteBuffer f() {
                throw new UnsupportedOperationException();
            }

            @Override // com.google.crypto.tink.shaded.protobuf.AllocatedBuffer
            public int g() {
                return this.f86640a;
            }

            @Override // com.google.crypto.tink.shaded.protobuf.AllocatedBuffer
            public AllocatedBuffer h(int i5) {
                if (i5 >= 0 && i5 <= i4) {
                    this.f86640a = i5;
                    return this;
                }
                throw new IllegalArgumentException("Invalid position: " + i5);
            }
        };
    }

    public abstract byte[] a();

    public abstract int b();

    public abstract boolean c();

    public abstract boolean d();

    public abstract int e();

    public abstract ByteBuffer f();

    public abstract int g();

    public abstract AllocatedBuffer h(int i3);
}
