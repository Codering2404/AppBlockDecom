package androidx.navigation.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigator;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class NavHostControllerKt {
    public static final State a(NavController navController, Composer composer, int i3) {
        return NavHostControllerKt__NavHostControllerKt.a(navController, composer, i3);
    }

    public static final NavHostController b(Navigator[] navigatorArr, Composer composer, int i3) {
        return NavHostControllerKt__NavHostController_androidKt.h(navigatorArr, composer, i3);
    }
}
