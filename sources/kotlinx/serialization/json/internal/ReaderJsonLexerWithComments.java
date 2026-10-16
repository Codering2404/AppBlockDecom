package kotlinx.serialization.json.internal;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
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
public final class ReaderJsonLexerWithComments extends ReaderJsonLexer {
    private final Pair W(int i3) {
        int i4 = i3 + 2;
        char cCharAt = D().charAt(i3 + 1);
        if (cCharAt != '*') {
            if (cCharAt != '/') {
                return TuplesKt.a(Integer.valueOf(i3), Boolean.FALSE);
            }
            int iJ = i4;
            while (i3 != -1) {
                int iM0 = StringsKt.m0(D(), '\n', iJ, false, 4, null);
                if (iM0 != -1) {
                    return TuplesKt.a(Integer.valueOf(iM0 + 1), Boolean.TRUE);
                }
                iJ = J(D().length());
                i3 = iJ;
            }
            return TuplesKt.a(-1, Boolean.TRUE);
        }
        boolean z2 = false;
        int iX = i4;
        while (i3 != -1) {
            int iN0 = StringsKt.n0(D(), "*/", iX, false, 4, null);
            if (iN0 != -1) {
                return TuplesKt.a(Integer.valueOf(iN0 + 2), Boolean.TRUE);
            }
            if (D().charAt(D().length() - 1) == '*') {
                iX = X(D().length() - 1);
                if (z2) {
                    break;
                }
                z2 = true;
            } else {
                iX = J(D().length());
            }
            i3 = iX;
        }
        this.f143035a = D().length();
        AbstractJsonLexer.x(this, "Expected end of the block comment: \"*/\", but had EOF instead", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    private final int X(int i3) {
        if (D().length() - i3 > this.f143144f) {
            return i3;
        }
        this.f143035a = i3;
        u();
        return (this.f143035a != 0 || D().length() == 0) ? -1 : 0;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public byte H() {
        u();
        ArrayAsSequence arrayAsSequenceD = D();
        int iL = L();
        if (iL >= arrayAsSequenceD.length() || iL == -1) {
            return (byte) 10;
        }
        this.f143035a = iL;
        return AbstractJsonLexerKt.a(arrayAsSequenceD.charAt(iL));
    }

    @Override // kotlinx.serialization.json.internal.ReaderJsonLexer, kotlinx.serialization.json.internal.AbstractJsonLexer
    public int L() {
        int iJ;
        int i3 = this.f143035a;
        while (true) {
            iJ = J(i3);
            if (iJ == -1) {
                break;
            }
            char cCharAt = D().charAt(iJ);
            if (cCharAt == ' ' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == '\t') {
                i3 = iJ + 1;
            } else {
                if (cCharAt != '/' || iJ + 1 >= D().length()) {
                    break;
                }
                Pair pairW = W(iJ);
                int iIntValue = ((Number) pairW.a()).intValue();
                if (!((Boolean) pairW.b()).booleanValue()) {
                    iJ = iIntValue;
                    break;
                }
                i3 = iIntValue;
            }
        }
        this.f143035a = iJ;
        return iJ;
    }

    @Override // kotlinx.serialization.json.internal.ReaderJsonLexer, kotlinx.serialization.json.internal.AbstractJsonLexer
    public boolean e() {
        u();
        int iL = L();
        if (iL >= D().length() || iL == -1) {
            return false;
        }
        return F(D().charAt(iL));
    }

    @Override // kotlinx.serialization.json.internal.ReaderJsonLexer, kotlinx.serialization.json.internal.AbstractJsonLexer
    public byte j() {
        u();
        ArrayAsSequence arrayAsSequenceD = D();
        int iL = L();
        if (iL >= arrayAsSequenceD.length() || iL == -1) {
            return (byte) 10;
        }
        this.f143035a = iL + 1;
        return AbstractJsonLexerKt.a(arrayAsSequenceD.charAt(iL));
    }

    @Override // kotlinx.serialization.json.internal.ReaderJsonLexer, kotlinx.serialization.json.internal.AbstractJsonLexer
    public void l(char c3) {
        u();
        ArrayAsSequence arrayAsSequenceD = D();
        int iL = L();
        if (iL >= arrayAsSequenceD.length() || iL == -1) {
            this.f143035a = -1;
            R(c3);
        }
        char cCharAt = arrayAsSequenceD.charAt(iL);
        this.f143035a = iL + 1;
        if (cCharAt == c3) {
            return;
        }
        R(c3);
    }
}
