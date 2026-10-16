package com.google.common.io;

import com.google.common.primitives.Longs;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class LittleEndianDataOutputStream extends FilterOutputStream implements DataOutput {
    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        ((FilterOutputStream) this).out.close();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.DataOutput
    public void write(byte[] bArr, int i3, int i4) throws IOException {
        ((FilterOutputStream) this).out.write(bArr, i3, i4);
    }

    @Override // java.io.DataOutput
    public void writeBoolean(boolean z2) throws IOException {
        ((DataOutputStream) ((FilterOutputStream) this).out).writeBoolean(z2);
    }

    @Override // java.io.DataOutput
    public void writeByte(int i3) throws IOException {
        ((DataOutputStream) ((FilterOutputStream) this).out).writeByte(i3);
    }

    @Override // java.io.DataOutput
    public void writeBytes(String str) throws IOException {
        ((DataOutputStream) ((FilterOutputStream) this).out).writeBytes(str);
    }

    @Override // java.io.DataOutput
    public void writeChar(int i3) throws IOException {
        writeShort(i3);
    }

    @Override // java.io.DataOutput
    public void writeChars(String str) throws IOException {
        for (int i3 = 0; i3 < str.length(); i3++) {
            writeChar(str.charAt(i3));
        }
    }

    @Override // java.io.DataOutput
    public void writeDouble(double d3) throws IOException {
        writeLong(Double.doubleToLongBits(d3));
    }

    @Override // java.io.DataOutput
    public void writeFloat(float f3) throws IOException {
        writeInt(Float.floatToIntBits(f3));
    }

    @Override // java.io.DataOutput
    public void writeInt(int i3) throws IOException {
        ((FilterOutputStream) this).out.write(i3 & 255);
        ((FilterOutputStream) this).out.write((i3 >> 8) & 255);
        ((FilterOutputStream) this).out.write((i3 >> 16) & 255);
        ((FilterOutputStream) this).out.write((i3 >> 24) & 255);
    }

    @Override // java.io.DataOutput
    public void writeLong(long j3) throws IOException {
        byte[] bArrJ = Longs.j(Long.reverseBytes(j3));
        write(bArrJ, 0, bArrJ.length);
    }

    @Override // java.io.DataOutput
    public void writeShort(int i3) throws IOException {
        ((FilterOutputStream) this).out.write(i3 & 255);
        ((FilterOutputStream) this).out.write((i3 >> 8) & 255);
    }

    @Override // java.io.DataOutput
    public void writeUTF(String str) throws IOException {
        ((DataOutputStream) ((FilterOutputStream) this).out).writeUTF(str);
    }
}
