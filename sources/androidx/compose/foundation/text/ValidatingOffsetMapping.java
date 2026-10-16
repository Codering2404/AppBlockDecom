package androidx.compose.foundation.text;

import androidx.compose.ui.text.input.OffsetMapping;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
final class ValidatingOffsetMapping implements OffsetMapping {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final OffsetMapping f10080b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f10081c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f10082d;

    public ValidatingOffsetMapping(OffsetMapping offsetMapping, int i3, int i4) {
        this.f10080b = offsetMapping;
        this.f10081c = i3;
        this.f10082d = i4;
    }

    @Override // androidx.compose.ui.text.input.OffsetMapping
    public int a(int i3) {
        int iA = this.f10080b.a(i3);
        if (i3 >= 0 && i3 <= this.f10082d) {
            ValidatingOffsetMappingKt.h(iA, this.f10081c, i3);
        }
        return iA;
    }

    @Override // androidx.compose.ui.text.input.OffsetMapping
    public int b(int i3) {
        int iB = this.f10080b.b(i3);
        if (i3 >= 0 && i3 <= this.f10081c) {
            ValidatingOffsetMappingKt.g(iB, this.f10082d, i3);
        }
        return iB;
    }
}
