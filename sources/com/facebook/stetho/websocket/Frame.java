package com.facebook.stetho.websocket;

import com.applovin.exoplayer2.common.base.Ascii;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class Frame {
    public static final byte OPCODE_BINARY_FRAME = 2;
    public static final byte OPCODE_CONNECTION_CLOSE = 8;
    public static final byte OPCODE_CONNECTION_PING = 9;
    public static final byte OPCODE_CONNECTION_PONG = 10;
    public static final byte OPCODE_TEXT_FRAME = 1;
    public boolean fin;
    public boolean hasMask;
    public byte[] maskingKey;
    public byte opcode;
    public byte[] payloadData;
    public long payloadLen;
    public boolean rsv1;
    public boolean rsv2;
    public boolean rsv3;

    Frame() {
    }

    private void decodeFirstByte(byte b3) {
        this.fin = (b3 & 128) != 0;
        this.rsv1 = (b3 & 64) != 0;
        this.rsv2 = (b3 & 32) != 0;
        this.rsv3 = (b3 & Ascii.DLE) != 0;
        this.opcode = (byte) (b3 & Ascii.SI);
    }

    private long decodeLength(byte b3, InputStream inputStream) throws IOException {
        if (b3 <= 125) {
            return b3;
        }
        if (b3 == 126) {
            return ((readByteOrThrow(inputStream) & 255) << 8) | (readByteOrThrow(inputStream) & 255);
        }
        if (b3 != 127) {
            throw new IOException("Unexpected length byte: " + ((int) b3));
        }
        long byteOrThrow = 0;
        for (int i3 = 0; i3 < 8; i3++) {
            byteOrThrow = (byteOrThrow << 8) | ((long) (readByteOrThrow(inputStream) & 255));
        }
        return byteOrThrow;
    }

    private static byte[] decodeMaskingKey(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[4];
        readBytesOrThrow(inputStream, bArr, 0, 4);
        return bArr;
    }

    private byte encodeFirstByte() {
        byte b3 = this.fin ? (byte) ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD : (byte) 0;
        if (this.rsv1) {
            b3 = (byte) (b3 | 64);
        }
        if (this.rsv2) {
            b3 = (byte) (b3 | 32);
        }
        if (this.rsv3) {
            b3 = (byte) (b3 | Ascii.DLE);
        }
        return (byte) (b3 | (this.opcode & Ascii.SI));
    }

    private static byte[] encodeLength(long j3) {
        return j3 <= 125 ? new byte[]{(byte) j3} : j3 <= 65535 ? new byte[]{126, (byte) ((j3 >> 8) & 255), (byte) (j3 & 255)} : new byte[]{Ascii.DEL, (byte) ((j3 >> 56) & 255), (byte) ((j3 >> 48) & 255), (byte) ((j3 >> 40) & 255), (byte) ((j3 >> 32) & 255), (byte) ((j3 >> 24) & 255), (byte) ((j3 >> 16) & 255), (byte) ((j3 >> 8) & 255), (byte) (j3 & 255)};
    }

    private static byte readByteOrThrow(InputStream inputStream) throws IOException {
        int i3 = inputStream.read();
        if (i3 != -1) {
            return (byte) i3;
        }
        throw new EOFException();
    }

    private static void readBytesOrThrow(InputStream inputStream, byte[] bArr, int i3, int i4) throws IOException {
        while (i4 > 0) {
            int i5 = inputStream.read(bArr, i3, i4);
            if (i5 == -1) {
                throw new EOFException();
            }
            i4 -= i5;
            i3 += i5;
        }
    }

    public void readFrom(BufferedInputStream bufferedInputStream) throws IOException {
        decodeFirstByte(readByteOrThrow(bufferedInputStream));
        byte byteOrThrow = readByteOrThrow(bufferedInputStream);
        this.hasMask = (byteOrThrow & 128) != 0;
        this.payloadLen = decodeLength((byte) (byteOrThrow & Ascii.DEL), bufferedInputStream);
        this.maskingKey = this.hasMask ? decodeMaskingKey(bufferedInputStream) : null;
        long j3 = this.payloadLen;
        byte[] bArr = new byte[(int) j3];
        this.payloadData = bArr;
        readBytesOrThrow(bufferedInputStream, bArr, 0, (int) j3);
        MaskingHelper.unmask(this.maskingKey, this.payloadData, 0, (int) this.payloadLen);
    }

    public void writeTo(BufferedOutputStream bufferedOutputStream) throws IOException {
        bufferedOutputStream.write(encodeFirstByte());
        byte[] bArrEncodeLength = encodeLength(this.payloadLen);
        if (this.hasMask) {
            bArrEncodeLength[0] = (byte) (bArrEncodeLength[0] | 128);
        }
        bufferedOutputStream.write(bArrEncodeLength, 0, bArrEncodeLength.length);
        if (this.hasMask) {
            throw new UnsupportedOperationException("Writing masked data not implemented");
        }
        bufferedOutputStream.write(this.payloadData, 0, (int) this.payloadLen);
    }
}
