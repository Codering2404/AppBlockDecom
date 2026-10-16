package cz.mobilesoft.coreblock.storage.sharedprefs;

import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class IntPref extends PrefDelegate<Integer> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IntPref(Function0 holder, String key, boolean z2, Function0 defaultValue, Function2 function2) {
        super(holder, key, z2, defaultValue, function2);
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int h() {
        return 0;
    }

    public Integer i(Object obj, KProperty property) {
        Intrinsics.checkNotNullParameter(property, "property");
        return Integer.valueOf(((PreferencesHolder) b().invoke()).c(c(), ((Number) a().invoke()).intValue()));
    }

    public void j(Object obj, KProperty property, int i3) {
        Intrinsics.checkNotNullParameter(property, "property");
        super.f(obj, property, Integer.valueOf(i3));
        SharedPreferences.Editor editorH = ((PreferencesHolder) b().invoke()).h(c(), i3);
        Intrinsics.checkNotNullExpressionValue(editorH, "putInt(...)");
        e(editorH);
    }

    public /* synthetic */ IntPref(Function0 function0, String str, boolean z2, Function0 function02, Function2 function2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, str, (i3 & 4) != 0 ? false : z2, (i3 & 8) != 0 ? new Function0() { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(IntPref.h());
            }
        } : function02, (i3 & 16) != 0 ? null : function2);
    }
}
