package cz.mobilesoft.coreblock.service.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import cz.mobilesoft.coreblock.storage.datastore.EventDataStore;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.qualifier.Qualifier;
import org.koin.mp.KoinPlatformTools;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class DexReceiver extends BroadcastReceiver implements KoinComponent {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f123552b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f123553c = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f123554a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.service.receiver.DexReceiver$onReceive$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.service.receiver.DexReceiver$onReceive$1", f = "DexReceiver.kt", l = {34, 37}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f123555a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Intent f123556b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ DexReceiver f123557c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ BroadcastReceiver.PendingResult f123558d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Intent intent, DexReceiver dexReceiver, BroadcastReceiver.PendingResult pendingResult, Continuation continuation) {
            super(2, continuation);
            this.f123556b = intent;
            this.f123557c = dexReceiver;
            this.f123558d = pendingResult;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f123556b, this.f123557c, this.f123558d, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x0069, code lost:
        
            if (r6.c2(true, r5) == r0) goto L31;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r5.f123555a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1c
                if (r1 == r3) goto Le
                if (r1 != r2) goto L14
            Le:
                kotlin.ResultKt.b(r6)     // Catch: java.lang.Throwable -> L12
                goto L6c
            L12:
                r6 = move-exception
                goto L74
            L14:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L1c:
                kotlin.ResultKt.b(r6)
                android.content.Intent r6 = r5.f123556b     // Catch: java.lang.Throwable -> L12
                java.lang.String r6 = r6.getAction()     // Catch: java.lang.Throwable -> L12
                if (r6 == 0) goto L6c
                int r1 = r6.hashCode()     // Catch: java.lang.Throwable -> L12
                r4 = -1670536538(0xffffffff9c6da2a6, float:-7.862694E-22)
                if (r1 == r4) goto L4f
                r3 = 2034148(0x1f09e4, float:2.850448E-39)
                if (r1 == r3) goto L36
                goto L6c
            L36:
                java.lang.String r1 = "android.app.action.EXIT_KNOX_DESKTOP_MODE"
                boolean r6 = r6.equals(r1)     // Catch: java.lang.Throwable -> L12
                if (r6 != 0) goto L3f
                goto L6c
            L3f:
                cz.mobilesoft.coreblock.service.receiver.DexReceiver r6 = r5.f123557c     // Catch: java.lang.Throwable -> L12
                cz.mobilesoft.coreblock.storage.datastore.EventDataStore r6 = cz.mobilesoft.coreblock.service.receiver.DexReceiver.a(r6)     // Catch: java.lang.Throwable -> L12
                r5.f123555a = r2     // Catch: java.lang.Throwable -> L12
                r1 = 0
                java.lang.Object r6 = r6.c2(r1, r5)     // Catch: java.lang.Throwable -> L12
                if (r6 != r0) goto L6c
                goto L6b
            L4f:
                java.lang.String r1 = "android.app.action.ENTER_KNOX_DESKTOP_MODE"
                boolean r6 = r6.equals(r1)     // Catch: java.lang.Throwable -> L12
                if (r6 != 0) goto L58
                goto L6c
            L58:
                cz.mobilesoft.coreblock.util.analytics.AnswersHelper r6 = cz.mobilesoft.coreblock.util.analytics.AnswersHelper.f128199a     // Catch: java.lang.Throwable -> L12
                r6.G4()     // Catch: java.lang.Throwable -> L12
                cz.mobilesoft.coreblock.service.receiver.DexReceiver r6 = r5.f123557c     // Catch: java.lang.Throwable -> L12
                cz.mobilesoft.coreblock.storage.datastore.EventDataStore r6 = cz.mobilesoft.coreblock.service.receiver.DexReceiver.a(r6)     // Catch: java.lang.Throwable -> L12
                r5.f123555a = r3     // Catch: java.lang.Throwable -> L12
                java.lang.Object r6 = r6.c2(r3, r5)     // Catch: java.lang.Throwable -> L12
                if (r6 != r0) goto L6c
            L6b:
                return r0
            L6c:
                android.content.BroadcastReceiver$PendingResult r6 = r5.f123558d
                r6.finish()
                kotlin.Unit r6 = kotlin.Unit.f139807a
                return r6
            L74:
                android.content.BroadcastReceiver$PendingResult r0 = r5.f123558d
                r0.finish()
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.service.receiver.DexReceiver.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DexReceiver() {
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f123554a = LazyKt.a(lazyThreadSafetyModeB, new Function0<EventDataStore>() { // from class: cz.mobilesoft.coreblock.service.receiver.DexReceiver$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(EventDataStore.class), qualifier, objArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EventDataStore b() {
        return (EventDataStore) this.f123554a.getValue();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || context == null) {
            return;
        }
        BroadcastReceiver.PendingResult pendingResultGoAsync = goAsync();
        Intrinsics.checkNotNullExpressionValue(pendingResultGoAsync, "goAsync(...)");
        BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(SupervisorKt.b(null, 1, null).plus(Dispatchers.b())), null, null, new AnonymousClass1(intent, this, pendingResultGoAsync, null), 3, null);
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
