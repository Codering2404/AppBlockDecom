package androidx.activity.compose;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

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
final class ActivityResultRegistryKt$rememberLauncherForActivityResult$1$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ActivityResultLauncherHolder f431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ActivityResultRegistry f432b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f433c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ ActivityResultContract f434d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ State f435f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ActivityResultRegistryKt$rememberLauncherForActivityResult$1$1(ActivityResultLauncherHolder activityResultLauncherHolder, ActivityResultRegistry activityResultRegistry, String str, ActivityResultContract activityResultContract, State state) {
        super(1);
        this.f431a = activityResultLauncherHolder;
        this.f432b = activityResultRegistry;
        this.f433c = str;
        this.f434d = activityResultContract;
        this.f435f = state;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(State state, Object obj) {
        ((Function1) state.getValue()).invoke(obj);
    }

    @Override // kotlin.jvm.functions.Function1
    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
        ActivityResultLauncherHolder activityResultLauncherHolder = this.f431a;
        ActivityResultRegistry activityResultRegistry = this.f432b;
        String str = this.f433c;
        ActivityResultContract activityResultContract = this.f434d;
        final State state = this.f435f;
        activityResultLauncherHolder.b(activityResultRegistry.l(str, activityResultContract, new ActivityResultCallback() { // from class: androidx.activity.compose.a
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ActivityResultRegistryKt$rememberLauncherForActivityResult$1$1.d(state, obj);
            }
        }));
        final ActivityResultLauncherHolder activityResultLauncherHolder2 = this.f431a;
        return new DisposableEffectResult() { // from class: androidx.activity.compose.ActivityResultRegistryKt$rememberLauncherForActivityResult$1$1$invoke$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                activityResultLauncherHolder2.c();
            }
        };
    }
}
