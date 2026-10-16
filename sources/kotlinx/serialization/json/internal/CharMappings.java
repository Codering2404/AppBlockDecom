package kotlinx.serialization.json.internal;

import com.applovin.exoplayer2.common.base.Ascii;
import kotlin.Metadata;

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
public final class CharMappings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CharMappings f143064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final char[] f143065b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte[] f143066c;

    static {
        CharMappings charMappings = new CharMappings();
        f143064a = charMappings;
        f143065b = new char[117];
        f143066c = new byte[126];
        charMappings.f();
        charMappings.e();
    }

    private CharMappings() {
    }

    private final void a(char c3, char c4) {
        b(c3, c4);
    }

    private final void b(int i3, char c3) {
        if (c3 != 'u') {
            f143065b[c3] = (char) i3;
        }
    }

    private final void c(char c3, byte b3) {
        d(c3, b3);
    }

    private final void d(int i3, byte b3) {
        f143066c[i3] = b3;
    }

    private final void e() {
        for (int i3 = 0; i3 < 33; i3++) {
            d(i3, Ascii.DEL);
        }
        d(9, (byte) 3);
        d(10, (byte) 3);
        d(13, (byte) 3);
        d(32, (byte) 3);
        c(',', (byte) 4);
        c(':', (byte) 5);
        c('{', (byte) 6);
        c('}', (byte) 7);
        c('[', (byte) 8);
        c(']', (byte) 9);
        c('\"', (byte) 1);
        c('\\', (byte) 2);
    }

    private final void f() {
        for (int i3 = 0; i3 < 32; i3++) {
            b(i3, 'u');
        }
        b(8, 'b');
        b(9, 't');
        b(10, 'n');
        b(12, 'f');
        b(13, 'r');
        a('/', '/');
        a('\"', '\"');
        a('\\', '\\');
    }
}
