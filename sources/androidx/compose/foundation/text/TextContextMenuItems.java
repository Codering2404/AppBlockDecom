package androidx.compose.foundation.text;

import android.R;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.res.StringResources_androidKt;
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
public final class TextContextMenuItems {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final TextContextMenuItems f9893b = new TextContextMenuItems("Cut", 0, R.string.cut);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final TextContextMenuItems f9894c = new TextContextMenuItems("Copy", 1, R.string.copy);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final TextContextMenuItems f9895d = new TextContextMenuItems("Paste", 2, R.string.paste);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final TextContextMenuItems f9896f = new TextContextMenuItems("SelectAll", 3, R.string.selectAll);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final TextContextMenuItems f9897g = new TextContextMenuItems("Autofill", 4, R.string.autofill);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final /* synthetic */ TextContextMenuItems[] f9898h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ EnumEntries f9899i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f9900a;

    static {
        TextContextMenuItems[] textContextMenuItemsArrA = a();
        f9898h = textContextMenuItemsArrA;
        f9899i = EnumEntriesKt.a(textContextMenuItemsArrA);
    }

    private TextContextMenuItems(String str, int i3, int i4) {
        this.f9900a = i4;
    }

    private static final /* synthetic */ TextContextMenuItems[] a() {
        return new TextContextMenuItems[]{f9893b, f9894c, f9895d, f9896f, f9897g};
    }

    public static TextContextMenuItems valueOf(String str) {
        return (TextContextMenuItems) Enum.valueOf(TextContextMenuItems.class, str);
    }

    public static TextContextMenuItems[] values() {
        return (TextContextMenuItems[]) f9898h.clone();
    }

    public final String b(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-309609081, i3, -1, "androidx.compose.foundation.text.TextContextMenuItems.resolvedString (ContextMenu.android.kt:131)");
        }
        String strB = StringResources_androidKt.b(this.f9900a, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return strB;
    }
}
