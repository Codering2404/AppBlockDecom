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
public final class StringJsonLexerWithComments extends StringJsonLexer {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StringJsonLexerWithComments(String source) {
        super(source);
        Intrinsics.checkNotNullParameter(source, "source");
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public byte H() {
        String strD = D();
        int iL = L();
        if (iL >= strD.length() || iL == -1) {
            return (byte) 10;
        }
        this.f143035a = iL;
        return AbstractJsonLexerKt.a(strD.charAt(iL));
    }

    @Override // kotlinx.serialization.json.internal.StringJsonLexer, kotlinx.serialization.json.internal.AbstractJsonLexer
    public int L() {
        int i3;
        int iM0 = this.f143035a;
        if (iM0 == -1) {
            return iM0;
        }
        String strD = D();
        while (iM0 < strD.length()) {
            char cCharAt = strD.charAt(iM0);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                if (cCharAt != '/' || (i3 = iM0 + 1) >= strD.length()) {
                    break;
                }
                char cCharAt2 = strD.charAt(i3);
                if (cCharAt2 == '*') {
                    int iN0 = StringsKt.n0(strD, "*/", iM0 + 2, false, 4, null);
                    if (iN0 == -1) {
                        this.f143035a = strD.length();
                        AbstractJsonLexer.x(this, "Expected end of the block comment: \"*/\", but had EOF instead", 0, null, 6, null);
                        throw new KotlinNothingValueException();
                    }
                    iM0 = iN0 + 2;
                } else {
                    if (cCharAt2 != '/') {
                        break;
                    }
                    iM0 = StringsKt.m0(strD, '\n', iM0 + 2, false, 4, null);
                    iM0 = iM0 == -1 ? strD.length() : iM0 + 1;
                }
            }
        }
        this.f143035a = iM0;
        return iM0;
    }

    @Override // kotlinx.serialization.json.internal.StringJsonLexer, kotlinx.serialization.json.internal.AbstractJsonLexer
    public boolean e() {
        int iL = L();
        if (iL >= D().length() || iL == -1) {
            return false;
        }
        return F(D().charAt(iL));
    }

    @Override // kotlinx.serialization.json.internal.StringJsonLexer, kotlinx.serialization.json.internal.AbstractJsonLexer
    public byte j() {
        String strD = D();
        int iL = L();
        if (iL >= strD.length() || iL == -1) {
            return (byte) 10;
        }
        this.f143035a = iL + 1;
        return AbstractJsonLexerKt.a(strD.charAt(iL));
    }

    @Override // kotlinx.serialization.json.internal.StringJsonLexer, kotlinx.serialization.json.internal.AbstractJsonLexer
    public void l(char c3) {
        String strD = D();
        int iL = L();
        if (iL >= strD.length() || iL == -1) {
            this.f143035a = -1;
            R(c3);
        }
        char cCharAt = strD.charAt(iL);
        this.f143035a = iL + 1;
        if (cCharAt == c3) {
            return;
        }
        R(c3);
    }
}
