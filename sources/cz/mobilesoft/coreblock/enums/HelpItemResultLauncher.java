package cz.mobilesoft.coreblock.enums;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import cz.mobilesoft.coreblock.enums.HelpItemResultLauncher;
import cz.mobilesoft.coreblock.util.helperextension.ContextExtKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class HelpItemResultLauncher {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f96984d = new Companion(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f96985e = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ComponentActivity f96986a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ActivityResultLauncher f96987b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private HelpItem f96988c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(HelpItemResultLauncher helpItemResultLauncher, Function2 function2, ActivityResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            HelpItem helpItem = helpItemResultLauncher.f96988c;
            if (helpItem != null) {
                function2.invoke(helpItem, result);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit f(HelpItemResultLauncher helpItemResultLauncher, Function2 function2, ActivityResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            HelpItem helpItem = helpItemResultLauncher.f96988c;
            if (helpItem != null) {
                function2.invoke(helpItem, result);
            }
            return Unit.f139807a;
        }

        public final HelpItemResultLauncher c(ComponentActivity activity, final Function2 onActivityResult) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(onActivityResult, "onActivityResult");
            final HelpItemResultLauncher helpItemResultLauncher = new HelpItemResultLauncher(activity, null);
            helpItemResultLauncher.e(activity.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: cz.mobilesoft.coreblock.enums.n
                @Override // androidx.activity.result.ActivityResultCallback
                public final void onActivityResult(Object obj) {
                    HelpItemResultLauncher.Companion.d(helpItemResultLauncher, onActivityResult, (ActivityResult) obj);
                }
            }));
            return helpItemResultLauncher;
        }

        public final HelpItemResultLauncher e(final Function2 onActivityResult, Composer composer, int i3) {
            Intrinsics.checkNotNullParameter(onActivityResult, "onActivityResult");
            if (ComposerKt.M()) {
                ComposerKt.U(1725850890, i3, -1, "cz.mobilesoft.coreblock.enums.HelpItemResultLauncher.Companion.remember (HelpItem.kt:155)");
            }
            composer.a0(685336253);
            Activity activityB = ContextExtKt.b((Context) composer.q(AndroidCompositionLocals_androidKt.g()));
            Intrinsics.checkNotNull(activityB, "null cannot be cast to non-null type androidx.activity.ComponentActivity");
            final HelpItemResultLauncher helpItemResultLauncher = new HelpItemResultLauncher((ComponentActivity) activityB, null);
            ActivityResultContracts.StartActivityForResult startActivityForResult = new ActivityResultContracts.StartActivityForResult();
            boolean zI = ((((i3 & 14) ^ 6) > 4 && composer.Z(onActivityResult)) || (i3 & 6) == 4) | composer.I(helpItemResultLauncher);
            Object objG = composer.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.enums.o
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return HelpItemResultLauncher.Companion.f(helpItemResultLauncher, onActivityResult, (ActivityResult) obj);
                    }
                };
                composer.w(objG);
            }
            helpItemResultLauncher.e(ActivityResultRegistryKt.a(startActivityForResult, (Function1) objG, composer, 0));
            composer.U();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            return helpItemResultLauncher;
        }

        private Companion() {
        }
    }

    public /* synthetic */ HelpItemResultLauncher(ComponentActivity componentActivity, DefaultConstructorMarker defaultConstructorMarker) {
        this(componentActivity);
    }

    public final ComponentActivity b() {
        return this.f96986a;
    }

    public final ActivityResultLauncher c() {
        ActivityResultLauncher activityResultLauncher = this.f96987b;
        if (activityResultLauncher != null) {
            return activityResultLauncher;
        }
        Intrinsics.throwUninitializedPropertyAccessException("launcher");
        return null;
    }

    public final void d(HelpItem item, Intent intent) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(intent, "intent");
        this.f96988c = item;
        c().b(intent);
    }

    public final void e(ActivityResultLauncher activityResultLauncher) {
        Intrinsics.checkNotNullParameter(activityResultLauncher, "<set-?>");
        this.f96987b = activityResultLauncher;
    }

    private HelpItemResultLauncher(ComponentActivity componentActivity) {
        this.f96986a = componentActivity;
    }
}
