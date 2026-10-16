package androidx.activity.compose;

import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

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
public final class ActivityResultRegistryKt {
    public static final ManagedActivityResultLauncher a(ActivityResultContract activityResultContract, Function1 function1, Composer composer, int i3) {
        ActivityResultRegistry activityResultRegistry;
        String str;
        if (ComposerKt.M()) {
            ComposerKt.U(-1408504823, i3, -1, "androidx.activity.compose.rememberLauncherForActivityResult (ActivityResultRegistry.kt:82)");
        }
        State stateP = SnapshotStateKt.p(activityResultContract, composer, i3 & 14);
        State stateP2 = SnapshotStateKt.p(function1, composer, (i3 >> 3) & 14);
        String str2 = (String) RememberSaveableKt.e(new Object[0], null, null, new Function0<String>() { // from class: androidx.activity.compose.ActivityResultRegistryKt$rememberLauncherForActivityResult$key$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return UUID.randomUUID().toString();
            }
        }, composer, 3072, 6);
        ActivityResultRegistryOwner activityResultRegistryOwnerA = LocalActivityResultRegistryOwner.f452a.a(composer, 6);
        if (activityResultRegistryOwnerA == null) {
            throw new IllegalStateException("No ActivityResultRegistryOwner was provided via LocalActivityResultRegistryOwner");
        }
        ActivityResultRegistry activityResultRegistry2 = activityResultRegistryOwnerA.getActivityResultRegistry();
        Object objG = composer.G();
        Composer.Companion companion = Composer.f23746a;
        if (objG == companion.a()) {
            objG = new ActivityResultLauncherHolder();
            composer.w(objG);
        }
        ActivityResultLauncherHolder activityResultLauncherHolder = (ActivityResultLauncherHolder) objG;
        Object objG2 = composer.G();
        if (objG2 == companion.a()) {
            objG2 = new ManagedActivityResultLauncher(activityResultLauncherHolder, stateP);
            composer.w(objG2);
        }
        ManagedActivityResultLauncher managedActivityResultLauncher = (ManagedActivityResultLauncher) objG2;
        boolean zI = composer.I(activityResultLauncherHolder) | composer.I(activityResultRegistry2) | composer.Z(str2) | composer.I(activityResultContract) | composer.Z(stateP2);
        Object objG3 = composer.G();
        if (zI || objG3 == companion.a()) {
            activityResultRegistry = activityResultRegistry2;
            Object activityResultRegistryKt$rememberLauncherForActivityResult$1$1 = new ActivityResultRegistryKt$rememberLauncherForActivityResult$1$1(activityResultLauncherHolder, activityResultRegistry, str2, activityResultContract, stateP2);
            str = str2;
            composer.w(activityResultRegistryKt$rememberLauncherForActivityResult$1$1);
            objG3 = activityResultRegistryKt$rememberLauncherForActivityResult$1$1;
        } else {
            str = str2;
            activityResultRegistry = activityResultRegistry2;
        }
        ActivityResultRegistry activityResultRegistry3 = activityResultRegistry;
        EffectsKt.a(activityResultRegistry3, str, activityResultContract, (Function1) objG3, composer, (i3 << 6) & 896);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return managedActivityResultLauncher;
    }
}
