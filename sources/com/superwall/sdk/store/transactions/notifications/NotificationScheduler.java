package com.superwall.sdk.store.transactions.notifications;

import android.content.Context;
import androidx.work.WorkManager;
import com.superwall.sdk.dependencies.DeviceHelperFactory;
import com.superwall.sdk.logger.LogLevel;
import com.superwall.sdk.logger.LogScope;
import com.superwall.sdk.logger.Logger;
import com.superwall.sdk.misc.IOScope;
import com.superwall.sdk.models.paywall.LocalNotification;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

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
public final class NotificationScheduler {
    public static final Companion Companion = new Companion(null);
    private static final String TAG_PREFIX = "superwall_notification_";

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void scheduleNotifications$default(Companion companion, List list, DeviceHelperFactory deviceHelperFactory, Context context, boolean z2, boolean z3, int i3, Object obj) {
            if ((i3 & 8) != 0) {
                z2 = false;
            }
            boolean z4 = z2;
            if ((i3 & 16) != 0) {
                z3 = true;
            }
            companion.scheduleNotifications(list, deviceHelperFactory, context, z4, z3);
        }

        public final void cancelNotificationById(String id, Context context) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(context, "context");
            WorkManager workManagerH = WorkManager.h(context);
            Intrinsics.checkNotNullExpressionValue(workManagerH, "getInstance(...)");
            workManagerH.a(id);
            Logger.debug$default(Logger.INSTANCE, LogLevel.debug, LogScope.paywallView, "Cancelled pending notification with tag: " + id, (Map) null, (Throwable) null, 24, (Object) null);
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object existsWithTag(android.content.Context r5, java.lang.String r6, kotlin.coroutines.Continuation<? super java.lang.Boolean> r7) {
            /*
                r4 = this;
                boolean r0 = r7 instanceof com.superwall.sdk.store.transactions.notifications.NotificationScheduler$Companion$existsWithTag$1
                if (r0 == 0) goto L13
                r0 = r7
                com.superwall.sdk.store.transactions.notifications.NotificationScheduler$Companion$existsWithTag$1 r0 = (com.superwall.sdk.store.transactions.notifications.NotificationScheduler$Companion$existsWithTag$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.superwall.sdk.store.transactions.notifications.NotificationScheduler$Companion$existsWithTag$1 r0 = new com.superwall.sdk.store.transactions.notifications.NotificationScheduler$Companion$existsWithTag$1
                r0.<init>(r4, r7)
            L18:
                java.lang.Object r7 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L31
                if (r2 != r3) goto L29
                kotlin.ResultKt.b(r7)
                goto L4f
            L29:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L31:
                kotlin.ResultKt.b(r7)
                androidx.work.WorkManager r5 = androidx.work.WorkManager.h(r5)
                java.lang.String r7 = "getInstance(...)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r7)
                com.google.common.util.concurrent.ListenableFuture r5 = r5.j(r6)
                java.lang.String r6 = "getWorkInfosByTag(...)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
                r0.label = r3
                java.lang.Object r7 = kotlinx.coroutines.guava.ListenableFutureKt.b(r5, r0)
                if (r7 != r1) goto L4f
                return r1
            L4f:
                java.lang.String r5 = "await(...)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r5)
                java.util.Collection r7 = (java.util.Collection) r7
                boolean r5 = r7.isEmpty()
                r5 = r5 ^ r3
                java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.a(r5)
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.store.transactions.notifications.NotificationScheduler.Companion.existsWithTag(android.content.Context, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
        }

        public final void scheduleNotifications(List<LocalNotification> notifications, DeviceHelperFactory factory, Context context, boolean z2, boolean z3) {
            Intrinsics.checkNotNullParameter(notifications, "notifications");
            Intrinsics.checkNotNullParameter(factory, "factory");
            Intrinsics.checkNotNullParameter(context, "context");
            WorkManager workManagerH = WorkManager.h(context);
            Intrinsics.checkNotNullExpressionValue(workManagerH, "getInstance(...)");
            BuildersKt__Builders_commonKt.d(new IOScope(null, 1, null), null, null, new NotificationScheduler$Companion$scheduleNotifications$1(notifications, z2, context, factory, z3, workManagerH, null), 3, null);
        }

        private Companion() {
        }
    }
}
