package com.facebook.stetho.dumpapp;

import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.server.SocketLike;
import com.facebook.stetho.server.SocketLikeHandler;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class DumpappSocketLikeHandler implements SocketLikeHandler {
    public static final byte[] PROTOCOL_MAGIC = {68, 85, 77, 80};
    public static final int PROTOCOL_VERSION = 1;
    private final Dumper mDumper;

    public DumpappSocketLikeHandler(Dumper dumper) {
        this.mDumper = dumper;
    }

    static void dump(Dumper dumper, Framer framer, String[] strArr) throws IOException {
        try {
            framer.writeExitCode(dumper.dump(framer.getStdin(), framer.getStdout(), framer.getStderr(), strArr));
        } catch (DumpappOutputBrokenException unused) {
        }
    }

    private void establishConversation(DataInputStream dataInputStream) throws IOException {
        byte[] bArr = new byte[4];
        dataInputStream.readFully(bArr);
        if (!Arrays.equals(PROTOCOL_MAGIC, bArr)) {
            throw logAndThrowProtocolException("Incompatible protocol, are you using an old dumpapp script?");
        }
        int i3 = dataInputStream.readInt();
        if (i3 == 1) {
            return;
        }
        throw logAndThrowProtocolException("Expected version=1; got=" + i3);
    }

    private static IOException logAndThrowProtocolException(String str) throws IOException {
        LogUtil.w(str);
        throw new IOException(str);
    }

    private String[] readArgs(Framer framer) throws IOException {
        String[] strArr;
        synchronized (framer) {
            try {
                byte frameType = framer.readFrameType();
                if (frameType != 33) {
                    throw new DumpappFramingException("Expected enter frame, got: " + ((int) frameType));
                }
                int i3 = framer.readInt();
                strArr = new String[i3];
                for (int i4 = 0; i4 < i3; i4++) {
                    strArr[i4] = framer.readString();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return strArr;
    }

    @Override // com.facebook.stetho.server.SocketLikeHandler
    public void onAccepted(SocketLike socketLike) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(socketLike.getInput());
        establishConversation(dataInputStream);
        Framer framer = new Framer(dataInputStream, socketLike.getOutput());
        dump(this.mDumper, framer, readArgs(framer));
    }
}
