package com.facebook.stetho.websocket;

import com.facebook.stetho.common.Utf8Charset;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class FrameHelper {
    FrameHelper() {
    }

    public static Frame createBinaryFrame(byte[] bArr) {
        return createSimpleFrame((byte) 2, bArr);
    }

    public static Frame createCloseFrame(int i3, String str) {
        byte[] bArrEncodeUTF8;
        int length;
        if (str != null) {
            bArrEncodeUTF8 = Utf8Charset.encodeUTF8(str);
            length = bArrEncodeUTF8.length + 2;
        } else {
            bArrEncodeUTF8 = null;
            length = 2;
        }
        byte[] bArr = new byte[length];
        bArr[0] = (byte) ((i3 >> 8) & 255);
        bArr[1] = (byte) (i3 & 255);
        if (bArrEncodeUTF8 != null) {
            System.arraycopy(bArrEncodeUTF8, 0, bArr, 2, bArrEncodeUTF8.length);
        }
        return createSimpleFrame((byte) 8, bArr);
    }

    public static Frame createPingFrame(byte[] bArr, int i3) {
        return createSimpleFrame((byte) 9, bArr, i3);
    }

    public static Frame createPongFrame(byte[] bArr, int i3) {
        return createSimpleFrame((byte) 10, bArr, i3);
    }

    private static Frame createSimpleFrame(byte b3, byte[] bArr) {
        return createSimpleFrame(b3, bArr, bArr.length);
    }

    public static Frame createTextFrame(String str) {
        return createSimpleFrame((byte) 1, Utf8Charset.encodeUTF8(str));
    }

    private static Frame createSimpleFrame(byte b3, byte[] bArr, int i3) {
        Frame frame = new Frame();
        frame.fin = true;
        frame.hasMask = false;
        frame.opcode = b3;
        frame.payloadLen = i3;
        frame.payloadData = bArr;
        return frame;
    }
}
