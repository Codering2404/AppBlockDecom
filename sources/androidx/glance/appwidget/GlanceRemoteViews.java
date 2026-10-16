package androidx.glance.appwidget;

import kotlin.Metadata;
import kotlinx.coroutines.sync.Mutex;

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
public final class GlanceRemoteViews {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Mutex f38046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LayoutConfiguration f38047b;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(android.content.Context r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof androidx.glance.appwidget.GlanceRemoteViews$initializeLayoutConfiguration$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.glance.appwidget.GlanceRemoteViews$initializeLayoutConfiguration$1 r0 = (androidx.glance.appwidget.GlanceRemoteViews$initializeLayoutConfiguration$1) r0
            int r1 = r0.f38069g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f38069g = r1
            goto L18
        L13:
            androidx.glance.appwidget.GlanceRemoteViews$initializeLayoutConfiguration$1 r0 = new androidx.glance.appwidget.GlanceRemoteViews$initializeLayoutConfiguration$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f38067d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f38069g
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r6 = r0.f38066c
            kotlinx.coroutines.sync.Mutex r6 = (kotlinx.coroutines.sync.Mutex) r6
            java.lang.Object r1 = r0.f38065b
            android.content.Context r1 = (android.content.Context) r1
            java.lang.Object r0 = r0.f38064a
            androidx.glance.appwidget.GlanceRemoteViews r0 = (androidx.glance.appwidget.GlanceRemoteViews) r0
            kotlin.ResultKt.b(r7)
            r7 = r6
            r6 = r1
            goto L59
        L38:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L40:
            kotlin.ResultKt.b(r7)
            androidx.glance.appwidget.LayoutConfiguration r7 = r5.f38047b
            if (r7 != 0) goto L74
            kotlinx.coroutines.sync.Mutex r7 = r5.f38046a
            r0.f38064a = r5
            r0.f38065b = r6
            r0.f38066c = r7
            r0.f38069g = r3
            java.lang.Object r0 = r7.f(r4, r0)
            if (r0 != r1) goto L58
            return r1
        L58:
            r0 = r5
        L59:
            androidx.glance.appwidget.LayoutConfiguration r1 = r0.f38047b     // Catch: java.lang.Throwable -> L65
            if (r1 != 0) goto L67
            androidx.glance.appwidget.LayoutConfiguration$Companion r1 = androidx.glance.appwidget.LayoutConfiguration.f38090g     // Catch: java.lang.Throwable -> L65
            r2 = 0
            androidx.glance.appwidget.LayoutConfiguration r1 = r1.a(r6, r2)     // Catch: java.lang.Throwable -> L65
            goto L67
        L65:
            r6 = move-exception
            goto L70
        L67:
            r0.f38047b = r1     // Catch: java.lang.Throwable -> L65
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)     // Catch: java.lang.Throwable -> L65
            r7.i(r4)
            return r1
        L70:
            r7.i(r4)
            throw r6
        L74:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.glance.appwidget.GlanceRemoteViews.b(android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
