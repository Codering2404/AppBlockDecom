package cz.mobilesoft.coreblock.scene.app_feel.screens;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.app_feel.screens.AppFeelLabelingScreenKt$SwipeCard$3$1$2$1", f = "AppFeelLabelingScreen.kt", l = {613}, m = "invokeSuspend", v = 1)
final class AppFeelLabelingScreenKt$SwipeCard$3$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    float f98706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    float f98707b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f98708c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ SwipeCardState f98709d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Function0 f98710f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Function0 f98711g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ Function0 f98712h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AppFeelLabelingScreenKt$SwipeCard$3$1$2$1(SwipeCardState swipeCardState, Function0 function0, Function0 function02, Function0 function03, Continuation continuation) {
        super(2, continuation);
        this.f98709d = swipeCardState;
        this.f98710f = function0;
        this.f98711g = function02;
        this.f98712h = function03;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new AppFeelLabelingScreenKt$SwipeCard$3$1$2$1(this.f98709d, this.f98710f, this.f98711g, this.f98712h, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0078 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0079  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
        /*
            r13 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r13.f98708c
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L1b
            if (r1 != r2) goto L13
            float r0 = r13.f98707b
            kotlin.ResultKt.b(r14)
            r10 = r13
            goto L7a
        L13:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L1b:
            kotlin.ResultKt.b(r14)
            cz.mobilesoft.coreblock.scene.app_feel.screens.SwipeCardState r14 = r13.f98709d
            androidx.compose.animation.core.Animatable r14 = r14.b()
            java.lang.Object r14 = r14.n()
            java.lang.Number r14 = (java.lang.Number) r14
            float r14 = r14.floatValue()
            cz.mobilesoft.coreblock.scene.app_feel.screens.SwipeCardState r1 = r13.f98709d
            float r1 = r1.f()
            int r1 = (r14 > r1 ? 1 : (r14 == r1 ? 0 : -1))
            r4 = 1069547520(0x3fc00000, float:1.5)
            if (r1 <= 0) goto L42
            cz.mobilesoft.coreblock.scene.app_feel.screens.SwipeCardState r1 = r13.f98709d
            float r1 = r1.c()
        L40:
            float r1 = r1 * r4
            goto L56
        L42:
            cz.mobilesoft.coreblock.scene.app_feel.screens.SwipeCardState r1 = r13.f98709d
            float r1 = r1.f()
            float r1 = -r1
            int r1 = (r14 > r1 ? 1 : (r14 == r1 ? 0 : -1))
            if (r1 >= 0) goto L55
            cz.mobilesoft.coreblock.scene.app_feel.screens.SwipeCardState r1 = r13.f98709d
            float r1 = r1.c()
            float r1 = -r1
            goto L40
        L55:
            r1 = r3
        L56:
            cz.mobilesoft.coreblock.scene.app_feel.screens.SwipeCardState r4 = r13.f98709d
            androidx.compose.animation.core.Animatable r5 = r4.b()
            java.lang.Float r6 = kotlin.coroutines.jvm.internal.Boxing.c(r1)
            r4 = 7
            r7 = 0
            androidx.compose.animation.core.SpringSpec r7 = androidx.compose.animation.core.AnimationSpecKt.l(r3, r3, r7, r4, r7)
            r13.f98706a = r14
            r13.f98707b = r1
            r13.f98708c = r2
            r8 = 0
            r9 = 0
            r11 = 12
            r12 = 0
            r10 = r13
            java.lang.Object r14 = androidx.compose.animation.core.Animatable.f(r5, r6, r7, r8, r9, r10, r11, r12)
            if (r14 != r0) goto L79
            return r0
        L79:
            r0 = r1
        L7a:
            int r14 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r14 <= 0) goto L84
            kotlin.jvm.functions.Function0 r14 = r10.f98710f
            r14.invoke()
            goto L93
        L84:
            int r14 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r14 >= 0) goto L8e
            kotlin.jvm.functions.Function0 r14 = r10.f98711g
            r14.invoke()
            goto L93
        L8e:
            kotlin.jvm.functions.Function0 r14 = r10.f98712h
            r14.invoke()
        L93:
            kotlin.Unit r14 = kotlin.Unit.f139807a
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.app_feel.screens.AppFeelLabelingScreenKt$SwipeCard$3$1$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((AppFeelLabelingScreenKt$SwipeCard$3$1$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
