package androidx.compose.runtime.saveable;

import androidx.collection.MutableScatterMap;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.text.CharsKt;

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
public final class SaveableStateRegistryKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ProvidableCompositionLocal f24883a = CompositionLocalKt.g(new Function0<SaveableStateRegistry>() { // from class: androidx.compose.runtime.saveable.SaveableStateRegistryKt$LocalSaveableStateRegistry$1
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final SaveableStateRegistry invoke() {
            return null;
        }
    });

    public static final SaveableStateRegistry a(Map map, Function1 function1) {
        return new SaveableStateRegistryImpl(map, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i3 = 0; i3 < length; i3++) {
            if (!CharsKt.b(charSequence.charAt(i3))) {
                return false;
            }
        }
        return true;
    }

    public static final ProvidableCompositionLocal e() {
        return f24883a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableScatterMap f(Map map) {
        MutableScatterMap mutableScatterMap = new MutableScatterMap(map.size());
        mutableScatterMap.t(map);
        return mutableScatterMap;
    }
}
