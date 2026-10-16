package cz.mobilesoft.coreblock.service;

import android.content.Context;
import android.util.Log;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.repository.TokenFCMRepository;
import cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository;
import cz.mobilesoft.coreblock.util.notifications.NotificationHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class LockieFirebaseMessagingService extends FirebaseMessagingService implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f123119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f123120b;

    /* JADX WARN: Multi-variable type inference failed */
    public LockieFirebaseMessagingService() {
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f123119a = LazyKt.a(lazyThreadSafetyModeB, new Function0<TokenFCMRepository>() { // from class: cz.mobilesoft.coreblock.service.LockieFirebaseMessagingService$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(TokenFCMRepository.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f123120b = LazyKt.a(lazyThreadSafetyModeB2, new Function0<ApprovalRepository>() { // from class: cz.mobilesoft.coreblock.service.LockieFirebaseMessagingService$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ApprovalRepository.class), objArr2, objArr3);
            }
        });
    }

    private final ApprovalRepository l() {
        return (ApprovalRepository) this.f123120b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TokenFCMRepository m() {
        return (TokenFCMRepository) this.f123119a.getValue();
    }

    private final void n(String str) {
        if (str != null) {
            CoroutineScope applicationScope = LockieApplication.f95365k;
            Intrinsics.checkNotNullExpressionValue(applicationScope, "applicationScope");
            BuildersKt__Builders_commonKt.d(applicationScope, null, null, new LockieFirebaseMessagingService$updateToken$1$1(this, str, null), 3, null);
        }
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Intrinsics.checkNotNullParameter(remoteMessage, "remoteMessage");
        if (remoteMessage.N() != null) {
            NotificationHelper notificationHelper = NotificationHelper.f128940a;
            Context applicationContext = getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            notificationHelper.B(applicationContext, remoteMessage);
            return;
        }
        NotificationHelper notificationHelper2 = NotificationHelper.f128940a;
        Context applicationContext2 = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext(...)");
        if (Intrinsics.areEqual(notificationHelper2.C(applicationContext2, remoteMessage), "strictModeUnlock")) {
            l().C();
        }
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        super.onNewToken(token);
        Log.d("NEW_TOKEN", "Refreshed token: " + token);
        n(token);
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
