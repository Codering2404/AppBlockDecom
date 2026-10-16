package androidx.window.layout.adapter.sidecar;

import android.graphics.Rect;
import androidx.window.core.Bounds;
import androidx.window.core.SpecificationComputer;
import androidx.window.core.VerificationMode;
import androidx.window.layout.DisplayFeature;
import androidx.window.layout.FoldingFeature;
import androidx.window.layout.HardwareFoldingFeature;
import androidx.window.layout.WindowLayoutInfo;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarDisplayFeature;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class SidecarAdapter {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f54400b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f54401c = SidecarAdapter.class.getSimpleName();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final VerificationMode f54402a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a(SidecarDeviceState sidecarDeviceState) {
            Intrinsics.checkNotNullParameter(sidecarDeviceState, "sidecarDeviceState");
            try {
                try {
                    return sidecarDeviceState.posture;
                } catch (NoSuchFieldError unused) {
                    Object objInvoke = SidecarDeviceState.class.getMethod("getPosture", null).invoke(sidecarDeviceState, null);
                    Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.Int");
                    return ((Integer) objInvoke).intValue();
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
                return 0;
            }
        }

        public final int b(SidecarDeviceState sidecarDeviceState) {
            Intrinsics.checkNotNullParameter(sidecarDeviceState, "sidecarDeviceState");
            int iA = a(sidecarDeviceState);
            if (iA < 0 || iA > 4) {
                return 0;
            }
            return iA;
        }

        public final List c(SidecarWindowLayoutInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
            try {
                try {
                    List list = info.displayFeatures;
                    return list == null ? CollectionsKt.emptyList() : list;
                } catch (NoSuchFieldError unused) {
                    Object objInvoke = SidecarWindowLayoutInfo.class.getMethod("getDisplayFeatures", null).invoke(info, null);
                    Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.collections.List<androidx.window.sidecar.SidecarDisplayFeature>");
                    return (List) objInvoke;
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
                return CollectionsKt.emptyList();
            }
            return CollectionsKt.emptyList();
        }

        public final void d(SidecarDeviceState sidecarDeviceState, int i3) {
            Intrinsics.checkNotNullParameter(sidecarDeviceState, "sidecarDeviceState");
            try {
                try {
                    sidecarDeviceState.posture = i3;
                } catch (NoSuchFieldError unused) {
                    SidecarDeviceState.class.getMethod("setPosture", Integer.TYPE).invoke(sidecarDeviceState, Integer.valueOf(i3));
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
            }
        }

        private Companion() {
        }
    }

    public SidecarAdapter(VerificationMode verificationMode) {
        Intrinsics.checkNotNullParameter(verificationMode, "verificationMode");
        this.f54402a = verificationMode;
    }

    private final boolean b(SidecarDisplayFeature sidecarDisplayFeature, SidecarDisplayFeature sidecarDisplayFeature2) {
        if (Intrinsics.areEqual(sidecarDisplayFeature, sidecarDisplayFeature2)) {
            return true;
        }
        if (sidecarDisplayFeature == null || sidecarDisplayFeature2 == null || sidecarDisplayFeature.getType() != sidecarDisplayFeature2.getType()) {
            return false;
        }
        return Intrinsics.areEqual(sidecarDisplayFeature.getRect(), sidecarDisplayFeature2.getRect());
    }

    private final boolean c(List list, List list2) {
        if (list == list2) {
            return true;
        }
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (!b((SidecarDisplayFeature) list.get(i3), (SidecarDisplayFeature) list2.get(i3))) {
                return false;
            }
        }
        return true;
    }

    public final boolean a(SidecarDeviceState sidecarDeviceState, SidecarDeviceState sidecarDeviceState2) {
        if (Intrinsics.areEqual(sidecarDeviceState, sidecarDeviceState2)) {
            return true;
        }
        if (sidecarDeviceState == null || sidecarDeviceState2 == null) {
            return false;
        }
        Companion companion = f54400b;
        return companion.b(sidecarDeviceState) == companion.b(sidecarDeviceState2);
    }

    public final boolean d(SidecarWindowLayoutInfo sidecarWindowLayoutInfo, SidecarWindowLayoutInfo sidecarWindowLayoutInfo2) {
        if (Intrinsics.areEqual(sidecarWindowLayoutInfo, sidecarWindowLayoutInfo2)) {
            return true;
        }
        if (sidecarWindowLayoutInfo == null || sidecarWindowLayoutInfo2 == null) {
            return false;
        }
        Companion companion = f54400b;
        return c(companion.c(sidecarWindowLayoutInfo), companion.c(sidecarWindowLayoutInfo2));
    }

    public final WindowLayoutInfo e(SidecarWindowLayoutInfo sidecarWindowLayoutInfo, SidecarDeviceState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (sidecarWindowLayoutInfo == null) {
            return new WindowLayoutInfo(CollectionsKt.emptyList());
        }
        SidecarDeviceState sidecarDeviceState = new SidecarDeviceState();
        Companion companion = f54400b;
        companion.d(sidecarDeviceState, companion.b(state));
        return new WindowLayoutInfo(f(companion.c(sidecarWindowLayoutInfo), sidecarDeviceState));
    }

    public final List f(List sidecarDisplayFeatures, SidecarDeviceState deviceState) {
        Intrinsics.checkNotNullParameter(sidecarDisplayFeatures, "sidecarDisplayFeatures");
        Intrinsics.checkNotNullParameter(deviceState, "deviceState");
        ArrayList arrayList = new ArrayList();
        Iterator it = sidecarDisplayFeatures.iterator();
        while (it.hasNext()) {
            DisplayFeature displayFeatureG = g((SidecarDisplayFeature) it.next(), deviceState);
            if (displayFeatureG != null) {
                arrayList.add(displayFeatureG);
            }
        }
        return arrayList;
    }

    public final DisplayFeature g(SidecarDisplayFeature feature, SidecarDeviceState deviceState) {
        HardwareFoldingFeature.Type typeA;
        FoldingFeature.State state;
        Intrinsics.checkNotNullParameter(feature, "feature");
        Intrinsics.checkNotNullParameter(deviceState, "deviceState");
        SpecificationComputer.Companion companion = SpecificationComputer.f54141a;
        String TAG = f54401c;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        SidecarDisplayFeature sidecarDisplayFeature = (SidecarDisplayFeature) SpecificationComputer.Companion.b(companion, feature, TAG, this.f54402a, null, 4, null).c("Type must be either TYPE_FOLD or TYPE_HINGE", new Function1<SidecarDisplayFeature, Boolean>() { // from class: androidx.window.layout.adapter.sidecar.SidecarAdapter$translate$checkedFeature$1
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(SidecarDisplayFeature require) {
                Intrinsics.checkNotNullParameter(require, "$this$require");
                boolean z2 = true;
                if (require.getType() != 1 && require.getType() != 2) {
                    z2 = false;
                }
                return Boolean.valueOf(z2);
            }
        }).c("Feature bounds must not be 0", new Function1<SidecarDisplayFeature, Boolean>() { // from class: androidx.window.layout.adapter.sidecar.SidecarAdapter$translate$checkedFeature$2
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(SidecarDisplayFeature require) {
                Intrinsics.checkNotNullParameter(require, "$this$require");
                return Boolean.valueOf((require.getRect().width() == 0 && require.getRect().height() == 0) ? false : true);
            }
        }).c("TYPE_FOLD must have 0 area", new Function1<SidecarDisplayFeature, Boolean>() { // from class: androidx.window.layout.adapter.sidecar.SidecarAdapter$translate$checkedFeature$3
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(SidecarDisplayFeature require) {
                Intrinsics.checkNotNullParameter(require, "$this$require");
                boolean z2 = true;
                if (require.getType() == 1 && require.getRect().width() != 0 && require.getRect().height() != 0) {
                    z2 = false;
                }
                return Boolean.valueOf(z2);
            }
        }).c("Feature be pinned to either left or top", new Function1<SidecarDisplayFeature, Boolean>() { // from class: androidx.window.layout.adapter.sidecar.SidecarAdapter$translate$checkedFeature$4
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(SidecarDisplayFeature require) {
                Intrinsics.checkNotNullParameter(require, "$this$require");
                return Boolean.valueOf(require.getRect().left == 0 || require.getRect().top == 0);
            }
        }).a();
        if (sidecarDisplayFeature == null) {
            return null;
        }
        int type = sidecarDisplayFeature.getType();
        if (type == 1) {
            typeA = HardwareFoldingFeature.Type.f54333b.a();
        } else {
            if (type != 2) {
                return null;
            }
            typeA = HardwareFoldingFeature.Type.f54333b.b();
        }
        int iB = f54400b.b(deviceState);
        if (iB == 0 || iB == 1) {
            return null;
        }
        if (iB == 2) {
            state = FoldingFeature.State.f54327d;
        } else {
            if (iB != 3 && iB == 4) {
                return null;
            }
            state = FoldingFeature.State.f54326c;
        }
        Rect rect = feature.getRect();
        Intrinsics.checkNotNullExpressionValue(rect, "feature.rect");
        return new HardwareFoldingFeature(new Bounds(rect), typeA, state);
    }

    public /* synthetic */ SidecarAdapter(VerificationMode verificationMode, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? VerificationMode.QUIET : verificationMode);
    }
}
