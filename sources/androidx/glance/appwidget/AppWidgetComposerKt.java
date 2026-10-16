package androidx.glance.appwidget;

import android.content.Context;
import android.os.Bundle;
import androidx.compose.ui.unit.DpSize;
import androidx.glance.GlanceId;
import androidx.glance.appwidget.SizeMode;
import androidx.glance.state.ConfigManager;
import androidx.glance.state.GlanceState;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
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
public final class AppWidgetComposerKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0062 A[PHI: r0 r1 r5 r8
      0x0062: PHI (r0v9 int) = (r0v8 int), (r0v16 int) binds: [B:46:0x01bd, B:21:0x005f] A[DONT_GENERATE, DONT_INLINE]
      0x0062: PHI (r1v6 androidx.glance.appwidget.RemoteViewsRoot) = (r1v5 androidx.glance.appwidget.RemoteViewsRoot), (r1v15 androidx.glance.appwidget.RemoteViewsRoot) binds: [B:46:0x01bd, B:21:0x005f] A[DONT_GENERATE, DONT_INLINE]
      0x0062: PHI (r5v12 ??) = (r5v21 ??), (r5v22 ??) binds: [B:46:0x01bd, B:21:0x005f] A[DONT_GENERATE, DONT_INLINE]
      0x0062: PHI (r8v3 android.content.Context) = (r8v2 android.content.Context), (r8v5 android.content.Context) binds: [B:46:0x01bd, B:21:0x005f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01eb A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Type inference failed for: r5v0, types: [int] */
    /* JADX WARN: Type inference failed for: r5v12, types: [androidx.glance.appwidget.LayoutConfiguration] */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(android.content.Context r28, androidx.glance.GlanceId r29, androidx.glance.appwidget.SizeMode r30, androidx.compose.ui.unit.DpSize r31, android.os.Bundle r32, java.lang.Object r33, androidx.glance.state.ConfigManager r34, kotlin.jvm.functions.Function2 r35, kotlin.coroutines.Continuation r36) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 522
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.glance.appwidget.AppWidgetComposerKt.a(android.content.Context, androidx.glance.GlanceId, androidx.glance.appwidget.SizeMode, androidx.compose.ui.unit.DpSize, android.os.Bundle, java.lang.Object, androidx.glance.state.ConfigManager, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object b(Context context, GlanceId glanceId, SizeMode sizeMode, DpSize dpSize, Bundle bundle, Object obj, ConfigManager configManager, Function2 function2, Continuation continuation, int i3, Object obj2) {
        if ((i3 & 2) != 0) {
            glanceId = new AppWidgetId(-1);
        }
        GlanceId glanceId2 = glanceId;
        if ((i3 & 4) != 0) {
            sizeMode = SizeMode.Single.f38453a;
        }
        return a(context, glanceId2, sizeMode, (i3 & 8) != 0 ? null : dpSize, (i3 & 16) != 0 ? null : bundle, (i3 & 32) != 0 ? null : obj, (i3 & 64) != 0 ? GlanceState.f39700a : configManager, function2, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object c(androidx.glance.appwidget.GlanceAppWidget r14, android.content.Context r15, androidx.glance.GlanceId r16, android.os.Bundle r17, androidx.compose.ui.unit.DpSize r18, java.lang.Object r19, kotlin.coroutines.Continuation r20) {
        /*
            r0 = r18
            r1 = r20
            boolean r2 = r1 instanceof androidx.glance.appwidget.AppWidgetComposerKt$compose$4
            if (r2 == 0) goto L18
            r2 = r1
            androidx.glance.appwidget.AppWidgetComposerKt$compose$4 r2 = (androidx.glance.appwidget.AppWidgetComposerKt$compose$4) r2
            int r3 = r2.f37729i
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L18
            int r3 = r3 - r4
            r2.f37729i = r3
        L16:
            r11 = r2
            goto L1e
        L18:
            androidx.glance.appwidget.AppWidgetComposerKt$compose$4 r2 = new androidx.glance.appwidget.AppWidgetComposerKt$compose$4
            r2.<init>(r1)
            goto L16
        L1e:
            java.lang.Object r1 = r11.f37728h
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r3 = r11.f37729i
            r4 = 2
            r5 = 1
            r6 = 0
            if (r3 == 0) goto L5b
            if (r3 == r5) goto L3b
            if (r3 != r4) goto L33
            kotlin.ResultKt.b(r1)
            return r1
        L33:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L3b:
            java.lang.Object r14 = r11.f37727g
            androidx.glance.appwidget.SizeMode r14 = (androidx.glance.appwidget.SizeMode) r14
            java.lang.Object r0 = r11.f37726f
            java.lang.Object r3 = r11.f37725d
            androidx.compose.ui.unit.DpSize r3 = (androidx.compose.ui.unit.DpSize) r3
            java.lang.Object r5 = r11.f37724c
            android.os.Bundle r5 = (android.os.Bundle) r5
            java.lang.Object r7 = r11.f37723b
            androidx.glance.GlanceId r7 = (androidx.glance.GlanceId) r7
            java.lang.Object r8 = r11.f37722a
            android.content.Context r8 = (android.content.Context) r8
            kotlin.ResultKt.b(r1)
            r9 = r8
            r8 = r0
            r0 = r3
            r3 = r9
            r9 = r5
            r5 = r14
            goto L90
        L5b:
            kotlin.ResultKt.b(r1)
            if (r0 == 0) goto L63
            androidx.glance.appwidget.SizeMode$Single r1 = androidx.glance.appwidget.SizeMode.Single.f38453a
            goto L67
        L63:
            androidx.glance.appwidget.SizeMode r1 = r14.c()
        L67:
            kotlinx.coroutines.flow.Flow r14 = androidx.glance.appwidget.AppWidgetUtilsKt.m(r14, r15, r16)
            androidx.glance.appwidget.AppWidgetComposerKt$compose$5 r3 = new androidx.glance.appwidget.AppWidgetComposerKt$compose$5
            r3.<init>(r6)
            r11.f37722a = r15
            r8 = r16
            r11.f37723b = r8
            r9 = r17
            r11.f37724c = r9
            r11.f37725d = r0
            r10 = r19
            r11.f37726f = r10
            r11.f37727g = r1
            r11.f37729i = r5
            java.lang.Object r14 = kotlinx.coroutines.flow.FlowKt.E(r14, r3, r11)
            if (r14 != r2) goto L8b
            goto Lb1
        L8b:
            r3 = r15
            r5 = r1
            r7 = r8
            r8 = r10
            r1 = r14
        L90:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            r10 = r1
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r11.f37722a = r6
            r11.f37723b = r6
            r11.f37724c = r6
            r11.f37725d = r6
            r11.f37726f = r6
            r11.f37727g = r6
            r11.f37729i = r4
            r4 = r7
            r7 = r9
            r9 = 0
            r12 = 64
            r13 = 0
            r6 = r0
            java.lang.Object r14 = b(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            if (r14 != r2) goto Lb2
        Lb1:
            return r2
        Lb2:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.glance.appwidget.AppWidgetComposerKt.c(androidx.glance.appwidget.GlanceAppWidget, android.content.Context, androidx.glance.GlanceId, android.os.Bundle, androidx.compose.ui.unit.DpSize, java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
