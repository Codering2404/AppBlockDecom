package com.google.common.io;

import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class LittleEndianDataInputStream extends FilterInputStream implements DataInput {
    private byte a() throws IOException {
        int i3 = ((FilterInputStream) this).in.read();
        if (-1 != i3) {
            return (byte) i3;
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public boolean readBoolean() {
        return readUnsignedByte() != 0;
    }

    @Override // java.io.DataInput
    public byte readByte() {
        return (byte) readUnsignedByte();
    }

    @Override // java.io.DataInput
    public char readChar() {
        return (char) readUnsignedShort();
    }

    @Override // java.io.DataInput
    public double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    @Override // java.io.DataInput
    public float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr) throws IOException {
        ByteStreams.f(this, bArr);
    }

    @Override // java.io.DataInput
    public int readInt() throws IOException {
        byte bA = a();
        byte bA2 = a();
        return Ints.h(a(), a(), bA2, bA);
    }

    @Override // java.io.DataInput
    public String readLine() {
        throw new UnsupportedOperationException("readLine is not supported");
    }

    @Override // java.io.DataInput
    public long readLong() throws IOException {
        byte bA = a();
        byte bA2 = a();
        byte bA3 = a();
        byte bA4 = a();
        byte bA5 = a();
        byte bA6 = a();
        return Longs.d(a(), a(), bA6, bA5, bA4, bA3, bA2, bA);
    }

    @Override // java.io.DataInput
    public short readShort() {
        return (short) readUnsignedShort();
    }

    @Override // java.io.DataInput
    public String readUTF() {
        return new DataInputStream(((FilterInputStream) this).in).readUTF();
    }

    @Override // java.io.DataInput
    public int readUnsignedByte() throws IOException {
        int i3 = ((FilterInputStream) this).in.read();
        if (i3 >= 0) {
            return i3;
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public int readUnsignedShort() throws IOException {
        return Ints.h((byte) 0, (byte) 0, a(), a());
    }

    @Override // java.io.DataInput
    public int skipBytes(int i3) {
        return (int) ((FilterInputStream) this).in.skip(i3);
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr, int i3, int i4) throws IOException {
        ByteStreams.g(this, bArr, i3, i4);
    }
}
