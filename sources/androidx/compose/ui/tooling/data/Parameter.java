package androidx.compose.ui.tooling.data;

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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
final class Parameter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f29927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f29928b;

    public Parameter(int i3, String str) {
        this.f29927a = i3;
        this.f29928b = str;
    }

    public final String a() {
        return this.f29928b;
    }

    public final int b() {
        return this.f29927a;
    }

    public /* synthetic */ Parameter(int i3, String str, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i4 & 2) != 0 ? null : str);
    }
}
