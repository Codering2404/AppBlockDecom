package cz.mobilesoft.coreblock.scene.timenudge.select;

import android.content.Context;
import android.content.Intent;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import cz.mobilesoft.coreblock.base.activity.BaseComposeActivity;
import cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Application;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class TimeNudgeSelectActivity extends BaseComposeActivity {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f122938g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f122939h = 8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f122940f = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.timenudge.select.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return TimeNudgeSelectActivity.p0(this.f122947a);
        }
    });

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent a(Context context, ArrayList selectedPackageNames) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(selectedPackageNames, "selectedPackageNames");
            Intent intent = new Intent(context, (Class<?>) TimeNudgeSelectActivity.class);
            intent.putExtra("APPLICATIONS", selectedPackageNames);
            return intent;
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n0(TimeNudgeSelectActivity timeNudgeSelectActivity) {
        timeNudgeSelectActivity.finish();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o0(TimeNudgeSelectActivity timeNudgeSelectActivity, PaddingValues paddingValues, int i3, Composer composer, int i4) {
        timeNudgeSelectActivity.c0(paddingValues, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BaseSelectionViewModel.ApplicationWebsiteSelectDTO p0(TimeNudgeSelectActivity timeNudgeSelectActivity) {
        Serializable serializableExtra = timeNudgeSelectActivity.getIntent().getSerializableExtra("APPLICATIONS");
        ArrayList arrayList = null;
        ArrayList arrayList2 = serializableExtra instanceof ArrayList ? (ArrayList) serializableExtra : null;
        if (arrayList2 != null) {
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            int size = arrayList2.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList2.get(i3);
                i3++;
                String str = (String) obj;
                arrayList3.add(new Application(str, str, str, false, null, 24, null));
            }
            arrayList = new ArrayList(arrayList3);
        }
        return new BaseSelectionViewModel.ApplicationWebsiteSelectDTO(null, arrayList, null, null, null, false, null, null, false, false, false, true, false, null, null, null, null, null, null, null, false, true, 2094964, null);
    }

    private final BaseSelectionViewModel.ApplicationWebsiteSelectDTO q0() {
        return (BaseSelectionViewModel.ApplicationWebsiteSelectDTO) this.f122940f.getValue();
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    public void c0(final PaddingValues paddingValues, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer composerK = composer.k(770935652);
        if ((i3 & 48) == 0) {
            i4 = (composerK.I(this) ? 32 : 16) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 17) != 16, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(770935652, i4, -1, "cz.mobilesoft.coreblock.scene.timenudge.select.TimeNudgeSelectActivity.RootCompose (TimeNudgeSelectActivity.kt:42)");
            }
            BaseSelectionViewModel.ApplicationWebsiteSelectDTO applicationWebsiteSelectDTOQ0 = q0();
            boolean zI = composerK.I(this);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.timenudge.select.b
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TimeNudgeSelectActivity.n0(this.f122948a);
                    }
                };
                composerK.w(objG);
            }
            TimeNudgeSelectScreenKt.d(applicationWebsiteSelectDTOQ0, (Function0) objG, composerK, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.timenudge.select.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimeNudgeSelectActivity.o0(this.f122949a, paddingValues, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
