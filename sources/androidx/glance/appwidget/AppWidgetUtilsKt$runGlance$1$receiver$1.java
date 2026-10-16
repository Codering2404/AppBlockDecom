package androidx.glance.appwidget;

import androidx.glance.appwidget.ContentReceiver;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProducerScope;

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
final class AppWidgetUtilsKt$runGlance$1$receiver$1 implements ContentReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AtomicReference f37780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ProducerScope f37781b;

    AppWidgetUtilsKt$runGlance$1$receiver$1(AtomicReference atomicReference, ProducerScope producerScope) {
        this.f37780a = atomicReference;
        this.f37781b = producerScope;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.glance.appwidget.ContentReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object L(kotlin.jvm.functions.Function2 r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof androidx.glance.appwidget.AppWidgetUtilsKt$runGlance$1$receiver$1$provideContent$1
            if (r0 == 0) goto L13
            r0 = r8
            androidx.glance.appwidget.AppWidgetUtilsKt$runGlance$1$receiver$1$provideContent$1 r0 = (androidx.glance.appwidget.AppWidgetUtilsKt$runGlance$1$receiver$1$provideContent$1) r0
            int r1 = r0.f37787g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f37787g = r1
            goto L18
        L13:
            androidx.glance.appwidget.AppWidgetUtilsKt$runGlance$1$receiver$1$provideContent$1 r0 = new androidx.glance.appwidget.AppWidgetUtilsKt$runGlance$1$receiver$1$provideContent$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f37785d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f37787g
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 == r3) goto L2d
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L2d:
            java.lang.Object r7 = r0.f37784c
            kotlinx.coroutines.channels.ProducerScope r7 = (kotlinx.coroutines.channels.ProducerScope) r7
            java.lang.Object r7 = r0.f37783b
            java.util.concurrent.atomic.AtomicReference r7 = (java.util.concurrent.atomic.AtomicReference) r7
            java.lang.Object r7 = r0.f37782a
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            kotlin.ResultKt.b(r8)
            goto L83
        L3d:
            kotlin.ResultKt.b(r8)
            java.util.concurrent.atomic.AtomicReference r8 = r6.f37780a
            kotlinx.coroutines.channels.ProducerScope r2 = r6.f37781b
            r0.f37782a = r7
            r0.f37783b = r8
            r0.f37784c = r2
            r0.f37787g = r3
            kotlinx.coroutines.CancellableContinuationImpl r4 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.c(r0)
            r4.<init>(r5, r3)
            r4.C()
            androidx.glance.appwidget.AppWidgetUtilsKt$runGlance$1$receiver$1$provideContent$2$1 r5 = new androidx.glance.appwidget.AppWidgetUtilsKt$runGlance$1$receiver$1$provideContent$2$1
            r5.<init>()
            r4.m(r5)
            java.lang.Object r8 = r8.getAndSet(r4)
            kotlinx.coroutines.CancellableContinuation r8 = (kotlinx.coroutines.CancellableContinuation) r8
            if (r8 == 0) goto L70
            r5 = 0
            boolean r8 = kotlinx.coroutines.CancellableContinuation.DefaultImpls.a(r8, r5, r3, r5)
            kotlin.coroutines.jvm.internal.Boxing.a(r8)
        L70:
            r2.h(r7)
            java.lang.Object r7 = r4.v()
            java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            if (r7 != r8) goto L80
            kotlin.coroutines.jvm.internal.DebugProbesKt.c(r0)
        L80:
            if (r7 != r1) goto L83
            return r1
        L83:
            kotlin.KotlinNothingValueException r7 = new kotlin.KotlinNothingValueException
            r7.<init>()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.glance.appwidget.AppWidgetUtilsKt$runGlance$1$receiver$1.L(kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public Object fold(Object obj, Function2 function2) {
        return ContentReceiver.DefaultImpls.a(this, obj, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public CoroutineContext.Element get(CoroutineContext.Key key) {
        return ContentReceiver.DefaultImpls.b(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key key) {
        return ContentReceiver.DefaultImpls.c(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return ContentReceiver.DefaultImpls.d(this, coroutineContext);
    }
}
