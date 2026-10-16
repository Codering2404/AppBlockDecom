package androidx.media3.extractor.metadata.emsg;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class EventMessageEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ByteArrayOutputStream f46423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DataOutputStream f46424b;

    public EventMessageEncoder() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        this.f46423a = byteArrayOutputStream;
        this.f46424b = new DataOutputStream(byteArrayOutputStream);
    }

    private static void b(DataOutputStream dataOutputStream, String str) throws IOException {
        dataOutputStream.writeBytes(str);
        dataOutputStream.writeByte(0);
    }

    public byte[] a(EventMessage eventMessage) {
        this.f46423a.reset();
        try {
            b(this.f46424b, eventMessage.f46417a);
            String str = eventMessage.f46418b;
            if (str == null) {
                str = "";
            }
            b(this.f46424b, str);
            this.f46424b.writeLong(eventMessage.f46419c);
            this.f46424b.writeLong(eventMessage.f46420d);
            this.f46424b.write(eventMessage.f46421e);
            this.f46424b.flush();
            return this.f46423a.toByteArray();
        } catch (IOException e3) {
            throw new RuntimeException(e3);
        }
    }
}
