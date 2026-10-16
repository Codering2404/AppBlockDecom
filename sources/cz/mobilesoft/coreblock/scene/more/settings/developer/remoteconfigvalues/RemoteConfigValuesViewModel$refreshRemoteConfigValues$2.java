package cz.mobilesoft.coreblock.scene.more.settings.developer.remoteconfigvalues;

import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.CrashHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.coroutines.CoroutineScope;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.remoteconfigvalues.RemoteConfigValuesViewModel$refreshRemoteConfigValues$2", f = "RemoteConfigValuesViewModel.kt", l = {39}, m = "invokeSuspend", v = 1)
final class RemoteConfigValuesViewModel$refreshRemoteConfigValues$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f109300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ RemoteConfigValuesViewModel f109301b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RemoteConfigValuesViewModel$refreshRemoteConfigValues$2(RemoteConfigValuesViewModel remoteConfigValuesViewModel, Continuation continuation) {
        super(2, continuation);
        this.f109301b = remoteConfigValuesViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RemoteConfigValuesViewState y(List list, RemoteConfigValuesViewModel remoteConfigValuesViewModel, RemoteConfigValuesViewState remoteConfigValuesViewState) {
        return RemoteConfigValuesViewState.b(remoteConfigValuesViewState, false, null, null, ExtensionsKt.h(list), remoteConfigValuesViewModel.X0(list, RemoteConfigValuesViewModel.T0(remoteConfigValuesViewModel).f()), 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RemoteConfigValuesViewState z(Exception exc, RemoteConfigValuesViewModel remoteConfigValuesViewModel, RemoteConfigValuesViewState remoteConfigValuesViewState) {
        String message = exc.getMessage();
        if (message == null) {
            message = remoteConfigValuesViewModel.D0(R.string.Sa);
        }
        return RemoteConfigValuesViewState.b(remoteConfigValuesViewState, false, message, null, null, null, 28, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new RemoteConfigValuesViewModel$refreshRemoteConfigValues$2(this.f109301b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f109300a;
        try {
            if (i3 == 0) {
                ResultKt.b(obj);
                RemoteConfigValuesProvider remoteConfigValuesProvider = RemoteConfigValuesProvider.f109281a;
                this.f109300a = 1;
                obj = remoteConfigValuesProvider.b(this);
                if (obj == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            final List list = (List) obj;
            final RemoteConfigValuesViewModel remoteConfigValuesViewModel = this.f109301b;
            remoteConfigValuesViewModel.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.remoteconfigvalues.b0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return RemoteConfigValuesViewModel$refreshRemoteConfigValues$2.y(list, remoteConfigValuesViewModel, (RemoteConfigValuesViewState) obj2);
                }
            });
        } catch (Exception e3) {
            CrashHelper.j(e3);
            final RemoteConfigValuesViewModel remoteConfigValuesViewModel2 = this.f109301b;
            remoteConfigValuesViewModel2.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.remoteconfigvalues.c0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return RemoteConfigValuesViewModel$refreshRemoteConfigValues$2.z(e3, remoteConfigValuesViewModel2, (RemoteConfigValuesViewState) obj2);
                }
            });
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((RemoteConfigValuesViewModel$refreshRemoteConfigValues$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
