package cz.mobilesoft.coreblock.scene.more.settings.developer.remoteconfigvalues;

import android.app.Application;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.scene.more.settings.developer.remoteconfigvalues.RemoteConfigValuesViewEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.ImmutableList;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

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
public final class RemoteConfigValuesViewModel extends BaseStatefulViewModel<RemoteConfigValuesViewState, RemoteConfigValuesViewEvent, RemoteConfigValuesViewCommand> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RemoteConfigValuesViewModel(Application application) {
        super(application, new RemoteConfigValuesViewState(false, null, null, null, null, 31, null));
        Intrinsics.checkNotNullParameter(application, "application");
        Z0();
    }

    public static final /* synthetic */ RemoteConfigValuesViewState T0(RemoteConfigValuesViewModel remoteConfigValuesViewModel) {
        return (RemoteConfigValuesViewState) remoteConfigValuesViewModel.I0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImmutableList X0(List list, String str) {
        if (StringsKt.p0(str)) {
            return ExtensionsKt.h(list);
        }
        String string = StringsKt.t1(str).toString();
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String lowerCase = string.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            RemoteConfigValue remoteConfigValue = (RemoteConfigValue) obj;
            String strA = remoteConfigValue.a();
            Locale locale2 = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale2, "getDefault(...)");
            String lowerCase2 = strA.toLowerCase(locale2);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            if (!StringsKt.a0(lowerCase2, lowerCase, false, 2, null)) {
                String strB = remoteConfigValue.b();
                Locale locale3 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale3, "getDefault(...)");
                String lowerCase3 = strB.toLowerCase(locale3);
                Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                if (StringsKt.a0(lowerCase3, lowerCase, false, 2, null)) {
                }
            }
            arrayList.add(obj);
        }
        return ExtensionsKt.h(arrayList);
    }

    private final void Z0() {
        if (((RemoteConfigValuesViewState) I0()).g()) {
            return;
        }
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.remoteconfigvalues.z
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RemoteConfigValuesViewModel.a1((RemoteConfigValuesViewState) obj);
            }
        });
        BuildersKt__Builders_commonKt.d(C0(), null, null, new RemoteConfigValuesViewModel$refreshRemoteConfigValues$2(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RemoteConfigValuesViewState a1(RemoteConfigValuesViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return RemoteConfigValuesViewState.b(updateState, true, null, null, null, null, 28, null);
    }

    private final void b1(final String str) {
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.remoteconfigvalues.a0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RemoteConfigValuesViewModel.c1(str, this, (RemoteConfigValuesViewState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RemoteConfigValuesViewState c1(String str, RemoteConfigValuesViewModel remoteConfigValuesViewModel, RemoteConfigValuesViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return RemoteConfigValuesViewState.b(updateState, false, null, str, null, remoteConfigValuesViewModel.X0(updateState.e(), str), 11, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: Y0, reason: merged with bridge method [inline-methods] */
    public void O0(RemoteConfigValuesViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event, RemoteConfigValuesViewEvent.OnRefreshRequested.f109298a)) {
            Z0();
        } else {
            if (!(event instanceof RemoteConfigValuesViewEvent.OnSearchQueryChanged)) {
                throw new NoWhenBranchMatchedException();
            }
            b1(((RemoteConfigValuesViewEvent.OnSearchQueryChanged) event).a());
        }
    }
}
