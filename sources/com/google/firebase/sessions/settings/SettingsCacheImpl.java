package com.google.firebase.sessions.settings;

import androidx.compose.animation.core.h;
import androidx.datastore.core.DataStore;
import com.google.firebase.sessions.TimeProvider;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Singleton;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

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
/* JADX INFO: loaded from: classes6.dex */
@Singleton
@Metadata
public final class SettingsCacheImpl implements SettingsCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CoroutineContext f90211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TimeProvider f90212b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final DataStore f90213c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicReference f90214d;

    /* JADX INFO: renamed from: com.google.firebase.sessions.settings.SettingsCacheImpl$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.google.firebase.sessions.settings.SettingsCacheImpl$1", f = "SettingsCache.kt", l = {73}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f90215a;

        /* JADX INFO: renamed from: com.google.firebase.sessions.settings.SettingsCacheImpl$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        /* synthetic */ class C01681 implements FlowCollector, FunctionAdapter {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ AtomicReference f90217a;

            C01681(AtomicReference atomicReference) {
                this.f90217a = atomicReference;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object emit(SessionConfigs sessionConfigs, Continuation continuation) {
                Object objQ = AnonymousClass1.q(this.f90217a, sessionConfigs, continuation);
                return objQ == IntrinsicsKt.f() ? objQ : Unit.f139807a;
            }

            @Override // kotlin.jvm.internal.FunctionAdapter
            public final Function b() {
                return new AdaptedFunctionReference(2, this.f90217a, AtomicReference.class, "set", "set(Ljava/lang/Object;)V", 4);
            }

            public final boolean equals(Object obj) {
                if ((obj instanceof FlowCollector) && (obj instanceof FunctionAdapter)) {
                    return Intrinsics.areEqual(b(), ((FunctionAdapter) obj).b());
                }
                return false;
            }

            public final int hashCode() {
                return b().hashCode();
            }
        }

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ Object q(AtomicReference atomicReference, SessionConfigs sessionConfigs, Continuation continuation) {
            atomicReference.set(sessionConfigs);
            return Unit.f139807a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return SettingsCacheImpl.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f90215a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow data = SettingsCacheImpl.this.f90213c.getData();
                C01681 c01681 = new C01681(SettingsCacheImpl.this.f90214d);
                this.f90215a = 1;
                if (data.collect(c01681, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    public SettingsCacheImpl(CoroutineContext backgroundDispatcher, TimeProvider timeProvider, DataStore sessionConfigsDataStore) {
        Intrinsics.checkNotNullParameter(backgroundDispatcher, "backgroundDispatcher");
        Intrinsics.checkNotNullParameter(timeProvider, "timeProvider");
        Intrinsics.checkNotNullParameter(sessionConfigsDataStore, "sessionConfigsDataStore");
        this.f90211a = backgroundDispatcher;
        this.f90212b = timeProvider;
        this.f90213c = sessionConfigsDataStore;
        this.f90214d = new AtomicReference();
        BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(backgroundDispatcher), null, null, new AnonymousClass1(null), 3, null);
    }

    private final SessionConfigs h() {
        if (this.f90214d.get() == null) {
            h.a(this.f90214d, null, BuildersKt__BuildersKt.b(null, new SettingsCacheImpl$sessionConfigs$1(this, null), 1, null));
        }
        Object obj = this.f90214d.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        return (SessionConfigs) obj;
    }

    @Override // com.google.firebase.sessions.settings.SettingsCache
    public Double a() {
        return h().c();
    }

    @Override // com.google.firebase.sessions.settings.SettingsCache
    public boolean b() {
        Long lB = h().b();
        Integer numA = h().a();
        return lB == null || numA == null || this.f90212b.a().a() - lB.longValue() >= ((long) numA.intValue());
    }

    @Override // com.google.firebase.sessions.settings.SettingsCache
    public Boolean c() {
        return h().e();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.google.firebase.sessions.settings.SettingsCache
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object d(com.google.firebase.sessions.settings.SessionConfigs r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.google.firebase.sessions.settings.SettingsCacheImpl$updateConfigs$1
            if (r0 == 0) goto L13
            r0 = r7
            com.google.firebase.sessions.settings.SettingsCacheImpl$updateConfigs$1 r0 = (com.google.firebase.sessions.settings.SettingsCacheImpl$updateConfigs$1) r0
            int r1 = r0.f90226c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f90226c = r1
            goto L18
        L13:
            com.google.firebase.sessions.settings.SettingsCacheImpl$updateConfigs$1 r0 = new com.google.firebase.sessions.settings.SettingsCacheImpl$updateConfigs$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f90224a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f90226c
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.ResultKt.b(r7)     // Catch: java.io.IOException -> L29
            goto L5d
        L29:
            r6 = move-exception
            goto L47
        L2b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L33:
            kotlin.ResultKt.b(r7)
            androidx.datastore.core.DataStore r7 = r5.f90213c     // Catch: java.io.IOException -> L29
            com.google.firebase.sessions.settings.SettingsCacheImpl$updateConfigs$2 r2 = new com.google.firebase.sessions.settings.SettingsCacheImpl$updateConfigs$2     // Catch: java.io.IOException -> L29
            r4 = 0
            r2.<init>(r6, r4)     // Catch: java.io.IOException -> L29
            r0.f90226c = r3     // Catch: java.io.IOException -> L29
            java.lang.Object r6 = r7.a(r2, r0)     // Catch: java.io.IOException -> L29
            if (r6 != r1) goto L5d
            return r1
        L47:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "Failed to update config values: "
            r7.append(r0)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            java.lang.String r7 = "FirebaseSessions"
            android.util.Log.w(r7, r6)
        L5d:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.settings.SettingsCacheImpl.d(com.google.firebase.sessions.settings.SessionConfigs, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.google.firebase.sessions.settings.SettingsCache
    public Integer e() {
        return h().d();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object i(kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.google.firebase.sessions.settings.SettingsCacheImpl$removeConfigs$1
            if (r0 == 0) goto L13
            r0 = r6
            com.google.firebase.sessions.settings.SettingsCacheImpl$removeConfigs$1 r0 = (com.google.firebase.sessions.settings.SettingsCacheImpl$removeConfigs$1) r0
            int r1 = r0.f90220c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f90220c = r1
            goto L18
        L13:
            com.google.firebase.sessions.settings.SettingsCacheImpl$removeConfigs$1 r0 = new com.google.firebase.sessions.settings.SettingsCacheImpl$removeConfigs$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f90218a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f90220c
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.ResultKt.b(r6)     // Catch: java.io.IOException -> L29
            return r6
        L29:
            r6 = move-exception
            goto L48
        L2b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L33:
            kotlin.ResultKt.b(r6)
            androidx.datastore.core.DataStore r6 = r5.f90213c     // Catch: java.io.IOException -> L29
            com.google.firebase.sessions.settings.SettingsCacheImpl$removeConfigs$2 r2 = new com.google.firebase.sessions.settings.SettingsCacheImpl$removeConfigs$2     // Catch: java.io.IOException -> L29
            r4 = 0
            r2.<init>(r4)     // Catch: java.io.IOException -> L29
            r0.f90220c = r3     // Catch: java.io.IOException -> L29
            java.lang.Object r6 = r6.a(r2, r0)     // Catch: java.io.IOException -> L29
            if (r6 != r1) goto L47
            return r1
        L47:
            return r6
        L48:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Failed to remove config values: "
            r0.append(r1)
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            java.lang.String r0 = "FirebaseSessions"
            int r6 = android.util.Log.w(r0, r6)
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.d(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.settings.SettingsCacheImpl.i(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
