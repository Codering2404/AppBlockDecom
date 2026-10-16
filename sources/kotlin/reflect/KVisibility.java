package kotlin.reflect;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class KVisibility {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final KVisibility f140271a = new KVisibility("PUBLIC", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final KVisibility f140272b = new KVisibility("PROTECTED", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final KVisibility f140273c = new KVisibility("INTERNAL", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final KVisibility f140274d = new KVisibility("PRIVATE", 3);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ KVisibility[] f140275f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final /* synthetic */ EnumEntries f140276g;

    static {
        KVisibility[] kVisibilityArrA = a();
        f140275f = kVisibilityArrA;
        f140276g = EnumEntriesKt.a(kVisibilityArrA);
    }

    private KVisibility(String str, int i3) {
    }

    private static final /* synthetic */ KVisibility[] a() {
        return new KVisibility[]{f140271a, f140272b, f140273c, f140274d};
    }

    public static KVisibility valueOf(String str) {
        return (KVisibility) Enum.valueOf(KVisibility.class, str);
    }

    public static KVisibility[] values() {
        return (KVisibility[]) f140275f.clone();
    }
}
