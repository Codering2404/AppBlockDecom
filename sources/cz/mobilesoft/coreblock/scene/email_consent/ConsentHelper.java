package cz.mobilesoft.coreblock.scene.email_consent;

import cz.mobilesoft.coreblock.BuildConfig;
import cz.mobilesoft.coreblock.enums.EmailConsentState;
import cz.mobilesoft.coreblock.enums.PendingEmailConsentState;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import cz.mobilesoft.coreblock.storage.datastore.SessionDataStore;
import cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore;
import cz.mobilesoft.coreblock.util.SessionManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ConsentHelper implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f101688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f101689b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f101690c;

    /* JADX WARN: Multi-variable type inference failed */
    public ConsentHelper() {
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f101688a = LazyKt.a(lazyThreadSafetyModeB, new Function0<CoreDataStore>() { // from class: cz.mobilesoft.coreblock.scene.email_consent.ConsentHelper$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreDataStore.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f101689b = LazyKt.a(lazyThreadSafetyModeB2, new Function0<SessionDataStore>() { // from class: cz.mobilesoft.coreblock.scene.email_consent.ConsentHelper$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(SessionDataStore.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f101690c = LazyKt.a(lazyThreadSafetyModeB3, new Function0<DevDataStore>() { // from class: cz.mobilesoft.coreblock.scene.email_consent.ConsentHelper$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DevDataStore.class), objArr4, objArr5);
            }
        });
    }

    private final boolean b(EmailConsentState emailConsentState, PendingEmailConsentState pendingEmailConsentState) {
        return (emailConsentState instanceof EmailConsentState.REQUIRED) && pendingEmailConsentState == PendingEmailConsentState.NONE;
    }

    private final CoreDataStore c() {
        return (CoreDataStore) this.f101688a.getValue();
    }

    private final DevDataStore d() {
        return (DevDataStore) this.f101690c.getValue();
    }

    private final SessionDataStore e() {
        return (SessionDataStore) this.f101689b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean g(EmailConsentState emailConsentState, PendingEmailConsentState pendingEmailConsentState, boolean z2) {
        if (SessionManager.f127910a.r()) {
            return b(emailConsentState, pendingEmailConsentState) || i(z2);
        }
        return false;
    }

    private final boolean i(boolean z2) {
        return BuildConfig.f95357b.booleanValue() && z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object f(kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r8 instanceof cz.mobilesoft.coreblock.scene.email_consent.ConsentHelper$showConsent$1
            if (r0 == 0) goto L13
            r0 = r8
            cz.mobilesoft.coreblock.scene.email_consent.ConsentHelper$showConsent$1 r0 = (cz.mobilesoft.coreblock.scene.email_consent.ConsentHelper$showConsent$1) r0
            int r1 = r0.f101696g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f101696g = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.email_consent.ConsentHelper$showConsent$1 r0 = new cz.mobilesoft.coreblock.scene.email_consent.ConsentHelper$showConsent$1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.f101694d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f101696g
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L5b
            if (r2 == r5) goto L53
            if (r2 == r4) goto L44
            if (r2 != r3) goto L3c
            java.lang.Object r1 = r0.f101693c
            cz.mobilesoft.coreblock.enums.PendingEmailConsentState r1 = (cz.mobilesoft.coreblock.enums.PendingEmailConsentState) r1
            java.lang.Object r2 = r0.f101692b
            cz.mobilesoft.coreblock.enums.EmailConsentState r2 = (cz.mobilesoft.coreblock.enums.EmailConsentState) r2
            java.lang.Object r0 = r0.f101691a
            cz.mobilesoft.coreblock.scene.email_consent.ConsentHelper r0 = (cz.mobilesoft.coreblock.scene.email_consent.ConsentHelper) r0
            kotlin.ResultKt.b(r8)
            goto La9
        L3c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L44:
            java.lang.Object r2 = r0.f101692b
            cz.mobilesoft.coreblock.enums.EmailConsentState r2 = (cz.mobilesoft.coreblock.enums.EmailConsentState) r2
            java.lang.Object r4 = r0.f101691a
            cz.mobilesoft.coreblock.scene.email_consent.ConsentHelper r4 = (cz.mobilesoft.coreblock.scene.email_consent.ConsentHelper) r4
            kotlin.ResultKt.b(r8)
            r6 = r4
            r4 = r2
            r2 = r6
            goto L8c
        L53:
            java.lang.Object r2 = r0.f101691a
            cz.mobilesoft.coreblock.scene.email_consent.ConsentHelper r2 = (cz.mobilesoft.coreblock.scene.email_consent.ConsentHelper) r2
            kotlin.ResultKt.b(r8)
            goto L72
        L5b:
            kotlin.ResultKt.b(r8)
            cz.mobilesoft.coreblock.storage.datastore.SessionDataStore r8 = r7.e()
            kotlinx.coroutines.flow.Flow r8 = r8.I()
            r0.f101691a = r7
            r0.f101696g = r5
            java.lang.Object r8 = kotlinx.coroutines.flow.FlowKt.D(r8, r0)
            if (r8 != r1) goto L71
            goto La4
        L71:
            r2 = r7
        L72:
            cz.mobilesoft.coreblock.enums.EmailConsentState r8 = (cz.mobilesoft.coreblock.enums.EmailConsentState) r8
            cz.mobilesoft.coreblock.storage.datastore.CoreDataStore r5 = r7.c()
            kotlinx.coroutines.flow.Flow r5 = r5.N2()
            r0.f101691a = r2
            r0.f101692b = r8
            r0.f101696g = r4
            java.lang.Object r4 = kotlinx.coroutines.flow.FlowKt.D(r5, r0)
            if (r4 != r1) goto L89
            goto La4
        L89:
            r6 = r4
            r4 = r8
            r8 = r6
        L8c:
            cz.mobilesoft.coreblock.enums.PendingEmailConsentState r8 = (cz.mobilesoft.coreblock.enums.PendingEmailConsentState) r8
            cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore r5 = r7.d()
            kotlinx.coroutines.flow.Flow r5 = r5.y0()
            r0.f101691a = r2
            r0.f101692b = r4
            r0.f101693c = r8
            r0.f101696g = r3
            java.lang.Object r0 = kotlinx.coroutines.flow.FlowKt.D(r5, r0)
            if (r0 != r1) goto La5
        La4:
            return r1
        La5:
            r1 = r8
            r8 = r0
            r0 = r2
            r2 = r4
        La9:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            boolean r8 = r0.g(r2, r1, r8)
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.a(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.email_consent.ConsentHelper.f(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Flow h() {
        return FlowKt.n(e().I(), d().y0(), c().N2(), new ConsentHelper$showConsentFlow$1(this, null));
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
