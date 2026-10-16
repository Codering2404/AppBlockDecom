package cz.mobilesoft.coreblock.scene.schedule.detail;

import androidx.compose.material.ModalBottomSheetState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.State;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleViewEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
public final class AdultContentBottomSheetKt {
    /* JADX WARN: Removed duplicated region for block: B:132:0x06d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void d(final kotlinx.coroutines.CoroutineScope r44, final cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState r45, final kotlin.jvm.functions.Function1 r46, final androidx.compose.material.ModalBottomSheetState r47, androidx.compose.runtime.Composer r48, final int r49) {
        /*
            Method dump skipped, instruction units count: 1776
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.detail.AdultContentBottomSheetKt.d(kotlinx.coroutines.CoroutineScope, cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState, kotlin.jvm.functions.Function1, androidx.compose.material.ModalBottomSheetState, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(Function1 function1) {
        function1.invoke(ScheduleViewEvent.OnAdultContentTurnOnClicked.f114541a);
        return Unit.f139807a;
    }

    private static final float f(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(Function1 function1) {
        function1.invoke(ScheduleViewEvent.OnAdultContentTurnOnClicked.f114541a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(CoroutineScope coroutineScope, ScheduleViewState scheduleViewState, Function1 function1, ModalBottomSheetState modalBottomSheetState, int i3, Composer composer, int i4) {
        d(coroutineScope, scheduleViewState, function1, modalBottomSheetState, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
