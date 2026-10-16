package cz.mobilesoft.coreblock.scene.more.customBlockScreen;

import android.content.Context;
import androidx.compose.runtime.MutableState;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.LockScreenColor;
import cz.mobilesoft.coreblock.storage.room.entity.core.ConfigType;
import cz.mobilesoft.coreblock.storage.room.entity.core.CustomBlockingScreenConfigEntity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomConfigDetailScreenKt$CustomConfigDetailScreen$2", f = "CustomConfigDetailScreen.kt", l = {}, m = "invokeSuspend", v = 1)
final class CustomConfigDetailScreenKt$CustomConfigDetailScreen$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f107121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f107122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Context f107123c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ CustomBlockingViewState f107124d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Ref.ObjectRef f107125f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ MutableState f107126g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CustomConfigDetailScreenKt$CustomConfigDetailScreen$2(String str, Context context, CustomBlockingViewState customBlockingViewState, Ref.ObjectRef objectRef, MutableState mutableState, Continuation continuation) {
        super(2, continuation);
        this.f107122b = str;
        this.f107123c = context;
        this.f107124d = customBlockingViewState;
        this.f107125f = objectRef;
        this.f107126g = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new CustomConfigDetailScreenKt$CustomConfigDetailScreen$2(this.f107122b, this.f107123c, this.f107124d, this.f107125f, this.f107126g, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f107121a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (this.f107122b == null) {
            ConfigType configType = ConfigType.CUSTOM;
            String string = this.f107123c.getString(R.string.P8);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String string2 = this.f107123c.getString(R.string.O8);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            String string3 = this.f107123c.getString(R.string.N7);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            CustomConfigDetailScreenKt.I(this.f107126g, new CustomBlockingScreenConfigEntity(null, configType, null, false, this.f107124d.d(), false, 0, string, string2, string3, LockScreenColor.BrandBlue.getHex(), 109, null));
        }
        this.f107125f.f140144a = CustomConfigDetailScreenKt.H(this.f107126g);
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((CustomConfigDetailScreenKt$CustomConfigDetailScreen$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
