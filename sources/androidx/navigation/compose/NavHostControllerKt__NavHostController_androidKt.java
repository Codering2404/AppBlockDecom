package androidx.navigation.compose;

import android.content.Context;
import android.os.Bundle;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigator;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
final /* synthetic */ class NavHostControllerKt__NavHostController_androidKt {
    private static final Saver d(final Context context) {
        return SaverKt.a(new Function2() { // from class: androidx.navigation.compose.k
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return NavHostControllerKt__NavHostController_androidKt.e((SaverScope) obj, (NavHostController) obj2);
            }
        }, new Function1() { // from class: androidx.navigation.compose.l
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NavHostControllerKt__NavHostController_androidKt.f(context, (Bundle) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bundle e(SaverScope saverScope, NavHostController navHostController) {
        return navHostController.Y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NavHostController f(Context context, Bundle bundle) {
        NavHostController navHostControllerG = g(context);
        navHostControllerG.X(bundle);
        return navHostControllerG;
    }

    private static final NavHostController g(Context context) {
        NavHostController navHostController = new NavHostController(context);
        navHostController.A().b(new ComposeNavGraphNavigator(navHostController.A()));
        navHostController.A().b(new ComposeNavigator());
        navHostController.A().b(new DialogNavigator());
        return navHostController;
    }

    public static final NavHostController h(Navigator[] navigatorArr, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-342848815, i3, -1, "androidx.navigation.compose.rememberNavController (NavHostController.android.kt:33)");
        }
        final Context context = (Context) composer.q(AndroidCompositionLocals_androidKt.g());
        Object[] objArrCopyOf = Arrays.copyOf(navigatorArr, navigatorArr.length);
        Saver saverD = d(context);
        boolean zI = composer.I(context);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: androidx.navigation.compose.j
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return NavHostControllerKt__NavHostController_androidKt.i(context);
                }
            };
            composer.w(objG);
        }
        NavHostController navHostController = (NavHostController) RememberSaveableKt.e(objArrCopyOf, saverD, null, (Function0) objG, composer, 0, 4);
        for (Navigator navigator : navigatorArr) {
            navHostController.A().b(navigator);
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return navHostController;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NavHostController i(Context context) {
        return g(context);
    }
}
