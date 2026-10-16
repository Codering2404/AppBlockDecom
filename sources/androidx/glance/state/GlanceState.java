package androidx.glance.state;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

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
public final class GlanceState implements ConfigManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final GlanceState f39700a = new GlanceState();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Mutex f39701b = MutexKt.b(false, 1, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map f39702c = new LinkedHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f39703d = 8;

    private GlanceState() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object d(android.content.Context r7, androidx.glance.state.GlanceStateDefinition r8, java.lang.String r9, kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r10 instanceof androidx.glance.state.GlanceState$getDataStore$1
            if (r0 == 0) goto L13
            r0 = r10
            androidx.glance.state.GlanceState$getDataStore$1 r0 = (androidx.glance.state.GlanceState$getDataStore$1) r0
            int r1 = r0.f39717h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f39717h = r1
            goto L18
        L13:
            androidx.glance.state.GlanceState$getDataStore$1 r0 = new androidx.glance.state.GlanceState$getDataStore$1
            r0.<init>(r6, r10)
        L18:
            java.lang.Object r10 = r0.f39715f
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f39717h
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L5b
            if (r2 == r4) goto L44
            if (r2 != r3) goto L3c
            java.lang.Object r7 = r0.f39713c
            java.util.Map r7 = (java.util.Map) r7
            java.lang.Object r8 = r0.f39712b
            kotlinx.coroutines.sync.Mutex r8 = (kotlinx.coroutines.sync.Mutex) r8
            java.lang.Object r9 = r0.f39711a
            java.lang.String r9 = (java.lang.String) r9
            kotlin.ResultKt.b(r10)     // Catch: java.lang.Throwable -> L39
            goto L8d
        L39:
            r7 = move-exception
            goto La3
        L3c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L44:
            java.lang.Object r7 = r0.f39714d
            kotlinx.coroutines.sync.Mutex r7 = (kotlinx.coroutines.sync.Mutex) r7
            java.lang.Object r8 = r0.f39713c
            r9 = r8
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r8 = r0.f39712b
            androidx.glance.state.GlanceStateDefinition r8 = (androidx.glance.state.GlanceStateDefinition) r8
            java.lang.Object r2 = r0.f39711a
            android.content.Context r2 = (android.content.Context) r2
            kotlin.ResultKt.b(r10)
            r10 = r7
            r7 = r2
            goto L71
        L5b:
            kotlin.ResultKt.b(r10)
            kotlinx.coroutines.sync.Mutex r10 = androidx.glance.state.GlanceState.f39701b
            r0.f39711a = r7
            r0.f39712b = r8
            r0.f39713c = r9
            r0.f39714d = r10
            r0.f39717h = r4
            java.lang.Object r2 = r10.f(r5, r0)
            if (r2 != r1) goto L71
            goto L89
        L71:
            java.util.Map r2 = androidx.glance.state.GlanceState.f39702c     // Catch: java.lang.Throwable -> L94
            java.lang.Object r4 = r2.get(r9)     // Catch: java.lang.Throwable -> L94
            if (r4 != 0) goto L97
            r0.f39711a = r9     // Catch: java.lang.Throwable -> L94
            r0.f39712b = r10     // Catch: java.lang.Throwable -> L94
            r0.f39713c = r2     // Catch: java.lang.Throwable -> L94
            r0.f39714d = r5     // Catch: java.lang.Throwable -> L94
            r0.f39717h = r3     // Catch: java.lang.Throwable -> L94
            java.lang.Object r7 = r8.a(r7, r9, r0)     // Catch: java.lang.Throwable -> L94
            if (r7 != r1) goto L8a
        L89:
            return r1
        L8a:
            r8 = r10
            r10 = r7
            r7 = r2
        L8d:
            r4 = r10
            androidx.datastore.core.DataStore r4 = (androidx.datastore.core.DataStore) r4     // Catch: java.lang.Throwable -> L39
            r7.put(r9, r4)     // Catch: java.lang.Throwable -> L39
            goto L98
        L94:
            r7 = move-exception
            r8 = r10
            goto La3
        L97:
            r8 = r10
        L98:
            java.lang.String r7 = "null cannot be cast to non-null type androidx.datastore.core.DataStore<T of androidx.glance.state.GlanceState.getDataStore$lambda$2>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4, r7)     // Catch: java.lang.Throwable -> L39
            androidx.datastore.core.DataStore r4 = (androidx.datastore.core.DataStore) r4     // Catch: java.lang.Throwable -> L39
            r8.i(r5)
            return r4
        La3:
            r8.i(r5)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.glance.state.GlanceState.d(android.content.Context, androidx.glance.state.GlanceStateDefinition, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.glance.state.ConfigManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object a(android.content.Context r6, androidx.glance.state.GlanceStateDefinition r7, java.lang.String r8, kotlin.coroutines.Continuation r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof androidx.glance.state.GlanceState$getValue$1
            if (r0 == 0) goto L13
            r0 = r9
            androidx.glance.state.GlanceState$getValue$1 r0 = (androidx.glance.state.GlanceState$getValue$1) r0
            int r1 = r0.f39720c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f39720c = r1
            goto L18
        L13:
            androidx.glance.state.GlanceState$getValue$1 r0 = new androidx.glance.state.GlanceState$getValue$1
            r0.<init>(r5, r9)
        L18:
            java.lang.Object r9 = r0.f39718a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f39720c
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r9)
            return r9
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            kotlin.ResultKt.b(r9)
            goto L44
        L38:
            kotlin.ResultKt.b(r9)
            r0.f39720c = r4
            java.lang.Object r9 = r5.d(r6, r7, r8, r0)
            if (r9 != r1) goto L44
            goto L52
        L44:
            androidx.datastore.core.DataStore r9 = (androidx.datastore.core.DataStore) r9
            kotlinx.coroutines.flow.Flow r6 = r9.getData()
            r0.f39720c = r3
            java.lang.Object r6 = kotlinx.coroutines.flow.FlowKt.D(r6, r0)
            if (r6 != r1) goto L53
        L52:
            return r1
        L53:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.glance.state.GlanceState.a(android.content.Context, androidx.glance.state.GlanceStateDefinition, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object c(android.content.Context r6, androidx.glance.state.GlanceStateDefinition r7, java.lang.String r8, kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r9 instanceof androidx.glance.state.GlanceState$deleteStore$1
            if (r0 == 0) goto L13
            r0 = r9
            androidx.glance.state.GlanceState$deleteStore$1 r0 = (androidx.glance.state.GlanceState$deleteStore$1) r0
            int r1 = r0.f39710h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f39710h = r1
            goto L18
        L13:
            androidx.glance.state.GlanceState$deleteStore$1 r0 = new androidx.glance.state.GlanceState$deleteStore$1
            r0.<init>(r5, r9)
        L18:
            java.lang.Object r9 = r0.f39708f
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f39710h
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L45
            if (r2 != r3) goto L3d
            java.lang.Object r6 = r0.f39707d
            kotlinx.coroutines.sync.Mutex r6 = (kotlinx.coroutines.sync.Mutex) r6
            java.lang.Object r7 = r0.f39706c
            r8 = r7
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r7 = r0.f39705b
            androidx.glance.state.GlanceStateDefinition r7 = (androidx.glance.state.GlanceStateDefinition) r7
            java.lang.Object r0 = r0.f39704a
            android.content.Context r0 = (android.content.Context) r0
            kotlin.ResultKt.b(r9)
            r9 = r6
            r6 = r0
            goto L5b
        L3d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L45:
            kotlin.ResultKt.b(r9)
            kotlinx.coroutines.sync.Mutex r9 = androidx.glance.state.GlanceState.f39701b
            r0.f39704a = r6
            r0.f39705b = r7
            r0.f39706c = r8
            r0.f39707d = r9
            r0.f39710h = r3
            java.lang.Object r0 = r9.f(r4, r0)
            if (r0 != r1) goto L5b
            return r1
        L5b:
            java.util.Map r0 = androidx.glance.state.GlanceState.f39702c     // Catch: java.lang.Throwable -> L6d
            r0.remove(r8)     // Catch: java.lang.Throwable -> L6d
            java.io.File r6 = r7.b(r6, r8)     // Catch: java.lang.Throwable -> L6d
            r6.delete()     // Catch: java.lang.Throwable -> L6d
            r9.i(r4)
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        L6d:
            r6 = move-exception
            r9.i(r4)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.glance.state.GlanceState.c(android.content.Context, androidx.glance.state.GlanceStateDefinition, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object e(android.content.Context r6, androidx.glance.state.GlanceStateDefinition r7, java.lang.String r8, kotlin.jvm.functions.Function2 r9, kotlin.coroutines.Continuation r10) {
        /*
            r5 = this;
            boolean r0 = r10 instanceof androidx.glance.state.GlanceState$updateValue$1
            if (r0 == 0) goto L13
            r0 = r10
            androidx.glance.state.GlanceState$updateValue$1 r0 = (androidx.glance.state.GlanceState$updateValue$1) r0
            int r1 = r0.f39724d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f39724d = r1
            goto L18
        L13:
            androidx.glance.state.GlanceState$updateValue$1 r0 = new androidx.glance.state.GlanceState$updateValue$1
            r0.<init>(r5, r10)
        L18:
            java.lang.Object r10 = r0.f39722b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f39724d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3d
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r10)
            return r10
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            java.lang.Object r6 = r0.f39721a
            r9 = r6
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            kotlin.ResultKt.b(r10)
            goto L4b
        L3d:
            kotlin.ResultKt.b(r10)
            r0.f39721a = r9
            r0.f39724d = r4
            java.lang.Object r10 = r5.d(r6, r7, r8, r0)
            if (r10 != r1) goto L4b
            goto L58
        L4b:
            androidx.datastore.core.DataStore r10 = (androidx.datastore.core.DataStore) r10
            r6 = 0
            r0.f39721a = r6
            r0.f39724d = r3
            java.lang.Object r6 = r10.a(r9, r0)
            if (r6 != r1) goto L59
        L58:
            return r1
        L59:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.glance.state.GlanceState.e(android.content.Context, androidx.glance.state.GlanceStateDefinition, java.lang.String, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
