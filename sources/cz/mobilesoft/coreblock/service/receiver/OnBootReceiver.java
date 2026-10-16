package cz.mobilesoft.coreblock.service.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.util.runnability.InitHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;

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
public class OnBootReceiver extends BroadcastReceiver implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f123711a = 8;

    static /* synthetic */ Object c(OnBootReceiver onBootReceiver, Context context, Continuation continuation) {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(OnBootReceiver onBootReceiver, Context context, BroadcastReceiver.PendingResult pendingResult) {
        CoroutinesHelperExtKt.d(new OnBootReceiver$onReceive$1$1(onBootReceiver, context, pendingResult, null));
    }

    public Object b(Context context, Continuation continuation) {
        return c(this, context, continuation);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        final BroadcastReceiver.PendingResult pendingResultGoAsync = goAsync();
        InitHelper.h(new InitHelper.OnInitializedListener() { // from class: cz.mobilesoft.coreblock.service.receiver.d
            @Override // cz.mobilesoft.coreblock.util.runnability.InitHelper.OnInitializedListener
            public final void onInitialized() {
                OnBootReceiver.d(this.f123786a, context, pendingResultGoAsync);
            }
        });
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
