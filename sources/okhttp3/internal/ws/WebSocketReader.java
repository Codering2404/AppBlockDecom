package okhttp3.internal.ws;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class WebSocketReader implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f144924a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final BufferedSource f144925b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final FrameCallback f144926c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f144927d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f144928f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f144929g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f144930h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f144931i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f144932j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f144933k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f144934l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Buffer f144935m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Buffer f144936n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private MessageInflater f144937o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final byte[] f144938p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Buffer.UnsafeCursor f144939q;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface FrameCallback {
        void a(ByteString byteString);

        void b(String str);

        void c(ByteString byteString);

        void d(ByteString byteString);

        void e(int i3, String str);
    }

    public WebSocketReader(boolean z2, BufferedSource source, FrameCallback frameCallback, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(frameCallback, "frameCallback");
        this.f144924a = z2;
        this.f144925b = source;
        this.f144926c = frameCallback;
        this.f144927d = z3;
        this.f144928f = z4;
        this.f144935m = new Buffer();
        this.f144936n = new Buffer();
        this.f144938p = z2 ? null : new byte[4];
        this.f144939q = z2 ? null : new Buffer.UnsafeCursor();
    }

    private final void b() throws ProtocolException, EOFException {
        short s2;
        String strE0;
        long j3 = this.f144931i;
        if (j3 > 0) {
            this.f144925b.l0(this.f144935m, j3);
            if (!this.f144924a) {
                Buffer buffer = this.f144935m;
                Buffer.UnsafeCursor unsafeCursor = this.f144939q;
                Intrinsics.checkNotNull(unsafeCursor);
                buffer.K(unsafeCursor);
                this.f144939q.f(0L);
                WebSocketProtocol webSocketProtocol = WebSocketProtocol.f144923a;
                Buffer.UnsafeCursor unsafeCursor2 = this.f144939q;
                byte[] bArr = this.f144938p;
                Intrinsics.checkNotNull(bArr);
                webSocketProtocol.b(unsafeCursor2, bArr);
                this.f144939q.close();
            }
        }
        switch (this.f144930h) {
            case 8:
                long size = this.f144935m.size();
                if (size == 1) {
                    throw new ProtocolException("Malformed close payload length of 1.");
                }
                if (size != 0) {
                    s2 = this.f144935m.readShort();
                    strE0 = this.f144935m.e0();
                    String strA = WebSocketProtocol.f144923a.a(s2);
                    if (strA != null) {
                        throw new ProtocolException(strA);
                    }
                } else {
                    s2 = 1005;
                    strE0 = "";
                }
                this.f144926c.e(s2, strE0);
                this.f144929g = true;
                return;
            case 9:
                this.f144926c.c(this.f144935m.M());
                return;
            case 10:
                this.f144926c.d(this.f144935m.M());
                return;
            default:
                throw new ProtocolException(Intrinsics.stringPlus("Unknown control opcode: ", Util.R(this.f144930h)));
        }
    }

    private final void c() throws IOException {
        boolean z2;
        if (this.f144929g) {
            throw new IOException("closed");
        }
        long jI = this.f144925b.v().i();
        this.f144925b.v().c();
        try {
            int iD = Util.d(this.f144925b.readByte(), 255);
            this.f144925b.v().h(jI, TimeUnit.NANOSECONDS);
            int i3 = iD & 15;
            this.f144930h = i3;
            boolean z3 = (iD & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0;
            this.f144932j = z3;
            boolean z4 = (iD & 8) != 0;
            this.f144933k = z4;
            if (z4 && !z3) {
                throw new ProtocolException("Control frames must be final.");
            }
            boolean z5 = (iD & 64) != 0;
            if (i3 == 1 || i3 == 2) {
                if (!z5) {
                    z2 = false;
                } else {
                    if (!this.f144927d) {
                        throw new ProtocolException("Unexpected rsv1 flag");
                    }
                    z2 = true;
                }
                this.f144934l = z2;
            } else if (z5) {
                throw new ProtocolException("Unexpected rsv1 flag");
            }
            if ((iD & 32) != 0) {
                throw new ProtocolException("Unexpected rsv2 flag");
            }
            if ((iD & 16) != 0) {
                throw new ProtocolException("Unexpected rsv3 flag");
            }
            int iD2 = Util.d(this.f144925b.readByte(), 255);
            boolean z6 = (iD2 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0;
            if (z6 == this.f144924a) {
                throw new ProtocolException(this.f144924a ? "Server-sent frames must not be masked." : "Client-sent frames must be masked.");
            }
            long j3 = iD2 & 127;
            this.f144931i = j3;
            if (j3 == 126) {
                this.f144931i = Util.e(this.f144925b.readShort(), 65535);
            } else if (j3 == 127) {
                long j4 = this.f144925b.readLong();
                this.f144931i = j4;
                if (j4 < 0) {
                    throw new ProtocolException("Frame length 0x" + Util.S(this.f144931i) + " > 0x7FFFFFFFFFFFFFFF");
                }
            }
            if (this.f144933k && this.f144931i > 125) {
                throw new ProtocolException("Control frame must be less than 125B.");
            }
            if (z6) {
                BufferedSource bufferedSource = this.f144925b;
                byte[] bArr = this.f144938p;
                Intrinsics.checkNotNull(bArr);
                bufferedSource.readFully(bArr);
            }
        } catch (Throwable th) {
            this.f144925b.v().h(jI, TimeUnit.NANOSECONDS);
            throw th;
        }
    }

    private final void f() throws IOException {
        while (!this.f144929g) {
            long j3 = this.f144931i;
            if (j3 > 0) {
                this.f144925b.l0(this.f144936n, j3);
                if (!this.f144924a) {
                    Buffer buffer = this.f144936n;
                    Buffer.UnsafeCursor unsafeCursor = this.f144939q;
                    Intrinsics.checkNotNull(unsafeCursor);
                    buffer.K(unsafeCursor);
                    this.f144939q.f(this.f144936n.size() - this.f144931i);
                    WebSocketProtocol webSocketProtocol = WebSocketProtocol.f144923a;
                    Buffer.UnsafeCursor unsafeCursor2 = this.f144939q;
                    byte[] bArr = this.f144938p;
                    Intrinsics.checkNotNull(bArr);
                    webSocketProtocol.b(unsafeCursor2, bArr);
                    this.f144939q.close();
                }
            }
            if (this.f144932j) {
                return;
            }
            j();
            if (this.f144930h != 0) {
                throw new ProtocolException(Intrinsics.stringPlus("Expected continuation opcode. Got: ", Util.R(this.f144930h)));
            }
        }
        throw new IOException("closed");
    }

    private final void i() throws IOException {
        int i3 = this.f144930h;
        if (i3 != 1 && i3 != 2) {
            throw new ProtocolException(Intrinsics.stringPlus("Unknown opcode: ", Util.R(i3)));
        }
        f();
        if (this.f144934l) {
            MessageInflater messageInflater = this.f144937o;
            if (messageInflater == null) {
                messageInflater = new MessageInflater(this.f144928f);
                this.f144937o = messageInflater;
            }
            messageInflater.a(this.f144936n);
        }
        if (i3 == 1) {
            this.f144926c.b(this.f144936n.e0());
        } else {
            this.f144926c.a(this.f144936n.M());
        }
    }

    private final void j() throws IOException {
        while (!this.f144929g) {
            c();
            if (!this.f144933k) {
                return;
            } else {
                b();
            }
        }
    }

    public final void a() {
        c();
        if (this.f144933k) {
            b();
        } else {
            i();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        MessageInflater messageInflater = this.f144937o;
        if (messageInflater == null) {
            return;
        }
        messageInflater.close();
    }
}
