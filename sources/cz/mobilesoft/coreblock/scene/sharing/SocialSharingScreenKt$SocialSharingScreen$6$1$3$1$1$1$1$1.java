package cz.mobilesoft.coreblock.scene.sharing;

import android.content.Context;
import android.view.View;
import cz.mobilesoft.coreblock.scene.sharing.dto.SocialsSharePayload;
import cz.mobilesoft.coreblock.scene.sharing.images.SocialShareTemplate;
import cz.mobilesoft.coreblock.scene.sharing.intents.ShareableAppInfo;
import cz.mobilesoft.coreblock.scene.sharing.render.SocialShareManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.sharing.SocialSharingScreenKt$SocialSharingScreen$6$1$3$1$1$1$1$1", f = "SocialSharingScreen.kt", l = {292}, m = "invokeSuspend", v = 1)
final class SocialSharingScreenKt$SocialSharingScreen$6$1$3$1$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f119334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f119335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ View f119336c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ SocialShareTemplate f119337d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ SocialsSharingViewState f119338f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ ShareableAppInfo f119339g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SocialSharingScreenKt$SocialSharingScreen$6$1$3$1$1$1$1$1(Context context, View view, SocialShareTemplate socialShareTemplate, SocialsSharingViewState socialsSharingViewState, ShareableAppInfo shareableAppInfo, Continuation continuation) {
        super(2, continuation);
        this.f119335b = context;
        this.f119336c = view;
        this.f119337d = socialShareTemplate;
        this.f119338f = socialsSharingViewState;
        this.f119339g = shareableAppInfo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new SocialSharingScreenKt$SocialSharingScreen$6$1$3$1$1$1$1$1(this.f119335b, this.f119336c, this.f119337d, this.f119338f, this.f119339g, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f119334a;
        if (i3 == 0) {
            ResultKt.b(obj);
            SocialShareManager socialShareManager = SocialShareManager.f119513a;
            Context context = this.f119335b;
            View view = this.f119336c;
            SocialShareTemplate socialShareTemplate = this.f119337d;
            SocialsSharePayload socialsSharePayloadF = this.f119338f.f();
            ShareableAppInfo shareableAppInfo = this.f119339g;
            String strH = this.f119338f.h();
            this.f119334a = 1;
            if (socialShareManager.e(context, view, socialShareTemplate, socialsSharePayloadF, shareableAppInfo, strH, this) == objF) {
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
        return ((SocialSharingScreenKt$SocialSharingScreen$6$1$3$1$1$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
