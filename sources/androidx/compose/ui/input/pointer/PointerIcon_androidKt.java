package androidx.compose.ui.input.pointer;

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
public final class PointerIcon_androidKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final PointerIcon f26853a = new AndroidPointerIconType(1000);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final PointerIcon f26854b = new AndroidPointerIconType(1007);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final PointerIcon f26855c = new AndroidPointerIconType(1008);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final PointerIcon f26856d = new AndroidPointerIconType(1002);

    public static final PointerIcon a(int i3) {
        return new AndroidPointerIconType(i3);
    }

    public static final PointerIcon b() {
        return f26854b;
    }

    public static final PointerIcon c() {
        return f26853a;
    }

    public static final PointerIcon d() {
        return f26856d;
    }

    public static final PointerIcon e() {
        return f26855c;
    }
}
