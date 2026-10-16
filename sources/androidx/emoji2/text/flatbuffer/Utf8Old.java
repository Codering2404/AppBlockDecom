package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class Utf8Old extends Utf8 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ThreadLocal f36988b = ThreadLocal.withInitial(new Supplier() { // from class: androidx.emoji2.text.flatbuffer.a
        @Override // java.util.function.Supplier
        public final Object get() {
            return Utf8Old.b();
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Cache {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final CharsetEncoder f36989a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final CharsetDecoder f36990b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        CharSequence f36991c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        ByteBuffer f36992d = null;

        Cache() {
            Charset charset = StandardCharsets.UTF_8;
            this.f36989a = charset.newEncoder();
            this.f36990b = charset.newDecoder();
        }
    }

    public static /* synthetic */ Cache b() {
        return new Cache();
    }
}
