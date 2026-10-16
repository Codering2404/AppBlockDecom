package androidx.glance.appwidget;

import androidx.glance.appwidget.GlanceRemoteViewsService;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@DebugMetadata(c = "androidx.glance.appwidget.GlanceRemoteViewsService$GlanceRemoteViewsFactory$loadData$1", f = "GlanceRemoteViewsService.kt", l = {112, 113}, m = "invokeSuspend")
final class GlanceRemoteViewsService$GlanceRemoteViewsFactory$loadData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f38077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f38078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ GlanceRemoteViewsService.GlanceRemoteViewsFactory f38079c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GlanceRemoteViewsService$GlanceRemoteViewsFactory$loadData$1(GlanceRemoteViewsService.GlanceRemoteViewsFactory glanceRemoteViewsFactory, Continuation continuation) {
        super(2, continuation);
        this.f38079c = glanceRemoteViewsFactory;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new GlanceRemoteViewsService$GlanceRemoteViewsFactory$loadData$1(this.f38079c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x005c, code lost:
    
        if (r7.g(r1, r6) == r0) goto L17;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r6.f38078b
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L22
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.b(r7)
            goto L5f
        L12:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1a:
            java.lang.Object r1 = r6.f38077a
            androidx.glance.appwidget.AppWidgetId r1 = (androidx.glance.appwidget.AppWidgetId) r1
            kotlin.ResultKt.b(r7)
            goto L49
        L22:
            kotlin.ResultKt.b(r7)
            androidx.glance.appwidget.AppWidgetId r1 = new androidx.glance.appwidget.AppWidgetId
            androidx.glance.appwidget.GlanceRemoteViewsService$GlanceRemoteViewsFactory r7 = r6.f38079c
            int r7 = androidx.glance.appwidget.GlanceRemoteViewsService.GlanceRemoteViewsFactory.a(r7)
            r1.<init>(r7)
            androidx.glance.session.SessionManager r7 = androidx.glance.session.SessionManagerKt.a()
            androidx.glance.appwidget.GlanceRemoteViewsService$GlanceRemoteViewsFactory r4 = r6.f38079c
            android.content.Context r4 = androidx.glance.appwidget.GlanceRemoteViewsService.GlanceRemoteViewsFactory.b(r4)
            java.lang.String r5 = androidx.glance.appwidget.AppWidgetUtilsKt.p(r1)
            r6.f38077a = r1
            r6.f38078b = r3
            java.lang.Object r7 = r7.e(r4, r5, r6)
            if (r7 != r0) goto L49
            goto L5e
        L49:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 != 0) goto L5f
            androidx.glance.appwidget.GlanceRemoteViewsService$GlanceRemoteViewsFactory r7 = r6.f38079c
            r3 = 0
            r6.f38077a = r3
            r6.f38078b = r2
            java.lang.Object r7 = androidx.glance.appwidget.GlanceRemoteViewsService.GlanceRemoteViewsFactory.c(r7, r1, r6)
            if (r7 != r0) goto L5f
        L5e:
            return r0
        L5f:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.glance.appwidget.GlanceRemoteViewsService$GlanceRemoteViewsFactory$loadData$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((GlanceRemoteViewsService$GlanceRemoteViewsFactory$loadData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
