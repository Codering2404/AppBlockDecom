package androidx.compose.animation.graphics.vector.compat;

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
final class ValueType {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ValueType f4484a = new ValueType("Float", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ValueType f4485b = new ValueType("Int", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ValueType f4486c = new ValueType("Color", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ValueType f4487d = new ValueType("Path", 3);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ ValueType[] f4488f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final /* synthetic */ EnumEntries f4489g;

    static {
        ValueType[] valueTypeArrA = a();
        f4488f = valueTypeArrA;
        f4489g = EnumEntriesKt.a(valueTypeArrA);
    }

    private ValueType(String str, int i3) {
    }

    private static final /* synthetic */ ValueType[] a() {
        return new ValueType[]{f4484a, f4485b, f4486c, f4487d};
    }

    public static ValueType valueOf(String str) {
        return (ValueType) Enum.valueOf(ValueType.class, str);
    }

    public static ValueType[] values() {
        return (ValueType[]) f4488f.clone();
    }
}
