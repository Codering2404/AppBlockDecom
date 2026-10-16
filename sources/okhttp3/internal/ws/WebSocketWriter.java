package okhttp3.internal.ws;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.Closeable;
import java.io.IOException;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class WebSocketWriter implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f144940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final BufferedSink f144941b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Random f144942c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f144943d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f144944f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f144945g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Buffer f144946h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Buffer f144947i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f144948j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private MessageDeflater f144949k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final byte[] f144950l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Buffer.UnsafeCursor f144951m;

    public WebSocketWriter(boolean z2, BufferedSink sink, Random random, boolean z3, boolean z4, long j3) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        Intrinsics.checkNotNullParameter(random, "random");
        this.f144940a = z2;
        this.f144941b = sink;
        this.f144942c = random;
        this.f144943d = z3;
        this.f144944f = z4;
        this.f144945g = j3;
        this.f144946h = new Buffer();
        this.f144947i = sink.u();
        this.f144950l = z2 ? new byte[4] : null;
        this.f144951m = z2 ? new Buffer.UnsafeCursor() : null;
    }

    private final void b(int i3, ByteString byteString) throws IOException {
        if (this.f144948j) {
            throw new IOException("closed");
        }
        int iC = byteString.C();
        if (iC > 125) {
            throw new IllegalArgumentException("Payload size must be less than or equal to 125");
        }
        this.f144947i.writeByte(i3 | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
        if (this.f144940a) {
            this.f144947i.writeByte(iC | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
            Random random = this.f144942c;
            byte[] bArr = this.f144950l;
            Intrinsics.checkNotNull(bArr);
            random.nextBytes(bArr);
            this.f144947i.write(this.f144950l);
            if (iC > 0) {
                long size = this.f144947i.size();
                this.f144947i.q2(byteString);
                Buffer buffer = this.f144947i;
                Buffer.UnsafeCursor unsafeCursor = this.f144951m;
                Intrinsics.checkNotNull(unsafeCursor);
                buffer.K(unsafeCursor);
                this.f144951m.f(size);
                WebSocketProtocol.f144923a.b(this.f144951m, this.f144950l);
                this.f144951m.close();
            }
        } else {
            this.f144947i.writeByte(iC);
            this.f144947i.q2(byteString);
        }
        this.f144941b.flush();
    }

    public final void a(int i3, ByteString byteString) {
        ByteString byteStringM = ByteString.f144998f;
        if (i3 != 0 || byteString != null) {
            if (i3 != 0) {
                WebSocketProtocol.f144923a.c(i3);
            }
            Buffer buffer = new Buffer();
            buffer.writeShort(i3);
            if (byteString != null) {
                buffer.q2(byteString);
            }
            byteStringM = buffer.M();
        }
        try {
            b(8, byteStringM);
        } finally {
            this.f144948j = true;
        }
    }

    public final void c(int i3, ByteString data) throws IOException {
        Intrinsics.checkNotNullParameter(data, "data");
        if (this.f144948j) {
            throw new IOException("closed");
        }
        this.f144946h.q2(data);
        int i4 = i3 | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (this.f144943d && data.C() >= this.f144945g) {
            MessageDeflater messageDeflater = this.f144949k;
            if (messageDeflater == null) {
                messageDeflater = new MessageDeflater(this.f144944f);
                this.f144949k = messageDeflater;
            }
            messageDeflater.a(this.f144946h);
            i4 = i3 | 192;
        }
        long size = this.f144946h.size();
        this.f144947i.writeByte(i4);
        int i5 = this.f144940a ? ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD : 0;
        if (size <= 125) {
            this.f144947i.writeByte(i5 | ((int) size));
        } else if (size <= 65535) {
            this.f144947i.writeByte(i5 | 126);
            this.f144947i.writeShort((int) size);
        } else {
            this.f144947i.writeByte(i5 | 127);
            this.f144947i.A1(size);
        }
        if (this.f144940a) {
            Random random = this.f144942c;
            byte[] bArr = this.f144950l;
            Intrinsics.checkNotNull(bArr);
            random.nextBytes(bArr);
            this.f144947i.write(this.f144950l);
            if (size > 0) {
                Buffer buffer = this.f144946h;
                Buffer.UnsafeCursor unsafeCursor = this.f144951m;
                Intrinsics.checkNotNull(unsafeCursor);
                buffer.K(unsafeCursor);
                this.f144951m.f(0L);
                WebSocketProtocol.f144923a.b(this.f144951m, this.f144950l);
                this.f144951m.close();
            }
        }
        this.f144947i.H0(this.f144946h, size);
        this.f144941b.U();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        MessageDeflater messageDeflater = this.f144949k;
        if (messageDeflater == null) {
            return;
        }
        messageDeflater.close();
    }

    public final void f(ByteString payload) throws IOException {
        Intrinsics.checkNotNullParameter(payload, "payload");
        b(9, payload);
    }

    public final void i(ByteString payload) throws IOException {
        Intrinsics.checkNotNullParameter(payload, "payload");
        b(10, payload);
    }
}
