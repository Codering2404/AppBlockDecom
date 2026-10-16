package cz.mobilesoft.coreblock.scene.more.settings.generalSettings;

import androidx.compose.material.ScaffoldState;
import androidx.compose.material.SnackbarHostState;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewCommand;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsScreenKt$CommandProcessor$1$1", f = "GeneralSettingsScreen.kt", l = {}, m = "invokeSuspend", v = 1)
final class GeneralSettingsScreenKt$CommandProcessor$1$1 extends SuspendLambda implements Function2<GeneralSettingsViewCommand, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f109689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f109690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ CoroutineScope f109691c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ ScaffoldState f109692d;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsScreenKt$CommandProcessor$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsScreenKt$CommandProcessor$1$1$1", f = "GeneralSettingsScreen.kt", l = {RCHTTPStatusCodes.NOT_MODIFIED}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f109693a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ScaffoldState f109694b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ GeneralSettingsViewCommand f109695c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ScaffoldState scaffoldState, GeneralSettingsViewCommand generalSettingsViewCommand, Continuation continuation) {
            super(2, continuation);
            this.f109694b = scaffoldState;
            this.f109695c = generalSettingsViewCommand;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f109694b, this.f109695c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f109693a;
            if (i3 == 0) {
                ResultKt.b(obj);
                SnackbarHostState snackbarHostStateB = this.f109694b.b();
                String strA = ((GeneralSettingsViewCommand.ShowSnackBar) this.f109695c).a();
                this.f109693a = 1;
                if (SnackbarHostState.e(snackbarHostStateB, strA, null, null, this, 6, null) == objF) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GeneralSettingsScreenKt$CommandProcessor$1$1(CoroutineScope coroutineScope, ScaffoldState scaffoldState, Continuation continuation) {
        super(2, continuation);
        this.f109691c = coroutineScope;
        this.f109692d = scaffoldState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        GeneralSettingsScreenKt$CommandProcessor$1$1 generalSettingsScreenKt$CommandProcessor$1$1 = new GeneralSettingsScreenKt$CommandProcessor$1$1(this.f109691c, this.f109692d, continuation);
        generalSettingsScreenKt$CommandProcessor$1$1.f109690b = obj;
        return generalSettingsScreenKt$CommandProcessor$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(GeneralSettingsViewCommand generalSettingsViewCommand, Continuation continuation) {
        return ((GeneralSettingsScreenKt$CommandProcessor$1$1) create(generalSettingsViewCommand, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        GeneralSettingsViewCommand generalSettingsViewCommand = (GeneralSettingsViewCommand) this.f109690b;
        IntrinsicsKt.f();
        if (this.f109689a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (!(generalSettingsViewCommand instanceof GeneralSettingsViewCommand.ShowSnackBar)) {
            throw new NoWhenBranchMatchedException();
        }
        BuildersKt__Builders_commonKt.d(this.f109691c, null, null, new AnonymousClass1(this.f109692d, generalSettingsViewCommand, null), 3, null);
        return Unit.f139807a;
    }
}
