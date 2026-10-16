package androidx.compose.ui.text.android;

import java.text.CharacterIterator;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class CharSequenceCharacterIterator implements CharacterIterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CharSequence f28941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f28942b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f28943c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f28944d;

    public CharSequenceCharacterIterator(CharSequence charSequence, int i3, int i4) {
        this.f28941a = charSequence;
        this.f28942b = i3;
        this.f28943c = i4;
        this.f28944d = i3;
    }

    @Override // java.text.CharacterIterator
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    @Override // java.text.CharacterIterator
    public char current() {
        int i3 = this.f28944d;
        if (i3 == this.f28943c) {
            return (char) 65535;
        }
        return this.f28941a.charAt(i3);
    }

    @Override // java.text.CharacterIterator
    public char first() {
        this.f28944d = this.f28942b;
        return current();
    }

    @Override // java.text.CharacterIterator
    public int getBeginIndex() {
        return this.f28942b;
    }

    @Override // java.text.CharacterIterator
    public int getEndIndex() {
        return this.f28943c;
    }

    @Override // java.text.CharacterIterator
    public int getIndex() {
        return this.f28944d;
    }

    @Override // java.text.CharacterIterator
    public char last() {
        int i3 = this.f28942b;
        int i4 = this.f28943c;
        if (i3 == i4) {
            this.f28944d = i4;
            return (char) 65535;
        }
        int i5 = i4 - 1;
        this.f28944d = i5;
        return this.f28941a.charAt(i5);
    }

    @Override // java.text.CharacterIterator
    public char next() {
        int i3 = this.f28944d + 1;
        this.f28944d = i3;
        int i4 = this.f28943c;
        if (i3 < i4) {
            return this.f28941a.charAt(i3);
        }
        this.f28944d = i4;
        return (char) 65535;
    }

    @Override // java.text.CharacterIterator
    public char previous() {
        int i3 = this.f28944d;
        if (i3 <= this.f28942b) {
            return (char) 65535;
        }
        int i4 = i3 - 1;
        this.f28944d = i4;
        return this.f28941a.charAt(i4);
    }

    @Override // java.text.CharacterIterator
    public char setIndex(int i3) {
        int i4 = this.f28942b;
        if (i3 > this.f28943c || i4 > i3) {
            throw new IllegalArgumentException("invalid position");
        }
        this.f28944d = i3;
        return current();
    }
}
