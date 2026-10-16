package androidx.glance.color;

import androidx.glance.R;
import androidx.glance.unit.ColorProviderKt;
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
public final class DynamicThemeColorProviders extends ColorProviders {
    public static final DynamicThemeColorProviders B = new DynamicThemeColorProviders();

    private DynamicThemeColorProviders() {
        super(ColorProviderKt.a(R.color.f37645q), ColorProviderKt.a(R.color.f37635g), ColorProviderKt.a(R.color.f37646r), ColorProviderKt.a(R.color.f37636h), ColorProviderKt.a(R.color.f37648t), ColorProviderKt.a(R.color.f37637i), ColorProviderKt.a(R.color.f37649u), ColorProviderKt.a(R.color.f37638j), ColorProviderKt.a(R.color.f37653y), ColorProviderKt.a(R.color.f37642n), ColorProviderKt.a(R.color.f37654z), ColorProviderKt.a(R.color.f37643o), ColorProviderKt.a(R.color.f37630b), ColorProviderKt.a(R.color.f37631c), ColorProviderKt.a(R.color.f37633e), ColorProviderKt.a(R.color.f37634f), ColorProviderKt.a(R.color.f37629a), ColorProviderKt.a(R.color.f37632d), ColorProviderKt.a(R.color.f37650v), ColorProviderKt.a(R.color.f37639k), ColorProviderKt.a(R.color.f37652x), ColorProviderKt.a(R.color.f37641m), ColorProviderKt.a(R.color.f37644p), ColorProviderKt.a(R.color.f37640l), ColorProviderKt.a(R.color.f37651w), ColorProviderKt.a(R.color.f37647s), null);
    }
}
