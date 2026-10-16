package androidx.glance.session;

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
public final class GlobalSnapshotManagerKt {
    /* JADX WARN: Removed duplicated region for block: B:22:0x0067 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0070 A[Catch: all -> 0x0036, TRY_LEAVE, TryCatch #1 {all -> 0x0036, blocks: (B:12:0x0032, B:23:0x0068, B:25:0x0070, B:20:0x0059, B:19:0x0054), top: B:38:0x0022, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007c A[Catch: all -> 0x0085, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0085, blocks: (B:27:0x007c, B:34:0x0089, B:35:0x008c, B:12:0x0032, B:23:0x0068, B:25:0x0070, B:20:0x0059, B:19:0x0054, B:32:0x0087), top: B:38:0x0022, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0065 -> B:23:0x0068). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof androidx.glance.session.GlobalSnapshotManagerKt$globalSnapshotMonitor$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.glance.session.GlobalSnapshotManagerKt$globalSnapshotMonitor$1 r0 = (androidx.glance.session.GlobalSnapshotManagerKt$globalSnapshotMonitor$1) r0
            int r1 = r0.f39537f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f39537f = r1
            goto L18
        L13:
            androidx.glance.session.GlobalSnapshotManagerKt$globalSnapshotMonitor$1 r0 = new androidx.glance.session.GlobalSnapshotManagerKt$globalSnapshotMonitor$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f39536d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f39537f
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r2 = r0.f39535c
            kotlinx.coroutines.channels.ChannelIterator r2 = (kotlinx.coroutines.channels.ChannelIterator) r2
            java.lang.Object r5 = r0.f39534b
            kotlinx.coroutines.channels.ReceiveChannel r5 = (kotlinx.coroutines.channels.ReceiveChannel) r5
            java.lang.Object r6 = r0.f39533a
            androidx.compose.runtime.snapshots.ObserverHandle r6 = (androidx.compose.runtime.snapshots.ObserverHandle) r6
            kotlin.ResultKt.b(r7)     // Catch: java.lang.Throwable -> L36
            goto L68
        L36:
            r7 = move-exception
            goto L87
        L38:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L40:
            kotlin.ResultKt.b(r7)
            r7 = -1
            r2 = 6
            kotlinx.coroutines.channels.Channel r5 = kotlinx.coroutines.channels.ChannelKt.b(r7, r4, r4, r2, r4)
            androidx.compose.runtime.snapshots.Snapshot$Companion r7 = androidx.compose.runtime.snapshots.Snapshot.f24914e
            androidx.glance.session.GlobalSnapshotManagerKt$globalSnapshotMonitor$observerHandle$1 r2 = new androidx.glance.session.GlobalSnapshotManagerKt$globalSnapshotMonitor$observerHandle$1
            r2.<init>()
            androidx.compose.runtime.snapshots.ObserverHandle r6 = r7.k(r2)
            kotlinx.coroutines.channels.ChannelIterator r7 = r5.iterator()     // Catch: java.lang.Throwable -> L36
            r2 = r7
        L59:
            r0.f39533a = r6     // Catch: java.lang.Throwable -> L36
            r0.f39534b = r5     // Catch: java.lang.Throwable -> L36
            r0.f39535c = r2     // Catch: java.lang.Throwable -> L36
            r0.f39537f = r3     // Catch: java.lang.Throwable -> L36
            java.lang.Object r7 = r2.a(r0)     // Catch: java.lang.Throwable -> L36
            if (r7 != r1) goto L68
            return r1
        L68:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Throwable -> L36
            boolean r7 = r7.booleanValue()     // Catch: java.lang.Throwable -> L36
            if (r7 == 0) goto L7c
            java.lang.Object r7 = r2.next()     // Catch: java.lang.Throwable -> L36
            kotlin.Unit r7 = (kotlin.Unit) r7     // Catch: java.lang.Throwable -> L36
            androidx.compose.runtime.snapshots.Snapshot$Companion r7 = androidx.compose.runtime.snapshots.Snapshot.f24914e     // Catch: java.lang.Throwable -> L36
            r7.n()     // Catch: java.lang.Throwable -> L36
            goto L59
        L7c:
            kotlinx.coroutines.channels.ChannelsKt.b(r5, r4)     // Catch: java.lang.Throwable -> L85
            r6.dispose()
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        L85:
            r7 = move-exception
            goto L8d
        L87:
            throw r7     // Catch: java.lang.Throwable -> L88
        L88:
            r0 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.b(r5, r7)     // Catch: java.lang.Throwable -> L85
            throw r0     // Catch: java.lang.Throwable -> L85
        L8d:
            r6.dispose()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.glance.session.GlobalSnapshotManagerKt.a(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
