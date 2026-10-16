package androidx.compose.ui.layout;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
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
public final class IntrinsicWidthHeight {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final IntrinsicWidthHeight f27072a = new IntrinsicWidthHeight("Width", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final IntrinsicWidthHeight f27073b = new IntrinsicWidthHeight("Height", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ IntrinsicWidthHeight[] f27074c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ EnumEntries f27075d;

    static {
        IntrinsicWidthHeight[] intrinsicWidthHeightArrA = a();
        f27074c = intrinsicWidthHeightArrA;
        f27075d = EnumEntriesKt.a(intrinsicWidthHeightArrA);
    }

    private IntrinsicWidthHeight(String str, int i3) {
    }

    private static final /* synthetic */ IntrinsicWidthHeight[] a() {
        return new IntrinsicWidthHeight[]{f27072a, f27073b};
    }

    public static IntrinsicWidthHeight valueOf(String str) {
        return (IntrinsicWidthHeight) Enum.valueOf(IntrinsicWidthHeight.class, str);
    }

    public static IntrinsicWidthHeight[] values() {
        return (IntrinsicWidthHeight[]) f27074c.clone();
    }
}
