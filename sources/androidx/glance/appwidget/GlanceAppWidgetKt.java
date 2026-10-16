package androidx.glance.appwidget;

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
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class GlanceAppWidgetKt {
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(androidx.glance.appwidget.GlanceAppWidget r3, kotlin.jvm.functions.Function2 r4, kotlin.coroutines.Continuation r5) throws java.lang.Throwable {
        /*
            boolean r3 = r5 instanceof androidx.glance.appwidget.GlanceAppWidgetKt$provideContent$1
            if (r3 == 0) goto L13
            r3 = r5
            androidx.glance.appwidget.GlanceAppWidgetKt$provideContent$1 r3 = (androidx.glance.appwidget.GlanceAppWidgetKt$provideContent$1) r3
            int r0 = r3.f37963b
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L13
            int r0 = r0 - r1
            r3.f37963b = r0
            goto L18
        L13:
            androidx.glance.appwidget.GlanceAppWidgetKt$provideContent$1 r3 = new androidx.glance.appwidget.GlanceAppWidgetKt$provideContent$1
            r3.<init>(r5)
        L18:
            java.lang.Object r5 = r3.f37962a
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r3.f37963b
            r2 = 1
            if (r1 == 0) goto L31
            if (r1 == r2) goto L2d
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            r3.<init>(r4)
            throw r3
        L2d:
            kotlin.ResultKt.b(r5)
            goto L4b
        L31:
            kotlin.ResultKt.b(r5)
            kotlin.coroutines.CoroutineContext r5 = r3.getContext()
            androidx.glance.appwidget.ContentReceiver$Key r1 = androidx.glance.appwidget.ContentReceiver.l8
            kotlin.coroutines.CoroutineContext$Element r5 = r5.get(r1)
            androidx.glance.appwidget.ContentReceiver r5 = (androidx.glance.appwidget.ContentReceiver) r5
            if (r5 == 0) goto L51
            r3.f37963b = r2
            java.lang.Object r3 = r5.L(r4, r3)
            if (r3 != r0) goto L4b
            return r0
        L4b:
            kotlin.KotlinNothingValueException r3 = new kotlin.KotlinNothingValueException
            r3.<init>()
            throw r3
        L51:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "provideContent requires a ContentReceiver and should only be called from GlanceAppWidget.provideGlance"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.glance.appwidget.GlanceAppWidgetKt.a(androidx.glance.appwidget.GlanceAppWidget, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0063, code lost:
    
        if (r7 == r1) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object b(androidx.glance.appwidget.GlanceAppWidget r5, android.content.Context r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof androidx.glance.appwidget.GlanceAppWidgetKt$updateAll$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.glance.appwidget.GlanceAppWidgetKt$updateAll$1 r0 = (androidx.glance.appwidget.GlanceAppWidgetKt$updateAll$1) r0
            int r1 = r0.f37968f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f37968f = r1
            goto L18
        L13:
            androidx.glance.appwidget.GlanceAppWidgetKt$updateAll$1 r0 = new androidx.glance.appwidget.GlanceAppWidgetKt$updateAll$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f37967d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f37968f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4d
            if (r2 == r4) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r5 = r0.f37966c
            java.util.Iterator r5 = (java.util.Iterator) r5
            java.lang.Object r6 = r0.f37965b
            android.content.Context r6 = (android.content.Context) r6
            java.lang.Object r2 = r0.f37964a
            androidx.glance.appwidget.GlanceAppWidget r2 = (androidx.glance.appwidget.GlanceAppWidget) r2
            kotlin.ResultKt.b(r7)
            goto L6e
        L38:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L40:
            java.lang.Object r5 = r0.f37965b
            r6 = r5
            android.content.Context r6 = (android.content.Context) r6
            java.lang.Object r5 = r0.f37964a
            androidx.glance.appwidget.GlanceAppWidget r5 = (androidx.glance.appwidget.GlanceAppWidget) r5
            kotlin.ResultKt.b(r7)
            goto L66
        L4d:
            kotlin.ResultKt.b(r7)
            androidx.glance.appwidget.GlanceAppWidgetManager r7 = new androidx.glance.appwidget.GlanceAppWidgetManager
            r7.<init>(r6)
            java.lang.Class r2 = r5.getClass()
            r0.f37964a = r5
            r0.f37965b = r6
            r0.f37968f = r4
            java.lang.Object r7 = r7.i(r2, r0)
            if (r7 != r1) goto L66
            goto L88
        L66:
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r7 = r7.iterator()
            r2 = r5
            r5 = r7
        L6e:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L89
            java.lang.Object r7 = r5.next()
            androidx.glance.GlanceId r7 = (androidx.glance.GlanceId) r7
            r0.f37964a = r2
            r0.f37965b = r6
            r0.f37966c = r5
            r0.f37968f = r3
            java.lang.Object r7 = r2.k(r6, r7, r0)
            if (r7 != r1) goto L6e
        L88:
            return r1
        L89:
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.glance.appwidget.GlanceAppWidgetKt.b(androidx.glance.appwidget.GlanceAppWidget, android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
