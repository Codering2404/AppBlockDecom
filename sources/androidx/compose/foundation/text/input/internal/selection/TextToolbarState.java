package androidx.compose.foundation.text.input.internal.selection;

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
public final class TextToolbarState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TextToolbarState f10960a = new TextToolbarState("None", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final TextToolbarState f10961b = new TextToolbarState("Cursor", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final TextToolbarState f10962c = new TextToolbarState("Selection", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ TextToolbarState[] f10963d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ EnumEntries f10964f;

    static {
        TextToolbarState[] textToolbarStateArrA = a();
        f10963d = textToolbarStateArrA;
        f10964f = EnumEntriesKt.a(textToolbarStateArrA);
    }

    private TextToolbarState(String str, int i3) {
    }

    private static final /* synthetic */ TextToolbarState[] a() {
        return new TextToolbarState[]{f10960a, f10961b, f10962c};
    }

    public static TextToolbarState valueOf(String str) {
        return (TextToolbarState) Enum.valueOf(TextToolbarState.class, str);
    }

    public static TextToolbarState[] values() {
        return (TextToolbarState[]) f10963d.clone();
    }
}
