package com.google.common.io;

import com.facebook.internal.Utility;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class ByteStreams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final OutputStream f85235a = new OutputStream() { // from class: com.google.common.io.ByteStreams.1
        public String toString() {
            return "ByteStreams.nullOutputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int i3) {
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) {
            Preconditions.t(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i3, int i4) {
            Preconditions.t(bArr);
            Preconditions.y(i3, i4 + i3, bArr.length);
        }
    };

    private static byte[] a(Queue queue, int i3) {
        if (queue.isEmpty()) {
            return new byte[0];
        }
        byte[] bArr = (byte[]) queue.remove();
        if (bArr.length == i3) {
            return bArr;
        }
        int length = i3 - bArr.length;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, i3);
        while (length > 0) {
            byte[] bArr2 = (byte[]) queue.remove();
            int iMin = Math.min(length, bArr2.length);
            System.arraycopy(bArr2, 0, bArrCopyOf, i3 - length, iMin);
            length -= iMin;
        }
        return bArrCopyOf;
    }

    public static long b(InputStream inputStream, OutputStream outputStream) throws IOException {
        Preconditions.t(inputStream);
        Preconditions.t(outputStream);
        byte[] bArrC = c();
        long j3 = 0;
        while (true) {
            int i3 = inputStream.read(bArrC);
            if (i3 == -1) {
                return j3;
            }
            outputStream.write(bArrC, 0, i3);
            j3 += (long) i3;
        }
    }

    static byte[] c() {
        return new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
    }

    public static InputStream d(InputStream inputStream, long j3) {
        return new LimitedInputStream(inputStream, j3);
    }

    public static int e(InputStream inputStream, byte[] bArr, int i3, int i4) throws IOException {
        Preconditions.t(inputStream);
        Preconditions.t(bArr);
        if (i4 < 0) {
            throw new IndexOutOfBoundsException(String.format("len (%s) cannot be negative", Integer.valueOf(i4)));
        }
        Preconditions.y(i3, i3 + i4, bArr.length);
        int i5 = 0;
        while (i5 < i4) {
            int i6 = inputStream.read(bArr, i3 + i5, i4 - i5);
            if (i6 == -1) {
                break;
            }
            i5 += i6;
        }
        return i5;
    }

    public static void f(InputStream inputStream, byte[] bArr) throws IOException {
        g(inputStream, bArr, 0, bArr.length);
    }

    public static void g(InputStream inputStream, byte[] bArr, int i3, int i4) throws IOException {
        int iE = e(inputStream, bArr, i3, i4);
        if (iE == i4) {
            return;
        }
        throw new EOFException("reached end of stream after reading " + iE + " bytes; " + i4 + " bytes expected");
    }

    private static long h(InputStream inputStream, long j3) throws IOException {
        int iAvailable = inputStream.available();
        if (iAvailable == 0) {
            return 0L;
        }
        return inputStream.skip(Math.min(iAvailable, j3));
    }

    static long i(InputStream inputStream, long j3) throws IOException {
        byte[] bArr = null;
        long j4 = 0;
        while (j4 < j3) {
            long j5 = j3 - j4;
            long jH = h(inputStream, j5);
            if (jH == 0) {
                int iMin = (int) Math.min(j5, 8192L);
                if (bArr == null) {
                    bArr = new byte[iMin];
                }
                jH = inputStream.read(bArr, 0, iMin);
                if (jH == -1) {
                    break;
                }
            }
            j4 += jH;
        }
        return j4;
    }

    public static byte[] j(InputStream inputStream) {
        Preconditions.t(inputStream);
        return k(inputStream, new ArrayDeque(20), 0);
    }

    private static byte[] k(InputStream inputStream, Queue queue, int i3) throws IOException {
        int iMin = Math.min(Utility.DEFAULT_STREAM_BUFFER_SIZE, Math.max(ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD, Integer.highestOneBit(i3) * 2));
        while (i3 < 2147483639) {
            int iMin2 = Math.min(iMin, 2147483639 - i3);
            byte[] bArr = new byte[iMin2];
            queue.add(bArr);
            int i4 = 0;
            while (i4 < iMin2) {
                int i5 = inputStream.read(bArr, i4, iMin2 - i4);
                if (i5 == -1) {
                    return a(queue, i3);
                }
                i4 += i5;
                i3 += i5;
            }
            iMin = IntMath.j(iMin, iMin < 4096 ? 4 : 2);
        }
        if (inputStream.read() == -1) {
            return a(queue, 2147483639);
        }
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ByteArrayDataInputStream implements ByteArrayDataInput {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final DataInput f85236a;

        @Override // java.io.DataInput
        public boolean readBoolean() {
            try {
                return this.f85236a.readBoolean();
            } catch (IOException e3) {
                throw new IllegalStateException(e3);
            }
        }

        @Override // java.io.DataInput
        public byte readByte() {
            try {
                return this.f85236a.readByte();
            } catch (EOFException e3) {
                throw new IllegalStateException(e3);
            } catch (IOException e4) {
                throw new AssertionError(e4);
            }
        }

        @Override // java.io.DataInput
        public char readChar() {
            try {
                return this.f85236a.readChar();
            } catch (IOException e3) {
                throw new IllegalStateException(e3);
            }
        }

        @Override // java.io.DataInput
        public double readDouble() {
            try {
                return this.f85236a.readDouble();
            } catch (IOException e3) {
                throw new IllegalStateException(e3);
            }
        }

        @Override // java.io.DataInput
        public float readFloat() {
            try {
                return this.f85236a.readFloat();
            } catch (IOException e3) {
                throw new IllegalStateException(e3);
            }
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr) {
            try {
                this.f85236a.readFully(bArr);
            } catch (IOException e3) {
                throw new IllegalStateException(e3);
            }
        }

        @Override // java.io.DataInput
        public int readInt() {
            try {
                return this.f85236a.readInt();
            } catch (IOException e3) {
                throw new IllegalStateException(e3);
            }
        }

        @Override // java.io.DataInput
        public String readLine() {
            try {
                return this.f85236a.readLine();
            } catch (IOException e3) {
                throw new IllegalStateException(e3);
            }
        }

        @Override // java.io.DataInput
        public long readLong() {
            try {
                return this.f85236a.readLong();
            } catch (IOException e3) {
                throw new IllegalStateException(e3);
            }
        }

        @Override // java.io.DataInput
        public short readShort() {
            try {
                return this.f85236a.readShort();
            } catch (IOException e3) {
                throw new IllegalStateException(e3);
            }
        }

        @Override // java.io.DataInput
        public String readUTF() {
            try {
                return this.f85236a.readUTF();
            } catch (IOException e3) {
                throw new IllegalStateException(e3);
            }
        }

        @Override // java.io.DataInput
        public int readUnsignedByte() {
            try {
                return this.f85236a.readUnsignedByte();
            } catch (IOException e3) {
                throw new IllegalStateException(e3);
            }
        }

        @Override // java.io.DataInput
        public int readUnsignedShort() {
            try {
                return this.f85236a.readUnsignedShort();
            } catch (IOException e3) {
                throw new IllegalStateException(e3);
            }
        }

        @Override // java.io.DataInput
        public int skipBytes(int i3) {
            try {
                return this.f85236a.skipBytes(i3);
            } catch (IOException e3) {
                throw new IllegalStateException(e3);
            }
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr, int i3, int i4) {
            try {
                this.f85236a.readFully(bArr, i3, i4);
            } catch (IOException e3) {
                throw new IllegalStateException(e3);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ByteArrayDataOutputStream implements ByteArrayDataOutput {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final DataOutput f85237a;

        @Override // java.io.DataOutput
        public void write(int i3) {
            try {
                this.f85237a.write(i3);
            } catch (IOException e3) {
                throw new AssertionError(e3);
            }
        }

        @Override // java.io.DataOutput
        public void writeBoolean(boolean z2) {
            try {
                this.f85237a.writeBoolean(z2);
            } catch (IOException e3) {
                throw new AssertionError(e3);
            }
        }

        @Override // java.io.DataOutput
        public void writeByte(int i3) {
            try {
                this.f85237a.writeByte(i3);
            } catch (IOException e3) {
                throw new AssertionError(e3);
            }
        }

        @Override // java.io.DataOutput
        public void writeBytes(String str) {
            try {
                this.f85237a.writeBytes(str);
            } catch (IOException e3) {
                throw new AssertionError(e3);
            }
        }

        @Override // java.io.DataOutput
        public void writeChar(int i3) {
            try {
                this.f85237a.writeChar(i3);
            } catch (IOException e3) {
                throw new AssertionError(e3);
            }
        }

        @Override // java.io.DataOutput
        public void writeChars(String str) {
            try {
                this.f85237a.writeChars(str);
            } catch (IOException e3) {
                throw new AssertionError(e3);
            }
        }

        @Override // java.io.DataOutput
        public void writeDouble(double d3) {
            try {
                this.f85237a.writeDouble(d3);
            } catch (IOException e3) {
                throw new AssertionError(e3);
            }
        }

        @Override // java.io.DataOutput
        public void writeFloat(float f3) {
            try {
                this.f85237a.writeFloat(f3);
            } catch (IOException e3) {
                throw new AssertionError(e3);
            }
        }

        @Override // java.io.DataOutput
        public void writeInt(int i3) {
            try {
                this.f85237a.writeInt(i3);
            } catch (IOException e3) {
                throw new AssertionError(e3);
            }
        }

        @Override // java.io.DataOutput
        public void writeLong(long j3) {
            try {
                this.f85237a.writeLong(j3);
            } catch (IOException e3) {
                throw new AssertionError(e3);
            }
        }

        @Override // java.io.DataOutput
        public void writeShort(int i3) {
            try {
                this.f85237a.writeShort(i3);
            } catch (IOException e3) {
                throw new AssertionError(e3);
            }
        }

        @Override // java.io.DataOutput
        public void writeUTF(String str) {
            try {
                this.f85237a.writeUTF(str);
            } catch (IOException e3) {
                throw new AssertionError(e3);
            }
        }

        @Override // java.io.DataOutput
        public void write(byte[] bArr) {
            try {
                this.f85237a.write(bArr);
            } catch (IOException e3) {
                throw new AssertionError(e3);
            }
        }

        @Override // java.io.DataOutput
        public void write(byte[] bArr, int i3, int i4) {
            try {
                this.f85237a.write(bArr, i3, i4);
            } catch (IOException e3) {
                throw new AssertionError(e3);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class LimitedInputStream extends FilterInputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f85238a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f85239b;

        LimitedInputStream(InputStream inputStream, long j3) {
            super(inputStream);
            this.f85239b = -1L;
            Preconditions.t(inputStream);
            Preconditions.e(j3 >= 0, "limit must be non-negative");
            this.f85238a = j3;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int available() {
            return (int) Math.min(((FilterInputStream) this).in.available(), this.f85238a);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void mark(int i3) {
            ((FilterInputStream) this).in.mark(i3);
            this.f85239b = this.f85238a;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            if (this.f85238a == 0) {
                return -1;
            }
            int i3 = ((FilterInputStream) this).in.read();
            if (i3 != -1) {
                this.f85238a--;
            }
            return i3;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void reset() {
            if (!((FilterInputStream) this).in.markSupported()) {
                throw new IOException("Mark not supported");
            }
            if (this.f85239b == -1) {
                throw new IOException("Mark not set");
            }
            ((FilterInputStream) this).in.reset();
            this.f85238a = this.f85239b;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j3) throws IOException {
            long jSkip = ((FilterInputStream) this).in.skip(Math.min(j3, this.f85238a));
            this.f85238a -= jSkip;
            return jSkip;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i3, int i4) throws IOException {
            long j3 = this.f85238a;
            if (j3 == 0) {
                return -1;
            }
            int i5 = ((FilterInputStream) this).in.read(bArr, i3, (int) Math.min(i4, j3));
            if (i5 != -1) {
                this.f85238a -= (long) i5;
            }
            return i5;
        }
    }
}
