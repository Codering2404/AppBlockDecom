package cz.mobilesoft.coreblock.scene.whats_new;

import android.app.Application;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.util.constants.WhatsNewData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
public final class WhatsNewFullScreenViewModel extends BaseStatefulViewModel<WhatsNewFullScreenViewState, WhatsNewFullScreenViewEvent, WhatsNewFullScreenViewCommand> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final String f123062o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WhatsNewFullScreenViewModel(Application application, String str) {
        super(application, new WhatsNewFullScreenViewState(null, 1, null));
        Intrinsics.checkNotNullParameter(application, "application");
        this.f123062o = str;
        S0();
    }

    private final void S0() {
        String strL = LockieApplication.l();
        Intrinsics.checkNotNullExpressionValue(strL, "getVersionName(...)");
        final List list = (List) WhatsNewData.f128462a.a().get(StringsKt.t1(strL).toString());
        if (list == null) {
            return;
        }
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.whats_new.o
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WhatsNewFullScreenViewModel.T0(list, (WhatsNewFullScreenViewState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WhatsNewFullScreenViewState T0(List list, WhatsNewFullScreenViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return updateState.a(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: U0, reason: merged with bridge method [inline-methods] */
    public void O0(WhatsNewFullScreenViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }
}
