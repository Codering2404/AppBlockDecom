package kotlinx.serialization.json.internal;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

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
public class ReaderJsonLexer extends AbstractJsonLexer {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final InternalJsonReader f143143e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected int f143144f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ArrayAsSequence f143145g;

    private final void V(int i3) {
        char[] cArrB = D().b();
        if (i3 != 0) {
            int i4 = this.f143035a;
            ArraysKt.copyInto(cArrB, cArrB, 0, i4, i4 + i3);
        }
        int length = D().length();
        while (true) {
            if (i3 == length) {
                break;
            }
            int iA = this.f143143e.a(cArrB, i3, length - i3);
            if (iA == -1) {
                D().f(i3);
                this.f143144f = -1;
                break;
            }
            i3 += iA;
        }
        this.f143035a = 0;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public String G(String keyToMatch, boolean z2) {
        Intrinsics.checkNotNullParameter(keyToMatch, "keyToMatch");
        return null;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public int J(int i3) {
        if (i3 < D().length()) {
            return i3;
        }
        this.f143035a = i3;
        u();
        return (this.f143035a != 0 || D().length() == 0) ? -1 : 0;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public int L() {
        int iJ;
        char cCharAt;
        int i3 = this.f143035a;
        while (true) {
            iJ = J(i3);
            if (iJ == -1 || !((cCharAt = D().charAt(iJ)) == ' ' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == '\t')) {
                break;
            }
            i3 = iJ + 1;
        }
        this.f143035a = iJ;
        return iJ;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public String M(int i3, int i4) {
        return D().e(i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
    public ArrayAsSequence D() {
        return this.f143145g;
    }

    public int U(char c3, int i3) {
        ArrayAsSequence arrayAsSequenceD = D();
        int length = arrayAsSequenceD.length();
        while (i3 < length) {
            if (arrayAsSequenceD.charAt(i3) == c3) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    protected void d(int i3, int i4) {
        StringBuilder sbC = C();
        sbC.append(D().b(), i3, i4 - i3);
        Intrinsics.checkNotNullExpressionValue(sbC, "append(...)");
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public boolean e() {
        u();
        int i3 = this.f143035a;
        while (true) {
            int iJ = J(i3);
            if (iJ == -1) {
                this.f143035a = iJ;
                return false;
            }
            char cCharAt = D().charAt(iJ);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                this.f143035a = iJ;
                return F(cCharAt);
            }
            i3 = iJ + 1;
        }
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public String i() {
        l('\"');
        int i3 = this.f143035a;
        int iU = U('\"', i3);
        if (iU == -1) {
            int iJ = J(i3);
            if (iJ != -1) {
                return p(D(), this.f143035a, iJ);
            }
            AbstractJsonLexer.z(this, (byte) 1, false, 2, null);
            throw new KotlinNothingValueException();
        }
        for (int i4 = i3; i4 < iU; i4++) {
            if (D().charAt(i4) == '\\') {
                return p(D(), this.f143035a, i4);
            }
        }
        this.f143035a = iU + 1;
        return M(i3, iU);
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public byte j() {
        u();
        ArrayAsSequence arrayAsSequenceD = D();
        int i3 = this.f143035a;
        while (true) {
            int iJ = J(i3);
            if (iJ == -1) {
                this.f143035a = iJ;
                return (byte) 10;
            }
            int i4 = iJ + 1;
            byte bA = AbstractJsonLexerKt.a(arrayAsSequenceD.charAt(iJ));
            if (bA != 3) {
                this.f143035a = i4;
                return bA;
            }
            i3 = i4;
        }
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public void l(char c3) {
        u();
        ArrayAsSequence arrayAsSequenceD = D();
        int i3 = this.f143035a;
        while (true) {
            int iJ = J(i3);
            if (iJ == -1) {
                this.f143035a = iJ;
                R(c3);
                return;
            }
            int i4 = iJ + 1;
            char cCharAt = arrayAsSequenceD.charAt(iJ);
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
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public void u() {
        int length = D().length() - this.f143035a;
        if (length > this.f143144f) {
            return;
        }
        V(length);
    }
}
