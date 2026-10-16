package kotlinx.serialization.json.internal;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
public class StringJsonLexer extends AbstractJsonLexer {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f143167e;

    public StringJsonLexer(String source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.f143167e = source;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public String G(String keyToMatch, boolean z2) {
        Intrinsics.checkNotNullParameter(keyToMatch, "keyToMatch");
        int i3 = this.f143035a;
        try {
            if (j() == 6 && Intrinsics.areEqual(I(z2), keyToMatch)) {
                t();
                if (j() == 5) {
                    return I(z2);
                }
            }
            return null;
        } finally {
            this.f143035a = i3;
            t();
        }
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public int J(int i3) {
        if (i3 < D().length()) {
            return i3;
        }
        return -1;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public int L() {
        char cCharAt;
        int i3 = this.f143035a;
        if (i3 == -1) {
            return i3;
        }
        String strD = D();
        while (i3 < strD.length() && ((cCharAt = strD.charAt(i3)) == ' ' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == '\t')) {
            i3++;
        }
        this.f143035a = i3;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
    public String D() {
        return this.f143167e;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public boolean e() {
        int i3 = this.f143035a;
        if (i3 == -1) {
            return false;
        }
        String strD = D();
        while (i3 < strD.length()) {
            char cCharAt = strD.charAt(i3);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                this.f143035a = i3;
                return F(cCharAt);
            }
            i3++;
        }
        this.f143035a = i3;
        return false;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public String i() {
        l('\"');
        int i3 = this.f143035a;
        int iM0 = StringsKt.m0(D(), '\"', i3, false, 4, null);
        if (iM0 == -1) {
            q();
            y((byte) 1, false);
            throw new KotlinNothingValueException();
        }
        for (int i4 = i3; i4 < iM0; i4++) {
            if (D().charAt(i4) == '\\') {
                return p(D(), this.f143035a, i4);
            }
        }
        this.f143035a = iM0 + 1;
        String strSubstring = D().substring(i3, iM0);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public byte j() {
        String strD = D();
        int i3 = this.f143035a;
        while (i3 != -1 && i3 < strD.length()) {
            int i4 = i3 + 1;
            char cCharAt = strD.charAt(i3);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                this.f143035a = i4;
                return AbstractJsonLexerKt.a(cCharAt);
            }
            i3 = i4;
        }
        this.f143035a = strD.length();
        return (byte) 10;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public void l(char c3) {
        if (this.f143035a == -1) {
            R(c3);
        }
        String strD = D();
        int i3 = this.f143035a;
        while (i3 < strD.length()) {
            int i4 = i3 + 1;
            char cCharAt = strD.charAt(i3);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                this.f143035a = i4;
                if (cCharAt == c3) {
                    return;
                } else {
                    R(c3);
                }
            }
            i3 = i4;
        }
        this.f143035a = -1;
        R(c3);
    }
}
