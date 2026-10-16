package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CharIterator;
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
public final class CharProgressionIterator extends CharIterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f140196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f140197b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f140198c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f140199d;

    public CharProgressionIterator(char c3, char c4, int i3) {
        this.f140196a = i3;
        this.f140197b = c4;
        boolean z2 = false;
        if (i3 <= 0 ? Intrinsics.compare((int) c3, (int) c4) >= 0 : Intrinsics.compare((int) c3, (int) c4) <= 0) {
            z2 = true;
        }
        this.f140198c = z2;
        this.f140199d = z2 ? c3 : c4;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f140198c;
    }

    @Override // kotlin.collections.CharIterator
    public char nextChar() {
        int i3 = this.f140199d;
        if (i3 != this.f140197b) {
            this.f140199d = this.f140196a + i3;
        } else {
            if (!this.f140198c) {
                throw new NoSuchElementException();
            }
            this.f140198c = false;
        }
        return (char) i3;
    }
}
