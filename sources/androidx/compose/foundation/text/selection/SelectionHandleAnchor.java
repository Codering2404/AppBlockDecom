package androidx.compose.foundation.text.selection;

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
public final class SelectionHandleAnchor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SelectionHandleAnchor f11375a = new SelectionHandleAnchor("Left", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SelectionHandleAnchor f11376b = new SelectionHandleAnchor("Middle", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final SelectionHandleAnchor f11377c = new SelectionHandleAnchor("Right", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ SelectionHandleAnchor[] f11378d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ EnumEntries f11379f;

    static {
        SelectionHandleAnchor[] selectionHandleAnchorArrA = a();
        f11378d = selectionHandleAnchorArrA;
        f11379f = EnumEntriesKt.a(selectionHandleAnchorArrA);
    }

    private SelectionHandleAnchor(String str, int i3) {
    }

    private static final /* synthetic */ SelectionHandleAnchor[] a() {
        return new SelectionHandleAnchor[]{f11375a, f11376b, f11377c};
    }

    public static SelectionHandleAnchor valueOf(String str) {
        return (SelectionHandleAnchor) Enum.valueOf(SelectionHandleAnchor.class, str);
    }

    public static SelectionHandleAnchor[] values() {
        return (SelectionHandleAnchor[]) f11378d.clone();
    }
}
