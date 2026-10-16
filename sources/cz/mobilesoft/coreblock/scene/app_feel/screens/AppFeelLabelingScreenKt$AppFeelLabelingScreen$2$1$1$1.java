package cz.mobilesoft.coreblock.scene.app_feel.screens;

import androidx.compose.runtime.MutableState;
import cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.app_feel.screens.AppFeelLabelingScreenKt$AppFeelLabelingScreen$2$1$1$1", f = "AppFeelLabelingScreen.kt", l = {209, 213, 214, 215}, m = "invokeSuspend", v = 1)
final class AppFeelLabelingScreenKt$AppFeelLabelingScreen$2$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    float f98675a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f98676b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f98677c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ AppFeelViewState f98678d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ SwipeCardState f98679f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ MutableState f98680g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AppFeelLabelingScreenKt$AppFeelLabelingScreen$2$1$1$1(AppFeelViewState appFeelViewState, SwipeCardState swipeCardState, MutableState mutableState, Continuation continuation) {
        super(2, continuation);
        this.f98678d = appFeelViewState;
        this.f98679f = swipeCardState;
        this.f98680g = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new AppFeelLabelingScreenKt$AppFeelLabelingScreen$2$1$1$1(this.f98678d, this.f98679f, this.f98680g, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00f1, code lost:
    
        if (androidx.compose.animation.core.Animatable.f(r1, r3, r2, null, null, r14, 12, null) != r8) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d0  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 252
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.app_feel.screens.AppFeelLabelingScreenKt$AppFeelLabelingScreen$2$1$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((AppFeelLabelingScreenKt$AppFeelLabelingScreen$2$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
