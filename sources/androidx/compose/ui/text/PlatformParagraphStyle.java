package androidx.compose.ui.text;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class PlatformParagraphStyle {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f28765c = new Companion(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final PlatformParagraphStyle f28766d = new PlatformParagraphStyle();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f28767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f28768b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PlatformParagraphStyle a() {
            return PlatformParagraphStyle.f28766d;
        }

        private Companion() {
        }
    }

    public /* synthetic */ PlatformParagraphStyle(int i3, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, z2);
    }

    public final int b() {
        return this.f28768b;
    }

    public final boolean c() {
        return this.f28767a;
    }

    public final PlatformParagraphStyle d(PlatformParagraphStyle platformParagraphStyle) {
        return platformParagraphStyle == null ? this : platformParagraphStyle;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlatformParagraphStyle)) {
            return false;
        }
        PlatformParagraphStyle platformParagraphStyle = (PlatformParagraphStyle) obj;
        return this.f28767a == platformParagraphStyle.f28767a && EmojiSupportMatch.g(this.f28768b, platformParagraphStyle.f28768b);
    }

    public int hashCode() {
        return (Boolean.hashCode(this.f28767a) * 31) + EmojiSupportMatch.h(this.f28768b);
    }

    public String toString() {
        return "PlatformParagraphStyle(includeFontPadding=" + this.f28767a + ", emojiSupportMatch=" + ((Object) EmojiSupportMatch.i(this.f28768b)) + ')';
    }

    public PlatformParagraphStyle(boolean z2) {
        this.f28767a = z2;
        this.f28768b = EmojiSupportMatch.f28693b.b();
    }

    private PlatformParagraphStyle(int i3, boolean z2) {
        this.f28767a = z2;
        this.f28768b = i3;
    }

    public PlatformParagraphStyle() {
        this(EmojiSupportMatch.f28693b.b(), false, null);
    }
}
