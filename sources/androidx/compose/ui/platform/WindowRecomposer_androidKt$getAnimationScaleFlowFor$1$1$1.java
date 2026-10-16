package androidx.compose.ui.platform;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.flow.FlowCollector;

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
@DebugMetadata(c = "androidx.compose.ui.platform.WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1", f = "WindowRecomposer.android.kt", l = {114, 121}, m = "invokeSuspend")
final class WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1 extends SuspendLambda implements Function2<FlowCollector<? super Float>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f28312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f28313b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private /* synthetic */ Object f28314c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ ContentResolver f28315d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Uri f28316f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1 f28317g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ Channel f28318h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ Context f28319i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1(ContentResolver contentResolver, Uri uri, WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1 windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1, Channel channel, Context context, Continuation continuation) {
        super(2, continuation);
        this.f28315d = contentResolver;
        this.f28316f = uri;
        this.f28317g = windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1;
        this.f28318h = channel;
        this.f28319i = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1 windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1 = new WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1(this.f28315d, this.f28316f, this.f28317g, this.f28318h, this.f28319i, continuation);
        windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1.f28314c = obj;
        return windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x007f, code lost:
    
        if (r4.emit(r9, r8) == r0) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0060 A[Catch: all -> 0x001b, TRY_LEAVE, TryCatch #0 {all -> 0x001b, blocks: (B:7:0x0016, B:18:0x0048, B:22:0x0058, B:24:0x0060, B:14:0x002d, B:17:0x0042), top: B:31:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0082  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x007f -> B:8:0x0019). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r8.f28313b
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L31
            if (r1 == r3) goto L25
            if (r1 != r2) goto L1d
            java.lang.Object r1 = r8.f28312a
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r4 = r8.f28314c
            kotlinx.coroutines.flow.FlowCollector r4 = (kotlinx.coroutines.flow.FlowCollector) r4
            kotlin.ResultKt.b(r9)     // Catch: java.lang.Throwable -> L1b
        L19:
            r9 = r4
            goto L48
        L1b:
            r9 = move-exception
            goto L8c
        L1d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L25:
            java.lang.Object r1 = r8.f28312a
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r4 = r8.f28314c
            kotlinx.coroutines.flow.FlowCollector r4 = (kotlinx.coroutines.flow.FlowCollector) r4
            kotlin.ResultKt.b(r9)     // Catch: java.lang.Throwable -> L1b
            goto L58
        L31:
            kotlin.ResultKt.b(r9)
            java.lang.Object r9 = r8.f28314c
            kotlinx.coroutines.flow.FlowCollector r9 = (kotlinx.coroutines.flow.FlowCollector) r9
            android.content.ContentResolver r1 = r8.f28315d
            android.net.Uri r4 = r8.f28316f
            r5 = 0
            androidx.compose.ui.platform.WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1 r6 = r8.f28317g
            r1.registerContentObserver(r4, r5, r6)
            kotlinx.coroutines.channels.Channel r1 = r8.f28318h     // Catch: java.lang.Throwable -> L1b
            kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L1b
        L48:
            r8.f28314c = r9     // Catch: java.lang.Throwable -> L1b
            r8.f28312a = r1     // Catch: java.lang.Throwable -> L1b
            r8.f28313b = r3     // Catch: java.lang.Throwable -> L1b
            java.lang.Object r4 = r1.a(r8)     // Catch: java.lang.Throwable -> L1b
            if (r4 != r0) goto L55
            goto L81
        L55:
            r7 = r4
            r4 = r9
            r9 = r7
        L58:
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch: java.lang.Throwable -> L1b
            boolean r9 = r9.booleanValue()     // Catch: java.lang.Throwable -> L1b
            if (r9 == 0) goto L82
            r1.next()     // Catch: java.lang.Throwable -> L1b
            android.content.Context r9 = r8.f28319i     // Catch: java.lang.Throwable -> L1b
            android.content.ContentResolver r9 = r9.getContentResolver()     // Catch: java.lang.Throwable -> L1b
            java.lang.String r5 = "animator_duration_scale"
            r6 = 1065353216(0x3f800000, float:1.0)
            float r9 = android.provider.Settings.Global.getFloat(r9, r5, r6)     // Catch: java.lang.Throwable -> L1b
            java.lang.Float r9 = kotlin.coroutines.jvm.internal.Boxing.c(r9)     // Catch: java.lang.Throwable -> L1b
            r8.f28314c = r4     // Catch: java.lang.Throwable -> L1b
            r8.f28312a = r1     // Catch: java.lang.Throwable -> L1b
            r8.f28313b = r2     // Catch: java.lang.Throwable -> L1b
            java.lang.Object r9 = r4.emit(r9, r8)     // Catch: java.lang.Throwable -> L1b
            if (r9 != r0) goto L19
        L81:
            return r0
        L82:
            android.content.ContentResolver r9 = r8.f28315d
            androidx.compose.ui.platform.WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1 r0 = r8.f28317g
            r9.unregisterContentObserver(r0)
            kotlin.Unit r9 = kotlin.Unit.f139807a
            return r9
        L8c:
            android.content.ContentResolver r0 = r8.f28315d
            androidx.compose.ui.platform.WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1 r1 = r8.f28317g
            r0.unregisterContentObserver(r1)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector flowCollector, Continuation continuation) {
        return ((WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1) create(flowCollector, continuation)).invokeSuspend(Unit.f139807a);
    }
}
