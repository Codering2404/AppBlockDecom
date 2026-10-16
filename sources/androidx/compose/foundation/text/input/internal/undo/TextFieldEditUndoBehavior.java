package androidx.compose.foundation.text.input.internal.undo;

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
public final class TextFieldEditUndoBehavior {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TextFieldEditUndoBehavior f10976a = new TextFieldEditUndoBehavior("MergeIfPossible", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final TextFieldEditUndoBehavior f10977b = new TextFieldEditUndoBehavior("ClearHistory", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final TextFieldEditUndoBehavior f10978c = new TextFieldEditUndoBehavior("NeverMerge", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ TextFieldEditUndoBehavior[] f10979d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ EnumEntries f10980f;

    static {
        TextFieldEditUndoBehavior[] textFieldEditUndoBehaviorArrA = a();
        f10979d = textFieldEditUndoBehaviorArrA;
        f10980f = EnumEntriesKt.a(textFieldEditUndoBehaviorArrA);
    }

    private TextFieldEditUndoBehavior(String str, int i3) {
    }

    private static final /* synthetic */ TextFieldEditUndoBehavior[] a() {
        return new TextFieldEditUndoBehavior[]{f10976a, f10977b, f10978c};
    }

    public static TextFieldEditUndoBehavior valueOf(String str) {
        return (TextFieldEditUndoBehavior) Enum.valueOf(TextFieldEditUndoBehavior.class, str);
    }

    public static TextFieldEditUndoBehavior[] values() {
        return (TextFieldEditUndoBehavior[]) f10979d.clone();
    }
}
